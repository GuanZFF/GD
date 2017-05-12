package pers.guanzf.common.sys.base.model;

import java.io.Serializable;

/**
 * @author GZFeng
 *
 * @param <T>
 * 
 * @see 请求的基础数据任何的数据都需要被此对象包装
 */
public class BaseRequest<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8472695274624905215L;

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
