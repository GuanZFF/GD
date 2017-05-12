package pers.guanzf.common.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import pers.guanzf.common.core.dao.ProduceMapper;
import pers.guanzf.common.core.dao.UserMapper;
import pers.guanzf.common.core.model.Produce;
import pers.guanzf.common.core.model.ProduceExample;
import pers.guanzf.common.core.model.User;
import pers.guanzf.common.core.model.UserExample;
import pers.guanzf.common.core.model.info.ProduceInfo;
import pers.guanzf.common.core.model.info.UserInfo;
import pers.guanzf.common.core.service.ProduceService;

@Controller
@RequestMapping("/test")
public class test {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ProduceMapper produceMapper;
	
	@Autowired
	private ProduceService produceService;

	@RequestMapping("/test3")
	@ResponseBody
	public UserInfo getUserInfo(String name) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(name);
		List<UserInfo> list = userMapper.selectByExample(example);
		return list.get(0);
	}
	
	@RequestMapping("/test4")
	@ResponseBody
	public Produce getProduceInfo() {
		ProduceExample example = new ProduceExample();
		ProduceExample.Criteria criteria = example.createCriteria();
		criteria.andProduceIdEqualTo("12");
		List<ProduceInfo> list = produceMapper.selectByExample(example);
		return list.get(0);
	}
	
	@RequestMapping("/test5")
	@ResponseBody
	public List<ProduceInfo> listProduceInfo() {
		return produceService.listProduce();
	}
}
