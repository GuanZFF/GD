package pers.guanzf.common.util;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class StringUtil {
	
	private static final Logger LOGGER = Logger.getLogger(StringUtil.class);

	/**
	 * 验证电话号码
	 */
	public static boolean verifyPhone(String phone) {
		String regex = "^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
		if (StringUtils.isEmpty(phone)) {
			LOGGER.info("Phone为空");
			return false;
		}
		return phone.matches(regex);
	}
	
	public static boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}
	
	public static boolean isNotEmpty(String str) {
		return !StringUtils.isEmpty(str);
	}
	
	public static boolean isBlank(String str) {
		if (StringUtils.isEmpty(str)) {
			return true;
		}
		str = str.trim();
		if (StringUtils.isEmpty(str)) {
			return true;
		}
		return false;
	}
	
	public static boolean isNotBlank(String str) {
		return !StringUtil.isBlank(str);
	}
	
	public static void main(String[] args) {
		System.out.println(StringUtil.isBlank(" "));
	}
	
	/**
	 * 验证IP地址 IP地址正确返回TRUE
	 */
	public static boolean verifyIpAddress(String ip) {
		if (StringUtils.isEmpty(ip)) {
			return false;
		}
		String regex = "^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\."
				+ "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\."
				+ "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\."
				+ "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$";
		return ip.matches(regex);
	}
	
	// 将汉字转换为全拼
	public static String getPingYin(String s)
	{
		char[] t1 = null;
		t1 = s.toCharArray();
		String[] t2 = new String[t1.length];
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();

		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		String t4 = "";
		int t0 = t1.length;
		try
		{
			for (int i = 0; i < t0; i++)
			{
				if (java.lang.Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+"))
				{
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					t4 += t2[0];
				}
				else
				{
					t4 += java.lang.Character.toString(t1[i]);
				}
			}
			return t4;
		}
		catch (BadHanyuPinyinOutputFormatCombination e1)
		{
			e1.printStackTrace();
		}
		return t4;
	}
}
