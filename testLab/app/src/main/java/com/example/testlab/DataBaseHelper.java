package com.example.testlab;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbtest";
    String createtb = "create table User(Username TEXT(50),Password TEXT(50))";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createtb);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    public long insertData(String name,String pass){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql="insert into User(Username,Password) values(?,?)";
            SQLiteStatement stm = db.compileStatement(sql);
            stm.bindString(1,name);
            stm.bindString(2,pass);
            long r = stm.executeInsert();
            db.close();
            return r;
        }catch (Exception ex){
            return -1;
        }

    }
    public String[] SelectData(String name) {
        try {
            String[] data = null;
            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "select * from User where Username=?";
            String[] arr = new String[]{name};
            Cursor cur = db.rawQuery(sql, arr);
            if (cur != null) {
                if (cur.moveToFirst()) {
                    data = new String[cur.getColumnCount()];
                    data[0] = cur.getString(0);
                    data[1] = cur.getString(1);
                }
            }
            db.close();
            return data;
        } catch (Exception ex) {
            return null;
        }
    }

    public long UpdateData(String user, String pass) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "update User set Password=? where Username=?";
            SQLiteStatement stm = db.compileStatement(sql);
            stm.bindString(2, user);
            stm.bindString(1, pass);
            long r = stm.executeInsert();
            db.close();
            return r;
        } catch (Exception ex) {
            return -1;
        }
    }

    //    public long DeleteData(String id){
//        try {
//            SQLiteDatabase db = this.getWritableDatabase();
//            String sql="delete from employee  where id=?";
//            SQLiteStatement stm = db.compileStatement(sql);
//            stm.bindString(1, id);
//            long r = stm.executeUpdateDelete();
//            db.close();
//            return r;
//        }catch (Exception ex){
//            return -1;
//        }
//
//    }
//    public void selectall(){
//        try {
//            String [] da =null;
//            SQLiteDatabase db=this.getReadableDatabase();
//            String sql="select empname from employee ";
//
//            String [] arr =new String[]{};
//            Cursor cur = db.rawQuery(sql, arr);
//            if(cur != null){
//                if(cur.moveToFirst()){
//                    da = new String[cur.getColumnCount()];
//                    da[0] = cur.getString(0);
//                    da[1] = cur.getString(1);
//                    da[2] = cur.getString(2);
//                    da[3] = cur.getString(3);
//                    da[4] = cur.getString(4);
//
//                }
//            }
//
//            db.close();
//
//
//        }catch (Exception ex){
//        }
//    }
    public Cursor viewdata() {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String query = "select * from User";
            Cursor cursor = db.rawQuery(query, null);
            return cursor;
        } catch (Exception ex) {
            return null;
        }
    }

}
