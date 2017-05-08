package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CallListSrchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallListSrchOutRec;

public interface RetrieveCallLog {

  /**
   * This service will retrieve all rows from the Incoming Detail table based on an idStage,
   * or 
   * nmFirstName, nmMiddleName, nmLastName, cdStagePersType, cdIncomingDisposition, 
   * cdStageClassification, cdCityList, cdIncomingCallerCounty, cdIncmgRegion,
   * cdStageCurrPriority, nbrIncmgUnit, dtIncomingCallFrom, dtIncomingCallTo, cdIncmgAllegType.
   *
   * @param CallListSrchOutRec
   * @return
   */
  public CallListSrchOutRec retrieveCallLog(CallListSrchInRec callListSrchInRec);

}
