package com.mysheng.office.base;

import java.io.Serializable;
import java.util.Collection;

/**
 * <pre>
 * <p>Title: 返回结果</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010 - 2016 </p>
 * <p>Company: Beijing Risenb Technology Co.,Ltd. </p>
 * <p>Build: 2016年11月7日 下午4:17:17 </p>
 * </pre>
 *
 * @author Chang Yuxin
 * @version 1.0
 */
public class Results implements Serializable {
	private static final long serialVersionUID = -5781099453947447091L;
	public static final String SUCCESS = "0";
	public static final String FAILURE = "1";

	/** 状态 */
	private String status = "";

	/** 系统错误代码 */
	private String errorCode = "";

	/** 消息 */
	private String errorMsg = "";

	/** 总数 */
	private long total;

	/** 结果 */
	private Object data;
	/**
	 * 后台管理使用展示信息
	 */
	private String msg;

	public Results() {
		super();
	}

	/**
	 * 返回成功的对象
	 * 
	 * @return Result
	 */
	public static Results success() {
		return new Results(SUCCESS, "", "", "");
	}

	/**
	 * 返回成功对象
	 * 
	 * @param msg
	 * @return
	 */
	public static Results success(String msg) {
		return new Results(SUCCESS, msg);
	}

	/**
	 * 返回成功的对象
	 * 
	 * @return Result
	 */
	public static Results success(Results result) {
		result.setStatus(SUCCESS);
		return result;
	}

	/**
	 * 返回成功的对象
	 * 
	 * @param data
	 * @return Result
	 */
	public static Results success(Object data) {
		return new Results(SUCCESS, "", "", data);
	}

	/**
	 * 返回成功的对象
	 * 
	 * @param data
	 * @param total
	 * @return esult
	 */
	public static Results success(Object data, long total) {
		return new Results(SUCCESS, "", "", data, total);
	}

	/**
	 * 返回失败对象
	 * 
	 * @param error
	 * @return Result
	 */
	public static Results failure(Errors error) {
		return new Results(FAILURE, error.getErrorCode(), error.getErrorMsg(), "");
	}

	/**
	 * 返回失败对象
	 * 
	 * @param errorCode
	 * @return Result
	 */
	public static Results failure(String errorCode) {
		return new Results(FAILURE, Errors.code(errorCode), Errors.msg(errorCode), null);
	}

	/**
	 * 返回失败对象
	 * 
	 * @param errorCode
	 * @return Result
	 */
	public static Results failure(String msg, Error errorCode) {
		return new Results(FAILURE, msg);
	}

	/**
	 * 返回失败对象
	 * 
	 * @param errorCode
	 * @param errorMsg
	 * @return Result
	 */
	public static Results failure(String errorCode, String errorMsg) {
		return new Results(FAILURE, Errors.code(errorCode), errorMsg + Errors.msg(errorCode), null);
	}
	
	public static Results fail(String msg) {
		return new Results(FAILURE, msg);
	}
	/**
	 * 返回失败对象
	 * 
	 * @param error
	 * @param errorMsg
	 * @return Result
	 */
	public static Results failure(Errors error, String errorMsg) {
		return new Results(FAILURE, error.getErrorCode(), errorMsg + error.getErrorMsg(), "");
	}

	/**
	 * 返回失败对象
	 * 
	 * @param error
	 * @param errorMsg
	 * @param limitCondition
	 *            限制条件,如最大长度
	 * @return Result
	 */
	public static Results failure(Errors error, String errorMsg, String limitCondition) {
		return new Results(FAILURE, error.getErrorCode(), errorMsg + error.getErrorMsg() + limitCondition, "");
	}

	/**
	 * 生成返回结果对象,不包含总数量
	 * 
	 * @param status
	 * @param msg
	 * @param data
	 */
	public Results(String status, String errorCode, String errorMsg, Object data) {
		this.status = status;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.data = data;
		if (null != data) {
			if (data instanceof Collection) {
				this.total = ((Collection<?>) data).size();
			} else if (data instanceof CharSequence) {
				this.total = ((CharSequence) data).length();
			}
		}
	}

	/**
	 * 返回成功对象 带展示信息
	 * 
	 * @param status
	 * @param errorCode
	 * @param errorMsg
	 * @param data
	 */
	public Results(String status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	/**
	 * 生成返回结果对象，包含总数量
	 * 
	 * @param status
	 * @param msg
	 * @param data
	 */
	public Results(String status, String errorCode, String errorMsg, Object data, long total) {
		this.status = status;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.data = data;
		this.total = total;
	}

	public static Results failure(Object data) {
		return new Results(FAILURE, "", "", data);
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg
	 *            the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
