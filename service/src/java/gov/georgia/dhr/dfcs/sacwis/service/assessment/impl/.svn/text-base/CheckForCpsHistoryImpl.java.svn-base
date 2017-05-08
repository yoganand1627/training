package gov.georgia.dhr.dfcs.sacwis.service.assessment.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

import gov.georgia.dhr.dfcs.sacwis.service.investigation.CheckForCpsHistory;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckForCpsHistorySI;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SrHouseholdMembersDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResource;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;

/**
 *This class implements the checkForCpsHistory service to check for closed and current stages
 *Should be used for Safety Resource Assessment Page. 
 *
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 07/8/11  Cwells             Initial Creation to check for CPS history for Safety Resource only. 
 * </pre>
 */

public class CheckForCpsHistoryImpl extends BaseServiceImpl implements CheckForCpsHistory {

  private StageDAO stageDAO = null;

  private SrHouseholdMembersDAO srHouseholdMembersDAO = null;

  private IncomingDetailDAO incomingDetailDAO = null;

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setSrHouseholdMembersDAO(SrHouseholdMembersDAO srHouseholdMembersDAO) {
    this.srHouseholdMembersDAO = srHouseholdMembersDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }


  public Boolean checkForCpsHistory(CheckForCpsHistorySI checkForCpsHistorySI) throws ServiceException {

    int idEvent = checkForCpsHistorySI.getUlIdEvent();
    int idCase = checkForCpsHistorySI.getIdCase();
    boolean cpsHistory = false;

    SafetyResource safetyResource = getPersistentObject(SafetyResource.class, idEvent);

    Date dtIncomingCall = incomingDetailDAO.findEarliestIncomingDetailDtByIdCase(idCase);

    List<Integer> memberList = createResourceMembList(idEvent, safetyResource);

    Long cpsHistoryCount = stageDAO.findClosedStageByPersonListDtStart(memberList, dtIncomingCall);

    if (cpsHistoryCount > 0) {
      cpsHistory = true;
    }

    return cpsHistory;
  }

  private List<Integer> createResourceMembList(int idEvent, SafetyResource safetyResource) {
    // SMS 114321 Capta 4.3 removed the children placed list from cps history check.   
    List<Integer> hshldMembers = srHouseholdMembersDAO.findSrHouseholdMembersByIdEvent(idEvent);
    List<Integer> nonDuplicateList = new ArrayList<Integer>();
    List<Integer> houseHoldList = new ArrayList<Integer>();

    Person primarySRPerson = getPrimaryResource(idEvent);
    houseHoldList.add(primarySRPerson.getIdPerson());
    Person secondarySRPerson = getSecondaryResource(idEvent);
    if (secondarySRPerson.getIdPerson() != null && secondarySRPerson.getIdPerson() != 0) {
      houseHoldList.add(secondarySRPerson.getIdPerson());
    }
    houseHoldList.addAll(hshldMembers);

    if (houseHoldList != null && !houseHoldList.isEmpty()) {
      for (Iterator<Integer> it = houseHoldList.iterator(); it.hasNext();) {

        Integer idPerson = it.next();
        if (!nonDuplicateList.contains(idPerson)) {
          nonDuplicateList.add(idPerson);
        }
      }
    }
    return nonDuplicateList;
  }

  /**
   * This private method returns the Person object of the Primary Resource when given an Event id
   * 
   * @param idEvent
   * @return Person
   */
  private Person getPrimaryResource(int idEvent) {

    SafetyResource safetyResource = getPersistentObject(SafetyResource.class, idEvent);
    Person primaryPerson = getPersistentObject(Person.class, safetyResource.getIdPrimary());

    return primaryPerson;
  }

  private Person getSecondaryResource(int idEvent) {
    Person secondaryPerson = new Person();
    SafetyResource safetyResource = getPersistentObject(SafetyResource.class, idEvent);
    if (safetyResource.getIdSecondary() != null && safetyResource.getIdSecondary() != 0) {
      secondaryPerson = getPersistentObject(Person.class, safetyResource.getIdSecondary());
    }

    return secondaryPerson;
  }

  private List<Integer> addCollectionToList(List<Integer> returnedList, Collection<SafetyResourceChild> addedList) {
    if (addedList != null && !addedList.isEmpty()) {
      for (Iterator<SafetyResourceChild> it = addedList.iterator(); it.hasNext();) {
        SafetyResourceChild safetyResourceChild = (SafetyResourceChild) it.next();
        returnedList.add(safetyResourceChild.getIdChild());

      }
    }
    return returnedList;
  }

}