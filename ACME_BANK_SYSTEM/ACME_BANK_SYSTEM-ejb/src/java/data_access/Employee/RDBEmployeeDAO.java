/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data_access.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author WEIQIANG LIANG
 */
public class RDBEmployeeDAO implements EmployeeDAO{
private Connection dbConnection=null;
private final String SQL_CREATE_EMPLOYEE="INSERT INTO ACME_BANK.EMPLOYEE(FIRSTNAME, LASTNAME, E_ID)"+ " VALUES (?, ?, ?)";
private final String SQL_READ_EMPLOYEE="SELECT * FROM ACME_BANK.EMPLOYEE WHERE E_ID = ?";
private final String SQL_UPDATE_EMPLOYEE="UPDATE ACME_BANK.EMPLOYEE SET FIRSTNAME=?, LASTNAME=? WHERE E_ID=?";
private final String SQL_DELETE_EMPLOYEE="DELTE FROM ACME_BANK.EMPLOYEE WHERE E_ID=?";

    public RDBEmployeeDAO(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }


    @Override
    public void createCustomer(Employee employee) {
        try{
            PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_CREATE_EMPLOYEE);
            
            prestmnt.setString(1, employee.getFirstName());
            prestmnt.setString(2, employee.getLastName());
            prestmnt.setString(3, employee.getE_ID());
            
            prestmnt.executeUpdate();
            
        }catch(Exception ex){
            System.out.println("Could not add new employee.");
            ex.printStackTrace();
        }
    }

    @Override
    public Employee readCustomer(String E_ID) {
        Employee employee =null;
        try{
             PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_READ_EMPLOYEE);
           
            prestmnt.setString(1, E_ID);
            
            ResultSet rs=prestmnt.executeQuery();
            
            employee=new Employee(rs.getString("E_ID"),rs.getString("firstName"),rs.getString("lastName"));
            
        }catch(Exception ex){
            System.out.println("Could not read an employee.");
            ex.printStackTrace();
        }
        return employee;
    }

    @Override
    public void updateCustomer(Employee employee) {
        try{
            
        }catch(Exception ex){
            System.out.println("Could not add new customer.");
            ex.printStackTrace();
        }
        
    }

    @Override
    public void deleteCustomer(String  E_ID) {
        try{
            PreparedStatement prestmnt=dbConnection.prepareStatement(SQL_DELETE_EMPLOYEE);
            
           
            prestmnt.setString(1, E_ID);
            
            prestmnt.executeUpdate();
            
        }catch(Exception ex){
            System.out.println("Could not delete  employee.");
            ex.printStackTrace();
        }
        
    }

    @Override
    public boolean userLoginValidation(String E_ID, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
