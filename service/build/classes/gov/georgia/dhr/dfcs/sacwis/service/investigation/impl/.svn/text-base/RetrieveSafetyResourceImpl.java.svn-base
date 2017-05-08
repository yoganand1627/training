package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SrChildrenConsideredPlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SrHouseholdMembersDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpTempAssignDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpTempAssign;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResource;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrieveSafetyResource;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCCPFamilyDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceHshldMemberBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourcePersonBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceRetrieveSO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *This class implements the retrieveSafetyResource service to retrieve
 *database information from SAFETY_RESOURCE, SR_HOUSEHOLD_MEMBERS,and 
 *STAGE_PERSON_LINK tables the Safety Resource Child page.
 *
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/17/08  PCOOGAN           Creation per Safety Resource enhancement MR-008.
 * 06/21/2009  bgehlot         STGAP00014329: MR-20 updates 
 * 07/09/2009  cwells          STGAP00014333:MR-20 Form updates  
 * 10/06/2009  cwells          STGAP00015511 - Changes made to handle previous safety resource to display correctly if they were   
 *                             created pre MR-20.  
 * </pre>                  
 */



public class RetrieveSafetyResourceImpl extends BaseServiceImpl implements RetrieveSafetyResource {
  static final String SAFETY_RSRC_ASMNT_NARR = "SAFETY_RSRC_ASMNT_NARR";
  static final String PRIMARYCARETAKER = "PRIMARY";
  static final String SECONDARYCARETAKER = "SECONDARY";
  static final String VACANT_PERSON = "Vacant";
  static final String NBR_UNIT_COUNTY_DIRECTOR = "18";
  
  private SafetyResourceChildDAO safetyResourceChildDAO = null;
  private SrHouseholdMembersDAO srHouseholdMembersDAO = null;  
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private UnitDAO unitDAO = null;
  private SrChildrenConsideredPlacementDAO srChildrenConsideredPlacementDAO = null;
  private PersonDAO personDAO = null;
  private EmpTempAssignDAO empTempAssignDAO = null;

  public void setEmpTempAssignDAO(EmpTempAssignDAO empTempAssignDAO) {
    this.empTempAssignDAO = empTempAssignDAO;
}
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
}
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
       this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
    
  public void setSafetyResourceChildDAO(SafetyResourceChildDAO safetyResourceChildDAO) {
    this.safetyResourceChildDAO = safetyResourceChildDAO;
  }
    
  public void setSrHouseholdMembersDAO(SrHouseholdMembersDAO srHouseholdMembersDAO) {
    this.srHouseholdMembersDAO = srHouseholdMembersDAO;
  }
  
  public void setSrChildrenConsideredPlacementDAO(SrChildrenConsideredPlacementDAO srChildrenConsideredPlacementDAO) {
    this.srChildrenConsideredPlacementDAO = srChildrenConsideredPlacementDAO;
  }
  
  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }
   
  /*implements public method declared in interface file */          
  
  public SafetyResourceRetrieveSO retrieveSafetyResource(SafetyResourceRetrieveSI safetyResourceRetrieveSI)
      throws ServiceException
  {
	  
    SafetyResourceRetrieveSO safetyResourceRetrieveSO = new SafetyResourceRetrieveSO();
    
    int ulIdStage = safetyResourceRetrieveSI.getUlIdStage();
    int ulIdEvent = safetyResourceRetrieveSI.getUlIdEvent();
    Integer idPrimary;
    Integer idSecondary;

    
    //Call private methods to get the list of possible safety resources, list of all possible
    //household members, list of previously saved household members, and list of currently saved
    //safety resource placements associated with the event
    List<SafetyResourcePersonBean> personSafetyResource = populatePersonsWithSafetyResourceCheckedOnPersonDetail(ulIdStage, ulIdEvent);
    List<SafetyResourceHshldMemberBean> principalsCollaterals = populatePrincpalsCollaterals(ulIdStage);
    List<Integer> hshldMembers = populateHousehold(ulIdEvent);
    List<SafetyResourceChildRetrieveSO> srChildren = populateChildren(ulIdEvent);
    
    //STGAP00014329: populate  the list of members in PK household and list of previously saved children to be
    // considered for placement.
    List<SafetyResourceHshldMemberBean> memeberPKHouseHoldUnder18List = populateMemberPKHouseHoldUnder18(ulIdStage);
    List<Integer> childrenConsideredList = populateChildrenConsidered(ulIdEvent);
    
    
    safetyResourceRetrieveSO.setUlIdEvent(ulIdEvent);
    
    // If not new, get information from the existing event
    if (ulIdEvent != 0) {
      SafetyResource safetyResource = getPersistentObject(SafetyResource.class, ulIdEvent);
      Event event = getPersistentObject(Event.class, ulIdEvent);
      
      safetyResourceRetrieveSO.setUlIdStage((event.getStage()).getIdStage().intValue());
      
      idPrimary = safetyResource.getIdPrimary();
      idSecondary = safetyResource.getIdSecondary();
      
      if (idPrimary != null) {
        
        safetyResourceRetrieveSO.setUlIdPrimary(idPrimary.intValue());
        
      }
      
      if (idSecondary != null) {
        
        safetyResourceRetrieveSO.setUlIdSecondary(idSecondary.intValue());
 
      }     
      
      //STGAP00014329: Added new dates on the page
      safetyResourceRetrieveSO.setDtRequestReceived(safetyResource.getDtRequestReceived());
      safetyResourceRetrieveSO.setDtHomeVisit(safetyResource.getDtHomeVisit());
      
      safetyResourceRetrieveSO.setTxtComments(safetyResource.getTxtComments());
      safetyResourceRetrieveSO.setCdDenialReason(safetyResource.getCdDenialReason());
      safetyResourceRetrieveSO.setIndRecommendation(safetyResource.getIndRecommendation());
      
      safetyResourceRetrieveSO.setCdEventStatus(event.getCdEventStatus());
      safetyResourceRetrieveSO.setDtLastUpdate(event.getDtLastUpdate());
    }   
    
    safetyResourceRetrieveSO.setHshldMembers(hshldMembers);
    safetyResourceRetrieveSO.setSrChildren(srChildren);
    safetyResourceRetrieveSO.setPersonSafetyResource(personSafetyResource);
    safetyResourceRetrieveSO.setPrincipalsCollaterals(principalsCollaterals);
    
    //STGAP00014329: set the lists in the SO object
    safetyResourceRetrieveSO.setMemeberPKHouseHoldUnder18List(memeberPKHouseHoldUnder18List);
    safetyResourceRetrieveSO.setChildrenConsideredList(childrenConsideredList);
    // CAPTA 4.3 Getting County manager to determine page mode access. 
    Stage stage = getPersistentObject(Stage.class, ulIdStage);
    Integer idCountyManager = retrieveCountyDirector(stage.getCdStageCnty());
    safetyResourceRetrieveSO.setIdCountyManager(idCountyManager);
   
    //STGAP00014333: If the document exists
    Date dtLastUpdate = commonDAO.findDtLastUpdate(SAFETY_RSRC_ASMNT_NARR, ulIdEvent);
    if (dtLastUpdate == null) {
      safetyResourceRetrieveSO.setIndBLOBExistsInDatabase(ArchitectureConstants.N);
    }else
      safetyResourceRetrieveSO.setIndBLOBExistsInDatabase(ArchitectureConstants.Y);
      safetyResourceRetrieveSO.setTemplateVersion(safetyResourceChildDAO.findSafetyRsrcFormVersion(ulIdEvent));
   
    return safetyResourceRetrieveSO;
  }
  
  @SuppressWarnings({"unchecked"})
  private Integer retrieveCountyDirector(String cdCounty) {
    Map map = new HashMap();
    Integer idStaff = null;
    String cdStageRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    // Find the County Director for the stage's county and add the person to the list of
    // those to receive the alert
    Unit cd = unitDAO.findUnitFullRowByCdCountyCdUnitRegionNbrUnit(cdCounty, cdStageRegion, NBR_UNIT_COUNTY_DIRECTOR);
    if (cd != null) {
      String nmPerson = personDAO.findNmFullByIdPerson(cd.getPerson().getIdPerson());
      idStaff  = cd.getPerson().getIdPerson();
      // Some counties do not have a county director; rather they have a vacant person and an actual
      // employee is designated to perform the work for the vacant person. In this situation,
      // find the designee and assign the alert to them.
      if (nmPerson.indexOf(VACANT_PERSON) >= 0) {
        List<EmpTempAssign> temps = empTempAssignDAO.findIdsemp(cd.getPerson().getIdPerson());
        if (listIsValid(temps)) {
          EmpTempAssign temp = temps.get(0);
          idStaff = temp.getPersonByIdPersonDesignee().getIdPerson();
        }
      }
    }
    if(idStaff == null) {
      idStaff = 0;
    } 
    return idStaff; 
  }
  

  
  
  private boolean listIsValid(Collection aList) {
    return (aList != null && !aList.isEmpty());
  }

  /**
   * This private method returns a list of principals and collaterals over 18 in the stage
   * which are potential safety resource placements. 
   *
   * @param idStage
   * @return List<SafetyResourcePersonBean>
   * @throws ServiceException
   */
  @SuppressWarnings( { "unchecked" })
  private List<SafetyResourcePersonBean> populatePersonsWithSafetyResourceCheckedOnPersonDetail(int idStage, int idEvent)
                                                                                                                         throws ServiceException {
    List<SafetyResourcePersonBean> personSafetyResource = new ArrayList<SafetyResourcePersonBean>();
 
      List<Map> personSafetyResourceMapList = new ArrayList<Map>();

      personSafetyResourceMapList = stagePersonLinkDAO.findPersonSafetyResCheckedFromStagePersonLink(idStage);
      SafetyResource safetyResource = getPersistentObject(SafetyResource.class, idEvent);
    // STGAP00015511 Checking here to see if the safety resource was saved pre MR-20
    if (idEvent != 0 && safetyResource != null) {

      if (safetyResource.getIdPrimary() != null) {
        SafetyResourcePersonBean primaryPerson = addToPersonSafetyResourceMapList(safetyResource, PRIMARYCARETAKER);
        personSafetyResource.add(primaryPerson);
      }
      if (safetyResource.getIdSecondary() != null) {
        SafetyResourcePersonBean secondaryPerson = addToPersonSafetyResourceMapList(safetyResource, SECONDARYCARETAKER);
        personSafetyResource.add(secondaryPerson);
      }
    }
      if (!personSafetyResourceMapList.isEmpty()) {

          if (idEvent != 0 && safetyResource != null) {
            for (Iterator<Map> it = personSafetyResourceMapList.iterator(); it.hasNext();) {
              boolean isPersonInList = false;
                Map personSafetyResourceMap = it.next();
                SafetyResourcePersonBean safetyResourcePersonBean = new SafetyResourcePersonBean();
         // STGAP00015511 Since this is not required check to make sure it is not null
            int idSecondaryPerson = safetyResource.getIdSecondary() == null ? 0 : safetyResource.getIdSecondary(); 
           if( safetyResource.getIdPrimary() == ((Integer) personSafetyResourceMap.get("idPerson")).intValue()){
             isPersonInList = true;
           }else if( idSecondaryPerson == ((Integer) personSafetyResourceMap.get("idPerson")).intValue()){
             isPersonInList = true;
          }
           // STGAP00015511 If Safety Resource has not been added to the display list yet then add it here 
           if(!isPersonInList){
          safetyResourcePersonBean.setUlIdChild(((Integer) personSafetyResourceMap.get("idPerson")).intValue());
          safetyResourcePersonBean.setNmChildFull((String) personSafetyResourceMap.get("nmPersonFull"));

          personSafetyResource.add(safetyResourcePersonBean);
           }
            }
            }else{
              
              for (Iterator<Map> newIt = personSafetyResourceMapList.iterator(); newIt.hasNext();) {
                
                Map personSafetyResourceMapNew = newIt.next();
                SafetyResourcePersonBean safetyResourcePersonBeanNew = new SafetyResourcePersonBean();
                
                safetyResourcePersonBeanNew.setUlIdChild(((Integer)personSafetyResourceMapNew.get("idPerson")).intValue());
                safetyResourcePersonBeanNew.setNmChildFull((String)personSafetyResourceMapNew.get("nmPersonFull"));
                
                personSafetyResource.add(safetyResourcePersonBeanNew);
              }
      }
        }
    return personSafetyResource;

  }
  
  private SafetyResourcePersonBean addToPersonSafetyResourceMapList(SafetyResource safetyResource, String primary){
  
    SafetyResourcePersonBean previousPrimaryCare = new SafetyResourcePersonBean();
    if(PRIMARYCARETAKER.equals(primary)){
      Person primaryCareTaker = getPersistentObject(Person.class, safetyResource.getIdPrimary());
      previousPrimaryCare.setUlIdChild(((Integer)safetyResource.getIdPrimary()));
      previousPrimaryCare.setNmChildFull(primaryCareTaker.getNmPersonFull());
    }else if (SECONDARYCARETAKER.equals(primary)){
      Person secondaryCareTaker = getPersistentObject(Person.class, safetyResource.getIdSecondary());
      previousPrimaryCare.setUlIdChild(((Integer)safetyResource.getIdSecondary()));
      previousPrimaryCare.setNmChildFull(secondaryCareTaker.getNmPersonFull());
    }
  return previousPrimaryCare;
  }
  
  /**
   * This private method returns a list of all principals and collaterals in the stage
   * which are potential safety resource household members.
   *
   * @param idStage
   * @return List<SafetyResourceHshldMemberBean>
   * @throws ServiceException
   */
  @SuppressWarnings( { "unchecked" })
  private List<SafetyResourceHshldMemberBean> populatePrincpalsCollaterals(int idStage) 
         throws ServiceException {
   
    List<SafetyResourceHshldMemberBean> prinCollat = new ArrayList<SafetyResourceHshldMemberBean>(); 
    List<Map> prinColMapList = new ArrayList<Map>();
    
    prinColMapList = stagePersonLinkDAO.findPrincipalsAndCollateralsFromStagePersonLinkAndPerson(idStage);
    
    if (!prinColMapList.isEmpty()){
      
      for (Iterator<Map> it = prinColMapList.iterator(); it.hasNext();) {
        
        Map prinColMap = it.next();
        SafetyResourceHshldMemberBean safetyResourceHshldMemberBean = new SafetyResourceHshldMemberBean();
        
        safetyResourceHshldMemberBean.setUlIdPerson(((Integer)prinColMap.get("ID_PERSON")).intValue());
        safetyResourceHshldMemberBean.setNmPersonFull((String)prinColMap.get("NM_PERSON_FULL"));
        safetyResourceHshldMemberBean.setSzRole((String)prinColMap.get("CD_STAGE_PERS_ROLE"));
        safetyResourceHshldMemberBean.setSzType((String)prinColMap.get("CD_STAGE_PERS_TYPE"));
        safetyResourceHshldMemberBean.setSzRelationship((String)prinColMap.get("CD_STAGE_PERS_REL_INT"));
        
        prinCollat.add(safetyResourceHshldMemberBean);
        
      }
    }
    return prinCollat;
  }
  
  /**
   * This private method returns an integer list of person id's of currently saved
   * safety resource resource household members for the safety resource event
   *
   * @param idEvent
   * @return List<Integer>
   * @throws ServiceException
   */  
  private List<Integer> populateHousehold(int idEvent) throws ServiceException{
    
    List<Integer> hshldMembers = new ArrayList<Integer>();
    hshldMembers = srHouseholdMembersDAO.findSrHouseholdMembersByIdEvent(idEvent);
    
    return hshldMembers;
    
  }
  
  public byte[] retrieveSafetyRsrcForm(SafetyResourceRetrieveSI safetyResourceRetrieveSI) {
    return safetyResourceChildDAO.retrieveSafetyRsrcForm(safetyResourceRetrieveSI.getUlIdEvent());
  }
  
  /**
   * This private method returns a list of Safety Resource Child Detail return objects
   * for use in displaying the list of individual child safety resource placements
   * associated with the safety resource event
   *
   * @param idEvent
   * @return List<SafetyResourceChildRetrieveSO>
   * @throws ServiceException
   */
  @SuppressWarnings( { "unchecked" })
  private List<SafetyResourceChildRetrieveSO> populateChildren(int idEvent) throws ServiceException{
    
    List<SafetyResourceChildRetrieveSO> srChildrenList = new ArrayList<SafetyResourceChildRetrieveSO>();
    List<Map> safetyResourceChildMapList = new ArrayList<Map>();
    
    safetyResourceChildMapList = safetyResourceChildDAO.findSafetyResourceChildrenForEvent(idEvent);
   
    if (!safetyResourceChildMapList.isEmpty()){
      
      for (Iterator<Map> it = safetyResourceChildMapList.iterator(); it.hasNext();) {
        
        Map safetyResourceChildMap = it.next();
        
        
        SafetyResourceChild safetyResourceChild = (SafetyResourceChild) 
                                                 safetyResourceChildMap.get("safetyResourceChild");
        SafetyResourceChildRetrieveSO safetyResourceChildRetrieveSO = new SafetyResourceChildRetrieveSO();
        SafetyResourcePersonBean safetyResourcePersonBean = new SafetyResourcePersonBean();
        List<SafetyResourcePersonBean> safetyResourceChildList = new ArrayList<SafetyResourcePersonBean>();
  
        safetyResourceChildRetrieveSO.setUlIdEvent(idEvent);
        safetyResourceChildRetrieveSO.setUlIdSrChild(safetyResourceChild.getIdSrChild());
        safetyResourceChildRetrieveSO.setCdRelationshipPrimary(safetyResourceChild.getCdRelPrimary());
        safetyResourceChildRetrieveSO.setCdRelationshipSecondary(safetyResourceChild.getCdRelSecondary());
        safetyResourceChildRetrieveSO.setDtStart(safetyResourceChild.getDtStart());
        safetyResourceChildRetrieveSO.setDtEnd(safetyResourceChild.getDtEnd());
        
        safetyResourcePersonBean.setUlIdChild(safetyResourceChild.getIdChild());
        safetyResourcePersonBean.setNmChildFull((String)safetyResourceChildMap.get("nmPersonFull"));
        
        safetyResourceChildList.add(safetyResourcePersonBean);
        
        safetyResourceChildRetrieveSO.setSafetyResourceChildList(safetyResourceChildList);
        srChildrenList.add(safetyResourceChildRetrieveSO); 
      }
    }
    
    return srChildrenList;
  }
  
  
  /** STGAP00014329
   * This private method returns a list of all members in the Primary Caretaker household who are under 
   * age 18 in the stage
   *
   * @param idStage
   * @return List<SafetyResourceHshldMemberBean>
   * @throws ServiceException
   */
  @SuppressWarnings( { "unchecked" })
  private List<SafetyResourceHshldMemberBean> populateMemberPKHouseHoldUnder18(int idStage) 
         throws ServiceException {
   
    List<SafetyResourceHshldMemberBean> memberPKHouseHoldUnder18 = new ArrayList<SafetyResourceHshldMemberBean>(); 
    List<Map> memberPKHouseHoldUnder18MapList = new ArrayList<Map>();
    
    memberPKHouseHoldUnder18MapList = stagePersonLinkDAO.findMemberPKHouseHoldFromStagePersonLinkAndPersonDtl(idStage);
    
    if (!memberPKHouseHoldUnder18MapList.isEmpty()){
      
      for (Iterator<Map> it = memberPKHouseHoldUnder18MapList.iterator(); it.hasNext();) {
        
        Map  memberPKHouseHoldUnder18Map = it.next();
        SafetyResourceHshldMemberBean safetyResourceHshldMemberBean = new SafetyResourceHshldMemberBean();
        
        safetyResourceHshldMemberBean.setUlIdPerson(((Integer)memberPKHouseHoldUnder18Map.get("ID_PERSON")).intValue());
        safetyResourceHshldMemberBean.setNmPersonFull((String)memberPKHouseHoldUnder18Map.get("NM_PERSON_FULL"));
        safetyResourceHshldMemberBean.setSzRole((String)memberPKHouseHoldUnder18Map.get("CD_STAGE_PERS_ROLE"));
        safetyResourceHshldMemberBean.setSzType((String)memberPKHouseHoldUnder18Map.get("CD_STAGE_PERS_TYPE"));
        safetyResourceHshldMemberBean.setSzRelationship((String)memberPKHouseHoldUnder18Map.get("CD_STAGE_PERS_REL_INT"));
        
        memberPKHouseHoldUnder18.add(safetyResourceHshldMemberBean);
        
      }
    }
    return memberPKHouseHoldUnder18;
  }
  
  /** STGAP00014329:
   * This private method returns an integer list of person id's of currently saved
   * safety resource children considered for the placement for the safety resource event
   *
   * @param idEvent
   * @return List<Integer>
   * @throws ServiceException
   */  
  private List<Integer> populateChildrenConsidered(int idEvent) throws ServiceException{
    
    List<Integer> childrenconsidered = new ArrayList<Integer>();
    childrenconsidered = srChildrenConsideredPlacementDAO.findSrChildrenConsideredByIdEvent(idEvent);
    return childrenconsidered;
  }
}
