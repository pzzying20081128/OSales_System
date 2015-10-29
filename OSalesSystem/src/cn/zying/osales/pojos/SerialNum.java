package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.Table ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

/**
 * 自动生成编号 SerialNum
 */
@Entity
@Table(name = "sys_serial_num")
public class SerialNum implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "pre")
    private String pre ;

    @Column(name = "serial_num")
    private Integer serialNum ;

    @Column(name = "date")
    private String date ;

    public SerialNum() {
    }

    public SerialNum(String pre, Integer serialNum, String date) {
        this.pre = pre ;
        this.serialNum = serialNum ;
        this.date = date ;
    }

    public Integer getId() {
        return this.id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

    public String getPre() {
        return this.pre ;
    }

    public void setPre(String pre) {
        this.pre = pre ;
    }

    public Integer getSerialNum() {
        return this.serialNum ;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum ;
    }

    public String getDate() {
        return this.date ;
    }

    public void setDate(String date) {
        this.date = date ;
    }

}
