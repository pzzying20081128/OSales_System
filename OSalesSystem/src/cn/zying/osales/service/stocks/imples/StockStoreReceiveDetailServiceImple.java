package cn.zying.osales.service.stocks.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockStoreReceiveDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockStoreReceiveDetailService ;
import cn.zying.osales.service.stocks.units.StockStoreReceiveDetailRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockStoreReceiveDetailSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockStoreReceiveDetailSearchUnits ;
import cn.zying.osales.units.search.bean.StockStoreReceiveDetailSearchBean ;

@Component(IStockStoreReceiveDetailService.name)
public class StockStoreReceiveDetailServiceImple extends ABCommonsService implements IStockStoreReceiveDetailService {

    //@Resource(name="StockStoreReceiveDetailSearchUnits")
    @Autowired
    @Qualifier("StockStoreReceiveDetailSearchUnits")
    private StockStoreReceiveDetailSearchUnits iStockStoreReceiveDetailSearchUnits ;

    //@Resource(name=" StockStoreReceiveDetailSaveUpdateUnits")
    @Autowired
    @Qualifier("StockStoreReceiveDetailSaveUpdateUnits")
    private StockStoreReceiveDetailSaveUpdateUnits iStockStoreReceiveDetailSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockStoreReceiveDetailRemoveUnits")
    private StockStoreReceiveDetailRemoveUnits iStockStoreReceiveDetailRemoveUnits ;

    @Override
    public StockStoreReceiveDetail saveUpdate(OptType optType, StockStoreReceiveDetail optStockStoreReceiveDetail) throws SystemOptServiceException {
        return iStockStoreReceiveDetailSaveUpdateUnits.saveUpdate(optType, optStockStoreReceiveDetail) ;
    }

    @Override
    public SelectPage<StockStoreReceiveDetail> search(OptType optType, StockStoreReceiveDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockStoreReceiveDetailSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StockStoreReceiveDetail> searchList(OptType optType, StockStoreReceiveDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockStoreReceiveDetailSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StockStoreReceiveDetail remove(OptType optType, StockStoreReceiveDetail optStockStoreReceiveDetail) throws SystemOptServiceException {
        return iStockStoreReceiveDetailRemoveUnits.remove(optType, optStockStoreReceiveDetail) ;
    }

    @Override
    public StockStoreReceiveDetail get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockStoreReceiveDetail.class) ;
    }

}
