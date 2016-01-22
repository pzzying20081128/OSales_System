package cn.zying.osales.units ;

import org.apache.poi.hssf.usermodel.HSSFCellStyle ;
import org.apache.poi.hssf.usermodel.HSSFFont ;
import org.apache.poi.hssf.util.HSSFColor ;
import org.apache.poi.ss.usermodel.CellStyle ;
import org.apache.poi.ss.usermodel.Font ;
import org.apache.poi.ss.usermodel.Workbook ;

public class ExcelStyle {

    private HSSFCellStyle cellStyle ;

    private HSSFCellStyle ttitleStyle ;

    private HSSFCellStyle columnHeadStyle ;

    public ExcelStyle(Workbook wb) {

        // setHSSFFont(wb) ;

        cellStyle = (HSSFCellStyle) wb.createCellStyle() ;
        Font ztFont = wb.createFont() ;
        // ztFont.setItalic(true); // 设置字体为斜体字
        // ztFont.setColor(Font.COLOR_RED); // 将字体设置为“红色”
        ztFont.setFontHeightInPoints((short) 10) ; // 将字体大小设置为18px
        // ztFont.setFontName("华文行楷"); // 将“华文行楷”字体应用到当前单元格上
        // ztFont.setUnderline(Font.U_DOUBLE) ; //
        // 添加（Font.U_SINGLE单条下划线/Font.U_DOUBLE双条下划线）
        // ztFont.setStrikeout(true); // 是否添加删除线
        cellStyle.setFont(ztFont) ; // 将字体应用到样式上面

        // /////////////

        ttitleStyle = (HSSFCellStyle) wb.createCellStyle() ;
        Font ttitleStyleFont = wb.createFont() ;
        // ztFont.setItalic(true); // 设置字体为斜体字
        // ztFont.setColor(Font.COLOR_RED); // 将字体设置为“红色”
        ttitleStyleFont.setFontHeightInPoints((short) 24) ; // 将字体大小设置为18px
        // ztFont.setFontName("华文行楷"); // 将“华文行楷”字体应用到当前单元格上
        // ztFont.setUnderline(Font.U_DOUBLE) ; //
        // 添加（Font.U_SINGLE单条下划线/Font.U_DOUBLE双条下划线）
        // ztFont.setStrikeout(true); // 是否添加删除线
        ttitleStyle.setFont(ttitleStyleFont) ; // 将字体应用到样式上面
        ttitleStyle.setAlignment(CellStyle.ALIGN_CENTER) ;

        // 另一个字体样式
        HSSFFont columnHeadFont = (HSSFFont) wb.createFont() ;
        // columnHeadFont.setFontName("宋体"); //字体
        columnHeadFont.setFontHeightInPoints((short) 10) ;
        // columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); ///加粗
        columnHeadFont.setColor(HSSFColor.BLACK.index) ;
        // 列头的样式
        HSSFCellStyle columnHeadStyle = (HSSFCellStyle) wb.createCellStyle() ;
        columnHeadStyle.setFont(columnHeadFont) ;
        columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER) ;// 左右居中
        columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER) ;// 上下居中
        columnHeadStyle.setLocked(true) ;
        columnHeadStyle.setWrapText(true) ;
        columnHeadStyle.setLeftBorderColor(HSSFColor.BLACK.index) ;// 左边框的颜色
        columnHeadStyle.setBorderLeft((short) 1) ;// 边框的大小
        columnHeadStyle.setRightBorderColor(HSSFColor.BLACK.index) ;// 右边框的颜色
        columnHeadStyle.setBorderRight((short) 1) ;// 边框的大小
        columnHeadStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN) ; // 设置单元格的边框为粗体
        columnHeadStyle.setBottomBorderColor(HSSFColor.BLACK.index) ; // 设置单元格的边框颜色
        // // 设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）
        // columnHeadStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        this.columnHeadStyle = columnHeadStyle ;

        // //////////////////

    }

    public HSSFCellStyle getTitleHSSFCellStyle() {

        return ttitleStyle ;
    }

    public HSSFCellStyle getCellStyle(short Alignment) {
        // cellStyle.setAlignment(Alignment) ;
        // System.out.println("=============  >  "+cellStyle) ;
        return cellStyle ;
    }

    public HSSFCellStyle getColumnHeadStyle() {
        return columnHeadStyle ;
    }

    public void setColumnHeadStyle(HSSFCellStyle columnHeadStyle) {
        this.columnHeadStyle = columnHeadStyle ;
    }

}
