package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StorePositionSearchBean ;

public interface InfaceStorePositionService {

    /**
          *  增加或更新
          */
    public StorePosition saveUpdate(OptType optType, StorePosition optStorePosition) throws SystemOptServiceException ;

    public SelectPage<StorePosition> search(OptType optType, StorePositionSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StorePosition> searchList(OptType optType, StorePositionSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StorePosition remove(OptType optType, StorePosition optStorePosition) throws SystemOptServiceException ;

    public StorePosition get(Integer id) throws SystemOptServiceException ;

}
