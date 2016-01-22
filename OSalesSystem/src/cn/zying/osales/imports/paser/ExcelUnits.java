package cn.zying.osales.imports.paser ;

import org.apache.poi.hssf.usermodel.HSSFCell ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.units.ToolsRegex ;

public class ExcelUnits {

    public enum ExcelType {
        INT, DOUBLE, STRING
    }

    @SuppressWarnings("unchecked")
    public static String getValue(HSSFCell hssfCell, ExcelType types) throws PaserServiceException {
        if (hssfCell == null) return null ;
        if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return Boolean.toString((hssfCell.getBooleanCellValue())) ;

        } else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            Double doubles = hssfCell.getNumericCellValue() ;

            if (types.equals(ExcelType.INT)) {
                String xx = Long.toString(doubles.longValue()) ;
                if (!ToolsRegex.regex(ToolsRegex.excel_number, xx)) throw new PaserServiceException("Excel单元格式不对[" + xx + "]") ;
                return xx ;
            } else if (types.equals(ExcelType.DOUBLE)) {
                if (!ToolsRegex.regexMoney(doubles.toString())) throw new PaserServiceException("Excel 格式不对") ;
                else
                    return doubles.toString() ;
            } else {
                if (ToolsRegex.regex(ToolsRegex.number, doubles.toString())) return Integer.toString(doubles.intValue()) ;
                else if (ToolsRegex.regex(ToolsRegex.excel_number, doubles.toString())) return Integer.toString(doubles.intValue()) ;
                else if (ToolsRegex.regex(ToolsRegex.numberXs, doubles.toString())) return doubles.toString() ;
                if (ToolsRegex.regex(ToolsRegex.number, Long.toString(doubles.longValue()))) return Long.toString(doubles.longValue()) ;

            }
            throw new PaserServiceException("ExcelType 格式没定义") ;

        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue()) ;
        }
    }

    public static boolean getValueNUll(HSSFCell hssfCell) {
        String value = null ;
        if (hssfCell == null) return true ;
        if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            value = String.valueOf(hssfCell.getBooleanCellValue()) ;
        } else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值

            value = String.valueOf(hssfCell.getNumericCellValue()) ;
        } else {
            // 返回字符串类型的值
            value = String.valueOf(hssfCell.getStringCellValue()) ;
        }

        if (value == null || value.equals("")) return true ;
        else
            return false ;
    }

    public static String switchValue(String value) {
        return ToolsUnits.isNOtNulll(value) ? value : null ;
    }

    public static void main(String[] args) {
        boolean xx = ToolsRegex.regex(ToolsRegex.excel_number, "-40") ;
        System.out.println("==>  " + xx) ;
    }

}
