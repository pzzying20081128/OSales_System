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
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.baseinfo.ISystemUserService ;
import cn.zying.osales.units.PrpertiesAutoWriteObjectService ;
import cn.zying.osales.units.search.bean.SystemUserSearchBean ;

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
        //
        //		loadStoreInfo(springContext);
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
        //		loadProductBrand(springContext);
        //
        //		loadTransportCompany(springContext);
        //
        //		loadStoreProductInfoStock(springContext);
        //
        //		loadProviderInfo(springContext);

    }

    //	private void loadProviderInfo(WebApplicationContext springContext) {
    //		Loggerfactory.info(logger, "start write  StockContract  to cache factory ");
    //		IProviderInfoService storeInfosSearchService = (IProviderInfoService) springContext.getBean(IProviderInfoService.name);
    //		List<ProviderInfo> providerInfos = storeInfosSearchService.listAll();
    //
    //		for (ProviderInfo providerInfo : providerInfos) {
    //			ToolsNewUnits.updateProviderInfoCache(providerInfo);
    //
    //		}
    //
    //	}

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

    //	private void loadProductBrand(WebApplicationContext springContext) {
    //		Loggerfactory.info(logger, "start write  ProductBrand  to cache factory  ");
    //
    //		IProductInfoService guestInfoService = (IProductInfoService) springContext.getBean(IProductInfoService.name);
    //
    //		List<ProductBrand> productBrands = guestInfoService.listAllList();
    //
    //		for (ProductBrand productBrand : productBrands) {
    //			ToolsNewUnits.updateProductBrandCache(productBrand);
    //		}
    //
    //	}

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

    //	private void loadStoreInfo(WebApplicationContext springContext) {
    //		Loggerfactory.info(logger, "start write  StoreInfo  to cache factory ");
    //		IStoreInfosSearchService storeInfosSearchService = (IStoreInfosSearchService) springContext.getBean(IStoreInfosSearchService.name);
    //
    //		List<StoreInfo> storeInfos = storeInfosSearchService.searchAllStoreInfos();
    //
    //		for (StoreInfo storeInfo : storeInfos) {
    //			ToolsNewUnits.updateStoreInfoCache(storeInfo);
    //		}
    //
    //	}

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
