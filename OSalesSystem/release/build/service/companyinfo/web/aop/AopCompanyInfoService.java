package cn.zy.apps.tools.dev.service.template ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;



@Component(IAopCompanyInfoService.name)
public class AopCompanyInfoService implements IAopCompanyInfoService {

    @Autowired
    @Qualifier(ICompanyInfoService.name)
    private ICompanyInfoService iCompanyInfoService ;

     public CompanyInfo  saveUpdate(OptType  optType ,   CompanyInfo   optCompanyInfo )throws SystemOptServiceException{
	
	     return  iCompanyInfoService.saveUpdate(  optType ,    optCompanyInfo );
	 
	 }
            
       	  
     public SelectPage<CompanyInfo > search(OptType  optType ,    
				           CompanyInfoSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
	
	 return  iCompanyInfoService.search(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
					
	}
	
	public List<CompanyInfo > searchList(OptType  optType ,    
				           CompanyInfoSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			 return  iCompanyInfoService.searchList(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
            
    }
            
    public  CompanyInfo    remove(OptType  optType ,  CompanyInfo   optCompanyInfo)throws SystemOptServiceException{
			
			   return  iCompanyInfoService.remove(  optType ,   optCompanyInfo);
			
	}
            
            
           public  CompanyInfo get(Integer id)throws SystemOptServiceException
		   {
		           return  iCompanyInfoService.get( id);
		   
		   }

}
