package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.AddressValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.common.AddressList;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN42SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This is the address detail conversation. It is called from the Address List and is used as a submodule to add,
 * update, and delete (end date) address information for a specific person. <p/> Change History: Date User Description
 * -------- ---------------- -------------------------------------------------- 05/18/04 DEMOMA SIR22875 Changed
 * AddressValueBean so that it is returned empty id's equal 0 and all other fields 'null' files also changed
 * AddressDao.java, AddressValueBean.java
 */
public class AddressDetailConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "AddressDetailConversation";

  public static final String SAVE_URL = "/person/AddressDetail/saveAddress";

  public static final String ADDRESS_LIST_PULLBACK = "AddressListPullBackList";

  public static final String MEDICAID_ADDRESS_CODE = "MD";
  
  public static final String MARK_REMOVAL_ALLOWED = "MarkRemovalAllowed";

  private AddressList addressList;
  private Person person;

  public void setAddressList(AddressList addressList) {
    this.addressList = addressList;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  /** @param context The GrndsExchangeContext object. */
  public void addressDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addressDetail_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    int idIndex;
    
    String markRemovalAllowed = ArchitectureConstants.N;

    try {
      /* addressList is from the address pullback EJB */
      List addressList = (List) state.getAttribute(ADDRESS_LIST_PULLBACK, request);
      CCMN42SO ccmn42so = (CCMN42SO) state.getAttribute(AddressListConversation.ADDRESS_LIST, request);

      String cReqFuncCd = ContextHelper.getStringSafe(request, "cReqFuncCd");

      ROWCCMN42SOG00_ARRAY rowccmn42sog00_array = ccmn42so.getROWCCMN42SOG00_ARRAY();

      if (rowccmn42sog00_array != null) {
        ccmn42so.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(0).getSzTxtPersonEmail();
        String windowName = (String) state.getAttribute("AddressListIncludePage", request);

        state.setAttribute(AddressListConversation.PAGE_MODE_KEY,
                           AddressListConversation.getPageMode(request, windowName), request);

        if (cReqFuncCd.equalsIgnoreCase(AddressListConversation.REQ_FUNC_CD_UPDATE)) {
          idIndex = Integer.parseInt(ContextHelper.getStringSafe(request, "indexNum"));
          ROWCCMN42SOG00 addressRow = rowccmn42sog00_array.getROWCCMN42SOG00(idIndex);
          AddressBean addressBean = new AddressBean();
          addressBean.setAddress1(addressRow.getSzAddrPersAddrStLn1());
          addressBean.setAddress2(addressRow.getSzAddrPersAddrStLn2());
          addressBean.setCity(addressRow.getSzAddrCity());
          addressBean.setState(addressRow.getSzCdAddrState());
          // !!! dup'd logic
          if (addressRow.getLAddrZip() != null) {
            if (addressRow.getLAddrZip().length() <= 5) {
              addressBean.setZip(addressRow.getLAddrZip());
            } else {
              addressBean.setZip(addressRow.getLAddrZip().substring(0, 5));
              addressBean.setZipSuff(addressRow.getLAddrZip().substring(6));
            }
          }

          addressBean.setCounty(addressRow.getSzCdAddrCounty());
          addressBean.setComments(addressRow.getSzTxtPersAddrCmnts());
          addressBean.addToRequest(request);
          request.setAttribute("AddressDetail_Attribute", addressRow);
          if (checkForMarkRemoval(ccmn42so, addressRow)) {
            markRemovalAllowed = ArchitectureConstants.Y;
          }
          GrndsTrace.msg(TRACE_TAG, 10, "addressRow_is:" + addressRow.toString());
        }
        else if (AddressListConversation.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
          if (checkForMarkRemoval(ccmn42so, null)) {
            markRemovalAllowed = ArchitectureConstants.Y;
          }
        }
      }
      // JMC SIR 17462 - When the user selects the ADD button from the Address List,
      // we have to set a blank address bean into the request. If we do not and the
      // page we are coming from utilizes the Address Submodule, the Address List Detail page
      // will grab the bean from the previous page and display those values for Address.
       if (AddressListConversation.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        AddressBean aapBean = new AddressBean();
        aapBean.addToRequest(request);
        markRemovalAllowed = ArchitectureConstants.Y;
      }
      
      request.setAttribute(MARK_REMOVAL_ALLOWED, markRemovalAllowed);
      
      // JMC SIR 17462 END
      GrndsTrace.msg(TRACE_TAG, 10, "rbAddressRadioIndex_is:"
                                    + ContextHelper.getStringSafe(request, "rbAddressRadioIndex"));
      if (cReqFuncCd.equalsIgnoreCase(AddressListConversation.REQ_FUNC_CD_CONTINUE)
          && request.getParameter("rbAddressRadioIndex") != null) {
        idIndex = Integer.parseInt(ContextHelper.getStringSafe(request, "rbAddressRadioIndex"));
        AddressValueBean addressRow = (AddressValueBean) addressList.get(idIndex);
        AddressBean addressBean = new AddressBean();
        if (addressRow.getStreetLn1() != null) {
          addressBean.setAddress1(addressRow.getStreetLn1());
        }
        if (addressRow.getStreetLn2() != null) {
          addressBean.setAddress2(addressRow.getStreetLn2());
        }
        if (addressRow.getCity() != null) {
          addressBean.setCity(addressRow.getCity());
        }
        if (addressRow.getState() != null) {
          addressBean.setState(addressRow.getState());
        }
        if (addressRow.getZip() != null) {
          // !!! dup'd logic
          if (addressRow.getZip().length() <= 5) {
            addressBean.setZip(addressRow.getZip());
          } else {
            addressBean.setZip(addressRow.getZip().substring(0, 5));
            addressBean.setZipSuff(addressRow.getZip().substring(6));
          }
        }
        if (addressRow.getCounty() != null) {
          addressBean.setCounty(addressRow.getCounty());
        }
        addressBean.addToRequest(request);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception executing addressDetail_xa.");
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * * this function will list all the addresses of persons in the same stageId
   *
   * @param context The GrndsExchangeContext object.
   */
  public void addressListPullBack_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addressListPullBack_xa()");
    performanceTrace.enterScope();

    // Get the addresses and store it to request and state
    populateAddressListPullBack(context);

    // request.setAttribute(ADDRESS_LIST, ccmn42so);
    // state.setAttribute(ADDRESS_LIST, ccmn42so, request);

    performanceTrace.exitScope();
    return;
  }

  /**
   * * this function will list all the addresses of persons in the same stageId
   *
   * @param context The GrndsExchangeContext object.
   */
  public void addressPullBackContinue_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addressPullBackContinue_xa()");
    performanceTrace.enterScope();
    // Allocate the structures
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    int i = ContextHelper.getIntSafe(request, "rbAddressRadioIndex");
    List vTmp = (List) state.getAttribute(ADDRESS_LIST_PULLBACK, request);
    AddressValueBean b;

    b = (AddressValueBean) vTmp.get(i);
    request.setAttribute(ADDRESS_LIST_PULLBACK, vTmp);
    request.setAttribute("AddressListPullBackListRow", b);

    performanceTrace.exitScope();
  }

  /**
   * * this function will add one row Address_Person_link and Person_Address table
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveAddress_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAddress_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // Save the addresses
      CCMN44SI ccmn44si = this.populateCCMN44SI_fromRequest(context);
      // CCMN44SO ccmn44so = CCMN44SO.unmarshal(new StringReader(WtcHelper.callService("CCMN44S", ccmn44si)));
      CCMN44SO ccmn44so = person.saveAddressListDetail(ccmn44si);
      if (ccmn44so != null) {
        String forwardURI = (String) state.getAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, request);
        forward(forwardURI, request, context.getResponse());
      }
    } catch (ServiceException we) {
      // This error is thrown by the populate method when the user
      // attempts to save a duplicate record. The service is
      // not actually called.
      if (we.getErrorCode() == Messages.MSG_DUPLICATE_RECORD) {
        setPresentationBranch("error", context);
        setErrorMessage(Messages.MSG_DUPLICATE_RECORD, SAVE_URL, request);
        return;
      }
      switch (we.getErrorCode()) {
        case Messages.MSG_SYS_STAGE_CLOSED:
        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        case Messages.MSG_DUPLICATE_RECORD:
          this.setPresentationBranch("error", context);
          setErrorMessage(we.getErrorCode(), SAVE_URL, request);
          break;

        default:
          processSevereException(context, we);
          break;
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  public CCMN44SI populateCCMN44SI_fromRequest(GrndsExchangeContext context) throws ServiceException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    AddressSave addressSave = new AddressSave();
    addressSave.setCCMN42SO((CCMN42SO) state.getAttribute(AddressListConversation.ADDRESS_LIST, request));
    addressSave.setCReqFuncCd(ContextHelper.getStringSafe(request, "cReqFuncCd"));
    addressSave.setIndexNum(ContextHelper.getIntSafe(request, "indexNum"));
    addressSave.setIndPrimary(CheckboxHelper.getCheckboxValue(request, "cbxBIndPersAddrLinkPrimary"));
    addressSave.setIndInvalid(CheckboxHelper.getCheckboxValue(request, "cbxBIndPersAddrLinkInvalid"));
    addressSave.setDateEnd(ContextHelper.getStringSafe(request, "txtDtDtPersAddrLinkEnd"));
    addressSave.setAttention(ContextHelper.getStringSafe(request, "txtSzAddrPersAddrAttn"));
    addressSave.setEmail(ContextHelper.getStringSafe(request, "szTxtPersonEmail"));
    addressSave.setAddressType(ContextHelper.getStringSafe(request, "selSzCdPersAddrLinkType"));
    addressSave.setIndRemovalHome(CheckboxHelper.getCheckboxValue(request, "cbxBIndRemovalHome"));
    addressSave.setAddressBean(AddressBean.getFromRequest(request));
    return populateCCMN44S_AUD(context, addressSave);
  }

  /** @param context The GrndsExchangeContext object. */
  public static CCMN44SI populateCCMN44S_AUD(GrndsExchangeContext context, AddressSave addressSave)
          throws ServiceException {
    HttpServletRequest request = context.getRequest();
    CCMN42SO ccmn42so = addressSave.getCCMN42SO();

    // We pass one of two cReqFuncCd's to our service - either Add or Update.
    // Later on in this populate method, we assumer !bAdd == bUpdate.
    boolean bAdd = false;
    String cReqFuncCd = addressSave.getCReqFuncCd();
    if (AddressListConversation.REQ_FUNC_CD_NEW_USING.equals(cReqFuncCd)
        || AddressListConversation.REQ_FUNC_CD_CONTINUE.equals(cReqFuncCd)
        || AddressListConversation.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      bAdd = true;
      cReqFuncCd = AddressListConversation.REQ_FUNC_CD_ADD;
    }

    ArchInputStruct archinputstruct = new ArchInputStruct();
    archinputstruct.setCReqFuncCd(cReqFuncCd);
    archinputstruct.setSzUserId(getUserLogonID(request));

    CCMN44SI ccmn44si = new CCMN44SI();
    ccmn44si.setArchInputStruct(archinputstruct);

    ROWCCMN44SIG00_ARRAY rowccmn44sig00_array = new ROWCCMN44SIG00_ARRAY();
    ROWCCMN44SIG00 rowccmn44sig00 = new ROWCCMN44SIG00();
    rowccmn44sig00.setSzCdScrDataAction(cReqFuncCd);

    boolean bEndDatePrimary = false;
    boolean bMedicaidAddress = MEDICAID_ADDRESS_CODE.equals(addressSave.getAddressType());

    if (bAdd) {
      // !!! 3 lines copied below
      rowccmn44sig00.setDtDtPersAddrLinkEnd(null);
      rowccmn44sig00.setUlIdAddrPersonLink(0);
      rowccmn44sig00.setLdIdAddress(0);
      // SIR 19834 - Medicaid Update flag not being set for Added rows.
      if (bMedicaidAddress) {
        rowccmn44sig00.setBSysIndAddrMedUpdate(ArchitectureConstants.Y);
      } else {
        rowccmn44sig00.setBSysIndAddrMedUpdate(ArchitectureConstants.N);
      }
    } else {
      int iIndex = addressSave.getIndexNum();

      ROWCCMN42SOG00_ARRAY rowccmn42sog00_array = ccmn42so.getROWCCMN42SOG00_ARRAY();

      if (rowccmn42sog00_array != null) {
        ROWCCMN42SOG00 rowccmn42sog00 = rowccmn42sog00_array.getROWCCMN42SOG00(iIndex);
        if (rowccmn42sog00 != null) {
          rowccmn44sig00.setTsLastUpdate(rowccmn42sog00.getTsLastUpdate());
          rowccmn44sig00.setTsSysTsLastUpdate2(rowccmn42sog00.getTsSysTsLastUpdate2());
          rowccmn44sig00.setDtDtPersAddrLinkEnd(rowccmn42sog00.getDtDtPersAddrLinkEnd());
          rowccmn44sig00.setDtDtPersAddrLinkStart(rowccmn42sog00.getDtDtPersAddrLinkStart());
          rowccmn44sig00.setUlIdAddrPersonLink(rowccmn42sog00.getUlIdAddrPersonLink());
          rowccmn44sig00.setLdIdAddress(rowccmn42sog00.getLdIdAddress());
          rowccmn44sig00.setLNbrPersonAddrHash(rowccmn42sog00.getLNbrPersonAddrHash());

          // if we are updating an existing record (valid & end date = null) to a primary record,
          // then
          // current primary address should be end dated
          // the non-primary record we are marking as primary should also be end-dated.
          // and a new primary address should begin
          if ((!ArchitectureConstants.Y.equals(addressSave.getIndInvalid())) && (isDateNull(addressSave.getDateEnd()))
              && (!ArchitectureConstants.Y.equals(rowccmn42sog00.getBIndPersAddrLinkPrimary()))
              && (ArchitectureConstants.Y.equals(addressSave.getIndPrimary()))) {
            // signal to end-date existing primary
            bEndDatePrimary = true;

            // create a new row with primary = true
            // !!! first 3 lines copied from if (bAdd)
            rowccmn44sig00.setDtDtPersAddrLinkEnd(null);
            rowccmn44sig00.setUlIdAddrPersonLink(0);
            rowccmn44sig00.setLdIdAddress(0);
            rowccmn44sig00.setTsLastUpdate(null);
            rowccmn44sig00.setTsSysTsLastUpdate2(null);
            rowccmn44sig00.setDtDtPersAddrLinkStart(DateHelper.getTodayCastorDate());
            rowccmn44sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);

            // end date old row
            ROWCCMN44SIG00 oldRow = createROWCCMN44SIG00(rowccmn42sog00);
            oldRow.setDtDtPersAddrLinkEnd(DateHelper.getTodayCastorDate());
            oldRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
            rowccmn44sig00_array.addROWCCMN44SIG00(oldRow);
          }
          /*
           * If the address type is Medicaid and the DataAction * code is not ADD (therefore the row is being updated)
           * set the * Medicaid Update flag to FND_YES (from ccmn92w.win)
           */
          if (MEDICAID_ADDRESS_CODE.equals(rowccmn42sog00.getSzCdPersAddrLinkType())) {
            /* check for change in end date between request and what it was in database */
            if (!isDateNull(addressSave.getDateEnd()) && rowccmn42sog00.getDtDtPersAddrLinkEnd() == null) {
              rowccmn44sig00.setBSysIndAddrMedUpdate(ArchitectureConstants.Y);
            }
            /*
             * check for change in invalid checkbox between request and what it was in database. We also check to make
             * sure the user has not saved an end date via the "set end date" button.
             */
            if (ArchitectureConstants.Y.equals(addressSave.getIndInvalid())
                && !ArchitectureConstants.Y.equals(rowccmn42sog00.getBIndPersAddrLinkInvalid())
                && rowccmn42sog00.getDtDtPersAddrLinkEnd() == null) {
              rowccmn44sig00.setBSysIndAddrMedUpdate(ArchitectureConstants.Y);
            }
          }
        }
      }
    }

    // The following logic pertains to both ADD's and UPDATE's
    if (!isDateNull(addressSave.getDateEnd())) {
      rowccmn44sig00.setDtDtPersAddrLinkEnd(DateHelper.toCastorDateSafe(addressSave.getDateEnd()));
    }
    AddressBean addressBean = addressSave.getAddressBean();
    rowccmn44sig00.setSzAddrCity(addressBean.getCity());
    rowccmn44sig00.setSzAddrPersAddrStLn1(addressBean.getAddress1());
    rowccmn44sig00.setSzAddrPersAddrStLn2(addressBean.getAddress2());
    rowccmn44sig00.setSzCdAddrCounty(addressBean.getCounty());
    rowccmn44sig00.setSzCdAddrState(addressBean.getState());
    if ("".equals(addressBean.getZipSuff())) {
      rowccmn44sig00.setLAddrZip(addressBean.getZip());
    } else {
      rowccmn44sig00.setLAddrZip(addressBean.getZip() + "-" + addressBean.getZipSuff());
    }
    rowccmn44sig00.setSzTxtPersAddrCmnts(addressBean.getComments());
    rowccmn44sig00.setSzAddrPersAddrAttn(addressSave.getAttention());
    rowccmn44sig00.setSzTxtPersonEmail(addressSave.getEmail());
    rowccmn44sig00.setSzCdPersAddrLinkType(addressSave.getAddressType());
    rowccmn44sig00.setBIndPersAddrLinkInvalid(addressSave.getIndInvalid());
    rowccmn44sig00.setBIndRemovalHome(addressSave.getIndRemovalHome());

    if (ArchitectureConstants.Y.equals(addressSave.getIndPrimary())) {
      rowccmn44sig00.setBIndPersAddrLinkPrimary(addressSave.getIndPrimary());
    } else {
      // if there is no primary address, then make this address a primary if the address is a valid address
      if (checkForPrimary(addressSave.getCCMN42SO()) || ArchitectureConstants.Y.equals(addressSave.getIndInvalid())) {
        rowccmn44sig00.setBIndPersAddrLinkPrimary(ArchitectureConstants.N);
      } else {
        rowccmn44sig00.setBIndPersAddrLinkPrimary(ArchitectureConstants.Y);
      }
    }

    // if the address type is MEDICAID_ADDRESS_CODE, set the medicaid flag to NO. because this address no longer
    //   needs to be saved
    // if a record is invalid & end date is null, then end date the record
    if (ArchitectureConstants.Y.equals(addressSave.getIndInvalid()) && isDateNull(addressSave.getDateEnd())) {
      rowccmn44sig00.setDtDtPersAddrLinkEnd(DateHelper.getTodayCastorDate());
      if (bMedicaidAddress && !bAdd) {
        rowccmn44sig00.setBSysIndAddrMedUpdate(ArchitectureConstants.Y);
      } else {
        rowccmn44sig00.setBSysIndAddrMedUpdate(ArchitectureConstants.N);
      }
    }
    // if adding an end dated address or invalid address, no need to check for duplicate also no need to check for
    // duplicate on update because address is unchangable on update
    boolean bDuplicateCheck = (bAdd && !ArchitectureConstants.Y.equals(addressSave.getIndInvalid()) && isDateNull(
            addressSave
                    .getDateEnd()));

    rowccmn44sig00_array.addROWCCMN44SIG00(rowccmn44sig00);
    /* if a primary address is being added, then end date the current primary addr */
    if ((bAdd && ArchitectureConstants.Y.equals(rowccmn44sig00.getBIndPersAddrLinkPrimary()))
        || (!bAdd && bEndDatePrimary)) {
      ROWCCMN44SIG00 endDatePrimary = endDateCurrentPrimaryAddress(context);
      if (endDatePrimary != null) {
        rowccmn44sig00_array.addROWCCMN44SIG00(endDatePrimary);
      }
    }
    ccmn44si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    ccmn44si.setROWCCMN44SIG00_ARRAY(rowccmn44sig00_array);
    ccmn44si.setUlIdStage(GlobalData.getUlIdStage(request));
    ccmn44si.setSzCdTask(GlobalData.getSzCdTask(request));
    if (bDuplicateCheck && checkForDuplicate(rowccmn44sig00, ccmn42so)) {
      throw new ServiceException(Messages.MSG_DUPLICATE_RECORD);
    }

    int rowCount = rowccmn44sig00_array.getROWCCMN44SIG00Count();
    rowccmn44sig00_array.setUlRowQty(rowCount);
    archinputstruct.setUlPageSizeNbr(rowCount);

    return ccmn44si;
  }

  /**
   * * This method calls a Tuxedo service to save an address (end date a current primary, * in otrder to add a new one)
   *
   * @param context The GrndsExchangeContext object.
   * @return
   */
  public static ROWCCMN44SIG00 endDateCurrentPrimaryAddress(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    BaseSessionStateManager state = getSessionStateManager(context);

    CCMN42SO ccmn42so = (CCMN42SO) state.getAttribute(AddressListConversation.ADDRESS_LIST, request);

    ROWCCMN42SOG00 rowccmn42sog00 = getPrimary(ccmn42so);
    if (rowccmn42sog00 == null) {
      return null;
    }

    ROWCCMN44SIG00 rowccmn44sig00 = createROWCCMN44SIG00(rowccmn42sog00);

    if (rowccmn42sog00.getSzCdPersAddrLinkType().equalsIgnoreCase(MEDICAID_ADDRESS_CODE)) {
      rowccmn44sig00.setBSysIndAddrMedUpdate(ArchitectureConstants.Y);
    } else {
      rowccmn44sig00.setBSysIndAddrMedUpdate(ArchitectureConstants.N);
    }

    rowccmn44sig00.setDtDtPersAddrLinkEnd(DateHelper.getTodayCastorDate());
    rowccmn44sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);

    return rowccmn44sig00;
  }

  protected static ROWCCMN44SIG00 createROWCCMN44SIG00(ROWCCMN42SOG00 rowccmn42sog00) {

    ROWCCMN44SIG00 rowccmn44sig00 = new ROWCCMN44SIG00();

    if (rowccmn42sog00 != null) {
      rowccmn42sog00.setSzTxtPersAddrCmnts(rowccmn42sog00.getSzTxtPersAddrCmnts());
      rowccmn44sig00.setBIndPersAddrLinkInvalid(rowccmn42sog00.getBIndPersAddrLinkInvalid());
      rowccmn44sig00.setBIndPersAddrLinkPrimary(rowccmn42sog00.getBIndPersAddrLinkPrimary());
      rowccmn44sig00.setBIndRemovalHome(rowccmn42sog00.getBIndRemovalHome());
      rowccmn44sig00.setBSysIndAddrMedUpdate(null);
      rowccmn44sig00.setDtDtPersAddrLinkEnd(rowccmn42sog00.getDtDtPersAddrLinkEnd());
      rowccmn44sig00.setDtDtPersAddrLinkStart(rowccmn42sog00.getDtDtPersAddrLinkStart());
      rowccmn44sig00.setLAddrZip(rowccmn42sog00.getLAddrZip());
      rowccmn44sig00.setLNbrPersonAddrHash(rowccmn42sog00.getLNbrPersonAddrHash());
      rowccmn44sig00.setLdIdAddress(rowccmn42sog00.getLdIdAddress());
      rowccmn44sig00.setSzAddrCity(rowccmn42sog00.getSzAddrCity());
      rowccmn44sig00.setSzAddrPersAddrAttn(rowccmn42sog00.getSzAddrPersAddrAttn());
      rowccmn44sig00.setSzTxtPersonEmail(rowccmn42sog00.getSzTxtPersonEmail());
      rowccmn44sig00.setSzAddrPersAddrStLn1(rowccmn42sog00.getSzAddrPersAddrStLn1());
      rowccmn44sig00.setSzAddrPersAddrStLn2(rowccmn42sog00.getSzAddrPersAddrStLn2());
      rowccmn44sig00.setSzCdAddrCounty(rowccmn42sog00.getSzCdAddrCounty());
      rowccmn44sig00.setSzCdAddrState(rowccmn42sog00.getSzCdAddrState());
      rowccmn44sig00.setSzCdPersAddrLinkType(rowccmn42sog00.getSzCdPersAddrLinkType());
      rowccmn44sig00.setSzCdScrDataAction(null);
      rowccmn44sig00.setTsLastUpdate(rowccmn42sog00.getTsLastUpdate());
      rowccmn44sig00.setTsSysTsLastUpdate2(rowccmn42sog00.getTsSysTsLastUpdate2());
      rowccmn44sig00.setUlIdAddrPersonLink(rowccmn42sog00.getUlIdAddrPersonLink());
    }
    return rowccmn44sig00;
  }

  /**
   * This method will gets an AddressValueBean and set the information into state
   *
   * @param context The GrndsExchangeContext object.
   */
  public void populateAddressListPullBack(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateAddressListPullBack");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    AddressValueBean returnBean;
    try {
      AddressValueBean searchBean = new AddressValueBean(GlobalData.getUlIdStage(request),
                                                         GlobalData.getSzCdStage(request));
      // Get a reference to the Address EJB
      returnBean = addressList.getActiveAddressForStage(searchBean);

      // Sir22875 The 'returnBean' is not null but contains the id's set to zero and and other fields null
      // because the method getActiveAddressForStage(searchBean) can not define a null when returned
      if (returnBean.getPersonId() == 0 && returnBean.getStageId() == 0) {
        String SSM_NO_ROWS_RETURNED = MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED);
        setErrorMessage(SSM_NO_ROWS_RETURNED, "/person/AddressDetail/addressDetail", request);
      }

      List vTmp = returnBean.getAddresses();
      state.setAttribute(ADDRESS_LIST_PULLBACK, vTmp, request);

      /*
       * Removed this if that will never be used dued to Sir22875 if (returnBean == null) {
       * ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true); }end remove for sir22875
       */
    } catch (Exception e) {
      processSevereException(context, e);
    }
  }

  /**
   * This method checks for duplicate address
   *
   * @param rowccmn44sig00 the ROWCCMN44SIG00 object
   * @param ccmn42so
   * @return boolean duplicateFlag Output
   */
  protected static boolean checkForDuplicate(ROWCCMN44SIG00 rowccmn44sig00, CCMN42SO ccmn42so) {
    boolean duplicateFlag = false;

    ROWCCMN42SOG00 addressRow;
    int i;
    boolean bComparePrimary;
    boolean bIsNewAddressPrimary = ArchitectureConstants.Y.equals(rowccmn44sig00.getBIndPersAddrLinkPrimary());
    boolean bCompareAddressId;

    ROWCCMN42SOG00_ARRAY rowccmn42sog00_array = ccmn42so.getROWCCMN42SOG00_ARRAY();
    if (rowccmn42sog00_array != null) {
      for (i = 0; i < ccmn42so.getROWCCMN42SOG00_ARRAY().getUlRowQty(); i++) {
        addressRow = ccmn42so.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i);
        if (addressRow.getDtDtPersAddrLinkEnd() == null) {
          boolean bIsOldAddressPrimary = ArchitectureConstants.Y.equals(addressRow.getBIndPersAddrLinkPrimary());
          /*
           * since the existing primary address is going to be end dated, no need to check * the new primary record to
           * existing primary record also no need to compare an address to itself
           */
          // !!! Matthew McClain, 09/15/2003, if this logic changes to
          // not allow both a primary and a non-primary to have the same
          // address, then because the way the code is ordered (setting
          // the id to 0) in populateCCMN44S_AUD, it would
          // not allow you to change an address from a non-primary to a primary
          bComparePrimary = (bIsNewAddressPrimary == bIsOldAddressPrimary);
          bCompareAddressId = (rowccmn44sig00.getLdIdAddress() != addressRow.getLdIdAddress());
          if (bComparePrimary && bCompareAddressId) {
            duplicateFlag = ((addressRow.getSzCdPersAddrLinkType()
                    .equalsIgnoreCase(rowccmn44sig00
                    .getSzCdPersAddrLinkType())) && ((addressRow
                    .getSzAddrPersAddrStLn1()
                    .equalsIgnoreCase(rowccmn44sig00
                    .getSzAddrPersAddrStLn1()))
                                                     && (addressRow
                    .getSzAddrPersAddrStLn2()
                    .equalsIgnoreCase(rowccmn44sig00
                    .getSzAddrPersAddrStLn2()))
                                                     && (addressRow
                    .getSzAddrCity()
                    .equalsIgnoreCase(rowccmn44sig00
                    .getSzAddrCity()))
                                                     && (addressRow
                    .getSzCdAddrState()
                    .equalsIgnoreCase(rowccmn44sig00
                    .getSzCdAddrState())) && (addressRow
                    .getLAddrZip()
                    .equalsIgnoreCase(rowccmn44sig00
                    .getLAddrZip()))));
          }
        }
        if (duplicateFlag) {
          break;
        }
      }
    }
    return duplicateFlag;
  }

  protected static boolean isDateNull(String txtDate) {
    return (txtDate == null || "".equals(txtDate));
  }

  protected static boolean checkForPrimary(CCMN42SO ccmn42so) {
    return (getPrimary(ccmn42so) != null);
  }

  protected static ROWCCMN42SOG00 getPrimary(CCMN42SO ccmn42so) {

    ROWCCMN42SOG00_ARRAY rowccmn42sog00_array = ccmn42so.getROWCCMN42SOG00_ARRAY();

    if (rowccmn42sog00_array != null) {
      for (int i = 0; i < ccmn42so.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00Count(); i++) {
        ROWCCMN42SOG00 addressRow = ccmn42so.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i);
        org.exolab.castor.types.Date addrDate = addressRow.getDtDtPersAddrLinkEnd();
        if ((addrDate == null || DateHelper.MAX_CASTOR_DATE.equals(addrDate))
            && ArchitectureConstants.Y.equalsIgnoreCase(addressRow.getBIndPersAddrLinkPrimary())) {
          return addressRow;
        }
      }
    }
    return null;
  }
  
  // Address can be marked for removal as long as no other address is marked for
  // removal home and the child is in at least one open SUB stage as the
  // primary child.
  protected static boolean checkForMarkRemoval(CCMN42SO ccmn42so, ROWCCMN42SOG00 addressRow) {
    boolean allowRemoval = false;
    ROWCCMN42SOG00 removalRow = getRemovalHome(ccmn42so);
    String inCare = ccmn42so.getBIndCareEntered();
    if (ArchitectureConstants.Y.equals(inCare) && removalRow == null) {
      allowRemoval = true;
    }
    else if (ArchitectureConstants.Y.equals(inCare) && addressRow != null && removalRow.getUlIdAddrPersonLink() == addressRow.getUlIdAddrPersonLink()) {
      allowRemoval = true;
    }
    return allowRemoval;
  }
  
  protected static ROWCCMN42SOG00 getRemovalHome(CCMN42SO ccmn42so) {

    ROWCCMN42SOG00_ARRAY rowccmn42sog00_array = ccmn42so.getROWCCMN42SOG00_ARRAY();

    if (rowccmn42sog00_array != null) {
      for (int i = 0; i < ccmn42so.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00Count(); i++) {
        ROWCCMN42SOG00 addressRow = ccmn42so.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i);
        org.exolab.castor.types.Date addrDate = addressRow.getDtDtPersAddrLinkEnd();
        if ((addrDate == null || DateHelper.MAX_CASTOR_DATE.equals(addrDate))
            && addressRow.getBIndRemovalHome() != null
            && ArchitectureConstants.Y.equalsIgnoreCase(addressRow.getBIndRemovalHome())) {
          return addressRow;
        }
      }
    }
    return null;
  }
}
