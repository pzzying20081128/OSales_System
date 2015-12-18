package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.Table ;

import cn.zying.osales.pojos.commons.StockDetailCommBean ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1
/*
 * 采购退货出库明细
 */
@Entity
@Table(name = "stock_return_store_out_detail")
public class StockReturnStoreOutDetail extends StockDetailCommBean {

    private static final long serialVersionUID = -7823574205120502318L ;

    // 采购退货出库单
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_return_store_out_id")
    private StockReturnStoreOut stockReturnStoreOut ;

    @Column(name = "stock_return_store_out_id", insertable = false, updatable = false)
    private Integer stockReturnStoreOutId ;

    // 采购退货单明细
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_Return_detail_id")
    private StockReturnDetail stockReturnDetail ;

    @Column(name = "stock_Return_detail_id", insertable = false, updatable = false)
    private Integer stockReturnDetailId ;

    public StockReturnStoreOut getStockReturnStoreOut() {
        return stockReturnStoreOut ;
    }

    public void setStockReturnStoreOut(StockReturnStoreOut stockReturnStoreOut) {
        this.stockReturnStoreOut = stockReturnStoreOut ;
    }

    public Integer getStockReturnStoreOutId() {
        return stockReturnStoreOutId ;
    }

    public void setStockReturnStoreOutId(Integer stockReturnStoreOutId) {
        this.stockReturnStoreOutId = stockReturnStoreOutId ;
    }

    public StockReturnDetail getStockReturnDetail() {
        return stockReturnDetail ;
    }

    public void setStockReturnDetail(StockReturnDetail stockReturnDetail) {
        this.stockReturnDetail = stockReturnDetail ;
    }

    public Integer getStockReturnDetailId() {
        return stockReturnDetailId ;
    }

    public void setStockReturnDetailId(Integer stockReturnDetailId) {
        this.stockReturnDetailId = stockReturnDetailId ;
    }

}
