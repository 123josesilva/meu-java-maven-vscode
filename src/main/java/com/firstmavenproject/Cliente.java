package com.firstmavenproject;

public class Cliente extends User {
    public String endereco; 

    public Cliente(String userName, String userEmail, String userPassword, String endereco){
        super(userName, userEmail, userPassword);
        this.endereco = endereco; 
    }

    public String getEndereco(){
        return this.endereco; 
    }
}
