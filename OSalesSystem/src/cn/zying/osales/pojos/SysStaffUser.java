package cn.zying.osales.pojos ;

import java.util.List ;


import javax.persistence.CascadeType ;
import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.OneToMany ;
import javax.persistence.Table ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;

/**
 * SystemUser generated by hbm2java
 */
@Entity
@Table(name = "sys_system_staff")
public class SysStaffUser extends CommBean {

    private static final long serialVersionUID = 8238708907376609336L ;

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @FieldDesc(name = "ID", isShow = false)
    private Integer id ;

    @Column(name = "pwd", length = 10)
    @FieldDesc(name = "密码", isShow = false)
    private String pwd ;

    @Column(name = "name", length = 10)
    @FieldDesc(name = "姓名")
    private String name ;
    
    @Column(name = "account", length = 10)
    @FieldDesc(name = "系统用户")
    private String account ;

    @Column(name = "sex", length = 1)
    @FieldDesc(name = "性别", desc = "0:女;1:男")
    private Integer sex ;

    @Column(name = "phone", length = 20)
    @FieldDesc(name = "手机")
    private String phone ;

    @Column(name = "cell", length = 20)
    @FieldDesc(name = "联系电话")
    private String cell ;

    @Column(name = "address", length = 200)
    @FieldDesc(name = "地址")
    private String address ;

    @Column(name = "is_admin",length = 1)
    @FieldDesc(name = "是否管理员", desc = "0:否;1:是")
    private Integer isAdmin ;

    // 业务员
    @Column(name = "is_biz_man" , length = 1)
    @FieldDesc(name = "是否业务员", desc = "0:否;1:是")
    private Integer isBizMan ;

    // 是否理货员
    @Column(name = "is_goods_man", length = 1)
    @FieldDesc(name = "是否理货员", desc = "0:否;1:是")
    private Integer isGoodsMan ;

    // 是否采购员
    @Column(name = "is_stock_man", length = 1)
    @FieldDesc(name = "是否采购员", desc = "0:否;1:是")
    private Integer isStockMan ;

    // 是否运输人
    @Column(name = "is_transport_man", length = 1)
    @FieldDesc(name = " 是否运输人", desc = "0:否;1:是")
    private Integer isTransportMan ;

    @Column(name = "text",length = 250)
    @FieldDesc(name = "备注")
    private String text ;
    
    /////////////////////////////////////////////////////
    
    @Transient
    private String accessPassword;
    
    @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="sysStaffUser")
    private List<SystemUserPower> systemUserPowers;
    
    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

    public String getAccount() {
        return account ;
    }

    public void setAccount(String account) {
        this.account = account ;
    }

    public String getPwd() {
        return pwd ;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd ;
    }

    public Integer getIsAdmin() {
        return isAdmin ;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin ;
    }

    public Integer getIsBizMan() {
        return isBizMan ;
    }

    public void setIsBizMan(Integer isBizMan) {
        this.isBizMan = isBizMan ;
    }

    public Integer getIsGoodsMan() {
        return isGoodsMan ;
    }

    public void setIsGoodsMan(Integer isGoodsMan) {
        this.isGoodsMan = isGoodsMan ;
    }

    public Integer getIsStockMan() {
        return isStockMan ;
    }

    public void setIsStockMan(Integer isStockMan) {
        this.isStockMan = isStockMan ;
    }

    public Integer getIsTransportMan() {
        return isTransportMan ;
    }

    public void setIsTransportMan(Integer isTransportMan) {
        this.isTransportMan = isTransportMan ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
    }

    public Integer getSex() {
        return sex ;
    }

    public void setSex(Integer sex) {
        this.sex = sex ;
    }

    public String getPhone() {
        return phone ;
    }

    public void setPhone(String phone) {
        this.phone = phone ;
    }

    public String getCell() {
        return cell ;
    }

    public void setCell(String cell) {
        this.cell = cell ;
    }

    public String getAddress() {
        return address ;
    }

    public void setAddress(String address) {
        this.address = address ;
    }

    public String getAccessPassword() {
        return accessPassword ;
    }

    public void setAccessPassword(String accessPassword) {
        this.accessPassword = accessPassword ;
    }

    public List<SystemUserPower> getSystemUserPowers() {
        return systemUserPowers ;
    }

    public void setSystemUserPowers(List<SystemUserPower> systemUserPowers) {
        this.systemUserPowers = systemUserPowers ;
    }

}
