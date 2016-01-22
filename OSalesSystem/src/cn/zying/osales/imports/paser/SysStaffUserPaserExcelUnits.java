package cn.zying.osales.imports.paser ;

import javax.persistence.EntityManagerFactory ;

import org.apache.poi.hssf.usermodel.HSSFCell ;
import org.apache.poi.hssf.usermodel.HSSFRow ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.units.IPropertiesCacheFactory ;

public class SysStaffUserPaserExcelUnits extends PaserExcelUnits<SysStaffUser> {

    public SysStaffUserPaserExcelUnits(EntityManagerFactory entityManagerFactory, IPropertiesCacheFactory cacheFactory) {
        super(entityManagerFactory, cacheFactory) ;

    }

    @Override
    protected SysStaffUser paserExcelRow(int row, HSSFRow hssfRow) {
        int excelRow = row + 1 ;
        StringBuffer error = new StringBuffer() ;
        SysStaffUser info = new SysStaffUser() ;
        info.setExcelRow(excelRow) ;
        // name
        HSSFCell xh ;

        // 姓名

        try {
            xh = hssfRow.getCell(0) ;
            String name = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            info.setName(name.trim()) ;
            if (!ToolsUnits.isNOtNulll(name)) {
                error.append("姓名不能为空") ;
                info.setPaserSuccess(false) ;
            }
        } catch (PaserServiceException e) {
            error.append("姓名错误") ;
            info.setPaserSuccess(false) ;
        }
        try {
            // 性别
            xh = hssfRow.getCell(1) ;
            String sax = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (!ToolsUnits.isNOtNulll(sax)) {
                info.setPaserSuccess(false) ;
                error.append("性别不能为空") ;
            } else {
                if (sax.trim().equals("男")) {
                    info.setSex(1) ;
                } else if (sax.trim().equals("女")) {
                    info.setSex(0) ;
                } else {
                    error.append("性别(" + sax + ")只能为[男,女]") ;
                    info.setPaserSuccess(false) ;
                }

            }
        } catch (PaserServiceException e) {
            error.append("性别错误") ;
            info.setPaserSuccess(false) ;
        }
        try {
            // 手机
            xh = hssfRow.getCell(2) ;
            String phone = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            info.setCell(phone) ;
        } catch (PaserServiceException e) {
            error.append("手机错误") ;
            info.setPaserSuccess(false) ;
        }
        try {
            // 电话
            xh = hssfRow.getCell(3) ;
            String cell = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;

            info.setPhone(cell) ;
        } catch (PaserServiceException e) {
            error.append("电话错误") ;
            info.setPaserSuccess(false) ;
        }
        try {
            // 联系地址
            xh = hssfRow.getCell(4) ;
            String address = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;

            info.setAddress(address) ;
        } catch (PaserServiceException e) {
            error.append("联系地址错误") ;
            info.setPaserSuccess(false) ;
        }
        try {
            // 采购员?
            xh = hssfRow.getCell(5) ;
            String stock = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (ToolsUnits.isNOtNulll(stock.trim()) && (stock.trim().equals("是") || stock.trim().equals("否"))) {
                info.setIsStockMan(stock.trim().equals("是") ? 1 : 0) ;
            } else {
                error.append("采购员只能为[是,否]") ;
                info.setPaserSuccess(false) ;
            }

        } catch (PaserServiceException e) {
            error.append("采购员错误") ;
            info.setPaserSuccess(false) ;
        }
        try {
            // 业务员?
            xh = hssfRow.getCell(6) ;
            String isBiz = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (ToolsUnits.isNOtNulll(isBiz) && (isBiz.equals("是") || isBiz.equals("否"))) {
                info.setIsBizMan(isBiz.equals("是") ? 1 : 0) ;
            } else {
                error.append("业务员只能为[是,否]空") ;
                info.setPaserSuccess(false) ;
            }

        } catch (PaserServiceException e) {
            error.append("业务员错误") ;
            info.setPaserSuccess(false) ;
        }
        try {
            // 理货员?
            xh = hssfRow.getCell(7) ;
            String isGoodsMan = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (ToolsUnits.isNOtNulll(isGoodsMan) && (isGoodsMan.equals("是") || isGoodsMan.equals("否"))) {
                info.setIsGoodsMan(isGoodsMan.equals("是") ? 1 : 0) ;
            } else {
                error.append("理货员只能为[是,否]") ;
                info.setPaserSuccess(false) ;
            }
        } catch (PaserServiceException e) {
            error.append("理货员错误") ;
            info.setPaserSuccess(false) ;
        }
        try {
            // 运输联系人?
            xh = hssfRow.getCell(8) ;
            String isTransportContactMan = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (ToolsUnits.isNOtNulll(isTransportContactMan) && (isTransportContactMan.equals("是") || isTransportContactMan.equals("否"))) {
                info.setIsTransportMan(isTransportContactMan.equals("是") ? 1 : 0) ;
            } else {
                error.append("运输联系人只能为[是,否]") ;
                info.setPaserSuccess(false) ;
            }
        } catch (PaserServiceException e) {
            error.append("运输联系人错误") ;
            info.setPaserSuccess(false) ;
        }
        try {
            // 备注
            xh = hssfRow.getCell(9) ;
            String text = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            info.setText(text) ;
        } catch (PaserServiceException e) {
            error.append("备注错误") ;
            info.setPaserSuccess(false) ;
        }
        info.setImportErrorMsg(error.toString()) ;
        return info ;
    }

}
