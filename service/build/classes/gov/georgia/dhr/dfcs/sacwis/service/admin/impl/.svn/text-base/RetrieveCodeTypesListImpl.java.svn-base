package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

/**
 * This class is used to retrieve the modifiable code types list. <p/> <p/>
 * 
 * <pre>
 *                          Change History:
 *                           Date          User                    Description
 *                           ----------    --------------------    ----------------------
 *                           07/16/2008     vdevarakonda           Initial class creation
 */

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.CodesTablesInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTablesInfo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveCodeTypesList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CodeTypesRetrieveSO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RetrieveCodeTypesListImpl extends BaseServiceImpl implements RetrieveCodeTypesList {

  private CodesTablesInfoDAO codesTablesInfoDAO = null;

  public void setCodesTablesInfoDAO(CodesTablesInfoDAO codesTablesInfoDAO) {
    this.codesTablesInfoDAO = codesTablesInfoDAO;
  }

  @SuppressWarnings( { "unchecked" })
  public List<CodeTypesRetrieveSO> retrieveCodeTypesList() throws ServiceException {
    List<CodesTablesInfo> codeTablesList = codesTablesInfoDAO.findUpdatableCodeTypes();
    List<CodeTypesRetrieveSO> codeTypesList = new ArrayList<CodeTypesRetrieveSO>();
    if (codeTablesList != null && codeTablesList.size() > 0) {
      for (Iterator it = codeTablesList.iterator(); it.hasNext();) {
        CodesTablesInfo codesTablesInfo = (CodesTablesInfo) it.next();
        CodeTypesRetrieveSO codeTypesRetrieveSO = new CodeTypesRetrieveSO();
        codeTypesRetrieveSO.setCodeType(codesTablesInfo.getCodeType());
        codeTypesRetrieveSO.setTransType(codesTablesInfo.getTransType());
        codeTypesRetrieveSO.setDesc(codesTablesInfo.getCodeTypeDesc());
        codeTypesList.add(codeTypesRetrieveSO);
      }
    }
    return codeTypesList;
  }
}