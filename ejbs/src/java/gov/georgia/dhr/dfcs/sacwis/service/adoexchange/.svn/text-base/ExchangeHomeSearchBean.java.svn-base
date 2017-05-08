package gov.georgia.dhr.dfcs.sacwis.service.adoexchange;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeHomeSearchDao;
import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeHomeValueBean;

import java.sql.Connection;

import javax.ejb.SessionBean;

import org.grnds.facility.log.GrndsTrace;

public class ExchangeHomeSearchBean extends BaseServiceEjb implements SessionBean {
  public static final String TRACE_TAG = "ExchangeHomeSearchBean";
  
  public PaginationResultBean searchExchangeHome(ExchangeHomeValueBean exchangeHomeValueBeanIn) throws TooManyRowsReturnedException {
    GrndsTrace.enterScope(TRACE_TAG + ".searchExchangeHome function");
    
    Connection connection = null;

    try {
      connection = JdbcHelper.getConnection();

      ExchangeHomeSearchDao exchangeHomeSearchDao = new ExchangeHomeSearchDao(connection);
      return exchangeHomeSearchDao.executeSearch(exchangeHomeValueBeanIn);
      
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
