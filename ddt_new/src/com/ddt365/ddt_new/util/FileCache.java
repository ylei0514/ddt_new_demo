package com.ddt365.ddt_new.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;

public class FileCache {
private File cacheDir;
	
	/**
	 * @param context
	 */
	public FileCache(Context context) {
		//判断sd卡是否存在
		if(android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
			//创建自己的缓存文件夹
			cacheDir = new File(android.os.Environment.getExternalStorageDirectory(), "ddtCache");
		} else {
			//使用系统的缓存文件夹
			cacheDir = context.getCacheDir();
		}
		if(!cacheDir.exists()) {
			//如果文件夹不存在，就创建
			cacheDir.mkdir();
		}
	}
	
	/**
	 * @param url
	 * @param bitmap
	 */
	//添加缓存文件
	public void addToFileCache(String url, InputStream inputStream) {
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(getFromFileCache(url));
			copyStream(inputStream, outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//从缓存中获取文件
	public File getFromFileCache(String url) {
		String fileName = urlToFileName(url);
		File file = new File(cacheDir, fileName);
		return file;
	}
	
//	public String getFileCreateTime(String url){
//		File file = getFromFileCache(url);
//		long create_time = file.lastModified();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String time = sdf.format(new Date(create_time));
//		return time;
//	}
	
	/**
	 * 清空文件缓存
	 */
	public void clearCache() {
		File[] files=cacheDir.listFiles();
      if(files==null)
          return;
      for(File f:files)
          f.delete();
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	//将url作为文件名
	private String urlToFileName(String url) {
		return String.valueOf(url.hashCode());
	}
	
	//复制流，将输入流中数据，复制到输出流中
	private void copyStream(InputStream is, OutputStream os){
      final int buffer_size=1024;
      try
      {
          byte[] bytes=new byte[buffer_size];
          for(;;)
          {
            int count=is.read(bytes, 0, buffer_size);
            if(count==-1)
                break;
            os.write(bytes, 0, count);
          }
      }
      catch(Exception ex){}
  }
}
