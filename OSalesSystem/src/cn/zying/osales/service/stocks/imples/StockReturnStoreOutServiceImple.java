package cn.zying.osales.service.stocks.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockReturnStoreOutService ;
import cn.zying.osales.service.stocks.units.StockReturnStoreOutCheckUnits ;
import cn.zying.osales.service.stocks.units.StockReturnStoreOutRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockReturnStoreOutSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockReturnStoreOutSearchUnits ;
import cn.zying.osales.units.search.bean.StockReturnStoreOutSearchBean ;

@Component(IStockReturnStoreOutService.name)
public class StockReturnStoreOutServiceImple extends ABCommonsService implements IStockReturnStoreOutService {

    //@Resource(name="StockReturnStoreOutSearchUnits")
    @Autowired
    @Qualifier("StockReturnStoreOutSearchUnits")
    private StockReturnStoreOutSearchUnits iStockReturnStoreOutSearchUnits ;

    //@Resource(name=" StockReturnStoreOutSaveUpdateUnits")
    @Autowired
    @Qualifier("StockReturnStoreOutSaveUpdateUnits")
    private StockReturnStoreOutSaveUpdateUnits iStockReturnStoreOutSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockReturnStoreOutRemoveUnits")
    private StockReturnStoreOutRemoveUnits iStockReturnStoreOutRemoveUnits ;
    
    @Autowired
    @Qualifier("StockReturnStoreOutCheckUnits")
    private StockReturnStoreOutCheckUnits  iStockReturnStoreOutCheckUnits;

    @Override
    public StockReturnStoreOut saveUpdate(OptType optType, StockReturnStoreOut optStockReturnStoreOut) throws SystemOptServiceException {
        return iStockReturnStoreOutSaveUpdateUnits.saveUpdate(optType, optStockReturnStoreOut) ;
    }

    @Override
    public SelectPage<StockReturnStoreOut> search(OptType optType, StockReturnStoreOutSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockReturnStoreOutSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StockReturnStoreOut> searchList(OptType optType, StockReturnStoreOutSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockReturnStoreOutSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StockReturnStoreOut remove(OptType optType, StockReturnStoreOut optStockReturnStoreOut) throws SystemOptServiceException {
        return iStockReturnStoreOutRemoveUnits.remove(optType, optStockReturnStoreOut) ;
    }

    @Override
    public StockReturnStoreOut get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockReturnStoreOut.class) ;
    }

    @Override
    public void check(  Integer id  , Integer oSalsesLoginUserId) throws SystemOptServiceException {
        iStockReturnStoreOutCheckUnits.check(id, oSalsesLoginUserId);
        
    }

}
