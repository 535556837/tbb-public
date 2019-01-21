package com.zyt.cxfq.model;

import java.io.Serializable;
import java.util.Date;

public class DCar implements Serializable {
    /**
     * 
     */
    private String carId;

    /**
     * 客户id
     */
    private String clientId;

    /**
     * 拥有人id
     */
    private String carOwnersId;

    /**
     * 数据来源
     */
    private String source;

    /**
     * 车牌号
     */
    private String licenseNo;

    /**
     * 参考实际价值
     */
    private String actualValue;

    /**
     * 车型名称
     */
    private String brandName;

    /**
     * 被保险人和车辆关系
     */
    private String carInsuredRelation;

    /**
     * 车辆种类代码
     */
    private String carKindCode;

    /**
     * 车辆种类
     */
    private String carKindCodeDes;

    /**
     * 整备质量(千克)
     */
    private String carLotEquQuality;

    /**
     * 条款类型
     */
    private String clauseType;

    /**
     * 进口/国产类
     */
    private String countryNature;

    /**
     * 能源种类
     */
    private String energyType1;

    /**
     * 初登日期
     */
    private String enrollDate;

    /**
     * 排量/功率(升)
     */
    private String exhaustScale;

    /**
     * 车架号
     */
    private String frameNo;

    /**
     * 发动机号码
     */
    private String hiddenEngineNo;

    /**
     * 是否新能源车
     */
    private String isEnergyCar;

    /**
     * 号牌底色
     */
    private String licenseColorCodeDes;

    /**
     * 是否已上牌照
     */
    private String licenseFlag;

    /**
     * 号牌种类
     */
    private String licenseTypeDes;

    /**
     * 是否未还清贷款
     */
    private String loanVehicleFlag;

    /**
     * 车型编码
     */
    private String modelCode;

    /**
     * 车型别名
     */
    private String modelCodeAlias;

    /**
     * 推荐送修代码
     */
    private String monopolyCode;

    /**
     * 是否推荐送修
     */
    private String monopolyFlag;

    /**
     * 推荐送修代码名称
     */
    private String monopolyName;

    /**
     * 是否新车
     */
    private String newCarFlag;

    /**
     * 是否外地车
     */
    private String noNlocalFlag;

    /**
     * 新车购置价格
     */
    private String purchasePrice;

    /**
     * 指定查询区域代码
     */
    private String queryAreaCode;

    /**
     * 指定查询区域描述
     */
    private String queryAreaName;

    /**
     * 类比车型价格
     */
    private String queryArvehiclePricereaName;

    /**
     * 行驶区域
     */
    private String runAreaCode;

    /**
     * 平均行驶里程
     */
    private String runMiles;

    /**
     * 核定载客量(人)
     */
    private String seatCount;

    /**
     * 核定载质量(千克)
     */
    private String tonCount;

    /**
     * 过户日期
     */
    private String transferDate;

    /**
     * 是否为过户车
     */
    private String transferVehicleFlag;

    /**
     * 使用性质
     */
    private String useNatureCode;

    /**
     * 实际使用年数
     */
    private String useYears;

    /**
     * 车架号/VIN码
     */
    private String vinNo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateUserId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * d_car
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return car_id 
     */
    public String getCarId() {
        return carId;
    }

    /**
     * 
     * @param carId 
     */
    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    /**
     * 客户id
     * @return client_id 客户id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 客户id
     * @param clientId 客户id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    /**
     * 拥有人id
     * @return car_owners_id 拥有人id
     */
    public String getCarOwnersId() {
        return carOwnersId;
    }

    /**
     * 拥有人id
     * @param carOwnersId 拥有人id
     */
    public void setCarOwnersId(String carOwnersId) {
        this.carOwnersId = carOwnersId == null ? null : carOwnersId.trim();
    }

    /**
     * 数据来源
     * @return source 数据来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 数据来源
     * @param source 数据来源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 车牌号
     * @return license_no 车牌号
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * 车牌号
     * @param licenseNo 车牌号
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo == null ? null : licenseNo.trim();
    }

    /**
     * 参考实际价值
     * @return actual_value 参考实际价值
     */
    public String getActualValue() {
        return actualValue;
    }

    /**
     * 参考实际价值
     * @param actualValue 参考实际价值
     */
    public void setActualValue(String actualValue) {
        this.actualValue = actualValue == null ? null : actualValue.trim();
    }

    /**
     * 车型名称
     * @return brand_name 车型名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 车型名称
     * @param brandName 车型名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 被保险人和车辆关系
     * @return car_insured_relation 被保险人和车辆关系
     */
    public String getCarInsuredRelation() {
        return carInsuredRelation;
    }

    /**
     * 被保险人和车辆关系
     * @param carInsuredRelation 被保险人和车辆关系
     */
    public void setCarInsuredRelation(String carInsuredRelation) {
        this.carInsuredRelation = carInsuredRelation == null ? null : carInsuredRelation.trim();
    }

    /**
     * 车辆种类代码
     * @return car_kind_code 车辆种类代码
     */
    public String getCarKindCode() {
        return carKindCode;
    }

    /**
     * 车辆种类代码
     * @param carKindCode 车辆种类代码
     */
    public void setCarKindCode(String carKindCode) {
        this.carKindCode = carKindCode == null ? null : carKindCode.trim();
    }

    /**
     * 车辆种类
     * @return car_kind_code_des 车辆种类
     */
    public String getCarKindCodeDes() {
        return carKindCodeDes;
    }

    /**
     * 车辆种类
     * @param carKindCodeDes 车辆种类
     */
    public void setCarKindCodeDes(String carKindCodeDes) {
        this.carKindCodeDes = carKindCodeDes == null ? null : carKindCodeDes.trim();
    }

    /**
     * 整备质量(千克)
     * @return car_lot_equ_quality 整备质量(千克)
     */
    public String getCarLotEquQuality() {
        return carLotEquQuality;
    }

    /**
     * 整备质量(千克)
     * @param carLotEquQuality 整备质量(千克)
     */
    public void setCarLotEquQuality(String carLotEquQuality) {
        this.carLotEquQuality = carLotEquQuality == null ? null : carLotEquQuality.trim();
    }

    /**
     * 条款类型
     * @return clause_type 条款类型
     */
    public String getClauseType() {
        return clauseType;
    }

    /**
     * 条款类型
     * @param clauseType 条款类型
     */
    public void setClauseType(String clauseType) {
        this.clauseType = clauseType == null ? null : clauseType.trim();
    }

    /**
     * 进口/国产类
     * @return country_nature 进口/国产类
     */
    public String getCountryNature() {
        return countryNature;
    }

    /**
     * 进口/国产类
     * @param countryNature 进口/国产类
     */
    public void setCountryNature(String countryNature) {
        this.countryNature = countryNature == null ? null : countryNature.trim();
    }

    /**
     * 能源种类
     * @return energy_type1 能源种类
     */
    public String getEnergyType1() {
        return energyType1;
    }

    /**
     * 能源种类
     * @param energyType1 能源种类
     */
    public void setEnergyType1(String energyType1) {
        this.energyType1 = energyType1 == null ? null : energyType1.trim();
    }

    /**
     * 初登日期
     * @return enroll_date 初登日期
     */
    public String getEnrollDate() {
        return enrollDate;
    }

    /**
     * 初登日期
     * @param enrollDate 初登日期
     */
    public void setEnrollDate(String enrollDate) {
        this.enrollDate = enrollDate == null ? null : enrollDate.trim();
    }

    /**
     * 排量/功率(升)
     * @return exhaust_scale 排量/功率(升)
     */
    public String getExhaustScale() {
        return exhaustScale;
    }

    /**
     * 排量/功率(升)
     * @param exhaustScale 排量/功率(升)
     */
    public void setExhaustScale(String exhaustScale) {
        this.exhaustScale = exhaustScale == null ? null : exhaustScale.trim();
    }

    /**
     * 车架号
     * @return frame_no 车架号
     */
    public String getFrameNo() {
        return frameNo;
    }

    /**
     * 车架号
     * @param frameNo 车架号
     */
    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo == null ? null : frameNo.trim();
    }

    /**
     * 发动机号码
     * @return hidden_engine_no 发动机号码
     */
    public String getHiddenEngineNo() {
        return hiddenEngineNo;
    }

    /**
     * 发动机号码
     * @param hiddenEngineNo 发动机号码
     */
    public void setHiddenEngineNo(String hiddenEngineNo) {
        this.hiddenEngineNo = hiddenEngineNo == null ? null : hiddenEngineNo.trim();
    }

    /**
     * 是否新能源车
     * @return is_energy_car 是否新能源车
     */
    public String getIsEnergyCar() {
        return isEnergyCar;
    }

    /**
     * 是否新能源车
     * @param isEnergyCar 是否新能源车
     */
    public void setIsEnergyCar(String isEnergyCar) {
        this.isEnergyCar = isEnergyCar == null ? null : isEnergyCar.trim();
    }

    /**
     * 号牌底色
     * @return license_color_code_des 号牌底色
     */
    public String getLicenseColorCodeDes() {
        return licenseColorCodeDes;
    }

    /**
     * 号牌底色
     * @param licenseColorCodeDes 号牌底色
     */
    public void setLicenseColorCodeDes(String licenseColorCodeDes) {
        this.licenseColorCodeDes = licenseColorCodeDes == null ? null : licenseColorCodeDes.trim();
    }

    /**
     * 是否已上牌照
     * @return license_flag 是否已上牌照
     */
    public String getLicenseFlag() {
        return licenseFlag;
    }

    /**
     * 是否已上牌照
     * @param licenseFlag 是否已上牌照
     */
    public void setLicenseFlag(String licenseFlag) {
        this.licenseFlag = licenseFlag == null ? null : licenseFlag.trim();
    }

    /**
     * 号牌种类
     * @return license_type_des 号牌种类
     */
    public String getLicenseTypeDes() {
        return licenseTypeDes;
    }

    /**
     * 号牌种类
     * @param licenseTypeDes 号牌种类
     */
    public void setLicenseTypeDes(String licenseTypeDes) {
        this.licenseTypeDes = licenseTypeDes == null ? null : licenseTypeDes.trim();
    }

    /**
     * 是否未还清贷款
     * @return loan_vehicle_flag 是否未还清贷款
     */
    public String getLoanVehicleFlag() {
        return loanVehicleFlag;
    }

    /**
     * 是否未还清贷款
     * @param loanVehicleFlag 是否未还清贷款
     */
    public void setLoanVehicleFlag(String loanVehicleFlag) {
        this.loanVehicleFlag = loanVehicleFlag == null ? null : loanVehicleFlag.trim();
    }

    /**
     * 车型编码
     * @return model_code 车型编码
     */
    public String getModelCode() {
        return modelCode;
    }

    /**
     * 车型编码
     * @param modelCode 车型编码
     */
    public void setModelCode(String modelCode) {
        this.modelCode = modelCode == null ? null : modelCode.trim();
    }

    /**
     * 车型别名
     * @return model_code_alias 车型别名
     */
    public String getModelCodeAlias() {
        return modelCodeAlias;
    }

    /**
     * 车型别名
     * @param modelCodeAlias 车型别名
     */
    public void setModelCodeAlias(String modelCodeAlias) {
        this.modelCodeAlias = modelCodeAlias == null ? null : modelCodeAlias.trim();
    }

    /**
     * 推荐送修代码
     * @return monopoly_code 推荐送修代码
     */
    public String getMonopolyCode() {
        return monopolyCode;
    }

    /**
     * 推荐送修代码
     * @param monopolyCode 推荐送修代码
     */
    public void setMonopolyCode(String monopolyCode) {
        this.monopolyCode = monopolyCode == null ? null : monopolyCode.trim();
    }

    /**
     * 是否推荐送修
     * @return monopoly_flag 是否推荐送修
     */
    public String getMonopolyFlag() {
        return monopolyFlag;
    }

    /**
     * 是否推荐送修
     * @param monopolyFlag 是否推荐送修
     */
    public void setMonopolyFlag(String monopolyFlag) {
        this.monopolyFlag = monopolyFlag == null ? null : monopolyFlag.trim();
    }

    /**
     * 推荐送修代码名称
     * @return monopoly_name 推荐送修代码名称
     */
    public String getMonopolyName() {
        return monopolyName;
    }

    /**
     * 推荐送修代码名称
     * @param monopolyName 推荐送修代码名称
     */
    public void setMonopolyName(String monopolyName) {
        this.monopolyName = monopolyName == null ? null : monopolyName.trim();
    }

    /**
     * 是否新车
     * @return new_car_flag 是否新车
     */
    public String getNewCarFlag() {
        return newCarFlag;
    }

    /**
     * 是否新车
     * @param newCarFlag 是否新车
     */
    public void setNewCarFlag(String newCarFlag) {
        this.newCarFlag = newCarFlag == null ? null : newCarFlag.trim();
    }

    /**
     * 是否外地车
     * @return no_nlocal_flag 是否外地车
     */
    public String getNoNlocalFlag() {
        return noNlocalFlag;
    }

    /**
     * 是否外地车
     * @param noNlocalFlag 是否外地车
     */
    public void setNoNlocalFlag(String noNlocalFlag) {
        this.noNlocalFlag = noNlocalFlag == null ? null : noNlocalFlag.trim();
    }

    /**
     * 新车购置价格
     * @return purchase_price 新车购置价格
     */
    public String getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * 新车购置价格
     * @param purchasePrice 新车购置价格
     */
    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice == null ? null : purchasePrice.trim();
    }

    /**
     * 指定查询区域代码
     * @return query_area_code 指定查询区域代码
     */
    public String getQueryAreaCode() {
        return queryAreaCode;
    }

    /**
     * 指定查询区域代码
     * @param queryAreaCode 指定查询区域代码
     */
    public void setQueryAreaCode(String queryAreaCode) {
        this.queryAreaCode = queryAreaCode == null ? null : queryAreaCode.trim();
    }

    /**
     * 指定查询区域描述
     * @return query_area_name 指定查询区域描述
     */
    public String getQueryAreaName() {
        return queryAreaName;
    }

    /**
     * 指定查询区域描述
     * @param queryAreaName 指定查询区域描述
     */
    public void setQueryAreaName(String queryAreaName) {
        this.queryAreaName = queryAreaName == null ? null : queryAreaName.trim();
    }

    /**
     * 类比车型价格
     * @return query_arvehicle_pricerea_name 类比车型价格
     */
    public String getQueryArvehiclePricereaName() {
        return queryArvehiclePricereaName;
    }

    /**
     * 类比车型价格
     * @param queryArvehiclePricereaName 类比车型价格
     */
    public void setQueryArvehiclePricereaName(String queryArvehiclePricereaName) {
        this.queryArvehiclePricereaName = queryArvehiclePricereaName == null ? null : queryArvehiclePricereaName.trim();
    }

    /**
     * 行驶区域
     * @return run_area_code 行驶区域
     */
    public String getRunAreaCode() {
        return runAreaCode;
    }

    /**
     * 行驶区域
     * @param runAreaCode 行驶区域
     */
    public void setRunAreaCode(String runAreaCode) {
        this.runAreaCode = runAreaCode == null ? null : runAreaCode.trim();
    }

    /**
     * 平均行驶里程
     * @return run_miles 平均行驶里程
     */
    public String getRunMiles() {
        return runMiles;
    }

    /**
     * 平均行驶里程
     * @param runMiles 平均行驶里程
     */
    public void setRunMiles(String runMiles) {
        this.runMiles = runMiles == null ? null : runMiles.trim();
    }

    /**
     * 核定载客量(人)
     * @return seat_count 核定载客量(人)
     */
    public String getSeatCount() {
        return seatCount;
    }

    /**
     * 核定载客量(人)
     * @param seatCount 核定载客量(人)
     */
    public void setSeatCount(String seatCount) {
        this.seatCount = seatCount == null ? null : seatCount.trim();
    }

    /**
     * 核定载质量(千克)
     * @return ton_count 核定载质量(千克)
     */
    public String getTonCount() {
        return tonCount;
    }

    /**
     * 核定载质量(千克)
     * @param tonCount 核定载质量(千克)
     */
    public void setTonCount(String tonCount) {
        this.tonCount = tonCount == null ? null : tonCount.trim();
    }

    /**
     * 过户日期
     * @return transfer_date 过户日期
     */
    public String getTransferDate() {
        return transferDate;
    }

    /**
     * 过户日期
     * @param transferDate 过户日期
     */
    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate == null ? null : transferDate.trim();
    }

    /**
     * 是否为过户车
     * @return transfer_vehicle_flag 是否为过户车
     */
    public String getTransferVehicleFlag() {
        return transferVehicleFlag;
    }

    /**
     * 是否为过户车
     * @param transferVehicleFlag 是否为过户车
     */
    public void setTransferVehicleFlag(String transferVehicleFlag) {
        this.transferVehicleFlag = transferVehicleFlag == null ? null : transferVehicleFlag.trim();
    }

    /**
     * 使用性质
     * @return use_nature_code 使用性质
     */
    public String getUseNatureCode() {
        return useNatureCode;
    }

    /**
     * 使用性质
     * @param useNatureCode 使用性质
     */
    public void setUseNatureCode(String useNatureCode) {
        this.useNatureCode = useNatureCode == null ? null : useNatureCode.trim();
    }

    /**
     * 实际使用年数
     * @return use_years 实际使用年数
     */
    public String getUseYears() {
        return useYears;
    }

    /**
     * 实际使用年数
     * @param useYears 实际使用年数
     */
    public void setUseYears(String useYears) {
        this.useYears = useYears == null ? null : useYears.trim();
    }

    /**
     * 车架号/VIN码
     * @return vin_no 车架号/VIN码
     */
    public String getVinNo() {
        return vinNo;
    }

    /**
     * 车架号/VIN码
     * @param vinNo 车架号/VIN码
     */
    public void setVinNo(String vinNo) {
        this.vinNo = vinNo == null ? null : vinNo.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人
     * @return update_user_id 修改人
     */
    public String getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 修改人
     * @param updateUserId 修改人
     */
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "DCar [carId=" + carId + ", clientId=" + clientId + ", carOwnersId=" + carOwnersId + ", source=" + source
				+ ", licenseNo=" + licenseNo + ", actualValue=" + actualValue + ", brandName=" + brandName
				+ ", carInsuredRelation=" + carInsuredRelation + ", carKindCode=" + carKindCode + ", carKindCodeDes="
				+ carKindCodeDes + ", carLotEquQuality=" + carLotEquQuality + ", clauseType=" + clauseType
				+ ", countryNature=" + countryNature + ", energyType1=" + energyType1 + ", enrollDate=" + enrollDate
				+ ", exhaustScale=" + exhaustScale + ", frameNo=" + frameNo + ", hiddenEngineNo=" + hiddenEngineNo
				+ ", isEnergyCar=" + isEnergyCar + ", licenseColorCodeDes=" + licenseColorCodeDes + ", licenseFlag="
				+ licenseFlag + ", licenseTypeDes=" + licenseTypeDes + ", loanVehicleFlag=" + loanVehicleFlag
				+ ", modelCode=" + modelCode + ", modelCodeAlias=" + modelCodeAlias + ", monopolyCode=" + monopolyCode
				+ ", monopolyFlag=" + monopolyFlag + ", monopolyName=" + monopolyName + ", newCarFlag=" + newCarFlag
				+ ", noNlocalFlag=" + noNlocalFlag + ", purchasePrice=" + purchasePrice + ", queryAreaCode="
				+ queryAreaCode + ", queryAreaName=" + queryAreaName + ", queryArvehiclePricereaName="
				+ queryArvehiclePricereaName + ", runAreaCode=" + runAreaCode + ", runMiles=" + runMiles
				+ ", seatCount=" + seatCount + ", tonCount=" + tonCount + ", transferDate=" + transferDate
				+ ", transferVehicleFlag=" + transferVehicleFlag + ", useNatureCode=" + useNatureCode + ", useYears="
				+ useYears + ", vinNo=" + vinNo + ", createTime=" + createTime + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + "]";
	}
    
}