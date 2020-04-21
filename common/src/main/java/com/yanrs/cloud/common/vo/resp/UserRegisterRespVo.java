package com.yanrs.cloud.common.vo.resp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRegisterRespVo {
	// accessToken
	private String accessToken;
	
	// 用户名称
	private String username;
	
	// 用户邮箱
	private String email;
	
	// 注册时间
	private String createAt;
}
