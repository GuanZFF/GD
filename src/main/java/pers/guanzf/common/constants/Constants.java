package pers.guanzf.common.constants;

public final class Constants {

	// 图片上传路劲名称
	public interface Path {
		public final static String ABSOLUTE = "absolute";
		public final static String RELATIVE = "relative";
	}

	// websocket 常量
	public interface WS {
		public final static String USERNAME = "username";// 用户账户
		public final static String IP = "remote_ip";// 客户端ip
		public final static String LABEL = "label";// 连接标识
		public final static String ID = "identification";// 连接独立标识
		public final static String TEST = "test";
	}

}
