package cn.zying.osales.pojos.commons ;

import java.util.Date ;

import javax.persistence.Column ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.MappedSuperclass ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;


@MappedSuperclass
public class StockDetailCommBean extends DetailCommBean {

    // 产品
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_info_id")
    @FieldDesc(name = "产品", mapping = "productInfo.name")
    private ProductInfo productInfo ;

    @Column(name = "product_info_id", insertable = false, updatable = false)
    private Integer productInfoId ;

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

    // 含税金额
    @Column(name = "tax_money")
    @FieldDesc(name = "含税金额", isShow = false)
    private Long taxMoney ;

    @Transient
    @FieldDesc(name = "含税金额", isShow = true)
    private String taxMoneyMoneyShow ;

    @Transient
    @FieldDesc(name = "含税金额", isShow = false)
    private String taxMoneyMoneyHide ;

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

    // 未税含税金额
    @Column(name = "no_tax_money")
    @FieldDesc(name = "未税金额", isShow = false)
    private Long noTaxMoney ;

    @Transient
    @FieldDesc(name = "未税金额", isShow = true)
    private String noTaxMoneyMoneyShow ;

    @Transient
    @FieldDesc(name = "未税金额", isShow = false)
    private String noTaxMoneyMoneyHide ;

    // 订购数量
    @Column(name = "count")
    @FieldDesc(name = "订购数量")
    private Integer orderCount ;

    // 订购箱数量
    @Column(name = "order_box")
    @FieldDesc(name = "订购箱数量")
    private String orderBox ;

    @Transient
    private String orderCountBoxShow ;

    @Column(name = "text")
    @FieldDesc(name = "备注")
    private String text ;

    // 仓库
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @FieldDesc(name = "入库仓库", mapping = "storeInfo.name")
    private StoreInfo storeInfo ;

    @Column(name = "store_id", insertable = false, updatable = false)
    private Integer storeInfoId ;

    // 库位
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_position_id")
    @FieldDesc(name = "入库库位", mapping = "storePosition.name")
    private StorePosition storePosition ;

    @Column(name = "store_position_id", insertable = false, updatable = false)
    private Integer storePositionId ;
    
    // 生产日期
    @Column(name = "produce_date")
    @Temporal(TemporalType.DATE)
    private Date produceDate ;

    //  // 有保质期？
    //  @Column(name = "is_protect_time")
    //  private Integer isProtectTime;

    // 保质期（天）
    @Column(name = "protect_time")
    private Integer protectTime ;

    // 库存数量
    @Transient
    private Integer storeCount ;

    @Transient
    private String storeBox ;

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

    public Long getTaxMoney() {
        return taxMoney ;
    }

    public void setTaxMoney(Long taxMoney) {
        this.taxMoney = taxMoney ;
    }

    public String getTaxMoneyMoneyShow() {
        return taxMoneyMoneyShow ;
    }

    public void setTaxMoneyMoneyShow(String taxMoneyMoneyShow) {
        this.taxMoneyMoneyShow = taxMoneyMoneyShow ;
    }

    public String getTaxMoneyMoneyHide() {
        return taxMoneyMoneyHide ;
    }

    public void setTaxMoneyMoneyHide(String taxMoneyMoneyHide) {
        this.taxMoneyMoneyHide = taxMoneyMoneyHide ;
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

    public Long getNoTaxMoney() {
        return noTaxMoney ;
    }

    public void setNoTaxMoney(Long noTaxMoney) {
        this.noTaxMoney = noTaxMoney ;
    }

    public String getNoTaxMoneyMoneyShow() {
        return noTaxMoneyMoneyShow ;
    }

    public void setNoTaxMoneyMoneyShow(String noTaxMoneyMoneyShow) {
        this.noTaxMoneyMoneyShow = noTaxMoneyMoneyShow ;
    }

    public String getNoTaxMoneyMoneyHide() {
        return noTaxMoneyMoneyHide ;
    }

    public void setNoTaxMoneyMoneyHide(String noTaxMoneyMoneyHide) {
        this.noTaxMoneyMoneyHide = noTaxMoneyMoneyHide ;
    }

    public Integer getOrderCount() {
        return orderCount ;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount ;
    }

    public String getOrderBox() {
        return orderBox ;
    }

    public void setOrderBox(String orderBox) {
        this.orderBox = orderBox ;
    }

    public String getOrderCountBoxShow() {
        return orderCountBoxShow ;
    }

    public void setOrderCountBoxShow(String orderCountBoxShow) {
        this.orderCountBoxShow = orderCountBoxShow ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public StoreInfo getStoreInfo() {
        return storeInfo ;
    }

    public void setStoreInfo(StoreInfo storeInfo) {
        this.storeInfo = storeInfo ;
    }

    public Integer getStoreInfoId() {
        return storeInfoId ;
    }

    public void setStoreInfoId(Integer storeInfoId) {
        this.storeInfoId = storeInfoId ;
    }

    public StorePosition getStorePosition() {
        return storePosition ;
    }

    public void setStorePosition(StorePosition storePosition) {
        this.storePosition = storePosition ;
    }

    public Integer getStorePositionId() {
        return storePositionId ;
    }

    public void setStorePositionId(Integer storePositionId) {
        this.storePositionId = storePositionId ;
    }

    public Integer getStoreCount() {
        return storeCount ;
    }

    public void setStoreCount(Integer storeCount) {
        this.storeCount = storeCount ;
    }

    public String getStoreBox() {
        return storeBox ;
    }

    public void setStoreBox(String storeBox) {
        this.storeBox = storeBox ;
    }

    public Date getProduceDate() {
        return produceDate ;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate ;
    }

    public Integer getProtectTime() {
        return protectTime ;
    }

    public void setProtectTime(Integer protectTime) {
        this.protectTime = protectTime ;
    }

}
