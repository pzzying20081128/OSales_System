package cn.zying.osales.imports.paser ;

import java.io.File ;
import java.io.FileInputStream ;
import java.io.InputStream ;
import java.util.ArrayList ;
import java.util.List ;

import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.EntityTransaction ;

import org.apache.poi.hssf.usermodel.HSSFCell ;
import org.apache.poi.hssf.usermodel.HSSFRow ;
import org.apache.poi.hssf.usermodel.HSSFSheet ;
import org.apache.poi.hssf.usermodel.HSSFWorkbook ;

import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.commons.CommBean ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.IPropertiesCacheFactory ;

public abstract class PaserExcelUnits<V> {

    private EntityManagerFactory entityManagerFactory ;

    protected IPropertiesCacheFactory cacheFactory ;

    public PaserExcelUnits(EntityManagerFactory entityManagerFactory, IPropertiesCacheFactory cacheFactory) {
        super() ;
        this.entityManagerFactory = entityManagerFactory ;
        this.cacheFactory = cacheFactory ;
    }

    protected abstract V paserExcelRow(int row, HSSFRow hssfRow) ;

    //    protected abstract boolean verificationPaserRow(V units) ;

    protected List<V> paser(File file, EntityManager entityManager) throws SystemOptServiceException {
        try {

            List<V> errorList = new ArrayList<V>() ;

            InputStream in = new FileInputStream(file) ;
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(in) ;
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0) ;

            for (int rowNum = 1; rowNum <= hssfSheet.getPhysicalNumberOfRows(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum) ;
                if (hssfRow == null) continue ;
                boolean haveNext = false ;
                for (int i = 0; i < hssfRow.getPhysicalNumberOfCells(); i++) {
                    HSSFCell hssfCell = hssfRow.getCell(i) ;
                    haveNext = ExcelUnits.getValueNUll(hssfCell) ;
                    if (haveNext == false) break ;

                }
                if (haveNext == true) continue ;

                V v = paserExcelRow(rowNum, hssfRow) ;

                CommBean commBean = (CommBean) v ;
                //
                boolean result = commBean.isPaserSuccess() ;
                if (result) {
                    commBean.setStatus(Status.有效) ;
                    //                    entityManager.persist(v) ;
                }
                //                } else {
                errorList.add(v) ;
                //                }
            }
            return errorList ;
        } catch (Exception e) {

            throw new SystemOptServiceException(e) ;

        }
    }

    public ImportServiceResult<V> paserExcel(File file) throws SystemOptServiceException {
        EntityManager entityManager = entityManagerFactory.createEntityManager() ;
        EntityTransaction transaction = entityManager.getTransaction() ;
        try {
            ImportServiceResult<V> importError = new ImportServiceResult<V>() ;

            transaction.begin() ;
            List<V> results = paser(file, entityManager) ;

            for (V result : results) {
                CommBean commBean = (CommBean) result ;
                if (commBean.isPaserSuccess()) entityManager.persist(result) ;
            }

            importError.setErrorResult(results) ;
            wirteImportError(results) ;
            transaction.commit() ;
            return importError ;
        } catch (Exception e) {
            transaction.rollback() ;
            throw new SystemOptServiceException(e) ;
        }

    }

    private String wirteImportError(List<V> results) throws SystemOptServiceException {

        String projectRealPath = "/tmp" ;
        File file = new File(projectRealPath) ;
        if (!file.exists()) {
            if (!file.mkdirs()) throw new SystemOptServiceException("创建路径出错!" + projectRealPath) ;
        }

        for (V result : results) {
            CommBean commBean = (CommBean) result ;
            if (!commBean.isPaserSuccess()) {

            }
        }

        return "xxx.excel" ;

    }
}
