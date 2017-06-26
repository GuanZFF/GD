package pers.guanzf.common.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.guanzf.common.core.model.Person;
import pers.guanzf.common.core.model.info.PersonInfo;
import pers.guanzf.common.core.model.info.PersonProduceInfo;
import pers.guanzf.common.core.model.info.UserInfo;
import pers.guanzf.common.core.service.PersonProduceService;
import pers.guanzf.common.core.service.PersonService;
import pers.guanzf.common.core.service.UserService;
import pers.guanzf.common.sys.base.model.Result;
import pers.guanzf.common.sys.kernel.MD5;
import pers.guanzf.common.util.StringUtil;
import pers.guanzf.common.util.UUIDUtil;
import pers.guanzf.technology.websocket.SendMessage;

@Controller
@RequestMapping("/personcontroller")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PersonProduceService personProduceService;

	@RequestMapping("/getpersonproduceinfobypersonid")
	@ResponseBody
	public PersonProduceInfo getPersonProduceInfoByPersonId(String personId) {
		PersonProduceInfo result = new PersonProduceInfo();
		if (StringUtil.isNotBlank(personId)) {
			result = personService.getProduceInfoByPersonId(personId);
		}
		return result;
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Person Login() {
		Person person = new Person();
		person.setPersonName("guanzf");
		return person;
	}
	
	@RequestMapping("/insertpersonproduceinfo")
	@ResponseBody
	public int insertPersonProduceInfo(HttpServletRequest request, PersonProduceInfo personProduceInfo) {
		String username = (String) request.getSession().getAttribute("username");
		UserInfo userInfo = userService.getUserByName(username);
		if (StringUtil.isNotEmpty(personProduceInfo.getProduceId())) {
			List<PersonProduceInfo> personProduceInfos = personProduceService.selectPersonProduceInfo(userInfo.getPersonId(), personProduceInfo.getProduceId());
			PersonProduceInfo produceInfo = personProduceInfos.get(0);
			personProduceInfo.setPersonProduceId(produceInfo.getPersonProduceId());
		}
		return personProduceService.updatePersonProduceInfo(personProduceInfo);
	}
	
	@RequestMapping("/getnotpassregperson")
	@ResponseBody
	public List<PersonInfo> getNotPassRegPerson() {
		return personService.getNotPassRegPerson();
	}
	
	@RequestMapping("/passperson")
	@ResponseBody
	public int passPerson(String personId) {
		if (StringUtil.isEmpty(personId)) {
			return 0;
		}
		int result = personService.passPerson(personId);
		SendMessage.sendMessage1(personService.getNotPassRegPerson());
		return result;
	}
	
	@RequestMapping("/notpassperson")
	@ResponseBody
	public int notPassPerson(String personId) {
		if (StringUtil.isEmpty(personId)) {
			return 0;
		}
		int result = personService.notPassPerson(personId);
		SendMessage.sendMessage1(personService.getNotPassRegPerson());
		return result;
	}
	
	@RequestMapping("/getpersoninfobypersonname")
	@ResponseBody
	public PersonInfo getPersonInfoByPersonName(String personName) {
		if (StringUtil.isEmpty(personName)) {
			return null;
		}
		return personService.getProduceInfoByUsername(personName);
	}
	
	@RequestMapping("/updatepersoninfo")
	@ResponseBody
	public int updatePersonInfo(PersonInfo personInfo, HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		UserInfo userInfo = userService.getUserByName(username);
		if (ObjectUtils.isEmpty(userInfo)) {
			return 0;
		}
		userInfo.setUserName(personInfo.getPersonName());
		if (StringUtil.isEmpty(personInfo.getPersonPassword())) {
			userInfo.setUserPassword(MD5.encode16(personInfo.getPersonPassword()));
		}
		userService.updateUserInfo(userInfo);
		personInfo.setPersonId(userInfo.getPersonId());
		return personService.updatePersonInfo(personInfo);
	}
	
}
