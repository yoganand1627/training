/**
 * Created on Jan 23, 2007 at 1:55:15 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DtDtTodoDue_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveStaffTodoWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveStaffTodoWO;
import gov.georgia.dhr.dfcs.sacwis.web.ws.RetrieveStaffTodoWS;

public class RetrieveStaffTodoWSImpl implements RetrieveStaffTodoWS {

  private Admin admin;

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public RetrieveStaffTodoWO getStaffTodoIds(RetrieveStaffTodoWI retrieveStaffTodoWI) {
    CCMN11SI ccmn11si = new CCMN11SI();
    ccmn11si.setUlIdTodoPersAssigned(retrieveStaffTodoWI.getIdPerson());
    DtDtTodoDue_ARRAY dtDtTodoDue_array = new DtDtTodoDue_ARRAY();
    dtDtTodoDue_array.addDtDtTodoDue(null);
    dtDtTodoDue_array.addDtDtTodoDue(null);
    ccmn11si.setDtDtTodoDue_ARRAY(dtDtTodoDue_array);
    CCMN11SO ccmn11so = admin.retrieveStaffTodo(ccmn11si);
    ROWCCMN17DO[] rowccmn17do = ccmn11so.getROWCCMN17DO_ARRAY().getROWCCMN17DO();
    int[] ids = new int[rowccmn17do.length];
    for (int i = 0; i < rowccmn17do.length; i++) {
      ids[i] = rowccmn17do[i].getLdIdTodo();
    }
    RetrieveStaffTodoWO retrieveStaffTodoWO = new RetrieveStaffTodoWO();
    retrieveStaffTodoWO.setIds(ids);
    return retrieveStaffTodoWO;
  }
}
