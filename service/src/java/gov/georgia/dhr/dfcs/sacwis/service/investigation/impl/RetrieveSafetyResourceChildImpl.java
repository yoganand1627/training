package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrieveSafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceChildRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourcePersonBean;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResource;
import gov.georgia.dhr.dfcs.sacwis.db.Person;


import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;

/**
 *This class implements the retrieveSafetyResourceChild service to retrieve
 *database information from SAFETY_RESOURCE_CHILD and STAGE_PERSON_LINK to display
 *the Safety Resource Child page.
 *
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/17/08  PCOOGAN           Creation per Safety Resource enhancement MR-008.
 * </pre>
 */


public class RetrieveSafetyResourceChildImpl extends BaseServiceImpl implements RetrieveSafetyResourceChild {

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private SafetyResourceChildDAO safetyResourceChildDAO = null;
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setSafetyResourceChildDAO(SafetyResourceChildDAO safetyResourceChildDAO) {
    this.safetyResourceChildDAO = safetyResourceChildDAO;
  }
  
  /* Implements public method defined in interface class */
  
  public SafetyResourceChildRetrieveSO retrieveSafetyResourceChild(SafetyResourceChildRetrieveSI 
          safetyResourceChildRetrieveSI) throws ServiceException {

    SafetyResourceChildRetrieveSO safetyResourceChildRetrieveSO = new SafetyResourceChildRetrieveSO();
    List<SafetyResourcePersonBean> safetyResourceChildList = new ArrayList<SafetyResourcePersonBean>();
    
    int ulIdEvent = safetyResourceChildRetrieveSI.getUlIdEvent();
    int ulIdSrChild = safetyResourceChildRetrieveSI.getUlIdSrChild();
    int ulIdStage = safetyResourceChildRetrieveSI.getUlIdStage();
    
    safetyResourceChildRetrieveSO.setUlIdEvent(ulIdEvent);
    safetyResourceChildRetrieveSO.setUlIdSrChild(ulIdSrChild);
    
    // Get the names of the primary and secondary safety resources for display
    List<String> names = getNames(ulIdEvent);
    
    String szPrimaryName = names.get(0);
    String szSecondaryName = names.get(1);
    
    safetyResourceChildRetrieveSO.setNmPrimarySafetyResource(szPrimaryName);
    safetyResourceChildRetrieveSO.setNmSecondarySafetyResource(szSecondaryName);
    
    // If in add mode, get all principals under 18 in stage to populate child list
    if (ulIdSrChild == 0) {
      
      safetyResourceChildList = processChildList(ulIdStage);
      
    } else //get the existing child record, which will be the only one displayed
      
    {
      
      SafetyResourceChild safetyResourceChild = new SafetyResourceChild(); 
      safetyResourceChild = getSafetyResourceChild(ulIdSrChild);
      
      safetyResourceChildRetrieveSO.setDtStart(safetyResourceChild.getDtStart());
      safetyResourceChildRetrieveSO.setDtEnd(safetyResourceChild.getDtEnd());
      safetyResourceChildRetrieveSO.setCdRelationshipPrimary(safetyResourceChild.getCdRelPrimary());
      safetyResourceChildRetrieveSO.setCdRelationshipSecondary(safetyResourceChild.getCdRelSecondary());
  
      safetyResourceChildList = processExistingChildList(safetyResourceChild.getIdChild());
      
      safetyResourceChildRetrieveSO.setSafetyResourceChildList(safetyResourceChildList);
    }
    
    safetyResourceChildRetrieveSO.setSafetyResourceChildList(safetyResourceChildList);
    
    return safetyResourceChildRetrieveSO;
  }

  /**
   * This private method returns a list of principals under 18 in the stage for use in
   * populating the potential child list of the Safety Resource Detail page in add mode.
   *
   * @param idStage
   * @return List<SafetyResourcePersonBean>
   * @throws ServiceException
   */
  @SuppressWarnings( { "unchecked" })
  private List<SafetyResourcePersonBean> processChildList(int idStage) throws ServiceException
  {
  
    List<SafetyResourcePersonBean> safetyResourceChildList = new ArrayList<SafetyResourcePersonBean>();
    List<Map> childList = new ArrayList<Map>();
    
    
    childList = stagePersonLinkDAO.findIdPersonAndNmPersonFullUnder18FromStagePersonLinkAndPerson(idStage);
    
    for (Iterator<Map> it = childList.iterator(); it.hasNext();) {
    
      Map child = (Map)it.next();  
      SafetyResourcePersonBean safetyResourceChild = new SafetyResourcePersonBean();
        
      safetyResourceChild.setUlIdChild(((Integer)child.get("idPerson")).intValue());
      safetyResourceChild.setNmChildFull((String)child.get("nmPersonFull"));
        
      safetyResourceChildList.add(safetyResourceChild);
       
    }
    
    return safetyResourceChildList;
  }
  
  /**
  * This private method uses getPersistentObject to find the names of the primary and
  * secondary safety resources for the Safety Resource event passed.  Primary safety
  * resource name is always passed in the first member of the list, the name of the
  * secondary safety resource is passed if existant.
  *
  * @param idEvent
  * @return List<String>
  * @throws ServiceException
  */
  private List<String> getNames(int idEvent) throws ServiceException
  {
        
    List<String> names = new ArrayList<String>();
      
    SafetyResource safetyResource = getPersistentObject(SafetyResource.class, idEvent);
    Person primaryPerson = getPersistentObject(Person.class, safetyResource.getIdPrimary());
    names.add(0,primaryPerson.getNmPersonFull());
      
    if (safetyResource.getIdSecondary() != null)
    {
      
      Person secondaryPerson = getPersistentObject(Person.class, safetyResource.getIdSecondary());
      names.add(1,secondaryPerson.getNmPersonFull());
      
    } else {
        
        names.add(1,"");
        
    }
     
    return names;
  }
  
  /**
   * This private method gets the existing child information for an existing SAFETY_RESOURCE_CHILD
   * record using the passed idSrChild primary key.
   *
   * @param idSrChild
   * @return SafetyResourceChild db bean
   * @throws ServiceException
   */
  private SafetyResourceChild getSafetyResourceChild(int idSrChild) throws ServiceException
  {
        
    SafetyResourceChild safetyResourceChild = new SafetyResourceChild();
      
    safetyResourceChild = safetyResourceChildDAO.findSafetyResourceByIdSrChild(idSrChild);
     
    return safetyResourceChild;
  }
    
  
  /**
   * This private method populates information for the list of SafetyResourcePersonBeans needed 
   * for the SafetyResourceChildRetrieveSO object when an existing child is known from the 
   * SAFETY_RESOURCE_CHILD table.
   *
   * @param idChild
   * @return List<SafetyResourcePersonBean>
   * @throws ServiceException
   */
  private List<SafetyResourcePersonBean> processExistingChildList(int idChild) throws ServiceException
  {
    
    List<SafetyResourcePersonBean> safetyResourceChildList = new ArrayList<SafetyResourcePersonBean>();
    SafetyResourcePersonBean safetyResourceChild = new SafetyResourcePersonBean();   
    String nmChild = "";
      
    safetyResourceChild.setUlIdChild(idChild);
      
    Person child = getPersistentObject(Person.class, idChild);
      
    nmChild = child.getNmPersonFull();
      
    safetyResourceChild.setNmChildFull(nmChild);
    safetyResourceChildList.add(safetyResourceChild);
     
    return safetyResourceChildList;
  }

}