package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.pojos.commons.CommOrderBean ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInvoiceDetailRemoveUnits")
public class StockInvoiceDetailRemoveUnits extends ABCommonsService {

    public <T> void removeBill(BillType billTYpe, T bill) throws SystemOptServiceException {

        switch (billTYpe) {
        case 采购进货单: {
            CommOrderBean commOrderBean = (CommOrderBean) bill ;
            String number = commOrderBean.getNumber() ;
            String del = "delete StockInvoiceDetail as stockInvoiceDetail where stockInvoiceDetail.billType='" + BillType.采购进货单 + "'  " +

            " and  stockInvoiceDetail.billNum ='" + number + "'  " ;

            baseService.executeByHSQL(del) ;
        }

            break ;

        default:
            break ;
        }

    }

    //    public StockInvoiceDetail  remove(OptType optType, StockInvoiceDetail  optStockInvoiceDetail ) throws SystemOptServiceException {
    //        
    //         Integer id =optStockInvoiceDetail.getId() ;
    //        StockInvoiceDetail   removeStockInvoiceDetail =baseService.get(id, StockInvoiceDetail.class);
    //        baseService.update(removeStockInvoiceDetail);
    //        return  removeStockInvoiceDetail ;
    //    }

}
