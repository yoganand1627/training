package gov.georgia.dhr.dfcs.sacwis.web.fad;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * <p>Title: FAHomeSearchCustomValidation </p> <p>Description: Custom Validation for FAHomeSearch page</p> <p>Copyright:
 * Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author Habib Hadjimani
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 9/12/03   JEH -        Revising to use ContextHelper and to
 *          require more search parameters than just region or just category. 10/13/03  dickmaec     SIR 19857 --
 *          ContextHelper.get... replaces getInputValue();
 *          8/28/2008 Joshua Dorsey SIR STGAP00010108 Change to check if user has to rights to search for adoption homes
 */

public class FAHomeSearchCustomValidation extends FormValidation {
  // static constants
  public static final String SEARCH_BUTTON = "btnSearch";
  public static final String TRACE_TAG = "FAHomeSearchCustomValidation";
  private int iNumberOfCharacteristics = 42;
  private int iNumberOfCheckedBoxes = 5;

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    boolean isValidForSearch = true;

    int sResourceId = ContextHelper.getIntSafe(request, "txtUlIdResource");
    String sResourceName = ContextHelper.getStringSafe(request, "txtSzNmResource");
    String sCityName = ContextHelper.getStringSafe(request, "txtSzAddrRsrcAddrCity");
    String sCategory = ContextHelper.getStringSafe(request, "selSzCdRsrcCategory");
    String selectedRegion = ContextHelper.getStringSafe(request, "selSzCdRsrcRegion");
    String sHomeStatus = ContextHelper.getStringSafe(request, "selSzCdRsrcFaHomeStatus");
    String sResourceCounty = ContextHelper.getStringSafe(request, "selSzCdRsrcCnty");
    String sHomeType = ContextHelper.getStringSafe(request, "selCCdRsrcFaHomeType1");
    String language = ContextHelper.getStringSafe(request, "selSzCdRsrcLanguage");
    String nbrChildId = ContextHelper.getStringSafe(request, "txtNbrChildPersonId");
    int capacity = ContextHelper.getIntSafe(request, "txtNbrRsrcFacilCapacity");
    // user profile information to grab user security rights joshd
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    // to string for comparison on category joshd
    String Adoption = "A";
    String AdoptLegal = "L";
    // Perform the following validation for 'Search'
    if (super.isButtonPressed(SEARCH_BUTTON)) {
      // Resource id is all that is required to perform a search. If user has
      // entered a resource id, do not perform any other validation.
      if (sResourceId > 0) {
        isValidForSearch = true;
        return isValidForSearch;
      }
      // To perform a search, user must enter at least one of the following
      // search criteria: resource id, resource name, category or region.
      if (sResourceId == 0 &&
          !StringHelper.isValid(sResourceName) &&
          !StringHelper.isValid(sCategory) &&
          !StringHelper.isValid(selectedRegion)) {
        isValidForSearch = false;
        setErrorMessage(Messages.MSG_RSRC_ENT_SEARCH_PARAM);
        return isValidForSearch;
      }

      // Validation if user has selected 'Statewide' as the region...
      if (sResourceId == 0 &&
          StringHelper.isValid(selectedRegion) &&
          selectedRegion.equals(CodesTables.CSVCRGNS_98)) {
        // User cannot select 'Statewide' as the region and specify a resource
        // name.
        if (StringHelper.isValid(sResourceName)) {
          isValidForSearch = false;
          setErrorMessage("txtSzNmResource", Messages.SSM_FAD_REGION_MISMATCH);
          return isValidForSearch;
        }

        // If user has selected 'Statewide' as the region, at least one of the
        // following criteria must also be entered: home status, county,
        // category or city.
        if (!StringHelper.isValid(sHomeStatus) &&
            !StringHelper.isValid(sResourceCounty) &&
            !StringHelper.isValid(sCategory) &&
            !StringHelper.isValid(sCityName)) {
          isValidForSearch = false;
          setErrorMessage(Messages.SSM_ENTER_CRITERIA);
          return isValidForSearch;
        }
      } // end if region is 'Statewide'

      // Home name and city must start with a letter.
      if (StringHelper.isValid(sResourceName) ||
          StringHelper.isValid(sCityName)) {
        Character c = null;
        char cChar;
        boolean b = false;

        // Check the home name field.
        if (StringHelper.isValid(sResourceName)) {
          cChar = sResourceName.charAt(0);
          b = c.isDigit(cChar);
          if (b) {
            isValidForSearch = false;
            setErrorMessage("txtSzNmResource", Messages.SSM_FAD_INVALID_HOME_NAME);
            return isValidForSearch;
          }
        }

        // Check the city field.
        if (StringHelper.isValid(sCityName)) {
          cChar = sCityName.charAt(0);
          b = c.isDigit(cChar);
          if (b) {
            isValidForSearch = false;
            setErrorMessage("txtSzAddrRsrcAddrCity", Messages.SSM_FAD_INVALID_HOME_NAME);
            return isValidForSearch;
          }
        }
      } // end home name and city must start with a letter.

      int j = 0;
      int iCharacteristicsCounter = 0;

      // User can select no more than 5 characteristics.
      for (j = 1; j < iNumberOfCharacteristics + 1; j++) {
        String sChkBox = "cbCharacteristics";
        sChkBox = sChkBox.concat(Integer.toString(j));
        if (StringHelper.getSafeString(request.getParameter(sChkBox)) != null) {
          iCharacteristicsCounter++;
          if (iCharacteristicsCounter > iNumberOfCheckedBoxes) {
            isValidForSearch = false;
            setErrorMessage(Messages.MSG_FAD_NO_MORE_CHAR);
            return isValidForSearch;
          }
        }
      }

      String cdPersonSex = ContextHelper.getStringSafe(request, "selCCdPersonSex");
      int iMin = ContextHelper.getIntSafe(request, "minAge");
      int iMax = ContextHelper.getIntSafe(request, "maxAge");

      /* if sex is selected, then age must be known and vice versa*/
      if (StringHelper.isValid(cdPersonSex)) {
        if (iMin == 0 || iMax == 0) {
          isValidForSearch = false;
          setErrorMessage("cbxMinYear", Messages.MSG_FAD_AGE_REQ);
        } else if (iMin > iMax) {
          isValidForSearch = false;
          setErrorMessage("cbxMinYear", Messages.MSG_AGE_MIN_LESS_MAX);
        }
      } else {
        if (iMin != 0 || iMax != 0) {
          isValidForSearch = false;
          setErrorMessage("selCCdPersonSex", Messages.MSG_GENDER_REQ_AGE_RNGE);
        }
      }

      boolean noExtraParams = (!StringHelper.isValid(sResourceName) &&
                               !StringHelper.isValid(sCityName) &&
                               !StringHelper.isValid(cdPersonSex) &&
                               !StringHelper.isValid(sHomeStatus) &&
                               !StringHelper.isValid(sResourceCounty) &&
                               !StringHelper.isValid(sHomeType) &&
                               !StringHelper.isValid(language) &&
                               capacity == 0 &&
                               iCharacteristicsCounter == 0 &&
                               iMin == 0 &&
                               iMax == 0);

      // User cannot perform a search with only Region or only Category.
      if (isValidForSearch &&
          noExtraParams &&
          !(StringHelper.isValid(sCategory) &&
            StringHelper.isValid(selectedRegion))) {
        isValidForSearch = false;
        setErrorMessage(Messages.SSM_ENTER_CRITERIA);
      }
   // end if( super.isButtonPressed( SEARCH_BUTTON ) )
      // ECEM 5.0 Displaying message if user does a child search without entering a anything
		} else if (super.isButtonPressed("btnChildLookUp")) {
			if ("".equals(nbrChildId) || nbrChildId == null) {
				setErrorMessage("txtNbrChildPersonId",
						Messages.MSG_INVALID_PERSON_ID);
				Boolean childSearchBtnPressed = true;
				state.setAttribute("childSearchBtnPressed",
						childSearchBtnPressed, request);
				isValidForSearch = false;
			}

		}

    return isValidForSearch;
  }
}
