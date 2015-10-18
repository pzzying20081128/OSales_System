package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.EnumType ;
import javax.persistence.Enumerated ;
import javax.persistence.MappedSuperclass ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.OSalesConfigProperties.Status ;

@MappedSuperclass
public abstract class CommBean implements java.io.Serializable {

    private static final long serialVersionUID = 15993127981203978L ;

    @Column(name = "status" ,length=5)
    @Enumerated(EnumType.STRING)
    @FieldDesc(name = "状态", isShow = true)
    private Status status ;

    public Status getStatus() {
        return status ;
    }

    public void setStatus(Status status) {
        this.status = status ;
    }

}
