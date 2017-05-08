package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.*;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrievePlacementReferralDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PlacementReferralDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementReferralDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PlacementReferral;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;


public class RetrievePlacementReferralDetailImpl extends BaseServiceImpl implements RetrievePlacementReferralDetail {
  private PlacementReferralDAO placementReferralDAO = null;
  
  public void setPlacementReferralDAO(PlacementReferralDAO placementReferralDAO) {
    this.placementReferralDAO = placementReferralDAO;
  }
    
  /**
   * Retrieve service which retrives a row from Placement_Referral table by using Placement Referral ID.
   * This row is populated in retrieveSO to display data on Placement Referral Detail Page.
   * 
   * @author lata.p.lokhande 02/19/2007.
   */
  public PlacementReferralDetailRetrieveSO retrievePlacementReferralDetail(PlacementReferralDetailRetrieveSI placementReferralDetailRetrieveSI){
    
    PlacementReferral placementReferral = null;
    PlacementReferralDetailRetrieveSO prDetailRetrieveSO = null;
    Person person = null;
    Employee employee = null;
    
    String placementType = "";
    Date dtExpiration = null;
    Date dtBegin = new Date();
    String status = "";
    int idPerson = 0;
    int idEmployee = 0;
    int idPlacementReferral = 0;
    String personGender = "";
    Date personBirthDate = null;
    int personAge = 0;
    String personName = "";
    String nmEmployeeFull = "";
            
    idPlacementReferral = placementReferralDetailRetrieveSI.getIdPlacementReferral();
    int idResource = placementReferralDetailRetrieveSI.getIdResource();
    ArchInputStruct input = placementReferralDetailRetrieveSI.getArchInputStruct();
                
    if(idPlacementReferral > 0) {
      placementReferral = placementReferralDAO.findPlacementReferralByIdPlacementReferral(idPlacementReferral);
    }
    prDetailRetrieveSO = new PlacementReferralDetailRetrieveSO();
    if(idResource != 0){
      prDetailRetrieveSO.setIdResource(idResource);
    }
        
    if(placementReferral == null) {
      placementReferral = new PlacementReferral();
    }else {
      placementType = placementReferral.getCdPlacementType();
      dtExpiration = placementReferral.getDtExpiration();
      status = placementReferral.getCdStatus();
      idResource = placementReferral.getCapsResource().getIdResource();
      idPerson = placementReferral.getPerson().getIdPerson();
      idEmployee = placementReferral.getEmployee().getIdPerson();
      dtBegin = placementReferral.getDtBegin();
    }
                
      prDetailRetrieveSO.setCdPlacementType(placementType);
           
      prDetailRetrieveSO.setDtBegin(dtBegin);
      prDetailRetrieveSO.setDtExpiration(dtExpiration);
      prDetailRetrieveSO.setIdResource(idResource);
      prDetailRetrieveSO.setCdStatus(status);
      prDetailRetrieveSO.setIdPlacementReferral(idPlacementReferral);
               
      if(idPerson != 0) {
        person = getPersistentObject(Person.class, idPerson);
      }
            
      if(person != null) {
        personGender = person.getCdPersonSex();
        personBirthDate = person.getDtPersonBirth();
        if(person.getNbrPersonAge() != null) {
          personAge = person.getNbrPersonAge();
        }
        
        personName = person.getNmPersonFull();
      }
        
        prDetailRetrieveSO.setCdPersonSex(personGender);
        prDetailRetrieveSO.setDtPersonBirth(personBirthDate);
        prDetailRetrieveSO.setIdPerson(idPerson);
        //if(personAge != 0){
          prDetailRetrieveSO.setNbrPersonAge(personAge);
        //}
        
        prDetailRetrieveSO.setNmPersonFull(personName);
      
      
      if(idEmployee != 0 ) {
        employee = getPersistentObject(Employee.class, idEmployee);
      }
      
      if(employee != null){
        idEmployee = employee.getIdPerson();
        nmEmployeeFull = employee.getNmEmployeeLast() + ","+ employee.getNmEmployeeFirst() + " "+employee.getNmEmployeeMiddle();
      }
      
      prDetailRetrieveSO.setIdEmployee(idEmployee);
      prDetailRetrieveSO.setNmEmployeeFull(nmEmployeeFull);
      
      return prDetailRetrieveSO;
  }
}