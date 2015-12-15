package cn.zying.osales.test.storage ;

import java.util.concurrent.ExecutorService ;

import java.util.concurrent.Executors ;
import java.util.concurrent.atomic.AtomicInteger ;

import javax.annotation.Resource ;

import org.junit.Test ;
import org.springframework.beans.factory.annotation.Qualifier ;

import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.service.stocks.IStockOrderDetailService ;
import cn.zying.osales.service.stocks.IStockOrderService ;
import cn.zying.osales.storage.IInStoreProductInfoStockService ;
import cn.zying.osales.storage.IInStoreProductInfoStockService.StoreOptType ;
import cn.zying.osales.test.ABSalesJUnitSping4Texts ;

public class StockOrderStorageTest extends ABSalesJUnitSping4Texts {

    @Resource(name = IInStoreProductInfoStockService.name)
    IInStoreProductInfoStockService storeProductInfoStockService ;

    @Resource(name = IStockOrderService.name)
    IStockOrderService stockOrderService ;

    @Resource(name = IStockOrderDetailService.name)
    IStockOrderDetailService stockOrderDetailService ;

    @Test
    public void sss() throws Exception {
        
        

        ExecutorService executorService = Executors.newFixedThreadPool(3) ;
        
        final AtomicInteger  atomicInteger  =new AtomicInteger(0) ; 

        for (int i = 0; i < 100; i++) {

            executorService.submit(new Runnable() {

                @Override
                public void run() {

                    StockOrderDetail stockOrderDetail = stockOrderDetailService.get(16) ;
                   
                    storeProductInfoStockService.inStore(StoreOptType.SaveAdd, stockOrderDetail) ;
                    
                    atomicInteger.addAndGet(1);
                    
                    System.out.println("=========== 1  > "+atomicInteger.get()) ;
                
                }
            }) ;

        }
        
       Thread.sleep(1000);
       System.out.println("=========== 2 > "+atomicInteger.get()) ;
    }
}
