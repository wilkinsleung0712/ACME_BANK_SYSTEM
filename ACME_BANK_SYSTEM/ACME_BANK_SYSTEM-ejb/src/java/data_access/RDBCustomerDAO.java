/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author WEIQIANG LIANG
 */
public class RDBCustomerDAO implements CustomerDAO {
private Connection dbConnection=null;
private final String SQL_CREATE_CUSTOMER="INSERT INTO ACME_BANK.CUSTOMER(FIRSTNAME, LASTNAME, DOB, ADDRESS)"+ " VALUES (?, ?, ?, ?)";
private final String SQL_READ_CUSTOMER="SELECT C_ID FROM ACME_BANK.CUSTOMER WHERE FIRSTNAME = ? AND LASTNAME=? AND ADDRESS=?";
private final String SQL_READBYID_CUSTOMER="SELECT * FROM ACME_BANK.CUSTOMER WHERE C_ID=?";
private final String SQL_UPDATE_CUSTOMER="UPDATE ACME_BANK.CUSTOMER SET FIRSTNAME=?, LASTNAME=?,DOB=?,ADDRESS=? WHERE C_ID=?";
private final String SQL_DELETE_CUSTOMER="DELTE FROM ACME_BANK.CUSTOMER WHERE C_ID=?";
private final String SQL_GETALL_CUSTOMER="SELECT * FROM ACME_BANK.CUSTOMER";

    public RDBCustomerDAO(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }


    @Override
    public void createCustomer(Customer customer) {

    try {
        PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_CREATE_CUSTOMER,Statement.RETURN_GENERATED_KEYS);
        
        prestmnt.setString(1, customer.getFirstName());
        prestmnt.setString(2, customer.getLastName());
        prestmnt.setDate(3, customer.getDOB());
        prestmnt.setString(4, customer.getAddress());
        
        prestmnt.executeUpdate();
        
        ResultSet rs=prestmnt.getGeneratedKeys();
        rs.next();
        customer.setC_ID(rs.getInt(1));
        
    } catch (SQLException ex) {
       System.out.println("Could not add new customer.");
       ex.printStackTrace();
    }
 
    }

    
       @Override
    public Customer readCustomerById(int C_ID) {
        Customer customer=null;
        try {
        PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_READBYID_CUSTOMER);
        
        prestmnt.setInt(1, C_ID);

        ResultSet rs=prestmnt.executeQuery();
        rs.next();
        customer=new Customer(rs.getString("firstName"),rs.getString("lastName"),rs.getDate("DOB"),rs.getString("address"));
        customer.setC_ID(C_ID);
        
   
        
     } catch (SQLException ex) {
       System.out.println("Could not find  customer with ID= [ "+C_ID+" ]");
       ex.printStackTrace();
    } 
        return customer;
    }
    
    @Override
    public int  readCustomer(Customer customer) {
        int C_ID=-1;
        try {
        PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_READ_CUSTOMER);
        
        prestmnt.setString(1, customer.getFirstName());
        prestmnt.setString(2, customer.getLastName());
        prestmnt.setString(3, customer.getAddress());
        
        
        ResultSet rs=prestmnt.executeQuery();
        rs.next();
        C_ID=rs.getInt("C_ID");
   
        
     } catch (SQLException ex) {
       System.out.println("Could not find  customer with ID= [ "+C_ID+" ]");
       ex.printStackTrace();
    } 
        return C_ID;
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
        PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_UPDATE_CUSTOMER);
        
        prestmnt.setString(1, customer.getFirstName());
        prestmnt.setString(2, customer.getLastName());
        prestmnt.setDate(3, customer.getDOB());
        prestmnt.setString(4, customer.getAddress());
        prestmnt.setInt(5, customer.getC_ID());
        
        prestmnt.executeUpdate();
        
       
    } catch (SQLException ex) {
       System.out.println("Could not update  customer.");
       ex.printStackTrace();
    }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        try {
        PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_DELETE_CUSTOMER);
        
  
        prestmnt.setInt(1, customer.getC_ID());
        
        prestmnt.executeUpdate();
        
       
    } catch (SQLException ex) {
       System.out.println("Could not delete  customer.");
       ex.printStackTrace();
    }
    }

    @Override
    public Collection getAllCustomer() {
        Collection<String> customerList=new HashSet<>();
        try {
                PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_GETALL_CUSTOMER);
                ResultSet rs=prestmnt.executeQuery();
                ResultSetMetaData metaData = rs.getMetaData();
                int columns = metaData.getColumnCount();
                String data="";
                while(rs.next()){
                    data="";
                    for(int i=1;i<=columns;i++){
                       data+=rs.getObject(i).toString()+"\t";
                    }
                    customerList.add(data);
                    
                }
       
             } catch (SQLException ex) {
                System.out.println("Could not delete  customer.");
                ex.printStackTrace();
         }
        return customerList;
    }

    @Override
    public int countAllCustomers() {
        int columns=-1;
         try {
                PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_GETALL_CUSTOMER);
                ResultSet rs=prestmnt.executeQuery();
                columns = rs.getMetaData().getColumnCount();
                
       
             } catch (SQLException ex) {
                System.out.println("Could not delete  customer.");
                ex.printStackTrace();
         }
         return columns;
    }

 
}
