/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data_access;

import java.sql.Date;

/**
 *
 * @author WEIQIANG LIANG
 */
public class Customer {
    private int C_ID;
    private String firstName;
    private String lastName;
    private Date DOB;
    private String address;

    public Customer(String firstName, String lastName, Date DOB, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.address = address;
    }

    

    public int getC_ID() {
        return C_ID;
    }

    public void setC_ID(int C_ID) {
        this.C_ID = C_ID;
    }

    
   
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString(){
        return "Customer [ID: "+this.C_ID+" FIRSTNAME: "+this.firstName+" LASTNAME: "+this.lastName+" DOB: "+this.DOB+" ADDRESS: "+this.address+" ]";
    }
}
