package com.firstmavenproject.dataBase;

import java.sql.*;
import java.util.Properties; 

public class ConectionDB {
    
    Connection connection = null;
    String url = "jdbc:postgresql://meu_postgres:5432/meu_banco";
    
    public void getConnectionDb(){
        try {
            Properties props = new Properties(); 
            props.setProperty("user", "admin");
            props.setProperty("password", "admin123");

            Connection conn = DriverManager.getConnection(url, props);
            if (conn != null){
                System.out.println("banco conectado!");
            }else{
                System.out.println("falha ao conectar com o banco!");
            }

        } catch (Exception e) {
            System.out.println("erro ao conectar com o banco-----/:");
            System.out.println(e);

        }
    }


}
