package controller;

import jakarta.servlet.ServletContext;
import model.TableBean;
import util.Constants;
import util.TableHandler;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class ServletData extends HttpServlet {

    private static final TableBean tableBean = new TableBean();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter printWriter = response.getWriter()) {
            int accuracy;
            try {
                accuracy = Integer.parseInt(request.getParameter("accuracy"));
                if (accuracy < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException | NullPointerException e) {
                accuracy = Constants.DEFAULT_ACCURACY;
            }
            ServletContext servletContext = request.getServletContext();
            String loadData = request.getParameter(Constants.IS_LOAD_DATA) == null ? "false" : request.getParameter("loadData");
            if (!loadData.equals("true")) {
                tableBean.addAttempt(Double.parseDouble(request.getParameter(Constants.X)),
                        new BigDecimal(request.getParameter(Constants.Y)).setScale(accuracy, RoundingMode.HALF_UP).stripTrailingZeros(),
                        new BigDecimal(request.getParameter(Constants.R)).setScale(accuracy, RoundingMode.HALF_UP).stripTrailingZeros(),
                        new Date().toString(),
                        "" + servletContext.getAttribute("workTime"),
                        "" + servletContext.getAttribute("result"));
            }
            printWriter.write(TableHandler.makeDataForTable(tableBean));
        }
    }
}
