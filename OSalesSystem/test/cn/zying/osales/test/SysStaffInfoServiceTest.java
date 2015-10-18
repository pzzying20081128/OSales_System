package cn.zying.osales.test;

import org.junit.Test ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;

import cn.zy.apps.tools.units.SQLUilts ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.web.aop.IAopSystemUserService ;

public class SysStaffInfoServiceTest extends ABSalesJUnitSping4Texts {
    
    @Autowired
    @Qualifier(IAopSystemUserService.aop_name)
    private IAopSystemUserService systemUserService;
    
    @Test
    public void search() {
        SysStaffUser sysStaffUser  =   systemUserService.searchByAccessName("1");
        System.out.println("-- > "+sysStaffUser) ;
        for(int i=0;i<1;i++){
            SysStaffUser sysStaffUser_  =new SysStaffUser();
            sysStaffUser_.setAccount(SQLUilts.getUniqueId());
            sysStaffUser_.setName(SQLUilts.getUniqueId());
            systemUserService.saveUpdate(OptType.save, sysStaffUser_,sysStaffUser.getId());
            
        }
    }

}
