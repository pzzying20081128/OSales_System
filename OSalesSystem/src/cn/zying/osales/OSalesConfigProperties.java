package cn.zying.osales ;

public interface OSalesConfigProperties {
    
    ////////////////////////////////////////////////////////////
    public static int isDefault_1 = 1 ;

    public static int isDefault_0 = 0 ;

    /////////////////// error///////////////////////////////////
    String USER_PASSWORD_ERROR = "用户名或密码错误" ;
    
    String USER_UPDATE_PASSWORD_ERROR = "更新密码错误" ;
    
    /////////////////////////////////////////////////////////////
    
    String query_sysStaffUser_searchByAccessName="sysStaffUser_searchByAccessName";
    
    String query_sysStaffUser_searchUserPower_userId="sysStaffUser_searchUserPower_userId";
    
    String query_sysStaffUser_searchUserPower_userId_moduleId="sysStaffUser_searchUserPower_userId_moduleId";
    
    

    public enum OptType {
        save, update, check, delete,list,search
    }

    public enum Status {
        无效, 删除, 正常
    }

}
