package cn.zying.osales.test;

import org.junit.Test ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.sysmanage.ISystemUserService ;

public class SysStaffInfoServiceTest extends ABSalesJUnitSping4Texts {
    
    @Autowired
    @Qualifier(ISystemUserService.aop_name)
    private ISystemUserService systemUserService;
    
    @Test
    public void search() {
        SysStaffUser sysStaffUser  =   systemUserService.searchByAccessName("1");
        System.out.println("-- > "+sysStaffUser) ;
        for(int i=0;i<1000;i++){
            SysStaffUser sysStaffUser_  =new SysStaffUser();
            sysStaffUser_.setAccount(i*100+"i");
            sysStaffUser_.setName(i+"name");
            systemUserService.saveUpdate(OptType.save, sysStaffUser_);
            
        }
    }

}
