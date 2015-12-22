package cn.zying.osales.service.stocks.invoice ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.units.StockInvoiceDetailRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceDetailSaveUpdateUnits ;

@Component(IStockInvoiceDetailCreateService.name)
public class StockInvoiceDetailCreateService implements IStockInvoiceDetailCreateService {

    @Autowired
    @Qualifier("StockInvoiceDetailSaveUpdateUnits")
    private StockInvoiceDetailSaveUpdateUnits stockInvoiceDetailSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockInvoiceDetailRemoveUnits")
    private StockInvoiceDetailRemoveUnits stockInvoiceDetailRemoveUnits ;

    @Override
    public <T> void createInvoiceDetail(BillType billType, T bill) throws SystemOptServiceException {
        switch (billType) {
        case 采购进货单:
            createStockStoreReceive((StockStoreReceive) bill) ;
            break ;

        default:
            break ;
        }
    }

    private void createStockStoreReceive(StockStoreReceive stockStoreReceive) throws SystemOptServiceException {

        StockInvoiceDetail optStockInvoiceDetail = new StockInvoiceDetail() ;

        optStockInvoiceDetail.setBillDate(stockStoreReceive.getCreateTime()) ;

        optStockInvoiceDetail.setBillNum(stockStoreReceive.getNumber()) ;

        optStockInvoiceDetail.setBillSum(stockStoreReceive.getTaxSumMoney()) ;

        optStockInvoiceDetail.setBillType(BillType.采购进货单) ;

        optStockInvoiceDetail.setKillSum(OSalesConfigProperties.default_long_null) ;
        optStockInvoiceDetail.setNoKillSum(OSalesConfigProperties.default_long_null) ;
        optStockInvoiceDetail.setProviderId(stockStoreReceive.getProviderInfoId()) ;
        optStockInvoiceDetail.setProviderInfo(stockStoreReceive.getProviderInfo()) ;

        stockInvoiceDetailSaveUpdateUnits.saveUpdate(OptType.save, optStockInvoiceDetail) ;
    }

    @Override
    public <T> void removeInvoiceDetail(BillType billType, T bill) throws SystemOptServiceException {
        stockInvoiceDetailRemoveUnits.removeBill(billType, bill) ;

    }

}
