package com.firstmavenproject.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.firstmavenproject.User;

public class UserDaoImpl implements CrudDao {
    private Connection conn;

    public UserDaoImpl() {
        conn = ConectionDB.getConnectionDb();
    }

    @Override
    public Boolean creatData(User user) {
        try {
            System.out.println("iniciando minha query");
            PreparedStatement st = conn
                    .prepareStatement("INSERT INTO usuarios  (nome_usuario, email_usuario, hash_usuario)"
                            + "VALUES (?,?,?)RETURNING id_usuario");
            st.setString(1, user.getUserName());
            st.setString(2, user.getUserEmail());
            st.setString(3, user.getUserPassword());

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                System.out.println("minha Query deu certo: ");
                System.out.println( " aqui o id do filha da puta>: "+ rs.getLong("id_usuario"));
                
            }else {
                return false; 
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            System.out.println("ERRO SQL Exception ------!");
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Boolean getData(String userEmail) {
        return true;
    }

    @Override
    public Boolean updateUser(User user) {
        return true;
    }

    @Override
    public Boolean deleteUser(User user) {
        return true;
    }
}
