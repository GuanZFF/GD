package pers.guanzf.common.core.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import pers.guanzf.common.core.model.BuyRecord;
import pers.guanzf.common.core.model.ImageAttribute;
import pers.guanzf.common.core.model.User;
import pers.guanzf.common.core.model.info.FriendInfo;
import pers.guanzf.common.core.model.info.MessageManageInfo;
import pers.guanzf.common.core.model.info.PersonInfo;
import pers.guanzf.common.core.model.info.UserInfo;
import pers.guanzf.common.core.service.PersonService;
import pers.guanzf.common.core.service.UserService;
import pers.guanzf.common.sys.base.model.BaseResponseBody;
import pers.guanzf.common.sys.base.model.Result;
import pers.guanzf.common.sys.kernel.MD5;
import pers.guanzf.common.util.DateUtil;
import pers.guanzf.common.util.FileUtil;
import pers.guanzf.common.util.SpringContextHolder;
import pers.guanzf.common.util.StringUtil;
import pers.guanzf.common.util.UUIDUtil;
import pers.guanzf.technology.websocket.SendMessage;

@Controller
@RequestMapping("/usercontroller")
public class UserController {
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/adduser")
	@ResponseBody
	public BaseResponseBody addUser(HttpServletRequest request, UserInfo user) {
		/*if (file != null && !file.isEmpty()) {
			StringBuffer folderName = new StringBuffer();
			folderName.append(StringUtil.getPingYin(user.getUserName()));
			StringBuffer filePathBuf = new StringBuffer();
			filePathBuf.append(File.separator).append("upload").append(File.separator).append("img").append(File.separator).append(folderName);
			String realPath = request.getSession().getServletContext().getRealPath(filePathBuf.toString());
			Result imgResult = FileUtil.uploadFile(file, realPath, folderName.toString());
			if (0 == imgResult.getFlag()) {
				return new BaseResponseBody();
			}
		}*/
		if (ObjectUtils.isEmpty(user)) {
			return new BaseResponseBody(0, "参数错误");
		}
		User user1 = userService.getUserByName(user.getUserName());
		if (!ObjectUtils.isEmpty(user1)) {
			return new BaseResponseBody(0, "用户名已存在");
		}
		if (user.getUserType().equals("1")) {
			user.setRegSuccess("0");
		} else {
			user.setRegSuccess("1");
		}
		user.setUserId(UUIDUtil.randomID());
		user.setUserPassword(MD5.encode16(user.getUserPassword()));
		int result = userService.addUser(user);
		if (result == 1) {
			SendMessage.sendMessage1(personService.getNotPassRegPerson());
			return new BaseResponseBody(1, "用户注册成功");
		} else {
			return new BaseResponseBody(0, "注册失败");
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseBody login(HttpServletRequest request, UserInfo user) {
		if (ObjectUtils.isEmpty(user) || StringUtil.isEmpty(user.getUserName())
				|| StringUtil.isEmpty(user.getUserPassword())) {
			return new BaseResponseBody(0, "登录信息错误");
		}
		UserInfo userInfo = userService.getUserByName(user.getUserName());
		if (ObjectUtils.isEmpty(userInfo)) {
			return new BaseResponseBody(0, "用户不存在");
		}
		if (userInfo.getRegSuccess().equals("0")) {
			return new BaseResponseBody(0, "你的信息等待管理员确认");
		} else if (userInfo.getRegSuccess().equals("2")) {
			return new BaseResponseBody(0, "你的信息没用通过验证，请重新注册");
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), MD5.encode16(user.getUserPassword()));
		try {
			subject.login(token);
		} catch (AuthenticationException ex) {
			return new BaseResponseBody(0, "用户名或密码错误");
		}
		request.getSession().setAttribute("username", user.getUserName());
		return new BaseResponseBody(1, "登录成功");
	}
	
	@RequestMapping("/success")
	public String successLogin(HttpServletRequest request) {
		LOGGER.info("--------------------------");
		return "/pages/common/BaseHeader.html";
	}
	
	@RequestMapping("/getuserdetail")
	@ResponseBody
	public UserInfo getUserDetail(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		UserInfo info = userService.getUserByName(username);
		if (ObjectUtils.isEmpty(info)) {
			return new UserInfo();
		}
		return info;
	}
	
	@RequestMapping("/getuserimgbyusername")
	@ResponseBody
	public String getUserImgbyUsername(String username) {
		if (StringUtil.isEmpty(username)) {
			return username;
		}
		UserInfo user = userService.getUserByName(username);
		if (ObjectUtils.isEmpty(user)) {
			return null;
		}
		return user.getUserImg();
	}
	
	@RequestMapping("/getuserimg")
	@ResponseBody
	public List<String> getUserImg() {
		return userService.getUserImg();
	}

	@RequestMapping("/getcurrentuser")
	@ResponseBody
	public UserInfo getCurrentUser(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		if (StringUtil.isEmpty(username)) {
			return new UserInfo();
		}
		UserInfo userInfo = userService.getUserByName(username);
		return userInfo;
	}
	
	@RequestMapping("/handleimage")
	@ResponseBody
	public String handleImage(@RequestParam MultipartFile file, HttpServletRequest request,
			ImageAttribute imageAttribute) {
		String fileFormat = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		String path = request.getServletContext().getRealPath(File.separator);
		String filename = DateUtil.getDateString(new Date(), DateUtil.YYYY_MM_DD_HH_MM_SS_MS) + "." + fileFormat;
		String uploadImageUrl = path + SpringContextHolder.getAppConfig().getUploadImage() + filename;
		boolean b = FileUtil.createFile(uploadImageUrl);
		if (!b) {
			LOGGER.info("创建文件失败");
		}
		String handleUploadImageUrl = path + SpringContextHolder.getAppConfig().getHandleUploadImage() + filename;
		b = FileUtil.createFile(handleUploadImageUrl);
		if (!b) {
			LOGGER.info("创建文件失败");
		}
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadImageUrl));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if (ObjectUtils.isEmpty(imageAttribute) || imageAttribute.getW() == 0 || imageAttribute.getH() == 0) {
			LOGGER.info("图片对象不正确");
			return "0";
		}
		FileUtil.cutImage(uploadImageUrl, handleUploadImageUrl, imageAttribute.getX(), imageAttribute.getY(),
				imageAttribute.getW(), imageAttribute.getH(), fileFormat, fileFormat);
		return SpringContextHolder.getAppConfig().getHandleUploadImage() + filename;
	}
	
	@RequestMapping("/listbuytime")
	@ResponseBody
	public List<BuyRecord> listBuyTime(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		UserInfo userInfo = userService.getUserByName(username);
		return userService.listBuyRecord(userInfo.getPersonId());
	}
	
	@RequestMapping("/listmymessagemanage")
	@ResponseBody
	public List<MessageManageInfo> listMyMessageManage(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		UserInfo userInfo = userService.getUserByName(username);
		return userService.listMyMessage(userInfo.getPersonId());
	}
	
	@RequestMapping("/insertmessagemanage")
	@ResponseBody
	public int insertMessageManage(MessageManageInfo messageManageInfo, HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		UserInfo userInfo = userService.getUserByName(username);
		messageManageInfo.setMessageId(UUIDUtil.randomID());
		messageManageInfo.setMessagePersonId(userInfo.getPersonId());
		messageManageInfo.setMessageDisable("1");
		return userService.insertMessage(messageManageInfo);
	}
	
	@RequestMapping("/listmyfriend")
	@ResponseBody
	public List<PersonInfo> listMyFriend(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		UserInfo userInfo = userService.getUserByName(username);
		return userService.listMyFriend(userInfo.getPersonId());
	}
	
	@RequestMapping("/insertmyfriend")
	@ResponseBody
	public Result insertMyFriend(FriendInfo friendInfo, HttpServletRequest request) {
		if (ObjectUtils.isEmpty(friendInfo)) {
			return new Result(0, "参数不正确");
		}
		String username = (String) request.getSession().getAttribute("username");
		UserInfo userInfo = userService.getUserByName(username);
		friendInfo.setFriendId(UUIDUtil.randomID());
		friendInfo.setFriendMyId(userInfo.getPersonId());
		FriendInfo friendInfo2 = userService.getFriend(userInfo.getPersonId(), friendInfo.getFriendFriendId());
		if (!ObjectUtils.isEmpty(friendInfo2)) {
			return new Result(0, "此人已添加");
		}
		int result = userService.insertMyFriend(friendInfo);
		if (result == 0) {
			return new Result(0, "插入失败");
		}
		return new Result(1, "成功");
	}
	
}
