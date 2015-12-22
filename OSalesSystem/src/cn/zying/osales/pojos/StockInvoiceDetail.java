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
 * 采购发票对账明细 StockPaymentState generated by hbm2java
 */
@Entity
@Table(name = "stock_invoice_detail")
public class StockInvoiceDetail extends DetailCommBean {

    // 采购发票
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_invoice_id")
    private StockInvoice stockInvoice ;

    @Column(name = "stock_invoice_id", insertable = false, updatable = false)
    private Integer stockInvoiceId ;

    // 供应商
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_info_id")
    @FieldDesc(name = "供应商", mapping = "providerInfo.name")
    private ProviderInfo providerInfo ;

    @Column(name = "provider_info_id", insertable = false, updatable = false)
    @FieldDesc(name = "供应商", isShow = false)
    private Integer providerId ;

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

    @Column(name = "text")
    @FieldDesc(name = "备注")
    private String text ;

    // 单据金额
    @Column(name = "bill_sum")
    @FieldDesc(name = "单据金额", isShow = false)
    private Long billSum ;

    @Transient
    @FieldDesc(name = "单据金额", isShow = true)
    private String billSumMoneyShow ;

    @Transient
    @FieldDesc(name = "单据金额", isShow = false)
    private String billSumMoneyHide ;

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

    // 单据信息
    @Column(name = "bill_info")
    @FieldDesc(name = "单据信息")
    private String billInfo ;

    public StockInvoice getStockInvoice() {
        return stockInvoice ;
    }

    public void setStockInvoice(StockInvoice stockInvoice) {
        this.stockInvoice = stockInvoice ;
    }

    public Integer getStockInvoiceId() {
        return stockInvoiceId ;
    }

    public void setStockInvoiceId(Integer stockInvoiceId) {
        this.stockInvoiceId = stockInvoiceId ;
    }

    public ProviderInfo getProviderInfo() {
        return providerInfo ;
    }

    public void setProviderInfo(ProviderInfo providerInfo) {
        this.providerInfo = providerInfo ;
    }

    public Integer getProviderId() {
        return providerId ;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId ;
    }

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

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public Long getBillSum() {
        return billSum ;
    }

    public void setBillSum(Long billSum) {
        this.billSum = billSum ;
    }

    public String getBillSumMoneyShow() {
        return billSumMoneyShow ;
    }

    public void setBillSumMoneyShow(String billSumMoneyShow) {
        this.billSumMoneyShow = billSumMoneyShow ;
    }

    public String getBillSumMoneyHide() {
        return billSumMoneyHide ;
    }

    public void setBillSumMoneyHide(String billSumMoneyHide) {
        this.billSumMoneyHide = billSumMoneyHide ;
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

    public String getBillInfo() {
        return billInfo ;
    }

    public void setBillInfo(String billInfo) {
        this.billInfo = billInfo ;
    }

}
