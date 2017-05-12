package pers.guanzf.test;

import java.security.MessageDigest;

public class MD5Test {

	public static void main(String[] args) throws Exception{
		MessageDigest digest = MessageDigest.getInstance("MD5");
		byte[] code = digest.digest("a".getBytes());
		StringBuffer sb = new StringBuffer();
		for (byte b : code) {
			String s = Integer.toHexString(b & 0xff);
			if (s.length() == 1) {
				s = "0" + s;
			}
			sb = sb.append(s);
		}
		System.out.println(sb.toString());
	}
	
}
