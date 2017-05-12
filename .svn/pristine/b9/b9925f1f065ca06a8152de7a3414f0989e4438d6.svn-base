package pers.guanzf.common.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import pers.guanzf.common.core.dao.PersonMapper;
import pers.guanzf.common.core.dao.PersonProduceMapper;
import pers.guanzf.common.core.dao.ProduceMapper;
import pers.guanzf.common.core.model.Person;
import pers.guanzf.common.core.model.PersonProduce;
import pers.guanzf.common.core.model.PersonProduceExample;
import pers.guanzf.common.core.model.Produce;
import pers.guanzf.common.core.model.info.PersonProduceInfo;
import pers.guanzf.common.core.service.PersonService;
import pers.guanzf.common.util.StringUtil;

@Service
public class PersonServiceImpl implements PersonService {

	private static final Logger LOGGER = Logger.getLogger(PersonServiceImpl.class);

	@Autowired
	private PersonMapper personMapper;

	@Autowired
	private ProduceMapper produceMapper;

	@Autowired
	private PersonProduceMapper personProduceMapper;

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
		List<PersonProduce> personProduces = personProduceMapper.selectByExample(example);
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
}
