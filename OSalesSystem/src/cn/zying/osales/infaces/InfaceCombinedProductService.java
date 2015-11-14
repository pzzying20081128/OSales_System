package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CombinedProduct ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.CombinedProductSearchBean ;

public interface InfaceCombinedProductService {

    /**
          *  增加或更新
          */
    public CombinedProduct saveUpdate(OptType optType, CombinedProduct optCombinedProduct) throws SystemOptServiceException ;

    public SelectPage<CombinedProduct> search(OptType optType, CombinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<CombinedProduct> searchList(OptType optType, CombinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public CombinedProduct remove(OptType optType, CombinedProduct optCombinedProduct) throws SystemOptServiceException ;

    public CombinedProduct get(Integer id) throws SystemOptServiceException ;

    public void check(Integer uuid, Integer checkManId) throws SystemOptServiceException ;

}
