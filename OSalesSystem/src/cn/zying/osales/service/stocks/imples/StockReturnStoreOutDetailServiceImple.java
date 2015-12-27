package cn.zying.osales.service.stocks.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnStoreOutDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockReturnStoreOutDetailService ;
import cn.zying.osales.service.stocks.units.StockReturnStoreOutDetailRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockReturnStoreOutDetailSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockReturnStoreOutDetailSearchUnits ;
import cn.zying.osales.units.search.bean.StockReturnStoreOutDetailSearchBean ;

@Component(IStockReturnStoreOutDetailService.name)
public class StockReturnStoreOutDetailServiceImple extends ABCommonsService implements IStockReturnStoreOutDetailService {

    //@Resource(name="StockReturnStoreOutDetailSearchUnits")
    @Autowired
    @Qualifier("StockReturnStoreOutDetailSearchUnits")
    private StockReturnStoreOutDetailSearchUnits iStockReturnStoreOutDetailSearchUnits ;

    //@Resource(name=" StockReturnStoreOutDetailSaveUpdateUnits")
    @Autowired
    @Qualifier("StockReturnStoreOutDetailSaveUpdateUnits")
    private StockReturnStoreOutDetailSaveUpdateUnits iStockReturnStoreOutDetailSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockReturnStoreOutDetailRemoveUnits")
    private StockReturnStoreOutDetailRemoveUnits iStockReturnStoreOutDetailRemoveUnits ;

    @Override
    public StockReturnStoreOutDetail saveUpdate(OptType optType, StockReturnStoreOutDetail optStockReturnStoreOutDetail) throws SystemOptServiceException {
        return iStockReturnStoreOutDetailSaveUpdateUnits.saveUpdate(optType, optStockReturnStoreOutDetail) ;
    }

    @Override
    public SelectPage<StockReturnStoreOutDetail> search(OptType optType, StockReturnStoreOutDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockReturnStoreOutDetailSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StockReturnStoreOutDetail> searchList(OptType optType, StockReturnStoreOutDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockReturnStoreOutDetailSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StockReturnStoreOutDetail remove(OptType optType, StockReturnStoreOutDetail optStockReturnStoreOutDetail) throws SystemOptServiceException {
        return iStockReturnStoreOutDetailRemoveUnits.remove(optType, optStockReturnStoreOutDetail) ;
    }

    @Override
    public StockReturnStoreOutDetail get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockReturnStoreOutDetail.class) ;
    }

}
