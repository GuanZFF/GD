package pers.guanzf.common.core.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import pers.guanzf.common.core.dao.FriendMapper;
import pers.guanzf.common.core.dao.MessageManageMapper;
import pers.guanzf.common.core.dao.PersonMapper;
import pers.guanzf.common.core.dao.PersonProduceMapper;
import pers.guanzf.common.core.dao.ProduceMapper;
import pers.guanzf.common.core.dao.UserMapper;
import pers.guanzf.common.core.model.BuyRecord;
import pers.guanzf.common.core.model.FriendExample;
import pers.guanzf.common.core.model.MessageManage;
import pers.guanzf.common.core.model.MessageManageExample;
import pers.guanzf.common.core.model.PersonProduceExample;
import pers.guanzf.common.core.model.User;
import pers.guanzf.common.core.model.UserExample;
import pers.guanzf.common.core.model.info.FriendInfo;
import pers.guanzf.common.core.model.info.MessageManageInfo;
import pers.guanzf.common.core.model.info.PersonInfo;
import pers.guanzf.common.core.model.info.PersonProduceInfo;
import pers.guanzf.common.core.model.info.ProduceInfo;
import pers.guanzf.common.core.model.info.UserInfo;
import pers.guanzf.common.core.service.PersonService;
import pers.guanzf.common.core.service.UserService;
import pers.guanzf.common.util.DateUtil;
import pers.guanzf.common.util.SpringContextHolder;
import pers.guanzf.common.util.StringUtil;
import pers.guanzf.common.util.UUIDUtil;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonProduceMapper personProduceMapper;
	
	@Autowired
	private ProduceMapper produceMapper;
	
	@Autowired
	private MessageManageMapper messageManageMapper;

	@Autowired
	private FriendMapper friendMapper;
	
	@Autowired
	private PersonMapper personMapper;
	
	@Override
	public UserInfo getUserByName(String name) {
		if (StringUtil.isBlank(name)) {
			return null;
		}
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(name);
		List<UserInfo> users = userMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(users)) {
			LOGGER.info("用户不存在");
			return null;
		}
		return users.get(0);
	}
	
	@Override
	public int addUser(UserInfo user) {
		if (ObjectUtils.isEmpty(user)) {
			return -2;
		}
		/* 插入person信息 */
		String personId = UUIDUtil.randomID();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setPersonName(user.getUserName());
		personInfo.setPersonImage(user.getUserImg());
		personInfo.setPersonPassword(user.getUserPassword());
		personInfo.setPersonId(personId);
		int result = personService.insertPersonInfo(personInfo);
		if (result != 1) {
			LOGGER.info("插入person信息时失败");
		}
		user.setPersonId(personId);
		return userMapper.insertSelective(user);
	}

	@Override
	public List<String> getUserImg() {
		String userImg = SpringContextHolder.getAppConfig().getDefaultUserImageUrl();
		List<String> images = Arrays.asList(userImg.split(","));
		return images;
	}

	@Override
	public List<BuyRecord> listBuyRecord(String personId) {
		List<BuyRecord> result = new ArrayList<>();
		PersonProduceExample example = new PersonProduceExample();
		example.setOrderByClause("CREATE_TIME DESC limit 10");
		PersonProduceExample.Criteria criteria = example.createCriteria();
		criteria.andPersonIdEqualTo(personId);
		List<PersonProduceInfo> personProduceInfos = personProduceMapper.selectByExample(example);
		for (PersonProduceInfo personProduceInfo : personProduceInfos) {
			BuyRecord buyRecord = new BuyRecord();
			ProduceInfo produceInfo = produceMapper.selectByPrimaryKey(personProduceInfo.getProduceId());
			buyRecord.setBuyTime(DateUtil.getDateString(personProduceInfo.getCreateTime(), DateUtil.YYYY_MM_DD_HH_MM_SS));
			buyRecord.setProduceName(produceInfo.getProduceName());
			buyRecord.setProduceType(produceInfo.getProduceType());
			buyRecord.setProducePrice(String.valueOf(produceInfo.getProducePrice()));
			result.add(buyRecord);
		}
		return result;
	}

	@Override
	public List<MessageManageInfo> listMyMessage(String personId) {
		if (StringUtil.isEmpty(personId)) {
			return null;
		}
		MessageManageExample example = new MessageManageExample();
		example.setOrderByClause("MESSAGE_DATE DESC LIMIT 15");
		MessageManageExample.Criteria criteria = example.createCriteria();
		criteria.andMessagePersonIdEqualTo(personId);
		criteria.andMessageDisableEqualTo("1");
		List<MessageManageInfo> result =  messageManageMapper.selectByExample(example);
		for (MessageManageInfo messageManageInfo : result) {
			ProduceInfo produceInfo = produceMapper.selectByPrimaryKey(messageManageInfo.getMessageProduceId());
			messageManageInfo.setProduceInfo(produceInfo);
		}
		return result;
	}

	@Override
	public int insertMessage(MessageManageInfo messageManageInfo) {
		return messageManageMapper.insertSelective(messageManageInfo);
	}

	@Override
	public List<PersonInfo> listMyFriend(String personId) {
		List<PersonInfo> friends = new ArrayList<>();
		FriendExample example = new FriendExample();
		example.setOrderByClause("FRIEND_CREATE_TIME DESC");
		FriendExample.Criteria criteria = example.createCriteria();
		criteria.andFriendMyIdEqualTo(personId);
		List<FriendInfo> friendInfos = friendMapper.selectByExample(example);
		for (FriendInfo friendInfo : friendInfos) {
			PersonInfo personInfo = personMapper.selectByPrimaryKey(friendInfo.getFriendFriendId());
			friends.add(personInfo);
		}
		return friends;
	}

	@Override
	public int insertMyFriend(FriendInfo friendInfo) {
		List<PersonProduceInfo> my = getPersonProduceInfo(friendInfo.getFriendMyId());
		List<PersonProduceInfo> friend = getPersonProduceInfo(friendInfo.getFriendFriendId());
		int total = my.size() > friend.size() ? my.size() : friend.size();
		int same = 0;
		for (PersonProduceInfo personProduceInfo : friend) {
			String produceId = personProduceInfo.getProduceId();
			for (PersonProduceInfo personProduceInfo2 : my) {
				if (produceId.equals(personProduceInfo2.getProduceId())) {
					same ++;
				}
			}
		}
		float sim = 0;
		if (same != 0) {
			sim = same / total;
		}
		friendInfo.setFriendSimilarityDegree(sim);
		return friendMapper.insertSelective(friendInfo);
	}
	
	public List<PersonProduceInfo> getPersonProduceInfo(String personId) {
		PersonProduceExample example = new PersonProduceExample();
		PersonProduceExample.Criteria criteria = example.createCriteria();
		criteria.andPersonIdEqualTo(personId);
		return personProduceMapper.selectByExample(example);
	}

	@Override
	public FriendInfo getFriend(String personId, String friendId) {
		FriendExample example = new FriendExample();
		FriendExample.Criteria criteria = example.createCriteria();
		criteria.andFriendIdEqualTo(personId);
		criteria.andFriendFriendIdEqualTo(friendId);
		List<FriendInfo> friendInfos = friendMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(friendInfos)) {
			return null;
		}
		return friendInfos.get(0);
	}

	@Override
	public int updateUserInfo(UserInfo userInfo) {
		return userMapper.updateByPrimaryKeySelective(userInfo);
	}
	

}
