package com.qinwutong.alipay.enums;

/**
 * 交易状态
 * */
public enum TradeStatusEnum{

    // 不触发通知
    TRADE_FINISHED("TRADE_FINISHED","交易完成"),
    // 触发通知
    TRADE_SUCCESS("TRADE_SUCCESS","支付成功"),
    // 不触发通知
    WAIT_BUYER_PAY("WAIT_BUYER_PAY","交易创建"),
    // 不触发通知
    TRADE_CLOSED("TRADE_CLOSED","交易关闭");

    final String type;

    final String state;

    public final String getState() {
        return state;
    }

    TradeStatusEnum(String type,String state){
        this.state = state;
        this.type = type;
    }

    public static TradeStatusEnum stateOf(String state) {
        for (TradeStatusEnum value : values()) {
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
