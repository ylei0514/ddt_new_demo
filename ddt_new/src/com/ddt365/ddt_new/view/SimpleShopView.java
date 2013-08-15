package com.ddt365.ddt_new.view;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ddt365.ddt_new.R;
import com.ddt365.ddt_new.mode.SimpleShopMode;

public class SimpleShopView extends LinearLayout{

	private LinearLayout ll;
	private Context context;
	private ImageView m_fore_back;
	private ImageView m_pic;
	private ImageView ygz_image;
	private TextView v;
	private TextView b_name;
	private TextView b_district;
	private TextView ygz_text;
	
	public SimpleShopView(Context context){
		super(context);
		this.context = context;
	}
	
	public SimpleShopView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		ll = (LinearLayout)LayoutInflater.from(context).inflate(R.layout.simple_shop_linear, null, false);
		
		m_fore_back = (ImageView)ll.findViewById(R.id.simple_shop_linear_pic_back);
		m_pic = (ImageView)ll.findViewById(R.id.simple_shop_linear_pic);
		ygz_image = (ImageView)ll.findViewById(R.id.simple_shop_linear_gz_image);
		v = (TextView)ll.findViewById(R.id.simple_shop_linear_v);
		b_name = (TextView)ll.findViewById(R.id.simple_shop_linear_name);
		b_district = (TextView)ll.findViewById(R.id.simple_shop_linear_district);
		ygz_text = (TextView)ll.findViewById(R.id.simple_shop_linear_gz_text);
	}

	public void fillWithData(SimpleShopMode shop,boolean is_del){
		m_fore_back.setImageResource(is_del?R.drawable.shop_list_logo:R.drawable.shop_list_logo);
		String pic = shop.getB_pic();
		m_pic.setImageBitmap(getImageFromAssetsFile(pic.trim()));
		boolean is_validate = shop.isIs_validate();
		v.setVisibility(is_validate?View.VISIBLE:View.GONE); 
		ygz_image.setVisibility(shop.isHas_gz()?View.VISIBLE:View.GONE);
		ygz_text.setVisibility(shop.isHas_gz()?View.VISIBLE:View.GONE);
		b_name.setText(shop.getB_name());
		b_district.setText(shop.getDistrict());
	}
	
	private Bitmap getImageFromAssetsFile(String fileName)  
	  {  
	      Bitmap image = null;  
	      AssetManager am = getResources().getAssets();  
	      try  
	      {  
	          InputStream is = am.open(fileName);  
	          image = BitmapFactory.decodeStream(is);  
	          is.close();  
	      }  
	      catch (IOException e)  
	      {  
	          e.printStackTrace();  
	      }  
	      return image;  
	  }  
}
