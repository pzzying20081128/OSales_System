package cn.zying.osales.test ;

import org.junit.runner.RunWith ;
import org.springframework.test.context.ContextConfiguration ;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner ;

import cn.zy.apps.tools.test.ABJUnitSping4Tests ;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
        "classpath:configs/spring/transaction_config.xml"  
})
public abstract class ABSalesJUnitSping4Texts extends ABJUnitSping4Tests {

}
