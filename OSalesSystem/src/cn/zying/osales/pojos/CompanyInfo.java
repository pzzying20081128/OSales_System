package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.Table ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.pojos.commons.CommBean ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

/**
 * 单位
 * 
 */
@Entity
@Table(name = "base_company_info")
public class CompanyInfo extends CommBean {

    private static final long serialVersionUID = 6856926347044776180L ;

    @Column(name = "short_name")
    @FieldDesc(name = "简称")
    private String shortName ;

    @Column(name = "name")
    @FieldDesc(name = "单位名字")
    private String name ;

    @Column(name = "address")
    @FieldDesc(name = "单位地址")
    private String address ;

    @Column(name = "contact_man")
    private String contactMan ;

    @Column(name = "phone")
    @FieldDesc(name = "联系电话")
    private String phone ;

    @Column(name = "order_phone")
    @FieldDesc(name = "订货电话")
    private String orderPhone ;

    @Column(name = "fax")
    @FieldDesc(name = "传真")
    private String fax ;

    @Column(name = "web")
    @FieldDesc(name = "网页")
    private String web ;

    @Column(name = "mail")
    @FieldDesc(name = "电子邮箱")
    private String mail ;

    @Column(name = "is_default")
    @FieldDesc(name = "默认", desc = "0:否;1:是")
    private Integer isDefault ;

    @Column(name = "bank")
    @FieldDesc(name = "银行")
    private String bank ;

    @Column(name = "bank_num")
    @FieldDesc(name = "银行帐号")
    private String bankNum ;

    public String getShortName() {
        return shortName ;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName ;
    }

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
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

    public String getOrderPhone() {
        return orderPhone ;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone ;
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

    public String getMail() {
        return mail ;
    }

    public void setMail(String mail) {
        this.mail = mail ;
    }

    public String getBank() {
        return bank ;
    }

    public void setBank(String bank) {
        this.bank = bank ;
    }

    public String getBankNum() {
        return bankNum ;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum ;
    }

    public Integer getIsDefault() {
        return isDefault ;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault ;
    }

}
