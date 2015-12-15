package cn.zying.osales.service.baseinfo.imples ;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.pojos.SysGridConfigs ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.pojos.UserGridConfigs ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ISysGridConfigsService ;
import cn.zying.osales.service.baseinfo.ISystemGridColConfigService ;

@Component(ISystemGridColConfigService.name)
public class SystemGridColConfigService extends ABCommonsService implements ISystemGridColConfigService {

    @Autowired
    @Qualifier(ISysGridConfigsService.name)
    private ISysGridConfigsService sysGridConfigsService ;

    @Override
    public void saveUserGridConfigs(String moduleName, String module_key, String data_indexs, String col_names, String col_hiddens, String col_widths, String col_indexs, Integer optUser) throws SystemOptServiceException {

        String del = "DELETE  FROM UserGridConfigs as  userGridConfigs  " +

        " where  userGridConfigs.moduleName='" + module_key + "'   and    userGridConfigs.systemUserId=" + optUser ;

        baseService.executeByHSQL(del) ;

        String[] data_index = data_indexs.split(";") ;
        String[] col_name = col_names.split(";") ;
        String[] col_hidden = col_hiddens.split(";") ;
        String[] col_width = col_widths.split(";") ;
        String[] col_index = col_indexs.split(";") ;

        List<SysGridConfigs> sysGridConfigs = new ArrayList<SysGridConfigs>() ;

        for (int i = 0; i < data_index.length; i++) {
            String data_index_ = data_index[i] ;
            String col_name_ = col_name[i] ;
            String col_hidden_ = col_hidden[i] ;
            String col_width_ = col_width[i] ;
            Integer col_index_ = Integer.parseInt(col_index[i]) ;
            SysStaffUser systemUser = baseService.load(optUser, SysStaffUser.class) ;
            UserGridConfigs ugh = new UserGridConfigs() ;
            ugh.setModuleName(moduleName) ;
            ugh.setModuleKey(module_key) ;
            ugh.setColName(col_name_) ;
            ugh.setColDataIndex(data_index_) ;
            ugh.setSystemUserId(optUser) ;
            ugh.setColIndex(col_index_) ;
            ugh.setHidden(Integer.parseInt(col_hidden_)) ;
            ugh.setColWidth(ToolsUnits.isNOtNulll(col_width_) ? Integer.parseInt(col_width_) : 200) ;
            ugh.setSystemUser(systemUser) ;
            baseService.save(ugh) ;
            SysGridConfigs sysGridConfig = SysGridConfigsServiceImple.init(ugh) ;
            sysGridConfig.setColIndex(i) ;
            sysGridConfigs.add(sysGridConfig) ;
        }
        sysGridConfigsService.addUpdate(module_key, sysGridConfigs) ;
    }

    public List<UserGridConfigs> find(String module_name, int user_id) throws SystemOptServiceException {
        String sql = "FROM UserGridConfigs where moduleName=:moduleName  and systemUserId=:systemUserId   order by  colIndex   " ;
        Map<String, Object> values = new HashMap<String, Object>() ;
        values.put("moduleName", module_name) ;
        values.put("systemUserId", user_id) ;
        return this.baseService.findByHSQL(sql, values) ;

    }

}
