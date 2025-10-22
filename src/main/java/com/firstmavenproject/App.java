package com.firstmavenproject;

import java.util.Scanner;

import com.firstmavenproject.dataBase.ConectionDB;
import com.firstmavenproject.dataBase.CrudDao;
import com.firstmavenproject.dataBase.UserDaoImpl;

public class App {
    public static void main(String[] args) {
        // concetando com o postgres
        ConectionDB cdb = new ConectionDB(); 
        cdb.getConnectionDb();
        CrudDao crudUser = new UserDaoImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("<<---maven project is running!!--->>");
        boolean isControler = true;
        while (isControler) {
            System.out.println("Digite 1 para criar um usuario");
            System.out.println("Digite [5] para sair");
            int entradaDedados = sc.nextInt();
            System.out.println("aqui seu input: " + entradaDedados);
            if (entradaDedados == 1) {
                System.out.println("Digite seu nome: ");
                String newUserName = sc.nextLine(); 
                sc.nextLine();
                System.out.println("Informe seu email: ");
                String newUserEmail = sc.nextLine();
                System.out.println("digite uma senha: ");
                String newUserPassword = sc.nextLine();
                
                //cria user
                User nU = new User(0, newUserName, newUserEmail, newUserPassword);
                nU.getUserData();
                boolean isCreated =  crudUser.creatData(nU); 
                System.out.println(isCreated);
            } else if (entradaDedados == 5) {
                System.out.println("bye! bye!");
                isControler = false;

            }
        }
        sc.close();
    }
}
