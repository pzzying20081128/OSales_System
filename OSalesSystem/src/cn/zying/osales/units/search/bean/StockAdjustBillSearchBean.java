package cn.zying.osales.units.search.bean ;

import java.util.List ;

import cn.zying.osales.OSalesConfigProperties.AdjustType ;
import cn.zying.osales.pojos.StockAdjustBill ;

public class StockAdjustBillSearchBean extends StockAdjustBill {

    /**
     * 
     */
    private static final long serialVersionUID = 5422695930430410110L ;

    private List<Integer> providerInfoIds ;

    private List<String> adjustSubjects ;

    private List<AdjustType> adjustTypes ;

    public List<Integer> getProviderInfoIds() {
        return providerInfoIds ;
    }

    public void setProviderInfoIds(List<Integer> providerInfoIds) {
        this.providerInfoIds = providerInfoIds ;
    }

    public List<String> getAdjustSubjects() {
        return adjustSubjects ;
    }

    public void setAdjustSubjects(List<String> adjustSubjects) {
        this.adjustSubjects = adjustSubjects ;
    }

    public List<AdjustType> getAdjustTypes() {
        return adjustTypes ;
    }

    public void setAdjustTypes(List<AdjustType> adjustTypes) {
        this.adjustTypes = adjustTypes ;
    }

}
