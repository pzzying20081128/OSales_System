package cn.zying.osales.service ;

import java.text.SimpleDateFormat ;
import java.util.Date ;
import java.util.List ;

import javax.persistence.EntityManager ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.jpa.ERPBaseService ;
import cn.zying.osales.pojos.SerialNum ;

@Component(IABService.name)
public class ABServiceImples extends ERPBaseService implements IABService {

    private static SimpleDateFormat sdfs = new SimpleDateFormat("yyyyMMdd") ;

    private static int byte_count = 6 ;

    @Override
    public String genSerialNum(String prefix) {
        Date date = new Date() ;
        String timeDay = sdfs.format(date) ;
        List<SerialNum> list = this.findByHSQL("FROM SerialNum WHERE pre='" + prefix + "'  AND date= '" + timeDay + "' ORDER BY id desc  ", 0, 1) ;
        Integer tmp_num = (list != null && list.size() == 1) ? list.get(0).getSerialNum() + 1 : 1 ;
        SerialNum sn = new SerialNum() ;
        sn.setDate(timeDay) ;
        sn.setPre(prefix) ;
        sn.setSerialNum(tmp_num) ;
        this.save(sn) ;
        String sb = tmp_num.toString() ;
        int str_len = (tmp_num.toString()).length() ;
        if (str_len < byte_count) {
            for (int i = 0; i < byte_count - str_len - 1; i++) {
                sb = "0" + sb ;
            }
        }
        String num = prefix + "-" + timeDay + "-" + sb ;
        return num ;
    }

    @Override
    public EntityManager getEm() {

        return getEntityManager() ;
    }

}
