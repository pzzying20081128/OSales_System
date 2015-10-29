package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockOrderDetailService ;
import cn.zying.osales.units.search.bean.StockOrderDetailSearchBean ;

@Component(IAopStockOrderDetailService.name)
public class AopStockOrderDetailService implements IAopStockOrderDetailService {

    @Autowired
    @Qualifier(IStockOrderDetailService.name)
    private IStockOrderDetailService iStockOrderDetailService ;

    public StockOrderDetail saveUpdate(OptType optType, StockOrderDetail optStockOrderDetail) throws SystemOptServiceException {

        return iStockOrderDetailService.saveUpdate(optType, optStockOrderDetail) ;

    }

    public SelectPage<StockOrderDetail> search(OptType optType, StockOrderDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockOrderDetailService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockOrderDetail> searchList(OptType optType, StockOrderDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockOrderDetailService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StockOrderDetail remove(OptType optType, StockOrderDetail optStockOrderDetail) throws SystemOptServiceException {

        return iStockOrderDetailService.remove(optType, optStockOrderDetail) ;

    }

    public StockOrderDetail get(Integer id) throws SystemOptServiceException {
        return iStockOrderDetailService.get(id) ;

    }

}
