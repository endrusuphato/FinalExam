package com.example.Endru300335685;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {

    public void add(savings saving) throws ClassNotFoundException, SQLException;

    //personal note of the variables in savings java
//    private String custno;
//    private String custname;
//    private Double cdep;
//    private Integer nyears;
//    private String savtype;

    public savings edit(savings saving, String custno) throws SQLException, ClassNotFoundException;

    public void delete(String custno) throws SQLException;

    public List<savings> display() throws ClassNotFoundException, SQLException;

}
