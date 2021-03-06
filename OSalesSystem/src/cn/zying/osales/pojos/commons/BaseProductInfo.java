package cn.zying.osales.pojos.commons ;

import java.util.List ;

import javax.persistence.Column ;
import javax.persistence.EnumType ;
import javax.persistence.Enumerated ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.MappedSuperclass ;
import javax.persistence.OneToOne ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.ProductInfoType ;
import cn.zying.osales.pojos.ProductBrand ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;

@MappedSuperclass
public class BaseProductInfo extends CommBean {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id")
    @FieldDesc(name = "类别", isShow = true, mapping = "productCategory.name", inputShow = false)
    private ProductCategory productCategory ;

    @Column(name = "product_category_id", insertable = false, updatable = false)
    @FieldDesc(name = "类别", isShow = false, mapping = "productCategory.name", inputShow = false)
    private Integer productCategoryId ;

    @Transient
    private List<Integer> productCategoryIds ;

    @Column(name = "short_name")
    @FieldDesc(name = "助记符")
    private String shortName ;

    @Transient
    private String baseUnitBoxUnit ;

    @Column(name = "name")
    @FieldDesc(name = "产品名称")
    private String name ;

    @Column(name = "model")
    @FieldDesc(name = "规格")
    private String model ;

    // 条码
    @Column(name = "bar_code")
    @FieldDesc(name = "条码")
    private String barCode ;

    @Column(name = "base_unit")
    @FieldDesc(name = "基本单位")
    private String baseUnit ;

    // 箱装量
    @Column(name = "box_count")
    @FieldDesc(name = "箱/件裝量")
    private Integer boxCount ;

    @Column(name = "box_unit")
    @FieldDesc(name = "箱/件裝单位")
    private String boxUnit ;

    @Column(name = "is_box")
    @FieldDesc(name = "是否以箱下单", desc = { "1:是", "0:否" })
    private Integer isBox ;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "providerInfo_id")
    @FieldDesc(name = "供应商", mapping = "providerInfo.name")
    private ProviderInfo providerInfo ;

    @Column(name = "providerInfo_id", insertable = false, updatable = false)
    @FieldDesc(name = "供应商", mapping = "providerInfo.name")
    private Integer providerInfoId ;

    @Transient
    private List<Integer> providerInfoIds ;

    // 最大采购价
    @Column(name = "max_stock_price")
    @FieldDesc(name = "最大采购价", isShow = false)
    private Long maxStockPrice ;

    @Transient
    @FieldDesc(name = "最大采购价", isShow = true)
    private String maxStockPriceMoneyShow ;

    @Transient
    @FieldDesc(name = "最大采购价", isShow = false)
    private String maxStockPriceMoneyHide ;
    
    // 最大采购价
    @Column(name = "max_no_tax_stock_price")
    @FieldDesc(name = "最大采购价", isShow = false)
    private Long maxNoTaxStockPrice ;

    @Transient
    @FieldDesc(name = "最大采购价", isShow = true)
    private String maxNoTaxStockPriceMoneyShow ;

    @Transient
    @FieldDesc(name = "最大采购价", isShow = false)
    private String maxNoTaxStockPriceMoneyHide ;

    //查询的含税采购价 
    @Transient
    private Long stockPrice ;

    @Transient
    private String stockPriceMoneyShow ;

    @Transient
    private String stockPriceMoneyHide ;

    //查询的末含税采购价 
    @Transient
    private Long stockNoTaxPrice ;

    @Transient
    private String stockNoTaxPriceMoneyShow ;

    @Transient
    private String stockNoTaxPriceMoneyHide ;

    // 销售价
    @Column(name = "sales_price")
    @FieldDesc(name = "销售价", isShow = false)
    private Long salesTaxPrice ;

    @Transient
    @FieldDesc(name = "销售价", isShow = true)
    private String salesTaxPriceMoneyShow ;

    @Transient
    @FieldDesc(name = "销售价", isShow = false)
    private String salesTaxPriceMoneyHide ;

    // 毛利率
    @Column(name = "gross_profit_rate")
    @FieldDesc(name = "毛利率", isShow = false)
    private Long grossProfitRate ;

    @Transient
    @FieldDesc(name = "毛利率", isShow = true)
    private String grossProfitRateTaxRateShow ;

    @Transient
    @FieldDesc(name = "毛利率", isShow = false)
    private String grossProfitRateTaxRateHide ;

    // 采购税率
    @Column(name = "stock_tax_rate")
    @FieldDesc(name = "采购税率", isShow = false)
    private Long stockTaxRate ;

    @Transient
    @FieldDesc(name = "采购税率", isShow = true)
    private String stockTaxRateTaxRateShow ;

    @Transient
    @FieldDesc(name = "采购税率", isShow = false)
    private String stockTaxRateTaxRateHide ;

    // 销售税率
    @Column(name = "sales_tax_rate")
    @FieldDesc(name = "销售税率", isShow = false)
    private Long salesTaxRate ;

    @Transient
    @FieldDesc(name = "销售税率", isShow = true)
    private String salesTaxRateTaxRateShow ;

    @Transient
    @FieldDesc(name = "销售税率", isShow = false)
    private String salesTaxRateTaxRateHide ;

    // 没含税单价
    @Column(name = "sales_no_tax_rate")
    @FieldDesc(name = "没含税单价", isShow = false)
    private Long salesNoTaxPrice ;

    @Transient
    @FieldDesc(name = "没含税单价", isShow = true)
    private String salesNoTaxPriceMoneyShow ;

    @Transient
    @FieldDesc(name = "没含税单价", isShow = false)
    private String salesNoTaxPriceMoneyHide ;

    // 税箱单价
    @Column(name = "sales_box_tax_price")
    @FieldDesc(name = "含税销售箱/件价格", isShow = false)
    private Long salesBoxTaxPrice ;

    @Transient
    @FieldDesc(name = "含税销售箱/件价格", isShow = true)
    private String salesBoxTaxPriceMoneyShow ;

    @Transient
    @FieldDesc(name = "含税销售箱/件价格", isShow = false)
    private String salesBoxTaxPriceMoneyHide ;

    // 含税箱单价
    @Column(name = "sales_box_no_tax_price")
    @FieldDesc(name = "没含税销售箱/件价格", isShow = false)
    private Long salesBoxNoTaxPrice ;

    @Transient
    @FieldDesc(name = "没含税销售箱/件价格", isShow = true)
    private String salesBoxNoTaxPriceMoneyShow ;

    @Transient
    @FieldDesc(name = "没含税销售箱/件价格", isShow = false)
    private String salesBoxNoTaxPriceMoneyHide ;

    //
    //    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productInfo", cascade = CascadeType.ALL)
    //    private List<ProductStoreInfo> productStoreInfo ;

    //    @Column(name = "is_shelf_life" ,length=1)
    //    @FieldDesc( name="是否有保质期" ,desc = { "1:有", "0:无" })
    //    private Integer isShelfLife ;

    @Column(name = "shelf_life")
    @FieldDesc(name = "保质期")
    private String shelfLife ;

    // 品牌
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_brand_id")
    @FieldDesc(name = "品牌", isShow = true, mapping = "productBrand.name")
    private ProductBrand productBrand ;

    @Column(name = "product_brand_id", insertable = false, updatable = false)
    @FieldDesc(name = "品牌", isShow = false, mapping = "productBrand.name")
    private Integer productBrandId ;

    @Transient
    private List<Integer> productBrandIds ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @FieldDesc(name = "仓库", isShow = true, mapping = "storeInfo.name")
    private StoreInfo storeInfo ;

    @Column(name = "store_id", insertable = false, updatable = false)
    @FieldDesc(name = "仓库", isShow = false, mapping = "storeInfo.name")
    private Integer storeInfoId ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_position_id")
    @FieldDesc(name = "库位", isShow = true, mapping = "storePosition.name")
    private StorePosition storePosition ;

    @SuppressWarnings("unused")
    @Column(name = "store_position_id", insertable = false, updatable = false)
    @FieldDesc(name = "库位", isShow = false, mapping = "storePosition.name")
    private Integer storePositionId ;

    @Column(name = "productInfo_type")
    @Enumerated(EnumType.STRING)
    @FieldDesc(name = "产品类型", desc = { "普通产品:普通产品", "组合产品:组合产品" })
    private ProductInfoType productInfoType ;

    @Column(name = "text")
    @FieldDesc(name = "备注", isShow = true)
    private String text ;

    public String getBaseUnitBoxUnit() {
        baseUnitBoxUnit = (boxCount == null ? "" : boxCount + baseUnit) ;
        baseUnitBoxUnit = baseUnitBoxUnit + (ToolsUnits.isNOtNulll(boxUnit) ? "/" + boxUnit : "") ;
        return baseUnitBoxUnit ;
    }

    public ProductCategory getProductCategory() {
        return productCategory ;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory ;
    }

    public String getShortName() {
        return shortName ;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName ;
    }

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
    }

    public String getModel() {
        return model ;
    }

    public void setModel(String model) {
        this.model = model ;
    }

    public String getBarCode() {
        return barCode ;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode ;
    }

    public String getBaseUnit() {
        return baseUnit ;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit ;
    }

    public Integer getBoxCount() {
        return boxCount ;
    }

    public void setBoxCount(Integer boxCount) {
        this.boxCount = boxCount ;
    }

    public String getBoxUnit() {
        return boxUnit ;
    }

    public void setBoxUnit(String boxUnit) {
        this.boxUnit = boxUnit ;
    }

    public Integer getIsBox() {
        return isBox ;
    }

    public void setIsBox(Integer isBox) {
        this.isBox = isBox ;
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

    public Long getMaxStockPrice() {
        return maxStockPrice ;
    }

    public void setMaxStockPrice(Long maxStockPrice) {
        this.maxStockPrice = maxStockPrice ;
    }

    public String getMaxStockPriceMoneyShow() {
        return maxStockPriceMoneyShow ;
    }

    public void setMaxStockPriceMoneyShow(String maxStockPriceMoneyShow) {
        this.maxStockPriceMoneyShow = maxStockPriceMoneyShow ;
    }

    public String getMaxStockPriceMoneyHide() {
        return maxStockPriceMoneyHide ;
    }

    public void setMaxStockPriceMoneyHide(String maxStockPriceMoneyHide) {
        this.maxStockPriceMoneyHide = maxStockPriceMoneyHide ;
    }

    public Long getSalesTaxPrice() {
        return salesTaxPrice ;
    }

    public void setSalesTaxPrice(Long salesTaxPrice) {
        this.salesTaxPrice = salesTaxPrice ;
    }

    public String getSalesTaxPriceMoneyShow() {
        return salesTaxPriceMoneyShow ;
    }

    public void setSalesTaxPriceMoneyShow(String salesTaxPriceMoneyShow) {
        this.salesTaxPriceMoneyShow = salesTaxPriceMoneyShow ;
    }

    public String getSalesTaxPriceMoneyHide() {
        return salesTaxPriceMoneyHide ;
    }

    public void setSalesTaxPriceMoneyHide(String salesTaxPriceMoneyHide) {
        this.salesTaxPriceMoneyHide = salesTaxPriceMoneyHide ;
    }

    public Long getGrossProfitRate() {
        return grossProfitRate ;
    }

    public void setGrossProfitRate(Long grossProfitRate) {
        this.grossProfitRate = grossProfitRate ;
    }

    public String getGrossProfitRateTaxRateShow() {
        return grossProfitRateTaxRateShow ;
    }

    public void setGrossProfitRateTaxRateShow(String grossProfitRateTaxRateShow) {
        this.grossProfitRateTaxRateShow = grossProfitRateTaxRateShow ;
    }

    public String getGrossProfitRateTaxRateHide() {
        return grossProfitRateTaxRateHide ;
    }

    public void setGrossProfitRateTaxRateHide(String grossProfitRateTaxRateHide) {
        this.grossProfitRateTaxRateHide = grossProfitRateTaxRateHide ;
    }

    public Long getStockTaxRate() {
        return stockTaxRate ;
    }

    public void setStockTaxRate(Long stockTaxRate) {
        this.stockTaxRate = stockTaxRate ;
    }

    public String getStockTaxRateTaxRateShow() {
        return stockTaxRateTaxRateShow ;
    }

    public void setStockTaxRateTaxRateShow(String stockTaxRateTaxRateShow) {
        this.stockTaxRateTaxRateShow = stockTaxRateTaxRateShow ;
    }

    public String getStockTaxRateTaxRateHide() {
        return stockTaxRateTaxRateHide ;
    }

    public void setStockTaxRateTaxRateHide(String stockTaxRateTaxRateHide) {
        this.stockTaxRateTaxRateHide = stockTaxRateTaxRateHide ;
    }

    public Long getSalesTaxRate() {
        return salesTaxRate ;
    }

    public void setSalesTaxRate(Long salesTaxRate) {
        this.salesTaxRate = salesTaxRate ;
    }

    public String getSalesTaxRateTaxRateShow() {
        return salesTaxRateTaxRateShow ;
    }

    public void setSalesTaxRateTaxRateShow(String salesTaxRateTaxRateShow) {
        this.salesTaxRateTaxRateShow = salesTaxRateTaxRateShow ;
    }

    public String getSalesTaxRateTaxRateHide() {
        return salesTaxRateTaxRateHide ;
    }

    public void setSalesTaxRateTaxRateHide(String salesTaxRateTaxRateHide) {
        this.salesTaxRateTaxRateHide = salesTaxRateTaxRateHide ;
    }

    public Long getSalesNoTaxPrice() {
        return salesNoTaxPrice ;
    }

    public void setSalesNoTaxPrice(Long salesNoTaxPrice) {
        this.salesNoTaxPrice = salesNoTaxPrice ;
    }

    public String getSalesNoTaxPriceMoneyShow() {
        return salesNoTaxPriceMoneyShow ;
    }

    public void setSalesNoTaxPriceMoneyShow(String salesNoTaxPriceMoneyShow) {
        this.salesNoTaxPriceMoneyShow = salesNoTaxPriceMoneyShow ;
    }

    public String getSalesNoTaxPriceMoneyHide() {
        return salesNoTaxPriceMoneyHide ;
    }

    public void setSalesNoTaxPriceMoneyHide(String salesNoTaxPriceMoneyHide) {
        this.salesNoTaxPriceMoneyHide = salesNoTaxPriceMoneyHide ;
    }

    public Long getSalesBoxTaxPrice() {
        return salesBoxTaxPrice ;
    }

    public void setSalesBoxTaxPrice(Long salesBoxTaxPrice) {
        this.salesBoxTaxPrice = salesBoxTaxPrice ;
    }

    public String getSalesBoxTaxPriceMoneyShow() {
        return salesBoxTaxPriceMoneyShow ;
    }

    public void setSalesBoxTaxPriceMoneyShow(String salesBoxTaxPriceMoneyShow) {
        this.salesBoxTaxPriceMoneyShow = salesBoxTaxPriceMoneyShow ;
    }

    public String getSalesBoxTaxPriceMoneyHide() {
        return salesBoxTaxPriceMoneyHide ;
    }

    public void setSalesBoxTaxPriceMoneyHide(String salesBoxTaxPriceMoneyHide) {
        this.salesBoxTaxPriceMoneyHide = salesBoxTaxPriceMoneyHide ;
    }

    public Long getSalesBoxNoTaxPrice() {
        return salesBoxNoTaxPrice ;
    }

    public void setSalesBoxNoTaxPrice(Long salesBoxNoTaxPrice) {
        this.salesBoxNoTaxPrice = salesBoxNoTaxPrice ;
    }

    public String getShelfLife() {
        return shelfLife ;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public ProductBrand getProductBrand() {
        return productBrand ;
    }

    public void setProductBrand(ProductBrand productBrand) {
        this.productBrand = productBrand ;
    }

    public Integer getProductBrandId() {
        return productBrandId ;
    }

    public void setProductBrandId(Integer productBrandId) {
        this.productBrandId = productBrandId ;
    }

    public Integer getStorePositionId() {
        return storePositionId ;
    }

    public void setStorePositionId(Integer storePositionId) {
        this.storePositionId = storePositionId ;
    }

    public ProductInfoType getProductInfoType() {
        return productInfoType ;
    }

    public void setProductInfoType(ProductInfoType productInfoType) {
        this.productInfoType = productInfoType ;
    }

    public void setBaseUnitBoxUnit(String baseUnitBoxUnit) {
        this.baseUnitBoxUnit = baseUnitBoxUnit ;
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

    public Integer getProductCategoryId() {
        return productCategoryId ;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId ;
    }

    public String getSalesBoxNoTaxPriceMoneyShow() {
        return salesBoxNoTaxPriceMoneyShow ;
    }

    public void setSalesBoxNoTaxPriceMoneyShow(String salesBoxNoTaxPriceMoneyShow) {
        this.salesBoxNoTaxPriceMoneyShow = salesBoxNoTaxPriceMoneyShow ;
    }

    public String getSalesBoxNoTaxPriceMoneyHide() {
        return salesBoxNoTaxPriceMoneyHide ;
    }

    public void setSalesBoxNoTaxPriceMoneyHide(String salesBoxNoTaxPriceMoneyHide) {
        this.salesBoxNoTaxPriceMoneyHide = salesBoxNoTaxPriceMoneyHide ;
    }

    public Long getStockPrice() {
        return stockPrice ;
    }

    public void setStockPrice(Long stockPrice) {
        this.stockPrice = stockPrice ;
    }

    public String getStockPriceMoneyShow() {
        return stockPriceMoneyShow ;
    }

    public void setStockPriceMoneyShow(String stockPriceMoneyShow) {
        this.stockPriceMoneyShow = stockPriceMoneyShow ;
    }

    public String getStockPriceMoneyHide() {
        return stockPriceMoneyHide ;
    }

    public void setStockPriceMoneyHide(String stockPriceMoneyHide) {
        this.stockPriceMoneyHide = stockPriceMoneyHide ;
    }

    public Long getStockNoTaxPrice() {
        return stockNoTaxPrice ;
    }

    public void setStockNoTaxPrice(Long stockNoTaxPrice) {
        this.stockNoTaxPrice = stockNoTaxPrice ;
    }

    public String getStockNoTaxPriceMoneyShow() {
        return stockNoTaxPriceMoneyShow ;
    }

    public void setStockNoTaxPriceMoneyShow(String stockNoTaxPriceMoneyShow) {
        this.stockNoTaxPriceMoneyShow = stockNoTaxPriceMoneyShow ;
    }

    public String getStockNoTaxPriceMoneyHide() {
        return stockNoTaxPriceMoneyHide ;
    }

    public void setStockNoTaxPriceMoneyHide(String stockNoTaxPriceMoneyHide) {
        this.stockNoTaxPriceMoneyHide = stockNoTaxPriceMoneyHide ;
    }

    public List<Integer> getProductCategoryIds() {
        return productCategoryIds ;
    }

    public void setProductCategoryIds(List<Integer> productCategoryIds) {
        this.productCategoryIds = productCategoryIds ;
    }

    public List<Integer> getProviderInfoIds() {
        return providerInfoIds ;
    }

    public void setProviderInfoIds(List<Integer> providerInfoIds) {
        this.providerInfoIds = providerInfoIds ;
    }

    public List<Integer> getProductBrandIds() {
        return productBrandIds ;
    }

    public void setProductBrandIds(List<Integer> productBrandIds) {
        this.productBrandIds = productBrandIds ;
    }

    public Long getMaxNoTaxStockPrice() {
        return maxNoTaxStockPrice ;
    }

    public void setMaxNoTaxStockPrice(Long maxNoTaxStockPrice) {
        this.maxNoTaxStockPrice = maxNoTaxStockPrice ;
    }

    public String getMaxNoTaxStockPriceMoneyShow() {
        return maxNoTaxStockPriceMoneyShow ;
    }

    public void setMaxNoTaxStockPriceMoneyShow(String maxNoTaxStockPriceMoneyShow) {
        this.maxNoTaxStockPriceMoneyShow = maxNoTaxStockPriceMoneyShow ;
    }

    public String getMaxNoTaxStockPriceMoneyHide() {
        return maxNoTaxStockPriceMoneyHide ;
    }

    public void setMaxNoTaxStockPriceMoneyHide(String maxNoTaxStockPriceMoneyHide) {
        this.maxNoTaxStockPriceMoneyHide = maxNoTaxStockPriceMoneyHide ;
    }

}
