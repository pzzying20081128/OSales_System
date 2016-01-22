package cn.zying.osales.pojos.commons ;

import javax.persistence.Transient ;

public class ImportBean {

    @Transient
    private boolean paserSuccess = true ;

    @Transient
    private String importErrorMsg ;

    @Transient
    private int excelRow ;

    public int getExcelRow() {
        return excelRow ;
    }

    public void setExcelRow(int excelRow) {
        this.excelRow = excelRow ;
    }

    public boolean isPaserSuccess() {
        return paserSuccess ;
    }

    public void setPaserSuccess(boolean paserSuccess) {
        this.paserSuccess = paserSuccess ;
    }

    public String getImportErrorMsg() {
        return importErrorMsg ;
    }

    public void setImportErrorMsg(String importErrorMsg) {
        this.importErrorMsg = importErrorMsg ;
    }

}
