package com.yanrs.cloud.common.vo.req;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRegisterReqVo {
	// 用户名称
	private String username;

	// 用户邮箱
	private String email;
	
	// 密码
	private String password;

}
