package com.arek.servlet;

import com.arek.controller.Controller;
import com.arek.controller.CookieController;
import com.arek.controller.LoginController;
import com.arek.controller.UserController;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class HelloServlet extends HttpServlet {
    private Map<String, Controller> controllerMap;


    @Override
    public void init() throws ServletException {
        this.controllerMap = new HashMap<String, Controller>();
        controllerMap.put("user", new UserController());
        controllerMap.put("login", new LoginController());
        controllerMap.put("cookie", new CookieController());
        controllerMap.put("default", (request, response) -> response.getWriter()
                .write("<h1>Hello from default controller</h1>"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String requestURI = req.getRequestURI();
        String relativePath = requestURI.substring(StringUtils.ordinalIndexOf(requestURI, "/", 2) + 1);
        Controller controller = controllerMap.get(relativePath);
        if (controller == null) {
            controller = controllerMap.get("default");
        }
        controller.handleGet(req, resp);

//        PrintWriter writer = resp.getWriter();
//        writer.write("<h1>404 error: File not found \n</h1><h3>The URL requested was not found</h3>");

    }
}
