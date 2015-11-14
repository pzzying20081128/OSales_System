package cn.zying.osales.pojos.commons ;

import java.util.Date ;

import javax.persistence.Column ;
import javax.persistence.FetchType ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.MappedSuperclass ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;
import javax.persistence.Transient ;

import cn.zy.apps.tools.jpa.FieldDesc ;
import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.pojos.SysStaffUser ;

@MappedSuperclass
public class CommOrderBean extends CommBean {

    @Column(name = "remarks", length = 255)
    @FieldDesc(name = "说明", isShow = true)
    private String remarks ;

    // 备注
    @Column(name = "text")
    @FieldDesc(name = " 备注")
    private String text ;

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

    @Column(name = "print_count")
    private Integer printCount = 0 ;

    // 采购进货入库编号
    @Column(name = "number")
    @FieldDesc(name = "单号")
    private String number ;

    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime = DateToolsUilts.getnowDate() ;
    
    
    @Transient
    private Date startTime;
    @Transient
    private Date endTime;
    public String getRemarks() {
        return remarks ;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks ;
    }

    public String getText() {
        return text ;
    }

    public void setText(String text) {
        this.text = text ;
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

    public Integer getPrintCount() {
        return printCount ;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount ;
    }

    public String getNumber() {
        return number ;
    }

    public void setNumber(String number) {
        this.number = number ;
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
