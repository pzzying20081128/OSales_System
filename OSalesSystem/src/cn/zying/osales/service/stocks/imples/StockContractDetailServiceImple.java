package cn.zying.osales.service.stocks.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockContractDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockContractDetailService ;
import cn.zying.osales.service.stocks.units.StockContractDetailRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockContractDetailSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockContractDetailSearchUnits ;
import cn.zying.osales.units.search.bean.StockContractDetailSearchBean ;

@Component(IStockContractDetailService.name)
public class StockContractDetailServiceImple extends ABCommonsService implements IStockContractDetailService {

    //@Resource(name="StockContractDetailSearchUnits")
    @Autowired
    @Qualifier("StockContractDetailSearchUnits")
    private StockContractDetailSearchUnits iStockContractDetailSearchUnits ;

    //@Resource(name=" StockContractDetailSaveUpdateUnits")
    @Autowired
    @Qualifier("StockContractDetailSaveUpdateUnits")
    private StockContractDetailSaveUpdateUnits iStockContractDetailSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockContractDetailRemoveUnits")
    private StockContractDetailRemoveUnits iStockContractDetailRemoveUnits ;

    @Override
    public StockContractDetail saveUpdate(OptType optType, StockContractDetail optStockContractDetail) throws SystemOptServiceException {
        return iStockContractDetailSaveUpdateUnits.saveUpdate(optType, optStockContractDetail) ;
    }

    @Override
    public SelectPage<StockContractDetail> search(OptType optType, StockContractDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockContractDetailSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StockContractDetail> searchList(OptType optType, StockContractDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockContractDetailSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StockContractDetail remove(OptType optType, StockContractDetail optStockContractDetail) throws SystemOptServiceException {
        return iStockContractDetailRemoveUnits.remove(optType, optStockContractDetail) ;
    }

    @Override
    public StockContractDetail get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockContractDetail.class) ;
    }

}
