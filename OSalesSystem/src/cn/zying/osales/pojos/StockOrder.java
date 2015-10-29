package cn.zying.osales.pojos ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

import java.util.Date ;
import java.util.List ;

import javax.persistence.CascadeType ;
import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.OneToMany ;
import javax.persistence.Table ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;

import org.hibernate.annotations.Index ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.pojos.commons.StockCommBean ;

@Entity
@Table(name = "stock_order")
// 采购订单
public class StockOrder extends StockCommBean implements java.io.Serializable {

    // 采购订单编号
    @Column(name = "order_number")
    @Index(name = "num_index")
    @FieldDesc(name = "订单编号")
    private String orderNumber ;

    // 采购员
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_man_id")
    @FieldDesc(name = "采购员", mapping = "stockMan.name")
    private SysStaffUser stockMan ;

    @Column(name = "stock_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "采购员")
    private Integer stockManId ;

    //	// 合同
    //	@ManyToOne(fetch = FetchType.LAZY)
    //	@JoinColumn(name = "contract_id")
    //	private StockContract stockContract;
    //	@Column(name = "contract_id", insertable = false, updatable = false)
    //	private Integer stockContractId;
    //
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "stockOrder")
    private List<StockOrderDetail> stockOrderDetails ;

    @Column(name = "order_date")
    // 订单日期
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "订单日期")
    private Date orderDate ;

    @Column(name = "stock_date")
    // 采购日期
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "采购日期")
    private Date stockDate ;

    public SysStaffUser getStockMan() {
        return stockMan ;
    }

    public void setStockMan(SysStaffUser stockMan) {
        this.stockMan = stockMan ;
    }

    public Date getOrderDate() {
        return orderDate ;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate ;
    }

    public Date getStockDate() {
        return stockDate ;
    }

    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate ;
    }

    public List<StockOrderDetail> getStockOrderDetails() {
        return stockOrderDetails ;
    }

    public void setStockOrderDetails(List<StockOrderDetail> stockOrderDetails) {
        this.stockOrderDetails = stockOrderDetails ;
    }

    public Integer getStockManId() {
        return stockManId ;
    }

    public void setStockManId(Integer stockManId) {
        this.stockManId = stockManId ;
    }

    public String getOrderNumber() {
        return orderNumber ;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber ;
    }

}
