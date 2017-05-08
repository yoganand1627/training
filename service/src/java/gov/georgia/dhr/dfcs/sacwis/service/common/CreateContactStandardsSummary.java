package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsSummarySI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsSummarySO;

/** @author Herve Jean-Baptiste, March 01, 2010 */
public interface CreateContactStandardsSummary {

  /**
   * This is the main method that creates the Summary Section on the Contact Standards page. It achieves
   * this by populating a two-dimensional array. The number of rows of the array is the number of children
   * that have a Contact Rule created for them. The number of column is always statically set to 5. For
   * example, if there are 3 children that Parent Contact Rules were created for, the array would look like this:
   * <pre>
   * Child Name  Father(s) Name  Mother(s) Name  Caretaker(s) Name  Complete?
   * [0][0]      [0][1]          [0][2]          [0][3]             [0][4] 
   * [1][0]      [1][1]          [1][2]          [1][3]             [1][4]
   * [2][0]      [2][1]          [2][2]          [2][3]             [2][4]
   * </pre>
   * 
   * @param contactStandardsSummarySI
   * @return ContactStandardsSummarySO
   * @throws ServiceException
   */
  ContactStandardsSummarySO createContactStandardsSummary (ContactStandardsSummarySI contactStandardsSummarySI) throws ServiceException;
}
