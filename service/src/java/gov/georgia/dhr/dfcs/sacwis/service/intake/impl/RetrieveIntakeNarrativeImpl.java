package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingNarrativeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingNarrative;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveIntakeNarrative;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IntNarrBlobInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IntNarrBlobOutRec;

public class RetrieveIntakeNarrativeImpl extends BaseServiceImpl implements RetrieveIntakeNarrative {

  private IncomingNarrativeDAO incomingNarrativeDAO = null;

  public void setIncomingNarrativeDAO(IncomingNarrativeDAO incomingNarrativeDAO) {
    this.incomingNarrativeDAO = incomingNarrativeDAO;
  }

  public IntNarrBlobOutRec findIntakeNarrative(IntNarrBlobInRec intNarrBlobInRec) throws ServiceException {
    ArchInputStruct archInputStruct = intNarrBlobInRec.getArchInputStruct();
    int idStage = intNarrBlobInRec.getIntNarrBlobRtrvStruct().getUlIdStage();
    if (archInputStruct != null && ServiceConstants.REQ_FUNC_CD_LIST.equals(archInputStruct.getCReqFuncCd())) {
      // Only check how many narrative rows that they are for the stage.
      if (0 == incomingNarrativeDAO.countIncomingNarrativesByIdStage(idStage)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      return new IntNarrBlobOutRec();
    }
    //cint42dQUERYdam
    IncomingNarrative incomingNarrative = incomingNarrativeDAO.findIncomingNarrativeByIdStage(idStage);
    if (incomingNarrative == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    //TODO:  This needs to be complete when forms architecture is determined
    //IntNarrBlobOutRec intNarrBlobOutRec = new IntNarrBlobOutRec();
    //intNarrBlobOutRec.BLOBStruct = pCINT42DOutputRec.getBLOBStruct();
    //intNarrBlobOutRec.BLOBStruct = incomingNarrative.getNarrIncoming();
    return new IntNarrBlobOutRec();
  }
}
