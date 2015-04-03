package com.autoorder.bo;

/**
 * 存放百度passport 的用户id和用户名
 * @autor Seaven
 * @time 下午11:51:55
 *
 */
public class BaiduUser {
	
	/**
	 * Baidu passportID
	 */
	private Long passportid;
	
	/**
	 * Baidu 用户名
	 */
	private String userName;
	
	/**
	 * Baidu 用户头像地址
	 * 可用 http://tb.himg.baidu.com/sys/portraitn/item/{userPhoto} 显示 
	 */
	private String userPhoto;

	public Long getPassportid() {
		return passportid;
	}

	public void setPassportid(Long passportid) {
		this.passportid = passportid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
}
