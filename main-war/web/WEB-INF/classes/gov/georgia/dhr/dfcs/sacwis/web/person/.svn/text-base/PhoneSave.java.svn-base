package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDB;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN46SOG00;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

/**
 * Encapsulates request to save a phoneDB
 * <p/>
 * Change History: Date      User         Description --------  -----------  ----------------------------------------------
 * 09/12/03  CASDORJM     SIR 19772 - Added in logic such that the phone submodule will allow a user to save a duplicate
 * phone number as long as one is primary and the other is not a primary. 09/26/03  CORLEYAN     SIR 19797 If we are
 * marking an old row as primary, make sure the old comments are not overwritten. 07/01/05 PINKSTBA      SIR 23727 MPS
 * Phase II.  Replaced WtcException/WtxHelper references with ServiceException/ServiceHelper references.
 */
public class PhoneSave implements Serializable {
  protected static final String TRACE_TAG = "PhoneSave";
  protected static final String TRUE = "Y";
  protected static final String FALSE = "N";
  //input
  protected String taskCode = null;
  protected int personId = 0;
  protected int stageId = 0;
  protected PhoneDB phoneDB = null;
  //state variables
  protected ROWCCMN46SOG00[] oldRows = null;
  protected boolean newRowIsActive = false;
  //output
  protected int errorCode = 0;
  protected String errorMessage = null;

  /**
   * Calls CCMN46S and checks against the current list of rows for several Error cases: MSG_CMN_NO_PRIMARY_ROW
   * MSG_NO_DUP_LB_ROW MSG_SYS_EVENT_STS_MSMTCH Calls CCMN31S to update or add a row and may result in this:
   * MSG_SYS_MULT_INST MSG_SYS_STAGE_CLOSED
   */
  public void execute(Person person) throws MarshalException, ValidationException, ParseException {
    CCMN46SO ccmn46so = PhoneConversation.callCCMN46S(personId, person);
    this.oldRows = ccmn46so.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00();

    this.newRowIsActive = ((phoneDB.getInvalid() == false) &&
                           (phoneDB.getEndDate() == null));

    if (hasErrors()) {
      return;
    }

    CCMN31SI ccmn31si = createCCMN31SI();
    try {
      person.savePhoneListDetail(ccmn31si);
    } catch (ServiceException e) {
      //assuming SQL_NOT_FOUND is MSG_SYS_EVENT_STS_MSMTCH
      // this is what the old window code did
      int errorCode = e.getErrorCode();
      if (errorCode == Messages.SQL_NOT_FOUND) {
        errorCode = Messages.MSG_SYS_EVENT_STS_MSMTCH;
      }
      switch (errorCode) {
        case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        case Messages.MSG_NO_DUP_LB_ROW:
        case Messages.MSG_SYS_STAGE_CLOSED:
        case Messages.MSG_SYS_MULT_INST:
          setError(errorCode);
          return;
      }
      throw e;
    }
  }

  /**
   * Checks whether an active primary phone number exists Checks whether new row is a duplicate of an active existing
   * row Checks whether new row was created from stale data
   */
  public boolean hasErrors() {
    if (newRowIsActive && doesPrimaryPhoneExist() == false) {
      int errorCode = Messages.MSG_CMN_NO_PRIMARY_ROW;

      setError(errorCode);

      this.errorMessage = MessageLookup.getMessageByNumber(errorCode);

      this.errorMessage = MessageLookup.addMessageParameter(errorMessage, "phone number");
      return true;
    }

    if ((newRowIsActive) &&
        (isNewRowDuplicate())) {
      setError(Messages.MSG_NO_DUP_LB_ROW);
      return true;
    }

    if ((phoneDB.getPhoneId() != 0) &&
        (isPhoneDataOutdated())) {
      setError(Messages.MSG_SYS_EVENT_STS_MSMTCH);
      return true;
    }
    return false;
  }

  /** Checks to see if a primary phone number exists for this person */
  protected boolean doesPrimaryPhoneExist() {
    if (phoneDB.getPrimary()) {
      return true;
    }
//    boolean hasPrimary = false;
    for (int i = 0; i < oldRows.length; i++) {
      org.exolab.castor.types.Date endDate = oldRows[i].getDtDtPersonPhoneEnd();
      if ((oldRows[i].getBIndPersonPhonePrimary().equals(TRUE)) &&
          (endDate == null || DateHelper.MAX_CASTOR_DATE.equals(endDate))) {
        return true;
      }
    }
    return false;
  }

  /** Checks to see if new row matches another active row in phoneType, number, and extension columns */
  protected boolean isNewRowDuplicate() {
    boolean isNewRowPrimary = phoneDB.getPrimary();
    for (int i = 0; i < oldRows.length; i++) {
      org.exolab.castor.types.Date cDate = oldRows[i].getDtDtPersonPhoneEnd();
      boolean isOldRowPrimary = "Y".equals(oldRows[i].getBIndPersonPhonePrimary());
      boolean isActive = ((oldRows[i].getBIndPersonPhoneInvalid().equals(FALSE)) &&
                          (cDate == null || DateHelper.MAX_CASTOR_DATE.equals(cDate)));

      if ((isActive) &&
          (isOldRowPrimary == isNewRowPrimary) &&
          (oldRows[i].getSzCdPhoneType().equals(phoneDB.getPhoneType())) &&
          (oldRows[i].getLNbrPhone().equals(phoneDB.getNumber())) &&
          (oldRows[i].getLNbrPhoneExtension().equals(phoneDB.getExtension())) &&
          (oldRows[i].getUlIdPhone() != phoneDB.getPhoneId())) {
        return true;
      }
    }
    return false;
  }

  /** performs an explicit check on tsLastUpdate */
  protected boolean isPhoneDataOutdated() {
    for (int i = 0; i < oldRows.length; i++) {
      if (oldRows[i].getUlIdPhone() != phoneDB.getPhoneId()) {
        continue;
      }
      if (oldRows[i].getTsLastUpdate().getTime() != phoneDB.getLastUpdateTime()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Check to see if the primary flag changed. Create a row for phone passed in If primary flag changed, end-date the
   * current phone and create a duplicate row which has a new start date and is primary If the phone constitutes a new
   * primary phone number for the person, end date all old primary phone numbers (there should only be one) Create an
   * array of these rows and initialize CCMN31SI
   */
  protected CCMN31SI createCCMN31SI()
          throws ParseException {
    boolean primaryChanged = false;
    boolean newPrimary = ((newRowIsActive) &&
                          (phoneDB.getPhoneId() == 0) &&
                          (phoneDB.getPrimary()));
    String oldComments = "";

    //check if primary changed
    if (phoneDB.getPhoneId() != 0) {
      for (int i = 0; i < oldRows.length; i++) {
        if (oldRows[i].getUlIdPhone() != phoneDB.getPhoneId()) {
          continue;
        }
        if (oldRows[i].getBIndPersonPhonePrimary().equals(FALSE) &&
            phoneDB.getPrimary()) {
          oldComments = oldRows[i].getSzTxtPhoneComments();
          primaryChanged = true;
          newPrimary = true;
        }
      }
    }

    ROWCCMN31SI row = createROWCCMN31SI(phoneDB);
    List<ROWCCMN31SI> rows = new ArrayList<ROWCCMN31SI>();
    rows.add(row);

    //if primary changes from unchecked to checked
    //    the old row gets an end date
    //    a new row is created and primary is set
    //    the new row has a new start date to indicate the time period,
    //    it's primary
    if (primaryChanged) {
      row.setBIndPersonPhonePrimary(FALSE);
      row.setDtDtPersonPhoneEnd(DateHelper.toCastorDate(new Date()));
      // SIR 19797 if we are endating the old row, maintain the comments
      // from the old row.
      row.setSzTxtPhoneComments(oldComments);

      ROWCCMN31SI row2 = createROWCCMN31SI(phoneDB);
      row2.setDtDtPersonPhoneStart(DateHelper.toCastorDate(new Date()));
      row2.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      row2.setTsLastUpdate(null);
      row2.setUlIdPhone(0);

      rows.add(row2);
    }
    if (newPrimary) {
      for (int i = 0; i < oldRows.length; i++) {
        org.exolab.castor.types.Date endDate = oldRows[i].getDtDtPersonPhoneEnd();
        if (oldRows[i].getBIndPersonPhonePrimary().equals(TRUE) &&
            (endDate == null || DateHelper.MAX_CASTOR_DATE.equals(endDate))) {
          oldRows[i].setDtDtPersonPhoneEnd(DateHelper.toCastorDate(new Date()));
          ROWCCMN31SI convertedRow = convertRow(oldRows[i]);
          rows.add(convertedRow);
        }
      }
    }

    ROWCCMN31SI[] array = rows.toArray(new ROWCCMN31SI[rows.size()]);

    ROWCCMN31SI_ARRAY arrayObject = new ROWCCMN31SI_ARRAY();
    arrayObject.setROWCCMN31SI(array);
    arrayObject.setUlRowQty(array.length);

    CCMN31SI ccmn31si = new CCMN31SI();
    ccmn31si.setArchInputStruct(new ArchInputStruct());
    ccmn31si.setROWCCMN31SI_ARRAY(arrayObject);
    ccmn31si.setSzCdTask(taskCode);
    ccmn31si.setUlIdPerson(personId);
    ccmn31si.setUlIdStage(stageId);
    ccmn31si.setUsSysNbrNumberOfRows(array.length);

    return ccmn31si;
  }

  /** Creates a ROWCCMN31SI from a PhoneDB; to save/add the values */
  protected static ROWCCMN31SI createROWCCMN31SI(PhoneDB phoneDB)
          throws ParseException {
    ROWCCMN31SI row = new ROWCCMN31SI();
    row.setBIndPersonPhoneInvalid(phoneDB.getInvalid() ? TRUE : FALSE);
    row.setBIndPersonPhonePrimary(phoneDB.getPrimary() ? TRUE : FALSE);
    row.setDtDtPersonPhoneEnd(DateHelper.toCastorDate(phoneDB.getEndDate()));
    row.setDtDtPersonPhoneStart(DateHelper.toCastorDate(phoneDB.getStartDate()));
    row.setLNbrPhone(phoneDB.getNumber());
    row.setLNbrPhoneExtension(phoneDB.getExtension());
    row.setSzCdPhoneType(phoneDB.getPhoneType());

    row.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    if (phoneDB.getPhoneId() != 0) {
      row.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    row.setSzTxtPhoneComments(phoneDB.getComments());
    row.setTsLastUpdate(phoneDB.getLastUpdate());
    row.setUlIdPhone(phoneDB.getPhoneId());

    return row;
  }

  /** Converts a ROWCCMN46SOG00 to ROWCCMN31SI to make it easy to end-date the old primary */
  protected static ROWCCMN31SI convertRow(ROWCCMN46SOG00 oldRow) {
    ROWCCMN31SI row = new ROWCCMN31SI();
    row.setBIndPersonPhoneInvalid(oldRow.getBIndPersonPhoneInvalid());
    row.setBIndPersonPhonePrimary(oldRow.getBIndPersonPhonePrimary());
    row.setDtDtPersonPhoneEnd(oldRow.getDtDtPersonPhoneEnd());
    row.setDtDtPersonPhoneStart(oldRow.getDtDtPersonPhoneStart());
    row.setLNbrPhone(oldRow.getLNbrPhone());
    row.setLNbrPhoneExtension(oldRow.getLNbrPhoneExtension());
    row.setSzCdPhoneType(oldRow.getSzCdPhoneType());
    row.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    row.setSzTxtPhoneComments(oldRow.getSzTxtPhoneComments());
    row.setTsLastUpdate(oldRow.getTsLastUpdate());
    row.setUlIdPhone(oldRow.getUlIdPhone());

    return row;
  }

  protected void setError(int errorCode) {
    this.errorCode = errorCode;
    this.errorMessage = MessageLookup.getMessageByNumber(errorCode);
  }

  public int getError() {
    return errorCode;
  }

  public void setTaskCode(String taskCode) {
    this.taskCode = taskCode;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  public void setPhoneDB(PhoneDB phoneDB) {
    this.phoneDB = phoneDB;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
