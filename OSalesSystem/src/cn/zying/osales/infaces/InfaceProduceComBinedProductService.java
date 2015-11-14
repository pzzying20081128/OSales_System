package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProduct ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProduceComBinedProductSearchBean ;

public interface InfaceProduceComBinedProductService {

    /**
          *  增加或更新
          */
    public ProduceComBinedProduct saveUpdate(OptType optType, ProduceComBinedProduct optProduceComBinedProduct) throws SystemOptServiceException ;

    public SelectPage<ProduceComBinedProduct> search(OptType optType, ProduceComBinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<ProduceComBinedProduct> searchList(OptType optType, ProduceComBinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public ProduceComBinedProduct remove(OptType optType, ProduceComBinedProduct optProduceComBinedProduct) throws SystemOptServiceException ;

    public ProduceComBinedProduct get(Integer id) throws SystemOptServiceException ;
    
    public  void check(Integer uuid, Integer oSalsesLoginUserId) throws SystemOptServiceException ;

}
