package com.qinwutong.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qinwutong.alipay.entity.AliPayDetails;
import com.qinwutong.alipay.entity.AliPayRefund;
import com.qinwutong.alipay.enums.AliPayResponseEnum;
import com.qinwutong.alipay.enums.PayWayEnum;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AliPayUtil {

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    private static final String appID ="2018101761697620";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    private static final String merchantPrivateKey="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCVIcrqLg12zWbO2rcm7meJqbuIcZsdcN/W0I49De4w0xczwJ32G/F5fcWu7DVSXYdaN6hhMpRWdUcsn/LarLHWfNsJhWWrCuVn4iqv/IMIz0mUt1ALVXILEo1eyTOf/OCyz2boXj+p7jvBK0osMVF7whB8ctEzeSNILwLlFC6FWbIrrgyAJGpzhk9jlaKNILHwi+H/kc9G/kIe2R1s+0yZl+60/de2vD1MZ6VbHSfRvxqH+WesgHJx/pqZj5SGZrzCQju1mJxX7ODVXrr5fMTPcIkm6TGUeaYTmYnMm+IbhzOB7+/2wIRVzJJMgJI+rpqHTxJaVUnva6Tq706o9uBXAgMBAAECggEAbpwBxG8jzVnLRuExts5cPN6HGUwpoEx3uPw2g1IxuETYkKnsfv16vIFsfbD0W4LDQUbGvFCndPjHMXHwzgAIZu10CDvIjHQockRtJNpE1ePoz0SnOcDGNTAtaoAQqjkE75qk2PQOhBsOdteEzAJITWJCmAsQ3vyaDo/PtdiiKISZPTZzybzlhZHYJP3xptAWe8zCQAClA+gbfg+ZM4+xZimCkg3YffDgfO+tSourPcKIfGn8xNAmZhzmjdAy0W0OwMEu303QPQQX8m9YpueG6ej+XbSk/gofyQUQN/r8szcGuQ6bKViG++9o5nylb4CTIubPwYGX87MPNjHK0LFzAQKBgQDj0edvujXQgQZbWnrTvXRvJK2ib7Ww9OitwKLsBTELC9kYPBpzPCoPVyz2fOo7m3E8is6f12PkiQPwhvCVFy3LVNFmWJfQBqXsPkpaSg+Ws0UqqEY6Cbka2gUqzGewdwD5eVbWZ2hF/7KbpKzAbFiIhGw/BlLTx0DKIN4fEE+jZQKBgQCnlCx8E7S26/j4olo5oqpr2wTaNQGBj93MdOe0AEO90K3wR+1y6RQgO+1xDBOhKm80HUJpNUZ1sVijcY2iu7yQyTTsHM9WHpxKbDvsnjw7q1Z4Pqmxq9+Qr4bBcGMa/A6Z1/LSJRDeVXpWmnvzoe+Wy87XKRxzLgIN+WtYXjE/CwKBgQCOLwToYCkR9lTHUxLxb35pl1Se2mVlCZTmTCHid+MB5+UYEPrZDKWbaWbwd0mg5gSoKmGGtODtUu4Ygb9I7WxxSIBgBc7J0Dxh0waIj0xnW39BfkBGHKdgMM2kxmm4Yq1DBg3CRkt31HveU8pVVclzemIse3/aGLNA835tmLp7WQKBgQCJLwGjqTYdMNumHrIh0IoWtTspro7HE5EM2P79GeJat0RNGXTGxwuUv7pG+w3ut6BFV1aQbe56Vm4rjr/V4j4hgLV0PLl21KQ5QJVlxLumVUL6OMIOEpd4CFkWbfyTkJgbVO8RHQrMF8mIr/qcnYpXNgzjkmIZ4CYKbo5zztgdtQKBgQDBjZFPwCszltAnwvzFaIesK8KOOh+qCKhaDz0KpOpnG+KzbIBfaRnHYPeMm3f7+Ztlh+R8A0Xwj91W01rWDwl5dBqX0S4rZGAjV5c+zcl+8FlOmG1BOtUFcIvKGpSl+AmbKgCPWVVVfqpcoyh34gw3G5L7srW0SlNObm4GCugjew==";
    /**
     * 支付宝公钥
     */
    private static final String alipayPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8hMBr7cqTwEMIWACEWNqWhcWHmD9yt3CaZrk8Cq3UbAI2mL7I3BGgOI8yWxyA0ojGaFRCcb4rr5+yVCS2yw0VhXn5x/mHS9RsPlFAxbB20HJfZaTLrAXHaw5sSajwb3O3sjViJalTh+Qp4ajh2UijujyQN9b3dUIjSrLZXZhx4lobs7QWsLuySffqG8v+8x/zgr6UK3S0XSe9nXoBSP+fRvJoxhl3HvB/yeJJyp76XrmPA6bD5qA6lB/KGvpwEeAdhGv0/orA1heD4B5z1FJLgPS773X8/OQezLG09ZKay1YH4iMv7OlgUqOZ1t2gnFO97CnBCq5MRNHu4/EbI7VdQIDAQAB";
    /**
     * 签名方式
     */
    private static final String signType="RSA2";

    /**
     * 网关 ~ serverUrl
     */
    private static final String gatewayUrl="https://openapi.alipay.com/gateway.do";

    /**
     * 编码
     */
    private static final String charset = "utf-8";

    /**
     * 类型
     */
    private static final String format="json";

    /**
     * 商户号
     */
    private static final String sysServiceProviderId="2088231588475221";


    /**
     * @param orderId 订单号
     * @param totalAmount 金额总计（例如：1.10元）
     * @param subject 订单主题，例如（陕西省勤务通：用户充值）
     * @param notifyUrl 异步通知的url，例如（http://132.232.225.239:8080/qinwutong/purchase/ali/recharge/notify）
     * @param payWayEnum 支付方式（APP支付、PC支付、移动H5支付）
     * @return html页面的字符串
     */ 
    public static String payWithPage(Long orderId,String totalAmount,String subject,String notifyUrl,PayWayEnum payWayEnum) throws JsonProcessingException, AlipayApiException {

        //参数校验
        Assert.notNull(orderId,"订单号不为空");
        Assert.notNull(totalAmount,"订单金额不为空");
        Assert.notNull(subject,"主体不为空");
        Assert.notNull(notifyUrl,"异步通知的Url");

        AlipayClient client = new DefaultAlipayClient(gatewayUrl,appID,merchantPrivateKey,format,charset,alipayPublicKey,signType); //获得初始化的AlipayClient

        Map<String,Object> map = new HashMap<>();
        // 商户订单号
        map.put("out_trade_no", orderId);
        // 产品码, APP支付 QUICK_MSECURITY_PAY, PC支付 FAST_INSTANT_TRADE_PAY, 移动H5支付 QUICK_WAP_PAY
        map.put("product_code", payWayEnum.getType());
        // 订单标题
        map.put("subject",subject);
        // 订单金额总计
        map.put("total_amount", totalAmount);

        ObjectMapper mapper = new ObjectMapper();

        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        // 设置异步通知的url
        request.setNotifyUrl(notifyUrl);
        request.setBizContent(mapper.writeValueAsString(map));
        // 返回的是页面，在这里以字符串形式返回
        return client.pageExecute(request).getBody();
    }

    /**
     * 接受服务器端的异步通知后，如果商户反馈给支付宝的字符不是success这7个字符，支付宝服务器会不断重发通知，直到超过24小时22分钟。
     * 一般情况下，25小时以内完成8次通知（通知的间隔频率一般是：4m,10m,10m,1h,2h,6h,15h）；
     * */
    public static AliPayDetails payNotifyCheck(Map<String,String[]> paramMap) throws AlipayApiException {

        AliPayDetails details = new AliPayDetails();
        details.setGmtCreate(paramMap.get("gmt_create")[0]);
        details.setSubject(paramMap.get("subject")[0]);
        details.setBuyerId(paramMap.get("buyer_id")[0]);
        details.setNotifyId(paramMap.get("notify_id")[0]);
        details.setOutTradeNo(paramMap.get("out_trade_no")[0]);
        details.setTotalAmount(paramMap.get("total_amount")[0]);
        details.setTradeStatus(paramMap.get("trade_status")[0]);
        details.setTradeNo(paramMap.get("trade_no")[0]);
        details.setAuthAppId(paramMap.get("auth_app_id")[0]);
        details.setReceiptAmount(paramMap.get("receipt_amount")[0]);
        details.setPointAmount(paramMap.get("point_amount")[0]);
        details.setAppId(paramMap.get("app_id")[0]);
        details.setBuyerPayAmount(paramMap.get("buyer_pay_amount")[0]);
        details.setSellerId(paramMap.get("seller_id")[0]);
        details.setType(1);
        Map<String,String> params = new HashMap<>();
        for (String name:paramMap.keySet()) {
            String[] values = paramMap.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        // flag表示验签状态，false为失败，true为成功
        boolean flag = AlipaySignature.rsaCheckV1(params,alipayPublicKey,charset,signType);
        details.setCheckStatus(flag);
        return details;
    }

    public static AliPayRefund refund(Long orderId,String refundAmount,PayWayEnum payWayEnum) throws JsonProcessingException, AlipayApiException {
        //可以方便地修改日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String now = dateFormat.format(new Date());
        Map<String,Object> map = new HashMap<>();
        // 退款金额
        map.put("refund_amount", refundAmount);
        //商户订单号
        map.put("out_trade_no", orderId);
        //产品码, APP支付 QUICK_MSECURITY_PAY, PC支付 FAST_INSTANT_TRADE_PAY, 移动H5支付 QUICK_WAP_PAY
        map.put("trade_no", payWayEnum.getType());
        map.put("out_request_no",payWayEnum.getType() + now);
        AlipayClient client = new DefaultAlipayClient(gatewayUrl,appID,merchantPrivateKey,format,charset,alipayPublicKey,signType); //获得初始化的AlipayClient
        AlipayTradeRefundRequest refundRequest = new AlipayTradeRefundRequest();
        ObjectMapper mapper = new ObjectMapper();
        refundRequest.setBizContent(mapper.writeValueAsString(map));
        AlipayTradeRefundResponse aliPayResponse = client.execute(refundRequest);
        AliPayRefund aliPayRefund = new AliPayRefund();
        // 接口调用成功
        if(aliPayResponse.isSuccess()){
            //业务执行成功
            if(AliPayResponseEnum.SUCCESS.getState().equals(aliPayResponse.getCode())){
                aliPayRefund.setType(AliPayResponseEnum.SUCCESS.getType());
            }else {
                aliPayRefund.setType(AliPayResponseEnum.stateOf(aliPayResponse.getCode()).getType());
            }
        }else {
            aliPayRefund.setType(AliPayResponseEnum.FAILURE.getType());
        }
        aliPayRefund.setBuyerLogonId(aliPayResponse.getBuyerLogonId());
        aliPayRefund.setBuyerUserId(aliPayResponse.getBuyerUserId());
        aliPayRefund.setGmtRefundPay(aliPayResponse.getGmtRefundPay());
        aliPayRefund.setOutRefundNo(payWayEnum.getType() + now);
        aliPayRefund.setOutTradeNo(aliPayResponse.getOutTradeNo());
        aliPayRefund.setRefundCurrency(aliPayResponse.getRefundCurrency());
        aliPayRefund.setRefundFee(aliPayResponse.getRefundFee());
        aliPayRefund.setTradeNo(aliPayResponse.getTradeNo());
        return aliPayRefund;
    }







}
