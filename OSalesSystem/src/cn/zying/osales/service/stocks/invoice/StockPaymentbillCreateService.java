package cn.zying.osales.service.stocks.invoice ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.pojos.StockPaymentBillDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.units.StockPaymentBillDetailSaveUpdateUnits ;

@Component(IStockPaymentbillCreateService.name)
public class StockPaymentbillCreateService extends ABCommonsService implements IStockPaymentbillCreateService {

    @Autowired
    @Qualifier("StockPaymentBillDetailSaveUpdateUnits")
    private StockPaymentBillDetailSaveUpdateUnits stockPaymentBillDetailSaveUpdateUnits ;

    @Override
    public <T> void createDetail(BillType billType, T bill) throws SystemOptServiceException {
        switch (billType) {
        case 采购付款:
            createStockInvoice(billType, (StockInvoice) bill) ;
            break ;

        case 采购调整单:
            createStockAdjustBill(billType, (StockAdjustBill) bill) ;
            break ;

        default:
            break ;
        }

    }

    private void createStockAdjustBill(BillType billType, StockAdjustBill stockAdjustBill) throws SystemOptServiceException {

        StockPaymentBillDetail stockPaymentBillDetail = new StockPaymentBillDetail() ;

        //        optStockInvoiceDetail.setBillDate(stockStoreReceive.gets) ;

        stockPaymentBillDetail.setBillNum(stockAdjustBill.getAdjustNum()) ;

        stockPaymentBillDetail.setPaymentSum(stockAdjustBill.getAdjustSum()) ;

        stockPaymentBillDetail.setBillType(billType) ;

        stockPaymentBillDetail.setKillSum(OSalesConfigProperties.default_long_null) ;
        stockPaymentBillDetail.setNoKillSum(stockPaymentBillDetail.getPaymentSum()) ;
        stockPaymentBillDetail.setProviderInfoId(stockAdjustBill.getProviderInfoId()) ;
        stockPaymentBillDetail.setProviderInfo(stockAdjustBill.getProviderInfo()) ;
        stockPaymentBillDetailSaveUpdateUnits.saveUpdate(OptType.save, stockPaymentBillDetail) ;
    }

    private void createStockInvoice(BillType billType, StockInvoice stockInvoice) throws SystemOptServiceException {

        StockPaymentBillDetail stockPaymentBillDetail = new StockPaymentBillDetail() ;

        stockPaymentBillDetail.setBillDate(stockInvoice.getCreateTime()) ;

        stockPaymentBillDetail.setBillNum(stockInvoice.getNum()) ;

        stockPaymentBillDetail.setPaymentSum(stockInvoice.getInvoiceSum()) ;

        stockPaymentBillDetail.setBillType(billType) ;

        stockPaymentBillDetail.setKillSum(OSalesConfigProperties.default_long_null) ;
        stockPaymentBillDetail.setNoKillSum(stockPaymentBillDetail.getPaymentSum()) ;
        stockPaymentBillDetail.setProviderInfoId(stockInvoice.getProviderInfoId()) ;
        stockPaymentBillDetail.setProviderInfo(stockInvoice.getProviderInfo()) ;

        stockPaymentBillDetailSaveUpdateUnits.saveUpdate(OptType.save, stockPaymentBillDetail) ;
    }

    @Override
    public <T> void removeDetail(BillType billType, T bill) throws SystemOptServiceException {
        String bullNum = null ;
        switch (billType) {
        case 采购付款:
            bullNum = ((StockInvoice) bill).getNum() ;
            break ;
        case 采购调整单:
            bullNum = ((StockAdjustBill) bill).getAdjustNum() ;
            break ;

        default:
            throw new SystemOptServiceException("BillType Error : " + billType.name()) ;
        }

        String sql = "delete  StockPaymentBillDetail as stockPaymentBillDetail   " +

        "  where  stockPaymentBillDetail.billType ='" + billType.name() + "'  " +

        "  and   stockPaymentBillDetail.billNum ='" + bullNum + "'   " ;

        baseService.executeByHSQL(sql) ;

    }
}
