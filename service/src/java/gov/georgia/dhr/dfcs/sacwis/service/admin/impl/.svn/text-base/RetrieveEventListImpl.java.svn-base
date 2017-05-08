package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 **  07/14/2008  charden           STGAP00006639 - added logic to check if page to be displayed is the relative care list 
 *                                 page and if so to get the person names to be displayed on the page from the person table
 *   03/26/2009  arege             STGAP00011634 Modified code so that all users cannot view the Sensitive case events through the ViewPerson Events
 *                                 on the Person Detail Page.    
 *   03/24/2010  arege             SMS#48651: Added code so that the event list displays all CFR events in the case only for the child and not all children in the case.
 *   03/28/2010  arege             Added code so that CNS eventlist displays events for the PC only in the ADO,FCC and PFC stages of that PC.                        
 *   10/05/2011  pnguyen           MR-094: Visitation Type
 *                                 
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TaskDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Task;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveEventList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN33SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO_ARRAY;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveEventListImpl extends BaseServiceImpl implements RetrieveEventList {

  public static final String IS_SENSITIVE = ArchitectureConstants.Y;

  private static final String MULTIPLE = "MULTIPLE";

  public static final String EXTERNAL_DOCUMENTATION_TASK = "2290";

  public static final String RCA_TASK = "9525";
  
  public static final String REQ_FUNC_CD_CHILDREN_FIRST_ADD = "CFR";
  
  public static final String REQ_FUNC_CD_CDNFSI_ADD = "CNS";
  
  public static final String REQ_FUNC_CD_PERM_ROUNDTABLE_ADD = "PER";
  
  public static final String REQ_FUNC_CD_SAFETY_ROUNDTABLE_ADD = "SRT";

  private StageDAO stageDAO = null;

  private DynamicEventDAO dynamicEventDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private TaskDAO taskDAO = null;

  private RiskAssessmentDAO riskAssessmentDAO = null;

  private RelativeCareAssmtPersonDAO relativeCareAssmtPersonDAO = null;

  private PersonDAO personDAO = null;
  
  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setTaskDAO(TaskDAO taskDAO) {
    this.taskDAO = taskDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setRiskAssessmentDAO(RiskAssessmentDAO riskAssessmentDAO) {
    this.riskAssessmentDAO = riskAssessmentDAO;
  }

  public void setRelativeCareAssmtPersonDAO(RelativeCareAssmtPersonDAO relativeCareAssmtPersonDAO) {
    this.relativeCareAssmtPersonDAO = relativeCareAssmtPersonDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CCMN33SO retrieveEventList(CCMN33SI ccmn33si) throws ServiceException {
    CCMN33SO ccmn33so = new CCMN33SO();
    // call cint21d
    Stage stage = stageDAO.findStageByIdStage(ccmn33si.getUlIdStage());
    if (stage != null) {
      ccmn33so.setDtDtStageClose(DateHelper.toCastorDate(stage.getDtStageClose()));
      ccmn33so.setSzCdStageReasonClosed(stage.getCdStageReasonClosed());
    }

    // Both IndFilteredSensitiveEvents and ROWCCMN33SO_ARRAY arpopulated in this call.
    // Several values in ccmn33si are used to populate the input for ccmn87d.
    // If nothing is found, the below will be skipped naturally, as it enumerates over the results from this call..
    // If a pullback for adoption assistance then can its own method
    if(ArchitectureConstants.Y.equals(ccmn33si.getBIndAdoptionAssitPB())) {
      retrieveAdoAppEvents(ccmn33si, ccmn33so);
    } else {
      retrieveEvents(ccmn33si, ccmn33so);
    }
    

    // For every row returned from the previous DAO, find people associated with it. If there is a CD_TASK
    // associated with the event, call DAO to return task information from Task Table
    ROWCCMN33SO_ARRAY rowccmn33so_array = ccmn33so.getROWCCMN33SO_ARRAY();
    Enumeration rowccmn33so_enum = rowccmn33so_array.enumerateROWCCMN33SO();
    while (rowccmn33so_enum.hasMoreElements()) {
      ROWCCMN33SO rowccmn33so = (ROWCCMN33SO) rowccmn33so_enum.nextElement();
      // ccmn85d -- updates rowccmn33so.szScrPersonNameEvent with name information from event person link using
      // rowccmn33so.ulIdEvent.
      findEventPersonLinkName(rowccmn33so);
      if (rowccmn33so.getSzCdTask() != null) {
        // ccmn82d -- Populate szTxtTaskDecode in the output object if it is not already popualated.
        String txtTaskDecode = retrieveTaskInfo(rowccmn33so);
        if (ccmn33so.getSzTxtTaskDecode() == null) {
          ccmn33so.setSzTxtTaskDecode(txtTaskDecode);
        }
        if (EXTERNAL_DOCUMENTATION_TASK.equals(rowccmn33so.getSzCdTask())) {
          // cinvd2d
          String indRiskAssmtIntranet = riskAssessmentDAO.findIndRiskAssmtIntranetByIdStage(ccmn33si.getUlIdStage());
          if (ArchitectureConstants.Y.equals(indRiskAssmtIntranet)) {
            rowccmn33so.setBIndTaskEventNavig(ArchitectureConstants.N);
          }
        }
      }
    }
    return ccmn33so;
  }

  private void retrieveEvents(CCMN33SI ccmn33si, CCMN33SO ccmn33so) throws ServiceException {

    // Before we call dynamicEventDAO we must first decide if we need to include extra tables. If cReqFunCd from the
    // archInputStruct is REQ_FUNC_CD_ADD ('A') then set extraTables to true. If Fun from the archInputStruct is
    // REQ_FUNC_CD_UPDATE ('U') then set extraTables to false.
    String cReqFuncCd = ccmn33si.getArchInputStruct().getCReqFuncCd();
 
    //Event list should display CNSevents for the PC child only in their FCC, ADO and PFC stages
    //Event list should display only Permanency Roundtable events where the primary child is the primary 
    // child of the currnet stage.  So other children's FCC do not show up. 
    if(REQ_FUNC_CD_CDNFSI_ADD.equals(cReqFuncCd) || REQ_FUNC_CD_PERM_ROUNDTABLE_ADD.equals(cReqFuncCd)){
      Integer idChild = 0;
      if(REQ_FUNC_CD_CDNFSI_ADD.equals(cReqFuncCd)){
      idChild = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(ccmn33si.getUlIdStageForCNS(), "PC");
      }else{
      // STGAP00017068: ECEM - Getting Stage id From non CDNF events then setting stage id to 0 to allow case search.
      idChild = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(ccmn33si.getUlIdStage(), "PC");  
      ccmn33si.setUlIdStage(0);
      
      }
      if (idChild == null) {
        idChild = 0;
     }
       ccmn33si.setUlIdPerson(idChild);
     }
    
    boolean extraTables;
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      extraTables = true;
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      extraTables = false;
    } else if (ServiceConstants.REQ_FUNC_CD_HEALTH_LOG_ADD.equals(cReqFuncCd)) {
      extraTables = true; // only used for the Health Log Event List page
      // reset this value to UPDATE otherwise third level tabs would not be displayed
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
      ccmn33si.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
    } else if (REQ_FUNC_CD_CHILDREN_FIRST_ADD.equals(cReqFuncCd)) {
      extraTables = true; // used for Children 1st Referral Event List page
      // reset this value to UPDATE otherwise third level tabs would not be displayed
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
      ccmn33si.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
    } else if (REQ_FUNC_CD_CDNFSI_ADD.equals(cReqFuncCd)) {
      extraTables = true; // used for CDNFSI Event List page
      // reset this value to UPDATE otherwise third level tabs would not be displayed
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
      ccmn33si.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
    } else if (REQ_FUNC_CD_PERM_ROUNDTABLE_ADD.equals(cReqFuncCd)) {
        extraTables = true; //STGAP00017068: ECEM 5.0 used for Perm Roundtable Event List page
        // reset this value to UPDATE otherwise third level tabs would not be displayed
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
        ccmn33si.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
       
      }else if (REQ_FUNC_CD_SAFETY_ROUNDTABLE_ADD.equals(cReqFuncCd)) {
          extraTables = false; //STGAP00017068: ECEM 5.0 used for Perm Roundtable Event List page
          // reset this value to UPDATE otherwise third level tabs would not be displayed
          cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
          ccmn33si.getArchInputStruct().setCReqFuncCd(cReqFuncCd);    
      } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

    List<String> cdEventTypeList = new ArrayList<String>();
    List<String> cdStageList = new ArrayList<String>();
    List<String> cdEventStatusList = new ArrayList<String>();
    ROWCCMN33SI_ARRAY rowccmn33si_array = ccmn33si.getROWCCMN33SI_ARRAY();
    if (rowccmn33si_array != null) {
      Enumeration rowccmn33si_enum = rowccmn33si_array.enumerateROWCCMN33SI();
      while (rowccmn33si_enum.hasMoreElements()) {
        ROWCCMN33SI rowccmn33si = (ROWCCMN33SI) rowccmn33si_enum.nextElement();
        String cdEventType = rowccmn33si.getSzCdEventType();
        // Check if one or more CdEventType's have been entered.
        // There may be 0 thru 40 different values for CdEventType
        if (StringHelper.isValid(cdEventType)) {
          cdEventTypeList.add(rowccmn33si.getSzCdEventType());
        }
        String szCdStage = rowccmn33si.getSzCdStage();
        if (StringHelper.isValid(szCdStage)) {
          cdStageList.add(szCdStage);
        }

        String szCdEventStatus = rowccmn33si.getSzCdEventStatus();
        if (StringHelper.isValid(szCdEventStatus)) {
          cdEventStatusList.add(szCdEventStatus);
        }
      }
    }
    String[] cdEventTypes = cdEventTypeList.toArray(new String[cdEventTypeList.size()]);
    String[] cdStages = cdStageList.toArray(new String[cdStageList.size()]);
    String[] cdEventStatuses = cdEventStatusList.toArray(new String[cdEventStatusList.size()]);
    String indUserSealed = ccmn33si.getBIndUserSealed();
    String indUserSensitive = ccmn33si.getBIndUserSensitive();

    Date dtScrDtStartDt = DateHelper.toJavaDate(ccmn33si.getDtScrDtStartDt());
    Date dtScrDtEventEnd = DateHelper.toJavaDate(ccmn33si.getDtScrDtEventEnd());
    // call ccmn87d
    PaginatedHibernateList<Object[]> result = dynamicEventDAO.findEvents(extraTables, ccmn33si.getUlIdCase(),
                                                                         ccmn33si.getUlIdStage(),
                                                                         ccmn33si.getUlIdPerson(),
                                                                         ccmn33si.getUlIdSituation(),
                                                                         ccmn33si.getUlIdEventPerson(), cdEventTypes,
                                                                         cdStages, ccmn33si.getSzCdTask(),
                                                                         dtScrDtStartDt, dtScrDtEventEnd,
                                                                         cdEventStatuses, ccmn33si.getArchInputStruct()
                                                                                                  .getUsPageNbr(),
                                                                         ccmn33si.getArchInputStruct()
                                                                                 .getUlPageSizeNbr());

    ROWCCMN33SO_ARRAY rowccmn33so_array = new ROWCCMN33SO_ARRAY();
    if (result != null && !result.isEmpty()) {    	
      ccmn33so.setBIndFilteredSensitiveEvents(ArchitectureConstants.N);
      for (Iterator<Object[]> it = result.iterator(); it.hasNext();) {
        Object[] personStage = it.next();
        
        ROWCCMN33SO rowccmn33so = new ROWCCMN33SO();
        String indCaseSensitive = (String) personStage[14]; // STGAP00011634 changed from 12 to 13
        // STGAP00011634: Check if the Case is Sensitive and the User does not have sensitive case access ,
        // profile, if true do not add this event to the list and mark as filtered sensitive events.
					if (IS_SENSITIVE.equals(indCaseSensitive)
							&& (ArchitectureConstants.N
									.equals(indUserSensitive))) {
						ccmn33so
								.setBIndFilteredSensitiveEvents(ArchitectureConstants.Y);
					} else {
						String indStageSealed = (String) personStage[12];
						String cdStage = (String) personStage[2];
						if (ArchitectureConstants.N.equals(indUserSealed)
								&& !CodesTables.CSTAGES_FAD.equals(cdStage)
								&& ArchitectureConstants.Y
										.equals(indStageSealed)) {
							// STGAP00011107: If the stage is sealed, and is not
							// a FAD stage and the user does not have SAU Sealed
							// attribute
							// then do not add the events for that stage in the
							// result set.
						} else {
							Date dtEventOccurred = (Date) personStage[3];
							rowccmn33so.setDtDtEventOccurred(DateHelper
									.toCastorDate(dtEventOccurred));
							String cdEventStatus = (String) personStage[0];
							rowccmn33so.setSzCdEventStatus(cdEventStatus);
							String cdEventType = (String) personStage[1];
							rowccmn33so.setSzCdEventType(cdEventType);
							String ScrCaseWorker = (String) personStage[9];
							rowccmn33so.setSzScrCaseWorker(ScrCaseWorker);
							String txtEventDescr = (String) personStage[10];
							rowccmn33so.setSzTxtEventDescr(txtEventDescr);
							String NmStage = (String) personStage[8];
							rowccmn33so.setSzNmStage(NmStage);
							Integer idCase = (Integer) personStage[5];
							rowccmn33so
									.setUlIdCase(idCase != null ? idCase : 0);
							Integer idEvent = (Integer) personStage[6];
							rowccmn33so.setUlIdEvent(idEvent != null ? idEvent
									: 0);
							Integer idStage = (Integer) personStage[7];
							rowccmn33so.setUlIdStage(idStage != null ? idStage
									: 0);
							rowccmn33so.setSzCdStage(cdStage);
							String cdTask = (String) personStage[11];
							rowccmn33so.setSzCdTask(cdTask);
							String cIndCurrent = (String) personStage[13];
						        rowccmn33so.setCIndCurrent(cIndCurrent);
							rowccmn33so_array.addROWCCMN33SO(rowccmn33so);
						}
					}
				
			}
		}
    ccmn33so.setROWCCMN33SO_ARRAY(rowccmn33so_array);
    ccmn33so.setMoreDataAvailable(ArchitectureConstants.Y.equals(result.getBMoreDataInd()) ? true : false);
  }
  
  
  private void retrieveAdoAppEvents(CCMN33SI ccmn33si, CCMN33SO ccmn33so) throws ServiceException {


    PaginatedHibernateList<Map> result = null;
    if(ArchitectureConstants.N.equals(ccmn33si.getBIndSrvAuthAdoptionAssitPB())) {
      result = specialNeedsDeterminationDAO.findApprovedSpclDeterminationEventsByIdStageNoSpclSer(ccmn33si.getUlIdStage(), ccmn33si.getArchInputStruct()
                                                                                                  .getUsPageNbr(), ccmn33si.getArchInputStruct()
                                                                                                  .getUlPageSizeNbr());
    } else {
      if (CodesTables.CPRGCOD1_510.equals(ccmn33si.getSzCdSvcAuthCategory())) {
        result = specialNeedsDeterminationDAO.findApprovedSpclDeterminationEventsByIdStageNonRecOnly(ccmn33si.getUlIdStage(), ccmn33si.getArchInputStruct()
                                                                                                    .getUsPageNbr(), ccmn33si.getArchInputStruct()
                                                                                                    .getUlPageSizeNbr());
      } else  if (CodesTables.CPRGCOD1_512.equals(ccmn33si.getSzCdSvcAuthCategory())) {
        List<String> serviceList = new ArrayList<String>();
        if(CodesTables.CENTCODE_17.equals(ccmn33si.getSzCdSvcAuthDtlSvc())) {
          serviceList.add(CodesTables.CSPLSERV_DCR);
        } else if(CodesTables.CENTCODE_58.equals(ccmn33si.getSzCdSvcAuthDtlSvc())) {
          serviceList.add(CodesTables.CSPLSERV_ORT);
          serviceList.add(CodesTables.CSPLSERV_MED);
          serviceList.add(CodesTables.CSPLSERV_TCS);
          serviceList.add(CodesTables.CSPLSERV_XXX);
        } else if(CodesTables.CENTCODE_60.equals(ccmn33si.getSzCdSvcAuthDtlSvc())) {
          serviceList.add(CodesTables.CSPLSERV_RES);
        }
        result = specialNeedsDeterminationDAO.findApprovedSpclDeterminationEventsByIdStageSpclSerOnly(ccmn33si.getUlIdStage(), serviceList, ccmn33si.getArchInputStruct()
                                                                                                     .getUsPageNbr(), ccmn33si.getArchInputStruct()
                                                                                                     .getUlPageSizeNbr());        
      }
    }
        
    ROWCCMN33SO_ARRAY rowccmn33so_array = new ROWCCMN33SO_ARRAY();
    if (result != null && !result.isEmpty()) {
      ccmn33so.setBIndFilteredSensitiveEvents(ArchitectureConstants.N);
      for (Iterator<Map> it = result.iterator(); it.hasNext();) {
        Map entries = it.next();
        ROWCCMN33SO rowccmn33so = new ROWCCMN33SO();
        String indCaseSensitive = (String) entries.get("indCaseSensitive");
        Date dtEventOccurred = (Date) entries.get("dtEventOccurred");
        rowccmn33so.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));
        String cdEventStatus = (String)entries.get("cdEventStatus");
        rowccmn33so.setSzCdEventStatus(cdEventStatus);
        String cdEventType = (String) entries.get("cdEventType");
        rowccmn33so.setSzCdEventType(cdEventType);
        String ScrCaseWorker = "";
        rowccmn33so.setSzScrCaseWorker(ScrCaseWorker);
        String txtEventDescr = (String) entries.get("txtEventDescr");
        rowccmn33so.setSzTxtEventDescr(txtEventDescr);
        String NmStage = (String) entries.get("nmStage");
        rowccmn33so.setSzNmStage(NmStage);
        Integer idCase = (Integer) entries.get("idCase");
        rowccmn33so.setUlIdCase(idCase != null ? idCase : 0);
        Integer idEvent = (Integer) entries.get("idEvent");
        rowccmn33so.setUlIdEvent(idEvent != null ? idEvent : 0);
        Integer idStage = (Integer) entries.get("idStage");
        rowccmn33so.setUlIdStage(idStage != null ? idStage : 0);
        String cdStage = (String) entries.get("cdStage");
        rowccmn33so.setSzCdStage(cdStage);
        String cdTask = (String) entries.get("cdTask");
        rowccmn33so.setSzCdTask(cdTask);
        rowccmn33so_array.addROWCCMN33SO(rowccmn33so);
      }
    }
    ccmn33so.setROWCCMN33SO_ARRAY(rowccmn33so_array);
    ccmn33so.setMoreDataAvailable(ArchitectureConstants.Y.equals(result.getBMoreDataInd()) ? true : false);
  }

  @SuppressWarnings( { "unchecked" })
  private void findEventPersonLinkName(ROWCCMN33SO rowccmn33so) {
    // Call ccmn85d

    // STGAP00006639 - added logic to check if page to be displayed is the relative care list page and if so to get the
    // person
    // names to be displayed on the page from the person table
    List<String> names = null;
    if (RCA_TASK.equals(rowccmn33so.getSzCdTask())) {
      Collection<Integer> idPersons = (Collection<Integer>) relativeCareAssmtPersonDAO
                                                                                      .findIdPersonByIdEvent(rowccmn33so
                                                                                                                        .getUlIdEvent());
      names = personDAO.findNmFullByIdPersons(idPersons);
    } else {
      names = eventPersonLinkDAO.findNmPersonFullByIdEvent(rowccmn33so.getUlIdEvent());
    }
    // No results is not an error here; it just means that no one is linked to the event, which is permissible.
    if (names != null) {
      // If one element, use that name; if there is more than one, use "MULTIPLE."
      if (names.size() == 1) {
        rowccmn33so.setSzScrPersonNameEvent(names.get(0));
      } else if (names.size() > 1) {
        rowccmn33so.setSzScrPersonNameEvent(MULTIPLE);
      }
    }
  }

  private String retrieveTaskInfo(ROWCCMN33SO rowccmn33so) {
    // call ccmn82d
    Task task = taskDAO.findTaskByCdTask(rowccmn33so.getSzCdTask());
    if (task != null) {
      rowccmn33so.setSzCdTaskTopWindow(task.getCdTaskTopWindow());
      // -- Why reset the event status field of the EVENT with the status of the static TASK entry????
      // rowccmn33so.setSzCdEventStatus(task.getCdTaskEventStatus());
      rowccmn33so.setBIndTaskEventNavig(task.getIndTaskEventNavig());
      rowccmn33so.setBIndTaskMultInstance(task.getIndTaskMultipleInstance());
      rowccmn33so.setCIndTaskNewUsing(task.getIndTaskNewUsing());
      rowccmn33so.setBIndTaskDelete(task.getIndTaskDelete());
      return task.getTxtTaskDecode();
    }
    return null;
  }
}
