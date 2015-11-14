package cn.zying.osales.pojos ;

import java.util.Date ;
import java.util.List ;

import javax.persistence.CascadeType ;
import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.OneToMany ;
import javax.persistence.OneToOne ;
import javax.persistence.Table ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.pojos.commons.BaseProductInfo ;

@Entity
@Table(name = "base_combined_product")
public class CombinedProduct extends BaseProductInfo {

    private static final long serialVersionUID = 719508775977630493L ;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_info_id")
    private ProductInfo productInfo ;

    @Column(name = "product_info_id", insertable = false, updatable = false)
    private Integer productInfoId ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "check_man_id")
    @FieldDesc(name = "审核员", mapping = "checkMan.name")
    private SysStaffUser checkMan ;

    @Column(name = "check_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "审核员")
    private Integer checkManId ;

    @Column(name = "check_date")
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "审核日期")
    private Date checkDate ;

    // /录入人
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_man_id")
    @FieldDesc(name = "录入人", mapping = "recordMan.name")
    private SysStaffUser recordMan ;

    @Column(name = "record_man_id", insertable = false, updatable = false)
    @FieldDesc(name = "录入人")
    private Integer recordManId ;

    @Column(name = "record_date")
    @Temporal(TemporalType.DATE)
    @FieldDesc(name = "录入日期")
    private Date recordDate ;

    //    combinedProduct
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "combinedProduct")
    private List<CombinedProductDetails> combinedProductDetailses ;

    public ProductInfo getProductInfo() {
        return productInfo ;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo ;
    }

    public Integer getProductInfoId() {
        return productInfoId ;
    }

    public void setProductInfoId(Integer productInfoId) {
        this.productInfoId = productInfoId ;
    }

    public SysStaffUser getCheckMan() {
        return checkMan ;
    }

    public void setCheckMan(SysStaffUser checkMan) {
        this.checkMan = checkMan ;
    }

    public Integer getCheckManId() {
        return checkManId ;
    }

    public void setCheckManId(Integer checkManId) {
        this.checkManId = checkManId ;
    }

    public Date getCheckDate() {
        return checkDate ;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate ;
    }

    public SysStaffUser getRecordMan() {
        return recordMan ;
    }

    public void setRecordMan(SysStaffUser recordMan) {
        this.recordMan = recordMan ;
    }

    public Integer getRecordManId() {
        return recordManId ;
    }

    public void setRecordManId(Integer recordManId) {
        this.recordManId = recordManId ;
    }

    public Date getRecordDate() {
        return recordDate ;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate ;
    }

    public List<CombinedProductDetails> getCombinedProductDetailses() {
        return combinedProductDetailses ;
    }

    public void setCombinedProductDetailses(List<CombinedProductDetails> combinedProductDetailses) {
        this.combinedProductDetailses = combinedProductDetailses ;
    }

}
