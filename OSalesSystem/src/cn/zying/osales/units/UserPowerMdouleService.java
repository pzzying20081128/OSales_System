package cn.zying.osales.units ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.powers.IUserPowerMdouleService ;
import cn.zy.apps.tools.units.powers.UserOptPower ;
import cn.zy.apps.tools.units.powers.UserPower ;
import cn.zying.osales.MeunsTree ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.web.aop.IAopSystemUserService ;

@Component("IUserPowerMdouleService")
public class UserPowerMdouleService extends ABCommonsService implements IUserPowerMdouleService {

    @Autowired
    @Qualifier(IAopSystemUserService.aop_name)
    private IAopSystemUserService systemUserService ;

    @Override
    public String[][] getInitTreeMeuns() {

        return MeunsTree.initTreeDatas() ;
    }

    @Override
    public List<String> listUserModulePowerBySysUserId(String loginUserId) throws Exception {

        return systemUserService.listUserModulePowerBySysUserId(Integer.parseInt (loginUserId )) ;
    }

    @Override
    public List<UserPower<UserOptPower>> searchUserPower(String moduleId, String loginUserId) throws Exception {

        return systemUserService.searchUserPower(moduleId, Integer.parseInt (loginUserId )) ;
    }

}
