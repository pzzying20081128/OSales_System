package cn.zying.osales.units.search.bean ;

import java.util.Date ;

import cn.zying.osales.pojos.SysOptHistory ;

public class SysOptHistorySearchBean extends SysOptHistory {

    private Date startTime ;

    private Date endTime ;

    public Date getStartTime() {
        return startTime ;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime ;
    }

    public Date getEndTime() {
        return endTime ;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime ;
    }

}
