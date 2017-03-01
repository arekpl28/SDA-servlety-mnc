package com.arek.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieController implements Controller {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("hello", "world");
        response.addCookie(cookie);
        cookie.setMaxAge(1000);

        response.getWriter().write("<h1>Hello from Cookie Controller");
    }
}
