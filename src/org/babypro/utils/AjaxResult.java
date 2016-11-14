package org.babypro.utils;

/**
 * Created by apple on 2016/11/14.
 */
public class AjaxResult {

    private boolean success = true;
    private String message;
    private Integer errorCode = -99;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean pSuccess) {
        success = pSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String pMessage) {
        message = pMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer pErrorCode) {
        errorCode = pErrorCode;
    }
}
