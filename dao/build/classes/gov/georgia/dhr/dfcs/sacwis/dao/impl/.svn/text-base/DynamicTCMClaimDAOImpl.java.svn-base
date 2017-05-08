package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicTCMClaimDAO;
import gov.georgia.dhr.dfcs.sacwis.db.TcmClaim;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * <pre>
 * Change History:
 * Date        User      Description
 * ----------  --------  --------------------------------------------------
 * 03/27/09    Van Vo    MR-026 STGAP00013024: search county based on staff county, when staff is in regional
 *                       unit (state office or county -none-) then search on stage county
 *                       
 * </pre>
 */

public class DynamicTCMClaimDAOImpl extends DynamicBaseDAOImpl implements DynamicTCMClaimDAO {

  @SuppressWarnings( { "unchecked" })
  public List<TcmClaim> findTCMClaims(int idStaff, int idPerson, Date dtStart, Date dtEnd, String status,
                                      String county, String unit) {
    if (allNullArgs(idStaff, idPerson, dtStart, dtEnd, status, county, unit)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Criteria criteria = getSession().createCriteria(TcmClaim.class, "tc");
    boolean staffAliasCreated = false;
    if (idStaff > 0) {
      staffAliasCreated = true;
      criteria.createAlias("tc.personByIdStaff", "pr");
      criteria.add(Restrictions.eq("pr.idPerson", idStaff));
    }
    if (idPerson > 0) {
      criteria.createAlias("tc.personByIdPerson", "ps");
      criteria.add(Restrictions.eq("ps.idPerson", idPerson));
    }
    if (!DateHelper.isNull(dtStart)) {
      criteria.add(Restrictions.ge("tc.dtService", dtStart));
    }
    if (!DateHelper.isNull(dtEnd)) {
      criteria.add(Restrictions.lt("tc.dtService", dtEnd));
    }
    if (StringHelper.isValid(status)) {
      criteria.add(Restrictions.eq("tc.cdStatus", status));
    } else {// MR-026: STGAP00013024: unless searched by non re-billable status, do not display those
      criteria.add(Restrictions.ne("tc.cdStatus", CodesTables.CTCMSTAT_NRB));
    }
    
    // MR-026: STGAP00013024
    boolean stageAliasCreated = false;
    String[] regional_county_list = { CodesTables.CCOUNT_XXX, CodesTables.CCOUNT_999 };
    if (StringHelper.isValid(county)) {
      criteria.createAlias("tc.stage", "st");
      stageAliasCreated = true;
      if (!staffAliasCreated) {
        staffAliasCreated = true;
        criteria.createAlias("tc.personByIdStaff", "pr");
      }
      criteria.createAlias("pr.employee", "pr_emp");
      criteria.createAlias("pr_emp.unit", "pr_emp_unit");
      criteria.add(Restrictions.or(Restrictions.and(Restrictions.eq("pr_emp_unit.cdCounty", county),
                                                    Restrictions.ne("pr_emp_unit.cdCounty", CodesTables.CCOUNT_XXX)),
                                   Restrictions.and(Restrictions.in("pr_emp_unit.cdCounty", regional_county_list),
                                                    Restrictions.eq("st.cdStageCnty", county))));
    }
    // end MR-026: STGAP00013024
    if (StringHelper.isValid(unit)) {
      if (!stageAliasCreated) {
        stageAliasCreated = true;
        criteria.createAlias("tc.stage", "st");
      }
      criteria.createAlias("st.unit", "stu");
      criteria.add(Restrictions.eq("stu.nbrUnit", unit));
    }
    criteria.addOrder(Order.asc("tc.dtService"));
    return (List<TcmClaim>) criteria.list();
  }

}
