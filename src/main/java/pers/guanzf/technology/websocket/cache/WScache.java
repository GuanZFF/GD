package pers.guanzf.technology.websocket.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.socket.WebSocketSession;

public class WScache {

	private static final Map<String, Map<String, WebSocketSession>> accountSessionMap = new HashMap<String, Map<String, WebSocketSession>>();

	/**
	 * websocket连接成功
	 */
	public static void connect(String id, String ip, WebSocketSession session) {
		if (accountSessionMap.containsKey(id)) {
			accountSessionMap.get(id).put(ip, session);
		} else {
			Map<String, WebSocketSession> map = new HashMap<String, WebSocketSession>();
			map.put(ip, session);
			accountSessionMap.put(id, map);
		}
	}

	/**
	 * webservice关闭连接
	 */
	public static void disconnect(String id, String ip) {
		if (accountSessionMap.containsKey(id)) {
			accountSessionMap.get(id).remove(ip);
		}
	}

	/**
	 * 获取账号和IP对应的session
	 */
	public static WebSocketSession getWebSocketSession(String id, String ip) {
		if (accountSessionMap.containsKey(id)) {
			return accountSessionMap.get(id).get(ip);
		}
		return null;
	}

	/**
	 * 获取账号对应的session
	 */
	public static Map<String, WebSocketSession> getWebSocketSessionByKey(String key) {
		return accountSessionMap.get(key);
	}

	/**
	 * 获取账号对应的session
	 */
	public static Map<String, Map<String, WebSocketSession>> getWebSocketSessionLikeKey(String key) {
		Map<String, Map<String, WebSocketSession>> asMap = null;
		for (String _key : accountSessionMap.keySet()) {
			if (_key.contains(key)) {
				if (null == asMap) {
					asMap = new HashMap<String, Map<String, WebSocketSession>>();
				}
				asMap.put(_key, accountSessionMap.get(_key));
			}
		}
		return asMap;
	}

	/**
	 * 获取IP获取对应的session
	 */
	public static Map<String, WebSocketSession> getWebSocketSessionsByIP(String ip) {
		Map<String, WebSocketSession> ipMap = null;
		Iterator<String> it = accountSessionMap.keySet().iterator();
		while (it.hasNext()) {
			String account = it.next().toString();
			Map<String, WebSocketSession> map = accountSessionMap.get(account);
			if (null != map) {
				Iterator<String> itip = map.keySet().iterator();
				while (itip.hasNext()) {
					String _ip = it.next().toString();
					if (ip.equals(_ip)) {
						if (null == ipMap) {
							ipMap = new HashMap<String, WebSocketSession>();
						}

						ipMap.put(account, map.get(_ip));
					}
				}
			}
		}
		return ipMap;
	}
}
