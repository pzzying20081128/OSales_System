package cn.zying.osales.pojos ;

import java.util.Date ;
import java.util.List ;

import javax.persistence.CascadeType ;
import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.OneToMany ;
import javax.persistence.OneToOne ;
import javax.persistence.Table ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.pojos.commons.CommOrderBean ;

/**
 * 生产组合产品
 * 
 * @author i
 * 
 */
@Entity
@Table(name = "produce_combined_product")
public class ProduceComBinedProduct extends CommOrderBean implements java.io.Serializable {

    // 要生产的产品
    /**
     * 取值要求 1：ProductInfo ProductInfoType 组合
     */

    // 生产产品
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productInfo_id")
    @FieldDesc(name = "组合产品", mapping = "productInfo.name")
    private ProductInfo productInfo ;

    @Column(name = "productInfo_id", insertable = false, updatable = false)
    @FieldDesc(name = "组合产品")
    private Integer productInfoId ;

    // 生产日期
    @Column(name = "produce_date")
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "生产日期")
    private Date produceDate ;

    // /生产数量
    @Column(name = "produce_count")
    @FieldDesc(name = "生产数量")
    private Integer produceCount ;

    // 仓库
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @FieldDesc(name = "入库仓库", mapping = "storeInfo.name")
    private StoreInfo storeInfo ;

    @Column(name = "store_id", insertable = false, updatable = false)
    @FieldDesc(name = "入库仓库")
    private Integer storeInfoId ;

    // 库位
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_position_id")
    @FieldDesc(name = "入库库位", mapping = "storePosition.name")
    private StorePosition storePosition ;

    @Column(name = "store_position_id", insertable = false, updatable = false)
    @FieldDesc(name = "入库库位")
    private Integer storePositionId ;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "produceProducInfo")
    private List<ProduceComBinedProductDetail> produceComBinationProducInfoDetails ;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_in_store_id")
    @FieldDesc(name = "采购入库单", mapping = "stockInStore.number")
    private StockInStore stockInStore ;

    @Column(name = "stock_in_store_id", insertable = false, updatable = false)
    @FieldDesc(name = "采购入库单")
    private Integer stockInStoreId ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_order_id")
    @FieldDesc(name = "采购单", mapping = "stockOrder.number")
    private StockOrder stockOrder ;

    @Column(name = "stock_order_id", insertable = false, updatable = false)
    @FieldDesc(name = "采购单")
    private Integer stockOrderId ;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_order_detail_id")
    @FieldDesc(name = "采购明细",isShow=false)
    private StockOrderDetail stockOrderDetail ;

    @Column(name = "stock_order_detail_id", insertable = false, updatable = false)
    @FieldDesc(name = "采购明细")
    private Integer stockOrderDetailId ;

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

    public Date getProduceDate() {
        return produceDate ;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate ;
    }

    public Integer getProduceCount() {
        return produceCount ;
    }

    public void setProduceCount(Integer produceCount) {
        this.produceCount = produceCount ;
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

    public List<ProduceComBinedProductDetail> getProduceComBinationProducInfoDetails() {
        return produceComBinationProducInfoDetails ;
    }

    public void setProduceComBinationProducInfoDetails(List<ProduceComBinedProductDetail> produceComBinationProducInfoDetails) {
        this.produceComBinationProducInfoDetails = produceComBinationProducInfoDetails ;
    }

    public StockInStore getStockInStore() {
        return stockInStore ;
    }

    public void setStockInStore(StockInStore stockInStore) {
        this.stockInStore = stockInStore ;
    }

    public Integer getStockInStoreId() {
        return stockInStoreId ;
    }

    public void setStockInStoreId(Integer stockInStoreId) {
        this.stockInStoreId = stockInStoreId ;
    }

    public StockOrder getStockOrder() {
        return stockOrder ;
    }

    public void setStockOrder(StockOrder stockOrder) {
        this.stockOrder = stockOrder ;
    }

    public Integer getStockOrderId() {
        return stockOrderId ;
    }

    public void setStockOrderId(Integer stockOrderId) {
        this.stockOrderId = stockOrderId ;
    }

    public StockOrderDetail getStockOrderDetail() {
        return stockOrderDetail ;
    }

    public void setStockOrderDetail(StockOrderDetail stockOrderDetail) {
        this.stockOrderDetail = stockOrderDetail ;
    }

    public Integer getStockOrderDetailId() {
        return stockOrderDetailId ;
    }

    public void setStockOrderDetailId(Integer stockOrderDetailId) {
        this.stockOrderDetailId = stockOrderDetailId ;
    }

}
