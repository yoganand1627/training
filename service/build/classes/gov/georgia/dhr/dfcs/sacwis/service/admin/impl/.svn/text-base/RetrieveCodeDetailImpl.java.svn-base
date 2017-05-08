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
import gov.georgia.dhr.dfcs.sacwis.dao.CodesTablesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CodesTablesInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTablesInfo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveCodeDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CodesTableDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CodesTableDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CodesTablesStruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RetrieveCodeDetailImpl extends BaseServiceImpl implements RetrieveCodeDetail {

  private CodesTablesDAO codesTablesDAO = null;

  private CodesTablesInfoDAO codesTablesInfoDAO = null;

  public void setCodesTablesInfoDAO(CodesTablesInfoDAO codesTablesInfoDAO) {
    this.codesTablesInfoDAO = codesTablesInfoDAO;
  }

  public void setCodesTablesDAO(CodesTablesDAO codesTablesDAO) {
    this.codesTablesDAO = codesTablesDAO;
  }

  @SuppressWarnings( { "unchecked" })
  public CodesTableDetailRetrieveSO retrieveCodeDetail(CodesTableDetailRetrieveSI codesTblDtlRtrvSI)
                                                                                                    throws ServiceException {
    String codeType = codesTblDtlRtrvSI.getCodeType();
    String code = codesTblDtlRtrvSI.getCode();
    CodesTableDetailRetrieveSO codesTableDetailRetrieveSO = new CodesTableDetailRetrieveSO();
    // Retrieving the transaction type and the description of the given code type
    CodesTablesInfo codesTablesInfo = codesTablesInfoDAO.findCodeTypeDetail(codeType);
    if (codesTablesInfo != null) {
      codesTableDetailRetrieveSO.setCodeType(codesTablesInfo.getCodeType());
      codesTableDetailRetrieveSO.setTransType(codesTablesInfo.getTransType());
      codesTableDetailRetrieveSO.setDesc(codesTablesInfo.getCodeTypeDesc());
    }
    // Retrieve the code detail only if it is an update
    if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(codesTblDtlRtrvSI.getCdReqFunc())) {
      List<CodesTablesStruct> codesTablesStructList = new ArrayList<CodesTablesStruct>();
      Map codeDetail = codesTablesDAO.findCodesTableDetail(codeType, code);
      if (codeDetail != null) {
        CodesTablesStruct codeTblStruct = new CodesTablesStruct();
        codeTblStruct.setCode((String) codeDetail.get("code"));
        codeTblStruct.setDecode((String) codeDetail.get("decode"));
        codeTblStruct.setEndDate((Date) codeDetail.get("dtEnd"));
        codesTablesStructList.add(codeTblStruct);
      }
      codesTableDetailRetrieveSO.setCodesTablesStructList(codesTablesStructList);
    }
    return codesTableDetailRetrieveSO;
  }
}
