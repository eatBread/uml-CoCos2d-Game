package com.eatwhat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class item_choose extends Activity{

	TextView view;
	Spinner spinner;
	Button sure;
	ArrayAdapter<String> adapter;
	static final String[] m={"5-10块","10块以上"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_choose);
		
		view = (TextView) findViewById(R.id.view);  
        spinner = (Spinner) findViewById(R.id.spinner2);
        sure = (Button)findViewById(R.id.sure);
        //将可选内容与ArrayAdapter连接起来  
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);  
          
        //设置下拉列表的风格  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
          
        //将adapter 添加到spinner中  
        spinner.setAdapter(adapter);  
          
        //添加事件Spinner事件监听    
        spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });  
          
        //设置默认值  
        spinner.setVisibility(View.VISIBLE);
        
        sure.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				bundle.putString("itemName", "more");
				Intent intent = new Intent() ;
				intent.setClass(item_choose.this, CanteenActivity.class) ;
				intent.putExtras(bundle);
				startActivity(intent);
			}
        	
        });
	}
}
