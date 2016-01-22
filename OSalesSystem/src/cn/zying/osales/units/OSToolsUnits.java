package cn.zying.osales.units ;

import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileOutputStream ;
import java.io.IOException ;
import java.io.OutputStreamWriter ;
import java.io.Writer ;
import java.math.BigDecimal ;
import java.math.BigInteger ;
import java.util.List ;

public class OSToolsUnits {

    public static void wirteFile(String pathfileName, String coentext) throws Exception {

        Writer writer = null ;

        try {

            //            String filePath = path + "/" + fileName ;
            File file = new File(pathfileName) ;
            // writer = new FileWriter(file);
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")) ;
            writer.write(coentext) ;
        } finally {
            if (writer != null) try {
                writer.close() ;
            } catch (IOException e) {
                throw new Exception(e) ;
            }
        }

    }

    public static Integer toIntBigDecimal(Object value) {

        return value == null ? null : ((BigDecimal) value).intValue() ;
    }

    public static Integer toInteger(Object value) {

        return value == null ? null : ((Integer) value).intValue() ;
    }

    public static Long toLong(Object value) {
        return value == null ? null : ((BigInteger) value).longValue() ;
    }

    public static boolean listIsNull(List<?> lists) {
        if (lists == null || lists.size() == 0) return true ;
        else
            return false ;
    }

}
