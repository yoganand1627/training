package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpTempAssignDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpTempAssign;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveDesignees;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC17SO;

/**
 * SaveDesigneesImpl class
 * <p/>
 * <p/>
 * 
 * @author Eric Dickman
 * @version 1.0.1; 
 * 
 * Change History: 
 *   Date        User              Description 
 *   ----------  ----------------  -------------------------------------------------- 
 *   07/24/08    alwilliams        STGAP00008071 - Updated method saveDesigneeAssigments. Issued
 *                                 service exceptions if the maximum number of designees or designators
 *                                 is exceeded. Expired designees are not included in the count.
 *                                 
 *   07/31/08    alwilliams        STGAP00008071 - Changed MAX_DESIGNATORS to MAX_ASSIGNEES. 
 *                                 MAX_ASSIGNEES and MAX_DESIGNEES are now defined in the
 *                                 SaveDesignees interface class.
 *                                 
 */
public class SaveDesigneesImpl extends BaseServiceImpl implements SaveDesignees {

  private EmpTempAssignDAO empTempAssignDAO = null;

  public void setEmpTempAssignDAO(EmpTempAssignDAO empTempAssignDAO) {
    this.empTempAssignDAO = empTempAssignDAO;
  }

  public CARC17SO saveDesigneeAssignments(CARC17SI carc17si) throws ServiceException {
    ROWCARC18SIG00_ARRAY_CARC17SI rowcarc18sig00_array = carc17si.getROWCARC18SIG00_ARRAY_CARC17SI();
    Enumeration rowcarc18sig00_enum = rowcarc18sig00_array.enumerateROWCARC18SIG00();
    while (rowcarc18sig00_enum.hasMoreElements()) {
      ROWCARC18SIG00 rowcarc18sig00 = (ROWCARC18SIG00) rowcarc18sig00_enum.nextElement();
      int idPersonEmp = rowcarc18sig00.getUlIdPerson();
      int idPersonDesignee = rowcarc18sig00.getUlIdPersonDesignee();
      String szCdSysDataActionOutcome = rowcarc18sig00.getSzCdSysDataActionOutcome();
      // If we are adding or updating, we have to check to see if there are too many, first.
      // Note that, we only check update becuase the service did; on the face of it, it seems that update should not
      //   change the total number of assignees.
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdSysDataActionOutcome) ||
          ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdSysDataActionOutcome)) {
 
        // Get a count of all of an employee's assignees (given ID PERSON DESIGNEE) not equal to a given ID PERSON.
        // cmsc45d
        long countIdPerson =
               empTempAssignDAO.countPersonByIdPersonDesigneeByPersonByIdPersonEmp(idPersonEmp, idPersonDesignee);
        // Check to see if the employee has less than the maximum number of assignees.
        if (countIdPerson >= MAX_DESIGNEES) {
          // The employee already has the maximum number of assignees, so set the severity and explan code and exit
          //   the service with an exception.
          throw new ServiceException(Messages.MSG_SEC_TOO_MANY_DESIGNEES);
        }

        // STGAP00008071 - Issue an exception message if the employee already has the maximum number of assignees.
        long assigneesCount =
               empTempAssignDAO.countPersonByIdPersonEmpByPersonByIdPersonDesignee(idPersonEmp, idPersonDesignee);
        if (assigneesCount >= MAX_ASSIGNEES) {
          // The employee already has the maximum number of assignees, so set the severity and explain code and exit
          //   the service with an exception.
          throw new ServiceException(Messages.MSG_SEC_TOO_MANY_DESIGNATORS);
        }        
        
      }
      int idEmpTempAssign = rowcarc18sig00.getUlIdEmpTempAssign();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdSysDataActionOutcome) ||
          ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdSysDataActionOutcome)) {
        EmpTempAssign empTempAssign = new EmpTempAssign();
        empTempAssign.setIdEmpTempAssign(idEmpTempAssign);
        empTempAssign.setDtLastUpdate(rowcarc18sig00.getTsLastUpdate());
        Person personEmp = (Person) getPersistentObject(Person.class, idPersonEmp);
        empTempAssign.setPersonByIdPersonEmp(personEmp);
        Person personDesignee = (Person) getPersistentObject(Person.class, idPersonDesignee);
        empTempAssign.setPersonByIdPersonDesignee(personDesignee);
        empTempAssign.setDtAssignExpiration(DateHelper.toJavaDate(rowcarc18sig00.getDtDtAssignExpiration()));
        // caud22d
        empTempAssignDAO.saveEmpTempAssign(empTempAssign);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(szCdSysDataActionOutcome)) {
        // caud22d
        if (0 == empTempAssignDAO.deleteEmpTempAssign(idEmpTempAssign,
                                                      rowcarc18sig00.getTsLastUpdate())) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    return new CARC17SO();
  }
}
