package cn.zying.osales.units ;

import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.pojos.SystemConfigs ;

public class SystemConfigsFactory {

    private static org.apache.log4j.Logger logger = Loggerfactory.instance(SystemConfigsFactory.class) ;

    private static Map<String, SystemConfigs> configs = new HashMap<String, SystemConfigs>() ;

    private static SystemConfigsFactory systemConfigsFactory = new SystemConfigsFactory() ;

    public static void instance(List<SystemConfigs> systemConfigses) {

        for (SystemConfigs systemConfigs : systemConfigses) {
            Loggerfactory.info(logger, "keys " + systemConfigs.getConfigKey() + "  value : " + systemConfigs.getConfigValue()) ;
            configs.put(systemConfigs.getConfigKey(), systemConfigs) ;
        }

    }

    public static SystemConfigsFactory getSystemConfigsFactory() {
        return systemConfigsFactory ;
    }

    public String searchConfigs(String key, String defaultValue) {
        SystemConfigs systemConfigs = configs.get(key) ;
        if (ToolsUnits.isNOtNulll(systemConfigs.getConfigValue())) return systemConfigs.getConfigValue() ;
        else
            return defaultValue ;
    }

    // String path = event.getServletContext().getRealPath("/") + "/WEB-INF/classes";
    public void wirteDefaultValue(String defaultfile, String... keys) {

        StringBuffer stringBuffer = new StringBuffer() ;
        try {

            for (String key : keys) {

                SystemConfigs systemConfigs = configs.get(key) ;

                String config = systemConfigs.getConfigValue() ;

                if (!ToolsUnits.isNOtNulll(config)) throw new RuntimeException(" sysconfigs key " + key + " configs  error is null ") ;

                stringBuffer.append(key + "='" + config + "' \r\n ") ;

            }

            OSToolsUnits.wirteFile(defaultfile, stringBuffer.toString()) ;

        } catch (Exception e) {
            throw new RuntimeException(e) ;
        }

    }
}
