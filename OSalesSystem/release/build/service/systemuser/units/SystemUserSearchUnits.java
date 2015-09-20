package  cn.zying.osales.service.sysmanage.units ;

import java.util.List ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;

import cn.zying.osales.pojos.SystemUser ; 
import cn.zying.osales.service.ABCommonsService ;


@Component("SystemUserUnits")
public class SystemUserSearchUnits extends ABCommonsService {

    public SelectPage<SystemUser> search(OptType optType,SystemUserSearchBean searchBean) throws SystemOptServiceException {
        SelectPage<SystemUser> selectPage = new SelectPage<SystemUser>() ;

        List<SystemUser> result = list(searchBean) ;

        Long sum = sum(searchBean) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    private List<SystemUser> list(SystemUserSearchBean searchBean) throws SystemOptServiceException {

    }

    private Long sum(SystemUserSearchBean searchBean) throws SystemOptServiceException {

    }

}
