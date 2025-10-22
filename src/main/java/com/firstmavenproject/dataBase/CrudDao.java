package com.firstmavenproject.dataBase;

import com.firstmavenproject.User;

public interface CrudDao {

    public Boolean creatData(User user);
    public Boolean getData(String userEmail);//User 
    public Boolean updateUser(User user);
    public Boolean deleteUser(User user); 

} 
