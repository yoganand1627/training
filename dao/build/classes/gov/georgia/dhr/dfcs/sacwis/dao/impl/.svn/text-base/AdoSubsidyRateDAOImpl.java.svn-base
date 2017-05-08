package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoSubsidyRateDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSubsidyRate;

/**
  * Change History:
  *   Date         User                  Description
  *   --------     -------------------   --------------------------------------
  *   07/01/2009   bgehlot               STGAP00014563: Added the methods findPreAdoptionSubsidyRateByAge and 
  *                                      findPostAdoptionSubsidyRateByAge, findAdoptionSubsidyRateEndDate,
  *                                      findAdoptionSubsidyRateStartDate
  */

public class AdoSubsidyRateDAOImpl extends BaseDAOImpl implements AdoSubsidyRateDAO {

  //STGAP00014563: This method returns the old Basic Rates which are end dated
  public AdoSubsidyRate findPreAdoptionSubsidyRateByAge(int age, Date endDate) {
    
    Query query = getSession().createQuery("from AdoSubsidyRate asr " +
                                             " where asr.numMaxAge >= :nbrAge1 " +
                                             " and asr.numMinAge <= :nbrAge2 " +
                                             " and asr.dtAdoSubsidyRateStart >= :minDate " +
                                             " and asr.dtAdoSubsidyRateEnd <= :endDate");
    query.setInteger("nbrAge1", age);
    query.setInteger("nbrAge2", age);
    query.setTimestamp("minDate", DateHelper.MIN_JAVA_DATE);
    query.setTimestamp("endDate", endDate);
    return (AdoSubsidyRate) firstResult(query);
  }
  
  //STGAP00014563: This method returns the new Basic Rates not end dated
  public AdoSubsidyRate findPostAdoptionSubsidyRateByAge(int age, Date startDate) {
    
    Query query = getSession().createQuery("from AdoSubsidyRate asr " +
                                             " where asr.numMaxAge >= :nbrAge1 " +
                                             " and asr.numMinAge <= :nbrAge2 " +
                                             " and asr.dtAdoSubsidyRateStart >= :startDate " +
                                             " and asr.dtAdoSubsidyRateEnd <= :maxDate");
    query.setInteger("nbrAge1", age);
    query.setInteger("nbrAge2", age);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    query.setTimestamp("startDate", startDate);
    return (AdoSubsidyRate) firstResult(query);
  }
  
  //STGAP00014563: This method returns the end date
  public Date findAdoptionSubsidyRateEndDate() {
    
    Query query = getSession().createQuery("select asr.dtAdoSubsidyRateEnd from AdoSubsidyRate asr " +
                                             " where asr.dtAdoSubsidyRateEnd != :maxDate");
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Date) firstResult(query);
  }
  
  //STGAP00014563: This method returns the start date
  public Date findAdoptionSubsidyRateStartDate() {
    
    Query query = getSession().createQuery("select asr.dtAdoSubsidyRateStart from AdoSubsidyRate asr " +
                                             " where asr.dtAdoSubsidyRateStart != :minDate");
    query.setTimestamp("minDate", DateHelper.MIN_JAVA_DATE);
    return (Date) firstResult(query);
  }

}
