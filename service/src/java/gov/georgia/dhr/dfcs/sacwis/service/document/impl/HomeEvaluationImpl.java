package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeApplicantInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantInfo;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.document.HomeEvaluation;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HOMEEVALUATIONSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HOMEEVALUATIONSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HomeEvaluationImpl extends BaseDocumentServiceImpl implements HomeEvaluation {

  private CapsCaseDAO capsCaseDAO;

  private StageDAO stageDAO;

  private CapsResourceDAO capsResourceDAO;

  private HomeApplicantInfoDAO homeApplicantInfoDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private List<StagePersonLink> hohList = new ArrayList<StagePersonLink>();

  private List<StagePersonLink> otherMembersList = new ArrayList<StagePersonLink>();

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  public void setHomeApplicantInfoDAO(HomeApplicantInfoDAO homeApplicantInfoDAO) {
	    this.homeApplicantInfoDAO = homeApplicantInfoDAO;
	  }
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public HOMEEVALUATIONSO retrieveHomeEvaluation(HOMEEVALUATIONSI homeEvaluationsi) {
    HOMEEVALUATIONSO homeEvaluationso = new HOMEEVALUATIONSO();

    hohList.clear();
    otherMembersList.clear();

    int idStage = homeEvaluationsi.getUlIdStage();

    Stage stage = stageDAO.findStageByIdStage(idStage);

    // get case name with case id from case table
    int idCase = stage.getCapsCase().getIdCase();

    // get the detail data
    String caseName = capsCaseDAO.findNmCaseByIdCase(idCase);

    // get information related to the Household
    CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);
    
    int idResource = capsResource.getIdResource().intValue();

    // get information related to the Household
 
    HomeApplicantInfo homeApplicantInfo = homeApplicantInfoDAO.findHomeApplicantInfoByIdResource(idResource);
    

    int facilityNum = capsResource.getIdResource();
    if (idCase == 0) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    PreFillData preFillData = getHomeEvaluationHeadings(facilityNum, caseName, idCase);

    getHomeValuationContactInfo(preFillData, caseName, capsResource);
    getOtherInformation(preFillData, capsResource, homeApplicantInfo);
    createHouseholdMembers(idStage, idCase, capsResource, preFillData);

    createHohArray(hohList, preFillData, capsResource);
    createOtherMembersArray(otherMembersList, preFillData);

    // displayHeadOfHouseHold(capsResource,stagePersonLink);
    homeEvaluationso.setPreFillData(preFillData);
    return homeEvaluationso;

  }

  /*
   * Get the detail data about the heading given a specific case number
   */
  private PreFillData getHomeEvaluationHeadings(int facilityNum, String caseName, int idCase) {
    PreFillData preFillData = new PreFillData();
    preFillData.addBookmark(createBookmark(HOME_NAME, caseName));
    preFillData.addBookmark(createBookmark(FACILITY_ID, facilityNum));
    preFillData.addBookmark(createBookmark(CASE_ID, idCase));
    return preFillData;
  } // end of getHomeEvaluationHeadings

  /*
   * Get address and contact information surrounding the Home
   */
  private PreFillData getHomeValuationContactInfo(PreFillData preFillData, String caseName, CapsResource capsResource) {
    preFillData.addBookmark(createBookmark(HD_HOME_NAME, caseName));
    preFillData.addBookmark(createBookmark(HD_STREET_LN1, capsResource.getAddrRsrcStLn1()));
    preFillData.addBookmark(createBookmark(HD_STREET_LN2, capsResource.getAddrRsrcStLn2()));
    preFillData.addBookmark(createBookmark(HD_CITY, capsResource.getAddrRsrcCity()));
    preFillData.addBookmark(createBookmark(HD_COUNTY, Lookup.simpleDecodeSafe("CCOUNT", capsResource.getCdRsrcCnty())));
    preFillData.addBookmark(createBookmark(HD_STATE, capsResource.getCdRsrcState()));
    preFillData.addBookmark(createBookmark(HD_ZIP, capsResource.getAddrRsrcZip()));
    preFillData.addBookmark(createBookmark(HD_PHONE, FormattingHelper.formatPhone(capsResource.getNbrRsrcPhn())));
    preFillData.addBookmark(createBookmark(HD_PHONE_EXTENSION, capsResource.getNbrRsrcPhoneExt()));
    return preFillData;
  }// end of getHomeValuationContactInfo

  /*
   * Get other information about family that is not grouped with previous information
   */
  private PreFillData getOtherInformation(PreFillData preFillData, CapsResource capsResource,
		  HomeApplicantInfo homeApplicantInfo) {

    preFillData.addBookmark(createBookmark(HOME_ANN_INCOME, 
                                           FormattingHelper.formatMoney(capsResource.getNbrRsrcAnnualIncome())));
    //STGAP00003759 Getting inquiry date that matches inquiry section of Home Information page
   if(homeApplicantInfo != null){
    preFillData.addBookmark(createBookmark(INQ_DATE, FormattingHelper.formatDate(homeApplicantInfo.getDtInquiry())));
   }
   return preFillData;
  }// end of getOtherInformation

  /*
   * Gets list of Household members
   */
  private void createHouseholdMembers(int idStage, int idCase, CapsResource capsResource, PreFillData preFillData) {

    List<StagePersonLink> stagePersonLinks = stagePersonLinkDAO.findHouseMembersLinkedToStage(idStage);
    if (stagePersonLinks != null && !stagePersonLinks.isEmpty()) {
      for (Iterator<StagePersonLink> it = stagePersonLinks.iterator(); it.hasNext();) {
        StagePersonLink stagePersonLink = it.next();
        determineHouseHoldStatus(preFillData, stagePersonLink);

      }// end of personDtl search
    } // end of map
  }// end of for loop

  /*
   * Used to display head of house hold members. This function will only be used if person has been designated as Head
   * Of Household. There many be many Heads.
   */
  private FormDataGroup displayHeadOfHouseHold(CapsResource capsResource, StagePersonLink stagePersonLink) {
    FormDataGroup group = createFormDataGroup(TMPLAT_HEAD_HOUSEHOLD, FRD03O00);
    Person person = stagePersonLink.getPerson();
    group.addBookmark(createBookmark(TMP1_NAME_FIRST, person.getNmPersonFirst()));
    group.addBookmark(createBookmark(TMP1_NAME_LAST, (String) person.getNmPersonLast()));
    group.addBookmark(createBookmark(TMP1_NAME_MIDDLE, (String) person.getNmPersonMiddle()));
    group.addBookmark(createBookmark(TMP1_NAME_SUFFIX, (String) person.getCdPersonSuffix()));
    int age = person.getNbrPersonAge();
    if(age > 0){
    group.addBookmark(createBookmark(TMP1_AGE, age));
    }
    Date dtDob = (Date) person.getDtPersonBirth();
    // Calculating the Age from the persons BirthDate if the Age is an aprox.
    if(age == 0 ){
    group.addBookmark(createBookmark(TMP1_AGE, DateHelper.getAge(dtDob)));
    }
    group.addBookmark(createBookmark(TMP1_DOB, FormattingHelper.formatDate(dtDob)));
    group.addBookmark(createBookmark(TMP1_SEX, Lookup.simpleDecodeSafe(CodesTables.CSEX,
                                                                       (String) person.getCdPersonSex())));
    group
         .addBookmark(createBookmark(TMP1_ETHNICITY, Lookup.simpleDecodeSafe(CodesTables.CETHNIC,
                                                                             (String) person.getCdPersonEthnicGroup())));
    group.addBookmark(createBookmark(TMP1_CITIZENSHIP, Lookup.simpleDecodeSafe(CodesTables.CCTZNSTA,
                                                                               person.getPersonDtl().getCdPersonCitizenship())));
    group.addBookmark(createBookmark(TMP1_LANGUAGE, Lookup.simpleDecodeSafe(CodesTables.CLANG,
                                                                            (String) person.getCdPersonLanguage())));
    group
         .addBookmark(createBookmark(TMP1_EDUCATION, Lookup.simpleDecodeSafe(CodesTables.CHIGHEDU,
                                                                             (String) person.getPersonDtl()
                                                                                            .getCdPersonHighestEduc())));
    group.addBookmark(createBookmark(TMP1_OCCUPATION, (String) person.getTxtPersonOccupation()));
    group.addBookmark(createBookmark(TMP4_MARITAL_STATUS,
                                     Lookup.simpleDecodeSafe(CodesTables.CFAMSTRC,
                                                             (String) capsResource.getCdRsrcMaritalStatus())));
    Date dtMarriageDate = (Date) capsResource.getDtRsrcMarriage();
    group.addBookmark(createBookmark(TMP3_MARRIAGE_DATE, FormattingHelper.formatDate(dtMarriageDate)));

    return group;
  } // end of CreateHeadOfHouseHold

  /*
   * Used to determine the Members household status. Adult Caretakers and Parents are considered Heads of Household.
   * 
   */
  private PreFillData determineHouseHoldStatus(PreFillData preFillData, StagePersonLink stagePersonLink) {

     HashMap<String, String> prinHoh = new HashMap<String, String>();
        prinHoh.put("AF", CodesTables.CRPTRINT_AF);
        prinHoh.put("FP", CodesTables.CRPTRINT_FP);        
        prinHoh.put("GU", CodesTables.CRPTRINT_GU);
        prinHoh.put("PA", CodesTables.CRPTRINT_PA);
        prinHoh.put("PK", CodesTables.CRPTRINT_PK);
        prinHoh.put("SP", CodesTables.CRPTRINT_SP);
        prinHoh.put("ST", CodesTables.CRPTRINT_ST);
        prinHoh.put("FA", CodesTables.CRPTRINT_ST);
        //STGAP00011500: an adoptive Parent should be 
        // considered Head of Household
        prinHoh.put("PT", CodesTables.CRPTRINT_PT);
        
        
        HashMap<String, String> prinOthers = new HashMap<String, String>();
        prinOthers.put("AB", CodesTables.CRPTRINT_AB);
        prinOthers.put("AU", CodesTables.CRPTRINT_AU);
        prinOthers.put("CO", CodesTables.CRPTRINT_CO);
        prinOthers.put("DA", CodesTables.CRPTRINT_DA);
        prinOthers.put("DC", CodesTables.CRPTRINT_DC);
        prinOthers.put("DR", CodesTables.CRPTRINT_DR);
        prinOthers.put("FI", CodesTables.CRPTRINT_FI);
        prinOthers.put("FR", CodesTables.CRPTRINT_FR);
        prinOthers.put("GC", CodesTables.CRPTRINT_GC);
        prinOthers.put("GP", CodesTables.CRPTRINT_GP);
        prinOthers.put("GU", CodesTables.CRPTRINT_GU);
        prinOthers.put("IC", CodesTables.CRPTRINT_IC);
        prinOthers.put("IP", CodesTables.CRPTRINT_IP);
        prinOthers.put("MF", CodesTables.CRPTRINT_MF);
        prinOthers.put("NN", CodesTables.CRPTRINT_NN);
        prinOthers.put("PB", CodesTables.CRPTRINT_PB);
        prinOthers.put("PP", CodesTables.CRPTRINT_PP);
        prinOthers.put("PR", CodesTables.CRPTRINT_PR);
        prinOthers.put("PY", CodesTables.CRPTRINT_PY);
        prinOthers.put("SB", CodesTables.CRPTRINT_SB);
        prinOthers.put("SC", CodesTables.CRPTRINT_SC);
        prinOthers.put("SH", CodesTables.CRPTRINT_SH);
        prinOthers.put("SL", CodesTables.CRPTRINT_SL);
        prinOthers.put("SO", CodesTables.CRPTRINT_SO);
        prinOthers.put("SR", CodesTables.CRPTRINT_SR);
        prinOthers.put("SS", CodesTables.CRPTRINT_SS);
        prinOthers.put("TP", CodesTables.CRPTRINT_TP);
        prinOthers.put("UF", CodesTables.CRPTRINT_UF);
        prinOthers.put("UH", CodesTables.CRPTRINT_UH);
        prinOthers.put("UK", CodesTables.CRPTRINT_UK);
        prinOthers.put("XX", CodesTables.CRPTRINT_XX);
        

if("PRN".equals(stagePersonLink.getCdStagePersType())){
    if (prinHoh.containsKey(stagePersonLink.getCdStagePersRelInt())) {
      hohList.add(stagePersonLink);

    } 
      else if (prinOthers.containsKey(stagePersonLink.getCdStagePersRelInt())) {
      otherMembersList.add(stagePersonLink);
      
      }
    }
else if("COL".equals(stagePersonLink.getCdStagePersType())){
   otherMembersList.add(stagePersonLink);
}
    return preFillData;
  } // end of determineHouseHoldStatus

  private void createHohArray(List<StagePersonLink> hohList, PreFillData preFillData, CapsResource capsResource) {

    if (hohList != null && !hohList.isEmpty()) {
      for (Iterator<StagePersonLink> it = hohList.iterator(); it.hasNext();) {
        StagePersonLink stagePersonLink = it.next();
        preFillData.addFormDataGroup(displayHeadOfHouseHold(capsResource, stagePersonLink));
      }
    }
  }

  private void createOtherMembersArray(List<StagePersonLink> otherMembersArray, PreFillData preFillData) {

    if (otherMembersArray != null && !otherMembersArray.isEmpty()) {
      for (Iterator<StagePersonLink> it = otherMembersArray.iterator(); it.hasNext();) {
        StagePersonLink stagePersonLink = it.next();
        preFillData.addFormDataGroup(DisplayOtherHouseHoldMembers(stagePersonLink));
      }
    }
  }
  
  

  /*
   * Used to display other house hold members. This function will only be used if person has NOT been designated as Head
   * Of Household. There many be many "Other household members".
   */
  private FormDataGroup DisplayOtherHouseHoldMembers(StagePersonLink stagePersonLink) {
    FormDataGroup group = createFormDataGroup(TMPLAT_OTHER_HOUSEHOLD, FRD03O01);
    Person person = stagePersonLink.getPerson();
    group.addBookmark(createBookmark(TMP2_NAME_FIRST, person.getNmPersonFirst()));
    group.addBookmark(createBookmark(TMP2_NAME_LAST, (String) person.getNmPersonLast()));
    group.addBookmark(createBookmark(TMP2_NAME_MIDDLE, (String) person.getNmPersonMiddle()));
    group.addBookmark(createBookmark(TMP2_NAME_SUFFIX, (String) person.getCdPersonSuffix()));
    int age = person.getNbrPersonAge();
    if (age > 0){
    group.addBookmark(createBookmark(TMP2_AGE, age));
    }
    Date dtDob = (Date) person.getDtPersonBirth();
    if(age == 0){
    	group.addBookmark(createBookmark(TMP2_AGE, DateHelper.getAge(dtDob)));
    }
    group.addBookmark(createBookmark(TMP2_DOB, FormattingHelper.formatDate(dtDob)));
    group.addBookmark(createBookmark(TMP2_SEX, Lookup.simpleDecodeSafe(CodesTables.CSEX,
                                                                       (String) person.getCdPersonSex())));
    group.addBookmark(createBookmark(TMP2_ETHNIC, Lookup.simpleDecodeSafe(CodesTables.CETHNIC,
                                                                          (String) person.getCdPersonEthnicGroup())));
    group.addBookmark(createBookmark(TMP2_EDUCATION,
                                     Lookup.simpleDecodeSafe(CodesTables.CHIGHEDU,
                                                             (String) stagePersonLink.getPerson().getPersonDtl()
                                                                                     .getCdPersonHighestEduc())));
    if("PRN".equals(stagePersonLink.getCdStagePersType())){
    group
         .addBookmark(createBookmark(TMP2_ROLE_IN_HOME, Lookup.simpleDecodeSafe(CodesTables.CRELVICT ,
                                                                                stagePersonLink.getCdStagePersRelInt())));
    }
    else if("COL".equals(stagePersonLink.getCdStagePersType())){
        group
        .addBookmark(createBookmark(TMP2_ROLE_IN_HOME, Lookup.simpleDecodeSafe(CodesTables.CSRCRPTR ,
                                                                               stagePersonLink.getCdStagePersRelInt())));
    }
    return group;

  } // end of CreateOtherHouseHoldMember

}