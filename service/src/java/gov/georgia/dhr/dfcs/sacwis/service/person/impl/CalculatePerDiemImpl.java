package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------------------------------
 **  07/16/2008  charden           STGAP00009118: wrote code to check for null value passed back by retrieveContractServiceRate() method. If null 
 *                                 is passed back, add zero to tempFosterCareRate instead of adding contractSvcRatePerDiem to tempFosterCareRate
 *                                 
 *
*/

import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterCareRateDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PaymentOfCareDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.service.person.CalculatePerDiem;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FosterCareRate;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.common.InterfaceServiceConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Double;


/**
 * CalculatePerDiemImpl
 *
 * @author Kalpana Thirumurthy
 * @version 1.0
 *
 * <pre>
 *              Change History:
 *              Date      User              Description
 *              --------  ----------------  --------------------------------------------------
 * </pre>
 */

public class CalculatePerDiemImpl extends BaseServiceImpl implements CalculatePerDiem {

  //Create local references to DAO's used for calculating the per diem info for Parent Demographic Update service
  private ContractServiceDAO contractServiceDAO = null;
  private EligibilityDAO eligibilityDAO = null;
  private FosterCareRateDAO fosterCareRateDAO = null;
  private LegalStatusDAO legalStatusDAO = null;
  private PaymentOfCareDAO paymentOfCareDAO = null;
  private PersonDAO personDAO = null;
  private PersonDtlDAO personDtlDAO = null;
  private PlacementDAO placementDAO = null;
  
  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setFosterCareRateDAO(FosterCareRateDAO fosterCareRateDAO) {
    this.fosterCareRateDAO = fosterCareRateDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setPaymentOfCareDAO(PaymentOfCareDAO paymentOfCareDAO) {
    this.paymentOfCareDAO = paymentOfCareDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }
  
  /**
   * Method used to calculate the per diem per day and monthly for the Outbound web Service for Stars
   * parent demographic update
   * This method is called from the SaveCsupParentdemographicImpl to get the calculated per diem info
   * @param context
   *          Accepts the SI object as the input and Returns the per diem info Object[]
   *          returns null if the calculation failed. If failed then throw a service
   *          exception in the calling service that triggers
   *          a rollback
   */

  @SuppressWarnings("unchecked")
  public HashMap callCalculatePerDiem(String idPersonForChild){

    // Declare the per diem information that needs to be sent to the calling service
    // This has the calculated "PER_DIEM" and "PER_MONTH" values returned
    HashMap perDiemInfo = new HashMap();

    // Local Variables to calculate the perdiem information
    List<Integer> stageForIdPerson = null;
    List<Map> plcmtTypeForPerDiem = null;
    Double contractSvcRatePerDiem = null;
    String payOfCareForPerDiem = null;
    Object[] payOfCareObject = null;
    String cdRbwoProgram = null;
    FosterCareRate fosterCarePerDiem = null;
    PersonDtl citizenshipForPerDiem = null;
    Eligibility eligInfo = null;
    Person personForPerDiem = null;
    String ageCodeForPerDiem = null;
    String cdPlcmtTypeForPerDiem = null;
    String serviceCodeForPerDiem = null;
    String idPlcmtContractForPerDiem = null;
    String indPlcmtEmergForPerDiem = null;
    String cdPocTypeForPerDiem = null;
    LegalStatus legalStat = null;
    Date dtEffPerDiem = null;
    String cdPersonCitizenForPerDiem = null;
    String nbrPersonAgeForPerDiem = null;
    String cdEligSel = null;
    String cdLegalStat = null;
    String decodePlcmtType = null;
    String decodePayOfCare = null;
    String decodeLegalStat = null;
    String decodeCitizenship = null;
    String decodeServiceCode = null;

    // Local variables to calculate the permonth information
    FosterCareRate fosterCarePerMonth = null;
    List<Map> plcmtTypeForPerMonth = null;
    String payOfCareForPerMonth = null;
    Object[] payOfCareForPerMonthObject = null;
    PersonDtl citizenshipForPerMonth = null;
    Person personForPerMonth = null;
    String cdPersonCitizenForPerMonth = null;
    String nbrPersonAgeForPerMonth = null;
    String cdPocTypeForPerMonth = null;
    String cdPlcmtTypeForPerMonth = null;
    String ageCodeForPerMonth = null;
    String serviceCodeForPerMonth = null;

    //get the placment type for calculating the perdiem values
    plcmtTypeForPerDiem = retrievePlcmtTypeDetails(idPersonForChild, InterfaceServiceConstants.PER_DIEM);
    // get the placment type for calculating the permonth values
    plcmtTypeForPerMonth = retrievePlcmtTypeDetails(idPersonForChild, InterfaceServiceConstants.PER_MONTH);
    
    // DOA calls to get the required information to calculate the perdiem values
    if(null != plcmtTypeForPerDiem)
    {
      for (Iterator<Map> it = plcmtTypeForPerDiem.iterator(); it.hasNext();)
      {
        Map map = it.next();
        cdPlcmtTypeForPerDiem = (String) map.get("cdPlcmtType");
        indPlcmtEmergForPerDiem = (String) map.get("indPlcmtEmerg");
        Object tempIdPlcmtContractForPerDiem = map.get("idPlcmtContract");
        if(null != tempIdPlcmtContractForPerDiem)
        {
          String tempStr = tempIdPlcmtContractForPerDiem.toString();
          idPlcmtContractForPerDiem = tempStr;
        }
      }
      
      //payOfCareForPerDiem = retrievePocDetails(idPersonForChild);
      payOfCareObject = retrievePocDetails(idPersonForChild);
      if(null != payOfCareObject)
      {
        if(null != payOfCareObject[0])
          payOfCareForPerDiem = payOfCareObject[0].toString();
      }
      if(null != payOfCareForPerDiem)
      {
        cdPocTypeForPerDiem = payOfCareForPerDiem;
        eligInfo = retrieveEligDetails(idPersonForChild);
        if(null != eligInfo)
          cdEligSel = eligInfo.getCdEligSelected();
        citizenshipForPerDiem = retrieveCitizenshipDetails(idPersonForChild);
        if(null != citizenshipForPerDiem)
          cdPersonCitizenForPerDiem = citizenshipForPerDiem.getCdPersonCitizenship();
        legalStat = retrieveLegalStatusDetails(idPersonForChild);
        if(null != legalStat)
          cdLegalStat = legalStat.getCdLegalStatStatus();
        personForPerDiem = retrievePersonDetails(idPersonForChild);
        if(null != personForPerDiem)
          nbrPersonAgeForPerDiem = (personForPerDiem.getNbrPersonAge()).toString();
      }
      dtEffPerDiem = retrievePocDateDetails(idPersonForChild);
      if (null != dtEffPerDiem)
      {
        perDiemInfo.put(InterfaceServiceConstants.DT_EFF_PER_DIEM, dtEffPerDiem);
      }
    }

    // DOA calls to get the required information to calculate the permonth values
    if(null != plcmtTypeForPerMonth)
    {
      //payOfCareForPerMonth = retrievePocDetails(idPersonForChild);
      payOfCareForPerMonthObject = retrievePocDetails(idPersonForChild);
      if(null != payOfCareForPerMonthObject)
      {
        if(null != payOfCareForPerMonthObject[0])
          payOfCareForPerMonth = payOfCareForPerMonthObject[0].toString();
        if(null != payOfCareForPerMonthObject[1])
          cdRbwoProgram = payOfCareForPerMonthObject[1].toString();
      }
      if(null != payOfCareForPerMonth)
        cdPocTypeForPerMonth = payOfCareForPerMonth;
      citizenshipForPerMonth = retrieveCitizenshipDetails(idPersonForChild);
      if(null != citizenshipForPerMonth)
        cdPersonCitizenForPerMonth = citizenshipForPerMonth.getCdPersonCitizenship();
      personForPerMonth = retrievePersonDetails(idPersonForChild);
      if(null != personForPerMonth)
        nbrPersonAgeForPerMonth = (personForPerMonth.getNbrPersonAge()).toString();
      
      dtEffPerDiem = retrievePocDateDetails(idPersonForChild);
      if (null != dtEffPerDiem)
      {
        perDiemInfo.put(InterfaceServiceConstants.DT_EFF_PER_DIEM, dtEffPerDiem);
      }
    }
    
    // The following logic is performed to calculate the perdiem for a child
    if(null != plcmtTypeForPerDiem)
    {
      if(null != cdPlcmtTypeForPerDiem)
      {
        decodePlcmtType = Lookup.simpleDecodeSafe(CodesTables.CPLCMTRU, cdPlcmtTypeForPerDiem);
      }
      if(InterfaceServiceConstants.CODE_PLCMT_TYPE_CCI.equals(decodePlcmtType) || 
                      InterfaceServiceConstants.CODE_PLCMT_TYPE_CPA.equals(decodePlcmtType) || 
                      InterfaceServiceConstants.CODE_PLCMT_TYPE_DFC.equals(decodePlcmtType))
      {
        if(null != decodePlcmtType)
        {
          if(null != cdPocTypeForPerDiem)
          {
            //if returned pocType is equal to one of these RFD, EFD, SFD, LOC, RWW then call the codes table to
            //get the decode value
            if(InterfaceServiceConstants.CODE_POC_TYPE_RFD.equals(cdPocTypeForPerDiem) || 
                            InterfaceServiceConstants.CODE_POC_TYPE_EFD.equals(cdPocTypeForPerDiem) ||
                            InterfaceServiceConstants.CODE_POC_TYPE_SFD.equals(cdPocTypeForPerDiem) || 
                            InterfaceServiceConstants.CODE_POC_TYPE_LOC.equals(cdPocTypeForPerDiem) || 
                            InterfaceServiceConstants.CODE_POC_TYPE_RWW.equals(cdPocTypeForPerDiem))
            {
              
              //lookup codes table for the decoded value for the legalStatType returned
              if(null != cdLegalStat)
              {
                decodeLegalStat = Lookup.simpleDecodeSafe(CodesTables.CLSRU, cdLegalStat);
                if(null != cdPersonCitizenForPerDiem)
                {
                  decodeCitizenship = Lookup.simpleDecodeSafe(CodesTables.CCITRU, cdPersonCitizenForPerDiem);
                }
                // Place the change here - cdRbwoProgram
                serviceCodeForPerDiem = callBuildServiceCode(decodePlcmtType, cdPocTypeForPerDiem, decodeLegalStat,
                                                   decodeCitizenship, decodeServiceCode, cdEligSel,
                                                   InterfaceServiceConstants.CD_ELIG_SEL_DEFAULT, 
                                                   InterfaceServiceConstants.DECODE_CITIZENSHIP_DEFAULT,
                                                   InterfaceServiceConstants.DECODE_LEGAL_STAT_DEFAULT, 
                                                   InterfaceServiceConstants.TEMP_TYPE_DEFAULT, 
                                                   indPlcmtEmergForPerDiem, cdRbwoProgram);
                decodeServiceCode = calculatePerDiemDecode(serviceCodeForPerDiem);
                if((InterfaceServiceConstants.CODE_PLCMT_TYPE_DFC.equals(decodePlcmtType)) && 
                                (InterfaceServiceConstants.CODE_POC_TYPE_RFD.equals(cdPocTypeForPerDiem) ||
                                InterfaceServiceConstants.CODE_POC_TYPE_EFD.equals(cdPocTypeForPerDiem) || 
                                InterfaceServiceConstants.CODE_POC_TYPE_SFD.equals(cdPocTypeForPerDiem)))
                {
                  ageCodeForPerDiem = calculateAgeCode(nbrPersonAgeForPerDiem);
                  // call the FOSTER_CARE_RATE DAO
                  if(null != ageCodeForPerDiem && null != decodeServiceCode)
                  {
                    fosterCarePerDiem = retrieveFosterCareRateDetails(ageCodeForPerDiem, DateHelper.getTodayCastorDate().toDate(), decodeServiceCode);
                  }
                  if(null != fosterCarePerDiem)
                  {
                    Double tempPerDiemInfo = (Double) fosterCarePerDiem.getAmtFcareRtUnitRate();
                    perDiemInfo.put(InterfaceServiceConstants.PER_DIEM, convertDecimalVal(tempPerDiemInfo));
                  }
                } else if(InterfaceServiceConstants.CODE_PLCMT_TYPE_CCI.equals(decodePlcmtType))
                {
                  // call the ContractServiceDAO method findNbrContractSvcByIdContractAndCdContractSvc
                  if(null != idPlcmtContractForPerDiem)
                  {
                    int tempIdContract = (Integer.valueOf(idPlcmtContractForPerDiem)).intValue();
                    contractSvcRatePerDiem = retrieveContractServiceRate(tempIdContract, decodeServiceCode);
                  }
                  if(null != contractSvcRatePerDiem)
                  {
                    perDiemInfo.put(InterfaceServiceConstants.PER_DIEM, convertDecimalVal(contractSvcRatePerDiem));
                  }
                } else if(InterfaceServiceConstants.CODE_PLCMT_TYPE_CPA.equals(decodePlcmtType))
                {
                  // use the above two DAO calls and add to get perdiem
                  if(null != idPlcmtContractForPerDiem && null != nbrPersonAgeForPerDiem)
                  {
                    ageCodeForPerDiem = calculateAgeCode(nbrPersonAgeForPerDiem);
                    int tempIdContract = (Integer.valueOf(idPlcmtContractForPerDiem)).intValue();
                    fosterCarePerDiem = retrieveFosterCareRateDetails(ageCodeForPerDiem, DateHelper.getTodayCastorDate().toDate(), decodeServiceCode);
                    
                    //STGAP00009118 - wrote code to check for null value passed back by retrieveContractServiceRate() method.  If null is passed back, add
                    //zero to tempFosterCareRate instead of adding contractSvcRatePerDiem to tempFosterCareRate
                    contractSvcRatePerDiem = retrieveContractServiceRate(tempIdContract, decodeServiceCode) != null ? retrieveContractServiceRate(tempIdContract, decodeServiceCode) : Double.NaN;
                    Double tempFosterCareRate = (Double) fosterCarePerDiem.getAmtFcareRtUnitRate();
                    Double tempFinalRate = false == contractSvcRatePerDiem.isNaN() ? (tempFosterCareRate + contractSvcRatePerDiem) : (tempFosterCareRate + 0);
                    perDiemInfo.put(InterfaceServiceConstants.PER_DIEM, convertDecimalVal(tempFinalRate));
                  }
                }
              }
          }
        }
      }
    }
  }
    
  // The following logic is performed to calculate the permonth for a child
  if(null != plcmtTypeForPerMonth)
  {
    if(plcmtTypeForPerMonth.size() > 0) {
      Map map = (Map) plcmtTypeForPerMonth.get(0);
      cdPlcmtTypeForPerMonth = (String) map.get("cdPlcmtType");
    }
    
    if(InterfaceServiceConstants.CODE_PLCMT_TYPE_REP.equals(cdPlcmtTypeForPerMonth) || 
                    InterfaceServiceConstants.CODE_PLCMT_TYPE_NRP.equals(cdPlcmtTypeForPerMonth))
    {
      if(null != cdPocTypeForPerMonth)
      {
        if(InterfaceServiceConstants.CODE_POC_TYPE_ERR.equals(cdPocTypeForPerMonth))
        {
          if(InterfaceServiceConstants.CODE_CITIZENSHIP_TYPE_TMR.equals(cdPocTypeForPerMonth))
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_ERR_TMR;
          else
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_ERR_NON_TMR;
        } else if(InterfaceServiceConstants.CODE_POC_TYPE_ERS.equals(cdPocTypeForPerMonth))
        {
          if(InterfaceServiceConstants.CODE_CITIZENSHIP_TYPE_TMR.equals(cdPocTypeForPerMonth))
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_ERS_TMR;
          else
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_ERS_NON_TMR;
        } else if(InterfaceServiceConstants.CODE_POC_TYPE_RCS.equals(cdPocTypeForPerMonth))
        {
          if(InterfaceServiceConstants.CODE_CITIZENSHIP_TYPE_TMR.equals(cdPocTypeForPerMonth))
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_RCS_TMR;
          else
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_RCS_NON_TMR;
        } else if(InterfaceServiceConstants.CODE_POC_TYPE_ESG.equals(cdPocTypeForPerMonth))
        {
          if(InterfaceServiceConstants.CODE_CITIZENSHIP_TYPE_TMR.equals(cdPocTypeForPerMonth))
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_ESG_TMR;
          else
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_NEG_NON_TMR;
        } else if(InterfaceServiceConstants.CODE_POC_TYPE_SUG.equals(cdPocTypeForPerMonth))
        {
          if(InterfaceServiceConstants.CODE_CITIZENSHIP_TYPE_TMR.equals(cdPocTypeForPerMonth))
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_SUG_TMR;
          else
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_SUG_NON_TMR;
        } else if(InterfaceServiceConstants.CODE_POC_TYPE_NEG.equals(cdPocTypeForPerMonth))
        {
          if(InterfaceServiceConstants.CODE_CITIZENSHIP_TYPE_TMR.equals(cdPocTypeForPerMonth))
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_NEG_TMR;
          else
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_NEG_NON_TMR;
        } else if(InterfaceServiceConstants.CODE_POC_TYPE_NSG.equals(cdPocTypeForPerMonth))
        {
          if(InterfaceServiceConstants.CODE_CITIZENSHIP_TYPE_TMR.equals(cdPocTypeForPerMonth))
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_NSG_TMR;
          else
            serviceCodeForPerMonth = InterfaceServiceConstants.SERVICE_CODE_REL_CARE_PAY_NSG_NON_TMR;
        }
        ageCodeForPerMonth = calculateAgeCode(nbrPersonAgeForPerMonth);
        // call the FOSTER_CARE_RATE DAO
        if(null != ageCodeForPerMonth && null != serviceCodeForPerMonth)
        {
          fosterCarePerMonth = retrieveFosterCareRateDetails(ageCodeForPerMonth, DateHelper.getTodayCastorDate().toDate(), serviceCodeForPerMonth);
        }
        if(null != fosterCarePerMonth)
        {
          double fosterCareRtUnitRateAmt = fosterCarePerMonth.getAmtFcareRtUnitRate();
          perDiemInfo.put(InterfaceServiceConstants.PER_MONTH, convertDecimalVal(fosterCareRtUnitRateAmt));
          perDiemInfo.put(InterfaceServiceConstants.PER_DIEM, convertDecimalVal(fosterCareRtUnitRateAmt/30));
        }
      }
    }
  }
  
  return perDiemInfo;
}

  //Helper methods that makes calls to the appropriate DAO's to get the data that is required to calculate the perdiem and permonth values
  private List<Map> retrievePlcmtTypeDetails(String idPersonForChild, String plcmtKind) {
    List<Map> plcmtTypeDet = null;
    if(null != idPersonForChild)
    {
      if(InterfaceServiceConstants.PER_DIEM.equals(plcmtKind))
      {
        plcmtTypeDet = placementDAO.findPlcmtTypeByChildStatusForPerDiem((Integer.valueOf(idPersonForChild)).intValue());
      } else if(InterfaceServiceConstants.PER_MONTH.equals(plcmtKind))
      {
        plcmtTypeDet = placementDAO.findPlcmtTypeByChildStatusForPerMonth((Integer.valueOf(idPersonForChild)).intValue());
      }
    }
    return plcmtTypeDet;
  }

  private Object[] retrievePocDetails(String idPersonForChild) {
    Object[] pocDet = null;
    if(null != idPersonForChild)
    {
      pocDet = paymentOfCareDAO.findPaymentOfCareApprovedByIdPersonByindConcurrentForPerDiem((Integer.valueOf(idPersonForChild)).intValue());
    }
    return pocDet;
  }
  
  private Date retrievePocDateDetails(String idPersonForChild) {
    Date pocDateDet = null;
    if(null != idPersonForChild)
    {
      pocDateDet = paymentOfCareDAO.findPaymentOfCareDateApprovedByIdPersonByindConcurrentForPerDiem((Integer.valueOf(idPersonForChild)).intValue());
    }
    return pocDateDet;
  }

  private Eligibility retrieveEligDetails(String idPersonForChild) {
    Eligibility eligDet = null;
    if(null != idPersonForChild)
    {
      eligDet = eligibilityDAO.findEligibilityCurrentApprovedByIdPerson((Integer.valueOf(idPersonForChild)).intValue());
    }
    return eligDet;
  }

  private PersonDtl retrieveCitizenshipDetails(String idPersonForChild) {
    PersonDtl citizenDet = null;
    if(null != idPersonForChild)
    {
      citizenDet = personDtlDAO.findServiceAuthByIdPerson((Integer.valueOf(idPersonForChild)).intValue());
    }
    return citizenDet;
  }

  private LegalStatus retrieveLegalStatusDetails(String idPersonForChild) {
    LegalStatus legalStatDet = null;
    if(null != idPersonForChild)
    {
      legalStatDet = legalStatusDAO.findCurrentLegalStatusbyIdPersonForPerDiem((Integer.valueOf(idPersonForChild)).intValue());
    }
    return legalStatDet;
  }

  private Person retrievePersonDetails(String idPersonForChild) {
    Person personDet = null;
    if(null != idPersonForChild)
    {
      personDet = personDAO.findPersonByIdPerson((Integer.valueOf(idPersonForChild)).intValue());
    }
    return personDet;
  }

  private Double retrieveContractServiceRate(int tempIdContract, String decodeServiceCode) {
    Double contractSrvRate = null;
    if(null != decodeServiceCode)
    {
    	contractSrvRate = contractServiceDAO.findNbrContractSvcByIdContractAndCdContractSvc(tempIdContract, decodeServiceCode);
    }
    return contractSrvRate;
  }

  private FosterCareRate retrieveFosterCareRateDetails(String ageCode, Date toDate, String decodeServiceCode) {
    FosterCareRate fosterCareRateDet = null;
    if(null != ageCode && null != decodeServiceCode)
    {
      fosterCareRateDet = fosterCareRateDAO.findFosterCareRateByAgeDateRangeAndService(ageCode, toDate, decodeServiceCode);
    }
    return fosterCareRateDet;
  }
  
  private String callBuildServiceCode(String decodePlcmtType, String cdPocTypeForPerDiem, String decodeLegalStat,
                                      String decodeCitizenship, String decodeServiceCode, String cdEligSel,
                                      String cdEligSelDefault, String decodeCitizenshipDefault,
                                      String decodeLegalStatDefault, String tempType, String indPlcmtEmerg,
                                      String cdRbwoProgram) {

    String servCode = null;
    if(InterfaceServiceConstants.CD_ELIG_SEL_010.equals(cdEligSel) || InterfaceServiceConstants.CD_ELIG_SEL_020.equals(cdEligSel))
    {
      servCode = cdEligSel;
    } else {
      servCode = cdEligSelDefault;
    }
    if(null != cdPocTypeForPerDiem)
      servCode = servCode + cdPocTypeForPerDiem;
    if(null != indPlcmtEmerg)
      servCode = servCode + indPlcmtEmerg;
    servCode = servCode + tempType;
    if(null != decodePlcmtType)
      servCode = servCode + decodePlcmtType;
    if(null != decodeCitizenship)
    {
      servCode = servCode + decodeCitizenship;
    } else {
      servCode = servCode + decodeCitizenshipDefault;
    }
    if(null != decodeLegalStat)
    {
      servCode = servCode + decodeLegalStat;
    } else {
      servCode = servCode + decodeLegalStatDefault;
    }
    if(null != cdRbwoProgram)
    {
      servCode = servCode + cdRbwoProgram;
    }
    
    return servCode;
  }

  private String calculatePerDiemDecode(String codeString) {
    // A lookup is performed on the codes table CPLCMTSC using the codeString.
    // All the codes that contain the codeString are retrieved into a list.
    // Then from the codes list the code which ends with '01' is decoded and
    // the decode value is returned.
    String decode = null;
    try {
      List<CodeAttributes> codeAttrList = Lookup.getCategoryCollection(CodesTables.CPLCMTSC);
      List<String> codeList = new ArrayList<String>();
      if (codeAttrList != null || !codeAttrList.isEmpty()) {
        for (Iterator it = codeAttrList.iterator(); it.hasNext();) {
          CodeAttributes codeAttr = (CodeAttributes) it.next();
          if (codeAttr.getCode().length() >= codeString.length()) {
            String code = codeAttr.getCode();
            if (codeString.regionMatches(0, code, 0, codeString.length())) {
              codeList.add(code);
            }
          }
        }
      }
      if (!codeList.isEmpty()) {
        for (Iterator codeIt = codeList.iterator(); codeIt.hasNext();) {
          String code = (String) codeIt.next();
          String decodeService = Lookup.simpleDecodeSafe(CodesTables.CPLCMTSC, code);
          String temp = decodeService.substring(3, 5);
          if (InterfaceServiceConstants.SERVICE_CODE_CHECK_01.equals(temp)) {
            decode = decodeService;
            return decode;
          }
        }

      }
    } catch (LookupException le) {
      throw new IllegalStateException("Lookup for CPLCMTSC codes table failed" , le);
    }
    System.out.println("decode in calculatePerDiemDecode " + decode);
    return decode;
  }

  private String calculateAgeCode(String personAge) {

    String ageCode = null;
    int nbrPersonAge = (Integer.valueOf(personAge)).intValue();

    if(nbrPersonAge >= 0 && nbrPersonAge <= 5)
    {
      ageCode = InterfaceServiceConstants.AGE_CODE_005;
    } else if(nbrPersonAge >= 6 && nbrPersonAge <= 12)
    {
      ageCode = InterfaceServiceConstants.AGE_CODE_612;
    } else if(nbrPersonAge >= 13)
    {
      ageCode = InterfaceServiceConstants.AGE_CODE_13P;
    }

    return ageCode;
  }
  
  //$TARS assumes no decimal places for the amount
  //so multiple by 100 to shift the decimal place to the right
  //and round to remove any values in the mantissa
  private Double convertDecimalVal(Double perDiemAmt) {
    Double perDiemVal = null;
       
    if(perDiemAmt != null)
    {
      perDiemVal = Math.rint(perDiemAmt * 100);
    }
    
    return perDiemVal;
  }
}