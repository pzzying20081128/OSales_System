package cn.zying.osales.units.search.bean ;

import cn.zying.osales.pojos.StockInvoice ;

public class StockInvoiceSearchBean extends StockInvoice {

    private static final long serialVersionUID = 4794708098358197182L ;

    private java.util.Date openStartTime ;

    private java.util.Date openEndTime ;

    private java.util.Date paymentStartTime ;

    private java.util.Date paymentEndTime ;

    public java.util.Date getOpenStartTime() {
        return openStartTime ;
    }

    public void setOpenStartTime(java.util.Date openStartTime) {
        this.openStartTime = openStartTime ;
    }

    public java.util.Date getOpenEndTime() {
        return openEndTime ;
    }

    public void setOpenEndTime(java.util.Date openEndTime) {
        this.openEndTime = openEndTime ;
    }

    public java.util.Date getPaymentStartTime() {
        return paymentStartTime ;
    }

    public void setPaymentStartTime(java.util.Date paymentStartTime) {
        this.paymentStartTime = paymentStartTime ;
    }

    public java.util.Date getPaymentEndTime() {
        return paymentEndTime ;
    }

    public void setPaymentEndTime(java.util.Date paymentEndTime) {
        this.paymentEndTime = paymentEndTime ;
    }

}
