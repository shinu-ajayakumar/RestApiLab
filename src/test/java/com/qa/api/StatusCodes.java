package com.qa.api;

public class StatusCodes {

	private final static int SUCCESS_200 = 200;
	private final static int CREATED_201 = 201;
	private final static int UNAUTHORIZED_401 = 401;
	private final static int NOT_FOUND_404 = 404;

	public static int getSuccessCode200() {
		return SUCCESS_200;
	}

	public static int getCreatedCode201() {
		return CREATED_201;
	}

	public static int getUnauthorizedCode401() {
		return UNAUTHORIZED_401;
	}

	public static int getNotFoundCode404() {
		return NOT_FOUND_404;
	}
}
