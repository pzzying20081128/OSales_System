package cn.zying.osales.test;

import cn.zy.apps.tools.dev.service.BuildServiceFile ;
import cn.zy.apps.tools.dev.service.IBuildServiceFile ;
import cn.zying.osales.pojos.StaffInfo ;
import cn.zying.osales.pojos.SystemUser ;

public class TestBuildServiceFile {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        
        
        String module= "sysmanage";
        
        String className=SystemUser.class.getSimpleName();

        String out ="./release/build/service/"+className.toLowerCase();
        
        String templatePath ="/media/you/MY_WORKSHOPS/tools/git/project/develop/develop/src/cn/zy/apps/tools/dev/service/template";
        
        String servicePackage="cn.zying.osales.service";
        
        IBuildServiceFile  buildServiceFile  =new BuildServiceFile(  templatePath ,out  );
        
        buildServiceFile.build(servicePackage +"."+module,SystemUser.class);

    }

}
