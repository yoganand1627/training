package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.AdoptionAsstncDao;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.AdoptionAsstncValueBean;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

/**
 * The session Bean class for the AdoptionAsstncEjb.
 * 
 * @author author name, create date <p/> Change History: Date User Description -------- -------------
 *         --------------------------------------------------- 07/10/04 thompswa SIR 16039 - Edit between start date of
 *         assistance and placement accomplished by adding new method, getPlacementWithGreatestStartDate( Integer
 *         personId ). <p/> 09/21/04 thompswa SIR 23066 - Adoption Assistance amount will now be edited against the ALOC
 *         rather than BLOC. Basic and moderate LOC is measured from CATHPLOC rather than CBILPLOC codes table. Messages
 *         and MSG names adjusted. <p/> 09/30/04 thompswa SIR 23131 - Edit between start date of assistance and
 *         placement enhanced by adding new parameter to getPlacementWithGreatestStartDate( Integer personId, Integer
 *         resourceId ). <p/> 01/13/05 ACodrea SIR 23315 closing the connection for all methods.
 */
public class AdoptionAsstncBean extends BaseServiceEjb {
  // static constants
  public static final String TRACE_TAG = "AdoptionAsstncBean";

  public static final org.exolab.castor.types.Date APRIL_30_2002 = DateHelper.toCastorDateSafe("04/30/2002");

  public static final org.exolab.castor.types.Date MAY_01_2002 = DateHelper.toCastorDateSafe("05/01/2002");

  public static final org.exolab.castor.types.Date AUG_31_2003 = DateHelper.toCastorDateSafe("08/31/2003");

  public static final org.exolab.castor.types.Date SEPT_01_2003 = DateHelper.toCastorDateSafe("09/01/2003");

  /* Adoption Assistance - Levels of Care */
  public static final String PERSON_LOC_BASIC_1 = CodesTables.CATHPLOC_010;

  public static final String PERSON_LOC_BASIC_2 = CodesTables.CATHPLOC_020;

  public static final String PERSON_LOC_BASIC_3 = CodesTables.CATHPLOC_210;

  /* Adoption Assistance - Ceilings */
  public static final double NO_CEILING_MAX = 1000000.00;

  public static final double NONRECURRING_ADOPTION_ASSTNC_MAX = 1500.00;

  public static final double RECURRING_ADOPTION_ASSTNC_MAX_OLD = 521.00;

  public static final double RECURRING_ADOPTION_ASSTNC_BASIC_MAX_NEW = 400.00;

  public static final double RECURRING_ADOPTION_ASSTNC_MODERATE_MAX_NEW = 545.00;

  /* Adoption Assistance - Assistance Types */
  public static final String NONRECURRING_TYPE_17 = CodesTables.CSUBTYPE_17;
  public static final String NONRECURRING_TYPE_22 = CodesTables.CSUBTYPE_22;
  public static final String NONRECURRING_TYPE_23 = CodesTables.CSUBTYPE_23;
  public static final String NONRECURRING_TYPE_24 = CodesTables.CSUBTYPE_24;
  public static final String NONRECURRING_TYPE_25 = CodesTables.CSUBTYPE_25;

  /** Constructor */
  public AdoptionAsstncBean() {
  }

  /**
   * Determines the maximum one-time payment amount for a non-recurring adoption assistance payment.
   * 
   * @param adoptionAsstncStartDate
   *          The date the new adoption assistance agreement takes effect.
   * @param personId
   *          The person id whose adoption assistance ceiling will be returned.
   * @param resourceId
   *          The resource id of the resource where the child is placed.
   * @return Double Adoption assistance ceiling.
   */
  public Double getNonRecurringAdoptionAsstncCeiling() {
    GrndsTrace.enterScope(TRACE_TAG + ".getNonRecurringAdoptionAsstncCeiling");

    Connection connection = null;
    double adoptionAsstncCeiling = 0;

    try {
      // Currently, the non-recurring adoption assistance ceiling is $1500.00.
      adoptionAsstncCeiling = NONRECURRING_ADOPTION_ASSTNC_MAX;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting adoption assistance ceiling: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      // SIR#23315, ASC closing the connection
      cleanup(connection);
    }
    return new Double(adoptionAsstncCeiling);
  }

  /**
   * Determines the monthly adoption assistance ceiling using the person id of the child being placed into adoption and
   * the "effective" adoption assistance start date, which is either the start date of the adoption assistance record
   * being added/updated or the start date of the earliest adoption assistance record for the person/resource
   * combination, if others exist.
   * 
   * @param adoptionAsstncBean
   *          The AdoptionAsstncValueBean containing the details of the adoption assistance record being added/updated.
   * @return Double The ceiling for the recurring adoption assistance record.
   */
  public Double getRecurringAdoptionAsstncCeiling(AdoptionAsstncValueBean adoptionAsstncRecord) {
    GrndsTrace.enterScope(TRACE_TAG + ".getRecurringAdoptionAsstncCeiling");

    Connection connection = null;
    double adoptionAsstncCeiling = 0;

    try {
      // ----------
      // For the adoption assistance ceiling calculations, use the earlier of
      // the two start dates--either the start date of the adoption assistance
      // record being added/updated, or the start date of the earliest existing
      // adoption assistance record for the child/resource combination, if
      // others exist. This start date will be referred to as the "effective"
      // start date.
      //
      // ADOPTION ASSISTANCE CEILING SCENARIOS:
      // 1.) If the effective start date is prior to May 1, 2002, there is no
      // adoption assistance ceiling.
      // 2.) If the effecitve start date is May 1, 2002, or after, but prior to
      // September 1, 2003, the old ceiling of $521.00 applies.
      // 3.) If the effective start date is September 1, 2003, or after, and the
      // most recent ALOC (the one with the greatest start date) is 'Basic',
      // the new Basic ceiling of $400.00 applies.
      // 4.) If the effective start date is September 1, 2003, or after, and the
      // most recent ALOC (the one with the greatest start date) is something
      // other than 'Basic', the new non-Basic ceiling of $545.00 applies.
      // ----------

      // Get the earliest adoption assistance record for the child and resource
      // combination, if others exist.
      connection = getConnection();
      AdoptionAsstncDao adoptionAsstncDao = new AdoptionAsstncDao(connection);
      AdoptionAsstncValueBean earliestAdoptionAsstncRecord = adoptionAsstncDao
                                                                              .queryEarliestAdoptionAsstncRecord(
                                                                                                                 adoptionAsstncRecord
                                                                                                                                     .getPersonId(),
                                                                                                                 adoptionAsstncRecord
                                                                                                                                     .getPayeeId());

      // For the adoption assistance ceiling calculations, get the "effective"
      // start date described above. The "effective" start date will be the
      // start date of the earliest existing adoption assistance record only if
      // that record is different from the record being updated.
      org.exolab.castor.types.Date startDateToUseForCalculations = adoptionAsstncRecord.getDateStart();

      if (earliestAdoptionAsstncRecord != null
          && earliestAdoptionAsstncRecord.getAdoptionAsstncId() != adoptionAsstncRecord.getAdoptionAsstncId()
          && earliestAdoptionAsstncRecord.getDateStart() != null
          && DateHelper.isBefore(earliestAdoptionAsstncRecord.getDateStart(), startDateToUseForCalculations)) {
        startDateToUseForCalculations = earliestAdoptionAsstncRecord.getDateStart();
      }

      // CASE 1:
      if (DateHelper.isBefore(startDateToUseForCalculations, MAY_01_2002)) {
        // The arbitrary ceiling of $1,000,000.00 was chosen as the amount to
        // represent "no ceiling" since the EJB should not return a null ceiling.
        adoptionAsstncCeiling = NO_CEILING_MAX;
      }
      // CASE 2:
      else if (DateHelper.isAfter(startDateToUseForCalculations, APRIL_30_2002)
               && DateHelper.isBefore(startDateToUseForCalculations, SEPT_01_2003)) {
        adoptionAsstncCeiling = RECURRING_ADOPTION_ASSTNC_MAX_OLD;
      } else if (DateHelper.isAfter(startDateToUseForCalculations, AUG_31_2003)) {
        String currentAloc = this.getAlocWithGreatestStartDate(new Integer(adoptionAsstncRecord.getPersonId()));

        // CASE 3:
        if (StringHelper.isValid(currentAloc)
            && (PERSON_LOC_BASIC_1.equals(currentAloc) || PERSON_LOC_BASIC_2.equals(currentAloc) || PERSON_LOC_BASIC_3
                                                                                                                      .equals(currentAloc))) {
          adoptionAsstncCeiling = RECURRING_ADOPTION_ASSTNC_BASIC_MAX_NEW;
        }
        // CASE 4:
        else {
          adoptionAsstncCeiling = RECURRING_ADOPTION_ASSTNC_MODERATE_MAX_NEW;
        }
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting adoption assistance ceiling: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      // SIR#23315, ASC closing the connection
      cleanup(connection);
    }
    return new Double(adoptionAsstncCeiling);
  }

  /**
   * Validates the specified adoption assistance amount based upon the adoption assistance type and the "effective"
   * adoption assistance start date, which is either the start date of the adoption assistance record being
   * added/updated or the start date of the earliest adoption assistance record for the person/resource combination, if
   * others exist.
   * 
   * @param adoptionAsstncRecord
   *          The AdoptionAsstncValueBean containing the details of the adoption assistance record to validate.
   * @return String The error message to be displayed if the validation fails.
   */
  public String getValidationErrors(AdoptionAsstncValueBean adoptionAsstncRecord) {
    GrndsTrace.enterScope(TRACE_TAG + ".getValidationErrors");

    Connection connection = null;
    double adoptionAsstncCeiling = 0;
    String errorMessage = "";

    try {
      
      connection = getConnection();
      AdoptionAsstncDao adoptionAsstncDao = new AdoptionAsstncDao(connection);
      
      List<String> nonRecurringType = new ArrayList<String>();
      nonRecurringType.add(NONRECURRING_TYPE_17);
      nonRecurringType.add(NONRECURRING_TYPE_22);
      nonRecurringType.add(NONRECURRING_TYPE_23);
      nonRecurringType.add(NONRECURRING_TYPE_24);
      nonRecurringType.add(NONRECURRING_TYPE_25);
      
      if (nonRecurringType.contains(adoptionAsstncRecord.getAdoptionAsstncTypeCode())) {
        // Determine the adoption assistance ceiling, and return an appropriate
        // error message if the adoption assistance amount exceeds the ceiling.
        double priorAppAmounts = adoptionAsstncDao.queryNonRecurringAmt(adoptionAsstncRecord.getStageId());
        adoptionAsstncCeiling = getNonRecurringAdoptionAsstncCeiling().doubleValue() + priorAppAmounts;
        if (adoptionAsstncRecord.getAdoptionAsstncAmount() > adoptionAsstncCeiling) {
          String msg = "Adding this Non-Recurring Expenses will take the child over the spending limit of $15000";
          //TODO: WAITING on DBCR
          //return MessageLookup.getMessageByNumber(Messages.MSG_NONRECURR_SUB_AMT);
          return MessageLookup.getMessageByNumber(msg);
        }
      } else {
        // Get the earliest adoption assistance record for the child and resource
        // combination, if others exist.
        AdoptionAsstncValueBean earliestAdoptionAsstncRecord = adoptionAsstncDao
                                                                                .queryEarliestAdoptionAsstncRecord(
                                                                                                                   adoptionAsstncRecord
                                                                                                                                       .getPersonId(),
                                                                                                                   adoptionAsstncRecord
                                                                                                                                       .getPayeeId());

        // For the adoption assistance validation, get the "effective" start
        // date described above. The "effective" start date will be the
        // start date of the earliest existing adoption assistance record only if
        // that record is different from the record being updated.
        org.exolab.castor.types.Date startDateToUseForValidation = adoptionAsstncRecord.getDateStart();

        if (earliestAdoptionAsstncRecord != null
            && earliestAdoptionAsstncRecord.getAdoptionAsstncId() != adoptionAsstncRecord.getAdoptionAsstncId()
            && earliestAdoptionAsstncRecord.getDateStart() != null
            && DateHelper.isBefore(earliestAdoptionAsstncRecord.getDateStart(), startDateToUseForValidation)) {
          startDateToUseForValidation = earliestAdoptionAsstncRecord.getDateStart();
        }

      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting adoption assistance validation errors: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      // SIR#23315, ASC closing the connection
      cleanup(connection);
    }
    return errorMessage;
  }

  /**
   * Retrieves the Authorized Level of Care (ALOC) record with the greatest start date for the given person id.
   * 
   * @param personId
   *          The person id whose ALOC record will be returned.
   * @return String ALOC with the greatest start date for the given person id.
   */
  public String getAlocWithGreatestStartDate(Integer personId) {
    GrndsTrace.enterScope(TRACE_TAG + ".getAlocWithGreatestStartDate");

    Connection connection = null;
    String alocWithGreatestStartDate = null;

    try {
      connection = getConnection();
      AdoptionAsstncDao adoptionAsstncDao = new AdoptionAsstncDao(connection);
      alocWithGreatestStartDate = adoptionAsstncDao.queryAlocWithGreatestStartDate(personId.intValue());
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting active ALOC: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      // SIR#23315, ASC closing the connection
      cleanup(connection);
    }
    return alocWithGreatestStartDate;
  }

  /**
   * SIR 16039 thompswa Retrieves the Placement record with the greatest start date for the given person id.
   * 
   * @param personId
   *          The person id whose Placement record will be returned.
   * @param resourceId
   *          The resource id whose Placement record will be returned.
   * @return String Placement with the greatest start date for the given person id.
   */
  public org.exolab.castor.types.Date getPlacementWithGreatestStartDate(Integer personId, Integer resourceId) {
    GrndsTrace.enterScope(TRACE_TAG + ".getPlacementWithGreatestStartDate");

    Connection connection = null;
    org.exolab.castor.types.Date placementWithGreatestStartDate = null;

    try {
      connection = getConnection();
      AdoptionAsstncDao adoptionAsstncDao = new AdoptionAsstncDao(connection);
      placementWithGreatestStartDate = adoptionAsstncDao.queryPlacementWithGreatestStartDate(personId.intValue(),
                                                                                             resourceId.intValue());
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting Placement: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      // SIR#23315, ASC closing the connection
      cleanup(connection);
    }
    return placementWithGreatestStartDate;
  } // SIR 16039 thompswa End.

  /** Gets a JDBC Tx Managed Connection */
  protected Connection getConnection() {
    return JdbcHelper.getConnection();
  }
}