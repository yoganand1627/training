package gov.georgia.dhr.dfcs.sacwis.web.fce;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

/**
 * <p>Title: FCE Custom Validation</p> <p>Description: Common checks between different FCE pages</p>
 * <p>Copyright: Copyright (c) 2004</p> <p>Company: DFPS</p>
 *
 * @author Matt McClaim
 */
/*
 Change History:
 Date      User              Description
 --------  ----------------  ----------------------------------------------
 09/28/04  Todd Reser        SIR 23056 - Edits to questions and dynamic display
                             required modifications to the Custom Validation.
                             While I was here, added changelog, fixed Javadocs.
 04/15/05  Todd Reser        SIR 23310 - Created if statement so that if
                             militaryObject.booleanValue() = true then throw
                             MSG_LIVING_APART error message.
 11/19/10  Hai Nguyen        SMS#81144: MR-053 Updated validation for new fields
                             on Removal HH and Deprivation page.
 12/03/10  Hai Nguyen        SMS#81144: Corrected some validation
 */
public abstract class FceCustomValidation
        extends FormValidation {
  public boolean validateCitizenship(FceEligibilityDB fceEligibilityDB,
                                     String cdPersonCitizenship) {
    boolean isValid = true;

    boolean cdPersonCitizenshipFilled = (cdPersonCitizenship.length() > 0);

    boolean verifiedUsCitizen = verifiedUsCitizen(fceEligibilityDB);
    boolean verifiedPermanentResident = verifiedPermanentResident(fceEligibilityDB);
    boolean verifiedOtherQualifiedAlien = verifiedOtherQualifiedAlien(fceEligibilityDB);
    boolean verifiedUndeterminedStatus = verifiedUndeterminedStatus(fceEligibilityDB);
    boolean verifiedEligibilitySpecialist = verifiedEligibilitySpecialist(fceEligibilityDB);

    int verifiedTypeCount = 0;
    if (verifiedUsCitizen) {
      verifiedTypeCount++;
    }
    if (verifiedPermanentResident) {
      verifiedTypeCount++;
    }
    if (verifiedOtherQualifiedAlien) {
      verifiedTypeCount++;
    }
    if (verifiedUndeterminedStatus) {
      verifiedTypeCount++;
    }

    //if citizenship status is not empty
    //and you didn't checked one of the verification methods
    if ((verifiedTypeCount == 0 && !verifiedEligibilitySpecialist) &&
        (cdPersonCitizenshipFilled)) {
      setErrorMessage(Messages.MSG_VERIF_CITIZEN_REQ);
      isValid = false;
    }
    return isValid;
  }

  public static boolean verifiedUsCitizen(FceEligibilityDB fceEligibilityDB) {
    return
            (fceEligibilityDB.getIndCtznshpBirthCrtfctUs()) ||
            (fceEligibilityDB.getIndCtznshpNtrlztnCrtfct()) ||
            (fceEligibilityDB.getIndCtznshpCitizenCrtfct()) ||
            (fceEligibilityDB.getIndCtznshpPassport()) ||
            (fceEligibilityDB.getIndCtznshpHospitalCrtfct()) ||
            (fceEligibilityDB.getIndCtznshpAmerIndianCrd()) ||
            (fceEligibilityDB.getIndCtznshpUsIdCard()) ||
            (fceEligibilityDB.getIndCtznshpCivilServiceEmp()) ||
            (fceEligibilityDB.getIndCtznshpBirthAbroad()) ||
            (fceEligibilityDB.getIndCtznshpNorthMarianaId()) ||
            (fceEligibilityDB.getIndCtznshpFinalAdoptDecree()) ||
            (fceEligibilityDB.getIndCtznshpVitalBirthRcrd()) ||
            (fceEligibilityDB.getIndCtznshpMiltryBirthRcrd()) ||
            (fceEligibilityDB.getIndCtznshpConfrmBirth()) ||
            (fceEligibilityDB.getIndCtznshpUsHsptlBrthRcrd()) ||
            (fceEligibilityDB.getIndCtznshpLifeInsBrthRcrd()) ||
            (fceEligibilityDB.getIndCtznshpCensusBirthRcrd()) ||
            (fceEligibilityDB.getIndCtznshpCertReportBirth()) ||
            (fceEligibilityDB.getIndCtznshpMedBirthRcrd()) ||
            (fceEligibilityDB.getIndCtznshpReligBirthRcrd()) ||
            (fceEligibilityDB.getIndCtznshpEvaluation()) ||
            (fceEligibilityDB.getIndCtznshpLoclGovtBrthRcrd());
  }

  public static boolean verifiedPermanentResident(FceEligibilityDB fceEligibilityDB) {
    return
            (fceEligibilityDB.getIndCtznshpResidentCard()) ||
            (fceEligibilityDB.getIndCtznshpRefugee());
  }

  public static boolean verifiedOtherQualifiedAlien(FceEligibilityDB fceEligibilityDB) {
    return
            (fceEligibilityDB.getIndCtznshpAttorneyReview()) ||
            (fceEligibilityDB.getIndCtznshpStudentVisa());
  }

  public static boolean verifiedUndeterminedStatus(FceEligibilityDB fceEligibilityDB) {
    return
            (fceEligibilityDB.getIndCtznshpBirthCrtfctFor()) ||
            (fceEligibilityDB.getIndCtznshpForDocumentation()) ||
            (fceEligibilityDB.getIndCtznshpNoDocumentation()) ||
            (fceEligibilityDB.getIndCtznshpLeglImmiStatExp()) ||
            (fceEligibilityDB.getIndCtznshpChldFound()) ||
            (fceEligibilityDB.getIndCtznshpUnaccMinorChild()) ||
            (fceEligibilityDB.getIndCtznshpUndocImmigrant());
  }
  
  public static boolean verifiedEligibilitySpecialist(FceEligibilityDB fceEligibilityDB) {
    return
            (fceEligibilityDB.getIndCtznshpSaveSystem()) ||
            (fceEligibilityDB.getIndCtznshpSuccessSystem());
  }

  public static boolean verifiedCitizenship(FceEligibilityDB fceEligibilityDB) {
    return ((verifiedUsCitizen(fceEligibilityDB)) ||
            (verifiedPermanentResident(fceEligibilityDB)) ||
            (verifiedOtherQualifiedAlien(fceEligibilityDB)) ||
            (verifiedUndeterminedStatus(fceEligibilityDB)) ||
            (verifiedEligibilitySpecialist(fceEligibilityDB)));
  }
  
  

  /**
   * This function validates the domicile/deprivation section for both parents to make sure the section is filled out
   * correctly.
   *
   * @param request the HTTPServletRequest object.
   */
  protected void validateBoth(HttpServletRequest request) {
    FceEligibilityDB fceEligibilityDB = new FceEligibilityDB();
    //We call populateWithRequest so that the data will match what was submitted
    //from the the jsp
    DomicileDeprivationConversation.populateWithRequest(fceEligibilityDB, request);
    String parentDisabled = fceEligibilityDB.getIndParentDisabledString();
    String monthsDisabled = fceEligibilityDB.getTxtMonthsDepDisabled();
    String verifMethod = fceEligibilityDB.getCdVerifMethod();
    String verifDocType = fceEligibilityDB.getCdVerifDocType();
    String pwe = fceEligibilityDB.getIdPrnEarnerString();
    String peNotAcptEmpTrn = fceEligibilityDB.getIndPeNotAcptEmpTrnString();
    String peRecvUnemp = fceEligibilityDB.getIndPeRecvUnempString();
    String peWrkEngEduTrn = fceEligibilityDB.getIndPeWrkEngEduTrnString();
    String recv100PctVa = fceEligibilityDB.getIndRecv100PctVaString();
    String recvRrRsdi = fceEligibilityDB.getIndRecvRrRsdiString();
    String steady = fceEligibilityDB.getCdPweSteadyUnder100Object();
    String monthsUnemp = fceEligibilityDB.getTxtMonthsDepUnemp();
    String irregular = fceEligibilityDB.getCdPweIrregularUnder100Object();
    String monthsUnderEmp = fceEligibilityDB.getTxtMonthsDepUnderEmpl();

    //SIR 23056 - Massive edits to the below if else else else ... syntax
    if ("true".equals(parentDisabled)) {
      if (StringHelper.isEmptyOrNull(monthsDisabled) 
                      || StringHelper.isEmptyOrNull(verifMethod) 
                      || (CodesTables.CVERMETH_D.equals(verifMethod) 
                          && (((CodesTables.CDOCTYPE_RR.equals(verifDocType) 
                                          || CodesTables.CDOCTYPE_RS.equals(verifDocType)) 
                                          && (recvRrRsdi == null 
                                                          || "".equals(recvRrRsdi)))
                          || (CodesTables.CDOCTYPE_VA.equals(verifDocType) 
                                          && (recv100PctVa == null 
                                                          || "".equals(recv100PctVa)))))) {
        //Complain if Parent Disabled and no verification method or documentation selected
        // OR disabled parent does not receive 100% VA or receive RR or RSDI due to a disability
        setErrorMessage(Messages.MSG_BOTH_TGTH);
      }
    } else if ("false".equals(parentDisabled)) {
      if (StringHelper.isEmptyOrNull(pwe)) {
        //Complain if PWE is null and Parent is not disabled
        setErrorMessage(Messages.MSG_BOTH_TGTH);
      } else if (StringHelper.isEmptyOrNull(steady)){
        //Complain if PWE not null, Parent not disabled and steady is empty/null
        setErrorMessage(Messages.MSG_BOTH_TGTH);
      } else {
        // PWE not null, Parent not disabled, and steady is not empty/null
        if ("Y".equals(steady)){
          // unemployed
          if ( StringHelper.isEmptyOrNull(monthsUnemp)) {
            //Complain monthsUnemp is empty/null
            setErrorMessage(Messages.MSG_BOTH_TGTH);
          } else if(StringHelper.isEmptyOrNull(peRecvUnemp) ) {
            // Complain if peRecvUnemp is empty/null
            setErrorMessage(Messages.MSG_BOTH_TGTH);
          } else {
            if( "true".equals(peRecvUnemp)){
              // receiving Unemployment Compensation
              if(StringHelper.isEmptyOrNull(peNotAcptEmpTrn)){
                // Complain peNotAcptEmpTrn is empty/null
                setErrorMessage(Messages.MSG_BOTH_TGTH);
              }
            } else {
              // not receiving Unemployment Compensation
              if(StringHelper.isEmptyOrNull(peWrkEngEduTrn)){
                // Complain peWrkEngEduTrn is empty/null
                setErrorMessage(Messages.MSG_BOTH_TGTH);
              } else {
                if ("true".equals(peWrkEngEduTrn)){
                  // PE worked or engaged in education training
                  if(StringHelper.isEmptyOrNull(peNotAcptEmpTrn)){
                    // Complain peNotAcptEmpTrn is empty/null
                    setErrorMessage(Messages.MSG_BOTH_TGTH);
                  }
                }
              }
            }
          }
        } else{
          // not unemployed
          if (StringHelper.isEmptyOrNull(irregular)){
            // Complain irregular/under-employed is empty/null
            setErrorMessage(Messages.MSG_BOTH_TGTH);
          } else {
            // irregular not empty/null
            if ("Y".equals(irregular)){
              // under-employed
              if (StringHelper.isEmptyOrNull(monthsUnderEmp)){
                // Complain under-employed and monthsUnderEmp is empty/null
                setErrorMessage(Messages.MSG_BOTH_TGTH);
              } // no complaints if not under-employed
            }
          }
        }
      }
    } else if( StringHelper.isEmptyOrNull(parentDisabled)){
      // Complain parentDisabled is neither true or false
      setErrorMessage(Messages.MSG_LVNG_ARRNG_REQ);
    }
  }

  /**
   * This function validates the domicile/deprivation section for one parent to make sure the section is filled out
   * correctly.
   *
   * @param request the HTTPServletRequest object.
   */
  protected void validateOne(HttpServletRequest request) {
    FceEligibilityDB fceEligibilityDB = new FceEligibilityDB();
    DomicileDeprivationConversation.populateWithRequest(fceEligibilityDB, request);

    Boolean parentObject = fceEligibilityDB.getIndAbsentMotherObject();
    Boolean militaryObject = fceEligibilityDB.getIndAbsentMilitaryWorkObject();
    boolean parent = fceEligibilityDB.getIndAbsentMother();
    boolean military = fceEligibilityDB.getIndAbsentMilitaryWork();
    boolean death = fceEligibilityDB.getIndAbsentDied();
    boolean deportation = fceEligibilityDB.getIndAbsentDeported();
    boolean desertion = fceEligibilityDB.getIndAbsentDeserted();
    boolean divorce = fceEligibilityDB.getIndAbsentDivorced();
    boolean hospitalization = fceEligibilityDB.getIndAbsentHospitalized();
    boolean incarceration = fceEligibilityDB.getIndAbsentIncarcerated();
    boolean seperated = fceEligibilityDB.getIndAbsentAltrntCustody();
    boolean seperation = fceEligibilityDB.getIndAbsentSeparated();
    boolean neverCohabitated = fceEligibilityDB.getIndAbsentNeverCohabitated();
    boolean workRelated = fceEligibilityDB.getIndAbsentWorkRelated();
    boolean volRelinquish = fceEligibilityDB.getIndAbsentTprVolRelinq();

    // SIR 23310 - Added check to see if militaryObject.booleanValue() is true
    if ((parentObject != null) &&
        (militaryObject != null) &&
        (militaryObject)) {
      setErrorMessage(Messages.MSG_LIVING_MILITARY_ABSENCE);
      return;
    }

    if ((parentObject == null) ||
        (militaryObject == null)) {
      setErrorMessage(Messages.MSG_LIVING_APART);
      return;
    }

    boolean reasonAbsentChecked =
            ((desertion) ||
             (divorce) ||
             (incarceration) ||
             (deportation) ||
             (hospitalization) ||
             (seperation) ||
             (death) ||
             (seperated) ||
             (neverCohabitated) ||
             (workRelated) ||
             (volRelinquish));

    if (military == false) {
      if (reasonAbsentChecked == false) {
        setErrorMessage(Messages.MSG_LVNG_ARRNG_REQ);
      }
    } else {
      if (reasonAbsentChecked) {
        setErrorMessage(Messages.MSG_OTH_PAR_INCONSISTENT);
      }
    }
  }
}


