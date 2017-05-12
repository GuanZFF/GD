package pers.guanzf.common.util;

import org.springframework.context.ApplicationContext;

import pers.guanzf.common.constants.AppConfig;

public class SpringUtil {

	private static ApplicationContext applicationContext = null;
	
	public static AppConfig getAppConfig() {
		return getBean(AppConfig.class);
	}
	
	public static <T> T getBean(Class<T> requiredType)
	{
		assertContextInjected();
		return applicationContext.getBean(requiredType);
	}
	
	private static void assertContextInjected()
	{
//		Validate.validState(applicationContext != null, "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
	}
}
