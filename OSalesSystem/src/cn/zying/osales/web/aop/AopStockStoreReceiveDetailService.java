package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockStoreReceiveDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockStoreReceiveDetailService ;
import cn.zying.osales.units.search.bean.StockStoreReceiveDetailSearchBean ;

@Component(IAopStockStoreReceiveDetailService.name)
public class AopStockStoreReceiveDetailService implements IAopStockStoreReceiveDetailService {

    @Autowired
    @Qualifier(IStockStoreReceiveDetailService.name)
    private IStockStoreReceiveDetailService iStockStoreReceiveDetailService ;

    public StockStoreReceiveDetail saveUpdate(OptType optType, StockStoreReceiveDetail optStockStoreReceiveDetail) throws SystemOptServiceException {

        return iStockStoreReceiveDetailService.saveUpdate(optType, optStockStoreReceiveDetail) ;

    }

    public SelectPage<StockStoreReceiveDetail> search(OptType optType, StockStoreReceiveDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockStoreReceiveDetailService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockStoreReceiveDetail> searchList(OptType optType, StockStoreReceiveDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockStoreReceiveDetailService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StockStoreReceiveDetail remove(OptType optType, StockStoreReceiveDetail optStockStoreReceiveDetail) throws SystemOptServiceException {

        return iStockStoreReceiveDetailService.remove(optType, optStockStoreReceiveDetail) ;

    }

    public StockStoreReceiveDetail get(Integer id) throws SystemOptServiceException {
        return iStockStoreReceiveDetailService.get(id) ;

    }

}
