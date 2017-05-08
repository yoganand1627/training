package gov.georgia.dhr.dfcs.sacwis.service.fce;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.FinderException;
import javax.naming.NamingException;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import org.exolab.castor.types.Date;

/**
 * <p>Title: ReviewReasonsNotEligible</p> <p>Description: This is the class used to determine the reasons why a person
 * would not be Ttile IV-E Eligible.</p> <p>Copyright: Copyright (c) 2004</p> <p>Company: DFPS</p>
 * <p/>
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  -------------------------------------------------
 * 07/12/04  Todd Reser        SIR 23012 - We have to get the DataBean so we can
 *                             compare the age if the person is >= 18.  Added
 *                             Flowerbox.
 * 07/13/04  Todd Reser        Fixed PMD Errors.
 * 08/09/04  Todd Reser        SIR 23012 - Modified routine to approve TitleIV-E
 *                             if age was 18, but not the month after their 18th
 * 09/08/04  Todd Reser        Modified if statements to appropriate calculate
 *                             IVE Eligibility vs. Extended Education questions
 * 10/14/04  Todd Reser        Changed the setting of and error message for
 *                             TooOldForIVE because the way it was coded didn't
 *                             catch 19 year olds & +.
 * 05/17/05  Todd Reser        SIR 23295 - Had to find out the last day of the
 *                             month of the child's 18th birthday because the if
 *                             statement was coded erroneously. (Switcdhed to
 *                             DateHelper)
 * 12/14/10  Hai Nguyen        SMS#81144: Just want to make sure it's pulling the correct
 *                             fcePerson, so changed method to retrieve fcePersonDB
 * 12/30/10  Hai Nguyen        SMS#89241: Removed unnecessary checks and methods.
 * 02/09/11  Hai Nguyen        SMS#95590: Added Permanency Hearing check.
 * 02/11/11  Hai Nguyen        SMS#95590: Updated condition for extension of custody check.
 *                             Added check for in dfcs custody at time of 
 *                             reimbursability determination.
 * </pre>
 *
 * @author Matt
 */

public class ReviewReasonsNotEligible implements Serializable {
  protected Connection connection = null;
  protected FceApplicationDB fceApplicationDB = null;
  protected FceEligibilityDB fceEligibilityDB = null;
  protected FceReviewDB fceReviewDB = null;
  protected FcePersonDB fcePersonDB = null;


  protected ReviewReasonsNotEligible(Connection connection, FceContext fceContext, Fce fce)
          throws EjbValidationException, NamingException, FinderException, RemoteException, SQLException {
    this.connection = connection;
    this.fceApplicationDB = fceContext.getFceApplicationDB(fce);
    this.fceEligibilityDB = fceContext.getFceEligibilityDB(fce);
    this.fceReviewDB = fceContext.getFceReviewDB(fce);
    this.fcePersonDB = fceContext.getFcePersonDBByIdFcePerson(fce);
  }

  /**
   * @param fce
   * @param fceContext
   * @return
   * @throws NamingException
   * @throws FinderException
   * @throws RemoteException
   * @throws SQLException
   * @throws EjbValidationException
   */
  @SuppressWarnings({"unchecked"})
  public static List getReasonsNotEligible(Fce fce, FceContext fceContext)
          throws NamingException, FinderException, RemoteException, SQLException, EjbValidationException {

    FceEligibilityDB fceEligibilityDB = fceContext.getFceEligibilityDB(fce);
         
    //get the Review's Reasons Not Eligible
    FceReviewDB fceReviewDB = fceContext.getFceReviewDB(fce);
    FcePersonDB fcePersonDB = fceContext.getFcePersonDBByIdFcePerson(fce);

    //nbrAgeYears, nbrAgeMonths
    List list = new ArrayList();
    long nbrAgeYears = 0;
    long nbrAgeMonths = 0;
    java.util.Date dtBirth = fcePersonDB.getDtBirth();
    java.util.Date dtReviewComplete = fceReviewDB.getDtReviewComplete();
    java.util.Date dtAgeCalculated = new java.util.Date();
    if (dtReviewComplete != null) {
      dtAgeCalculated = dtReviewComplete;
    }
    if (dtBirth != null) {
      nbrAgeMonths = DateUtility.getAgeInMonths(dtBirth, dtAgeCalculated);
      nbrAgeYears = nbrAgeMonths / 12;
      nbrAgeMonths = nbrAgeMonths % 12;
    }

    // SIR 23012 - We have to calculate if the child is "too old" for Title IV-E.
    // The child is eligible until the month following their 18th birthday.
    //Set them as being eligible if under age 19, otherwise make them ineligible
    Boolean TooOldForIVE = (nbrAgeYears < 19L) ?
                           Boolean.FALSE : Boolean.TRUE;

    //SIR 23295 - We need to find out the last day of the month of the child's
    //18th birthday
    Date afterDate = DateHelper.addToDate(DateHelper.toCastorDate(fcePersonDB.getDtBirth()), 18, 0, 0);
    afterDate.setDay(DateHelper.getLastDayOfTheMonth(afterDate).getDay());

    //If it's after their birthmonth on their 18th birthyear, then they aren't Title IV-E eligible.
    if (DateHelper.isAfter(DateHelper.getTodayCastorDate(), afterDate) ) {
      TooOldForIVE = Boolean.TRUE;
    }

    if (TooOldForIVE == Boolean.TRUE) {
      list.add(CodesTables.CFCERNE_R09);
    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndCtnblResChildElgbltyObject()))//det, leg
    {
      list.add(CodesTables.CFCERNE_R10);
    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndGrossIncChildElgbltyObject()))//det, leg
    {
      list.add(CodesTables.CFCERNE_R11);
    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndStdOfNeedChildTestElgbltyObject()))//det, leg
    {
      list.add(CodesTables.CFCERNE_A15);
    }
    // The following check is required only if child is in custody
    // which is determined by IndPrmncyHearingsDueObject being Boolean.TRUE.
    // Extension check is required only if child in permanent custody
    // which is determined by the value of IndExtnsionProvided12Mnths.
    if ((Boolean.TRUE.equals(fceReviewDB.getIndPrmncyHearingsDueObject()))
          && Boolean.FALSE.equals(fceReviewDB.getIndExtnsionProvided12MnthsObject()))//det, leg
    {
      list.add(CodesTables.CFCERNE_R08);
    }
    // The following check is required only if child is in custody
    // which is determined by IndPrmncyHearingsDueObject being Boolean.TRUE.
    if ((Boolean.TRUE.equals(fceReviewDB.getIndPrmncyHearingsDueObject()))
          && (Boolean.FALSE.equals(fceReviewDB.getIndPrmncyHrngs12MonthObject()))) {
      list.add(CodesTables.CFCERNE_R06);
    }
    // The following check if child is not in DFCS custody
    // which is determined by IndPrmncyHearingsDueObject being null
    // therefore child is not IV-E Reimbursable
    if(fceReviewDB.getIndPrmncyHearingsDueObject() == null){
      list.add(CodesTables.CFCERNE_A10);
    }
    
    return list;
  }

}
