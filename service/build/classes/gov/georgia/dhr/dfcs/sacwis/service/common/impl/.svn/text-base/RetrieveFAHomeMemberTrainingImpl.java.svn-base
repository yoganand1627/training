package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.FaIndivTrainingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveFAHomeMemberTraining;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SOG00_ARRAY;

/**
 * Retrieves data from FA_INDIV_TRAINING table
 * 
 * @author lata.p.lokhande
 * 
 * <pre>
 *   Change History:
 *   Date      User        Description
 *   --------  ----------  --------------------------------------------------
 *   10/20/08  alwilliams  STGAP00010495 - Changed training hours completed and training 
 *                         hours remaining to a double. 
 *   10/28/08  alwilliams  STGAP00010494 - Updated method retrieveFAHomeMemberTraining to
 *                         call findMaxEffectiveDateByHomeStatusIdPerson to get the last
 *                         (maximum) F/A Home approval date. The last approval date is the
 *                         effective date and is used to calculated the current hours of 
 *                         training remaining.
 *                                               
 *                         Added method getRequiredTrngHrs(String szTrngHrsCode) to get
 *                         the required training hours from the CODES_TABLE using the
 *                         codes table lookup component.
 *                         
 *                         Updated method getRequiredTrngHrs(Date approvedDate) to call method
 *                         getRequiredTrngHrs(String szTrngHrsCode).
 *                         
 *   01/13/09 alwilliams   STGAP00010494 - Updated method retrieveFAHomeMemberTraining to calculate
 *                         the number of training hours in November or December of the previous year
 *                         if the home was approved in November or December of the previous year. In this 
 *                         case the calculated training hours from the previous year is counted toward the 
 *                         total 10 training hours that must be completed by December 31st of the current year.
 * 
 *   01/14/09 alwilliams   STGAP00010494 - Updated method retrieveFAHomeMemberTraining to use existing DateHelper 
 *                         methods to calculate the value for last year and to determine if the month of a date 
 *                         is November or December. Removed method isMonthNovOrDec and references to methods 
 *                         isPreviousYear and isSameMonth.       
 *                         
 *   01/23/09 alwilliams   STGAP00010494 - Update for Peer Review 1                                    
 * </pre>
 */
public class RetrieveFAHomeMemberTrainingImpl extends BaseServiceImpl implements RetrieveFAHomeMemberTraining {

  // STGAP00010495: Changed training hours completed to a double
  private double trngHrsCompletedInCurrentYr = 0;

  // STGAP00010495: Training hours completed in previous year
  private double trngHrsCompletedInPreviousYr = 0;

  // STGAP00010495: Changed training hours remaining to a double
  private double trngHrsRemainInCurrentYr = 0;

  private int trngHrsRequiredInCurrentYr = 0;

  private FaIndivTrainingDAO faIndivTrainingDAO = null;

  private ResourceHistoryDAO resourceHistoryDAO = null;

  public void setFaIndivTrainingDAO(FaIndivTrainingDAO faIndivTrainingDAO) {
    this.faIndivTrainingDAO = faIndivTrainingDAO;
  }

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  public CFAD32SO retrieveFAHomeMemberTraining(CFAD32SI cfad32si) throws ServiceException {

    CFAD32SO cfad32so = new CFAD32SO();
    cfad32so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());

    CFAD32SOG00_ARRAY cfad32sog00_array = new CFAD32SOG00_ARRAY();

    // STGAP00010494 - get the current date
    Date currentDate = new Date();
    int currentYear = DateHelper.getYear(currentDate);
    int lastYear = currentYear - 1;

    // clss57d
    // List<FaIndivTraining> faIndivTrainingList =
    // faIndivTrainingDAO.findFaIndivTrainingByIdPerson(cfad32si.getUlIdPerson());
    List<Map> faIndivTrainingList = faIndivTrainingDAO.findFaIndivTrainingByIdPerson(cfad32si.getUlIdPerson());
    if (faIndivTrainingList != null) {
      // Iterator<FaIndivTraining> it = faIndivTrainingList.iterator();
      Iterator<Map> it = faIndivTrainingList.iterator();

      // for (Iterator<FaIndivTraining> it = faIndivTrainingList.iterator(); it.hasNext();) {
      trngHrsCompletedInCurrentYr = 0;
      trngHrsRemainInCurrentYr = 0;

      // STGAP00010494 - Reset training hours completed in previous year
      trngHrsCompletedInPreviousYr = 0;

      // STGAP00010494 - Updated to call findMaxEffectiveDateByHOmeStatusIdPerson
      Date faHomeApprovedDate = resourceHistoryDAO.findMaxEffectiveDateByHomeStatusIdPerson(cfad32si.getUlIdPerson(),
                                                                                            FA_HOME_STAGE,
                                                                                            FA_HOME_ACTIVE_STATUS);
      // STGAP00010494 - Get required training hours.
      if (faHomeApprovedDate != null && DateHelper.isSameYear(faHomeApprovedDate, currentDate)) {
        trngHrsRequiredInCurrentYr = getRequiredTrngHrs(faHomeApprovedDate);
      } else if (faHomeApprovedDate != null) {
        // STGAP000010494 - Called the new method to get the required training hours
        trngHrsRequiredInCurrentYr = getRequiredTrngHrs(CodesTables.CFAYRTRN_NA);
      } else {
        trngHrsRequiredInCurrentYr = 0;
      }

      while (it.hasNext()) {
        Map row = it.next();
        int indivTrainingId = (Integer) row.get("idIndivTraining");

        CFAD32SOG00 cfad32sog00 = new CFAD32SOG00();
        cfad32sog00.setUlIdIndivTraining(indivTrainingId);
        cfad32sog00.setTsLastUpdate((Date) row.get("dtLastUpdate"));

        String trngType = (String) row.get("cdIndivTrnType");

        cfad32sog00.setSzCdIndivTrnType((String) row.get("cdIndivTrnType"));
        cfad32sog00.setDtDtIndivTrn(DateHelper.toCastorDate((Date) row.get("dtIndivTrn")));
        cfad32sog00.setCIndIndivTrnEc((String) row.get("indIndivTrnEc"));

        cfad32sog00.setLdNbrIndivTrnHrs((Double) row.get("nbrIndivTrnHrs"));

        int trainingSessionNumber = (Integer) row.get("nbrIndivTrnSession");
        cfad32sog00.setSNbrIndivTrnSession(trainingSessionNumber);
        cfad32sog00.setSzTxtIndivTrnTitle((String) row.get("txtIndivTrnTitle"));
        // added following code for Release 2
        cfad32sog00.setLdCdTrain1Role((String) row.get("cdTrain1Role"));
        cfad32sog00.setLdNmTrain1((String) row.get("nmTrain1"));
        cfad32sog00.setLdCdTrain2Role((String) row.get("cdTrain2Role"));
        cfad32sog00.setLdNmTrain2((String) row.get("nmTrain2"));
        cfad32sog00.setLdCdTrain3Role((String) row.get("cdTrain3Role"));
        cfad32sog00.setLdNmTrain3((String) row.get("nmTrain3"));
        cfad32sog00.setLdCdTrain4Role((String) row.get("cdTrain4Role"));
        cfad32sog00.setLdNmTrain4((String) row.get("nmTrain4"));
        cfad32sog00.setLdIndCoTrain((String) row.get("indCoTrain"));
        cfad32sog00.setNmAgency((String) row.get("nmAgency"));

        cfad32sog00_array.addCFAD32SOG00(cfad32sog00);

        // STGAP00010494 - Calculate training hours if FA Home is approved. If
        // FA Home is not approved then Training Hours Completed Current Year defaults
        // to 0 and Training Hours Remaining Current year defaults to 0.
        if (faHomeApprovedDate != null) {

          // STGAP00010494 - Get year and month of FA Home Approval Date
          int faHomeApprovedYear = DateHelper.getYear(faHomeApprovedDate);
          int faHomeApprovedMonth = DateHelper.getMonth(faHomeApprovedDate);

          // added to calculate training hrs.

          Date trainingDate = (Date) row.get("dtIndivTrn");

          // STGAP00010495: Changed training hours to a double and used doubleValue to
          // to return the map entry as a double.
          double trainingHours = ((Double) row.get("nbrIndivTrnHrs")).doubleValue();

          // STGAP00004111: added codes here to make sure we don't add
          // Pre-Cert Pre-Service to total yearly hours
          if (DateHelper.isSameYear(trainingDate, currentDate) && !trngType.equals(CodesTables.CFATRAIN_PRSV)) {
            if (DateHelper.isAfter(trainingDate, faHomeApprovedDate)) {
              trngHrsCompletedInCurrentYr += trainingHours;
            }
          }

          // STGAP00010494: Get training hours completed in November and December of the previous year
          // Pre-Cert and Pre-Service hours are not added to the total yearly hours
          if ((DateHelper.getYear(trainingDate) == lastYear && faHomeApprovedYear == lastYear)
              && !trngType.equals(CodesTables.CFATRAIN_PRSV)) {
            if (faHomeApprovedMonth == Calendar.NOVEMBER || faHomeApprovedMonth == Calendar.DECEMBER) {
              int trainingMonth = DateHelper.getMonth(trainingDate);
              if (trainingMonth == Calendar.NOVEMBER || trainingMonth == Calendar.DECEMBER) {
                if (DateHelper.isAfter(trainingDate, faHomeApprovedDate)) {
                  trngHrsCompletedInPreviousYr += trainingHours;
                }
              }
            }
          }
        } // End FA Home Approval Date check

      }// while

      double trngHrsCompleted = trngHrsCompletedInCurrentYr + trngHrsCompletedInPreviousYr;
      trngHrsRemainInCurrentYr = (double) trngHrsRequiredInCurrentYr - trngHrsCompleted;
      if (trngHrsRemainInCurrentYr < 0)
        trngHrsRemainInCurrentYr = 0;
    }
    cfad32so.setCFAD32SOG00_ARRAY(cfad32sog00_array);
    cfad32so.setTrngHrsCompleted(trngHrsCompletedInCurrentYr);
    cfad32so.setTrngHrsRemain(trngHrsRemainInCurrentYr);
    return cfad32so;
  }

  // STGAP000010494 - Updated this method to call a common method that uses the
  // the code table.

  /**
   * This method gets the required training hours using the approved date
   * 
   * @param approvedDate
   * @return
   */
  private int getRequiredTrngHrs(Date approvedDate) {

    int approvedMonth;
    String szRequiredTrngHrsCode;

    // DateHelper uses Calendar.MONTH, which returns zero-based values (i.e. 0=January, 1=February, etc.)
    approvedMonth = DateHelper.getMonth(approvedDate) + 1;
    if (approvedMonth > 9) {
      szRequiredTrngHrsCode = String.valueOf(approvedMonth);
    } else {
      szRequiredTrngHrsCode = "0" + String.valueOf(approvedMonth);
    }

    int requiredTrngHrs = getRequiredTrngHrs(szRequiredTrngHrsCode);

    return requiredTrngHrs;
  }

  // STGAP000010494 - Added this method

  /**
   * This method getS the required training hours using the training hours code. The training hours codes are specified
   * in FA /Homes Required Training Hours category (CAYAYRTN) in the CODES_TABLES.
   * 
   * @param szTrngHrsCode
   * @return
   */
  private int getRequiredTrngHrs(String szTrngHrsCode) {

    String szRequiredTrngHrs = Lookup.simpleDecodeSafe(CodesTables.CFAYRTRN, szTrngHrsCode);

    if (StringHelper.EMPTY_STRING.equals(szRequiredTrngHrs)) {
      szRequiredTrngHrs = "0";
    }

    return Integer.parseInt(szRequiredTrngHrs);
  }

}
