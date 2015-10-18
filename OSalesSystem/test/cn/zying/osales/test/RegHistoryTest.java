package cn.zying.osales.test;

import org.junit.Test ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysOptHistory ;
import cn.zying.osales.service.baseinfo.ISysOptHistoryService ;

public class RegHistoryTest extends ABSalesJUnitSping4Texts {

    
    @Autowired
    @Qualifier(ISysOptHistoryService.name)
    private ISysOptHistoryService sysOptHistoryService;
    
    @Test
    public  void save()throws Exception{
        SysOptHistory sysOptHistory =new SysOptHistory();
        sysOptHistory.setClassification(OSalesConfigProperties.classification_base_info);
        sysOptHistory.setModule(OSalesConfigProperties.classification_base_info_module_base_info_sys_staff);
        sysOptHistory.setOptTime(DateToolsUilts.getnowDate());
        sysOptHistory.setSysStaffUserId(1);
        sysOptHistory.setText("ssssssssssssssssssssssssssssssss");
        sysOptHistoryService.saveUpdate(OptType.save, sysOptHistory);
    }
    
}
