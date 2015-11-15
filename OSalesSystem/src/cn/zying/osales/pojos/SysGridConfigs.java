package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.Index ;
import javax.persistence.Table ;

import cn.zy.apps.tools.jpa.FieldDesc ;

@Entity
@Table(name = "sys_grid_configs")
public class SysGridConfigs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "module_name")
//    @FieldDesc(name="")
    private String moduleName ;
    
    @Column(name = "module_key")
    private String moduleKey ;

    @Column(name = "column_data_index")
    @FieldDesc(name = "数据索引")
    private String colDataIndex ;

    @Column(name = "column_Name")
    @FieldDesc(name = "列名")
    private String colName ;

    @Column(name = "print_Name")
    @FieldDesc(name = "打印名")
    private String printName ;

    @Column(name = "column_index")
    @FieldDesc(name = "排序")
    private Integer colIndex ;

   

    @Column(name = "is_print")
    @FieldDesc(name = "是否打印")
    private Integer isPrint ;

    @Column(name = "is_total")
    @FieldDesc(name = "是否求和")
    private Integer istotal ;

    @Column(name = "is_excel_exports")
    @FieldDesc(name = "是否excel导出")
    private Integer isExcelExPorts ;

    //    @Column(name = "print_place")
    //    private Integer printPlace ;

    //    @Column(name = "add_type")
    //    @FieldDesc(desc = "0:页面加入;1:手工加入")
    //    private Integer addType ;

    //    @Transient
    //    private boolean isSave = true ;
    //
    //    @Transient
    //    private int excelWith = 5 * 2 * 256 ;
    //
    //    @Transient
    //    private int excelAlign ;
    
    

    public Integer getId() {
        return id ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

    public String getModuleName() {
        return moduleName ;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName ;
    }

    public Integer getColIndex() {
        return colIndex ;
    }

    public void setColIndex(Integer colIndex) {
        this.colIndex = colIndex ;
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

  
    public Integer getIsPrint() {
        return isPrint ;
    }

    public void setIsPrint(Integer isPrint) {
        this.isPrint = isPrint ;
    }

    public String getPrintName() {
        return printName ;
    }

    public void setPrintName(String printName) {
        this.printName = printName ;
    }

    public Integer getIstotal() {
        return istotal ;
    }

    public void setIstotal(Integer istotal) {
        this.istotal = istotal ;
    }

    public Integer getIsExcelExPorts() {
        return isExcelExPorts ;
    }

    public void setIsExcelExPorts(Integer isExcelExPorts) {
        this.isExcelExPorts = isExcelExPorts ;
    }

    public String getModuleKey() {
        return moduleKey ;
    }

    public void setModuleKey(String moduleKey) {
        this.moduleKey = moduleKey ;
    }

}
