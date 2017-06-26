package pers.guanzf.common.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import pers.guanzf.common.core.dao.PersonProduceMapper;
import pers.guanzf.common.core.dao.UserMapper;
import pers.guanzf.common.core.model.PersonProduceExample;
import pers.guanzf.common.core.model.UserExample;
import pers.guanzf.common.core.model.info.PersonInfo;
import pers.guanzf.common.core.model.info.PersonProduceInfo;
import pers.guanzf.common.core.model.info.UserInfo;
import pers.guanzf.common.core.service.PersonProduceService;
import pers.guanzf.common.util.StringUtil;

@Service
public class PersonProduceServiceImpl implements PersonProduceService {
	
	private static final Logger LOGGER = Logger.getLogger(PersonProduceServiceImpl.class);
	
	@Autowired
	private PersonProduceMapper personProduceMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public int insertPersonProduceInfo(PersonProduceInfo personProduceInfo) {
		if (ObjectUtils.isEmpty(personProduceInfo) || StringUtil.isEmpty(personProduceInfo.getPersonProduceId())) {
			LOGGER.info("信息不完全");
			return 0;
		}
		return personProduceMapper.insertSelective(personProduceInfo);
	}

	@Override
	public List<PersonProduceInfo> selectPersonProduceInfo(String personId, String produceId) {
		PersonProduceExample example = new PersonProduceExample();
		PersonProduceExample.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(personId)) {
			criteria.andPersonIdEqualTo(personId);
		}
		if (StringUtil.isNotEmpty(produceId)) {
			criteria.andProduceIdEqualTo(produceId);
		}
		return personProduceMapper.selectByExample(example);
	}

	@Override
	public int updatePersonProduceInfo(PersonProduceInfo personProduceInfo) {
		return personProduceMapper.updateByPrimaryKeySelective(personProduceInfo);
	}

}
