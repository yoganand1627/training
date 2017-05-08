/**
 * Created on Aug 11, 2006 at 11:12:16 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;

import java.util.Date;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/*Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------

08/20/08  mxpatel           STGAP00007052: Added a distinct statement to ensure unique results.  Commented the cdPersonIdType
                            out as it was a duplicate statement.

*/

public class DynamicPersonDAOImpl extends DynamicBaseDAOImpl implements DynamicPersonDAO {
  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Map> findPersonInfoByTypeAndIdStage(int idStage, int type, int pageNbr, int pageSize) {
    if(oneNullArg(idStage, type)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    // In theory, this should probably be separate, but it's so simple and specific that I am leaving it here.
    
  //mxpatel commented this out since dtCallDisposed is never read
    /*SQLQuery query = getSession().createSQLQuery(
            "SELECT NVL(INCOMING_DETAIL.DT_INCOMING_CALL_DISPOSED,:maxDate) as dtCallDisposed " +
            "  FROM INCOMING_DETAIL " +
            " WHERE INCOMING_DETAIL.ID_STAGE=:idStage");
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    query.setInteger("idStage", idStage);
    query.addScalar("dtCallDisposed", Hibernate.DATE);
    Date dtCallDisposed = (Date) firstResult(query);
*/
    //mxpatel commented this out since dtCallDisposed is never read
    
 
    Criteria criteria = getSession().createCriteria(StagePersonLink.class, "spl");
    criteria.createAlias("spl.person", "p", Criteria.INNER_JOIN);
    criteria.createAlias("p.personIds", "pid", Criteria.LEFT_JOIN);
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.distinct(Projections.property("p.idPerson")));//mxpatel added this
    projectionList.add(Projections.property("p.idPerson"), "idPerson");
    projectionList.add(Projections.property("p.nmPersonFull"), "nmPersonFull");
    projectionList.add(Projections.property("p.nbrPersonAge"), "nbrPersonAge");
    projectionList.add(Projections.property("p.dtPersonBirth"), "dtPersonBirth");
    projectionList.add(Projections.property("p.cdPersonSex"), "cdPersonSex");
   projectionList.add(Projections.property("pid.nbrPersonIdNumber"), "nbrPersonIdNumber"); 
    projectionList.add(Projections.property("pid.cdPersonIdType"),"cdPersonIdType");
    projectionList.add(Projections.property("p.dtPersonDeath"), "dtPersonDeath");
    projectionList.add(Projections.property("p.cdPersonDeath"), "cdPersonDeath");
    projectionList.add(Projections.property("p.cdPersonLanguage"), "cdPersonLanguage");
    projectionList.add(Projections.property("p.cdPersonEthnicGroup"), "cdPersonEthnicGroup");
    projectionList.add(Projections.property("p.cdPersonMaritalStatus"), "cdPersonMaritalStatus");
  // projectionList.add(Projections.property("pid.cdPersonIdType"), "cdPersonIdType"); //mxpatel commented this out
    projectionList.add(Projections.property("spl.stage.idStage"), "idStage");
    projectionList.add(Projections.property("spl.cdStagePersRole"), "cdStagePersRole");
    projectionList.add(Projections.property("spl.txtStagePersNotes"), "txtStagePersNotes");
    projectionList.add(Projections.property("spl.cdStagePersRelInt"), "cdStagePersRelInt");
    projectionList.add(Projections.property("spl.cdStagePersType"), "cdStagePersType");
    projectionList.add(Projections.property("spl.indStagePersReporter"), "indStagePersReporter");
    projectionList.add(Projections.property("p.cdPersonReligion"), "cdPersonReligion");
    projectionList.add(Projections.property("p.cdPersonChar"), "cdPersonChar");
    projectionList.add(Projections.property("p.indPersonDobApprox"), "indPersonDobApprox");
    projectionList.add(Projections.property("p.cdPersonLivArr"), "cdPersonLivArr");
    projectionList.add(Projections.property("p.cdPersGuardCnsrv"), "cdPersGuardCnsrv");
    projectionList.add(Projections.property("p.cdPersonStatus"), "cdPersonStatus");
    projectionList.add(Projections.property("p.txtPersonOccupation"), "txtPersonOccupation");
    projectionList.add(Projections.property("p.indPersCancelHist"), "indPersCancelHist");
    projectionList.add(Projections.property("p.dtLastUpdate"), "dtLastUpdate");
    projectionList.add(Projections.property("p.nmPersonFirst"), "nmPersonFirst");
    projectionList.add(Projections.property("p.nmPersonMiddle"), "nmPersonMiddle");
    projectionList.add(Projections.property("p.nmPersonLast"), "nmPersonLast");
    projectionList.add(Projections.property("p.cdPersonSuffix"), "cdPersonSuffix");
    criteria.setProjection(projectionList);
    criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    criteria.add(Restrictions.or(Restrictions.eq("pid.indPersonIdInvalid", ArchitectureConstants.N),
                                 Restrictions.isNull("pid.indPersonIdInvalid")));
    criteria.add(Restrictions.eq("spl.stage.idStage", idStage));
    
    
    //STGAP00009525: Principals are not displaying on intake report
    //Commented out so that the persons having  person_identifiers  records is also displayed on the 
    //Intake Report for Closed intakes.
    /*criteria.add(Restrictions.or(Restrictions.le("pid.dtPersonIdStart", dtCallDisposed),
                                 Restrictions.isNull("pid.dtPersonIdStart")));
    criteria.add(Restrictions.or(Restrictions.ge("pid.dtPersonIdEnd", dtCallDisposed),
                                 Restrictions.isNull("pid.dtPersonIdEnd")));*/
   /* criteria.add(Restrictions.or(Restrictions.eq("pid.cdPersonIdType", CodesTables.CNUMTYPE_SSN),
                                 Restrictions.isNull("pid.cdPersonIdType")));*/
    switch (type) {
      case VICTIM_TYPE:
        criteria.add(Restrictions.eq("spl.cdStagePersType", CodesTables.CPRSNTYP_PRN));
        criteria.add(Restrictions.eq("spl.cdStagePersRole", CodesTables.CROLEALL_VC));
        break;
      case PERPETRATOR_TYPE:
        criteria.add(Restrictions.eq("spl.cdStagePersType", CodesTables.CPRSNTYP_PRN));
        criteria.add(Restrictions.eq("spl.cdStagePersRole", CodesTables.CROLEALL_AP));
        break;
      case OTHER_PRN_TYPE:
        criteria.add(Restrictions.eq("spl.cdStagePersType", CodesTables.CPRSNTYP_PRN));
        criteria.add(Restrictions.ne("spl.cdStagePersRole", CodesTables.CROLEALL_VC));
        criteria.add(Restrictions.ne("spl.cdStagePersRole", CodesTables.CROLEALL_AP));
        criteria.addOrder(Order.asc("spl.cdStagePersRole"));
        break;
      case REPORTER_TYPE:
        criteria.add(Restrictions.eq("spl.indStagePersReporter", ArchitectureConstants.Y));
        break;
      case COLLATERAL_TYPE:
        criteria.add(Restrictions.eq("spl.cdStagePersType", CodesTables.CPRSNTYP_COL));
        criteria.add(Restrictions.or(Restrictions.ne("spl.indStagePersReporter", ArchitectureConstants.Y),
                                     Restrictions.isNull("spl.indStagePersReporter")));
        break;
      default:
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, criteria);
  }
}
