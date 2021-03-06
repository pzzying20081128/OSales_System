package cn.zying.osales.pojos ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

import java.util.Date ;
import java.util.List ;

import javax.persistence.CascadeType ;
import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.EnumType ;
import javax.persistence.Enumerated ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.OneToMany ;
import javax.persistence.Table ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.OSalesConfigProperties.StockBillIsReconciliation ;
import cn.zying.osales.OSalesConfigProperties.StockPaymentType ;
import cn.zying.osales.pojos.commons.CommBean ;

/**
 * 采购付款 StockPayment generated by hbm2java
 */
@Entity
@Table(name = "stock_payment")
public class StockPayment extends CommBean {

    // 付款单号
    @Column(name = "num")
    @FieldDesc(name = "付款单号")
    private String num ;

    // 对方收款单号
    @Column(name = "other_side_receive_num")
    @FieldDesc(name = "对方收款单号")
    private String otherSideReceiveNum ;

    // 供应商
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_info_id")
    @FieldDesc(name = "付款商", mapping = "providerInfo.name")
    private ProviderInfo providerInfo ;

    @Column(name = "provider_info_id", insertable = false, updatable = false)
    @FieldDesc(name = "付款商")
    private Integer providerInfoId ;

    // 采购员
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_man_id")
    @FieldDesc(name = "采购员", mapping = "stockMan.name")
    private SysStaffUser stockMan ;

    @Column(name = "stock_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "采购员")
    private Integer stockManId ;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "stockPayment")
    private List<StockPaymentDetail> stockPaymentDetails ;

    // 预付?
    @Column(name = "is_prepayment")
    @FieldDesc(name = "是否预付")
    private Integer isPrePayment ;

    @Transient
    private List<Integer> isPrePayments ;

    // 付款日期
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "付款日期")
    private Date paymentDate ;

    // 付款金额
    @Column(name = "payment_sum")
    @FieldDesc(name = "付款金额")
    private Long paymentSum ;

    @Transient
    @FieldDesc(name = "付款金额")
    private String paymentSumMoneyShow ;

    @Transient
    @FieldDesc(name = "付款金额")
    private String paymentSumMoneyHide ;

    @Column(name = "text")
    @FieldDesc(name = "备注")
    private String text ;

    @ManyToOne(fetch = FetchType.LAZY)
    @FieldDesc(name = "采审核人", mapping = "checkMan.name")
    private SysStaffUser checkMan ;

    @Column(name = "check_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "采审核人")
    private Integer checkManId ;

    @Column(name = "check_date")
    @Enumerated
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "采审时间")
    private Date checkedDate ;

    // 抵消金额
    @Column(name = "kill_sum")
    @FieldDesc(name = "抵消金额", isShow = false)
    private Long killSum ;

    @Transient
    @FieldDesc(name = "抵消金额", isShow = true)
    private String killSumMoneyShow ;

    @Transient
    @FieldDesc(name = "抵消金额", isShow = false)
    private String killSumMoneyHide ;

    // 未抵消金额
    @Column(name = "no_kill_sum")
    @FieldDesc(name = "未抵消金额", isShow = false)
    private Long noKillSum ;

    @Transient
    @FieldDesc(name = "未抵消金额", isShow = true)
    private String noKillSumMoneyShow ;

    @Transient
    @FieldDesc(name = "未抵消金额", isShow = false)
    private String noKillSumMoneyHide ;

    // /对账余额
    @Column(name = "reconciliationSum")
    @FieldDesc(name = "对账余额", isShow = false)
    private Long reconciliationSum ;

    @Transient
    @FieldDesc(name = "对账余额", isShow = true)
    private String reconciliationSumMoneyShow ;

    @Transient
    @FieldDesc(name = "对账余额", isShow = false)
    private String reconciliationSumMoneyHide ;

    // 对方银行
    @Column(name = "other_side_bank")
    @FieldDesc(name = "对方银行")
    private String otherSideBank ;

    // 我方银行
    @Column(name = "our_bank")
    @FieldDesc(name = "我方银行")
    private String ourBank ;

    // 付款方式
    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    @FieldDesc(name = "付款方式")
    private StockPaymentType paymentType ;

    @Transient
    private List<StockPaymentType> paymentTypes ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_man_id")
    @FieldDesc(name = "录入人", mapping = "recordMan.name")
    private SysStaffUser recordMan ;

    @Column(name = "record_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "录入人", isShow = false)
    private Integer recordManId ;

    // /对账状态
    @Column(name = "reconciliation")
    @Enumerated(EnumType.STRING)
    private StockBillIsReconciliation reconciliation ;

    @Transient
    private List<StockBillIsReconciliation> reconciliationes ;

    public String getNum() {
        return num ;
    }

    public void setNum(String num) {
        this.num = num ;
    }

    public String getOtherSideReceiveNum() {
        return otherSideReceiveNum ;
    }

    public void setOtherSideReceiveNum(String otherSideReceiveNum) {
        this.otherSideReceiveNum = otherSideReceiveNum ;
    }

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

    public Integer getIsPrePayment() {
        return isPrePayment ;
    }

    public void setIsPrePayment(Integer isPrePayment) {
        this.isPrePayment = isPrePayment ;
    }

    public Date getPaymentDate() {
        return paymentDate ;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate ;
    }

    public Long getPaymentSum() {
        return paymentSum ;
    }

    public void setPaymentSum(Long paymentSum) {
        this.paymentSum = paymentSum ;
    }

    public String getPaymentSumMoneyShow() {
        return paymentSumMoneyShow ;
    }

    public void setPaymentSumMoneyShow(String paymentSumMoneyShow) {
        this.paymentSumMoneyShow = paymentSumMoneyShow ;
    }

    public String getPaymentSumMoneyHide() {
        return paymentSumMoneyHide ;
    }

    public void setPaymentSumMoneyHide(String paymentSumMoneyHide) {
        this.paymentSumMoneyHide = paymentSumMoneyHide ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public SysStaffUser getRecordMan() {
        return recordMan ;
    }

    public void setRecordMan(SysStaffUser recordMan) {
        this.recordMan = recordMan ;
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

    public Date getCheckedDate() {
        return checkedDate ;
    }

    public void setCheckedDate(Date checkedDate) {
        this.checkedDate = checkedDate ;
    }

    public Long getKillSum() {
        return killSum ;
    }

    public void setKillSum(Long killSum) {
        this.killSum = killSum ;
    }

    public String getKillSumMoneyShow() {
        return killSumMoneyShow ;
    }

    public void setKillSumMoneyShow(String killSumMoneyShow) {
        this.killSumMoneyShow = killSumMoneyShow ;
    }

    public String getKillSumMoneyHide() {
        return killSumMoneyHide ;
    }

    public void setKillSumMoneyHide(String killSumMoneyHide) {
        this.killSumMoneyHide = killSumMoneyHide ;
    }

    public Long getNoKillSum() {
        return noKillSum ;
    }

    public void setNoKillSum(Long noKillSum) {
        this.noKillSum = noKillSum ;
    }

    public String getNoKillSumMoneyShow() {
        return noKillSumMoneyShow ;
    }

    public void setNoKillSumMoneyShow(String noKillSumMoneyShow) {
        this.noKillSumMoneyShow = noKillSumMoneyShow ;
    }

    public String getNoKillSumMoneyHide() {
        return noKillSumMoneyHide ;
    }

    public void setNoKillSumMoneyHide(String noKillSumMoneyHide) {
        this.noKillSumMoneyHide = noKillSumMoneyHide ;
    }

    public String getOtherSideBank() {
        return otherSideBank ;
    }

    public void setOtherSideBank(String otherSideBank) {
        this.otherSideBank = otherSideBank ;
    }

    public String getOurBank() {
        return ourBank ;
    }

    public void setOurBank(String ourBank) {
        this.ourBank = ourBank ;
    }

    public StockPaymentType getPaymentType() {
        return paymentType ;
    }

    public void setPaymentType(StockPaymentType paymentType) {
        this.paymentType = paymentType ;
    }

    public List<StockPaymentDetail> getStockPaymentDetails() {
        return stockPaymentDetails ;
    }

    public void setStockPaymentDetails(List<StockPaymentDetail> stockPaymentDetails) {
        this.stockPaymentDetails = stockPaymentDetails ;
    }

    public Integer getRecordManId() {
        return recordManId ;
    }

    public void setRecordManId(Integer recordManId) {
        this.recordManId = recordManId ;
    }

    public Long getReconciliationSum() {
        return reconciliationSum ;
    }

    public void setReconciliationSum(Long reconciliationSum) {
        this.reconciliationSum = reconciliationSum ;
    }

    public String getReconciliationSumMoneyShow() {
        return reconciliationSumMoneyShow ;
    }

    public void setReconciliationSumMoneyShow(String reconciliationSumMoneyShow) {
        this.reconciliationSumMoneyShow = reconciliationSumMoneyShow ;
    }

    public String getReconciliationSumMoneyHide() {
        return reconciliationSumMoneyHide ;
    }

    public void setReconciliationSumMoneyHide(String reconciliationSumMoneyHide) {
        this.reconciliationSumMoneyHide = reconciliationSumMoneyHide ;
    }

    public List<StockPaymentType> getPaymentTypes() {
        return paymentTypes ;
    }

    public void setPaymentTypes(List<StockPaymentType> paymentTypes) {
        this.paymentTypes = paymentTypes ;
    }

    public List<Integer> getIsPrePayments() {
        return isPrePayments ;
    }

    public void setIsPrePayments(List<Integer> isPrePayments) {
        this.isPrePayments = isPrePayments ;
    }

    public StockBillIsReconciliation getReconciliation() {
        return reconciliation ;
    }

    public void setReconciliation(StockBillIsReconciliation reconciliation) {
        this.reconciliation = reconciliation ;
    }

    public List<StockBillIsReconciliation> getReconciliationes() {
        return reconciliationes ;
    }

    public void setReconciliationes(List<StockBillIsReconciliation> reconciliationes) {
        this.reconciliationes = reconciliationes ;
    }

}
