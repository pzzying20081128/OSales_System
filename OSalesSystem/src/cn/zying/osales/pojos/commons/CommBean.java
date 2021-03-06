package cn.zying.osales.pojos.commons ;

import java.util.Date ;
import java.util.List ;

import javax.persistence.Column ;
import javax.persistence.EnumType ;
import javax.persistence.Enumerated ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.MappedSuperclass ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.Status ;

@MappedSuperclass
public abstract class CommBean extends ImportBean implements java.io.Serializable {

    private static final long serialVersionUID = 15993127981203978L ;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "status", length = 5)
    @Enumerated(EnumType.STRING)
    @FieldDesc(name = "状态", isShow = true)
    private Status status ;

    @Column(name = "create_time", length = 5)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = DateToolsUilts.getnowDate() ;

    @Transient
    //查询
    private List<Status> statuses ;

    @Transient
    private Date startTime ;

    @Transient
    private Date endTime ;

    @Transient
    private String _dc ;

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

    public List<Status> getStatuses() {
        return statuses ;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses ;
    }

    public String get_dc() {
        return _dc ;
    }

    public void set_dc(String _dc) {
        this._dc = _dc ;
    }

    public Date getCreateTime() {
        return createTime ;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime ;
    }

    public Date getStartTime() {
        return startTime ;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime ;
    }

    public Date getEndTime() {
        return endTime ;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime ;
    }

}
