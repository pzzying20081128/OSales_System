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

/**
 * 对帐明细
 * @author you
 *
 */
@Entity
@Table(name = "stock_payment_detail")
public class StockPaymentDetail extends DetailCommBean {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_detail_id")
    private StockPaymentBillDetail stockPaymentBillDetail ;

    @Column(name = "bill_detail_id", insertable = false, updatable = false)
    private Integer stockPaymentBillDetailId ;

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
    @JoinColumn(name = "stock_payment_id")
    private StockPayment stockPayment ;

    @Column(name = "stock_payment_id", insertable = false, updatable = false)
    private Integer stockPaymentId ;

    public StockPaymentBillDetail getStockPaymentBillDetail() {
        return stockPaymentBillDetail ;
    }

    public void setStockPaymentBillDetail(StockPaymentBillDetail stockPaymentBillDetail) {
        this.stockPaymentBillDetail = stockPaymentBillDetail ;
    }

    public Integer getStockPaymentBillDetailId() {
        return stockPaymentBillDetailId ;
    }

    public void setStockPaymentBillDetailId(Integer stockPaymentBillDetailId) {
        this.stockPaymentBillDetailId = stockPaymentBillDetailId ;
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

    public StockPayment getStockPayment() {
        return stockPayment ;
    }

    public void setStockPayment(StockPayment stockPayment) {
        this.stockPayment = stockPayment ;
    }

    public Integer getStockPaymentId() {
        return stockPaymentId ;
    }

    public void setStockPaymentId(Integer stockPaymentId) {
        this.stockPaymentId = stockPaymentId ;
    }

}
