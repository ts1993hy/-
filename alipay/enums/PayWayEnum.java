package com.qinwutong.alipay.enums;

/**
 * 支付方式
 * */
public enum PayWayEnum{

    PC_PAY("FAST_INSTANT_TRADE_PAY","PC支付"),
    APP_PAY("QUICK_MSECURITY_PAY","APP支付"),
    QUICK_WAP_PAY("QUICK_WAP_PAY","移动H5支付");

    final String type;

    final String state;

    public final String getState() {
        return state;
    }

    PayWayEnum(String type,String state){
        this.state = state;
        this.type = type;
    }

    public static PayWayEnum stateOf(String state) {
        for (PayWayEnum value : values()) {
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