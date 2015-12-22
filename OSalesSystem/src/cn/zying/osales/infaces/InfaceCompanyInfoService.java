package cn.zying.osales.infaces;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CompanyInfo ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.CompanyInfoSearchBean ;

public interface InfaceCompanyInfoService {
    
    
       /**
             *  增加或更新
             */
            public CompanyInfo   saveUpdate(OptType  optType ,   CompanyInfo   optCompanyInfo )throws SystemOptServiceException;
            
       	  
            public SelectPage<CompanyInfo > search(OptType  optType ,    
				           CompanyInfoSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
			public List<CompanyInfo > searchList(OptType  optType ,    
				           CompanyInfoSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
            public  CompanyInfo    remove(OptType  optType ,  CompanyInfo   optCompanyInfo)throws SystemOptServiceException;
            
            
           public  CompanyInfo get(Integer id)throws SystemOptServiceException;


}
