/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data_access.transactions;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author WEIQIANG LIANG
 */
public class Transactions {
    private String T_ID;
    private String accNum;
    private int amount;
    private String description;

    public Transactions(int C_ID, String accNum, int amount,String description) {
        Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        this.T_ID = "T_"+C_ID+sdf.format(cal.getTime());
        this.accNum = accNum;
        this.amount = amount;
        this.description=description;
    }

    public String getT_ID() {
        return T_ID;
    }

    public void setT_ID(String T_ID) {
        this.T_ID = T_ID;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
