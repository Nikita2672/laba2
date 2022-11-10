package controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Constants;
import util.Validator;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ServletAreaCheck extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long startTime = System.nanoTime();
        String x = request.getParameter(Constants.X);
        String y = request.getParameter(Constants.Y);
        String r = request.getParameter(Constants.R);
        String fromG = request.getParameter(Constants.IS_FROM_GRAPH);
        int accuracy;
        try {
            accuracy = Integer.parseInt(request.getParameter("accuracy"));
        } catch (NumberFormatException | NullPointerException e) {
            accuracy = 18;
        }
        if (Validator.validate(r, x, y, fromG)) {
            ServletContext servletContext = request.getServletContext();
            boolean isHit = checkHit(Double.parseDouble(x), new BigDecimal(y).setScale(accuracy, RoundingMode.HALF_UP), new BigDecimal(r).setScale(accuracy, RoundingMode.HALF_UP));
            long workTime = (System.nanoTime() - startTime) / 1000;
            servletContext.setAttribute("workTime", workTime);
            servletContext.setAttribute("result", isHit);
            getServletContext().getRequestDispatcher(Constants.SERVLET_DATA).forward(request, response);
        } else {
            response.sendError(400, Constants.INVALID_DATA);
        }
    }

    public boolean checkHit(double x, BigDecimal y, BigDecimal r) {
        if (x >= 0 && (y.compareTo(new BigDecimal(0)) > 0)) {
            return (BigDecimal.valueOf(x * x).add(y.multiply(y))).compareTo((r.multiply(r))) <= 0;
        } else if (x < 0 && y.compareTo(new BigDecimal(0)) > 0) {
            return false;
        } else if (x <= 0 && y.compareTo(new BigDecimal(0)) <= 0) {
            return y.compareTo(BigDecimal.valueOf(-2 * x).add(r.multiply(new BigDecimal(-1)))) >= 0;
        } else {
            return BigDecimal.valueOf(x).compareTo(r.multiply(BigDecimal.valueOf(0.5))) < 0 && y.compareTo(r.multiply(new BigDecimal(-1))) > 0;
        }
    }
}
