package com.ddt365.ddt_new.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ddt365.ddt_new.DdtNewApplication;
import com.ddt365.ddt_new.R;
import com.ddt365.ddt_new.mode.SimpleShopMode;
import com.ddt365.ddt_new.util.Constant;
import com.ddt365.ddt_new.util.SimpleShopXmlUtil;
import com.ddt365.ddt_new.view.SimpleShopView;

public class MyShopFrag extends Fragment {

	private List<SimpleShopMode> m_list;
	private boolean has_gz;
	
	private Button add_but;
	
	// 添加商户页面
	private LinearLayout no_followed_linear;
	private ViewPager m_vpager;
	private ImageView dot01;
	private ImageView dot02;
	private ImageView dot03;
	
	private List<View> views;
	
	// 已有关注商户页面
	private LinearLayout has_followed_linear;
	private GridView gv;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		SharedPreferences pref = DdtNewApplication.getShare(getActivity());
		has_gz = pref.getBoolean(Constant.HAS_FOLLOWED, false);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout v = (LinearLayout) inflater.inflate(
				R.layout.shop_activity, container, false);
		
		add_but = (Button)v.findViewById(R.id.shop_add_add_button);
		add_but.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View paramView) {
				Toast.makeText(getActivity(), "chenggong", Toast.LENGTH_SHORT).show();
			}
		});
		
		no_followed_linear = (LinearLayout)v.findViewById(R.id.shop_add_noshop_linear);
		has_followed_linear = (LinearLayout)v.findViewById(R.id.shop_add_hasshop_linear);
		
		no_followed_linear.setVisibility(has_gz?View.GONE:View.VISIBLE);
		has_followed_linear.setVisibility(has_gz?View.VISIBLE:View.GONE);
		
		m_list = getShopList();
		
		if(has_gz){
			gv = (GridView)v.findViewById(R.id.shop_add_hasshop_grid);
			gv.setAdapter(new GridAdapter());
			
		}else{
			m_vpager = (ViewPager)v.findViewById(R.id.shop_add_viewpager);
			dot01 = (ImageView)v.findViewById(R.id.shop_add_dot01);
			dot02 = (ImageView)v.findViewById(R.id.shop_add_dot02);
			dot03 = (ImageView)v.findViewById(R.id.shop_add_dot03);
			setDot(0);
			
			views = getViews(inflater);
			
			m_vpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
				
				@Override
				public void onPageSelected(int arg0) {
					setDot(arg0);
				}
				
				@Override
				public void onPageScrolled(int arg0, float arg1, int arg2) {
					
				}
				
				@Override
				public void onPageScrollStateChanged(int arg0) {
					
				}
			});
			
			m_vpager.setAdapter(new PagerAdapter() {
				
				@Override
				public boolean isViewFromObject(View arg0, Object arg1) {
					return arg0==arg1;
				}
				
				@Override
				public int getCount() {
					return views.size();
				}

				@Override
				public Object instantiateItem(ViewGroup container, int position) {
					((ViewPager) container).addView(views.get(position), 0);
					return views.get(position);
				}

				@Override
				public void destroyItem(ViewGroup container, int position,
						Object object) {
					((ViewPager) container).removeView(views.get(position));
				}
				
			});
		}
		
		return v;
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	private List<View> getViews(LayoutInflater inflater){
		List<View> list = new ArrayList<View>();
		int count = 0;
		for(int i = 0 ; i < 3 ; i++){
			View view01 = inflater.inflate(R.layout.simple_shop_item, null);
			SimpleShopView v1 = (SimpleShopView)view01.findViewById(R.id.simple_shop_item_shop01);
			SimpleShopView v2 = (SimpleShopView)view01.findViewById(R.id.simple_shop_item_shop02);
			SimpleShopView v3 = (SimpleShopView)view01.findViewById(R.id.simple_shop_item_shop03);
			
			v1.fillWithData(m_list.get(count++), false);
			v2.fillWithData(m_list.get(count++), false);
			v3.fillWithData(m_list.get(count++), false);
			list.add(view01);
		}
		 return list;
	}
	
	private List<SimpleShopMode> getShopList(){
		SimpleShopXmlUtil ssxu = new SimpleShopXmlUtil();
		List<SimpleShopMode> list = ssxu.pullParseXML(this.getActivity());
		return list;
	}

	public void setDot(int arg0){
		dot01.setImageResource(arg0==0?R.drawable.shop_slide_on:R.drawable.shop_slide_off);
		dot02.setImageResource(arg0==1?R.drawable.shop_slide_on:R.drawable.shop_slide_off);
		dot03.setImageResource(arg0==2?R.drawable.shop_slide_on:R.drawable.shop_slide_off);
	}
	
	private class GridAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return m_list.size();
		}

		@Override
		public Object getItem(int paramInt) {
			return m_list.get(paramInt);
		}

		@Override
		public long getItemId(int paramInt) {
			return paramInt;
		}

		@Override
		public View getView(int paramInt, View paramView,
				ViewGroup paramViewGroup) {
			Object o = getItem(paramInt);
			
			View view = paramViewGroup;
			
			if(o instanceof SimpleShopMode){
				if(view == null || !(view instanceof SimpleShopView)){
					view = new SimpleShopView(getActivity());
				}
				((SimpleShopView)view).fillWithData((SimpleShopMode)o,false);
			}
			return view;
		}
	}
}
