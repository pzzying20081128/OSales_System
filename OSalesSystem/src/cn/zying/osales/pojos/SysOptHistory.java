package cn.zying.osales.pojos ;

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

import org.apache.struts2.json.annotations.JSON ;

import cn.zy.apps.tools.jpa.FieldDesc ;

@Entity
@Table(name = "sys_opt_history")
public class SysOptHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @FieldDesc(name = "ID", isShow = false)
    private Integer id ;

    @Column(name = "classification", length = 10)
    @FieldDesc(name = "类别")
    private String classification ;

    @Column(name = "module", length = 10)
    @FieldDesc(name = "模块")
    private String module ;

    @Column(name = "opt_time")
    @FieldDesc(name = "操作时间")
    private Date optTime ;

    @Column(name = "text")
    @FieldDesc(name = "操作内容")
    private String text ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sys_staff_user_id")
    @FieldDesc(name = "操作人员", mapping = "sysStaffUser.name")
    private SysStaffUser sysStaffUser ;

    @Column(name = "sys_staff_user_id" ,insertable=false,updatable=false)
    @FieldDesc(name = "模块", isShow = false)
    private Integer sysStaffUserId ;

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

    public String getClassification() {
        return classification ;
    }

    public void setClassification(String classification) {
        this.classification = classification ;
    }

    public String getModule() {
        return module ;
    }

    public void setModule(String module) {
        this.module = module ;
    }

    @JSON(format = "yyyy_MM_dd HH:mm:ss")
    public Date getOptTime() {
        return optTime ;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public SysStaffUser getSysStaffUser() {
        return sysStaffUser ;
    }

    public void setSysStaffUser(SysStaffUser sysStaffUser) {
        this.sysStaffUser = sysStaffUser ;
    }

    public Integer getSysStaffUserId() {
        return sysStaffUserId ;
    }

    public void setSysStaffUserId(Integer sysStaffUserId) {
        this.sysStaffUserId = sysStaffUserId ;
    }

}
