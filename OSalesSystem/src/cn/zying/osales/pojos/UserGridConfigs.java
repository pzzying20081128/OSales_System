package cn.zying.osales.pojos ;

import javax.persistence.CascadeType ;
import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.FetchType ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.Table ;

@Entity
@Table(name = "sys_user_grid_configs")
public class UserGridConfigs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "module_name")
    private String moduleName ;

    @Column(name = "module_key")
    private String moduleKey ;

    @Column(name = "column_data_index")
    private String colDataIndex ;

    @Column(name = "column_Name")
    private String colName ;

    @Column(name = "column_width")
    private Integer colWidth ;

    @Column(name = "column_index")
    private Integer colIndex ;

    @Column(name = "column_hidden")
    private Integer hidden ;

    @Column(name = "print_width")
    private Integer printWidth ;

    @Column(name = "is_print")
    private Integer isPrint ;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sys_system_staff_id")
    private SysStaffUser systemUser ;

    @Column(name = "sys_system_staff_id", insertable = false, updatable = false)
    private Integer systemUserId ;

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

    public String getColDataIndex() {
        return colDataIndex ;
    }

    public void setColDataIndex(String colDataIndex) {
        this.colDataIndex = colDataIndex ;
    }

    public String getColName() {
        return colName ;
    }

    public void setColName(String colName) {
        this.colName = colName ;
    }

    public Integer getColWidth() {
        return colWidth ;
    }

    public void setColWidth(Integer colWidth) {
        this.colWidth = colWidth ;
    }

    public Integer getColIndex() {
        return colIndex ;
    }

    public void setColIndex(Integer colIndex) {
        this.colIndex = colIndex ;
    }

    public Integer getHidden() {
        return hidden ;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden ;
    }

    public Integer getPrintWidth() {
        return printWidth ;
    }

    public void setPrintWidth(Integer printWidth) {
        this.printWidth = printWidth ;
    }

    public Integer getIsPrint() {
        return isPrint ;
    }

    public void setIsPrint(Integer isPrint) {
        this.isPrint = isPrint ;
    }

    public SysStaffUser getSystemUser() {
        return systemUser ;
    }

    public void setSystemUser(SysStaffUser systemUser) {
        this.systemUser = systemUser ;
    }

    public Integer getSystemUserId() {
        return systemUserId ;
    }

    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId ;
    }

    public String getModuleKey() {
        return moduleKey ;
    }

    public void setModuleKey(String moduleKey) {
        this.moduleKey = moduleKey ;
    }

    public String getModuleName() {
        return moduleName ;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName ;
    }

}
