package com.example.myserverconnection;

import java.sql.ResultSet;

public interface ActionDB {
    public ResultSet SelectData() throws Exception;
    public int InsertData() throws Exception;
    public int UpdateData() throws Exception;
    public int DeleteData() throws Exception;

}
