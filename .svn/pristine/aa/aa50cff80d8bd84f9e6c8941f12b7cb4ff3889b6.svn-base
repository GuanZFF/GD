package pers.guanzf.common.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.guanzf.common.core.model.Person;
import pers.guanzf.common.core.model.info.PersonProduceInfo;
import pers.guanzf.common.core.service.PersonService;
import pers.guanzf.common.util.StringUtil;

@Controller
@RequestMapping("/personcontroller")
public class PersonController {

	@Autowired
	private PersonService personService;

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
	
}
