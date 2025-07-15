package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import utils.DataBase;

public class Account {
    // ######### Properties #########
    private Integer accountId;
    private String name;
    private User user;
    private Integer balance;
    private Integer type;
    
    // ############## Methods ##############
    public static ArrayList<Transaction> getTrasactions(int id){
        ArrayList<Transaction> list = new ArrayList<>();
        try{
            Connection con = DataBase.getConnection();
            String query = "select * from transactions where account_id = ? ;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int trId = rs.getInt("id");
                String remark = rs.getString("remark");
                String type = rs.getString("type");
                int balance = rs.getInt("balance");
                LocalDateTime time = rs.getTimestamp("time").toLocalDateTime();
                list.add(new Transaction(id,trId, remark, type, balance, time));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }  
        return list;
    }

    public static int getAmount(int from){
        try{
            Connection con = DataBase.getConnection();
            String query = "select * from accounts where account_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, from);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int current = rs.getInt("balance");
                return current;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public static boolean update(int id,int amount){
        try{
            Connection con = DataBase.getConnection();
            String query = "update accounts set balance = ? where account_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setInt(2, id);
            
            if(ps.executeUpdate() != 0){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static int fetchBalance(int id){
        try{
            Connection con = DataBase.getConnection();
            String query = "select * from accounts where account_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("balance");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String toString() {
        return accountId+","+name+","+balance;
    }

    public boolean createAccount(){
        try{
            Connection con = DataBase.getConnection();
            String query = "insert into accounts (user_id,name,balance,type) value (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user.getUserId());
            ps.setString(2, name);
            ps.setInt(3, balance);
            ps.setInt(4, type);


            if(ps.executeUpdate() != 0){
                return true;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    // ############## Constructors ##############
    
    public Account(String name, User user, Integer balance, Integer type) {
        this.name = name;
        this.user = user;
        this.balance = balance;
        this.type = type;
    }

    

    
    public Account(Integer accountId, String name, Integer balance, Integer type) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
        this.type = type;
    }

    public Account(Integer accountId, String name, User user, Integer balance, Integer type) {
        this.accountId = accountId;
        this.name = name;
        this.user = user;
        this.balance = balance;
        this.type = type;
    }




    // ############# Getters and Setters ###########
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }



}