package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.Table ;

import cn.zy.apps.tools.jpa.FieldDesc ;

@Entity
@Table(name = "base_product_brand")
public class ProductBrand extends CommBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "name",length=20 )
    @FieldDesc(name = "品牌")
    private String name ;

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
    }
    
}
