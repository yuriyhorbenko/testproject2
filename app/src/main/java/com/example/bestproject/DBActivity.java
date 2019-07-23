package com.example.bestproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d("okok","db is ok");
        readData(db, dbHelper);
    }


    public void readData(SQLiteDatabase db,DBHelper dbHelper){
        Cursor c = db.query("mytable", null, null,
                null, null, null, null);

        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c.moveToFirst()) {
            // определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("name");
            int emailColIndex = c.getColumnIndex("email");
            do {

                Integer index_value = c.getInt(idColIndex);
                String name_value = c.getString(nameColIndex);
                String email_value  = c.getString(emailColIndex);
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d("okok",
                        "ID = " + index_value +
                                ", name = " + name_value +
                                ", email = " + email_value);
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());
        } else {
            Log.d("okok", "0 rows");
        }
        c.close();
        db.close();
    }



    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "myDBNew", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d("okok", "--- onCreate database ---");
            // создаем таблицу с полями
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name text,"
                    + "email text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
