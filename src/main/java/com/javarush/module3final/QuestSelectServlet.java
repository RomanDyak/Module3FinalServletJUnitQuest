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
        out.println("<html><body>");
        out.println("Привет " + name + " выбери испытание");
        out.println("");
        out.println("<button> <a href=\"diverLogic\">Водолаз</a></button>");
        out.println("<button> <a href=\"baseLogic\">Базовый JR</a></button>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
