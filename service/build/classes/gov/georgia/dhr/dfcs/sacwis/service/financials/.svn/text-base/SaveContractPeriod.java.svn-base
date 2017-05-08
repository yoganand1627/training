package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON06SO;

public interface SaveContractPeriod {

  /**
   * This service will update all columns for Id Contract, Nbr Cnper Period, Id Cntrct Wkr, Cd Cnper Status, Dt Cnper
   * Start, Dt Cnper Term, Dt Cnper Closure, Ind Cnper Renewal, and Ind Cnper Signed on the Contract Period table.  It
   * can add, modify or delete a Contract Period row.  For any Contract Period that it adds, it will duplicate the
   * previous Period's last version's Service Line Items.  If it modifies DtCnperStart or DtCnperTerm, then it will
   * update DtCnverEffective, DtCnverEnd, DtCncntyEffective and DtCncntyEnd on the Contract Version and Contract County
   * tables respectively. If a Contract Period is deleted, then it will delete the version, service line items and
   * counties associated with Nbr Cnper Period.
   *
   * @param ccon06si
   * @return
   */
  CCON06SO saveContractPeriod(CCON06SI ccon06si);

}
