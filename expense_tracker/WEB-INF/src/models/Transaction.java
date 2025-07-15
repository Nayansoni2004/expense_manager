package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import utils.DataBase;

public class Transaction {
    private Integer transactionId;
    private Integer accountId;
    private String remark;
    private String type;
    private String time;
    private Integer balance;

    // ###### methods #####
    public boolean completeTransaction(){
        try{
            Connection con = DataBase.getConnection();
            String query = "insert into transactions (account_id,type,balance,remark) value (?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,accountId);
            ps.setString(2,type);
            ps.setInt(3, balance);
            ps.setString(4, remark);

            if(ps.executeUpdate() != 0)return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addAmount(){
        try{
            Connection con = DataBase.getConnection();
            String query = "insert into transactions (account_id,type,balance,remark) value (?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,accountId);
            ps.setString(2,"credit");
            ps.setInt(3, balance);
            ps.setString(4, remark);

            if(ps.executeUpdate() != 0){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public String toString() {
        return transactionId + ", "+accountId + ", " + remark + ", " + balance + ", " + type + ", " + time;
    }

    // ###### Constructors #####
    public Transaction(Integer accountId, String remark, Integer balance) {
        this.accountId = accountId;
        this.remark = remark;
        this.balance = balance;
    }

    public Transaction(Integer accountId, String remark, String type, Integer balance) {
        this.accountId = accountId;
        this.remark = remark;
        this.type = type;
        this.balance = balance;
    }

    public Transaction(Integer accountId,Integer transactionId, String remark, String type, Integer balance,LocalDateTime time){
        this(accountId, remark, type, balance);
        this.transactionId = transactionId;
        this.time = time.toString();
    }

    // ####### Getters and Setters ######
    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }


    

}
