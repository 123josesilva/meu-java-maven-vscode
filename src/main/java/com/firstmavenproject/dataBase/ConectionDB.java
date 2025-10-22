package com.firstmavenproject.dataBase;

import java.sql.*;
import java.util.Properties;

public class ConectionDB {

    private static Connection conn;
    private static String url = "jdbc:postgresql://meu_postgres:5432/meu_banco";

    public static Connection getConnectionDb() {
        try {

            Properties props = new Properties();
            props.setProperty("user", "admin");
            props.setProperty("password", "admin123");

            conn = DriverManager.getConnection(url, props);

            if (conn != null) {
                System.out.println("banco conectado!");
            } else {
                System.out.println("falha ao conectar com o banco!");
            }

        } catch (Exception e) {
            System.out.println("erro ao conectar com o banco-----/:");
            System.out.println(e);

        }

        return conn;
    }

}
