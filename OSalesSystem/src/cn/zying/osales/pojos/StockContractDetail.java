package cn.zying.osales.pojos ;

import java.util.List ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.Table ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.pojos.commons.DetailCommBean ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

/**
 * 采购合同明细
 */
@Entity
@Table(name = "stock_contract_detail")
public class StockContractDetail extends DetailCommBean {

    // 产品
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_info_id")
    @FieldDesc(name = "产品", mapping = "productInfo.name")
    private ProductInfo productInfo ;

    @Column(name = "product_info_id", insertable = false, updatable = false)
    @FieldDesc(name = "产品", isShow = false)
    private Integer productInfoId ;

    //stockInStoreId
    @Transient
    private List<Integer> productInfoIds ;

    // 含税单价
    @Column(name = "tax_price")
    @FieldDesc(name = "含税单价", isShow = false)
    private Long taxPrice ;

    @Transient
    @FieldDesc(name = "含税单价", isShow = true)
    private String taxPriceMoneyShow ;

    @Transient
    @FieldDesc(name = "含税单价", isShow = false)
    private String taxPriceMoneyHide ;

    // 税率
    @Column(name = "taxRate")
    @FieldDesc(name = "税率", isShow = false)
    private Long taxRate ;

    @Transient
    @FieldDesc(name = "税率", isShow = true)
    private String taxRateTaxRateShow ;

    @Transient
    @FieldDesc(name = "税率", isShow = false)
    private String taxRateTaxRateHide ;

    // 未税含税单价
    @Column(name = "no_tax_price")
    @FieldDesc(name = "未税单价", isShow = false)
    private Long noTaxPrice ;

    @Transient
    @FieldDesc(name = "未税单价", isShow = true)
    private String noTaxPriceMoneyShow ;

    @Transient
    @FieldDesc(name = "未税单价", isShow = false)
    private String noTaxPriceMoneyHide ;

    // 采购合同
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_contract_id")
    private StockContract stockContract ;

    @Column(name = "stock_contract_id", insertable = false, updatable = false)
    private Integer stockContractId ;

    // 是否以箱下单
    @Column(name = "is_box")
    @FieldDesc(desc = { "1:是", "0:否" })
    private Integer isBox ;

    @Column(name = "text")
    private String text ;

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

    public List<Integer> getProductInfoIds() {
        return productInfoIds ;
    }

    public void setProductInfoIds(List<Integer> productInfoIds) {
        this.productInfoIds = productInfoIds ;
    }

    public Long getTaxPrice() {
        return taxPrice ;
    }

    public void setTaxPrice(Long taxPrice) {
        this.taxPrice = taxPrice ;
    }

    public String getTaxPriceMoneyShow() {
        return taxPriceMoneyShow ;
    }

    public void setTaxPriceMoneyShow(String taxPriceMoneyShow) {
        this.taxPriceMoneyShow = taxPriceMoneyShow ;
    }

    public String getTaxPriceMoneyHide() {
        return taxPriceMoneyHide ;
    }

    public void setTaxPriceMoneyHide(String taxPriceMoneyHide) {
        this.taxPriceMoneyHide = taxPriceMoneyHide ;
    }

    public Long getTaxRate() {
        return taxRate ;
    }

    public void setTaxRate(Long taxRate) {
        this.taxRate = taxRate ;
    }

    public String getTaxRateTaxRateShow() {
        return taxRateTaxRateShow ;
    }

    public void setTaxRateTaxRateShow(String taxRateTaxRateShow) {
        this.taxRateTaxRateShow = taxRateTaxRateShow ;
    }

    public String getTaxRateTaxRateHide() {
        return taxRateTaxRateHide ;
    }

    public void setTaxRateTaxRateHide(String taxRateTaxRateHide) {
        this.taxRateTaxRateHide = taxRateTaxRateHide ;
    }

    public Long getNoTaxPrice() {
        return noTaxPrice ;
    }

    public void setNoTaxPrice(Long noTaxPrice) {
        this.noTaxPrice = noTaxPrice ;
    }

    public String getNoTaxPriceMoneyShow() {
        return noTaxPriceMoneyShow ;
    }

    public void setNoTaxPriceMoneyShow(String noTaxPriceMoneyShow) {
        this.noTaxPriceMoneyShow = noTaxPriceMoneyShow ;
    }

    public String getNoTaxPriceMoneyHide() {
        return noTaxPriceMoneyHide ;
    }

    public void setNoTaxPriceMoneyHide(String noTaxPriceMoneyHide) {
        this.noTaxPriceMoneyHide = noTaxPriceMoneyHide ;
    }

    public StockContract getStockContract() {
        return stockContract ;
    }

    public void setStockContract(StockContract stockContract) {
        this.stockContract = stockContract ;
    }

    public Integer getStockContractId() {
        return stockContractId ;
    }

    public void setStockContractId(Integer stockContractId) {
        this.stockContractId = stockContractId ;
    }

    public Integer getIsBox() {
        return isBox ;
    }

    public void setIsBox(Integer isBox) {
        this.isBox = isBox ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

}
