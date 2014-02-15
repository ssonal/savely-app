package com.example.savely;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class HomeScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case R.id.action_add:
				openAdd();
				return true;
			case R.id.action_settings:
//				openSettings();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	public void openAdd()
	{
		Intent newEvent = new Intent(this, AddNewActivity.class);
		startActivity(newEvent);
	}

}
