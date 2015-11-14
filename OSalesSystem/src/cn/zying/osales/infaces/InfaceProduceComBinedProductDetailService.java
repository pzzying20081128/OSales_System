package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProductDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProduceComBinedProductDetailSearchBean ;

public interface InfaceProduceComBinedProductDetailService {

    /**
          *  增加或更新
          */
    public ProduceComBinedProductDetail saveUpdate(OptType optType, ProduceComBinedProductDetail optProduceComBinedProductDetail) throws SystemOptServiceException ;

    public SelectPage<ProduceComBinedProductDetail> search(OptType optType, ProduceComBinedProductDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<ProduceComBinedProductDetail> searchList(OptType optType, ProduceComBinedProductDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public ProduceComBinedProductDetail remove(OptType optType, ProduceComBinedProductDetail optProduceComBinedProductDetail) throws SystemOptServiceException ;

    public ProduceComBinedProductDetail get(Integer id) throws SystemOptServiceException ;

}
