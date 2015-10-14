package cn.zying.osales.test;

import org.junit.Test ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;

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
    }

}
