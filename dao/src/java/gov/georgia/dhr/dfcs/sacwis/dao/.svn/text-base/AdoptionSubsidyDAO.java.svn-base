package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
                 
 * 05/18/2009  bgehlot           STGAP00013779: MR-050: Added method findActiveAdoptionSubsidyByIdPersonCdAdoptionType,totalNonRecAdoptionSubsidyAmt
 * 06/11/2009 bgehlot            STGAP00014186: Added the method findSpecialServiceForAttachedApp
 * 01/08/2010  mxpatel           STGAP00015702: Added methods for MR-52
 * 02/10/2010  mxpatel           SMS #44084: added method findActiveAdoptionSubsidyByIdPersonCdAdoptionTypeOfSvcAuthDtl
 */

public interface AdoptionSubsidyDAO {
  /**
   * Find IdAdptSubPerson by idAdptSub
   *
   * @param adptSubPerson
   * @param dtAdptSubEffective
   * @param dtAdptSubEnd
   * @param idAdptSub
   * @return The idAdptSubPerson if it exists.
   */
  Integer findIdAdptSubPersonByIdAdptSub(int adptSubPerson, Date dtAdptSubEffective, Date dtAdptSubEnd, int idAdptSub);

  /**
   * Find AdoptionSubsidy by idAdptSub
   *
   * @param idAdptSub
   * @return The AdoptionSubsidy if it exists.
   */
  AdoptionSubsidy findAdptSubByIdAdptSub(int idAdptSub);
  
  /**
   * Find IdPerson By AdptSub and CdApdtSubCloseRsn
   *
   * @param adptSubPerson
   * @param dtAdptSubEffective
   * @param dtAdptSubEnd
   * @param idAdptSub
   * @return The idPerson for the given criteria.
   */
  Integer findIdPersonByAdPtSubAndCdAdptSubCloseRsn(int adptSubPerson, Date dtAdptSubEffective, Date dtAdptSubEnd,
                                                    int idAdptSub);

  /**
   * Find AdptSubPerson By IdAdptSub
   *
   * @param idAdptSub
   * @param dtAdptSubEnd
   * @param dtAdptSubEffective
   * @param adptSubPerson
   * @return The idPerson for the given criteria
   */
  Integer findAdptSubPersonByIdAdptSub(int idAdptSub, Date dtAdptSubEnd, Date dtAdptSubEffective, int adptSubPerson);

  /**
   * Find IdPerson by AdptSubPerson
   *
   * @param adptSubPerson
   * @param dtAdptSubEffective
   * @param dtAdptSubEnd
   * @return The idPerson for the given criteria.
   */
  Integer findIdPersonByAdptSubPerson(int adptSubPerson, Date dtAdptSubEffective, Date dtAdptSubEnd);

  /**
   * Find IdPerson by CdApdtSubCloseRsn
   *
   * @param adptSubPerson
   * @param dtAdptSubEffective
   * @param dtAdptSubEnd
   * @return The idPerson for the given criteria.
   */
  Integer findIdPersonByCdAdptSubCloseRsn(int adptSubPerson, Date dtAdptSubEffective, Date dtAdptSubEnd);

  /**
   * Find IdPerson By AdptSubEnd
   *
   * @param adptSubPerson
   * @param dtAdptSubEffective
   * @param dtAdptSubEnd
   * @return The idPerson for the given criteria.
   */
  Integer findIdPersonByDtAdptSubEnd(int adptSubPerson, Date dtAdptSubEffective, Date dtAdptSubEnd);

  /**
   * Retrieves a row from the AdoptionSubsidy table for each open subsidy for a given idAdptSubPerson.
   *
   * @param idAdptSubPerson
   * @param dtPersonDeath
   * @return List of AdoptionSubsidy by idAdptSubPerson and dtPersonDeath
   */
  @SuppressWarnings({"unchecked"})
  List<AdoptionSubsidy> findListOfOpenAdoptionSubsidyByIdAdptSubPersonAndDtAdptSubEnd(int idAdptSubPerson,
                                                                                      Date dtPersonDeath);

  /**
   * Retrieves idAdptSubPerson from AdoptionSubsidy given idAdptSubPerson, idAdptSub, cdAdptAudDeterm, dtCurrStart, and
   * dtAdptSubEffective
   *
   * @param idAdptSubPerson
   * @param idAdptSub
   * @param cdAdptAudDeterm
   * @param dtCurrStart
   * @param dtAdptSubEffective
   */
  Integer findIdAdptSubPersonByDtAdptSubEndLessEqlDtCurrStartAndGrtrDtAdptSubEffective(int idAdptSubPerson,
                                                                                       int idAdptSub,
                                                                                       String cdAdptAudDeterm,
                                                                                       Date dtCurrStart,
                                                                                       Date dtAdptSubEffective);

  /**
   * Retrieves idAdptSubPerson from AdoptionSubsidy given idAdptSubPerson, idAdptSub, cdAdptAudDeterm, dtCurrEnd, and
   * dtAdptSubEnd
   *
   * @param idAdptSubPerson
   * @param idAdptSub
   * @param cdAdptAudDeterm
   * @param dtCurrEnd
   * @param dtAdptSubEnd
   */
  Integer findIdAdptSubPersonByDtAdptSubEffectiveGrtrEqlDtCurrEndAndLessDtAdptSubEnd(int idAdptSubPerson, int idAdptSub,
                                                                                     String cdAdptAudDeterm,
                                                                                     Date dtCurrEnd, Date dtAdptSubEnd);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy} object to the database.
   *
   * @param adoptionSubsidy A populated {@link gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy} object.
   */
  int saveAdoptionSubsidy(AdoptionSubsidy adoptionSubsidy);

  Object[] findAdoptionSubsidyByIdAdptSubPerson(Date dtAdptSubEffective, Date dtAdptSubEnd, int adptSubPerson,
                                                Date tsLastUpdate);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy} object.
   *
   * @param adoptionSubsidy
   */
  void deleteAdoptionSubsidy(AdoptionSubsidy adoptionSubsidy);
  
  /**
   * Gets the Adoption Subsidy record for the given Person and the given Adoption Assistance Application
   * event
   * @param idPerson
   * @param idAdoAsstAppEvent
   * @return
   */
  AdoptionSubsidy findAdoptionSubsidyByIdPerson(int idPerson, int idAdoAsstAppEvent);
  
  /**
   * Gets the most recent non-end dated Adoption Subsidy record for the given person  
   * @param idPerson
   * @return
   */
  AdoptionSubsidy findAdoptionSubsidyByIdPerson(int idPerson);
  
  /** 
   * STGAP00013779: Gets the most recent non-end dated Basic Rate and Specialized Rate Adoption Subsidy record for the given person
   * @param idCase  
   * @param idEvent
   * @param idPerson
   * @param cdAdoptionType
   * @return
   */
  Map<String, Object> findActiveAdoptionSubsidyByIdPersonCdAdoptionType(int idCase, int idEvent, int idPerson, 
                                                                        List<String> cdAdoptionType, 
                                                                        Date dtDtAdptSubEffective,
                                                                        Date dtEndTerm) ;
  
  /** 
   * STGAP00013779: Gets the total Amount of Non Recurring Adoption Subsidy record for the given person 
   * @param idCase
   * @param idEvent
   * @param idPerson
   * @param cdAdoptionType
   * @return
   */
  Double totalNonRecAdoptionSubsidyAmt(int idCase, int idPerson, List<String> cdAdoptionType); 
  
  
  /** 
   * STGAP00014186: Find the Special Services adoption subsidy record for the given Adoption Application.
   * @param idSpecialNeedsEvent
   * @return
   */
  Integer findSpecialServiceForAttachedApp(int idSpecialNeedsEvent, int idEvent);
 
  List<AdoptionSubsidy> findActiveAdoptionSubsidyByIdPersonCdAdoptionTypeOfSvcAuthDtl(int idCase, int idPerson,
                                                                                      List<String> cdAdoptionType,
                                                                                      Date dtAdptSubEffective,
                                                                                      Date dtAdptSubEndTerminate,
                                                                                      double amtAdptSub);
  Double getTotalAgreementAmountUsed(int idSpecialNeedsDeter, int idStage, String cdEventStatus,
                                     String cdEventType, String cdPaymentMthd, List<String> cdSpclAsstType);
  
  /**
   * This method finds the most recently approved Adoption Assistance Agreement of certain adoption assistance types
   * @param adptSubPerson - person the adoption assistance is for 
   * @param idCase
   * @param cdAdptSubDeterm - approval types of adoption assistance
   * @param dtDateEffBy - the agreement is effective on this date
   * @return
   */
  List<AdoptionSubsidy> findActiveAdoptionSubsidyByIdCaseIdAdptSubPersonCdAdptSubDetermAndDateEffBy(int idCase, int adptSubPerson, Collection<String> cdAdptSubDeterm, Date dtDateEffBy);
  
  /**
   * This method finds the most recently approved Adoption Assistance Agreement of any adoption assistance type
   * @param adptSubPerson - person the adoption assistance is for 
   * @param idCase
   * @param dtDateEffBy - the agreement is effective on this date
   * @return
   */
  List<AdoptionSubsidy> findActiveAdoptionSubsidyByIdCaseIdAdptSubPersonAndDateEffBy(int idCase, int adptSubPerson, Date dtDateEffBy);
}
