package gov.georgia.dhr.dfcs.sacwis.web.contacts;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.document.NewUsingDocumentValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSVC02SIG03;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSVC02SIG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TCMClaimSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimValidateSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelperException;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper.ObjectActionCodePair;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentRecordHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * <p>
 * Title: ContactSearchListDetailConversation
 * </p>
 * <p>
 * Description: This is the Conversation class used to search for contacts and summaries of open or closed stages that
 * relate to a particular case and display the Detail Information.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: TDPRS
 * </p>
 * <p/> <p/>
 * 
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  ----------------------------------------------
 * 02/08/03  Todd Reser       Initial creation; merge of the old
 *                            ContactDetailConversation and
 *                            ContactSearchListConversation.
 * 02/10/03  Todd Reser       Added functionality to handle portions of New
 *                            Using, Display and Add.
 * 02/13/03  Todd Reser       Finished implementing New Using, Add &amp; Display,
 *                            Removed old error Message MSG_SELECT_CNTCTD_PRSN.
 * 02/14/03  Todd Reser       Cleaned up Error Handling.
 * 02/17/03  Todd Reser       Removed MSG_FAD_SUBMIT_SUM because it is handled
 *                            in custom validation
 * 02/18/03  Todd Reser       Moved csys08so to State.  Added CheckboxHelper to
 *                            populateCSYS07.  Added error handling default
 *                            cases.
 * 02/19/03  Todd Reser       Added placeholders for launchDocument and
 *                            SaveSubmit. Updated Javadocs.  Implemented Staff
 *                            Pullback.
 * 02/21/03  Todd Reser       Added to csys07s populating of setBIndReview and
 *                            setBIndVictimSelected.
 * 02/28/03  Todd Reser       Added System outs to try and assist in debugging.
 * 03/10/03  Todd Reser       Undid werlemk's changes and added PageMode.
 * 03/11/03  Todd Reser       Fixed population of TaskCode from CCMN45.
 * 03/12/03  Todd Reser       Added population of EventId from CaseUtility.
 * 03/13/03  Todd Reser       Added population of szCdEventStatus in 07AUD.
 *                            Added functionality for Add &amp; Delete.
 * 03/14/03  Todd Reser       Added functionality to display SearchList after a
 *                            delete.
 * 03/15/03  Todd Reser       Modified displayContact_xa to get values from
 *                            request, then if they were null or &quot;&quot; to get it
 *                            from rowcsys04so to allow for calling from
 *                            saveContact_xa
 * 03/18/03  Todd Reser       Fixed eventId for display of Details.
 * 03/19/03  Todd Reser       Added function determineTemplate, and constants.
 *                            Implemented PageModes.
 * 03/20/03  Todd Reser       Switched displayContact to use hdnUlRowSelected.
 * 03/26/03  Todd Reser       QA Sweep.
 * 03/31/03  Todd Reser       Fixed Narrative button.
 * 04/01/03  Todd Reser       Changed New Using to Add not Update.
 * 04/02/03  Todd Reser       Removed useless Display Document Function.
 *                            Fixed Document save.
 * 04/11/03  Todd Reser       Switched Event Information in pop07 to
 *                            CaseUtility Event info.
 * 04/14/03  Todd Reser       Put ulRow Selected into State when calling staff
 *                            Pullback, added code to display_xa to get it from
 *                            state if it is not null.
 * 04/16/03  Todd Reser       Added code to put all form items into state when
 *                            calling retrieveStaff_xa, and to get items from
 *                            state in displayContact_xa.
 * 04/17/03  Todd Reser       Fixed Add's by setting EventId to 0 when Adding.
 * 04/23/03  Todd Reser       Fixed linking from Event List by getting ulIdEvent
 *                            from Global Data.
 * 04/24/03  Todd Reser       Implemented ToDo's in SaveSubmit_xa.
 * 04/28/03  Todd Reser       Set Begin &amp; End dates to EMPTY_STRING in
 *                            Continue_xa. Changed &quot;Y&quot;, &quot;N&quot;, &quot;S&quot;, &quot;true&quot;,
 *                            and &quot;false&quot; to ArchitectureConstants. Deleted
 *                            unused/commented out code.
 * 04/30/03  Todd Reser       Added input.setUlPageSizeNbr code to pop_07.
 * 05/07/03  Todd Reser       Added while loop to DisplayContact to loop through
 *                            pages of csys04so's to find a ulIdEvent match.
 * 05/08/03  Todd Reser       Populated and input into state rowcsys04so in
 *                            displayContact_xa so re-display would work after a
 *                            save.
 * 05/10/03  KRD              SIR 17233 - Code changes applied to support
 *                            &quot;Approver Mode&quot; providing supervisors the ability
 *                            to modify data without invalidating the pending
 *                            approval.  Required changes to
 *                            populateCSYS07SI_AUD().
 * 05/12/03  Todd Reser       Added Null checks for rowcsys04soArray, removed
 *                            ROWCCMN45SOG00 setting of TaskCode.
 * 05/14/03  Todd Reser       Reverted to a previous version since all edits
 *                            made yesterday were useless.  Modified upgrading
 *                            of PENDing if statment to match CAPS.  Added a
 *                            null check to Pending upgrade if statment.
 * 05/15/03  Todd Reser       Added a lot of static constants, created
 *                            determineStageProgram, and determineTaskCode.
 * 05/16/03  Todd Reser       Ripped out unused Constants.  Practically rewrote
 *                            the display, continue and add methods.
 * 05/27/03  Todd Reser       Modified addContact to catch if someone does not
 *                            have Stage Access and they are trying to add a
 *                            Contact other than Closed Stage Addendum.
 * 05/29/03  Todd Reser       Changed hdnSzNmPersonFull to szNmPersonFull.
 * 06/04/03  Todd Reser       Switched from PageMode.APPROVE.equals(
 *                            GlobalData.getAppMode(request)) to
 *                            GlobalData.isApprovalMode(request)
 * 06/05/03  Todd Reser       Set the csys08so User Name and ID to the currently
 *                            logged in user when adding a contact.
 * 06/06/03  GRIMSHAN         SIR 16979 in display contact call page mode set in
 *                            event conversation.  If the page mode needs to be
 *                            re-set because it is not being called by event
 *                            list, the logic in that method will reset it
 * 06/12/03  Todd Reser       SIR 18215 - We needed to pass the ulIdEvent of the
 *                            NewUsed Contact so that the DocumentUtilityHelpers
 *                            can use it to copy the document when Saving.
 * 06/13/03  Todd Reser       SIR 18285 - Had to move pageMode setting to just
 *                            before DocumentRecordHelper call because it wasn't
 *                            being executed.
 * 06/16/03  Todd Reser       SIR 18274 - Modified page so that if Adding an
 *                            EEXR, it redirects to the Save Method instead of
 *                            making the user press Save.
 * 06/19/03  Todd Reser       SIR 18414 Added isApprovalMode to if statment to
 *                            supress messages when entering in Approval mode.
 * 06/20/03  Todd Reser       SIR 18428 - Removed Approval Status popup message.
 *                            SIR 18353 - NewUsed Approved Contacts weren't
 *                            able to be saved.
 * 07/01/03  Ochumd           Sir 18474 - Task Message &quot;Person Home Study
 *                            submitted for approval&quot; Changed to read  &quot;F/A Home
 *                            Study Submitted for Approval&quot;.
 * 07/03/2003 CASDORJM        SIR 18616 - Originally we used
 *                            CheckboxHelper.getChangedValues() to populate the
 *                            rowcsvc02sig03 and rowcsys07si objects.  I added
 *                            a special case for new using since the checkboxes
 *                            populated by the new using feature would not
 *                            register as changed values.  By using
 *                            CheckboxHelper.getCheckedValues() and setting the
 *                            actionCode to ADD for the initial save of all new
 *                            usings, we are able to get the save to function
 *                            correctly.
 * 07/25/03  Todd Reser       SIR 19163 - Had to add 24N and FTF to detailArray
 *                            so the page would allow data to be entered instead
 *                            of eternally staying in Initial PresenationMode.
 * 10/28/03  Todd Reser       Removed a System.out.println of the CSYS08 object.
 * 11/12/03  Todd Reser       Updated a missing Javadoc paramter.
 * 03/11/04  Todd Reser       SIR 22657 - Added CSQ to detailArray
 * 04/24/04  Todd Reser       SIR 15161 - Need the Event date to be the system
 *                            date of data entry.
 * 06/30/04  CORLEYAN         SIR 22985 - If the service returns an error on save
 *                            and submit, we want to handle that error appropriately,
 *                            not process severe exception.  Also, removed hard coded
 *                            message and replaced with Message in DB
 * 08/18/04  Todd Reser       SIR 22947 - Added TOO_MANY_CONTACTS_IN_MONTHLY to
 *                            handleContactDetailAUDError
 * 10/29/04  gerryc           SIR 15280 - added stage type to the csys07s input
 *                            in order to use it later to distinguish between
 *                            SVC REG and SVC GUA.
 * 2/10/05   gerryc           SIR 14291 - set indicator so that the new three month
 *                            review to dos and contacts are now created again
 *                            upon saving old ones.
 * 02/28/05  marallh          SIR 23410 - Added LEV and LES to detailArray
 * 07/05/05  berkime          SIR 23298 Added CAGR as a contact type to detail Array
 * 07/14/05  cooganpj         SIR 23726 - Lockdown changes for MPS Phase II
 * 07/18/05  cooganpj         SIR 23726 - Added condition for both types of 24 hour contacts.
 * 07/20/05  cooganpj         SIR 23728 - Added condition for view only contacts in MPS when
 *                            pending approval.
 * 07/24/05  werlem           SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 * 08/08/05  pisharrk         SIR 23867 - To make Monthly Status APS contacts non-editable in MPS, if the
 *                            checked out case is in Pending ('PEND') status.
 * 08/17/05  mkw              Phase II -- Added check for getCdMobileStatus to
 *                            check for error status and set page mode
 *                            appropriately.
 * 09/20/05  mkw              Phase III -- Enhancements for Facility and APS:
 *                            SIRs 23968, 23949, and 23950.
 * 09/23/05  cooganpj         SIR 23966 - Edited code to fully address MPS lockdown for AFC
 *                            stages in pending status.
 * 10/13/05  pisharrk         SIR 24020 - Added a conditional clause to make auto generated 'Monthly Status
 *                            APS' contacts (for APS, INV stages, including Pending stages) editable in IMPACT.
 * 10/20/05  pisharrk         SIR 24020 - Voided the above changes and modified an existing conditional clause
 *                            to eliminate a bug produced by the earlier fix.
 * 06/19/08   pjcoogan        STGAP00008568: Move safety resource assessment narrative from contact
 *                            to Safety Resource page.
 * 10/31/09  mchillman         STGAP00010898 Added code for ADO Sealing
 * 
 * 06/01/09  cwells            STGAP00014023 Checking to see if user was ever assigned to a case if so
 *                             we want to display the add button even if the stage is closed 
 * 06/20/09  arege             STGAP00014326 MR-024 Changes 
 * 07/09/09  arege             STGAP00014327 MR-024 Changes
 * 07/22/09  arege             STGAP00014327 MR-024 Changes        
 * 07/25/09  arege             STGAP00014327 Set All Contacts in Case Checkbox to be selected by default.
 * 07/26/09  arege             STGAP00014326 - Modified code to set correct page mode.
 * 07/28/09  arege             STGAP00014858 Modified code so that TCM contact with TCMclaim in NBL status
 *                             can be modified for 7 days.
 * 07/30/09  arege             STGAP00014857 CaseWorkers with SAU Sealed Attribute should be able to add and modify
 *                             contacts
 * 08/04/09  arege             STGAP00014856 Removed unnecessary Error Message on Page when INV conclusion event is in PEND.
 * 08/06/09  arege             STGAP00014856 Commented out unnecessary Error Message generated while adding new contacts when there there is 
 *                             a Pending CCL event. 
 * 08/30/09  arege             STGAP00015191 and STGAP00015282  Purpose fields and collaterals and Principal contacted fields not saved
 *                             when copying an existing Contact.
 * 09/07/09  arege             STGAP00015300 Modified code to reflect change in widget names on jsp. 
 * 09/14/09  arege             STGAP00015320 MR 24 Event List page with a Contact event no longer gives complete description.
 * 09/16/09  arege             STGAP00015282 If a Contact is copied , the DtEnteredOn should be the date on which the contact 
 *                             was copied.  
 * 09/28/09  arege             STGAP00015444: Check mark on saving narrative of type PCV does not appear after saving Contact Detail Page.
 *                             Contact_Narrative table should be used to save narratives of all types.
 * 09/29/09  arege             STGAP00015281 Narrative is not being deleted with change of Narrative Type.
 * 02/17/10  swroberts         MR-061 Added sorting of contact list by contact date.
 * 02/23/10  wjcochran         MR-062 Added variable to indicate whether or not adding a contact is allowed
 * 06/04/10  arege             SMS#52235: Contacts created before sealing could not be viewed and copied for Adoptive homes
 *                             by anybody except SAUSealed.
 * 08/16/10  bgehlot           66380 MR072 Add new field Discussed/In Reference to
 * 05/24/11  schoi             SMS #109398: MR-086 Added an array for Contact Type of Transfer Summary to handle added fields 
 *                             on the Transfer Summary Contact Detail page
 * 03/28/12  cminor			   STGAP00016837:  Added additional check for if user is copying an existing CONTACT to edit.  If copying
 * 							   then CONTACT creator is replace with currently logged in user for creation of te new CONACT record.
 * 04/09/12	 cminor			   STGAP00018101: Changed DAO call to use overloaded method created for STGAP00016837 to correct Logged in user
 * 							   name and Logged in User title
 *   
 * </pre>
 * 
 * @author Todd Reser, Februrary 8, 2003
 */
@SuppressWarnings("serial")
public class ContactSearchListDetailConversation extends BaseHiddenFieldStateConversation {

  public static final String DETAIL_CONTACT = "DETAIL_CONTACT";

  public static final String SUMMARY_CONTACT = "SUMMARY_CONTACT";
  
  // SMS #109398: MR-086
  // Presentataion Mode to handle Contact Type of Transfer Summary
  public static final String TRN_SUMMARY_CONTACT = "TRN_SUMMARY_CONTACT";

  public static final String INITIAL_CONTACT = "INITIAL_CONTACT";

  public static final String TRACE_TAG = "ContactSearchListDetailConversation";

  public static final String DISPLAY_LIST_PAGE = "/contacts/ContactSearchListDetail/displayContactSearchList";

  public static final String DISPLAY_DETAIL_PAGE = "/contacts/ContactSearchListDetail/displayContact";

  public static final String VISITATION_NARRATIVE_TABLE_NAME = "CONTACT_VISITATION_NARRATIVE"; // Used to save
                                                                                                // narrative of type PCV

  public static final String SAFETY_RSRC_ASMNT_NARR_TABLE_NAME = "SAFETY_RSRC_ASMNT_NARR";

  public static final String NARRATIVE_TABLE_NAME = "CONTACT_NARRATIVE"; // Used to save narratives of type Blank and
                                                                          // SPW

  public static final String CSYS08S = "CSYS08S";

  public static final String ROWCSYS04SO_STRING = "rowcsys04so";

  public static final String GENERALFAILURE = "General Failure:";

  public static final String SZCDCONTACTMETHOD = "szCdContactMethod";

  public static final String SZCDCONTACTPURPOSE = "szCdContactPurpose";

  public static final String CONTACTTYPE = "contactType";

  public static final String BINDCONTACTATTEMPTED = "bIndContactAttempted";

  public static final String DTDTCONTACTOCCURRED = "dtDtContactOccurred";

  public static final String CBXBINDCONTACTATTEMPTED = "cbxBIndContactAttempted";

  public static final String CBXBINDEXTCOMMENT = "cbxBIndExtComment";

  public static final String SELSZCDCONTACTMETHOD = "selSzCdContactMethod";

  public static final String SELSZCDCONTACTPURPOSE = "selSzCdContactPurpose";

  public static final String SELSZCDCONTACTTYPE = "selSzCdContactType";

  public static final String SELSZCDCONTACTLOCATION = "selSzCdContactLocation";

  public static final String SELSZCDCONTACTOTHERS = "selSzCdContactOthers";

  public static final String TXTDTDTMONTHLYSUMMBEGIN = "txtDtDtMonthlySummBegin";

  public static final String TXTDTDTMONTHLYSUMMEND = "txtDtDtMonthlySummEnd";

  public static final String TXTDTDTCONTACTOCCURRED = "txtDtDtContactOccurred";

  public static final String TXTTMSCRCNTCT = "txtTmScrTmCntct";

  public static final String DOCEXISTS = "docExists";

  public static final String GENERIC_CONTACT = "CONNARR";

  public static final String HDNULROWSELECTED = "hdnUlRowSelected";

  public static final String HDNENTEREDON = "hdnEnteredOn"; // MR-024

  public static final String ULROWSELECTED = "ulRowSelected";

  public static final String DISABLE_TCM_GUARANTOR_PC_NAME = "disable_selGuarantorPC";

  public static final String CONTACT_TYPE_FAD_CLOS_SUMM = "FCL";

  public static final String CONTACT_TYPE_MNTH_SUM = "MTH";

  public static final String CONTACT_TYPE_SUB_TRANS = "STS";

  public static final String CONTACT_TYPE_COMP_CHECK = "CMP";

  public static final String CONTACT_TYPE_PERS_HOME_STUDY = "PHS";

  public static final String CONTACT_TYPE_EXT_REQ = "EXR";

  public static final String CONTACT_TYPE_REGULAR = "REG";

  public static final String CONTACT_TYPE_CORRECT_ACT_SUM = "ATZ";

  public static final String CONTACT_TYPE_CORR_ACTION = "ATP";

  public static final String CONTACT_TYPE_MONTH_ASSES = "MAS";

  public static final String CONTACT_TYPE_REEVALUATION = "REA";

  public static final String CONTACT_TYPE_SERIOUS_INC = "SEI";

  public static final String CONTACT_TYPE_VARIANCE = "VAR";

  public static final String CONTACT_TYPE_VIOLATION = "VIO";

  public static final String CONTACT_DEVELOP_PLAN_SUM = "DVZ";

  public static final String CONTACT_CLOSING_SUM_SUM = "FAZ";

  public static final String CONTACT_MONTH_ASSESS_SUM = "MAZ";

  public static final String CONTACT_THREE_MONTH_SUM = "C3MT";// 14291

  public static final String CONTACT_PERS_HOME_STUDY_SUM = "PHZ";

  public static final String CONTACT_QUARTER_VISIT_SUM = "QUZ";

  public static final String CONTACT_REEVALUATION_SUM = "REE";

  public static final String CONTACT_REGULAR_SUM = "REZ";

  public static final String CONTACT_SERIOUS_INC_SUM = "SEZ";

  public static final String CONTACT_VARIANCE_SUM = "VAZ";

  public static final String CONTACT_VIOLATION_SUM = "VIZ";

  public static final String CONTACT_QUARTER_VISIT = "QUV";

  public static final String CONTACT_TYPE_DEVELOP_PLAN = "DVP";

  public static final String CONTACT_TYPE_GUARDIANSHIP_REFERRAL = "AGR";// 23298

  public static final String CONTACTS_ARI = "3810";

  public static final String CONTACTS_ARF = "3910";

  public static final String CONTACTS_INT = "1010";

  public static final String CONTACTS_INV = "2180";

  public static final String CONTACTS_FPR = "7020";

  public static final String CONTACTS_DIV = "1510";

  public static final String CONTACTS_FSU = "4120";

  public static final String CONTACTS_FAD = "8060";

  public static final String CONTACTS_PAD = "9010";

  public static final String CONTACTS_ADO = "8520";

  public static final String CONTACTS_SUB = "3010";

  public static final String CONTACTS_PFC = "6530";

  public static final String TODO_DESC_HOME_STUDY = "F/A Home Study submitted for approval";

  public static final String TODO_DESC_TRANSFER_SUMMARY = "Transfer Summary submitted for approval";

  public static final String TODO_DESC_MNTH_SUMM = "Monthly summary submitted for approval";

  public static final String TODO_DESC_REGULAR = "Contact submitted for approval";

  public static final String TODO_DESC_CORRECTIVE_ACTION = "Corrective Action submitted for approval";

  public static final String TODO_DESC_DEVELOPMENT_PLAN = "Developmental Plan submitted for approval";

  public static final String TODO_DESC_CLOSING_SUM = "F/A Home Closing Summary submitted for approval";

  public static final String TODO_DESC_MONTH_ASSESS = "Monthly Assessment submitted for approval";

  public static final String TODO_DESC_QUARTER_VISIT = "Quarterly Assessment submitted for approval";

  public static final String TODO_DESC_REEVALUATION = "Re-evaluation submitted for approval";

  public static final String TODO_DESC_SERIOUS_INC = "Serious Incident submitted for approval";

  public static final String TODO_DESC_VARIANCE = "Variance submitted for approval";

  public static final String TODO_DESC_VIOLATION = "Violation submitted for approval";

  public static final String TODO_DESC_COMP_CHECK = "Completion Check submitted for approval";

  public static final String TODO_DESC_FA_HOME_STUDY = "F/A Home Study submitted for approval";

  public static final String TODO_DESC_EXT_REQ = "Extension Request submitted for approval";

  public static final String TODO_DESC_GUARDIANSHIP_REFERRAL = "APS Guardianship Referral submitted for approval";// 23298

  public static final String SVC_CD_TASK_APRV_MONTHLY = "7170";

  public static final String SVC_CD_TASK_APRV_FPR_PHS = "7290";

  public static final String SVC_CD_TASK_APRV_FMR_PHS = "5930";

  public static final String SVC_CD_TASK_APRV_FSC_PHS = "4430";

  public static final String SVC_CD_TASK_APRV_SUB_PHS = "3440";

  public static final String SVC_CD_TASK_APRV_SUB_REG = "3300";

  public static final String SVC_CD_TASK_APRV_SUB_MNTH = "3280";

  public static final String SVC_CD_TASK_APRV_SUB_TRANS = "3430";

  public static final String SVC_CD_TASK_APRV_ADO_REG = "8810";

  public static final String SVC_CD_TASK_APRV_ADO_MNTH = "8790";

  public static final String SVC_CD_TASK_APRV_ADO_TRANS = "8820";

  public static final String SVC_CD_TASK_APRV_FMR_MNTH = "5810";

  public static final String SVC_CD_TASK_APRV_FSC_MNTH = "4310";

  public static final String SVC_CD_TASK_APRV_EXT_REQ = "2395";

  public static final String SVC_CD_TASK_APRV_FAD_CONTACT = "8300";

  public static final String SVC_CD_TASK_APRV_PAL_MNTH = "3590";

  public static final String SVC_CD_TASK_APRV_PAD_MNTH = "9280";

  public static final String SVC_CD_TASK_CONTACT_ARI_AFC = "3610";

  public static final String SVC_CD_TASK_APRV_INV_AGR = "2040";

  public static final String SVC_CD_TASK_APRV_SVC_AGR = "6030";

  public static final String STAGE_CODE_CPS_SVC = "FPR";

  public static final String STAGE_CODE_FMR = "FRE";

  public static final String STAGE_CODE_FSC = "FSU";

  public static final String STAGE_CODE_FAD = "FAD";

  public static final String STAGE_CODE_SUB = "SUB";

  public static final String STAGE_CODE_APS_SVC = "SVC";

  public static final String STAGE_CODE_INV = "INV";

  public static final String STAGE_CODE_ADO = "ADO";

  public static final Set<String> MOBILE_CONTACT_TYEPS = new HashSet<String>(
                                                                             Arrays
                                                                                   .asList(new String[] {
                                                                                                         CodesTables.CCNTCTYP_C24N, // 24
                                                                                                                                    // Hour
                                                                                                                                    // Contact
                                                                                                         CodesTables.CCNTCTYP_C24H, // 24
                                                                                                                                    // Hour
                                                                                                                                    // Contact
                                                                                                         CodesTables.CCNTCTYP_CIFF, // Initial
                                                                                                                                    // Face
                                                                                                                                    // To
                                                                                                                                    // Face
                                                                                                         CodesTables.CCNTCTYP_CFTF, // Initial
                                                                                                                                    // Face
                                                                                                                                    // To
                                                                                                                                    // Face
                                                                                                         CodesTables.CCNTCTYP_CMST, // Monthly
                                                                                                                                    // Status
                                                                                                                                    // APS
                                                                                                         CodesTables.CCNTCTYP_CSPV, // Supvry
                                                                                                                                    // Consultation
                                                                                                         CodesTables.CCNTCTYP_EREG, // Contact
                                                                                                         CodesTables.CCNTCTYP_EIFF, // Initial
                                                                                                                                    // Face
                                                                                                                                    // To
                                                                                                                                    // Face
                                                                                                         CodesTables.CCNTCTYP_EFAC, // Facilities
                                                                                                                                    // Closing
                                                                                                         CodesTables.CCNTCTYP_EDOC, // Documentary
                                                                                                         CodesTables.CCNTCTYP_EPHY // Physical
                                                                                                                                    // Evidence
                                                                                   }));

  public static final Set<String> NOTIFICATION_CONTACT_TYPES = new HashSet<String>(
                                                                                   Arrays
                                                                                         .asList(new String[] {
                                                                                                               CodesTables.CCNTCTYP_ANOT, // Notification
                                                                                                               CodesTables.CCNTCTYP_BNOT, // Notification
                                                                                                               CodesTables.CCNTCTYP_CNOT, // Notification
                                                                                                               CodesTables.CCNTCTYP_DNOT, // Notification
                                                                                                               CodesTables.CCNTCTYP_ENOT // Notification
                                                                                         }));

  public static final Set<String> NON_SUMMARY_CPS_FAD_CONTACT_TYPES = new HashSet<String>(
                                                                                          Arrays
                                                                                                .asList(new String[] {
                                                                                                                      CodesTables.CCNTCTYP_IATP, // Corrective
                                                                                                                                                  // Action
                                                                                                                      CodesTables.CCNTCTYP_IDVP, // Developmental
                                                                                                                                                  // Plan
                                                                                                                      CodesTables.CCNTCTYP_IMAS, // Monthly
                                                                                                                                                  // Assessment
                                                                                                                      CodesTables.CCNTCTYP_IPHS, // F/A
                                                                                                                                                  // Home
                                                                                                                                                  // Study
                                                                                                                      CodesTables.CCNTCTYP_IQUV, // Quarterly
                                                                                                                                                  // Assessment
                                                                                                                      CodesTables.CCNTCTYP_IREA, // Re-Evaluation
                                                                                                                      CodesTables.CCNTCTYP_ISEI, // Serious
                                                                                                                                                  // Incident
                                                                                                                      CodesTables.CCNTCTYP_IVAR, // Variance
                                                                                                                      CodesTables.CCNTCTYP_IVIO // Violation
                                                                                                }));

  private static final Set<String> CONTACTS_TASK_CODES = new HashSet<String>() {
    {
      add(CONTACTS_ARI);
      add(CONTACTS_ARF);
      add(CONTACTS_INT);
      add(CONTACTS_INV);
      add(CONTACTS_FPR);
      add(CONTACTS_DIV);
      add(CONTACTS_FSU);
      add(CONTACTS_FAD);
      add(CONTACTS_PAD);
      add(CONTACTS_ADO);
      add(CONTACTS_SUB);
      add(CONTACTS_PFC);
    }
  };

  private static final String MSG_CMN_NO_PC = "No Primary Child was found for this stage.";

  private Common common;

  private DocumentSave documentSave;

  private Financials financials;

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setDocumentSave(DocumentSave documentSave) {
    this.documentSave = documentSave;
  }

  public void setFinancials(Financials financials) {
    this.financials = financials;
  }

  /**
   * This helper method populates the input object for the csys03s retrieve service.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   * @return csys03si
   */
  private CSYS03SI populateCSYS03SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSYS03SI_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CSYS03SI csys03si = new CSYS03SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(50);
    input.setSzUserId(user.getUserLogonID());
    csys03si.setArchInputStruct(input);
    csys03si.setUlIdStage(GlobalData.getUlIdStage(request));

    performanceTrace.exitScope();
    return csys03si;
  }

  /**
   * This helper method populates the input object for the csys04s retrieve service.
   * 
   * @param context
   *                The GrndsExchangeContext object
   * @param pagination
   *                TuxedoPaginationValueBean.
   * @return csys04si
   */
  private CSYS04SI populateCSYS04SI_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean pagination) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSYS04SI_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CSYS04SI csys04si = new CSYS04SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(pagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(pagination.getResultDetails().getResultsPerPage());
    
    // MR-061 Added sorting for contact search/list
    input.setSzOrderBy(pagination.getResultDetails().getOrderBy());
    input.setSzOrderDirection(pagination.getResultDetails().getOrderByDirection());
    
    input.setSzUserId(user.getUserLogonID());
    
    csys04si.setArchInputStruct(input);
    csys04si.setUlIdStage(GlobalData.getUlIdStage(request));
    csys04si.setUlIdCase(GlobalData.getUlIdCase(request));
    // set the values for the Principals/Collaterals if any were checked
    ROWCSYS04SI_ARRAY csys04siArray = new ROWCSYS04SI_ARRAY();

    // see if the stage is a FSD stage and is sealed if so set the sealed date
    CaseUtility.Stage stage = CaseUtility.getStage(GlobalData.getUlIdStage(request));
    csys04si
            .setDtDtStageSealed((ArchitectureConstants.Y.equals(stage.getIndSealed()) && CodesTables.CSTAGES_FAD
                                                                                                                .equals(stage
                                                                                                                             .getCdStage())) ? stage
                                                                                                                                                    .getDtSealed()
                                                                                                                                            : null);

    // if deletedDetail != null then we don't populate anything else for CSYS04SI
    if (request.getAttribute("deletedDetail") == null) {
      String[] collateralsPrincipalsArray = CheckboxHelper.getCheckedValues(request, "cbxUlIdPerson");
      for (int i = 0; i < collateralsPrincipalsArray.length; i++) {
        ROWCSYS04SI csys04siRow = new ROWCSYS04SI();
        csys04siRow.setUlIdPerson(Integer.parseInt(collateralsPrincipalsArray[i]));
        csys04siArray.addROWCSYS04SI(csys04siRow);
      }

      // set the array into the si object after all of the rows are added
      csys04si.setROWCSYS04SI_ARRAY(csys04siArray);

      // Todo: Shouldn't this line be here???
      csys04si.setUlRowQty(csys04siArray.getUlRowQty());

      // if the Contacts for Case Checkbox is checked then set UlIdCase to
      // GlobalData.UlCaseId, otherwise set it to 0 so the service will do a
      // search including all stages.
      // MR-024
      csys04si.setUlIdCase(GlobalData.getUlIdCase(request));
      if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSearch.x"))) {
        if ("on".equals(ContextHelper.getStringSafe(request, "cbxUlIsCase"))) {
          csys04si.setUlIdCase(GlobalData.getUlIdCase(request));
        } else {
          csys04si.setUlIdCase(0);
        }
        request.setAttribute("SEARCHBTN", "true");
      } else {
        request.setAttribute("SEARCH_ENTIRE_CASE", "true");
      }

      csys04si.setDtScrSearchDateFrom(ContextHelper.getCastorDateSafe(request, "dtScrSearchDateFrom"));
      csys04si.setDtScrSearchDateTo(ContextHelper.getCastorDateSafe(request, "dtScrSearchDateTo"));
      csys04si.setSzCdContactType(ContextHelper.getStringSafe(request, SELSZCDCONTACTTYPE));
      csys04si.setSzCdContactPurpose(ContextHelper.getStringSafe(request, SELSZCDCONTACTPURPOSE));
      csys04si.setSzCdContactMethod(ContextHelper.getStringSafe(request, SELSZCDCONTACTMETHOD));
      csys04si.setSzCdContactLocation(ContextHelper.getStringSafe(request, SELSZCDCONTACTLOCATION));
      csys04si.setSzCdContactOthers(ContextHelper.getStringSafe(request, SELSZCDCONTACTOTHERS));
      // STGAP00014326 MR -024 set Purpose options
      String[] purposeChecks = CheckboxHelper.getCheckedValues(request, "cbxContactPurpose");
      ContactCbxRecord_Array cbxArray = new ContactCbxRecord_Array();
      for (String contactPurpose : purposeChecks) {
        ContactCbxRecord cbx = new ContactCbxRecord();
        cbx.setSzCdCbxCodeType(CodesTables.CCNTPURP);
        cbx.setSzCdContactCbx(contactPurpose);
        cbxArray.addContactCbxRecord(cbx);
      }
      csys04si.setContactCbxRecord_Array(cbxArray);
      
      //MR-072 set the values for the Discussed In Reference to if any were checked
      DiscussedPersonsSI_ARRAY discussedPersonsSI_ARRAY = new DiscussedPersonsSI_ARRAY();
      String[] discussedInReferenceToArray = CheckboxHelper.getCheckedValues(request, "cbxDiscussed");
      for (int i = 0; i < discussedInReferenceToArray.length; i++) {
        DiscussedPersonsSI discussedPersonsSI = new DiscussedPersonsSI();
        discussedPersonsSI.setUlIdPerson(Integer.parseInt(discussedInReferenceToArray[i]));
        discussedPersonsSI_ARRAY.addDiscussedPersonsSI(discussedPersonsSI);
      }

      // set the array into the si object after all of the rows are added
      csys04si.setDiscussedPersonsSI_ARRAY(discussedPersonsSI_ARRAY);

    }

    performanceTrace.exitScope();
    return csys04si;
  }

  /**
   * This helper method populates the input object for the csys07s AUD service.
   * 
   * @param context
   *                The GrndsExchangeContext object
   * @return csys07si
   * @throws CheckboxHelperException
   */
  private CSYS07SI populateCSYS07SI_AUD(GrndsExchangeContext context) throws CheckboxHelperException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSYS07SI_AU()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CSYS07SI csys07si = new CSYS07SI();
    ArchInputStruct input = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCSVC02SIG03_ARRAY rowcsvc02sig03_array = new ROWCSVC02SIG03_ARRAY();
    ROWCLSC97DIG00_ARRAY rowclsc97dig00_array = new ROWCLSC97DIG00_ARRAY();
    ROWCSYS07SI_ARRAY rowcsys07si_array = new ROWCSYS07SI_ARRAY();

    CSYS08SO csys08so = getCSYS08SO(request);
    if (csys08so == null) {
      csys08so = new CSYS08SO();
    }

    ROWCCMN45DO rowccmn45do = csys08so.getROWCCMN45DO();
    if (rowccmn45do == null) {
      rowccmn45do = new ROWCCMN45DO();
    }

    // If this is a NEW record the csys08so contact type will
    // not be filled so we grab the value from the hidden field on the contact detail page.
    String szCdContactType = ContextHelper.getStringSafe(request, "selSzCdContactType");
    if (szCdContactType == null) {
      szCdContactType = csys08so.getSzCdContactType();
    }
    if (szCdContactType.length() <= 3) {
      throw new IllegalStateException("szCdContactType(2) length is <= 3: '" + szCdContactType + "'");
    }
    String szScrTxtNarrStatus = csys08so.getSzScrTxtNarrStatus();

    // Get AUD Codes from checkboxes into SI objects
    ROWCSYS08SO_ARRAY contactList = csys08so.getROWCSYS08SO_ARRAY();
    int ulRowSelected = 0;

    // JMC - SIR 18616 - Originally we used CheckboxHelper.getChangedValues()
    // to populate the rowcsvc02sig03 and rowcsys07si objects. I added
    // a special case for new using since the checkboxes populated by the
    // new using feature would not register as changed values. By using
    // CheckboxHelper.getCheckedValues() and setting the actionCode to ADD
    // for the initial save of all new usings, we are able to get the
    // save to function correctly.

    // STGAP00015191 and STGAP00015282 : Purpose fields and collaterals and Principal contacted fields not saved
    // when copying an existing Contact.
    BaseSessionStateManager state = getSessionStateManager(context);

    if (PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))) {
      String[] allChecked = CheckboxHelper.getCheckedValues(request, "cbxUlIdPerson");
      int checked;
      for (int n = 0; n < allChecked.length; n++) {
        checked = Integer.parseInt(allChecked[n]);
        ROWCSVC02SIG03 rowcsvc02sig03 = new ROWCSVC02SIG03();
        rowcsvc02sig03.setUlIdPerson(checked);
        rowcsvc02sig03.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
        rowcsvc02sig03_array.addROWCSVC02SIG03(rowcsvc02sig03);

        ROWCSYS07SI rowcsys07si = new ROWCSYS07SI();
        rowcsys07si.setUlIdPerson(checked);
        rowcsys07si.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
        rowcsys07si_array.addROWCSYS07SI(rowcsys07si);

        ROWCLSC97DIG00 rowclsc97dig00 = new ROWCLSC97DIG00();
        rowclsc97dig00.setUlIdPerson(checked);
        rowclsc97dig00_array.addROWCLSC97DIG00(rowclsc97dig00);
      }
    } else {
      Collection<ObjectActionCodePair> contactChecks = CheckboxHelper.getChangedValues(request, "cbxUlIdPerson",
                                                                                       contactList, ROWCSYS08SO.class,
                                                                                       "ulIdPerson");

      Iterator<ObjectActionCodePair> i = contactChecks.iterator();
      while (i.hasNext()) {
        CheckboxHelper.ObjectActionCodePair pair = (CheckboxHelper.ObjectActionCodePair) i.next();
        String actionCode = pair.getActionCode();
        ROWCSYS08SO contact = (ROWCSYS08SO) pair.getObject();
        ROWCSVC02SIG03 rowcsvc02sig03 = new ROWCSVC02SIG03();
        rowcsvc02sig03.setUlIdPerson(contact.getUlIdPerson());
        rowcsvc02sig03.setSzCdScrDataAction(actionCode);
        rowcsvc02sig03.setTsLastUpdate(contact.getTsLastUpdate());
        rowcsvc02sig03_array.addROWCSVC02SIG03(rowcsvc02sig03);

        ROWCSYS07SI rowcsys07si = new ROWCSYS07SI();
        rowcsys07si.setUlIdPerson(contact.getUlIdPerson());
        rowcsys07si.setSzCdScrDataAction(actionCode);
        rowcsys07si.setTsLastUpdate(contact.getTsLastUpdate());
        rowcsys07si_array.addROWCSYS07SI(rowcsys07si);

        ROWCLSC97DIG00 rowclsc97dig00 = new ROWCLSC97DIG00();
        rowclsc97dig00.setUlIdPerson(contact.getUlIdPerson());
        rowclsc97dig00_array.addROWCLSC97DIG00(rowclsc97dig00);
        ulRowSelected++;
      }

      rowcsvc02sig03_array.setUlRowQty(rowcsvc02sig03_array.getROWCSVC02SIG03Count());
      rowcsys07si_array.setUlRowQty(rowcsys07si_array.getROWCSYS07SICount());
      rowclsc97dig00_array.setUlRowQty(rowclsc97dig00_array.getROWCLSC97DIG00Count());
    }

    // STGAP00014326 MR-024
    String[] privConversationChecks = CheckboxHelper.getCheckedValues(request, "cbxPrivConver");
    ROWPRIVCONVER_ARRAY privConversation_array = new ROWPRIVCONVER_ARRAY();
    ROWDELETEPRIVCONVER_ARRAY privDeleteConversation_array = new ROWDELETEPRIVCONVER_ARRAY();
    ROWPRIVCONVERSO_ARRAY rowPrivConverSOARRAY = (ROWPRIVCONVERSO_ARRAY) state
                                                                              .getAttribute(
                                                                                            "savedPrivConversationArray",
                                                                                            request);

    if (rowPrivConverSOARRAY != null) {
      Enumeration<ROWPRIVCONVERSO> privConverEnumeration = rowPrivConverSOARRAY.enumerateROWPRIVCONVERSO();
      while (privConverEnumeration.hasMoreElements()) {
        ROWPRIVCONVERSO rowPrivConverso = (ROWPRIVCONVERSO) privConverEnumeration.nextElement();
        Integer idPersonToDelete = rowPrivConverso.getUlIdPerson();
        ROWDELETEPRIVCONVER rowDeletePrivConversation = new ROWDELETEPRIVCONVER();
        rowDeletePrivConversation.setUlIdPerson(idPersonToDelete);
        privDeleteConversation_array.addROWDELETEPRIVCONVER(rowDeletePrivConversation);
      }
    }
    privDeleteConversation_array.setUlRowQty(privDeleteConversation_array.getROWDELETEPRIVCONVERCount());

    for (int j = 0; j < privConversationChecks.length; j++) {
      Integer idPerson = (Integer) (contactList.getROWCSYS08SO()[Integer.parseInt(privConversationChecks[j])]
                                                                                                             .getUlIdPerson());
      ROWPRIVCONVER rowPrivConversation = new ROWPRIVCONVER();
      rowPrivConversation.setUlIdPerson(idPerson);
      privConversation_array.addROWPRIVCONVER(rowPrivConversation);
      privConversation_array.setUlRowQty(privConversation_array.getROWPRIVCONVERCount());
    }

    // remove after forming add and delete lists,
    state.removeAttribute("savedPrivConversationArray", request);
    csys07si.setROWPRIVCONVER_ARRAY(privConversation_array);
    csys07si.setROWDELETEPRIVCONVER_ARRAY(privDeleteConversation_array);

    // End STGAP00014326 MR-024
    
    // MR-072
    String[] discussedPersonsChecks = CheckboxHelper.getCheckedValues(request, "cbxDiscussed");
    ROWDISCUSSED_ARRAY discussed_array = new ROWDISCUSSED_ARRAY();
    ROWDELETEDISCUSSED_ARRAY deleteDiscussed_array = new ROWDELETEDISCUSSED_ARRAY();
    ROWDISCUSSEDSO_ARRAY rowDiscussedSOARRAY = (ROWDISCUSSEDSO_ARRAY) state
                                                                              .getAttribute(
                                                                                            "savedDiscussedArray",
                                                                                            request);

    if (rowDiscussedSOARRAY != null) {
      Enumeration<ROWDISCUSSEDSO> discussedEnumeration = rowDiscussedSOARRAY.enumerateROWDISCUSSEDSO();
      while (discussedEnumeration.hasMoreElements()) {
        ROWDISCUSSEDSO rowDiscussedso = (ROWDISCUSSEDSO) discussedEnumeration.nextElement();
        Integer idPersonToDelete = rowDiscussedso.getUlIdPerson();
        ROWDELETEDISCUSSED rowDeleteDiscussed = new ROWDELETEDISCUSSED();
        rowDeleteDiscussed.setUlIdPerson(idPersonToDelete);
        deleteDiscussed_array.addROWDELETEDISCUSSED(rowDeleteDiscussed);
      }
    }
    deleteDiscussed_array.setUlRowQty(deleteDiscussed_array.getROWDELETEDISCUSSEDCount());

    for (int j = 0; j < discussedPersonsChecks.length; j++) {
      Integer idPerson = (Integer) (contactList.getROWCSYS08SO()[Integer.parseInt(discussedPersonsChecks[j])]
                                                                                                             .getUlIdPerson());
      ROWDISCUSSED rowDiscussed = new ROWDISCUSSED();
      rowDiscussed.setUlIdPerson(idPerson);
      discussed_array.addROWDISCUSSED(rowDiscussed);
      discussed_array.setUlRowQty(discussed_array.getROWDISCUSSEDCount());
    }

    // remove after forming add and delete lists,
    state.removeAttribute("savedDiscussedArray", request);
    csys07si.setROWDISCUSSED_ARRAY(discussed_array);
    csys07si.setROWDELETEDISCUSSED_ARRAY(deleteDiscussed_array);

    // End MR-072

    input.setSzUserId(user.getUserLogonID());
    int ulIdEvent = GlobalData.getUlIdEvent(request);

    String cReqFuncCd;
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnDelete.x"))) {
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_DELETE;
    } else if (ulIdEvent != 0) {
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else {
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    input.setCReqFuncCd(cReqFuncCd);

    // If contact type is null and eventStatus is new then the Page Size = 1
    // NOTE: We want to use the contact type we retrieved from csys08so, not the
    // szCdContactType string we initialize at the beginning of this method becuase
    // that will not be null even if this is a new record.
    if (CodesTables.CEVTSTAT_NEW.equals(rowccmn45do.getSzCdEventStatus())
        && (csys08so.getSzCdContactType() == null || "".equals(csys08so.getSzCdContactType()))) {
      input.setUlPageSizeNbr(1);
    } else {
      input.setUlPageSizeNbr(0);
    }

    // In CAPs, the usPageNbr was used to tell the service whether new contacts should be created or not.
    // In IMPACT, it was requested that there be no system generated contacts (this deals only w/ summaries).
    // We simply set the usPageNbr indicator to 1 which tricks the service into thinking the contacts have
    // already been generated and therefore does not generate any new monthly summaries.

    // SIR 14291 - add the generation of the three month summary contacts and todos.
    // SIR 15280 - only generate these for INV & SVC REG stages
    if (CONTACT_THREE_MONTH_SUM.equals(szCdContactType)
        && (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request)) || (CodesTables.CSTAGES_SVC
                                                                                                        .equals(GlobalData
                                                                                                                          .getSzCdStage(request)) && CodesTables.CSTGTYPE_REG
                                                                                                                                                                             .equals(GlobalData
                                                                                                                                                                                               .getSzCdStageType(request))))) {
      input.setUsPageNbr(0);
    } else {
      input.setUsPageNbr(1);
    }
    // We use the ulSysNbrReserved1 to tell the service we are in approval mode. If we are
    // in approval mode, the service will not invalidate the pending approval.
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));
    rowccmn01uig00.setSzCdTask(GlobalData.getSzCdTask(request));

    // We only need to set this Timestamp for Delete & Update
    if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_DELETE)
        || cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)) {
      rowccmn01uig00.setTsLastUpdate(rowccmn45do.getTsLastUpdate());
    }

    String szCdEventStatus = rowccmn45do.getSzCdEventStatus();
    if (szCdEventStatus == null) {
      szCdEventStatus = "";
    }

    // Always pass in the event from csys08so so we invalidate the approval when we need to do so
    csys07si.setUlIdEvent(csys08so.getUlIdEvent());

    // If we are in APPROVAL mode, we don't want to modify the event status.
    if (!ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {
      // If Status is not PENDing set it to COMPlete or PROCess
      if (!szCdEventStatus.equals(CodesTables.CEVTSTAT_PEND)
          || PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
        // Upgrade event to completed if meets requirements
        // (Save enabled, Narrative stored or exists)
        if ("24H".equals(szCdContactType) || "REG".equals(szCdContactType) || "CCA".equals(szCdContactType)
            || "MST".equals(szCdContactType) || "MTG".equals(szCdContactType) || "PHS".equals(szCdContactType)
            || "CMP".equals(szCdContactType) || "ATP".equals(szCdContactType) || "DVP".equals(szCdContactType)
            || "MAS".equals(szCdContactType) || "QUV".equals(szCdContactType) || "REA".equals(szCdContactType)
            || "SEI".equals(szCdContactType) || "VAR".equals(szCdContactType) || "VIO".equals(szCdContactType)
            || "REV".equals(szCdContactType)) {
          szCdEventStatus = "COMP";
        } else if ("MTH".equals(szCdContactType) && csys08so.getDtDtMonthlySummBegin().getDay() > (short) 0
                   && !"".equals(csys08so.getBScrIndStructNarrExists()) || !"".equals(szScrTxtNarrStatus)) {
          szCdEventStatus = "COMP";
        } else if (!"MTH".equals(szCdContactType) && !"".equals(csys08so.getBScrIndStructNarrExists())
                   || !"".equals(szScrTxtNarrStatus)) {
          szCdEventStatus = "COMP";
        } else {
          szCdEventStatus = "PROC";
        }
      }
    }
    rowccmn01uig00.setSzCdEventStatus(szCdEventStatus);

    rowccmn01uig00.setSzCdEventType("CON");

    if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
      rowccmn01uig00.setUlIdEvent(0);
      // SIR 15161 - Need the Event date to be the system date of data entry
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    } else {
      rowccmn01uig00.setUlIdEvent(GlobalData.getUlIdEvent(request));
      // Added this line so that the dtEntered field in Event table is not changed when you update a contact.
      rowccmn01uig00.setDtDtEventOccurred(csys08so.getDtDTContactEntered());
    }
    rowccmn01uig00.setUlIdStage(GlobalData.getUlIdStage(request));
    rowccmn01uig00.setUlIdPerson(csys08so.getUlIdPerson());

    rowcsvc02sig03_array.setUlRowQty(rowcsvc02sig03_array.getROWCSVC02SIG03Count());

    csys07si.setUlIdCase(GlobalData.getUlIdCase(request));
    csys07si.setSzCdStage(GlobalData.getSzCdStage(request));
    csys07si.setSzCdStageType(GlobalData.getSzCdStageType(request)); // SIR 15280 added

    csys07si.setSzCdStageClassification(csys08so.getSzCdStageClassification());
    if (csys08so.getUlNbrReviewContact() > 0) {
      csys07si.setBIndReview(ArchitectureConstants.Y);
    } else {
      csys07si.setBIndReview(ArchitectureConstants.N);
    }
    csys07si.setTsSysTsLastUpdate2(csys08so.getTsSysTsLastUpdate2());
    csys07si.setBIndVictimSelected(ContextHelper.getStringSafe(request, "hdnBVictimSelected"));
    csys07si.setSzNmPersonFull(ContextHelper.getStringSafe(request, "szNmPersonFull"));
    csys07si.setUlIdPerson(ContextHelper.getIntSafe(request, "hdnUlIdPerson"));
    csys07si.setSzNmAgencyName(ContextHelper.getStringSafe(request, "szNmAgencyName"));
    csys07si.setSzCdContactLocation(ContextHelper.getStringSafe(request, SELSZCDCONTACTLOCATION));
    csys07si.setSzCdContactMethod(ContextHelper.getStringSafe(request, SELSZCDCONTACTMETHOD));
    csys07si.setSzCdContactOthers(ContextHelper.getStringSafe(request, SELSZCDCONTACTOTHERS));
    String contactType = ContextHelper.getStringSafe(request, SELSZCDCONTACTTYPE);
    csys07si.setSzCdContactType(contactType);

    // STGAP00014326 MR-024 Changes //TODO
    Date dtToday = new Date();
    csys07si.setSzCdContactedBy(ContextHelper.getStringSafe(request, "rbContactedBy"));

    if (ContextHelper.getBooleanSafe(request, "hidDeleteDocument")) {
      csys07si.setTsSysTsLastUpdate3(csys08so.getTsLastUpdate());
    }
    // STGAP00015281 : Check if the hdnDocExits is false, if it is false set the BIndDeleteDoc to Y ,
    // Save service will delete the narrative from the Contact_Narrative table if BIndDeleteDoc is Y.
    if (ContextHelper.getBooleanSafe(request, "hidDeleteDocument")
        && ArchitectureConstants.FALSE.equals(ContextHelper.getStringSafe(request, "hdnDocExists"))) {
      csys07si.setBIndDeleteDoc(ArchitectureConstants.Y);
    }
    if (CodesTables.CCCONTBY_DFC.equals(csys07si.getSzCdContactedBy())) {
      csys07si.setSzNmContactedBy(ContextHelper.getStringSafe(request, "szNmContactedByStaff"));
    } else if (CodesTables.CCCONTBY_CCA.equals(csys07si.getSzCdContactedBy())) {
      csys07si.setSzNmContactedBy(ContextHelper.getStringSafe(request, "szNmContactedByCCA"));
    } else {
      csys07si.setSzNmContactedBy(ContextHelper.getStringSafe(request, "szNmContactedByXXX"));
    }
    csys07si.setSzCdContactNarrative(ContextHelper.getStringSafe(request, "rbNarrType"));
    // Set EnteredOn date only once during initial save
    // Check if we already have a date on the page, as the field is disabled, you will not get it from request
    // so use a hidden field.
    org.exolab.castor.types.Date enteredOn = ContextHelper.getCastorDateSafe(request, HDNENTEREDON);

    // STGAP00015282: When copying a contact the dtContactEntered should be the day on which the copy event was created.
    if (PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))) {
      csys07si.setDtDTContactEntered(DateHelper.toCastorDate(dtToday));
    } else if (StringHelper.isNotEmptyOrNull(enteredOn)) {
      csys07si.setDtDTContactEntered(enteredOn);
    } else {
      csys07si.setDtDTContactEntered(DateHelper.toCastorDate(dtToday));
    }

    List<String> newContactPurpose = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxContactPurpose"));
    List<String> oldContactPurpose = new ArrayList<String>();
    ContactCbxDisplay_Array oldContactPurposeArray = csys08so.getContactCbxDisplay_Array();
    if (oldContactPurposeArray != null) {
      Enumeration<ContactCbxDisplay> oldContactPurposeArrayEnumeration = oldContactPurposeArray
                                                                                               .enumerateContactCbxDisplay();
      while (oldContactPurposeArrayEnumeration.hasMoreElements()) {
        // Get all the Saved Purpose options and add it to the oldContactPurpose array list.
        ContactCbxDisplay oldContactCbx = (ContactCbxDisplay) oldContactPurposeArrayEnumeration.nextElement();
        String cdCbxCodeType = oldContactCbx.getSzCdCbxCodeType();
        String cdPurpose = oldContactCbx.getSzCdContactCbx();
        if (CodesTables.CCNTPURP.equals(cdCbxCodeType)) {
          oldContactPurpose.add(cdPurpose);
        }
      }
    }
    Collection<String> allContactPurpose = null;
    try {
      allContactPurpose = Lookup.getCategoryCodesCollection(CodesTables.CCNTPURP);
    } catch (LookupException le) {
      throw new IllegalStateException("Lookup data has not been initialized. Contact tech support for assistance.");
    }
    ContactCbxRecord_Array cbxArray = new ContactCbxRecord_Array();

    // STGAP00015191 and STGAP00015282
    if (PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))) {
      for (String contactPurpose : allContactPurpose) {
        if (newContactPurpose.contains(contactPurpose)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
          cbx.setSzCdCbxCodeType(CodesTables.CCNTPURP);
          cbx.setSzCdContactCbx(contactPurpose);
          cbxArray.addContactCbxRecord(cbx);
        }
      }
    } else {
      for (String contactPurpose : allContactPurpose) {
        if (newContactPurpose.contains(contactPurpose) && !oldContactPurpose.contains(contactPurpose)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
          cbx.setSzCdCbxCodeType(CodesTables.CCNTPURP);
          cbx.setSzCdContactCbx(contactPurpose);
          cbxArray.addContactCbxRecord(cbx);
        }

        if (!newContactPurpose.contains(contactPurpose) && oldContactPurpose.contains(contactPurpose)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
          cbx.setSzCdCbxCodeType(CodesTables.CCNTPURP);
          cbx.setSzCdContactCbx(contactPurpose);
          cbxArray.addContactCbxRecord(cbx);
        }
      }
    }

    // End STGAP00014326 MR-024 Changes

    csys07si.setContactCbxRecord_Array(cbxArray);

    // STGAP00015320: Cycle through the list of purposes selected in the request and add each purpose to
    // Event description untill length of eventdescription is less than 97 characters.
    // SIR 14291 - don't add the '-' and purpose for the three month review type
    // because there is no purpose code to add for that type. Later on in csys07,
    // the szTxtEventDescr is looked at, and having the extra '-' causes problems
    // with not moving contacts & events to the SVC stage.
    String szTxtEventDescr = StringHelper.EMPTY_STRING;
    int descrLength = 0;
    szTxtEventDescr = Lookup.simpleDecodeSafe("CCNTCTYP", ContextHelper.getStringSafe(request, SELSZCDCONTACTTYPE));
    if (newContactPurpose != null && !newContactPurpose.isEmpty()) {
      String cdPurpose = null;
      String decodePurpose = null;
      List<String> decodePurposeList = new ArrayList<String>();
      Iterator<String> newContactPurposeIt = newContactPurpose.iterator();
      while (newContactPurposeIt.hasNext()) {
        cdPurpose = newContactPurposeIt.next();
        decodePurpose = Lookup.simpleDecodeSafe("CCNTPURP", cdPurpose);
        decodePurposeList.add(decodePurpose);
      }
      Collections.sort(decodePurposeList);
      Iterator<String> decodePurposeListIt = decodePurposeList.iterator();

      szTxtEventDescr += " - ";
      while (decodePurposeListIt.hasNext()) {
        decodePurpose = decodePurposeListIt.next();
        szTxtEventDescr += decodePurpose;
        if (decodePurposeListIt.hasNext()) {
          szTxtEventDescr += ", ";
        }
        descrLength = szTxtEventDescr.length();
        if (descrLength >= 100) {
          szTxtEventDescr = szTxtEventDescr.substring(0, 96);
          szTxtEventDescr += "...";
          break;
        }
      }

    }

    rowccmn01uig00.setSzTxtEventDescr(szTxtEventDescr);

    // -- Add TCM-specific fields *******************************************************
    if (contactType.endsWith("TCM")) {
      csys07si.setUlIdTCMClient(ContextHelper.getIntSafe(request, "selGuarantorPC"));
      csys07si.setSzCdTCMEligible(ContextHelper.getStringSafe(request, "selEligible"));
      csys07si.setSzCdTCMMedSvcs(ContextHelper.getStringSafe(request, "selMedSvcs"));

      List<String> newEligProgs = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxEligProgs_"));
      List<String> newMedSvcs = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxSvcsProvided_"));
      List<String> oldEligProgs = new ArrayList<String>();
      List<String> oldMedSvcs = new ArrayList<String>();
      // -- get oldEligProgs and oldMedSvcs
      // MR-024 As the contact is now modifiable, get the saved checkboxes which are used later
      // to compare with the current checkboxes on the page.
      ContactCbxDisplay_Array oldEligProgsArray = csys08so.getContactCbxDisplay_Array();
      if (oldEligProgsArray != null) {
        Enumeration<ContactCbxDisplay> oldEligProgsArrayEnumeration = oldEligProgsArray.enumerateContactCbxDisplay();
        while (oldEligProgsArrayEnumeration.hasMoreElements()) {
          // Get all the Saved EligProgs options and add it to the oldEligProgsArray array list.
          ContactCbxDisplay oldContactCbx = (ContactCbxDisplay) oldEligProgsArrayEnumeration.nextElement();
          String cdCbxCodeType = oldContactCbx.getSzCdCbxCodeType();
          String eligProg = oldContactCbx.getSzCdContactCbx();
          if (CodesTables.CTCMPROG.equals(cdCbxCodeType)) {
            oldEligProgs.add(eligProg);
          }
        }
      }

      ContactCbxDisplay_Array oldMedSvcsArray = csys08so.getContactCbxDisplay_Array();
      if (oldMedSvcsArray != null) {
        Enumeration<ContactCbxDisplay> oldMedSvcsArrayEnumeration = oldMedSvcsArray.enumerateContactCbxDisplay();
        while (oldMedSvcsArrayEnumeration.hasMoreElements()) {
          // Get all the Saved EligProgs options and add it to the oldEligProgsArray array list.
          ContactCbxDisplay oldContactCbx = (ContactCbxDisplay) oldMedSvcsArrayEnumeration.nextElement();
          String cdCbxCodeType = oldContactCbx.getSzCdCbxCodeType();
          String medSvcs = oldContactCbx.getSzCdContactCbx();
          if (CodesTables.CTCMSVCS.equals(cdCbxCodeType)) {
            oldMedSvcs.add(medSvcs);
          }
        }
      }

      Collection<String> allEligProgs = null;
      Collection<String> allMedSvcs = null;
      try {
        allEligProgs = Lookup.getCategoryCodesCollection(CodesTables.CTCMPROG);
        allMedSvcs = Lookup.getCategoryCodesCollection(CodesTables.CTCMSVCS);
      } catch (LookupException le) {
        throw new IllegalStateException("Lookup data has not been initialized. Contact tech support for assistance.");
      }

      for (String eligProg : allEligProgs) {
        if (newEligProgs.contains(eligProg) && !oldEligProgs.contains(eligProg)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
          cbx.setSzCdCbxCodeType(CodesTables.CTCMPROG);
          cbx.setSzCdContactCbx(eligProg);
          cbxArray.addContactCbxRecord(cbx);
        }

        if (!newEligProgs.contains(eligProg) && oldEligProgs.contains(eligProg)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
          cbx.setSzCdCbxCodeType(CodesTables.CTCMPROG);
          cbx.setSzCdContactCbx(eligProg);
          cbxArray.addContactCbxRecord(cbx);
        }
      }

      for (String medSvc : allMedSvcs) {
        if (newMedSvcs.contains(medSvc) && !oldMedSvcs.contains(medSvc)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
          cbx.setSzCdCbxCodeType(CodesTables.CTCMSVCS);
          cbx.setSzCdContactCbx(medSvc);
          cbxArray.addContactCbxRecord(cbx);
        }

        if (!newMedSvcs.contains(medSvc) && oldMedSvcs.contains(medSvc)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
          cbx.setSzCdCbxCodeType(CodesTables.CTCMSVCS);
          cbx.setSzCdContactCbx(medSvc);
          cbxArray.addContactCbxRecord(cbx);
        }
      }

      csys07si.setContactCbxRecord_Array(cbxArray);
    }
    // -- *******************************************************************************
    String bIndContactAttempted = CheckboxHelper.getCheckboxValue(request, CBXBINDCONTACTATTEMPTED);
    if (!bIndContactAttempted.equals(ArchitectureConstants.Y)) {
      bIndContactAttempted = ArchitectureConstants.N;
    }
    csys07si.setBIndContactAttempted(bIndContactAttempted);

    String bIndExtComment = CheckboxHelper.getCheckboxValue(request, CBXBINDEXTCOMMENT);
    if (!bIndExtComment.equals(ArchitectureConstants.Y)) {
      bIndExtComment = ArchitectureConstants.N;
    }
    csys07si.setIndExtDocAccepted(bIndExtComment);

    String bIndCrossCountyLines = ArchitectureConstants.N;
    if ("on".equals(ContextHelper.getStringSafe(request, "chkCrossCountyLines"))) {
      bIndCrossCountyLines = ArchitectureConstants.Y;
    }
    csys07si.setBIndCrossCountyLines(bIndCrossCountyLines);

    // SIR 18274 - This section sets the Date and Time to the current date and
    // time if the contact Type is and EEXR and the UlidEvent == 0
    if (CodesTables.CCNTCTYP_EEXR.equals(szCdContactType) && GlobalData.getUlIdEvent(request) == 0) {
      csys07si.setDtDTContactOccurred(DateHelper.getTodayCastorDate());
      csys07si.setTmScrTmCntct(ContextHelper.getTimeSafe(request, "txtTmScrTmCntct"));
    } else {
      csys07si.setDtDTContactOccurred(ContextHelper.getCastorDateSafe(request, TXTDTDTCONTACTOCCURRED));
      csys07si.setTmScrTmCntct(ContextHelper.getTimeSafe(request, TXTTMSCRCNTCT));
    }

    csys07si.setDtDtMonthlySummEnd(ContextHelper.getCastorDateSafe(request, TXTDTDTMONTHLYSUMMEND));
    csys07si.setDtDtMonthlySummBegin(ContextHelper.getCastorDateSafe(request, TXTDTDTMONTHLYSUMMBEGIN));
    csys07si.setUlRowSelected(ulRowSelected);

    csys07si.setROWCCMN01UIG00(rowccmn01uig00);
    csys07si.setArchInputStruct(input);
    csys07si.setROWCSVC02SIG03_ARRAY(rowcsvc02sig03_array);
    csys07si.setROWCSYS07SI_ARRAY(rowcsys07si_array);
    csys07si.setROWCLSC97DIG00_ARRAY(rowclsc97dig00_array);

    performanceTrace.exitScope();
    return csys07si;
  }

  /**
   * This helper method populates the input object for the csys08s retrieve service.
   * 
   * @param context
   *                The GrndsExchangeContext object
   * @param pagination
   *                TuxedoPaginationValueBean
   * @param ulIdEvent
   *                int
   * @return csys08si
   */
  private CSYS08SI populateCSYS08SI_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean pagination,
                                             int ulIdEvent) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSYS08SI_Retrieve()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    CSYS08SI csys08si = new CSYS08SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(pagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(pagination.getResultDetails().getResultsPerPage());
    input.setSzUserId(user.getUserLogonID());

    csys08si.setArchInputStruct(input);
    csys08si.setUlIdCase(GlobalData.getUlIdCase(request));

    csys08si.setUlIdEvent(ulIdEvent);

    csys08si.setUlIdStage(GlobalData.getUlIdStage(request));

    String contactType = getSelSzCdContactType(request);

    String narrType = ContextHelper.getStringSafe(request, "rbNarrType");
    // MR-024 added condition to set narrative table name for Parent,Child Visitation (PCV)narrative
    // Narrative type is no longer based on contactType, it is based on the radio button selected by the
    // user.
    // STGAP00015444: Contact_Narrative table should be used to save narratives of all types.
    if (contactType != null) {
      if (contactType.endsWith("SRA")) {
        csys08si.setSzSysTxtTablename(SAFETY_RSRC_ASMNT_NARR_TABLE_NAME);
      } else {
        csys08si.setSzSysTxtTablename(NARRATIVE_TABLE_NAME);
      }
    }
    performanceTrace.exitScope();
    return csys08si;
  }

  private TCMClaimSaveSI populateTCMClaimSaveSI(HttpServletRequest request) {
    TCMClaimSaveSI si = new TCMClaimSaveSI();

    // -- if idEvent > 0, additional lookups for resubmitted TCM claims will be performed in
    // -- the ValidateTCMClaim service; explicitly set to 0 here (will be reset before save is
    // -- called with newly created contact idEvent, if appropriate)
    si.setIdEvent(0);

    if (GlobalData.getUlIdEvent(request) > 0) {
      si.setIdEvent(GlobalData.getUlIdEvent(request));
    }

    // -- populate everything except nbrMedicaid (comes from validation)
    // -- and idEvent (comes from saved contact)
    si.setIdStaff(ContextHelper.getIntSafe(request, "hdnUlIdPerson"));
    si.setIdStage(GlobalData.getUlIdStage(request));
    si.setIdPerson(ContextHelper.getIntSafe(request, "selGuarantorPC"));

    Date contactDate = ContextHelper.getJavaDateSafe(request, TXTDTDTCONTACTOCCURRED);
    String contactTime = ContextHelper.getTimeSafe(request, TXTTMSCRCNTCT);
    si.setDtService(DateHelper.toJavaDateSafe(contactDate, contactTime));

    return si;
  }

  /**
   * This method is the main call for Adding.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  public void addContact_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addContact_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PageMode.setPageMode(PageModeConstants.NEW, request);

    try {
      TuxedoPaginationValueBean pagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, pagination);
      pagination.getResultDetails().setResultsPerPage(50);

      // only reset the event id if you aren't coming from a todo
      if (ToDoHelper.hasPageModeEditOverride(request) == false) {
        GlobalData.setUlIdEvent(0, request);
      }

      // The event id might not be null if you are coming from a todo
      CSYS08SI csys08si = populateCSYS08SI_Retrieve(context, pagination, GlobalData.getUlIdEvent(request));
      
      //STGAP00018101 We are setting the User Name and ID to the currently logged in user.
      UserProfile user = UserProfileHelper.getUserProfile(context);
      CSYS08SO csys08so = common.contactDetailRetrieve(csys08si,user.getUserID(),user.getUserFullName()); 
   
      state.setAttribute("CSYS08SO", csys08so, request);

      // STGAP00014856 Commented out the following code as the informational message is not required.
      // warn on invalidation of approval
      /*
       * if (csys08so.getUlIdEvent() != 0 && !GlobalData.isApprovalMode(request)) {
       * setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request); }
       */

      // TODO fix this once pagination works
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd("N");
      csys08so.setArchOutputStruct(archOutputStruct);

      pagination.setPaginationInformation(csys08so.getArchOutputStruct(), csys08so.getROWCSYS08SO_ARRAY()
                                                                                  .getROWCSYS08SOCount());

      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, pagination);
    } catch (ServiceException we) {
      handleContactDetailDisplayError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERALFAILURE + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is the main call for when Continue has been pressed to Add.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  public void continueType_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".continueType_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CSYS08SO csys08so = getCSYS08SO(request);

    // STGAP00014856 Commented out the following code as the informational message is not required.
    // warn on invalidation of approval
    // if (csys08so != null && csys08so.getUlIdEvent() != 0 && !GlobalData.isApprovalMode(request)) {
    // setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
    // }

    // SIR 18274 - This section redirects to the Save routine if it is an
    // Extension Request (EEXR) because there are no User filled in fields.
    String contactType = ContextHelper.getStringSafe(request, SELSZCDCONTACTTYPE);
    if (CodesTables.CCNTCTYP_EEXR.equals(contactType)) {
      try {
        // should go straight to summary contact
        request.setAttribute("txtTmScrTmCntct", new gov.georgia.dhr.dfcs.sacwis.core.utility.Time());
        request.setAttribute("selSzCdContactType", CodesTables.CCNTCTYP_EEXR);
        forward("/contacts/ContactSearchListDetail/saveContact", request, context.getResponse());
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, GENERALFAILURE + e.getMessage());
        processSevereException(context, e);
      }
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is the main call for deleting.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  public void deleteContact_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteContact_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      String pageMode = PageMode.getPageMode(request);
      // if NEW/NEW_USING, there's nothing to delete
      // if VIEW, it shouldn't get here
      if (PageModeConstants.EDIT.equals(pageMode)) {
        CSYS07SI csys07si = populateCSYS07SI_AUD(context);
        // ServiceHelper.callService("CSYS07S", csys07si);
        common.contactDetailSave(csys07si);
      }
    } catch (ServiceException we) {
      handleContactDetailAUDError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    // set items to null so displayContactSearchList works properly
    request.setAttribute("deletedDetail", "true");
    GlobalData.setUlIdEvent(0, request);

    performanceTrace.exitScope();
  }

  /**
   * This method calls the populate csys08si_Retireve and handleContactDisplayError methods.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  public void displayContact_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayContact_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String allowModifyOfFormOnClosed = ArchitectureConstants.N;
    String allowAddOnClosedStage = (String) state.getAttribute("allowAddOnClosedStage", request);

    // The getUlIdEvent() method will determine where we are coming from and
    // get the ulIdEvent of the Contact/Summary Detail Event we want to display.
    int ulIdEvent = getUlIdEvent(context);
    GlobalData.setUlIdEvent(ulIdEvent, request);

    if (ulIdEvent == 0) {
      // If you get a todo with no ulIdEvent, you need to create a new contact
      setPresentationBranch("ADD_CONTACT", context);
      return;
    }

    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnNewUsing.x"))) {
      // 07/18/2003, Matthew McClain, setting New Using here to let
      // EventSearchConversation know to leave PageMode alone.
      PageMode.setPageMode(PageModeConstants.NEW_USING, request);
    }

    // SIR 16979 get the page mode from event search conversation, it will be re-set
    // by the logic of this method if it is not being accessed from event search.
    String pageMode = EventSearchConversation.getEventDetailPageMode(request);
    PageMode.setPageMode(pageMode, request);

    // Now that we have the ulIdEvent of the Contact/Summary Detail we want to display,
    // we call the csys08so retrieve to get the Detail information to display on the
    // Detail page.
    try {
      TuxedoPaginationValueBean pagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, pagination);
      pagination.getResultDetails().setResultsPerPage(50);

      CSYS08SI csys08si = populateCSYS08SI_Retrieve(context, pagination, ulIdEvent);
      CSYS08SO csys08so = new CSYS08SO();
      //STGAP00016837 Checks if the 'COPY' button was pressed. 
      //If so replace creator/original user with the currently logged in User
      if(StringHelper.isValid(ContextHelper.getStringSafe(request, "btnNewUsing.x"))){
    	  UserProfile user = UserProfileHelper.getUserProfile(context);
          csys08so = common.contactDetailRetrieve(csys08si,user.getUserID(),user.getUserFullName()); 
      } else {
    	  csys08so = common.contactDetailRetrieve(csys08si); 
      }
     
      String szCdContactType = csys08so.getSzCdContactType();
//      request.setAttribute("selSzCdContactType", szCdContactType);
      if (szCdContactType != null) {
        if ("SRA".equals(szCdContactType.substring(1, 4))) {
          csys08si.setSzSysTxtTablename(SAFETY_RSRC_ASMNT_NARR_TABLE_NAME);
        } else {
          csys08si.setSzSysTxtTablename(NARRATIVE_TABLE_NAME);
        }
      }

      if (StringHelper.isValid(szCdContactType) == false) {
        // If you get a todo with an ulIdEvent, but no SzCdContactType,
        // you need to create a new contact
        setPresentationBranch("ADD_CONTACT", context);
        PageMode.setPageMode(PageModeConstants.NEW, request);
        return;
      }

      ROWCCMN45DO rowccmn45do = csys08so.getROWCCMN45DO();
      if (rowccmn45do == null) {
        rowccmn45do = new ROWCCMN45DO();
      }

      // If this is a new using, we want the date and time to be blank when we enter the page
      // so we modify the csys08so output object to reflect this. We also want to set the Page
      // Mode to NEW_USING so the user will not be able to produce the document until the page
      // is saved.
      if (PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))) {
        csys08so.setDtDTContactOccurred(null);
        TmScrTmCntct_ARRAY tmSvcTmCntctArray = new TmScrTmCntct_ARRAY();
        tmSvcTmCntctArray.addTmScrTmCntct(0, "");
        csys08so.setTmScrTmCntct_ARRAY(tmSvcTmCntctArray);
        csys08so.setUlIdEvent(0);
        // SIR 18215 - We need to pass the ulIdEvent of the NewUsed Contact
        // so that the DocumentUtilityHelpers can use it.
        request.setAttribute("nEvent", String.valueOf(ulIdEvent));
        GlobalData.setUlIdEvent(0, request);
      }

      // We need to warn the user about invalidating the approval if we
      // are not in approval mode and either of the following is true:
      // 1) We are in EDIT mode and the event is pending
      // 2) We are in NEW or NEW USING and CSYS08SO
      // SIR 23728 - All contacts are read only in MPS when pending approval.
      // SIR 23867 - Changes made in the following conditional clause to make all contacts,
      // including Monthly Status APS,are non-editable in MPS, if the stages are in PEND status.

      if (!GlobalData.isApprovalMode(request)
          &&

          ((PageModeConstants.EDIT.equals(PageMode.getPageMode(request)) && CodesTables.CEVTSTAT_PEND
                                                                                                     .equals(rowccmn45do
                                                                                                                        .getSzCdEventStatus())) || csys08so
                                                                                                                                                           .getUlIdEvent() != 0)) {
        if (PlatformConstants.MOBILE_IMPACT) {
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        }
      }
      // SIR 18353 - Added to if statement to make sure that the NewUsing button
      // had not been pressed, otherwise we'd erroneously keep NewUsed Approved
      // contacts from being able to be saved.
      else if (CodesTables.CEVTSTAT_APRV.equals(rowccmn45do.getSzCdEventStatus())
               && !StringHelper.isValid(ContextHelper.getStringSafe(request, "btnNewUsing.x"))) {
        // !!! I think EventSearchConversation should handle this fine
        PageMode.setPageMode(PageModeConstants.VIEW, request);
      }

      // If the Contact is a Closed Stage Addendum (FCCA) then the page should be
      // in modify mode because anyone's allowed to modify a FCCA.
      if (CodesTables.CCNTCTYP_FCCA.equals(csys08so.getSzCdContactType()) && !PlatformConstants.MOBILE_IMPACT) {
        PageMode.setPageMode(PageModeConstants.EDIT, request);
      }

      // SIR 18885; !!! this allows anyone to edit approved events in AFC/INV stages
      ROWCCMN45DO eventDetail = csys08so.getROWCCMN45DO();
      if (eventDetail == null) {
        eventDetail = new ROWCCMN45DO();
      }

      if ("AFC".equals(GlobalData.getSzCdStageProgram(request)) && "INV".equals(GlobalData.getSzCdStage(request))
          && CodesTables.CEVTSTAT_APRV.equals(eventDetail.getSzCdEventStatus())) {
        PageMode.setPageMode(PageModeConstants.EDIT, request);
      }
      // END SIR 18885

      // SIR 19020 - If we are viewing a contact in a Stage other than the one in GlobalData set PageMode to View.
      if ((eventDetail.getUlIdStage() != GlobalData.getUlIdStage(request)) && (!pageMode.equals(PageModeConstants.NEW))
          && (!pageMode.equals(PageModeConstants.NEW_USING))) {
        // FIXME: This does nothing because the assignment is never used!
        pageMode = PageModeConstants.VIEW;
      }

      // SIR 23726 - Lockdown changes for MPS Phase II
      // SIR 24020 - Conditional clause expanded

      if (CaseUtility.getCaseCheckoutStatus(rowccmn45do.getUlIdStage())
          && !(CodesTables.CEVTSTAT_PEND.equals(rowccmn45do.getSzCdEventStatus()) || csys08so.getUlIdEvent() != 0)
          && !CaseUtility.getAFCPendingStatus(GlobalData.getUlIdCase(request))) {
        if ("PR".equals(CaseUtility.getRoleInWorkloadStage(rowccmn45do.getUlIdStage(), csys08so.getUlIdPerson()))
            && MOBILE_CONTACT_TYEPS.contains(csys08so.getSzCdContactType())) {
          if (PlatformConstants.SERVER_IMPACT && !PageMode.getPageMode(request).equals(PageModeConstants.VIEW)) {
            PageMode.setPageMode(PageModeConstants.VIEW, request);
            setInformationalMessage(Messages.MSG_CASE_CHECKEDOUT, request);
          }
        } else {
          if (PlatformConstants.MOBILE_IMPACT) {
            PageMode.setPageMode(PageModeConstants.VIEW, request);
          }
        }
      }

      CaseUtility.Stage stage = CaseUtility.getStage("" + csys08si.getUlIdStage());
      boolean stageClosed = false;
      if (stage.getDtClose() != null) {
        stageClosed = true;
      }
      // STGAP00013826 - If we are giving the user the right to add contacts to a close stage
      // we need to decide if the user should be able to modify an existing one or
      // should we lock it down and display it view only. If the contact was last
      // edited after the stage was closed then the form is modifiable. If it was
      // last edited before the stage was closed then we make the form view only.
      if (stageClosed && ArchitectureConstants.Y.equals(allowAddOnClosedStage)) {
        Date stageClosureDate = DateHelper.toJavaDateSafe(stage.getDtClose(), "12:00 am");

        stageClosureDate = DateHelper.addToDate(stageClosureDate, 0, 0, 1);
        Date dtContactLsUpdate = csys08so.getTsSysTsLastUpdate2();

        if (DateHelper.isNull(dtContactLsUpdate) == false && DateHelper.isNull(stageClosureDate) == false) {
          if (stageClosureDate.before(dtContactLsUpdate)) {
            allowModifyOfFormOnClosed = ArchitectureConstants.Y;
          }
        }

      }
      // On mobile, override the page mode IFF the stage is in error status.
      // SIR 23966 - Also set page mode to view pending AFC approval. This is done here
      // becuase AFC pend for MPS lockdown requires a separate check from the normal pend
      // mode check included below.
      if (PlatformConstants.MOBILE_IMPACT && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
        String cdMobileStatus = CaseUtility.getCdMobileStatus(GlobalData.getUlIdCase(request));
        if (CodesTables.CMOBSTAT_ER.equals(cdMobileStatus)
            || CaseUtility.getAFCPendingStatus(GlobalData.getUlIdCase(request))) {
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        }
      }

      // STGAP00014326 MR-024
      // Check to see if the sysdate - Entered On date is greater than 7days.
      // then page mode should be view only PageMode.setPageMode(PageModeConstants.VIEW, request);
      // Also Check if the status of the TCM claim corresponding to the Contact is Not Billed.
      Date dtToday = new Date();
      boolean editAllowedForSevenDays = false;
      boolean editAllowed = false;
      boolean isContactAuthor = false;
      boolean isTCMNotBilled = false;
      boolean isDateBeforeStageClose = true;
      int caseId = GlobalData.getUlIdCase(request);
      int stageId = GlobalData.getUlIdStage(request);
      UserProfile userProfile = getUserProfile(request);
      int userId = userProfile.getUserID();

      if (csys08so.getDtDTContactEntered() != null) {
        Date weekAfterEnteredOn = DateHelper.addToDate(csys08so.getDtDTContactEntered(), 0, 0, 7).toDate();
        editAllowedForSevenDays = DateHelper.isBefore(dtToday, weekAfterEnteredOn);
      }

      // Set the comments mode to true if the user has been assigned or has stage access and
      // editAllowed is false i.e. the Contact is more than 7 days old.

      /*
       * We need to do a specific check for null csys08so.idPerson or non-null csys08so.idPortalUser and ensure that the
       * final result is false when this is a portal contact
       */
      boolean hasBeenAssigned = common.determineIfUserWasEverAssigned(caseId, stageId, userProfile.getUserID());
      boolean hasStageAccess = CaseUtility.hasStageAccess(userProfile.getUserID(), stageId);
      if (csys08so.getUlIdPerson() == 0 || csys08so.getUlIdPortalUser() != 0) {
        boolean hasFormCommentsAccess = false;
        String sHasFormCommentsAccess = String.valueOf(hasFormCommentsAccess);
        state.setAttribute("FORMCOMMENTSACCESS", sHasFormCommentsAccess, request);
      } else {
        boolean hasFormCommentsAccess = (hasBeenAssigned || hasStageAccess);
        String sHasFormCommentsAccess = String.valueOf(hasFormCommentsAccess);
        state.setAttribute("FORMCOMMENTSACCESS", sHasFormCommentsAccess, request);
      }
      boolean contactStageClosed = false; // Stage in which the contact was done

      CaseUtility.Stage contactStage = CaseUtility.getStage("" + csys08so.getROWCCMN45DO().getUlIdStage());
      if (contactStage.getDtClose() != null) {
        contactStageClosed = true;
      }

      if (contactStageClosed) {
        // Check if the contact was before stageClosed or after Stageclosed
        // Check if the stageClosureDate is less than sysdate and that the contact was done before stageclosure, if yes
        // contact is not modifiable
        Date stageClosureDate = DateHelper.toJavaDateSafe(contactStage.getDtClose(), "12:00 am");
        Date dtContactEntered = DateHelper.toJavaDateSafe(csys08so.getDtDTContactEntered(), "12:00 am");
        if (csys08so.getDtDTContactEntered() != null) {
          boolean isContactBeforeStageClosure = (DateHelper.isBefore(dtContactEntered, stageClosureDate));
          if (isContactBeforeStageClosure) {
            isDateBeforeStageClose = true; // now the contact is not modifiable i.e the contact was entered before
            // stage closure, 7 day
            // scenario will be taken care of by the editAllowed variable.
          } else {
            isDateBeforeStageClose = false; // Contact was entered after the stage was closed.
          }
        }
      } else {
        isDateBeforeStageClose = false; // that means the stage is still open
      }

      // Check if the logged in user is the original Contact Author.
      if (userId == csys08so.getUlIdPerson()) {
        isContactAuthor = true;
      }

      // This is checked in the retrieve service
      String contactType = ContextHelper.getStringSafe(request, "selSzCdContactType");
      if (!contactType.endsWith("TCM")) {
        isTCMNotBilled = true;
      } else {
        isTCMNotBilled = csys08so.getBIndTcmNBLStatus();
      }

      editAllowed = editAllowedForSevenDays && isContactAuthor && isTCMNotBilled;

      // A person having SAU Sealed attribute should be able to add a contact and modify a contact on
      // SAU sealed FAD stages with HomeTypes of Foster/Adopt (Legal Risk)(CFACATEG_L), Adoptive (A), ICPC Adopt(J),
      // Relative Adopt(D)
      // cd_rsrc_category in caps_resource table
      boolean SAU = userProfile.hasRight(UserProfile.SEC_SAU_SEALED);
      boolean sausealedhomeandworker = false;
      List<String> homeCategories = new ArrayList<String>();
      homeCategories.add(CodesTables.CFACATEG_L);
      homeCategories.add(CodesTables.CFACATEG_A);
      homeCategories.add(CodesTables.CFACATEG_J);
      homeCategories.add(CodesTables.CFACATEG_D);
      if (SAU) {
        if (homeCategories.contains(csys08so.getSzCdRsrcCategory())
            && ArchitectureConstants.Y.equals(contactStage.getIndSealed())
            && CodesTables.CSTAGES_FAD.equals(contactStage.getCdStage())) {
          sausealedhomeandworker = true;
        }
      }

      // Set the page mode to EDIT if editAllowed is TRUE i.e if Contact is less than 7 days old
      // (editAllowedForSevenDays)
      // AND the logged in user is the Person who created the contact (isContactAuthor) AND if it is TCM contact it has
      // NBL status
      // (isTCMNotBilled)
      // OR
      // if the person is SAU sealed and he has created a contact in a FAD stage that is Sealed and the home is of type
      // L, A, J, D and
      // contact is less than seven days old and the person logged in is the person who created the contact.
      //CAPTA 4.3 start - allow edit to Deputy Director, Policy unit or County Director if the contact is entered by either one of them.
      int loggedInUserId = userProfile.getUserID(); //logged in user
      int enteredByUserId = csys08so.getUlIdPerson(); // user who originally entered this contact.
      boolean editAllowedForDeputyPolicyCountyDtr = false;
  
      //logged in user as well as user who entered this contact has be be either Deputy Director, Policy unit or County Director
      //to modify the contact details.
      if(enteredByUserId != 0){ 
        if(common.isUserDeputyPolicyCountyDrt(loggedInUserId, GlobalData.getUlIdStage(request) ) 
                        && common.isUserDeputyPolicyCountyDrt(enteredByUserId, contactStage.getIdStage())  ){
          editAllowedForDeputyPolicyCountyDtr = true; 
        }
      }
      //if contact entered by and logged in user is any one of these (deputy director, policy unit, county director) allow edit contact details.
      if(editAllowedForDeputyPolicyCountyDtr) {
        PageMode.setPageMode(PageModeConstants.MODIFY, request);
      }else {
        PageMode.setPageMode(PageModeConstants.VIEW, request);
      }
      //CAPTA 4.3 - end
      if (editAllowed || (sausealedhomeandworker && editAllowedForSevenDays && isContactAuthor)) {
            PageMode.setPageMode(PageModeConstants.EDIT, request);
      }
      // STGAP00015282:If copy button is pressed , set Page mode Constants to NEW_USING , this will ensure
      // copying of narrative.
      if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnNewUsing.x"))) {
        PageMode.setPageMode(PageModeConstants.NEW_USING, request);
      }

      String editAllowed1 = String.valueOf(editAllowed);

      state.setAttribute("EDITALLOWEDFORSEVENDAYS", String.valueOf(editAllowedForSevenDays), request);
      state.setAttribute("SAUSEALEDHOMEANDWORKER", String.valueOf(sausealedhomeandworker), request);
      state.setAttribute("EDITALLOWED", editAllowed1, request);
      state.setAttribute("ISDATEBEFORESTAGECLOSE", String.valueOf(isDateBeforeStageClose), request);
      state.setAttribute("CSYS08SO", csys08so, request);
      state.setAttribute("allowFormModifyOnClosedStage", allowModifyOfFormOnClosed, request);
      state.setAttribute("editAllowedForDeputyPolicyCountyDtr", String.valueOf(editAllowedForDeputyPolicyCountyDtr), request);

      // TODO fix this once pagination works
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd("N");
      csys08so.setArchOutputStruct(archOutputStruct);

      pagination.setPaginationInformation(csys08so.getArchOutputStruct(), csys08so.getROWCSYS08SO_ARRAY()
                                                                                  .getROWCSYS08SOCount());

      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, pagination);

      if (csys08so.getTsLastUpdate() != null) {
        request.setAttribute(DOCEXISTS, ArchitectureConstants.TRUE);
      } else {
        request.setAttribute(DOCEXISTS, ArchitectureConstants.FALSE);
      }
    } catch (ServiceException we) {
      handleContactDetailDisplayError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERALFAILURE + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method calls the populate csys03si_Retireve, csys04si_Retrieve and handleContactSearchListDisplayError
   * methods.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  public void displayContactSearchList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayContactSearchList_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // added by mcclaim on 7/12/2003 to prevent a user with only todo access
      // for a single Contact from modifying all contacts in the stage
      ToDoHelper.clearPageModeEditOverride(request);

      state.removeAllAttributes(request);

      TuxedoPaginationValueBean pagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, pagination);
      // -- pageSize corresponds to limit of ROWCSYS04SO_ARRAY elements in CSYS04SO
      pagination.getResultDetails().setResultsPerPage(50);

      PageMode.setPageMode(GlobalData.getAppMode(request), request);

      // On mobile, override the page mode IFF the stage is in error status.
      // SIR 23966 - Also set page mode to view pending AFC approval. This is done here
      // becuase AFC pend for MPS lockdown requires a separate check from the normal pend
      // mode check included below.
      if (PlatformConstants.MOBILE_IMPACT) {
        String cdMobileStatus = CaseUtility.getCdMobileStatus(GlobalData.getUlIdCase(request));
        if (CodesTables.CMOBSTAT_ER.equals(cdMobileStatus)
            || CaseUtility.getAFCPendingStatus(GlobalData.getUlIdCase(request))) {
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        }
      }
      // STGAP00013826 Checking to see if user was ever assigned to a case if so
      // we want to display the add button even if the stage is closed
      int caseId = GlobalData.getUlIdCase(request);
      int stageId = GlobalData.getUlIdStage(request);
      UserProfile userProfile = getUserProfile(request);
      boolean stageClosed = false;
      String showAddOnClosed = ArchitectureConstants.N;
      String taskCode = GlobalData.getSzCdTask(request);
      CaseUtility.Stage stage = CaseUtility.getStage("" + stageId);
      if (stage.getDtClose() != null) {
        stageClosed = true;
      }
      /*
       * STGAP00013826- User should be able to add contacts to a closed stage if: 1) any user that was ever assigned to
       * the stage as either a primary or secondary case manager. Note, the history of all primary and secondary
       * assignments to a stage is stored in the STAGE_ASSIGN_HISTORY database table. 2) any user that falls within the
       * unit hierarchy of the most recently assigned primary case manager has the ability to record a new contact.
       */
      if (stageClosed) {
        // also checks unit hi
        boolean hasBeenAssigned = common.determineIfUserWasEverAssigned(caseId, stageId, userProfile.getUserID());
        boolean hasStageAccess = CaseUtility.hasStageAccess(userProfile.getUserID(), stageId);

        if (CONTACTS_TASK_CODES.contains(taskCode) && (hasBeenAssigned || hasStageAccess)) {
          showAddOnClosed = ArchitectureConstants.Y;
        }
      }
      //CAPTA 4.3 start - County Director, Policy Unit and Deputy Director can add and modify contact Details
      String allowContactAddForDeputyDtr = ArchitectureConstants.N;
      if(common.isUserDeputyPolicyCountyDrt(userProfile.getUserID(), stage.getIdStage())){
        //showAddOnClosed = ArchitectureConstants.Y;
        allowContactAddForDeputyDtr = ArchitectureConstants.Y;
      }
    //CAPTA 4.3 end
      

      CSYS04SI csys04si = populateCSYS04SI_Retrieve(context, pagination);
      //SMS#52235
      csys04si.setBIndUserStageAccess(Boolean.toString(CaseUtility.hasStageAccess(userProfile.getUserID(), stageId)));
      csys04si.setBIndUserSealed(Boolean.toString(userProfile.hasRight(UserProfile.SEC_SAU_SEALED)));
      CSYS04SO csys04so = common.contactListSearch(csys04si);

      // A person having SAU Sealed attribute should be able to add a contact and modify a contact on
      // SAU sealed FAD stages with HomeTypesof Foster/Adopt (Legal Risk)(CFACATEG_L), Adoptive (A), ICPC Adopt(J),
      // Relative Adopt(D)
      // cd_rsrc_category in caps_resource table
      boolean SAU = userProfile.hasRight(UserProfile.SEC_SAU_SEALED);
      boolean sausealedhomeandworker = false;
      List<String> homeCategories = new ArrayList<String>();
      homeCategories.add(CodesTables.CFACATEG_L);
      homeCategories.add(CodesTables.CFACATEG_A);
      homeCategories.add(CodesTables.CFACATEG_J);
      homeCategories.add(CodesTables.CFACATEG_D);
      if (SAU) {
        if (homeCategories.contains(csys04so.getSzCdRsrcCategory())
            && ArchitectureConstants.Y.equals(stage.getIndSealed())
            && CodesTables.CSTAGES_FAD.equals(stage.getCdStage())) {
          sausealedhomeandworker = true;
        }
      }

      state.setAttribute("SAUSEALEDHOMEANDWORKER", String.valueOf(sausealedhomeandworker), request);
      state.setAttribute("allowAddOnClosedStage", showAddOnClosed, request);
      state.setAttribute("rowcsys04soArray", csys04so.getROWCSYS04SO_ARRAY(), request);
      state.setAttribute("csys04si", csys04si, request);
      state.setAttribute("allowContactAddForDeputyDtr", allowContactAddForDeputyDtr, request);
      
      
      /*  MR-062: add variable to indicate whether or 
       *  not adding a contact is allowed
       */
      state.setAttribute("allowContactAdd", csys04so.getIndCanAddCntct(), request);

      // -- set pagination info from output object
      pagination.setPaginationInformation(csys04so.getArchOutputStruct(), csys04so.getROWCSYS04SO_ARRAY()
                                                                                  .getROWCSYS04SOCount());
      storePaginationBeanToRequest(context, pagination);

      CSYS03SI csys03si = populateCSYS03SI_Retrieve(context);
      CSYS03SO csys03so = common.retrievePersonList(csys03si);

      request.setAttribute("CSYS03SO", csys03so);

    } catch (ServiceException we) {
      handleContactSearchListDisplayError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERALFAILURE + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is the main call for saving.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  public void saveContact_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveContact_xa()");
    performanceTrace.enterScope();

    try {
      saveDetail(context);
    } catch (ServiceException we) {
      handleContactDetailAUDError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is the main call for save and submitting. It will call the saveDetail helper method and then populate
   * the ToDoDetailDB bean for display on the To Do Detail page.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  public void saveSubmit_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveSubmit_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {

      CSYS07SO csys07so = saveDetail(context);
      if (csys07so == null) {
        csys07so = new CSYS07SO();
      }

      ToDoDetailDB toDoDetailDB = createToDoDetailDB(context, csys07so);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
    } catch (ServiceException we) {
      if (we.getErrorCode() != Messages.MSG_NO_ROWS_RETURNED) {
        // SIR 22985 -- we want to call handle detail error here,
        // these would be valid errors retured from the service.
        handleContactDetailAUDError(we, context);
      } else {
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        // SIR 22985 -- Replace hard coded message with database message.
        setErrorMessage(Messages.MSG_SAVE_CONT_NAR, request);
        return;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is the getting the new Staff Name. It will get everything submitted into the request
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  public void retrieveStaff_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".retrieveStaff_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CSYS08SO csys08so = getCSYS08SO(request);
    if (csys08so == null) {
      csys08so = new CSYS08SO();
    }
    TmScrTmCntct_ARRAY timeArray = new TmScrTmCntct_ARRAY();

    String time = ContextHelper.getTimeSafe(request, "txtTmScrTmCntct");
    timeArray.addTmScrTmCntct(0, time);
    csys08so.setTmScrTmCntct_ARRAY(timeArray);
    csys08so.setSzCdContactType(ContextHelper.getStringSafe(request, SELSZCDCONTACTTYPE));
    csys08so.setDtDTContactOccurred(ContextHelper.getJavaDateSafe(request, TXTDTDTCONTACTOCCURRED));
    csys08so.setBIndContactAttempted(CheckboxHelper.getCheckboxValue(request, CBXBINDCONTACTATTEMPTED));
    csys08so.setIndExtDocAccepted(CheckboxHelper.getCheckboxValue(request, CBXBINDEXTCOMMENT));
    csys08so.setSzCdContactPurpose(ContextHelper.getStringSafe(request, SELSZCDCONTACTPURPOSE));
    csys08so.setSzCdContactMethod(ContextHelper.getStringSafe(request, SELSZCDCONTACTMETHOD));
    csys08so.setSzCdContactLocation(ContextHelper.getStringSafe(request, SELSZCDCONTACTLOCATION));
    csys08so.setSzCdContactedBy(ContextHelper.getStringSafe(request, "rbContactedBy"));
    csys08so.setSzCdContactOthers(ContextHelper.getStringSafe(request, SELSZCDCONTACTOTHERS));
    csys08so.setDtDtMonthlySummBegin(ContextHelper.getCastorDateSafe(request, TXTDTDTMONTHLYSUMMBEGIN));
    csys08so.setDtDtMonthlySummEnd(ContextHelper.getCastorDateSafe(request, TXTDTDTMONTHLYSUMMEND));

    ROWCSYS08SO_ARRAY oldArray = csys08so.getROWCSYS08SO_ARRAY();
    if (oldArray == null) {
      oldArray = new ROWCSYS08SO_ARRAY();
    }

    ROWCSYS08SO_ARRAY newArray = new ROWCSYS08SO_ARRAY();

    ROWCSYS08SO csys08soRow;
    Enumeration<ROWCSYS08SO> csys08soEnumeration = oldArray.enumerateROWCSYS08SO();
    int loopCount = 0;
    while (csys08soEnumeration.hasMoreElements()) {
      csys08soRow = (ROWCSYS08SO) csys08soEnumeration.nextElement();
      String cbxName = "cbxUlIdPerson" + (loopCount + 1);
      if (StringHelper.isValid(ContextHelper.getStringSafe(request, cbxName))) {
        csys08soRow.setCSysIndContactOccurred(ArchitectureConstants.Y);
      } else {
        csys08soRow.setCSysIndContactOccurred(ArchitectureConstants.N);
      }
      newArray.addROWCSYS08SO(csys08soRow);
      loopCount++;
    }
    csys08so.setROWCSYS08SO_ARRAY(newArray);

    state.setAttribute("CSYS08SO", csys08so, request);

    StaffSearchInput io = new StaffSearchInput();
    io.setSourcePage(StaffSearchInput.OTHER);
    io.setDestinationUrl("/contacts/ContactSearchListDetail/setStaff");
    request.setAttribute("StaffSearchInput", io);

    // context and forward the user.
    try {
      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    } catch (Exception o) {
      processSevereException(context, o);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method will retrieve the row object that the staff search sent to us and put the new data into the csys08so
   * object for display on the contact detail page.
   * 
   * @param context
   *                GrndsExchangeContext
   */
  public void setStaff_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setStaff_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CSYS08SO csys08so = getCSYS08SO(request);
    if (csys08so == null) {
      csys08so = new CSYS08SO();
    }

    ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

    if (ccmn50do_array == null) {
      ccmn50do_array = new ROWCCMN50DO_ARRAY();
    }

    Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
    if (e.hasMoreElements()) {
      ROWCCMN50DO staff = (ROWCCMN50DO) e.nextElement();
      // csys08so.setSzNmPersonFull(staff.getSzNmPersonFull());
      csys08so.setSzNmContactedBy(staff.getSzNmPersonFull()); // MR -024
      // csys08so.setUlIdPerson(staff.getUlIdPerson()); as we are entering info for contacted by here.
      // csys08so.setSzCdJobTitle(staff.getSzCdEmployeeClass());
    }
    state.setAttribute("CSYS08SO", csys08so, request);

    performanceTrace.exitScope();
  }

  /**
   * This helper method is called by continueType, displayContact, and newUsing to determine which presentation branch
   * the page should be in.
   * 
   * @param request
   *                HttpServletRequest
   * @return presentationMode
   */
  public static String getPresentationMode(HttpServletRequest request) {
    String contactType = getSelSzCdContactType(request);

    if (contactType.length() <= 3) {
      throw new IllegalStateException("contactType length is <= 3: '" + contactType + "'");
    }
    // !!! dup'd
    String stageTypeCode = contactType.substring(1, 4);

    // String stageTypeCode = contactType.substring(0, 3);

    // SIR 22657 - Added CSQ to detailArray
    // SIR 19163 - Had to add 24N and FTF to detailArray so the page would allow
    // data to be entered instead of eternally staying in Initial PresenationMode.
    // SIR 23410 - Added LES and LEV to detailArray
    // SIR 23298 Added AGR to the detail Array
    String[] detailArray = { "24H", "24N", "ATP", "DVP", "CCA", "CSQ", "FTF", "IFF", "MAS", "MST", "MTG", "NOT", "PHS",
                            "QUV", "SRA", "REA", "REG", "REV", "SEI", "VAR", "VIO", "LES", "LEV", "AGR", "TCM", "INQ",
                            "PTC", "PVC" };
    String[] summaryArray = { "3MT", "ACS", "ATZ", "CCS", "CLS", "CMP", "DOC", "DVZ", "ENV", "EXR", "FAC", "FAZ",
                             "FCL", "INC", "LIC", "MAZ", "MTH", "PAR", "PHY", "PHZ", "PPS", "PRO", "QUZ", "REE", "REZ",
                             "SCS", "SEZ", "SPV", "STR", "STS", "VAZ", "VIZ" };

    // SMS #109398: MR-086
    // Added the third array for Contact Type of Transfer Summary to handle added fields on the Transfer Summary
    // Moved the "TRN" from summaryArray to trnSummaryArray
    String[] trnSummaryArray = { "TRN" };
    
    if (Arrays.asList(detailArray).contains(stageTypeCode)) {
      return DETAIL_CONTACT;
    } else if (Arrays.asList(summaryArray).contains(stageTypeCode)) {
      return SUMMARY_CONTACT;
    } else if (Arrays.asList(trnSummaryArray).contains(stageTypeCode)) { // SMS #109398: MR-086
      return TRN_SUMMARY_CONTACT;
    }
    

    /*
     * !!! change to Sets for (int i = 0; i < detailArray.length; i++) { if (stageTypeCode.equals(detailArray[i])) {
     * return DETAIL_CONTACT; } }
     * 
     * for (int i = 0; i < summaryArray.length; i++) { if (stageTypeCode.equals(summaryArray[i])) { return
     * SUMMARY_CONTACT; } }
     */
    throw new IllegalStateException("Unhandled contactType(1,4): '" + stageTypeCode + "'");
  }

  // !!! I don't like this, but it's currently everywhere
  // I think it'd be better to assure a cys08so object and fill in all this temporary state
  public static String getSelSzCdContactType(HttpServletRequest request) {
    // If we are adding a new contact, the user must select Contact/Summary Type after clicking
    // the add button on the Contact/Summaries List Page. In this instance, the Contact Type
    // is passed to the ContactDetail.jsp through the request. If we are viewing the detail
    // page for an existing contact/summary or a new using, the contact type should be
    // in the csys08so object.
    String selSzCdContactType = ContextHelper.getStringSafe(request, SELSZCDCONTACTTYPE);
    if (!"".equals(selSzCdContactType)) {
      return selSzCdContactType;
    }

    CSYS08SO csys08so = getCSYS08SO(request);
    if (csys08so == null) {
      // return null;
      return "";
    }
    return FormattingHelper.formatString(csys08so.getSzCdContactType());
  }

  public static List<Option> getGuarantorPCOptions(HttpServletRequest request) {
    CSYS08SO csys08so = getCSYS08SO(request);
    ROWCSYS08SO_ARRAY rowcsys08soArray = csys08so == null ? null : csys08so.getROWCSYS08SO_ARRAY();

    String stage = GlobalData.getSzCdStage(request);
    boolean restrictToPrimaryChild = CodesTables.CSTAGES_ADO.equals(stage) || CodesTables.CSTAGES_SUB.equals(stage);

    List<Option> guarantorPCOptions = buildGuarantorPCOptions(rowcsys08soArray, restrictToPrimaryChild);

    if (restrictToPrimaryChild) {
      if (guarantorPCOptions.size() > 0) {
        request.setAttribute(DISABLE_TCM_GUARANTOR_PC_NAME, true);
      } else {
        // -- use all persons because no PC found
        guarantorPCOptions = buildGuarantorPCOptions(rowcsys08soArray, false);
        setInformationalMessage(MSG_CMN_NO_PC, DISPLAY_DETAIL_PAGE, request);
      }
    }

    return guarantorPCOptions;
  }

  private static List<Option> buildGuarantorPCOptions(ROWCSYS08SO_ARRAY rowcsys08soArray, boolean restrictToPrimaryChild) {
    List<Option> guarantorPCOptions = new ArrayList<Option>();

    if (rowcsys08soArray == null) {
      return guarantorPCOptions;
    }

    for (ROWCSYS08SO row : rowcsys08soArray.getROWCSYS08SO()) {
      if (restrictToPrimaryChild) {
        if (CodesTables.CINVROLE_PC.equals(row.getSzCdStagePersRole())) {
          guarantorPCOptions.add(new Option(String.valueOf(row.getUlIdPerson()), row.getSzNmPersonFull()));
          break;
        }
        continue;
      }

      guarantorPCOptions.add(new Option(String.valueOf(row.getUlIdPerson()), row.getSzNmPersonFull()));
    }

    return guarantorPCOptions;
  }

  public static CSYS08SO getCSYS08SO(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);
    return (CSYS08SO) state.getAttribute("CSYS08SO", request);
  }

  public static List<CodeAttributes> getTypeOptions(HttpServletRequest request) {
    List<CodeAttributes> typeOptions = new ArrayList<CodeAttributes>();
    List<CodeAttributes> codesTable = null;
    try {
      codesTable = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CCNTCTYP);
    } catch (LookupException le) {
      throw new IllegalStateException("Lookup data has not been initialized. Contact tech support for assistance.");
    }

    if (codesTable != null) {
      String typeKey = getTypeKey(request);
      for (CodeAttributes codeAttr : codesTable) {
        if (codeAttr.getCode().startsWith(typeKey)) {
          typeOptions.add(codeAttr);
        }
      }
    }

    return typeOptions;
  }

  private static final Set<String> INQ_ONLY_PURPOSES = new HashSet<String>() {
    {
      add("IPO"); // Invited person to orientation
    }
  };

  // -- this method returns all non-keyed codes from CCNTPURP, but excludes IPO for
  // -- contact types other than INQ (Inquiry Follow Up)
  public static List<CodeAttributes> getPurposeOptions(HttpServletRequest request, boolean filter) {
    List<CodeAttributes> purposeOptions = new ArrayList<CodeAttributes>();
    List<CodeAttributes> codesTable = null;
    try {
      // -- this assumes all "keyed" codes have been end-dated
      codesTable = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CCNTPURP);
    } catch (LookupException le) {
      throw new IllegalStateException("Lookup data has not been initialized. Contact tech support for assistance.");
    }

    if (codesTable != null) {
      boolean typeIsINQ = getSelSzCdContactType(request).endsWith("INQ");
      for (CodeAttributes codeAttr : codesTable) {
        if (filter && INQ_ONLY_PURPOSES.contains(codeAttr.getCode())) {
          if (typeIsINQ) {
            purposeOptions.add(codeAttr);
          }
          continue;
        }
        purposeOptions.add(codeAttr);
      }
    }

    return purposeOptions;
  }

  private static final Set<String> INQ_ONLY_METHODS = new HashSet<String>() {
    {
      add("INA"); // N/A
      add("ISC"); // Interested/Still Considering
      add("LEM"); // Left message
      add("NOA"); // No answer
      add("NOI"); // Not interested
      add("PHD"); // Phone disconnected
    }
  };

  public static List<CodeAttributes> getMethodOptions(HttpServletRequest request, boolean filter) {
    List<CodeAttributes> methodOptions = new ArrayList<CodeAttributes>();
    List<CodeAttributes> codesTable = null;
    try {
      codesTable = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CCNTMETH);
    } catch (LookupException le) {
      throw new IllegalStateException("Lookup data has not been initialized. Contact tech support for assistance.");
    }

    if (codesTable != null) {
      boolean typeIsINQ = getSelSzCdContactType(request).endsWith("INQ");
      for (CodeAttributes codeAttr : codesTable) {
        if (filter && INQ_ONLY_METHODS.contains(codeAttr.getCode())) {
          if (typeIsINQ) {
            methodOptions.add(codeAttr);
          }
          continue;
        }
        methodOptions.add(codeAttr);
      }
    }

    return methodOptions;
  }

  /**
   * This helper method is called by deleteContact and saveContact to handle any ServiceExceptions by setting the
   * branch, looking up the error message and setting it.
   * 
   * @param we
   *                The ServiceException object.
   * @param context
   *                The GrndsExchangeContext object.
   */
  private void handleContactDetailAUDError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    int errorCode = we.getErrorCode();
    switch (errorCode) {
    // SIR 22947 - Added TOO_MANY_CONTACTS_IN_MONTHLY
    case Messages.TOO_MANY_CONTACTS_IN_MONTHLY:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_SVC_DELETE_CONTACT:
    case Messages.MSG_SVC_NO_SUMMARY_DATES:
    case Messages.MSG_SVC_STRUCTURED_NARR:
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_SYS_MULT_INST:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_VICTIM_NOT_SELECTED:
    case Messages.MSG_SVC_TCM_EXISTS:
    case Messages.MSG_SVC_TCM_DOB:
    case Messages.MSG_SVC_TCM_ID:
      setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      setErrorMessage(errorCode, request);
      break;
    default:
      processSevereException(context, we);
      break;
    }
  }

  /**
   * This helper method is called by the Save and Save and Submit activity methods. It will save the contact detail
   * utilizing the CSYS07S AUD service.
   * 
   * @param context
   *                GrndsExchangeContext
   * @return CSYS07SO (used for save and submits)
   * @throws ServiceException
   * @throws CheckboxHelperException
   */
  private CSYS07SO saveDetail(GrndsExchangeContext context) throws ServiceException, CheckboxHelperException {
    HttpServletRequest request = context.getRequest();
    CSYS07SI csys07si = populateCSYS07SI_AUD(context);

    // -- ***************** Add call to saveTCMClaim here *****************
    TCMClaimSaveSI tcmClaimSaveSI = null;
    boolean updateTCMClaim = false;
    String contactType = csys07si.getSzCdContactType();
    boolean saveTCMClaim = contactType != null && contactType.endsWith("TCM")
                           && !CodesTables.CINFPKRQ_N.equals(ContextHelper.getStringSafe(request, "selEligible"))
                           && CodesTables.CINVACAN_Y.equals(ContextHelper.getStringSafe(request, "selMedSvcs"));
    if (saveTCMClaim) {
      // -- remember, we need to do TCM validation before the contact can be saved!
      tcmClaimSaveSI = populateTCMClaimSaveSI(request);
      tcmClaimSaveSI.setCdReqFuncCd(csys07si.getArchInputStruct().getCReqFuncCd());
      TCMClaimValidateSO tcmClaimValidateSO = financials.validateTCMClaim(tcmClaimSaveSI);
      tcmClaimSaveSI.setNbrMedicaid(tcmClaimValidateSO.getNbrMedicaid());

      // -- for TCM contact updates, still validate TCM info, but do not modify the existing TCM_CLAIM
      // -- record; the actual TCM claim can be resubmitted with new data via the TCM Claims page
      saveTCMClaim = ServiceConstants.REQ_FUNC_CD_ADD.equals(csys07si.getArchInputStruct().getCReqFuncCd());
      updateTCMClaim = ServiceConstants.REQ_FUNC_CD_UPDATE.equals(csys07si.getArchInputStruct().getCReqFuncCd());
    }

    // -- add CONTACT_CBX values and 3 new CONTACT column values to csys07si
    // -- **** Don't forget to modify contactDetailSave to save TCM info, too! ****
    // CSYS07SO csys07so = (CSYS07SO) ServiceHelper.callService("CSYS07S", csys07si, CSYS07SO.class);
    CSYS07SO csys07so = common.contactDetailSave(csys07si);

    if (saveTCMClaim || updateTCMClaim) {
      tcmClaimSaveSI.setIdEvent(csys07so.getUlIdEvent());
      // TCMClaimSaveSO tcmClaimSaveSO =
      financials.saveTCMClaim(tcmClaimSaveSI);
    }

    // If we have successfully called the service, and csys08so.ulIdEvent was non-zero,
    // it is 0 now because the event was invalidated; mark it as such to prevent the
    // display of a warning message.
    CSYS08SO csys08so = getCSYS08SO(request);
    if (csys08so != null) {
      csys08so.setUlIdEvent(0);
    }

    GlobalData.setUlIdEvent(csys07so.getUlIdEvent(), request);
    request.setAttribute("sEvent", String.valueOf(GlobalData.getUlIdEvent(request)));
    request.setAttribute("sCase", String.valueOf(GlobalData.getUlIdCase(request)));

    boolean newUsing = PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING);
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    if (newUsing) {
      GrndsTrace.msg(TRACE_TAG, 7, "Value of nEvent:" + request.getParameter("nEvent"));
      GrndsTrace.msg(TRACE_TAG, 7, "Value of nCase:" + request.getParameter("nCase"));
      GrndsTrace.msg(TRACE_TAG, 7, "Value of sEvent:" + request.getAttribute("sEvent"));
      GrndsTrace.msg(TRACE_TAG, 7, "Value of sCase:" + request.getAttribute("sCase"));
      try {
        NewUsingDocumentValueBean newUsingDocumentValueBean = DocumentRecordHelper.newUseDocumentRecord(documentSave,
                                                                                                        request);
        DocumentRecordHelper.saveNewUseDocumentRecord(documentSave, request, newUsingDocumentValueBean);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, ">>>> Error copying narrative for idEvent " + request.getParameter("nEvent")
                                     + ": " + e.getMessage());
        // processSevereException(context, e);
      }
    }
    return csys07so;
  }

  /**
   * This helper method is called by the displayContactDetal method to handle and ServiceException by setting the
   * branch, looking up the error message and setting it.
   * 
   * @param we
   *                The ServiceException object.
   * @param context
   *                The GrndsExchangeContext object.
   */
  private void handleContactDetailDisplayError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    int errorCode = we.getErrorCode();
    switch (errorCode) {
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_CONFIRM_ON_EXIT:
    case Messages.MSG_FAD_SUBMIT_SUM:
    case Messages.MSG_SVC_CONTACT_DOESNT_EXIST:
    case Messages.MSG_SVC_DELETE_CONTACT:
    case Messages.MSG_SVC_NO_SUMMARY_DATES:
    case Messages.MSG_SVC_STRUCTURED_NARR:
      setErrorMessage(errorCode, request);
      break;
    default:
      processSevereException(context, we);
      break;
    }
  }

  /**
   * This helper method will determine the task code we need to pass to the To Do Detail page.
   * 
   * @param context
   *                GrndsExchangeContext
   * @param csys07so
   *                CSYS07SO
   * @return toDoDetailDB
   */
  private ToDoDetailDB createToDoDetailDB(GrndsExchangeContext context, CSYS07SO csys07so) {
    HttpServletRequest request = context.getRequest();

    String szCdContactType = ContextHelper.getStringSafe(request, "selSzCdContactType");

    if (szCdContactType.length() <= 3) {
      throw new IllegalStateException("szCdContactType length is <= 3: '" + szCdContactType + "'");
    }
    // !!! dup'd
    String contactType = szCdContactType.substring(1, 4);

    String stage = GlobalData.getSzCdStage(request);

    String taskCode = "";
    String todoDesc = "";

    if (contactType.equals(CONTACT_TYPE_MNTH_SUM)) {
      todoDesc = TODO_DESC_MNTH_SUMM;
      // JMC - SIR 17941 - Changed SVC to FPR.
      if (stage.equals(CodesTables.CSTAGES_FPR)) {
        taskCode = SVC_CD_TASK_APRV_MONTHLY;
      } else if (stage.equals(STAGE_CODE_FMR)) {
        taskCode = SVC_CD_TASK_APRV_FMR_MNTH;
      } else if (stage.equals(STAGE_CODE_FSC)) {
        taskCode = SVC_CD_TASK_APRV_FSC_MNTH;
      } else if (stage.equals(CodesTables.CSTAGES_ADO)) {
        taskCode = SVC_CD_TASK_APRV_ADO_MNTH;
      } else if (stage.equals(CodesTables.CSTAGES_SUB)) {
        taskCode = SVC_CD_TASK_APRV_SUB_MNTH;
      } else if (stage.equals(CodesTables.CSTAGES_PAD)) {
        taskCode = SVC_CD_TASK_APRV_PAD_MNTH;
      } else if (stage.equals(CodesTables.CSTAGES_PAL)) {
        taskCode = SVC_CD_TASK_APRV_PAL_MNTH;
      } else if (stage.equals(CodesTables.CSTAGES_FAD)) {
        taskCode = SVC_CD_TASK_APRV_FAD_CONTACT;
      }
    } else if (contactType.equals(CONTACT_TYPE_PERS_HOME_STUDY) && !stage.equals(CodesTables.CSTAGES_FAD)) {
      todoDesc = TODO_DESC_HOME_STUDY;
      if (stage.equals(STAGE_CODE_CPS_SVC)) {
        taskCode = SVC_CD_TASK_APRV_FPR_PHS;
      } else if (stage.equals(STAGE_CODE_FMR)) {
        taskCode = SVC_CD_TASK_APRV_FMR_PHS;
      } else if (stage.equals(STAGE_CODE_FSC)) {
        taskCode = SVC_CD_TASK_APRV_FSC_PHS;
      } else if (stage.equals(CodesTables.CSTAGES_SUB)) {
        taskCode = SVC_CD_TASK_APRV_SUB_PHS;
      }
    } else if (contactType.equals(CONTACT_TYPE_PERS_HOME_STUDY) && stage.equals(CodesTables.CSTAGES_FAD)) {
      todoDesc = TODO_DESC_FA_HOME_STUDY;
      taskCode = SVC_CD_TASK_APRV_FAD_CONTACT;
    } else if (contactType.equals(CONTACT_TYPE_REGULAR)) {
      todoDesc = TODO_DESC_REGULAR;
      if (stage.equals(CodesTables.CSTAGES_ADO)) {
        taskCode = SVC_CD_TASK_APRV_ADO_REG;
      } else if (stage.equals(CodesTables.CSTAGES_SUB)) {
        taskCode = SVC_CD_TASK_APRV_SUB_REG;
      } else if (stage.equals(CodesTables.CSTAGES_FAD)) {
        taskCode = SVC_CD_TASK_APRV_FAD_CONTACT;
      }
    } else if (contactType.equals(CONTACT_TYPE_SUB_TRANS)) {
      todoDesc = TODO_DESC_TRANSFER_SUMMARY;
      if (stage.equals(CodesTables.CSTAGES_ADO)) {
        taskCode = SVC_CD_TASK_APRV_ADO_TRANS;
      } else if (stage.equals(CodesTables.CSTAGES_SUB)) {
        taskCode = SVC_CD_TASK_APRV_SUB_TRANS;
      } else if (stage.equals(CodesTables.CSTAGES_FAD)) {
        taskCode = SVC_CD_TASK_APRV_FAD_CONTACT;
      }
    } else if (stage.equals(CodesTables.CSTAGES_FAD)) {
      taskCode = SVC_CD_TASK_APRV_FAD_CONTACT;
      if (CONTACT_TYPE_CORRECT_ACT_SUM.equals(contactType) || CONTACT_TYPE_CORR_ACTION.equals(contactType)) {
        todoDesc = TODO_DESC_CORRECTIVE_ACTION;
      } else if (CONTACT_DEVELOP_PLAN_SUM.equals(contactType) || CONTACT_TYPE_DEVELOP_PLAN.equals(contactType)) {
        todoDesc = TODO_DESC_DEVELOPMENT_PLAN;
      } else if (CONTACT_CLOSING_SUM_SUM.equals(contactType) || CONTACT_TYPE_FAD_CLOS_SUMM.equals(contactType)) {
        todoDesc = TODO_DESC_CLOSING_SUM;
      } else if (CONTACT_MONTH_ASSESS_SUM.equals(contactType) || CONTACT_TYPE_MONTH_ASSES.equals(contactType)) {
        todoDesc = TODO_DESC_MONTH_ASSESS;
      } else if (CONTACT_PERS_HOME_STUDY_SUM.equals(contactType)) {
        todoDesc = TODO_DESC_HOME_STUDY;
      } else if (CONTACT_QUARTER_VISIT_SUM.equals(contactType) || CONTACT_QUARTER_VISIT.equals(contactType)) {
        todoDesc = TODO_DESC_QUARTER_VISIT;
      } else if (CONTACT_REEVALUATION_SUM.equals(contactType) || CONTACT_TYPE_REEVALUATION.equals(contactType)) {
        todoDesc = TODO_DESC_REEVALUATION;
      } else if (CONTACT_REGULAR_SUM.equals(contactType)) {
        todoDesc = TODO_DESC_REGULAR;
      } else if (CONTACT_SERIOUS_INC_SUM.equals(contactType) || CONTACT_TYPE_SERIOUS_INC.equals(contactType)) {
        todoDesc = TODO_DESC_SERIOUS_INC;
      } else if (CONTACT_VARIANCE_SUM.equals(contactType) || CONTACT_TYPE_VARIANCE.equals(contactType)) {
        todoDesc = TODO_DESC_VARIANCE;
      } else if (CONTACT_VIOLATION_SUM.equals(contactType) || CONTACT_TYPE_VIOLATION.equals(contactType)) {
        todoDesc = TODO_DESC_VIOLATION;
      } else if (CONTACT_TYPE_COMP_CHECK.equals(contactType)) {
        todoDesc = TODO_DESC_COMP_CHECK;
      }
    } else if (CONTACT_TYPE_EXT_REQ.equals(contactType)) {
      todoDesc = TODO_DESC_EXT_REQ;
      taskCode = SVC_CD_TASK_APRV_EXT_REQ;
    }
    // SIR 23298 - APS Guardianship Referral form is submitted for approval
    else if (CONTACT_TYPE_GUARDIANSHIP_REFERRAL.equals(contactType)) {
      todoDesc = TODO_DESC_GUARDIANSHIP_REFERRAL;
      if (STAGE_CODE_INV.equals(stage)) {
        taskCode = SVC_CD_TASK_APRV_INV_AGR;
      } else if (STAGE_CODE_APS_SVC.equals(stage)) {
        taskCode = SVC_CD_TASK_APRV_SVC_AGR;
      }
    }

    EventIdStruct_ARRAY retrievedArray = csys07so.getEventIdStruct_ARRAY();
    EventIdStruct_ARRAY newArray = new EventIdStruct_ARRAY();
    ToDoDetailDB toDoDetailDB;

    if (retrievedArray == null || retrievedArray.getEventIdStructCount() < 1) {
      toDoDetailDB = new ToDoDetailDB(todoDesc, GlobalData.getUlIdEvent(request), GlobalData.getUlIdCase(request),
                                      GlobalData.getUlIdStage(request), taskCode);
    } else {
      Enumeration e = retrievedArray.enumerateEventIdStruct();
      EventIdStruct eventIdStruct = new EventIdStruct();
      // The first element in the array we send to do is ALWAYS the ulIdEvent
      // returned in csys07so.getUlIdEvent.
      eventIdStruct.setUlIdEvent(csys07so.getUlIdEvent());
      newArray.addEventIdStruct(eventIdStruct);
      while (e.hasMoreElements()) {
        eventIdStruct = (EventIdStruct) e.nextElement();
        newArray.addEventIdStruct(eventIdStruct);
      }

      toDoDetailDB = new ToDoDetailDB(todoDesc, newArray, GlobalData.getUlIdCase(request),
                                      GlobalData.getUlIdStage(request), taskCode);
    }

    return toDoDetailDB;
  }

  /**
   * <p>
   * This submethod is called by the displayContact_xa() method. It will determine where the user is coming from and
   * obtain a ulIdEvent based on this. We are handling 5 different ways for the user to access the page.
   * </p>
   * <p>
   * Cases:
   * </p>
   * <p/> <blockquote>
   * <ol>
   * <li>The user selected a hyperlink from the Search List page.</li>
   * <li>The user is performing a New Using from the Search List page.</li>
   * <li>The user is Adding a Contact/Summary from the Search List page.</li>
   * <li>The user is accessing the detail page from a Navigable To Do.</li>
   * <li>The user is paginating on the page or the page is reloading from a Save or Save and Submit.</li>
   * </ol>
   * </blockquote>
   * 
   * @param context
   *                GrndsExchangeContext
   * @return ulIdEvent
   */
  private int getUlIdEvent(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCSYS04SO_ARRAY rowcsys04soArray = (ROWCSYS04SO_ARRAY) state.getAttribute("rowcsys04soArray", request);

    if (rowcsys04soArray == null) {
      rowcsys04soArray = new ROWCSYS04SO_ARRAY();
    }

    ROWCSYS04SO rowcsys04so = new ROWCSYS04SO();

    // CASE 1: User selected a HYPERLINK
    // Check to see if HDNULROWSELECTED is valid. If it is valid, this means the user
    // selected a hyperlink and the value was set in the javascript function.
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, HDNULROWSELECTED))) {
      int ulRowSelected = ContextHelper.getIntSafe(request, HDNULROWSELECTED);
      if (ulRowSelected < rowcsys04soArray.getROWCSYS04SOCount()) {
        rowcsys04so = rowcsys04soArray.getROWCSYS04SO(ulRowSelected);
      }
      return rowcsys04so.getUlIdEvent();
    }
    // CASE 2: User selected a row and clicked NEW USING
    else if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnNewUsing.x"))) {
      int ulRowSelected = ContextHelper.getIntSafe(request, ULROWSELECTED);
      if (ulRowSelected < rowcsys04soArray.getROWCSYS04SOCount()) {
        rowcsys04so = rowcsys04soArray.getROWCSYS04SO(ulRowSelected);
      }
      return rowcsys04so.getUlIdEvent();
    }
    // CASE 3: User clicked the ADD button on the Contact Search List page.
    // CASE 4: User is navigating the Contact Detail directly from Case To Do, Staff To Do,
    // or the Event List - all these conversations will put the ulIdEvent into Global Data.
    // CASE 5: The user is attempting to paginate the page or the display
    // is being called after the save (display is presentation url for save).
    return GlobalData.getUlIdEvent(request);
  }

  /**
   * This helper method is called by the displayContactSearchList method to handle and ServiceExceptions by setting the
   * branch, looking up the error message and setting it.
   * 
   * @param we
   *                The ServiceException object.
   * @param context
   *                The GrndsExchangeContext object.
   */
  private void handleContactSearchListDisplayError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    int errorCode = we.getErrorCode();
    switch (errorCode) {
    case Messages.MSG_ARC_DATA_CHANGED:
    case Messages.MSG_ERR_ON_RETURN:
    case Messages.MSG_REPORT_LAUNCH_FAILED:
    case Messages.MSG_REPORT_LAUNCHED:
    case Messages.MSG_SVC_MAX_CONTACT_FORM:
    case Messages.MSG_SVC_NO_CONTACTS_FOUND:
    case Messages.MSG_SVC_STRUCTURED_NARR:
    case Messages.MSG_SYS_NO_CNCT_NARR:
    case Messages.MSG_CONTACT_TYPE_SEARCH:
    case Messages.SSM_COMPLETE_REQUIRED:
    case Messages.SSM_ARC_NO_REPORTS_FOUND:
      setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      setErrorMessage(errorCode, request);
      break;

    default:
      processSevereException(context, we);
      break;
    }
  }

  public static String getPurposeKey(HttpServletRequest request) {
    String stage = GlobalData.getSzCdStage(request);
    String program = GlobalData.getSzCdStageProgram(request);

    if (((CodesTables.CSTAGES_INV.equals(stage)) && ((CodesTables.CPGRMS_APS.equals(program)) || (CodesTables.CPGRMS_AFC
                                                                                                                        .equals(program))))
        || (CodesTables.CSTAGES_SVC.equals(stage))
        || (CodesTables.CSTAGES_AOC.equals(stage))
        || (CodesTables.CSTAGES_FPR.equals(stage))) {
      return "A";
    }
    // If Investigation - Licensing or CPS
    if ((CodesTables.CSTAGES_INV.equals(stage))
        && ((CodesTables.CPGRMSFM_CCL.equals(program)) || (CodesTables.CPGRMSFM_RCL.equals(program)) || (CodesTables.CPGRMSFM_CPS
                                                                                                                                 .equals(program)))) {
      return "B";
    }
    // If PAL or Foster Adoptive Home
    if ((CodesTables.CSTAGES_PAL.equals(stage)) || (CodesTables.CSTAGES_FAD.equals(stage))) {
      return "I";
    }
    // If Intake
    if (CodesTables.CSTAGES_INT.equals(stage)) {
      return "D";
    }
    // If Adoption
    else if ((CodesTables.CSTAGES_ADO.equals(stage)) || (CodesTables.CSTAGES_PAD.equals(stage))) {
      return "H";
    }
    // If Substitute Care
    else if ((CodesTables.CSTAGES_SUB.equals(stage)) || (CodesTables.CSTAGES_FRE.equals(stage))
             || (CodesTables.CSTAGES_FSU.equals(stage))) {
      return "G";
    }
    // Admin Review
    else if ((CodesTables.CSTAGES_ARI.equals(stage)) || (CodesTables.CSTAGES_ARF.equals(stage))) {
      return "K";
    }

    throw new IllegalStateException("Error occurred while returning data.  Contact Tech Support for assistance.");
  }

  public static String getOthersKey(HttpServletRequest request) {
    String stage = GlobalData.getSzCdStage(request);
    String program = GlobalData.getSzCdStageProgram(request);

    // If Service Delivery or Investigation and APS
    if ((CodesTables.CPGRMSFM_APS.equals(program))
        && ((CodesTables.CSTAGES_INV.equals(stage)) || (CodesTables.CSTAGES_SVC.equals(stage)) || (CodesTables.CSTAGES_AOC
                                                                                                                          .equals(stage)))) {
      return "A";
    }
    // If Service Delivery, Investigation, CPS or Licensing
    else if (((CodesTables.CSTAGES_INV.equals(stage)) || (CodesTables.CSTAGES_FPR.equals(stage)))
             && ((CodesTables.CPGRMS_CPS.equals(program)) || (CodesTables.CPGRMS_RCL.equals(program)) || (CodesTables.CPGRMS_CCL
                                                                                                                                .equals(program)))) {
      return "B";
    }
    // If Investigation and Facilities
    else if ((CodesTables.CSTAGES_INV.equals(stage)) && (CodesTables.CPGRMS_AFC.equals(program))) {
      return "C";
    }
    // If Intake
    else if (CodesTables.CSTAGES_INT.equals(stage)) {
      return "D";
    }
    // If PAL
    else if (CodesTables.CSTAGES_PAL.equals(stage)) {
      return "H";
    }
    // If Foster Adoptive Home, Adoption, or Substitute Care
    else if ((CodesTables.CSTAGES_ADO.equals(stage)) || (CodesTables.CSTAGES_SUB.equals(stage))
             || (CodesTables.CSTAGES_FAD.equals(stage)) || (CodesTables.CSTAGES_PAD.equals(stage))
             || (CodesTables.CSTAGES_FRE.equals(stage)) || (CodesTables.CSTAGES_FSU.equals(stage))) {
      return "G";
    }
    // Admin Review
    if ((CodesTables.CSTAGES_ARI.equals(stage)) || (CodesTables.CSTAGES_ARF.equals(stage))) {
      return "K";
    }

    throw new IllegalStateException("Error occurred while returning data.  Contact Tech Support for assistance.");
  }

  public static String getTypeKey(HttpServletRequest request) {
    CSYS08SO csys08so = getCSYS08SO(request);
    if (csys08so == null) {
      csys08so = new CSYS08SO();
    }

    String stage = GlobalData.getSzCdStage(request);
    // String program = GlobalData.getSzCdStageProgram(request);

    // If the stage is closed, we always display the decodes that begin
    // with 'F'. This includes Closed Case Addendum.

    // STGAP00013826 - MR-24 All code starting with 'F' have been end dated. We also need to be displaying the type key
    // for the
    // correct stage since we are adding contacts to closed stages now.

    // if (!DateHelper.isNull(csys08so.getDtDtStageClose() && request.getAttribute( "allowAddOnClosedStage" )))) {
    // (csys08so.getDtDtStageClose() != null) &&
    // (DateHelper.NULL_CASTOR_DATE.equals(csys08so.getDtDtStageClose()) == false)) {
    // return "F";
    // }

    // -- CPS IS ONLY PROGRAM USED *********************
    // If we are in a CPS or Licensing Investigation filter on "A"
    if (CodesTables.CSTAGES_INV.equals(stage)) { // &&
      // ((CodesTables.CPGRMS_CPS.equals(program)) ||
      // (CodesTables.CPGRMS_CCL.equals(program)) ||
      // (CodesTables.CPGRMS_RCL.equals(program)))) {
      return "A";
    }

    // -- FRE NO LONGER USED ***************************
    // If Service Delivery and CPS
    // else if (CodesTables.CSTAGES_FRE.equals(stage)) {
    // return "B";
    // }

    // -- APS PROGRAM NO LONGER USED *******************
    // If Service Delivery or Investigation and APS
    // else if ((CodesTables.CPGRMS_APS.equals(program)) &&
    // ((CodesTables.CSTAGES_INV.equals(stage)) ||
    // (CodesTables.CSTAGES_SVC.equals(stage)) ||
    // (CodesTables.CSTAGES_AOC.equals(stage)))) {
    // return "C";
    // }

    // If Intake
    else if (CodesTables.CSTAGES_INT.equals(stage)) {
      return "D";
    }

    // -- PAL NO LONGER USED ***************************
    // If PAL
    else if (CodesTables.CSTAGES_PAL.equals(stage)) {
      return "J";
    }

    // -- AFC PROGRAM NO LONGER USED *******************
    // If Investigation and Facilities
    // else if ((CodesTables.CSTAGES_INV.equals(stage)) && (CodesTables.CPGRMSFM_AFC.equals(program))) {
    // return "E";
    // }

    // -- THIS REPLACED BELOW **************************
    // If Substitute Care or Preparation for Adult Living, PAL
    // else if (CodesTables.CSTAGES_SUB.equals(stage)) {
    // return "G";
    // }

    // If Adoption
    else if ((CodesTables.CSTAGES_ADO.equals(stage))) {
      return "H";
    }

    // If Foster Adoptive Home
    else if (CodesTables.CSTAGES_FAD.equals(stage)) {
      return "I";
    }

    // Admin Review
    else if ((CodesTables.CSTAGES_ARI.equals(stage)) || (CodesTables.CSTAGES_ARF.equals(stage))) {
      return "K";
    }

    // -- Ongoing (FPR, ONG)
    else if (CodesTables.CSTAGES_FPR.equals(stage) || CodesTables.CSTAGES_ONG.equals(stage)) {
      return "L";
    }

    // -- Foster Care Child (SUB, FCC)
    else if (CodesTables.CSTAGES_SUB.equals(stage) || CodesTables.CSTAGES_FCC.equals(stage)) {
      return "M";
    }

    // -- Diversion
    else if (CodesTables.CSTAGES_DIV.equals(stage)) {
      return "N";
    }

    // -- Foster Care Family (FSU, FCF)
    else if (CodesTables.CSTAGES_FSU.equals(stage) || CodesTables.CSTAGES_FCF.equals(stage)) {
      return "O";
    }

    // -- Post Foster Care
    else if (CodesTables.CSTAGES_PFC.equals(stage)) {
      return "P";
    }

    // -- Post Adoption Care
    else if (CodesTables.CSTAGES_PAD.equals(stage)) {
      return "Q";
    }

    throw new IllegalStateException("Error occurred while returning data.  Contact Tech Support for assistance.");
  }
}
