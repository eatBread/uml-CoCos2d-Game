package com.eatwhat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registActivity extends Activity{
	Button registButton ;
	EditText nameEditText ;
	EditText pw1, pw2 ;
	
	DatabaseHelper db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regist);
		
		registButton = (Button)findViewById(R.id.registe_button2) ;
		nameEditText = (EditText)findViewById(R.id.username_edit1) ;
		pw1 = (EditText) findViewById(R.id.password_edit1) ;
		pw2 = (EditText) findViewById(R.id.password_edit2) ;
		
		db = new DatabaseHelper(getApplicationContext(), MainActivity.DB_NAME, null, MainActivity.DB_VERSION);
		
		registButton.setOnClickListener(new OnClickListener() {
			
			String name = new String() ;
			String passw1 = new String() ;
			String passw2 = new String() ;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				name = nameEditText.getText().toString() ;
				passw1 = pw1.getText().toString() ;
				passw2 = pw2.getText().toString() ;
				if(!passw1.equals(passw2)){
					Toast.makeText(getApplicationContext(), "密码输入不一致",
						     Toast.LENGTH_SHORT).show();
					pw1.setText("") ;
					pw2.setText("") ;
				}
				else if(db.exite(name)){
					Toast.makeText(getApplicationContext(), "该用户名已经存在",
						     Toast.LENGTH_SHORT).show();
					nameEditText.setText("") ;
				}
				else{				
					db.insert(name,passw1);
					Bundle bundle = new Bundle();
					Intent intent = new Intent() ;
					intent.setClass(registActivity.this, MainActivity.class) ;
					bundle.putString("name", name);
					intent.putExtras(bundle);
					startActivity(intent) ;
				}
			}
		}) ;
	}
}
