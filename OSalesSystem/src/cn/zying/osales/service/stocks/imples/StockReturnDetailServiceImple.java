package cn.zying.osales.service.stocks.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockReturnDetailService ;
import cn.zying.osales.service.stocks.units.StockReturnDetailRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockReturnDetailSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockReturnDetailSearchUnits ;
import cn.zying.osales.units.search.bean.StockReturnDetailSearchBean ;

@Component(IStockReturnDetailService.name)
public class StockReturnDetailServiceImple extends ABCommonsService implements IStockReturnDetailService {

    //@Resource(name="StockReturnDetailSearchUnits")
    @Autowired
    @Qualifier("StockReturnDetailSearchUnits")
    private StockReturnDetailSearchUnits iStockReturnDetailSearchUnits ;

    //@Resource(name=" StockReturnDetailSaveUpdateUnits")
    @Autowired
    @Qualifier("StockReturnDetailSaveUpdateUnits")
    private StockReturnDetailSaveUpdateUnits iStockReturnDetailSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockReturnDetailRemoveUnits")
    private StockReturnDetailRemoveUnits iStockReturnDetailRemoveUnits ;

    @Override
    public StockReturnDetail saveUpdate(OptType optType, StockReturnDetail optStockReturnDetail) throws SystemOptServiceException {
        return iStockReturnDetailSaveUpdateUnits.saveUpdate(optType, optStockReturnDetail) ;
    }

    @Override
    public SelectPage<StockReturnDetail> search(OptType optType, StockReturnDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockReturnDetailSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StockReturnDetail> searchList(OptType optType, StockReturnDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockReturnDetailSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StockReturnDetail remove(OptType optType, StockReturnDetail optStockReturnDetail) throws SystemOptServiceException {
        return iStockReturnDetailRemoveUnits.remove(optType, optStockReturnDetail) ;
    }

    @Override
    public StockReturnDetail get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockReturnDetail.class) ;
    }

}
