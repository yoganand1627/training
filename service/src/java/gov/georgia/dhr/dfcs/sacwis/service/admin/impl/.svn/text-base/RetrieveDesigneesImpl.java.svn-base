/*
 * Change History: 
 *   Date        User              Description 
 *   ----------  ----------------  -------------------------------------------------- 
 *   04/10/2008  aroberts          Allowed for indicator to dictate which findsByIds is implemented to 
 *                                 avoid adding a record that exists but expired prior to current date 
 *                                 
 *   07/24/2008  alwilliams        STGAP00008071 - Updated method retrieveDesigneeAssignments. Move
 *                                 the counter (i++) to the end of the loop.
 * 
 */

package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpTempAssignDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpTempAssign;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveDesignees;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY;

public class RetrieveDesigneesImpl extends BaseServiceImpl implements RetrieveDesignees {
  private EmpTempAssignDAO empTempAssignDAO = null;

  public void setEmpTempAssignDAO(EmpTempAssignDAO empTempAssignDAO) {
    this.empTempAssignDAO = empTempAssignDAO;
  }

  public CARC16SO retrieveDesigneeAssignments(CARC16SI carc16si) {
    CARC16SO carc16so = new CARC16SO();
    String allEmpTempDesignees = "all";

    ROWCARC14SOG00_ARRAY rowcarc14sog00_array = new ROWCARC14SOG00_ARRAY();
    // retrieve all designee assignments for the given employee
    //List<EmpTempAssign> designees = empTempAssignDAO.findEmpTempAssignmentDesigneesByIdPerson(carc16si.getUlIdPerson());
    List<EmpTempAssign> designees;
    if(ArchitectureConstants.N.equals(carc16si.getBIndRetrieveAllDesignees())) {
      designees = empTempAssignDAO.findIdsemp(carc16si.getUlIdPerson());
    } else {
      designees = empTempAssignDAO.findIdsemp(carc16si.getUlIdPerson(), allEmpTempDesignees);
    }
    
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    int i = 1;
    for (Iterator<EmpTempAssign> it = designees.iterator(); it.hasNext();) {
      EmpTempAssign empTempAssign = it.next();
      Person designee = empTempAssign.getPersonByIdPersonDesignee();
      ROWCARC14SOG00 rowcarc14so00 = new ROWCARC14SOG00();
      rowcarc14so00.setUlIdEmpTempAssign(
              empTempAssign.getIdEmpTempAssign() != null ? empTempAssign.getIdEmpTempAssign() : 0);
      rowcarc14so00.setUlIdPersonDesignee(designee.getIdPerson() != null ? designee.getIdPerson() : 0);
      rowcarc14so00.setSzNmPersonFull(designee.getNmPersonFull());
      rowcarc14so00.setDtDtAssignExpiration(DateHelper.toCastorDate(empTempAssign.getDtAssignExpiration()));
      rowcarc14so00.setTsLastUpdate(empTempAssign.getDtLastUpdate());
      rowcarc14sog00_array.addROWCARC14SOG00(rowcarc14so00);
      rowcarc14sog00_array.setUlRowQty(i);
      archOutputStruct.setUlRowQty(i);
      i++;
    }
    carc16so.setROWCARC14SOG00_ARRAY(rowcarc14sog00_array);
    carc16so.setArchOutputStruct(archOutputStruct);
    return carc16so;
  }

}
