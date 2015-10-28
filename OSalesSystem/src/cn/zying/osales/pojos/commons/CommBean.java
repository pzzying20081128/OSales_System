package cn.zying.osales.pojos.commons ;

import javax.persistence.Column ;
import javax.persistence.EnumType ;
import javax.persistence.Enumerated ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.MappedSuperclass ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.OSalesConfigProperties.Status ;

@MappedSuperclass
public abstract class CommBean implements java.io.Serializable {

    private static final long serialVersionUID = 15993127981203978L ;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "status", length = 5)
    @Enumerated(EnumType.STRING)
    @FieldDesc(name = "状态", isShow = true)
    private Status status ;

    public Status getStatus() {
        return status ;
    }

    public void setStatus(Status status) {
        this.status = status ;
    }

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

}
