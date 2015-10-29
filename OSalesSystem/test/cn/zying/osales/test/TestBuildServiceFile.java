package cn.zying.osales.test;

import cn.zy.apps.tools.dev.service.BuildServiceFile ;
import cn.zy.apps.tools.dev.service.IBuildServiceFile ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.pojos.StockInStoreDetail ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.pojos.StockStoreReceiveDetail ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;

public class TestBuildServiceFile {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        
        
        String module= "stocks";
        
        Class<?> clazz = StockStoreReceiveDetail.class;
        
        String className=clazz.getSimpleName();

        String out ="./release/build/service/"+className.toLowerCase();
        
        String templatePath ="/media/you/MY_WORKSHOPS/tools/git/project/develop/develop/src/cn/zy/apps/tools/dev/service/template";
        
        String servicePackage="cn.zying.osales.service";
        
        IBuildServiceFile  buildServiceFile  =new BuildServiceFile(  templatePath ,out  );
        
        buildServiceFile.build(servicePackage +"."+module,clazz);

    }

}
