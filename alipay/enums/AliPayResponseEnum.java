package com.qinwutong.alipay.enums;

public enum AliPayResponseEnum {

    SUCCESS("10000","接口调用成功"),
    SERVICE_NOT_USE("20000","服务不可用"),
    NO_USER_PERMISSION("20001","授权权限不足"),
    MISSION_PARAMETERS("40001","缺少必选参数"),
    ILLEGAL_PARAMETERS("40002","非法的参数"),
    BUSINESS_PROCESSING_FAILED("40004","业务处理失败"),
    SERVER_PERMISSION("40006","权限不足"),
    FAILURE("00000","接口调用失败");

    final String type;

    final String state;

    public final String getState() {
        return state;
    }

    AliPayResponseEnum(String type,String state){
        this.state = state;
        this.type = type;
    }

    public static AliPayResponseEnum stateOf(String state) {
        for (AliPayResponseEnum value : values()) {
            if (value.getState().equals(state) ) {
                return value;
            }
        }
        return null;
    }

    public final String getType(){
        return type;
    }

}
