package com.yanrs.cloud.user.exception;

import com.yanrs.cloud.user.enums.UserExceptionEnum;

public class UserException extends RuntimeException {

	/**
	 * UserException 
	 */
	private static final long serialVersionUID = 1L;

	public UserException(UserExceptionEnum userExceptionEnum) {
		super(userExceptionEnum.getMessage());
	}
}
