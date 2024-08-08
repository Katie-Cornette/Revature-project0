package com.revature.utils;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection() throws SQLException{

        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e ){
            e.printStackTrace();
            System.out.println("A problem occurred locating the driver! NO!");
        }

        String url ="jdbc:postgresql://localhost:5432/postgres?currentSchema=project0";
        String username = "postgres";
        String password = "Password";

        return DriverManager.getConnection(url, username, password);
    }
}
