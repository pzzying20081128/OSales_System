package cn.zying.osales.pojos ;

import java.util.List ;

import javax.persistence.CascadeType ;
import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.OneToMany ;
import javax.persistence.Table ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zying.osales.OSalesConfigProperties.StoreType ;
import cn.zying.osales.pojos.commons.CommBean ;

@Entity
@Table(name = "base_store_info")
public class StoreInfo extends CommBean {

    @Column(name = "name", length = 20)
    @FieldDesc(name = "仓库名称")
    private String name ;

    @Column(name = "type", length = 6)
    @FieldDesc(name = "仓库类型", desc = "一般仓库;专柜;样品")
    private StoreType storeType ;

    @Column(name = "address", length = 255)
    @FieldDesc(name = "仓库地址")
    private String address ;

    @Column(name = "phone", length = 20)
    @FieldDesc(name = "联系电话")
    private String phone ;

    @Column(name = "text", length = 255)
    @FieldDesc(name = "备注")
    private String text ;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "storeInfo")
    private List<StorePosition> storePositions ;

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
    }

    public StoreType getStoreType() {
        return storeType ;
    }

    public void setStoreType(StoreType storeType) {
        this.storeType = storeType ;
    }

    public String getAddress() {
        return address ;
    }

    public void setAddress(String address) {
        this.address = address ;
    }

    public String getPhone() {
        return phone ;
    }

    public void setPhone(String phone) {
        this.phone = phone ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
    }

    public List<StorePosition> getStorePositions() {
        return storePositions ;
    }

    public void setStorePositions(List<StorePosition> storePositions) {
        this.storePositions = storePositions ;
    }

}
