package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInvoiceSaveUpdateUnits")
public class StockInvoiceSaveUpdateUnits extends ABCommonsService {

    public StockInvoice saveUpdate(OptType optType, StockInvoice optStockInvoice) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockInvoice) ;

        case update:
            return update(optStockInvoice) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockInvoice save(StockInvoice optStockInvoice) throws SystemOptServiceException {
        setPropertis(optStockInvoice) ;
        optStockInvoice.setStatus(Status.有效) ;
        if (!ToolsUnits.isNOtNulll(optStockInvoice.getNum())) {
            optStockInvoice.setNum(baseService.genSerialNum(OSalesConfigProperties.OrderSimpleName.SGFP.name())) ;
        }
        optStockInvoice.setReconciliationSum(optStockInvoice.getInvoiceSum());
        baseService.save(optStockInvoice) ;
        return optStockInvoice ;

    }

    public StockInvoice update(StockInvoice optStockInvoice) throws SystemOptServiceException {
        setPropertis(optStockInvoice) ;
        StockInvoice stockInvoice = baseService.get(StockInvoice.class, optStockInvoice.getId()) ;
        ToolsUnits.copyBeanProperties(stockInvoice, optStockInvoice, "num", "invoiceNum", "providerInfo", "providerInfoId",

        "invoiceDate", "paymentDate", "invoiceSum", "text") ;
        stockInvoice.setReconciliationSum(stockInvoice.getInvoiceSum());

        baseService.save(stockInvoice) ;
        return stockInvoice ;
    }

    private void setPropertis(StockInvoice optStockInvoice) {
        ProviderInfo providerInfo = baseService.load(optStockInvoice.getProviderInfoId(), ProviderInfo.class) ;
        optStockInvoice.setProviderInfo(providerInfo) ;
        if (optStockInvoice.getRecordManId() != null) {
            SysStaffUser recordMan = baseService.load(optStockInvoice.getRecordManId(), SysStaffUser.class) ;
            optStockInvoice.setRecordMan(recordMan) ;
        }

    }

}
