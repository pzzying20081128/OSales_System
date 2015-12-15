package cn.zying.osales.units ;

import java.math.BigDecimal ;
import java.math.BigInteger ;

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

}
