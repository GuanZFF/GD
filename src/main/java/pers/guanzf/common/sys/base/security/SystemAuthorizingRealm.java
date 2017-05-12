package pers.guanzf.common.sys.base.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import pers.guanzf.common.core.model.User;
import pers.guanzf.common.core.service.UserService;

@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	/**
	 * 授权回调函数
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 认证回调函数, 登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userService.getUserByName(token.getUsername());

		if (!ObjectUtils.isEmpty(user)) {
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),
					user.getUserPassword(), getName());
			return authenticationInfo;
		}
		return null;
	}

}
