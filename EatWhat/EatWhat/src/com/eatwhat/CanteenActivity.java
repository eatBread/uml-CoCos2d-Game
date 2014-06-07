package com.eatwhat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class CanteenActivity extends Activity{
	ListView listView ;
	private List<Map<String, Object>> mDataList = new ArrayList<Map<String, Object>>();
	
	private void setData(){
		Map<String, Object> map = new HashMap<String, Object>();
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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.canteen) ;
		setData() ;
		listView = (ListView) findViewById(R.id.listView1) ;
		SimpleAdapter listItemAdapter = new SimpleAdapter(this,
				mDataList,R.layout.recipe_item,new String[]{"picture","name","range","price"},
				new int[]{R.id.imageView1,R.id.textView1,R.id.textView2,R.id.textView3});
		listView.setAdapter(listItemAdapter) ;
	}
}
