package cn.zying.osales.service.baseinfo ;

import java.util.List ;

import cn.zying.osales.pojos.UserGridConfigs ;
import cn.zying.osales.service.SystemOptServiceException ;

public interface ISystemGridColConfigService {

    public String name = "ISystemGridColConfigService" ;

    /**
     * String data_indexs ; private String col_names ; private String
     * col_hiddens ; private String col_widths ;
     * 
     * @throws OptServiceException
     */
    public void saveUserGridConfigs(String moduleName, String module_key, String data_indexs, String col_names, String col_hiddens, String col_widths, String col_indexs, Integer optUser) throws SystemOptServiceException ;

    public List<UserGridConfigs> find(String module_name, int user_id) throws SystemOptServiceException ;

}
