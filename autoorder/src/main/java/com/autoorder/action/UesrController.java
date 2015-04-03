package com.autoorder.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autoorder.bo.BaiduUser;
import com.autoorder.utils.common.BaiduAuthUtils;
import com.baidu.api.domain.User;

/**
 * @autor Seaven
 * @time 下午11:42:14
 *
 */
@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UesrController {

	@Resource(name = "baiduAuthUtils")
	BaiduAuthUtils authUtils;
	
	/**
	 * 百度passport cookie 我们用这玩意做用户是否登录检验
	 */
	private static final String BAIDU_COOKIE_UID = "BAIDUID";

	private static final String BAIDU_SESSION_USER = "loginUser";

	private static final String USER_IS_LOGIN = "isLogin";

	@ResponseBody
	@RequestMapping("/baiduCode.do")
	public void getBaiduCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		authUtils.getBaiDuCode(request, response);
	}
	
	/**
	 * 登陆
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/login.do")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

		User baiduUser = authUtils.getLoginUser(request, response);

		BaiduUser user = new BaiduUser();

		if (null != baiduUser) {
			user.setPassportid(baiduUser.getUid());
			user.setUserName(baiduUser.getUname());
			user.setUserPhoto(baiduUser.getPortrait());

			HttpSession session = request.getSession();
			Cookie cookie = getBaiduCookie(request);
			
			if (null != cookie) {
				session.setAttribute(BAIDU_SESSION_USER, user);
				session.setAttribute(BAIDU_COOKIE_UID, cookie.getName());
			}
		}
		
		response.sendRedirect("../html/main.html");
	}

	/**
	 * 是否登陆
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkLogin.do")
	public Map<String, Object> checkLogin(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		
		Cookie cookie = getBaiduCookie(request);

		if (null != cookie) {
			Object cookieName = session.getAttribute(BAIDU_COOKIE_UID);

			if (null != cookieName && cookieName.equals(cookie.getName())) {
				map.put(BAIDU_SESSION_USER, session.getAttribute(BAIDU_SESSION_USER));
				map.put(USER_IS_LOGIN, true);
			} else {
				map.put(USER_IS_LOGIN, false);
			}
		}
		return map;
	}

	/**
	 * 取baidu的cookie
	 * @param request
	 * @return
	 */
	private Cookie getBaiduCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			if (BAIDU_COOKIE_UID.equals(cookie.getName())) {
				return cookie;
			}
		}
		
		return null;
	}
}
