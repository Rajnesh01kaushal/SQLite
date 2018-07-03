package com.example.hp.solite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBClass extends SQLiteOpenHelper {

        private static  final String DATABASE_NAME = "Acadview";
        private static final int DATABASE_VERSION = 1;


    public DBClass(Context context) {

        super(context, "DATABASE_NAME",null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE USER (NAME text,password text, number text, type text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(sqLiteDatabase);

    }

    public boolean onAddData (String name, String password,String PhoneNo,String type){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

         ContentValues contentValues = new ContentValues();
         contentValues.put("Name", name);
         contentValues.put("Password", password);
         contentValues.put("Number", PhoneNo);
         contentValues.put("Type", type);

        long status = sqLiteDatabase.insert("USER",null, contentValues);

         contentValues.clear();
         return (status > -1);
     }

     Cursor getData() {
         SQLiteDatabase sqLiteDatabase = getReadableDatabase();

         Cursor cursor = sqLiteDatabase.query("USER",null,null,null,null,null,null);
         return cursor;

         }

//         delete function

         public void onDelete(String name){
        SQLiteDatabase db = getWritableDatabase();

        String[] arr = null;
        arr[0] = name;

        db.delete("USER","Name = ?",arr);
         }



//        public void onUpdate(String name) {
//            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("Name", name);
//
//
//
//            String arr[] = {"", ""};
//            arr[0] = name;
//
////            sqLiteDatabase.update("USER", contentValues, "Name=?,arr");
//
//
//        }
////        dbClass.onUpdate(name.getText().toString());


}
