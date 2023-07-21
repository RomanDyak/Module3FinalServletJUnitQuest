package com.javarush.module3final;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession currentSession = request.getSession(true);


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<link href=\"static/main.css\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"textBlock\"> <p class=\"text\">" +
                "Сегодня Вам предстоит пройти ряд испытаний, хватит ли смекалки, ловкости, умения? " +
                "</p></div>");
        out.println("<div class=\"answerBlock\">");
        out.println("<form action=\"select\" method=\"get\">\n" +
                "  <div class=\"form-example\">\n" +
                "    <label for=\"name\">Представьтесь пожалуйста: </label>\n" +
                "    <input type=\"text\" name=\"name\" id=\"name\" required>\n" +
                "  </div>\n" +
                "  <div class=\"form-example\">\n" +
                "    <input type=\"submit\" value=\"На СТАРТ!\">\n" +
                "  </div>\n" +
                "</form>");

        out.println("</div></body></html>");
    }

    public void destroy() {
    }
}