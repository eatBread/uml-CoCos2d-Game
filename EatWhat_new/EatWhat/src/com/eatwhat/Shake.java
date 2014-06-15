package com.eatwhat;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Shake extends Activity{

	private SensorManager sensorManager;
	private Vibrator vibrator;
	private static final String TAG = "TestSensorActivity";
	private static final int SENSOR_SHAKE = 10;
	
	TextView tv1;
	TextView tv2;
	TextView tv3;
	ImageView iv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shake);
		
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		
		tv1 = (TextView)findViewById(R.id.textView1);
		tv2 = (TextView)findViewById(R.id.textView2);
		tv3 = (TextView)findViewById(R.id.textView3);
		iv = (ImageView)findViewById(R.id.imageView1);
		}
	
		@Override
		protected void onResume() {
			super.onResume();
			if (sensorManager != null) {// ע�������
				sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
				// ��һ��������Listener���ڶ������������ô��������ͣ�����������ֵ��ȡ��������Ϣ��Ƶ��
			}
		}
		
		@Override
		protected void onPause() {
			super.onPause();
			if (sensorManager != null) {// ȡ��������
				sensorManager.unregisterListener(sensorEventListener);
			}
		}
		/**
		* ������Ӧ����
		*/
		private SensorEventListener sensorEventListener = new SensorEventListener() {
			@Override
			public void onSensorChanged(SensorEvent event) {
				// ��������Ϣ�ı�ʱִ�и÷���
				float[] values = event.values;
				float x = values[0]; // x�᷽����������ٶȣ�����Ϊ��
				float y = values[1]; // y�᷽����������ٶȣ���ǰΪ��
				float z = values[2]; // z�᷽����������ٶȣ�����Ϊ��
				
				int medumValue = 19;// ���� i9250��ô�ζ����ᳬ��20��û�취��ֻ����19��
				if (Math.abs(x) > medumValue || Math.abs(y) > medumValue || Math.abs(z) > medumValue) {
					vibrator.vibrate(200);
					Message msg = new Message();
					msg.what = SENSOR_SHAKE;
					handler.sendMessage(msg);
				}
			}
			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
			}
		};
		/**
		* ����ִ��
		*/
		Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				switch (msg.what) {
				case SENSOR_SHAKE:
					tv1.setText("�����");
					tv2.setText("6Ԫ");
					tv3.setText("���Ƿ���");
					iv.setImageResource(R.drawable.food1);
					break;
				}
			}
		};
}