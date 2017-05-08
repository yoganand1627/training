package gov.georgia.dhr.dfcs.sacwis.service.adoexchange;


import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeChildValueBean;

public interface ExchangeChildSearch {
  public PaginationResultBean searchExchangeChild(ExchangeChildValueBean exchangeChildValueBean) throws TooManyRowsReturnedException;
}
