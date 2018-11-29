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

    private void connect() throws IOException, SQLException {


        try{

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Rick\\IdeaProjects\\prCreaker\\src\\dao\\heros.sqlite");




        }catch (Exception e){
            System.out.println("fail");
            e.printStackTrace();
            connection.close();

        }




    }

    public void write(String request) throws SQLException, IOException, ClassNotFoundException {

        connect();
        statement.execute(request);
        close();
    }

    public List<Hero> read(String request) throws SQLException, IOException, ClassNotFoundException {

        connect();
        List<Hero> list = null;


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

        close();
        return list;

    }

    public void close() throws ClassNotFoundException, SQLException
    {
        connection.close();
        statement.close();
        resultSet.close();


    }


}
