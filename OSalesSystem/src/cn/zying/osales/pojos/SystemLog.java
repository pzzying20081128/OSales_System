package cn.zying.osales.pojos ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

import java.util.Date ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.Table ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;

import cn.zy.apps.tools.jpa.FieldDesc ;

/**
 * SystemLog generated by hbm2java
 */
@Entity
@Table(name = "sys_system_log")
public class SystemLog implements java.io.Serializable {

    private static final long serialVersionUID = 8125723863697520445L ;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_user_id")
    @FieldDesc(name = "系统用户", mapping = "systemUser.account")
    private SysStaffUser systemUser ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_user_id", insertable = false, updatable = false)
    @FieldDesc(name = "员工", mapping = "systemUser.name")
    private SysStaffUser staffUser ;

    @Column(name = "system_user_id", insertable = false, updatable = false)
    private Integer staffUserId ;

    @Column(name = "system_user_id", insertable = false, updatable = false)
    private Integer systemUserId ;

    // 做什么
    @Column(name = "what", length = 200)
    private String what ;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date ;

    @Column(name = "module_name", length = 100)
    private String moduleName ;

    public SystemLog() {
    }

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

    public SysStaffUser getSystemUser() {
        return systemUser ;
    }

    public void setSystemUser(SysStaffUser systemUser) {
        this.systemUser = systemUser ;
    }

    public String getWhat() {
        return what ;
    }

    public void setWhat(String what) {
        this.what = what ;
    }

    public Date getDate() {
        return date ;
    }

    public void setDate(Date date) {
        this.date = date ;
    }

    public Integer getSystemUserId() {
        return systemUserId ;
    }

    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId ;
    }

    public String getModuleName() {
        return moduleName ;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName ;
    }

    public SysStaffUser getStaffUser() {
        return staffUser ;
    }

    public void setStaffUser(SysStaffUser staffUser) {
        this.staffUser = staffUser ;
    }

    public Integer getStaffUserId() {
        return staffUserId ;
    }

    public void setStaffUserId(Integer staffUserId) {
        this.staffUserId = staffUserId ;
    }

}
