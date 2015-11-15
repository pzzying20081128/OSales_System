package cn.zying.osales.service.baseinfo.imples ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysGridConfigs ;
import cn.zying.osales.pojos.UserGridConfigs ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ISysGridConfigsService ;

@Component(ISysGridConfigsService.name)
public class SysGridConfigsServiceImple extends ABCommonsService implements ISysGridConfigsService {

    public static SysGridConfigs init(UserGridConfigs userGridConfigs) {
        SysGridConfigs sysGridConfigs = new SysGridConfigs() ;
        sysGridConfigs.setIsExcelExPorts(OSalesConfigProperties.isDefault_0) ;
        sysGridConfigs.setIsPrint(OSalesConfigProperties.isDefault_0) ;
        sysGridConfigs.setIstotal(OSalesConfigProperties.isDefault_0) ;
        sysGridConfigs.setColName(userGridConfigs.getColName()) ;
        sysGridConfigs.setColDataIndex(userGridConfigs.getColDataIndex()) ;
        sysGridConfigs.setModuleKey(userGridConfigs.getModuleKey()) ;
        sysGridConfigs.setModuleName(userGridConfigs.getModuleName()) ;
        sysGridConfigs.setPrintName(userGridConfigs.getColName()) ;
        return sysGridConfigs ;

    }

    /**
     *  -1 没有  0:有
     * @param sysGridConfigOld
     * @param sysGridConfigIn
     * @return
     * @throws SystemOptServiceException
     */
    private SysGridConfigs isHave(SysGridConfigs sysGridConfigOld, List<SysGridConfigs> sysGridConfigIn) throws SystemOptServiceException {
        for (SysGridConfigs sysGridConfigIn_ : sysGridConfigIn) {
            if (sysGridConfigIn_.getColName().equals(sysGridConfigOld.getColName())) return sysGridConfigIn_ ;
        }
        return null ;
    }

    private void addNoHave(String modulekey, List<SysGridConfigs> sysGridConfigs, List<SysGridConfigs> sysGridConfigIn) throws SystemOptServiceException {
        boolean isHave = false ;
        for (SysGridConfigs sysGridConfigIn_ : sysGridConfigIn) {
            isHave = false ;
            for (SysGridConfigs sysGridConfig : sysGridConfigs) {
                if (sysGridConfig.getColName().equals(sysGridConfigIn_.getColName())) isHave = true ;
            }

            if (isHave == false) {
                baseService.save(sysGridConfigIn_) ;
            }
        }
    }

    @Override
    public void addUpdate(String modulekey, List<SysGridConfigs> sysGridConfig) throws SystemOptServiceException {

        String sql = "select sysGridConfig    from  SysGridConfigs as    sysGridConfig  " +

        "  where sysGridConfig.moduleName ='" + modulekey + "'  " ;

        List<SysGridConfigs> sysGridConfigs = baseService.findByHSQL(sql) ;

        for (SysGridConfigs sysGridConfig_ : sysGridConfigs) {
            SysGridConfigs result = isHave(sysGridConfig_, sysGridConfig) ;
            if (result == null) {
                baseService.remove(sysGridConfig_) ;
            } else {
                ToolsUnits.copyBeanProperties(sysGridConfig_, result, "colName", "colDataIndex") ;
            }
        }
        addNoHave(modulekey, sysGridConfigs, sysGridConfig) ;
    }

    @Override
    public List<SysGridConfigs> search(String name, int... startSize) throws SystemOptServiceException {
        String sql = "select  sysGridConfigs  from  SysGridConfigs as sysGridConfigs  where sysGridConfigs.moduleName like (:name) " ;
        Map<String, Object> value = ToolsUnits.createSearchMap() ;
        if (ToolsUnits.isNOtNulll(name)) value.put("name", "%" + name + "%") ;
        else
            value.put("name", "%%") ;
        return baseService.findByHSQL(sql, value, startSize) ;
    }

    @Override
    public SelectPage<SysGridConfigs> search(String moduleKey, CommSearchBean commSearchBean) throws SystemOptServiceException {

        String sql = "select  sysGridConfigs  from  SysGridConfigs as sysGridConfigs  where sysGridConfigs.moduleKey like (:moduleKey)   " +

        "   order by case when  sysGridConfigs."+commSearchBean.getSort()+"  is  NULL   then 0 else 1 end desc,   sysGridConfigs."+commSearchBean.getSort() +"   "+commSearchBean.getDir() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;
        if (ToolsUnits.isNOtNulll(name)) value.put("moduleKey", "%" + moduleKey + "%") ;
        else
            value.put("moduleKey", "%%") ;

        List<SysGridConfigs> result = baseService.findByHSQL(sql, value) ;

        SelectPage<SysGridConfigs> selectPage = new SelectPage<SysGridConfigs>() ;
        selectPage.setCount((long) result.size()) ;
        selectPage.setResult(result) ;
        return selectPage ;
    }

    @Override
    public SysGridConfigs get(Integer id) throws SystemOptServiceException {

        SysGridConfigs sysGridConfigs = baseService.get(id, SysGridConfigs.class) ;

        return sysGridConfigs ;
    }

    @Override
    public SysGridConfigs saveUpdate(OptType optype, SysGridConfigs sysGridConfigs) throws SystemOptServiceException {

        switch (optype) {
        case update: {
            SysGridConfigs old = baseService.get(SysGridConfigs.class, sysGridConfigs.getId()) ;
            ToolsUnits.copyBeanProperties(old, sysGridConfigs, "printName", "colIndex", "isPrint", "istotal", "isExcelExPorts") ;
            baseService.update(old) ;
            return old ;
        }

        default:
            break ;
        }

        return null ;
    }

}
