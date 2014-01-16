/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package remote_beans;

import data_access.Customer;
import data_access.CustomerDAO;
import data_access.RDBCustomerDAO;
import java.sql.Connection;
import java.sql.Date;
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
public class CustomerBean implements CustomerBeanRemote {
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

    @Override
    public boolean createCustomer(String firstname, String lastname, Date dob, String address) {
       try {
            CustomerDAO dao = new RDBCustomerDAO(dbConnection);
            Customer customer = new Customer(firstname, lastname, dob, address);
            
            dao.createCustomer(customer);
            return true;
            
        } catch (Exception e) {
            System.out.println("Could not create customer.");
            e.printStackTrace();
        }
       return false;
    }

    @Override
    public boolean updateCustomer(int C_ID,String firstname, String lastname, Date dob, String address) {
         try {
            CustomerDAO dao= new RDBCustomerDAO(dbConnection);

            Customer customer=dao.readCustomerById(C_ID);
            
            if(customer==null){
               throw new Exception();
            }
            customer.setAddress(address);
            customer.setDOB(dob);
            customer.setFirstName(firstname);
            customer.setLastName(lastname);

            dao.updateCustomer(customer);
            return true;
        } catch (Exception e) {
            System.out.println("Could not update customer.");
            e.printStackTrace();
        }
         return false;
    }

    @Override
    public boolean deleteCustomer(int C_ID) {
        try {
            CustomerDAO dao= new RDBCustomerDAO(dbConnection);

            Customer customer=dao.readCustomerById(C_ID);
            
            if(customer==null){
               throw new Exception();
            }
            
            dao.deleteCustomer(customer);
           return true;
        } catch (Exception e) {
            System.out.println("Could not update customer.");
            e.printStackTrace();
        }
        return false;
    }

    
@Override
    public int readCustomer(String firstname, String lastname, Date dob, String address) {
        int C_ID=-1;
        try{
           CustomerDAO dao= new RDBCustomerDAO(dbConnection);
             C_ID=dao.readCustomer(new Customer( firstname,  lastname,  dob,  address)); 
             if(C_ID==-1){
                 throw new Exception();
                 
             }
        }catch(Exception ex){
            System.out.println("Could not read customer's ID.");
            ex.printStackTrace();
        }
        
        return C_ID;
    }

    @Override
    public Collection getAllCustomer() {
        CustomerDAO dao= new RDBCustomerDAO(dbConnection);
        return dao.getAllCustomer();
    }

    @Override
    public int countAllCustomers() {
       CustomerDAO dao= new RDBCustomerDAO(dbConnection);
        return dao.countAllCustomers();
    }

    

   
    
    
}
