package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN13SO;

public interface RetrieveIntake {
  /**
   * Retrieves the user's supervisor if the ReqFuncCd is REQ_FUNC_CD_APPROVAL, or it will get the NM STAGE, NM TASK,
   * TASK DUE DT, PRIMARY WORKER of STAGE if the ReqFuncCd is REQ_FUNC_CD_ASSIGN, or it will get the information related
   * to the ID TODO specified.
   *
   * @param ccmn13si The input object containing the method parameters
   * @return CCMN13SO The output object populated with the retrieved row/column values.
   */
  public CCMN13SO findIntakeInformation(CCMN13SI ccmn13si);
}
