package Beans;

import DataBase.BaseConn;

import java.sql.*;
import java.util.ArrayList;

public class UserList {

    ArrayList<User> usersData = null;

    public ArrayList<User> getData(){
        usersData = new ArrayList<User>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
        usersData = new ArrayList<User>();
        conn = new BaseConn().getConnection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("Select * from data");

        while(rs.next()){
            User temp = new User();
            temp.setId(rs.getInt("id_p"));
            temp.setName(rs.getString("name_p"));
            temp.setLosses(rs.getInt("losses"));
            temp.setVictories(rs.getInt("victories"));
            usersData.add(temp);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usersData;
    }

    public void addVictory(String name){

        if(NameInBase(name)==true){
            addPlayer(name);
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = new BaseConn().getConnection();
            stmt = conn.prepareStatement("update data set victories = victories+1 where name_p = ?");
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPlayer(String name){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = new BaseConn().getConnection();
            stmt = conn.prepareStatement("insert into data(name_p,victories,losses) values(?,0,0)");
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addLoss(String name){

        if(NameInBase(name)==true){
            addPlayer(name);
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = new BaseConn().getConnection();
            stmt = conn.prepareStatement("update data set losses = losses+1 where name_p = ?");
            stmt.setString(1,name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean NameInBase(String name){

        boolean status = true;
        for(User temp: getData()) {
            if(temp.getName().equals(name)){
                status = false;
            }
        }
        return status;
    }
}
