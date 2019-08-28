package com.example.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;

public class FileUtil {
	public static void main(String[] args) {
		System.out.println(getFileMD5("http://localhost:4051/file/1.jpg"));
		System.out.println(getFileMD5("http://localhost:4051/file/5.jpg"));
		
		System.out.println(getFileMD5("http://localhost:4051/file/a.txt"));
		System.out.println(getFileMD5("http://localhost:4051/file/b.txt"));
		List<String> list=Arrays.asList("1","2","3");
		int i=0;
		
		
	}
	
	
   public static String getFileMD5(String destUrl){
        MessageDigest digest = null;
        InputStream in = null;
        byte buffer[] = new byte[1024];
        int len;
        try{
            digest = MessageDigest.getInstance("MD5");
            in = getInputStream(destUrl);
            while ((len = in.read(buffer, 0, 1024)) != -1){
                digest.update(buffer, 0, len);
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }
   
   public static InputStream getInputStream(String destUrl) {
       InputStream inputStream = null;
       URLConnection urlConnection = null;
       URL url = null;
       try {
           url = new URL(destUrl);
           urlConnection = url.openConnection();
           inputStream = urlConnection.getInputStream();
       } catch (MalformedURLException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return inputStream;
   }
}
