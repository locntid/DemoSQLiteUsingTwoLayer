package info.tutsmodel.demosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by locnt_000 on 9/16/2015.
 */
public class UserDAO  {
    private SQLiteDatabase db;
    public UserDAO(Context context){
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public Long inserUser(User user){
        ContentValues values = new ContentValues();
        values.put("name",user.name);
        values.put("passw",user.pass);
        return db.insert("user",null,values);
    }

    public int updateUser(User user){
        ContentValues values = new ContentValues();
        values.put("name",user.name);
        values.put("passw",user.pass);
        return db.update("user", values, "id = ?", new String[]{String.valueOf(user.id)});
    }

    public int deleteUser(int id){
        return db.delete("user","id = ?",new String[]{String.valueOf(id)});
    }
    /*
    Doc database
    xuat ra danh sach
     */
    private ArrayList<User> getUsers(String sql, String...selectionArgs){
        ArrayList<User> list = new ArrayList<>();
        Cursor c  = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            User user = new User();
            user.id = c.getInt(c.getColumnIndex("id"));
            user.name = c.getString(c.getColumnIndex("name"));
            user.pass = c.getString(c.getColumnIndex("passw"));
            list.add(user);
        }
        return list;
    }



    public ArrayList<User> getUsers(){
        // thuc hien cau lenh sql truy xuat du lieu
        String sql = "select * from user";
        return getUsers(sql);
    }


}
