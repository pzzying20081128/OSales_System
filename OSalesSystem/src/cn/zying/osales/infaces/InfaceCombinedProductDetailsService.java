package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CombinedProductDetails ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.CombinedProductDetailsSearchBean ;

public interface InfaceCombinedProductDetailsService {

    /**
          *  增加或更新
          */
    public CombinedProductDetails saveUpdate(OptType optType, CombinedProductDetails optCombinedProductDetails) throws SystemOptServiceException ;

    public SelectPage<CombinedProductDetails> search(OptType optType, CombinedProductDetailsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<CombinedProductDetails> searchList(OptType optType, CombinedProductDetailsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public CombinedProductDetails remove(OptType optType, CombinedProductDetails optCombinedProductDetails) throws SystemOptServiceException ;

    public CombinedProductDetails get(Integer id) throws SystemOptServiceException ;

}
