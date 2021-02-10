package com.example.myserverconnection;

import java.sql.*;

public class ModelEmployee implements ActionDB {
    private String empid;
    private String empname;
    private String empemail;
    private String empsalary;

    Connection con;

    public ModelEmployee(Connection con) {
        this.con = con;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }

    public String getEmpsalary() {
        return empsalary;
    }

    public void setEmpsalary(String empsalary) {
        this.empsalary = empsalary;
    }

    @Override
    public ResultSet SelectData() throws Exception {
        String sql="select * from employee";
        ResultSet rs=con.createStatement().executeQuery(sql);

        return rs;
    }

    @Override
    public int InsertData() throws Exception {
        String sql="insert into employee Value(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,empid);
        ps.setString(2,empname);
        ps.setString(3,empemail);
        ps.setString(4,empsalary);
        int r=ps.executeUpdate();
        return r;
    }

    @Override
    public int UpdateData() throws Exception {
        String sql="Update employee set empname=?,empemail=?,empsalary=? where empid=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,empname);
        ps.setString(2,empemail);
        ps.setString(3,empsalary);
        ps.setString(4,empid);
        int r=ps.executeUpdate();
        return r;
    }

    @Override
    public int DeleteData() throws Exception {
        String sql="Delete from employee where empid=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,empid);
        int r=ps.executeUpdate();
        return r;
    }
}
