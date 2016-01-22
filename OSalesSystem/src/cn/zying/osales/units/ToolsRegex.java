package cn.zying.osales.units ;

import java.util.regex.Matcher ;
import java.util.regex.Pattern ;

public class ToolsRegex {

    //税率100.00  23.23 23.33% 4位小数
    //    private static String tax_rate = "(^[-+]?[1-9]\\d*(\\.\\d{1,4})?%??$)|(^[-+]?[0]{1}(\\.\\d{1,4})?%??$)" ;
    private static String tax_rate = "(^[1-9]\\d*(\\.\\d{1,4})?%??$)|(^[0]{1}(\\.\\d{1,4})?%??$)" ;

    //    private static String tax_rate = "(^[0-9]\\d*(\\.\\d{1,4})?%??$)|(^[0]{1}(\\.\\d{1,4})?%??$)" ;
    private static String meoney = "(^[0-9]\\d*(\\.\\d{1,4})?$)|(^[0]{1}(\\.\\d{1,4})?$)" ;

    //全数字
    public static String number = "^[-+]?[0-9]\\d*$" ;

    public static String numberXs = "(^[0-9]\\d*$)|(^[0-9]\\d*(\\.\\d*)?$)" ;

    public static String excel_number = "(^[-+]?[0-9]\\d*$)|(^[1-9]\\d*(\\.0)?$)" ;

    public static boolean regex(String regex, String input) {
        return matcher(regex, input) ;
    }

    /**
     * 匹配是否是税率
     * @param input
     * @return
     */
    public static boolean regexTaxRate(String input) {
        return matcher(tax_rate, input) ;
    }

    /**
     * 匹配是否全数字
     * @param input
     * @return
     */
    public static boolean regexNumber(String input) {
        return matcher(number, input) ;
    }

    /**
     * 匹配是否是钱
     * @param input
     * @return
     */
    public static boolean regexMoney(String input) {
        return matcher(meoney, input) ;
    }

    private static boolean matcher(String zz, String matcherStr) {
        //        //System.out.println("==================|" + matcherStr + "|") ;
        Pattern pattern = Pattern.compile(zz) ;
        Matcher matcher = pattern.matcher(matcherStr) ;
        boolean b = matcher.matches() ;
        return b ;
    }

    public static void main(String[] args) {
        System.out.println("==>  " + ToolsRegex.regexTaxRate("10.0")) ;
        System.out.println("==>  " + ToolsRegex.regexMoney("0.00")) ;
        System.out.println("==>  " + ToolsRegex.regexNumber("1102")) ;

        System.out.println("==> 1  " + ToolsRegex.regex(ToolsRegex.numberXs, "12")) ;
        System.out.println("==> 2  " + ToolsRegex.regex(ToolsRegex.numberXs, "12.0d")) ;

        System.out.println("==> 1  excel_number   | " + ToolsRegex.regex(ToolsRegex.numberXs, "12.0")) ;
    }
}
