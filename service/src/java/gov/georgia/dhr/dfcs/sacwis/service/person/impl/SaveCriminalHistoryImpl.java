package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Date;
import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.CriminalHistNarrDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CriminalHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CriminalHistory;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCriminalHistory;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC32SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC32SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC32SO;

public class SaveCriminalHistoryImpl extends BaseServiceImpl implements SaveCriminalHistory {

  private CriminalHistoryDAO criminalHistoryDAO = null;

  private CriminalHistNarrDAO criminalHistNarrDAO = null;

  public void setCriminalHistoryDAO(CriminalHistoryDAO criminalHistoryDAO) {
    this.criminalHistoryDAO = criminalHistoryDAO;
  }

  public void setCriminalHistNarrDAO(CriminalHistNarrDAO criminalHistNarrDAO) {
    this.criminalHistNarrDAO = criminalHistNarrDAO;

  }

  public CCFC32SO saveCriminalHistory(CCFC32SI ccfc32si) throws ServiceException {
    ROWCCFC32SIG00_ARRAY rowccfc32sig00_array = ccfc32si.getROWCCFC32SIG00_ARRAY();
    Enumeration rowccfc32sig00_enum = rowccfc32sig00_array.enumerateROWCCFC32SIG00();
    while (rowccfc32sig00_enum.hasMoreElements()) {
      ROWCCFC32SIG00 rowccfc32sig00 = (ROWCCFC32SIG00) rowccfc32sig00_enum.nextElement();
      String cdScrDataAction = rowccfc32sig00.getSzCdScrDataAction();
      int idRecCheck = rowccfc32sig00.getUlIdRecCheck();
      String cdCrimHistAction = rowccfc32sig00.getSzCdCrimHistAction();
      String nmCrimHistReturned = rowccfc32sig00.getSzNmCrimHistReturned();
      String txtCrimHistCmnts = rowccfc32sig00.getSzTxtCrimHistCmnts();
      int idCrimHist = rowccfc32sig00.getUlIdCrimHist();
      Date dtLastUpdate = rowccfc32sig00.getTsLastUpdate();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)) {
        // caud92d
        criminalHistoryDAO.insertCriminalHistory(idRecCheck, cdCrimHistAction, nmCrimHistReturned, txtCrimHistCmnts);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
        CriminalHistory criminalHistory = new CriminalHistory();
        RecordsCheck recordsCheck = (RecordsCheck) getPersistentObject(RecordsCheck.class, idRecCheck);
        criminalHistory.setRecordsCheck(recordsCheck);
        criminalHistory.setCdCrimHistAction(cdCrimHistAction);
        criminalHistory.setNmCrimHistReturned(nmCrimHistReturned);
        criminalHistory.setTxtCrimHistCmnts(txtCrimHistCmnts);
        // caud92d
        criminalHistoryDAO.saveCriminalHistory(criminalHistory);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {
        // caud92d
        if (0 == criminalHistoryDAO.deleteCriminalHistory(idCrimHist, dtLastUpdate)) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }

      if (ArchitectureConstants.Y.equals(rowccfc32sig00.getCIndDeleteNarr())) {
        // cmsc37d
        criminalHistNarrDAO.deleteCriminalHistNarr(idCrimHist);
      }

    }
    // return object is empty
    return new CCFC32SO();
  }
}
