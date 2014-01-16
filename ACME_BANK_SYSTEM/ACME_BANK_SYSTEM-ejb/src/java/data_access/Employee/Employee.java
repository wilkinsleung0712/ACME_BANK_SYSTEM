/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data_access.Employee;

/**
 *
 * @author WEIQIANG LIANG
 */
public class Employee {
    private String E_ID;
    private String firstName;
    private String lastName;

    public Employee(String E_ID, String firstName, String lastName) {
        this.E_ID = E_ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getE_ID() {
        return E_ID;
    }

    public void setE_ID(String E_ID) {
        this.E_ID = E_ID;
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
    
    
}
