package com.zyt.cxfq.model.entity;
/**
 * 爬取数据web传输类
 * @author Administrator
 *
 */
public class quoteSeleniumEntity {
	/**
	 * 交强险 JSON
	 */
	private String insuranceBeanJq;
	/**
	 * 商业险 JSON
	 */
	private String insuranceBeanSyList;
	/**
	 * 车信息 JSON
	 */
	private String insuranceCar;
	/**
	 * 保险人信息 JSON
	 */
	private String insurancePerson;
	/**
	 * 车船税信息 JSON
	 */
	private String vehicleTaxBean;
	/**
	 * 车牌号
	 */
	private String licenseNo;
	/**
	 * 商业险结束时间
	 */
	private String syEndDate;
	/**
	 * 商业险开始时间
	 */
	private String syStartDate;
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getInsuranceBeanJq() {
		return insuranceBeanJq;
	}
	public void setInsuranceBeanJq(String insuranceBeanJq) {
		this.insuranceBeanJq = insuranceBeanJq;
	}
	public String getInsuranceBeanSyList() {
		return insuranceBeanSyList;
	}
	public void setInsuranceBeanSyList(String insuranceBeanSyList) {
		this.insuranceBeanSyList = insuranceBeanSyList;
	}
	public String getInsuranceCar() {
		return insuranceCar;
	}
	public void setInsuranceCar(String insuranceCar) {
		this.insuranceCar = insuranceCar;
	}
	public String getInsurancePerson() {
		return insurancePerson;
	}
	public void setInsurancePerson(String insurancePerson) {
		this.insurancePerson = insurancePerson;
	}
	public String getVehicleTaxBean() {
		return vehicleTaxBean;
	}
	public void setVehicleTaxBean(String vehicleTaxBean) {
		this.vehicleTaxBean = vehicleTaxBean;
	}
	public String getSyEndDate() {
		return syEndDate;
	}
	public void setSyEndDate(String syEndDate) {
		this.syEndDate = syEndDate;
	}
	public String getSyStartDate() {
		return syStartDate;
	}
	public void setSyStartDate(String syStartDate) {
		this.syStartDate = syStartDate;
	}
	@Override
	public String toString() {
		return "quoteSeleniumEntity [insuranceBeanJq=" + insuranceBeanJq + ", insuranceBeanSyList="
				+ insuranceBeanSyList + ", insuranceCar=" + insuranceCar + ", insurancePerson=" + insurancePerson
				+ ", vehicleTaxBean=" + vehicleTaxBean + ", licenseNo=" + licenseNo + ", syEndDate=" + syEndDate
				+ ", syStartDate=" + syStartDate + "]";
	}
	

	
	
}
