package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;


/** Change History:
   **  Date        User              Description
   **  --------    ----------------  ----------------------------------------------------------------------
   **  07/30/08    charden           STGAP00009615 - created and called new methods to check to see if parent 
   *                                 unit entered is a child of the unit being modified. If so, a service
   *                                 exception will be thrown from the helper method
   *
   */


import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexUnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpJobHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpJobHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveUnitDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HierarchicalUnit;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SaveUnitDetailImpl extends BaseServiceImpl implements SaveUnitDetail {

  public static final String UNIT_MEMBER_IN_ASSIGNED = CodesTables.CUMINOUT_IN;

  public static final String UNIT_MEMBER_OUT_ASSIGNED = CodesTables.CUMINOUT_OUT;

  public static final String UNIT_MEMBER_ROLE_APPROVER = CodesTables.CUNMBRRL_40;

  private ComplexUnitDAO complexUnitDAO = null;
  
  private EmpJobHistoryDAO empJobHistoryDAO = null;

  private UnitDAO unitDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  public void setComplexUnitDAO(ComplexUnitDAO complexUnitDAO) {
    this.complexUnitDAO = complexUnitDAO;
  }

  public void setEmpJobHistoryDAO(EmpJobHistoryDAO empJobHistoryDAO) {
    this.empJobHistoryDAO = empJobHistoryDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public CCMN22SO saveUnitInformation(CCMN22SI ccmn22si) throws ServiceException {
    CCMN22SO ccmn22so = new CCMN22SO();
    ROWCCMN22SIG02_ARRAY rowccmn22sig02_array = ccmn22si.getROWCCMN22SIG02_ARRAY();
    ROWCCMN22SIG02 rowccmn22sig02 = new ROWCCMN22SIG02();
    String cReqFuncCd = ccmn22si.getArchInputStruct().getCReqFuncCd();
    int idUnit = ccmn22si.getUlIdUnit();
    boolean newUnit = false;

    // Check for the presence of idUnit. If one does not exist (new Unit creation)
    // save the new Unit Information, Retrieve the id of the newly created Unit and set
    // its value into ccmn22si.
 
    if (idUnit == 0) {
      if (rowccmn22sig02_array != null) {
        rowccmn22sig02 = rowccmn22sig02_array.getROWCCMN22SIG02(0);
      }

      String cdCounty = ccmn22si.getROWCCMN22SIG01().getSzCdUnitCounty();
      String cdUnitRegion = ccmn22si.getROWCCMN22SIG01().getSzCdUnitRegion();
      String nbrUnit = ccmn22si.getROWCCMN22SIG01().getSzNbrUnit();
      
      //-- first verify that no unit already exists for given county, region, and nbr
      Unit unit = unitDAO.findUnitFullRowByCdCountyCdUnitRegionNbrUnit(cdCounty, cdUnitRegion, nbrUnit);
      if(unit != null) {
        throw new ServiceException(Messages.MSG_CMN_UNIT_EXISTS);
      }

      // Call the following method to save the new Unit.
      idUnit = addUpdateUnit(ccmn22si);
      ccmn22si.setUlIdUnit(idUnit);
      newUnit = true;
    }

    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd) || ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      // A change was made to Unit Member Information, so update UNIT EMP LINK in the followign loop.
      rowccmn22sig02_array = ccmn22si.getROWCCMN22SIG02_ARRAY();

      if (rowccmn22sig02_array != null) {

        Enumeration rowccmn22sig02_enum = rowccmn22sig02_array.enumerateROWCCMN22SIG02();
        while (rowccmn22sig02_enum.hasMoreElements()) {
          rowccmn22sig02 = (ROWCCMN22SIG02) rowccmn22sig02_enum.nextElement();
          int idPerson = rowccmn22sig02.getUlIdPerson();
          if (UNIT_MEMBER_IN_ASSIGNED.equals(rowccmn22sig02.getSzCdUnitMemberInOut())) {
            // If the employee to be modified has (or is proposed to have) MemberInOut status (in this unit) == IN, then
            // check if the employee is currently the UNIT APPROVER of the unit in which they are currently "IN"
            // assigned.
            //
            // If the employee is the UNIT APPROVER of their current "IN" unit (and that current "IN" unit is not the
            // unit
            // being modified right now), the findIdUnitForApprover() function will return the id of the unit.
            //
            // If the findIdUnitForApprover() method returns a non-zero result, then the checkUnitEmployeeCount method
            // needs to be called
            int idUnitForApprover = findIdUnitForApprover(idPerson, idUnit);
            if (idUnitForApprover != 0) {
              // The checkUnitEmployeeCount() method will throw SQL_NOT_FOUND if person cannot be found in the unit
              try {
                checkUnitEmployeeCount(idUnitForApprover);
              } catch (ServiceException e) {
                if (e.getErrorCode() == Messages.SQL_NOT_FOUND) {
                  // If the current IdPerson that we are processing is the same IdPerson in pInputMsg->ROWCCMN22SIG01
                  // (that is the Unit Approver for this unit), then in addition to not re-assigning the current
                  // IdPerson, we should not continue processing the remaining employees in the pInputMsg. Return the
                  // MSG_CMN_TMSTAMP_MISMATCH message to the user.
                  if (rowccmn22sig02.getUlIdPerson() == ccmn22si.getROWCCMN22SIG01().getUlIdPerson()) {
                    throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH, e);
                  }
                  // The current idPerson is not the approver; we may continue with the remaining employees
                  // in the pInputMsg. Use continue to skip to the next row.
                  continue;
                }
              }
            }
          }

          if (UNIT_MEMBER_OUT_ASSIGNED.equals(rowccmn22sig02.getSzScrCdUnitMemberInOut())
              && UNIT_MEMBER_IN_ASSIGNED.equals(rowccmn22sig02.getSzCdUnitMemberInOut())) {
            // The employee has been switched from OUT to "IN" status for this unit. (szCdUnitMemberInOut = IN the
            // current
            // assignment, while szScrCdUnitMemberInOut = OUT (the original))
            //
            // Delete all other occurences (other units) where this employee is "IN". An employee can only be
            // IN-assigned
            // to one unit.
            updateUnitApprover(idPerson);
            deleteUnitEmployeeLinks(idPerson);
          }
          audUnitEmpLink(rowccmn22sig02, ccmn22si.getUlIdUnit());
        }
      }
    }
    if (!ServiceConstants.REQ_FUNC_CD_NO_ACTION.equals(ccmn22si.getROWCCMN22SIG01().getCReqFuncCd())) {
      // A change was made to Unit information, so update UNIT
      // Update only if this is not a new unit
      if (!newUnit) {
        addUpdateUnit(ccmn22si);
      }

      if (ccmn22si.getROWCCMN22SIG01().getCReqFuncCd().equals(ServiceConstants.REQ_FUNC_CD_DELETE)) {
        // Ensure that units that are deleted are not referenced as the parent unit of any other units
        setUnitParentToNull(idUnit);
        // caudc2d
        complexUnitDAO.updateCapsCaseAndStage(idUnit);
      }
    }
    
    ccmn22so.setUlIdUnit(idUnit);
    return ccmn22so;
  }

  int addUpdateUnit(CCMN22SI ccmn22si) throws ServiceException {
    // Full row update of the UNIT table.
    // Todo: Transform Hibernate exceptions into: MSG_CMN_TMSTAMP_MISMATCH
    // ccmn48d
    ROWCCMN22SIG01 rowccmn22sig01 = ccmn22si.getROWCCMN22SIG01();
    String cReqFuncCd = rowccmn22sig01.getCReqFuncCd();

    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      int idUnit = ccmn22si.getUlIdUnit();
      Unit unit = getPersistentObject(Unit.class, idUnit);
      Person person = getPersistentObject(Person.class, rowccmn22sig01.getUlIdPerson());
      // If the idPerson is 0 then set it to null so the integer '0' is not inserted in the DB
      // Hibernate will throw an OjectNotFoundException when it tries to retrieve a person record 
      // base on primary key that is set to '0'
      if(rowccmn22sig01.getUlIdPerson() == 0) {
        person = null;
      }
      
      //-- update supervisor in EmpJobHistory for all unit members
      updateUnitApproverReferences(idUnit, person);
      
      unit.setPerson(person);
      unit.setNbrUnit(rowccmn22sig01.getSzNbrUnit());
      unit.setCdCounty(rowccmn22sig01.getSzCdUnitCounty());
      unit.setCdUnitRegion(rowccmn22sig01.getSzCdUnitRegion());
      unit.setCdUnitSpecialization(rowccmn22sig01.getSzCdUnitSpecialization());
      unit.setCdUnitProgram("CPS");
      Unit parent = unitDAO.findUnitByIdUnit(rowccmn22sig01.getUlIdUnitParent());
    
      //STGAP00009615 - called new methods to check to see if parent unit entered is a child of the unit being modified
      //If so, a service exception will be thrown from the helper method
      if (!(ccmn22si.getROWCCMN22SIG02_ARRAY().hasUlRowQty() == true)) {
        HierarchicalUnit hierarchicalUnit = createHierarchicalUnit(unit);
        checkForImproperParent(hierarchicalUnit, parent);
      }else{
        ccmn22si.getROWCCMN22SIG02_ARRAY().setUlRowQty(0);
      }
      unit.setUnit(parent);
      unitDAO.saveUnit(unit);
      return unit.getIdUnit();
    } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      Unit newUnit = new Unit();
      newUnit.setNbrUnit(rowccmn22sig01.getSzNbrUnit());
      newUnit.setCdCounty(rowccmn22sig01.getSzCdUnitCounty());
      newUnit.setCdUnitRegion(rowccmn22sig01.getSzCdUnitRegion());
      newUnit.setCdUnitSpecialization(rowccmn22sig01.getSzCdUnitSpecialization());
      newUnit.setCdUnitProgram("CPS");
      Unit parentUnit = getPersistentObject(Unit.class, rowccmn22sig01.getUlIdUnitParent());
      newUnit.setUnit(parentUnit);
      unitDAO.saveUnit(newUnit);
      return newUnit.getIdUnit();
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      int idUnit = ccmn22si.getUlIdUnit();
      Unit unit = getPersistentObject(Unit.class, idUnit);
      unitDAO.deleteUnit(unit);
      return idUnit;
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }

  void audUnitEmpLink(ROWCCMN22SIG02 rowccmn22sig02, int idUnit) throws ServiceException {
    // Full row update of the UNIT EMP LINK table.
    // Todo: Transform Hibernate exceptions into: MSG_CMN_TMSTAMP_MISMATCH
    // ccmn49d
    String cReqFuncCd = rowccmn22sig02.getSzCdScrDataAction();
    UnitEmpLink unitEmpLink = null;
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      unitEmpLink = new UnitEmpLink();
      unitEmpLink.setCdUnitMemberInOut(CodesTables.CUMINOUT_OUT);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      unitEmpLink = getPersistentObject(UnitEmpLink.class, rowccmn22sig02.getUlIdUnitEmpLink());
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      unitEmpLink = getPersistentObject(UnitEmpLink.class, rowccmn22sig02.getUlIdUnitEmpLink());
      unitEmpLinkDAO.deleteUnitEmpLink(unitEmpLink);
      return;
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

    Employee employee = getPersistentObject(Employee.class, rowccmn22sig02.getUlIdPerson());
    Unit unit = getPersistentObject(Unit.class, idUnit);
    unitEmpLink.setEmployee(employee);
    unitEmpLink.setUnit(unit);
    //unitEmpLink.setCdUnitMemberInOut(rowccmn22sig02.getSzCdUnitMemberInOut());
    unitEmpLink.setCdUnitMemberRole(rowccmn22sig02.getSzCdUnitMemberRole());
    unitEmpLinkDAO.saveUnitEmpLink(unitEmpLink);
  }

  void deleteUnitEmployeeLinks(int idPerson) {
    // This DAM deletes all the UNIT EMPLOYEE LINKs for a given ID PERSON who is IN assigned. This is used because an
    // employee can only be in assinged to one unit.
    // ccmne0d -- Delete is forced by the service setting the cReqFuncCd
    unitEmpLinkDAO.deleteUnitEmpLinkByIdPersonCdUnitMemberInOut(idPerson, CodesTables.CUMINOUT_IN);
    // Ignore how many rows were deleted.
  }

  void setUnitParentToNull(int idUnit) {
    // This DAM set the Parent unit column to NULL when that column is equal to the given ID UNIT. This is used when
    // a UNIT is deleted, to insure that the deleted ID UNIT does not appear as the parent unit for another unit.
    //
    // ccmnf3d -- Update is forced by the service setting the cReqFuncCd
    unitDAO.updateUnitIDUnitParent(idUnit);
    // Ignore how many rows were updated.
  }

  void updateUnitApprover(int idPerson) {
    // Update UNIT_APPROVER column on the UNIT table for a given ID PERSON.
    //
    // This DAO is used when a Person is deleted from a unit (because they are IN-assigned to both the current unit and
    // the previous unit). It makes sure that if the ID PERSON to be deleted from the old unit does not appear as the
    // approver for that unit. If they do the approver column is set to NULL.
    //
    // ccmnf4d -- Update is always called because the cReqFuncCd is set in the service.

    unitDAO.updateUnitIdPerson(idPerson, CodesTables.CUMINOUT_IN);
    // Ignore how many rows were updated.
  }

  int findIdUnitForApprover(int idPerson, int idUnit) {
    // ccmng5d
    Integer idUnitFromUnitEmpLink = unitEmpLinkDAO.findUnitEmpLinkByIdPerson(idPerson);
    // If the IdUnit returned from the dam call (pCCMNG5DOutputRec->ulIdUnit) is not the same
    // idUnit being modified, return that value; otherwise return 0;
    // We allow the "Role" for the current "IN" approver of a unit to be modified.
    if (idUnitFromUnitEmpLink != null && idUnit != idUnitFromUnitEmpLink) {
      return idUnit;
    }
    return 0;
  }

  void checkUnitEmployeeCount(int idUnit) throws ServiceException {
    // ccmn36d
    List<Map> employeeInfoList = unitEmpLinkDAO.findAllEmployeeUnitEmpLinkByIdUnit(idUnit);
    if (employeeInfoList == null || employeeInfoList.isEmpty()) {
      // This could happen if there had only been one employee in the IdUnit searched on (the "IN" approver of that
      // unit), and someone else (on CAPS) had re-assigned that employee to a different unit between the time the
      // ccmng5d dam was executed and the time this dam (36d) was executed.
      //
      // This is highly unlikely; however, if this occurred we would NOT want to continue processing on this
      // employee (within the current execution of this service), therefore throw SQL_NOT_FOUND.
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // There is one or more employees retrieved from the database who are assigned to this particular unit.
    //
    // If two rows were retrieved, that means that there are at least two employees assigned to this particular unit,
    // (there may be more). In this case, we need to give the user a MSG stating that this proposed "IN" employee is
    // unit approver of a non-empty unit (MSG_CMN_UNIT_APPROVER).
    if (employeeInfoList.size() > 1) {
      throw new ServiceException(Messages.MSG_CMN_UNIT_APPROVER);
    }
    // If only one row was retrieved, that row must contain the IdPerson of the Unit Approver of this particular unit,
    // and that IdPerson must be the only employee assigned to this particular unit.
    //
    // No exception indicates success.
  }
  
  //STGAP00009615 - new method to create a hierarchical unit based on the unit being modified
  private HierarchicalUnit createHierarchicalUnit(Unit unit) {
    int idUnit = unit.getIdUnit();
    HierarchicalUnit hUnit = createBasicUnit(unit);
    
    //-- get child units
    List<Unit> childUnits = unitDAO.findChildUnitsByIdUnitParent(idUnit);
    if(childUnits != null && !childUnits.isEmpty()) {
      for(Unit childUnit : childUnits) {
        if(idUnit != childUnit.getIdUnit()) {
          hUnit.addChildUnit(createHierarchicalUnit(childUnit));
        }
      }
    }
    
    return hUnit;
  }
  
  //STGAP00009615 - new method to creat a basic Hierarchical Unit
  private HierarchicalUnit createBasicUnit(Unit unit) {
    int idUnit = unit.getIdUnit();
    HierarchicalUnit hUnit = new HierarchicalUnit(idUnit);
    
    //-- non-null values
    hUnit.setNbrUnit(unit.getNbrUnit());
    hUnit.setCdUnitRegion(unit.getCdUnitRegion());
    hUnit.setCdUnitProgram(unit.getCdUnitProgram());
    
    //-- nullable values
    Person unitApprover = unit.getPerson();
    if(unitApprover != null) {
      hUnit.setIdUnitApprover(unitApprover.getIdPerson());
    }
    hUnit.setCdUnitSpecialization(unit.getCdUnitSpecialization());
    hUnit.setCdCounty(unit.getCdCounty());
    
    return hUnit;
  }
  
  //STGAP00009615 - created new method to check if parent unit entered is a child of the current unit
  private void checkForImproperParent(HierarchicalUnit hierarchicalUnit, Unit parent) {
    Set<HierarchicalUnit> childUnits = hierarchicalUnit.getChildUnits();
    Iterator<HierarchicalUnit> it = childUnits.iterator();
    while (it.hasNext()) {
      HierarchicalUnit hUnit = (HierarchicalUnit) it.next();
      if (hUnit.getIdUnit() == parent.getIdUnit()) {
        throw new ServiceException(Messages.MSG_CMN_UNIT_CHILD_NO_PARENT);
      }
    }
    return;
  }
  
  private void updateUnitApproverReferences(int idUnit, Person unitApprover) {
    //-- find every unit member from UnitEmpLink ("IN" unit) and update EmpJobHistory
    List<Integer> unitMembers = unitEmpLinkDAO.findUnitMembersInOrOut(idUnit, CodesTables.CUMINOUT_IN);
    if(unitMembers != null && !unitMembers.isEmpty()) {
      for(Integer idPerson : unitMembers) {
        EmpJobHistory empJobHistory = empJobHistoryDAO.findSoleEJHByIdPerson(idPerson);
        empJobHistory.setPersonByIdJobPersSupv(unitApprover);
        empJobHistoryDAO.saveEmpJobHistory(empJobHistory);
      }
    }
  }
}
