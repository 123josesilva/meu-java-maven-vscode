package com.firstmavenproject;

public class Admin extends User {
    private String adminCargo;
    private boolean superAdmin; 
    private boolean isActive; 

    public Admin(String userName, String userEmail, String userPassword, String adminCargo, boolean superAdmin, boolean isActive){
        super(userName, userEmail, userPassword); 
        this.adminCargo = adminCargo;
        this.superAdmin= superAdmin;
        this.isActive = isActive; 
    }

    public String getAdminCargo() {
        return this.adminCargo; 
    }

    @Override
    public String toString(){
        return "adminCargo: " + this.adminCargo + " superAdmin: " + this.superAdmin + " isActive: " + isActive  ; 
    }
}
