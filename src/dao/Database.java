package dao;

import models.Hero;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.IOException;
import java.util.List;


public class Database {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    private  static Connection connect() throws IOException, SQLException {
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

    public static List<Hero> read(String request) throws SQLException, IOException, ClassNotFoundException {

        Connection connection = connect();
        Statement statement = connection.createStatement();
        List<Hero> list = null;
        ResultSet resultSet =null;


        resultSet=statement.executeQuery(request);

        Hero hero= new Hero();

        while (resultSet.next())
        {
            hero.id =resultSet.getInt("id");
            hero.name=resultSet.getString("name");
            hero.universe=resultSet.getString("universe");
            hero.power=resultSet.getInt("power");
            hero.description=resultSet.getString("desqription");
            hero.logo=resultSet.getString("icon");
            hero.phone=resultSet.getInt("phone");
            list.add(hero);
        }

        connection.close();
        statement.close();
        resultSet.close();
        return list;

    }



}
