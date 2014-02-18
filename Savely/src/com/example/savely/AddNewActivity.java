package com.example.savely;

import java.util.*;

import com.example.savely.SQLHelpers.EntrySQLiteHelper;
import com.example.savely.SQLModels.Entry;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class AddNewActivity extends Activity implements OnClickListener{
//	private Spinner spinner1;
//	private Button button2;
	
	private RadioGroup transactionType;
	private RadioGroup accountType;
	private RadioGroup categoryType;
	private Button submitButton;
	private EditText description;
	private RadioButton checkedButton;
	
	private Hashtable<String, Integer> transactionHashTable = new Hashtable<String, Integer>();
	{
		transactionHashTable.put("Income", 0);
		transactionHashTable.put("Expense", 1);
	}
	
	private Hashtable<String, Integer> accountHashTable = new Hashtable<String, Integer>();
	{
		accountHashTable.put("Wallet", 0);
		accountHashTable.put("PiggyBank", 1);
		accountHashTable.put("SB Acc", 2);
	}
	
	private Hashtable<String, Integer> categoryHashTable = new Hashtable<String, Integer>();
	{
		categoryHashTable.put("Food", 0);
		categoryHashTable.put("Transport", 1);
		categoryHashTable.put("Clothing", 2);
	}
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		transactionType = (RadioGroup)findViewById(R.id.TypeRadioButton);
		accountType = (RadioGroup)findViewById(R.id.AccountsRadioButton);
		categoryType = (RadioGroup)findViewById(R.id.CategoriesRadioButton);
		submitButton = (Button)findViewById(R.id.button1);
		description = (EditText)findViewById(R.id.editText1);
//		addListenerOnButton();
//		addListenerOnSpinnerItemSelection();
		
		submitButton.setOnClickListener(this);
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_new, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		EntrySQLiteHelper db = new EntrySQLiteHelper(this);
		Entry entry = new Entry();
		
		int selectedId = transactionType.getCheckedRadioButtonId();
		checkedButton = (RadioButton)findViewById(selectedId);
		entry.setTypeId(transactionHashTable.get(checkedButton.getText()));
		
		selectedId = accountType.getCheckedRadioButtonId();
		checkedButton = (RadioButton)findViewById(selectedId);
		entry.setAccountId(accountHashTable.get(checkedButton.getText()));
		
		selectedId = categoryType.getCheckedRadioButtonId();
		checkedButton = (RadioButton)findViewById(selectedId);
		entry.setCategoryId(categoryHashTable.get(checkedButton.getText()));
		
		entry.setDetails(description.getText().toString());
		
		db.addEntry(entry);
		finish();
	}

}
