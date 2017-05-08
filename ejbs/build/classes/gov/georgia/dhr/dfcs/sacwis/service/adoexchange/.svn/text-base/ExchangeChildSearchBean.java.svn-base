package gov.georgia.dhr.dfcs.sacwis.service.adoexchange;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeChildSearchDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeChildValueBean;

import java.sql.Connection;

import javax.ejb.SessionBean;

import org.grnds.facility.log.GrndsTrace;

public class ExchangeChildSearchBean extends BaseServiceEjb implements SessionBean {

  public static final String TRACE_TAG = "ExchangeChildSearchBean";

  public PaginationResultBean searchExchangeChild(ExchangeChildValueBean exchangeChildValueBeanIn) throws TooManyRowsReturnedException {
    GrndsTrace.enterScope(TRACE_TAG + ".searchExchangeChild function");
    
    Connection connection = null;

    try {
      connection = JdbcHelper.getConnection();

      ExchangeChildSearchDAO exchangeChildSearchDao = new ExchangeChildSearchDAO(connection);
      return exchangeChildSearchDao.executeSearch(exchangeChildValueBeanIn);
      
    } catch (TooManyRowsReturnedException t) {
      throw t;
    } catch (Exception e) {
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
  }
}
