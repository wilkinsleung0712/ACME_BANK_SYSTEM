/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data_access.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author WEIQIANG LIANG
 */
public class RDBTransactionsDAO implements TransactionsDAO{
    
private  Connection dbConnection=null;

private final String SQL_CREATE_TRANSACTIONS="INSERT INTO ACME_BANK.TRANSACTIONS(T_ID, ACCNUM,AMOUNT,DESCRIPTION )"+ " VALUES (?,?, ?, ?)";
private final String SQL_READ_TRANSACTIONS="SELECT * FROM ACME_BANK.TRANSACTIONS WHERE T_ID = ?";
private final String SQL_UPDATE_TRANSACTIONS="UPDATE ACME_BANK.TRANSACTIONS SET ACCNUM=?, AMOUNT=? DESCRIPTION=? WHERE T_ID=?";
private final String SQL_DELETE_TRANSACTIONS="DELTE FROM ACME_BANK.TRANSACTIONS WHERE T_ID=?";
private final String SQL_GETALL_TRANSACTIONS="SELECT * FROM ACME_BANK.TRANSACTIONS";
private final String SQL_GETALLBYID_TRANSACTIONS="SELECT * FROM ACME_BANK.TRANSACTIONS WHERE T_ID LIKE ?";

    public RDBTransactionsDAO(Connection dbConnection) {
        this.dbConnection=dbConnection;
    }


    @Override
    public void createTranscations(Transactions transaction) {
        try{
            PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_CREATE_TRANSACTIONS);
            
            prestmnt.setString(1, transaction.getT_ID());
            prestmnt.setString(2, transaction.getAccNum());
            prestmnt.setInt(3, transaction.getAmount());
            prestmnt.setString(4, transaction.getDescription());
            
            prestmnt.executeUpdate();
            
            
        }catch(Exception ex){
            System.out.println("Could not record a transaction. "+transaction.getT_ID());
             ex.printStackTrace();
        }
    }

    @Override
    public Collection getAllTranscations() {
        Collection<String> collection=new HashSet<>();;
        try{
            PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_GETALL_TRANSACTIONS);
            ResultSet rs=prestmnt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
                int columns = metaData.getColumnCount();
                String data="";
                while(rs.next()){
                    data="";
                    for(int i=1;i<=columns;i++){
                       data+=rs.getObject(i).toString()+"\t";
                    }
                    collection.add(data);
                    
                }
        }catch(Exception ex){
            System.out.println("Could not record a transaction. ");
             ex.printStackTrace();
        }
        return collection;
    }

    @Override
    public void updateTransactions(String T_ID) {
        try{
            
        }catch(Exception ex){
            System.out.println("Could not record a transaction. "+T_ID);
             ex.printStackTrace();
        }
    }

    @Override
    public void deleteTransactions(String T_ID) {
        try{
            PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_DELETE_TRANSACTIONS);
            
            prestmnt.setString(1, T_ID);
         
            prestmnt.executeUpdate();
            
            
        }catch(Exception ex){
            System.out.println("Could not delete a transaction. "+T_ID);
             ex.printStackTrace();
        }
    }

    @Override
    public Collection getTranscationsByT_ID(String T_ID) {
        Collection collection=new HashSet<>();;
        try{
            PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_GETALLBYID_TRANSACTIONS);
            prestmnt.setString(1,"T_"+T_ID+"%");
            ResultSet rs=prestmnt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
                int columns = metaData.getColumnCount();
                String data="";
                while(rs.next()){
                    data="";
                    for(int i=1;i<=columns;i++){
                       data+=rs.getObject(i).toString()+"\t";
                    }
                    collection.add(data);
                    
                }
        }catch(Exception ex){
            System.out.println("Could not record a transaction. ");
             ex.printStackTrace();
        }
        return collection;
    }
    
}
