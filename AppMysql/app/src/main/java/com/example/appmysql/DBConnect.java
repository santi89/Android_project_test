package com.example.appmysql;
import  java.sql.*;
public class DBConnect {
    public  static  Connection getConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user="root";
            String pwd="";
            String url="jdbc:mysql://192.168.43.222:3307/db1?&characterEncoding=utf-8";
            return  DriverManager.getConnection(url,user,pwd);
        }catch (Exception ex){
            return  null;
        }
    }
}
