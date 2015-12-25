package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockInvoiceService ;
import cn.zying.osales.units.search.bean.StockInvoiceSearchBean ;

@Component(IAopStockInvoiceService.name)
public class AopStockInvoiceService implements IAopStockInvoiceService {

    @Autowired
    @Qualifier(IStockInvoiceService.name)
    private IStockInvoiceService iStockInvoiceService ;

    public StockInvoice saveUpdate(OptType optType, StockInvoice optStockInvoice) throws SystemOptServiceException {

        return iStockInvoiceService.saveUpdate(optType, optStockInvoice) ;

    }

    public SelectPage<StockInvoice> search(OptType optType, StockInvoiceSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockInvoiceService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockInvoice> searchList(OptType optType, StockInvoiceSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockInvoiceService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StockInvoice remove(OptType optType, StockInvoice optStockInvoice) throws SystemOptServiceException {

        return iStockInvoiceService.remove(optType, optStockInvoice) ;

    }

    public StockInvoice get(Integer id) throws SystemOptServiceException {
        return iStockInvoiceService.get(id) ;

    }

    @Override
    public StockInvoice check(StockInvoice stockinvoice) throws SystemOptServiceException {
        return iStockInvoiceService.check(stockinvoice) ;
    }

    @Override
    public SelectPage<StockInvoice> searchBillReconcile(OptType optType, StockInvoiceSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockInvoiceService.searchBillReconcile(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public StockInvoice autoReconcile(StockInvoice stockinvoice) throws SystemOptServiceException {
        return iStockInvoiceService.autoReconcile(stockinvoice) ;
    }

    @Override
    public StockInvoice cancelReconcile(StockInvoice stockinvoice) throws SystemOptServiceException {
        return iStockInvoiceService.cancelReconcile(stockinvoice) ;
    }

}
