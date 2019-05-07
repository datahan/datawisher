package com.datawisher.common.ezhiyang.settlement.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: SettlementDetailDTO
 * @Description: 结算明细
 * @author luo.zhang
 * @date 2019年3月13日上午11:39:32
 * @version V1.0
 */
public class SettlementDetailDTO implements Serializable {

    private static final long serialVersionUID = 256927723141005105L;
    /**
     * 结算项金额
     */
    private BigDecimal amount;
    /**
     * 业务流水号
     */
    private String businessTransNo;

    /**
     * 业务流水号
     */
    private String transNo;

    /**
     * 贷方账号
     */
    private String inBkNo;
    /**
     * 贷方账户名
     */
    private String inAcctName;
    /**
     * 贷方银行名称
     */
    private String inBkName;
    /**
     * 贷方银行编号
     */
    private String inBkCode;
    /**
     * 贷方分行名称
     */
    private String inBkSubName;
    /**
     * 贷方分行编号
     */
    private String inBkSubCode;
    /**
     * 用途
     */
    private String detailPur;
    /**
     * 状态 0未处理 1成功 2失败 3处理中4放弃
     */
    private Byte status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 贷方主账户
     */
    private String inAcctNo;
    /**
     *贷方账户类型编号
     */
    private String inAcctType;
    /**
     *借方主账户
     */
    private String outAcctNo;
    /**
     *借方账户类型编号
     */
    private String outAcctType;
    /**
     * 贷方所属企业名称
     */
    private String inOrgName;
    /**
     * 机构id
     */
    private Long inOrgId;
    /**
     * 期望结算时间
     */
    private Date preSettleTime;
    /**
     * 支付方式
     * 1：银行 2：支付宝 3：微信
     */
    private Integer payType;

    /**
     * 数据来源 01灵猴 02 智企购
     */
    private String source;
    /**
     * 服务费
     */
    private BigDecimal serviceFee;

    /**
     * 是否冻结（适合智企购）
     */
    private boolean freeze;
    /**
     *是否冻结不可用（适合灵猴）
     */
    private boolean  freezeNot;

    /**
     * 错误提示
     */
    private String errMsg;


    public boolean isFreeze() {
        return freeze;
    }

    public void setFreeze(boolean freeze) {
        this.freeze = freeze;
    }

    public boolean isFreezeNot() {
        return freezeNot;
    }

    public void setFreezeNot(boolean freezeNot) {
        this.freezeNot = freezeNot;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getInBkNo() {
        return inBkNo;
    }

    public void setInBkNo(String inBkNo) {
        this.inBkNo = inBkNo;
    }

    public String getInAcctName() {
        return inAcctName;
    }

    public void setInAcctName(String inAcctName) {
        this.inAcctName = inAcctName;
    }

    public String getInBkName() {
        return inBkName;
    }

    public void setInBkName(String inBkName) {
        this.inBkName = inBkName;
    }

    public String getInBkCode() {
        return inBkCode;
    }

    public void setInBkCode(String inBkCode) {
        this.inBkCode = inBkCode;
    }

    public String getInBkSubName() {
        return inBkSubName;
    }

    public void setInBkSubName(String inBkSubName) {
        this.inBkSubName = inBkSubName;
    }

    public String getInBkSubCode() {
        return inBkSubCode;
    }

    public void setInBkSubCode(String inBkSubCode) {
        this.inBkSubCode = inBkSubCode;
    }

    public String getDetailPur() {
        return detailPur;
    }

    public void setDetailPur(String detailPur) {
        this.detailPur = detailPur;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInAcctNo() {
        return inAcctNo;
    }

    public void setInAcctNo(String inAcctNo) {
        this.inAcctNo = inAcctNo;
    }

    public String getInAcctType() {
        return inAcctType;
    }

    public void setInAcctType(String inAcctType) {
        this.inAcctType = inAcctType;
    }

    public String getOutAcctNo() {
        return outAcctNo;
    }

    public void setOutAcctNo(String outAcctNo) {
        this.outAcctNo = outAcctNo;
    }

    public String getOutAcctType() {
        return outAcctType;
    }

    public void setOutAcctType(String outAcctType) {
        this.outAcctType = outAcctType;
    }

    public String getInOrgName() {
        return inOrgName;
    }

    public void setInOrgName(String inOrgName) {
        this.inOrgName = inOrgName;
    }

    public Long getInOrgId() {
        return inOrgId;
    }

    public void setInOrgId(Long inOrgId) {
        this.inOrgId = inOrgId;
    }



    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getBusinessTransNo() {
        return businessTransNo;
    }

    public void setBusinessTransNo(String businessTransNo) {
        this.businessTransNo = businessTransNo;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getPreSettleTime() {
        return preSettleTime;
    }

    public void setPreSettleTime(Date preSettleTime) {
        this.preSettleTime = preSettleTime;
    }

    @Override
    public String toString() {
        return "SettlementDetailDTO{" +
            "amount=" + amount +
            ", businessTransNo='" + businessTransNo + '\'' +
            ", transNo='" + transNo + '\'' +
            ", inBkNo='" + inBkNo + '\'' +
            ", inAcctName='" + inAcctName + '\'' +
            ", inBkName='" + inBkName + '\'' +
            ", inBkCode='" + inBkCode + '\'' +
            ", inBkSubName='" + inBkSubName + '\'' +
            ", inBkSubCode='" + inBkSubCode + '\'' +
            ", detailPur='" + detailPur + '\'' +
            ", status=" + status +
            ", remark='" + remark + '\'' +
            ", inAcctNo='" + inAcctNo + '\'' +
            ", inAcctType='" + inAcctType + '\'' +
            ", outAcctNo='" + outAcctNo + '\'' +
            ", outAcctType='" + outAcctType + '\'' +
            ", inOrgName='" + inOrgName + '\'' +
            ", inOrgId=" + inOrgId +
            ", preSettleTime=" + preSettleTime +
            ", payType=" + payType +
            ", source='" + source + '\'' +
            ", serviceFee=" + serviceFee +
            ", freeze=" + freeze +
            ", freezeNot=" + freezeNot +
            ", errMsg='" + errMsg + '\'' +
            '}';
    }
}
