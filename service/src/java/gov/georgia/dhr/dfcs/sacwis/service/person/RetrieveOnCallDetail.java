package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN09SO;

public interface RetrieveOnCallDetail {

  /**
   * This service calls one dam:
   * <pre>
   * CCMN21D:
   * input:   1 variable:  IdOnCall
   * output:  12 variables: IdPerson, Nm Person Full,
   *         Home Phone, Contact Order, OnCallDesig(nation),
   *          Phone1, Ext1, Phone2, Ext2,Title,Program
   *          IdEmpOnCallLink, IdOnCall, tsLastUpdate
   * </pre>
   *
   * @param ccmn09si
   */
  public CCMN09SO findEmpOnCallInfo(CCMN09SI ccmn09si);
}
