package pers.guanzf.common.core.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import pers.guanzf.common.core.dao.UserMapper;
import pers.guanzf.common.core.model.User;
import pers.guanzf.common.core.model.UserExample;
import pers.guanzf.common.core.model.info.UserInfo;
import pers.guanzf.common.core.service.UserService;
import pers.guanzf.common.util.SpringContextHolder;
import pers.guanzf.common.util.StringUtil;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

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
		return userMapper.insertSelective(user);
	}

	@Override
	public List<String> getUserImg() {
		String userImg = SpringContextHolder.getAppConfig().getDefaultUserImageUrl();
		List<String> images = Arrays.asList(userImg.split(","));
		return images;
	}

}
