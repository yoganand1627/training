package gov.georgia.dhr.dfcs.sacwis.core.pagination;

import java.util.List;

/**
 * This bean wraps a List of results such that pagination information can be carried with it. It extends the
 * BasePaginationValueBean, which allows for pagination information to bean tied to any bean that extends it.
 *
 * @author Randy O'Neil, December 12, 2001
 */
public class PaginationResultBean extends BasePaginationValueBean {
  public void setResults(List results) {
    this.results = results;
  }

  public List getResults() {
    return this.results;
  }

  List results;
}












