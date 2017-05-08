package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.structs.input.PlacementReferralDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementReferralDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PlacementReferral;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;

import gov.georgia.dhr.dfcs.sacwis.service.resource.SavePlacementReferralDetail;
/**
 * Save service for Placement Referral Detail page.
 * @author lata.p.lokhande, 02/20/2007
 *
 */
public class SavePlacementReferralDetailImpl extends BaseServiceImpl implements SavePlacementReferralDetail {
  
  private PlacementReferralDAO placementReferralDAO = null;
  
  public void setPlacementReferralDAO(PlacementReferralDAO placementReferralDAO) {
    this.placementReferralDAO = placementReferralDAO;
  }
    
  public PlacementReferralDetailSaveSO savePlacementReferralDetail(PlacementReferralDetailSaveSI prDetailSaveSI){
    PlacementReferral placementReferral = null;
    PlacementReferralDetailSaveSO placementReferralDetailSaveSO = new PlacementReferralDetailSaveSO();
    
    int idPerson = prDetailSaveSI.getIdPerson();
    int idResource = prDetailSaveSI.getIdResource();
    int idEmployee = prDetailSaveSI.getIdEmployee();
    int idPlacementReferral = prDetailSaveSI.getIdPlacementReferral();
    
    if(idPlacementReferral == 0) {
      placementReferral = new PlacementReferral();
    }else {
      placementReferral = getPersistentObject(PlacementReferral.class, idPlacementReferral);
    }
        
    Person person = getPersistentObject(Person.class, idPerson);
    placementReferral.setPerson(person);
    
    CapsResource resource = getPersistentObject(CapsResource.class, idResource);
    placementReferral.setCapsResource(resource);
    
    Employee employee = getPersistentObject(Employee.class, idEmployee);
    placementReferral.setEmployee(employee);
    
    placementReferral.setCdPlacementType(prDetailSaveSI.getCdPlacementType());
    placementReferral.setCdStatus(prDetailSaveSI.getCdStatus());
    placementReferral.setDtBegin(prDetailSaveSI.getDtBegin());
    placementReferral.setDtExpiration(prDetailSaveSI.getDtExpiration());
      
    placementReferralDAO.savePlacementReferral(placementReferral);
  
    return placementReferralDetailSaveSO;
    
  }
}
