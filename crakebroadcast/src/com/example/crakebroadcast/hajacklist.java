package com.example.crakebroadcast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
//���ٳ�֮��չʾ�Ľ���
import android.widget.TextView;

public class hajacklist extends Activity {
	TextView tvTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvTextView = (TextView) findViewById(R.id.action_settings);
		String hijackname = getIntent().getStringExtra("processname");
        tvTextView.setText(hijackname);
      
	}
	public void stop(View view){
		
		  //wanjie
        finish();
		
	}
}
