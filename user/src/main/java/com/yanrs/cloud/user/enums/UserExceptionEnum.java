package com.yanrs.cloud.user.enums;

public enum UserExceptionEnum {
	REGISTER_ERROR(30001, "注册错误"),
	USER_EXIST(30002, "用户已存在"),
	EMAIL_EXIST(30003, "邮箱错误");
	
	private Integer code;
	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private UserExceptionEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	private UserExceptionEnum() {
	}
}
