package com.autoorder.utils.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.baidu.api.Baidu;
import com.baidu.api.BaiduApiClient;
import com.baidu.api.BaiduApiException;
import com.baidu.api.BaiduOAuthException;
import com.baidu.api.domain.Session;
import com.baidu.api.domain.User;
import com.baidu.api.service.IUserService;
import com.baidu.api.service.impl.UserServiceImpl;
import com.baidu.api.store.BaiduCookieStore;
import com.baidu.api.store.BaiduStore;

/**
 * @autor Seaven
 * @time 上午1:30:03
 *
 */
@Component("baiduAuthUtils")
public class BaiduAuthUtils {
	private static final Logger logger = Logger.getLogger(BaiduAuthUtils.class);
	
	private static final String CLIENT_ID = "kcqb2uI1oNT330nBGEVrGZ0X";
	
	private static final String CLIENT_SECRET = "aOhiWzOlkW8GbvAwQBpsvzG8pcKR1O9F";
	
	public static String REDIRECT_URI = "";
	
	/**
	 * 取得baidu token
	 * @param response
	 * @param request
	 * @return
	 */
	public String getAccessToken(HttpServletResponse response, HttpServletRequest request) {
		BaiduStore store = new BaiduCookieStore(CLIENT_ID, request, response);
		Session session = store.getSession();
		if (null != session) {
			return session.getToken().getAccessToken();
		}

		Baidu baidu = null;
		try {
			baidu = new Baidu(CLIENT_ID, CLIENT_SECRET, REDIRECT_URI, store, request);
			return baidu.getAccessToken();
		} catch (BaiduApiException e) {
			logger.debug("BaiduApiException", e);
		} catch (BaiduOAuthException e) {
			logger.debug("BaiduOAuthException ", e);
		}

		return null;
	}
    
    /**
     * 取得baidu code
     * @param request
     * @param response
     * @throws IOException
     */
    public void getBaiDuCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BaiduStore store = new BaiduCookieStore(CLIENT_ID, request, response);
        Baidu baidu = null;
        try {
            baidu = new Baidu(CLIENT_ID, CLIENT_SECRET, REDIRECT_URI, store, request);
            String state = baidu.getState();
            Map<String, String> params = new HashMap<String, String>();
            params.put("state", state);
            String authorizeUrl = baidu.getBaiduOAuth2Service().getAuthorizeUrl(params);
            response.sendRedirect(authorizeUrl);
        } catch (BaiduOAuthException e) {
            logger.debug("BaiduOAuthException ", e);
        } catch (BaiduApiException e) {
            logger.debug("BaiduApiException ", e);
        }
    }
    
    /**
     * 取得当前登陆的百度用户
     * @param request
     * @param response
     * @return
     */
	public User getLoginUser(HttpServletRequest request, HttpServletResponse response) {
		String token = getAccessToken(response, request);
		IUserService userService = new UserServiceImpl(new BaiduApiClient(token));
		User loggedInUser = null;
		try {
			loggedInUser = userService.getLoggedInUser();
		} catch (BaiduApiException e) {
            logger.debug("BaiduApiException ", e);
		}
		return loggedInUser;
	}
}
