package pers.guanzf.technology.quartz;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSON;

import pers.guanzf.common.constants.Constants;
import pers.guanzf.common.core.dao.ProduceMapper;
import pers.guanzf.common.core.model.ProduceExample;
import pers.guanzf.common.core.model.info.ProduceInfo;
import pers.guanzf.technology.websocket.cache.WScache;

public class TimedTask {
	
	private static final Logger LOGGER = Logger.getLogger(TimedTask.class);
	
	@Autowired
	private ProduceMapper produceMapper;

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
	
	public void clearProduceTodayData() {
		ProduceInfo produceInfo = new ProduceInfo();
		produceInfo.setProduceTodayNum(0);
		ProduceExample example = new ProduceExample();
		ProduceExample.Criteria criteria = example.createCriteria();
		criteria.andProduceTodayNumNotEqualTo(0);
		int result = produceMapper.updateByExampleSelective(produceInfo, example);
		if (result == 0) {
			LOGGER.info("没有需要更新的数据");
		}
	}
}
