package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.PaymentOfCareSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01;

import java.util.Date;


public interface SavePaymentOfCare {
  public static final String PRIMARY_CHILD = "PC";
  PaymentOfCareSaveSI savePaymentOfCare (PaymentOfCareSaveSI paymentOfCareSave);
  /**
   * This method checks whether the payment of care being saved overlaps with other existing payments in Adoption 
   * and Foster Care Child, open or closed. New payment is allowed to start the same day previous one ended. If 
   * previous payment starts and ends the same day, the next one could start the same day that previous starts 
   * and ends.
   * Payment is overlapping when:
   * <ul> <li>New payment's start date is between start and end date of any existing payment
   * </li> <li>New payment's start date is after existing, open payment's start datte
   * </li> <li>New payment's start date is before existing payment start date but new payment's end date is after 
   * exisiting payment's start date</li></ul>
   * @param idPocEvent: id of new payment of care
   * @param startDate: new payment of care's start date
   * @param endDate: new payment of care's end date
   * @param idStage: id of current stage to obtain id person of primary child
   * @param indConcurrent: indicator whether payment of care being looked at is of type Concurrent
   * @return integer return codes:
   * <ul> <li>0: no overlapping
   * <ul> <li>1: overlapping occurs, see Conversation for more determination factor
   * <ul> <li>2: overlapping occurs, see Conversation for more determination factor</li></ul>
   */
  int checkStartDateOverlapsEndDate(int idPocEvent, Date startDate, Date endDate, int idStage, String indConcurrent);
  boolean isRelativeCareApproved(int idPerson, int idStage); 
  boolean isRelativeCareAssessmentApproved( int idStage); //SMS#108265
  ROWCSUB45SOG01 findLegalStatus(int idStage, Date dtEffDate);
  boolean childHasDob(int idPerson); 
}