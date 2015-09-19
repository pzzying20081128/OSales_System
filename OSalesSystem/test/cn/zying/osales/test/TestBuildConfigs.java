package cn.zying.osales.test ;
import cn.zy.apps.tools.dev.builds.BuildJSModule ;
import cn.zy.apps.tools.dev.builds.IBuildJSModule ;
import cn.zying.osales.pojos.SystemUser ;



public class TestBuildConfigs {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
//        IBuildConfigs buildConfigs = new BuildConfigs("/media/you/MY_WORKSHOPS/tools/git/project/develop/develop/release/build") ;
//        buildConfigs.build("test", StaffInfo.class) ;
        
//        String outPath, String jsSrcPath
        String jsSrcPath  =  "/media/you/MY_WORKSHOPS/tools/git/project/develop/develop/src/cn/zy/apps/tools/dev/builds/js";
        String out ="./release/build";
        IBuildJSModule buildJSModule=new BuildJSModule(jsSrcPath ,out );
        buildJSModule.build("system_user_manage",SystemUser.class);

    }

}
