package gov.georgia.dhr.dfcs.sacwis.web.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.types.Date;

/**
 * This class is used to perform the custom validation on Domicile and Deprivation.
 *
 * @author Rodrigo DeJuana 02/19/2002
 */
/*
 Change History:
 Date      User              Description
 --------  ----------------  ----------------------------------------------
 10/07/04  Todd Reser        SIR 23056 - Never was an error thrown if they
                             didn't complete the section.  While I was here,
                             added changelog, fixed Javadocs.
 10/18/04  Todd Reser        Removed to unnecessary checks found in peer review.
 11/18/10  Hai Nguyen        SMS#81144: MR-053 Added validation for specified
                             relative indicator. Removed validation for
                             Eligibility Specialist Confirmation section. Removed
                             validation for Month and Year field. Removed
                             validation for Date of Deprivation Change section.
 01/05/11  Hai Nguyen        SMS#81144: Only do validation for Initial or Amended Application
 */

public class DomicileDeprivationCustomValidation
        extends FceCustomValidation {
  /**
   * This method contains the logic to perform custom validation on the Domicle and Deprivation page.
   *
   * @return errorMessage
   */
  protected boolean validateForm() {
    HttpServletRequest request = getRequest();

    String livArr = ContextHelper.getStringSafe(request, "cdLivingMonthRemoval");
    
    if( "A".equals(ContextHelper.getStringSafe(request, "cdApplication"))){
      if (StringHelper.isEmptyOrNull(livArr)) {
        setErrorMessage(Messages.MSG_LVNG_ARRNG_REQ);
        return getErrorMessages().isEmpty();
      }else{
        char cLivArr = livArr.charAt(0);
        switch (cLivArr) {
          case DomicileDeprivationConversation.C_LIV_ARR_BOTH:
            validateBoth(request);
            break;
          case DomicileDeprivationConversation.C_LIV_ARR_ONE:
            validateOne(request);
            break;
          case DomicileDeprivationConversation.C_LIV_ARR_OTHER:
            validateOther(request, false);
            break;
          case DomicileDeprivationConversation.C_LIV_ARR_NONE:
            validateNone(request);
            break;
        }
      }
    }
    return getErrorMessages().isEmpty();
  }

  private void validateOther(HttpServletRequest request,
                             boolean sixMonth) {
    String relative = ContextHelper.getStringSafe(request, "idOtherRelativePerson");
    String indSpecifiedRelative = request.getParameter("indSpecifiedRelative");

    if (sixMonth) {
      relative = ContextHelper.getStringSafe(request, "idMngngCvsPerson");
    }

    if (StringHelper.isEmptyOrNull(relative) 
                    || StringHelper.isEmptyOrNull(indSpecifiedRelative)){
      setErrorMessage(Messages.MSG_LVNG_ARRNG_REQ);
    }
  }
 
  private void validateNone(HttpServletRequest request) {
    String b6Mnths = ContextHelper.getStringSafe(request, "indChildLivingPrnt6Mnths");
    String recent = ContextHelper.getStringSafe(request, "cdNotaMostRecent");
    String monthsRelCustody = ContextHelper.getStringSafe(request, "txtMonthsLivingRelCust");

    if (StringHelper.isEmptyOrNull(b6Mnths)) {
      setErrorMessage(Messages.MSG_LVNG_ARRNG_REQ);
    } else if ("true".equals(b6Mnths)) {
      if (StringHelper.isEmptyOrNull(monthsRelCustody)) {
        setErrorMessage(Messages.MSG_LVNG_ARRNG_REQ);
        return;
      }else{
        if (StringHelper.isEmptyOrNull(recent)) {
          setErrorMessage(Messages.MSG_LVNG_ARRNG_REQ);
          return;
        }else{
          char livArr = recent.charAt(0);
          switch (livArr) {
            case DomicileDeprivationConversation.C_LIV_ARR_BOTH:
              validateBoth(request);
              break;
            case DomicileDeprivationConversation.C_LIV_ARR_ONE:
              validateOne(request);
              break;
            case DomicileDeprivationConversation.C_LIV_ARR_OTHER:
              validateOther(request, true);
              break;
          }
        }
      }
    }
  }
  
  private void validateNotahanged(HttpServletRequest request, String currLivAr, String livArr){
    
  }
  
  private void validateLivArrChanged(HttpServletRequest request, String currLivAr, String livArr){
    
  }
}
