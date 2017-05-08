package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.DiligentSearchDAO;
import gov.georgia.dhr.dfcs.sacwis.db.DiligentSearch;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveDiligentSearch;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoList;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiligentSearchInfoRetrieveSO;

public class RetrieveDiligentSearchImpl extends BaseServiceImpl implements RetrieveDiligentSearch {

  private DiligentSearchDAO diligentSearchDAO = null;

  private PersonDAO personDAO = null;

  public void setDiligentSearchDAO(DiligentSearchDAO diligentSearchDAO) {
    this.diligentSearchDAO = diligentSearchDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  @SuppressWarnings("unchecked")
  public DiligentSearchInfoRetrieveSO retrieveDiligentSearchInformation(
                                                                        DiligentSearchInfoRetrieveSI diligentSearchInfoRetrieveSI) {
    DiligentSearchInfoRetrieveSO diligentSearchInfoRetrieveSO = new DiligentSearchInfoRetrieveSO();
    int idCase = diligentSearchInfoRetrieveSI.getUlIdCase();
    int idDiligentSearch = diligentSearchInfoRetrieveSI.getUlIdDiligentSearch();
    int idPersonSearch = diligentSearchInfoRetrieveSI.getulIdPersonSearch();
    int idPersonDetail = diligentSearchInfoRetrieveSI.getUlIdPersonDetail();
    String pageMode = diligentSearchInfoRetrieveSI.getPageMode();
    String personDetailName = null;
    String personSearchName = null;
    List<DiligentSearch> diligentSearchList = new ArrayList();

    // retrieves diligent search info
    if (idPersonSearch == 0 && idDiligentSearch == 0) {
      return diligentSearchInfoRetrieveSO;
    } else if (idPersonSearch != 0) {
      if (pageMode != null && pageMode.equals("NEW_USING")) {
        diligentSearchList = diligentSearchDAO.findDiligentSearchInfoBasedOnCaseId(idCase);
        personSearchName = findPersonNameByIdSearch(idPersonSearch);
        diligentSearchInfoRetrieveSO.setNamePersonSearch(personSearchName);
      } else {
        diligentSearchList = diligentSearchDAO.findDiligentSearchInfo(idPersonSearch);
        personSearchName = findPersonNameByIdSearch(idPersonSearch);
        diligentSearchInfoRetrieveSO.setNamePersonSearch(personSearchName);
        if (pageMode != null && pageMode.equals("NEW")) {
          long countExistingRecord = diligentSearchDAO.countExistingRecord(idPersonDetail, idPersonSearch);
          if (countExistingRecord > 0) {
            throw new ServiceException(Messages.MSG_DILSEARCH_COPY);
          }
        }
      }
      // get diligent search list data
      List diligentList = new ArrayList();
      if (diligentSearchList != null && !diligentSearchList.isEmpty()) {
        for (Iterator it = diligentSearchList.iterator(); it.hasNext();) {
          DiligentSearch diligentSearch = (DiligentSearch) it.next();
          DiligentSearchInfoList diligentSearchInfoList = new DiligentSearchInfoList();
          diligentSearchInfoList.setDtRelCareSubDisc(diligentSearch.getDtSubsyDiscsd());
          diligentSearchInfoList.setIndIncludeDilSrch(diligentSearch.getIndIncDlgnt());
          diligentSearchInfoList.setIndCaretakerPriorRemoval(diligentSearch.getIndCrtkrPrior());
          diligentSearchInfoList.setIndSuccContacted(diligentSearch.getIndSuccCont());
          diligentSearchInfoList.setIndVisitationRsrc(diligentSearch.getIndVisitRsrc());
          diligentSearchInfoList.setIndPlcmtRsrc(diligentSearch.getIndPlcmtRsrc());
          diligentSearchInfoList.setTxtRemCmnts(diligentSearch.getTxtDescRem());
          diligentSearchInfoList.setSelReferralType(diligentSearch.getCdRefType());
          diligentSearchInfoList.setTxtOtherDesc(diligentSearch.getTxtOtherDesc());
          diligentSearchInfoList.setTxtReferrsNm(diligentSearch.getTxtRefName());
          diligentSearchInfoList.setIdDiligentSearchInfo(diligentSearch.getIdDiligentSearch());
          int personDetailId = diligentSearch.getPersonByIdPersonDetail().getIdPerson();
          int personSearchId = diligentSearch.getPersonByIdPersonSearch().getIdPerson();
          personDetailName = findPersonNameByIdDetail(personDetailId);
          personSearchName = findPersonNameByIdSearch(personSearchId);
          diligentSearchInfoList.setPersonName(personDetailName);
          diligentSearchInfoList.setPersonNameSearch(personSearchName);
          diligentList.add(diligentSearchInfoList);
          diligentSearchInfoRetrieveSO.setNamePersonDetail(personDetailName);
        }
      }

      diligentSearchInfoRetrieveSO.setDsiBeanList(diligentList);
     
    }
    // get diligent search information based in diligent search id
    if (idDiligentSearch != 0) {
      DiligentSearch diligentSearch = diligentSearchDAO.findDiligentSearchInfoBasedOnId(idDiligentSearch);
      List diligentInfoList = new ArrayList();
      DiligentSearchInfoList diligentSearchInfoList = new DiligentSearchInfoList();
      if (diligentSearch != null) {
        diligentSearchInfoList.setIndIncludeDilSrch(diligentSearch.getIndIncDlgnt());
        diligentSearchInfoList.setIndPlcmtRsrc(diligentSearch.getIndPlcmtRsrc());
        diligentSearchInfoList.setIndCaretakerPriorRemoval(diligentSearch.getIndCrtkrPrior());
        diligentSearchInfoList.setIndSuccContacted(diligentSearch.getIndSuccCont());
        diligentSearchInfoList.setIndVisitationRsrc(diligentSearch.getIndVisitRsrc());
        diligentSearchInfoList.setTxtCmnts(diligentSearch.getTxtComments());
        diligentSearchInfoList.setTxtNotContactedCmnts(diligentSearch.getTxtWhyCont());
        diligentSearchInfoList.setTxtOtherDesc(diligentSearch.getTxtOtherDesc());
        diligentSearchInfoList.setTxtPlcmtRsrcCmnts(diligentSearch.getTxtRsrc());
        diligentSearchInfoList.setTxtReferrsNm(diligentSearch.getTxtRefName());
        diligentSearchInfoList.setTxtRemCmnts(diligentSearch.getTxtDescRem());
        diligentSearchInfoList.setSelCurrOutcomeContact(diligentSearch.getCdCurrOutcome());
        diligentSearchInfoList.setSelReferralType(diligentSearch.getCdRefType());
        diligentSearchInfoList.setDtRelCareSubDisc(diligentSearch.getDtSubsyDiscsd());
        diligentSearchInfoList.setDtLastUpdate(diligentSearch.getDtLastUpdate());
        diligentInfoList.add(diligentSearchInfoList);
      }
      diligentSearchInfoRetrieveSO.setDsiBeanList(diligentInfoList);
      diligentSearchInfoRetrieveSO.setDsiBean(diligentSearchInfoList);
      int personDetailId = diligentSearch.getPersonByIdPersonDetail().getIdPerson();
      personDetailName = findPersonNameByIdDetail(personDetailId);
      diligentSearchInfoRetrieveSO.setUlIdPersonDetail(personDetailId);
      int personSearchId = diligentSearch.getPersonByIdPersonSearch().getIdPerson();
      personSearchName = findPersonNameByIdSearch(personSearchId);
      diligentSearchInfoRetrieveSO.setUlIdPersonSearch(personSearchId);
      diligentSearchInfoRetrieveSO.setUlIdDiligentSearch(diligentSearch.getIdDiligentSearch());
      diligentSearchInfoRetrieveSO.setNamePersonSearch(personSearchName);
      diligentSearchInfoRetrieveSO.setNamePersonDetail(personDetailName);

      // check for existing record in database.
      if (pageMode != null && pageMode.equals("NEW_USING")) {
        long countExistingRecord = diligentSearchDAO.countExistingRecord(personDetailId, idPersonSearch);
        if (countExistingRecord > 0) {
          throw new ServiceException(Messages.MSG_DILSEARCH_COPY);
        }
      }

    }
    return diligentSearchInfoRetrieveSO;

  }

  // get the person name based on id person search
  public String findPersonNameByIdSearch(int id) {
    String personSearchName = personDAO.findNmFullByIdPerson(id);
    return personSearchName;

  }

  // get name of person based on id person detail
  public String findPersonNameByIdDetail(int id) {
    String personDetailName = personDAO.findNmFullByIdPerson(id);
    return personDetailName;

  }

}
