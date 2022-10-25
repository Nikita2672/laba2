package controller;

import model.TableBean;
import util.Constants;
import util.TableHandler;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ServletData extends HttpServlet {

    private static final TableBean tableBean = new TableBean();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        String loadData = request.getParameter(Constants.IS_LOAD_DATA) == null ? "false" : request.getParameter("loadData");
        if (!loadData.equals("true")) {
            tableBean.addAttempt(Double.parseDouble(request.getParameter(Constants.X)),
                    Double.parseDouble(request.getParameter(Constants.Y)),
                    Double.parseDouble(request.getParameter(Constants.R)),
                    new Date().toString(),
                    "" + ServletAreaCheck.getWorkTime(),
                    ServletAreaCheck.isHit());
        }
        printWriter.write(TableHandler.makeDataForTable(tableBean));
    }
}
