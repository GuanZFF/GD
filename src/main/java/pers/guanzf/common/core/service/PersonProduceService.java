package pers.guanzf.common.core.service;

import java.util.List;

import pers.guanzf.common.core.model.info.PersonInfo;
import pers.guanzf.common.core.model.info.PersonProduceInfo;

public interface PersonProduceService {
	
	int insertPersonProduceInfo(PersonProduceInfo personProduceInfo);
	
	List<PersonProduceInfo> selectPersonProduceInfo(String personId, String produceId);
	
	int updatePersonProduceInfo(PersonProduceInfo personProduceInfo);
	
}
