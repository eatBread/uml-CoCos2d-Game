package com.eatwhat;

import android.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class mainPageActivity extends Activity{
	ImageButton image1 ;
	ImageButton image2 ;
	ImageButton image3 ;
	ImageButton image4 ;
	ImageButton image5 ;
	ImageButton image6 ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_page) ;
		
		image1 = (ImageButton)findViewById(R.id.imageButton1) ;
		image2 = (ImageButton)findViewById(R.id.imageButton2) ;
		image3 = (ImageButton)findViewById(R.id.imageButton3) ;
		image4 = (ImageButton)findViewById(R.id.imageButton4) ;
		image5 = (ImageButton)findViewById(R.id.imageButton5) ;
		image6 = (ImageButton)findViewById(R.id.imageButton6) ;
		
		image1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent() ;
				intent.setClass(mainPageActivity.this, CanteenActivity.class) ;
				startActivityForResult(intent, 4);
			}
		}) ;
		image2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent() ;
				intent.setClass(mainPageActivity.this, CanteenActivity.class) ;
				startActivityForResult(intent, 4);
			}
		}) ;
		image3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent() ;
				intent.setClass(mainPageActivity.this, CanteenActivity.class) ;
				startActivityForResult(intent, 4);
			}
		}) ;
		image4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent() ;
				intent.setClass(mainPageActivity.this, CanteenActivity.class) ;
				startActivityForResult(intent, 4);
			}
		}) ;
		image5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent() ;
				intent.setClass(mainPageActivity.this, CanteenActivity.class) ;
				startActivityForResult(intent, 4);
			}
		}) ;
		image6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent() ;
				intent.setClass(mainPageActivity.this, CanteenActivity.class) ;
				startActivityForResult(intent, 4);
			}
		}) ;
	}
}
