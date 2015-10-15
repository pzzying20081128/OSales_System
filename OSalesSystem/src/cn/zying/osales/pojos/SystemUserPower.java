package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.Table ;

import cn.zy.apps.tools.units.powers.UserPower ;

@Entity
@Table(name = "sys_user_power")
public class SystemUserPower extends UserPower<SystemUserOptPower> {

    private static final long serialVersionUID = -4250985705396091347L ;

    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ids ;

    @Column(name = "sys_system_user_id", insertable = false, updatable = false)
    private Integer systemUserInfoId ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sys_system_user_id")
    private SysStaffUser sysStaffUser ;

    public Integer getIds() {
        return ids ;
    }

    public void setIds(Integer ids) {
        this.ids = ids ;
    }

    public Integer getSystemUserInfoId() {
        return systemUserInfoId ;
    }

    public void setSystemUserInfoId(Integer systemUserInfoId) {
        this.systemUserInfoId = systemUserInfoId ;
    }

    public SysStaffUser getSysStaffUser() {
        return sysStaffUser ;
    }

    public void setSysStaffUser(SysStaffUser sysStaffUser) {
        this.sysStaffUser = sysStaffUser ;
    }

}
