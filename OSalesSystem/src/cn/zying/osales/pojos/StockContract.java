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

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.OSalesConfigProperties.ContractStatus ;
import cn.zying.osales.pojos.commons.CommBean ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

/**
 * 采购合同
 */
@Entity
@Table(name = "stock_contract")
public class StockContract extends CommBean {

    private static final long serialVersionUID = 2454559811376575533L ;

    /**
     * 采购合同编号
     **/
    @Column(name = "contract_num")
    private String num ;

    /**
     * // 供应商
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_info_id")
    @FieldDesc(name = "供应商", mapping = "providerInfo.name")
    private ProviderInfo providerInfo ;

    @Column(name = "provider_info_id", insertable = false, updatable = false)
    @FieldDesc(name = "供应商", isShow = false)
    private Integer providerInfoId ;

    /**
     * // 采购合同明细list
     **/
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "stockContract")
    private List<StockContractDetail> stockContractDetails ;

    // 采购员 **/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_man_id")
    @FieldDesc(name = "采购员", mapping = "stockMan.name")
    private SysStaffUser stockMan ;

    @Column(name = "stock_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "采购员", isShow = false)
    private Integer stockManId ;

    /**
     * // 公司名称
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_info_id")
    @FieldDesc(name = "公司名称", mapping = "companyGuest.name")
    private CompanyInfo companyInfo ;

    @Column(name = "company_info_id", insertable = false, updatable = false)
    @FieldDesc(name = "公司名称", isShow = false)
    private Integer companyInfoId ;

    /**
     * // 合同类型
     **/
    @Column(name = "contract_status")
    @FieldDesc(name = "合同类型", desc = { "未启用合同:未启用合同", "执行合同:执行合同", "历史合同:历史合同", "待定:待定" })
    @Enumerated(EnumType.STRING)
    private ContractStatus contractStatus ;

    @Column(name = "text")
    @FieldDesc(name = "备注")
    private String text ;

    /**
     * // 签订日期
     **/
    @Column(name = "signed_date")
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "签订日期")
    private Date signedDate ;

    public String getNum() {
        return num ;
    }

    public void setNum(String num) {
        this.num = num ;
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

    public List<StockContractDetail> getStockContractDetails() {
        return stockContractDetails ;
    }

    public void setStockContractDetails(List<StockContractDetail> stockContractDetails) {
        this.stockContractDetails = stockContractDetails ;
    }

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

    public ContractStatus getContractStatus() {
        return contractStatus ;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public Date getSignedDate() {
        return signedDate ;
    }

    public void setSignedDate(Date signedDate) {
        this.signedDate = signedDate ;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo ;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo ;
    }

    public Integer getCompanyInfoId() {
        return companyInfoId ;
    }

    public void setCompanyInfoId(Integer companyInfoId) {
        this.companyInfoId = companyInfoId ;
    }

}
