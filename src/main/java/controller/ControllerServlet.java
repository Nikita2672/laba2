package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");
        if (x != null && y != null && r != null) {
            getServletContext().getRequestDispatcher("/AreaCheckServlet").forward(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_FOUND);//302
            response.setHeader("Location", "http://localhost:8080/webapp-1.0-SNAPSHOT/");
        }
    }
}
