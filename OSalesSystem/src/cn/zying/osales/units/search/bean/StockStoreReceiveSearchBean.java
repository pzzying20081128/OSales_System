package cn.zying.osales.units.search.bean ;

import cn.zying.osales.pojos.StockStoreReceive ;

public class StockStoreReceiveSearchBean extends StockStoreReceive {

    private String stockOrderNumber ;

    private String stockInStoreNumber ;
    
    
    

    public String getStockOrderNumber() {
        return stockOrderNumber ;
    }

    public void setStockOrderNumber(String stockOrderNumber) {
        this.stockOrderNumber = stockOrderNumber ;
    }

    public String getStockInStoreNumber() {
        return stockInStoreNumber ;
    }

    public void setStockInStoreNumber(String stockInStoreNumber) {
        this.stockInStoreNumber = stockInStoreNumber ;
    }

  

}
