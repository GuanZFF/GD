package pers.guanzf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import pers.guanzf.common.core.model.Person;

public class FastJson_test {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("123", null);
		map.put("name", "jj");
		Person person = new Person();
		person.setPersonId(null);
		person.setPersonName("guanzf");
		List<String> list = new ArrayList<>();
		list.add(null);
		list.add("guanzf");
		String ss = JSON.toJSONString(list, SerializerFeature.WriteNullListAsEmpty);
		String s = JSON.toJSONString(person, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero);
		System.out.println(ss);
	}
}
