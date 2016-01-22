package cn.zying.osales.imports ;

import java.io.File ;

import cn.zying.osales.imports.paser.ImportServiceResult ;

public interface ImportService<V> {

    public ImportServiceResult<V> imports(File file) throws ImportServiceException ;

}
