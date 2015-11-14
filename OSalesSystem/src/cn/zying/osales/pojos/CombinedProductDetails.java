package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.OneToOne ;
import javax.persistence.Table ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;

@Entity
@Table(name = "base_combined_product_details")
public class CombinedProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_info_id")
    @FieldDesc(name = "产品", mapping = "productInfo.name")
    private ProductInfo productInfo ;

    @Column(name = "product_info_id", insertable = false, updatable = false)
    private Integer productInfoId ;

    @Column(name = "number")
    @FieldDesc(name = "产品数量")
    private Integer number ;

    @Column(name = "stock_money_price")
    @FieldDesc(name = "采购价", isShow = false)
    private Long stockMoneyPrice ;

    @Transient
    @FieldDesc(name = "最大采购价", isShow = true)
    private String stockMoneyPriceMoneyShow ;

    @Transient
    @FieldDesc(name = "最大采购价", isShow = false)
    private String stockMoneyPriceMoneyHide ;

    @Column(name = "sales_money_price")
    @FieldDesc(name = "销售价", isShow = false)
    private Long salesMoneyPrice ;

    @Transient
    @FieldDesc(name = "销售价", isShow = true)
    private String salesMoneyPriceMoneyShow ;

    @Transient
    @FieldDesc(name = "销售价", isShow = false)
    private String salesMoneyPriceMoneyHide ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "combined_product_id")
    private CombinedProduct combinedProduct ;

    @Column(name = "combined_product_id", insertable = false, updatable = false)
    private Integer combinedProductId ;

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
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

    public Integer getNumber() {
        return number ;
    }

    public void setNumber(Integer number) {
        this.number = number ;
    }

    public Long getStockMoneyPrice() {
        return stockMoneyPrice ;
    }

    public void setStockMoneyPrice(Long stockMoneyPrice) {
        this.stockMoneyPrice = stockMoneyPrice ;
    }

    public String getStockMoneyPriceMoneyShow() {
        return stockMoneyPriceMoneyShow ;
    }

    public void setStockMoneyPriceMoneyShow(String stockMoneyPriceMoneyShow) {
        this.stockMoneyPriceMoneyShow = stockMoneyPriceMoneyShow ;
    }

    public String getStockMoneyPriceMoneyHide() {
        return stockMoneyPriceMoneyHide ;
    }

    public void setStockMoneyPriceMoneyHide(String stockMoneyPriceMoneyHide) {
        this.stockMoneyPriceMoneyHide = stockMoneyPriceMoneyHide ;
    }

    public CombinedProduct getCombinedProduct() {
        return combinedProduct ;
    }

    public void setCombinedProduct(CombinedProduct combinedProduct) {
        this.combinedProduct = combinedProduct ;
    }

    public Integer getCombinedProductId() {
        return combinedProductId ;
    }

    public void setCombinedProductId(Integer combinedProductId) {
        this.combinedProductId = combinedProductId ;
    }

    public Long getSalesMoneyPrice() {
        return salesMoneyPrice ;
    }

    public void setSalesMoneyPrice(Long salesMoneyPrice) {
        this.salesMoneyPrice = salesMoneyPrice ;
    }

    public String getSalesMoneyPriceMoneyShow() {
        return salesMoneyPriceMoneyShow ;
    }

    public void setSalesMoneyPriceMoneyShow(String salesMoneyPriceMoneyShow) {
        this.salesMoneyPriceMoneyShow = salesMoneyPriceMoneyShow ;
    }

    public String getSalesMoneyPriceMoneyHide() {
        return salesMoneyPriceMoneyHide ;
    }

    public void setSalesMoneyPriceMoneyHide(String salesMoneyPriceMoneyHide) {
        this.salesMoneyPriceMoneyHide = salesMoneyPriceMoneyHide ;
    }

}
