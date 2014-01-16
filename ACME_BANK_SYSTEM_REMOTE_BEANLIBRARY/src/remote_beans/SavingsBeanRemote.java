/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package remote_beans;

import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author WEIQIANG LIANG
 */
@Remote
public interface SavingsBeanRemote {
    public boolean createSavingsAccount(int C_ID);
    public boolean updateSavingsAccount(int C_ID);
    public boolean deleteSavingsAccount (int C_ID);
    public boolean withdraw(int C_ID,int amount);
    public boolean deposit(int C_ID,int amount);
    public int viewBalance(int C_ID);
    public Collection getAllSavingsAccount();
}
