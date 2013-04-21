package com.projectarli.facebooklogin;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView text = null;
	SharedPreferences preferences = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		text = (TextView) findViewById(R.id.text);
		preferences = getSharedPreferences("data", MODE_PRIVATE);
		
		text.setText(	"Name: " + preferences.getString("user_name", "No name") + "\n" +
						"Username: " + preferences.getString("user_username", "No username") + "\n" + 
						"User ID: " + preferences.getString("user_id", "No ID") + "\n" + 
						"Sesion Iniciada: " + preferences.getBoolean("sessionStarted", false));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
