package com.firstmavenproject;

import com.password4j.BcryptFunction;
import com.password4j.Hash;
import com.password4j.Password;
import com.password4j.types.Bcrypt;

public class User {
    private int userID;
    private String userName;
    private String userEmail;
    private String userPassword; 

    public User(int userID, String userName, String userEmail, String userPassword){
        this.userID = userID;
        this.userName = userName; 
        this.userEmail = userEmail; 
        this.userPassword = getHashPassword(userPassword); 
    }

    public String getHashPassword(String userPassword){
        BcryptFunction bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12); 
        Hash hash = Password.hash(userPassword).with(bcrypt);
        System.out.println("aqui o hash " + hash.getResult());    
        return hash.getResult(); 
    }

    public void getUserData(){
        System.out.println("userName: " + userName);
        System.out.println("userEmail: "  + userEmail);
        System.out.println("userId: " + userID);
        System.out.println("userPassWord: "  + userPassword);

    }

}
