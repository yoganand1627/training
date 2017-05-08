package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

/**
 * This class is used to retrieve all the code, decode end date combinations for a given code type. <p/> <p/>
 * 
 * <pre>
 *                          Change History:
 *                           Date          User                    Description
 *                           ----------    --------------------    ----------------------
 *                           07/17/2008     vdevarakonda           Initial class creation
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.CodesTablesInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicCodesTablesDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTablesInfo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveCodesTableDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CodesTableDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CodesTableDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CodesTablesStruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RetrieveCodesTableDetailImpl extends BaseServiceImpl implements RetrieveCodesTableDetail {
  private DynamicCodesTablesDAO dynamicCodesTablesDAO = null;

  private CodesTablesInfoDAO codesTablesInfoDAO = null;

  public void setCodesTablesInfoDAO(CodesTablesInfoDAO codesTablesInfoDAO) {
    this.codesTablesInfoDAO = codesTablesInfoDAO;
  }

  public DynamicCodesTablesDAO getDynamicCodesTablesDAO() {
    return dynamicCodesTablesDAO;
  }

  public void setDynamicCodesTablesDAO(DynamicCodesTablesDAO dynamicCodesTablesDAO) {
    this.dynamicCodesTablesDAO = dynamicCodesTablesDAO;
  }

  @SuppressWarnings( { "unchecked" })
  public CodesTableDetailRetrieveSO retrieveCodesTableDetail(CodesTableDetailRetrieveSI codesTblDtlRtrvSI)
                                                                                                          throws ServiceException {
    String codeType = codesTblDtlRtrvSI.getCodeType();
    ArchOutputStruct aos = new ArchOutputStruct();
    String bMoreDataInd = "N";
    String cdSortBy = codesTblDtlRtrvSI.getBWcdCdSortBy();

    int pageNbr = codesTblDtlRtrvSI.getArchInputStruct().getUsPageNbr();
    int pageSize = codesTblDtlRtrvSI.getArchInputStruct().getUlPageSizeNbr();
    boolean sortAscending = ServiceConstants.SORT_ASCENDING.equals(codesTblDtlRtrvSI.getSzSortDir());
    PaginatedHibernateList<Object[]> codeTablesList = dynamicCodesTablesDAO.findCodesTableDetail(codeType, cdSortBy,
                                                                                                 pageNbr, pageSize,
                                                                                                 sortAscending);
    List<CodesTablesStruct> codeTblStructList = new ArrayList<CodesTablesStruct>();
    CodesTableDetailRetrieveSO codesTblDtlRetSO = new CodesTableDetailRetrieveSO();
    CodesTablesInfo codesTablesInfo = codesTablesInfoDAO.findCodeTypeDetail(codeType);
    codesTblDtlRetSO.setCodeType(codesTablesInfo.getCodeType());
    codesTblDtlRetSO.setTransType(codesTablesInfo.getTransType());
    codesTblDtlRetSO.setDesc(codesTablesInfo.getCodeTypeDesc());

    if (codeTablesList != null && codeTablesList.size() > 0) {
      for (Iterator<Object[]> it = codeTablesList.iterator(); it.hasNext();) {
        Object[] objectArray = it.next();
        bMoreDataInd = codeTablesList.getBMoreDataInd();
        CodesTablesStruct codeTblStruct = new CodesTablesStruct();
        String code = (String) objectArray[0];
        String decode = (String) objectArray[1];
        Date endDate = (Date) objectArray[2];
        codeTblStruct.setCode(code);
        codeTblStruct.setDecode(decode);
        codeTblStruct.setEndDate(endDate);
        codeTblStructList.add(codeTblStruct);
      }
    }
    codesTblDtlRetSO.setCodesTablesStructList(codeTblStructList);
    aos.setBMoreDataInd(bMoreDataInd);
    codesTblDtlRetSO.setArchOutputStruct(aos);
    return codesTblDtlRetSO;
  }
}