package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.CompanyInfo ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StockContract ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockContractSaveUpdateUnits")
public class StockContractSaveUpdateUnits extends ABCommonsService {

    public StockContract saveUpdate(OptType optType, StockContract optStockContract) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockContract) ;

        case update:
            return update(optStockContract) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockContract save(StockContract optStockContract) throws SystemOptServiceException {
        setProperties(optStockContract) ;
        optStockContract.setStatus(Status.有效);
        baseService.save(optStockContract);
        return optStockContract ;
    }

    public StockContract update(StockContract optStockContract) throws SystemOptServiceException {
        setProperties(optStockContract) ;
        
        StockContract stockContract = baseService.get(optStockContract.getId(), StockContract.class) ;

        ToolsUnits.copyBeanProperties(optStockContract, stockContract, "providerInfo", "providerInfoId", "stockMan", "stockManId", "companyInfo", "companyInfoId", "contractStatus", "text", "signedDate") ;
        baseService.update(stockContract) ;
        return stockContract ;
    }

    private void setProperties(StockContract optStockContract) {
        CompanyInfo companyInfo = baseService.load(optStockContract.getCompanyInfoId(), CompanyInfo.class) ;
        optStockContract.setCompanyInfo(companyInfo) ;
        ProviderInfo providerInfo = baseService.load(optStockContract.getProviderInfoId(), ProviderInfo.class) ;
        optStockContract.setProviderInfo(providerInfo) ;

    }

}
