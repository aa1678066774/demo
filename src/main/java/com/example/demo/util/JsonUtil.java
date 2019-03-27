package com.example.demo.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

public class JsonUtil {
	/**
	 * object转json字符窜
	 * @param obj
	 * @return
	 */
	public static String ObjectToJsonStr(Object obj) {
		if(obj!=null) {
			Gson gson = new Gson();
			return gson.toJson(obj);
		}
		return "";    
	}
	/**
	 * json字符窜转object
	 * @param str
	 * @param c
	 * @return
	 */
	public static <T> T JsonStrToObject(String str,Class<T> c) {
		if(StringUtil.isNotEmpty(str)) {
			Gson gson = new Gson();
			return gson.fromJson(str, c);
		}
		return null;    
	}
	
	/**
	 * Object转Map
	 * @param obj
	 * @return
	 */
	public static Map<?, ?> objectToMap(Object obj) {  
        if(obj == null)  
            return null;   
  
        return new BeanMap(obj);  
    }
	
	/**
	 * Map转Object
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {    
        if (map == null)  
            return null;  
        Object obj = beanClass.newInstance();  
        BeanUtils.populate(obj, map);  
        return obj;  
    } 
	
	public static void main(String[] args) {
		Map<String, Object> map=new HashMap<String,Object>();
		 map.put("name", "123");
		 map.put("bir", new Date());
		System.out.println(ObjectToJsonStr(map)); 
	}
}
