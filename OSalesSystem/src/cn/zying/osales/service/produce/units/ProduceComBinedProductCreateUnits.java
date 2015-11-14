package cn.zying.osales.service.produce.units ;

import java.util.ArrayList ;
import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.OrderSimpleName ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.OSalesConfigProperties.StockType ;
import cn.zying.osales.pojos.CombinedProduct ;
import cn.zying.osales.pojos.CombinedProductDetails ;
import cn.zying.osales.pojos.ProduceComBinedProduct ;
import cn.zying.osales.pojos.ProduceComBinedProductDetail ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.units.CombinedProductSearchUnits ;

@Component("ProduceComBinedProductCreateUnits")
public class ProduceComBinedProductCreateUnits extends ABCommonsService {

    @Autowired
    @Qualifier("CombinedProductSearchUnits")
    private CombinedProductSearchUnits combinedProductSearchUnits ;

    public void create(StockOrder stockOrder) throws SystemOptServiceException {

        for (StockOrderDetail stockInStoreDetail : stockOrder.getStockOrderDetails()) {

            ProduceComBinedProduct produceComBinedProduct = new ProduceComBinedProduct() ;

            produceComBinedProduct.setNumber(baseService.genSerialNum(OrderSimpleName.KSSC.name())) ;
            produceComBinedProduct.setStatus(Status.有效) ;
            produceComBinedProduct.setProduceCount(stockInStoreDetail.getOrderCount()) ;
            produceComBinedProduct.setProduceDate(stockOrder.getStockDate()) ;
            produceComBinedProduct.setProductInfo(stockInStoreDetail.getProductInfo()) ;
            produceComBinedProduct.setProductInfoId(stockInStoreDetail.getProductInfoId()) ;
            produceComBinedProduct.setRecordMan(stockOrder.getCheckMan()) ;
            produceComBinedProduct.setRecordManId(stockOrder.getCheckManId()) ;
            produceComBinedProduct.setRecordDate(stockOrder.getOrderDate()) ;
            produceComBinedProduct.setStockOrder(stockOrder) ;
            produceComBinedProduct.setStoreInfo(stockInStoreDetail.getStoreInfo()) ;
            produceComBinedProduct.setStoreInfoId(stockInStoreDetail.getStoreInfoId()) ;
            produceComBinedProduct.setStorePosition(stockInStoreDetail.getStorePosition()) ;
            produceComBinedProduct.setStorePositionId(stockInStoreDetail.getStorePositionId()) ;
            produceComBinedProduct.setStockOrderDetail(stockInStoreDetail);

            List<ProduceComBinedProductDetail> produceComBinationProducInfoDetails = new ArrayList<ProduceComBinedProductDetail>() ;

            produceComBinedProduct.setProduceComBinationProducInfoDetails(produceComBinationProducInfoDetails) ;

            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            CombinedProduct combinedProduct = combinedProductSearchUnits.searchByProductInfoId(stockInStoreDetail.getProductInfoId()) ;
            for (CombinedProductDetails combinedProductDetails : combinedProduct.getCombinedProductDetailses()) {

                ProduceComBinedProductDetail produceComBinedProductDetail = new ProduceComBinedProductDetail() ;

                produceComBinationProducInfoDetails.add(produceComBinedProductDetail) ;

                produceComBinedProductDetail.setProduceProducInfo(produceComBinedProduct) ;

                produceComBinedProductDetail.setProductInfo(combinedProductDetails.getProductInfo()) ;
                produceComBinedProductDetail.setProduceProducInfoId(combinedProductDetails.getProductInfoId()) ;
                produceComBinedProductDetail.setNeedunitQuantity(combinedProductDetails.getNumber()) ;
                produceComBinedProductDetail.setProductInfoQuantity(combinedProductDetails.getNumber() * produceComBinedProduct.getProduceCount()) ;
                produceComBinedProductDetail.setStoreInfo(combinedProductDetails.getProductInfo().getStoreInfo()) ;
                produceComBinedProductDetail.setStoreInfoId(combinedProductDetails.getProductInfoId()) ;
                produceComBinedProductDetail.setStorePosition(combinedProductDetails.getProductInfo().getStorePosition()) ;
                produceComBinedProductDetail.setStorePositionId(combinedProductDetails.getProductInfo().getStorePositionId()) ;
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            baseService.save(produceComBinedProduct) ;

        }

    }

}
