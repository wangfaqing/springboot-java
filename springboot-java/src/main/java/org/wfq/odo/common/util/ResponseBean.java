package org.wfq.odo.common.util;

/**
 * 包装Json响应的Bean
 * Created by guofe on 2015/9/29.
 */
public class ResponseBean<T> {

    /**
     * 返回代码，0 正确，负数 程序异常，正数 校验错误
     */
    private int code;

    /**
     * 额外信息
     */
    private String message;
    /**
     * 接口定义id
     */
    private String intefaceId;

    /**
     * 返回结果
     */
    private T result;

    public ResponseBean() {
    }

    public ResponseBean(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public ResponseBean(ResultEnum resultEnum, T result) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.result = result;
    }

    public ResponseBean(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
    
    

    public String getIntefaceId() {
		return intefaceId;
	}

	public void setIntefaceId(String intefaceId) {
		this.intefaceId = intefaceId;
	}

	@Override
    public String toString() {
        if (code == 0) {
            if (message == null) {
                if (result != null) {
                    return result.toString();
                }
            } else {
                if (result != null) {
                    return message + ": " + result.toString();
                } else {
                    return message;
                }
            }
        } else {
            return code + " on " + message;
        }
        return null;
    }
}
