package cn.zying.osales.historys ;

import cn.zy.apps.tools.history.IRegisterHistory ;
import cn.zy.apps.tools.history.RegisterHistoryInfo.HistoryType ;
import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zy.apps.tools.units.DateToolsUilts ;

public abstract class ABBaseRegisterHistory implements IRegisterHistory {

    protected  org.apache.log4j.Logger logger = Loggerfactory.instance(ABBaseRegisterHistory.class) ;



    @Override
    public void register(HistoryType historyType, String classification, String module, String operate, String desc, Object tagetObject, String loginUserAttrIndex, Object... args) {
        Loggerfactory.error(logger, "reg  history   classification   : " + classification+"  module  "+module+"   operate "+operate+"  desc  "+desc+"   "+tagetObject.getClass()) ;
        try {
            Integer loginSysUserId = (Integer) args[Integer.parseInt(loginUserAttrIndex)] ;
            regUserlastOptTime(loginSysUserId, args) ;
            abRegister(historyType, classification, module, operate, desc, loginSysUserId, args) ;
        } catch (Exception e) {
            Loggerfactory.error(logger, e.getMessage(), e) ;
        }
    }

    private void regUserlastOptTime(Integer loginSysUserId, Object... args) {
        Loggerfactory.info(logger, "reg  user  last  opt  time   :  " + loginSysUserId + "   " + DateToolsUilts.getnowDate().toLocaleString()) ;

        //            try {
        //                Loggerfactory.info(logger, "reg  user  last  opt  time   :  " + loginSysUserId) ;
        //                systemUserOnlineService.regOptTime(loginSysUserId) ;
        //            } catch (OptServiceException e) {
        //                Loggerfactory.error(logger, e.getMessage(), e) ;
        //            }
    }

    public void abRegister(HistoryType historyType, String classification, String module, String operate, String desc, Integer loginSysUserId, Object... args) {
  
        switch (historyType) {
        case after:
            optafter(module, operate, desc, loginSysUserId, args) ;
            break ;

        case before:
            optbefore( module, operate, desc, loginSysUserId, args) ;
            break ;

        case exception:
            optexception( module, operate, desc, loginSysUserId, args) ;
            break ;

        }
        

    }

    protected void optafter( String module, String operate, String desc, Integer loginSysUserId, Object... args) {

    }

    protected void optbefore( String module, String operate, String desc, Integer loginSysUserId, Object... args) {

    }

    protected void optexception( String module, String operate, String desc, Integer loginSysUserId, Object... args) {

    }
}
