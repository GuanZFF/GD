package pers.guanzf.technology.websocket.handle;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


import pers.guanzf.common.constants.Constants;
import pers.guanzf.technology.websocket.cache.WScache;
import pers.guanzf.technology.websocket.model.WSSessionInfo;

@RequestMapping("websck")
public class WSocketHandler extends TextWebSocketHandler {
	private static final Log logger = LogFactory.getLog(WSocketHandler.class);

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String key = null;
		WSSessionInfo info = getSessionInfo(session);
		if (Constants.WS.TEST.equals(info.getLabel())) {
			if (!StringUtils.isEmpty(info.getId())) {
				key = info.getId();
				WScache.disconnect(info.getId(), info.getIp());
			}
		}
		logger.info("websocket connection closed......" + "key=" + key + " ip=" + info.getIp());
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String key = null;
		WSSessionInfo info = getSessionInfo(session);
		if (Constants.WS.TEST.equals(info.getLabel())) {
			if (!StringUtils.isEmpty(info.getId())) {
				key = info.getId();
				WScache.connect(info.getId(), info.getIp(), session);
			}
		}
		logger.info("connect to the websocket success......" + "key=" + key + " ip=" + info.getIp());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		/*if (null != message) {
			String msg = message.getPayload();
			Heartbeat ht = JSON.parseObject(msg, Heartbeat.class);
			if (null != ht && 1 == ht.getBeat()) {
				WSSessionInfo info = getSessionInfo(session);
				logger.info("websocket 心跳: IP=" + info.getIp() + " 用户账户=" + info.getAccount() + " 系统标识="
						+ info.getLabel() + " 区域标识=" + info.getId());
			}
		}*/
		super.handleTextMessage(session, message);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
		try {
			if (session.isOpen()) {
				WSSessionInfo info = getSessionInfo(session);
				if (Constants.WS.TEST.equals(info.getLabel())) {
					WScache.disconnect(info.getId(), info.getIp());
				}
				session.close();
			}
		} catch (Exception e) {
			logger.error("websocket连接异常,系统已经关闭连接。", throwable);
		}
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * @title: getIP @category: 获取客户端IP @param: @param session @param: @return @return: String @throws
	 */
	private WSSessionInfo getSessionInfo(WebSocketSession session) {
		WSSessionInfo info = new WSSessionInfo();
		info.setAccount((String) session.getAttributes().get(Constants.WS.USERNAME));
		info.setIp((String) session.getAttributes().get(Constants.WS.IP));
		info.setId((String) session.getAttributes().get(Constants.WS.ID));
		info.setLabel((String) session.getAttributes().get(Constants.WS.LABEL));
		return info;
	}
	
}
