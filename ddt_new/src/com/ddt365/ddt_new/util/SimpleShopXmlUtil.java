package com.ddt365.ddt_new.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;

import com.ddt365.ddt_new.R;
import com.ddt365.ddt_new.mode.SimpleShopMode;

public class SimpleShopXmlUtil {
	public static final String xml_path = "xml/";
	
	public List<SimpleShopMode> pullParseXML(Context context) {

		List<SimpleShopMode> list = null;
		SimpleShopMode shop = null;

//		try {
//			XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
//			pullParserFactory.setNamespaceAware(true);
//			XmlPullParser xmlPullParser = pullParserFactory.newPullParser();
			
//			String file_name = "simpleshop.xml";
			
			Resources res = context.getResources(); 
			XmlResourceParser xrp = res.getXml(R.xml.simpleshop);
			
			try {
				while (xrp.getEventType() != XmlResourceParser.END_DOCUMENT) {
					String nodeName = xrp.getName();
					switch (xrp.getEventType()) {
					case XmlResourceParser.START_DOCUMENT:
						list = new ArrayList<SimpleShopMode>();
						break;
					case XmlResourceParser.START_TAG:
						if ("shop".equals(nodeName)) {
							shop = new SimpleShopMode();
						} else if ("bname".equals(nodeName)) {
							shop.setB_name(xrp.nextText());
						} else if ("district".equals(nodeName)) {
							shop.setDistrict(xrp.nextText());
						} else if ("pic".equals(nodeName)) {
							shop.setB_pic(xrp.nextText());
						} else if ("validate".equals(nodeName)) {
							shop.setIs_validate(xrp.nextText().equals("Y")?true:false);
						} else if ("bid".equals(nodeName)) {
							shop.setBid(xrp.nextText());
						}
						break;
					case XmlResourceParser.END_TAG:
						if ("shop".equals(nodeName)) {
							list.add(shop);
							shop = null;
						}
						break;
					default:
						break;
					}
					xrp.next();
				}
			}catch (XmlPullParserException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
//			FileReader f = null;
//			try {
//				f = new FileReader(xml_path+file_name);
//			} catch (FileNotFoundException e1) {
//				e1.printStackTrace();
//				return null;
//			}
//			xmlPullParser.setInput(f);
//			int eventType = xmlPullParser.getEventType();
//			try {
//				while (eventType != XmlPullParser.END_DOCUMENT) {
//					String nodeName = xmlPullParser.getName();
//					switch (eventType) {
//					case XmlPullParser.START_DOCUMENT:
//						list = new ArrayList<SimpleShopMode>();
//						break;
//					case XmlPullParser.START_TAG:
//						if ("shop".equals(nodeName)) {
//							shop = new SimpleShopMode();
//						} else if ("bname".equals(nodeName)) {
//							shop.setB_name(xmlPullParser.nextText());
//						} else if ("district".equals(nodeName)) {
//							shop.setDistrict(xmlPullParser.nextText());
//						} else if ("pic".equals(nodeName)) {
//							shop.setB_pic(xmlPullParser.nextText());
//						} else if ("validate".equals(nodeName)) {
//							shop.setIs_validate(xmlPullParser.nextText().equals("Y")?true:false);
//						} else if ("bid".equals(nodeName)) {
//							shop.setBid(xmlPullParser.nextText());
//						}
//						break;
//					case XmlPullParser.END_TAG:
//						if ("shop".equals(nodeName)) {
//							list.add(shop);
//							shop = null;
//						}
//						break;
//					default:
//						break;
//					}
//					eventType = xmlPullParser.next();
//				}
//			} catch (NumberFormatException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} catch (XmlPullParserException e) {
//			e.printStackTrace();
//		}
			
		
		return list;
	}
	
	/*public void creatXml(List<Student> list) {
		XmlPullParserFactory pullParserFactory;
		try {
			File file = new File("src/xml/mystudent.xml");
			FileOutputStream outputStream = null;
			OutputStreamWriter writer = null;
			outputStream = new FileOutputStream(file);
			writer = new OutputStreamWriter(outputStream, "UTF-8");
			BufferedWriter writer2 = new BufferedWriter(writer);// 增加的缓存功能
			
			pullParserFactory = XmlPullParserFactory.newInstance();

			pullParserFactory.setNamespaceAware(true);
			XmlSerializer xs = pullParserFactory.newSerializer();
			xs.setOutput(writer2);
			xs.setOutput(outputStream, "UTF-8");
			xs.startDocument("utf-8", true);
			xs.startTag(null, "root");
			for(Student s:list){
				xs.startTag(null, "student");
				xs.attribute(null, "id", Integer.toString(s.getId()));
				xs.attribute(null, "group", Integer.toString(s.getGroup()));
				xs.startTag(null, "name");
				xs.text(s.getName());
				xs.endTag(null, "name");
				xs.startTag(null, "sex");
				xs.text(s.getSex());
				xs.endTag(null, "sex");
				xs.startTag(null, "age");
				xs.text(Integer.toString(s.getAge()));
				xs.endTag(null, "age");
				xs.startTag(null, "email");
				xs.text(s.getEmail());
				xs.endTag(null, "email");
				xs.startTag(null, "birthday");
				xs.text(s.getBirthday());
				xs.endTag(null, "birthday");
				xs.startTag(null, "memo");
				xs.text(s.getMemo());
				xs.endTag(null, "memo");
				xs.endTag(null, "student");
			}
			xs.endTag(null, "root");
			xs.endDocument();
			outputStream.close();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}*/
}
