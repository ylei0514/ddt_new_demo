package com.ddt365.ddt_new.base;

import android.os.Bundle;
import android.view.Window;

public abstract class BaseShowActivity extends BaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		this.setContentView(this.getLayout());
		
		
		
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		
		
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		
		
	}

	public abstract int getLayout();
	
}
