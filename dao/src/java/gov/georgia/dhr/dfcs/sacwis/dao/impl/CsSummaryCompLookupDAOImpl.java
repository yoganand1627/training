package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CsSummaryCompLookupDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CsSummaryCompLookup;

import java.util.List;

import org.hibernate.Query;

/**
 * <pre>
 * Change History:
 * Date        User                     Description
 * --------    ----------------         ----------------------------------------------
 * 03/02/2010  hjbaptiste            Initial creation
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste, March 02, 2010
 */
public class CsSummaryCompLookupDAOImpl extends BaseDAOImpl implements CsSummaryCompLookupDAO {

  @SuppressWarnings("unchecked")
  public CsSummaryCompLookup findCsSummaryCompLookupByMotherFatherCaretaker(String indFather, String indMother, String indCaretaker) {
    Query query = getSession().createQuery(" from CsSummaryCompLookup cs "
                                           + " where cs.indFatherRuleComp = :indFather "
                                           + " and cs.indMotherRuleComp = :indMother "
                                           + " and cs.indCtkRuleComp = :indCaretaker ");
    
    query.setString("indFather", indFather);
    query.setString("indMother", indMother);
    query.setString("indCaretaker", indCaretaker);
    return (CsSummaryCompLookup) query.uniqueResult();
  }
}
