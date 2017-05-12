package pers.guanzf.common.core.controller;

import java.io.File;
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

import pers.guanzf.common.core.model.User;
import pers.guanzf.common.core.model.info.UserInfo;
import pers.guanzf.common.core.service.UserService;
import pers.guanzf.common.sys.base.model.BaseResponseBody;
import pers.guanzf.common.sys.base.model.Result;
import pers.guanzf.common.sys.kernel.MD5;
import pers.guanzf.common.util.FileUtil;
import pers.guanzf.common.util.StringUtil;
import pers.guanzf.common.util.UUIDUtil;

@Controller
@RequestMapping("/usercontroller")
public class UserController {
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/adduser")
	@ResponseBody
	public BaseResponseBody addUser(HttpServletRequest request, UserInfo user, @RequestParam("userImg") MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			StringBuffer folderName = new StringBuffer();
			folderName.append(StringUtil.getPingYin(user.getUserName()));
			StringBuffer filePathBuf = new StringBuffer();
			filePathBuf.append(File.separator).append("upload").append(File.separator).append("img").append(File.separator).append(folderName);
			String realPath = request.getSession().getServletContext().getRealPath(filePathBuf.toString());
			Result imgResult = FileUtil.uploadFile(file, realPath, folderName.toString());
			if (0 == imgResult.getFlag()) {
				return new BaseResponseBody();
			}
		}
		if (ObjectUtils.isEmpty(user)) {
			return new BaseResponseBody(0, "参数错误");
		}
		User user1 = userService.getUserByName(user.getUserName());
		if (!ObjectUtils.isEmpty(user1)) {
			return new BaseResponseBody(0, "用户名已存在");
		}
		user.setUserId(UUIDUtil.randomID());
		user.setUserPassword(MD5.encode16(user.getUserPassword()));
		int result = userService.addUser(user);
		if (result == 1) {
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
}
