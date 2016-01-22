package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockContractDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockContractDetailService ;
import cn.zying.osales.units.search.bean.StockContractDetailSearchBean ;

@Component(IAopStockContractDetailService.name)
public class AopStockContractDetailService implements IAopStockContractDetailService {

    @Autowired
    @Qualifier(IStockContractDetailService.name)
    private IStockContractDetailService iStockContractDetailService ;

    public StockContractDetail saveUpdate(OptType optType, StockContractDetail optStockContractDetail) throws SystemOptServiceException {

        return iStockContractDetailService.saveUpdate(optType, optStockContractDetail) ;

    }

    public SelectPage<StockContractDetail> search(OptType optType, StockContractDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockContractDetailService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockContractDetail> searchList(OptType optType, StockContractDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockContractDetailService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StockContractDetail remove(OptType optType, StockContractDetail optStockContractDetail) throws SystemOptServiceException {

        return iStockContractDetailService.remove(optType, optStockContractDetail) ;

    }

    public StockContractDetail get(Integer id) throws SystemOptServiceException {
        return iStockContractDetailService.get(id) ;

    }

}
