package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockReturnDetailService ;
import cn.zying.osales.units.search.bean.StockReturnDetailSearchBean ;

@Component(IAopStockReturnDetailService.name)
public class AopStockReturnDetailService implements IAopStockReturnDetailService {

    @Autowired
    @Qualifier(IStockReturnDetailService.name)
    private IStockReturnDetailService iStockReturnDetailService ;

    public StockReturnDetail saveUpdate(OptType optType, StockReturnDetail optStockReturnDetail) throws SystemOptServiceException {

        return iStockReturnDetailService.saveUpdate(optType, optStockReturnDetail) ;

    }

    public SelectPage<StockReturnDetail> search(OptType optType, StockReturnDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockReturnDetailService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockReturnDetail> searchList(OptType optType, StockReturnDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockReturnDetailService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StockReturnDetail remove(OptType optType, StockReturnDetail optStockReturnDetail) throws SystemOptServiceException {

        return iStockReturnDetailService.remove(optType, optStockReturnDetail) ;

    }

    public StockReturnDetail get(Integer id) throws SystemOptServiceException {
        return iStockReturnDetailService.get(id) ;

    }

}
