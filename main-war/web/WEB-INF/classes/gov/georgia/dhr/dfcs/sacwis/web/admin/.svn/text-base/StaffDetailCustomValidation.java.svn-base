package gov.georgia.dhr.dfcs.sacwis.web.admin;

// -- architecture classes --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;

/**
 * StaffDetail  .jsp Custom validation class <p>Description:  This class looks for an end date and also retrieves the
 * Mail county based on the unit, region and program </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 * <pre>
 * Change History:
 * Date      User      Description
 * --------  --------- ------------------------------------------------------------------------------------------------
 * 10/13/03  dickmaec  SIR 19857 -- ContextHelper.get... replaces getInputValue();
 * 4/7/2004  gerryc    SIR 22808 - added error if they are trying to update a person who
 *                     was previously terminated.  They need to remove the termination date first
 *                     because otherwise the next time the page loads, the termination date is still
 *                     displayed, and the unit information is blank.  When the user tries to re-add it
 *                     they are taken to the job history detail, and there's conflict between the
 *                     previous job history start date (recent) and the end date (term date)
 * 05/06/04  CORLEYAN  SIR 22869 -- Make sure if the user has entered an Eth that a Race is
 *                     entered, and vice versa
 * </pre>
 *
 * @author Jeff Chambers
 * @version 1.0
 */

public class StaffDetailCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "StaffDetailCustomValidation";

  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    //UNUSED: RaceEthnicityBean reBean = new RaceEthnicityBean();

    //SIR 22808 changed from strings to castor dates
    //UNUSED: org.exolab.castor.types.Date endDated = ContextHelper.getCastorDateSafe(request, "hdnEndDated");
    org.exolab.castor.types.Date termDate = ContextHelper.getCastorDateSafe(request, "txtDtJobTerm");
    org.exolab.castor.types.Date prevTermDate = ContextHelper.getCastorDateSafe(request, "hdnDtPrevTermDate");

    boolean result = true;

/*    try {
      //validating mail code for office selected
      CCMN40SI ccmn40si = populateCCMN40SO_MailCode(request);
      CCMN40SO ccmn40so = getEjb(Admin.class).retrieveOfficeName(ccmn40si);
      int ulIdOffice = ccmn40so.getUlIdOffice();
      request.setAttribute("ulIdOffice", "" + ulIdOffice);
    } catch (ServiceException we) {
      setErrorMessage(MessageLookup.getMessageByNumber(we.getErrorCode()));
      result = false;
    } catch (Exception e) {
      setErrorMessage(e.getMessage());
      result = false;
    }*/

    /*SIR 22808 - added custom error message to remove the termination date if
     trying to update a record for someone with a termination date.
     This only throws an error if there was a previous term date.  That way,
     workers who enter a term date for the first time won't get this*/
    if (termDate != null && prevTermDate != null) {
      setErrorMessage("txtDtJobTerm", MessageLookup.getMessageByNumber(Messages.MSG_CMN_REMOVE_TERM_DATE));
      result = false;
    }

    // SIR 22869
    if ((RaceEthnicityHelper.isEthnicityChecked(request) && !RaceEthnicityHelper.isRaceChecked(request)) ||
        (!RaceEthnicityHelper.isEthnicityChecked(request) && RaceEthnicityHelper.isRaceChecked(request))) {
      setErrorMessage(Messages.SSM_ETHNIC_AND_RACE);
      result = false;
    }

    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! ");
    performanceTrace.exitScope();
    return result;
  }

  private CCMN40SI populateCCMN40SO_MailCode(HttpServletRequest request) {

    //Allocate the structures
    ArchInputStruct input = new ArchInputStruct();
    CCMN40SI ccmn40si = new CCMN40SI();

    //Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setBPerfInd("Y");
    input.setBDataAcsInd("Y");
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(50);

    ccmn40si.setArchInputStruct(input);

    // Call service to get new ulIdOffice if mail code changed
    // ccmn40si.setSzAddrMailCode( ContextHelper.getStringSafe(request, "txtSzAddrMailCode").toUpperCase() );
    // ccmn40si.setSzAddrMailCode( ContextHelper.getStringSafe(request, "txtSzAddrMailCode"));
    ccmn40si.setSzCdCounty(ContextHelper.getStringSafe(request, "cboSzCdCounty"));
    ccmn40si.setSzCdOfficeRegion(ContextHelper.getStringSafe(request, "cboSzCdUnitRegion"));
    ccmn40si.setSzNmOfficeName(ContextHelper.getStringSafe(request, "cboSzCdOfficeLocation"));
    return ccmn40si;
  }
}