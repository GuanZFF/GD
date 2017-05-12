package pers.guanzf.common.sys.base.model;

import java.io.Serializable;

/**
 * @author GZFeng
 *
 * @param <T>
 * 
 * @see 响应基础数据
 */
public class BaseResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6516718429330906182L;

	private T data;

	private int code = 1;

	private String message = "操作成功";

	private String errorMessage = "";

	public BaseResponse() {

	}

	public BaseResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public BaseResponse(int code, String message, String errorMessage) {
		super();
		this.code = code;
		this.message = message;
		this.errorMessage = errorMessage;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
