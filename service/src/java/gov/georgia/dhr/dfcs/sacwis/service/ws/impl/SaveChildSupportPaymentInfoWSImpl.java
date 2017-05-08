package gov.georgia.dhr.dfcs.sacwis.service.ws.impl; 
                          
import gov.georgia.dhr.dfcs.sacwis.dao.AgencyCustodialParentsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeAndResourcesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ChildSupportInbound;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeAndResources;
import gov.georgia.dhr.dfcs.sacwis.service.common.InterfaceServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.SaveChildSupportPaymentInfoWS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveChildSupportPaymentInfoSI;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * SaveChildSupportPaymentInfoWSImpl
 *
 * @author Kalpana Thirumurthy
 * @version 1.0
 *
 * <pre>
 *              Change History:
 *              Date         User                 Description
 *              --------     ----------------     --------------------------------------------------
 *              5/09/2008    hjbaptiste           STGAP00008448: Added processing code to indicate payment processing status. Also added code
 *                                                to add/padd the CRS IDs that are not 9 digits long and search for them with or without the 
 *                                                leading zeros since we are not sure how they are saved in the database. Replaced method to 
 *                                                shift the payment amount two decimal places to the left. Cleaned the code.
 * </pre>
 */

public class SaveChildSupportPaymentInfoWSImpl extends BaseServiceImpl implements SaveChildSupportPaymentInfoWS
{        
  private static final String CD_PAYMENT_PROC_CORRCTLY = CodesTables.CPMTPROC_00;
  private static final String CD_NON_CUST_CRS_ID_NOT_FOUND = CodesTables.CPMTPROC_01;
  private static final String CD_CNTY_BY_CRS_ID_NOT_FOUND = CodesTables.CPMTPROC_02;
  private static final String CD_PAYMENT_IS_NULL = CodesTables.CPMTPROC_03;
  private static final String CD_STAGE_NOT_FOUND = CodesTables.CPMTPROC_04;
  private static final String CD_INCOME_RESRC_NOT_UPDATED = CodesTables.CPMTPROC_05;
  private static final int CRS_ID_LENGTH = 9;

  
  private AgencyCustodialParentsDAO agencyCustodialParentsDAO = null;
  private EligibilityDAO eligibilityDAO = null;
  private IncomeAndResourcesDAO incomeAndResourcesDAO = null;
  private PersonIdDAO personIdDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  Log log = LogFactory.getLog(SaveChildSupportPaymentInfoWS.class);
  
  public void setAgencyCustodialParentsDAO (AgencyCustodialParentsDAO agencyCustodialParentsDAO){
    this.agencyCustodialParentsDAO = agencyCustodialParentsDAO;
  }
  public void setEligibilityDAO (EligibilityDAO eligibilityDAO){
    this.eligibilityDAO = eligibilityDAO;
  }
  public void setIncomeAndResourcesDAO (IncomeAndResourcesDAO incomeAndResourcesDAO){
    this.incomeAndResourcesDAO = incomeAndResourcesDAO;
  }
  public void setPersonIdDAO (PersonIdDAO personIdDAO){
    this.personIdDAO = personIdDAO;
  }
  public void setStagePersonLinkDAO (StagePersonLinkDAO stagePersonLinkDAO){
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public int saveChildSupportPaymentInfo(SaveChildSupportPaymentInfoSI saveChildSupportPaymentInfoSI) {
    
    IncomeAndResources incRsrcWebService = new IncomeAndResources();
    ChildSupportInbound incRsrcWebServiceAudit = new ChildSupportInbound();
    Object[] PersonIdFromCrsId = null;
    String cdCounty = null;
    List<Integer> splStageIdList = null;
    Integer childStageId = null;
    Integer childIdPerson = null;
    Double payedAmount = 0.0;
    Double payedAmountFinalDouble = (Double) ((double) 0);
    int countChildReferred = 0;
    Eligibility csupFlag = null;
    Object[] pLink = null;
    int idWorker = 0;
    int insertedRows = 0;
    boolean nonCustParentCrsIdNotFound = true;
    boolean countyByCrsIdNotFound = true;
    boolean stageNotFound = true;
    boolean paymentIsNull = true;
    boolean incomeResrcNotUpdated = true;
    int statusCode = -1;
    
    log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - Enter");
    if(null != saveChildSupportPaymentInfoSI)
    {
      log.info(">> Inside SaveChildSupportPaymentInfoWSImpl " + saveChildSupportPaymentInfoSI);
      if(null != (String)Integer.toString(saveChildSupportPaymentInfoSI.getIdNonCustCrsId()))
      {
        log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - NonCustCrsId " + saveChildSupportPaymentInfoSI.getIdNonCustCrsId());
        String idNonCustCrsId = Integer.toString(saveChildSupportPaymentInfoSI.getIdNonCustCrsId());
        // If the CRS ID doesn't contain nine(9) digits then 'padd' it and search for it with or without
        // the leading zeros since we're not sure if does or doesn't contain nine digits in the database
        if (idNonCustCrsId.length() < CRS_ID_LENGTH){
          PersonIdFromCrsId = personIdDAO.findDistinctIdPersonByCrsIdPadded(idNonCustCrsId, addLeadingZerosToCrsId(idNonCustCrsId));
        } else {
          PersonIdFromCrsId = personIdDAO.findDistinctIdPersonByCrsId(idNonCustCrsId);
        }
        if (null != PersonIdFromCrsId)
        {
          nonCustParentCrsIdNotFound = false;
          log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - ParentPersonId " + PersonIdFromCrsId[0]);
          java.math.BigDecimal parentPersonId = (java.math.BigDecimal) PersonIdFromCrsId[0];
          if(null != parentPersonId.toString())
          {
            log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - CountyCrsId " + saveChildSupportPaymentInfoSI.getIdCountyCrsId());
            if (saveChildSupportPaymentInfoSI.getIdCountyCrsId() > 0) {
              String idCountyCrsId = Integer.toString(saveChildSupportPaymentInfoSI.getIdCountyCrsId());
              if (idCountyCrsId.length() < CRS_ID_LENGTH){
                cdCounty = agencyCustodialParentsDAO.findCountyByCountyCrsIdPadded(saveChildSupportPaymentInfoSI.getIdCountyCrsId(), Integer.valueOf(addLeadingZerosToCrsId(idCountyCrsId)));
              } else {
                cdCounty = agencyCustodialParentsDAO.findCountyByCountyCrsId(saveChildSupportPaymentInfoSI.getIdCountyCrsId());
              }
              if (null != cdCounty) {
                countyByCrsIdNotFound = false;
                log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - CountyCode " + cdCounty);
                splStageIdList = stagePersonLinkDAO.findIdStageByIdPersonParent(parentPersonId.intValue(), cdCounty);
              }
            }
            if(null != splStageIdList)
            {
              stageNotFound = false;
              log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - Children Stage For Parent " + splStageIdList);
              if (null != saveChildSupportPaymentInfoSI.getAmtIncRsrcChildSupportRecd()) {
                paymentIsNull = false;
                log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - Amount Payment received " + saveChildSupportPaymentInfoSI.getAmtIncRsrcChildSupportRecd());
                if (splStageIdList.size() > 1) {
                  log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - More than one child " + splStageIdList);
                  for (int i = 0; i <= splStageIdList.size() - 1; i++) {
                    childStageId = splStageIdList.get(i);
                    log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - child stage id " + childStageId);
                    childIdPerson = stagePersonLinkDAO.findIdPersonForChildByIdStage(childStageId);
                    log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - child person id " + childIdPerson);
                    csupFlag = eligibilityDAO.findDistinctEligibilityByIdPersonAndIndCsupSend(childIdPerson);
                    if (null != csupFlag) {
                      log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - child eligibility for referral " + csupFlag.getIndEligCsupSend());
                      if (InterfaceServiceConstants.CSUP_FLAG_Y.equals(csupFlag.getIndEligCsupSend())) {
                        countChildReferred = countChildReferred + 1;
                      }
                    }
                  }
                  log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - number of children eligible for this parent "
                           + countChildReferred);
                  double childReferredCount = (double) countChildReferred;
                  if (null != saveChildSupportPaymentInfoSI.getAmtIncRsrcChildSupportRecd()) {
                    // Call this method to convert the amount to double and calculate the amount
                    // payed for each eligible child returned for the parent
                    payedAmount = calculatePayedAmt(saveChildSupportPaymentInfoSI.getAmtIncRsrcChildSupportRecd());
                    payedAmount = payedAmount / (Double) childReferredCount;
                    log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - amount for each eligible child for this parent " + payedAmount);
                  }
                } else {
                  // Call this method to convert the amount to double and need not calculate
                  // the amount for each child as this code is called only if the parent has
                  // one child

                  payedAmount = calculatePayedAmt(saveChildSupportPaymentInfoSI.getAmtIncRsrcChildSupportRecd());
                  log.info(">> Inside SaveChildSupportPaymentInfoWSImpl - amount for the eligible child for this parent " + payedAmountFinalDouble);
                }
              }
              for(int i = 0; i<= splStageIdList.size() - 1; i++)
              {
                childStageId = splStageIdList.get(i);
                childIdPerson = stagePersonLinkDAO.findIdPersonForChildByIdStage(childStageId);
                csupFlag = eligibilityDAO.findDistinctEligibilityByIdPersonAndIndCsupSend(childIdPerson);
                if(null != csupFlag)
                {
                  log.info(">> Inside SaveChildSupportPaymentInfoWSImpl before referral check" + csupFlag.getIndEligCsupSend() + "child IdPerson " + childIdPerson);
                  if (InterfaceServiceConstants.CSUP_FLAG_Y.equals(csupFlag.getIndEligCsupSend()))
                  {
                    // set the SO with all the ids here and call the insert into income_and_resources table
                    log.info(">> Inside SaveChildSupportPaymentInfoWSImpl before insert");
                    incRsrcWebService.setAmtIncRsrc(payedAmount);
                    incRsrcWebService.setCdIncRsrcType(InterfaceServiceConstants.INC_RSRC_TYPE_CODE_CSP);
                    incRsrcWebService.setCdIncRsrcIncome(InterfaceServiceConstants.INC_RSRC_INCOME_CODE);
                    incRsrcWebService.setDtIncRsrcFrom(saveChildSupportPaymentInfoSI.getDtIncRsrcChildSupportRecd());
                    incRsrcWebService.setDtIncRsrcTo(saveChildSupportPaymentInfoSI.getDtIncRsrcChildSupportRecd());
                    incRsrcWebService.setTxtIncRsrcDesc(saveChildSupportPaymentInfoSI.getTxtIncRsrcCheckNumber());
                    incRsrcWebService.setCdIncRsrcFreqType(InterfaceServiceConstants.INC_RSRC_FREQ_TYPE_CODE_OTM);
                    if(null != PersonIdFromCrsId[0])
                        pLink = stagePersonLinkDAO.findIdPersonByIdStagePersRole(Integer.valueOf((String)PersonIdFromCrsId[0].toString()).intValue());
                    
                    if(null != pLink)
                    {
                      if(null != pLink[0])
                        idWorker = Integer.valueOf((String)pLink[0].toString());
                    }
                    int tmpInsertedRows  = incomeAndResourcesDAO.insertPaymentRecdIncomeAndResources(
                                           childIdPerson,
                                           idWorker,
                                           incRsrcWebService.getAmtIncRsrc() /*== null ? 0.0 : incRsrcWebService.getAmtIncRsrc().doubleValue())*/, 
                                           incRsrcWebService.getCdIncRsrcType(), 
                                           incRsrcWebService.getCdIncRsrcIncome(), 
                                           incRsrcWebService.getDtIncRsrcFrom(), 
                                           incRsrcWebService.getDtIncRsrcTo(), 
                                           incRsrcWebService.getTxtIncRsrcDesc(), 
                                           incRsrcWebService.getCdIncRsrcFreqType());
                    
                    if (tmpInsertedRows > 0){
                      incomeResrcNotUpdated = false;
                    }
                    insertedRows = insertedRows + tmpInsertedRows;
                    
                    
                    log.info(">> Inside SaveChildSupportPaymentInfoWSImpl after insert");
                  }
                }
              }
            }
          }
        }
      }
      log.info(">> Inside SaveChildSupportPaymentInfoWSImpl after insert - rows inserted " + insertedRows);
      if(payedAmount != 0.0)
      {
        incRsrcWebServiceAudit.setAmtChldSpprtAmnt(payedAmount);
      } else {
        if(null != saveChildSupportPaymentInfoSI.getAmtIncRsrcChildSupportRecd())
          incRsrcWebServiceAudit.setAmtChldSpprtAmnt(calculatePayedAmt(saveChildSupportPaymentInfoSI.getAmtIncRsrcChildSupportRecd()));
      }
      incRsrcWebServiceAudit.setNbrNcpCrsId(saveChildSupportPaymentInfoSI.getIdNonCustCrsId());
      incRsrcWebServiceAudit.setNbrCountyCrsId(saveChildSupportPaymentInfoSI.getIdCountyCrsId());
      incRsrcWebServiceAudit.setDtChldSpprtRcvd(saveChildSupportPaymentInfoSI.getDtIncRsrcChildSupportRecd());
      if (saveChildSupportPaymentInfoSI.getTxtIncRsrcCheckNumber() != null) {
        incRsrcWebServiceAudit.setNbrCheck(Integer.valueOf(saveChildSupportPaymentInfoSI.getTxtIncRsrcCheckNumber()));
      }
      
      if (!nonCustParentCrsIdNotFound){
        if (!countyByCrsIdNotFound) {
          incRsrcWebServiceAudit.setNbrCntyOffice(Integer.valueOf(cdCounty));
          if (!stageNotFound){
            if (!paymentIsNull) {
              if (!incomeResrcNotUpdated) {
                // indicate that the Payment processed correctly with no errors
                statusCode = Integer.valueOf(CD_PAYMENT_PROC_CORRCTLY);
                incRsrcWebServiceAudit.setCdChildSupPaymntProcess(CD_PAYMENT_PROC_CORRCTLY);
              } else {
                // indicate that No Income and Resources updated
                statusCode = Integer.valueOf(CD_INCOME_RESRC_NOT_UPDATED);
                incRsrcWebServiceAudit.setCdChildSupPaymntProcess(CD_INCOME_RESRC_NOT_UPDATED);
              }
            } else {
              // indicate that the Payment received is null
              statusCode = Integer.valueOf(CD_STAGE_NOT_FOUND);
              incRsrcWebServiceAudit.setCdChildSupPaymntProcess(CD_STAGE_NOT_FOUND);
            }
          } else {
            // indicate that the Payment is null
            statusCode = Integer.valueOf(CD_PAYMENT_IS_NULL);
            incRsrcWebServiceAudit.setCdChildSupPaymntProcess(CD_PAYMENT_IS_NULL);
          }
        } else {
          // indicate that County by CrsId not found
          statusCode = Integer.valueOf(CD_CNTY_BY_CRS_ID_NOT_FOUND);
          incRsrcWebServiceAudit.setCdChildSupPaymntProcess(CD_CNTY_BY_CRS_ID_NOT_FOUND);
        }
      } else {
        // indicate that the Non-Custodial Parent CrsId not found
        statusCode = Integer.valueOf(CD_NON_CUST_CRS_ID_NOT_FOUND);
        incRsrcWebServiceAudit.setCdChildSupPaymntProcess(CD_NON_CUST_CRS_ID_NOT_FOUND);
      }
      incomeAndResourcesDAO.saveChildSupportInbound(incRsrcWebServiceAudit);
    }
    return statusCode;
  }
  
  /* STARS is sending the amount without the decimal value. For example: if a child is supposed to
  receive an amount of $15.65, STARS sends its as '1565' and the WSDL interprets it as 1565.0 as
  its expecting a double and does not find a decimal it adds it to the end. The following code
  was written to shift the decimal point two places to the left. STARS has agreed to always send 
  two digits for the decimal for example: if the child is supposed to receive $15.00 STARS has agreed 
  to send the value as 1500 and not 15
  */
  private double calculatePayedAmt (double payedAmount){
    return payedAmount = payedAmount * .01;
  }
  
  // A CrsId contains nine(9) digits. When the Id is sent over from STAR$, the zeros are automatically
  // removed since it is an integer. This method will add/padd the leading zeros to make the ID a
  // nine digit number.
  private String addLeadingZerosToCrsId(String crsId) {
    int nbrOfLeadingZeros = CRS_ID_LENGTH - crsId.length();
    StringBuffer buffer = new StringBuffer();
    for (int i = 1; i <= nbrOfLeadingZeros; i++) {
      buffer.append('0');
    }
    buffer.append(crsId);
    String crsIdPadded = buffer.toString();
    return crsIdPadded;
  }
}