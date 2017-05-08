package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;

import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;

import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import gov.georgia.dhr.dfcs.sacwis.service.document.RelativeCareSubsidyApplicationAgreementForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelativeCareSubsidyApplicationAgreementFormSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareSubsidyApplicationAgreementFormSO;

/**
 * Relative Care Subsidy Application and Agreement Form service Implementation
 * 
 * <pre>
 * Change History:
 *  Date         User      Description
 *  ----------   --------  --------------------------------------------------
 *  05/21/2011   hnguyen   SMS#109407: MR-087 Relative Care Subsidy Application and Agreement Form added 
 *  06/14/2011   hnguyen   SMS#111766: MR-087 Retrieve child phone and address from placement caps_resource record
 *                         not from placement records.
 * </pre>
 * 
 */

public class RelativeCareSubsidyApplicationAgreementFormImpl extends BaseDocumentServiceImpl implements
                                                                                 RelativeCareSubsidyApplicationAgreementForm {
  private LegalStatusDAO legalStatusDAO;
  
  private PersonIdDAO personIdDAO;

  private PlacementDAO placementDAO;
  
  private ResourceAddressDAO resourceAddressDAO;
  
  private ResourcePhoneDAO resourcePhoneDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setResourcePhoneDAO(ResourcePhoneDAO resourcePhoneDAO) {
    this.resourcePhoneDAO = resourcePhoneDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  private static final String UNDERLINE = "_________________________";

  public RelativeCareSubsidyApplicationAgreementFormSO retrieveRelativeCareSubsidyApplicationAgreementForm(
                                                                                     RelativeCareSubsidyApplicationAgreementFormSI relativeCareSubsidyApplicationAgreementFormSI) {
    RelativeCareSubsidyApplicationAgreementFormSO relativeCareSubsidyApplicationAgreementFormSO = new RelativeCareSubsidyApplicationAgreementFormSO();
    Person child = new Person();
    PreFillData preFillData = new PreFillData();

    int idCase = relativeCareSubsidyApplicationAgreementFormSI.getUlIdCase();
    int idStage = relativeCareSubsidyApplicationAgreementFormSI.getUlIdStage();    
    
    // retrieve Primary Child from stage, assuming there will always be one
    List<StagePersonLink> primaryChildren = new ArrayList<StagePersonLink>();
    primaryChildren = stagePersonLinkDAO.findPrimaryChildrenByIdStage(idStage);
    
    Iterator<StagePersonLink> it = primaryChildren.iterator();
    
    while(it.hasNext()){
      StagePersonLink spl = it.next();
      child = spl.getPerson();
      break;
    }
    
    int idPerson = 0;
    if(child != null && child.getIdPerson() != null){
      idPerson = child.getIdPerson().intValue();
    }

    CapsResource resource = new CapsResource();
    ResourceAddress rsrcAddress = new ResourceAddress();
    String rsrcPhone = StringHelper.EMPTY_STRING;

    List<String> cdStages = new ArrayList<String>();
    cdStages.add(CodesTables.CSTAGES_SUB);
    cdStages.add(CodesTables.CSTAGES_PFC);
    
    Placement childPlacement = placementDAO.findMostRecentPlcmtByIdPersonByIdCaseByCdStages(idPerson, idCase, cdStages);
    
    // person may not have placement
    if (null == childPlacement){
      childPlacement = new Placement();
    }else{
      resource = childPlacement.getCapsResourceByIdRsrcFacil();
      
      if(resource != null){
        rsrcAddress = resourceAddressDAO.findRsrcAddressByAddressTypeOnly(resource.getIdResource());
        
        if(rsrcAddress == null){
          rsrcAddress = new ResourceAddress();
        }

        Map phoneInfo = resourcePhoneDAO.findResourcePhoneInfo(resource.getIdResource());
        rsrcPhone = FormattingHelper.formatPhone((String) phoneInfo.get("nbrRsrcPhone"));
        String ext = (String) phoneInfo.get("nbrRsrcPhoneExt");
        if (rsrcPhone != null) {
          if (ext != null) {
            rsrcPhone = rsrcPhone + "   Ext " + ext;
          }
        }        
      }
    }
    
    String ssn = personIdDAO.findNonEndDatePersonSSN(idPerson);

    // Generate pre-fill data
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_NAME,
                                           FormattingHelper.formatString(child.getNmPersonFirst() + " " + child.getNmPersonLast()).trim()));
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_DOB,
                                           FormattingHelper.formatDate(child.getDtPersonBirth())));
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_AGE,
                                           DateHelper.getAge(child.getDtPersonBirth())));
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_SSN,
                                           FormattingHelper.formatSSN(ssn)));
    
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_PHONE,
                                           rsrcPhone));
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_ADDRESS_LN1,
                                           FormattingHelper.formatString(rsrcAddress.getAddrRsrcAddrStLn1())));
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_ADDRESS_LN2,
                                           FormattingHelper.formatString(rsrcAddress.getAddrRsrcAddrStLn2())));
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_ADDRESS_CITY,
                                           FormattingHelper.formatString(rsrcAddress.getAddrRsrcAddrCity())));
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_ADDRESS_STATE,
                                           FormattingHelper.formatString(rsrcAddress.getCdRsrcAddrState())));
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_ADDRESS_ZIP,
                                           FormattingHelper.formatString(rsrcAddress.getAddrRsrcAddrZip())));
    
    
    // These following fields requires that if there is no value, then we must display the underline chararacter
    // to allow space for printed copies of this form to be handwritten.
    String childName = FormattingHelper.formatString(child.getNmPersonFirst() + " " + child.getNmPersonLast()).trim();
    if(StringHelper.isEmptyOrNull(childName)){
      childName = UNDERLINE;
    }
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_NAME2, childName));
    
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_NAME3, childName));

    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.CHILD_NAME4, childName));

    LegalStatus childLegalStatusForCase = legalStatusDAO.findMostRecentLegalStatusByIdPersonIdCase(idPerson, idCase);
    
    // person may not have legal status
    if (null == childLegalStatusForCase){
      childLegalStatusForCase = new LegalStatus();
    }

    String legalCounty = FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CCOUNT,childLegalStatusForCase.getCdLegalStatCnty()));
    if(StringHelper.isEmptyOrNull(legalCounty)){
      legalCounty = UNDERLINE;
    }
    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.LEGAL_COUNTY, legalCounty));

    preFillData.addBookmark(createBookmark(RelativeCareSubsidyApplicationAgreementForm.LEGAL_COUNTY2, legalCounty));

    relativeCareSubsidyApplicationAgreementFormSO.setPreFillData(preFillData);

    return relativeCareSubsidyApplicationAgreementFormSO;
  }
}
