package cn.zying.osales.service.stocks.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockReturnService ;
import cn.zying.osales.service.stocks.units.StockReturnCheckUnits ;
import cn.zying.osales.service.stocks.units.StockReturnRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockReturnSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockReturnSearchUnits ;
import cn.zying.osales.units.search.bean.StockReturnSearchBean ;

@Component(IStockReturnService.name)
public class StockReturnServiceImple extends ABCommonsService implements IStockReturnService {

    //@Resource(name="StockReturnSearchUnits")
    @Autowired
    @Qualifier("StockReturnSearchUnits")
    private StockReturnSearchUnits iStockReturnSearchUnits ;

    @Autowired
    @Qualifier("StockReturnCheckUnits")
    private StockReturnCheckUnits iStockReturnCheckUnits ;

    //@Resource(name=" StockReturnSaveUpdateUnits")
    @Autowired
    @Qualifier("StockReturnSaveUpdateUnits")
    private StockReturnSaveUpdateUnits iStockReturnSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockReturnRemoveUnits")
    private StockReturnRemoveUnits iStockReturnRemoveUnits ;

    @Override
    public StockReturn saveUpdate(OptType optType, StockReturn optStockReturn, int optUserId) throws SystemOptServiceException {
        optStockReturn.setRecordManId(optUserId) ;
        return iStockReturnSaveUpdateUnits.saveUpdate(optType, optStockReturn) ;
    }

    @Override
    public SelectPage<StockReturn> search(OptType optType, StockReturnSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockReturnSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StockReturn> searchList(OptType optType, StockReturnSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockReturnSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StockReturn remove(OptType optType, StockReturn optStockReturn) throws SystemOptServiceException {
        return iStockReturnRemoveUnits.remove(optType, optStockReturn) ;
    }

    @Override
    public StockReturn get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockReturn.class) ;
    }

    @Override
    public void check(Integer stockReturnId, int optUser) throws SystemOptServiceException {
        iStockReturnCheckUnits.check(stockReturnId, optUser) ;

    }

}
