package com.eatwhat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class Information extends Activity{

	TextView tv;
	String name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
		
		Bundle bundle = this.getIntent().getExtras();
		name = bundle.getString("name");
		tv = (TextView)findViewById(R.id.textView1);
		
		tv.setText("ук╨е:" + name);
	}
}