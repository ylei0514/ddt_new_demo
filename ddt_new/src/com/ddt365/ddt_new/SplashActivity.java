package com.ddt365.ddt_new;

import java.util.Timer;
import java.util.TimerTask;

import com.ddt365.ddt_new.MainActivity;
import com.ddt365.ddt_new.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity{

	private Timer t;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  
		
        setContentView(R.layout.splash);
        
		t = new Timer();
		t.schedule(new TimerTask(){

			@Override
			public void run() {
				Intent i = new Intent(SplashActivity.this,MainActivity.class);
				startActivity(i);
				finish();
			}
		}, 2000);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	
}
