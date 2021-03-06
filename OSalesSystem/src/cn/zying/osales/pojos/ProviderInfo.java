package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.EnumType ;
import javax.persistence.Enumerated ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.Table ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.OSalesConfigProperties.PaymentMethod ;
import cn.zying.osales.OSalesConfigProperties.ReturnType ;
import cn.zying.osales.pojos.commons.CommBean ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

/**
 * ProviderInfo generated by hbm2java 供应商
 */
@Entity
@Table(name = "base_provider_info")
public class ProviderInfo extends CommBean {

    @Column(name = "name", length = 200)
    @FieldDesc(name = "供应商")
    private String name ;

    // 助记符
    @Column(name = "short_name", length = 200)
    @FieldDesc(name = "助记符")
    private String shortName ;

    // 采购员
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_man_id", nullable = true)
    @FieldDesc(name = "采购员", mapping = "stockMan.name")
    private SysStaffUser stockMan ;

    @Column(name = "stock_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "采购员", inputShow = true, isShow = false)
    private Integer stockManId ;

    @Column(name = "settle_time")
    @FieldDesc(name = "帐期")
    private Integer settleTime ;

    @Column(name = "payment", length = 4)
    @FieldDesc(name = "付款方式")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod ;

    @Column(name = "address", length = 200)
    @FieldDesc(name = "地址")
    private String address ;

    @Column(name = "contact_man", length = 20)
    @FieldDesc(name = "联系人")
    private String contactMan ;

    @Column(name = "phone", length = 20)
    @FieldDesc(name = "联系电话")
    private String phone ;

    @Column(name = "fax", length = 20)
    @FieldDesc(name = "传真")
    private String fax ;

    @Column(name = "web", length = 200)
    @FieldDesc(name = "网址")
    private String web ;

    @Column(name = "qq", length = 20)
    @FieldDesc(name = "qq")
    private String qq ;

    @Column(name = "mail", length = 200)
    @FieldDesc(name = "电子邮箱")
    private String mail ;

    @Column(name = "return_type", length = 5)
    @FieldDesc(name = "退货类型")
    @Enumerated(EnumType.STRING)
    private ReturnType returnType ;

    @Column(name = "bank1", length = 100)
    @FieldDesc(name = "银行帐号")
    private String bank1 ;

    @Column(name = "bank2", length = 100)
    @FieldDesc(name = "银行帐号")
    private String bank2 ;

    @Column(name = "text", length = 255)
    @FieldDesc(name = "备注")
    private String text ;

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
    }

    public String getShortName() {
        return shortName ;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName ;
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

    public Integer getSettleTime() {
        return settleTime ;
    }

    public void setSettleTime(Integer settleTime) {
        this.settleTime = settleTime ;
    }

    public String getAddress() {
        return address ;
    }

    public void setAddress(String address) {
        this.address = address ;
    }

    public String getContactMan() {
        return contactMan ;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan ;
    }

    public String getPhone() {
        return phone ;
    }

    public void setPhone(String phone) {
        this.phone = phone ;
    }

    public String getFax() {
        return fax ;
    }

    public void setFax(String fax) {
        this.fax = fax ;
    }

    public String getWeb() {
        return web ;
    }

    public void setWeb(String web) {
        this.web = web ;
    }

    public String getQq() {
        return qq ;
    }

    public void setQq(String qq) {
        this.qq = qq ;
    }

    public String getMail() {
        return mail ;
    }

    public void setMail(String mail) {
        this.mail = mail ;
    }

    public String getBank1() {
        return bank1 ;
    }

    public void setBank1(String bank1) {
        this.bank1 = bank1 ;
    }

    public String getBank2() {
        return bank2 ;
    }

    public void setBank2(String bank2) {
        this.bank2 = bank2 ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod ;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod ;
    }

    public ReturnType getReturnType() {
        return returnType ;
    }

    public void setReturnType(ReturnType returnType) {
        this.returnType = returnType ;
    }

}
