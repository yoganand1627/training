package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.dao.financials.AdoptionAsstncValueBean;

import org.exolab.castor.types.Date;

/**
 * Remote interface for the AdoptionAsstncEjb.
 * <pre>
 * Change History: Date      User           Description
 * --------  ------------- -------------------------------------------------------------------------------------------
 * 07/10/04  thompswa       SIR 16039 - Edit between start date of assistance and placement accomplished by adding new
 *                          method, getPlacementWithGreatestStartDate( Integer personId ).
 * 09/21/04  thompswa       SIR 23066 - Adoption Assistance amount will now be edited against the ALOC rather than
 *                          BLOC. Basic and moderate LOC is measured from CATHPLOC rather than CBILPLOC codes table.
 *                          Messages and MSG names adjusted.
 * 09/30/04  thompswa       SIR 23131 - Edit between start date of assistance and placement enhanced by adding new
 *                          parameter to getPlacementWithGreatestStartDate, Integer resourceId.
 * <pre>
 */
public interface AdoptionAsstnc {
  /**
   * Retrieves the Authorized Level of Care (ALOC) record with the greatest start date for the given person id.
   *
   * @param personId The person id whose ALOC record will be returned.
   * @return String ALOC with the greatest start date for the given person id.
   */
  public String getAlocWithGreatestStartDate(Integer personId);

  /**
   * SIR 16039, SIR 23131 thompswa Retrieves the Placement record with the greatest start date for the given person id
   * and resource id combination.
   *
   * @param personId   The person id whose Placement record will be returned.
   * @param resourceId The resource id whose Placement record will be returned.
   * @return String Placement with the greatest start date for the given person id.
   */
  public Date getPlacementWithGreatestStartDate(Integer personId, Integer resourceId);

  /**
   * Determines the maximum one-time payment amount for a non-recurring adoption assistance payment.
   *
   * @return Double Adoption assistance ceiling.
   */
  public Double getNonRecurringAdoptionAsstncCeiling();

  /**
   * Determines the monthly adoption assistance ceiling using the person id of the child being placed into adoption and
   * the "effective" adoption assistance start date, which is either the start date of the adoption assistance record
   * being added/updated or the start date of the earliest adoption assistance record for the person/resource
   * combination, if others exist.
   *
   * @param adoptionAsstncRecord The AdoptionAsstncValueBean containing the details of the adoption assistance record
   *                             being added/updated.
   * @return Double The ceiling for the recurring adoption assistance record.
   */
  public Double getRecurringAdoptionAsstncCeiling(AdoptionAsstncValueBean adoptionAsstncRecord);

  /**
   * Validates the specified adoption assistance amount based upon the adoption assistance type and the "effective"
   * adoption assistance start date, which is either the start date of the adoption assistance record being
   * added/updated or the start date of the earliest adoption assistance record for the person/resource combination, if
   * others exist.
   *
   * @param adoptionAsstncRecord The AdoptionAsstncValueBean containing the details of the adoption assistance record to
   *                             validate.
   * @return String The error message to be displayed if the validation fails.
   */
  public String getValidationErrors(AdoptionAsstncValueBean adoptionAsstncRecord);
}