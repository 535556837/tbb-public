package com.zyt.cxfq.common.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TUserorderData  {
	  /**
     * 主键
     */
    private String tUserorderid;
    
    /**
     * 用户电话
     */
    private String phone;
    
    /**
     * 联表得到的dataid/skuid
     */
    private String skuid;

    /**
     * 订单编号
     */
    private String OrderNo;

    /**
     * 用户信息
     */
    private String B_Member_ID;

    /**
     * 品牌信息ID
     */
    private String bBrandinformationid;

    /**
     * 车辆信息ID
     */
    private String bCarinformationid;

    /**
     * 下单时间
     */
    private Date orderingtime;

    /**
     * 投保日期
     */
    private Date productworkingtime;

    /**
     * 订单状态:0未提交 1 待支付  2待发货 3待收货 4已完成 5已取消
     */
    private Integer orderstate;

    /**
     * 订单来源 1系统创建 2外部爬虫数据
     */
    private Integer ordersource;

    /**
     * 支付方式 1分期 2支付宝 3微信 4银联5积分支付7积分+支付宝8积分+微信9积分+银联
     */
    private Integer PayType;

    /**
     * 订单总价
     */
    private BigDecimal ordertotelmoney;

    /**
     * 优惠价格
     */
    private BigDecimal discountprice;

    /**
     * 发货时间
     */
    private Date deliveredtime;

    /**
     * 收货时间
     */
    private Date recipienttime;

    /**
     * 是否删除
                         1否
                         2是
     */
    private Integer isdelete;

    /**
     * 运费
     */
    private BigDecimal transportprice;

    /**
     * 确认时间
     */
    private Date confirmtime;

    /**
     * 已付款时间
     */
    private Date paymenttime;

    /**
     * 备注信息（写入配送时间端）
     */
    private String remark;

    /**
     * 在订单提交时选择的优惠券价格
     */
    private BigDecimal couponsbatchprice;

    /**
     * 订单简介（选填）
     */
    private String orderremark;

    /**
     * 运单号（后台确认发货时填写）
     */
    private String waybillnum;

    /**
     * 缴费通知单号
     */
    private String thirdorderno;

    /**
     * 支付交易单号
     */
    private String thirdtransid;

    /**
     * 投保信息查询ID
     */
    private String thirdrequestid;

    /**
     * 缴费截止日期
     */
    private Date lastdate;

    /**
     * 订单类型1保险2积分商城
     */
    private String orderType;

    /**
     * 保单号列表,多个用,号分隔
     */
    private String policyvo;

    /**
     * 投保单号列表,多个以逗号分隔,与保单号一一对应
     */
    private String proposalno;

    /**
     * 创建时间
     */
    private Date CreateTime;

    /**
     * 创建人
     */
    private String CreateUserID;

    /**
     * 修改时间
     */
    private Date updatetime;

    /**
     * 修改人
     */
    private String updateuserid;


    /**
     * 主键
     * @return T_UserOrderID 主键
     */
    public String gettUserorderid() {
        return tUserorderid;
    }

    /**
     * 主键
     * @param tUserorderid 主键
     */
    public void settUserorderid(String tUserorderid) {
        this.tUserorderid = tUserorderid == null ? null : tUserorderid.trim();
    }
    
    
    /**
     * 用户电话
     * @param phone 用户电话
     */
    public String getPhone() {
		return phone;
	}
    
    /**
     * 用户电话
     * @param phone 用户电话
     */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
     * 订单编号
     * @return OrderNo 订单编号
     */
    public String getOrderno() {
        return OrderNo;
    }

    /**
     * 订单编号
     * @param orderno 订单编号
     */
    public void setOrderno(String orderno) {
        this.OrderNo = orderno == null ? null : orderno.trim();
    }

    /**
     * 用户信息
     * @return B_Member_ID 用户信息
     */
    public String getbMemberId() {
        return B_Member_ID;
    }

    /**
     * 用户信息
     * @param bMemberId 用户信息
     */
    public void setbMemberId(String bMemberId) {
        this.B_Member_ID = bMemberId == null ? null : bMemberId.trim();
    }

    /**
     * 品牌信息ID
     * @return B_BrandInformationID 品牌信息ID
     */
    public String getbBrandinformationid() {
        return bBrandinformationid;
    }

    /**
     * 品牌信息ID
     * @param bBrandinformationid 品牌信息ID
     */
    public void setbBrandinformationid(String bBrandinformationid) {
        this.bBrandinformationid = bBrandinformationid == null ? null : bBrandinformationid.trim();
    }

    /**
     * 车辆信息ID
     * @return B_CarInformationID 车辆信息ID
     */
    public String getbCarinformationid() {
        return bCarinformationid;
    }

    /**
     * 车辆信息ID
     * @param bCarinformationid 车辆信息ID
     */
    public void setbCarinformationid(String bCarinformationid) {
        this.bCarinformationid = bCarinformationid == null ? null : bCarinformationid.trim();
    }

    /**
     * 下单时间
     * @return OrderingTime 下单时间
     */
    public Date getOrderingtime() {
        return orderingtime;
    }

    /**
     * 下单时间
     * @param orderingtime 下单时间
     */
    public void setOrderingtime(Date orderingtime) {
        this.orderingtime = orderingtime;
    }

    /**
     * 投保日期
     * @return ProductWorkingTime 投保日期
     */
    public Date getProductworkingtime() {
        return productworkingtime;
    }

    /**
     * 投保日期
     * @param productworkingtime 投保日期
     */
    public void setProductworkingtime(Date productworkingtime) {
        this.productworkingtime = productworkingtime;
    }

    /**
     * 订单状态:0未提交 1 待支付  2待发货 3待收货 4已完成 5已取消
     * @return OrderState 订单状态:0未提交 1 待支付  2待发货 3待收货 4已完成 5已取消
     */
    public Integer getOrderstate() {
        return orderstate;
    }

    /**
     * 订单状态:0未提交 1 待支付  2待发货 3待收货 4已完成 5已取消
     * @param orderstate 订单状态:0未提交 1 待支付  2待发货 3待收货 4已完成 5已取消
     */
    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }

    /**
     * 订单来源 1系统创建 2外部爬虫数据
     * @return OrderSource 订单来源 1系统创建 2外部爬虫数据
     */
    public Integer getOrdersource() {
        return ordersource;
    }

    /**
     * 订单来源 1系统创建 2外部爬虫数据
     * @param ordersource 订单来源 1系统创建 2外部爬虫数据
     */
    public void setOrdersource(Integer ordersource) {
        this.ordersource = ordersource;
    }

    /**
     * 支付方式 1分期 2支付宝 3微信 4银联5积分支付7积分+支付宝8积分+微信9积分+银联
     * @return PayType 支付方式 1分期 2支付宝 3微信 4银联5积分支付7积分+支付宝8积分+微信9积分+银联
     */
    public Integer getPaytype() {
        return PayType;
    }

    /**
     * 支付方式 1分期 2支付宝 3微信 4银联5积分支付7积分+支付宝8积分+微信9积分+银联
     * @param paytype 支付方式 1分期 2支付宝 3微信 4银联5积分支付7积分+支付宝8积分+微信9积分+银联
     */
    public void setPaytype(Integer paytype) {
        this.PayType = paytype;
    }

    /**
     * 订单总价
     * @return OrderTotelMoney 订单总价
     */
    public BigDecimal getOrdertotelmoney() {
        return ordertotelmoney;
    }

    /**
     * 订单总价
     * @param ordertotelmoney 订单总价
     */
    public void setOrdertotelmoney(BigDecimal ordertotelmoney) {
        this.ordertotelmoney = ordertotelmoney;
    }

    /**
     * 优惠价格
     * @return DiscountPrice 优惠价格
     */
    public BigDecimal getDiscountprice() {
        return discountprice;
    }

    /**
     * 优惠价格
     * @param discountprice 优惠价格
     */
    public void setDiscountprice(BigDecimal discountprice) {
        this.discountprice = discountprice;
    }

    /**
     * 发货时间
     * @return DeliveredTime 发货时间
     */
    public Date getDeliveredtime() {
        return deliveredtime;
    }

    /**
     * 发货时间
     * @param deliveredtime 发货时间
     */
    public void setDeliveredtime(Date deliveredtime) {
        this.deliveredtime = deliveredtime;
    }

    /**
     * 收货时间
     * @return RecipientTime 收货时间
     */
    public Date getRecipienttime() {
        return recipienttime;
    }

    /**
     * 收货时间
     * @param recipienttime 收货时间
     */
    public void setRecipienttime(Date recipienttime) {
        this.recipienttime = recipienttime;
    }

    /**
     * 是否删除
                         1否
                         2是
     * @return IsDelete 是否删除
                         1否
                         2是
     */
    public Integer getIsdelete() {
        return isdelete;
    }

    /**
     * 是否删除
                         1否
                         2是
     * @param isdelete 是否删除
                         1否
                         2是
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    /**
     * 运费
     * @return TransportPrice 运费
     */
    public BigDecimal getTransportprice() {
        return transportprice;
    }

    /**
     * 运费
     * @param transportprice 运费
     */
    public void setTransportprice(BigDecimal transportprice) {
        this.transportprice = transportprice;
    }

    /**
     * 确认时间
     * @return ConfirmTime 确认时间
     */
    public Date getConfirmtime() {
        return confirmtime;
    }

    /**
     * 确认时间
     * @param confirmtime 确认时间
     */
    public void setConfirmtime(Date confirmtime) {
        this.confirmtime = confirmtime;
    }

    /**
     * 已付款时间
     * @return PaymentTime 已付款时间
     */
    public Date getPaymenttime() {
        return paymenttime;
    }

    /**
     * 已付款时间
     * @param paymenttime 已付款时间
     */
    public void setPaymenttime(Date paymenttime) {
        this.paymenttime = paymenttime;
    }

    /**
     * 备注信息（写入配送时间端）
     * @return Remark 备注信息（写入配送时间端）
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注信息（写入配送时间端）
     * @param remark 备注信息（写入配送时间端）
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 在订单提交时选择的优惠券价格
     * @return CouponsBatchPrice 在订单提交时选择的优惠券价格
     */
    public BigDecimal getCouponsbatchprice() {
        return couponsbatchprice;
    }

    /**
     * 在订单提交时选择的优惠券价格
     * @param couponsbatchprice 在订单提交时选择的优惠券价格
     */
    public void setCouponsbatchprice(BigDecimal couponsbatchprice) {
        this.couponsbatchprice = couponsbatchprice;
    }

    /**
     * 订单简介（选填）
     * @return OrderRemark 订单简介（选填）
     */
    public String getOrderremark() {
        return orderremark;
    }

    /**
     * 订单简介（选填）
     * @param orderremark 订单简介（选填）
     */
    public void setOrderremark(String orderremark) {
        this.orderremark = orderremark == null ? null : orderremark.trim();
    }

    /**
     * 运单号（后台确认发货时填写）
     * @return WaybillNum 运单号（后台确认发货时填写）
     */
    public String getWaybillnum() {
        return waybillnum;
    }

    /**
     * 运单号（后台确认发货时填写）
     * @param waybillnum 运单号（后台确认发货时填写）
     */
    public void setWaybillnum(String waybillnum) {
        this.waybillnum = waybillnum == null ? null : waybillnum.trim();
    }

    /**
     * 缴费通知单号
     * @return thirdOrderNo 缴费通知单号
     */
    public String getThirdorderno() {
        return thirdorderno;
    }

    /**
     * 缴费通知单号
     * @param thirdorderno 缴费通知单号
     */
    public void setThirdorderno(String thirdorderno) {
        this.thirdorderno = thirdorderno == null ? null : thirdorderno.trim();
    }

    /**
     * 支付交易单号
     * @return thirdTransId 支付交易单号
     */
    public String getThirdtransid() {
        return thirdtransid;
    }

    /**
     * 支付交易单号
     * @param thirdtransid 支付交易单号
     */
    public void setThirdtransid(String thirdtransid) {
        this.thirdtransid = thirdtransid == null ? null : thirdtransid.trim();
    }

    /**
     * 投保信息查询ID
     * @return thirdRequestId 投保信息查询ID
     */
    public String getThirdrequestid() {
        return thirdrequestid;
    }

    /**
     * 投保信息查询ID
     * @param thirdrequestid 投保信息查询ID
     */
    public void setThirdrequestid(String thirdrequestid) {
        this.thirdrequestid = thirdrequestid == null ? null : thirdrequestid.trim();
    }

    /**
     * 缴费截止日期
     * @return lastdate 缴费截止日期
     */
    public Date getLastdate() {
        return lastdate;
    }

    /**
     * 缴费截止日期
     * @param lastdate 缴费截止日期
     */
    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    /**
     * 订单类型1保险2积分商城
     * @return orderType 订单类型1保险2积分商城
     */
    public String getOrdertype() {
        return orderType;
    }

    /**
     * 订单类型1保险2积分商城
     * @param ordertype 订单类型1保险2积分商城
     */
    public void setOrdertype(String ordertype) {
        this.orderType = ordertype == null ? null : ordertype.trim();
    }

    /**
     * 保单号列表,多个用,号分隔
     * @return policyVo 保单号列表,多个用,号分隔
     */
    public String getPolicyvo() {
        return policyvo;
    }

    /**
     * 保单号列表,多个用,号分隔
     * @param policyvo 保单号列表,多个用,号分隔
     */
    public void setPolicyvo(String policyvo) {
        this.policyvo = policyvo == null ? null : policyvo.trim();
    }

    /**
     * 投保单号列表,多个以逗号分隔,与保单号一一对应
     * @return proposalNo 投保单号列表,多个以逗号分隔,与保单号一一对应
     */
    public String getProposalno() {
        return proposalno;
    }

    /**
     * 投保单号列表,多个以逗号分隔,与保单号一一对应
     * @param proposalno 投保单号列表,多个以逗号分隔,与保单号一一对应
     */
    public void setProposalno(String proposalno) {
        this.proposalno = proposalno == null ? null : proposalno.trim();
    }

    /**
     * 创建时间
     * @return CreateTime 创建时间
     */
    public Date getCreatetime() {
        return CreateTime;
    }

    /**
     * 创建时间
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.CreateTime = createtime;
    }

    /**
     * 创建人
     * @return CreateUserID 创建人
     */
    public String getCreateuserid() {
        return CreateUserID;
    }

    /**
     * 创建人
     * @param CreateUserID 创建人
     */
    public void setCreateuserid(String createuserid) {
        this.CreateUserID = createuserid == null ? null : createuserid.trim();
    }

    /**
     * 修改时间
     * @return UpdateTime 修改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 修改时间
     * @param updatetime 修改时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 修改人
     * @return UpdateUserID 修改人
     */
    public String getUpdateuserid() {
        return updateuserid;
    }

    /**
     * 修改人
     * @param updateuserid 修改人
     */
    public void setUpdateuserid(String updateuserid) {
        this.updateuserid = updateuserid == null ? null : updateuserid.trim();
    }

	public String getSkuid() {
		return skuid;
	}

	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}

	public String getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}

	public String getB_Member_ID() {
		return B_Member_ID;
	}

	public void setB_Member_ID(String b_Member_ID) {
		B_Member_ID = b_Member_ID;
	}

	public Integer getPayType() {
		return PayType;
	}

	public void setPayType(Integer payType) {
		PayType = payType;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Date getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}

	public String getCreateUserID() {
		return CreateUserID;
	}

	public void setCreateUserID(String createUserID) {
		CreateUserID = createUserID;
	}
    
    
}

