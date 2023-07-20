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
        out.println("<html><body>");
        out.println("<div> <p>" +
                "Сегодня Вам предстоит пройти ряд испытаний, хватит ли смекалки, ловкости, умения? " +
                "</p></div>");
        out.println("<form action=\"select\" method=\"get\">\n" +
                "  <div class=\"form-example\">\n" +
                "    <label for=\"name\">Представьтесь пожалуйста: </label>\n" +
                "    <input type=\"text\" name=\"name\" id=\"name\" required>\n" +
                "  </div>\n" +
                "  <div class=\"form-example\">\n" +
                "    <input type=\"submit\" value=\"Погнали!\">\n" +
                "  </div>\n" +
                "</form>");

        out.println("</body></html>");
    }

    public void destroy() {
    }
}