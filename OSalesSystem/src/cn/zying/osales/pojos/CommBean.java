package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.EnumType ;
import javax.persistence.Enumerated ;
import javax.persistence.MappedSuperclass ;
import javax.persistence.Temporal ;

import cn.zying.osales.OSalesConfigProperties.Status ;

@MappedSuperclass
public abstract class CommBean implements java.io.Serializable {

    private static final long serialVersionUID = 15993127981203978L ;

    @Column(name = "status" ,length=5)
    @Enumerated(EnumType.STRING)
    private Status status ;

    public Status getStatus() {
        return status ;
    }

    public void setStatus(Status status) {
        this.status = status ;
    }

}
