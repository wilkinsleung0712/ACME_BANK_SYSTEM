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
public interface EmployeeDAO {
     public void createCustomer(Employee employee);
    public Employee readCustomer(String E_ID);
    public void updateCustomer(Employee employee);
    public void deleteCustomer(String E_ID);
    public boolean userLoginValidation(String E_ID, String password);
}
