/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package remote_beans;

import data_access.transactions.RDBTransactionsDAO;
import data_access.transactions.Transactions;
import data_access.transactions.TransactionsDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author WEIQIANG LIANG
 */
@Stateless
public class TransactionsBean implements TransactionsBeanRemote {
@Resource(lookup="jdbc/myACME_BANK_SYSTEM_DataSource")
private DataSource dataSource;
private Connection dbConnection;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

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

    @Override
    public void createTranscations(int C_ID, String accNum, int amount,String description){
        TransactionsDAO dao=new RDBTransactionsDAO(dbConnection);
           dao.createTranscations(new Transactions(C_ID,accNum,amount,description));
    }
    
    @Override
    public Collection getAllTranscations(){
        TransactionsDAO dao=new RDBTransactionsDAO(dbConnection);
        return dao.getAllTranscations();
    }
    @Override
    public void updateTransactions(String T_ID){
        TransactionsDAO dao=new RDBTransactionsDAO(dbConnection);
        dao.updateTransactions(T_ID);
    }
    @Override
    public void deleteTransactions(String T_ID){
        TransactionsDAO dao=new RDBTransactionsDAO(dbConnection);
        dao.deleteTransactions(T_ID);
    }

    @Override
    public Collection getTranscationsByT_ID(String T_ID) {
        TransactionsDAO dao=new RDBTransactionsDAO(dbConnection);
        return dao.getTranscationsByT_ID(T_ID);
    }
}
