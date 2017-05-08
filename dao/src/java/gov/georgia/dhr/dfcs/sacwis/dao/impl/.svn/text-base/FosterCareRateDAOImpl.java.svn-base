package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.FosterCareRateDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FosterCareRate;
import org.hibernate.Query;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

/**
 * This is the DAO retrieves the Foster Care Rate record from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User       Description
 *   --------  ---------  --------------------------------------------------
 *   10/17/08 alwilliams  STGAP00009397: Converted the foster care rate start date to a 
 *                        castor date object. The conversion stripped off the time component. 
 *                        Converted the stripped castor date object to a Java date object.                      
 *                       
 *                       
 * </pre>
 */
public class FosterCareRateDAOImpl extends BaseDAOImpl implements FosterCareRateDAO {
  public FosterCareRate findFosterCareRateByAgeDateRangeAndService(String cdAgeRange, Date dtFcareRtStart, String cdFcareRateService){
    

    Query query = getSession().createQuery(" from FosterCareRate " +
                                           " where dtFcareRtStart <= :dtFcareRtStart " +
                                           " and dtFcareRtEnd >= :dtFcareRtStart " + 
                                           " and cdAgeRange = :cdAgeRange " + 
                                           " and cdFcareRateService = :cdFcareRateService ");
    
    // STGAP00009397 - Convert java date to a castor date to strip off the time
    org.exolab.castor.types.Date cdtFcareRtStart = DateHelper.toCastorDate(dtFcareRtStart);
    
    query.setTimestamp("dtFcareRtStart", DateHelper.toJavaDate(cdtFcareRtStart));
    query.setString("cdAgeRange", cdAgeRange);
    query.setString("cdFcareRateService",cdFcareRateService);
    return (FosterCareRate) firstResult(query);
  }
}
