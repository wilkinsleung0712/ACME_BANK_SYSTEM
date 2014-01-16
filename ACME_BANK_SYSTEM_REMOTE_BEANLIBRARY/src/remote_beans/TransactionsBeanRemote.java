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
public interface TransactionsBeanRemote {
    public void createTranscations(int C_ID, String accNum, int amount,String description);
    public Collection getAllTranscations();
    public void updateTransactions(String T_ID);
    public void deleteTransactions(String T_ID);
    public Collection getTranscationsByT_ID(String T_ID);
}
