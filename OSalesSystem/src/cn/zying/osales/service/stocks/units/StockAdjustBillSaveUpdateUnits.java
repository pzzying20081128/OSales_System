package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockAdjustBillSaveUpdateUnits")
public class StockAdjustBillSaveUpdateUnits extends ABCommonsService {

    public StockAdjustBill saveUpdate(OptType optType, StockAdjustBill optStockAdjustBill) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockAdjustBill) ;

        case update:
            return update(optStockAdjustBill) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockAdjustBill save(StockAdjustBill optStockAdjustBill) throws SystemOptServiceException {
        optStockAdjustBill.setAdjustNum(baseService.genSerialNum(OSalesConfigProperties.OrderSimpleName.CGTZD.name())) ;
        setProeprties(optStockAdjustBill) ;
        optStockAdjustBill.setStatus(OSalesConfigProperties.Status.有效) ;

        optStockAdjustBill.setRecordMan(baseService.load(optStockAdjustBill.getRecordManId(), SysStaffUser.class)) ;

        baseService.save(optStockAdjustBill) ;
        return optStockAdjustBill ;
    }

    public StockAdjustBill update(StockAdjustBill optStockAdjustBill) throws SystemOptServiceException {
        setProeprties(optStockAdjustBill) ;
        StockAdjustBill stockAdjustBill = baseService.get(StockAdjustBill.class, optStockAdjustBill.getId()) ;
        ToolsUnits.copyBeanProperties(stockAdjustBill, optStockAdjustBill, "adjustNum", "providerInfo"

        , "providerInfoId", "adjustSubject", "adjustType", "adjustDate", "adjustSum", "text") ;
        return stockAdjustBill ;
    }

    private void check(OptType optType, StockAdjustBill optStockAdjustBill) throws SystemOptServiceException {
        switch (optType) {
        case save: {
            String sql = "select stockAdjustBill  from  StockAdjustBill as  stockAdjustBill  " +

            "   where  stockAdjustBill.adjustNum ='" + optStockAdjustBill.getAdjustNum() + "' " ;

            StockAdjustBill stockAdjustBill = baseService.findSinglenessByHSQL(sql) ;

            if (stockAdjustBill != null) {

                throw new SystemOptServiceException("调整单号[" + optStockAdjustBill.getAdjustNum() + "]重复") ;
            }
        }

            break ;

        case update: {
            String sql = "select stockAdjustBill  from  StockAdjustBill as  stockAdjustBill  " +

            "   where  stockAdjustBill.adjustNum ='" + optStockAdjustBill.getAdjustNum() + "'  " +

            "   and  stockAdjustBill.id !=" + optStockAdjustBill.getId() ;

            StockAdjustBill stockAdjustBill = baseService.findSinglenessByHSQL(sql) ;

            if (stockAdjustBill != null) {

                throw new SystemOptServiceException("调整单号[" + optStockAdjustBill.getAdjustNum() + "]重复") ;
            }
        }

            break ;

        default:
            break ;
        }

    }

    private void setProeprties(StockAdjustBill optStockAdjustBill) {
        ProviderInfo providerInfo = baseService.load(optStockAdjustBill.getProviderInfoId(), ProviderInfo.class) ;
        optStockAdjustBill.setProviderInfo(providerInfo) ;

    }

}
