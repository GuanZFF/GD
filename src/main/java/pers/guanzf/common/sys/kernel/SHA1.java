package pers.guanzf.common.sys.kernel;

import java.nio.charset.Charset;
import java.security.MessageDigest;

import org.apache.log4j.Logger;

public class SHA1 {
	
	private static final Logger LOGGER = Logger.getLogger(SHA1.class);

	public static String getFingerprint(String str) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("sha-1");
			byte[] b = digest.digest(str.getBytes(Charset.forName("UTF-8")));
			StringBuffer sb = new StringBuffer();
			for (byte c : b) {
				String code = Integer.toHexString(c & 0xff);
				if (code.length() == 1) {
					code = "0" + code;
				}
				sb.append(code);
			}
			return sb.toString();
		} catch (Exception ex) {
			LOGGER.info("加密过程出现异常");
			ex.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getFingerprint("guanzf"));
	}
}
