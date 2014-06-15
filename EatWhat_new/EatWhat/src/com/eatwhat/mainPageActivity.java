package com.eatwhat;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;

public class mainPageActivity extends Activity{
	
	Button info;
	Button shake;
	String name;
	@Override
	public void onCreate(Bundle savedInstanceState) {  
	      super.onCreate(savedInstanceState);  
	      setContentView(R.layout.main_page);  
	      GridView gridview = (GridView) findViewById(R.id.gridview);
	      info = (Button)findViewById(R.id.info);
	      shake = (Button)findViewById(R.id.shake);
	      
	      Bundle bundle = this.getIntent().getExtras();
	      name = bundle.getString("name");
	      
	      info.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle bun = new Bundle();
				bun.putString("name", name);
				Intent intent = new Intent() ;
				intent.setClass(mainPageActivity.this, Information.class);
				intent.putExtras(bun);
				startActivity(intent) ;
			}
	    	  
	      });
	      
	      shake.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent() ;
				intent.setClass(mainPageActivity.this, Shake.class) ;
				startActivity(intent) ;
			}
	    	  
	      });
	      
	      //���ɶ�̬���飬����ת������  
	      ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();  
	      for(int i=0;i<6;i++)  
	      {  
	        HashMap<String, Object> map = new HashMap<String, Object>();  

	        switch(i){
	        case 0:
		        map.put("ItemImage", R.drawable.yi);//���ͼ����Դ��ID
	        	map.put("ItemText", "һ��");//�������ItemText
	        	break;
	        case 1:
		        map.put("ItemImage", R.drawable.er);//���ͼ����Դ��ID
	        	map.put("ItemText", "����");//�������ItemText
	        	break;
	        case 2:
		        map.put("ItemImage", R.drawable.yi);//���ͼ����Դ��ID
	        	map.put("ItemText", "����");//�������ItemText
	        	break;
	        case 3:
		        map.put("ItemImage", R.drawable.er);//���ͼ����Դ��ID
	        	map.put("ItemText", "�ķ�");//�������ItemText
	        	break;
	        case 4:
		        map.put("ItemImage", R.drawable.yi);//���ͼ����Դ��ID
	        	map.put("ItemText", "����");//�������ItemText
	        	break;
	        default:
		        map.put("ItemImage", R.drawable.er);//���ͼ����Դ��ID
	        	map.put("ItemText", "����");//�������ItemText
	        }
	        lstImageItem.add(map);  
	      }  
	      //������������ImageItem <====> ��̬�����Ԫ�أ�����һһ��Ӧ  
	      SimpleAdapter saImageItems = new SimpleAdapter(this, //ûʲô����  
	                                                lstImageItem,//������Դ   
	                                                R.layout.canteen_item,//night_item��XMLʵ��  
	                                                  
	                                                //��̬������ImageItem��Ӧ������          
	                                                new String[] {"ItemImage","ItemText"},   
	                                                  
	                                                //ImageItem��XML�ļ������һ��ImageView,����TextView ID  
	                                                new int[] {R.id.ItemImage,R.id.ItemText});  
	      //��Ӳ�����ʾ  
	      gridview.setAdapter(saImageItems);  
	      //�����Ϣ����  
	      gridview.setOnItemClickListener(new OnItemClickListener(){
	    	  public void onItemClick(AdapterView<?> arg0,//The AdapterView where the click happened   
                      View arg1,//The view within the AdapterView that was clicked  
                      int arg2,//The position of the view in the adapter  
                      long arg3//The row id of the item that was clicked  
                      ) {  
	    		  //�ڱ�����arg2=arg3  
	    		  HashMap<String, Object> item=(HashMap<String, Object>) arg0.getItemAtPosition(arg2);  
	    		  //��ʾ��ѡItem��ItemText  
	    		  setTitle((String)item.get("ItemText"));
	    		  Bundle bundle = new Bundle();
	    		  bundle.putString("itemName", (String)item.get("ItemText"));
	    		  bundle.putString("name", name);
	    		  Intent intent = new Intent();
	    		  intent.setClass(mainPageActivity.this, CanteenActivity.class) ;
	    		  intent.putExtras(bundle);
				  startActivity(intent);
	    	  }  
	      });
	  }  
	    
}
