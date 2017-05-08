/* Change log
 * 
 * 	03/17/2008 	aroberts	Added PFC_COLUMN and renamed RD_COLUMN to FAD_COLUMN
 * 
 *      10/16/2008      mxpatel         STGAP00007259: Added a for loop to iterator over all the 
 *                                      designators and check if they are sys_admin.  If they are sys_admin then
 *                                      display all the units for selected criteria.
 */
package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicUnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveUnitSummary;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfUserHasRight;//mxpatel added this for defect #7259
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveUnitHierarchy;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UnitHierarchyRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HierarchicalUnit;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN29SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN29SOG01_ARRAY;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RetrieveUnitSummaryImpl extends BaseServiceImpl implements RetrieveUnitSummary {
  private RetrieveUnitHierarchy retrieveUnitHierarchy = null;
  private UnitDAO unitDAO = null;
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  private WorkloadDAO workloadDAO = null;
  private DynamicUnitEmpLinkDAO dynamicUnitEmpLinkDAO = null;
  private CheckIfUserHasRight checkIfUserHasRight; //mxpatel added this for defect #7259
  
  

  public void setRetrieveUnitHierarchy(RetrieveUnitHierarchy retrieveUnitHierarchy) {
    this.retrieveUnitHierarchy = retrieveUnitHierarchy;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public void setDynamicUnitEmpLinkDAO(DynamicUnitEmpLinkDAO dynamicUnitEmpLinkDAO) {
    this.dynamicUnitEmpLinkDAO = dynamicUnitEmpLinkDAO;
  }
  
  ////mxpatel added this for defect #7259
  public void setCheckIfUserHasRight(CheckIfUserHasRight checkIfUserHasRight) {
    this.checkIfUserHasRight = checkIfUserHasRight;
  }

  public CCMN29SO findUnitSummary(CCMN29SI ccmn29si) throws ServiceException {
    ArchInputStruct archInputStruct = ccmn29si.getArchInputStruct();
    CCMN29SO ccmn29so = new CCMN29SO();
    int idUnit = findIdUnit(ccmn29si);

    //-- is one of the persons provided the Unit Approver for either the unit entered
    //-- or one of the entered unit's parent units
    int[] userDesignators = ccmn29si.getUlIdPerson_ARRAY_CCMN29SI().getUlIdPerson();
    UnitHierarchyRetrieveSI si = new UnitHierarchyRetrieveSI(UnitHierarchyRetrieveSI.UNIT_ID, idUnit);
    Set<HierarchicalUnit> hUnits = retrieveUnitHierarchy.retrieveUnitHierarchy(si).getUnits();
    HierarchicalUnit hUnit = hUnits.isEmpty() ? null : hUnits.iterator().next(); //-- Set will only contain one
 
    
    
    //mxpatel added this for loop for defect #7259
  for (int idPerson : userDesignators) {
      if(!checkIfUserHasRight.determineIfUserHasRight(idPerson, SYS_ADMIN)){
        checkUnitAccess(hUnit, userDesignators);
      }
  }
  //  checkUnitAccess(hUnit, userDesignators);////mxpatel commented this out for defect #7259
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();
    String orderBy = ccmn29si.getSzOrderBy();
    String sortDir = ccmn29si.getSzSortDir();
    findUnitEmp(idUnit, ccmn29so, pageNbr, pageSize, orderBy, sortDir);

    if ("1".equals(ccmn29si.getCScrIndAsgnTotal())) {
      setTotalAssignments(ccmn29so);
    } else if ("2".equals(ccmn29si.getCScrIndAsgnTotal())) {
      setTotalPrimaryStagesAssignments(ccmn29so);
    }
 
    return ccmn29so;
  }

  @SuppressWarnings("serial")
  private int findIdUnit(CCMN29SI ccmn29si) throws ServiceException {
    String county = ccmn29si.getSzCdUnitCounty();
    String regDiv = ccmn29si.getSzCdUnitRegion();
    String nbrUnit = ccmn29si.getSzNbrUnit();
    
    //-- this retrieve only returns results if entries in UnitEmpLink exist
    Map unit = unitEmpLinkDAO.findIdUnitIdPersonCdMemberRoleFromUnitEmpLinkAndUnit(county, regDiv, nbrUnit);

    if (unit == null || unit.size() == 0) {
      //-- this determines if Unit exists (apparently without assigned employees, i.e. a new unit)
      Unit u = unitDAO.findUnitFullRowByCdCountyCdUnitRegionNbrUnit(county, regDiv, nbrUnit);
      if(u != null) {
        throw new ServiceException(Messages.MSG_CMN_NO_UNIT_APPRV);
      }
      throw new ServiceException(Messages.MSG_CMN_INVALID_UNIT);
    }
    return getIntegerSafe(unit.get("idUnit"));
  }

  private void findUnitEmp(int idUnit, CCMN29SO ccmn29so, int pageNbr, int pageSize, String orderBy, String sortDir)
          throws ServiceException {
    //-- Call the DAO to retrieve paginated result set
    PaginatedHibernateList<Map> empLink = dynamicUnitEmpLinkDAO.findUnitSummary(idUnit,
                                                                                orderBy, sortDir,
                                                                                pageNbr, pageSize);
    if (empLink == null || empLink.size() == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    //-- Next, populate the output object from the PaginatedHibernateList
    ROWCCMN29SOG01_ARRAY rowccon13sog_array = new ROWCCMN29SOG01_ARRAY();
    int rowQty = 0;
    for (Iterator<Map> it = empLink.iterator(); it.hasNext();) {
      Map row = it.next();
      ROWCCMN29SOG01 rowccmn29sog01 = new ROWCCMN29SOG01();
      String tempFullName = FormattingHelper.formatFullName((String) row.get(DynamicUnitEmpLinkDAO.EMP_FIRST_NAME),
                                                            (String) row.get(DynamicUnitEmpLinkDAO.EMP_MIDDLE_NAME),
                                                            (String) row.get(DynamicUnitEmpLinkDAO.EMP_LAST_NAME));
      rowccmn29sog01.setSzBjnJob((String) row.get(DynamicUnitEmpLinkDAO.EMP_BJN));
      rowccmn29sog01.setSzNmPersonFull(tempFullName);
      rowccmn29sog01.setSzCdUnitMemberInOut((String) row.get(DynamicUnitEmpLinkDAO.IN_UNIT_COLUMN));

      //-- Extract, check, and populate integers.  These values should checked in the JSP before displaying.
      //-- If the value returned in the output object is -1, display a message like "data not available" or "n/a".
      rowccmn29sog01.setUlIdPerson(getPositiveIntFromIntegerSafe((Integer) row.get(
              DynamicUnitEmpLinkDAO.STAFF_ID_COLUMN)));
      rowccmn29sog01.setUlNbrINT(getPositiveIntFromLongSafe((Long) row.get(DynamicUnitEmpLinkDAO.INT_COLUMN)));
      rowccmn29sog01.setUlNbrINV(getPositiveIntFromLongSafe((Long) row.get(DynamicUnitEmpLinkDAO.INV_COLUMN)));
      rowccmn29sog01.setUlNbrDIV(getPositiveIntFromLongSafe((Long) row.get(DynamicUnitEmpLinkDAO.DIV_COLUMN)));
      rowccmn29sog01.setUlNbrONG(getPositiveIntFromLongSafe((Long) row.get(DynamicUnitEmpLinkDAO.ONG_COLUMN)));
      rowccmn29sog01.setUlNbrFC(getPositiveIntFromLongSafe((Long) row.get(DynamicUnitEmpLinkDAO.FC_COLUMN)));
      rowccmn29sog01.setUlNbrADO(getPositiveIntFromLongSafe((Long) row.get(DynamicUnitEmpLinkDAO.ADO_COLUMN)));
      rowccmn29sog01.setUlNbrPAD(getPositiveIntFromLongSafe((Long) row.get(DynamicUnitEmpLinkDAO.PAD_COLUMN)));
      rowccmn29sog01.setUlNbrFAD(getPositiveIntFromLongSafe((Long) row.get(DynamicUnitEmpLinkDAO.FAD_COLUMN)));
      rowccmn29sog01.setUlNbrPFC(getPositiveIntFromLongSafe((Long) row.get(DynamicUnitEmpLinkDAO.PFC_COLUMN)));
      rowccmn29sog01.setNbrErrors(getPositiveIntFromLongSafe((Long) row.get(DynamicUnitEmpLinkDAO.ERRORS_COLUMN)));
      rowccmn29sog01.setNbrWarnings(getPositiveIntFromLongSafe((Long) row.get(DynamicUnitEmpLinkDAO.WARNINGS_COLUMN)));      
      rowccon13sog_array.addROWCCMN29SOG01(rowccmn29sog01);
      rowQty++;
    }
    rowccon13sog_array.setUlRowQty(rowQty);
    ccmn29so.setROWCCMN29SOG01_ARRAY(rowccon13sog_array);

    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    archOutputStruct.setBMoreDataInd(empLink.getBMoreDataInd());
    ccmn29so.setArchOutputStruct(archOutputStruct);
  }
  
  /*
  private void findIdPerson(CCMN29SI ccmn29si, Map unit) throws ServiceException {
    // Check the number of (user + designees) which have either a
    // "Clerk" role for the unit or are the approver or are above
    // the approver in the unit heirarchy
    boolean hasAccess = false;
    for (Enumeration idPersonEnum = ccmn29si.getUlIdPerson_ARRAY_CCMN29SI().enumerateUlIdPerson();
         idPersonEnum.hasMoreElements() && !hasAccess;) {
      int tempId = (Integer) idPersonEnum.nextElement();
      Integer idPerson = unitEmpLinkDAO.findIdPersonFromUnitEmpLink(tempId, (Integer) unit.get("idUnit"),
                                                                    (String) unit.get("cdUnitMemberRole"),
                                                                    CodesTables.CCPE_070);
      if (idPerson == null) {
        // the user has no access to the unit
        throw new ServiceException(Messages.MSG_CMN_INVALID_ACCESS);
      } else {
        // the user has access to the unit
        hasAccess = true;
      }
    }
  }
  */

  private void setTotalAssignments(CCMN29SO ccmn29so) {
    // Use ID PERSON for the employee and designees from the output object
    // to count the workload Repeat for all the ID PERSONS
    for (Enumeration rowccmn29sog01Enum = ccmn29so.getROWCCMN29SOG01_ARRAY().enumerateROWCCMN29SOG01();
         rowccmn29sog01Enum.hasMoreElements();) {
      ROWCCMN29SOG01 rowccmn29sog01 = (ROWCCMN29SOG01) rowccmn29sog01Enum.nextElement();
      long count = workloadDAO.countWorkloadByIdPerson(rowccmn29sog01.getUlIdPerson());
      rowccmn29sog01.setUsScrNbrTotPAssignments((int) count);
    }
  }

  private void setTotalPrimaryStagesAssignments(CCMN29SO ccmn29so) {
    // Use ID PERSON for the employee and designees from the output object
    // to count the workload Repeat for all the ID PERSONS
    for (Enumeration rowccmn29sog01Enum = ccmn29so.getROWCCMN29SOG01_ARRAY().enumerateROWCCMN29SOG01();
         rowccmn29sog01Enum.hasMoreElements();) {
      ROWCCMN29SOG01 rowccmn29sog01 = (ROWCCMN29SOG01) rowccmn29sog01Enum.nextElement();
      long count = workloadDAO.countPrimaryStagesByIdPerson(rowccmn29sog01.getUlIdPerson());
      rowccmn29sog01.setUsScrNbrTotPAssignments((int) count);
    }
  }
  
  private void checkUnitAccess(HierarchicalUnit hUnit, int[] users) {
    
    int unitLevel = 0;
    while(hUnit != null) {
      List<Integer> unitAccessMembers = new ArrayList<Integer>();
      if(unitLevel > 0) {
        //-- we're checking a parent unit; retrieve all unit members
        //-- instead of just "IN" assigned (see STGAP00005343)
        List<Integer> membersInUnit = unitEmpLinkDAO.findUnitMembersInAndOut(hUnit.getIdUnit());
        if(membersInUnit != null && !membersInUnit.isEmpty()) {
          unitAccessMembers.addAll(membersInUnit);
        }
      } else {
        //-- base level unit; add only unit approver
        unitAccessMembers.add(hUnit.getIdUnitApprover());
      }
      if(!unitAccessMembers.isEmpty()) {
        for(int idPerson : users) {
          if(idPerson > 0 && unitAccessMembers.contains(idPerson)) {
            return;
          }
        }
      }
      hUnit = hUnit.getParentUnit();
      unitLevel++;
    }
    throw new ServiceException(Messages.MSG_CMN_INVALID_ACCESS);
  }
  
  private int getIntegerSafe(Object o) {
    if(o != null && o instanceof Integer) {
      return (Integer) o;
    }
    return 0;
  }

  private int getPositiveIntFromIntegerSafe(Integer i) {
    if (i == null || i < 0) {
      return -1;
    } else {
      return i.intValue();
    }
  }

  private int getPositiveIntFromLongSafe(Long l) {
    if (l == null || l < 0) {
      return -1;
    } else {
      return l.intValue();
    }
  }
}
