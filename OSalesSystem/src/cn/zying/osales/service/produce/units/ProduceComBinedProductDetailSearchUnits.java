package cn.zying.osales.service.produce.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProductDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProduceComBinedProductDetailSearchBean ;

@Component("ProduceComBinedProductDetailSearchUnits")
public class ProduceComBinedProductDetailSearchUnits extends ABCommonsService {

    public SelectPage<ProduceComBinedProductDetail> search(OptType optType, ProduceComBinedProductDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<ProduceComBinedProductDetail> selectPage = new SelectPage<ProduceComBinedProductDetail>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<ProduceComBinedProductDetail> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<ProduceComBinedProductDetail> list(OptType optType, ProduceComBinedProductDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<ProduceComBinedProductDetail> selectPage = new SelectPage<ProduceComBinedProductDetail>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<ProduceComBinedProductDetail> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  produceComBinedProductDetail   from   ProduceComBinedProductDetail as  produceComBinedProductDetail  " ;

    private List<ProduceComBinedProductDetail> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<ProduceComBinedProductDetail> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(produceComBinedProductDetail.id)  from   ProduceComBinedProductDetail as  produceComBinedProductDetail " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, ProduceComBinedProductDetailSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where produceComBinedProductDetail.produceProducInfoId = "+searchBean.getProduceProducInfoId() ;
        return sqlWhere ;
    }

}
