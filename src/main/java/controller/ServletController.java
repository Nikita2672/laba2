package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Constants;

import java.io.IOException;

public class ServletController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String x = request.getParameter(Constants.X);
        String y = request.getParameter(Constants.Y);
        String r = request.getParameter(Constants.R);
        String loadData = request.getParameter(Constants.IS_LOAD_DATA);
        if ((x != null && y != null && r != null)) {
            getServletContext().getRequestDispatcher(Constants.SERVLET_AREA).forward(request, response);
        } else if (loadData.equals("true")) {
            getServletContext().getRequestDispatcher(Constants.SERVLET_DATA).forward(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_FOUND);//302
            response.setHeader("Location", "http://localhost:8080/webapp-1.0-SNAPSHOT/");
        }
    }
}
