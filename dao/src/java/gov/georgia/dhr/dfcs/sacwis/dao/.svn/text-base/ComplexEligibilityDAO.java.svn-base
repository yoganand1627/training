package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;

public interface ComplexEligibilityDAO {
  /**
   * Inserts a new row in the Eligibility table.  New record could be: 1. NON-BLOC type:  Just insert it in directly
   * regardless if any record exists with the same ID_PERSON. 2. BLOC type:  a. No record exists of BLOC type.  Then
   * this is a brand new record.  Just insert it into the chain. b. BLOC records exists, but this new record passes all
   * validation.  Just insert it into the chain
   *
   * @param indPrfrmValidation
   * @param indGeneric
   * @param eligibility
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public void insertEligibility(String indPrfrmValidation, String indGeneric, Eligibility eligibility)
          throws ServiceException;

  /**
   * Update an existing record.  New dates (Start, End) could be either 'shrinking' or 'expanding': +-----+ +----------+
   * +-----+ |     |  <------o--->  <---o------>  |     | +-----+         +----------+ +-----+
   *
   * @param indPrfrmValidation
   * @param eligibility
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public void updateEligibility(String indPrfrmValidation, Eligibility eligibility) throws ServiceException;
}
