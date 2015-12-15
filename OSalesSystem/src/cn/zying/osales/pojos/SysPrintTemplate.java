package cn.zying.osales.pojos ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.Lob ;
import javax.persistence.Table ;
import javax.persistence.Transient ;

@Entity
@Table(name = "sys_print_template")
public class SysPrintTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "module_name")
    private String moduleName ;

    @Lob
    @Column(name = "template")
    //    @Basic(fetch=FetchType.LAZY)
    private String template ;

    @Transient
    private String filePath ;

    @Transient
    private String fileName ;

    @Column(name = "page_width")
    private Integer pageWidth ;

    @Column(name = "page_heigth")
    private Integer pageHeigth ;

    @Column(name = "head_top")
    private Integer headTop ;

    @Column(name = "head_left")
    private Integer headLeft ;

    @Column(name = "head_width")
    private Integer headWidth ;

    @Column(name = "head_heigth")
    private Integer headHeigth ;

    //    @Column(name = "body_top")
    //    private Integer bodyTop ;
    //
    //    @Column(name = "body_left")
    //    private Integer bodyLeft ;
    //
    //    @Column(name = "body_width")
    //    private Integer bodyWidth ;
    //
    //    @Column(name = "body_heigth")
    //    private Integer bodyHeigth ;
    //
    //    @Column(name = "bottom_top")
    //    private Integer bottomTop ;
    //
    //    @Column(name = "bottom_left")
    //    private Integer bottomLeft ;
    //
    //    @Column(name = "bottom_width")
    //    private Integer bottomWidth ;
    //
    //    @Column(name = "bottom_heigth")
    //    private Integer bottomHeigth ;

    //    /**
    //     * 每一页 打印行数
    //     */
    //    @Column(name = "each_page_print_row")
    //    private Integer eachPagePrintRow ;

    /**
    //     * 每一页 打印xu号
    //     */
    //    @Column(name = "each_page_print_xhao")
    //    private Integer printXhao = SystemPopertiesConfigs.is_print_row_n ;

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

    public String getTemplate() {
        return template ;
    }

    public void setTemplate(String template) {
        this.template = template ;
    }

    public String getFilePath() {
        return filePath ;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath ;
    }

    public String getFileName() {
        return fileName ;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName ;
    }

    public Integer getPageWidth() {
        return pageWidth ;
    }

    public void setPageWidth(Integer pageWidth) {
        this.pageWidth = pageWidth ;
    }

    public Integer getPageHeigth() {
        return pageHeigth ;
    }

    public void setPageHeigth(Integer pageHeigth) {
        this.pageHeigth = pageHeigth ;
    }

    public Integer getHeadTop() {
        return headTop ;
    }

    public void setHeadTop(Integer headTop) {
        this.headTop = headTop ;
    }

    public Integer getHeadLeft() {
        return headLeft ;
    }

    public void setHeadLeft(Integer headLeft) {
        this.headLeft = headLeft ;
    }

    public Integer getHeadWidth() {
        return headWidth ;
    }

    public void setHeadWidth(Integer headWidth) {
        this.headWidth = headWidth ;
    }

    public Integer getHeadHeigth() {
        return headHeigth ;
    }

    public void setHeadHeigth(Integer headHeigth) {
        this.headHeigth = headHeigth ;
    }

    //    public Integer getBodyTop() {
    //        return bodyTop ;
    //    }
    //
    //    public void setBodyTop(Integer bodyTop) {
    //        this.bodyTop = bodyTop ;
    //    }
    //
    //    public Integer getBodyLeft() {
    //        return bodyLeft ;
    //    }
    //
    //    public void setBodyLeft(Integer bodyLeft) {
    //        this.bodyLeft = bodyLeft ;
    //    }
    //
    //    public Integer getBodyWidth() {
    //        return bodyWidth ;
    //    }
    //
    //    public void setBodyWidth(Integer bodyWidth) {
    //        this.bodyWidth = bodyWidth ;
    //    }
    //
    //    public Integer getBodyHeigth() {
    //        return bodyHeigth ;
    //    }
    //
    //    public void setBodyHeigth(Integer bodyHeigth) {
    //        this.bodyHeigth = bodyHeigth ;
    //    }
    //
    //    public Integer getBottomTop() {
    //        return bottomTop ;
    //    }
    //
    //    public void setBottomTop(Integer bottomTop) {
    //        this.bottomTop = bottomTop ;
    //    }
    //
    //    public Integer getBottomLeft() {
    //        return bottomLeft ;
    //    }
    //
    //    public void setBottomLeft(Integer bottomLeft) {
    //        this.bottomLeft = bottomLeft ;
    //    }
    //
    //    public Integer getBottomWidth() {
    //        return bottomWidth ;
    //    }
    //
    //    public void setBottomWidth(Integer bottomWidth) {
    //        this.bottomWidth = bottomWidth ;
    //    }
    //
    //    public Integer getBottomHeigth() {
    //        return bottomHeigth ;
    //    }
    //
    //    public void setBottomHeigth(Integer bottomHeigth) {
    //        this.bottomHeigth = bottomHeigth ;
    //    }
    //
    //    public Integer getEachPagePrintRow() {
    //        return eachPagePrintRow ;
    //    }
    //
    //    public void setEachPagePrintRow(Integer eachPagePrintRow) {
    //        this.eachPagePrintRow = eachPagePrintRow ;
    //    }
    //
    //    public Integer getPrintXhao() {
    //        return printXhao ;
    //    }
    //
    //    public void setPrintXhao(Integer printXhao) {
    //        this.printXhao = printXhao ;
    //    }

}
