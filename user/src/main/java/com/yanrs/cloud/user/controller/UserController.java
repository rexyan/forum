package com.yanrs.cloud.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yanrs.cloud.common.vo.req.UserRegisterReqVo;
import com.yanrs.cloud.common.vo.resp.AppResponse;
import com.yanrs.cloud.user.bean.Userinfo;
import com.yanrs.cloud.user.enums.UserExceptionEnum;
import com.yanrs.cloud.user.exception.UserException;
import com.yanrs.cloud.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public AppResponse<Object> register(UserRegisterReqVo userRegisterReqVo) {
		log.info("register, params: {}", userRegisterReqVo);

		try {
			// username 是否存在
			Boolean usernameExist = userService.checkUsername(userRegisterReqVo.getUsername());
			if (usernameExist) {
				throw new UserException(UserExceptionEnum.USER_EXIST);
			}
			// email 是否存在
			Boolean emailExist = userService.checkEmail(userRegisterReqVo.getEmail());
			if (emailExist) {
				throw new UserException(UserExceptionEnum.EMAIL_EXIST);
			}
			// 注册
			String accessToken = userService.register(userRegisterReqVo);
			return AppResponse.success(accessToken);
		} catch (Exception e) {
			log.error("register error: {}", e.getMessage());
			AppResponse<Object> appResponse = AppResponse.fail(null);
			appResponse.setMessage(e.getMessage());
			return appResponse;
		}
	}
	
	@PostMapping("/login")
	public AppResponse<Object> login(UserRegisterReqVo userRegisterReqVo) {
		log.info("login, params: {}", userRegisterReqVo);
		
		String username = userRegisterReqVo.getUsername();
		String password = userRegisterReqVo.getPassword();
		List<Userinfo> userinfoList = userService.userLogin(username, password);
		
		if (userinfoList==null || userinfoList.size() == 0) {
			AppResponse<Object> appResponse = new AppResponse<>();
			appResponse.setData(null);
			appResponse.setMessage("账号或密码不正确");
			return appResponse;
		}else {
			Userinfo userinfo = userinfoList.get(0);
			return AppResponse.success(userinfo);
		}
	}
}
