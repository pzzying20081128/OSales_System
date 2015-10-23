package cn.zying.osales.service ;

import java.text.SimpleDateFormat ;
import java.util.Date ;
import java.util.List ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.jpa.ERPBaseService ;
import cn.zying.osales.pojos.SerialNum ;

@Component(IABService.name)
public class ABServiceImples extends ERPBaseService implements IABService {

    @Override
    public String genSerialNum(String prefix) {
        int byte_count = 6 ;
        String num = "" ;
        Date date = new Date() ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd") ;
           Long total_count = this.findSinglenessByHSQL("SELECT COUNT(*) FROM SerialNum WHERE pre='" + prefix + "' AND date= '" + sdf.format(date) + "'") ;
        List<SerialNum> list ;
        if (total_count > 0) list = this.findByHSQL("FROM SerialNum WHERE pre='" + prefix + "'  AND date= '" + sdf.format(date) + "' ORDER BY id ASC  ", total_count.intValue() - 1, total_count.intValue()) ;
        else
            list = this.findByHSQL("FROM SerialNum WHERE pre='" + prefix + "'  AND date= '" + sdf.format(date) + "' ORDER BY id ASC  ") ;
        int tmp_num = 1 ;
        SerialNum sn = new SerialNum() ;
        StringBuffer sb = new StringBuffer() ;
        if (list != null && list.size() == 1) {
            sn = (SerialNum) list.get(0) ;
            tmp_num = sn.getSerialNum() + 1 ;
        }
        int str_len = (tmp_num + "").length() ;
        if (str_len < byte_count) {
            for (int i = 0; i < byte_count - str_len - 1; i++) {
                sb.append("0") ;
            }
        }
        sn = new SerialNum() ;
        sn.setDate(sdf.format(date)) ;
        sn.setPre(prefix) ;
        sn.setSerialNum(tmp_num) ;
        this.save(sn) ;
        num = sdf.format(date) + "-" + sb.toString() + (tmp_num + "") ;
        return prefix + "-" + num ;
    }

}
