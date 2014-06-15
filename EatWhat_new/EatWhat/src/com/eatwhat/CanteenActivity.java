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
		map.put("name", "�����");
		map.put("range", "4��");
		map.put("price", "6.0Ԫ");
		mDataList.add(map) ;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.food1);
		map.put("name", "�����");
		map.put("range", "4��");
		map.put("price", "6.0Ԫ");
		mDataList.add(map) ;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.food1);
		map.put("name", "�����");
		map.put("range", "4��");
		map.put("price", "6.0Ԫ");
		mDataList.add(map) ;
		map.put("picture", R.drawable.food1);
		map.put("name", "�����");
		map.put("range", "4��");
		map.put("price", "6.0Ԫ");
		mDataList.add(map) ;
	}
	private void setData1(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("picture", R.drawable.taocan1);
		map.put("name", "�ײ�1");
		map.put("range", "4��");
		map.put("price", "6.0Ԫ");
		mDataList.add(map) ;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.taocan2);
		map.put("name", "�ײ�2");
		map.put("range", "5��");
		map.put("price", "5.0Ԫ");
		mDataList.add(map) ;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.shaowei);
		map.put("name", "��ζ");
		map.put("range", "3��");
		map.put("price", "7.0Ԫ");
		mDataList.add(map) ;
		setData();
		}
	private void setData2(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("picture", R.drawable.qingjiao);
		map.put("name", "�ཷ���������");
		map.put("range", "4��");
		map.put("price", "8.0Ԫ");
		mDataList.add(map) ;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.wangle);
		map.put("name", "���˽�ɶ");
		map.put("range", "5��");
		map.put("price", "9.0Ԫ");
		mDataList.add(map) ;
		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.yinni);
		map.put("name", "ӡ�᳴��");
		map.put("range", "3��");
		map.put("price", "7.0Ԫ");
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
		if(canteenname.equals("һ��")){
			setData1();
		}
		else if(canteenname.equals("����")){
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
