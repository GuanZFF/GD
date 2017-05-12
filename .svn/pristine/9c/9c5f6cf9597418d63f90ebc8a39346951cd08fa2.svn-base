package pers.guanzf.technology.websocket.interceptor;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import pers.guanzf.common.constants.Constants;

@Component
public class WSocketInterceptor extends HttpSessionHandshakeInterceptor
{
	private static final Log logger = LogFactory.getLog(WSocketInterceptor.class);

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception
	{
		if (request.getHeaders().containsKey("Sec-WebSocket-Extensions"))
		{
			request.getHeaders().set("Sec-WebSocket-Extensions", "permessage-deflate");
		}
		
		URI uri =request.getURI();
		String path = uri.getPath();
		String[] arr = path.split("[/]");
		if (null != arr && 4 == arr.length)
		{
			attributes.put(Constants.WS.LABEL, arr[2]);
			attributes.put(Constants.WS.ID, arr[3]);
		}
		
		String remoteIp = request.getRemoteAddress().getHostString();
		attributes.put(Constants.WS.IP, remoteIp);
		
		//用户名在登录的时候放入
		//attributes.put(Constants.WS.USERNAME, "abc");
		
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}
	
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex)
	{
		logger.info("After Handshake");
		
		super.afterHandshake(request, response, wsHandler, ex);
	}
}
