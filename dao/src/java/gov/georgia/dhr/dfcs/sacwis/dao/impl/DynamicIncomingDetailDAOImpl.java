package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicIncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class DynamicIncomingDetailDAOImpl extends DynamicBaseDAOImpl implements DynamicIncomingDetailDAO {

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Map> findIncomingDetailByIdName(int pageNbr, int pageSize,
                                                                String cdStageClassification,
                                                                Collection<String> cdCityList,
                                                                String cdIncomingCallerCounty, String cdIncmgRegion,
                                                                String cdIncomingDisposition,
                                                                String cdStageCurrPriority,
                                                                String nbrIncmgUnit, Date dtIncomingCallFrom,
                                                                Date dtIncomingCallTo,
                                                                String cdIncmgAllegType, Collection<Integer> idStags) {
    if( (cdCityList == null || allNullArgs(cdCityList.toArray())) &&
        (idStags == null || allNullArgs(idStags.toArray())) &&
        allNullArgs(cdStageClassification, cdIncomingCallerCounty, cdIncmgRegion, cdIncomingDisposition,
                                  cdStageCurrPriority, nbrIncmgUnit, cdIncmgAllegType) &&
        oneNullArg(dtIncomingCallFrom, dtIncomingCallTo) ) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    Criteria criteria = getSession().createCriteria(IncomingDetail.class, "id");
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("id.nmIncomingCallerFirst").as("nmIncomingCallerFirst"));
    projectionList.add(Projections.property("id.nmIncomingCallerMiddle").as("nmIncomingCallerMiddle"));
    projectionList.add(Projections.property("id.nmIncomingCallerLast").as("nmIncomingCallerLast"));
    projectionList.add(Projections.property("id.cdIncomingDisposition").as("cdIncomingDisposition"));
    projectionList.add(Projections.property("id.dtIncomingCall").as("dtIncomingCall"));
    projectionList.add(Projections.property("id.cdIncomingCallerCounty").as("cdIncomingCallerCounty"));
    projectionList.add(Projections.property("id.addrIncomingCallerCity").as("addrIncomingCallerCity"));
    projectionList.add(Projections.property("id.nmIncmgWorkerName").as("nmIncmgWorkerName"));
    projectionList.add(Projections.property("id.idStage").as("idStage"));
    projectionList.add(Projections.property("id.employee.idPerson").as("idIncomingWorker"));
    projectionList.add(Projections.property("id.indIncmgSensitive").as("indIncmgSensitive"));
    projectionList.add(Projections.property("id.indIncmgIntInvClsReclass").as("indIncmgIntInvClsReclass"));

    criteria.setProjection(projectionList);
    criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

    if (StringHelper.isValid(cdStageClassification) || StringHelper.isValid(cdStageCurrPriority)) {
      criteria.createAlias("id.stage", "s", Criteria.INNER_JOIN);
      if (StringHelper.isValid(cdStageClassification)) {
        criteria.add(Restrictions.eq("s.cdStageClassification", cdStageClassification));
      }
      if (StringHelper.isValid(cdStageCurrPriority)) {
        criteria.add(Restrictions.eq("s.cdStageCurrPriority", cdStageCurrPriority));
      }
    }
    if (idStags != null && idStags.size() > 0) {
      criteria.add(Restrictions.in("id.stage.idStage", idStags));
    }
    if (cdCityList != null && cdCityList.size() > 0) {
      criteria.add(Restrictions.in("id.addrIncomingCallerCity", cdCityList));
    }
    if (StringHelper.isValid(cdIncomingCallerCounty)) {
      criteria.add(Restrictions.eq("id.cdIncomingCallerCounty", cdIncomingCallerCounty));
    }
    if (StringHelper.isValid(cdIncmgRegion)) {
      criteria.add(Restrictions.eq("id.cdIncmgRegion", cdIncmgRegion));
    }
    if (StringHelper.isValid(cdIncomingDisposition)) {
      criteria.add(Restrictions.eq("id.cdIncomingDisposition", cdIncomingDisposition));
    }
    if (StringHelper.isValid(nbrIncmgUnit)) {
      criteria.add(Restrictions.eq("id.nbrIncmgUnit", nbrIncmgUnit));
    }
    if (StringHelper.isValid(cdIncmgAllegType)) {
      criteria.add(Restrictions.eq("id.cdIncmgAllegType", cdIncmgAllegType));
    }

    if (!DateHelper.isNull(dtIncomingCallFrom) && !DateHelper.isNull(dtIncomingCallTo)) {
      criteria.add(Restrictions.between("id.dtIncomingCall", dtIncomingCallFrom, dtIncomingCallTo));
    }

    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, criteria);
  }

}
