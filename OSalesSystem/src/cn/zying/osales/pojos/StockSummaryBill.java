package cn.zying.osales.pojos ;

import java.util.Date ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.EnumType ;
import javax.persistence.Enumerated ;
import javax.persistence.FetchType ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.OneToOne ;
import javax.persistence.Table ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.OSalesConfigProperties.BillType ;

@Entity
@Table(name = "stock_summary_bill")
public class StockSummaryBill implements java.io.Serializable {

    private static final long serialVersionUID = 1835785718900105017L ;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    // 单据类型
    @Column(name = "bill_type")
    @Enumerated(EnumType.STRING)
    @FieldDesc(name = "单据类型")
    private BillType billType ;

    // 单据编号
    @Column(name = "bill_num")
    @FieldDesc(name = "单据编号")
    private String billNum ;

    @Column(name = "bill_time", length = 5)
    @Temporal(TemporalType.DATE)
    private Date billTime ;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "select_properties_id")
    private StockSummaryBillSelectProperties stockSummaryBillSelectProperties ;

    // 供应商
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_info_id")
    @FieldDesc(name = "供应商", mapping = "providerInfo.name")
    private ProviderInfo providerInfo ;

    @Column(name = "provider_info_id", insertable = false, updatable = false)
    @FieldDesc(name = "供应商", isShow = false)
    private Integer providerInfoId ;

    // 产品
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_info_id")
    @FieldDesc(name = "产品", mapping = "productInfo.name")
    private ProductInfo productInfo ;

    @Column(name = "product_info_id", insertable = false, updatable = false)
    private Integer productInfoId ;

    @Column(name = "stock_tax_sum_money")
    @FieldDesc(name = "进货含税总金额", isShow = false)
    private Long stockTaxSumMoney ;

    @Transient
    @FieldDesc(name = "进货含税总金额", isShow = true)
    private String stockTaxSumMoneyMoneyShow ;

    @Transient
    @FieldDesc(name = "进货含税总金额", isShow = false)
    private String stockTaxSumMoneyMoneyHide ;

    @Column(name = "stock_no_tax_sum_money")
    @FieldDesc(name = "进货末税总金额", isShow = false)
    private Long stockNoTaxSumMoney ;

    @Transient
    @FieldDesc(name = "进货末税总金额", isShow = true)
    private String stockNoTaxSumMoneyMoneyShow ;

    @Transient
    @FieldDesc(name = "进货末税总金额", isShow = false)
    private String stockNoTaxSumMoneyMoneyHide ;

    @Column(name = "stock_count")
    @FieldDesc(name = "进货数量")
    private Integer stockCount ;

    ///////////////////////////////////////////////////////////////////
    @Column(name = "return_goods_tax_sum_money")
    @FieldDesc(name = "退货含税总金额", isShow = false)
    private Long returnGoodsTaxSumMoney ;

    @Transient
    @FieldDesc(name = "退货含税总金额", isShow = true)
    private String returnGoodsTaxSumMoneyMoneyShow ;

    @Transient
    @FieldDesc(name = "退货含税总金额", isShow = false)
    private String returnGoodsTaxSumMoneyMoneyHide ;

    @Column(name = "return_goods_no_tax_sum_money")
    @FieldDesc(name = "退货末税总金额", isShow = false)
    private Long returnGoodsNoTaxSumMoney ;

    @Transient
    @FieldDesc(name = "退货末税总金额", isShow = true)
    private String returnGoodsNoTaxSumMoneyMoneyShow ;

    @Transient
    @FieldDesc(name = "退货末税总金额", isShow = false)
    private String returnGoodsNoTaxSumMoneyMoneyHide ;

    @Column(name = "return_goods_count")
    @FieldDesc(name = "退货数量")
    private Integer returnGoodsCount ;

    /////////////////////////////////////////////////////////////////////

    @Column(name = "stock_adjust_sum_money")
    @FieldDesc(name = "采购调整金额", isShow = false)
    private Long stockAdjustSumMoney ;

    @Transient
    @FieldDesc(name = "采购调整金额", isShow = true)
    private String stockAdjustSumMoneyMoneyShow ;

    @Transient
    @FieldDesc(name = "采购调整金额", isShow = false)
    private String stockAdjustSumMoneyMoneyHide ;

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

    public ProductInfo getProductInfo() {
        return productInfo ;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo ;
    }

    public Integer getProductInfoId() {
        return productInfoId ;
    }

    public void setProductInfoId(Integer productInfoId) {
        this.productInfoId = productInfoId ;
    }

    public Long getStockTaxSumMoney() {
        return stockTaxSumMoney ;
    }

    public void setStockTaxSumMoney(Long stockTaxSumMoney) {
        this.stockTaxSumMoney = stockTaxSumMoney ;
    }

    public String getStockTaxSumMoneyMoneyShow() {
        return stockTaxSumMoneyMoneyShow ;
    }

    public void setStockTaxSumMoneyMoneyShow(String stockTaxSumMoneyMoneyShow) {
        this.stockTaxSumMoneyMoneyShow = stockTaxSumMoneyMoneyShow ;
    }

    public String getStockTaxSumMoneyMoneyHide() {
        return stockTaxSumMoneyMoneyHide ;
    }

    public void setStockTaxSumMoneyMoneyHide(String stockTaxSumMoneyMoneyHide) {
        this.stockTaxSumMoneyMoneyHide = stockTaxSumMoneyMoneyHide ;
    }

    public Long getStockNoTaxSumMoney() {
        return stockNoTaxSumMoney ;
    }

    public void setStockNoTaxSumMoney(Long stockNoTaxSumMoney) {
        this.stockNoTaxSumMoney = stockNoTaxSumMoney ;
    }

    public String getStockNoTaxSumMoneyMoneyShow() {
        return stockNoTaxSumMoneyMoneyShow ;
    }

    public void setStockNoTaxSumMoneyMoneyShow(String stockNoTaxSumMoneyMoneyShow) {
        this.stockNoTaxSumMoneyMoneyShow = stockNoTaxSumMoneyMoneyShow ;
    }

    public String getStockNoTaxSumMoneyMoneyHide() {
        return stockNoTaxSumMoneyMoneyHide ;
    }

    public void setStockNoTaxSumMoneyMoneyHide(String stockNoTaxSumMoneyMoneyHide) {
        this.stockNoTaxSumMoneyMoneyHide = stockNoTaxSumMoneyMoneyHide ;
    }

    public Integer getStockCount() {
        return stockCount ;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount ;
    }

    public Long getReturnGoodsTaxSumMoney() {
        return returnGoodsTaxSumMoney ;
    }

    public void setReturnGoodsTaxSumMoney(Long returnGoodsTaxSumMoney) {
        this.returnGoodsTaxSumMoney = returnGoodsTaxSumMoney ;
    }

    public String getReturnGoodsTaxSumMoneyMoneyShow() {
        return returnGoodsTaxSumMoneyMoneyShow ;
    }

    public void setReturnGoodsTaxSumMoneyMoneyShow(String returnGoodsTaxSumMoneyMoneyShow) {
        this.returnGoodsTaxSumMoneyMoneyShow = returnGoodsTaxSumMoneyMoneyShow ;
    }

    public String getReturnGoodsTaxSumMoneyMoneyHide() {
        return returnGoodsTaxSumMoneyMoneyHide ;
    }

    public void setReturnGoodsTaxSumMoneyMoneyHide(String returnGoodsTaxSumMoneyMoneyHide) {
        this.returnGoodsTaxSumMoneyMoneyHide = returnGoodsTaxSumMoneyMoneyHide ;
    }

    public Long getReturnGoodsNoTaxSumMoney() {
        return returnGoodsNoTaxSumMoney ;
    }

    public void setReturnGoodsNoTaxSumMoney(Long returnGoodsNoTaxSumMoney) {
        this.returnGoodsNoTaxSumMoney = returnGoodsNoTaxSumMoney ;
    }

    public String getReturnGoodsNoTaxSumMoneyMoneyShow() {
        return returnGoodsNoTaxSumMoneyMoneyShow ;
    }

    public void setReturnGoodsNoTaxSumMoneyMoneyShow(String returnGoodsNoTaxSumMoneyMoneyShow) {
        this.returnGoodsNoTaxSumMoneyMoneyShow = returnGoodsNoTaxSumMoneyMoneyShow ;
    }

    public String getReturnGoodsNoTaxSumMoneyMoneyHide() {
        return returnGoodsNoTaxSumMoneyMoneyHide ;
    }

    public void setReturnGoodsNoTaxSumMoneyMoneyHide(String returnGoodsNoTaxSumMoneyMoneyHide) {
        this.returnGoodsNoTaxSumMoneyMoneyHide = returnGoodsNoTaxSumMoneyMoneyHide ;
    }

    public Integer getReturnGoodsCount() {
        return returnGoodsCount ;
    }

    public void setReturnGoodsCount(Integer returnGoodsCount) {
        this.returnGoodsCount = returnGoodsCount ;
    }

    public Long getStockAdjustSumMoney() {
        return stockAdjustSumMoney ;
    }

    public void setStockAdjustSumMoney(Long stockAdjustSumMoney) {
        this.stockAdjustSumMoney = stockAdjustSumMoney ;
    }

    public String getStockAdjustSumMoneyMoneyShow() {
        return stockAdjustSumMoneyMoneyShow ;
    }

    public void setStockAdjustSumMoneyMoneyShow(String stockAdjustSumMoneyMoneyShow) {
        this.stockAdjustSumMoneyMoneyShow = stockAdjustSumMoneyMoneyShow ;
    }

    public String getStockAdjustSumMoneyMoneyHide() {
        return stockAdjustSumMoneyMoneyHide ;
    }

    public void setStockAdjustSumMoneyMoneyHide(String stockAdjustSumMoneyMoneyHide) {
        this.stockAdjustSumMoneyMoneyHide = stockAdjustSumMoneyMoneyHide ;
    }

    public StockSummaryBillSelectProperties getStockSummaryBillSelectProperties() {
        return stockSummaryBillSelectProperties ;
    }

    public void setStockSummaryBillSelectProperties(StockSummaryBillSelectProperties stockSummaryBillSelectProperties) {
        this.stockSummaryBillSelectProperties = stockSummaryBillSelectProperties ;
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

    public Date getBillTime() {
        return billTime ;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime ;
    }

}
