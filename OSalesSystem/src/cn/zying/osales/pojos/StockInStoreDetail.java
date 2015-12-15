package cn.zying.osales.pojos ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.Table ;

import cn.zying.osales.pojos.commons.StockDetailCommBean ;

/**
 * StockStoreDetailInfo generated by hbm2java 采购进货入库明细
 */

@Entity
@Table(name = "stock_in_store_detail")
public class StockInStoreDetail extends StockDetailCommBean {

    // 采购进货入库
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_in_store_id")
    private StockInStore stockInStore ;

    @Column(name = "stock_in_store_id", insertable = false, updatable = false)
    private Integer stockInStoreId ;

    // 采购订单明细
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_order_detail_Id")
    private StockOrderDetail stockOrderDetail ;

    @Column(name = "stock_order_detail_Id", insertable = false, updatable = false)
    private Integer stockOrderDetailId ;

    // 要接受单总数
    @Column(name = "order_sum")
    private Integer orderSum ;

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

    public Integer getOrderSum() {
        return orderSum ;
    }

    public void setOrderSum(Integer orderSum) {
        this.orderSum = orderSum ;
    }

    //    // 订购订单的数量 主要用于比较在采购进货入库中修改的 数量不能大于 该数量
    //    // //此数量需要在采购订单审核的时候保存到采购进货入库 不能修改
    //    @Column(name = "count_hide")
    //    private Integer countHide ;

}
