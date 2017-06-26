package pers.guanzf.common.core.service;

import java.util.List;

import pers.guanzf.common.core.model.BuyRecord;
import pers.guanzf.common.core.model.MessageManage;
import pers.guanzf.common.core.model.info.FriendInfo;
import pers.guanzf.common.core.model.info.MessageManageInfo;
import pers.guanzf.common.core.model.info.PersonInfo;
import pers.guanzf.common.core.model.info.UserInfo;

public interface UserService {

	public UserInfo getUserByName(String name);

	public int addUser(UserInfo user);
	
	public List<String> getUserImg();
	
	public List<BuyRecord> listBuyRecord(String personId);
	
	public List<MessageManageInfo> listMyMessage(String personId);
	
	public int insertMessage(MessageManageInfo messageManageInfo);
	
	public List<PersonInfo> listMyFriend(String personId);
	
	public int insertMyFriend(FriendInfo friendInfo);
	
	public FriendInfo getFriend(String personId, String friendId);
	
	public int updateUserInfo(UserInfo userInfo);
	
}
