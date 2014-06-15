package com.eatwhat;

import java.util.HashMap;

import android.R.bool;
import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{

	private static final String TABLE_NAME = "Member";
	
	  DatabaseHelper(Context context, String name, CursorFactory cursorFactory, int version) 
	  {     
	     super(context, name, cursorFactory, version);     
	  }     
	     
	     @Override    
	 	public void onCreate(SQLiteDatabase db){
	 		String SQL_CREATE_TABLE = "create table " + TABLE_NAME + " (_id integer primary key autoincrement,"+
	 				" name TEXT, " + "password TEXT);";
	 		db.execSQL(SQL_CREATE_TABLE);
	 	}
	     
	     @Override    
	 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {     
	         // TODO 更改数据库版本的操作     
	  }     
	     
	 @Override    
	 public void onOpen(SQLiteDatabase db) {     
	         super.onOpen(db);       
	         // TODO 每次成功打开数据库后首先被执行     
	 } 
	 
	 public void insert(String name,String password) {

		 SQLiteDatabase dataBase = getWritableDatabase(); 
		 
		 ContentValues values = new ContentValues();
		 values.put("name", name);
		 values.put("password", password);
		 
		 long rid = dataBase.insert(TABLE_NAME, null, values);

	     dataBase.close();
	    }

	    // 删除一条数据
	    public void delete(String name) {

	       /*SQLiteDatabase database = getWritableDatabase();	 
			 
	       ContentValues values = new ContentValues();
	       String whereClause = "name = ?";
	       String[] whereArgs = {"name"};
	       
	       int row = database.delete(TABLE_NAME, whereClause, whereArgs);

	       database.close();*/
	    	SQLiteDatabase DB = getWritableDatabase();
			String[] args = {name};
			DB.delete(TABLE_NAME, "name=?", args);
			DB.close();

	    }

	    public void update(String name,String phone,String name1,String phone1) {
	       /*SQLiteDatabase database = getWritableDatabase();	 
			 
	       ContentValues values = new ContentValues();
	       values.put("name", name);
	       values.put("phone", phone);
	       
	       String whereClause = "name = ?";
	       String[] whereArgs = {"name"};
	       
	       int row = database.update(TABLE_NAME, values, whereClause, whereArgs);

	       database.close();*/
	    	SQLiteDatabase DB = getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("name", name1);
			values.put("phone", phone1);

			String[] args = {name, phone};
			DB.update(TABLE_NAME, values, "name=? AND phone=?", args);
			DB.close();
	    }
	    
	    public boolean exite(String name){
	    	String name2;
	    	boolean c = false;
	    	SQLiteDatabase database = getWritableDatabase();
	    	Cursor result = database.rawQuery("SELECT * FROM "+ TABLE_NAME, null); //ID所在行查询             
	        
	    	result.moveToFirst();
		    while(!result.isAfterLast()){
		    	  name2 = result.getString(1);
		    	  if(name.equals(name2)){
		    		  c = true;
		    	  }
		    	  result.moveToNext();
		    }
		    
		    database.close();
		    return c;
	    }
	    
	    public boolean right(String name,String password){
	    	SQLiteDatabase database = getWritableDatabase();
	    	String name2;
	    	String pass;
	    	boolean c = false;
	    	Cursor result = database.rawQuery("SELECT * FROM "+ TABLE_NAME, null); //ID所在行查询             
	        
	    	result.moveToFirst();
		    while(!result.isAfterLast()){
		    	  name2 = result.getString(1);
		    	  pass = result.getString(2);
		    	  if(name.equals(name2) && password.equals(pass)){
		    		  c = true;
		    	  }
		    	  result.moveToNext();
		    }
		    
		    database.close();
		    return c;
	    }
//	    public  get() {
//		    SQLiteDatabase database = getWritableDatabase();	 
//		       
//		       HashMap<String,String> ma = new HashMap<String,String>();
//		       String name;
//		       String password;
//				 
//		       Cursor result = database.rawQuery("SELECT name FROM "+ TABLE_NAME, null);
//		       result.moveToFirst();
//		       while(!result.isAfterLast()){
//		    	   name = result.getString(1);
//		    	   phone = result.getString(2);
//		    	   ma.put(name, phone);
//		    	   result.moveToNext();
//		       }
//		       database.close();
//		       
//		       return ma;
//		    }
}
