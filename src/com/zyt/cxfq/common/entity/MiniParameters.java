package com.zyt.cxfq.common.entity;

/**
 * 小程序传参类
 * @author Administrator
 *
 */
public class MiniParameters {
	public String appid;// "申请的appid"; } }
	public String mchid;// "申请的商户号"; } }
	public String nonce;// return Helper.GetNoncestr(); } }
	public String notify_url;// "http://yourdomain.com/notifyurl"; } }
	public String body;// "testpay"; } }
	public String out_trade_no;//
	public String spbill_create_ip;// "IP地址"; } }
	public String total_fee;// "1"; } }
	public String trade_type;// "JSAPI"; } }
	public String key;// "在商家后台设置的密钥"; } }
	public String secret;// "在配置小程序时的密钥"; } }
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMchid() {
		return mchid;
	}
	public void setMchid(String mchid) {
		this.mchid = mchid;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	@Override
	public String toString() {
		return "MiniParameters [appid=" + appid + ", mchid=" + mchid + ", nonce=" + nonce + ", notify_url=" + notify_url
				+ ", body=" + body + ", out_trade_no=" + out_trade_no + ", spbill_create_ip=" + spbill_create_ip
				+ ", total_fee=" + total_fee + ", trade_type=" + trade_type + ", key=" + key + ", secret=" + secret
				+ "]";
	}
	

}
