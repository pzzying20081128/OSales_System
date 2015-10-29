package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.Table ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.pojos.commons.CommBean ;

@Entity
@Table(name = "base_product_brand")
public class ProductBrand extends CommBean {

    @Column(name = "name", length = 20)
    @FieldDesc(name = "品牌")
    private String name ;

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
    }

}
