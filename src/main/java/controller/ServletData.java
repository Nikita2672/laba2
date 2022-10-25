package controller;

import model.TableBean;
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
        String loadData = request.getParameter("loadData") == null ? "false" : request.getParameter("loadData");
        if (!loadData.equals("true")) {
            tableBean.addAttempt(Double.parseDouble(request.getParameter("x")),
                    Double.parseDouble(request.getParameter("y")),
                    Double.parseDouble(request.getParameter("r")),
                    new Date().toString(),
                    "" + ServletAreaCheck.getWorkTime(),
                    ServletAreaCheck.isHit());
        }
        printWriter.write(TableHandler.makeDataForTable(tableBean));
    }
}
