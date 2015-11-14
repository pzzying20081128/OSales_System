package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.Table ;

import cn.zy.apps.tools.jpa.FieldDesc ;

@Entity
@Table(name = "produce_combined_product_detail")
public class ProduceComBinedProductDetail implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    // 要生产的产品 中包含的产品
    /**
     * 取值要求 1：ProductInfo ProductInfoType 组合
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productInfo_id")
    @FieldDesc(name="产品",mapping="productInfo.name")
    private ProductInfo productInfo ;

    @Column(name = "productInfo_id", insertable = false, updatable = false)
    @FieldDesc(name="产品")
    private Integer productInfoId ;

    // 需要单位产品数量
    @Column(name = "unit_quantity")
    @FieldDesc(name="单位产品数量")
    private Integer needunitQuantity ;

    // 需要的产品数量
    @Column(name = "productInfo_quantity")
    @FieldDesc(name="需要的产品数量")
    private Integer productInfoQuantity ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produce_producInfo_id")
    private ProduceComBinedProduct produceProducInfo ;

    @Column(name = "produce_producInfo_id", insertable = false, updatable = false)
    private Integer produceProducInfoId ;

    // 仓库
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @FieldDesc(name="出库仓库",mapping="storeInfo.name")
    private StoreInfo storeInfo ;

    @Column(name = "store_id", insertable = false, updatable = false)
    @FieldDesc(name="出库仓库")
    private Integer storeInfoId ;

    // 存放区
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_position_id")
    @FieldDesc(name="出库仓位" ,mapping="storePosition.name")
    private StorePosition storePosition ;

    @Column(name = "store_position_id", insertable = false, updatable = false)
    @FieldDesc(name="出库仓位")
    private Integer storePositionId ;

    // 备注
    @Column(name = "text")
    @FieldDesc(name=" 备注")
    private String text ;

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

    public Integer getProductInfoQuantity() {
        return productInfoQuantity ;
    }

    public void setProductInfoQuantity(Integer productInfoQuantity) {
        this.productInfoQuantity = productInfoQuantity ;
    }

    public Integer getProduceProducInfoId() {
        return produceProducInfoId ;
    }

    public void setProduceProducInfoId(Integer produceProducInfoId) {
        this.produceProducInfoId = produceProducInfoId ;
    }

    public void setStoreInfo(StoreInfo storeInfo) {
        this.storeInfo = storeInfo ;
    }

    public StoreInfo getStoreInfo() {
        return storeInfo ;
    }

    public void setStoreInfoId(Integer storeInfoId) {
        this.storeInfoId = storeInfoId ;
    }

    public Integer getStoreInfoId() {
        return storeInfoId ;
    }

    public void setStorePosition(StorePosition storePosition) {
        this.storePosition = storePosition ;
    }

    public StorePosition getStorePosition() {
        return storePosition ;
    }

    public void setStorePositionId(Integer storePositionId) {
        this.storePositionId = storePositionId ;
    }

    public Integer getStorePositionId() {
        return storePositionId ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public String getText() {
        return text ;
    }

    public Integer getNeedunitQuantity() {
        return needunitQuantity ;
    }

    public void setNeedunitQuantity(Integer needunitQuantity) {
        this.needunitQuantity = needunitQuantity ;
    }

    public ProduceComBinedProduct getProduceProducInfo() {
        return produceProducInfo ;
    }

    public void setProduceProducInfo(ProduceComBinedProduct produceProducInfo) {
        this.produceProducInfo = produceProducInfo ;
    }

}
