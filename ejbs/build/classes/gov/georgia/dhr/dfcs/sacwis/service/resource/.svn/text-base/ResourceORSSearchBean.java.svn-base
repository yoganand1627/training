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
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceORSSearchDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceORSSearchValueBean;

/**
 * This ResourceORSSearchEJB class is used to conduct ORS resource searches.
 *
 * @author ssubram, March 12, 2008
 * @stereotype SessionBean
 * @remoteInterface gov.georgia.dhr.dfcs.sacwis.service.resource.ResourceORSSearch
 * @homeInterface gov.georgia.dhr.dfcs.sacwis.service.resource.ResourceORSSearchHome
 * @statemode Stateless
 */
public class ResourceORSSearchBean extends BaseServiceEjb implements SessionBean {
  public static final String TRACE_TAG = "ResourceORSSearchEjb";

  /** Search for ORS Resources given the specified parameters. */
  public PaginationResultBean searchORSResources(ResourceORSSearchValueBean resourceORSSearchDB)
          throws SQLException, ResourceActivityException, TooManyRowsReturnedException {
    GrndsTrace.enterScope(TRACE_TAG + ".searchORSResources");
    Connection connection = null;

    try {
      connection = JdbcHelper.getConnection();
      ResourceORSSearchDAO dataAccessor = new ResourceORSSearchDAO(connection);
      return dataAccessor.executeSearch(resourceORSSearchDB);
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

