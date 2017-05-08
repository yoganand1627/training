package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSubsidyRate;

/**
 * Change History:
 *   Date         User                  Description
 *   --------     -------------------   --------------------------------------
 *   07/01/2009   bgehlot               STGAP00014563: Added the methods findPreAdoptionSubsidyRateByAge and 
 *                                       findPostAdoptionSubsidyRateByAge, findAdoptionSubsidyRateEndDate,
  *                                      findAdoptionSubsidyRateStartDate
 *                                      
 */

public interface AdoSubsidyRateDAO {

  /**
   * This method returns the old Basic Rates which are end dated
   *
   * @param age
   * @param endDate
   * @return AdoSubsidyRate
   */  
  AdoSubsidyRate findPreAdoptionSubsidyRateByAge (int age, Date endDate);
  
  /** 
   * STGAP00014563: This method returns the new Basic Rates not end dated
   * @param age
   * @param startDate
   * @return
   */
  AdoSubsidyRate findPostAdoptionSubsidyRateByAge(int age, Date startDate); 
  
  /** 
   * STGAP00014563: This method returns the end date
   * @return
   */
  Date findAdoptionSubsidyRateEndDate();
  
  /** 
   * STGAP00014563: This method returns the start date
   * @return
   */
  Date findAdoptionSubsidyRateStartDate();
}
