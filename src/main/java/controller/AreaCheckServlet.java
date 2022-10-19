package controller;

import model.TableBean;
import util.TableHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class AreaCheckServlet extends HttpServlet {
    private final TableBean tableBean = new TableBean();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long startTime = System.nanoTime();
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");
        try {
            double paramY = Double.parseDouble(y);
            double paramR = Double.parseDouble(r);
            if (request.getParameter("fromG").equals("true")) {
                double paramX = Double.parseDouble(x);
                boolean result = checkHit(paramX, paramY, paramR);
                long endTime = System.nanoTime();
                String workTime = Long.toString((endTime - startTime) / 1000);
                sendData(response, paramX, paramY, paramR, new Date().toString(), workTime, result);
            } else {
                int paramX = Integer.parseInt(x);
                if (paramX < -3 || paramX > 5 || paramY < -5 || paramY > 5 || paramR < 2 || paramR > 5) {
                    throw new IllegalArgumentException();
                } else {
                    boolean result = checkHit(paramX, paramY, paramR);
                    long endTime = System.nanoTime();
                    String workTime = Long.toString((endTime - startTime) / 1000);
                    sendData(response, paramX, paramY, paramR, new Date().toString(), workTime, result);
                }
            }
        } catch (IllegalArgumentException e) {
            response.getWriter().write("Data is incorrect");
        }
    }

    private void sendData(HttpServletResponse response, double x, double y, double r, String time, String workTime, boolean isHit) throws IOException {
        PrintWriter pw = response.getWriter();
        tableBean.addAttempt(x, y, r, time, workTime, isHit);
        pw.write(TableHandler.makeDataForTable(tableBean));
    }

    public boolean checkHit(double x, double y, double r) {
        if (x >= 0 && y >= 0) {
            return (x * x + y * y) < (r * r);
        } else if (x < 0 && y > 0) {
            return false;
        } else if (x <= 0 && y <= 0) {
            return y >= (-2 * x - r);
        } else {
            return x < r / 2 && y > -r;
        }
    }
}
