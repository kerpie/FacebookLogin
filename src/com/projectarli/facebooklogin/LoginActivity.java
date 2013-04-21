package com.projectarli.facebooklogin;

import java.util.ArrayList;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends Activity {

	Button fbButton = null;
	SharedPreferences preferences = null;
	ArrayList<String> permissions = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		fbButton = (Button) findViewById(R.id.facebookButtonLogin);
		preferences = getSharedPreferences("data", MODE_PRIVATE);
		permissions = new ArrayList<String>();
		permissions.add("");
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		fbButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Session.openActiveSession(LoginActivity.this, true, new Session.StatusCallback() {
					
					@Override
					public void call(Session session, SessionState state, Exception exception) {
						if(session.isOpened()){												
							Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {
								@Override
								public void onCompleted(GraphUser user, Response response) {
									if(user != null){
										Editor edit = preferences.edit();
										edit.putBoolean("sessionStarted", true);
										edit.putString("user_name", user.getName());
										edit.putString("user_username", user.getUsername());
										edit.putString("user_id", user.getId());
										edit.commit();
										Intent intent = new Intent(LoginActivity.this, MainActivity.class);
										startActivity(intent);
									}
									else{
										Toast.makeText(LoginActivity.this, "nop! =(", Toast.LENGTH_SHORT).show();
									}
								}
							});
						}
					}
				});
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(LoginActivity.this, requestCode, resultCode, data);
	}
}
