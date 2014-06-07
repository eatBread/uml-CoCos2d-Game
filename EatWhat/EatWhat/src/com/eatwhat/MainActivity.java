package com.eatwhat;

import android.os.Bundle;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button buttonRegist ;
	Button loginButton ;
	EditText nameEditText ;
	EditText passwordEditText ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		buttonRegist = (Button)findViewById(R.id.registe_button1) ;
		loginButton = (Button)findViewById(R.id.signin_button) ;
		nameEditText = (EditText)findViewById(R.id.username_edit) ;
		passwordEditText = (EditText)findViewById(R.id.password_edit) ;
		
		buttonRegist.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent() ;
				intent.setClass(MainActivity.this, registActivity.class) ;
				startActivityForResult(intent, 1);
			}
		}) ;
		loginButton.setOnClickListener(new OnClickListener() {
			String name= new String(), password = new String();
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				name = nameEditText.getText().toString() ;
				password = passwordEditText.getText().toString() ;
				if(name.equals("aaa") && password.equals("111")){
					Intent intent = new Intent() ;
					intent.setClass(MainActivity.this, mainPageActivity.class) ;
					startActivityForResult(intent, 2) ;
				}
				else{
					Toast.makeText(getApplicationContext(), "用户名或密码有误",
						     Toast.LENGTH_SHORT).show();
					nameEditText.setText("") ;
					passwordEditText.setText("") ;
				}
			}
		}) ;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
