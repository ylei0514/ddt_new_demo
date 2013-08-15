package com.ddt365.ddt_new.activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.ddt365.ddt_new.R;
import com.ddt365.ddt_new.base.BaseShowActivity;

public class TestActivity extends BaseShowActivity{

	
	private Button test_button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		test_button = (Button)findViewById(R.id.test_button);
		test_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	public int getLayout() {
		return R.layout.test_activity;
	}

	
}
