package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.RejectionReasonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RejectionReason;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveRejectionReason;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN09SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN09SOG00_ARRAY;

public class RetrieveRejectionReasonImpl extends BaseServiceImpl implements RetrieveRejectionReason {
  private RejectionReasonDAO rejectionReasonDAO = null;

  public void setRejectionReasonDAO(RejectionReasonDAO rejectionReasonDAO) {
    this.rejectionReasonDAO = rejectionReasonDAO;
  }

  public CFIN09SO retrieveRejectionReason(CFIN09SI cfin09si) throws ServiceException {
    CFIN09SO cfin09so = new CFIN09SO();
    /*
    ** Call CAUD08D The Contract County AUD performs a full row insert,
    ** update or delete to the Contract County table.
    */
    // convert clss03dQUERYdam() to rejectionReasonDAO.findRejectionReasonByIdRejItemCdRejRsnRejected()
    List<RejectionReason> rejectReasonList =
            rejectionReasonDAO.findRejectionReasonByIdRejItemCdRejRsnRejected(cfin09si.getUlIdRejectedItemId(),
                                                                              cfin09si.getSzCdRejRsnRejItemId());
    if (rejectReasonList == null) {
      throw new ServiceException(Messages.MSG_DETAIL_DELETED);
    }
    ROWCFIN09SOG00_ARRAY rowcfin09sog00_array = new ROWCFIN09SOG00_ARRAY();
    for (Iterator<RejectionReason> it = rejectReasonList.iterator(); it.hasNext();) {
      RejectionReason rejectionReason = it.next();
      ROWCFIN09SOG00 rowcfin09sog00 = new ROWCFIN09SOG00();
      rowcfin09sog00.setSzCdRejRsn(rejectionReason.getCdRejRsn());
      rowcfin09sog00_array.addROWCFIN09SOG00(rowcfin09sog00);
    }
    cfin09so.setROWCFIN09SOG00_ARRAY(rowcfin09sog00_array);

    return cfin09so;
  }

}
