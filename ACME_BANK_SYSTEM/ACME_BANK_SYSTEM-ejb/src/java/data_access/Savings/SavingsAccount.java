/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data_access.Savings;

/**
 *
 * @author WEIQIANG LIANG
 */
public class SavingsAccount {
    private int C_ID;
    private int balance;
    private String accNum;

    public SavingsAccount(int C_ID) {
        this.C_ID = C_ID;
        this.balance=0;
        this.accNum="S"+C_ID;
    }

    public int getC_ID() {
        return C_ID;
    }

    public void setC_ID(int C_ID) {
        this.C_ID = C_ID;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }
    
    public void deposit(int amount){
        this.balance+=amount;
    }
    
    public boolean withdraw(int amount){
        if(this.balance>amount){
            this.balance-=amount;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "Customer [ID: "+this.C_ID+" Account Number: "+this.accNum+" Balance: "+this.balance+" ]";
        
    }
}
