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
            System.out.println("Digite 2 para criar um Administrador");
            System.out.println("Digite [5] para sair");

            int entradaDedados = 0;
            try {
                entradaDedados = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("erro ao formatar o user input em int! ");
                e.printStackTrace();
            }

            System.out.println("aqui seu input: " + entradaDedados);
            if (entradaDedados == 1) {
                System.out.println("Digite seu nome: ");
                String newUserName = sc.nextLine();
                System.out.println("Informe seu email: ");
                String newUserEmail = sc.nextLine();
                System.out.println("digite uma senha: ");
                String newUserPassword = sc.nextLine();

                try {
                    User nU = new User(newUserName, newUserEmail, newUserPassword);
                    nU.getUserData();
                    // cria user
                    boolean isCreated = crudUser.creatData(nU);
                    System.out.println(isCreated);
                    
                } catch (IllegalArgumentException e) {
                    
                    System.out.println("erro ao criar o usuário " + e.getMessage());
                    
                }
                
            } else if (entradaDedados == 2) {
                
                System.out.println("informe seu cargo: ");
                String newUserCargo = sc.nextLine(); 
                String[] getUserinputData=  inputUserData();
                
                try{
                    Admin newA = new Admin(getUserinputData[0], getUserinputData[1], getUserinputData[2], newUserCargo);
                    System.out.println(newA.getAdminCargo()); 
                    
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            } else if (entradaDedados == 5) {
                System.out.println("bye! bye!");
                isControler = false;
                
            }
        }
        sc.close();
    }

    public static String[] inputUserData() {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Digite seu nome: ");
        String newUserName = scanner.nextLine();
        System.out.println("Informe seu email: ");
        String newUserEmail = scanner.nextLine();
        System.out.println("digite uma senha: ");
        String newUserPassword = scanner.nextLine();

        scanner.close();
        
        String[] userData = {newUserName, newUserEmail, newUserPassword}; 
        return userData; 
    }
}
