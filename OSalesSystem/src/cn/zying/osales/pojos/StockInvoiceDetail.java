package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.Table ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.pojos.commons.DetailCommBean ;

@Entity
@Table(name = "stock_invoice_detail")
public class StockInvoiceDetail extends DetailCommBean {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_detail_id")
    private StockInvoiceBillDetail stockInvoiceBillDetail ;

    @Column(name = "bill_detail_id", insertable = false, updatable = false)
    private Integer stockInvoiceBillDetailId ;

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

    // 采购发票
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_invoice_id")
    private StockInvoice stockInvoice ;

    @Column(name = "stock_invoice_id", insertable = false, updatable = false)
    private Integer stockInvoiceId ;

    public StockInvoiceBillDetail getStockInvoiceBillDetail() {
        return stockInvoiceBillDetail ;
    }

    public void setStockInvoiceBillDetail(StockInvoiceBillDetail stockInvoiceBillDetail) {
        this.stockInvoiceBillDetail = stockInvoiceBillDetail ;
    }

    public Integer getStockInvoiceBillDetailId() {
        return stockInvoiceBillDetailId ;
    }

    public void setStockInvoiceBillDetailId(Integer stockInvoiceBillDetailId) {
        this.stockInvoiceBillDetailId = stockInvoiceBillDetailId ;
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

}
