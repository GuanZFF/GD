package pers.guanzf.common.sys.kernel;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import pers.guanzf.common.util.StringUtil;

public class SendMessageVerify {

	private static final Logger LOGGER = Logger.getLogger(SendMessageVerify.class);

	// 互亿验证码发送
	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

	public static int sendIdentifyingCode(String phone) {
		if (!StringUtil.verifyPhone(phone)) {
			return -2;
		}
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=GBK");

		int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);

		String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");

		NameValuePair[] data = { // 发送数据
				new NameValuePair("account", "C07965583"), // 账号名
				new NameValuePair("password", "2ce88a86bf6aca7c58e1eb0963726969"), // 动态命令
				new NameValuePair("mobile", phone), // 接收验证码的手机号码
				new NameValuePair("content", content),// 发送的内容
		};

		method.setRequestBody(data);
		int result = 0;
		try {
			client.executeMethod(method);
			String SubmitResult = method.getResponseBodyAsString();

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			String code = root.elementText("code");
			// String msg = root.elementText("msg");
			// String smsid = root.elementText("smsid");
			// System.out.println(code);
			// System.out.println(msg);
			// System.out.println(smsid);

			if ("2".equals(code)) {
				result = 1;
				LOGGER.info("短信发送成功");
			}
		} catch (Exception ex) {
			LOGGER.info("短信验证时出现错误");
			ex.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		SendMessageVerify.sendIdentifyingCode("18255408516");
	}
}
