package com.qinwutong.alipay.entity;

import lombok.Data;

@Data
public class AliPayDetails {

    private Integer id;
    // 交易创建时间
    private String gmtCreate;
    // 交易主题
    private String subject;
    // 买家支付宝用户号
    private String buyerId;
    // 通知校验id
    private String notifyId;
    // 商户订单号（咱们的真实订单号）
    private String outTradeNo;
    // 订单金额
    private String totalAmount;
    // 交易状态
    private String tradeStatus;
    // 支付宝交易号
    private String tradeNo;
    //
    private String authAppId;
    // 商家在交易中实际收到的款项，单位为元
    private String receiptAmount;
    // 使用集分宝支付的金额
    private String pointAmount;
    // 支付宝分配给开发者的应用Id
    private String appId;
    // 用户在交易中支付的金额
    private String buyerPayAmount;
    // 卖家支付宝用户号
    private String sellerId;
    // 验签状态
    private Boolean checkStatus;

    private Integer purchaseId;

    private Integer type;
}