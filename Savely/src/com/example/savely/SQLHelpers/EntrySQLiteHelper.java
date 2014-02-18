package com.example.savely.SQLHelpers;

import java.util.LinkedList;
import java.util.List;

import com.example.savely.SQLModels.Entry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EntrySQLiteHelper extends SQLiteOpenHelper {
	
	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "EntryDB";
	
	private static final String TABLE_ENTRIES = "entries";
	private static final String KEY_ID = "id";
	private static final String KEY_ACCOUNTID = "accountid"; 
	private static final String KEY_CATEGORYID = "categoryid";
	private static final String KEY_TYPEID = "typeid";
	private static final String KEY_DETAILS = "details";
	
	private static final String[] COLUMNS = {KEY_ID, KEY_ACCOUNTID, KEY_CATEGORYID, KEY_TYPEID, KEY_DETAILS};
	
	public EntrySQLiteHelper(Context context)
	{
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE = "CREATE TABLE entries ( "+
				"id INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"accountid INTEGER, " +
				"categoryid INTEGER, " +
				"typeid INTEGER, " +
				"details TEXT)";
		
		db.execSQL(CREATE_TABLE);
				
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String UPGRADE_TABLE = "DROP TABLE IF EXISTS entries";
		db.execSQL(UPGRADE_TABLE);
		this.onCreate(db);
	}
	
	public void addEntry(Entry entry)
	{
		Log.d("Adding new entry", entry.getDetails());
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues val = new ContentValues();
		val.put(KEY_ACCOUNTID, entry.getAccountId());
		val.put(KEY_CATEGORYID, entry.getCategoryId());
		val.put(KEY_TYPEID, entry.getTypeId());
		val.put(KEY_DETAILS, entry.getDetails());
		
		db.insert(TABLE_ENTRIES, null, val);
		
		db.close();
	}
	
	public List<Entry> getAllEntries()
	{
		List<Entry> entries = new LinkedList<Entry>();
		
		String query = "SELECT * FROM " + TABLE_ENTRIES;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		
		Entry entry = null;
		if (cursor.moveToFirst())
		{
			do
			{
				entry = new Entry();
				entry.setId(Integer.parseInt(cursor.getString(0)));
				entry.setAccountId(Integer.parseInt(cursor.getString(1)));
				entry.setCategoryId(Integer.parseInt(cursor.getString(2)));
				entry.setTypeId(Integer.parseInt(cursor.getString(3)));
				entry.setDetails(cursor.getString(4));
				
				entries.add(entry);
			}while(cursor.moveToNext());
		}
		
		return entries;
	}
	
	public int updateEntry(Entry entry)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues val = new ContentValues();
		val.put(KEY_ACCOUNTID, entry.getAccountId());
		val.put(KEY_CATEGORYID, entry.getCategoryId());
		val.put(KEY_TYPEID, entry.getTypeId());
		val.put(KEY_DETAILS, entry.getDetails());
		
		int i = db.update(TABLE_ENTRIES, 
				val, 
				KEY_ID+" = ?", 
				new String[]{String.valueOf(entry.getId())});
		
		db.close();
		return i;
	}
	
	public void deleteEntry(Entry entry) {
		 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. delete
        db.delete(TABLE_ENTRIES,
                KEY_ID+" = ?",
                new String[] { String.valueOf(entry.getId()) });
 
        // 3. close
        db.close();
        Log.d("Deleted entry", entry.getDetails());
    }

	
	public static String[] getColumns() {
		return COLUMNS;
	}



}
