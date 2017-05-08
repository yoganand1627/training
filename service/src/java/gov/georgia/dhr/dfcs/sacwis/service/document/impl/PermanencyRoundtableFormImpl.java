package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.document.PermanencyRoundtableForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PERMROUNDTABLESI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PERMROUNDTABLESO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;

import java.util.Date;

public class PermanencyRoundtableFormImpl extends BaseDocumentServiceImpl
		implements PermanencyRoundtableForm {

	private StagePersonLinkDAO stagePersonLinkDAO;
	
	private LegalStatusDAO legalStatusDAO;
	
	private CommonDAO commonDAO;
	
	private UnitEmpLinkDAO unitEmpLinkDAO;
	
	private FCCPFamilyDAO fccpFamilyDAO;
	
	private EventDAO eventDAO;
	
	private PersonDAO personDAO;
		

	public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
		this.stagePersonLinkDAO = stagePersonLinkDAO;
	}
	
	public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
		this.legalStatusDAO = legalStatusDAO;
	}
	
	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
	
	public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
		this.unitEmpLinkDAO = unitEmpLinkDAO;
	}
	
	public void setFccpFamilyDAO(FCCPFamilyDAO fccpFamilyDAO) {
		this.fccpFamilyDAO = fccpFamilyDAO;
	}
	
	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}
	
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
 

  public PERMROUNDTABLESO retrievePermanencyRoundtableForm(PERMROUNDTABLESI permRoundtableSI) {
	  PERMROUNDTABLESO permRoundtableso = new PERMROUNDTABLESO();
	  int idEvent = permRoundtableSI.getUlIdEvent();
	  
	  Event event = eventDAO.findEventByIdEvent(idEvent);
	  int idStage = event.getStage().getIdStage();
	  int idCase = event.getCapsCase().getIdCase();
	  
      PreFillData preFillData = new PreFillData();
      populateHeaderInfo(preFillData, idStage, idCase, idEvent);
      populateBodyInfo(preFillData, idStage, idCase);
      
     
      
	  permRoundtableso.setPreFillData(preFillData);
    return permRoundtableso;
  }

	private void populateBodyInfo(PreFillData preFillData, int idStage, int idCase) {
		Integer idCaseManager = stagePersonLinkDAO
				.findIdPersonForCaseManagerByIdStage(idStage);
		
    // STGAP00017578
    // Get the most recent FCCPFamily by idPrimaryChild
    int idPrimaryChild = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, CodesTables.CROLES_PC);
    FccpFamily fccpFamily = fccpFamilyDAO.findLatestApprovedFCCPFamilyByIdPerson(idPrimaryChild);
    // End STGAP00017578	
		
		
		if (idCaseManager != null) {
			Person manager = personDAO.findPersonByIdPerson(idCaseManager);
			
			preFillData.addBookmark(createBookmark(CASE_MANAGER,
					formatFullName(manager)));
			
			Integer unitSupervisorObj = unitEmpLinkDAO
					.findUnitSupervisorByIdPerson(idCaseManager);
			if (unitSupervisorObj > 0) {
				Person supervisor = personDAO.findPersonByIdPerson(unitSupervisorObj);
				
				preFillData.addBookmark(createBookmark(SUPERVISOR,
						formatFullName(supervisor)));
				
			}else{
				// Creating an empty string to allow Default Prefill tag to be modifable.  
				preFillData.addBookmark(createBookmark(SUPERVISOR, StringHelper.EMPTY_STRING));
			}
		}
		
		if(fccpFamily != null){
		String cdPermanencyPl = fccpFamily.getCdPrimPermPlan();
		String cdConcurrentPl = fccpFamily.getCdSecndPermPlan();
		
		 preFillData.addBookmark(createBookmark(PERM_PLAN, Lookup
			        .simpleDecodeSafe(CodesTables.CPERMPLN, cdPermanencyPl)));
		 preFillData.addBookmark(createBookmark(CONPERM_PLAN, Lookup
			        .simpleDecodeSafe(CodesTables.CPERMPLN, cdConcurrentPl)));
		}
	}

private void populateHeaderInfo(PreFillData preFillData, int idStage, int idCase, int idEvent) {

	int idPrimaryChild = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, CodesTables.CROLES_PC);
	Date dtLastUpdate = commonDAO.findDtLastUpdate(ROUNDTABLE_FORM_TABLE, idEvent);
	
	if(idPrimaryChild != 0){
	String cdCounty = findMostRecentLegalStatusCnty(idPrimaryChild, idCase);
    Person primaryChild = personDAO.findPersonByIdPerson(idPrimaryChild);
	String childFullName = formatFullName(primaryChild);
	preFillData.addBookmark(createBookmark(CHILD_NAME, childFullName));
	preFillData.addBookmark(createBookmark(ID_PERSON, idPrimaryChild));
	preFillData.addBookmark(createBookmark(COUNTY, Lookup.simpleDecodeSafe("CCOUNT", cdCounty)));
	preFillData.addBookmark(createBookmark(RT_DATE, DateHelper.toString(dtLastUpdate, DateHelper.SLASH_FORMAT)));
	}
}


/**
 * This private method displays the county of the most recent legal status for the given person and case.
 * 
 * @param person
 * @return formatted name
 */
	private String findMostRecentLegalStatusCnty(int idPrimaryChild, int idCase) {
		LegalStatus legalStatus = legalStatusDAO
				.findMostRecentLegalStatusByIdPersonIdCase(idPrimaryChild,
						idCase);
		String cdLegalStatusCounty = "";
		if (legalStatus != null) {
			cdLegalStatusCounty = legalStatus.getCdLegalStatCnty();
		}
		return cdLegalStatusCounty;
	}



/**
 * This private method displays name as First Middle Last
 * 
 * @param person
 * @return formatted name
 */
private String formatFullName(Person person) {
  String firstName = person.getNmPersonFirst();
  String lastName = person.getNmPersonLast();
  String middleName = person.getNmPersonMiddle();
  String formattedName = "";
  if (middleName != null && !"".equals(middleName)) {
    formattedName = firstName + " " + middleName + " " + lastName;
  } else {
    formattedName = firstName + " " + lastName;
  }

  return formattedName;
}

}// end of service
