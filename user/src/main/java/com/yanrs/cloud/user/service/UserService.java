package com.yanrs.cloud.user.service;

import java.util.List;

import com.yanrs.cloud.common.vo.req.UserRegisterReqVo;
import com.yanrs.cloud.user.bean.Userinfo;

public interface UserService {
	
	/**
	 * 注册
	 * @param userRegisterReqVo
	 * @return
	 */
	String register(UserRegisterReqVo userRegisterReqVo);

	/**
	 * 检查用户名
	 * @param username
	 * @return
	 */
	Boolean checkUsername(String username);
	
	/**
	 * 检查邮箱
	 * @param email
	 * @return
	 */
	Boolean checkEmail(String email);
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	List<Userinfo> userLogin(String username, String password);

}
