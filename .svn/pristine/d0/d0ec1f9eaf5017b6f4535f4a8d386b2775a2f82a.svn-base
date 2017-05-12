var WSocket = {
	"websocketUrl" : "/websck/",
	"socketJsUrl" : "/sockjs/websck",
	"timeout": 60000,
	"timer": null,


	/**
	 * websocket connect
	 * @param type 连接类型 sockjs or websocket
	 * @param openFn  打开连接时回调函数
	 * @param messageFn 收到消息时的回调函数
	 * @param closeFn 关闭连接时的回调函数
	 * @returns websocket对象
	 */
	"connect" : function(type, label, id, openFn, messageFn, closeFn) {
		var url = null;
		var ws = null;
		if (type == "sockjs") {
			url = contextPath + WSocket.socketJsUrl;
			ws = new SockJS(url);
		} else {
			if (window.location.protocol == 'http:') {
				url = 'ws://' + window.location.host + WSocket.websocketUrl + label + "/" + id;
			} else {
				url = 'wss://' + window.location.host + WSocket.websocketUrl + label + "/" + id;
			}
//			ws = new WebSocket(url);
			ws =  new ReconnectingWebSocket(url, null, {debug: true, reconnectInterval: 4000});
		}
		//websocket的四个基本方法
		ws.onopen = function(){
			if (null != WSocket.timer){
				clearInterval(WSocket.timer);    
			}
			WSocket.timer =setInterval(function(){WSocket.heartbeat(ws)}, WSocket.timeout);
			openFn;
		};
		ws.onmessage = function(event) {
			var data = jQuery.parseJSON(event.data);
			messageFn(data);
		};
		ws.onerror = function () {
			//WSocket.reconnect(ws);
		};
		ws.onclose = function () {
			//WSocket.reconnect(ws);
			closeFn;
		};
		return ws;
	},

	/**
	 * 关闭连接
	 * @param ws
	 */
	"disconnect" : function(ws) {
		if (ws != null) {
			ws.close();
		}
	},
	/**
	 * 发送消息给服务器
	 * @param ws
	 * @param message
	 * @returns {Boolean}
	 */
	"send" : function(ws, message) {
		if (ws == null) {
			alert("还未连接成功，不能发送消息");
			return false;
		}
		ws.send(message);
	},
	"heartbeat" : function(ws) {
		if (null != ws && ws.readyState == 1){
			ws.send('{"beat": 1}');
		}
	},
	"reset" : function() {
		WSocket.heartbeat();
	},
	"end" : null
};
