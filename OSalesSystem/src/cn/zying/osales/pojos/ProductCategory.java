package cn.zying.osales.pojos ;

import java.util.List ;

import javax.persistence.CascadeType ;
import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.OneToMany ;
import javax.persistence.Table ;

import cn.zy.apps.tools.jpa.FieldDesc ;

/**
 * 产品信息表
 */
@Entity
@Table(name = "base_product_category")
public class ProductCategory extends CommBean {
    private static final long serialVersionUID = -2184091312240111071L ;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "parent", nullable = true)
    @FieldDesc(name = "父类类别", isShow = true, mapping = "parent.name", inputShow = false)
    private ProductCategory parent ;

    @Column(name = "parent", insertable = false, updatable = false)
    @FieldDesc(name = "父类类别", isShow = false, inputShow = true)
    private Integer parentId ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.ALL)
    @FieldDesc(name = "子类别", isShow = false, inputShow = false)
    private List<ProductCategory> childs ;

    @Column(name = "name", unique = true, length = 100)
    @FieldDesc(name = "类别", length = 100)
    private String name ;

    @Column(name = "text")
    @FieldDesc(name = "备注", length = 250)
    private String text ;

    /**
     * 0 : 不是孩子 1 ： 是孩子
     */
    @Column(name = "is_child")
    @FieldDesc(name = "是否有子类别", isShow = true, desc = "0:无;1:有")
    private Integer isChild ;

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

    public ProductCategory getParent() {
        return parent ;
    }

    public void setParent(ProductCategory parent) {
        this.parent = parent ;
    }

    public Integer getParentId() {
        return parentId ;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId ;
    }

    public List<ProductCategory> getChilds() {
        return childs ;
    }

    public void setChilds(List<ProductCategory> childs) {
        this.childs = childs ;
    }

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public Integer getIsChild() {
        return isChild ;
    }

    public void setIsChild(Integer isChild) {
        this.isChild = isChild ;
    }

}
