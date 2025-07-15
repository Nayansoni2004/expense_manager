package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DataBase;

public class User{
    // ############# Properties ############
    private Integer userId;
    private String fullName;
    private String email;
    private String password;
    private AccountType accountType;

    // ############# Methods ############
    public ArrayList<Account> getAllAccounts(){
        ArrayList<Account> accounts = new ArrayList<>();

        try{
            Connection con = DataBase.getConnection();
            String query = "select * from accounts where user_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accounts.add(new Account(rs.getInt("account_id"),rs.getString("name"),rs.getInt("balance"),rs.getInt("type")));
            }
           
        }catch(SQLException e){
            e.printStackTrace();
        }

        return accounts;
    }

    public boolean signIn(){
        try{
            Connection con = DataBase.getConnection();
            String query = "select * from users where email = ? and password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                fullName = rs.getString("name");
                userId = rs.getInt("user_id");
                return true;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean signUp(){
        try{
            Connection con = DataBase.getConnection();
            String query = "insert into users(name,email,password) value (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setString(3, password);

            if(ps.executeUpdate() != 0)return true;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    // ############# Constructor ############ 
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public User(Integer userId, String fullName, String email, String password, ArrayList<Account> accounts,
            AccountType accountType) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
    }



    // ############# Getters and Setters ############
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }



}