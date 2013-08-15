package com.ddt365.ddt_new.base;

import com.ddt365.ddt_new.R;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity{

	public int exit_mode = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	protected void onPause() {
		super.onPause();
		if(exit_mode == 0){
			overridePendingTransition(R.anim.push_left_in,
					R.anim.push_right_out);
		}else{
			overridePendingTransition(R.anim.push_left_in,
					R.anim.push_right_out);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	
	
	
}
