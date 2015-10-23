package cn.zying.osales.service.baseinfo.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductBrand ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.IProductBrandService ;
import cn.zying.osales.service.baseinfo.units.ProductBrandRemoveUnits ;
import cn.zying.osales.service.baseinfo.units.ProductBrandSaveUpdateUnits ;
import cn.zying.osales.service.baseinfo.units.ProductBrandSearchUnits ;
import cn.zying.osales.units.search.bean.ProductBrandSearchBean ;

@Component(IProductBrandService.name)
public class ProductBrandServiceImple extends ABCommonsService implements IProductBrandService {

    //@Resource(name="ProductBrandSearchUnits")
    @Autowired
    @Qualifier("ProductBrandSearchUnits")
    private ProductBrandSearchUnits iProductBrandSearchUnits ;

    //@Resource(name=" ProductBrandSaveUpdateUnits")
    @Autowired
    @Qualifier("ProductBrandSaveUpdateUnits")
    private ProductBrandSaveUpdateUnits iProductBrandSaveUpdateUnits ;

    @Autowired
    @Qualifier("ProductBrandRemoveUnits")
    private ProductBrandRemoveUnits iProductBrandRemoveUnits ;

    @Override
    public void saveUpdate(OptType optType, ProductBrand optProductBrand) throws SystemOptServiceException {
        iProductBrandSaveUpdateUnits.saveUpdate(optType, optProductBrand) ;
    }

    @Override
    public SelectPage<ProductBrand> search(OptType optType, ProductBrandSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iProductBrandSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<ProductBrand> searchList(OptType optType, ProductBrandSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProductBrandSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public void remove(OptType optType, ProductBrand optProductBrand) throws SystemOptServiceException {
        iProductBrandRemoveUnits.remove(optType, optProductBrand) ;
    }

    @Override
    public ProductBrand get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, ProductBrand.class) ;
    }

}
