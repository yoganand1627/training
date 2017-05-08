package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.CriminalHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CriminalHistory;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveCriminalHistory;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00_ARRAY;

public class RetrieveCriminalHistoryImpl extends BaseServiceImpl implements RetrieveCriminalHistory {

  private CriminalHistoryDAO criminalHistoryDAO = null;

  public void setCriminalHistoryDAO(CriminalHistoryDAO criminalHistoryDAO) {
    this.criminalHistoryDAO = criminalHistoryDAO;
  }

  public CCFC31SO retrieveCriminalHistory(CCFC31SI ccfc31si) {
    CCFC31SO ccfc31so = new CCFC31SO();
    //clsc57d
    List<CriminalHistory> criminalHistoryList =
            criminalHistoryDAO.findCriminalHistoryByIdRecCheck(ccfc31si.getUlIdRecCheck());
    ROWCCFC31SOG00_ARRAY rowccfc31sog00_array = new ROWCCFC31SOG00_ARRAY();
    if (criminalHistoryList != null) {
      for (Iterator<CriminalHistory> it = criminalHistoryList.iterator(); it.hasNext();) {
        CriminalHistory row = it.next();
        ROWCCFC31SOG00 rowccfc31sog00 = new ROWCCFC31SOG00();
        rowccfc31sog00.setSzCdCrimHistAction(row.getCdCrimHistAction());
        rowccfc31sog00.setSzNmCrimHistReturned(row.getNmCrimHistReturned());
        rowccfc31sog00.setSzTxtCrimHistCmnts(row.getTxtCrimHistCmnts());
        rowccfc31sog00.setUlIdCrimHist(row.getIdCrimHist() != null ? row.getIdCrimHist() : 0);
        rowccfc31sog00.setTsLastUpdate(row.getDtLastUpdate());
        rowccfc31sog00_array.addROWCCFC31SOG00(rowccfc31sog00);
      }
    }
    ccfc31so.setROWCCFC31SOG00_ARRAY(rowccfc31sog00_array);
    return ccfc31so;
  }

}
