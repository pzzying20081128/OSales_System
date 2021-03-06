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
import cn.zying.osales.pojos.commons.CommBean ;

/**
 * 采购发票 StockInvoice generated by hbm2java
 */

@Entity
@Table(name = "stock_invoice")
public class StockInvoice extends CommBean {

    // 发票编号
    @Column(name = "num")
    @FieldDesc(name = "发票编号")
    private String num ;

    // 发票号
    @Column(name = "invoice_num")
    @FieldDesc(name = "发票号")
    private String invoiceNum ;

    // 供应商
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_info_id")
    @FieldDesc(name = "供应商", mapping = "providerInfo.name")
    private ProviderInfo providerInfo ;

    @Column(name = "provider_info_id", insertable = false, updatable = false)
    @FieldDesc(name = "供应商", isShow = false)
    private Integer providerInfoId ;

    @Transient
    private List<Integer> providerInfoIds ;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "stockInvoice")
    private List<StockInvoiceDetail> stockInvoiceDetails ;

    // 发票日期
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "发票日期")
    private Date invoiceDate ;

    //	// 设账期?
    //	@Column(name = "is_settle_time")
    //	private Integer isSettleTime;

    // 付款日期
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "付款日期")
    private Date paymentDate ;

    // 发票金额
    @Column(name = "invoice_sum")
    @FieldDesc(name = "发票金额", isShow = false)
    private Long invoiceSum ;

    @Transient
    @FieldDesc(name = "发票金额", isShow = true)
    private String invoiceSumMoneyShow ;

    @Transient
    @FieldDesc(name = "发票金额", isShow = false)
    private String invoiceSumMoneyHide ;

    @Column(name = "text")
    @FieldDesc(name = "备注")
    private String text ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_man_id")
    @FieldDesc(name = "录入人", mapping = "recordMan.name")
    private SysStaffUser recordMan ;

    @Column(name = "record_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "录入人", isShow = false)
    private Integer recordManId ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "check_man_id")
    @FieldDesc(name = "审核人", mapping = "checkMan.name")
    private SysStaffUser checkMan ;

    @Column(name = "check_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "审核人", isShow = false)
    private Integer checkManId ;

    @Column(name = "check_date")
    @Enumerated
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "审核日期")
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

    // /对账状态
    @Column(name = "reconciliation")
    @Enumerated(EnumType.STRING)
    private StockBillIsReconciliation reconciliation ;

    @Transient
    private List<StockBillIsReconciliation> reconciliations ;

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

    public String getInvoiceNum() {
        return invoiceNum ;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum ;
    }

    public ProviderInfo getProviderInfo() {
        return providerInfo ;
    }

    public void setProviderInfo(ProviderInfo providerInfo) {
        this.providerInfo = providerInfo ;
    }

    public List<StockInvoiceDetail> getStockInvoiceDetails() {
        return stockInvoiceDetails ;
    }

    public void setStockInvoiceDetails(List<StockInvoiceDetail> stockInvoiceDetails) {
        this.stockInvoiceDetails = stockInvoiceDetails ;
    }

    public Date getInvoiceDate() {
        return invoiceDate ;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate ;
    }

    public Date getPaymentDate() {
        return paymentDate ;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate ;
    }

    public Long getInvoiceSum() {
        return invoiceSum ;
    }

    public void setInvoiceSum(Long invoiceSum) {
        this.invoiceSum = invoiceSum ;
    }

    public String getInvoiceSumMoneyShow() {
        return invoiceSumMoneyShow ;
    }

    public void setInvoiceSumMoneyShow(String invoiceSumMoneyShow) {
        this.invoiceSumMoneyShow = invoiceSumMoneyShow ;
    }

    public String getInvoiceSumMoneyHide() {
        return invoiceSumMoneyHide ;
    }

    public void setInvoiceSumMoneyHide(String invoiceSumMoneyHide) {
        this.invoiceSumMoneyHide = invoiceSumMoneyHide ;
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

    public Integer getRecordManId() {
        return recordManId ;
    }

    public void setRecordManId(Integer recordManId) {
        this.recordManId = recordManId ;
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

    public StockBillIsReconciliation getReconciliation() {
        return reconciliation ;
    }

    public void setReconciliation(StockBillIsReconciliation reconciliation) {
        this.reconciliation = reconciliation ;
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

    public String getNum() {
        return num ;
    }

    public void setNum(String num) {
        this.num = num ;
    }

    public Integer getProviderInfoId() {
        return providerInfoId ;
    }

    public void setProviderInfoId(Integer providerInfoId) {
        this.providerInfoId = providerInfoId ;
    }

    public List<Integer> getProviderInfoIds() {
        return providerInfoIds ;
    }

    public void setProviderInfoIds(List<Integer> providerInfoIds) {
        this.providerInfoIds = providerInfoIds ;
    }

    public List<StockBillIsReconciliation> getReconciliations() {
        return reconciliations ;
    }

    public void setReconciliations(List<StockBillIsReconciliation> reconciliations) {
        this.reconciliations = reconciliations ;
    }

}
