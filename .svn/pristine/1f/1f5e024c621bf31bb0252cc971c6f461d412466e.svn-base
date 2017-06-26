package pers.guanzf.common.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import pers.guanzf.common.core.dao.CommodityStructrueMapper;
import pers.guanzf.common.core.dao.FriendMapper;
import pers.guanzf.common.core.dao.PersonMapper;
import pers.guanzf.common.core.dao.PersonProduceMapper;
import pers.guanzf.common.core.dao.ProduceMapper;
import pers.guanzf.common.core.dao.SysDictMapper;
import pers.guanzf.common.core.dao.UserMapper;
import pers.guanzf.common.core.model.Comment;
import pers.guanzf.common.core.model.CommodityStructrueExample;
import pers.guanzf.common.core.model.FriendExample;
import pers.guanzf.common.core.model.PersonProduceExample;
import pers.guanzf.common.core.model.ProduceExample;
import pers.guanzf.common.core.model.info.CommodityStructrueInfo;
import pers.guanzf.common.core.model.info.FriendInfo;
import pers.guanzf.common.core.model.info.PersonInfo;
import pers.guanzf.common.core.model.info.PersonProduceInfo;
import pers.guanzf.common.core.model.info.ProduceInfo;
import pers.guanzf.common.core.model.info.UserInfo;
import pers.guanzf.common.core.service.ProduceService;
import pers.guanzf.common.util.DateUtil;
import pers.guanzf.common.util.StringUtil;
import pers.guanzf.common.util.UUIDUtil;

@Service
public class ProduceServiceImpl implements ProduceService {

	private static final Logger LOGGER = Logger.getLogger(ProduceServiceImpl.class);
	
	@Autowired
	private ProduceMapper produceMapper;
	
	@Autowired
	private FriendMapper friendMapper;
	
	@Autowired
	private CommodityStructrueMapper commodityStructrueMapper;
	
	@Autowired
	private PersonProduceMapper personProduceMapper;
	
	@Autowired
	private SysDictMapper sysDictMapper;
	
	@Autowired
	private PersonMapper personMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<ProduceInfo> listProduce() {
		ProduceExample example = new ProduceExample();
		return produceMapper.selectByExample(example);
	}

	@Override
	public ProduceInfo getProduceInfo(String produceId) {
		if (StringUtils.isEmpty(produceId)) {
			LOGGER.info("ID为空");
			return null;
		}
		ProduceExample example = new ProduceExample();
		ProduceExample.Criteria criteria = example.createCriteria();
		criteria.andProduceIdEqualTo(produceId);
		List<ProduceInfo> produces = produceMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(produces)) {
			LOGGER.info("ID没有对应的信息");
			return null;
		}
		String userId = produces.get(0).getProduceUserId();
		UserInfo userInfo = userMapper.selectByPrimaryKey(userId);
		produces.get(0).setUserInfo(userInfo);
		return produces.get(0);
	}

	@Override
	public int deleteProduceInfo(String produceId) {
		if (StringUtils.isEmpty(produceId)) {
			LOGGER.info("ID为空");
			return -1;
		}
		ProduceExample example = new ProduceExample();
		ProduceExample.Criteria criteria = example.createCriteria();
		criteria.andProduceIdEqualTo(produceId);
		int result = produceMapper.deleteByExample(example);
		if (result != 1) {
			LOGGER.info("删除商品信息有误");
		}
		return result;
	}

	@Override
	public int insertProduceInfo(ProduceInfo produce) {
		produce.setProduceId(UUIDUtil.randomID());
		int result = produceMapper.insertSelective(produce);
		if (result != 1) {
			LOGGER.info("数据插入失败");
			return 0;
		}
		return 1;
	}

	@Override
	public int updateProduceInfo(ProduceInfo produce) {
		ProduceExample example = new ProduceExample();
		ProduceExample.Criteria criteria = example.createCriteria();
		criteria.andProduceIdEqualTo(produce.getProduceId());
		int result = produceMapper.updateByExampleSelective(produce, example);
		if (result != 1) {
			LOGGER.info("更新数据失败");
			return 0;
		}
		return 1;
	}
	
	public List<ProduceInfo> listMostBestProduce() {
		return null;
	}

	@Override
	public List<ProduceInfo> listFriendRecommendData(String userId, String num) {
		if (StringUtil.isEmpty(userId)) {
			
		}
		/* 查询好用ID */
		FriendExample example = new FriendExample();
		example.setOrderByClause("FRIEND_SIMILARITY_DEGREE DESC limit 4");
		FriendExample.Criteria criteria = example.createCriteria();
		criteria.andFriendIdEqualTo(userId);
		List<FriendInfo> friendInfos = friendMapper.selectByExample(example);
		for (FriendInfo friendInfo : friendInfos) {
			
		}
		return null;
	}

	@Override
	public List<CommodityStructrueInfo> listCommodityStructrueInfos(String commodityStructrueFartherId) {
		if (StringUtil.isEmpty(commodityStructrueFartherId)) {
			return null;
		}
		CommodityStructrueExample example = new CommodityStructrueExample();
		CommodityStructrueExample.Criteria criteria = example.createCriteria();
		criteria.andCommodityStructrueFartherIdEqualTo(commodityStructrueFartherId);
		return commodityStructrueMapper.selectByExample(example);
	}

	@Override
	public List<CommodityStructrueInfo> listCommodityStructrueByFloor(String floor) {
		if (StringUtil.isEmpty(floor)) {
			return null;
		}
		CommodityStructrueExample example = new CommodityStructrueExample();
		CommodityStructrueExample.Criteria criteria = example.createCriteria();
		criteria.andCommodityStructrueChildNumEqualTo(Integer.valueOf(floor));
		return commodityStructrueMapper.selectByExample(example);
	}

	@Override
	public List<ProduceInfo> listProduceInfoByUserId(String userId) {
		if (StringUtil.isEmpty(userId)) {
			return null;
		}
		ProduceExample example = new ProduceExample();
		example.setOrderByClause("PRODUCE_SELL_NUM DESC LIMIT 6");
		ProduceExample.Criteria criteria = example.createCriteria();
		criteria.andProduceUserIdEqualTo(userId);
		return produceMapper.selectByExample(example);
	}

	@Override
	public List<ProduceInfo> listProduceAtTodayNum() {
		ProduceExample example = new ProduceExample();
		example.setOrderByClause("PRODUCE_TODAY_NUM DESC LIMIT 6");
		ProduceExample.Criteria criteria = example.createCriteria();
		return produceMapper.selectByExample(example);
	}

	@Override
	public List<Comment> listCommentInfo(String produceId) {
		if (StringUtil.isEmpty(produceId)) {
			return null;
		}
		List<Comment> result = new ArrayList<>();
		PersonProduceExample example = new PersonProduceExample();
		PersonProduceExample.Criteria criteria = example.createCriteria();
		criteria.andProduceIdEqualTo(produceId);
		criteria.andCommentIsNotNull();
		List<PersonProduceInfo> personProduceInfos = personProduceMapper.selectByExample(example);
		for (PersonProduceInfo personProduceInfo : personProduceInfos) {
			PersonInfo personInfo = personMapper.selectByPrimaryKey(personProduceInfo.getPersonId());
			Comment comment = new Comment();
			comment.setComment(personProduceInfo.getComment());
			comment.setCommentTime(DateUtil.getDateString(personProduceInfo.getCreateTime(), DateUtil.YYYY_MM_DD_HH_MM_SS));
			comment.setCommentValue(String.valueOf(personProduceInfo.getCommentValue()));
			comment.setPersonName(personInfo.getPersonName());
			comment.setPersonSex(personInfo.getPersonSex());
			comment.setCommentUrl(personProduceInfo.getCommentImgUrl());
			result.add(comment);
		}
		return result;
	}

	@Override
	public List<ProduceInfo> getProduceInfoByName(String produceName) {
		if (StringUtil.isEmpty(produceName)) {
			return null;
		}
		ProduceExample example = new ProduceExample();
		ProduceExample.Criteria criteria = example.createCriteria();	
		criteria.andProduceNameEqualTo(produceName);
		return produceMapper.selectByExample(example);
	}

	@Override
	public List<ProduceInfo> getproduceInfoByFriend(String personId, String produceType) {
		List<ProduceInfo> result = new ArrayList<>();
		if (StringUtil.isEmpty(personId)) {
			return null;
		}
		FriendExample example = new FriendExample();
		example.setOrderByClause("FRIEND_SIMILARITY_DEGREE DESC");
		FriendExample.Criteria criteria = example.createCriteria();
		criteria.andFriendMyIdEqualTo(personId);
		List<FriendInfo> friendInfos = friendMapper.selectByExample(example);
		for (FriendInfo friendInfo : friendInfos) {
			PersonProduceExample example2 = new PersonProduceExample();
			PersonProduceExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andPersonIdEqualTo(friendInfo.getFriendFriendId());
			List<PersonProduceInfo> personProduceInfos = personProduceMapper.selectByExample(example2);
			for (PersonProduceInfo personProduceInfo : personProduceInfos) {
				ProduceInfo produceInfo = produceMapper.selectByPrimaryKey(personProduceInfo.getProduceId());
				if (StringUtil.isNotEmpty(produceType) && produceInfo.getProduceType().equals(produceType)) {
					result.add(produceInfo);
				} else if (StringUtil.isEmpty(produceType))	{
					result.add(produceInfo);
				}
				if (result.size() >= 4) {
					return result;
				}
			}
		}
		return result;
	}

	@Override
	public List<ProduceInfo> getGoods(String produceType) {
		if (StringUtil.isEmpty(produceType)) {
			return null;
		}
		ProduceExample example = new ProduceExample();
		example.setOrderByClause("PRODUCE_TODAY_NUM DESC LIMIT 4");
		ProduceExample.Criteria criteria = example.createCriteria();	
		criteria.andProduceTypeEqualTo(produceType);
		return produceMapper.selectByExample(example);
	}

	@Override
	public List<ProduceInfo> getShangJia(String produceType) {
		if (StringUtil.isEmpty(produceType)) {
			return null;
		}
		ProduceExample example = new ProduceExample();
		example.setOrderByClause("PRODUCE_TODAY_NUM LIMIT 4");
		ProduceExample.Criteria criteria = example.createCriteria();	
		criteria.andProduceTypeEqualTo(produceType);
		return produceMapper.selectByExample(example);
	}
	

}
