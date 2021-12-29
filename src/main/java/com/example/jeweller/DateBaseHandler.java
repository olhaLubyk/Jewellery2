package com.example.jeweller;
import java.sql.*;

public class DateBaseHandler extends configs {
    Connection dbConnection;

    public Connection getDbConnection()
        throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(User user){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_NAME + "," + Const.USER_LASTNAME + "," +
                Const.USER_LOGIN + "," + Const.USER_PASSWORD + "," + Const.USER_GENDER + "," + Const.USER_JOB + ")" +
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,user.getFistName());
            prSt.setString(2,user.getLastName());
            prSt.setString(3,user.getLogin());
            prSt.setString(4,user.getPassword());
            prSt.setString(5,user.getGender());
            prSt.setString(6, user.getJob());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user){
        ResultSet resultSet = null;

        String select = "SELECT *  FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getLogin());
            prSt.setString(2,user.getPassword());

          resultSet =  prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void addStone(Stone stone){
        String insert = "INSERT INTO " + Const.STONE_TABLE + "(" + Const.STONE_NAME + "," + Const.STONE_DESCRIPTION+ "," +
                Const.STONE_KARAT + "," + Const.STONE_TRANSPARENCY+ "," + Const.STONE_PRICE + "," + Const.STONE_RANK + "," + Const.STONE_VALUE + ")"
                + " VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt2 = getDbConnection().prepareStatement(insert);
            prSt2.setString(1,stone.getName());
            prSt2.setString(2,stone.getDescripion());
            prSt2.setInt(3,stone.getKarat());
            prSt2.setInt(4,stone.getTransPar());
            prSt2.setInt(5,stone.getPrice());
            prSt2.setInt(6,stone.getRank());
            prSt2.setString(7,stone.getStoneValue());

            prSt2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getStones(){
        ResultSet resultSet = null;

        String select = "SELECT "+ Const.STONE_NAME +"  FROM " + Const.USER_TABLE;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet =  prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
