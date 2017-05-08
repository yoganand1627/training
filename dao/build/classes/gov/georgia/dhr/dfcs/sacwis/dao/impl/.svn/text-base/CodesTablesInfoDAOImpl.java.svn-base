package gov.georgia.dhr.dfcs.sacwis.dao.impl;

/**
 * This DAO contains sqls that retrieves data from the CodesTablesInfo table in the database <p/>
 * 
 * <pre>
 *    Change History:
 *    Date          User          Description
 *    ----------    --------      --------------------------------------------------
 *    07/18/2008    vdevarakonda  Initial class creation           
 * </pre>
 */

import gov.georgia.dhr.dfcs.sacwis.dao.CodesTablesInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTablesInfo;

import java.util.List;

import org.hibernate.Query;

public class CodesTablesInfoDAOImpl extends BaseDAOImpl implements CodesTablesInfoDAO {
  @SuppressWarnings( { "unchecked" })
  public List<CodesTablesInfo> findUpdatableCodeTypes() {

    Query query = getSession().createQuery(" from CodesTablesInfo ");

    return (List<CodesTablesInfo>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public CodesTablesInfo findCodeTypeDetail(String codeType) {

    Query query = getSession().createQuery(" from CodesTablesInfo " + " where codeType = :codeType");
    query.setString("codeType", codeType);
    return (CodesTablesInfo) query.uniqueResult();
  }
}