package com.yanrs.cloud.common.enums;

public enum ResponseCodeEnum {
	SUCCESS(90000, "成功"),
	FAIL(30011, "失败"),
	NOT_FOUND(30012,"资源未找到"),
	NOT_AUTHED(30013,"无权限，访问拒绝"),
	PARAM_INVAILD(30014,"提交参数非法");
	
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
	private ResponseCodeEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	private ResponseCodeEnum() {
	}
}
