package cn.zying.osales.pojos ;

import java.util.Date ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.EnumType ;
import javax.persistence.Enumerated ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.Table ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.OSalesConfigProperties.AdjustType ;
import cn.zying.osales.pojos.commons.CommBean ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

/**
 * 采购调整单 StockAdjust generated by hbm2java
 */
@Entity
@Table(name = "stock_adjust_bill")
public class StockAdjustBill extends CommBean {

    //	// 采购合同编号
    //	@Column(name = "stock_num")
    //	private String adjustNum;

    // 供应商名称
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_info_id")
    @FieldDesc(name = "供应商", mapping = "providerInfo.name")
    private ProviderInfo providerInfo ;

    @Column(name = "provider_info_id", insertable = false, updatable = false)
    @FieldDesc(name = "供应商", isShow = false)
    private Integer providerInfoId ;

    // 采购员
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_man_id")
    @FieldDesc(name = "采购员", mapping = "stockMan.name")
    private SysStaffUser stockMan ;

    @Column(name = "stock_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "采购员", inputShow = true, isShow = false)
    private Integer stockManId ;

    // 调整科目
    @Column(name = "adjust_subject")
    @FieldDesc(name = "调整科目")
    private String adjustSubject ;

    // 调整类型
    @Column(name = "adjust_type")
    @Enumerated(EnumType.STRING)
    @FieldDesc(name = "调整类型")
    private AdjustType adjustType ;

    // 调整日期
    @Column(name = "adjust_date")
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "调整日期")
    private Date adjustDate ;

    // 调整金额
    @Column(name = "adjust_sum")
    @FieldDesc(name = "调整金额")
    private Long adjustSum ;

    @Transient
    @FieldDesc(name = "调整金额")
    private String adjustSumMoneyShow ;

    @Transient
    @FieldDesc(name = "调整金额")
    private String adjustSumMoneyHide ;

    @Column(name = "text")
    @FieldDesc(name = "备注")
    private String text ;

    // /审核人
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "check_man_id")
    @FieldDesc(name = "采购员", mapping = "checkMan.name")
    private SysStaffUser checkMan ;

    @Column(name = "check_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "采购员", inputShow = true, isShow = false)
    private Integer checkManId ;

    // /审核时间
    @Column(name = "check_date")
    @Enumerated
    @Temporal(TemporalType.DATE)
    private Date checkedTime ;

    // /录入人
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_man_id")
    @FieldDesc(name = "录入人", mapping = "stockMan.name")
    private SysStaffUser recordMan ;

    @Column(name = "record_man_id", insertable = false, updatable = false)
    private Integer recordManId ;

    public ProviderInfo getProviderInfo() {
        return providerInfo ;
    }

    public void setProviderInfo(ProviderInfo providerInfo) {
        this.providerInfo = providerInfo ;
    }

    public Integer getProviderInfoId() {
        return providerInfoId ;
    }

    public void setProviderInfoId(Integer providerInfoId) {
        this.providerInfoId = providerInfoId ;
    }

    public SysStaffUser getStockMan() {
        return stockMan ;
    }

    public void setStockMan(SysStaffUser stockMan) {
        this.stockMan = stockMan ;
    }

    public Integer getStockManId() {
        return stockManId ;
    }

    public void setStockManId(Integer stockManId) {
        this.stockManId = stockManId ;
    }

    public String getAdjustSubject() {
        return adjustSubject ;
    }

    public void setAdjustSubject(String adjustSubject) {
        this.adjustSubject = adjustSubject ;
    }

    public AdjustType getAdjustType() {
        return adjustType ;
    }

    public void setAdjustType(AdjustType adjustType) {
        this.adjustType = adjustType ;
    }

    public Date getAdjustDate() {
        return adjustDate ;
    }

    public void setAdjustDate(Date adjustDate) {
        this.adjustDate = adjustDate ;
    }

    public Long getAdjustSum() {
        return adjustSum ;
    }

    public void setAdjustSum(Long adjustSum) {
        this.adjustSum = adjustSum ;
    }

    public String getAdjustSumMoneyShow() {
        return adjustSumMoneyShow ;
    }

    public void setAdjustSumMoneyShow(String adjustSumMoneyShow) {
        this.adjustSumMoneyShow = adjustSumMoneyShow ;
    }

    public String getAdjustSumMoneyHide() {
        return adjustSumMoneyHide ;
    }

    public void setAdjustSumMoneyHide(String adjustSumMoneyHide) {
        this.adjustSumMoneyHide = adjustSumMoneyHide ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public SysStaffUser getCheckMan() {
        return checkMan ;
    }

    public void setCheckMan(SysStaffUser checkMan) {
        this.checkMan = checkMan ;
    }

    public Integer getCheckManId() {
        return checkManId ;
    }

    public void setCheckManId(Integer checkManId) {
        this.checkManId = checkManId ;
    }

    public Date getCheckedTime() {
        return checkedTime ;
    }

    public void setCheckedTime(Date checkedTime) {
        this.checkedTime = checkedTime ;
    }

    public SysStaffUser getRecordMan() {
        return recordMan ;
    }

    public void setRecordMan(SysStaffUser recordMan) {
        this.recordMan = recordMan ;
    }

    public Integer getRecordManId() {
        return recordManId ;
    }

    public void setRecordManId(Integer recordManId) {
        this.recordManId = recordManId ;
    }

}
