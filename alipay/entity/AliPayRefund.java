package com.qinwutong.alipay.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AliPayRefund {
    // id
    private Integer id;
    // 标示一次退款请求，在一个订单并非一次全部退款时使用
    private String outRefundNo;
    // 支付宝交易号
    private String tradeNo;
    // 商户订单号
    private String outTradeNo;
    // 用户的登录id
    private String buyerLogonId;
    // 退款总金额
    private String refundFee;
    // 退款币种信息
    private String refundCurrency;
    // 退款支付时间
    private Date gmtRefundPay;
    // 买家在支付宝的用户id
    private String buyerUserId;
    // 接口调用结果
    private String type;

}