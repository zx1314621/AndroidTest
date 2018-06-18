package com.example.androidclasstest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidclasstest.DataBase.MyDatabaseHelper;
import com.facebook.common.internal.Objects;

public class SqliteActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);


        //创建数据库
        final Button createDatabase = findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });

        //插入数据
        Button addData = findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name","The Normal World");
                values.put("author","Lu Yao");
                values.put("pages","1600");
                values.put("price","67.98");
                db.insert("Book",null,values);
                values.clear();

                values.put("name","The Lost Symbol");
                values.put("author","Dan Brown");
                values.put("pages","510");
                values.put("price","19.95");
                db.insert("Book",null,values);

                Toast.makeText(SqliteActivity.this,"数据插入成功!",Toast.LENGTH_SHORT).show();

            }
        });


        //更新数据
        Button updateData = findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price",109.99);

                db.update("Book",values,"name = ?",new String[]{"The Lost Symbol"});
                Toast.makeText(SqliteActivity.this,"数据更新成功!",Toast.LENGTH_SHORT).show();
            }
        });

        //删除页数大于1000数据
        final Button deleteButton = findViewById(R.id.delete_data);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book","pages > ?",new String[]{"1000"});
                Toast.makeText(SqliteActivity.this,"删除数据成功!",Toast.LENGTH_SHORT).show();
            }
        });


        //查询数据
        Button queryButton = findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                //查询Book表
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("SQLite Book Table", "name is" + name);
                        Log.d("SQLite Book Table", "author is" + author);
                        Log.d("SQLite Book Table", "pages is" + pages);
                        Log.d("SQLite Book Table", "price is" + price);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }

        });





    }
}
