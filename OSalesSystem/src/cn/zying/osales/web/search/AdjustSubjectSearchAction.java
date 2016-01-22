package cn.zying.osales.web.search ;

import java.util.ArrayList ;
import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.service.stocks.IStockAdjustBillService ;
import cn.zying.osales.units.search.bean.CombSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;

@Component("AdjustSubjectSearchAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class AdjustSubjectSearchAction extends ABSalesSearchAction {

    @Autowired
    @Qualifier(IStockAdjustBillService.name)
    private IStockAdjustBillService stockAdjustBillService ;

    @Override
    protected List<CombSearchBean> searchResult() throws Exception {
        List<String> results = stockAdjustBillService.searchAdjustSubject(name, 0, 20) ;
        List<CombSearchBean> res = new ArrayList<CombSearchBean>() ;
        for (String result : results) {
            CombSearchBean combSearchBean = new CombSearchBean() ;
            combSearchBean.setId(result) ;
            combSearchBean.setName(result) ;
            res.add(combSearchBean) ;
        }
        return res ;
    }

}
