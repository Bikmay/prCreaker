package servlets;

import dao.Database;
import models.Hero;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeroServlet extends HttpServlet {

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            ArrayList<Hero> listHeros=Database.read("SELECT*FROM heros");



            req.setAttribute("listHeros",listHeros);



            req.getRequestDispatcher("/webapp/index.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    /*
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        User user = new User(name, age);
        service.saveUser(user);
        resp.sendRedirect("/users");*/

    }

    @Override
    protected void	doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        int id = Integer.parseInt(req.getParameter("id"));
        User user = service.findUser(id);
        user.setName(req.getParameter("name"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        service.updateUser(user);
        resp.sendRedirect("/users");
        */
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteUser(service.findUser(id));
        resp.sendRedirect("/users");
        */
    }

}
