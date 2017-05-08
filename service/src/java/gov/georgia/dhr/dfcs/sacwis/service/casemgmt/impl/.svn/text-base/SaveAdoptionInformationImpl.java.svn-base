package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoCbxSentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoSiblingExtLnkHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoSiblingHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvPerLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionOutcomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingExternalLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingGroupDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfo;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbx;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbxSent;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoFamily;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSiblingExtLnkHistory;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSiblingHistory;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConv;
import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConvPerLink;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.Sibling;
import gov.georgia.dhr.dfcs.sacwis.db.SiblingExternalLink;
import gov.georgia.dhr.dfcs.sacwis.db.SiblingExternalLinkId;
import gov.georgia.dhr.dfcs.sacwis.db.SiblingGroup;
import gov.georgia.dhr.dfcs.sacwis.db.SiblingId;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveSpecializedUnitPersonnel;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveAdoptionInformation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionInformationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionResourceBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SiblingGroupInformationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SiblingSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoInfoCbxSentStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptionInformationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingExternalLinkStruct;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Description:Service Implementation for Saving Adoption Information.
 * 
 * <pre>
 *            Change History:
 *             Date      User              Description
 *             --------  ----------------  --------------------------------------------------
 * </pre>
 *            
 *             10/7/2008  Ronnie Phelps Added changes for Adoptions Enhancements
 *             01/27/2009 mchillman     STGAP00012222 added nul pointer checks
 *             02/05/2009 arege         STGAP00012356: Modified code so that the MSG_ADO_DT_WO_TERMINATION
 *                                      is not thrown while saving Adoption Info page for 
 *                                      converted cases. 
 *             02/18/2009 bgehlot       STGAP00012413: Error Message MSG_ADO_DT_WO_TERMINATION should be
 *                                      displayed for all Legal statutes but Permanent Court and Permanent Voluntary. 
 *             04/13/2009 mxpatel       STGAP00012857: Eliminated duplicated in the racAndSauList to avoid duplicate alerts.
 *             05/11/2009 mxpatel       STGAP00012669: added code to be able to save AdoInfo with a resource which does not
 *                                      have a FAD stage.
 *             05/25/2009 mchillman     STGAP00012438 MR-50 set FHC Inquiry date to Foster Parent Notified Agency of Decision to Adopt date 
 *             07/21/2009 hjbaptiste    STGAP00014781: Modified saveadoptiondetailplan() to retrieve the Regional Adopton Assistance Consultants,
 *                                      the Regional Adoption Exchange Consultants and the RACs so that the alert can be sent to them without
 *                                      sending them to everyone that has the SAU Staff attribute. Modified saveSiblingGroupInformation() to send
 *                                      alert to only the Regional Adoption Exchange Consultants      
 *             8/21/2009 cwells         STGAP00014796: If a home conversion exists with the child and id_resource combination then the inquiry date 
 *                                      should be updated with the date selected for the Question "Foster parent notified agency of decision to adopt" 
 *            11/12/2009 arege          SMS#37448 Modified retrieveLegalActionTPRAchieved that calculates number available for adoption in a sibling group.                      
 *            11/19/2009 cwells         37378 The date disruption is defined as the end date of the child's adoptive placement record that took place before the
 *                                      adoption is finalized.                                         
 *             03/03/2011 schoi         SMS #97845: MR-074-2 Added logic to include the VS/TPR Putative Father for Legal Status field
 *             03/10/2011 schoi         SMS #97845: MR-074-2 Per code peer review, reworded comment sections in accordance with decode value update
 *                                      from 'Voluntary Surrender - Mother' to 'Voluntary Surrender - Biological Mother'
 *                                      and from 'TPR - Mother' to 'TPR - Biological Mother' in the retrieveLegalActionTPRAchieved method
 *             06/06/2011 hnguyen       SMS#109405: MR-083 No longer saving Regional Families Consider comments as this is a display only 
 *                                      from source Exchange Child Detail page Chid Availability section comments.                         
 *             09/23/11   hnguyen       STGAP00017011: MR-092 Added new logic to save current and history siblings with ado in a different case.
 *             11/01/11   hnguyen       STGAP00017475: MR-092 Reorder logic to update sibling external links only for this stage primary child in the group, 
 *                                      otherwise it would delete the links on next sibling iteration.
 *                                      
 */
public class SaveAdoptionInformationImpl extends BaseServiceImpl implements SaveAdoptionInformation {

  public static final String SUBCARE_STAGE = CodesTables.CSPCUNTS_SUB;

  public static final String HCN_TASK_ID = "9997";

  private static final String FA_CATG_FOST = CodesTables.CFACATEG_F;

  private static final String FA_CATG_ICPC_FOSTER = CodesTables.CFACATEG_I;

  private static final String FA_CATG_REL_FOST = CodesTables.CFACATEG_O;

  private AdoInfoDAO adoInfoDAO = null;

  private AdoInfoCbxDAO adoInfoCbxDAO = null;

  private AdoInfoCbxSentDAO adoInfoCbxSentDAO = null;

  private AdoInfoFamilyDAO adoInfoFamilyDAO = null;
  
  private PostEvent postEvent = null;

  private EventDAO eventDAO = null;
  
  private PlacementDAO placementDAO = null;

  private ComplexTodoDAO complexTodoDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  private SiblingGroupDAO siblingGroupDAO = null;

  private SiblingDAO siblingDAO = null;

  private SiblingExternalLinkDAO siblingExternalLinkDAO = null;

  private AdoSiblingHistoryDAO adoSiblingHistoryDAO = null;
  
  private AdoSiblingExtLnkHistoryDAO adoSiblingExtLnkHistoryDAO = null;

  private ExchangeChildDAO exchangeChildDAO = null;

  private LegalActionDAO legalActionDAO = null;

  private FosterHomeConvDAO fosterHomeConvDAO = null;

  private FosterHomeConvPerLinkDAO fosterHomeConvPerLinkDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private CapsResourceDAO capsResourceDAO = null;

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setComplexTodoDAO(ComplexTodoDAO complexTodoDAO) {
    this.complexTodoDAO = complexTodoDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
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

  public void setSiblingDAO(SiblingDAO siblingDAO) {
    this.siblingDAO = siblingDAO;
  }

  public void setSiblingExternalLinkDAO(SiblingExternalLinkDAO siblingExternalLinkDAO) {
    this.siblingExternalLinkDAO = siblingExternalLinkDAO;
  }

  public void setSiblingGroupDAO(SiblingGroupDAO siblingGroupDAO) {
    this.siblingGroupDAO = siblingGroupDAO;
  }

  public void setAdoSiblingHistoryDAO(AdoSiblingHistoryDAO adoSiblingHistoryDAO) {
    this.adoSiblingHistoryDAO = adoSiblingHistoryDAO;
  }

  public void setAdoSiblingExtLnkHistoryDAO(AdoSiblingExtLnkHistoryDAO adoSiblingExtLnkHistoryDAO) {
    this.adoSiblingExtLnkHistoryDAO = adoSiblingExtLnkHistoryDAO;
  }

  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setFosterHomeConvDAO(FosterHomeConvDAO fosterHomeConvDAO) {
    this.fosterHomeConvDAO = fosterHomeConvDAO;
  }

  public void setFosterHomeConvPerLinkDAO(FosterHomeConvPerLinkDAO fosterHomeConvPerLinkDAO) {
    this.fosterHomeConvPerLinkDAO = fosterHomeConvPerLinkDAO;
  }
  
  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  /**
   * saveAdoptionInformation takes care of posting the event and call the method for saving/updating the information
   * into AdoInfo Table .
   * 
   * @param context
   *                The AdoptionInformationSaveSI object.
   */
  public int saveAdoptionInformation(AdoptionInformationSaveSI adoptioninfoSaveSI) throws ServiceException {

    int idEvent = adoptioninfoSaveSI.getUlIdEvent();
    ROWCCMN01UIG00 adoptioninfoEvent = adoptioninfoSaveSI.getROWCCMN01UIG00();
    String eventReqFuncCd;
    if (idEvent != 0) {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    adoptioninfoSaveSI.setCdReqFuncCd(eventReqFuncCd);

    Stage stage = getPersistentObject(Stage.class, adoptioninfoSaveSI.getUlIdStage());
    if (adoptioninfoEvent.getSzCdEventStatus().equals("COMP")) {
      adoptioninfoEvent.setSzTxtEventDescr("Adoption Information for " + stage.getNmStage() + " is complete");
    } else {
      adoptioninfoEvent.setSzTxtEventDescr("Adoption Information for " + stage.getNmStage());
    }
    if (idEvent == 0) {

      CCMN01UO ccmn01uo = callPostEvent(eventReqFuncCd, adoptioninfoEvent, adoptioninfoSaveSI);
      idEvent = ccmn01uo.getUlIdEvent();
      adoptioninfoSaveSI.setUlIdEvent(idEvent);
    } else {
      eventDAO.updateEventByIdEvent(idEvent, adoptioninfoSaveSI.getROWCCMN01UIG00().getSzCdEventStatus());
    }

    saveadoptiondetailplan(adoptioninfoSaveSI);
    return idEvent;
  }

  /**
   * saveadoptiondetailplan takes care of saving/updating the information into Ado_Info Table .
   * 
   * @param context
   *                The AdoptionInformationSaveSI object.
   */
  private void saveadoptiondetailplan(AdoptionInformationSaveSI adoptioninfoSaveSI) throws ServiceException {

    AdoInfo adoinfo = new AdoInfo();
    int idEvent = adoptioninfoSaveSI.getUlIdEvent();
    int idStage = adoptioninfoSaveSI.getUlIdStage();
    int idCase = adoptioninfoSaveSI.getUlIdCase();
    int idPerson = adoptioninfoSaveSI.getUlIdPerson();
    Event event = getPersistentObject(Event.class, idEvent);
    adoptioninfoSaveSI.setUlIdEvent(idEvent);

    String szCdReasonChildNonAvail = adoptioninfoSaveSI.getSzCdReasonChildNonAvail();
    Date dtFostParNotAgTPR = adoptioninfoSaveSI.getDtFostParNotAgTPR();
    Date dtPermStaffFostPar = adoptioninfoSaveSI.getDtPermStaffFostPar();
    Date dtFostParNotAgDecAdpt = adoptioninfoSaveSI.getDtFostParNotAgDecAdpt();
    Date dtChildLifeHistPres = adoptioninfoSaveSI.getDtChildLifeHistPres();
    Date dtStaffAdptFam = adoptioninfoSaveSI.getDtStaffAdptFam();
    Date dtAdptPlacAgmtSigned = adoptioninfoSaveSI.getDtAdptPlacAgmtSigned();
    Date dtDocSentAttor = adoptioninfoSaveSI.getDtDocSentAttor();
    Date dtPermFileLetterComp = adoptioninfoSaveSI.getDtPermFileLetterComp();
    Date dtLastUpdate = adoptioninfoSaveSI.getDtLastUpdate();
    Date dtDisrupt = adoptioninfoSaveSI.getDtDisrupt();
    String indOutofTown = adoptioninfoSaveSI.getIndOutofTown();
    String indOtherSiblingsAdopted = adoptioninfoSaveSI.getIndOtherSiblingsAdopted();
    int nmFamConsidered = adoptioninfoSaveSI.getNmFamConsidered();
    String szCdReasonsFamNotSel = adoptioninfoSaveSI.getSzCdReasonsFamNotSel();
    String szCdTypeAdptRsrcNeeded = adoptioninfoSaveSI.getSzCdTypeAdptRsrcNeeded();
    String szCdComntsPrepAct = adoptioninfoSaveSI.getSzCdComntsPrepAct();
    String szCdComntsBarRec = adoptioninfoSaveSI.getSzCdComntsBarRec();
    String szCdComntsRecActsCounty = adoptioninfoSaveSI.getSzCdComntsRecActsCounty();
    String szCdComntsBarPla = adoptioninfoSaveSI.getSzCdComntsBarPla();
    String szCdComntsBarTpr = adoptioninfoSaveSI.getSzCdComntsBarTpr();
    String[] checkedPreperationActivities = adoptioninfoSaveSI.getChkPreperationActivities();
    String[] checkedBarriersRecruitment = adoptioninfoSaveSI.getChkBarriersRecruitment();
    String[] checkedBarriersPlacement = adoptioninfoSaveSI.getChkBarriersPlacement();
    String[] checkedBarriersTPR = adoptioninfoSaveSI.getChkBarriersTPR();
    String indIdentifiedAdopRes = adoptioninfoSaveSI.getIndIdentifiedAdopRes();
    int idResource = adoptioninfoSaveSI.getResourceIdForPullback();
    int idResourcePre = adoptioninfoSaveSI.getResourceIdForPullbackPre();
    String szCdCounty = adoptioninfoSaveSI.getSzCdCounty();
    String szCdState = adoptioninfoSaveSI.getSzCdState();
    String txtSzNmPrAgency = adoptioninfoSaveSI.getNMAgency();
    String attrSocialServicesStaff = adoptioninfoSaveSI.getAttrSocialServicesStaff();
    String attrStateOficeConsultant = adoptioninfoSaveSI.getAttrstateOficeConsultant();
    Date dtAdptPlacAgmtSignedPre = adoptioninfoSaveSI.getDtAdptPlacAgmtSignedPre();
    Date dtDocSentAttorPre = adoptioninfoSaveSI.getDtDocSentAttorPre();
    Date dtPermFileLetterCompPre = adoptioninfoSaveSI.getDtPermFileLetterCompPre();
    int idChildRegEvent = adoptioninfoSaveSI.getIdChildRegistrationEvent();

    String szCdChildLinked = adoptioninfoSaveSI.getSzCdChildLinked();
    String szCdCountyConsidered = adoptioninfoSaveSI.getSzCdCountyConsidered();
    Date dtLetterSent = adoptioninfoSaveSI.getDtLetterSent();
    // MR-083 no longer saving this field, as it is a display only from exchange child detail
//    String szCdExchConsidered = adoptioninfoSaveSI.getSzCdExchConsidered();
    String indAdoptOutcome = adoptioninfoSaveSI.getIndAdoptOutcome();
    String indAdoptOutcomePre = adoptioninfoSaveSI.getIndAdoptOutcomePre();
    
    // MR-092 sibling group related questions
    String indHasSiblingExtCase = adoptioninfoSaveSI.getIndHasSiblingExtCase();
    String indSiblingGrpExtCase = adoptioninfoSaveSI.getIndSiblingGrpExtCase();

    boolean isUniqueResult = true;
    List<AdoptionResourceBean> resBeanList = new ArrayList<AdoptionResourceBean>();
    if (adoptioninfoSaveSI.getIdenResList().size() != 0) {
      resBeanList = adoptioninfoSaveSI.getIdenResList();
    }
    adoinfo.setEvent(event);
    adoinfo.setIdEvent(idEvent);
    adoinfo.setDtLastUpdate(dtLastUpdate);
    adoinfo.setCdChldAvail(szCdReasonChildNonAvail);
    adoinfo.setDtPermStaff(dtPermStaffFostPar);
    adoinfo.setDtLifeHisPres(dtChildLifeHistPres);
    adoinfo.setDtPermFile(dtPermFileLetterComp);
    adoinfo.setDtDocSent(dtDocSentAttor);
    adoinfo.setDtIntTpr(dtFostParNotAgTPR);
    adoinfo.setDtAdoStaff(dtStaffAdptFam);
    adoinfo.setDtDecAdopt(dtFostParNotAgDecAdpt);
    adoinfo.setDtAdoAgree(dtAdptPlacAgmtSigned);
    adoinfo.setIndInqry(indOutofTown);
    adoinfo.setTxtTypAdo(szCdTypeAdptRsrcNeeded);
    adoinfo.setTxtNotSel(szCdReasonsFamNotSel);
    adoinfo.setNbrFamCons(nmFamConsidered);
    adoinfo.setIndOthSib(indOtherSiblingsAdopted);
    adoinfo.setTxtPrepCmnts(szCdComntsPrepAct);
    adoinfo.setTxtRecrBarr(szCdComntsBarRec);
    adoinfo.setTxtCntyAct(szCdComntsRecActsCounty);
    adoinfo.setTxtPlcmntBarr(szCdComntsBarPla);
    adoinfo.setTxtTprBarr(szCdComntsBarTpr);
    adoinfo.setIndIdenAdo(indIdentifiedAdopRes);
    adoinfo.setIndFpAdo(indAdoptOutcome);
    adoinfo.setDtLetterSent(dtLetterSent);
    // MR-083 no longer saving this field, as it is a display only from exchange child detail
//    adoinfo.setTxtConsComments(szCdExchConsidered);
    adoinfo.setTxtCountyConsComment(szCdCountyConsidered);
    adoinfo.setTxtChildLinked(szCdChildLinked);
    // MR-092 Sibling group related question
    adoinfo.setIndHasSiblingExtCase(indHasSiblingExtCase);
    adoinfo.setIndSiblingGrpExtCase(indSiblingGrpExtCase);

    // set child registration event
    if (idChildRegEvent != 0) {
      Event childRegEvent = getPersistentObject(Event.class, idChildRegEvent);
      adoinfo.setEventByIdEventChildRegistration(childRegEvent);
    }

    // Alert for dtPermFileLetterComp
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);

    Integer idPrimaryChild = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, "PC");

    // Alert for dtAdptPlacAgmtSigned to be sent to RACs, Regional Adoption Assistance Consultants
    // and Regional Adoption Exchange Consultants
    if (dtAdptPlacAgmtSignedPre == null && dtAdptPlacAgmtSigned != null) {
      // Get the most recent approved Child Life History Check List event
      Event cckEvent = eventDAO.findEventByStageTypeAndStatus(idStage, CodesTables.CEVNTTYP_CCK,
                                                              CodesTables.CEVTSTAT_APRV);

      LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPrimaryChild);

      // check to see if an approved child life history exists and
      // if DFCS has permanent custody of the child
      if ((cckEvent == null || (legalStatus == null || isInDFCSCustodyType(legalStatus.getCdLegalStatStatus()) == false))) {
        // STGAP00012356: Find Most Recent ExchangeChildRecord for Primary Child and then check if it has an entry in
        // dt approved column and throw the error message if dt approved is null.
        ExchangeChild exchangeChild = exchangeChildDAO.findMostRecentExchangeChildRecordByIdPerson(idPrimaryChild);
        Date dtApproved = null;
        if (exchangeChild != null) {
          dtApproved = exchangeChild.getDtApproved();
        }
        if (dtApproved == null
            || (legalStatus == null || isInDFCSCustodyType(legalStatus.getCdLegalStatStatus()) == false)) {
          throw new ServiceException(Messages.MSG_ADO_DT_WO_TERMINATION);
        }
      }

      String cdCounty = capsCase.getCdCaseCounty();
      if (cdCounty != null) {
        if (cdCounty.length() == 1) {
          cdCounty = "00" + cdCounty;
        } else if (cdCounty.length() == 2) {
          cdCounty = "0" + cdCounty;
        }
      }
      // Get the region of the county
      String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
      List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
      List<Integer> adoAssistanceList = unitEmpLinkDAO.findSAUAdoptionSpecSupRegionalMembersByIdRegion(cdRegion);
      List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
      List<Integer> racAndAuthorizedSauList = new ArrayList<Integer>();
      if (listIsValid(racList)) {
        racAndAuthorizedSauList.addAll(racList);
      }
      if (listIsValid(adoAssistanceList)) {
        racAndAuthorizedSauList.addAll(adoAssistanceList);
      }
      if (listIsValid(adoExchangeList)) {
        racAndAuthorizedSauList.addAll(adoExchangeList);
      }

      if (listIsValid(racAndAuthorizedSauList)) {
        Iterator<Integer> itrRacAndAuthorizedSauList = racAndAuthorizedSauList.iterator();
        List<Todo> todoList3 = new ArrayList<Todo>();
        while (itrRacAndAuthorizedSauList.hasNext()) {
          int idAssigned = (Integer) itrRacAndAuthorizedSauList.next();
          Todo todo3 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          todo3.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo3.setTxtTodoDesc("Adoption placement agreement has been signed");
          todo3.setCdTodoTask(cdTask);
          todo3.setCdTodoType(CodesTables.CTODOTYP_A);
          todo3.setDtTodoDue(dateCreated);
          todo3.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idPerson));
          todo3.setDtTodoCreated(dateCreated);
          todo3.setCapsCase(capsCase);
          todo3.setStage(getPersistentObject(Stage.class, idStage));
          todoList3.add(todo3);
        }
        complexTodoDAO.saveTodo(todoList3);
      }
    }

    CapsResource capsResource = null;
    int idResourceManager = 0;
    int idResourceStage = 0;
    if (idResource != 0) {
      capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
      // mxpatel sibling
      if (capsResource != null) {
        if (capsResource.getStage() != null) {
          idResourceStage = capsResource.getStage().getIdStage();

          StagePersonLink rmSpl = stagePersonLinkDAO
                                                    .findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(
                                                                                                           idResourceStage,
                                                                                                           CodesTables.CROLEALL_PR,
                                                                                                           CodesTables.CPRSNALL_STF);
          if (rmSpl != null) {
            idResourceManager = rmSpl.getPerson().getIdPerson();
          }
        }
      }
    }

    boolean childHasAnIdentifiedResource = idResource != 0;

    boolean yesOutcome = (indAdoptOutcome != null && indAdoptOutcome.equals("Y"));

    boolean yesOutcomeJustSelected = yesOutcome && ((indAdoptOutcomePre == null || !indAdoptOutcomePre.equals("Y")));

    boolean newIdentifiedResource = (childHasAnIdentifiedResource && (idResource != idResourcePre));

    /*
     * If the user enters a date in the field 'foster parent notifies agency of intent to adopt' and the decision
     * outcome is 'Yes' create alert to notify case worker that foster home conversion needs to be completed. Also
     * create the Foster home conversion event.
     */
    // mxpatel sibling
    if (capsResource != null) {
      if (capsResource.getStage() != null) {
        if (childHasAnIdentifiedResource && yesOutcomeJustSelected) {
          Person caseWorker = getPersistentObject(Person.class, idResourceManager);

          Todo todo2 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          todo2.setPersonByIdTodoPersAssigned(caseWorker);
          todo2.setTxtTodoDesc("Foster Home Conversion Needs to be completed");
          todo2.setCdTodoTask(cdTask);
          todo2.setCdTodoType(CodesTables.CTODOTYP_A);
          todo2.setDtTodoDue(dateCreated);
          todo2.setPersonByIdTodoPersWorker(caseWorker);
          todo2.setDtTodoCreated(dateCreated);
          todo2.setCapsCase(capsCase);
          todo2.setStage(getPersistentObject(Stage.class, idResourceStage));
          complexTodoDAO.insertTodo(todo2);

        }
      }
    }
    // STGAP00014796 If a home conversion exists with the child and id_resource combination then the inquiry date
    // should be updated with the date selected for the Question Foster parent notified agency of decision to adopt.
    // If the date does not exisit then do nothing. If there is no Home Conversion entry then add the initial entry now.
    if ((newIdentifiedResource && yesOutcome) || (childHasAnIdentifiedResource && yesOutcomeJustSelected)) {
      /* create the foster home conversion event if home has a foster home as an identifed resource */
      if (capsResource != null
          && (FA_CATG_FOST.equals(capsResource.getCdRsrcCategory())
              || FA_CATG_ICPC_FOSTER.equals(capsResource.getCdRsrcCategory()) || FA_CATG_REL_FOST
                                                                                                 .equals(capsResource
                                                                                                                     .getCdRsrcCategory()))) {

        // Foster home conversion event should be saved with the identified resource's stage

        Date todaysDate = null;
        try {
          SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
          String todaysDateFormatted = sdf.format(new Date());
          todaysDate = sdf.parse(todaysDateFormatted);
        } catch (ParseException p) {
          p.printStackTrace();
        }
        Integer fcEventId = fosterHomeConvDAO.findFosterHomeConvByIdPersonIdResource(idResource,
                                                                                     idPrimaryChild.intValue());

        if (fcEventId == null) {
          /* create foster home conversion event */
          ROWCCMN01UIG00 adoptioninfoEvent = new ROWCCMN01UIG00();
          adoptioninfoEvent.setSzCdEventStatus("NEW");
          adoptioninfoEvent.setSzCdEventType("HCN");
          adoptioninfoEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
          adoptioninfoEvent.setUlIdStage(idResourceStage);
          adoptioninfoEvent.setUlIdPerson(adoptioninfoSaveSI.getUlIdPerson());
          adoptioninfoEvent.setSzTxtEventDescr("Home Conversion");
          adoptioninfoEvent.setSzCdTask(HCN_TASK_ID);
          adoptioninfoEvent.setUlIdEvent(idEvent);
          adoptioninfoEvent.setTsLastUpdate(new Date());
          adoptioninfoSaveSI.setRowCCMN01UIG00(adoptioninfoEvent);
          CCMN01UI ccmn01ui = new CCMN01UI();
          ArchInputStruct archInputStruct = new ArchInputStruct();
          archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
          ccmn01ui.setArchInputStruct(archInputStruct);
          ccmn01ui.setROWCCMN01UIG00(adoptioninfoEvent);
          CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);

          int fhcIdEvent = ccmn01uo.getUlIdEvent();
          Event fhcEvent = getPersistentObject(Event.class, fhcIdEvent);
          // create foster home conversion record and personLink
          FosterHomeConv fosterHomeConv = new FosterHomeConv();
          fosterHomeConv.setCapsResourceByIdResource(capsResource);
          fosterHomeConv.setCdConvAppStatus(CodesTables.CFHCSTTS_INQ);
          fosterHomeConv.setEvent(fhcEvent);
          fosterHomeConv.setDtInquiry(dtFostParNotAgDecAdpt);
          fosterHomeConvDAO.saveFosterHomeConvDetails(fosterHomeConv);

          FosterHomeConvPerLink fosterHomeConvPerLink = new FosterHomeConvPerLink();
          fosterHomeConvPerLink.setIdPerson(idPrimaryChild);
          fosterHomeConvPerLink.setFosterHomeConv(fosterHomeConv);
          fosterHomeConvPerLinkDAO.saveFosterHomeConvPerLink(fosterHomeConvPerLink);
        } else if (dtFostParNotAgDecAdpt != null) {
          fosterHomeConvDAO.updateFosterHomeConvDtInquiry(dtFostParNotAgDecAdpt, fcEventId);
        }
      }

    }

    if (capsResource != null) {
      adoinfo.setCapsResource(capsResource);
      adoinfo.setCdRsrcCnty(szCdCounty);
      adoinfo.setCdState(szCdState);
      adoinfo.setNmPrivAgency(txtSzNmPrAgency);
    }
    // 37378 When the event status is complete then we are saving the date here to keep
    // a record of the disruption date. Now when it is displayed we will get the date from the DB.
    if (event != null && "COMP".equals(event.getCdEventStatus())) {
      adoinfo.setDtDisrupt(getDisruptionDate(idPrimaryChild));
    }

    String FuncID = adoptioninfoSaveSI.getCdReqFuncCd();
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(adoptioninfoSaveSI.getCdReqFuncCd())) {
      adoInfoDAO.saveAdoInfoDetail(adoinfo);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(adoptioninfoSaveSI.getCdReqFuncCd())) {
      adoInfoDAO.saveAdoInfoDetail(adoinfo);
    }

    saveadoinfochecks(adoinfo, checkedPreperationActivities, idEvent, checkedBarriersRecruitment,
                      checkedBarriersPlacement, checkedBarriersTPR,
                      FuncID);
    
    saveRecruitmentActivities(adoptioninfoSaveSI);
    
    saveadoinforesource(adoinfo, idEvent, resBeanList, FuncID);

    if (adoptioninfoSaveSI.getSiblingGroupInformationSI() != null) {
      saveSiblingGroupInformation(adoptioninfoSaveSI);
    }
  }

  private boolean listIsValid(Collection aList) {
    return (aList != null && !aList.isEmpty());
  }

  /**
   * callPostEvent takes care of posting the event.
   * 
   * @param context
   *                The ROWCCMN01UIG00 object. String cReqFuncCd Add/Update.
   */

  private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00,
                                 AdoptionInformationSaveSI adoptionInformationSaveSI) throws ServiceException {
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();

    Integer idPerson = stagePersonLinkDAO
                                         .findIdPersonByIdStageAndCdStagePersRole(
                                                                                  adoptionInformationSaveSI
                                                                                                           .getUlIdStage(),
                                                                                  "PC");

    String actionCode = ServiceConstants.REQ_FUNC_CD_ADD;

    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 rowccmn01uig01;
    rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
    rowccmn01uig01.setUlIdPerson(idPerson);
    rowccmn01uig01.setSzCdScrDataAction(actionCode);
    rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);

    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }

  private Date getDisruptionDate(int idChild) {
    String cdStage = CodesTables.CSTAGES_ADO;
    Placement placement = placementDAO.findLatestEndedPlcmtByIdChildByStageType(idChild, cdStage);
    // 37378 The date disruption is defined as the end date of the child's adoptive placement record that took place
    // before the
    // adoption is finalized.

    if (placement != null && (CodesTables.CRMRSNAC_ADF.equals(placement.getCdPlcmtRemovalRsn())) == false) {
      // if removal reason is anything other then adoption finalized
      // return the disruption date
      return placement.getDtPlcmtEnd();
    }
    return null;
  }

  /**
   * saveadoinfochecks saves the checkboxes selected in Adoption Information Page to ADO_INFO_CBX Table.
   * 
   */

  private void saveadoinfochecks(AdoInfo adoinfo, String[] checkedPreperationActivities, int IdEvent,
                                 String[] checkedBarriersRecruitment,
                                 String[] checkedBarriersPlacement, 
                                 String[] checkedBarriersTPR, String FuncID) throws ServiceException {

    List<String> prepactsList = new ArrayList<String>();
    List<String> barrecList = new ArrayList<String>();
    List<String> barplacList = new ArrayList<String>();
    List<String> bartprList = new ArrayList<String>();

    // add each element of the array to the list
    prepactsList.addAll(Arrays.asList(checkedPreperationActivities));
    barrecList.addAll(Arrays.asList(checkedBarriersRecruitment));
    barplacList.addAll(Arrays.asList(checkedBarriersPlacement));
    bartprList.addAll(Arrays.asList(checkedBarriersTPR));

    Iterator itPrepActs = prepactsList.iterator();
    Iterator itBarRec = barrecList.iterator();
    Iterator itBarPl = barplacList.iterator();
    Iterator itBarTpr = bartprList.iterator();

    String cbx_prep_code = "CADCPAC";
    String cbx_barrec_code = "CADBREC";
    String cbx_barpl_code = "CADBPLA";
    String cbx_bartpr_code = "CADBTPR";

    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(FuncID)) {
      /* Delete all AdoInfoCbx records */
      adoInfoCbxDAO.deleteAdoInfoByIdEvent(IdEvent, cbx_prep_code);
      adoInfoCbxDAO.deleteAdoInfoByIdEvent(IdEvent, cbx_barrec_code);
      adoInfoCbxDAO.deleteAdoInfoByIdEvent(IdEvent, cbx_barpl_code);
      adoInfoCbxDAO.deleteAdoInfoByIdEvent(IdEvent, cbx_bartpr_code);
      // MR-083 DO NOT DELETE CADRACC records,
      // these records have different insert/update/delete logic 
    }

    while (itPrepActs.hasNext()) {
      AdoInfoCbx adoinfocbx_prepacts = new AdoInfoCbx();
      adoinfocbx_prepacts.setAdoInfo(adoinfo);
      adoinfocbx_prepacts.setCdAdoInfoCbx(itPrepActs.next().toString());
      adoinfocbx_prepacts.setCdCbxCodeType(cbx_prep_code);

      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(FuncID)) {

        adoInfoCbxDAO.saveAdoInfoCheckBox(adoinfocbx_prepacts);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(FuncID)) {
        adoInfoCbxDAO.saveAdoInfoCheckBox(adoinfocbx_prepacts);
      }
    }

    while (itBarRec.hasNext()) {
      AdoInfoCbx adoinfocbx_barrec = new AdoInfoCbx();

      adoinfocbx_barrec.setAdoInfo(adoinfo);
      adoinfocbx_barrec.setCdAdoInfoCbx(itBarRec.next().toString());
      adoinfocbx_barrec.setCdCbxCodeType(cbx_barrec_code);
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(FuncID)) {
        adoInfoCbxDAO.saveAdoInfoCheckBox(adoinfocbx_barrec);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(FuncID)) {
        adoInfoCbxDAO.saveAdoInfoCheckBox(adoinfocbx_barrec);
      }
    }

    while (itBarPl.hasNext()) {

      AdoInfoCbx adoinfocbx_barpl = new AdoInfoCbx();
      adoinfocbx_barpl.setAdoInfo(adoinfo);
      adoinfocbx_barpl.setCdAdoInfoCbx(itBarPl.next().toString());
      adoinfocbx_barpl.setCdCbxCodeType(cbx_barpl_code);
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(FuncID)) {
        adoInfoCbxDAO.saveAdoInfoCheckBox(adoinfocbx_barpl);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(FuncID)) {
        adoInfoCbxDAO.saveAdoInfoCheckBox(adoinfocbx_barpl);
      }
    }
    while (itBarTpr.hasNext()) {

      AdoInfoCbx adoinfocbx_bartpr = new AdoInfoCbx();
      adoinfocbx_bartpr.setAdoInfo(adoinfo);
      adoinfocbx_bartpr.setCdAdoInfoCbx(itBarTpr.next().toString());
      adoinfocbx_bartpr.setCdCbxCodeType(cbx_bartpr_code);
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(FuncID)) {
        adoInfoCbxDAO.saveAdoInfoCheckBox(adoinfocbx_bartpr);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(FuncID)) {
        adoInfoCbxDAO.saveAdoInfoCheckBox(adoinfocbx_bartpr);
      }
    }
  }

  /**
   * saveadoinforesource saves the resource List selected in Adoption Information Page to ADO_INFO_FAMILY Table.
   * 
   */

  private void saveadoinforesource(AdoInfo adoinfo, int IdEvent, List<AdoptionResourceBean> resBeanList, String FuncID)
                                                                                                                       throws ServiceException {

    int size = resBeanList.size();
    adoInfoFamilyDAO.deleteAdoResourceListByIdEvent(IdEvent);
    if (size != 0) {
      for (Iterator it = resBeanList.iterator(); it.hasNext();) {
        AdoptionResourceBean resBean = (AdoptionResourceBean) it.next();
        AdoInfoFamily adofamily = new AdoInfoFamily();
        int idResource = resBean.getIdResource();
        CapsResource capsResource = (CapsResource) getPersistentObject(CapsResource.class, idResource);
        adofamily.setAdoInfo(adoinfo);
        adofamily.setCapsResource(capsResource);
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(FuncID)) {
          adoInfoFamilyDAO.saveAdoFamilyInfo(adofamily);
        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(FuncID)) {
          adoInfoFamilyDAO.saveAdoFamilyInfo(adofamily);
        }
      }
    }
  }

  private Person retrieveUnitSupervisorByCaseManagerId(int idPerson) {
    Map resultMap = unitEmpLinkDAO.findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(idPerson);
    Integer idSupervisor = null;
    boolean throwError = false;
    if (resultMap != null && resultMap.size() > 0) {
      idSupervisor = (Integer) resultMap.get("idPerson");
      if (idSupervisor == null) {
        throwError = true;
      }
    } else {
      throwError = true;
    }

    if (throwError) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return getPersistentObject(Person.class, idSupervisor);
  }

  private void saveSiblingGroupInformation(AdoptionInformationSaveSI adoptionInformationSaveSI) {
    SiblingGroupInformationSI siblingGroupInformationSI = adoptionInformationSaveSI.getSiblingGroupInformationSI();

    List<SiblingGroup> newPlacementGroups = new ArrayList<SiblingGroup>();
    List<SiblingGroup> allPlacementGroups = new ArrayList<SiblingGroup>();

    int idCase = adoptionInformationSaveSI.getUlIdCase();
    int idStage = adoptionInformationSaveSI.getUlIdStage();
    int idEvent = adoptionInformationSaveSI.getUlIdEvent();
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    
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
    
    List<Integer> existingPlacementGroups = siblingGroupDAO.findSiblingGroupIdsByIdCase(idCase);

    List<SiblingSI> existingSiblingsToCreate = siblingGroupInformationSI.getSiblingsToSaveInExistingGroups();

    Map<Integer, Integer> registeredChildGroupings = siblingGroupInformationSI.getInitialRegisteredChildMap();

    if (listIsValid(existingPlacementGroups)) {// handle existing sibling records
      /* delete all sibling records for case before inserting new siblings */
      siblingDAO.deleteSiblingsByIdSiblingGroupsList(existingPlacementGroups);

      Iterator exIterator = existingSiblingsToCreate.iterator();
      while (exIterator.hasNext()) {
        SiblingSI siblingSI = (SiblingSI) exIterator.next();

        Sibling sibling = new Sibling();
        sibling.setId(new SiblingId());
        sibling.getId().setPerson(getPersistentObject(Person.class, siblingSI.getIdPerson()));
        sibling.getId().setSiblingGroup(getPersistentObject(SiblingGroup.class, siblingSI.getIdSiblingGroup()));
        siblingDAO.saveSibling(sibling);

        /* lookup exchangeChild id and update non-avail code */
        ExchangeChild exchangeChild = exchangeChildDAO
                                                      .findMostRecentExchangeChildRecordByIdPerson(siblingSI
                                                                                                            .getIdPerson());

        if (exchangeChild != null) {
          siblingSI.setNonAvailStatus(exchangeChild.getCdNonAvailStatus());
        }
      }
    }

    /* insert new sibling placement groups */
    int numOfNewSiblingGroups = siblingGroupInformationSI.getNumOfNewSiblingGroupsToSave();
    List<SiblingSI> newSiblingsList = siblingGroupInformationSI.getSiblingsToSaveInNewGroups();
    /*
     * these primary keys will be used to update the children mapped to these groups. The Order of the list must be
     * maintained in order to map sibling to the correct group.
     */
    List<Integer> newSiblingGroupPrimaryKeys = new ArrayList<Integer>();
    /* Map contains the sibling struct and the index of the associated sibling group */
    Map<SiblingSI, Integer> siblingsMappedToNewGroups = siblingGroupInformationSI.getSiblingsMappedToNewGroups();

    if (numOfNewSiblingGroups > 0) {
      /* save new sibling groups to be referenced later by the index */
      for (int i = 0; i < numOfNewSiblingGroups; ++i) {

        if (siblingsMappedToNewGroups.containsValue(new Integer(i)) == false) {
          /*
           * Since this sibling group has not been included in siblingsMappedToNewGroups we will add a Dummy Sibling
           * group that will not be saved. This sibling group is used to maintain the index of the new groups that are
           * checked
           */
          SiblingGroup dummyDoNotSaveSiblingGroup = new SiblingGroup();
          allPlacementGroups.add(dummyDoNotSaveSiblingGroup);
          newSiblingGroupPrimaryKeys.add(dummyDoNotSaveSiblingGroup.getIdSiblingGroup());
        } else {// groups that are mapped and will be saved
          SiblingGroup siblingGroup = new SiblingGroup();

          siblingGroup.setCapsCase(capsCase);
          siblingGroup.setNbrAvail(0);
          siblingGroup.setNbrInGroup(0);

          siblingGroupDAO.saveSiblingGroup(siblingGroup);
          allPlacementGroups.add(siblingGroup);
          newSiblingGroupPrimaryKeys.add(siblingGroup.getIdSiblingGroup());
        }

      }

      /*
       * create new sibling records based on groupings(the groupings contain the index of the groups saved)
       */
      if (listIsValid(newSiblingsList)) {
        Iterator newSiblingIterator = newSiblingsList.iterator();

        while (newSiblingIterator.hasNext()) {
          SiblingSI siblingAssignedToNewGroupSI = (SiblingSI) newSiblingIterator.next();

          int idPerson = siblingAssignedToNewGroupSI.getIdPerson();
          Integer indexOfNewGroupInteger = (Integer) siblingsMappedToNewGroups.get(siblingAssignedToNewGroupSI);

          Integer newIdSiblingGroupForeignKey = newSiblingGroupPrimaryKeys.get(indexOfNewGroupInteger.intValue());
          siblingAssignedToNewGroupSI.setIdSiblingGroup(newIdSiblingGroupForeignKey.intValue());

          /* create new sibling */
          Sibling newSibling = new Sibling();
          newSibling.setId(new SiblingId());
          newSibling.getId().setPerson(getPersistentObject(Person.class, idPerson));
          newSibling.getId().setSiblingGroup(getPersistentObject(SiblingGroup.class, siblingAssignedToNewGroupSI.getIdSiblingGroup()));

          siblingDAO.saveSibling(newSibling);
          /* lookup exchangeChild id and update non-avail code */
          ExchangeChild exchangeChild = exchangeChildDAO
                                                        .findMostRecentExchangeChildRecordByIdPerson(siblingAssignedToNewGroupSI
                                                                                                                                .getIdPerson());

          if (exchangeChild != null) {
            siblingAssignedToNewGroupSI.setNonAvailStatus(exchangeChild.getCdNonAvailStatus());
          }
        }
      }
    }
    /* create list of all sibling/group match which contains new and existing siblings */
    List<SiblingSI> allSiblings = new ArrayList<SiblingSI>();
    if (listIsValid(existingSiblingsToCreate)) {
      allSiblings.addAll(existingSiblingsToCreate);
    }
    if (listIsValid(newSiblingsList)) {
      allSiblings.addAll(newSiblingsList);
    }

    /* create list of all placementgroup ids which contains new and existing siblings */
    List<SiblingGroup> existingSiblingGroups = siblingGroupDAO.findSiblingGroupByIdCase(idCase);

    if (listIsValid(existingSiblingGroups)) {
      allPlacementGroups.addAll(existingSiblingGroups);
    }

    /* Get a list of Regional Adoption Exchange Consultants Only */
    String cdCounty = capsCase.getCdCaseCounty();
    if (cdCounty != null) {
      if (cdCounty.length() == 1) {
        cdCounty = "00" + cdCounty;
      } else if (cdCounty.length() == 2) {
        cdCounty = "0" + cdCounty;
      }
    }
    // Get the region of the county
    String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    List<Integer> adoExchangeConsultants = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);

    boolean registeredChildsGroupHasChanged = false;

    Iterator allSibsIterator = allSiblings.iterator();

    /*
     * The code block below will check to see if a registered sibling's group information has changed and send an alert
     * to the state adoptions unit if it has changed
     */
    while (allSibsIterator.hasNext()) {
      SiblingSI siblingSI = (SiblingSI) allSibsIterator.next();
      Integer idPersonToLookup = new Integer(siblingSI.getIdPerson());
      Integer idSiblingGroupInteger = new Integer(siblingSI.getIdSiblingGroup());

      if (registeredChildGroupings.containsKey(idPersonToLookup)) {
        if (registeredChildGroupings.get(idPersonToLookup).equals(idSiblingGroupInteger) == false) {
          // registered child's sibling group has been changed
          registeredChildsGroupHasChanged = true;
        }
      }

      // create alert to notify SAU that the Sibling Group Information has been updated
      if (registeredChildsGroupHasChanged) {
        String nmPersonFull = getPersistentObject(Person.class, idPersonToLookup).getNmPersonFull();
        /*
         * look through sibling list to see if we have any changes to children that were registered with the exchange
         */
        if (listIsValid(adoExchangeConsultants)) {
          Iterator<Integer> itrSauList2 = adoExchangeConsultants.iterator();
          List<Todo> todoList2 = new ArrayList<Todo>();
          while (itrSauList2.hasNext()) {
            int idAssigned = (Integer) itrSauList2.next();
            Todo todo2 = new Todo();
            String cdTask = "";
            Date dateCreated = new Date();
            todo2.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
            String todoDesc = nmPersonFull + "'s Sibling Group Information has been updated";
            todoDesc = StringHelper.truncate(todoDesc, 80);
            String todoLongDesc = nmPersonFull + "'s Sibling Group Information has been updated";
            todo2.setTxtTodoDesc(todoDesc);
            todo2.setTxtTodoLongDesc(todoLongDesc);
            todo2.setCdTodoTask(cdTask);
            todo2.setCdTodoType(CodesTables.CTODOTYP_A);
            todo2.setDtTodoDue(dateCreated);
            todo2.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, siblingSI.getIdPerson()));
            todo2.setDtTodoCreated(dateCreated);
            todo2.setCapsCase(capsCase);
            todo2.setStage(getPersistentObject(Stage.class, adoptionInformationSaveSI.getUlIdStage()));
            todoList2.add(todo2);
          }
          complexTodoDAO.saveTodo(todoList2);
        }
      }
      
      // MR-092 Look for primary child sibling group then add the sibling with open ADO in another case link
      if(idPersonToLookup == idPrimaryChild){
        // STGAP00017475: MR-092 Update only for this stage specific primary child in the group
        // Delete existing sibling_external_link for primary child sibling group and recreate with
        // new links
        siblingExternalLinkDAO.deleteAllSiblingExternalLinkByIdSiblingGroup(idSiblingGroupInteger);
        
        List<SiblingExternalLinkStruct> siblingExtLinkStructList = siblingGroupInformationSI.getSiblingExternalLinkStructList();
        Iterator<SiblingExternalLinkStruct> lstIter = siblingExtLinkStructList.iterator();
        
        while(lstIter.hasNext()){
          SiblingExternalLinkStruct struct = lstIter.next();
          SiblingExternalLink sel = new SiblingExternalLink();
          
          // populate composite id
          sel.setId(new SiblingExternalLinkId());
          sel.getId().setPerson(getPersistentObject(Person.class, struct.getIdPerson()));
          sel.getId().setSiblingGroup(getPersistentObject(SiblingGroup.class, idSiblingGroupInteger));
          
          sel.setStage(getPersistentObject(Stage.class, struct.getIdSiblingExternalStage()));

          siblingExternalLinkDAO.saveSiblingExternalLink(sel);
        }
      }
    }

    /*
     * Calculate nbr avail and nbr in group for all placement groups based on save structs and remove those groups
     * without siblings
     */
    updateSiblingPlacementGroupsAndNumbers(allSiblings, allPlacementGroups, idCase);

    /* save the sibling group information in ADO history if the event status was set to complete */
    Event event = getPersistentObject(Event.class, idEvent);
    if (event.getCdEventStatus().equals("COMP")) {
      saveSiblingGroupHistory(allSiblings, idEvent, idCase, idPrimaryChild);
    }
  }

  private void saveSiblingGroupHistory(List<SiblingSI> allSiblings, int idEvent, int idCase, int idPrimaryChild) {
    // List<SiblingSI> existingSiblingList = siblingGroupInformationSI.getSiblingsToSaveInExistingGroups();
    // List<SiblingSI> newSiblingList = siblingGroupInformationSI.getSiblingsToSaveInNewGroups();
    AdoInfo adoInfo = getPersistentObject(AdoInfo.class, idEvent);

    // get all children in the case regardless of whether they are in a group
    List<Integer> unsavedChildrenInCase = stagePersonLinkDAO.findFccIdPersonByIdCase(idCase);

    if (listIsValid(unsavedChildrenInCase)) {
      Iterator existingIterator = allSiblings.iterator();

      while (existingIterator.hasNext()) {// update sibling in existing groups
        SiblingSI siblingSI = (SiblingSI) existingIterator.next();

        AdoSiblingHistory adoSiblingHistory = new AdoSiblingHistory();
        adoSiblingHistory.setDtAdoInfoComplete(new Date());
        adoSiblingHistory.setAdoInfo(adoInfo);
        adoSiblingHistory.setIdPerson(siblingSI.getIdPerson());
        adoSiblingHistory.setIdSiblingGroup(siblingSI.getIdSiblingGroup());
        /* lookup exchangeChild */
        ExchangeChild exchangeChild = exchangeChildDAO
                                                      .findMostRecentExchangeChildRecordByIdPerson(siblingSI
                                                                                                            .getIdPerson());
        adoSiblingHistory.setExchangeChild(exchangeChild);

        if (exchangeChild != null) {
          adoSiblingHistory.setCdNonAvailStatus(exchangeChild.getCdNonAvailStatus());
        }
        adoSiblingHistoryDAO.saveAdoSiblingHistory(adoSiblingHistory);
        int indexOfChild = unsavedChildrenInCase.indexOf(new Integer(siblingSI.getIdPerson()));
        if (indexOfChild != -1) {
          /* remove this child id from the list since it has been saved */
          unsavedChildrenInCase.remove(indexOfChild);
        }
      }

      // if there are still some children that haven't been saved then save those children
      // to history without sibling group information
      if (unsavedChildrenInCase.size() > 0) {// check size for readability
        Iterator unsavedIterator = unsavedChildrenInCase.iterator();
        while (unsavedIterator.hasNext()) {
          Integer idPerson = (Integer) unsavedIterator.next();

          AdoSiblingHistory adoSiblingHistory = new AdoSiblingHistory();

          adoSiblingHistory.setAdoInfo(adoInfo);
          adoSiblingHistory.setIdPerson(idPerson);
          adoSiblingHistory.setDtAdoInfoComplete(new Date());

          /* lookup exchangeChild */
          ExchangeChild exchangeChild = exchangeChildDAO.findMostRecentExchangeChildRecordByIdPerson(idPerson);
          adoSiblingHistory.setExchangeChild(exchangeChild);

          if (exchangeChild != null) {
            adoSiblingHistory.setCdNonAvailStatus(exchangeChild.getCdNonAvailStatus());
          }
          adoSiblingHistoryDAO.saveAdoSiblingHistory(adoSiblingHistory);
        }
      }

    }
    
    Sibling sib = siblingDAO.findSiblingByIdPersonByIdCase(idPrimaryChild, idCase);
    
    if(sib != null){
      SiblingGroup sibGrp = sib.getId().getSiblingGroup();
      Collection<SiblingExternalLink> selList = sibGrp.getSiblingExternalLinks();
      
      if(selList != null){
        Iterator<SiblingExternalLink> selIter = selList.iterator();
        
        while(selIter.hasNext()){
          SiblingExternalLink sel = selIter.next();
          
          AdoSiblingExtLnkHistory aselHist = new AdoSiblingExtLnkHistory();
          
          aselHist.setIdSiblingGroup(sel.getId().getSiblingGroup().getIdSiblingGroup());
          aselHist.setPerson(sel.getId().getPerson());
          aselHist.setStage(sel.getStage());
          aselHist.setAdoInfo(adoInfo);
          aselHist.setDtAdoInfoComplete(new Date());
          
          adoSiblingExtLnkHistoryDAO.saveAdoSiblingExtLnkHistory(aselHist);
          
        } // end while
      } // end if
    } // end if
  }

  private void updateSiblingPlacementGroupsAndNumbers(List<SiblingSI> allSiblings,
                                                      List<SiblingGroup> allPlacementGroups, int idCase) {

    /* Map will store <idSiblngGroup, count(siblings)> */
    Map<Integer, Integer> siblingInGroupCountMap = new HashMap<Integer, Integer>();
    Map<Integer, Integer> siblingAvailableToAdoptCountMap = new HashMap<Integer, Integer>();

    /* updating # in group map */
    for (int i = 0; i < allSiblings.size(); ++i) {
      SiblingSI siblingSI = (SiblingSI) allSiblings.get(i);
      Integer idSiblingGroupInteger = (siblingSI.getIdSiblingGroup());

      if (siblingInGroupCountMap.get(idSiblingGroupInteger) != null) {
        // increment sibling count
        Integer incrementedCount = siblingInGroupCountMap.get(idSiblingGroupInteger).intValue() + 1;
        siblingInGroupCountMap.put(idSiblingGroupInteger, incrementedCount);
      } else {
        // add initial sibling group count
        siblingInGroupCountMap.put(idSiblingGroupInteger, new Integer(1));
      }
    }

    /* updating # available to adopt map */
    for (int i = 0; i < allSiblings.size(); ++i) {
      SiblingSI siblingSI = (SiblingSI) allSiblings.get(i);
      Integer idSiblingGroupInteger = (siblingSI.getIdSiblingGroup());

      LegalAction legalAction = retrieveLegalActionTPRAchieved(idCase, siblingSI.getIdPerson());
      String cdNonAvailStatus = siblingSI.getNonAvailStatus();

      if (legalAction == null) {
        // if there is no TPR or VS then a child isn't available for adoption
        continue;
      }

      Integer incrementedCount = siblingAvailableToAdoptCountMap.get(idSiblingGroupInteger);
      if (legalAction != null && cdNonAvailStatus == null) {
        // legal action but no registration increment sibling count
        incrementedCount = (incrementedCount != null) ? (incrementedCount + 1) : new Integer(1);
      } else if (legalAction != null
                 && (cdNonAvailStatus.equals("00") || cdNonAvailStatus.equals("03") || cdNonAvailStatus.equals("55"))) {
        // increment sibling count since there is a TPR or VS and non-avail code shows available
        incrementedCount = (incrementedCount != null) ? (incrementedCount + 1) : new Integer(1);
      }
      siblingAvailableToAdoptCountMap.put(idSiblingGroupInteger, incrementedCount);
    }

    Iterator allPlacementGroupsIterator = allPlacementGroups.iterator();
    while (allPlacementGroupsIterator.hasNext()) {
      /* get #'s based on values created in previous code blocks */
      SiblingGroup siblingGroup = (SiblingGroup) allPlacementGroupsIterator.next();

      if (siblingGroup.getIdSiblingGroup() == null || siblingGroup.getIdSiblingGroup() == 0) {
        /*
         * dummy sibling group(used as place holders for new primary key indexes)... there is no need to update values
         * in this group.
         */
        continue;
      }

      /* update # of children in the sibling group and # available for adoption */
      if (siblingInGroupCountMap.get(siblingGroup.getIdSiblingGroup()) != null
          && siblingInGroupCountMap.get(siblingGroup.getIdSiblingGroup()).intValue() > 0) {
        Integer numInGroupValue = siblingInGroupCountMap.get(siblingGroup.getIdSiblingGroup());
        Integer numAvailToAdoptValue = new Integer(0);

        /* update # available for adoption and # in group */
        if (siblingAvailableToAdoptCountMap.get(siblingGroup.getIdSiblingGroup()) != null) {
          numAvailToAdoptValue = siblingAvailableToAdoptCountMap.get(siblingGroup.getIdSiblingGroup());
        }

        // update the number of siblings in the group and number of siblings available to adopt
        siblingGroupDAO.updateNumberValuesByIdSiblingGroup(siblingGroup.getIdSiblingGroup(), numInGroupValue,
                                                           numAvailToAdoptValue);

      } else {
        // delete sibling group since there are no children associated with it
        if(siblingGroup.getSiblingExternalLinks() == null 
                          || siblingGroup.getSiblingExternalLinks().size() == 0){
          siblingGroupDAO.deleteSiblingGroup(siblingGroup);
        }
      }
    }

  }

  private LegalAction retrieveLegalActionTPRAchieved(int idCase, int idPerson) {
    List<String> cdLegalActActions = new ArrayList<String>();
    cdLegalActActions.add(CodesTables.CLEGCPS_VLM); // Voluntary Surrender-Biological Mother
    cdLegalActActions.add(CodesTables.CLEGCPS_VAM); // Voluntary Surrender by Adoptive Mother
    cdLegalActActions.add(CodesTables.CLEGCPS_VAF); // Voluntary Surrender by Adoptive Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VSF); // Voluntary Surrender Legal/Biological Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VLS); // Voluntary Surrender Legal Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VBF); // Voluntary Surrender Biological Father
    // SMS #97845: MR-074-2
    cdLegalActActions.add(CodesTables.CLEGCPS_VPF); // Voluntary Surrender-Putative Father
    
    // SMS#37448: Added TFB, TFL, TFF codes to the cdHrTypCrtOrds list
    List<String> cdHrTypCrtOrds = new ArrayList<String>();
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPF); // TPR Father this code is end dated
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPM); // TPR - Biological Mother
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPA); // TPR - Adoptive Mother
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFA); // TPR - Adoptive Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFB); // TPR - Biological Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFL); // TPR - Biological and Legal Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFF); // TPR - Legal Father
    // SMS #97845: MR-074-2
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPP); // TPR - Putative Father
    
    // outcomes
    String cdOutComeTypeTpg = CodesTables.CLEGLOUT_TPG;
    String cdOutComeTypeDpc = CodesTables.CLEGLOUT_DPC;

    // SMS#37448 : Find all legal actions for given person in a given case where cdLegalActActions (Action drop down on
    // page)
    // is one of the VS (Voluntary Surrender) OR cdHrTypCrtOrds (Hearing Type/Court Order ) is one of the TPR's.

    LegalAction legalAction = legalActionDAO
                                            .findLegalActionListByIdCaseByIdPersonByCdActionsByCdHrTypCrtOrds(
                                                                                                              idCase,
                                                                                                              idPerson,
                                                                                                              cdLegalActActions,
                                                                                                              cdHrTypCrtOrds,
                                                                                                              cdOutComeTypeTpg,
                                                                                                              cdOutComeTypeDpc);

    return legalAction;
  }

  private boolean isInDFCSCustodyType(String cdLegalStatStatus) {
    boolean isInDfcsCustodyType = false;
    // List of in dfcs custody legal statuses
    Set<String> dfcsCustodyList = new HashSet<String>();
    // STGAP00012413: Error Message MSG_ADO_DT_WO_TERMINATION should be
    // displayed for all Legal statutes but Permanent Court and Permanent Voluntary.
    dfcsCustodyList.add(CodesTables.CLEGSTAT_PCT); // Permanent Court
    dfcsCustodyList.add(CodesTables.CLEGSTAT_PVL); // Permanent Voluntary
    if (dfcsCustodyList.contains(cdLegalStatStatus)) {
      isInDfcsCustodyType = true;
    }

    return isInDfcsCustodyType;
  }

  private boolean courtOrderIsTPR(String cdHrTypCrtOrd) {
    if (StringHelper.isValid(cdHrTypCrtOrd)) {
      // SMS#37448: Added TFB, TFL, TFF codes to the  list
      // SMS #97845: MR-074-2
      // Added TPR - Putative Father (CLHECOT_TPP) to the condition 
      // (Note, this method is never used locally) 
      return (cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPF) || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPM)
              || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPA) || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFA)
              || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFB) || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFL) 
              || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFF) || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPP));

    }
    return false;
  }

  /**
   * MR-083
   * saveRecruitmentActivities saves the County Recruitment Activities date in Adoption Information Page
   * to ADO_INFO_CBX and ADO_INFO_CBX_SENT table. Method allows for modification of existing historical
   * activity dates as well as adding new date by entering directly into an empty date field.
   * 
   */
  private void saveRecruitmentActivities(AdoptionInformationSaveSI adoptionInformationSaveSI) {
    Collection<String> activityCodesList = new ArrayList<String>();
    Map<String, Date> newRecActivityDate = adoptionInformationSaveSI.getNewRecActivityDate();
    Map<String, List<AdoInfoCbxSentStruct>> modifiedRecActivitiesDates = new HashMap<String, List<AdoInfoCbxSentStruct>>();
    
    Integer idEvent = adoptionInformationSaveSI.getUlIdEvent();
    AdoInfo adoInfo = null;
    
    if(idEvent != null){
      adoInfo = getPersistentObject(AdoInfo.class, idEvent);
    }
    
    if(adoInfo != null){
      try{
        // get all possible recruitment activity codes
        activityCodesList = Lookup.getCategoryCodesCollection(CodesTables.CADRACC);
      } catch( Exception e ){
        // this should never occur
        throw new ServiceException(Messages.MSG_CODE_NOT_FOUND);
      }
      
      if(null != activityCodesList && !activityCodesList.isEmpty()){
        Iterator<String> it = activityCodesList.iterator();
        
        // loop through each activity code
        while(it.hasNext()){
          String actCode = it.next();
          modifiedRecActivitiesDates = adoptionInformationSaveSI.getModifiedRecActivitiesDates();
          
          if(modifiedRecActivitiesDates != null && !modifiedRecActivitiesDates.isEmpty()){
            List<AdoInfoCbxSentStruct> adoInfoCbxSentStructList = modifiedRecActivitiesDates.get(actCode);
            
            for( int i = 0; i < adoInfoCbxSentStructList.size(); i++ ){
              AdoInfoCbxSentStruct adoInfoCbxSentStruct = adoInfoCbxSentStructList.get(i);
              
              if(null != adoInfoCbxSentStruct){
                  if(adoInfoCbxSentStruct.getDtAdoInfoCbxSent() == null && adoInfoCbxSentStruct.getIdAdoInfoCbxSent() > 0){
                    // date is null but idAdoInfoCbxSent > 0, therefore user
                    // has deleted value from date field, therefore delete record with the old date.                
                    adoInfoCbxSentDAO.deleteAdoInfoCbxSent(adoInfoCbxSentStruct.getIdAdoInfoCbxSent());
                  }else{ // otherwise save or update
                    AdoInfoCbxSent adoInfoCbxSent = null;
                    
                    if(adoInfoCbxSentStruct.getIdAdoInfoCbxSent() > 0){
                      adoInfoCbxSent = getPersistentObject(AdoInfoCbxSent.class, adoInfoCbxSentStruct.getIdAdoInfoCbxSent());
                    }else{
                      AdoInfoCbx adoInfoCbx = adoInfoCbxDAO.findAdoInfoCbxByIdEventCdCodeTypeCdInfoCbx(idEvent, CodesTables.CADRACC, actCode);
                      
                      // parent record does not exist, therefore create one
                      if(adoInfoCbx == null){
                        adoInfoCbx = new AdoInfoCbx();
                        adoInfoCbx.setIdInfoChar(0);
                        adoInfoCbx.setCdCbxCodeType(CodesTables.CADRACC);
                        adoInfoCbx.setCdAdoInfoCbx(actCode);
                        adoInfoCbx.setAdoInfo(adoInfo);
                        adoInfoCbxDAO.saveAdoInfoCheckBox(adoInfoCbx);
                        // retrieve saved record
                        adoInfoCbx = adoInfoCbxDAO.findAdoInfoCbxByIdEventCdCodeTypeCdInfoCbx(idEvent, CodesTables.CADRACC, actCode);
                      }
                      adoInfoCbxSent = new AdoInfoCbxSent();
                      adoInfoCbxSent.setIdAdoInfoCbxSent(0);
                      adoInfoCbxSent.setAdoInfoCbx(adoInfoCbx);
                    }
                    
                    adoInfoCbxSent.setDtAdoInfoCbxSent(adoInfoCbxSentStruct.getDtAdoInfoCbxSent());
                    adoInfoCbxSentDAO.saveAdoInfoCheckBoxSent(adoInfoCbxSent);
                  }
              }
            } // end for loop
          } // end if
          
          // Added the new date entered by user using calendar control
          if(null != newRecActivityDate){
            Date newActDate = newRecActivityDate.get(actCode);
            
            if(null != newActDate){
              AdoInfoCbx adoInfoCbx = adoInfoCbxDAO.findAdoInfoCbxByIdEventCdCodeTypeCdInfoCbx(idEvent, CodesTables.CADRACC, actCode);
              
              // parent record does not exist, therefore create one
              if(adoInfoCbx == null){
                adoInfoCbx = new AdoInfoCbx();
                adoInfoCbx.setIdInfoChar(0);
                adoInfoCbx.setCdCbxCodeType(CodesTables.CADRACC);
                adoInfoCbx.setCdAdoInfoCbx(actCode);
                adoInfoCbx.setAdoInfo(adoInfo);
                adoInfoCbxDAO.saveAdoInfoCheckBox(adoInfoCbx);
                // retrieve saved record
                adoInfoCbx = adoInfoCbxDAO.findAdoInfoCbxByIdEventCdCodeTypeCdInfoCbx(idEvent, CodesTables.CADRACC, actCode);
              }
              
              AdoInfoCbxSent adoInfoCbxSent = new AdoInfoCbxSent();
              adoInfoCbxSent.setIdAdoInfoCbxSent(0);
              adoInfoCbxSent.setAdoInfoCbx(adoInfoCbx);
              adoInfoCbxSent.setDtAdoInfoCbxSent(newActDate);
              adoInfoCbxSentDAO.saveAdoInfoCheckBoxSent(adoInfoCbxSent);
            }
          } // end if
        } // end while
      } // if
    } else {
      // this should not occur
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
  } // end method

}
