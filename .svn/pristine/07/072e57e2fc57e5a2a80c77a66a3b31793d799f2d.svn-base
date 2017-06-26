package pers.guanzf.common.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.guanzf.common.core.dao.ProduceMapper;
import pers.guanzf.common.core.dao.SysDictMapper;
import pers.guanzf.common.core.model.ProduceExample;
import pers.guanzf.common.core.model.SysDictExample;
import pers.guanzf.common.core.model.info.ProduceInfo;
import pers.guanzf.common.core.model.info.SysDictInfo;
import pers.guanzf.common.core.service.SysDictService;
import pers.guanzf.common.util.StringUtil;

@Service
public class SysDictServiceImpl implements SysDictService {
	
	@Autowired
	private SysDictMapper sysDictMapper;
	
	@Autowired
	private ProduceMapper produceMapper;

	@Override
	public int insertSysDictInfo(SysDictInfo sysDictInfo) {
		if (ObjectUtils.isEmpty(sysDictInfo)) {
			return 0;
		}
		return sysDictMapper.insertSelective(sysDictInfo);
	}

	@Override
	public List<SysDictInfo> listSysDictInfo() {
		SysDictExample example = new SysDictExample();
		example.setOrderByClause("SYS_DICT_TYPE,SYS_DICT_SORT");
		List<SysDictInfo> sysDictInfos = sysDictMapper.selectByExample(example);
		for (SysDictInfo sysDictInfo : sysDictInfos) {
			
		}
		return sysDictInfos;
	}

	@Override
	public int deleteSysDictInfo(String sysDictId) {
		if (StringUtil.isEmpty(sysDictId)) {
			return 0;
		}
		return sysDictMapper.deleteByPrimaryKey(sysDictId);
	}

	@Override
	public int updateSysDictInfo(SysDictInfo sysDictInfo) {
		if (ObjectUtils.isEmpty(sysDictInfo) || StringUtil.isEmpty(sysDictInfo.getSysDictId())) {
			return 0;
		}
		SysDictInfo dictInfo = sysDictMapper.selectByPrimaryKey(sysDictInfo.getSysDictId());
		if (ObjectUtils.isEmpty(dictInfo)) {
			return 0;
		}
		return sysDictMapper.updateByPrimaryKeySelective(sysDictInfo);
	}

	@Override
	public SysDictInfo getSysDictInfo(String sysDictId) {
		if (StringUtil.isEmpty(sysDictId)) {
			return null;
		}
		return sysDictMapper.selectByPrimaryKey(sysDictId);
	}
	
	
	@Override
	public List<SysDictInfo> listSysDictInfoByType(String sysDictType) {
		if (StringUtil.isEmpty(sysDictType)) {
			return null;
		}
		SysDictExample example = new SysDictExample();
		SysDictExample.Criteria criteria = example.createCriteria();
		criteria.andSysDictTypeEqualTo(sysDictType);
		return sysDictMapper.selectByExample(example);
	}

	@Override
	public List<SysDictInfo> listProduceInfo() {
		SysDictExample example = new SysDictExample();
		SysDictExample.Criteria criteria = example.createCriteria();
		criteria.andSysDictTypeEqualTo("produceType");
		List<SysDictInfo> sysDictInfos = sysDictMapper.selectByExample(example);
		for (SysDictInfo sysDictInfo : sysDictInfos) {
			ProduceExample example2 = new ProduceExample();
			ProduceExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andProduceTypeEqualTo(sysDictInfo.getSysDictId());
			List<ProduceInfo> produceInfos = produceMapper.selectByExample(example2);
			sysDictInfo.setProduceInfo(produceInfos);
		}
		return sysDictInfos;
	}
	
}
