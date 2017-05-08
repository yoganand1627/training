package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDB;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

/** @todo add parameters, etc. to javadocs that are not _xa methods */

/**
 * Replaces /inc/ccmn91w.win. Defines phoneDetail, phonePullback, and phoneSave.
 *
 * @author Matthew McClain, March 1, 2003
 *         <p/>
 *         07/15/05 floresj   SIR 23727 Refactored for Phase II implemnetation
 */
//public class PhoneConversation extends BaseHiddenFieldStateConversation
public class PhoneConversation extends PhoneBaseConversation {
  // SIR 23727 Start
//  public static final String TRACE_TAG = "PhoneConversation";
//  public static final String PHONE_SUB_PERSON_ID = "phonePersonId";
//  public static final String PHONE_SUB_PERSON_NAME = "phonePersonName";
//  public static final String CONVERSATION_URL = "/person/PhoneConversation/";
//  public static final String FORWARD_TO = CONVERSATION_URL + "ForwardTo";
//  public static final String PHONE_DETAIL = CONVERSATION_URL + "PhoneDetail";
//  public static final String PHONE_DETAIL_PHONE = "phoneDB";
//  public static final String PHONE_PULLBACK = CONVERSATION_URL + "PhonePullback";
//  public static final String PHONE_PULLBACK_PHONES = "phonesDB";
//  public static final String PHONE_SAVE = CONVERSATION_URL + "PhoneSave";
//  public static final String PHONE_SUB_HOLDER = CONVERSATION_URL + "PhoneSubHolder";
//  public static final String RETURN_URL = "phoneSub_returnUrl";
//  public static final String PAGE_MODE = "PHONE_SUBMODULE_PAGE_MODE_KEY";
//  protected static final String TRUE = "Y";
//  protected static final String FALSE = "N";
  //SIR 23727 End

  private Person person;

  public void setPerson(Person person) {
    this.person = person;
  }

  /** Contructor */
  public PhoneConversation() {
    super();
  }

  /**
   * Retrieves PhoneDB for the PhoneDetail.jsp
   *
   * @param context The GrndsExchangeContext object.
   */
//SIR 23727 Start
//  public void phoneDetail_xa( GrndsExchangeContext context )
//  {
//    PerformanceTrace performanceTrace = PerformanceTrace.enterScope( TRACE_TAG, "phoneDetail_xa" );
//
//    HttpServletRequest request = context.getRequest();
//    BaseSessionStateManager state = getSessionStateManager( context );
//
//    try
//    {
//      int personId = ContextHelper.getIntSafe(request, PHONE_SUB_PERSON_ID);
//      if( personId != 0 )
//      {
//        GlobalData.setUlIdPerson(personId, request);
//      }
//
//      String personName = ContextHelper.getStringSafe(request, PHONE_SUB_PERSON_NAME);
//      if( !"".equals( personName ) )
//      {
//        GlobalData.setSzNmPersonFull(personName, request);
//      }
//
//      // SIR 22456 - Get page mode out of request using PAGE_MODE constant
//      // key name because that is the name that JSP's that include the phone
//      // submodule are expecting to use. Also put page mode back into the
//      // request using the same name.
//      String pageMode = ContextHelper.getString( request, PAGE_MODE );
//      if( ( pageMode == null ) || ( pageMode.equals( "" ) ) )
//      {
//        pageMode = PageMode.getPageMode( request );
//      }
//      request.setAttribute( PAGE_MODE, pageMode );
//
//      PhoneDB phoneDB = getPhoneDB( request );
//      request.setAttribute( PHONE_DETAIL_PHONE, phoneDB );
//    }
//    catch( Throwable e )
//    {
//      e.printStackTrace();
//      processSevereException( context, e );
//    }
//    finally
//    {
//      performanceTrace.exitScope();
//    }
//  }
//SIR 23727 End

  /**
   * Retrieves the vector of PhoneDBs for PhonePullback.jsp based on stageId
   * and stageType. Sets SSM_NO_ROWS_RETURNED if vector.size() == 0.
   *
   * @param context The GrndsExchangeContext object.
   */
//SIR 23727 Start
//  public void phonePullback_xa( GrndsExchangeContext context )
//  {
//    PerformanceTrace performanceTrace = PerformanceTrace.enterScope( TRACE_TAG, "phonePullback_xa" );
//
//    HttpServletRequest request = context.getRequest();
//
//    try
//    {
//      int stageId = GlobalData.getUlIdStage( request );
//      String stageCode = GlobalData.getSzCdStage( request );
//
//      List vector = phone.getActivePhonesForStage( stageId, stageCode );
//
//      request.setAttribute( PHONE_PULLBACK_PHONES, vector );
//
//      if( vector.size() == 0 )
//      {
//        String SSM_NO_ROWS_RETURNED = MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED );
//        setErrorMessage( SSM_NO_ROWS_RETURNED, PHONE_PULLBACK, request );
//      }
//    }
//    catch( Throwable e )
//    {
//      e.printStackTrace();
//      processSevereException( context, e );
//    }
//    finally
//    {
//      performanceTrace.exitScope();
//    }
//  }
//SIR 23727 End

  /**
   * Save the Phone passed on the request to it. Executes PhoneSave Method object (command). If PhoneSave has an
   * errorMessage, control is returned to PhoneDetail to resolve. Otherwise, forwards request to returnUrl.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void phoneSave_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "phoneSave_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();

    try {
      String taskCode = GlobalData.getSzCdTask(request);
      int personId = GlobalData.getUlIdPerson(request);

      //stageId should only be 0 coming from StaffDetail (says ccmn31s.src)
      int stageId = GlobalData.getUlIdStage(request);

      String returnUrl = ContextHelper.getString(request, PhoneConversation.RETURN_URL);

      PhoneDB phoneDB = getPhoneDB(request);

      PhoneSave phoneSave = new PhoneSave();
      phoneSave.setTaskCode(taskCode);
      phoneSave.setPersonId(personId);
      phoneSave.setStageId(stageId);
      phoneSave.setPhoneDB(phoneDB);
      phoneSave.execute(person);

      String errorMessage = phoneSave.getErrorMessage();
      if (errorMessage != null) {
        String url = PHONE_DETAIL;

        setErrorMessage(errorMessage, url, request);

        request.setAttribute(PHONE_DETAIL_PHONE, phoneDB);
        forward(url, request, response);
        return;
      }

      forward(returnUrl, request, response);
    }
    catch (Throwable e) {
      e.printStackTrace();
      processSevereException(context, e);
    }
    finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Calls CCMN46S which returns a list of phone numbers for a person.
   *
   * @param personId The id of the person row.
   */
  @SuppressWarnings("unchecked")
  public static CCMN46SO callCCMN46S(int personId, Person person)
          throws ServiceException, MarshalException, ValidationException {
    CCMN46SO ccmn46so = null;
    List vector = new ArrayList();

    int i = 0;
    while (true) {
      i++;

      ArchInputStruct archInputStruct = new ArchInputStruct();
      archInputStruct.setUsPageNbr(i);
      archInputStruct.setUlPageSizeNbr(50);

      CCMN46SI ccmn46si = new CCMN46SI();
      ccmn46si.setArchInputStruct(archInputStruct);
      ccmn46si.setUlIdPerson(personId);

      /* from ccmn80w.win:
      ** SysIndValidOnly is only used for Intake,
      ** for the purposes of showing telephone numbers
      ** that were valid within a particular date range.
      ** Chris Guarriello suggested that I set this value to FALSE.
                        */
      ccmn46si.setBSysIndIntake(ArchitectureConstants.N);
      ccmn46so = person.retrievePhoneListDetail(ccmn46si);

      addRowsToVector(ccmn46so, vector);

      ArchOutputStruct archOutputStruct = ccmn46so.getArchOutputStruct();
      if (isFalse(archOutputStruct.getBMoreDataInd())) {
        break;
      }
    }
    setRowsOnCCMN46SO(ccmn46so, vector, false);
    return ccmn46so;
  }

  /**
   * All ROWCCMN46SOG00 of ccmn46so are set in vector.
   */
//SIR 23727 Start
//  protected static void addRowsToVector( CCMN46SO ccmn46so,
//      List vector )
//  {
//    ROWCCMN46SOG00[] outputArray = ccmn46so.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00();
//    List list = Arrays.asList( outputArray );
//    vector.addAll( list );
//  }
//SIR 23727 End

  /**
   * Vector of ROWCCMN46SOG00 are set back on ccmn46so.
   */
//SIR 23727 Start
//  protected static void setRowsOnCCMN46SO( CCMN46SO ccmn46so,
//      List list,
//      boolean more )
//  {
//    ROWCCMN46SOG00[] outputArray = new ROWCCMN46SOG00[list.size()];
//    list.toArray( outputArray );
//
//    ROWCCMN46SOG00_ARRAY rowccmn46so_array = new ROWCCMN46SOG00_ARRAY();
//    rowccmn46so_array.setROWCCMN46SOG00( outputArray );
//    rowccmn46so_array.setUlRowQty( outputArray.length );
//
//    ccmn46so.setROWCCMN46SOG00_ARRAY( rowccmn46so_array );
//
//    ArchOutputStruct archOutputStruct = ccmn46so.getArchOutputStruct();
//    archOutputStruct.setUlRowQty( outputArray.length );
//    archOutputStruct.setBMoreDataInd( FALSE );
//    if( more )
//    {
//      archOutputStruct.setBMoreDataInd( TRUE );
//    }
//  }
//SIR 23727 End

  /**
   * Either retrieves the PhoneDB from the request attribute, or creates a new
   * one and fills it with the request parameters.
   */
//SIR 23727 Start
//  protected static PhoneDB getPhoneDB( HttpServletRequest request )
//      throws Exception
//  {
//    PhoneDB phoneDB = (PhoneDB)request.getAttribute( PHONE_DETAIL_PHONE );
//    if( phoneDB != null )
//    {
//      GrndsTrace.msg( TRACE_TAG, 7, "retrieving phoneDB from request attribute" );
//      request.removeAttribute( PHONE_DETAIL_PHONE );
//      return phoneDB;
//    }
//    GrndsTrace.msg( TRACE_TAG, 7, "retrieving phoneDB from request parameters" );
//
//    phoneDB = new PhoneDB();
//    phoneDB.setPersonId( GlobalData.getUlIdPerson( request ) );
//    phoneDB.setPersonFullName( GlobalData.getSzNmPersonFull( request ) );
//    phoneDB.setPhoneId( ContextHelper.getIntSafe( request, "phoneId" ) );
//    phoneDB.setPhoneType( ContextHelper.getString( request, "phoneType" ) );
//    phoneDB.setPrimary( ContextHelper.getBooleanSafe( request, "phonePrimary" ) );
//    phoneDB.setInvalid( ContextHelper.getBooleanSafe( request, "phoneInvalid" ) );
//    phoneDB.setNumber( ContextHelper.getPhoneSafe( request, "phoneNumber" ) );
//    phoneDB.setExtension( ContextHelper.getStringSafe( request, "phoneExtension" ) );
//    phoneDB.setComments( ContextHelper.getStringSafe( request, "phoneComments" ) );
//
//    String startDateString = ContextHelper.getStringSafe( request, "phoneStartDate" );
//    Date startDate = DateHelper.toJavaDateFromInputWithDefault( startDateString, null );
//    if( startDate == null )
//    {
//      startDate = new Date();
//    }
//    phoneDB.setStartDate( startDate );
//
//
//    String endDateString = ContextHelper.getStringSafe( request, "phoneEndDate" );
//    Date endDate = DateHelper.toJavaDateFromInputWithDefault( endDateString, null );
//    if( ( endDate == null ) &&
//        ( phoneDB.getInvalid() ) )
//    {
//      endDate = new Date();
//    }
//    phoneDB.setEndDate( endDate );
//
//
//    long lastUpdateTime = ContextHelper.getLongSafe( request, "phoneLastUpdate" );
//    Date lastUpdate = null;
//    if( lastUpdateTime != 0 )
//    {
//      lastUpdate = new Date( lastUpdateTime );
//    }
//    phoneDB.setLastUpdate( lastUpdate );
//
//    return phoneDB;
//  }
//SIR 23727 End

  /**
   * Converts a ROWCCMN46SOG00 to a PhoneDB
   */
//SIR 23727 Start
//  protected static PhoneDB toPhoneDB( ROWCCMN46SOG00 row )
//  {
//    PhoneDB phoneDB = new PhoneDB();
//    phoneDB.setComments( row.getSzTxtPhoneComments() );
//    phoneDB.setEndDate( DateHelper.toJavaDate( row.getDtDtPersonPhoneEnd() ) );
//    phoneDB.setExtension( row.getLNbrPhoneExtension() );
//    phoneDB.setInvalid( row.getBIndPersonPhoneInvalid().equals( TRUE ) );
//    phoneDB.setLastUpdate( row.getTsLastUpdate() );
//    phoneDB.setNumber( row.getLNbrPhone() );
//    phoneDB.setPhoneId( row.getUlIdPhone() );
//    phoneDB.setPhoneType( row.getSzCdPhoneType() );
//    phoneDB.setPrimary( row.getBIndPersonPhonePrimary().equals( TRUE ) );
//    phoneDB.setStartDate( DateHelper.toJavaDate( row.getDtDtPersonPhoneStart() ) );
//    return phoneDB;
//  }
//SIR 23727 End

  /**
   * Similar to StringHelper.isTrue, except it handles null and "1"
   */
//SIR 23727 Start
//  protected static boolean isTrue( String string )
//  {
//    return ( ( string != null ) &&
//             ( string.equals( "Y" ) || string.equals( "1" ) ) );
//  }
//SIR 23727 End

  /**
   * Similar to StringHelper.isFalse, except it handles null and "1"
   */
//SIR 23727 Start
//  protected static boolean isFalse( String string )
//  {
//    return ( isTrue( string ) == false );
//  }

  /** @todo add javadoc */
  //!!! modify StringHelper?
  //used by PhoneSub.jsp
//  public static int stringToInt( String string )
//  {
//    string = safeString( string );
//    if( string.equals( "" ) )
//    {
//      return 0;
//    }
//    return Integer.parseInt( string );
//  }
//SIR 23727 Start

  /**
   * Never returns null; returns "" instead.
   */
//SIR 23727 Start
//  public static String safeString( String string )
//  {
//    if( string == null )
//    {
//      return "";
//    }
//    string = string.trim();
//    if( string.equals( "null" ) )
//    {
//      return "";
//    }
//    return string;
//  }
//SIR 23727 End
}