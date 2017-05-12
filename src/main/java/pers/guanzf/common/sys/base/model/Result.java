package pers.guanzf.common.sys.base.model;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class Result
{
	private int flag;
	private String message;
	private Map<String, Object> resultMap = new HashMap<String, Object> ();
	
	public Result()
	{
	}
	
	public Result(int flag, String message)
	{
		this.flag = flag;
		this.message = message;
	}
	
	public Result(int flag, String message, Map<String, Object> resultMap) {
		this.flag = flag;
		this.message = message;
		this.resultMap = resultMap;
	}
	
	public int getFlag()
	{
		return flag;
	}
	public void setFlag(int flag)
	{
		this.flag = flag;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public Map getResultMap()
	{
		return resultMap;
	}
	@SuppressWarnings("unchecked")
	public void setResultMap(Map resultMap)
	{
		this.resultMap = resultMap;
	}
}
