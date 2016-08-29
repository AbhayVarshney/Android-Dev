package com.demo.android.d16sqlite;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

public class D16SQLiteActivity extends ListActivity {

	SQLiteDatabase db;
	EditText editText;
	
	public void doListButton(View view) {
		StringBuilder sb = new StringBuilder("List of databases\n");
		for (String s : databaseList()) {
			sb.append(s + "\n");
		}
		new AlertDialog.Builder(this).setMessage(sb).setPositiveButton("OK", null).show();
	}
	public void doInsertButton(View view) {
		if (editText.getText().toString().length() == 0) {
			new AlertDialog.Builder(this)
			.setTitle("No Text Entered")
			.setIcon(android.R.drawable.ic_dialog_alert)
			.setPositiveButton(android.R.string.ok, null)
			.show();
			return;
		}
		//String sqlScript = "INSERT ... ; NEXT ; ansdfd ;"
		String sql = "INSERT INTO mytable VALUES(null, '" + editText.getText().toString() + "')";
		db.execSQL(sql);
		Toast.makeText(this, "Item inserted into database", Toast.LENGTH_LONG).show();
		
	}
	public void doQueryButton(View view) {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		String sql = "SELECT * FROM mytable";
		Cursor cursor = db.rawQuery(sql, null);
		if (cursor != null) {
			while (cursor.moveToNext()) {
				int id = cursor.getInt(0);
				String name = cursor.getString(1);
				arrayList.add("" + id + " - " + name);
			}
			cursor.close();
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
			setListAdapter(adapter);
		}
		
		
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        editText = (EditText) findViewById(R.id.editText1);
        
        db = openOrCreateDatabase("mydb", MODE_PRIVATE, null);
        
        String sql = "CREATE TABLE IF NOT EXISTS mytable (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
        db.execSQL(sql);
        
    }
    
    
    
}