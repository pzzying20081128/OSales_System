package cn.zying.osales.service.produce.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProduceComBinedProduct ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProduceComBinedProductSearchBean ;

@Component("ProduceComBinedProductSearchUnits")
public class ProduceComBinedProductSearchUnits extends ABCommonsService {

    public SelectPage<ProduceComBinedProduct> search(OptType optType, ProduceComBinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<ProduceComBinedProduct> selectPage = new SelectPage<ProduceComBinedProduct>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<ProduceComBinedProduct> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<ProduceComBinedProduct> list(OptType optType, ProduceComBinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<ProduceComBinedProduct> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  produceComBinedProduct   from    ProduceComBinedProduct as produceComBinedProduct   inner join  fetch  produceComBinedProduct.stockOrder   " ;

    private List<ProduceComBinedProduct> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<ProduceComBinedProduct> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = " select  count(produceComBinedProduct.id)   from    ProduceComBinedProduct as produceComBinedProduct  inner join    produceComBinedProduct.stockOrder    " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, ProduceComBinedProductSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = "where  1=1 " ;

        if (searchBean.getStatus() != null && !searchBean.getStatus().equals(Status.全部)) {
            sqlWhere = sqlWhere + "   and   produceComBinedProduct.status ='" + searchBean.getStatus() + "'   " ;
        }

        return sqlWhere ;
    }

}
