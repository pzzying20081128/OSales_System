package cn.zying.osales.service ;

import cn.zy.apps.tools.jpa.IERPBaseService ;

public interface IABService extends IERPBaseService {

    public String name = "IABService" ;

    public String genSerialNum(String prefix) ;

}
