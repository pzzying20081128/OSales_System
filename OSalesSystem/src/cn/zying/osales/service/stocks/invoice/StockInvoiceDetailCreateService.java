package cn.zying.osales.service.stocks.invoice ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.pojos.StockInvoiceBillDetail ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.units.StockInvoiceBillDetailSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceDetailRemoveUnits ;

@Component(IStockInvoiceDetailCreateService.name)
public class StockInvoiceDetailCreateService implements IStockInvoiceDetailCreateService {

    @Autowired
    @Qualifier("StockInvoiceBillDetailSaveUpdateUnits")
    private StockInvoiceBillDetailSaveUpdateUnits stockInvoiceBillDetailSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockInvoiceDetailRemoveUnits")
    private StockInvoiceDetailRemoveUnits stockInvoiceDetailRemoveUnits ;

    @Override
    public <T> void createInvoiceDetail(BillType billType, T bill) throws SystemOptServiceException {
        switch (billType) {
        case 采购进货单:
            createStockStoreReceive(billType , (StockStoreReceive) bill) ;
            break ;
        case 采购票前调整单:
            createStockAdjustBill(billType , (StockAdjustBill) bill) ;
            break ;

        default:
            break ;
        }
    }

    private void createStockStoreReceive(BillType  billType   ,  StockStoreReceive stockStoreReceive) throws SystemOptServiceException {

        StockInvoiceBillDetail optStockInvoiceDetail = new StockInvoiceBillDetail() ;

        //        optStockInvoiceDetail.setBillDate(stockStoreReceive.gets) ;

        optStockInvoiceDetail.setBillNum(stockStoreReceive.getNumber()) ;

        optStockInvoiceDetail.setBillSum(stockStoreReceive.getTaxSumMoney()) ;

        optStockInvoiceDetail.setBillType(billType) ;

        optStockInvoiceDetail.setKillSum(OSalesConfigProperties.default_long_null) ;
        optStockInvoiceDetail.setNoKillSum(optStockInvoiceDetail.getBillSum()) ;
        optStockInvoiceDetail.setProviderInfoId(stockStoreReceive.getProviderInfoId()) ;
        optStockInvoiceDetail.setProviderInfo(stockStoreReceive.getProviderInfo()) ;

        stockInvoiceBillDetailSaveUpdateUnits.saveUpdate(OptType.save, optStockInvoiceDetail) ;
    }

    private void createStockAdjustBill(BillType  billType  , StockAdjustBill stockAdjustBill) throws SystemOptServiceException {

        StockInvoiceBillDetail optStockInvoiceDetail = new StockInvoiceBillDetail() ;

        //        optStockInvoiceDetail.setBillDate(stockStoreReceive.gets) ;

        optStockInvoiceDetail.setBillNum(stockAdjustBill.getAdjustNum()) ;

        optStockInvoiceDetail.setBillSum(stockAdjustBill.getAdjustSum()) ;

        optStockInvoiceDetail.setBillType(billType) ;

        optStockInvoiceDetail.setKillSum(OSalesConfigProperties.default_long_null) ;
        optStockInvoiceDetail.setNoKillSum(optStockInvoiceDetail.getBillSum()) ;
        optStockInvoiceDetail.setProviderInfoId(stockAdjustBill.getProviderInfoId()) ;
        optStockInvoiceDetail.setProviderInfo(stockAdjustBill.getProviderInfo()) ;
        stockInvoiceBillDetailSaveUpdateUnits.saveUpdate(OptType.save, optStockInvoiceDetail) ;
    }

    @Override
    public <T> void removeInvoiceDetail(BillType billType, T bill) throws SystemOptServiceException {
        stockInvoiceDetailRemoveUnits.removeBill(billType, bill) ;

    }

}
