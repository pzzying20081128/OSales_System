package cn.zying.osales.web ;

import java.util.List ;

import javax.servlet.ServletContextEvent ;
import javax.servlet.ServletContextListener ;

import org.springframework.web.context.ContextLoaderListener ;
import org.springframework.web.context.WebApplicationContext ;
import org.springframework.web.context.support.WebApplicationContextUtils ;

import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProductBrand ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.IProviderInfoService ;
import cn.zying.osales.service.baseinfo.IProductBrandService ;
import cn.zying.osales.service.baseinfo.ISystemUserService ;
import cn.zying.osales.units.PrpertiesAutoWriteObjectService ;
import cn.zying.osales.units.search.bean.ProductBrandSearchBean ;
import cn.zying.osales.units.search.bean.ProductCategorySearchBean ;
import cn.zying.osales.units.search.bean.ProviderInfoSearchBean ;
import cn.zying.osales.units.search.bean.StoreInfoSearchBean ;
import cn.zying.osales.units.search.bean.StorePositionSearchBean ;
import cn.zying.osales.units.search.bean.SystemUserSearchBean ;
import cn.zying.osales.web.aop.IAopProductCategoryService ;
import cn.zying.osales.web.aop.IAopStoreInfoService ;
import cn.zying.osales.web.aop.IAopStorePositionService ;

public class SystemConfigInitListener extends ContextLoaderListener implements ServletContextListener {

    private org.apache.log4j.Logger logger = Loggerfactory.instance(SystemConfigInitListener.class) ;

    //	private IERPSystemConfigs iERPSystemConfigs = DefaultERPSystemConfigs.instance();

    //	 protected static ERPSetPrpertiesUnits erpSetPrpertiesUnits = ERPSetPrpertiesUnits.instance(false) ;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {

            WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()) ;

            PrpertiesAutoWriteObjectService prpertiesAutoWriteObjectService = (PrpertiesAutoWriteObjectService) springContext.getBean("PrpertiesAutoWriteObjectService") ;

            load(springContext, prpertiesAutoWriteObjectService) ;

        } catch (Exception e) {
            Loggerfactory.error(logger, e.getMessage(), e) ;
        }
    }

    private void load(WebApplicationContext springContext, PrpertiesAutoWriteObjectService prpertiesAutoWriteObjectService) {
        //		ISystemConfigService systemConfigService = (ISystemConfigService) springContext.getBean(ISystemConfigService.name);
        //
        //		iERPSystemConfigs.loadSystemConfig(systemConfigService.searchAll(null).getResult());
        //
        //		loadFeeSubject(springContext);
        //
        loadStaffInfo(springContext, prpertiesAutoWriteObjectService) ;

        loadProductCategory(springContext, prpertiesAutoWriteObjectService) ;
        //
        loadStoreInfo(springContext, prpertiesAutoWriteObjectService) ;
        //
        //		loadStorePosition(springContext);
        //
        //		loadGuestInfo(springContext);
        //
        //		loadStockContract(springContext);
        //
        //		loadProductInfo(springContext);
        //
        //		loadSystemConfigs(springContext);
        //
        loadProductBrand(springContext, prpertiesAutoWriteObjectService) ;
        //
        //		loadTransportCompany(springContext);
        //
        //		loadStoreProductInfoStock(springContext);
        //
        loadProviderInfo(springContext, prpertiesAutoWriteObjectService) ;

    }

    private void loadProviderInfo(WebApplicationContext springContext, PrpertiesAutoWriteObjectService prpertiesAutoWriteObjectService) {
        Loggerfactory.info(logger, "start write  ProviderInfo   to cache factory ") ;
        IProviderInfoService storeInfosSearchService = (IProviderInfoService) springContext.getBean(IProviderInfoService.name) ;

        ProviderInfoSearchBean searchBean = new ProviderInfoSearchBean() ;

        searchBean.setStatus(Status.全部) ;

        List<ProviderInfo> providerInfos = storeInfosSearchService.searchList(OptType.search, searchBean, null, 0) ;

        for (ProviderInfo providerInfo : providerInfos) {
            prpertiesAutoWriteObjectService.cacheObject(providerInfo.getId().toString(), providerInfo) ;

        }

    }

    //	private void loadStoreProductInfoStock(WebApplicationContext springContext) {
    //		Loggerfactory.info(logger, "start write  StoreProductInfoStock  to cache factory ");
    //		IStoreProductInfoStockService storeInfosSearchService = (IStoreProductInfoStockService) springContext
    //				.getBean(IStoreProductInfoStockService.name);
    //		List<StoreProductInfoStock> storeProductInfoStocks = storeInfosSearchService.listAllStoreProductInfoStock();
    //
    //		for (StoreProductInfoStock storeProductInfoStock : storeProductInfoStocks) {
    //			StoreSelectProductUnits.updateStoreProductInfoStockCache(storeProductInfoStock);
    //
    //		}
    //
    //		List<StoreProductInfoDetail> storeProductInfoDetails = storeInfosSearchService.listAllStoreProductInfoDetail();
    //
    //		for (StoreProductInfoDetail storeProductInfoDetail : storeProductInfoDetails) {
    //			StoreSelectProductUnits.updateStorePositionProductInfoCacheKey(storeProductInfoDetail);
    //
    //		}
    //
    //	}

    //	private void loadTransportCompany(WebApplicationContext springContext) {
    //		Loggerfactory.info(logger, "start write  StockContract  to cache factory ");
    //		ITransportCompanyService storeInfosSearchService = (ITransportCompanyService) springContext.getBean(ITransportCompanyService.name);
    //		List<TransportCompany> transportCompanys = storeInfosSearchService.listAll();
    //
    //		for (TransportCompany transportCompany : transportCompanys) {
    //			ToolsNewUnits.updateTransportCompanyCache(transportCompany);
    //
    //		}
    //
    //	}

    //	private void loadStockContract(WebApplicationContext springContext) {
    //		Loggerfactory.info(logger, "start write  StockContract  to cache factory ");
    //		IStoreInfosSearchService storeInfosSearchService = (IStoreInfosSearchService) springContext.getBean(IStoreInfosSearchService.name);
    //		List<StockContract> stockContracts = storeInfosSearchService.searchALLStockContractn();
    //
    //		for (StockContract stockContract : stockContracts) {
    //			ToolsNewUnits.updateStockContractCache(stockContract);
    //
    //		}
    //
    //	}

    //	private void loadProductInfo(WebApplicationContext springContext) {
    //		Loggerfactory.info(logger, "start write  ProductInfo  to cache factory  ");
    //
    //		IProductInfoService guestInfoService = (IProductInfoService) springContext.getBean(IProductInfoService.name);
    //
    //		List<ProductInfo> productInfos = guestInfoService.listproductInfo();
    //
    //		for (ProductInfo productInfo : productInfos) {
    //			ToolsNewUnits.updateProductInfoCache(productInfo);
    //		}
    //
    //		IProductInfoTypeSearchService productInfoTypeSearchService = (IProductInfoTypeSearchService) springContext
    //				.getBean(IProductInfoTypeSearchService.name);
    //
    //		List<ProductType> productTypes = productInfoTypeSearchService.listAll();
    //
    //		for (ProductType productType : productTypes) {
    //			ToolsNewUnits.updateProductTypeCache(productType);
    //		}
    //		
    //		
    //		List<ProductStoreInfo>  productStoreInfos  = guestInfoService.listAll();
    //		
    //	  for(ProductStoreInfo   productStoreInfo : productStoreInfos  ){
    //	      erpSetPrpertiesUnits.setPrpertiesUnits(productStoreInfo);
    //	      ToolsNewUnits.updateProductStoreInfoCache(productStoreInfo);
    //	  }
    //	
    //	}

    private void loadProductBrand(WebApplicationContext springContext, PrpertiesAutoWriteObjectService prpertiesAutoWriteObjectService) {
        Loggerfactory.info(logger, "start write  ProductBrand  to cache factory  ") ;

        IProductBrandService service = (IProductBrandService) springContext.getBean(IProductBrandService.name) ;

        ProductBrandSearchBean searchBean = new ProductBrandSearchBean() ;

        searchBean.setStatus(Status.全部) ;

        List<ProductBrand> productBrands = service.searchList(OptType.search, searchBean, null) ;

        for (ProductBrand productBrand : productBrands) {
            prpertiesAutoWriteObjectService.cacheObject(productBrand.getId().toString(), productBrand) ;
        }

    }

    //	private void loadGuestInfo(WebApplicationContext springContext) {
    //		Loggerfactory.info(logger, "start write  GuestInfo  to cache factory  ");
    //
    //		IGuestInfoService guestInfoService = (IGuestInfoService) springContext.getBean(IGuestInfoService.name);
    //
    //		List<GuestInfo> guestInfos = guestInfoService.listAll();
    //
    //		for (GuestInfo guestInfo : guestInfos) {
    //			ToolsNewUnits.updateGuestInfoCache(guestInfo);
    //		}
    //
    //	}

    //	private void loadStorePosition(WebApplicationContext springContext) {
    //
    //		IStoreInfosSearchService storeInfosSearchService = (IStoreInfosSearchService) springContext.getBean(IStoreInfosSearchService.name);
    //		Loggerfactory.info(logger, "start write  StorePosition  to cache factory ! ");
    //
    //		loadStoreInfo(springContext);
    //
    //		List<StorePosition> storePositions = storeInfosSearchService.searchALLStorePosition();
    //
    //		for (StorePosition storePosition : storePositions) {
    //			ToolsNewUnits.updateStorePositionCache(storePosition);
    //		}
    //
    //	}

    private void loadStoreInfo(WebApplicationContext springContext, PrpertiesAutoWriteObjectService prpertiesAutoWriteObjectService) {
        

        IAopStoreInfoService storeInfosSearchService = (IAopStoreInfoService) springContext.getBean(IAopStoreInfoService.name) ;

        StoreInfoSearchBean searchBean = new StoreInfoSearchBean() ;

        searchBean.setStatus(Status.全部) ;

        List<StoreInfo> storeInfos = storeInfosSearchService.searchList(OptType.search, searchBean, null) ;
        
        Loggerfactory.info(logger, "start write  StoreInfo  to cache factory "+storeInfos.size()) ;

        for (StoreInfo storeInfo : storeInfos) {
            prpertiesAutoWriteObjectService.cacheObject(storeInfo.getId().toString(), storeInfo) ;
        }

        IAopStorePositionService storePositionService = (IAopStorePositionService) springContext.getBean(IAopStorePositionService.name) ;

        StorePositionSearchBean storePositionSearchBean = new StorePositionSearchBean() ;

        storePositionSearchBean.setStatus(Status.全部) ;

        List<StorePosition> storePositions = storePositionService.searchList(OptType.search, storePositionSearchBean, null) ;
        Loggerfactory.info(logger, "start write  StorePosition   to cache factory   "+storePositions.size()) ;
        for (StorePosition storePosition : storePositions) {
            prpertiesAutoWriteObjectService.cacheObject(storePosition.getId().toString(), storePosition) ;
        }

    }

    private void loadProductCategory(WebApplicationContext springContext, PrpertiesAutoWriteObjectService prpertiesAutoWriteObjectService) {
        Loggerfactory.info(logger, "start load  ProductType  to Cachefactory ") ;

        IAopProductCategoryService aopProductCategoryService = (IAopProductCategoryService) springContext.getBean(IAopProductCategoryService.name) ;

        ProductCategorySearchBean searchBean = new ProductCategorySearchBean() ;

        searchBean.setStatus(Status.全部) ;

        List<ProductCategory> ProductCategorys = aopProductCategoryService.searchList(OptType.search, searchBean, null) ;

        for (ProductCategory productCategory : ProductCategorys) {
            prpertiesAutoWriteObjectService.cacheObject(productCategory.getId().toString(), productCategory) ;
        }

    }

    private void loadStaffInfo(WebApplicationContext springContext, PrpertiesAutoWriteObjectService prpertiesAutoWriteObjectService) {

        Loggerfactory.info(logger, "start load  SysStaffInfo to Cachefactory ") ;

        ISystemUserService selectStaffInfoService = (ISystemUserService) springContext.getBean(ISystemUserService.name) ;

        SystemUserSearchBean searchBean = new SystemUserSearchBean() ;

        searchBean.setStatus(Status.全部) ;

        List<SysStaffUser> staffInfos = selectStaffInfoService.searchList(OptType.list, searchBean, null) ;

        for (SysStaffUser staffInfo : staffInfos) {
            prpertiesAutoWriteObjectService.cacheObject(staffInfo.getId().toString(), staffInfo) ;
        }

    }

    //	private void loadFeeSubject(WebApplicationContext springContext) {
    //		Loggerfactory.info(logger, "start write  FeeSubject  to cache factory start ! ");
    //		IFeeSubjectService feeSubjectService = (IFeeSubjectService) springContext.getBean(IFeeSubjectService.name);
    //		List<FeeSubject> feeSubjects = feeSubjectService.listAll();
    //		for (FeeSubject feeSubject : feeSubjects) {
    //			ToolsNewUnits.updateFeeSubjectCache(feeSubject);
    //		}
    //
    //	}

    //	private void loadSystemConfigs(WebApplicationContext springContext) {
    //		Loggerfactory.info(logger, "start load  System configs  ");
    //
    //		ISystemConfigService systemConfigService = (ISystemConfigService) springContext.getBean(ISystemConfigService.name);
    //
    //		SelectPage<SystemConfig> feeSubjects = systemConfigService.searchAll(null);
    //
    //		IERPSystemConfigs iERPSystemConfigs = DefaultERPSystemConfigs.instance();
    //
    //		iERPSystemConfigs.loadSystemConfig(feeSubjects.getResult());
    //
    //	}

}
