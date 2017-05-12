package pers.guanzf.common.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.guanzf.common.core.model.info.ProduceInfo;
import pers.guanzf.common.core.service.ProduceService;
import pers.guanzf.common.sys.base.model.BaseRequest;
import pers.guanzf.common.sys.base.model.BaseResponse;
import pers.guanzf.common.sys.base.model.BaseResponseBody;

@Controller
@RequestMapping("/PC")
public class ProduceController {

	@Autowired
	private ProduceService produceService;

	@RequestMapping("/writeproduceinfo")
	@org.springframework.web.bind.annotation.ResponseBody
	public BaseResponseBody writeProduceInfo(ProduceInfo produce) {
		if (ObjectUtils.isEmpty(produce)) {
			return new BaseResponseBody(0, "test");
		}
		return null;
	}

	@RequestMapping("/readproduceallinfo")
	@ResponseBody
	public BaseResponse<List<ProduceInfo>> readProduceAllInfo() {
		List<ProduceInfo> list = produceService.listProduce();
		BaseResponse<List<ProduceInfo>> result = new BaseResponse<>();
		result.setData(list);
		result.setMessage("处理成功");
		return result;
	}
	
	@RequestMapping("/registerproduce")
	@ResponseBody
	public BaseResponse<String> registerProduce(@RequestParam BaseRequest<ProduceInfo> baseRequest) {
		BaseResponse<String> response = new BaseResponse<>();
		ProduceInfo produce = baseRequest.getData();
		if (ObjectUtils.isEmpty(produce)) {
			response.setCode(0);
			response.setMessage("注册失败");
			return response;
		}
		int result = 0;
		if (StringUtils.isEmpty(produce.getProduceId())) {
			result = produceService.insertProduceInfo(produce);
		} else {
			result = produceService.updateProduceInfo(produce);
		}
		if (result != 1) {
			response.setCode(0);
			response.setMessage("注册数据失败");
		}
		return response;
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(BaseRequest<ProduceInfo> baseRequest) {
		System.out.println(baseRequest.getData().getProduceName());
		return "jj";
	}
	
	@RequestMapping("/listmostsell")
	@ResponseBody
	public List<ProduceInfo> listMostSell() {
		return null;
		// return new ArrayList<>();
	}

}
