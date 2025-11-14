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

    public User(String userName, String userEmail, String userPassword) {
        // this.userID = userID;
        if (userName == null || userName.isBlank()) {
            throw new IllegalArgumentException("O campo nome nao pode estar vazio");
        }

        if (userEmail == null || userEmail.isBlank()) {
            throw new IllegalArgumentException("O campo email nao pode estar vazio");
        }

        if (userPassword == null || userPassword.isBlank()) {
            throw new IllegalArgumentException("O campo senha nao pode estar vazio");
        }

        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = getHashPassword(userPassword);
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public String getHashPassword(String userPassword) {
        BcryptFunction bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12);
        Hash hash = Password.hash(userPassword).with(bcrypt);
        System.out.println("aqui o hash " + hash.getResult());
        return hash.getResult();
    }

    public void getUserData() {
        System.out.println("userName: " + userName);
        System.out.println("userEmail: " + userEmail);
        System.out.println("userId: " + userID);
        System.out.println("userPassWord: " + userPassword);

    }

}
