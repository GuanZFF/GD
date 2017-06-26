package pers.guanzf.common.core.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pers.guanzf.common.core.model.Comment;
import pers.guanzf.common.core.model.ImageAttribute;
import pers.guanzf.common.core.model.info.CommodityStructrueInfo;
import pers.guanzf.common.core.model.info.PersonInfo;
import pers.guanzf.common.core.model.info.PersonProduceInfo;
import pers.guanzf.common.core.model.info.ProduceInfo;
import pers.guanzf.common.core.model.info.UserInfo;
import pers.guanzf.common.core.service.PersonProduceService;
import pers.guanzf.common.core.service.PersonService;
import pers.guanzf.common.core.service.ProduceService;
import pers.guanzf.common.core.service.UserService;
import pers.guanzf.common.sys.base.model.BaseRequest;
import pers.guanzf.common.sys.base.model.BaseResponse;
import pers.guanzf.common.sys.base.model.BaseResponseBody;
import pers.guanzf.common.sys.base.model.Result;
import pers.guanzf.common.util.FileUtil;
import pers.guanzf.common.util.StringUtil;
import pers.guanzf.common.util.UUIDUtil;

@Controller
@RequestMapping("/PC")
public class ProduceController {
	
	private static final Logger LOGGER = Logger.getLogger(ProduceController.class);

	@Autowired
	private ProduceService produceService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PersonProduceService personProduceService;

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
	}

	@RequestMapping("/listfriendrecommenddata")
	@ResponseBody
	public List<ProduceInfo> listFriendRecommendData(HttpServletRequest request, String userId, String num) {
		String username = (String) request.getSession().getAttribute("username");
		UserInfo userInfo = userService.getUserByName(username);
		if (StringUtil.isEmpty(num)) {
			return new ArrayList<>();
		}
		if (!ObjectUtils.isEmpty(userInfo)) {
			userId = userInfo.getUserId();
		}
		return produceService.listFriendRecommendData(userId, num);
	}
	
	@RequestMapping("/addproduce")
	@ResponseBody
	public int addProduce(HttpServletRequest request, ProduceInfo produceInfo) {
		String username = (String) request.getSession().getAttribute("username");
		UserInfo userInfo = userService.getUserByName(username);
		produceInfo.setProduceUserId(userInfo.getUserId());
		return produceService.insertProduceInfo(produceInfo);
	}
	
	@RequestMapping("/testuploadimage")
	@ResponseBody
	public int testUploadImage(@RequestParam MultipartFile file, HttpServletRequest request, ImageAttribute imageAttribute) {
		if (ObjectUtils.isEmpty(file) || file.isEmpty()) {
			return 0;
		}
		String name = file.getOriginalFilename();
		
		System.out.println(name);
		
		String path = request.getServletContext().getRealPath(File.separator) + "/images/upload/" + name;
		File file2 = new File(path);
		boolean b;
		if (!file2.exists()) {
			try {
				b = file2.createNewFile();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), file2);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String purposePath = request.getServletContext().getRealPath(File.separator) + "/images/uploadHandle/" + name;
		FileUtil.cutImage(path, purposePath, imageAttribute.getX(), imageAttribute.getY(), imageAttribute.getW(), imageAttribute.getH(), "jpg", "jpg");
		return 0;
	}
	
	@RequestMapping("/getcommonditystructrueinfo")
	@ResponseBody
	public CommodityStructrueInfo getCommondityStructrueInfo(String commodityStructrueId) {
		return null;
	}
	
	@RequestMapping("/listcommoditystructrueinfos")
	@ResponseBody
	public List<CommodityStructrueInfo> listCommodityStructrueInfos(String commodityStructrueFartherId) {
		if (StringUtil.isEmpty(commodityStructrueFartherId)) {
			return null;
		}
		return produceService.listCommodityStructrueInfos(commodityStructrueFartherId);
	}
	
	@RequestMapping("/listcommoditystructruebyfloor")
	@ResponseBody
	public List<CommodityStructrueInfo> listCommodityStructrueByFloor(String floor) {
		if (StringUtil.isEmpty(floor)) {
			return null;
		}
		return produceService.listCommodityStructrueByFloor(floor);
	}
	
	@RequestMapping("/listmyproducedata")
	@ResponseBody
	public List<ProduceInfo> listMyProduceData(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		UserInfo userInfo = userService.getUserByName(username);
		return produceService.listProduceInfoByUserId(userInfo.getUserId());
	}
	
	@RequestMapping("/getproduceinfo")
	@ResponseBody
	public ProduceInfo getProduceInfo(String produceId) {
		if (StringUtil.isEmpty(produceId)) {
			return null;
		}
		return produceService.getProduceInfo(produceId);
	}
	
	@RequestMapping("/listproduceinfoattodaynum")
	@ResponseBody
	public List<ProduceInfo> listProduceInfoAtTodayNum() {
		return produceService.listProduceAtTodayNum();
	}
	
	@RequestMapping("/listcommentinfo")
	@ResponseBody
	public List<Comment> listCommentInfo(String produceId) {
		if (StringUtil.isEmpty(produceId)) {
			return null;
		}
		return produceService.listCommentInfo(produceId);
	}
	
	@RequestMapping("/getproduceinfobyname")
	@ResponseBody
	public ProduceInfo getProduceInfoByName(String produceName) {
		if (StringUtil.isEmpty(produceName)) {
			return new ProduceInfo();
		}
		List<ProduceInfo> produceInfos = produceService.getProduceInfoByName(produceName);
		if (CollectionUtils.isEmpty(produceInfos)) {
			return new ProduceInfo();
		}
		return produceInfos.get(0);
	}
	
	@RequestMapping("/updateproduceinfo")
	@ResponseBody
	public int updateProduceInfo(ProduceInfo produceInfo) {
		if (ObjectUtils.isEmpty(produceInfo) || StringUtil.isEmpty(produceInfo.getProduceId())) {
			return 0;
		}
		return produceService.updateProduceInfo(produceInfo);
	}
	
	@RequestMapping("/buyproduceinfo")
	@ResponseBody
	public Result buyProduceInfo(HttpServletRequest request, String produceId) {
		String username = (String) request.getSession().getAttribute("username");
		UserInfo userInfo = userService.getUserByName(username);
		if (StringUtil.isEmpty(produceId)) {
			return new Result(0, "Id不存在");
		}
		List<PersonProduceInfo> personProduceInfos = personProduceService.selectPersonProduceInfo(userInfo.getPersonId(), produceId);
		if (CollectionUtils.isEmpty(personProduceInfos)) {
			PersonProduceInfo personProduceInfo = new PersonProduceInfo();
			personProduceInfo.setPersonProduceId(UUIDUtil.randomID());
			personProduceInfo.setPersonId(userInfo.getPersonId());
			personProduceInfo.setProduceId(produceId);
			personProduceService.insertPersonProduceInfo(personProduceInfo);
		} else {
			PersonProduceInfo personProduceInfo = personProduceInfos.get(0);
			if (StringUtil.isNotEmpty(personProduceInfo.getComment())) {
				return new Result(0, "你已购买过此商品");
			} else {
				return new Result(2, "你可以添加评论");
			}
		}
		ProduceInfo produceInfo = produceService.getProduceInfo(produceId);
		ProduceInfo produceInfo2 = new ProduceInfo();
		produceInfo2.setProduceId(produceId);
		produceInfo2.setProduceSellNum(produceInfo.getProduceSellNum() + 1);
		produceInfo2.setProduceTodayNum(produceInfo.getProduceTodayNum() + 1);
		produceService.updateProduceInfo(produceInfo2);
		return new Result(1, "购买成功");
	}
	
	@RequestMapping("/listfriendrecomcom")
	@ResponseBody
	public List<ProduceInfo> listFriendRecomCom(String produceType, HttpServletRequest request) {
		if (StringUtil.isEmpty(produceType)) {
			return new ArrayList<>();
		}
		String username = (String) request.getSession().getAttribute("username");
		UserInfo userInfo = userService.getUserByName(username);
		return produceService.getproduceInfoByFriend(userInfo.getPersonId(), produceType);
	}
	
	@RequestMapping("/listgood")
	@ResponseBody
	public List<ProduceInfo> listGood(String produceType) {
		return produceService.getGoods(produceType);
	}
	
	@RequestMapping("/listshangjia")
	@ResponseBody
	public List<ProduceInfo> listShangJia(String produceType) {
		return produceService.getGoods(produceType);
	}
}
