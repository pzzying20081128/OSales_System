package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.StockContract ;
import cn.zying.osales.pojos.StockContractDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockContractDetailSaveUpdateUnits")
public class StockContractDetailSaveUpdateUnits extends ABCommonsService {

    public StockContractDetail saveUpdate(OptType optType, StockContractDetail optStockContractDetail) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockContractDetail) ;

        case update:
            return update(optStockContractDetail) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockContractDetail save(StockContractDetail optStockContractDetail) throws SystemOptServiceException {

        setProperties(optStockContractDetail) ;

        baseService.save(optStockContractDetail) ;

        return optStockContractDetail ;
    }

    public StockContractDetail update(StockContractDetail optStockContractDetail) throws SystemOptServiceException {
        setProperties(optStockContractDetail) ;

        StockContractDetail stockContractDetail = baseService.get(optStockContractDetail.getId(), StockContractDetail.class) ;

        ToolsUnits.copyBeanProperties(stockContractDetail, optStockContractDetail,

        "productInfo", "productInfoId", "taxPrice", "taxPriceMoneyShow", "taxPriceMoneyHide",

        "taxRate", "taxRateTaxRateShow", "taxRateTaxRateHide",

        "noTaxPrice", "noTaxPriceMoneyShow", "noTaxPriceMoneyHide", "isBox", "text") ;
        
        baseService.update(stockContractDetail) ;

        return stockContractDetail ;
    }

    private void setProperties(StockContractDetail optStockContractDetail) {

        ProductInfo productInfo = baseService.load(optStockContractDetail.getProductInfoId(), ProductInfo.class) ;

        optStockContractDetail.setProductInfo(productInfo) ;
        optStockContractDetail.setProductInfoId(optStockContractDetail.getProductInfoId());

        StockContract stockContract = baseService.get(StockContract.class, optStockContractDetail.getStockContractId()) ;

        optStockContractDetail.setStockContract(stockContract) ;
        optStockContractDetail.setStockContractId(optStockContractDetail.getStockContractId());

    }

}
