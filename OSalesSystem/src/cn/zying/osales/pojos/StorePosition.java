package cn.zying.osales.pojos;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.Table ;

import cn.zy.apps.tools.jpa.FieldDesc ;



@Entity
@Table(name = "base_store_position")
public class StorePosition extends CommBean {

    private static final long serialVersionUID = -4433696835387380184L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_info_id")
    @FieldDesc(name = "仓库",isShow=false,mapping="storeInfo.name")
    private StoreInfo storeInfo;

    @Column(name = "store_info_id", insertable = false, updatable = false)
    @FieldDesc(name = "仓库",isShow=false,mapping="storeInfo.name")
    private Integer storeInfoId;

    @Column(name = "name")
    @FieldDesc(name = "库位")
    private String name;

    @Column(name = "text")
    private String text;

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

    public StoreInfo getStoreInfo() {
        return storeInfo ;
    }

    public void setStoreInfo(StoreInfo storeInfo) {
        this.storeInfo = storeInfo ;
    }

    public Integer getStoreInfoId() {
        return storeInfoId ;
    }

    public void setStoreInfoId(Integer storeInfoId) {
        this.storeInfoId = storeInfoId ;
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

   
}
