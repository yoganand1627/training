//*  Service Class  Name:     RetrieveAdoptionInformationImpl
//*  Created by:   Jacob Vaidyan
//*  Date Created: 1/8/2007
//*
//*  Description:Service Implementation for retrieving Adoption Information.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  10/7/2008	Ronnie Phelps	  Added changes for adoptions enhancements

//**  06/12/09   mxpatel          STGAP00013445: added code to display the values of the NAC in the latest 
//**                              Ado Info page when going to the Ado Info page through the ECD.
//**  09/11/09  cwells            STGAP00014567: Added method to find the latest actual,approved adoptive placement for the given stage and child  
//**  09/22/09  cwells            STGAP00015326: to remove null pointer changed format of this statement by placing static variable first.
//**  11/19/09  cwells            37378: The disruption date should be pulled from the latest, actual, non-concurrent placement for the child in the ADO stage 
//**                              but it the event is in Complete status then it should be pulled from the DB
//**  11/26/09   arege            SMS#37201 # available for adoption value was not calculated correctly for Ado info in COMP status. 
//**  03/03/11   schoi            SMS #97845: MR-074-2 Added logic to include the VS/TPR Putative Father
//**                              and removed hierarchy of TPR over Voluntary Surrender for displaying the Legal Status field
//**  03/04/11   schoi            SMS #97845: MR-074-2 Reworded comment sections per decode value update
//**                              from 'Voluntary Surrender - Mother' to 'Voluntary Surrender - Biological Mother'
//**                              and from 'TPR - Mother' to 'TPR - Biological Mother'
//**  06/05/11   hnguyen          SMS#109405: MR-083 Updated recruitment activities retrieval logic and updated retrieval to not pull latest
//**                              EXC if existing COMP status adoption information does not have idChildRegEvent saved.
//**  07/05/11   hnguyen          SMS##113568: Fixed issue with setting child exchange registration and county recruitment activities when event is copied.
//**  09/23/11   hnguyen          STGAP00017011: MR-092 Added new logic to retrieve current and history siblings with ado in a different case.
//**                              Also to retrieve current list of principal children with open ADO in a different case to populate dynamic sibling dropdowns.
//**  10/17/11   hnguyen          STGAP00017214: MR-092 Corrected sibling in a different case dropdown to display updated group children if updated in another
//**                              Adoption Information event in the same case.

package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoCbxSentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoSiblingExtLnkHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoSiblingHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExcChildAdoInfoCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildFamLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeHomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionOutcomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RsrcLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingExternalLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingGroupDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfo;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbx;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbxSent;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoFamily;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSiblingExtLnkHistory;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSiblingHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChildFamLink;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeHome;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.Sibling;
import gov.georgia.dhr.dfcs.sacwis.db.SiblingExternalLink;
import gov.georgia.dhr.dfcs.sacwis.db.SiblingGroup;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveAdoptionInformation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionInformationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionResourceBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoInfoCbxSentStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptionInformationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildFamilyLinkBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingExternalLinkStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingGroupInformationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingPlacementGroupSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingSO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ExcChildAdoInfoCbx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class RetrieveAdoptionInformationImpl extends BaseServiceImpl implements RetrieveAdoptionInformation {

  private EventDAO eventDAO = null;

  private AdoInfoDAO adoInfoDAO = null;

  private AdoInfoCbxDAO adoInfoCbxDAO = null;

  private AdoInfoFamilyDAO adoInfoFamilyDAO = null;

  private CapsResourceDAO capsResourceDAO = null;

  private RsrcLinkDAO rsrcLinkDAO = null;

  private ExchangeChildFamLinkDAO exchangeChildFamLinkDAO = null;
  
  private ExchangeChildDAO exchangeChildDAO = null;
  
  private ExchangeHomeDAO exchangeHomeDAO = null;
  
  private SiblingGroupDAO siblingGroupDAO = null;
  
  private SiblingDAO siblingDAO = null;
  
  private SiblingExternalLinkDAO siblingExternalLinkDAO = null;
  
  private StageDAO stageDAO = null;
  
  private LegalActionDAO legalActionDAO = null;
  
  private LegalActionOutcomeDAO legalActionOutcomeDAO = null;
  
  private AdoInfoCbxSentDAO adoInfoCbxSentDAO = null;

  private AdoSiblingHistoryDAO adoSiblingHistoryDAO = null;

  private AdoSiblingExtLnkHistoryDAO adoSiblingExtLnkHistoryDAO = null;

  private ExcChildAdoInfoCbxDAO excChildAdoInfoCbxDAO = null;
  
  private PlacementDAO placementDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setAdoInfoDAO(AdoInfoDAO adoInfoDAO) {
    this.adoInfoDAO = adoInfoDAO;
  }

  public void setAdoInfoCbxDAO(AdoInfoCbxDAO adoInfoCbxDAO) {
    this.adoInfoCbxDAO = adoInfoCbxDAO;
  }

  public void setAdoInfoCbxSentDAO(AdoInfoCbxSentDAO adoInfoCbxSentDAO) {
	  this.adoInfoCbxSentDAO = adoInfoCbxSentDAO;
  }
  
  public void setAdoInfoFamilyDAO(AdoInfoFamilyDAO adoInfoFamilyDAO) {
    this.adoInfoFamilyDAO = adoInfoFamilyDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setRsrcLinkDAO(RsrcLinkDAO rsrcLinkDAO) {
    this.rsrcLinkDAO = rsrcLinkDAO;
  }
  
  public void setExchangeChildFamLinkDAO(ExchangeChildFamLinkDAO exchangeChildFamLinkDAO) {
	  this.exchangeChildFamLinkDAO = exchangeChildFamLinkDAO;
  }
  
  public void setSiblingGroupDAO(SiblingGroupDAO siblingGroupDAO) {
	  this.siblingGroupDAO = siblingGroupDAO;
  }

  public void setSiblingDAO(SiblingDAO siblingDAO) {
		this.siblingDAO = siblingDAO;
  }

  public void setSiblingExternalLinkDAO(SiblingExternalLinkDAO siblingExternalLinkDAO) {
    this.siblingExternalLinkDAO = siblingExternalLinkDAO;
}

  public void setStageDAO(StageDAO stageDAO) {
	  this.stageDAO = stageDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
	  this.legalActionDAO = legalActionDAO;
  }

  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
	  this.exchangeChildDAO = exchangeChildDAO;
  }
  
  public void setExchangeHomeDAO(ExchangeHomeDAO exchangeHomeDAO) {
	  this.exchangeHomeDAO = exchangeHomeDAO;
  }
  
  public void setAdoSiblingHistoryDAO(AdoSiblingHistoryDAO adoSiblingHistoryDAO) {
	  this.adoSiblingHistoryDAO = adoSiblingHistoryDAO;
  }

  public void setAdoSiblingExtLnkHistoryDAO(AdoSiblingExtLnkHistoryDAO adoSiblingExtLnkHistoryDAO) {
	  this.adoSiblingExtLnkHistoryDAO = adoSiblingExtLnkHistoryDAO;
  }

  public void setExcChildAdoInfoCbxDAO(ExcChildAdoInfoCbxDAO excChildAdoInfoCbxDAO) {
	  this.excChildAdoInfoCbxDAO = excChildAdoInfoCbxDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO){
	  this.placementDAO = placementDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO){
	  this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setLegalActionOutcomeDAO(LegalActionOutcomeDAO legalActionOutcomeDAO) {
	  this.legalActionOutcomeDAO = legalActionOutcomeDAO;
  }
  
  @SuppressWarnings("unchecked")
  /**
   * retrieveAdoptionInformation takes care of retrieving Adoption Information and associated check boxes
   * 
   * @param context
   *          The AdoptionInformationRetrieveSI object.
   * 
   * Returns AdoptionInformationRetrieveSO object.
   */
  public AdoptionInformationRetrieveSO retrieveAdoptionInformation(
          AdoptionInformationRetrieveSI adoptioninformationRetrieveSI) throws ServiceException {
    AdoptionInformationRetrieveSO adoptioninfoRetrieveSO = new AdoptionInformationRetrieveSO();

    int idEvent = adoptioninformationRetrieveSI.getUlIdEvent();
    int idStage = adoptioninformationRetrieveSI.getUlIdStage();
    int idCase = adoptioninformationRetrieveSI.getUlIdCase();
    int idResource = 0;
    int idChildRegEvent = 0;
    boolean resPresent = false;
    boolean idfampresent = false;

    Integer idPrimaryChild = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, "PC");
    // STGAP00010427: If the Adoption Information event id is 0 and the child registration event id is non-zero
    // that means the Adoption Information page is being called by clicking the hyperlink on the
    // Exchange child search results or the sibling id hyperlink on the exchange child detail page.
    // In this case we retrieve the corresponding adoption information event id and set it.
    if (adoptioninformationRetrieveSI.getUlIdChildRegEvent() > 0 && idEvent == 0) {
      idChildRegEvent = adoptioninformationRetrieveSI.getUlIdChildRegEvent();
      // STGAP00013445: retrieve the LATEST Adoption Infomation event
      AdoInfo adoInfo = adoInfoDAO.findLatestAdoInfoByIdChildRegEvent(idChildRegEvent);
      if (adoInfo != null) {
        idEvent = adoInfo.getIdEvent();
      }
    } else if (adoptioninformationRetrieveSI.getUlIdChildRegEvent() == 0) {
      // find the latest child registration event only if we didn't come from
      // the Exchange child search results. If we did come from the exchange child
      // search results then idChildRegEvent will be non-zero.
      Event childRegEvent = eventDAO.findLatestEventByStageAndType(idStage, CodesTables.CEVNTTYP_EXC);

      // MR-083 only if adoption info event status is not COMP do we set the latest EXC.
      // Keeping all existing COMP status Adoption Information without idChildRegEvent as is.
      // This scenario occurs when user completes the Adoption Information first before any
      // Exchange Child Detail was completed.
      String cdEventStatus = "";
      cdEventStatus = eventDAO.findEventCdEventStatusbyIdEvent(idEvent);

      if (childRegEvent != null 
                      // event is not completed
                      && (!"COMP".equals(cdEventStatus)
                                      // or if a copied event
                                      || adoptioninformationRetrieveSI.getIsNewUsing())) {
        // set the child's IdChildRegEvent to be the latest event
        idChildRegEvent = childRegEvent.getIdEvent().intValue();
        adoptioninfoRetrieveSO.setUlIdChildRegEvent(idChildRegEvent);
      }
    }

    AdoInfo adoptionInformation = adoInfoDAO.findAdoInformation(idEvent);
    List<AdoInfoCbx> adoptioninformationcbx1List = new ArrayList();
    List<AdoInfoCbx> adoptioninformationcbx2List = new ArrayList();
    List<AdoInfoCbx> adoptioninformationcbx4List = new ArrayList();
    List<AdoInfoCbx> adoptioninformationcbx5List = new ArrayList();
    List<AdoInfoCbx> adoptioninformationcbx6List = new ArrayList();
    List<AdoInfoFamily> adoptionFamilyList = new ArrayList();
    List<ExchangeChildFamLink> exchangeChildFamLinkList = null;
    List<ExchangeChildFamilyLinkBean> exchangeChildFamilyLinkBeanList = new ArrayList();

    /* Add the logic for retrieving the check box and code type */
    String cdEventStatus = "";
    cdEventStatus = eventDAO.findEventCdEventStatusbyIdEvent(idEvent);
    adoptioninformationcbx1List = adoInfoCbxDAO.findAdoInfoCheckboxbyIdEventandCbxCodeType(idEvent, "CADCPAC");
    adoptioninformationcbx2List = adoInfoCbxDAO.findAdoInfoCheckboxbyIdEventandCbxCodeType(idEvent, "CADBREC");
    adoptioninformationcbx4List = adoInfoCbxDAO.findAdoInfoCheckboxbyIdEventandCbxCodeType(idEvent, "CADRACC");
    adoptioninformationcbx5List = adoInfoCbxDAO.findAdoInfoCheckboxbyIdEventandCbxCodeType(idEvent, "CADBPLA");
    adoptioninformationcbx6List = adoInfoCbxDAO.findAdoInfoCheckboxbyIdEventandCbxCodeType(idEvent, "CADBTPR");
    adoptionFamilyList = adoInfoFamilyDAO.findAdoFamilyInfobyIdEvent(idEvent);
    Iterator itPrepActs = adoptioninformationcbx1List.iterator();
    Iterator itBarRec = adoptioninformationcbx2List.iterator();

    Iterator itRecCt = adoptioninformationcbx4List.iterator();
    Iterator itBarPl = adoptioninformationcbx5List.iterator();
    Iterator itBarTpr = adoptioninformationcbx6List.iterator();
    String[] checkedPreperationActivities = new String[adoptioninformationcbx1List.size()];
    String[] checkedBarriersRecruitment = new String[adoptioninformationcbx2List.size()];
    Map<String, List<AdoInfoCbxSentStruct>> savedRecActivitiesDatesCounty = new HashMap<String, List<AdoInfoCbxSentStruct>>();

    String[] checkedBarriersPlacement = new String[adoptioninformationcbx5List.size()];
    String[] checkedBarriersTPR = new String[adoptioninformationcbx6List.size()];

    if (adoptioninformationcbx1List != null && !adoptioninformationcbx1List.isEmpty()) {

      for (int i = 0; itPrepActs.hasNext(); i++) {
        AdoInfoCbx cb1 = (AdoInfoCbx) itPrepActs.next();
        checkedPreperationActivities[i] = (String) cb1.getCdAdoInfoCbx();
      }
    }

    if (adoptioninformationcbx1List != null && !adoptioninformationcbx2List.isEmpty()) {

      for (int i = 0; itBarRec.hasNext(); i++) {
        AdoInfoCbx cb1 = (AdoInfoCbx) itBarRec.next();
        checkedBarriersRecruitment[i] = (String) cb1.getCdAdoInfoCbx();
      }
    }

    if (adoptioninformationcbx4List != null && !adoptioninformationcbx4List.isEmpty()) {

      for (int i = 0; itRecCt.hasNext(); i++) {
        AdoInfoCbx cb1 = (AdoInfoCbx) itRecCt.next();

        List<AdoInfoCbxSent> recruitmentActivityDatesCounty = adoInfoCbxSentDAO.findAdoInfoCbxSentByIdInfoCharIdEvent(cb1.getIdInfoChar(),
                                                                                                            idEvent);
        
        if(recruitmentActivityDatesCounty != null){
          Iterator<AdoInfoCbxSent> itSent = recruitmentActivityDatesCounty.iterator();
          
          while(itSent.hasNext()){
            AdoInfoCbxSent adoInfoCbxSent = itSent.next();
            
            AdoInfoCbxSentStruct adoInfoCbxSentSO = new AdoInfoCbxSentStruct();
            if(adoptioninformationRetrieveSI.getIsNewUsing()){
              // if a copied event then set all id to zero
              adoInfoCbxSentSO.setIdAdoInfoCbxSent(0);
              adoInfoCbxSentSO.setIdInfoChar(0);
              adoInfoCbxSentSO.setIdEvent(0);
            }else{
              adoInfoCbxSentSO.setIdAdoInfoCbxSent(adoInfoCbxSent.getIdAdoInfoCbxSent().intValue());
              adoInfoCbxSentSO.setIdInfoChar(cb1.getIdInfoChar());
              adoInfoCbxSentSO.setIdEvent(cb1.getAdoInfo().getEvent().getIdEvent());
            }
            adoInfoCbxSentSO.setCdCbxCodeType(cb1.getCdCbxCodeType());
            adoInfoCbxSentSO.setCdAdoInfoCbx(cb1.getCdAdoInfoCbx());
            adoInfoCbxSentSO.setDtAdoInfoCbxSent(adoInfoCbxSent.getDtAdoInfoCbxSent());
            
            if( !savedRecActivitiesDatesCounty.containsKey(cb1.getCdAdoInfoCbx())){
              List<AdoInfoCbxSentStruct> adoInfoCbxSentSOList = new ArrayList<AdoInfoCbxSentStruct>();
              adoInfoCbxSentSOList.add(adoInfoCbxSentSO);
              savedRecActivitiesDatesCounty.put(cb1.getCdAdoInfoCbx(), adoInfoCbxSentSOList);
            }else{
              List<AdoInfoCbxSentStruct> adoInfoCbxSentSOList = savedRecActivitiesDatesCounty.get(cb1.getCdAdoInfoCbx());
              adoInfoCbxSentSOList.add(adoInfoCbxSentSO);
            }
          }
          adoptioninfoRetrieveSO.setSavedRecActivitiesDatesCounty(savedRecActivitiesDatesCounty);
        }
      }
    }

    if (adoptioninformationcbx5List != null && !adoptioninformationcbx5List.isEmpty()) {

      for (int i = 0; itBarPl.hasNext(); i++) {
        AdoInfoCbx cb1 = (AdoInfoCbx) itBarPl.next();
        checkedBarriersPlacement[i] = (String) cb1.getCdAdoInfoCbx();
      }
    }

    if (adoptioninformationcbx6List != null && !adoptioninformationcbx6List.isEmpty()) {

      for (int i = 0; itBarTpr.hasNext(); i++) {
        AdoInfoCbx cb1 = (AdoInfoCbx) itBarTpr.next();
        checkedBarriersTPR[i] = (String) cb1.getCdAdoInfoCbx();
      }
    }

    if (adoptionFamilyList != null && !adoptionFamilyList.isEmpty()) {

      String nmFamResource = "";
      List<AdoptionResourceBean> resBeanList = new ArrayList();
      for (Iterator it = adoptionFamilyList.iterator(); it.hasNext();) {
        AdoInfoFamily adofamily = (AdoInfoFamily) it.next();
        AdoptionResourceBean adoresbean = new AdoptionResourceBean();
        if (adofamily.getCapsResource() != null) {
          idfampresent = true;
          int adoFamilyIdResource = adofamily.getCapsResource().getIdResource().intValue();
          adoresbean.setIdResource(adoFamilyIdResource);
          nmFamResource = capsResourceDAO.findNmByIdResourceOnly(adoFamilyIdResource);
          adoresbean.setNmResource(nmFamResource);
          resBeanList.add(adoresbean);
        }
      }
      if (idfampresent) {
        adoptioninfoRetrieveSO.setIdenResList(resBeanList);
      }
    }

    adoptioninfoRetrieveSO.setUlIdEvent(idEvent);
    adoptioninfoRetrieveSO.setCdEventStatus(cdEventStatus);

    Event event = eventDAO.findEventByIdEvent(idEvent);

    if (adoptionInformation != null) {

      adoptioninfoRetrieveSO.setSzCdReasonChildNonAvail(adoptionInformation.getCdChldAvail());
      adoptioninfoRetrieveSO.setDtFostParNotAgTPR(adoptionInformation.getDtIntTpr());
      adoptioninfoRetrieveSO.setDtPermStaffFostPar(adoptionInformation.getDtPermStaff());
      adoptioninfoRetrieveSO.setDtFostParNotAgDecAdpt(adoptionInformation.getDtDecAdopt());
      adoptioninfoRetrieveSO.setDtChildLifeHistPres(adoptionInformation.getDtLifeHisPres());
      adoptioninfoRetrieveSO.setDtStaffAdptFam(adoptionInformation.getDtAdoStaff());
      adoptioninfoRetrieveSO.setDtAdptPlacAgmtSigned(adoptionInformation.getDtAdoAgree());
      adoptioninfoRetrieveSO.setDtDocSentAttor(adoptionInformation.getDtDocSent());
      adoptioninfoRetrieveSO.setDtPermFileLetterComp(adoptionInformation.getDtPermFile());
      adoptioninfoRetrieveSO.setDtLastUpdate(adoptionInformation.getDtLastUpdate());
      adoptioninfoRetrieveSO.setIndOutofTown(adoptionInformation.getIndInqry());
      adoptioninfoRetrieveSO.setIndOtherSiblingsAdopted(adoptionInformation.getIndOthSib());
      adoptioninfoRetrieveSO.setNmFamConsidered(adoptionInformation.getNbrFamCons().intValue());
      adoptioninfoRetrieveSO.setSzCdReasonsFamNotSel(adoptionInformation.getTxtNotSel());
      adoptioninfoRetrieveSO.setSzCdTypeAdptRsrcNeeded(adoptionInformation.getTxtTypAdo());
      adoptioninfoRetrieveSO.setSzCdComntsPrepAct(adoptionInformation.getTxtPrepCmnts());
      adoptioninfoRetrieveSO.setSzCdComntsBarRec(adoptionInformation.getTxtRecrBarr());
      adoptioninfoRetrieveSO.setSzCdComntsRecActsCounty(adoptionInformation.getTxtCntyAct());
      adoptioninfoRetrieveSO.setSzCdComntsBarPla(adoptionInformation.getTxtPlcmntBarr());
      adoptioninfoRetrieveSO.setSzCdComntsBarTpr(adoptionInformation.getTxtTprBarr());
      adoptioninfoRetrieveSO.setSzCdChildLinked(adoptionInformation.getTxtChildLinked());
      adoptioninfoRetrieveSO.setSzCdCountyConsidered(adoptionInformation.getTxtCountyConsComment());
      adoptioninfoRetrieveSO.setDtLetterSent(adoptionInformation.getDtLetterSent());
      adoptioninfoRetrieveSO.setIndAdoptOutcome(adoptionInformation.getIndFpAdo());
      // MR-092 retrieve sibling related questions
      adoptioninfoRetrieveSO.setIndHasSiblingExtCase(adoptionInformation.getIndHasSiblingExtCase());
      adoptioninfoRetrieveSO.setIndSiblingGrpExtCase(adoptionInformation.getIndSiblingGrpExtCase());

      /*
       * If there is already a child registration event, use the existing event We are not updating this with the latest
       * event unless there is a business need
       */
      if (adoptionInformation.getEventByIdEventChildRegistration() != null 
                      && "COMP".equals(cdEventStatus)
                      && !adoptioninformationRetrieveSI.getIsNewUsing()) {
        idChildRegEvent = adoptionInformation.getEventByIdEventChildRegistration().getIdEvent().intValue();
        adoptioninfoRetrieveSO.setUlIdChildRegEvent(idChildRegEvent);
      }

      // 37378 The disruption date should be pulled from the latest, actual, non-concurrent placement for the child in
      // the ADO stage
      // but it the evnet is in Complete status then it should be pulled from the DB
      if ("COMP".equals(event.getCdEventStatus())) {
        adoptioninfoRetrieveSO.setDtDisruption(adoptionInformation.getDtDisrupt());
      } else {
        Date dtDisruption = getDisruptionDate(idPrimaryChild);
        adoptioninfoRetrieveSO.setDtDisruption(dtDisruption);

      }

      if (adoptionInformation.getCapsResource() != null) {
        resPresent = true;
        idResource = adoptionInformation.getCapsResource().getIdResource().intValue();
        adoptioninfoRetrieveSO.setResourceIdForPullback(idResource);
        adoptioninfoRetrieveSO.setInitialResourceIdForPullback(idResource);
        adoptioninfoRetrieveSO.setSzCdCounty(adoptionInformation.getCdRsrcCnty());
        adoptioninfoRetrieveSO.setSzCdState(adoptionInformation.getCdState());
        adoptioninfoRetrieveSO.setNMAgency(adoptionInformation.getNmPrivAgency());
      }
      adoptioninfoRetrieveSO.setIndIdentifiedAdopRes(adoptionInformation.getIndIdenAdo());

      if (resPresent) {
        CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResc(idResource);
        String nmResource = capsResource.getNmResource();
        String category = capsResource.getCdRsrcCategory();
        adoptioninfoRetrieveSO.setNMResource(nmResource);
        adoptioninfoRetrieveSO.setSzCdCategory(category);
      }
      adoptioninfoRetrieveSO.setChkPreperationActivities(checkedPreperationActivities);
      adoptioninfoRetrieveSO.setChkBarriersRecruitment(checkedBarriersRecruitment);
      adoptioninfoRetrieveSO.setSavedRecActivitiesDatesCounty(savedRecActivitiesDatesCounty);
      adoptioninfoRetrieveSO.setChkBarriersPlacement(checkedBarriersPlacement);
      adoptioninfoRetrieveSO.setChkBarriersTPR(checkedBarriersTPR);
    } else {
      Date dtDisruption = getDisruptionDate(idPrimaryChild);
      adoptioninfoRetrieveSO.setDtDisruption(dtDisruption);
    }

    /* if the child is registered with the adoption exchange, lookup the families considered */
    if (idChildRegEvent != 0) {
      ExchangeChild exchangeChild = exchangeChildDAO.findExchangeChildByEventId(idChildRegEvent);

      exchangeChildFamLinkList = exchangeChildFamLinkDAO
                                                        .findExchangeChildFamLinksByChildEventIdAndCurrentInd(
                                                                                                              idChildRegEvent,
                                                                                                              ArchitectureConstants.N);
      if (exchangeChildFamLinkList != null && !exchangeChildFamLinkList.isEmpty()) {

        for (Iterator itChildFam = exchangeChildFamLinkList.iterator(); itChildFam.hasNext();) {
          ExchangeChildFamLink childFamLink = (ExchangeChildFamLink) itChildFam.next();

          ExchangeChildFamilyLinkBean ecfLinkBean = new ExchangeChildFamilyLinkBean();

          ecfLinkBean.setCdNonAvailReason(childFamLink.getCdNonAvailCode());
          ecfLinkBean.setCdNonSelectionReason(childFamLink.getCdNonSelectionRsn());
          ecfLinkBean.setDtOut(childFamLink.getDtOut());
          ecfLinkBean.setIdEventChildRegistration(childFamLink.getEventByIdEventChildRegistration().getIdEvent());
          ecfLinkBean.setIdEventHomeRegistration(childFamLink.getEventByIdEventHomeRegistration().getIdEvent());
          ecfLinkBean.setIdExchangeChildFamilyLink(childFamLink.getIdExchangeChildFamLink().intValue());
          ecfLinkBean.setIndLinkCurrent(childFamLink.getIndLinkCurrent());

          // set resource id
          ExchangeHome home = exchangeHomeDAO
                                             .findExchangeHomeByEventId(childFamLink
                                                                                    .getEventByIdEventHomeRegistration()
                                                                                    .getIdEvent());
          ecfLinkBean.setIdResource(home.getCapsResource().getIdResource());

          // set resource name
          ecfLinkBean.setResourceName(home.getCapsResource().getNmResource());

          exchangeChildFamilyLinkBeanList.add(ecfLinkBean);

        }
        adoptioninfoRetrieveSO.setChildFamilyLinkList(exchangeChildFamilyLinkBeanList);
      }

      // set recruitment status and comments for state recruitment activities.
      if (exchangeChild != null) {
        // MR-083 retrieve recruitment status from exchange child
        adoptioninfoRetrieveSO.setSzCdStateActivelyRecruiting(exchangeChild.getCdStateActivelyRecruiting());
        adoptioninfoRetrieveSO.setSzCdComntsRecActsState(exchangeChild.getTxtRecruitComment());
        adoptioninfoRetrieveSO.setSzCdExchConsidered(exchangeChild.getTxtAvailComments());
      }
      /* get state recruitment activities */
      List<ExcChildAdoInfoCbx> adoptioninformationcbx3List = new ArrayList<ExcChildAdoInfoCbx>();
      adoptioninformationcbx3List = excChildAdoInfoCbxDAO.findExcChildAdoInfoByIdEventByCdInfoCbx(idChildRegEvent,
                                                                                                  CodesTables.CADRACS);

      if (adoptioninformationcbx3List != null && !adoptioninformationcbx3List.isEmpty()) {
        Map<String, List<Date>> savedRecActivitiesDatesState = new HashMap<String, List<Date>>();
        Iterator<ExcChildAdoInfoCbx> it = adoptioninformationcbx3List.iterator();
        while (it.hasNext()) {
          ExcChildAdoInfoCbx excChildAdoInfoCbx = it.next();
          // MR-083 if code key does not exist in map yet then add otherwise retrieve existing
          // date list and add additional date.
          if( !savedRecActivitiesDatesState.containsKey(excChildAdoInfoCbx.getCdAdoInfoCbx())){
            List<Date> dateList = new ArrayList<Date>();
            dateList.add(excChildAdoInfoCbx.getDtPerformed());
            savedRecActivitiesDatesState.put(excChildAdoInfoCbx.getCdAdoInfoCbx(), dateList);
          }else{
            List<Date> dateList = savedRecActivitiesDatesState.get(excChildAdoInfoCbx.getCdAdoInfoCbx());
            dateList.add(excChildAdoInfoCbx.getDtPerformed());
          }
        }
        adoptioninfoRetrieveSO.setSavedRecActivitiesDatesState(savedRecActivitiesDatesState);
      }

      /* end get state recruitment activities */
    }

    /* Retrieve Sibling Group Information */
    SiblingGroupInformationSO siblingGroupInformation = null;
    if (event != null && event.getCdEventStatus().equals("COMP") && !adoptioninformationRetrieveSI.getIsNewUsing()) {
      /* populate sibling Group information from history if the event status is complete */
      // STGAP00013445: added argument - idEvent = adoInfo idEvent
      siblingGroupInformation = populateAdoSiblingGroupHistoryInformation(adoptioninformationRetrieveSI, idEvent);
    } else {
      siblingGroupInformation = populateSiblingGroupInformation(adoptioninformationRetrieveSI);
    }

    adoptioninfoRetrieveSO.setSiblingGroupInformation(siblingGroupInformation);
    
    /* 
     * MR-092
     * Retrieve all principal children under 18 that have an open ADO stage in another case, potential sibling.
     * */
    List<StagePersonLink> splList = stagePersonLinkDAO.findPrincipalChildrenOpenAdoStagePersonLinkInAnotherCaseByPcIdAdoStageByPcIdPerson(idStage, idPrimaryChild);
    Map<Integer,Integer> prnChildrenUnder18WithAnotherAdoCase = new HashMap<Integer,Integer>();
    Map<Integer, String> prnChildrenUnder18WithAnotherAdoCaseNames = new HashMap<Integer, String>();
    
    //MR-092 get saved sibling and add them to the sibling dropdown option
    // In case sibling are no longer one of the principal children, but we still need to display
    // the previously saved sibling names.
    List<SiblingExternalLinkStruct> siblingExtLnkList = new ArrayList<SiblingExternalLinkStruct>();
    
    if(adoptioninfoRetrieveSO != null 
                    && adoptioninfoRetrieveSO.getSiblingGroupInformation() != null){
      
      siblingExtLnkList = adoptioninfoRetrieveSO.getSiblingGroupInformation().getSiblingExternalLinkStructList();

      if(siblingExtLnkList != null && siblingExtLnkList.size() > 0){
        for(int i = 0; i < siblingExtLnkList.size(); i++){
          SiblingExternalLinkStruct siblingExtLnkStruct = siblingExtLnkList.get(i);
          
          int idSibling = siblingExtLnkStruct.getIdPerson();
          Person sibling = getPersistentObject(Person.class, idSibling);
          String siblingFullName = StringHelper.getNonNullString(sibling.getNmPersonFirst())
                                      .concat(" ")
                                      .concat(StringHelper.getNonNullString(sibling.getNmPersonLast()));
          
          prnChildrenUnder18WithAnotherAdoCaseNames.put(idSibling, siblingFullName);
        }
        
        // STGAP00017214: Pre-populate radios if there are currently existing sibling in same group as PC.
        // placement group could change in another PROC Adoption Information event.
        adoptioninfoRetrieveSO.setIndHasSiblingExtCase(ServiceConstants.FND_YES);
        adoptioninfoRetrieveSO.setIndSiblingGrpExtCase(ServiceConstants.FND_YES);
      }
    }
    
    for( Iterator<StagePersonLink> splIter = splList.iterator(); splIter.hasNext();){
    	StagePersonLink siblingSpl = splIter.next();
    	int idSibling = siblingSpl.getPerson().getIdPerson();
        int idAdoStageExtCase = siblingSpl.getStage().getIdStage();
        Person sibling = getPersistentObject(Person.class, idSibling);
    	
        // only want to put sibling in map of dropdown sibling name if not there
    	if( !prnChildrenUnder18WithAnotherAdoCaseNames.containsKey(idSibling)){
          String siblingFullName = StringHelper.getNonNullString(sibling.getNmPersonFirst())
                                      .concat(" ")
                                      .concat(StringHelper.getNonNullString(sibling.getNmPersonLast()));
          
          prnChildrenUnder18WithAnotherAdoCaseNames.put(idSibling, siblingFullName);
    	}
    	
        prnChildrenUnder18WithAnotherAdoCase.put(idSibling, idAdoStageExtCase);
    }
    
    adoptioninfoRetrieveSO.setPrnChildrenUnder18WithAnotherAdoCase(prnChildrenUnder18WithAnotherAdoCase);
    adoptioninfoRetrieveSO.setPrnChildrenUnder18WithAnotherAdoCaseNames(prnChildrenUnder18WithAnotherAdoCaseNames);
    
    return adoptioninfoRetrieveSO;
  }

  private SiblingGroupInformationSO populateSiblingGroupInformation(
                                                                    AdoptionInformationRetrieveSI adoptioninformationRetrieveSI) throws ServiceException {

    int idCase = adoptioninformationRetrieveSI.getUlIdCase();
    int idStage = adoptioninformationRetrieveSI.getUlIdStage();
    int totalAvailableForAdoption = 0;
    int idPrimaryChild = 0;
    
    // MR-092 retrieve primary child info
    List<StagePersonLink> pcSplList = stagePersonLinkDAO.findPrimaryChildrenByIdStage(idStage);
    
    if(pcSplList.size() > 1){
    	// more than one primary child...this should never happen
    	throw new ServiceException(Messages.SSM_TOO_MANY_ROWS_RETURNED);
    }else if (pcSplList.size() == 0){
    	// no Primary child...this should never happen
    	throw new ServiceException(Messages.SSM_NO_ROWS_RETURNED);
    }else{
    	// should always be one primary child
    	idPrimaryChild = pcSplList.get(0).getPerson().getIdPerson();
    }
    
    List<StagePersonLink> splList = stagePersonLinkDAO.findPrincipalChildrenOpenAdoStagePersonLinkInAnotherCaseByPcIdAdoStageByPcIdPerson(idStage, idPrimaryChild);

    SiblingGroupInformationSO siblingGroupInformationSO = null;

    List<Integer> siblingPersonIds = stagePersonLinkDAO.findFccIdPersonByIdCase(idCase);

    if ((siblingPersonIds == null || siblingPersonIds.isEmpty())
                    && (splList == null || splList.isEmpty())) {
      return null; // no ids
    } else {
      siblingGroupInformationSO = new SiblingGroupInformationSO();
    }

    /* will store each child registered with the exchange to track changes in the sibling information */

    Map<Integer, Integer> registeredChildGroupings = new HashMap<Integer, Integer>();

    List<SiblingPlacementGroupSO> siblingPlacementGroups = new ArrayList<SiblingPlacementGroupSO>();
    HashMap<Integer, SiblingPlacementGroupSO> siblingGroupMap = new HashMap<Integer, SiblingPlacementGroupSO>();

    /* Get Sibling placement groups for Case */
    List<SiblingGroup> siblingGroupList = siblingGroupDAO.findSiblingGroupByIdCase(idCase);

    if (siblingGroupList == null || siblingGroupList.isEmpty()) {
      /*
       * create 1 new Sibling group if there are no sibling group records and there is more than 1 fcc stage
       */
      siblingGroupInformationSO.setNumOfNewSiblingGroups(1);

    } else {
      /* create groups for existing SiblingGroups */
      for (Iterator sg = siblingGroupList.iterator(); sg.hasNext();) {
        SiblingGroup siblingGroup = (SiblingGroup) sg.next();

        SiblingPlacementGroupSO siblingPlacementGroupSO = new SiblingPlacementGroupSO();
        siblingPlacementGroupSO.setIdSiblingGroup(siblingGroup.getIdSiblingGroup().intValue());
        int nbrAvail = (siblingGroup.getNbrAvail() != null) ? siblingGroup.getNbrAvail() : 0;
        int nbrInGroup = (siblingGroup.getNbrInGroup() != null) ? siblingGroup.getNbrInGroup() : 0;

        siblingPlacementGroupSO.setNbrAvailable(nbrAvail);
        siblingPlacementGroupSO.setNbrInGroup(nbrInGroup);
        siblingPlacementGroupSO.setIdCase(idCase);

        siblingGroupMap.put(siblingGroup.getIdSiblingGroup(), siblingPlacementGroupSO);

        siblingPlacementGroups.add(siblingPlacementGroupSO);
        // increment total # of children available for adoption
        totalAvailableForAdoption = totalAvailableForAdoption + siblingGroup.getNbrAvail();
      }      
    }

    HashMap<SiblingSO, SiblingPlacementGroupSO> groupings = new HashMap<SiblingSO, SiblingPlacementGroupSO>();

    List<SiblingSO> siblingList = new ArrayList<SiblingSO>();
    List<SiblingExternalLinkStruct> siblingExternalLinkStructList = new ArrayList<SiblingExternalLinkStruct>();

    /*******************************************************************************************************************
     * get Siblings for case, legal status and child name
     * 
     * MR-092 Also to get siblings with ADO in another case
     */
    SiblingGroup pcSiblingGrp = null;

    if (siblingPersonIds != null && !siblingPersonIds.isEmpty()) {

      for (Iterator sbIdsIterator = siblingPersonIds.iterator(); sbIdsIterator.hasNext();) {
        int idPerson = ((Integer) sbIdsIterator.next()).intValue();

        SiblingSO siblingSO = new SiblingSO();

        siblingSO.setIdPerson(idPerson);

        Person person = getPersistentObject(Person.class, idPerson);
        siblingSO.setChildName(person.getNmPersonFull());

        /* add child to list of siblings */
        siblingList.add(siblingSO);
        // need to pull sibling record by id case because sibling could be in more than one case
        Sibling sib = siblingDAO.findSiblingByIdPersonByIdCase(idPerson, idCase);
        
        /* set the sibling groupId if it exists */
        if (sib != null) {
          int idSiblingGroup = sib.getId().getSiblingGroup().getIdSiblingGroup().intValue();
          siblingSO.setIdSiblingGroup(idSiblingGroup);
          
          if(idPerson == idPrimaryChild){
          	pcSiblingGrp = sib.getId().getSiblingGroup();
          }          
        }
        
        if( pcSiblingGrp != null){
            Collection<SiblingExternalLink> siblingExternalLinkList = pcSiblingGrp.getSiblingExternalLinks();
            
            for (Iterator<SiblingExternalLink> selIter = siblingExternalLinkList.iterator(); selIter.hasNext();) {
            	SiblingExternalLink selObj = selIter.next();
            	SiblingExternalLinkStruct selStruct = new SiblingExternalLinkStruct();
            	
            	selStruct.setIdSiblingGroup(selObj.getId().getSiblingGroup().getIdSiblingGroup());
            	selStruct.setIdPerson(selObj.getId().getPerson().getIdPerson());
            	selStruct.setIdSiblingExternalStage(selObj.getStage().getIdStage());
                
                siblingExternalLinkStructList.add(selStruct);
            }
        }
        
        ExchangeChild exchangeChild = exchangeChildDAO.findMostRecentExchangeChildRecordByIdPerson(idPerson);

        boolean exchangeChildNotAvailable = false;
        if (exchangeChild != null) {// child is registered with the exchange
          String cdNonAvailStatus = exchangeChild.getCdNonAvailStatus();
          siblingSO.setNonAvailStatus(cdNonAvailStatus);
          siblingSO.setIdChildRegEvent(exchangeChild.getIdEvent());

          /* add child to registered map */
          registeredChildGroupings
                                  .put(new Integer(siblingSO.getIdPerson()), new Integer(siblingSO.getIdSiblingGroup()));

          /* children available for adoption will have one of the following non avail codes */
          if ((cdNonAvailStatus.equals("00") || cdNonAvailStatus.equals("03") || cdNonAvailStatus.equals("55")) == false) {
            exchangeChildNotAvailable = true;
          }

        }
        /*
         * if there is a sibling group id for this child, store that sibling and placement into the groupings mapping
         */
        if (siblingSO.getIdSiblingGroup() != 0) {
          groupings.put(siblingSO, (SiblingPlacementGroupSO) siblingGroupMap.get(siblingSO.getIdSiblingGroup()));
        }

        boolean hasTPRorVS = populateLegalActionsList(siblingSO, idCase, null);

        if (hasTPRorVS && (exchangeChildNotAvailable == false)) {
          /*
           * Child is available to adopt if the child has had a TPR or VS and the non-availability code of the child
           * does not indicate that the child has been selected
           */
          siblingSO.setIndAvailableToAdopt(true);
        }
      }

    }else if( splList != null && !splList.isEmpty()){
      // MR-092 get sibling group info if external sibling are the only siblings previously saved
      
      Sibling sib = siblingDAO.findSiblingByIdPersonByIdCase(idPrimaryChild, idCase);
      
      /* get the primary child group id if any at this point 
       * and retreive any previously saved sibling external links
       * */
      int idSiblingGroup = 0;
      if (sib != null) {
        idSiblingGroup = sib.getId().getSiblingGroup().getIdSiblingGroup().intValue();
        
        if(idSiblingGroup > 0){
              pcSiblingGrp = sib.getId().getSiblingGroup();
        }          
      }
      
      if( pcSiblingGrp != null){
          Collection<SiblingExternalLink> siblingExternalLinkList = pcSiblingGrp.getSiblingExternalLinks();
          
          for (Iterator<SiblingExternalLink> selIter = siblingExternalLinkList.iterator(); selIter.hasNext();) {
              SiblingExternalLink selObj = selIter.next();
              SiblingExternalLinkStruct selStruct = new SiblingExternalLinkStruct();
              
              selStruct.setIdSiblingGroup(selObj.getId().getSiblingGroup().getIdSiblingGroup());
              selStruct.setIdPerson(selObj.getId().getPerson().getIdPerson());
              selStruct.setIdSiblingExternalStage(selObj.getStage().getIdStage());
              
              siblingExternalLinkStructList.add(selStruct);
          }
      }
      
    }
    
    siblingGroupInformationSO.setGroupings(groupings);
    siblingGroupInformationSO.setRegisteredChildMap(registeredChildGroupings);

    siblingGroupInformationSO.setSiblingRetrieveSOList(siblingList);
    siblingGroupInformationSO.setSiblingExternalLinkStructList(siblingExternalLinkStructList);
    siblingGroupInformationSO.setSiblingPlacementGroups(siblingPlacementGroups);
    siblingGroupInformationSO.setIdCase(idCase);
    siblingGroupInformationSO.setTotalAvailableForAdoption(totalAvailableForAdoption);
    

    return siblingGroupInformationSO;

  }

  private SiblingGroupInformationSO populateAdoSiblingGroupHistoryInformation(
                                                                              AdoptionInformationRetrieveSI adoptioninformationRetrieveSI,
                                                                              int idEvent) {

    SiblingGroupInformationSO siblingGroupInformationSO = new SiblingGroupInformationSO();

    int idCase = adoptioninformationRetrieveSI.getUlIdCase();

    List<AdoSiblingHistory> adoSiblingHistoryList = adoSiblingHistoryDAO.findAdoSiblingHistoryByIdEvent(idEvent);
    List<AdoSiblingExtLnkHistory> adoSiblingExtLnkHistoryList = adoSiblingExtLnkHistoryDAO.findAdoSiblingExtLnkHistoryByIdEvent(idEvent);
    List<SiblingExternalLinkStruct> siblingExternalLinkStructList = new ArrayList<SiblingExternalLinkStruct>();

    HashMap<SiblingSO, SiblingPlacementGroupSO> groupings = new HashMap<SiblingSO, SiblingPlacementGroupSO>();

    List<SiblingSO> siblingList = new ArrayList<SiblingSO>();
    List<SiblingPlacementGroupSO> siblingPlacementGroups = new ArrayList<SiblingPlacementGroupSO>();
    Map<Integer, Integer> registeredChildGroupings = new HashMap<Integer, Integer>();

    Iterator adoSiblingHistoryIterator = adoSiblingHistoryList.iterator();
    Map<Integer, SiblingPlacementGroupSO> placementGroupMap = new HashMap<Integer, SiblingPlacementGroupSO>();
    while (adoSiblingHistoryIterator.hasNext()) {/*
     * update group list, siblingList, and groupings map
     */
      AdoSiblingHistory adoSiblingHistory = (AdoSiblingHistory) adoSiblingHistoryIterator.next();
      int idPerson = adoSiblingHistory.getIdPerson();
      Person person = getPersistentObject(Person.class, idPerson);
      int idSiblingGroup = 0;

      if (adoSiblingHistory.getIdSiblingGroup() != null) {
        idSiblingGroup = adoSiblingHistory.getIdSiblingGroup();
      }

      SiblingSO siblingSO = new SiblingSO();

      siblingSO.setChildName(person.getNmPersonFull());
      siblingSO.setIdPerson(idPerson);
      siblingSO.setIdSiblingGroup(idSiblingGroup);
      siblingSO.setNonAvailStatus(adoSiblingHistory.getCdNonAvailStatus());
      // SMS#37201 # available for adoption value was not calculated correctly for Ado info in COMP
      // status.
      // Set the indicator to true or false depending upon the value in adosiblinghistory table, which will then
      // be retrieved on jsp to calculate the # available to adopt.
      boolean hasTPROrVS = populateLegalActionsList(siblingSO, idCase, adoSiblingHistory.getDtAdoInfoComplete());
      String cdNonAvailStatus = adoSiblingHistory.getCdNonAvailStatus();
      if (hasTPROrVS && cdNonAvailStatus == null) {
        // legal action but no registration
        siblingSO.setIndAvailableToAdopt(true);
      } else if (hasTPROrVS
                 && (CodesTables.CANONAV_00.equals(cdNonAvailStatus) || CodesTables.CANONAV_03.equals(cdNonAvailStatus) || CodesTables.CANONAV_55
                                                                                                                                                 .equals(cdNonAvailStatus))) {
        siblingSO.setIndAvailableToAdopt(true);
      }

      SiblingPlacementGroupSO siblingPlacementGroupSO = null;
      if (idSiblingGroup != 0 && placementGroupMap.get(new Integer(siblingSO.getIdSiblingGroup())) == null) {

        siblingPlacementGroupSO = new SiblingPlacementGroupSO();
        siblingPlacementGroupSO.setIdCase(idCase);
        siblingPlacementGroupSO.setIdSiblingGroup(idSiblingGroup);

        /* create group list */
        siblingPlacementGroups.add(siblingPlacementGroupSO);

        placementGroupMap.put(new Integer(siblingSO.getIdSiblingGroup()), siblingPlacementGroupSO);
      } else {
        siblingPlacementGroupSO = (SiblingPlacementGroupSO) placementGroupMap
                                                                             .get(new Integer(
                                                                                              siblingSO
                                                                                                       .getIdSiblingGroup()));
      }

      ExchangeChild exchangeChild = exchangeChildDAO.findMostRecentExchangeChildRecordByIdPerson(idPerson);

      // STGAP00011726: needed when copying from case List to avoid NPE
      if (exchangeChild != null) {// child is registered with the exchange
        /* add child to registered map */
        registeredChildGroupings.put(new Integer(siblingSO.getIdPerson()), new Integer(siblingSO.getIdSiblingGroup()));
        siblingSO.setIdChildRegEvent(exchangeChild.getIdEvent());
      }

      /* add sibling/group map */
      groupings.put(siblingSO, siblingPlacementGroupSO);

      /* add sibling to sibling list */
      siblingList.add(siblingSO);

    }
    
    if( adoSiblingExtLnkHistoryList != null){
        for (Iterator<AdoSiblingExtLnkHistory> aselhIter = adoSiblingExtLnkHistoryList.iterator(); aselhIter.hasNext();) {
        	AdoSiblingExtLnkHistory aselhObj = aselhIter.next();
        	SiblingExternalLinkStruct selStruct = new SiblingExternalLinkStruct();
        	
        	selStruct.setIdSiblingGroup(aselhObj.getIdSiblingGroup());
        	selStruct.setIdPerson(aselhObj.getPerson().getIdPerson());
        	selStruct.setIdSiblingExternalStage(aselhObj.getStage().getIdStage());
        	
        	siblingExternalLinkStructList.add(selStruct);
        }        	
    }

    siblingGroupInformationSO.setGroupings(groupings);
    siblingGroupInformationSO.setSiblingPlacementGroups(siblingPlacementGroups);
    siblingGroupInformationSO.setRegisteredChildMap(registeredChildGroupings);
    siblingGroupInformationSO.setSiblingRetrieveSOList(siblingList);
    siblingGroupInformationSO.setSiblingExternalLinkStructList(siblingExternalLinkStructList);
    siblingGroupInformationSO.setIdCase(idCase);

    return siblingGroupInformationSO;
  }

  private boolean populateLegalActionsList(SiblingSO siblingSO, int idCase, Date dtEventOccurred) {
    boolean hasTPRorVS = false;

    List<LegalAction> legalActionList = retrieveLegalActionTPRAchieved(idCase, siblingSO.getIdPerson(), dtEventOccurred);

    StringBuffer terminationCodes = new StringBuffer();

    if (legalActionList != null && !legalActionList.isEmpty()) {
      hasTPRorVS = true;
      HashMap<String, String> actionCodesMap = new HashMap<String, String>();

      for (Iterator i = legalActionList.iterator(); i.hasNext();) {
        /*
         * for each distinct termination code add it to a string buffer to be used for the legal action
         */
        LegalAction legalAction = (LegalAction) i.next();// update in order to avoid displaying the wrong code
        String actionCode = (legalAction.getCdHrTypCrtOrd() != null && courtOrderIsTPR(legalAction.getCdHrTypCrtOrd())) ? Lookup
                                                                                                                                .simpleDecodeSafe(
                                                                                                                                                  "CLHECOT",
                                                                                                                                                  legalAction
                                                                                                                                                             .getCdHrTypCrtOrd())
                                                                                                                       : Lookup
                                                                                                                               .simpleDecodeSafe(
                                                                                                                                                 "CLEGCPS",
                                                                                                                                                 legalAction
                                                                                                                                                            .getCdLegalActAction());

        if (actionCodesMap.get(actionCode) == null) {
          terminationCodes.append(actionCode + "; ");
          actionCodesMap.put(actionCode, actionCode);
        }

      }
    }

    siblingSO.setLegalActionsList(terminationCodes.toString());

    return hasTPRorVS;
  }

  private List<LegalAction> retrieveLegalActionTPRAchieved(int idCase, int idPerson, Date dtEventOccurred) {
    List<String> cdLegalActActions = new ArrayList<String>();
    cdLegalActActions.add(CodesTables.CLEGCPS_VLM); // Voluntary Surrender - Biological Mother
    cdLegalActActions.add(CodesTables.CLEGCPS_VAM); // Voluntary Surrender - Adoptive Mother
    cdLegalActActions.add(CodesTables.CLEGCPS_VAF); // Voluntary Surrender - Adoptive Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VSF); // Voluntary Surrender - Legal/Biological Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VLS); // Voluntary Surrender - Legal Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VBF); // Voluntary Surrender - Biological Father
    // SMS #97845: MR-074-2
    cdLegalActActions.add(CodesTables.CLEGCPS_VPF); // Voluntary Surrender - Putative Father

    String[] cdOutcomes = new String[5];
    cdOutcomes[0] = CodesTables.CLEGLOUT_TPC; // Perm Custody to DHR
    cdOutcomes[1] = CodesTables.CLEGLOUT_TPS; // Perm Custody to Specified Relative for Adoption
    cdOutcomes[2] = CodesTables.CLEGLOUT_TPT; // Perm Custody to a 3rd Party
    cdOutcomes[3] = CodesTables.CLEGLOUT_DPC; // Deceased Parents perm custody to dhr
    cdOutcomes[4] = CodesTables.CLEGLOUT_TPG;// TPR granted

    List<String> cdHrTypCrtOrds = new ArrayList<String>();
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPF); // This is end-dated code
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPM);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFL);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFF);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFB);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPA);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFA);
    // SMS #97845: MR-074-2
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPP); // TPR-Putative Father

    List<LegalAction> legalActionsQueriedList = null;

    if (dtEventOccurred == null) {
      legalActionsQueriedList = legalActionDAO
                                              .findLegalActionListByIdStageByIdPersonBycdActionsByCdOutcomes(
                                                                                                             idCase,
                                                                                                             idPerson,
                                                                                                             cdLegalActActions,
                                                                                                             cdOutcomes,
                                                                                                             cdHrTypCrtOrds);
    } else {
      legalActionsQueriedList = legalActionDAO
                                              .findLegalActionListByIdStageByIdPersonBycdActionsByCdOutcomesBeforeDate(
                                                                                                                       idCase,
                                                                                                                       idPerson,
                                                                                                                       cdLegalActActions,
                                                                                                                       cdOutcomes,
                                                                                                                       cdHrTypCrtOrds,
                                                                                                                       dtEventOccurred);
    }

    List<LegalAction> filteredLegalActionList = new ArrayList<LegalAction>();
    if (legalActionsQueriedList != null && !legalActionsQueriedList.isEmpty()) {
      Iterator allIterator = legalActionsQueriedList.iterator();

      while (allIterator.hasNext()) {
        LegalAction la = (LegalAction) allIterator.next();

        if (courtOrderIsTPR(la.getCdHrTypCrtOrd()) && !la.getCdHrTypCrtOrd().equals(CodesTables.CLEGLOUT_DPC)) {
          // ensure that TPR was granted before returning this legal action
          // Get all the legal action outcome records for this event
          List<String> cdOutcomeList = legalActionOutcomeDAO.findCdOutcomeListByIdEvent(la.getIdLegalActEvent());
          if (cdOutcomeList.contains(CodesTables.CLEGLOUT_TPG)) {
            filteredLegalActionList.add(la);
          }
          // SMS #97845: MR-074-2
          // Removed hierarchy of TPR over Voluntary Surrender for displaying the Legal Status field
          // The code didn't display the legal action if it includes both VS and TPR without TPG selected
          // By this code update, the page displays all VS displays without looking at TPR first
          else if (courtActionIsVS(la.getCdLegalActAction())) {
            filteredLegalActionList.add(la);
          }
        }  else {
          filteredLegalActionList.add(la);
        }
      }
    }

    return filteredLegalActionList;
  }

  /* This method is used to find the end date of the adoptive placement by stage.*/

  private Date getDisruptionDate(int idChild) {
    // STGAP00014567- Get the Latest, actual, non-concurrent placement for the child in the ADO stage to populate the
    // Disruption
    // date.
    String cdStage = CodesTables.CSTAGES_ADO;
    Placement placement = placementDAO.findLatestEndedPlcmtByIdChildByStageType(idChild, cdStage);
    // The date disruption is defined as the end date of the child's adoptive placement record that took place before
    // the adoption is finalized.

    // STGAP00015326- changed format of this statement by placing static variable first.
    if (placement != null && (CodesTables.CRMRSNAC_ADF.equals(placement.getCdPlcmtRemovalRsn())) == false) {
      // if removal reason is anything other then adoption finalized
      // return the disruption date
      return placement.getDtPlcmtEnd();
    }
    return null;
  }

  private boolean courtOrderIsTPR(String cdHrTypCrtOrd) {
    if (StringHelper.isValid(cdHrTypCrtOrd)) {

      // SMS #97845: MR-074-2
      // Added TPR-Putative Father (CLHECOT_TPP) to the condition 
      return (cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPF) || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPM)
              || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPA) || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFA)
              || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFL) || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFF)
              || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFB) || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPP));
    }
    return false;
  }

  //SMS #97845: MR-074-2
  private boolean courtActionIsVS(String cdLegalActActions) {
    if (StringHelper.isValid(cdLegalActActions)) {
      return (cdLegalActActions.equals(CodesTables.CLEGCPS_VLM) || cdLegalActActions.equals(CodesTables.CLEGCPS_VAM)
              || cdLegalActActions.equals(CodesTables.CLEGCPS_VAF) || cdLegalActActions.equals(CodesTables.CLEGCPS_VSF)
              || cdLegalActActions.equals(CodesTables.CLEGCPS_VLS) || cdLegalActActions.equals(CodesTables.CLEGCPS_VBF)
              || cdLegalActActions.equals(CodesTables.CLEGCPS_VPF));
    }
    return false;
  }
}
