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
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;

/**
 * 商品库存信息细节
 * 
 * @author fack
 * 
 */
@Entity
@Table(name = "store_product_info_detail")
public class StoreProductInfoDetail implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6082343614242755931L ;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    /**
     * 库存数量
     * 
     */
    @Column(name = "purchase_sum")
    @FieldDesc(name = "库存数量")
    private Integer purchaseSum ;

    /**
     * 库存金额
     * 
     */
    @Column(name = "purchase_money")
    private Long purchaseMoney ;

    @Transient
    @FieldDesc(name = "库存金额")
    private String purchaseMoneyMoneyShow ;

    @Transient
    private String purchaseMoneyMoneyHide ;

    /**
     * 计划入库数量
     */
    @Column(name = "plan_in_sum")
    @FieldDesc(name = "计划入库数量")
    private Integer planInStoreSum ;

    @Column(name = "plan_in_money")
    private Long planInStoreMoney ;

    @Transient
    @FieldDesc(name = " 计划入库金额")
    private String planInStoreMoneyMoneyShow ;

    @Transient
    private String planInStoreMoneyMoneyHide ;

    /**
     * 计划出库数量
     */
    @Column(name = "plan_out_sum")
    @FieldDesc(name = "计划出库数量")
    private Integer planOutStoreSum ;

    @Column(name = "plan_out_money")
    private Long planOutStoreMoney ;

    @Transient
    @FieldDesc(name = "计划出库金额")
    private String planOutStoreMoneyMoneyShow ;

    @Transient
    private String planOutStoreMoneyMoneyHide ;

    /**
     * 实际/审批出库数量
     */
    @Column(name = "approval_sum")
    @FieldDesc(name = "审批出库数量")
    private Integer approvalSum ;

    @Column(name = "approval_money")
    private Long approvalMoney ;

    @Transient
    @FieldDesc(name = "审批出库金额")
    private String approvalMoneyMoneyShow ;

    @Transient
    private String approvalMoneyMoneyHide ;

    /**
     * 预留数量
     */
    @Column(name = "reserve_sum")
    @FieldDesc(name = "预留数量")
    private Integer reserveSum ;

    @Column(name = "reserve_money")
    private Long reserveMoney ;

    @Transient
    @FieldDesc(name = "预留金额")
    private String reserveMoneyMoneyShow ;

    @Transient
    private String reserveMoneyMoneyHide ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_product_info_stock_id")
    private StoreProductInfoStock storeProductInfoStock ;

    @Column(name = "store_product_info_stock_id", insertable = false, updatable = false)
    private Integer storeProductInfoStockId ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_position_id")
    @FieldDesc(name = "库位", mapping = "storePosition.name")
    private StorePosition storePosition ;

    @Column(name = "store_position_id", insertable = false, updatable = false)
    @FieldDesc(name = "库位", isShow = false)
    private Integer storePositionId ;

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

    public Integer getPurchaseSum() {
        return purchaseSum ;
    }

    public void setPurchaseSum(Integer purchaseSum) {
        this.purchaseSum = purchaseSum ;
    }

    public Long getPurchaseMoney() {
        return purchaseMoney ;
    }

    public void setPurchaseMoney(Long purchaseMoney) {
        this.purchaseMoney = purchaseMoney ;
    }

    public String getPurchaseMoneyMoneyShow() {
        return purchaseMoneyMoneyShow ;
    }

    public void setPurchaseMoneyMoneyShow(String purchaseMoneyMoneyShow) {
        this.purchaseMoneyMoneyShow = purchaseMoneyMoneyShow ;
    }

    public String getPurchaseMoneyMoneyHide() {
        return purchaseMoneyMoneyHide ;
    }

    public void setPurchaseMoneyMoneyHide(String purchaseMoneyMoneyHide) {
        this.purchaseMoneyMoneyHide = purchaseMoneyMoneyHide ;
    }

    public Integer getPlanOutStoreSum() {
        return planOutStoreSum ;
    }

    public void setPlanOutStoreSum(Integer planOutStoreSum) {
        this.planOutStoreSum = planOutStoreSum ;
    }

    public Long getPlanOutStoreMoney() {
        return planOutStoreMoney ;
    }

    public void setPlanOutStoreMoney(Long planOutStoreMoney) {
        this.planOutStoreMoney = planOutStoreMoney ;
    }

    public String getPlanOutStoreMoneyMoneyShow() {
        return planOutStoreMoneyMoneyShow ;
    }

    public void setPlanOutStoreMoneyMoneyShow(String planOutStoreMoneyMoneyShow) {
        this.planOutStoreMoneyMoneyShow = planOutStoreMoneyMoneyShow ;
    }

    public String getPlanOutStoreMoneyMoneyHide() {
        return planOutStoreMoneyMoneyHide ;
    }

    public void setPlanOutStoreMoneyMoneyHide(String planOutStoreMoneyMoneyHide) {
        this.planOutStoreMoneyMoneyHide = planOutStoreMoneyMoneyHide ;
    }

    public Integer getApprovalSum() {
        return approvalSum ;
    }

    public void setApprovalSum(Integer approvalSum) {
        this.approvalSum = approvalSum ;
    }

    public Long getApprovalMoney() {
        return approvalMoney ;
    }

    public void setApprovalMoney(Long approvalMoney) {
        this.approvalMoney = approvalMoney ;
    }

    public String getApprovalMoneyMoneyShow() {
        return approvalMoneyMoneyShow ;
    }

    public void setApprovalMoneyMoneyShow(String approvalMoneyMoneyShow) {
        this.approvalMoneyMoneyShow = approvalMoneyMoneyShow ;
    }

    public String getApprovalMoneyMoneyHide() {
        return approvalMoneyMoneyHide ;
    }

    public void setApprovalMoneyMoneyHide(String approvalMoneyMoneyHide) {
        this.approvalMoneyMoneyHide = approvalMoneyMoneyHide ;
    }

    public Integer getReserveSum() {
        return reserveSum ;
    }

    public void setReserveSum(Integer reserveSum) {
        this.reserveSum = reserveSum ;
    }

    public Long getReserveMoney() {
        return reserveMoney ;
    }

    public void setReserveMoney(Long reserveMoney) {
        this.reserveMoney = reserveMoney ;
    }

    public String getReserveMoneyMoneyShow() {
        return reserveMoneyMoneyShow ;
    }

    public void setReserveMoneyMoneyShow(String reserveMoneyMoneyShow) {
        this.reserveMoneyMoneyShow = reserveMoneyMoneyShow ;
    }

    public String getReserveMoneyMoneyHide() {
        return reserveMoneyMoneyHide ;
    }

    public void setReserveMoneyMoneyHide(String reserveMoneyMoneyHide) {
        this.reserveMoneyMoneyHide = reserveMoneyMoneyHide ;
    }

    public StoreProductInfoStock getStoreProductInfoStock() {
        return storeProductInfoStock ;
    }

    public void setStoreProductInfoStock(StoreProductInfoStock storeProductInfoStock) {
        this.storeProductInfoStock = storeProductInfoStock ;
    }

    public Integer getStoreProductInfoStockId() {
        return storeProductInfoStockId ;
    }

    public void setStoreProductInfoStockId(Integer storeProductInfoStockId) {
        this.storeProductInfoStockId = storeProductInfoStockId ;
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

    public Integer getPlanInStoreSum() {
        return planInStoreSum ;
    }

    public void setPlanInStoreSum(Integer planInStoreSum) {
        this.planInStoreSum = planInStoreSum ;
    }

    public Long getPlanInStoreMoney() {
        return planInStoreMoney ;
    }

    public void setPlanInStoreMoney(Long planInStoreMoney) {
        this.planInStoreMoney = planInStoreMoney ;
    }

    public String getPlanInStoreMoneyMoneyShow() {
        return planInStoreMoneyMoneyShow ;
    }

    public void setPlanInStoreMoneyMoneyShow(String planInStoreMoneyMoneyShow) {
        this.planInStoreMoneyMoneyShow = planInStoreMoneyMoneyShow ;
    }

    public String getPlanInStoreMoneyMoneyHide() {
        return planInStoreMoneyMoneyHide ;
    }

    public void setPlanInStoreMoneyMoneyHide(String planInStoreMoneyMoneyHide) {
        this.planInStoreMoneyMoneyHide = planInStoreMoneyMoneyHide ;
    }

}