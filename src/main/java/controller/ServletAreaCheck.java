package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Constants;
import util.Validator;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletAreaCheck extends HttpServlet {

    private static boolean isHit;
    private static long workTime;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long startTime = System.nanoTime();
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");
        String fromG = request.getParameter("fromG");
        if (Validator.validate(r, x, y, fromG)) {
            isHit = checkHit(Double.parseDouble(x), Double.parseDouble(y), Double.parseDouble(r));
            workTime = (System.nanoTime() - startTime) / 1000;
            getServletContext().getRequestDispatcher(Constants.SERVLET_DATA).forward(request, response);
        } else {
            PrintWriter pw = response.getWriter();
            pw.write("Data is invalid");
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

    public static boolean isHit() {
        return isHit;
    }

    public static long getWorkTime() {
        return workTime;
    }
}
