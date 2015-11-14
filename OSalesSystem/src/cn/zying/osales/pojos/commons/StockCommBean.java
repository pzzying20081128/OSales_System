package cn.zying.osales.pojos.commons ;

import java.util.List ;

import javax.persistence.Column ;
import javax.persistence.EnumType ;
import javax.persistence.Enumerated ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.MappedSuperclass ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.OSalesConfigProperties.StockType ;
import cn.zying.osales.pojos.ProviderInfo ;

@MappedSuperclass
public class StockCommBean extends CommOrderBean {

    // 供应商
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_info_id")
    @FieldDesc(name = "供应商", mapping = "providerInfo.name")
    private ProviderInfo providerInfo ;

    @Column(name = "provider_info_id", insertable = false, updatable = false)
    @FieldDesc(name = "供应商")
    private Integer providerInfoId ;
    


    @Column(name = "tax_sum_money")
    @FieldDesc(name = "含税总金额", isShow = false)
    private Long taxSumMoney ;

    @Transient
    @FieldDesc(name = "含税总金额", isShow = true)
    private String taxSumMoneyMoneyShow ;

    @Transient
    @FieldDesc(name = "含税总金额", isShow = false)
    private String taxSumMoneyMoneyHide ;

    @Column(name = "no_tax_sum_money")
    @FieldDesc(name = "没税总金额", isShow = false)
    private Long noTaxSumMoney ;

    @Transient
    @FieldDesc(name = "没税总金额", isShow = true)
    private String noTaxSumMoneyMoneyShow ;

    @Transient
    @FieldDesc(name = "没税总金额", isShow = false)
    private String noTaxSumMoneyMoneyHide ;

    @Column(name = "order_count")
    @FieldDesc(name = "订购数量")
    private Integer orderCount ;

    // 采购订单类型
    @Column(name = "stock_type")
    @Enumerated(EnumType.STRING)
    @FieldDesc(name = "订单类型")
    private StockType stockType ;

    //为了查询
    @Transient
    private List<StockType> stockTypes ;

    @Transient
    private List<Integer> providerInfoIds ;

    @Transient
    private List<Integer> productInfoIds ;

    public Long getTaxSumMoney() {
        return taxSumMoney ;
    }

    public void setTaxSumMoney(Long taxSumMoney) {
        this.taxSumMoney = taxSumMoney ;
    }

    public String getTaxSumMoneyMoneyShow() {
        return taxSumMoneyMoneyShow ;
    }

    public void setTaxSumMoneyMoneyShow(String taxSumMoneyMoneyShow) {
        this.taxSumMoneyMoneyShow = taxSumMoneyMoneyShow ;
    }

    public String getTaxSumMoneyMoneyHide() {
        return taxSumMoneyMoneyHide ;
    }

    public void setTaxSumMoneyMoneyHide(String taxSumMoneyMoneyHide) {
        this.taxSumMoneyMoneyHide = taxSumMoneyMoneyHide ;
    }

    public Long getNoTaxSumMoney() {
        return noTaxSumMoney ;
    }

    public void setNoTaxSumMoney(Long noTaxSumMoney) {
        this.noTaxSumMoney = noTaxSumMoney ;
    }

    public String getNoTaxSumMoneyMoneyShow() {
        return noTaxSumMoneyMoneyShow ;
    }

    public void setNoTaxSumMoneyMoneyShow(String noTaxSumMoneyMoneyShow) {
        this.noTaxSumMoneyMoneyShow = noTaxSumMoneyMoneyShow ;
    }

    public String getNoTaxSumMoneyMoneyHide() {
        return noTaxSumMoneyMoneyHide ;
    }

    public void setNoTaxSumMoneyMoneyHide(String noTaxSumMoneyMoneyHide) {
        this.noTaxSumMoneyMoneyHide = noTaxSumMoneyMoneyHide ;
    }

    public Integer getOrderCount() {
        return orderCount ;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount ;
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

    public StockType getStockType() {
        return stockType ;
    }

    public void setStockType(StockType stockType) {
        this.stockType = stockType ;
    }

    public List<StockType> getStockTypes() {
        return stockTypes ;
    }

    public void setStockTypes(List<StockType> stockTypes) {
        this.stockTypes = stockTypes ;
    }

    public List<Integer> getProviderInfoIds() {
        return providerInfoIds ;
    }

    public void setProviderInfoIds(List<Integer> providerInfoIds) {
        this.providerInfoIds = providerInfoIds ;
    }

    public List<Integer> getProductInfoIds() {
        return productInfoIds ;
    }

    public void setProductInfoIds(List<Integer> productInfoIds) {
        this.productInfoIds = productInfoIds ;
    }

}
