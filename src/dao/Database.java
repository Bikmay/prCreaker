package dao;

import models.Hero;

import java.io.File;
import java.sql.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Database {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    public static int a=0;

    public static int getA(){
        return a;
    }

    private static Connection connect() throws IOException, SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Rick\\IdeaProjects\\prCreaker\\src\\dao\\heros.sqlite");

            return connection;



        }catch (Exception e){
            System.out.println("fail");
            e.printStackTrace();
            connection.close();

        }


        return null;

    }

    public static void write(String request) throws SQLException, IOException, ClassNotFoundException {

        Connection connection =  connect();
        Statement statement = connection.createStatement();


        statement.execute(request);
        connection.close();
        statement.close();
    }

    public static ArrayList<Hero> read(String request) throws SQLException, IOException, ClassNotFoundException {

        Connection connection = connect();
        Statement statement = connection.createStatement();
        ArrayList<Hero> list = null;
        ResultSet resultSet =null;


        resultSet=statement.executeQuery(request);

        if(resultSet==null)
            System.out.println("result null");
        Hero hero= null;
        while (resultSet.next())
        {
            hero=new Hero();

            hero.id =resultSet.getInt("id");
            hero.name=resultSet.getString("name");
            hero.universe=resultSet.getString("universe");
            hero.power=resultSet.getInt("power");
            hero.description=resultSet.getString("description");
            hero.logo=resultSet.getString("icon");
            hero.phone=resultSet.getInt("phone");
            list.add(hero);
        }

        if(list==null)
            System.out.println("list is null!!");

        System.out.println("2121");

        resultSet.close();
        statement.close();
        connection.close();
        return list;

    }



}
