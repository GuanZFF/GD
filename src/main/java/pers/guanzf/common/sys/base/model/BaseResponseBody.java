package pers.guanzf.common.sys.base.model;

import java.util.Map;

public class BaseResponseBody {

	public int flag;

	public String message;

	public Map<String, Object> map;

	public BaseResponseBody(int flag, String message) {
		super();
		this.flag = flag;
		this.message = message;
	}

	public BaseResponseBody() {
		super();
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
