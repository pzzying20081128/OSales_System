package cn.zying.osales.service.basemanage.units ;

import java.util.List ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StaffInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StaffInfoSearchUnits")
public class StaffInfoSearchUnits extends ABCommonsService {

    public SelectPage<StaffInfo> search(OptType optType, StaffInfoSearchBean searchBean) throws SystemOptServiceException {
        SelectPage<StaffInfo> selectPage = new SelectPage<StaffInfo>() ;

        List<StaffInfo> result = list(searchBean) ;

        Long sum = sum(searchBean) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    private List<StaffInfo> list(StaffInfoSearchBean searchBean) throws SystemOptServiceException {

    }

    private Long sum(StaffInfoSearchBean searchBean) throws SystemOptServiceException {

    }

}
