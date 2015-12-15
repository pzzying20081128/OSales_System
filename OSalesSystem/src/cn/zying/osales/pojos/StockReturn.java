package cn.zying.osales.pojos ;

import java.util.Date ;
import java.util.List ;

import javax.persistence.CascadeType ;
import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.EnumType ;
import javax.persistence.Enumerated ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.OneToMany ;
import javax.persistence.Table ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.OSalesConfigProperties.ProductInfoType ;
import cn.zying.osales.OSalesConfigProperties.ReturnType ;
import cn.zying.osales.pojos.commons.StockCommBean ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

/**
 * StockReturn generated by hbm2java
 */
// 采购退货
@Entity
@Table(name = "stock_return")
public class StockReturn extends StockCommBean implements java.io.Serializable {

    // 采购员
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_man_id")
    @FieldDesc(name = "采购员", mapping = "stockMan.name")
    private SysStaffUser stockMan ;

    @Column(name = "stock_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "采购员")
    private Integer stockManId ;

    @Column(name = "return_type")
    @FieldDesc(name = "退货类型")
    @Enumerated(EnumType.STRING)
    private ReturnType returnType ;

    @Transient
    private List<ReturnType> returnTypes ;

    @Column(name = "stock_product_type")
    @Enumerated(EnumType.STRING)
    @FieldDesc(name = "产品类型", desc = { "普通产品:普通产品", "组合产品:组合产品" })
    private ProductInfoType stockProductType ;

    @Transient
    private List<ProductInfoType> stockProductTypes ;

    @Column(name = "return_date")
    // 订单日期
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "退货日期")
    private Date returnDate ;

    // 合同
    // 合同

    //	@ManyToOne(fetch = FetchType.LAZY)
    //	@JoinColumn(name = "contract_id")
    //	private StockContract stockContract;
    //	@Column(name = "contract_id", insertable = false, updatable = false)
    //	private Integer stockContractId;

    //	// /直营退货单
    //	@ManyToOne(fetch = FetchType.LAZY)
    //	@JoinColumn(name = "direct_stock_return_id")
    //	private DirectStockReturn directStockReturn;
    //	@Column(name = "direct_stock_return_id", insertable = false, updatable = false)
    //	private Integer directStockReturnId;

    // 采购退货明细list
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "stockReturn")
    private List<StockReturnDetail> stockReturnDetails ;

    public SysStaffUser getStockMan() {
        return stockMan ;
    }

    public void setStockMan(SysStaffUser stockMan) {
        this.stockMan = stockMan ;
    }

    public Integer getStockManId() {
        return stockManId ;
    }

    public void setStockManId(Integer stockManId) {
        this.stockManId = stockManId ;
    }

    public ReturnType getReturnType() {
        return returnType ;
    }

    public void setReturnType(ReturnType returnType) {
        this.returnType = returnType ;
    }

    public List<StockReturnDetail> getStockReturnDetails() {
        return stockReturnDetails ;
    }

    public void setStockReturnDetails(List<StockReturnDetail> stockReturnDetails) {
        this.stockReturnDetails = stockReturnDetails ;
    }

    public ProductInfoType getStockProductType() {
        return stockProductType ;
    }

    public void setStockProductType(ProductInfoType stockProductType) {
        this.stockProductType = stockProductType ;
    }

    public Date getReturnDate() {
        return returnDate ;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate ;
    }

    public List<ProductInfoType> getStockProductTypes() {
        return stockProductTypes ;
    }

    public void setStockProductTypes(List<ProductInfoType> stockProductTypes) {
        this.stockProductTypes = stockProductTypes ;
    }

    public List<ReturnType> getReturnTypes() {
        return returnTypes ;
    }

    public void setReturnTypes(List<ReturnType> returnTypes) {
        this.returnTypes = returnTypes ;
    }

}
