package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

//import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.DiligentSearchDAO;
import gov.georgia.dhr.dfcs.sacwis.db.DiligentSearch;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiligentSearchInfoSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoList;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveDiligentSearch;

//import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

public class SaveDiligentSearchImpl extends BaseServiceImpl implements SaveDiligentSearch {

  private DiligentSearchDAO diligentSearchDAO = null;

  public void setDiligentSearchDAO(DiligentSearchDAO diligentSearchDAO) {
    this.diligentSearchDAO = diligentSearchDAO;
  }

  public DiligentSearchInfoSaveSO saveDiligentSearchInformation(DiligentSearchInfoSaveSI diligentSearchInfoSaveSI)
                                                                                                                  throws ServiceException {

    DiligentSearchInfoSaveSO diligentSearchInfoSaveSO = new DiligentSearchInfoSaveSO();
    saveDiligentSearch(diligentSearchInfoSaveSI);
    return diligentSearchInfoSaveSO;
  }

  private void saveDiligentSearch(DiligentSearchInfoSaveSI diligentSearchInfoSaveSI) throws ServiceException {

    DiligentSearchInfoList diligentSearchInfoList = (DiligentSearchInfoList) diligentSearchInfoSaveSI.getDsiBean();
    DiligentSearch diligentSearch = new DiligentSearch();
    diligentSearch.setIndIncDlgnt(diligentSearchInfoList.getIndIncludeDilSrch());
    diligentSearch.setCdRefType(diligentSearchInfoList.getSelReferralType());
    diligentSearch.setIndCrtkrPrior(diligentSearchInfoList.getIndCaretakerPriorRemoval());
    diligentSearch.setTxtComments(diligentSearchInfoList.getTxtCmnts());
    diligentSearch.setTxtDescRem(diligentSearchInfoList.getTxtRemCmnts());
    diligentSearch.setTxtOtherDesc(diligentSearchInfoList.getTxtOtherDesc());
    diligentSearch.setTxtRefName(diligentSearchInfoList.getTxtReferrsNm());
    diligentSearch.setIndSuccCont(diligentSearchInfoList.getIndSuccContacted());
    diligentSearch.setTxtWhyCont(diligentSearchInfoList.getTxtNotContactedCmnts());
    diligentSearch.setCdCurrOutcome(diligentSearchInfoList.getSelCurrOutcomeContact());
    diligentSearch.setIndVisitRsrc(diligentSearchInfoList.getIndVisitationRsrc());
    diligentSearch.setIndPlcmtRsrc(diligentSearchInfoList.getIndPlcmtRsrc());
    diligentSearch.setTxtRsrc(diligentSearchInfoList.getTxtPlcmtRsrcCmnts());
    diligentSearch.setDtLastUpdate(diligentSearchInfoList.getDtLastUpdate());
    diligentSearch.setDtSubsyDiscsd(diligentSearchInfoList.getDtRelCareSubDisc());
    diligentSearch.setIdDiligentSearch(diligentSearchInfoList.getIdDiligentSearchInfo());
    int idPersonSearch = diligentSearchInfoSaveSI.getUlIdPersonSearch();
    Person person = new Person();
    person = (Person) getPersistentObject(Person.class, idPersonSearch);
    diligentSearch.setPersonByIdPersonSearch(person);
    int idPersonDetail = diligentSearchInfoSaveSI.getUlIdPersonDetail();
    Person persondet = new Person();
    persondet = (Person) getPersistentObject(Person.class, idPersonDetail);
    diligentSearch.setPersonByIdPersonDetail(persondet);
    int idCase = diligentSearchInfoSaveSI.getIdCase();
    CapsCase capsCase = new CapsCase();
    capsCase = (CapsCase) getPersistentObject(CapsCase.class, idCase);
    diligentSearch.setCapsCase(capsCase);
    int idStage = diligentSearchInfoSaveSI.getIdstage();
    Stage stage = new Stage();
    stage = (Stage) getPersistentObject(Stage.class, idStage);
    diligentSearch.setStage(stage);

    diligentSearchDAO.saveDiligentSearchInfo(diligentSearch);
  }

}
