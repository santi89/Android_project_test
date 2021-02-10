package com.st.countries;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class mydatabase extends SQLiteOpenHelper {

    private static final String dbname = "db1";
    private static final int dbversion = 1;
    String createtb = "create table employee (id Integer primary key Autoincrement," +
            "empname Text(50)," +
            "empsuname Text(50)," +
            "age Integer, " +
            "tel Text(20))";

    public mydatabase(@Nullable Context context) {
        super(context, dbname, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createtb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(String name, String surname, String age, String tel) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "insert into employee(name,surname,age,tel) values(?,?,?,?)";
            SQLiteStatement stmt = db.compileStatement(sql);
            stmt.bindString(1, name);
            stmt.bindString(2, surname);
            stmt.bindString(3, age);
            stmt.bindString(4, tel);
            long r = stmt.executeInsert();
            db.close();
            return r;
        } catch (Exception ex) {
            return -1;
        }

    }

    public String[] SelectData(String name) {
        try {
            String[] data = null;
            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "select * from employee where empname=?";
            String[] arr = new String[]{name};
            Cursor cur = db.rawQuery(sql, arr);
            if (cur != null) {
                if (cur.moveToFirst()) {
                    data = new String[cur.getColumnCount()];
                    data[0] = cur.getString(0);
                    data[1] = cur.getString(1);
                    data[2] = cur.getString(2);
                    data[3] = cur.getString(3);
                    data[4] = cur.getString(4);

                }
            }
            db.close();
            return data;

        } catch (Exception ex) {
            return null;
        }


    }
}
