package dao;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Logger;

public class Database {



    public static boolean connect() throws IOException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:./src/dao/heros.sqlite");

            return true;


        }catch (Exception e){
            System.out.println("fail");

            return false;
        }



    }


}
