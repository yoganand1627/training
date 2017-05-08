package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.PaymentOfCare;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface PaymentOfCareDAO {
  
  /**
   * Find the current approved payment of care for a specific child from specific list of cdPocType(s) 
   * with a POC end date later than today's date and has not been terminated
   * 
   * @param idPerson
   * @return PaymentOfCare
   */
  Object[] findPaymentOfCareApprovedByIdPersonByindConcurrentForPerDiem(int idPerson);
  
  /**
   * Find the current approved payment of care for a specific child from specific list of cdPocType(s) 
   * with a POC end date later than today's date and has not been terminated
   * 
   * @param idPerson
   * @return PaymentOfCare
   */
  Date findPaymentOfCareDateApprovedByIdPersonByindConcurrentForPerDiem(int idPerson);
  
  /**
   * Retrieve a Payment of Care row by idPocEvent
   *
   * @param idEvent
   * @return PaymentOfCare
   */
  @SuppressWarnings({"unchecked"})
  PaymentOfCare findPOC(int idPocEvent);

  /**
   * Inserts/updates an entire row of Payment_of_Care table.
   *
   * @param poc
   */
  void savePOC(PaymentOfCare poc);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.Ppt} object.
   *
   * @param ppt
   */
  int deletePOC(int idPocEvent);
  /**
   * Retrieve a Payment of Care  row by idStage and Placement start date
   *
   * @param idEvent
   * @return PlanParticipant
   */
  @SuppressWarnings({"unchecked"})
  String findPlcmtPOCByIdStageandStartDate(int idStage, Date dtPlcmtStart);


  
  /**
   * Finds ant existing end and terminate dates on the PAYMENT_OF_CARE table for the person
   * 
   * @param idPerson
   * @return Map
   */
  List<Map> findEndAndTerminateDateByIdPerson(int idPerson, String indConcurrent, int idCurrentPoc);

  /**
   * Find the current approved payment of care for a specific child from specific list of cdPocType(s) 
   * with a POC end date later than today's date and has not been terminated
   * 
   * @param idPerson
   * @param cdPocTypes
   * @param todayDate
   * @return PaymentOfCare
   */
  PaymentOfCare findPaymentOfCareApprovedByIdPersonByCdPocTypes( int idPerson, 
                                                                      Collection<String> cdPocTypes,
                                                                      Date todayDate);
  
  
  /**
   * Finds the most recent approved payment of care in the FCC stage for a specific child from specific list of cdPocType(s) 
   * 
   * @param idPerson
   * @param cdPocTypes
   * @return PaymentOfCare
   */
  PaymentOfCare findMostRecentApprovedPOCInFCC( int idPerson, Collection<String> cdPocTypes);
    
  
  
  /**
   * Find the current approved payment of care for a specific child from specific list of cdPocType(s) 
   * with a POC end date later than today's date and has not been terminated
   * 
   * @param idPerson
   * @param cdPocTypes
   * @param todayDate
   * @param idStage
   * @return PaymentOfCare
   */
  PaymentOfCare findPaymentOfCareApprovedByIdPersonByCdPocTypesByStage( int idPerson, 
                                                                               Collection<String> cdPocTypes,
                                                                               Date todayDate, 
                                                                               int idStage);
  /**
   * Find the current approved payment of care for a specific child from specific list of cdPocType(s) 
   * with a POC end date later than today's date and has not been terminated
   * 
   * @param idPerson
   * @param cdPocTypes
   * @param todayDate
   * @return PaymentOfCare
   */
  PaymentOfCare findPaymentOfCareApprovedByIdPersonByindConcurrent( int idPerson, 
                                                                    String indConcurrent, Date todayDate, int idStage);
  
  /**
   * Find the current payment of care 
   * 
   * @param idPerson
   * @param todayDate
   * @return PaymentOfCare
   */
  PaymentOfCare findMostRecentPaymentOfCareByIdPerson( int idPerson, Date todayDate);
  
  /**
   * Find the current payment of care and stage
   * 
   * @param idPerson
   * @param todayDate
   * @param idStage
   * @return PaymentOfCare
   */
  PaymentOfCare findMostRecentPaymentOfCareByIdPersonAndStage(int idPerson, Date todayDate, int idStage);
  
  /**
   * Find number of Foster care type Payment of cares
   * @param indConcurrent
   * @param idStage
   * @param idPlcmtChild
   * @return count
   */ 
  Long countFcPaymentOfcare(String indConcurrent, int idStage, int idPlcmtChild);
  
  /**
   * Find number of RBWO type Payment of cares
   * @param indConcurrent
   * @param idStage
   * @param idPlcmtChild
   * @return count
   */ 
  Long countRbwoPaymentOfcare(String indConcurrent, int idStage, int idPlcmtChild);
  
  /**
   * Find number of subsidized type Payment of cares
   * @param indConcurrent
   * @param idStage
   * @param idPlcmtChild
   * @return count
   */ 
  Long countSubPaymentOfcare(String indConcurrent, int idStage, int idPlcmtChild);
  
  /**
   * Find the non current approved payment of care for a specific child from specific list of cdPocType(s) 
   * with a POC end date later than today's date and has not been terminated.
   * 
   * @param idPerson
   * @param cdPocTypes
   * @param todayDate
   * @return PaymentOfCare
   */
  PaymentOfCare findPaymentOfCareApprovedByIdPersonByNonConcurrent( int idPerson, Date plcmtStartDate, int idStage);
  
  /**
   * Find the current approved payment of care for a specific child from Foster care POCs  
   * with a POC end date later than today's date and has not been terminated
   * 
   * @param idPerson
   * @param cdPocTypes
   * @param todayDate
   * @return PaymentOfCare
   */
  PaymentOfCare findFcPaymentOfCareApprovedByIdPersonByindConcurrent( int idPerson, 
                                                                    String indConcurrent, Date todayDate, int idStage);
  /**
   * Find the current approved payment of care for a specific child from RBWO POCs
   * 
   * @param idPerson
   * @param cdPocTypes
   * @param todayDate
   * @return PaymentOfCare
   */
  PaymentOfCare findRbwoPaymentOfCareApprovedByIdPersonByindConcurrent( int idPerson, 
                                                                    String indConcurrent, Date todayDate, int idStage);
  /**
   * Find the current approved payment of care for a specific child from Subsidized POCs 
   * 
   * @param idPerson
   * @param cdPocTypes
   * @param todayDate
   * @return PaymentOfCare
   */
  PaymentOfCare findSubPaymentOfCareApprovedByIdPersonByindConcurrent( int idPerson, 
                                                                    String indConcurrent, Date todayDate, int idStage);

  /**
   * Find number of Non relative subsidized type Payment of cares
   * @param indConcurrent
   * @param idStage
   * @param idPlcmtChild
   * @return count
   */ 
  Long countNrpSubPaymentOfcare(String indConcurrent, int idStage, int idPlcmtChild);
  
  /**
   * Finds start and existing end and terminate dates on the PAYMENT_OF_CARE table for the person
   * 
   * @param idPerson
   * @return Map
   */
  List<Map> findEndAndTerminateDateByIdPerson(int idPerson, int idCurrentPoc);
  
  /**
   * Find the current approved payment of care for a specific child from Subsidized POCs 
   * 
   * @param idPerson
   * @param idStage
   */
  PaymentOfCare findPaymentOfCareByIdPersonByIdStage( int idPerson,int idStage, Date plcmtEnd, 
                                                            String indCCI, String szPlcmtTempType);
  
  PaymentOfCare findPaymentOfCareByIdPersonIdStage( int idPerson, int idStage);


}
