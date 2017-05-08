package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AaFunding;

import org.hibernate.Query;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 10/02/11  hnguyen                  STGAP00017011: MR-092 Added new method findLatestValidatedAAFundingByIdChild.
 * 11/01/11  hnguyen                  STGAP00017465: MR-092 Updated findLatestValidatedAAFundingByIdChild query to 
 *                                    sort also by event id desc if date validate are the same.
 * 11/09/11  hnguyen                  STGAP00017622: MR-092 Updated findLatestValidatedAAFundingByIdChildByIdStage query 
 * 11/01/11  hjbaptiste               STGAP00017484: In findAAfundingByIdEvent(), join fetching the Employee record
 * 03/12/12  arege                    STGAP00018020: Added method to find latest AAFundingSummary of type IVE or PST
 * </pre>
 *
 * @author Herve Jean-Baptiste, September 02, 2011
 */

public class AaFundingDAOImpl extends BaseDAOImpl implements AaFundingDAO {

  public AaFunding findAAfundingByIdEvent(int idAaFundingEvent) {
    Query query = getSession().createQuery("     from AaFunding aaf join fetch aaf.employee "
                                           + "    where aaf.event.idEvent = :idAaFundingEvent ");
    query.setInteger("idAaFundingEvent", idAaFundingEvent);
    return (AaFunding) query.uniqueResult();
  }

  public AaFunding findLatestValidatedAAFundingByIdChildByIdStage(int idChild, int idStage) {
    Query query = getSession().createQuery(" from AaFunding aaf "
                                           + " where aaf.event.cdEventStatus = 'APRV' "
                                           + " and aaf.child.idPerson = :idChild "
                                           + " and aaf.dtAaFundingValidated is not null "
                                           + " and aaf.event.stage.idStage = :idStage "
                                           + " order by aaf.dtAaFundingValidated desc, aaf.event.idEvent desc ");
    query.setInteger("idChild", idChild);
    query.setInteger("idStage", idStage);
    return (AaFunding) firstResult(query);
  }
  
  public AaFunding findLatestValidatedIVEOrPSTAAFundingByIdChildByIdStage(int idChild, int idStage) {
    Query query = getSession().createQuery(" from AaFunding aaf "
                                           + " where aaf.event.cdEventStatus = 'APRV' "
                                           + " and aaf.child.idPerson = :idChild "
                                           + " and aaf.cdAaFundingType in ('IVE', 'PST') "
                                           + " and aaf.dtAaFundingValidated is not null "
                                           + " and aaf.event.stage.idStage = :idStage "
                                           + " order by aaf.dtAaFundingValidated desc, aaf.event.idEvent desc ");
    query.setInteger("idChild", idChild);
    query.setInteger("idStage", idStage);
    return (AaFunding) firstResult(query);
  }
  
  public void saveAaFunding(AaFunding aaFunding) {
    getSession().saveOrUpdate (aaFunding);

  }

  public void deleteAaFunding(AaFunding aaFunding) {
    getSession().delete(aaFunding);

  }

}
