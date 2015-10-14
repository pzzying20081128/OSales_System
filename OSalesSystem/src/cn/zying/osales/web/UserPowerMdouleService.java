package cn.zying.osales.web ;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.powers.IUserPowerMdouleService ;
import cn.zy.apps.tools.units.powers.UserOptPower ;
import cn.zy.apps.tools.units.powers.UserPower ;
import cn.zying.osales.MeunsTree ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.pojos.SystemUserOptPower ;
import cn.zying.osales.pojos.SystemUserPower ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.sysmanage.ISystemUserService ;

@Component("IUserPowerMdouleService")
public class UserPowerMdouleService extends ABCommonsService implements IUserPowerMdouleService {

    @Autowired
    @Qualifier(ISystemUserService.aop_name)
    private ISystemUserService systemUserService ;

    @Override
    public String[][] getInitTreeMeuns() {

        return MeunsTree.initTreeDatas() ;
    }

    @Override
    public List<String> listUserModulePowerBySysUserId(String loginUserId) throws Exception {

        return systemUserService.listUserModulePowerBySysUserId(loginUserId) ;
    }

    @Override
    public List<UserPower<UserOptPower>> searchUserPower(String moduleId, String loginUserId) throws Exception {

        return systemUserService.searchUserPower(moduleId, loginUserId) ;
    }

}
