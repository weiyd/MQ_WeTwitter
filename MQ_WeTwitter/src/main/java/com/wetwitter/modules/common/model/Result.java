package com.wetwitter.modules.common.model;

import java.io.Serializable;
import java.util.Map;

public class Result implements Serializable
{
	/**
	 * code
	 */
	private Integer resultCode;
	
	/**
	 * Desc
	 */
	private String resultMsg;
	
	/**
	 * 扩展用
	 */
	private Map<String,Object> extend;
	
	public Result()
	{
		
	}
	
	public Result(Integer resultCode, String resultMsg) 
	{
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.extend = null;
	}

	public Result(Integer resultCode, String resultMsg, Map<String, Object> extend) 
	{
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.extend = extend;
	}
	
	public static Result success()
	{
		Result result = new Result();
		result.setResultCode(200);
		result.setResultMsg("success");
		return result;
	}
	
	public static Result fail()
	{
		Result result = new Result();
		result.setResultCode(500);
		result.setResultMsg("fail");
		return result;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
}
