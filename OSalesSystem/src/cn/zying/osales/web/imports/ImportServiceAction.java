package cn.zying.osales.web.imports ;

import java.io.File ;

import javax.persistence.EntityManagerFactory ;
import javax.persistence.PersistenceUnit ;

import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zying.osales.imports.ABImportService ;
import cn.zying.osales.imports.paser.ImportServiceResult ;
import cn.zying.osales.units.IPropertiesCacheFactory ;
import cn.zying.osales.units.PropertiesCacheFactory ;
import cn.zying.osales.web.OSalesSystemABAction ;

public abstract class ImportServiceAction<V> extends OSalesSystemABAction<V> {

    private static final long serialVersionUID = 5948948407693204511L ;

    @PersistenceUnit(unitName = "db")
    protected EntityManagerFactory emf ;

    private File importExcel ; // 上传的文件

    private String importExcelFileName ; // 文件名称

    private String importExcelContentType ; // 文件类型

    private int importErrorSize = 0 ;

    private String importErrorFile = "sss.excel" ;

    protected IPropertiesCacheFactory cacheFactory = PropertiesCacheFactory.instance() ;

    protected abstract ABImportService<V> instanceImportService() ;

    public String importExcel() throws Exception {
        try {
            Loggerfactory.info(logger, "start import excel : " + importExcel) ;
            ABImportService<V> service = instanceImportService() ;
            this.success = true ;
            ImportServiceResult<V> result = service.imports(importExcel) ;
            if (result != null && result.getErrorResult() != null && result.getErrorResult().size() > 0) {
                importErrorSize = result.getErrorResult().size() ;
            } else {
                importErrorSize = 0 ;
            }

            Loggerfactory.info(logger, "start import excel : " + importExcel + " importErrorSize " + importErrorSize) ;
        } catch (Exception e) {
            this.msg = handError(e) ;
            this.success = false ;
        }
        return SUCCESS ;
    }

    public File getImportExcel() {
        return importExcel ;
    }

    public void setImportExcel(File importExcel) {
        this.importExcel = importExcel ;
    }

    public String getImportExcelFileName() {
        return importExcelFileName ;
    }

    public void setImportExcelFileName(String importExcelFileName) {
        this.importExcelFileName = importExcelFileName ;
    }

    public String getImportExcelContentType() {
        return importExcelContentType ;
    }

    public void setImportExcelContentType(String importExcelContentType) {
        this.importExcelContentType = importExcelContentType ;
    }

    public int getImportErrorSize() {
        return importErrorSize ;
    }

    public void setImportErrorSize(int importErrorSize) {
        this.importErrorSize = importErrorSize ;
    }

    public String getImportErrorFile() {
        return importErrorFile ;
    }

    public void setImportErrorFile(String importErrorFile) {
        this.importErrorFile = importErrorFile ;
    }

}
