package com.ddt365.ddt_new.fragment;

import com.ddt365.ddt_new.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MessageFrag extends Fragment{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout v = (LinearLayout)inflater.inflate(R.layout.message_activity, container, false);
		
		
		
		return v;
	}

	@Override
	public void onResume() {
		super.onResume();
	}
}
