package cn.zying.osales.pojos.commons ;

import javax.persistence.Column ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.MappedSuperclass ;

@MappedSuperclass
public class DetailCommBean implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

}
