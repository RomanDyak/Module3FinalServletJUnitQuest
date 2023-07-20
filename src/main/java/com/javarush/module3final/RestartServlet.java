package com.javarush.module3final;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RestartServlet", value = "/restart")
public class RestartServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        session.removeAttribute("step");
        session.removeAttribute("repo");
        session.removeAttribute("event");
        session.removeAttribute("possibleSteps");
        session.removeAttribute("possibleSteps");
        session.removeAttribute("diverStats");

        response.sendRedirect(request.getContextPath() + "/select");
    }
}
