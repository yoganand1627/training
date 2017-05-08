package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.*;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;

import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrievePlacementReferralLog;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PlacementReferralLogRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralLogRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementReferralDAO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralLogList;

public class RetrievePlacementReferralLogImpl extends BaseServiceImpl implements RetrievePlacementReferralLog {
  private PlacementReferralDAO placementReferralDAO = null;

  private PersonDAO personDAO = null;

  private EmployeeDAO employeeDAO = null;

  public void setPlacementReferralDAO(PlacementReferralDAO placementReferralDAO) {
    this.placementReferralDAO = placementReferralDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  /**
   * This retrieve service retrieves the data from Placement_Referral table and populates the retrieveSO object.
   * 
   * @param PlacementReferralLogRetrieveSI
   * @return A populated PlacementReferralLogRetrieveSO object.
   * @author lata.p.lokhande
   */
  public PlacementReferralLogRetrieveSO retrievePlacementReferralLog(
                                                                     PlacementReferralLogRetrieveSI placementReferralLogRetrieveSI) {

    PlacementReferralLogRetrieveSO placementReferralLogRetrieveSO = null;

    // get archinputstruct object from retrieveSI object and then
    // get the page number and page size.
    ArchInputStruct input = placementReferralLogRetrieveSI.getArchInputStruct();
    int pageNbr = input.getUsPageNbr();
    int pageSize = input.getUlPageSizeNbr();

    int idResource = placementReferralLogRetrieveSI.getIdResource();
    PaginatedHibernateList<Map> placementReferralList = placementReferralDAO
                                                                            .findPlacementReferralByIdResource(
                                                                                                               idResource,
                                                                                                               pageNbr,
                                                                                                               pageSize);

    if (placementReferralList != null || placementReferralList.size() != 0) {

      placementReferralLogRetrieveSO = populatePlacementReferralLog_RetrieveSO(placementReferralList);
    }
    placementReferralLogRetrieveSO.setIdResource(idResource);

    return placementReferralLogRetrieveSO;
  }

  /**
   * Helper method which populates the retrieveSO object from PaginatedHibernateList<Map>.
   * 
   * @param placementReferralList
   * @return
   */
  private PlacementReferralLogRetrieveSO populatePlacementReferralLog_RetrieveSO(
                                                                                 PaginatedHibernateList<Map> placementReferralList) {
    PlacementReferralLogRetrieveSO prLogRetrieveSO = new PlacementReferralLogRetrieveSO();
    List<PlacementReferralLogList> listOfplacementReferrals = new ArrayList<PlacementReferralLogList>();

    // create ArchOutputStruct and set the "more data indicator" field from PaginatedHibernateList
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    archOutputStruct.setBMoreDataInd(placementReferralList.getBMoreDataInd());

    for (Iterator<Map> it = placementReferralList.iterator(); it.hasNext();) {
      Map placementReferralMap = it.next();
      PlacementReferralLogList placementReferralLogList = new PlacementReferralLogList();

      int idPerson = (Integer) placementReferralMap.get("idPerson");

      // get person details for this person.
      Person person = personDAO.findPersonByIdPerson(idPerson);
      String nmPersonFull = null;
      String cdPersonSex = null;
      Date dtPersonBirth = null;
      int nbrPersonAge = 0;

      if (person != null) {
        nmPersonFull = person.getNmPersonFull();
        cdPersonSex = person.getCdPersonSex();
        dtPersonBirth = person.getDtPersonBirth();
        if (person.getNbrPersonAge() != null) {
          nbrPersonAge = person.getNbrPersonAge();
        }
      }

      int idEmployee = (Integer) placementReferralMap.get("idEmployee");

      // get the employee's full name.
      Employee employee = employeeDAO.findEmployeeByIdPerson(idEmployee);

      String nmEmployeeFull = null;
      if (employee != null) {
        nmEmployeeFull = employee.getPerson().getNmPersonFull();
      }

      Date dtBegin = (Date) placementReferralMap.get("dtBegin");
      Date dtExpiration = (Date) placementReferralMap.get("dtExpiration");
      String cdStatus = (String) placementReferralMap.get("cdStatus");
      String cdPlacementType = (String) placementReferralMap.get("cdPlacementType");
      int idPlacementReferral = (Integer) placementReferralMap.get("idPlacementReferral");

      // populate the placementReferralLogList object.
      placementReferralLogList.setIdPlacementReferral(idPlacementReferral);
      placementReferralLogList.setDtBegin(dtBegin);
      placementReferralLogList.setDtExpiration(dtExpiration);
      placementReferralLogList.setCdStatus(cdStatus);
      placementReferralLogList.setIdPerson(idPerson);
      placementReferralLogList.setNmPersonFull(nmPersonFull);
      placementReferralLogList.setCdPersonSex(cdPersonSex);
      placementReferralLogList.setDtPersonBirth(dtPersonBirth);
      placementReferralLogList.setNbrPersonAge(nbrPersonAge);
      placementReferralLogList.setCdPlacementType(cdPlacementType);
      placementReferralLogList.setNmEmployeeFull(nmEmployeeFull);

      //put logList object in retrieveSO object.
      listOfplacementReferrals.add(placementReferralLogList);
    }
    //put the list of referrals & ArchOutputStruct in retrieveSO object.
    prLogRetrieveSO.setPlacementReferralLogList(listOfplacementReferrals);
    prLogRetrieveSO.setArchOutputStruct(archOutputStruct);

    return prLogRetrieveSO;

  }
}
