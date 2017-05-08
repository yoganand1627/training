package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO;

public interface RetrieveHomeDemographics {
  /**
   * Function codes to indicate what type of retrieval to perform.</p> <p>Probably want to put these in the
   * CodesTables.</p>
   */
  String RETRIEVE_RESOURCE = "R";
  String RETRIEVE_HISTORY = "H";

  /**
   * Home Demographics Retrieve Do not retrieve CdTask from the Event Table (don't copy it from EventDAO Output as the
   * most recent event may have a CdTask that was created by another window. This is because the record retrieved from
   * the Caps_Resource table will hold the value of the event created most recently only.
   * <p/>
   * If the Historical Record is being retrieved, then pass the Resource Table's stage out to the Event Group.  This is
   * needed to create the Report.
   * <p/>
   * Write logic to determine if contract version has changed less than two days afte original contract.
   * <p/>
   * After the call to ContracPeriodDAO, do not handle NO_DATA_FOUND. In cases in which dt_cnper_closure date on the
   * CONTRACT_PERIOD table is not > than sys date, ContracPeriodDAO will fail. This is OK because logic will handle this
   * situation appropriately. Due to conversion,the dt_cnper_closure was not being recorded appropriately. It should
   * have been set to the date the home closed, and in some cases it was being set to DtContractCreated + 100 years.
   * Also corrected logic to compare dtDtCnperTerm and dtTempDate appropriately.
   * <p/>
   * Call to SchDistDAO to get the school district decode to pass to the Resource Address window to be held in the
   * listbox.  This will only happen if the Address Type is Primary and the School District code is not NULL.
   * <p/>
   * To populate Event list with the correct date, added code to get the current date after 2 days is subtracted from it
   * to compare to an old date for contracts ( new contracts are not supposed to be created if the county changes
   * whithin 2 days of the creation of a FAD home).
   * <p/>
   * Add the element of age to the determination of service code. Regardless of whether the associated contract can
   * serve LOC 1 or LOC 1 and 2 clients, CONTRACT_SERVICE rows are currently set up for both level 1 (service code 95L)
   * and level 2 (service code 95M). CONTRACT_COUNTY rows are linked to both. Because the contract is set up for both
   * level 1 and level 2, the home may be incorrectly reimbursed at the level 2 rate.
   * <p/>
   * Service Codes 60A-E are now being reduced to Service Codes 63A - D, updated code to compare and save with new
   * codes.
   * <p/>
   * Add a new field to the Home Information page. This new field would be stored in the CAPS_RESOURCE table. <ol><li>If
   * the Non-FPS Adoptive Home checkbox is checked, staff will have to select a 'Certifying Entity'. to indicate the
   * certifying agency</li> <li>This will be a required field when the Non-FPS Adoptive Home checkbox is checked for a
   * new home.</li> <li>If a user is modifying an existing Non-FPS Adoptive Home, this new field will be required,
   * unless the home status is also being changed to 'Pending Closure' or 'Closed'.</li></ol>
   *
   * @param cfad07si {@link CFAD07SI} object
   * @return {@link CFAD07SO} object
   */
  public CFAD07SO retrieveHomeDemographics(CFAD07SI cfad07si);
}
