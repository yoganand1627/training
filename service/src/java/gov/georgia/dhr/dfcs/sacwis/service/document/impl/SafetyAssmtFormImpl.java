/**
 * Created on Dec 04, 2006 at 10:55:33 AM by Selima Rollins  
 */
package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SaSafetyAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SaDrugExposedNewborns;
import gov.georgia.dhr.dfcs.sacwis.db.SaReasonableEfforts;
import gov.georgia.dhr.dfcs.sacwis.db.SaSafetyAssessment;
import gov.georgia.dhr.dfcs.sacwis.db.SaSafetyFactor;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;
import gov.georgia.dhr.dfcs.sacwis.service.document.SafetyAssmtForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SAFETYASSESSMENTFRMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SAFETYASSESSMENTFRMSO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SafetyAssmtFormImpl extends BaseDocumentServiceImpl implements SafetyAssmtForm {

  private SaSafetyAssessmentDAO saSafetyAssessmentDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private PersonDAO personDAO;

  private CapsCaseDAO capsCaseDAO;

  private UnitEmpLinkDAO unitEmpLinkDAO;

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setSaSafetyAssessmentDAO(SaSafetyAssessmentDAO saSafetyAssessmentDAO) {
    this.saSafetyAssessmentDAO = saSafetyAssessmentDAO;
  }

  public SAFETYASSESSMENTFRMSO retrieveSafetyAssmtFrm(SAFETYASSESSMENTFRMSI safetyAssessmentFrmsi) {
    SAFETYASSESSMENTFRMSO safetyAssessmentfrmso = new SAFETYASSESSMENTFRMSO();

    int idEvent = safetyAssessmentFrmsi.getUlIdEvent();

    String exposed = safetyAssessmentFrmsi.getSzExposed();

    SaSafetyAssessment safetyAssessmentObject = saSafetyAssessmentDAO.findSafetyAssessmentByIdEvent(idEvent);

    // get case name with case id from case table
    int idCase = safetyAssessmentObject.getCapsCase().getIdCase();

    int idStage = safetyAssessmentFrmsi.getUlIdStage();

    // get the detail data
    String caseName = capsCaseDAO.findNmCaseByIdCase(idCase);

    PreFillData preFillData = getSafetyAssessmentHeadings(idCase, idStage, caseName, safetyAssessmentObject);
    getSafetyFactorRow(preFillData, safetyAssessmentObject);

    getDrugExposedRow(preFillData, safetyAssessmentObject, exposed);
    getReasonableEfforts(preFillData, safetyAssessmentObject);
    safetyAssessmentfrmso.setPreFillData(preFillData);
    return safetyAssessmentfrmso;

  }

  /*
   * Get the individual bookmarks that are not in groups...
   */
  private PreFillData getSafetyAssessmentHeadings(int idCase, int idStage, String caseName,
                                                  SaSafetyAssessment safetyAssessmentObject) {
    PreFillData preFillData = new PreFillData();

    preFillData.addBookmark(createBookmark(TITLE_CASE_NAME, caseName));
    preFillData.addBookmark(createBookmark(TITLE_CASE_ID, idCase));
    getCaseManagerInfo(idStage, preFillData);

    String otherSaFactor = safetyAssessmentObject.getOtherSafetyFactor();
    String addtnlComments = safetyAssessmentObject.getTxtAddtnlComments();
    String overallDecision = safetyAssessmentObject.getCdOvSfDecision();
    String reffortsaddComments = safetyAssessmentObject.getTxtWyRps();

    preFillData.addBookmark(createBookmark(OTHER_FACTORS, otherSaFactor));
    preFillData.addBookmark(createBookmark(SAFETY_COMMENTS_ASSMNT, addtnlComments));
    preFillData.addBookmark(createBookmark(ADDITIONAL_COMMENTS_EFFORTS, reffortsaddComments));
    preFillData.addBookmark(createBookmark(OVERALL_SAFETY_DECISION,
                                           Lookup.simpleDecodeSafe("COVSFDSN", overallDecision)));
    return preFillData;
  }

  /*
   * Retrieves the safety factors and the names of those associated with the case passes them to the appropriate
   */

  @SuppressWarnings("unchecked")
  private void getSafetyFactorRow(PreFillData preFillData, SaSafetyAssessment safetyAssessmentObject) {

    // FormDataGroup safetyGroup = null;
    Map<String, Collection<SaSafetyFactor>> map = new HashMap<String, Collection<SaSafetyFactor>>();
    Iterator<SaSafetyFactor> SafetyFactorIterator = safetyAssessmentObject.getSaSafetyFactors().iterator();
    List<String> keyList = new ArrayList<String>();
    String otherFactor = "";
    // String tempFactor = "";

    while (SafetyFactorIterator.hasNext()) {
      // boolean hasTheSameFactor = false;
      SaSafetyFactor safetyFactor = SafetyFactorIterator.next();
      String factor = safetyFactor.getCdSfFactor();
      Collection<SaSafetyFactor> collection = (Collection) map.get(factor);
      if (collection == null) {
        collection = new ArrayList<SaSafetyFactor>();
        map.put(factor, collection);
        if (!"OTH".equals(factor)) {
          keyList.add(factor);
        } else {
          otherFactor = factor;
        }

      }
      collection.add(safetyFactor);
    }
    Collections.sort(keyList);
    createSafetyFactors(keyList, map, preFillData, otherFactor);
  }

  private void createSafetyFactors(List<String> keyList, Map map, PreFillData preFillData, String otherFactor) {

    Iterator<String> listIter = keyList.iterator();

    while (listIter.hasNext()) {
      String code = listIter.next();
      displaySafetyFactors(code, map, preFillData);
    }
    displayOtherSafetyFactors(map, otherFactor, preFillData);
  }

  @SuppressWarnings("unchecked")
  private FormDataGroup displaySafetyFactors(String code, Map map, PreFillData preFillData) {

    FormDataGroup parentGroup = createFormDataGroup(TMPLAT_SAFETY_FACTORS, FAS01O00);
    Collection<SaSafetyFactor> collect = (Collection) map.get(code);
    parentGroup.addBookmark(createBookmark(SAFETY_FACTORS_LIST, Lookup.simpleDecodeSafe("CSFFAC", code)));

    createSubGroup(collect, parentGroup);
    preFillData.addFormDataGroup(parentGroup);
    return parentGroup;
  }

  @SuppressWarnings("unchecked")
  private void displayOtherSafetyFactors(Map map, String otherFactor, PreFillData preFillData) {
    Collection<SaSafetyFactor> otherCollect = (Collection) map.get(otherFactor);
    createOtherSubGroup(otherCollect, preFillData);
  }

  private FormDataGroup displayOtherSubGroup(SaSafetyFactor saSafetyFactor) {
    FormDataGroup otherGroup = createFormDataGroup(TMPLAT_OTHER_SA_FACTOR, FAS01O00);
    Person caretakerName = saSafetyFactor.getPersonByIdPersonCaretaker();
    Person childName = saSafetyFactor.getPersonByIdPersonChild();
    String safetyFactorResponse = saSafetyFactor.getCdSfFactorRps();

    if (safetyFactorResponse != null && "Y".equals(saSafetyFactor.getCdSfFactorRps())) {
      safetyFactorResponse = "Yes";
    } else {
      safetyFactorResponse = "No";
    }

    otherGroup.addBookmark(createBookmark(OTHER_CARETAKER1, caretakerName.getNmPersonFull()));
    otherGroup.addBookmark(createBookmark(CHILD_OTHER_NA, childName.getNmPersonFull()));
    otherGroup.addBookmark(createBookmark(OTHER_SAFETY_DECISIONS1, safetyFactorResponse));
    return otherGroup;
  }

  private void createOtherSubGroup(Collection<SaSafetyFactor> collect, PreFillData preFillData) {
    if (collect != null && !collect.isEmpty()) {
      for (Iterator<SaSafetyFactor> it = collect.iterator(); it.hasNext();) {
        SaSafetyFactor saSafetyFactor = it.next();
        preFillData.addFormDataGroup(displayOtherSubGroup(saSafetyFactor));
      }
    } // end if
  }

  private FormDataGroup createSubGroup(Collection<SaSafetyFactor> collect, FormDataGroup parentGroup) {
    if (collect != null && !collect.isEmpty()) {
      for (Iterator<SaSafetyFactor> it = collect.iterator(); it.hasNext();) {
        SaSafetyFactor saSafetyFactor = it.next();
        FormDataGroup subGroup = displaySubGroup(saSafetyFactor);
        parentGroup.addFormDataGroup(subGroup);
      }
    } // end if
    return parentGroup;
  }

  private FormDataGroup displaySubGroup(SaSafetyFactor saSafetyFactor) {
    FormDataGroup group = createFormDataGroup(TMPLAT_CLIENT_NAME, FAS01O00);

    Person caretakerName = saSafetyFactor.getPersonByIdPersonCaretaker();
    Person childName = saSafetyFactor.getPersonByIdPersonChild();
    String safetyFactorResponse;
    if (saSafetyFactor.getCdSfFactorRps() != null && "Y".equals(saSafetyFactor.getCdSfFactorRps())) {
      safetyFactorResponse = "Yes";
    } else {
      safetyFactorResponse = "No";
    }
    group.addBookmark(createBookmark(CARETAKER_FULL_NAME, caretakerName.getNmPersonFull()));
    group.addBookmark(createBookmark(CHILD_NAME_FULL, childName.getNmPersonFull()));
    group.addBookmark(createBookmark(SAFETY_DECISION, safetyFactorResponse));
    return group;

  }

  // Retrieves the Reasonable Efforts and sends them to the proper function to be displayed.
  private void getReasonableEfforts(PreFillData preFillData, SaSafetyAssessment safetyAssessment) {

    FormDataGroup reasonEffortsGroup = null;
    String tempEffort = "";
    Iterator<SaReasonableEfforts> reasonableEffortsIterator = safetyAssessment.getSaReasonableEffortses().iterator();
    while (reasonableEffortsIterator.hasNext()) {
      boolean hasTheSameEffort = false;
      SaReasonableEfforts reasonableEfforts = reasonableEffortsIterator.next();
      String reasonEffort = reasonableEfforts.getCdRsbEfforts();
      if (tempEffort.equals(reasonEffort)) {
        hasTheSameEffort = true;
      }

      reasonEffortsGroup = createReasonEffortsRow(reasonableEfforts, hasTheSameEffort, reasonEffortsGroup);
      FormDataGroup reasonNameGroup = createReasonNameGroup();
      createReasonClientName(reasonableEfforts, reasonNameGroup);
      reasonEffortsGroup.addFormDataGroup(reasonNameGroup);
      tempEffort = reasonEffort;
      if (!hasTheSameEffort) {
        preFillData.addFormDataGroup(reasonEffortsGroup);
      }
    }

  }

  private FormDataGroup createReasonEffortsRow(SaReasonableEfforts reasonableEffortsObject, boolean hasTheSameEffort,
                                               FormDataGroup reasonEffortsCurrentGroup) {
    FormDataGroup group = createFormDataGroup(TMPLAT_REASONABLE_EFFORTS, FAS01O00);
    String reasonableEffort = reasonableEffortsObject.getCdRsbEfforts();
    if (!hasTheSameEffort) {
      group.addBookmark(createBookmark(REASONABLE_EFFORTS, Lookup.simpleDecodeSafe("CRSNEFFT", reasonableEffort)));
    } else {
      group = reasonEffortsCurrentGroup;
    }
    return group;
  }

  // This function creates the parent group for the caretaker name group.
  private FormDataGroup createReasonNameGroup() {
    return createFormDataGroup(TMPLAT_REASON_LISTNAMES, FAS01O00);
  }

  // This function combines the inner child name group with the outer group.
  private void createReasonClientName(SaReasonableEfforts reasonableEfforts, FormDataGroup reasonNameGroup) {
    reasonNameGroup.addFormDataGroup(addReasonClientName(reasonableEfforts));
  }

  // This function populates the child name bookmarks.
  private FormDataGroup addReasonClientName(SaReasonableEfforts reasonableEffortsObject) {
    FormDataGroup group = createFormDataGroup(TMPLAT_NAMES, FAS01O00);
    Person childFullName = reasonableEffortsObject.getPerson();
    String effortsComments = reasonableEffortsObject.getTxtComments();
    String effortResponse;
    if ("Y".equals(reasonableEffortsObject.getCdRsbEffortsRps())) {
      effortResponse = "Yes";
    } else {
      effortResponse = "No";
    }
    group.addBookmark(createBookmark(CHILD_NAME_WHOLE, childFullName.getNmPersonFull()));
    group.addBookmark(createBookmark(REASONABLE_EFF_RSPNS, effortResponse));
    group.addBookmark(createBookmark(REASONABLE_EFFORTS_COMMENT, effortsComments));
    return group;
  }

  private PreFillData getCaseManagerInfo(int idStage, PreFillData preFillData) {
    int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, "PR") != null ? Integer
                                                                                                              .parseInt(stagePersonLinkDAO
                                                                                                                                          .findIdPersonByIdStageAndCdStagePersRole(
                                                                                                                                                                                   idStage,
                                                                                                                                                                                   "PR")
                                                                                                                                          .toString())
                                                                                                    : 0;
    Person person = personDAO.findPersonByIdPerson(idPerson);

    if (person != null) {
      UnitEmpLink unitEmpLink = getUnitEmployeeData(person.getIdPerson().intValue());
      preFillData.addBookmark(createBookmark(TITLE_MANAGER_NAME, person.getNmPersonFull()));
      preFillData.addBookmark(createBookmark(TITLE_MANAGER_ID, person.getIdPerson().intValue()));
      
      preFillData.addBookmark(createBookmark(TITLE_COUNTY_NAME, Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                                        unitEmpLink.getUnit().getCdCounty())));
//      preFillData.addBookmark(createBookmark(TITLE_COUNTY_NAME, Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
//                                                                                        person.getCdPersonCounty())));

    }

    return preFillData;
  } /*
     * This function will retrieve the drug exposure questions, if applicable, from the database and sends them to the
     * appropriate function to be displayed.
     */

  private void getDrugExposedRow(PreFillData preFillData, SaSafetyAssessment safetyAssessmentObject, String exposed) {

    FormDataGroup drugExposedGroup;
    if ("true".equals(exposed)) {
      preFillData.addFormDataGroup(createDrugHeader());
      Iterator<SaDrugExposedNewborns> drugExposedIterator = safetyAssessmentObject.getSaDrugExposedNewbornses()
                                                                                  .iterator();
      while (drugExposedIterator.hasNext()) {
        SaDrugExposedNewborns drugExposed = drugExposedIterator.next();
        drugExposedGroup = createDrugExposedRow(drugExposed);
        preFillData.addFormDataGroup(drugExposedGroup);
      }
    }
  }

  private FormDataGroup createDrugHeader() {
    return createFormDataGroup(TMPLAT_DRUG_EXPOSED, FAS01O00);
  }

  /*
   * This function populates the drug exposure bookmarks.
   */
  private FormDataGroup createDrugExposedRow(SaDrugExposedNewborns drugExposed) {
    FormDataGroup group = createFormDataGroup(TMPLAT_EXPOSED_DRUG, FAS01O00);
    String drugExposureRsp;
    if ("Y".equals(drugExposed.getCdDrugExpNbRps())) {
      drugExposureRsp = "Yes";
    } else {
      drugExposureRsp = "No";
    }
    group
         .addBookmark(createBookmark("DRUG_EXPOSED", Lookup.simpleDecodeSafe("CDRGEXNB", drugExposed.getCdDrugExpNb())));
    group.addBookmark(createBookmark("DRUG_EXPOSURE_RESPONSE", drugExposureRsp));
    return group;
  }

  private UnitEmpLink getUnitEmployeeData(int idPerson) {
    UnitEmpLink unitEmpLink = unitEmpLinkDAO
                                            .findUnitFromUnitAndUnitEmpLinkByIdPersonCDUnitMemberInOut(
                                                                                                       idPerson,
                                                                                                       CodesTables.CUMINOUT_IN);
    return unitEmpLink;
  }

}
