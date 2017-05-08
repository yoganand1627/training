package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeAndResourcesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeResourceInboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeResourceOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeAndResources;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeResourceInbound;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.SaveIncomeResource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IncomeResourceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IncomeResourceSO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * SaveIncomeResourceImpl
 * 
 * @author Srinivasa Rao Dodda
 * @version 1.0
 * 
 * <pre>
 *             Change History:
 *             Date      User              Description
 *             --------  ----------------  --------------------------------------------------
 *             06/23/09  hjbaptiste        Reverted to calculating Start and End Dates based on the Benefit month
 *             
 * </pre>
 */
@SuppressWarnings("unchecked")
public class SaveIncomeResourceImpl extends BaseServiceImpl implements SaveIncomeResource {

  private IncomeResourceInboundDAO incomeResourceInboundDAO = null;

  private IncomeAndResourcesDAO incomeAndResourcesDAO = null;

  private IncomeResourceOutboundDAO incomeResourceOutboundDAO = null;

  public static final String INCOME_TYPE = "INC";

  public static final String RESOURCE_TYPE = "RES";

  public static final String BLANK_STRING = "X";

  public void setIncomeResourceInboundDAO(IncomeResourceInboundDAO incomeResourceInboundDAO) {
    this.incomeResourceInboundDAO = incomeResourceInboundDAO;
  }

  public void setIncomeAndResourcesDAO(IncomeAndResourcesDAO incomeAndResourcesDAO) {
    this.incomeAndResourcesDAO = incomeAndResourcesDAO;
  }

  public void setIncomeResourceOutboundDAO(IncomeResourceOutboundDAO incomeResourceOutboundDAO) {
    this.incomeResourceOutboundDAO = incomeResourceOutboundDAO;
  }

  @SuppressWarnings( { "unchecked" })
  private IncomeAndResources loadIncomeAndResources(IncomeResourceSI incomeResourceSI) {

    IncomeAndResources incomeAndResources = new IncomeAndResources();
    Integer idPerson = 0;
    Integer idIncRsrcWorker = 0;
    int idIncomeResourceOutbound = incomeResourceSI.getIdIncomeResourceOutbound();
    
    Map idIncRsrc = new HashMap();
    idIncRsrc = incomeResourceOutboundDAO.findIdInitiatorAndIdPerson(idIncomeResourceOutbound);
    if (idIncRsrc != null) {
      idPerson = (Integer) idIncRsrc.get("idPerson");
      idIncRsrcWorker = (Integer) idIncRsrc.get("idInitiator");
    }
    
    String cdIncRsrcIncome = incomeResourceSI.getSzIncRsrcInd();
    String cdIncRsrcType = incomeResourceSI.getSzIncRsrcType();
    Date dtIncRsrcTo = getNonNullMaxDate(incomeResourceSI.getDtEndDate());
    Date dtIncRsrcFrom = incomeResourceSI.getDtStartDate();
    String sdsIncRrcsSource = incomeResourceSI.getTxtSrcEmpName();

    String txtIncRsrcSrcAddrZip = getNonNullStr(incomeResourceSI.getTxtIncRsrcSrcAddrZip());
    if (txtIncRsrcSrcAddrZip.length() > 0) {
      incomeAndResources = incomeAndResourcesDAO.findIncomeandResourcesByInboundParamsnZip(cdIncRsrcType,
                                                                                           cdIncRsrcIncome,
                                                                                           dtIncRsrcTo, dtIncRsrcFrom,
                                                                                           idPerson, idIncRsrcWorker,
                                                                                           sdsIncRrcsSource,
                                                                                           txtIncRsrcSrcAddrZip);
    } else {
      incomeAndResources = incomeAndResourcesDAO.findIncomeandResourcesByInboundParams(cdIncRsrcType, cdIncRsrcIncome,
                                                                                       dtIncRsrcTo, dtIncRsrcFrom,
                                                                                       idPerson, idIncRsrcWorker,
                                                                                       sdsIncRrcsSource);
    }

    if (incomeAndResources != null) {
      incomeAndResources = populateIncomeAndResource(incomeAndResources, incomeResourceSI, idPerson, idIncRsrcWorker);
    } else {
      incomeAndResources = new IncomeAndResources();
      incomeAndResources = populateIncomeAndResource(incomeAndResources, incomeResourceSI, idPerson, idIncRsrcWorker);
    }
    incomeAndResourcesDAO.saveIncomeAndResources(incomeAndResources);
    return incomeAndResources;
  }

  private IncomeAndResources populateIncomeAndResource(IncomeAndResources incomeAndResources,
                                                       IncomeResourceSI incomeResourceSI, int idPerson,
                                                       int idIncRsrcWorker) {

    incomeAndResources.setCdIncRsrcType(incomeResourceSI.getSzIncRsrcType() != null ? incomeResourceSI.getSzIncRsrcType() : "");
    incomeAndResources.setCdIncRsrcIncome(incomeResourceSI.getSzIncRsrcInd() != null ? incomeResourceSI.getSzIncRsrcInd() : "");

    if (INCOME_TYPE.equalsIgnoreCase(incomeResourceSI.getSzIncRsrcInd()) && "E".equalsIgnoreCase(incomeResourceSI.getIndEarnedRUnearned())) {
      incomeAndResources.setAmtIncRsrc(calculateMonthlyAmount(incomeResourceSI.getLdIncomeAmount(), incomeResourceSI.getSzIncomeFrequency()));
      incomeAndResources.setCdIncRsrcFreqType(getShinesFreqMapValue(incomeResourceSI.getSzIncomeFrequency()));
      incomeAndResources.setTxtIncRsrcDesc(getSuccessFreqConvertComment(incomeResourceSI.getSzIncomeFrequency()));
      incomeAndResources.setSdsIncRsrcVerfMethod(getNonNullStr(incomeResourceSI.getSzIncomeVerification()));
    }
    if (INCOME_TYPE.equalsIgnoreCase(incomeResourceSI.getSzIncRsrcInd()) && "U".equalsIgnoreCase(incomeResourceSI.getIndEarnedRUnearned())) {
      incomeAndResources.setAmtIncRsrc(calculateMonthlyAmount(incomeResourceSI.getLdUnerndIncomeAmount(), incomeResourceSI.getSzUnerndIncomeFrequency()));
      incomeAndResources.setCdIncRsrcFreqType(getShinesFreqMapValue(incomeResourceSI.getSzUnerndIncomeFrequency()));
      incomeAndResources.setSdsIncRsrcVerfMethod(getNonNullStr(incomeResourceSI.getSzUnerndIncomeVerification()));
      
      if ((incomeResourceSI.getSzIncRsrcType() == null) && (incomeResourceSI.getUlAuNumber() != 0)) {
        incomeAndResources.setCdIncRsrcType(CodesTables.CINCRSRC_XXX);
        incomeAndResources.setTxtIncRsrcDesc("AU Benefit Amount");
      }

      if (CodesTables.CINCRSRC_FOS.equals(incomeResourceSI.getSzIncRsrcType())
          || CodesTables.CINCRSRC_TAN.equals(incomeResourceSI.getSzIncRsrcType())
          || CodesTables.CINCRSRC_XXX.equals(incomeResourceSI.getSzIncRsrcType())
          || (incomeResourceSI.getSzIncRsrcType() == null)) {
        Double benefitAmount = incomeResourceSI.getLdTanfRfoodBnftAmount();
        benefitAmount = (benefitAmount == null) ? incomeResourceSI.getLdUnerndIncomeAmount() : benefitAmount;
        benefitAmount = (benefitAmount == null) ? incomeResourceSI.getLdIncomeAmount() : benefitAmount;

        String benefitFreq = incomeResourceSI.getSzUnerndIncomeFrequency();
        benefitFreq = (benefitFreq == null) ? incomeResourceSI.getSzIncomeFrequency() : benefitFreq;
        incomeAndResources.setAmtIncRsrc(calculateMonthlyAmount(benefitAmount, benefitFreq));
        incomeAndResources.setCdIncRsrcFreqType(getShinesFreqMapValue(benefitFreq));
        incomeAndResources.setTxtIncRsrcDesc(getSuccessFreqConvertComment(benefitFreq));

        // for foods stamps is should be a resource on our side
        if (CodesTables.CINCRSRC_FOS.equals(incomeResourceSI.getSzIncRsrcType())) {
          incomeAndResources.setCdIncRsrcIncome(CodesTables.CINCRSRC_RES);
        }
      }
    }
    
    if (RESOURCE_TYPE.equalsIgnoreCase(incomeResourceSI.getSzIncRsrcInd())) {

      incomeAndResources.setAmtIncRsrc(incomeResourceSI.getLdResourceAmount() != null ? incomeResourceSI.getLdResourceAmount(): new Double(0));
      incomeAndResources.setSdsIncRsrcVerfMethod(incomeResourceSI.getSzResourceVerification() != null ? incomeResourceSI.getSzResourceVerification()
                                                                                                     : "");
    }

    int benifitMonth = incomeResourceSI.getUlBenifitMonth();
    incomeAndResources.setDtIncRsrcFrom(getBeginDate(benifitMonth));
    incomeAndResources.setDtIncRsrcTo(getEndDate(benifitMonth));

    // replace the value with default value from the page with check box
    incomeAndResources.setIndIncRsrcNotAccess("N");
    String tempEmpName = getNonNullStr(incomeResourceSI.getTxtSrcEmpName());
    tempEmpName = (tempEmpName.length() > 20) ? tempEmpName.substring(0, 20) : tempEmpName;
    incomeAndResources.setSdsIncRsrcSource(tempEmpName);
    incomeAndResources.setTxtIncRsrcSrcAddrStLn1(getNonNullStr(incomeResourceSI.getTxtIncRsrcSrcAddrStLn1()));
    incomeAndResources.setTxtIncRsrcSrcAddrStLn2(getNonNullStr(incomeResourceSI.getTxtIncRsrcSrcAddrStLn2()));
    incomeAndResources.setTxtIncRsrcSrcAddrCity(getNonNullStr(incomeResourceSI.getTxtIncRsrcSrcAddrCity()));
    incomeAndResources.setTxtIncRsrcSrcAddrState(getNonNullStr(incomeResourceSI.getTxtIncRsrcSrcAddrState()));
    incomeAndResources.setTxtIncRsrcSrcAddrZip(getNonNullStr(incomeResourceSI.getTxtIncRsrcSrcAddrZip()));
    incomeAndResources.setDtIncRsrcModified(new Date());
    incomeAndResources.setAuNumber(getNonNullInteger(incomeResourceSI.getUlAuNumber()));
    incomeAndResources.setAuStatus(getNonNullStr(incomeResourceSI.getSzClientIdStatus()));
    incomeAndResources.setCaseLoadNumber(getNonNullStr(incomeResourceSI.getSzCaseLdNumber()));

    Person person = getPersistentObject(Person.class, idPerson);
    incomeAndResources.setPersonByIdPerson(person);

    Person incRsrcWorker = getPersistentObject(Person.class, idIncRsrcWorker);
    incomeAndResources.setPersonByIdIncRsrcWorker(incRsrcWorker);
    return incomeAndResources;
  }

  public IncomeResourceSO saveIncomeResource(IncomeResourceSI incomeResourceSI) {
    IncomeResourceInbound incomeResourceInbound = populateIncomeResource(incomeResourceSI);

    // check to see if the inbound record matches ups excatly to any other record if so then it is just a duplicate
    // and do not add the record to caps.IncomeResource but still save the record to the IncomeResourceInbound table
    long count = incomeResourceInboundDAO.countIncomeAndResourceInbound(incomeResourceInbound.getIdClient().intValue(),
                                                                        incomeResourceInbound.getClientStatus(),
                                                                        incomeResourceInbound.getAuNumber().intValue(),
                                                                        incomeResourceInbound.getCdProgramType(),
                                                                        incomeResourceInbound.getBnftMonth().intValue(),
                                                                        incomeResourceInbound.getCdIncRsrcInd(),
                                                                        incomeResourceInbound.getCdIncRsrcType(),
                                                                        incomeResourceInbound.getIndEarned(),
                                                                        incomeResourceInbound.getSdsIncRsrcSource(),
                                                                        incomeResourceInbound.getIncRsrcAmt().doubleValue(),
                                                                        incomeResourceInbound.getCdIncRsrcFreqType(),
                                                                        incomeResourceInbound.getCdIncRsrcVrf(),
                                                                        incomeResourceInbound.getDtIncRsrcFrom(),
                                                                        incomeResourceInbound.getDtIncRsrcTo(),
                                                                        incomeResourceInbound.getUnErndIncAmt().doubleValue(),
                                                                        incomeResourceInbound.getCdUnErndIncFreqType(),
                                                                        incomeResourceInbound.getRsrcAmt().doubleValue(),
                                                                        incomeResourceInbound.getCdUnErndIncVrf(),
                                                                        incomeResourceInbound.getAuStatus(),
                                                                        incomeResourceInbound.getTanfrfoodBnftAmt().doubleValue(),
                                                                        incomeResourceInbound.getCaseLoadNumber(),
                                                                        incomeResourceInbound.getIdIncomeResourceOutbound());
    if (count > 0) {
      incomeResourceInbound.setReturnCode("DUP");
    } else {
      loadIncomeAndResources(incomeResourceSI);
    }

    int id = incomeResourceInboundDAO.saveIncomeResourceInboundInfo(incomeResourceInbound);
    IncomeResourceSO incomeResourceSO = new IncomeResourceSO();
    incomeResourceSO.setTransID((id));
    return incomeResourceSO;
  }

  private String getShinesFreqMapValue(String successFreqType) {
    String shinesFrequencyType = "";
    if ("AN".equalsIgnoreCase(successFreqType)) {
      shinesFrequencyType = CodesTables.CFREQ_ANN;
    } else if ("SM".equalsIgnoreCase(successFreqType)) {
      shinesFrequencyType = CodesTables.CFREQ_SMN;
    } else if ("BW".equalsIgnoreCase(successFreqType)) {
      shinesFrequencyType = CodesTables.CFREQ_BWK;
    } else if ("MO".equalsIgnoreCase(successFreqType)) {
      shinesFrequencyType = CodesTables.CFREQ_MON;
    } else if ("OT".equalsIgnoreCase(successFreqType)) {
      shinesFrequencyType = CodesTables.CFREQ_OTM;
    } else if ("QU".equalsIgnoreCase(successFreqType)) {
      shinesFrequencyType = CodesTables.CFREQ_QRT;
    } else if ("WK".equalsIgnoreCase(successFreqType)) {
      shinesFrequencyType = CodesTables.CFREQ_WEK;
    } else if ("AC".equalsIgnoreCase(successFreqType)) {
      shinesFrequencyType = CodesTables.CFREQ_OTM;
    } else if ("BM".equalsIgnoreCase(successFreqType)) {
      shinesFrequencyType = CodesTables.CFREQ_MON;
    } else if ("SA".equalsIgnoreCase(successFreqType)) {
      shinesFrequencyType = CodesTables.CFREQ_MON;
    } else {
      shinesFrequencyType = successFreqType;
    }
    return shinesFrequencyType;
  }

  /**
   * Calculate the monthly income for frequency types Semi-Annual and Semi-monthly. For other frequency type just return
   * the original value and the online code will take care of calculating the monthly types.
   * 
   * @param successAmount
   * @param successFreqType
   * @return
   */
  private Double calculateMonthlyAmount(Double successAmount, String successFreqType) {
    if (successAmount == null)
      return new Double(0);

    double shinesAmount = successAmount.doubleValue();

    if ("BM".equalsIgnoreCase(successFreqType)) {
      shinesAmount = successAmount.doubleValue() / 2.0;
    } else if ("SA".equalsIgnoreCase(successFreqType)) {
      shinesAmount = successAmount.doubleValue() / 6.0;
    }

    return Double.valueOf(shinesAmount);
  }

  /**
   * Returns the comment to be inserted into the income and resource detail page when Bi-monthly or Semi-annual amount
   * is converted to monthly amount.
   * 
   * @param successFreqType
   * @return
   */
  private String getSuccessFreqConvertComment(String successFreqType) {
    String successIncomeRsrcComment = "";
    if ("BM".equalsIgnoreCase(successFreqType)) {
      successIncomeRsrcComment = "The SUCCESS bi-monthly amount is converted to a monthly Amount";
    } else if ("SA".equalsIgnoreCase(successFreqType)) {
      successIncomeRsrcComment = "The SUCCESS semi-annual amount is converted to a monthly Amount";
    } else if ("AC".equalsIgnoreCase(successFreqType)) {
      successIncomeRsrcComment = "The SUCCESS Actual amount is converted to an equivalent one-time Amount";
    }
    return successIncomeRsrcComment;
  }

  private Date getEndDate(int intBenefitMonth) {
    Date endDate = null;
    Integer benefitMonth = new Integer(intBenefitMonth);
    String strBenefitMonth = benefitMonth.toString();

    // benefitMonth is in the form of YYYYMM
    if ((strBenefitMonth != null) && (strBenefitMonth.length() == 6)) {
      String strMonth = strBenefitMonth.substring(4);
      String strYear = strBenefitMonth.substring(0, 4);
      Date benefitDate = DateHelper.toJavaDateSafe(strMonth + "/01/" + strYear);
      if (benefitDate != null) {
        endDate = DateHelper.getLastDayOfTheMonth(benefitDate);
      }
    }
    return endDate;
  }

  public IncomeResourceInbound populateIncomeResource(IncomeResourceSI incomeResourceSI) {
    IncomeResourceInbound incomeResourceInbound = new IncomeResourceInbound();
    incomeResourceInbound.setIdIncomeResourceOutbound(getNonNullInteger(incomeResourceSI.getIdIncomeResourceOutbound()));
    incomeResourceInbound.setIdClient(getNonNullInteger(incomeResourceSI.getUlClientID()));
    incomeResourceInbound.setClientStatus(getValidStr(incomeResourceSI.getSzClientIdStatus()));
    incomeResourceInbound.setAuNumber(getNonNullInteger(incomeResourceSI.getUlAuNumber()));
    incomeResourceInbound.setCdProgramType(getValidStr(incomeResourceSI.getSzCdProgramType()));
    incomeResourceInbound.setBnftMonth(getNonNullInteger(incomeResourceSI.getUlBenifitMonth()));
    incomeResourceInbound.setCdIncRsrcInd(getValidStr(incomeResourceSI.getSzIncRsrcInd()));
    incomeResourceInbound.setCdIncRsrcType(getValidStr(incomeResourceSI.getSzIncRsrcType()));
    incomeResourceInbound.setIndEarned(getValidStr(incomeResourceSI.getIndEarnedRUnearned()));
    incomeResourceInbound.setSdsIncRsrcSource(getValidStr(incomeResourceSI.getTxtSrcEmpName()));
    incomeResourceInbound.setTxtIncRsrcSrcAddrStLn1(getValidStr(incomeResourceSI.getTxtIncRsrcSrcAddrStLn1()));
    incomeResourceInbound.setTxtIncRsrcSrcAddrStLn2(getValidStr(incomeResourceSI.getTxtIncRsrcSrcAddrStLn2()));
    incomeResourceInbound.setTxtIncRsrcSrcAddrCity(getValidStr(incomeResourceSI.getTxtIncRsrcSrcAddrCity()));
    incomeResourceInbound.setTxtIncRsrcSrcAddrState(getValidStr(incomeResourceSI.getTxtIncRsrcSrcAddrState()));
    incomeResourceInbound.setTxtIncRsrcSrcAddrZip(getValidStr(incomeResourceSI.getTxtIncRsrcSrcAddrZip()));
    incomeResourceInbound.setIncRsrcAmt(getNonNullDouble(incomeResourceSI.getLdIncomeAmount()));
    incomeResourceInbound.setCdIncRsrcFreqType(getValidStr(incomeResourceSI.getSzIncomeFrequency()));
    incomeResourceInbound.setCdIncRsrcVrf(getValidStr(incomeResourceSI.getSzIncomeVerification()));
    incomeResourceInbound.setDtIncRsrcFrom(getNonNullMaxDate(incomeResourceSI.getDtStartDate()));
    incomeResourceInbound.setDtIncRsrcTo(getNonNullMaxDate(incomeResourceSI.getDtEndDate()));
    incomeResourceInbound.setUnErndIncAmt(getNonNullDouble(incomeResourceSI.getLdUnerndIncomeAmount()));
    incomeResourceInbound.setCdUnErndIncFreqType(getValidStr(incomeResourceSI.getSzUnerndIncomeFrequency()));
    incomeResourceInbound.setCdUnErndIncVrf(getValidStr(incomeResourceSI.getSzUnerndIncomeVerification()));
    incomeResourceInbound.setRsrcAmt(getNonNullDouble(incomeResourceSI.getLdResourceAmount()));
    incomeResourceInbound.setAuStatus(getValidStr(incomeResourceSI.getUlAuStatus()));
    incomeResourceInbound.setTanfrfoodBnftAmt(getNonNullDouble(incomeResourceSI.getLdTanfRfoodBnftAmount()));
    incomeResourceInbound.setCaseLoadNumber(getValidStr(incomeResourceSI.getSzCaseLdNumber()));
    return incomeResourceInbound;
  }

  private Date getBeginDate(int intBenefitMonth) {
    Date beginDate = null;
    Integer benefitMonth = new Integer(intBenefitMonth);
    String strBenefitMonth = benefitMonth.toString();
    // benefitMonth is in the form of YYYYMM
    if ((strBenefitMonth != null) && (strBenefitMonth.length() == 6)) {
      String strMonth = strBenefitMonth.substring(4);
      String strYear = strBenefitMonth.substring(0, 4);
      Date benefitDate = DateHelper.toJavaDateSafe(strMonth + "/01/" + strYear);
      if (benefitDate != null) {
        beginDate = benefitDate;
      }
    }
    return beginDate;
  }

  private String getNonNullStr(String str) {
    return isValidStr(str) ? str.trim() : "";
  }

  private String getValidStr(String str) {
    return isValidStr(str) ? str.trim() : BLANK_STRING;
  }

  private boolean isValidStr(String str) {
    return (str != null && str.length() > 0);
  }

  private Double getNonNullDouble(Double dble) {
    return (dble != null) ? dble : 0.0;
  }

  private Integer getNonNullInteger(Integer integer) {
    return (integer != null) ? integer : 0;
  }

  private Date getNonNullMaxDate(Date date) {
    return (date != null) ? date : DateHelper.MAX_JAVA_DATE;
  }
}