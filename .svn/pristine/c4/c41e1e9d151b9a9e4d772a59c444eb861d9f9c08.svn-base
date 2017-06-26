package pers.guanzf.common.core.service;

import java.util.List;

import pers.guanzf.common.core.model.info.PersonInfo;
import pers.guanzf.common.core.model.info.PersonProduceInfo;

public interface PersonService {

	PersonProduceInfo getProduceInfoByPersonId(String personId);
	
	PersonInfo getProduceInfoByUsername(String username);
	
	int insertPersonInfo(PersonInfo personInfo);
	
	int insertPersonProduceInfo(String personId, String produceId);
	
	List<PersonInfo> getNotPassRegPerson();
	
	int passPerson(String personId);
	
	int notPassPerson(String personId);
	
	int updatePersonInfo(PersonInfo personInfo);
	
}
