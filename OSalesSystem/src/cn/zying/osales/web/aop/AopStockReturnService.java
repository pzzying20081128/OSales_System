package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockReturnService ;
import cn.zying.osales.units.search.bean.StockReturnSearchBean ;

@Component(IAopStockReturnService.name)
public class AopStockReturnService implements IAopStockReturnService {

    @Autowired
    @Qualifier(IStockReturnService.name)
    private IStockReturnService iStockReturnService ;

    public StockReturn saveUpdate(OptType optType, StockReturn optStockReturn, int optUserId) throws SystemOptServiceException {

        return iStockReturnService.saveUpdate(optType, optStockReturn, optUserId) ;

    }

    public SelectPage<StockReturn> search(OptType optType, StockReturnSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockReturnService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockReturn> searchList(OptType optType, StockReturnSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockReturnService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StockReturn remove(OptType optType, StockReturn optStockReturn) throws SystemOptServiceException {

        return iStockReturnService.remove(optType, optStockReturn) ;

    }

    public StockReturn get(Integer id) throws SystemOptServiceException {
        return iStockReturnService.get(id) ;

    }

}
