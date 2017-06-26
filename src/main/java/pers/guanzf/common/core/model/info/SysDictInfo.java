package pers.guanzf.common.core.model.info;

import java.util.List;

import pers.guanzf.common.core.model.SysDict;

public class SysDictInfo extends SysDict {

	private List<ProduceInfo> produceInfo;

	public List<ProduceInfo> getProduceInfo() {
		return produceInfo;
	}

	public void setProduceInfo(List<ProduceInfo> produceInfo) {
		this.produceInfo = produceInfo;
	}

}
