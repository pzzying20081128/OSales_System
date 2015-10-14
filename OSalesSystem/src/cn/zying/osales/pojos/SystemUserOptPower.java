package cn.zying.osales.pojos;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.Id ;
import javax.persistence.Table ;

import cn.zy.apps.tools.units.powers.UserOptPower ;


@Entity
@Table(name="sys_user_opt_power")
public class SystemUserOptPower extends  UserOptPower {

    
    @Id
    @Column(name="ids")
    private Integer  ids;

    public Integer getIds() {
        return ids ;
    }

    public void setIds(Integer ids) {
        this.ids = ids ;
    }
    
    
}
