package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.document.SafetyRoundtableForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SAFETYROUNDTABLESI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourcePersonBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SAFETYROUNDTABLESO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RiskArea;
import gov.georgia.dhr.dfcs.sacwis.db.RiskAssessment;
import gov.georgia.dhr.dfcs.sacwis.db.RiskCategory;
import gov.georgia.dhr.dfcs.sacwis.db.RiskFactors;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SafetyRoundtableFormImpl extends BaseDocumentServiceImpl implements
		SafetyRoundtableForm {

	private StagePersonLinkDAO stagePersonLinkDAO;

	private CommonDAO commonDAO;

	private CapsCaseDAO capsCaseDAO;

	private UnitEmpLinkDAO unitEmpLinkDAO;

	private FCCPFamilyDAO fccpFamilyDAO;

	private EventDAO eventDAO;

	private PersonDAO personDAO;

	private RiskAssessmentDAO riskAssessmentDAO;

	private RiskFactorsDAO riskFactorsDAO;

	private CpsInvstDetailDAO cpsInvstDetailDAO;

	public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
		this.stagePersonLinkDAO = stagePersonLinkDAO;
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

	public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
		this.capsCaseDAO = capsCaseDAO;
	}

	public void setRiskAssessmentDAO(RiskAssessmentDAO riskAssessmentDAO) {
		this.riskAssessmentDAO = riskAssessmentDAO;
	}

	public void setRiskFactorsDAO(RiskFactorsDAO riskFactorsDAO) {
		this.riskFactorsDAO = riskFactorsDAO;
	}

	public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
		this.cpsInvstDetailDAO = cpsInvstDetailDAO;
	}

	public SAFETYROUNDTABLESO retrieveSafetyRoundtableForm(
			SAFETYROUNDTABLESI safetyRoundtableSI) {
		SAFETYROUNDTABLESO safetyRoundtableso = new SAFETYROUNDTABLESO();
		int idEvent = safetyRoundtableSI.getUlIdEvent();

		Event event = eventDAO.findEventByIdEvent(idEvent);
		int idStage = event.getStage().getIdStage();
		int idCase = event.getCapsCase().getIdCase();

		PreFillData preFillData = new PreFillData();

		populateHeaderInfo(preFillData, idStage, idCase, idEvent);
		int idRiskAssessmentEvent = populateRiskConcerns(preFillData, idCase);
		populateRiskCapabilities(preFillData, idCase, idRiskAssessmentEvent);
		populateRiskVulnerability(preFillData, idCase, idRiskAssessmentEvent, idStage);
		processChildList(idStage, preFillData);
		populateOveralRiskLevel(preFillData, idStage, idCase);
		populateBodyInfo(preFillData, idStage);

		safetyRoundtableso.setPreFillData(preFillData);
		return safetyRoundtableso;
	}

	private void populateOveralRiskLevel(PreFillData preFillData, int idStage,
			int idCase) {

		if (idStage > 0) {
			String cdOverallLevel = "";
			RiskAssessment riskReAssessmsnt = riskAssessmentDAO
					.findCompRiskAssessmentLatestByIdStage(idStage);
			if (riskReAssessmsnt != null) {
				cdOverallLevel = riskReAssessmsnt.getCdCurrentLvlRisk();
			} else {// If the most current risk reassessment does not exists
					// then pull the risk level from the investigation
					// conclustion.

				CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO
						.findCpsInvstDetailByIdCaseOnly(idCase);
				// Check for the supervisors override first then then check the
				// case managers entry
				if (cpsInvstDetail != null) {
					if (cpsInvstDetail.getCdOverrideRiskLvl() != null) {
						cdOverallLevel = cpsInvstDetail.getCdOverrideRiskLvl();
					} else {

						cdOverallLevel = cpsInvstDetail.getCdCnclsnRiskLvl();
					}

				}
			}
			preFillData
			.addBookmark(createBookmark(CURRENT_RISK_LEVEL,
					Lookup.simpleDecodeSafe("CLVLRSK",
							cdOverallLevel)));
		}
	}

	@SuppressWarnings("unchecked")
	private void populateRiskVulnerability(PreFillData preFillData, int idCase,
			int idRiskAssessmentEvent, int idStage) {
		List<String> cdFactors = new ArrayList<String>();
		cdFactors.add("R01");
		cdFactors.add("R02");
		cdFactors.add("R03");
		cdFactors.add("R04");
		cdFactors.add("R05");
		cdFactors.add("R06");

		HashMap<String, String> factorsLookUp = new HashMap<String, String>();
		factorsLookUp
				.put(
						"R01",
						"Child is four years old or younger or otherwise unable to protect him/herself.");
		factorsLookUp.put("R03",
				"Caregiver is unwilling/ unable to protect the children.");
		factorsLookUp
				.put(
						"R02",
						"Child's is physically impaired, mentally impaired, or in need of some special care.");
		factorsLookUp.put("R06", "Child's behavior is seen as provoking.");
		factorsLookUp
				.put("R04",
						"Alleged perpetrator, child or adult, has access to a child in the family.");
		factorsLookUp
				.put(
						"R05",
						"Child's behavior is hostile or aggressive or unusually distrubed, fussy, or irritable.");

		// Returns a list of Child Vunerabalities with a response of Yes for the
		// Risk Assessment identified as the most recent comp
		List<RiskFactors> factors = riskFactorsDAO
				.findRiskFactorsByIdEventCdFactorCdResponse(cdFactors,
						idRiskAssessmentEvent, "0");
		if (factors != null && !factors.isEmpty()) {
			for (Iterator<RiskFactors> it = factors.iterator(); it.hasNext();) {
				RiskFactors riskFactor = it.next();
				String cdFactor = riskFactor.getCdRiskFactor();
				preFillData.addFormDataGroup(displayChildVulnerabilities(
						cdFactor, factorsLookUp));
			}
		}		
	}

	private void populateRiskCapabilities(PreFillData preFillData, int idCase,
			int idRiskAssessmentEvent) {
		List<String> cdFactors = new ArrayList<String>();
		cdFactors.add("R07");
		cdFactors.add("R08");
		cdFactors.add("R09");
		cdFactors.add("R10");
		cdFactors.add("R11");
		cdFactors.add("R12");
		cdFactors.add("R13");
		cdFactors.add("R14");
		cdFactors.add("R15");
		cdFactors.add("R16");

		HashMap<String, String> factorsLookUp = new HashMap<String, String>();
		factorsLookUp.put("R07",
				"Caregiver(s) are not lacking knowledge of child development.");
		factorsLookUp
				.put(
						"R08",
						"Caregiver(s) has realistic expectations or understands the needs of the child, considering the child's behavior and development.");
		factorsLookUp
				.put(
						"R09",
						"Caregiver(s) has the parenting skills needed to meet child's behavioral and developmental needs.");
		factorsLookUp.put("R10", " Caregiver has impulse control.");
		factorsLookUp
				.put(
						"R11",
						"Caregiver(s) does not use discipline that is disproportionately harsh compared to the misbehavior.");
		factorsLookUp.put("R12",
				"Caregiver(s) is able to cope appropriately with stress.");
		factorsLookUp
				.put(
						"R13",
						"Caregiver(s) has no history of mental illness such as depression, attempted suicide, schizophrenia, bi-polar disorder, etc. (diagnosed or indicated). ");
		factorsLookUp
				.put(
						"R14",
						"Caregiver(s) has no significant impairment in mental capacity such as retardation, brain damage, etc.(diagnosed or indicated).");
		factorsLookUp.put("R15",
				"Caregiver(s) has no history of drug or alcohol abuse.");
		factorsLookUp.put("R16",
				"Caregiver(s) was not abused or neglected as a child.");

		// Returns a list of Caregiver Capabilities with a response of No for
		// the Risk Assessment identified as the most recent comp
		List<RiskFactors> factors = riskFactorsDAO
				.findRiskFactorsByIdEventCdFactorCdResponse(cdFactors,
						idRiskAssessmentEvent, "1");
		if (factors != null && !factors.isEmpty()) {
			for (Iterator<RiskFactors> it = factors.iterator(); it.hasNext();) {
				RiskFactors riskFactor = it.next();
				String cdFactor = riskFactor.getCdRiskFactor();
				preFillData.addFormDataGroup(displayRiskFactors(cdFactor,
						factorsLookUp));
			}
		}
	}

	private FormDataGroup displayRiskFactors(String cdFactor,
			HashMap<String, String> factorsLookUp) {
		FormDataGroup group = createFormDataGroup(TMPLAT_CAREGIVER_CAP,
				SAFETYROUNDTABLE);
		String factorDecode = factorsLookUp.get(cdFactor);
		group.addBookmark(createBookmark(CAREGIVER_CAP, factorDecode));
		return group;
	}

	private FormDataGroup displayChildVulnerabilities(String cdFactor,
			HashMap<String, String> factorsLookUp) {
		FormDataGroup group = createFormDataGroup(TMPLAT_VULNERABILITY,
				SAFETYROUNDTABLE);
		String factorDecode = factorsLookUp.get(cdFactor);
		group.addBookmark(createBookmark(VULNERABILITY, factorDecode));
		return group;
	}

	
	  /**
	   * This private method returns a list of principals under 18 in the stage 
	   *
	   * @param idStage
	   * @return List<SafetyResourcePersonBean>
	   * @throws ServiceException
	   */
	  @SuppressWarnings( { "unchecked" })
	  private void processChildList(int idStage, PreFillData preFillData) throws ServiceException
	  {
	    List<Map> childList = new ArrayList<Map>();
	    childList = stagePersonLinkDAO.findIdPersonAndNmPersonFullUnder18FromStagePersonLinkAndPerson(idStage);	    
	    for (Iterator<Map> it = childList.iterator(); it.hasNext();) {
	      Map child = (Map)it.next();  	        
	      String nmChildFull = (String)child.get("nmPersonFull");
	      preFillData.addFormDataGroup(addChild(nmChildFull));       
	    }
	  }
	
	private int populateRiskConcerns(PreFillData preFillData, int idCase) {
		RiskAssessment riskAssessment = riskAssessmentDAO
				.findCompRiskAssessmentLatestByIdCase(idCase);
		int idRiskAssessmentEvent = 0;
		if (riskAssessment != null) {

			idRiskAssessmentEvent = riskAssessment.getIdEvent();
			HashMap<String, String> riskCodes = new HashMap<String, String>();
			riskCodes.put("CV", "Child Vulnerability");
			riskCodes.put("CC", "Caregiver Capability");
			riskCodes.put("QC", "Quality of Care");
			riskCodes.put("MT", "Maltreatment Pattern");
			riskCodes.put("HE", "Home Environment");
			riskCodes.put("SE", "Social Environment");
			riskCodes.put("RI", "Response to Intervention");

			List<RiskArea> riskAreas = (List<RiskArea>) riskAssessment
					.getEvent().getRiskAreas();
			if (riskAreas != null && !riskAreas.isEmpty()) {
				for (Iterator<RiskArea> it = riskAreas.iterator(); it.hasNext();) {
					RiskArea riskArea = it.next();
					if (SOMEWHAT.endsWith(riskArea.getCdRiskAreaConcernScale())
							|| CONSIDERABLE.endsWith(riskArea
									.getCdRiskAreaConcernScale())
							|| EXTREME.endsWith(riskArea
									.getCdRiskAreaConcernScale()))
						preFillData.addFormDataGroup(addCategory(riskArea,
								riskCodes));
				}
			}
		}
		return idRiskAssessmentEvent;
	}
	
	private FormDataGroup addChild(String nmFull) {
		FormDataGroup group = createFormDataGroup(TMPLAT_CHILDREN_LIST,
				SAFETYROUNDTABLE);
		group.addBookmark(createBookmark(CHILD, nmFull));
		return group;
	}

	private FormDataGroup addCategory(RiskArea riskArea,
			HashMap<String, String> riskCodes) {
		FormDataGroup group = createFormDataGroup(TMPLAT_RISK_ASSESSMENT,
				SAFETYROUNDTABLE);
		String categoryDecode = riskCodes.get(riskArea.getCdRiskArea());
		group.addBookmark(createBookmark(CATEGORY, categoryDecode));
		return group;
	}

	private void populateBodyInfo(PreFillData preFillData, int idStage) {
		Integer idCaseManager = stagePersonLinkDAO
				.findIdPersonForCaseManagerByIdStage(idStage);

		if (idCaseManager != null) {
			Person manager = personDAO.findPersonByIdPerson(idCaseManager);

			preFillData.addBookmark(createBookmark(CASE_MANAGER,
					formatFullName(manager)));

			Integer unitSupervisorObj = unitEmpLinkDAO
					.findUnitSupervisorByIdPerson(idCaseManager);
			if (unitSupervisorObj > 0) {
				Person supervisor = personDAO
						.findPersonByIdPerson(unitSupervisorObj);

				preFillData.addBookmark(createBookmark(SUPERVISOR,
						formatFullName(supervisor)));

			} else {
				// Creating an empty string to allow Default Prefill tag to be
				// modifable.
				preFillData.addBookmark(createBookmark(SUPERVISOR,
						StringHelper.EMPTY_STRING));
			}
		}
	}

	private void populateHeaderInfo(PreFillData preFillData, int idStage,
			int idCase, int idEvent) {

		Person primaryCareTaker = stagePersonLinkDAO
				.findStagePersonLinkPrimaryCaretaker(idStage);
		Date dtLastUpdate = commonDAO.findDtLastUpdate(EVENT_TABLE,
				idEvent);
		String cdCounty = capsCaseDAO.findCdCaseCountyByIdStage(idStage);

		preFillData.addBookmark(createBookmark(ID_CASE, idCase));

		if (primaryCareTaker != null) {
			int idPrimaryCareTaker = primaryCareTaker.getIdPerson();

			String childFullName = formatFullName(primaryCareTaker);
			preFillData.addBookmark(createBookmark(PK_NAME, childFullName));
			preFillData.addBookmark(createBookmark(ID_PERSON,
					idPrimaryCareTaker));
			preFillData.addBookmark(createBookmark(COUNTY, Lookup
					.simpleDecodeSafe("CCOUNT", cdCounty)));
		}

		preFillData.addBookmark(createBookmark(RT_DATE, DateHelper.toString(
				dtLastUpdate, DateHelper.SLASH_FORMAT)));
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
