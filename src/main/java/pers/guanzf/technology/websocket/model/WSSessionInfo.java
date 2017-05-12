package pers.guanzf.technology.websocket.model;

public class WSSessionInfo
{
	private String account;//用户账户
	private String ip;//对端pc的ip
	private String label;//系统标识
	private String id;//区域id
	
	public String getAccount()
	{
		return account;
	}
	public void setAccount(String account)
	{
		this.account = account;
	}
	public String getIp()
	{
		return ip;
	}
	public void setIp(String ip)
	{
		this.ip = ip;
	}
	public String getLabel()
	{
		return label;
	}
	public void setLabel(String label)
	{
		this.label = label;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
}
