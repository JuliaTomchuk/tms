package org.example;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("idDel");
        if (!(StringUtils.isBlank(id) )&& containsKey(Integer.valueOf(id))) {
            Garage.getInstance().deleteCar(Integer.valueOf(id));
        }

        resp.sendRedirect("garage");
    }

    private boolean containsKey(int id) {
        return Garage.getInstance().getCars().containsKey(id);
    }
}
