package com.eatwhat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import android.os.Bundle;
import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
	
	public static final String DB_NAME = "member.db";
	public static final int DB_VERSION = 1;
	DatabaseHelper db;
	Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		buttonRegist = (Button)findViewById(R.id.registe_button1) ;
		loginButton = (Button)findViewById(R.id.signin_button) ;
		nameEditText = (EditText)findViewById(R.id.username_edit) ;
		passwordEditText = (EditText)findViewById(R.id.password_edit) ;
		
		context = this;
		db = new DatabaseHelper(getApplicationContext(), DB_NAME, null, DB_VERSION);
		
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
			String userName= new String(), password = new String();
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				userName = nameEditText.getText().toString() ;
				password = passwordEditText.getText().toString();
				if(db.exite(userName)){
					if(db.right(userName, password)){
						Intent intent = new Intent() ;
						Bundle bundle = new Bundle();
						bundle.putString("name", userName);
						intent.setClass(MainActivity.this, mainPageActivity.class);
						intent.putExtras(bundle);
						startActivity(intent) ;
					}
					else{
						Toast.makeText(getApplicationContext(), "�������",
							     Toast.LENGTH_SHORT).show();
						nameEditText.setText("");
						passwordEditText.setText("");
					}
				}
				else{
					Toast.makeText(getApplicationContext(), "�û���������",
						     Toast.LENGTH_SHORT).show();
					nameEditText.setText("");
					passwordEditText.setText("");
				}
//				HttpClient httpClient = new DefaultHttpClient();
//                 
//                //��������������������ĵ�ַ
//                String validateUrl = "http://192.168.191.1/YCM/testjson.php";
//                 
//                //���ö�ȡ��ʱ
//                httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
//                //���ö�ȡ��ʱ
//                httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);
//                HttpPost httpRequst = new HttpPost(validateUrl);
//                 
//                //׼�����������
//                List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();                
//                params.add(new BasicNameValuePair("user", userName));
//                params.add(new BasicNameValuePair("password", password));
//                 
//                try
//                {
//                	//��������
//                    httpRequst.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));                           
//                    //�õ���Ӧ
//                    HttpResponse response = httpClient.execute(httpRequst);
//                                                      
//                    //����ֵ���Ϊ200�Ļ���֤���ɹ��ĵõ�������
//                    if(response.getStatusLine().getStatusCode() == 200)
//                    {
//                    	StringBuilder builder = new StringBuilder();
//                                     
//                        //���õ������ݽ��н���
//                        BufferedReader buffer = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//                                     
//                        for(String s =buffer.readLine(); s!= null; s = buffer.readLine())
//                        {
//                        	builder.append(s);
//                        }
//                                     
//                        System.out.println(builder.toString());
//                        //�õ�Json����
//                        JSONObject jsonObject   = new JSONObject(builder.toString());
//                                     
//                        //ͨ���õ���ֵ�Եķ�ʽ�õ�ֵ
//                        id = jsonObject.getInt("user_id");
//                        userName = jsonObject.getString("user_name");
//                        password = jsonObject.getString("password");                           
//                    }                         
//                 } catch (Exception e)
//                 {
//                           e.printStackTrace();
//                 }
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
