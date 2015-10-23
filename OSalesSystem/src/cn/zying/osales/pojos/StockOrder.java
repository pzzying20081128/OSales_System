package cn.zying.osales.pojos ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

import java.util.Date ;
import java.util.List ;

import javax.persistence.CascadeType ;
import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.EnumType ;
import javax.persistence.Enumerated ;
import javax.persistence.FetchType ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.OneToMany ;
import javax.persistence.Table ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;
import javax.persistence.Transient ;

import org.hibernate.annotations.Index ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.OSalesConfigProperties.StockType ;

@Entity
@Table(name = "stock_order")
// 采购订单
public class StockOrder extends CommBean implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    // 采购订单编号
    @Column(name = "order_number")
    @Index(name = "num_index")
    @FieldDesc(name = "订单编号")
    private String orderNumber ;

    // 供应商
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_info_id")
    @FieldDesc(name = "供应商", mapping = "providerInfo.name")
    private ProviderInfo providerInfo ;

    @Column(name = "provider_info_id", insertable = false, updatable = false)
    @FieldDesc(name = "供应商")
    private Integer providerInfoId ;

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

    @Column(name = "tax_sum_money")
    @FieldDesc(name = "含税总金额", isShow = false)
    private Long taxSumMoney ;

    @Transient
    @FieldDesc(name = "含税总金额", isShow = true)
    private String taxSumMoneyMoneyShow ;

    @Transient
    @FieldDesc(name = "含税总金额", isShow = false)
    private String taxSumMoneyMoneyHide ;

    @Column(name = "no_tax_sum_money")
    @FieldDesc(name = "没税总金额", isShow = false)
    private String noTaxSumMoney ;

    @Transient
    @FieldDesc(name = "没税总金额", isShow = true)
    private Long noTaxSumMoneyMoneyShow ;

    @Transient
    @FieldDesc(name = "没税总金额", isShow = false)
    private String noTaxSumMoneyMoneyHide ;

    @Column(name = "order_count")
    @FieldDesc(name = "订购数量")
    private Integer orderCount ;

    // 备注
    @Column(name = "text")
    @FieldDesc(name = " 备注")
    private String text ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "check_man_id")
    @FieldDesc(name = "审核员", mapping = "checkMan.name")
    private SysStaffUser checkMan ;

    @Column(name = "check_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "审核员")
    private Integer checkManId ;

    @Column(name = "check_date")
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "审核日期")
    private Date checkDate ;

    // 采购订单类型
    @Column(name = "stock_type")
    @Enumerated(EnumType.STRING)
    @FieldDesc(name = "订单类型")
    private StockType stockType ;

    // /录入人
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_man_id")
    @FieldDesc(name = "录入人", mapping = "recordMan.name")
    private SysStaffUser recordMan ;

    @Column(name = "record_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "录入人")
    private Integer recordManId ;
    
    @Column(name = "record_date")
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "录入日期")
    private Date recordDate ;

    @Column(name = "print_count")
    private Integer printCount = 0 ;

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
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

    public Long getTaxSumMoney() {
        return taxSumMoney ;
    }

    public void setTaxSumMoney(Long taxSumMoney) {
        this.taxSumMoney = taxSumMoney ;
    }

    public String getTaxSumMoneyMoneyShow() {
        return taxSumMoneyMoneyShow ;
    }

    public void setTaxSumMoneyMoneyShow(String taxSumMoneyMoneyShow) {
        this.taxSumMoneyMoneyShow = taxSumMoneyMoneyShow ;
    }

    public String getTaxSumMoneyMoneyHide() {
        return taxSumMoneyMoneyHide ;
    }

    public void setTaxSumMoneyMoneyHide(String taxSumMoneyMoneyHide) {
        this.taxSumMoneyMoneyHide = taxSumMoneyMoneyHide ;
    }

    public String getNoTaxSumMoney() {
        return noTaxSumMoney ;
    }

    public void setNoTaxSumMoney(String noTaxSumMoney) {
        this.noTaxSumMoney = noTaxSumMoney ;
    }

    public Long getNoTaxSumMoneyMoneyShow() {
        return noTaxSumMoneyMoneyShow ;
    }

    public void setNoTaxSumMoneyMoneyShow(Long noTaxSumMoneyMoneyShow) {
        this.noTaxSumMoneyMoneyShow = noTaxSumMoneyMoneyShow ;
    }

    public String getNoTaxSumMoneyMoneyHide() {
        return noTaxSumMoneyMoneyHide ;
    }

    public void setNoTaxSumMoneyMoneyHide(String noTaxSumMoneyMoneyHide) {
        this.noTaxSumMoneyMoneyHide = noTaxSumMoneyMoneyHide ;
    }

    public Integer getOrderCount() {
        return orderCount ;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public SysStaffUser getCheckMan() {
        return checkMan ;
    }

    public void setCheckMan(SysStaffUser checkMan) {
        this.checkMan = checkMan ;
    }

    public Integer getCheckManId() {
        return checkManId ;
    }

    public void setCheckManId(Integer checkManId) {
        this.checkManId = checkManId ;
    }

    public Date getCheckDate() {
        return checkDate ;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate ;
    }

    public StockType getStockType() {
        return stockType ;
    }

    public void setStockType(StockType stockType) {
        this.stockType = stockType ;
    }

    public SysStaffUser getRecordMan() {
        return recordMan ;
    }

    public void setRecordMan(SysStaffUser recordMan) {
        this.recordMan = recordMan ;
    }

    public Integer getRecordManId() {
        return recordManId ;
    }

    public void setRecordManId(Integer recordManId) {
        this.recordManId = recordManId ;
    }

    public Integer getPrintCount() {
        return printCount ;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount ;
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

    public Date getRecordDate() {
        return recordDate ;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate ;
    }

}
