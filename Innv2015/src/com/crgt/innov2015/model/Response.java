package com.crgt.innov2015.model;

import com.crgt.innov2015.util.Constants;

/**
 * Base response class
 * @author mvattipulusu
 *
 */
public class Response {

	private int result = 0;
	
	private String message = Constants.FAILURE_MESSAGE;


	public Response(int result, String message) {
		super();
		this.result = result;
		this.message = message;
	}
	public Response() {
		// TODO Auto-generated constructor stub
	}
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Code ="+result);
		sb.append("\n message ="+message);
		return sb.toString();
	}
	
	
}
