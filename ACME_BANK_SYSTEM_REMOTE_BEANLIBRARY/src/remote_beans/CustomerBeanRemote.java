/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package remote_beans;

import java.sql.Date;
import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author WEIQIANG LIANG
 */
@Remote
public interface CustomerBeanRemote {
     public boolean createCustomer(String firstname, String lastname, Date dob, String address);
     public boolean updateCustomer(int C_ID,String firstname, String lastname, Date dob, String address);
     public boolean deleteCustomer(int C_ID);
     public int readCustomer(String firstname, String lastname, Date dob, String address);
      public Collection getAllCustomer();
      public int countAllCustomers();

}
