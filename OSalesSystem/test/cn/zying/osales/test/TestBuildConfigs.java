package cn.zying.osales.test ;
import cn.zy.apps.tools.dev.javascript.BuildJSModule ;
import cn.zy.apps.tools.dev.javascript.IBuildJSModule ;
import cn.zying.osales.pojos.ProduceComBinedProductDetail ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.pojos.StockReturnDetail ;
import cn.zying.osales.pojos.StoreProductInfoDetail ;
import cn.zying.osales.pojos.StoreProductInfoStock ;
import cn.zying.osales.pojos.SysPrintTemplate ;




public class TestBuildConfigs {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
//        IBuildConfigs buildConfigs = new BuildConfigs("/media/you/MY_WORKSHOPS/tools/git/project/develop/develop/release/build") ;
//        buildConfigs.build("test", StaffInfo.class) ;
        
//        String outPath, String jsSrcPath
        
        String moduleNmae="stock_return_detail";
        
        Class<?> clazz = StockReturnDetail.class;
        
        String jsSrcPath  =  "/media/you/MY_WORKSHOPS/tools/git/project/develop/develop/src/cn/zy/apps/tools/dev/javascript/template";
        String out ="./release/build/"+moduleNmae;
        IBuildJSModule buildJSModule=new BuildJSModule(jsSrcPath ,out );
        buildJSModule.build(moduleNmae,clazz);

    }

}
