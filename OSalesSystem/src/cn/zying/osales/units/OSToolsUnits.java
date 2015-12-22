package cn.zying.osales.units ;

import java.math.BigDecimal ;
import java.math.BigInteger ;
import java.util.List ;

public class OSToolsUnits {

    public static Integer toIntBigDecimal(Object value) {

        return value == null ? null : ((BigDecimal) value).intValue() ;
    }

    public static Integer toInteger(Object value) {

        return value == null ? null : ((Integer) value).intValue() ;
    }

    public static Long toLong(Object value) {
        return value == null ? null : ((BigInteger) value).longValue() ;
    }
    
    
    public static boolean  listIsNull(List<?> lists){
        if(lists ==null  || lists.size() ==0)return true;
        else
            return false;
    }

}
