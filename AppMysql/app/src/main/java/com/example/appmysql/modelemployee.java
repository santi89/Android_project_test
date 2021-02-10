package com.example.appmysql;
import java.sql.*;
public class modelemployee implements ActionDB{
    private String empid;
    private String empName;
    private String ememail;
    private String emsalary;
    Connection c;

    public modelemployee(Connection c) {
        this.c = c;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getLastname() {
        return ememail;
    }

    public void setLastname(String ememail) {
        this.ememail = ememail;
    }

    public String getTel() {
        return emsalary;
    }

    public void setTel(String emsalary) {
        this.emsalary = emsalary;
    }

    @Override
    public ResultSet SelectData() throws Exception {
        String sql="Select * from employee";
        ResultSet rs=c.createStatement().executeQuery(sql);
        return rs;
    }
    public ResultSet SelectDatabyVal() throws Exception {
        String sql="Select * from employee where empid='"+empid+"'";
        ResultSet rs=c.createStatement().executeQuery(sql);
        return rs;
    }
    @Override
    public int InsertData() throws Exception {
        String sql="Insert into employee Values(?,?,?,?)";
        PreparedStatement ps=c.prepareStatement(sql);
        ps.setString(1,empid);
        ps.setString(2,empName);
        ps.setString(3,ememail);
        ps.setString(4,emsalary);
        int r=ps.executeUpdate();
        return r;
    }

    @Override
    public int UpdateData() throws Exception {
        String sql="update employee set empname=?,empemail=?,empsalary=? where empid=?";
        PreparedStatement ps=c.prepareStatement(sql);
        ps.setString(4,empid);
        ps.setString(1,empName);
        ps.setString(2,ememail);
        ps.setString(3,emsalary);
        int r=ps.executeUpdate();
        return r;
    }

    @Override
    public int DeleteData() throws Exception {
        String sql="Delete from employee where empid=?";
        PreparedStatement ps=c.prepareStatement(sql);
        ps.setString(1,empid);
        int r=ps.executeUpdate();
        return r;
    }
}
