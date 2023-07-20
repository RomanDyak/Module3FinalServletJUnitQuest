package com.javarush.module3final;

import com.javarush.module3final.entity.base.BaseAnswer;
import com.javarush.module3final.entity.base.BaseEvent;
import com.javarush.module3final.repository.BaseRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BaseLogicServlet", value = "/baseLogic")
public class BaseLogicServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(BaseLogicServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();

        String step = req.getParameter("move");

        logger.debug("move parameter is {}", step);


        if (step == null) {
            step = "1";
            session.setAttribute("step", step);
            session.setAttribute("repo", new BaseRepo());
            logger.debug("step is null, set step 1 and new BaseRepo");
            logger.info("step is null, set step 1 and new BaseRepo");

        }

        BaseRepo repo = (BaseRepo) session.getAttribute("repo");
        List<Long> steps = (List<Long>) session.getAttribute("possibleSteps");

        BaseEvent event;
//      steps.contains(step) is not working?
        if (steps != null && containsStep(steps, step)) {
            event = repo.getEvent(Long.parseLong(step));
            session.setAttribute("event", event);
            session.setAttribute("step", step);
            logger.info("step getting from request parameter");
        } else {
            event = repo.getEvent((Long.parseLong(session.getAttribute("step").toString())));
            logger.info("step getting from session");
            session.setAttribute("event", event);
        }
        session.setAttribute("possibleSteps", getPossibleSteps(event));
        getServletContext().getRequestDispatcher("/base.jsp").forward(req, resp);
    }

    private boolean containsStep(List<Long> steps, String step) {
        try{
            for (Long l : steps) {
                if(l.equals(Long.valueOf(step))) return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    List<Long> getPossibleSteps(BaseEvent event) {
        List posSteps = new ArrayList<>();
        for (BaseAnswer ans : event.getActions()) {
            posSteps.add(ans.getMove());
        }
        return posSteps;
    }
}
