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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regist);
		
		registButton = (Button)findViewById(R.id.registe_button2) ;
		nameEditText = (EditText)findViewById(R.id.username_edit1) ;
		pw1 = (EditText) findViewById(R.id.password_edit1) ;
		pw2 = (EditText) findViewById(R.id.password_edit2) ;
		
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
					Toast.makeText(getApplicationContext(), "�������벻һ��",
						     Toast.LENGTH_SHORT).show();
					pw1.setText("") ;
					pw2.setText("") ;
				}
				else if(name.equals("a")){
					Toast.makeText(getApplicationContext(), "���û����Ѿ�����",
						     Toast.LENGTH_SHORT).show();
					nameEditText.setText("") ;
				}
				else{
					Intent intent = new Intent() ;
					intent.setClass(registActivity.this, mainPageActivity.class) ;
					startActivityForResult(intent, 3) ;
				}
			}
		}) ;
	}
}
