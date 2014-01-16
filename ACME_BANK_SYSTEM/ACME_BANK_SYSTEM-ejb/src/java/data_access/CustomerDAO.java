/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data_access;

import java.util.Collection;

/**
 *
 * @author WEIQIANG LIANG
 */
public interface CustomerDAO {
    public void createCustomer(Customer customer);
    public int readCustomer(Customer customer);
    public Customer readCustomerById(int C_ID);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
    public Collection getAllCustomer();
    public int countAllCustomers();
}
