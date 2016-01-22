package cn.zying.osales.imports.paser ;

import java.util.List ;

public class ImportServiceResult<V> {

    private List<V> errorResult ;

    private String errorExcelFile ;

    public List<V> getErrorResult() {
        return errorResult ;
    }

    public void setErrorResult(List<V> errorResult) {
        this.errorResult = errorResult ;
    }

    public String getErrorExcelFile() {
        return errorExcelFile ;
    }

    public void setErrorExcelFile(String errorExcelFile) {
        this.errorExcelFile = errorExcelFile ;
    }

}
