package servlets;

import dao.Database;
import models.Hero;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class CheckRegistration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("get");
        ArrayList<Hero> listHeros= null;
        try {
            listHeros = Database.read("SELECT*FROM heros");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        req.setAttribute("listHeros",listHeros);
        req.getRequestDispatcher("index.jsp").forward(req,resp);





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Hero hero=new Hero();
        System.out.println("servlet2");
        hero.name= req.getParameter("name");
        hero.universe = req.getParameter("uni");
        hero.power = Integer.parseInt(req.getParameter("power"));
        hero.description = req.getParameter("description");

        try {
            ArrayList<Hero> listHeros= Database.read("SELECT*FROM heros");

            req.setAttribute("listHeros",listHeros);
            for (int i = 0; i <listHeros.size() ; i++) {

                if(listHeros.get(i).name.equals(hero.name)){
                    System.out.println("check");
                    req.setAttribute("error", "Hero already exists");
                     resp.sendRedirect(req.getContextPath() + "/heros");

                }
            }

            Database.write("INSERT INTO heros (name,universe,power,description,icon) VALUES (?,?,?,?,?);",hero);

            System.out.println("enter");
            resp.sendRedirect("heros");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erorr");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("erorr");
        }


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
