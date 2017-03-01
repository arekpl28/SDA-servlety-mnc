package com.arek.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserController implements Controller {
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("hello", "world");
        cookie.setMaxAge(1000);
        response.addCookie(cookie);
        PrintWriter writer = response.getWriter();
        writer.write("<h1> Hello from User Controller</h1>");


    }
}
