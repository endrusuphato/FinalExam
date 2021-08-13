package com.example.Endru300335685;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface{

    Connection con;

    public DatabaseService(Connection con) {
        this.con = con;
    }




    @Override
    public void add(savings saving) throws ClassNotFoundException, SQLException {

        String quer1 = "INSERT INTO savingstable VALUES (?,?,?,?,?)";
        PreparedStatement query = con.prepareStatement(quer1);

        query.setString(1, saving.getCustno());
        query.setString(2, saving.getCustname());
        query.setDouble(3, saving.getCdep());
        query.setInt(4, saving.getNyears());
        query.setString(5, saving.getSavtype());


        query.executeUpdate();
    }

    //personal note of the variables in savings java
//    private String custno;
//    private String custname;
//    private Double cdep;
//    private Integer nyears;
//    private String savtype;

    @Override
    public savings edit(savings saving, String custno) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con.prepareStatement("UPDATE savingstable set custno = ?, custname = ?, cdep = ?, nyears = ?, savtype = ? where custno = ?");
        query.setString(1, saving.getCustno());
        query.setString(2, saving.getCustname());
        query.setDouble(3, saving.getCdep());
        query.setInt(4, saving.getNyears());

        query.setString(5, saving.getSavtype());
        query.setString(6, custno);
        query.executeUpdate();

        return saving;
    }

    @Override
    public void delete(String custno) throws SQLException {
        String quer1 = "Delete from savingstable where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, custno);
        query.executeUpdate();
    }

    @Override
    public List<savings> display() throws ClassNotFoundException, SQLException {
        List<savings> Catlist = new ArrayList<savings>();

        String quer1 = "Select * from savingstable";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();

        savings obj1;

        //display records if present
        while (rs.next()) {
            obj1 = new savings(rs.getString("custno"), rs.getString("custname"), rs.getDouble("cdep"), rs.getInt("nyears"), rs.getString("savtype"));
            Catlist.add(obj1);
        }
        return Catlist;
    }



    public savings search(String custno) throws SQLException, ClassNotFoundException {
        String quer1 = "select * from savingstable where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, custno);
        ResultSet rs = query.executeQuery();

        if (!rs.first()) {
            System.out.print("Record not existing");
            return null;
        }
        savings obj1 = null;

        obj1 = new savings(rs.getString("custno"), rs.getString("custname"), rs.getDouble("cdep"), rs.getInt("nyears"), rs.getString("savtype"));
        return obj1;
    }
}
