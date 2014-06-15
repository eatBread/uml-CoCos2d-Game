package com.eatwhat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class CanteenActivity extends Activity{
	ListView listView ;
	Button back;
	Button choose;
	String name;
	private List<Map<String, Object>> mDataList = new ArrayList<Map<String, Object>>();
	
	private void setData(){
		Map<String, Object> map;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.food1);
		map.put("name", "下午茶");
		map.put("range", "4分");
		map.put("price", "6.0元");
		mDataList.add(map) ;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.food1);
		map.put("name", "下午茶");
		map.put("range", "4分");
		map.put("price", "6.0元");
		mDataList.add(map) ;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.food1);
		map.put("name", "下午茶");
		map.put("range", "4分");
		map.put("price", "6.0元");
		mDataList.add(map) ;
		map.put("picture", R.drawable.food1);
		map.put("name", "下午茶");
		map.put("range", "4分");
		map.put("price", "6.0元");
		mDataList.add(map) ;
	}
	private void setData1(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("picture", R.drawable.taocan1);
		map.put("name", "套餐1");
		map.put("range", "4分");
		map.put("price", "6.0元");
		mDataList.add(map) ;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.taocan2);
		map.put("name", "套餐2");
		map.put("range", "5分");
		map.put("price", "5.0元");
		mDataList.add(map) ;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.shaowei);
		map.put("name", "烧味");
		map.put("range", "3分");
		map.put("price", "7.0元");
		mDataList.add(map) ;
		setData();
		}
	private void setData2(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("picture", R.drawable.qingjiao);
		map.put("name", "青椒鸡柳烩意粉");
		map.put("range", "4分");
		map.put("price", "8.0元");
		mDataList.add(map) ;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.wangle);
		map.put("name", "忘了叫啥");
		map.put("range", "5分");
		map.put("price", "9.0元");
		mDataList.add(map) ;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.yinni);
		map.put("name", "印尼炒饭");
		map.put("range", "3分");
		map.put("price", "7.0元");
		mDataList.add(map) ;
		setData();
		}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.canteen);
		
		Bundle bundle = this.getIntent().getExtras();
		String canteenname = bundle.getString("itemName");
		name = bundle.getString("name");
		if(canteenname.equals("一饭")){
			setData1();
		}
		else if(canteenname.equals("二饭")){
			setData2();
		}
		else setData2();
		listView = (ListView) findViewById(R.id.listView1);
		back = (Button)findViewById(R.id.backbutton);
		choose = (Button)findViewById(R.id.choosebutton);
		SimpleAdapter listItemAdapter = new SimpleAdapter(this,
				mDataList,R.layout.recipe_item,new String[]{"picture","name","range","price"},
				new int[]{R.id.imageView1,R.id.textView1,R.id.textView2,R.id.textView3});
		listView.setAdapter(listItemAdapter);
		
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
	    		intent.setClass(CanteenActivity.this, mainPageActivity.class);
	    		Bundle bundle = new Bundle();
				bundle.putString("name", name);
				intent.putExtras(bundle);
				startActivity(intent);
			}
			
		});
		
		choose.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
	    		intent.setClass(CanteenActivity.this, item_choose.class);
				startActivity(intent);
			}
			
		});
		
	}
}
