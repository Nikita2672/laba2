package controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Constants;
import util.Validator;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletAreaCheck extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long startTime = System.nanoTime();
        String x = request.getParameter(Constants.X);
        String y = request.getParameter(Constants.Y);
        String r = request.getParameter(Constants.R);
        String fromG = request.getParameter(Constants.IS_FROM_GRAPH);
        if (Validator.validate(r, x, y, fromG)) {
            ServletContext servletContext = request.getServletContext();
            boolean isHit = checkHit(Double.parseDouble(x), Double.parseDouble(y), Double.parseDouble(r));
            long workTime = (System.nanoTime() - startTime) / 1000;
            servletContext.setAttribute("workTime", workTime);
            servletContext.setAttribute("result", isHit);
            getServletContext().getRequestDispatcher(Constants.SERVLET_DATA).forward(request, response);
        } else {
            PrintWriter pw = response.getWriter();
            pw.write(Constants.INVALID_DATA);
        }
    }

    public boolean checkHit(double x, double y, double r) {
        if (x >= 0 && y >= 0) {
            return (x * x + y * y) <= (r * r);
        } else if (x < 0 && y > 0) {
            return false;
        } else if (x <= 0 && y <= 0) {
            return y >= (-2 * x - r);
        } else {
            return x < r / 2 && y > -r;
        }
    }
}
