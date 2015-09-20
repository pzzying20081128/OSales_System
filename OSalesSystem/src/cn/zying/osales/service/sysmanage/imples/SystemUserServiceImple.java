package cn.zying.osales.service.sysmanage.imples ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;

import cn.zying.osales.pojos.SystemUser ;

import cn.zying.osales.service.sysmanage.ISystemUserService ;

import cn.zying.osales.service.sysmanage.units.SystemUserSearchBean ;

import cn.zying.osales.OSalesConfigProperties.OptType ;

import cn.zying.osales.service.ABCommonsService ;

import cn.zying.osales.service.SystemOptServiceException ;

@Component(ISystemUserService.name)
public class SystemUserServiceImple extends ABCommonsService implements ISystemUserService {

    @Override
    public void saveUpdate(OptType optType, SystemUser optSystemUser) throws SystemOptServiceException {

    }

    @Override
    public SelectPage<SystemUser> search(OptType optType, SystemUserSearchBean searchBean) throws SystemOptServiceException {

    }

    @Override
    public void remove(OptType optType, SystemUser optSystemUser) throws SystemOptServiceException {

    }

}
