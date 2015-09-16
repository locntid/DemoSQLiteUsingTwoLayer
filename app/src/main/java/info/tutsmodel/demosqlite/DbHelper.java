package info.tutsmodel.demosqlite;

/**
 * Created by locnt_000 on 9/16/2015.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, "demo", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQA =
                "CREATE TABLE  user (" +
                        "id INTEGER PRIMARY KEY," +
                        "name TEXT," +
                        "passw TEXT);";
        db.execSQL(createTableQA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String createTableQA = "DROP TABLE IF EXISTS user";
        db.execSQL(createTableQA);
    }
}
