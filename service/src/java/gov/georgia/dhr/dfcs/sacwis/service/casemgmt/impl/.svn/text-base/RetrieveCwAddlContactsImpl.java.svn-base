//*  Service Class  Name: RetrieveCwAddlContactsImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 12/06/2009
//*
//*  Description:Service Implementation for retrieving Case Watch additiona1 case info data for foster care.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/06/09  Patrick Coogan    Created file for ECEM Case Watch page
//**  03/01/10  Patrick Coogan    SMS 46604: Corrected page display to only show error
//**                              when both CASA and GAL missing
//**  05/12/10  Mital Patel       SMS #51115: added code type to capture GAL Non-Atty.
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WtlpPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.WtlpPlan;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwAddlContacts;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCasaGalBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCiAddlContactSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwFcParentalContactsBean;

public class RetrieveCwAddlContactsImpl extends BaseServiceImpl implements RetrieveCwAddlContacts {

  ContactDAO contactDAO = null;
  
  PersonDAO personDAO = null;
  
  StagePersonLinkDAO stagePersonLinkDAO = null;
  
  WtlpPlanDAO wtlpPlanDAO = null;
  
  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setWtlpPlanDAO(WtlpPlanDAO wtlpPlanDAO) {
    this.wtlpPlanDAO = wtlpPlanDAO;
  }

  @SuppressWarnings("unchecked")
  /**
   * retrieveCwCwAddlContacts retrieves all information necessary for displaying other case info and contact foster care data on the Case Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns CwCiAddlContactSO object.
   */
  public CwCiAddlContactSO retrieveCwAddlContacts(CaseWatchSI caseWatchSI) {

    CwCiAddlContactSO cwCiAddlContactSO = new CwCiAddlContactSO();
    Integer idCase = caseWatchSI.getIdCase();
    Integer idStage = caseWatchSI.getIdStage();
    Integer idPerson = caseWatchSI.getIdPerson();
    
    Integer currentAge = null;
    
    Person child = personDAO.findPersonByIdPerson(idPerson);
    
    if ((child!=null ? child.getDtPersonBirth():null)!=null){
      currentAge = DateHelper.getAge(child.getDtPersonBirth());
    }
    
    List<String> cdStagePersRelInts =  new ArrayList<String>();
    cdStagePersRelInts.add(CodesTables.CRPTRINT_GX); //Atty/Gua Ad Litem
    cdStagePersRelInts.add(CodesTables.CRPTRINT_CS); //CASA
    cdStagePersRelInts.add(CodesTables.CRPTRINT_GY);//SMS #51115: GAL Non-Atty
    //CASA/GAL Involvement
    List<CwCasaGalBean> casaGals = new ArrayList<CwCasaGalBean>();
    addCasaGals(idStage, cdStagePersRelInts, casaGals,cwCiAddlContactSO);
    cwCiAddlContactSO.setCasaGals(casaGals);
    
    //Date of Most Recent Diligent Search Contact
    Date dtDiligentSearchContact = contactDAO.findMostRecentContactByCaseAndPurpose(idCase, CodesTables.CCNTPURP_DIL);
    cwCiAddlContactSO.setDtDiligentSearchContact(dtDiligentSearchContact);
    
    //Date of Most Recent Sibling Contact
    Date dtSiblingContact = contactDAO.findMostRecentContactByCaseAndPersonAndPurpose(idCase, idPerson, CodesTables.CCNTPURP_SIB);
    cwCiAddlContactSO.setDtSiblingContact(dtSiblingContact);
    
    //Date of Parental Contacts

    List<CwFcParentalContactsBean> parentalContacts
                                  = new ArrayList<CwFcParentalContactsBean>();
    cdStagePersRelInts.clear();
    //Legal Custodian/Parent (Legal Only)/Putative Mother are end dated and because
    //of that it has never been added below. 
    cdStagePersRelInts.add(CodesTables.CRPTRINT_AB); //Absent parent
    cdStagePersRelInts.add(CodesTables.CRPTRINT_PT); //Adoptive Parent
    cdStagePersRelInts.add(CodesTables.CRPTRINT_BF); //Biological Father
    cdStagePersRelInts.add(CodesTables.CRPTRINT_BM); //Biological Mother
    cdStagePersRelInts.add(CodesTables.CRPTRINT_BP); //Biological Parent
    cdStagePersRelInts.add(CodesTables.CRPTRINT_BB); //Biological and Legal Father
    cdStagePersRelInts.add(CodesTables.CRPTRINT_CP); //Custodial Parent/Guardian
    cdStagePersRelInts.add(CodesTables.CRPTRINT_LF); //Legal Father
    cdStagePersRelInts.add(CodesTables.CRPTRINT_LM); //Legal Mother
    cdStagePersRelInts.add(CodesTables.CRPTRINT_NC); //Non Custodial Parent
    cdStagePersRelInts.add(CodesTables.CRPTRINT_PA); //Parent
    cdStagePersRelInts.add(CodesTables.CRPTRINT_PK); //Primary Care Taker
    cdStagePersRelInts.add(CodesTables.CRPTRINT_PF); //Putative Father
    cdStagePersRelInts.add(CodesTables.CRPTRINT_SC); //Secondary Care taker
    cdStagePersRelInts.add(CodesTables.CRPTRINT_GP); //Grand Parent
    addParentalContacts(idCase, idStage, cdStagePersRelInts, parentalContacts);
    cwCiAddlContactSO.setParentalContacts(parentalContacts);
    //Assigned ILP Coordinator
    Person person = stagePersonLinkDAO.findStagePersonLinkWithAssignedIPL(idStage);
    if (person != null){
      cwCiAddlContactSO.setNmIlpSecAssign(person.getNmPersonFull());
    }
    WtlpPlan wtlpPlan = wtlpPlanDAO.findWtlpPlanLatestApprovedByIdCaseByIdPerson(idCase, idPerson);
    if (wtlpPlan != null){
      Person ydpCoord = wtlpPlan.getPersonByIdYdpCoord();
      if (ydpCoord != null){
        cwCiAddlContactSO.setNmWtlpIlpAssign(ydpCoord.getNmPersonFull());
      }
    }
    if(currentAge>=14){
      
      if ((cwCiAddlContactSO.getNmIlpSecAssign()==null) || ("".equals(cwCiAddlContactSO.getNmIlpSecAssign()))){
        cwCiAddlContactSO.setIndIlpSecAssignError("E");
        cwCiAddlContactSO.setIndOverallError("E");
      }
      if ((cwCiAddlContactSO.getNmWtlpIlpAssign()==null) || ("".equals(cwCiAddlContactSO.getNmWtlpIlpAssign()))){
        cwCiAddlContactSO.setIndWtlpIlpAssignError("E");
        cwCiAddlContactSO.setIndOverallError("E");
      }  
    }
      
    return cwCiAddlContactSO;
  }
  
  private void addCasaGals(Integer idStage, List<String> cdStagePersRelInts, List<CwCasaGalBean> casaGals, CwCiAddlContactSO cwCiAddlContactSO){
    List<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO.findStagePersonLinkByIdStageByCdStagePersRelInts(idStage, cdStagePersRelInts);

    boolean galFound = false;
    
    if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()){
      for (int i=0; i<stagePersonLinkList.size(); i++){
        StagePersonLink stagePersonLink = stagePersonLinkList.get(i);
        CwCasaGalBean cwCasaGalBean = new CwCasaGalBean();
        Integer idRelPerson = stagePersonLink.getPerson().getIdPerson();
        Person person = personDAO.findPersonByIdPerson(idRelPerson);
        if (person != null){
          cwCasaGalBean.setNmPersonFull(person.getNmPersonFull());
          cwCasaGalBean.setRelCd(stagePersonLink.getCdStagePersRelInt());
          //SMS 46604: Comment out the if here - so basically, if we find a CASA or GAL
          //at all, set to true and no error set
          //if (CodesTables.CRPTRINT_GX.equals(stagePersonLink.getCdStagePersRelInt())){
            galFound = true;
          //}
        }else{
          cwCasaGalBean = null;
        }
        if (cwCasaGalBean != null){
          casaGals.add(cwCasaGalBean);
        }
      }
    }
    
    if (!galFound){ 
      cwCiAddlContactSO.setIndCasaGalError("E");
      cwCiAddlContactSO.setIndOverallError("E");
    }
  }
  
  private void addParentalContacts(Integer idCase, Integer idStage, 
                                   List<String> cdStagePersRelInts, 
                                   List<CwFcParentalContactsBean> parentalContacts){
    List<String> methods = new ArrayList<String>();
    methods.add(CodesTables.CCNTMETH_ATF); //Announced Face to Face
    methods.add(CodesTables.CCNTMETH_UTF); //Unannounced Face to Face
    List<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO.
                        findStagePersonLinkByIdStageByCdStagePersRelInts(idStage, cdStagePersRelInts);

    if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()){
      for (int i=0; i<stagePersonLinkList.size(); i++){
        StagePersonLink stagePersonLink = stagePersonLinkList.get(i);
        //If the Grand Parent is marked as Principal
        if (stagePersonLink.getCdStagePersRelInt().equals(CodesTables.CRPTRINT_GP) &&
                        !stagePersonLink.getCdStagePersType().equals(CodesTables.CPRSNTYP_PRN)){
          continue;
        }
        CwFcParentalContactsBean cwFcParentalContactsBean = new CwFcParentalContactsBean();
        Integer idRelPerson = stagePersonLink.getPerson().getIdPerson();
        Person person = personDAO.findPersonByIdPerson(idRelPerson);
        if (person != null){
          cwFcParentalContactsBean.setNmPersonFull(person.getNmPersonFull());
          cwFcParentalContactsBean.setRelCd(stagePersonLink.getCdStagePersRelInt());
          Date dtOfParentalContact = contactDAO.
                      findMostRecentContactByPersonAndCaseAndMethods(idRelPerson, idCase, methods);
          cwFcParentalContactsBean.setContactDate(dtOfParentalContact);
          cwFcParentalContactsBean.setIndError("");
        }else{
          cwFcParentalContactsBean = null;
        }
        if (cwFcParentalContactsBean != null){
          parentalContacts.add(cwFcParentalContactsBean);
        }
      }
    }
  }
}
