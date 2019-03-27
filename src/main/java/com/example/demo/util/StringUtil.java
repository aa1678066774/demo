package com.example.demo.util;

public class StringUtil {
	
	/**
	 * 字符窜比较
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean equals(String a, String b) {
        if (a == null) {
            return b == null;
        }
        return a.equals(b);
    }
	
	/**
	 * 忽略大小写字符窜比较
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean equalsIgnoreCase(String a, String b) {
        if (a == null) {
            return b == null;
        }
        return a.equalsIgnoreCase(b);
    }
	
	/**
	 * 字符串转Integer
     * @param in
     * @return
     */
    public static Integer stringToInteger(String in) {
        if (in == null) {
            return null;
        }
        in = in.trim();
        if (in.length() == 0) {
            return null;
        }
        
        try {
            return Integer.parseInt(in);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static boolean isEmpty(String str) {
		// TODO Auto-generated method stub
		return (str==null||"".equals(str))?true:false;
	}
	
	public static boolean isNotEmpty(String str) {
		// TODO Auto-generated method stub
		return !isEmpty(str);
	}
}
