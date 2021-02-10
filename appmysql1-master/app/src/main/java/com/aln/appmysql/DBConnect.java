package com.aln.appmysql;
import java.sql.*;
public class DBConnect  {
    public static Connection getConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user="root";
            String pwd="";
            String url="jdbc:mysql://192.168.43.222/db1?&characterEncoding=UTF-8";
            return DriverManager.getConnection(url,user,null);
        }catch (Exception ex){
            return null;
        }
    }
}
