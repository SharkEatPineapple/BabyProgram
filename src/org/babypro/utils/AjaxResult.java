package org.babypro.utils;

/**
 * Created by apple on 2016/11/14.
 */
public class AjaxResult {

    private boolean success = true;
    private String message;
    private Integer errorCode = -99;
    private String result;

    public AjaxResult(Boolean pSuccess, String pMessage){
        success = pSuccess;
        message = pMessage;
    }


    public AjaxResult(Boolean pSuccess, String pMessage, Integer pErrorCode){
        success = pSuccess;
        message = pMessage;
        errorCode = pErrorCode;
    }


    public AjaxResult(Boolean pSuccess, String pMessage, String pResult){
        success = pSuccess;
        message = pMessage;
        result = pResult;
    }



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

    public String getResult() {
        return result;
    }

    public void setResult(String pResult) {
        result = pResult;
    }
}
