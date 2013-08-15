package com.ddt365.ddt_new;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.ddt365.ddt_new.fragment.MemberFrag;
import com.ddt365.ddt_new.fragment.MessageFrag;
import com.ddt365.ddt_new.fragment.MyShopFrag;
import com.ddt365.ddt_new.mode.SimpleShopMode;
import com.ddt365.ddt_new.util.SimpleShopXmlUtil;

public class MainActivity extends FragmentActivity {

	private final static String MYSHOPTAG = "MyShopFrag";
	private final static String MESSAGETAG = "MessageFrag";
	private final static String MEMBERTAG = "MemberFrag";
	
	public int bottom_height = 0;
	
	private MyShopFrag shop_frag;
	private MessageFrag mess_frag;
	private MemberFrag mem_frag;
	
	private Button myshop_button;
	private Button message_button;
	private Button member_button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		setContentView(R.layout.activity_main);
		initButton();
		if (getSupportFragmentManager().findFragmentByTag(MYSHOPTAG) == null) {
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			if(shop_frag == null){
				shop_frag = new MyShopFrag();
			}
			ft.add(R.id.container,shop_frag, MYSHOPTAG);
			ft.commit();
		}
	}

	private void initButton(){
		myshop_button = (Button)findViewById(R.id.button01);
		message_button = (Button)findViewById(R.id.button02);
		member_button = (Button)findViewById(R.id.button03);
		
		myshop_button.setBackgroundResource(R.drawable.bottom_button_shanghu1);
		message_button.setBackgroundResource(R.drawable.bottom_button_xiaoxi2);
		member_button.setBackgroundResource(R.drawable.bottom_button_wode2);
		
		myshop_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(getSupportFragmentManager().findFragmentByTag(MYSHOPTAG) == null){
					if(shop_frag == null){
						shop_frag = new MyShopFrag();
					}
					FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
					ft.replace(R.id.container, shop_frag, MYSHOPTAG);
//					ft.addToBackStack(MYSHOPTAG);
					ft.commit();
					
					myshop_button.setBackgroundResource(R.drawable.bottom_button_shanghu1);
					message_button.setBackgroundResource(R.drawable.bottom_button_xiaoxi2);
					member_button.setBackgroundResource(R.drawable.bottom_button_wode2);
				}
			}
		});
		message_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(getSupportFragmentManager().findFragmentByTag(MESSAGETAG) == null){
					if(mess_frag == null){
						mess_frag = new MessageFrag();
					}
					FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
					ft.replace(R.id.container, mess_frag, MESSAGETAG);
//					ft.addToBackStack(MYSHOPTAG);
					ft.commit();
					
					myshop_button.setBackgroundResource(R.drawable.bottom_button_shanghu2);
					message_button.setBackgroundResource(R.drawable.bottom_button_xiaoxi1);
					member_button.setBackgroundResource(R.drawable.bottom_button_wode2);
				}
			}
		});
		member_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(getSupportFragmentManager().findFragmentByTag(MEMBERTAG) == null){
					if(mem_frag == null){
						mem_frag = new MemberFrag();
					}
					FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
					ft.replace(R.id.container, mem_frag, MEMBERTAG);
//					ft.addToBackStack(MYSHOPTAG);
					ft.commit();
					
					myshop_button.setBackgroundResource(R.drawable.bottom_button_shanghu2);
					message_button.setBackgroundResource(R.drawable.bottom_button_xiaoxi2);
					member_button.setBackgroundResource(R.drawable.bottom_button_wode1);
				}
			}
		});
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
	
}
