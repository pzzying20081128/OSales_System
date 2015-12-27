package cn.zying.osales.service.stocks.units ;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Comparator ;
import java.util.List ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInvoiceBillDetail ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockInvoiceBillDetailSearchBean ;

/**
 * 查询所有要对帐的票据
 * @author you
 *
 */
@Component("StockInvoiceBillSearchAllReconcileSearchUnits")
public class StockInvoiceBillSearchAllReconcileSearchUnits extends ABCommonsService {

    public SelectPage<StockInvoiceBillDetail> searchAllReconcileBill(OptType optType, StockInvoiceBillDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        String sql = "select stockInvoiceBillDetail  from   StockInvoiceBillDetail as  stockInvoiceBillDetail " +

        "   where  stockInvoiceBillDetail.providerInfoId=" + searchBean.getProviderInfoId() +

        "   and  stockInvoiceBillDetail.killSum  = 0" ;

        List<StockInvoiceBillDetail> stockInvoiceBillDetails = baseService.findByHSQL(sql) ;

        String stockInvoiceDetailes = "select  stockInvoiceDetail  from  StockInvoiceDetail as  stockInvoiceDetail  inner join fetch  stockInvoiceDetail.stockInvoiceBillDetail " +

        "  where  stockInvoiceDetail.stockInvoiceId = " + searchBean.getStockInvoiceId() ;

        List<StockInvoiceBillDetail> stockInvoiceDetails_ = new ArrayList<StockInvoiceBillDetail>() ;

        //        if (stockInvoiceBillDetails != null && stockInvoiceBillDetails.size() > 0)
        //
        //        {
        //            stockInvoiceDetailes = stockInvoiceDetailes + "  and  stockInvoiceDetail.stockInvoiceBillDetail in (:stockInvoiceBillDetail) " ;
        //
        //            Map<String, Object> values = ToolsUnits.createSearchMap() ;
        //
        //            values.put("stockInvoiceBillDetail", stockInvoiceBillDetails) ;
        //
        //            stockInvoiceDetails = baseService.findByHSQL(stockInvoiceDetailes, values, startLimit) ;
        //
        //        } else {
        //            stockInvoiceDetails = baseService.findByHSQL(stockInvoiceDetailes, startLimit) ;
        //        }
        if (startLimit == null || startLimit.length == 0 || startLimit[0] == 0) {
            List<StockInvoiceDetail> stockInvoiceDetails = baseService.findByHSQL(stockInvoiceDetailes) ;
            for (StockInvoiceDetail stockInvoiceDetail : stockInvoiceDetails) {

                StockInvoiceBillDetail stockInvoiceBillDetail = stockInvoiceDetail.getStockInvoiceBillDetail() ;

                stockInvoiceBillDetail.setStockInvoiceDetail(stockInvoiceDetail) ;

                stockInvoiceDetails_.add(stockInvoiceBillDetail) ;

            }

        }

        stockInvoiceDetails_.addAll(stockInvoiceBillDetails) ;

        Collections.sort(stockInvoiceBillDetails, new Comparator<StockInvoiceBillDetail>() {

            @Override
            public int compare(StockInvoiceBillDetail o1, StockInvoiceBillDetail o2) {

                return o1.getBillDate().compareTo(o2.getBillDate()) ;
            }

        }) ;

        SelectPage<StockInvoiceBillDetail> result = new SelectPage<StockInvoiceBillDetail>() ;
        result.setCount((long) stockInvoiceDetails_.size()) ;
        result.setResult(stockInvoiceDetails_) ;

        return result ;

    }

}
