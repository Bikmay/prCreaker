package dao;

import models.Hero;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.File;
import java.sql.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Database {

    private static final Logger logger= (Logger) LogManager.getLogger(Database.class);



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
        ArrayList<Hero> list = new ArrayList<>();
        ResultSet resultSet =null;


        resultSet=statement.executeQuery(request);

        if(resultSet==null)
            System.out.println("result null");
        Hero hero= null;
        while (resultSet.next())
        {
            hero=new Hero();

            hero.id =resultSet.getInt(1);
            hero.name=resultSet.getString(2);
            hero.universe=resultSet.getString(3);
            hero.power=resultSet.getInt(4);
            hero.description=resultSet.getString(5);
            hero.logo=resultSet.getString(6);
            hero.phone=resultSet.getInt(7);
            list.add(hero);
        }

        System.out.println(list.get(0).name);

        resultSet.close();
        statement.close();
        connection.close();
        return list;

    }



}
