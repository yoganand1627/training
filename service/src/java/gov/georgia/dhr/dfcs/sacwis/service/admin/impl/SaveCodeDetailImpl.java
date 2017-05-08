package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

/**
 * This DAO contains sql that saves data into the CodesTables table. <p/>
 * 
 * <pre>
 *    Change History:
 *    Date          User              Description
 *    ----------    ------------      --------------------------------------------------
 *    07/18/2008    vdevarakonda      Initial class creation           
 * </pre>
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.CodesTablesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CodesTablesHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTablesHistory;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTablesId;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveCodeDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CodeDetailSaveSI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaveCodeDetailImpl extends BaseServiceImpl implements SaveCodeDetail {

  private CodesTablesDAO codesTablesDAO = null;

  private CodesTablesHistoryDAO codesTablesHistoryDAO = null;

  public void setCodesTablesDAO(CodesTablesDAO codesTablesDAO) {
    this.codesTablesDAO = codesTablesDAO;
  }

  public void setCodesTablesHistoryDAO(CodesTablesHistoryDAO codesTablesHistoryDAO) {
    this.codesTablesHistoryDAO = codesTablesHistoryDAO;
  }

  public void saveCodeDetail(CodeDetailSaveSI codeDetailSaveSI) throws ServiceException {
    CodesTablesId codesTableId = null;
    CodesTablesId id = new CodesTablesId();
    Date dtEnd = codeDetailSaveSI.getDtEnd();
    gov.georgia.dhr.dfcs.sacwis.db.CodesTables codesTables = new gov.georgia.dhr.dfcs.sacwis.db.CodesTables();
    int idEmployee = codeDetailSaveSI.getIdEmployee();
    int nbrRows = 0;
    String code = codeDetailSaveSI.getCode();
    String codeType = codeDetailSaveSI.getCodeType();
    String decode = codeDetailSaveSI.getDecode();
    String transType = codeDetailSaveSI.getTransType();
    // A check is performed on the code to see if it already exists while inserting a new row
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(codeDetailSaveSI.getCdReqFunc()) && codeType != null
        && codeType.length() > 0) {
      List<String> codesList = new ArrayList<String>();
      codesList = codesTablesDAO.findCodesList(codeType);
      if (codesList != null && codesList.size() > 0 && codesList.contains(code)) {
        throw new ServiceException(Messages.MSG_CODES_TABLE_CODE_EXISTS);
      }
    }
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(codeDetailSaveSI.getCdReqFunc())) {
      // If the transaction type is limited update only the decode
      if (CodesTables.CCTUPDT_L.equals(transType)) {
        nbrRows = codesTablesDAO.updateCodeDetail(codeType, code, decode);
      } else if (CodesTables.CCTUPDT_F.equals(transType)) {
        // If the transaction type is Full update decode and end date
        nbrRows = codesTablesDAO.updateCodeDetail(codeType, code, decode, dtEnd);
      }
      if (nbrRows == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else {
      id.setCodeType(codeType);
      id.setCode(code);
      codesTables.setId(id);
      codesTables.setDecode(decode);
      codesTables.setDtEnd(dtEnd);
      codesTableId = codesTablesDAO.saveCodeDetail(codesTables);
      if (codesTableId == null) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }
    // If the codes tables is successfully updated than the transaction is recorded in the
    // CodesTablesHistory table
    CodesTablesHistory codesTableHistory = new CodesTablesHistory();
    codesTableHistory.setCodeType(codeType);
    codesTableHistory.setCode(code);
    codesTableHistory.setDecode(decode);
    codesTableHistory.setTransType(transType);
    codesTableHistory.setDtEnd(dtEnd);
    Person person = new Person();
    person = (Person) getPersistentObject(Person.class, idEmployee);
    codesTableHistory.setPerson(person);
    codesTablesHistoryDAO.saveCodeDetail(codesTableHistory);
  }
}
