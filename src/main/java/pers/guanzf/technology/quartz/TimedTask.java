package pers.guanzf.technology.quartz;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.springframework.util.CollectionUtils;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSON;

import pers.guanzf.common.constants.Constants;
import pers.guanzf.technology.websocket.cache.WScache;

public class TimedTask {

	public void test() {
		Map<String, Map<String, WebSocketSession>> map = WScache.getWebSocketSessionLikeKey(Constants.WS.TEST);
		if (CollectionUtils.isEmpty(map)) {
			return;
		}
		Set<String> ids = map.keySet();
		for (String id : ids) {
			Map<String, WebSocketSession> sessions = map.get(id);
			Set<String> ips = sessions.keySet();
			for (String ip : ips) {
				WebSocketSession session = sessions.get(ip);
				try {
					session.sendMessage(new TextMessage(JSON.toJSONString("-----------")));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
