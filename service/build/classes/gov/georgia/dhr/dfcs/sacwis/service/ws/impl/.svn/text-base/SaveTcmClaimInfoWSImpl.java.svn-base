package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.TCMClaimDAO;
import gov.georgia.dhr.dfcs.sacwis.db.TcmClaim;
import gov.georgia.dhr.dfcs.sacwis.db.TcmClaimOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.SaveTcmClaimInfoWS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveTcmClaimInfoSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveTcmClaimInfoSO;

import java.util.Date;

/**
 * SaveTcmClaimInfoWSImpl
 * 
 * @author Kalpana Thirumurthy
 * @version 1.0
 * 
 * <pre>
 *              Change History:
 *              Date      User              Description
 *              --------  ----------------  --------------------------------------------------
 * </pre>
 */

public class SaveTcmClaimInfoWSImpl extends BaseServiceImpl implements SaveTcmClaimInfoWS {

  private TCMClaimDAO tcmClaimDAO = null;

  private static final String SMI_PAID = "1";
  private static final String SMI_DENIED = "4";
  private static final String SMI_PENDING = "5";
  private static final String SMI_VOID = "22";
  private static final String SMI_REJECTED = "99";

  public void setTcmClaimDAO(TCMClaimDAO tcmClaimDAO) {
    this.tcmClaimDAO = tcmClaimDAO;
  }

  public SaveTcmClaimInfoSO saveTcmClaimInfo(SaveTcmClaimInfoSI saveTcmClaimInfoSI) {
    SaveTcmClaimInfoSO saveTcmClaimInfoSO = new SaveTcmClaimInfoSO();

    if (saveTcmClaimInfoSI != null) {
      TcmClaimOutbound tcmClaimOutbound = tcmClaimDAO
                                                     .findTcmClaimByTransactionId(saveTcmClaimInfoSI
                                                                                                    .getIdTransactionId());

      if (tcmClaimOutbound != null) {
        String eobCodes = returnEobCode(saveTcmClaimInfoSI.getCdEobCodes());

        // Insert a row in the audit table with the data in the incoming request
        tcmClaimDAO.saveTCMClaimInbound(saveTcmClaimInfoSI.getIdTransactionId(), eobCodes,
                                        saveTcmClaimInfoSI.getNbrTcnNumber(), saveTcmClaimInfoSI.getDtPayDate(),
                                        saveTcmClaimInfoSI.getNbrRaNumber(), saveTcmClaimInfoSI.getCdReturnStatus());

        // Update The TCMClaim table if there is an error finding the claim entry we have big problems so just error
        // out to the caller.
        
        int idTcmClaim = tcmClaimOutbound.getIdTcmClaim();
        TcmClaim tcmClaim = getPersistentObject(TcmClaim.class, idTcmClaim);
        tcmClaim.setCdDenial(eobCodes);
        String status = returnStatusCode(saveTcmClaimInfoSI.getCdReturnStatus());
        tcmClaim.setCdStatus(status);
        String tcnNumber = tcmClaim.getNbrTcn();
        if (CodesTables.CTCMSTAT_REJ.equalsIgnoreCase(status) == false)  {
          tcnNumber = (saveTcmClaimInfoSI.getNbrTcnNumber() != null) ? saveTcmClaimInfoSI.getNbrTcnNumber().trim() : null;
          tcnNumber = (tcnNumber != null && tcnNumber.length() > 0) ?  tcnNumber : tcmClaim.getNbrTcn(); 
        }  
        
        tcmClaim.setNbrTcn(tcnNumber);
        tcmClaim.setDtPay(saveTcmClaimInfoSI.getDtPayDate());
        tcmClaim.setNbrRa(saveTcmClaimInfoSI.getNbrRaNumber());
        tcmClaim.setDtStatus(new Date());
        tcmClaimDAO.saveTCMClaim(tcmClaim);
        saveTcmClaimInfoSO.setIdTransactionId(idTcmClaim);
      }
    }
    return saveTcmClaimInfoSO;
  }

  private String returnStatusCode(String returnStatus) {
    String returnCode = CodesTables.CTCMSTAT_REJ;
    returnStatus = (returnStatus != null) ? returnStatus.trim() : null;
    if (SMI_PAID.equalsIgnoreCase(returnStatus)) {
      return CodesTables.CTCMSTAT_PAD;
    } else if (SMI_DENIED.equalsIgnoreCase(returnStatus)) {
      return CodesTables.CTCMSTAT_DND;
    } else if (SMI_PENDING.equalsIgnoreCase(returnStatus)) {
      return CodesTables.CTCMSTAT_PND;
    } else if (SMI_VOID.equalsIgnoreCase(returnStatus)) {
      return CodesTables.CTCMSTAT_VOD;
    }
    return returnCode;
  }

  //The database column can only handle 30 so just get the first entry and size it
  private String returnEobCode(String[] tempErrCode){
    String eobCode = null;
    if(tempErrCode != null && tempErrCode.length > 0){
      String firstEOB = tempErrCode[0];
      if(firstEOB != null && firstEOB.length() > 0){
        firstEOB.trim();
        if(firstEOB.length() > 30) {
          firstEOB = firstEOB.substring(0, 30);
        }
        eobCode = firstEOB;
      }
    }
    return eobCode;
  }
}