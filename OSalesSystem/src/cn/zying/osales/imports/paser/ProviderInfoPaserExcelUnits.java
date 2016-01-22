package cn.zying.osales.imports.paser ;

import javax.persistence.EntityManagerFactory ;

import org.apache.poi.hssf.usermodel.HSSFCell ;
import org.apache.poi.hssf.usermodel.HSSFRow ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.PaymentMethod ;
import cn.zying.osales.OSalesConfigProperties.ReturnType ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.units.IPropertiesCacheFactory ;
import cn.zying.osales.units.ToolsRegex ;
import cn.zying.osales.web.aop.IAopProviderInfoService ;
import cn.zying.osales.web.aop.IAopSystemUserService ;

public class ProviderInfoPaserExcelUnits extends PaserExcelUnits<ProviderInfo> {

    private IAopProviderInfoService service ;

    private IAopSystemUserService aopSystemUserService ;

    public ProviderInfoPaserExcelUnits(EntityManagerFactory entityManagerFactory, IPropertiesCacheFactory cacheFactory) {
        super(entityManagerFactory, cacheFactory) ;

    }

    public void setService(IAopProviderInfoService service) {
        this.service = service ;
    }

    /**
    0 供应商 
    1 助记符 
    2 付款方式    
    3 采购员 
    4 帐期  
    5 地址  
    6 联系人 
    7 传真  
    8 网址  
    9 qq  
    10 电子邮箱    
    11退货类型    
    12银行帐号    
    13银行帐号1   
    14备注

    **/
    @Override
    protected ProviderInfo paserExcelRow(int row, HSSFRow hssfRow) {

        int excelRow = row + 1 ;
        StringBuffer error = new StringBuffer() ;
        ProviderInfo info = new ProviderInfo() ;
        info.setExcelRow(excelRow) ;

        // 0 : 名称1
        HSSFCell xh = hssfRow.getCell(0) ;
        try {
            String 名称1 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (!ToolsUnits.isNOtNulll(名称1)) {
                error.append("名字为空") ;
                info.setPaserSuccess(false) ;
            } else {
                info.setName(名称1) ;
                info.setPaserSuccess(true) ;
            }
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }

        xh = hssfRow.getCell(1) ;
        try {
            String 助记符1 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (!ToolsUnits.isNOtNulll(助记符1)) {
                error.append("助记符为空") ;
                info.setPaserSuccess(false) ;
            } else {
                info.setShortName(助记符1) ;
                info.setPaserSuccess(true) ;
            }
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }
        // 3 付款方式     
        xh = hssfRow.getCell(2) ;
        try {
            String 付款方式1 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (ToolsUnits.isNOtNulll(付款方式1)) {
                if (!付款方式1.equals("月结") && !付款方式1.equals("到付") && !付款方式1.equals("预付")) {
                    error.append("付款方式应为[月结 , 到付,预付];") ;
                    info.setPaserSuccess(false) ;

                } else {
                    info.setPaymentMethod(PaymentMethod.valueOf(付款方式1)) ;
                    info.setPaserSuccess(true) ;
                }
            }
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }

        //3 采购员 
        xh = hssfRow.getCell(3) ;
        try {
            String 采购员1 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (ToolsUnits.isNOtNulll(采购员1)) {
                SysStaffUser 采购员1_ = aopSystemUserService.searchByName(采购员1) ;
                if (采购员1_ == null) {
                    info.setStockMan(null) ;
                } else {
                    info.setStockMan(采购员1_) ;
                    info.setPaserSuccess(true) ;
                }
            }
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }

        // 4 帐期  
        xh = hssfRow.getCell(4) ;
        try {
            String 账期0 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.INT) ;
            if (ToolsUnits.isNOtNulll(账期0)) {
                if (!ToolsRegex.regex("^[1-9]\\d*$", 账期0)) {
                    error.append("账期[" + 账期0 + "]错误") ;
                } else
                    info.setSettleTime(ToolsUnits.isNOtNulll(账期0) ? (Integer.parseInt(账期0)) : null) ;
            }
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }

        // 6地址
        try {
            xh = hssfRow.getCell(5) ;
            String 地址0 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            info.setAddress(地址0) ;
            //           6 联系人 
            xh = hssfRow.getCell(6) ;
            String 联系人0 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            info.setContactMan(联系人0) ;
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }

        //            7 传真  
        try {
            xh = hssfRow.getCell(7) ;
            String 传真0 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (ToolsUnits.isNOtNulll(传真0)) {
                if (!ToolsRegex.regex("^[1-9]\\d*$", 传真0)) {
                    error.append("传真[" + 传真0 + "]格式不对") ;
                } else {
                    info.setFax(传真0) ;
                }
            } else {
                info.setFax(null) ;
            }

        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }

        //        8 网址  
        try {
            xh = hssfRow.getCell(8) ;
            String 主页0 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (ToolsUnits.isNOtNulll(主页0)) {
                info.setWeb(null) ;
            } else {
                info.setWeb(主页0) ;
            }
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }

        //        9 qq  
        try {
            xh = hssfRow.getCell(9) ;
            String QQ0 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (ToolsUnits.isNOtNulll(QQ0)) {
                info.setQq(QQ0) ;
            } else {
                info.setQq(null) ;
            }
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }
        try {
            //10 电子邮箱    
            xh = hssfRow.getCell(10) ;
            String 电子邮件0 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (ToolsUnits.isNOtNulll(电子邮件0)) {
                info.setMail(电子邮件0) ;
            } else {

            }
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }
        try {
            //         11退货类型    
            xh = hssfRow.getCell(10) ;
            String 退货类型1 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            if (!ToolsUnits.isNOtNulll(退货类型1)) {
                error.append("退货类型为空") ;
            } else {
                if (!退货类型1.equals("不确定") && !退货类型1.equals("开票前退货") && !退货类型1.equals("开票后退货")) {
                    error.append("付款方式应为[不确定 ,开票前退货 ,开票后退货]") ;
                } else {
                    info.setReturnType(ReturnType.valueOf(退货类型1)) ;
                }
            }
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }

        try {
            //        12银行帐号    
            xh = hssfRow.getCell(12) ;
            String 银行帐号0 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            info.setBank1(银行帐号0) ;
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }
        try {
            //         13银行帐号1   
            xh = hssfRow.getCell(13) ;
            String 银行帐号1 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            info.setBank2(银行帐号1) ;
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }

        try {
            //         14备注
            xh = hssfRow.getCell(14) ;
            String 备注 = ExcelUnits.getValue(xh, ExcelUnits.ExcelType.STRING) ;
            info.setText(备注) ;
        } catch (Exception e) {
            error.append(e.getMessage()) ;
            info.setPaserSuccess(false) ;
        }
        return info ;
    }
}
