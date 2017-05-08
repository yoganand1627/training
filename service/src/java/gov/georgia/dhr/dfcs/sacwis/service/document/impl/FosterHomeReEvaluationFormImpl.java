package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.ArrayList;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterCareRateDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PaymentOfCareDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.PaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.document.FosterHomeReEvaluationForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.util.Iterator;

/*Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
08/12/10  wjcochran         SMS #37465: Updated form to use the approval date for approved forms and
                            current date for non-approved forms due to the possibility of setting 
                            preFillAlways to true. In the case of approved forms, we want to use data
                            as it existed at the time of approval - i.e. resource address and children
                            placed at the resource. This will mimic a form that has been locked down.
                            The reason this has been implemented is due to some error where approved
                            forms are having incorrect values for resource name and address and also
                            children in placement.
                            
                            Added eventDAO, resourceHistoryDAO. Removed the unused stageLinkDAO.
*/

public class FosterHomeReEvaluationFormImpl extends BaseDocumentServiceImpl implements FosterHomeReEvaluationForm {

  private CapsResourceDAO capsResourceDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private PlacementDAO placementDAO;

  private PaymentOfCareDAO paymentOfCareDAO;

  private PersonDAO personDAO;

  private FosterCareRateDAO fosterCareRateDAO;

  private EventDAO eventDAO;
  
  private ResourceHistoryDAO resourceHistoryDAO;
  
  public void setFosterCareRateDAO(FosterCareRateDAO fosterCareRateDAO) {
    this.fosterCareRateDAO = fosterCareRateDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPaymentOfCareDAO(PaymentOfCareDAO paymentOfCareDAO) {
    this.paymentOfCareDAO = paymentOfCareDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  public CFAD04SO retrieveFHReEvaluationForm(CFAD04SI fhReEvaluationFormsi) {
    CFAD04SO fhReEvaluationFormso = new CFAD04SO();

    int idStage = fhReEvaluationFormsi.getUlIdStage();
    int idResource = getIdResource(fhReEvaluationFormsi.getUlIdResource(), idStage);
    int idEvent = fhReEvaluationFormsi.getUlIdEvent();
    Date formDate = determineFormDate(idEvent);

    PreFillData preFillData = new PreFillData();

    FormDataGroup fadGroup = getFadGroup();
    if ( fadGroup == null ){
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    // The FILLING_FIELD bookmark is just to make the template work when no individual field are created within a group
    preFillData.addBookmark(createBookmark(FILLING_FIELD, " "));
    getHeadingInfo(preFillData, idResource); 
    getFamilyAddress(fadGroup, idResource, formDate);
    getHomeMembers(fadGroup, idStage);
    getChildrenCurrInPlacement(fadGroup, idResource, idStage, formDate);

    preFillData.addFormDataGroup(fadGroup);

    fhReEvaluationFormso.setPreFillData(preFillData);

    return fhReEvaluationFormso;
  }

  private FormDataGroup getFadGroup() {
    FormDataGroup group = createFormDataGroup(TMPLAT_FAD_GENERIC, FRD01O00);
    return group;
  }
private void getHeadingInfo(PreFillData preFillData, int idResource ){
  CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
  int idCase = 0;
  if(capsResource != null ){
    idCase = capsResource.getCapsCase().getIdCase();
 }

  preFillData.addBookmark(createBookmark(HOME_NAME, capsResource.getNmResource())); 
  preFillData.addBookmark(createBookmark(ID_RESOURCE, capsResource.getIdResource()));
  preFillData.addBookmark(createBookmark(CASE_NUM, idCase));
  
  
  
  
}
  /* Modified for SMS #37465 to pull the address at a particular date. This date
   * will either be the approval date for the re-evaluation form or the current
   * date for non-approved forms.
   */
  private void getFamilyAddress(FormDataGroup fadGroup, int idResource, Date formDate) {
    
    ResourceHistory resHistory = resourceHistoryDAO.findResourceHistoryByIdResourceDtDtPlcmtStart(idResource, formDate);
    if (resHistory != null) {
      FormDataGroup group = createFormDataGroup(TMPLAT_HOME_ADDR, FRD01O00);

      group.addBookmark(createBookmark(STREET_LN1, resHistory.getAddrRshsStLn1()));
      group.addBookmark(createBookmark(STREET_LN2, resHistory.getAddrRshsStLn2()));
      group.addBookmark(createBookmark(CITY, resHistory.getAddrRshsCity()));
      group.addBookmark(createBookmark(COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT, 
                                                                       resHistory.getCdRshsCnty())));
      group.addBookmark(createBookmark(STATE, resHistory.getCdRshsState()));
      group.addBookmark(createBookmark(ZIP, resHistory.getAddrRshsZip()));
      group.addBookmark(createBookmark(PHONE, FormattingHelper.formatPhone(resHistory.getNbrRshsPhn())));
    

      fadGroup.addFormDataGroup(group);
    }
  }

  // get the list of members living in the household. This is set on personDetail page of each person in the case
  private void getHomeMembers(FormDataGroup fadGroup, int idStage) {
    FormDataGroup group = null;

    // STGAP00007529 displaying all people listed on the person list page instead of 
    // just the household members.  This was done because of clients request
   //  List<StagePersonLink> stagePersonLinks = stagePersonLinkDAO.findHouseMembersLinkedToStage( idStage );

    List<StagePersonLink> stagePersonLinks = stagePersonLinkDAO.findStagePersonLinkByIdStageOrderByCdStagePersrole(idStage);
    
    
    if (stagePersonLinks != null && !stagePersonLinks.isEmpty()) {
      for (Iterator<StagePersonLink> it = stagePersonLinks.iterator(); it.hasNext();) {
        StagePersonLink stagePersonLink = it.next();
        group = createFormDataGroup(TMPLAT_HOME_MEMB, FRD01O00);
        if(!CodesTables.CPRSNALL_STF.equals(stagePersonLink.getCdStagePersType())){
          // Staff members dont show up on person list page
        group.addBookmark(createBookmark(HOME_MEMB_NAME_FULL, stagePersonLink.getPerson().getNmPersonFull()));
        fadGroup.addFormDataGroup(group);
        }
       
      } // end for loop
    } // end if stagePersonLinks != null
    
  } // end getHomeMembers()

  // get the list of kids that have been placed in this home but are not household members
  // SMS #37465 - Modified this method to take in a date parameter, rather than always use 
  // the current date
  private void getChildrenCurrInPlacement(FormDataGroup fadGroup, int idResource, int idStage, Date formDate) {
    //STGAP00011742: Using the following line results in a date with the
    // following format: MM/DD/YY 00:00:00. This date causes an error in queries
    // that involve placements that were converted from the ADO stage to the PAD stage
    // as the end date for ADO and start date for PAD are the same. When the DAO
    // call is made, the older ADO placement will always be selected when this form
    // is accessed on the same day that an ADO placement becomes a PAD placement.
    //Date todayDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());

    FormDataGroup group = null;
    List<Map> childrenPlacedList = placementDAO
                                               .findPersonsByIdPlcmtChildByCapsResourceByIdRsrcFacil(formDate,
                                                                                                     idResource,
                                                                                                     CodesTables.CPLCMTAC_A);

    if (childrenPlacedList != null && !childrenPlacedList.isEmpty()) {
      for (Map childMap : childrenPlacedList) {
        group = createFormDataGroup(TMPLAT_CURR_PLCMT, FRD01O00);

        group.addBookmark(createBookmark(CHILD_NAME_FIRST, (String) childMap.get("personFirstName")));
        group.addBookmark(createBookmark(CHILD_NAME_MIDDLE, (String) childMap.get("personMiddleName")));
        group.addBookmark(createBookmark(CHILD_NAME_LAST, (String) childMap.get("personLastName")));
        group.addBookmark(createBookmark(CHILD_NAME_SUFFIX, (String) childMap.get("personSuffix")));
        Date dob = (Date) childMap.get("personDtOfBirth");
        if (dob != null) {
          group.addBookmark(createBookmark(CHILD_DOB, FormattingHelper.formatDate(dob)));
        }

        String cdPlcmtType = (String) childMap.get("cdPlcmtType");
        if (cdPlcmtType != null) {
          group.addBookmark(createBookmark(CHILD_LIV_ARR, Lookup.simpleDecodeSafe(CodesTables.CPLMNTYP, cdPlcmtType)));
        }
        Date dtPlcmtStart = (Date) childMap.get("dtPlcmtStart");
        if (dtPlcmtStart != null) {
          group.addBookmark(createBookmark(CHILD_PLCMT_DT, FormattingHelper.formatDate(dtPlcmtStart)));
        }
        group
             .addBookmark(createBookmark(
                                         CHILD_AUTH_FC_PER_DIEM,
                                         getFosterCarePerDiemRate(
                                                                  idResource,
                                                                  ((Integer) childMap.get("personByIdPlcmtChild"))
                                                                                                                  .intValue(),
                                                                  formDate)));

        fadGroup.addFormDataGroup(group);
      }
    }
  }

  // get the approved per diem for the child for only one of the per diem types listed below
  private String getFosterCarePerDiemRate(int idResource, int idPerson, Date todayDate) {
    String perDiemRate = null;
    Collection<String> cdPocTypes = new ArrayList<String>();
    cdPocTypes.add("RFD"); // Regular Foster Care per diem
    cdPocTypes.add("EFD"); // special Foster Care per diem
    cdPocTypes.add("SFD"); // Specialized Foster Care per diem

    int childAge = 0;
    childAge = DateHelper.getAge(personDAO.findPersonByIdPerson(idPerson).getDtPersonBirth());
    String ageRange = "";
    if (childAge <= 5) {
      ageRange = "005";
    } else if (childAge > 5 && childAge < 13) {
      ageRange = "612";
    } else if (childAge >= 13) {
      ageRange = "13P";
    }

    // get the paymentOfCare
    PaymentOfCare paymentOfCare = paymentOfCareDAO.findPaymentOfCareApprovedByIdPersonByCdPocTypes(idPerson,
                                                                                                   cdPocTypes,
                                                                                                   todayDate);
    if (paymentOfCare != null) {
      Double perDiemSavedRate = fosterCareRateDAO.findFosterCareRateByAgeDateRangeAndService(ageRange, todayDate,
                                                                                             SERVICE)
                                                 .getAmtFcareRtUnitRate();
      Double nbrSpecPerDiem = paymentOfCare.getNbrSpecPerDiem();
      Double SpecFcRbwoWaiver = paymentOfCare.getAmtSpecFcRbwoWaiver();

      Double totalPerDiemRate = perDiemSavedRate + SpecFcRbwoWaiver + nbrSpecPerDiem;
      perDiemRate = String.valueOf(totalPerDiemRate.doubleValue());
    }

    return perDiemRate;
  }

  private int getIdResource(int idResource, int idStage) {
    if (idResource == 0) {
      CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);
      if (capsResource != null) {
        idResource = capsResource.getIdResource();
      }
    }
    return idResource;
  }
  
  /* This method has been added for SMS #37465.
   * If an event is approved, we want to use the event
   * approved date, as detailed in change history.
   */
  private Date determineFormDate(int idEvent) {
    
    Date date = new Date();
    
    if (idEvent > 0) {
      Event event = eventDAO.findEventByIdEvent(idEvent);
      if (event != null) {
        String cdEventStatus = event.getCdEventStatus();
        if (CodesTables.CEVTSTAT_APRV.equals(cdEventStatus)) {
          date = event.getDtEventOccurred();
        }
      }
    }
    return date;
  }

}
