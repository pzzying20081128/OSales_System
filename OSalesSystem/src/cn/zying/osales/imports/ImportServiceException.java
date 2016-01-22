package cn.zying.osales.imports ;

public class ImportServiceException extends Exception {

    private static final long serialVersionUID = 6105721493198682435L ;

    public ImportServiceException() {
        super() ;

    }

    public ImportServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace) ;

    }

    public ImportServiceException(String message, Throwable cause) {
        super(message, cause) ;

    }

    public ImportServiceException(String message) {
        super(message) ;

    }

    public ImportServiceException(Throwable cause) {
        super(cause) ;

    }

}
