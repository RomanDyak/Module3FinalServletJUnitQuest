package com.javarush.module3final;

import com.javarush.module3final.entity.DiverAnswer;
import com.javarush.module3final.entity.DiverEvent;
import com.javarush.module3final.repository.DiverRepo;
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

@WebServlet(name = "DiverLogicServlet", value = "/diverLogic")
public class DiverLogicServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(DiverLogicServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();

        String step = req.getParameter("move");

        if (step == null) {
            step = "1";
            session.setAttribute("step", step);
            session.setAttribute("repo", new DiverRepo());
            session.setAttribute("diverStats", new DiverStats());
        }

        Long currentStep = Long.parseLong(step);

        DiverRepo repo = (DiverRepo) session.getAttribute("repo");
        List<Long> steps = (List<Long>) session.getAttribute("possibleSteps");
        DiverStats diverStats = (DiverStats) session.getAttribute("diverStats");

        if (currentStep >= 54L) {
            if( diverStats.getBodyStat() <= 1 || diverStats.getHeartStat() <= 1 || diverStats.getFeelingStat() <=2) {
               DiverEvent event = repo.getEvent(62L);
                session.setAttribute("event", event);
                logger.info("Finish section bodyStat {}; heartStat {}; feelingStat {}",
                        diverStats.getBodyStat(),
                        diverStats.getHeartStat(),
                        diverStats.getFeelingStat());
            }
        }

        DiverEvent event;
        if (steps != null && containsStep(steps, currentStep)) {
            event = repo.getEvent(currentStep);
            session.setAttribute("event", event);

            //change stats
            Long prevStep = Long.parseLong(session.getAttribute("step").toString());
            List<Integer> newStatsList = repo.getResultsByPrevAndNextId(prevStep, currentStep);
            diverStats.changeStats(newStatsList);
            session.setAttribute("diverStats", diverStats);
            logger.info(diverStats.toString());
            session.setAttribute("step", currentStep);

            session.setAttribute("statsList" ,diverStats.getStats());
        } else {
            event = repo.getEvent((Long.parseLong(session.getAttribute("step").toString())));
            session.setAttribute("event", event);
        }
        session.setAttribute("possibleSteps", getPossibleSteps(event));
        getServletContext().getRequestDispatcher("/diver.jsp").forward(req, resp);
    }


    private boolean containsStep(List<Long> steps, Long currentStep) {
        try{
            for (Long l : steps) {
                if(l.equals(currentStep)) return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    List<Long> getPossibleSteps(DiverEvent event) {
        List posSteps = new ArrayList<>();
        for (DiverAnswer ans : event.getActions()) {
            posSteps.add(ans.getMove());
        }
        return posSteps;
    }

}
