package org.wfq.odo.common.exception;

import org.wfq.odo.common.util.ResultEnum;

/**
 * 抛出异常
 */
public class CommonException extends RuntimeException {

    
	private static final long serialVersionUID = 1030643008892262130L;
	private int code;

    public CommonException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CommonException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "CommonException code: " + code + " " + super.toString();
    }
}