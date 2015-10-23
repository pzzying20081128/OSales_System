package cn.zying.osales.web.search ;

import java.util.ArrayList ;
import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zying.osales.service.IABService ;
import cn.zying.osales.units.search.bean.CombSearchBean ;

@Component("ProductInfoSearchAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class ProductInfoSearchAction extends ABSalesSearchAction {

    private enum SelecType {
        baseUnit, boxUnit
    }

    @Autowired
    @Qualifier(IABService.name)
    private IABService baseService ;

    private SelecType selectype ;

    @Override
    protected List<CombSearchBean> searchResult() throws Exception {
        switch (selectype) {
        case baseUnit:

            return selectBaseUnit(name) ;

        case boxUnit:

            return selectBoxUnit(name) ;

        default:
            throw new Exception("selectype " + selectype + "  error  ") ;
        }

    }

    public void setSelectype(SelecType selectype) {
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

}
