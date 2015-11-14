package cn.zying.osales.service ;

import cn.zy.apps.tools.jpa.ServiceException ;

public class SystemOptServiceException extends ServiceException {

    public SystemOptServiceException() {
        super() ;

    }

    public SystemOptServiceException(String message, Throwable cause) {
        super(message, cause) ;

    }

    public SystemOptServiceException(String message) {
        super(message) ;

    }

    public SystemOptServiceException(Throwable cause) {
        super(cause) ;

    }

}
