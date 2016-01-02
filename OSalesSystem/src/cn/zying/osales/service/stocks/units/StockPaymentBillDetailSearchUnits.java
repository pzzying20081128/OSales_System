package cn.zying.osales.service.stocks.units ;

import java.util.ArrayList ;
import java.util.List ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockPaymentBillDetail ;
import cn.zying.osales.pojos.StockPaymentDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockPaymentBillDetailSearchBean ;

/**
 * 查询所有的能对帐的单据包含已对帐的单据
 * @author you
 *
 */
@Component("StockPaymentBillDetailSearchUnits")
public class StockPaymentBillDetailSearchUnits extends ABCommonsService {

    public SelectPage<StockPaymentBillDetail> searchAllBillDetail(OptType optType, StockPaymentBillDetailSearchBean searchBean,

    CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        String sql = "select stockPaymentBillDetail  from   StockPaymentBillDetail as  stockPaymentBillDetail " +

        "   where  stockPaymentBillDetail.providerInfoId=" + searchBean.getProviderInfoId() +

        "   and  stockPaymentBillDetail.killSum  = 0" ;

        List<StockPaymentBillDetail> stockInvoiceBillDetails = baseService.findByHSQL(sql) ;

        String stockInvoiceDetailes = "select  stockPaymentDetail  from  StockPaymentDetail as  stockPaymentDetail  inner join fetch  stockPaymentDetail.stockPaymentBillDetail " +

        "  where  stockPaymentDetail.stockPaymentId = " + searchBean.getStockPaymentId() ;

        List<StockPaymentBillDetail> stockPaymentBillDetailes_ = new ArrayList<StockPaymentBillDetail>() ;

        if (startLimit == null || startLimit.length == 0 || startLimit[0] == 0) {
            List<StockPaymentDetail> stockPaymentDetails = baseService.findByHSQL(stockInvoiceDetailes) ;
            for (StockPaymentDetail stockPaymentDetail : stockPaymentDetails) {

                StockPaymentBillDetail stockPaymentBillDetail = stockPaymentDetail.getStockPaymentBillDetail() ;

                stockPaymentBillDetail.setStockPaymentDetail(stockPaymentDetail) ;

                stockPaymentBillDetailes_.add(stockPaymentBillDetail) ;

            }

        }

        stockPaymentBillDetailes_.addAll(stockInvoiceBillDetails) ;

//        Collections.sort(stockPaymentBillDetailes_, new Comparator<StockPaymentBillDetail>() {
//
//            @Override
//            public int compare(StockPaymentBillDetail o1, StockPaymentBillDetail o2) {
//
//                return o1.getBillDate().compareTo(o2.getBillDate()) ;
//            }
//
//        }) ;

        SelectPage<StockPaymentBillDetail> result = new SelectPage<StockPaymentBillDetail>() ;
        result.setCount((long) stockPaymentBillDetailes_.size()) ;
        result.setResult(stockPaymentBillDetailes_) ;

        return result ;

    }

}
