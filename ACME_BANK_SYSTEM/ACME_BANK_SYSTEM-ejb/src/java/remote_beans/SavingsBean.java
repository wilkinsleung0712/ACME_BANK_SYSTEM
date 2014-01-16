/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package remote_beans;

import data_access.Savings.RDBSavingsAccountDAO;
import data_access.Savings.SavingsAccountDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.sql.DataSource;

/**
 *
 * @author WEIQIANG LIANG
 */
@Stateful
public class SavingsBean implements SavingsBeanRemote {
@Resource(lookup="jdbc/myACME_BANK_SYSTEM_DataSource")
private DataSource dataSource;
private Connection dbConnection;

@PostConstruct
public void init(){
    try {
        this.dbConnection=this.dataSource.getConnection();
    } catch (SQLException ex) {
        System.out.println("DataBase connection cannot be initialized.");
        ex.printStackTrace();
    }
}

@PreDestroy
public void close(){
    try {
        this.dbConnection.close();
    } catch (SQLException ex) {
        System.out.println("DataBase connection cannot be closed.");
        ex.printStackTrace();
    }
    
}


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public boolean createSavingsAccount(int C_ID) {
        try{
            SavingsAccountDAO dao=new RDBSavingsAccountDAO(dbConnection);
            dao.createSavingsAccount(C_ID);
            return true;
        }catch(Exception ex){
           System.out.println("Could not open a saving account for customer. "+C_ID);
           ex.printStackTrace();
           return false;
        }
        
    }

    @Override
    public boolean updateSavingsAccount(int C_ID) {
        try{
            SavingsAccountDAO dao=new RDBSavingsAccountDAO(dbConnection);
            dao.updateSavingsAccount(C_ID);
            return true;
        }catch(Exception ex){
            System.out.println("Could not open a saving account for customer. "+C_ID);
           ex.printStackTrace();
            return false;
        }
       
    }

    @Override
    public boolean deleteSavingsAccount(int C_ID) {
        try{
            SavingsAccountDAO dao=new RDBSavingsAccountDAO(dbConnection);
            dao.deleteSavingsAccount(C_ID);
            return true;
        }catch(Exception ex){
              System.out.println("Could not delete a savings account for customer. "+C_ID);
           ex.printStackTrace();
           return false;
        }
    }

    @Override
    public boolean withdraw(int C_ID, int amount) {
        try{
            SavingsAccountDAO dao=new RDBSavingsAccountDAO(dbConnection);
            
            dao.withdraw(C_ID, amount);
            return true;
            
            
        }catch(Exception ex){
             System.out.println("Could not withdraw on Account. "+C_ID);
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deposit(int C_ID, int amount) {
        try{
            SavingsAccountDAO dao=new RDBSavingsAccountDAO(dbConnection);
            dao.deposit(C_ID, amount);
            return true;
        }catch(Exception ex){
             System.out.println("Could not deposit on Account. "+C_ID);
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public int viewBalance(int C_ID) {
        int balance=-1;
        try{
            SavingsAccountDAO dao=new RDBSavingsAccountDAO(dbConnection);
            balance=dao.viewBalance(C_ID);
        }catch(Exception ex){
            System.out.println("Could not view balance on a savings account for customer. "+C_ID);
            ex.printStackTrace();
        }
        return balance;
    }

    @Override
    public Collection getAllSavingsAccount() {
        SavingsAccountDAO dao= new RDBSavingsAccountDAO(dbConnection);
        return dao.getAllSavingsAccount();
    }

   
}
