package cn.zying.osales.pojos ;

import java.util.List ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.Table ;
import javax.persistence.Transient ;

// Generated 2013-6-20 10:53:13 by Hibernate Tools 3.4.0.CR1

/**
 * SystemConfig generated by hbm2java
 */
@Entity
@Table(name = "system_config")
public class SystemConfig implements java.io.Serializable {

    private static final long serialVersionUID = 482203725884869873L ;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "title")
    private String title ;

    @Column(name = "key", unique = true)
    private String configKey ;

    @Column(name = "value")
    private String configValue ;

    // 用来保存选择的属性
    @Column(name = "config_desc")
    private String configDesc ;

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

    public String getTitle() {
        return title ;
    }

    public void setTitle(String title) {
        this.title = title ;
    }

    public String getConfigKey() {
        return configKey ;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey ;
    }

    public String getConfigValue() {
        return configValue ;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue ;
    }

    public String getConfigDesc() {
        return configDesc ;
    }

    public void setConfigDesc(String configDesc) {
        this.configDesc = configDesc ;
    }

    //	@Transient
    //	private List<SystemConfigKeyValue> configKValue;

}
