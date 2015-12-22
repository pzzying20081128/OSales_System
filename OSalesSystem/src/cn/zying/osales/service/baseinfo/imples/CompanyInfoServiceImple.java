 package  cn.zying.osales.service.baseinfo.imples;
 

  import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CompanyInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ICompanyInfoService ;
import cn.zying.osales.service.baseinfo.units.CompanyInfoRemoveUnits ;
import cn.zying.osales.service.baseinfo.units.CompanyInfoSaveUpdateUnits ;
import cn.zying.osales.service.baseinfo.units.CompanyInfoSearchUnits ;
import cn.zying.osales.units.search.bean.CompanyInfoSearchBean ;
 

@Component(ICompanyInfoService.name)
public class CompanyInfoServiceImple extends  ABCommonsService  implements ICompanyInfoService {

            //@Resource(name="CompanyInfoSearchUnits")
			  @Autowired
            @Qualifier("CompanyInfoSearchUnits")        
            private  CompanyInfoSearchUnits  iCompanyInfoSearchUnits;
           
           //@Resource(name=" CompanyInfoSaveUpdateUnits")
		     @Autowired
            @Qualifier("CompanyInfoSaveUpdateUnits")      
           private CompanyInfoSaveUpdateUnits  iCompanyInfoSaveUpdateUnits;
			
		   
		      @Autowired
    @Qualifier("CompanyInfoRemoveUnits")
    private CompanyInfoRemoveUnits iCompanyInfoRemoveUnits ;
		   
			@Override
            public CompanyInfo saveUpdate(OptType  optType ,   CompanyInfo   optCompanyInfo )throws SystemOptServiceException{
        	     return 	 iCompanyInfoSaveUpdateUnits.saveUpdate(optType, optCompanyInfo);
        		}
            
       	   @Override
            public SelectPage<CompanyInfo > search(OptType  optType ,    
				   CompanyInfoSearchBean  searchBean , CommSearchBean  commSearchBean ,int... startLimit)throws SystemOptServiceException{
				    return  iCompanyInfoSearchUnits.search(optType, searchBean,
					commSearchBean ,startLimit );
            }
			
			 @Override
			public List<CompanyInfo > searchList(OptType  optType ,    
				           CompanyInfoSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			  return  iCompanyInfoSearchUnits.list(optType, searchBean,
					commSearchBean ,startLimit );
            
    }
            
			@Override
            public  CompanyInfo   remove(OptType  optType ,   CompanyInfo   optCompanyInfo)throws SystemOptServiceException{
			      return   iCompanyInfoRemoveUnits.remove(optType, optCompanyInfo);
			  }
			  
			   @Override
            public CompanyInfo get(Integer id) throws SystemOptServiceException {
                
                return baseService.get(id, CompanyInfo.class) ;
            }
            
            
}
