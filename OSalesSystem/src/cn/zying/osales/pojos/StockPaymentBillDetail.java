package cn.zying.osales.pojos ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

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
import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.pojos.commons.DetailCommBean ;

/**
 * 采购付款对账明细 StockPaymentState generated by hbm2java
 */
@Entity
@Table(name = "stock_payment_bill_detail")
public class StockPaymentBillDetail extends DetailCommBean {

    // 单据类型
    @Column(name = "bill_type")
    @Enumerated(EnumType.STRING)
    @FieldDesc(name = "单据类型")
    private BillType billType ;

    // 单据编号
    @Column(name = "bill_num")
    @FieldDesc(name = "单据编号")
    private String billNum ;

    // 单据日期
    @Column(name = "bill_date")
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "单据日期")
    private Date billDate ;

    // 供应商
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_info_id")
    private ProviderInfo providerInfo ;

    @Column(name = "provider_info_id", insertable = false, updatable = false)
    private Integer providerInfoId ;

    // 单据金额
    @Column(name = "payment_sum")
    private Long paymentSum ;

    @Transient
    private String paymentSumMoneyShow ;

    @Transient
    private String paymentSumMoneyHide ;

    @Column(name = "text")
    private String text ;

    // 已抵消金额
    @Column(name = "kill_sum")
    private Long killSum ;

    @Transient
    private String killSumMoneyShow ;

    @Transient
    private String killSumMoneyHide ;

    // 未抵消金额
    @Column(name = "no_kill_sum")
    private Long noKillSum ;

    @Transient
    private String noKillSumMoneyShow ;

    @Transient
    private String noKillSumMoneyHide ;

    @Transient
    private Integer stockPaymentId ;

    @Transient
    private StockPayment stockPayment ;

    @Transient
    private StockPaymentDetail stockPaymentDetail ;

    @Transient
    private Integer stockPaymentDetailId ;

    //单据对帐金额
    @Transient
    private Long stockPaymentDetailKillSum ;

    @Transient
    @FieldDesc(name = "抵消金额", isShow = true)
    private String stockPaymentDetailKillSumMoneyShow ;

    @Transient
    @FieldDesc(name = "抵消金额", isShow = false)
    private String stockPaymentDetailKillSumMoneyHide ;

    public BillType getBillType() {
        return billType ;
    }

    public void setBillType(BillType billType) {
        this.billType = billType ;
    }

    public String getBillNum() {
        return billNum ;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum ;
    }

    public Date getBillDate() {
        return billDate ;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate ;
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

    public Integer getStockPaymentId() {
        return stockPaymentId ;
    }

    public void setStockPaymentId(Integer stockPaymentId) {
        this.stockPaymentId = stockPaymentId ;
    }

    public StockPayment getStockPayment() {
        return stockPayment ;
    }

    public void setStockPayment(StockPayment stockPayment) {
        this.stockPayment = stockPayment ;
    }

    public StockPaymentDetail getStockPaymentDetail() {
        return stockPaymentDetail ;
    }

    public void setStockPaymentDetail(StockPaymentDetail stockPaymentDetail) {
        this.stockPaymentDetail = stockPaymentDetail ;
    }

    public Long getStockPaymentDetailKillSum() {
        return stockPaymentDetailKillSum ;
    }

    public void setStockPaymentDetailKillSum(Long stockPaymentDetailKillSum) {
        this.stockPaymentDetailKillSum = stockPaymentDetailKillSum ;
    }

    public String getStockPaymentDetailKillSumMoneyShow() {
        return stockPaymentDetailKillSumMoneyShow ;
    }

    public void setStockPaymentDetailKillSumMoneyShow(String stockPaymentDetailKillSumMoneyShow) {
        this.stockPaymentDetailKillSumMoneyShow = stockPaymentDetailKillSumMoneyShow ;
    }

    public String getStockPaymentDetailKillSumMoneyHide() {
        return stockPaymentDetailKillSumMoneyHide ;
    }

    public void setStockPaymentDetailKillSumMoneyHide(String stockPaymentDetailKillSumMoneyHide) {
        this.stockPaymentDetailKillSumMoneyHide = stockPaymentDetailKillSumMoneyHide ;
    }

    public Integer getStockPaymentDetailId() {
        return stockPaymentDetailId ;
    }

    public void setStockPaymentDetailId(Integer stockPaymentDetailId) {
        this.stockPaymentDetailId = stockPaymentDetailId ;
    }

}
