package pers.guanzf.common.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import pers.guanzf.common.core.dao.FriendMapper;
import pers.guanzf.common.core.dao.PersonMapper;
import pers.guanzf.common.core.dao.PersonProduceMapper;
import pers.guanzf.common.core.dao.ProduceMapper;
import pers.guanzf.common.core.dao.UserMapper;
import pers.guanzf.common.core.model.FriendExample;
import pers.guanzf.common.core.model.Person;
import pers.guanzf.common.core.model.PersonExample;
import pers.guanzf.common.core.model.PersonProduce;
import pers.guanzf.common.core.model.PersonProduceExample;
import pers.guanzf.common.core.model.Produce;
import pers.guanzf.common.core.model.UserExample;
import pers.guanzf.common.core.model.info.PersonInfo;
import pers.guanzf.common.core.model.info.PersonProduceInfo;
import pers.guanzf.common.core.model.info.ProduceInfo;
import pers.guanzf.common.core.model.info.UserInfo;
import pers.guanzf.common.core.service.PersonService;
import pers.guanzf.common.util.StringUtil;
import pers.guanzf.common.util.UUIDUtil;

@Service
public class PersonServiceImpl implements PersonService {

	private static final Logger LOGGER = Logger.getLogger(PersonServiceImpl.class);

	@Autowired
	private PersonMapper personMapper;

	@Autowired
	private ProduceMapper produceMapper;

	@Autowired
	private PersonProduceMapper personProduceMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private FriendMapper friendMapper;
	
	@Override
	public PersonProduceInfo getProduceInfoByPersonId(String personId) {
		PersonProduceInfo result = new PersonProduceInfo();
		if (StringUtils.isEmpty(personId)) {
			LOGGER.info("PersonId为空值");
			return null;
		}
		Person person = personMapper.selectByPrimaryKey(personId);
		if (ObjectUtils.isEmpty(person)) {
			LOGGER.info("personId没有响应的数据信息" + personId);
			return null;
		}
		result.setPerson(person);
		/* 获取person对应的produce的详细信息 */
		List<Produce> produces = new ArrayList<>();
		PersonProduceExample example = new PersonProduceExample();
		PersonProduceExample.Criteria criteria = example.createCriteria();
		criteria.andPersonIdEqualTo(personId);
		List<PersonProduceInfo> personProduces = personProduceMapper.selectByExample(example);
		for (PersonProduce personProduce : personProduces) {
			if (!ObjectUtils.isEmpty(personProduce) && StringUtil.isNotBlank(personProduce.getProduceId())) {
				Produce produce = produceMapper.selectByPrimaryKey(personProduce.getProduceId());
				produces.add(produce);
			}
		}
		if (!CollectionUtils.isEmpty(produces)) {
			result.setProduce(produces);
		}
		return result;
	}

	@Override
	public PersonInfo getProduceInfoByUsername(String username) {
		PersonExample example = new PersonExample();
		PersonExample.Criteria criteria = example.createCriteria();
		criteria.andPersonNameEqualTo(username);
		List<PersonInfo> personInfos = personMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(personInfos)) {
			return null;
		}
		return personInfos.get(0);
	}

	@Override
	public int insertPersonInfo(PersonInfo personInfo) {
		if (ObjectUtils.isEmpty(personInfo)) {
			return 0;
		}
		if (StringUtil.isEmpty(personInfo.getPersonId())) {
			personInfo.setPersonId(UUIDUtil.randomID());
		}
		if (StringUtil.isNotEmpty(personInfo.getPersonName())) {
			personInfo.setPersonPingyinName(StringUtil.getPingYin(personInfo.getPersonName()));
		}
		return personMapper.insertSelective(personInfo);
	}

	@Override
	public int insertPersonProduceInfo(String personId, String produceId) {
		if (StringUtil.isEmpty(personId) || StringUtil.isEmpty(produceId)) {
			return 0;
		}
		PersonInfo personInfo = personMapper.selectByPrimaryKey(personId);
		ProduceInfo produceInfo = produceMapper.selectByPrimaryKey(produceId);
		PersonProduceInfo personProduceInfo = new PersonProduceInfo();
		personProduceInfo.setPersonId(personId);
		personProduceInfo.setProduceId(produceId);
		personProduceInfo.setPersonProduceId(UUIDUtil.randomID());
		return personProduceMapper.insertSelective(personProduceInfo);
	}
	
	@Override
	public List<PersonInfo> getNotPassRegPerson() {
		List<PersonInfo> result = new ArrayList<>();
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andRegSuccessEqualTo("0");
		List<UserInfo> userInfos = userMapper.selectByExample(example);
		for (UserInfo userInfo : userInfos) {
			PersonInfo personInfo = personMapper.selectByPrimaryKey(userInfo.getPersonId());
			result.add(personInfo);
		}
		return result;
	}

	@Override
	public int passPerson(String personId) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andPersonIdEqualTo(personId);
		List<UserInfo> personInfos = userMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(personInfos)) {
			return 0;
		}
		personInfos.get(0).setRegSuccess("1");
		return userMapper.updateByPrimaryKeySelective(personInfos.get(0));
	}

	@Override
	public int notPassPerson(String personId) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andPersonIdEqualTo(personId);
		List<UserInfo> personInfos = userMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(personInfos)) {
			return 0;
		}
		personInfos.get(0).setRegSuccess("2");
		return userMapper.updateByPrimaryKeySelective(personInfos.get(0));
	}

	@Override
	public int updatePersonInfo(PersonInfo personInfo) {
		return personMapper.updateByPrimaryKeySelective(personInfo);
	}

}
