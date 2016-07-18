package com.techpark.cm.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5辅助工具类
 * @author GJ
 *
 */
public class MD5Util {

	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	
	public static String encode(String text) {
		MessageDigest msgDigest = null;
		
		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}
		
		try {
			msgDigest.update(text.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("System doesn't support your EncodingException.");
		}
		
		byte[] bytes = msgDigest.digest();
		String md5Str = new String(encodeHex(bytes));
		return md5Str;
	}
	
	public static char[] encodeHex(byte[] data) {
		int l = data.length;
		char[] out = new char[l << 1];
		for(int i = 0, j = 0; i < l; i++)
		{
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}
		return out;
	}
}
