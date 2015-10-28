package cn.zying.osales.web.search ;

import java.util.ArrayList ;
import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.service.IABService ;
import cn.zying.osales.units.search.bean.CombSearchBean ;
import cn.zying.osales.units.search.bean.ProductInfoSearchBean ;
import cn.zying.osales.web.aop.IAopProductInfoService ;

@Component("ProductInfoSearchAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class ProductInfoSearchAction extends ABSalesSearchAction {

    private enum SelecType {
        baseUnit, boxUnit, productInfo
    }

    @Autowired
    @Qualifier(IABService.name)
    private IABService baseService ;

    @Autowired
    @Qualifier(IAopProductInfoService.name)
    private IAopProductInfoService aopProductInfoService ;

    private SelecType selectype ;

    private ProductInfoSearchBean searchBean ;

    @SuppressWarnings("unchecked")
    @Override
    protected List searchResult() throws Exception {

        switch (selectype) {
        case baseUnit:

            return selectBaseUnit(name) ;

        case boxUnit:

            return selectBoxUnit(name) ;

        case productInfo:

            return selectProductInfo(name) ;

        default:
            throw new Exception("selectype " + selectype + "  error  ") ;
        }

    }

    private List<ProductInfo> selectProductInfo(String name) throws Exception {
        searchBean.setName(name) ;

        List<ProductInfo> results = aopProductInfoService.searchList(OptType.search, searchBean, null, 0, 20) ;
        if (searchBean.getId() != null) {
            boolean ishave = false ;
            for (ProductInfo result : results) {
                if (result.getId().equals(searchBean.getId())) {
                    ishave = true ;
                    break ;
                }
            }
            if (ishave == false) {
                ProductInfo res = aopProductInfoService.get(searchBean.getId()) ;
                results.add(0, res) ;
            }

        } else {

        }
        writeObjectService.intToPrpertiesUnits(results) ;
        return results ;
    }

    public void setSelectype(SelecType selectype) throws Exception {
        this.selectype = selectype ;
    }

    private static String baseUnit = "select  distinct  productInfo.baseUnit    from  ProductInfo  as  productInfo   " ;

    private List<CombSearchBean> selectBaseUnit(String name) throws Exception {
        String sql = baseUnit ;
        if (ToolsUnits.isNOtNulll(name)) {
            sql = sql + "   where  productInfo.baseUnit !='" + name + "'  " ;
        }

        List<String> results = baseService.findByHSQL(sql, 0, 20) ;

        List<CombSearchBean> combSearchBeans = new ArrayList<CombSearchBean>() ;
        if (ToolsUnits.isNOtNulll(name)) {
            CombSearchBean combSearchBean_ = new CombSearchBean() ;

            combSearchBean_.setId(name) ;

            combSearchBean_.setName(name) ;

            combSearchBeans.add(combSearchBean_) ;
        }

        for (String result : results) {
            if (!ToolsUnits.isNOtNulll(result)) continue ;
            CombSearchBean combSearchBean = new CombSearchBean() ;
            combSearchBeans.add(combSearchBean) ;
            combSearchBean.setId(result) ;
            combSearchBean.setName(result) ;
        }
        return combSearchBeans ;
    }

    private static String boxUnit = "select  distinct  productInfo.boxUnit    from  ProductInfo  as  productInfo   " ;

    private List<CombSearchBean> selectBoxUnit(String name) throws Exception {
        String sql = boxUnit ;
        if (ToolsUnits.isNOtNulll(name)) {
            sql = sql + "   where  productInfo.boxUnit !='" + name + "'  " ;
        }

        List<String> results = baseService.findByHSQL(sql, 0, 20) ;

        List<CombSearchBean> combSearchBeans = new ArrayList<CombSearchBean>() ;

        if (ToolsUnits.isNOtNulll(name)) {
            CombSearchBean combSearchBean_ = new CombSearchBean() ;

            combSearchBean_.setId(name) ;

            combSearchBean_.setName(name) ;

            combSearchBeans.add(combSearchBean_) ;
        }

        for (String result : results) {
            if (!ToolsUnits.isNOtNulll(result)) continue ;
            CombSearchBean combSearchBean = new CombSearchBean() ;
            combSearchBeans.add(combSearchBean) ;
            combSearchBean.setId(result) ;
            combSearchBean.setName(result) ;
        }
        return combSearchBeans ;
    }

    public ProductInfoSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(ProductInfoSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
