package pers.guanzf.common.constants;

import pers.guanzf.common.util.StringUtil;

public enum Sex
{
	MAN("1", "男"), WOMAN("2", "女");
	private String value;
	private String name;

	private Sex(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getNameByValue(String value) {
		if (StringUtil.isEmpty(value)) {
			return "";
		}
		Sex[] sex = Sex.values();
		for (Sex sex2 : sex) {
			if (sex2.getValue().equals(value)) {
				return sex2.getName();
			}
		}
		return value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
