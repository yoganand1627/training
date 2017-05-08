package gov.georgia.dhr.dfcs.sacwis.service.resource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.SessionBean;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceActivityException;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchValueBean;

/**
 * This ResourceSearchEJB class is used to conduct resource searches.
 *
 * @author Sanjay Rana, July 23, 2002
 * @stereotype SessionBean
 * @remoteInterface gov.georgia.dhr.dfcs.sacwis.service.resource.ResourceSearch
 * @homeInterface gov.georgia.dhr.dfcs.sacwis.service.resource.ResourceSearchHome
 * @statemode Stateless
 */
public class ResourceSearchBean extends BaseServiceEjb implements SessionBean {
  public static final String TRACE_TAG = "ResourceSearchEjb";

  /** Search for Resources given the specified parameters. */
  public PaginationResultBean searchResources(ResourceSearchValueBean resourceSearchDB)
          throws SQLException, ResourceActivityException, TooManyRowsReturnedException {
    GrndsTrace.enterScope(TRACE_TAG + ".searchResources");
    Connection connection = null;

    try {
      connection = JdbcHelper.getConnection();
      ResourceSearchDAO dataAccessor = new ResourceSearchDAO(connection);
      return dataAccessor.executeSearch(resourceSearchDB);
    } catch (SQLException sqe) {
      throw sqe;
    } catch (TooManyRowsReturnedException tme) {
      throw tme;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      if (e instanceof RuntimeException) {
        throw (RuntimeException) e;
      }
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
  }
}
