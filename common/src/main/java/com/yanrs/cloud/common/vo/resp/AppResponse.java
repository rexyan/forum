package com.yanrs.cloud.common.vo.resp;

import com.yanrs.cloud.common.enums.ResponseCodeEnum;

import lombok.Data;

@Data
public class AppResponse<T> {
	private Integer code;
	private String message;
	private T data;
	
	public static<T> AppResponse<T> success(T Data) {
		AppResponse<T> appResponse = new AppResponse<T>();
		appResponse.setData(Data);
		appResponse.setCode(ResponseCodeEnum.SUCCESS.getCode());
		appResponse.setMessage(ResponseCodeEnum.SUCCESS.getMessage());
		return appResponse;
	}
	
	public static<T> AppResponse<T> fail(T Data) {
		AppResponse<T> appResponse = new AppResponse<T>();
		appResponse.setData(Data);
		appResponse.setCode(ResponseCodeEnum.FAIL.getCode());
		appResponse.setMessage(ResponseCodeEnum.FAIL.getMessage());
		return appResponse;
	}
}
