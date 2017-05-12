package pers.guanzf.technology.websocket.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import pers.guanzf.technology.websocket.handle.WSocketHandler;
import pers.guanzf.technology.websocket.interceptor.WSocketInterceptor;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class WSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer
{
	private static final Log logger = LogFactory.getLog(WSocketConfig.class);

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
	{
		registry.addHandler(chatHandler(), "/websck/{label}/{id}").addInterceptors(new WSocketInterceptor());
		registry.addHandler(chatHandler(), "/sockjs/websck/{label}/{id}").addInterceptors(new WSocketInterceptor()).setAllowedOrigins().withSockJS();
		logger.info("web socket registry success............................................................");
	}

	@Bean
	public WSocketHandler chatHandler()
	{
		return new WSocketHandler();
	}
}
