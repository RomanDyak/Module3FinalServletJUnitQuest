package com.javarush.module3final;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuestSelectServlet", value = "/select")
public class QuestSelectServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(QuestSelectServlet.class);
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession currentSession = request.getSession();

        String name = request.getParameter("name");

        if(name == null) {
            name = (String) currentSession.getAttribute("name");
        }

        logger.debug("Выбрано имя: {}", name);

        currentSession.setAttribute("name", name);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<link href=\"static/main.css\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"textBlock\"> <p class=\"text\"> Привет " + name + " выбери испытание </p>");
        out.println("");
        out.println("<div class=\"container\"><div class=\"btn\"><a href=\"baseLogic\" >Базовый JR</a></div>\n" +
                "<div class=\"btn\"><a href=\"diverLogic\" >Водолаз</a></div></div>");
        out.println("</div></body></html>");
    }

    public void destroy() {
    }
}
