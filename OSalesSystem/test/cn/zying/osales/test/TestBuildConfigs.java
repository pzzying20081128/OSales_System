package cn.zying.osales.test ;
import cn.zy.apps.tools.dev.javascript.BuildJSModule ;
import cn.zy.apps.tools.dev.javascript.IBuildJSModule ;
import cn.zying.osales.pojos.CompanyInfo ;
import cn.zying.osales.pojos.ProduceComBinedProductDetail ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.pojos.StockContract ;
import cn.zying.osales.pojos.StockContractDetail ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.pojos.StockPaymentDetail ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.pojos.StockReturnDetail ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.pojos.StockReturnStoreOutDetail ;
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
        
        String moduleNmae="stock_adjust_bill";
        
        Class<?> clazz = StockAdjustBill.class;
        
        String jsSrcPath  =  "/media/you/MY_WORKSHOPS/tools/git/project/develop/develop/src/cn/zy/apps/tools/dev/javascript/template";
        String out ="./release/build/"+moduleNmae;
        IBuildJSModule buildJSModule=new BuildJSModule(jsSrcPath ,out );
        buildJSModule.build(moduleNmae,clazz);

    }

}
