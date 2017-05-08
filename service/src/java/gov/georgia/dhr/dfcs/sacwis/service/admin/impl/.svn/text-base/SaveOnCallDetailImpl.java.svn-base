package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

/*** Change History:
  **  Date        User              Description
  **  --------    ----------------  -------------------------------------------------------------------------------------------
  **  07/08/2008  charden           STGAP00007499 - Created new compareTo ( ) method in SaceOnCallDetailImpl to call to compare the the timestamps.
  *                                 Compared the dates first, then called created compareTo ( ) method to compare time
  **/


import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexOnCallCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexOnCallDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicOnCallDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpOnCallLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OnCallDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpOnCallLink;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.OnCall;
import gov.georgia.dhr.dfcs.sacwis.db.OnCallCounty;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveOnCallDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN20DO;

import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class SaveOnCallDetailImpl extends BaseServiceImpl implements SaveOnCallDetail {

  private final String WINDOW_MODE_NEW_USING = "2";
  private final String EMP_ON_CALL_LINK = "EMP_ON_CALL_LINK";

  private ComplexOnCallDAO complexOnCallDAO = null;
  private ComplexOnCallCountyDAO complexOnCallCountyDAO = null;
  private DynamicOnCallDAO dynamicOnCallDAO = null;
  private EmpOnCallLinkDAO empOnCallLinkDAO = null;
  private OnCallDAO onCallDAO = null;
  private TodoDAO todoDAO = null;

  public void setComplexOnCallDAO(ComplexOnCallDAO complexOnCallDAO) {
    this.complexOnCallDAO = complexOnCallDAO;
  }

  public void setComplexOnCallCountyDAO(ComplexOnCallCountyDAO complexOnCallCountyDAO) {
    this.complexOnCallCountyDAO = complexOnCallCountyDAO;
  }

  public void setDynamicOnCallDAO(DynamicOnCallDAO dynamicOnCallDAO) {
    this.dynamicOnCallDAO = dynamicOnCallDAO;
  }

  public void setEmpOnCallLinkDAO(EmpOnCallLinkDAO empOnCallLinkDAO) {
    this.empOnCallLinkDAO = empOnCallLinkDAO;
  }

  public void setOnCallDAO(OnCallDAO onCallDAO) {
    this.onCallDAO = onCallDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public CCMN10SO saveOnCallDetailInformation(CCMN10SI ccmn10si) throws ServiceException {
    CCMN10SO ccmn10so = new CCMN10SO();
    ArchOutputStruct aos = new ArchOutputStruct();
    String cReqFuncCd = ccmn10si.getArchInputStruct().getCReqFuncCd();
    // if (ccmn10si.getSzSysCdWinMode() == WINDOW_MODE_NEW_USING) {
    //if (WINDOW_MODE_NEW_USING.equals(ccmn10si.getSzSysCdWinMode())) {
      //      the CCMN16D Dam is called
      //      then over-lap checking is done
      //      if there is no over-lap then
      //          the ADD section of the CCMN20D Dam is called
      //              then the ADD section of the CCMN43D Dam is called.
      //                 then the ADD section of the CCMN22D Dam is called.
      //
      //
      // Initialize pInputMsg->ArchInputStruct.bDataAcsInd to TRUE:
      // this flag will be used to determine if an overlap exists.
      // no overlap exists: pInputMsg->ArchInputStruct.bDataAcsInd == TRUE
      // an overlap exists: pInputMsg->ArchInputStruct.bDataAcsInd == FALSE
      // If an overlap exists, the proposed shift/block should NOT be added.
    if(!"4".equals(ccmn10si.getSzSysCdWinMode())){
      if(proposedScheduleOverlaps(ccmn10si.getROWCCMN20DI())){
          throw new ServiceException(Messages.MSG_CMN_OVERLAP_ADD);
      }
    }
      
      //if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
        if (WINDOW_MODE_NEW_USING.equals(ccmn10si.getSzSysCdWinMode())) {
        // CCMN20D, CCMN43D and CCMN22D only need to be called if no_overlap exists 
        // (as determined in the CallCCMN16D function) . The CallCCMN20D Function will call 
        // all three dams: ccmn20d, ccmn43d, and ccmn22d
        // ComplexOnCallDAO (CCMN20D) (on_call AUD: only using ADD section)
        //  TodoDAO (CCMN43D)  (to-do alert AUD: only using ADD section)
        // EmpOnCallLinkDAO (CCMN22D) (emp_on_call_link AUD: only using ADD section)
        // Calling DAO CCMN20D
        ROWCCMN20DI rowccmn20di = ccmn10si.getROWCCMN20DI();
        OnCall onCall = null;
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
          onCall = onCallDAO.insertOnCall(rowccmn20di.getSzCdOnCallProgram(), rowccmn20di.getSzCdOnCallType(),
                                          rowccmn20di.getSzCdRegion(), rowccmn20di.getSzCdOnCallCounty(),
                                          DateHelper.toJavaDateSafe(rowccmn20di.getDtDtOnCallStart(),
                                                                    rowccmn20di.getTmOnCallStart()),
                                          DateHelper.toJavaDateSafe(rowccmn20di.getDtDtOnCallEnd(),
                                                                    rowccmn20di.getTmOnCallEnd()),
                                          rowccmn20di.getBIndOnCallFilled());

          if (onCall == null) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
        }
        //The following DAOs, TodoDAO and EmpOnCallLinkDAO will be called only if the above insert is through
        // The idOnCall from onCall will be used while calling EmpOnCallLinkDAO later
        int idOnCall = onCall.getIdOnCall();
        ROWCCMN20DO rowccmn20do = new ROWCCMN20DO();
        ccmn10so.setROWCCMN20DO(rowccmn20do);
        ccmn10so.getROWCCMN20DO().setUlIdOnCall(idOnCall);
        ccmn10so.getROWCCMN20DO().setTsLastUpdate(onCall.getDtLastUpdate());
        // Tod object to be populated to be passed in as param
        // Preparing to Call TodoDAO for ADD,  CCMN43D
        Date today = new Date();
        Todo todo = new Todo();
        todo.setCdTodoType(CodesTables.CTODOTYP_A);
        todo.setDtTodoCreated(today);
        todo.setDtTodoCompleted(today);
        todo.setDtTodoDue(today);
        todo.setDtTodoTaskDue(null);
        ROWCCMN22DI_ARRAY rowccmn22di_array = ccmn10si.getROWCCMN22DI_ARRAY();
        for (Enumeration rowccmn22diEnum = rowccmn22di_array.enumerateROWCCMN22DI(); rowccmn22diEnum.hasMoreElements();)
        {
          ROWCCMN22DI rowccmn22di = (ROWCCMN22DI) rowccmn22diEnum.nextElement();
          String cdEmpOnCallDesig = rowccmn22di.getSzCdEmpOnCallDesig();
          String nbrEmpOnCallPhone1 = rowccmn22di.getSzNbrEmpOnCallPhone1();
          String nbrEmpOnCallExt1 = rowccmn22di.getLNbrEmpOnCallExt1();
          String szCdTitle = rowccmn22di.getSzCdTitle();
          String szCdOnCallProgram = rowccmn22di.getSzCdOnCallProgram();
          Person persAssigned = (Person) getPersistentObject(Person.class, rowccmn22di.getUlIdPerson());
          todo.setPersonByIdTodoPersAssigned(persAssigned);
          String txtTodoDesc = "On-Call Addition.";
          String txtTodoLongDesc = "You have been added to the following On-Call";
          if (CodesTables.CONCLTYP_BL.equals(rowccmn20di.getSzCdOnCallType())) {
            txtTodoLongDesc += " Block:";
          } else {
            txtTodoLongDesc += " Shift:";
          }
          String dtOnCallStartStr = FormattingHelper.formatDate(rowccmn20di.getDtDtOnCallStart());
          String dtOnCallEndStr = FormattingHelper.formatDate(rowccmn20di.getDtDtOnCallEnd());
          String tmOnCallStartStr = rowccmn20di.getTmOnCallStart();
          String tmOnCallEndStr = rowccmn20di.getTmOnCallEnd();
          txtTodoLongDesc += "   Region: " + rowccmn20di.getSzCdRegion() + "   County: "
                             + rowccmn20di.getSzCdOnCallMultOrAll() + "   Program: "
                             + rowccmn20di.getSzCdOnCallProgram() + "   Start Date: " + dtOnCallStartStr
                             + "   Start Time: " + tmOnCallStartStr + "   End Date: " + dtOnCallEndStr
                             + "   End Time: " + tmOnCallEndStr;
          txtTodoDesc += dtOnCallStartStr + "  " + tmOnCallStartStr + " THRU " + dtOnCallEndStr + "  " + tmOnCallEndStr;
          int ord = rowccmn22di.getUsNbrEmpOnCallCntctOrd();
          txtTodoLongDesc += "   Contact Order: " + ord + "   On-Call Designation: " + cdEmpOnCallDesig;
          txtTodoLongDesc += "   On-Call Phone: " + nbrEmpOnCallPhone1 + "   Ext: " + nbrEmpOnCallExt1;
          todo.setTxtTodoLongDesc(txtTodoLongDesc);
          todo.setTxtTodoDesc(txtTodoDesc);
          // First, add the to-do (alert); then  ADD by calling EmpOnCallDAO ccmn22d: 
          // (cReqFuncCd, IdOnCall, IdPerson, Desig, Phone1, Ext1, Phone2, Ext2, Contact Order)
          // Calling DAO CCMN43D
          if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
            todoDAO.saveTodo(todo);
          }
          // Preparing to call EmpOnCallLinkDAO, CCMN22D, only if the above save operation is through

          EmpOnCallLink empOnCallLink = new EmpOnCallLink();
          OnCall onCall_forEmpOnCallLink = (OnCall) getPersistentObject(OnCall.class, idOnCall);
          Person person = (Person) getPersistentObject(Person.class, rowccmn22di.getUlIdPerson());
          empOnCallLink.setOnCall(onCall_forEmpOnCallLink);
          empOnCallLink.setPerson(person);
          Employee employee = (Employee) getPersistentObject(Employee.class, rowccmn22di.getUlIdPerson());
          empOnCallLink.setEmployee(employee);
          empOnCallLink.setCdEmpOnCallDesig(cdEmpOnCallDesig);
          empOnCallLink.setNbrEmpOnCallPhone1(nbrEmpOnCallPhone1);
          empOnCallLink.setNbrEmpOnCallExt1(nbrEmpOnCallExt1);
          empOnCallLink.setNbrEmpOnCallPhone2(rowccmn22di.getSzNbrEmpOnCallPhone2());
          empOnCallLink.setNbrEmpOnCallExt2(rowccmn22di.getLNbrEmpOnCallExt2());
          empOnCallLink.setCdTitle(rowccmn22di.getSzCdTitle());
          empOnCallLink.setCdPrgmCvrg(rowccmn22di.getSzCdOnCallProgram());
          empOnCallLink.setNbrEmpOnCallCntctOrd(rowccmn22di.getUsNbrEmpOnCallCntctOrd());
          // Calling EmpOnCallLinkDAO, CCMN22D
          if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
            empOnCallLinkDAO.saveEmpOnCallLink(empOnCallLink);
          }
        }
        // Calling OnCallCountyDAO, CCMNH8D if the above 'save' opeartion is through      
        // Preparing for the DAO call. Following are parameters for onCallCountyDAO
        String cdRegion = rowccmn20di.getSzCdRegion();
        String cdCounty = rowccmn20di.getSzCdOnCallCounty();

        OnCallCounty onCallCounty = new OnCallCounty();
        OnCall onCall_forCounty = (OnCall) getPersistentObject(OnCall.class, idOnCall);
        onCallCounty.setCdOnCallRegion(rowccmn20di.getSzCdRegion());
        // onCallCounty.setCdOnCallCounty(cdOnCallCounty);
        //onCallCounty.setDtLastUpdate(dtLastUpdate);
        onCallCounty.setOnCall(onCall_forCounty);
        SzCdOnCallCounty_ARRAY szCdOnCallCounty_array = rowccmn20di.getSzCdOnCallCounty_ARRAY();
        //String[] cdOnCallCounty = new String[szCdOnCallCounty_array.getSzCdOnCallCountyCount()];
        String[] cdOnCallCounty = new String[1];
        // if (CodesTables.CREGIONS_98.equals(cdRegion)) {
        //  cdOnCallCounty[0] = ALLCOUNTIES;
        //} else {
        // int index = 0;
        // for (Enumeration szCdOnCallCountyEnum = szCdOnCallCounty_array.enumerateSzCdOnCallCounty();
        //      szCdOnCallCountyEnum
        //              .hasMoreElements(); index++) {
        //   cdOnCallCounty[index] = (String) szCdOnCallCountyEnum.nextElement();
        //}
        //  }
        cdOnCallCounty[0] = cdCounty;

        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
          complexOnCallCountyDAO.saveOnCallCounty(onCallCounty, cdOnCallCounty);
        }
        // The mext DAO is called if the above 'save' operation is through
      //} // no_overlap == TRUE 
      //-- else represents that overlap does exist
      //else { // pInputMsg->ArchInputStruct.bDataAcsInd == FALSE 
        // Need to display a message to the user that states an overlap would be created 
        // if the proposed shift/block were added; therefore, it has NOT been added.
        // pServiceStatus.severity = FND_SEVERITY_ERROR;
        // pServiceStatus.explan_code = Messages.MSG_CMN_OVERLAP_ADD;
        // rc = Messages.MSG_CMN_OVERLAP_ADD;        
      //} // end else no_overlap == FALSE 
    } // end if pInputMsg->szSysCdWinMode == WINDOW_MODE_NEW_USING
    else {
      // We need to Add, Update, or Delete rows in the EMP_ON_CALL_LINK table.
      // We will be able to tell if the action for a particular row is
      // Add, Update, or Delete based on the szCdScrDataAction field.
      //
      // if (szCdScrDataAction == REQ_FUNC_CD_ADD)
      //   the CCMN43D Dam is called to ADD a to-do alert for the employee.
      //   the CCMN22D Dam is called to ADD the employee to the shift/block;
      // else
      // if (szCdScrDataAction == REQ_FUNC_CD_UPDATE)
      //   the CCMN43D Dam is called to ADD a to-do alert for the employee.
      //   the CCMN22D Dam is called to UPDATE the employee to the shift/block;
      // else
      // if (szCdScrDataAction == REQ_FUNC_CD_DELETE)
      //   the CCMN43D Dam is called to ADD a to-do alert for the employee.
      //   the CCMN22D Dam is called to DELETE the employee to the shift/block;
      //
      // Calling EmpOnCallLinkDAO, TodoDAO and ComplexOnCallDAO (CCMN43D, CCMN22D, CCMN20D)
      // Preparing to call EmpOnCallLinkDAO, CCMN22D, only if the above save operation is through
      ROWCCMN20DI rowccmn20di = ccmn10si.getROWCCMN20DI();
      Todo todo = new Todo();
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setDtTodoCreated(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
      todo.setDtTodoCompleted(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
      todo.setDtTodoDue(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));

      ROWCCMN22DI_ARRAY rowccmn22di_array = ccmn10si.getROWCCMN22DI_ARRAY();
      for (Enumeration rowccmn22diEnum = rowccmn22di_array.enumerateROWCCMN22DI(); rowccmn22diEnum.hasMoreElements();) {
        ROWCCMN22DI rowccmn22di = (ROWCCMN22DI) rowccmn22diEnum.nextElement();
        String cdScrDataAction = rowccmn22di.getSzCdScrDataAction();
        String txtTodoDesc = "";
        String txtTodoLongDesc = "";

        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)) {
          // call TodoDAO to ADD a to-do alert for the employee.
          // call EmpOnCallLinkDAO to Add/Update/Delete the employee to the shift/block;
          txtTodoLongDesc = "You have been added to the following On-Call";
          txtTodoDesc = "On-Call Addition.";
        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
          // call CCMN43D Dam to ADD a to-do alert for the employee.
          // call CCMN22D Dam to UPDATE the employee to the shift/block;
          txtTodoLongDesc = "You have been modified in the following On-Call";
          txtTodoDesc = "On-Call Modification.";
        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {
          // call CCMN43D Dam to ADD a to-do alert for the employee.
          // call CCMN22D Dam to DELETE the employee to the shift/block;
          txtTodoLongDesc = "You have been deleted from the following On-Call";
          txtTodoDesc = "On-Call Deletion.";
        }
        Person persAssigned = (Person) getPersistentObject(Person.class, rowccmn22di.getUlIdPerson());
        todo.setPersonByIdTodoPersAssigned(persAssigned);
        if (CodesTables.CONCLTYP_BL.equals(rowccmn20di.getSzCdOnCallType())) {
          txtTodoLongDesc += " Block:";
        } else {
          txtTodoLongDesc += " Shift:";
        }
        String dtOnCallStartStr = FormattingHelper.formatDate(rowccmn20di.getDtDtOnCallStart());
        String dtOnCallEndStr = FormattingHelper.formatDate(rowccmn20di.getDtDtOnCallEnd());
        String tmOnCallStartStr = rowccmn20di.getTmOnCallStart();
        String tmOnCallEndStr = rowccmn20di.getTmOnCallEnd();
        txtTodoLongDesc += "   Region: " + rowccmn20di.getSzCdRegion() + "   County: "
                           + rowccmn20di.getSzCdOnCallMultOrAll() + "   Program: " + rowccmn20di.getSzCdOnCallProgram()
                           + "   Start Date: " + dtOnCallStartStr + "   Start Time: " + tmOnCallStartStr
                           + "   End Date: " + dtOnCallEndStr + "   End Time: " + tmOnCallEndStr;
        txtTodoDesc += dtOnCallStartStr + "  " + tmOnCallStartStr + " THRU " + dtOnCallEndStr + "  " + tmOnCallEndStr;
        int ord = rowccmn22di.getUsNbrEmpOnCallCntctOrd();
        String cdEmpOnCallDesig = rowccmn22di.getSzCdEmpOnCallDesig();
        String nbrEmpOnCallPhone1 = rowccmn22di.getSzNbrEmpOnCallPhone1();
        String nbrEmpOnCallExt1 = rowccmn22di.getLNbrEmpOnCallExt1();
        txtTodoLongDesc += "   Contact Order: " + ord + "   On-Call Designation: " + cdEmpOnCallDesig;
        txtTodoLongDesc += "   On-Call Phone: " + nbrEmpOnCallPhone1 + "   Ext: " + nbrEmpOnCallExt1;
        todo.setTxtTodoLongDesc(txtTodoLongDesc);
        todo.setTxtTodoDesc(txtTodoDesc);
        // Preparing to call EmpOnCallLinkDAO, CCMN22D, if the above save operation is through
        EmpOnCallLink empOnCallLink = new EmpOnCallLink();
        OnCall onCall = (OnCall) getPersistentObject(OnCall.class, rowccmn20di.getUlIdOnCall());
        Person person = (Person) getPersistentObject(Person.class, rowccmn22di.getUlIdPerson());
        Employee employee = (Employee) getPersistentObject(Employee.class, rowccmn22di.getUlIdPerson());
        empOnCallLink.setEmployee(employee);
        empOnCallLink.setOnCall(onCall);
        empOnCallLink.setPerson(person);
        empOnCallLink.setCdEmpOnCallDesig(cdEmpOnCallDesig);
        empOnCallLink.setNbrEmpOnCallPhone1(nbrEmpOnCallPhone1);
        empOnCallLink.setNbrEmpOnCallExt1(nbrEmpOnCallExt1);
        empOnCallLink.setNbrEmpOnCallPhone2(rowccmn22di.getSzNbrEmpOnCallPhone2());
        empOnCallLink.setNbrEmpOnCallExt2(rowccmn22di.getLNbrEmpOnCallExt2());
        empOnCallLink.setNbrEmpOnCallCntctOrd(rowccmn22di.getUsNbrEmpOnCallCntctOrd());
        empOnCallLink.setIdEmpOnCallLink(rowccmn22di.getUlIdEmpOnCallLink());
        empOnCallLink.setDtLastUpdate(rowccmn22di.getTsLastUpdate());
        empOnCallLink.setCdTitle(rowccmn22di.getSzCdTitle());
        empOnCallLink.setCdPrgmCvrg(rowccmn22di.getSzCdOnCallProgram());

        // First, add the to-do (alert); then  ADD by calling EmpOnCallDAO ccmn22d: 
        // Calling TodoDAO CCMN43D, EmpOnCallLinkDAO, CCMN22D
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)) {
          todoDAO.saveTodo(todo);
          empOnCallLinkDAO.saveEmpOnCallLink(empOnCallLink);
        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
          todoDAO.saveTodo(todo);
          empOnCallLinkDAO.saveEmpOnCallLink(empOnCallLink);
        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {
          todoDAO.saveTodo(todo);
          empOnCallLinkDAO.deleteEmpOnCallLinkByIdEmpOnCallLink(rowccmn22di.getUlIdEmpOnCallLink());
        }
      }// end of for loop
      // if we get to this point,
      // then all the AUDs for the EMP_ON_CALL_LINK table
      // were successful -- now need to change
      // IND_ON_CALL_FILLED in the ON_CALL table to 'Y' (from 'N').
      //
      // Since this call (ccmn20d) is only used to change IND_ON_CALL_FILLED
      // from 'N' to 'Y', it does not need to be audited (via LOG_AUDIT_RECORD),
      // so the entire InputMsg Architecture Header data is not copied into
      // pCCMN20DInputRec->ArchInputStruct.
      if (ServiceConstants.REQ_FUNC_CD_LIST.equals(ccmn10si.getArchInputStruct().getCReqFuncCd())) {
        // Calling OnCallDAO   CCMN20D 
        // For 'Add' operation 'indOnCallFilled' field value is passed in as 'Y'
        Date lastUpdate = complexOnCallDAO.updateOnCallByIdOnCallDtLastUpdate(ArchitectureConstants.Y,
                                                                              rowccmn20di.getUlIdOnCall(),
                                                                              rowccmn20di.getTsLastUpdate());
        ccmn10so.getROWCCMN20DO().setTsLastUpdate(lastUpdate);
      }
    } //-- end else (window mode is not NEW_USING)
    //} //-- end if no overlap
    ccmn10so.setArchOutputStruct(aos);
    return ccmn10so;
  }
  
  private boolean proposedScheduleOverlaps(ROWCCMN20DI rowccmn20di){
    boolean overlap = false;
    
    //int newIdOnCall = rowccmn20di.getUlIdOnCall();
    Date newStartDateAndTime = DateHelper.toJavaDateSafe(rowccmn20di.getDtDtOnCallStart().toDate(), rowccmn20di.getTmOnCallStart());
    Date newEndDateAndTime = DateHelper.toJavaDateSafe(rowccmn20di.getDtDtOnCallEnd().toDate(), rowccmn20di.getTmOnCallEnd());
    
    //STGAP00007499 - made strings newStartTime and newEndTime to be used in compareTo() method
    String newStartTime = StringHelper.getNonNullString(rowccmn20di.getTmOnCallStart());
    String newEndTime = StringHelper.getNonNullString(rowccmn20di.getTmOnCallEnd());
    
    
    String[] countyAsArray = rowccmn20di.getSzCdOnCallCounty_ARRAY().getSzCdOnCallCounty();
    String program = rowccmn20di.getSzCdOnCallProgram();
    int fakePageNbr = 1;
    int fakePageSize = 350;
    PaginatedHibernateList<Object[]> schedules;
    do{
      schedules = dynamicOnCallDAO.findOnCall(countyAsArray, program, null, null, null, fakePageNbr, fakePageSize);
      if(schedules != null && schedules.size() > 0){
        //-- indexes of each schedule: 0=region, 1=program, 2=type, 3=startDate, 4=endDate, 5=idOnCall, 6=filled,
        //--                           7=dtLastUpdate, 8=countOfCounties
        Object[] firstSchedule = schedules.get(0);
        Object[] lastSchedule = schedules.get(schedules.size()-1);
        Date fsStartDate = (Date) firstSchedule[3];
        Date lsEndDate = (Date) lastSchedule[4];
        
        //-- if we do not format the dates, the compareTo method does not work
        String fsStartDateString = DateHelper.DATE_TIME_FORMAT.format(fsStartDate);
        String lsEndDateString = DateHelper.DATE_TIME_FORMAT.format(lsEndDate);
        try{
          fsStartDate = DateHelper.DATE_TIME_FORMAT.parse(fsStartDateString);
          lsEndDate = DateHelper.DATE_TIME_FORMAT.parse(lsEndDateString);
        } catch(ParseException pe){
          //-- do anything?
        }
        
        //-- if the proposed schedule falls somewhere b/w the existing schedules, check against each one
        //-- if firstSchedule's startDate < newEndDateAndTime AND newStartDateAndTime < lastSchedule's endDate
        if(fsStartDate.compareTo(newEndDateAndTime) < 0 && newStartDateAndTime.compareTo(lsEndDate) < 0){
          //-- iterate thru each schedule and check overlap
          Iterator<Object[]> its = schedules.iterator();
          while(its.hasNext()){
            Object[] schedule = its.next();
            //Integer id = (Integer) schedule[5];
            
            //if(id.intValue() !=  newIdOnCall){
              Date existingStartDate = (Date) schedule[3];
              Date existingEndDate = (Date) schedule[4];
              
              
              
              //-- again, format dates so compareTo works
              String startDateString = DateHelper.DATE_TIME_FORMAT.format(existingStartDate);
              String endDateString = DateHelper.DATE_TIME_FORMAT.format(existingEndDate);
              try{
                existingStartDate = DateHelper.DATE_TIME_FORMAT.parse(startDateString);
                existingEndDate = DateHelper.DATE_TIME_FORMAT.parse(endDateString);
              } catch(ParseException pe){
                //-- do anything?
              }
              
              //-- 4 ways to overlap:
              //-- (1) NS < OS < OE < NE  | [_] |
              //-- (2) NS < OS < NE < OE  | [_|_]
              //-- (3) OS < NS < NE < OE  [_|_|_]
              //-- (4) OS < NS < OE < NE  [_|_] |
              //-- NS=newStart, NE=newEnd, OS=oldStart, OE=oldEnd
              
              //-- in all 4 scenarios, the following two conditions are true
              //-- OS < NE && NS < OE

             
              //STGAP00007499 - called class method compareTo() to determine if the date and time of new onCall overlaps existing onCall date and time
              if (existingStartDate.compareTo(newEndDateAndTime) < 0 && newStartDateAndTime.compareTo(existingEndDate) < 0) {
              if (this.compareTo(existingStartDate, newEndTime, existingEndDate, newStartTime)) {
                overlap = true;
                break;
              }
            }
          }
        }
      }
      
      fakePageNbr++;
    } while(schedules.isMoreDataAvailable());
    
    return overlap;
  }

  private CCMN10SI callDynamicOnCallDAO(CCMN10SI ccmn10si, String cReqFuncCd)
          throws ServiceException {
    int _CCMN16DO__ROWCCMN16DO_SIZE = 350;
    int rc_time1 = 0;
    int rc_time2 = 0;
    int rc_time3 = 0;
    int rc_time4 = 0;
    String temp1_start_time = new String();
    String temp1_end_time = new String();
    String temp2_start_time = new String();
    String temp2_end_time = new String();
    ROWCCMN20DI rowccmn20di = ccmn10si.getROWCCMN20DI();
    SzCdOnCallCounty_ARRAY szCdOnCallCounty_array = rowccmn20di.getSzCdOnCallCounty_ARRAY();
    for (Enumeration szCdOnCallCountyEnum = szCdOnCallCounty_array.enumerateSzCdOnCallCounty(); szCdOnCallCountyEnum
            .hasMoreElements();) {
      String[] szCdOnCallCounty = {(String) szCdOnCallCountyEnum.nextElement()};
      rc_time1 = 0;
      rc_time2 = 0;
      rc_time3 = 0;
      rc_time4 = 0;
      // Calling ynamicOnCallDAO CCMN16D
      List<Object[]> objList = dynamicOnCallDAO.findOnCall(szCdOnCallCounty, rowccmn20di.getSzCdOnCallProgram(), null,
                                                           null, null, 1, 250);
      // if there are no rows found matching the county and program then there is no overlap 
      //checking required. The proposed shift/block is the first entry for the county
      // and program pair: by-pass the over-lap checking and add the proposed shift/block.
      int ccmn16doRowQty = objList.size();
      if (objList != null && ccmn16doRowQty != 0) {
        //-- in Object[]: 0=region, 1=program, 2=type, 3=startDate, 4=endDate, 5=idOnCall, 6=filled,
        //--              7=dtLastUpdate, 8=countOfCounties
        Object[] firstResult = objList.get(0);
        Object[] lastResult = objList.get(ccmn16doRowQty - 1);
        if (objList.size() != _CCMN16DO__ROWCCMN16DO_SIZE) {
          // We now have all of the shifts/blocks for the county/program pair
          // (in the pCCMN16DOutputRec->ROWCCMN16DO array) of the proposed
          // shift/block to be added.
          // First, if the ulRowQty != _CCMN16DO__ROWCCMN16DO_SIZE:
          // we need to check for over-laps.
          // else
          // (that is, if ulRowQty == _CCMN16DO__ROWCCMN16DO_SIZE)
          // the maximum number of shifts/blocks for the county/program pair
          // already exist; return the MSG_ON_CALL_TOO_MANY message to the user.
          // To check for overlaps:
          // We need to check if there exists an OnCall shift/block which contains
          // any part of the proposed OnCall shift/block's time; and if so, do NOT
          // add the proposed OnCall shift/block as it would create an
          // Overlap condition.
          // The new shift/block (S/B) to be added is either/or:
          // Case 1:
          // Completely contained prior to first start date/time already scheduled.
          // If (new S/B's end date/time) > (First start date/time)
          // Set no_overlap = false
          // Case 2:
          // Completely contained after the last start date/time already scheduled.
          // If (new S/B's start date/time) < (Last end date/time)
          // Set no_overlap = false
          // no_overlap will only be set to false if both Case 1 and Case 2's
          // comparisons indicate that no_overlap should be set to false:
          // If (new S/B's end date/time) > (First start date/time)
          // AND If (new S/B's start date/time) < (Last end date/time)
          // Set no_overlap = false
          // Case 3:
          // It's start and/or end date/time overlaps with the existing schedule.
          // So we need to compare the new S/B with each current shift or block
          // that is already scheduled.
          // There are four combinations of comparisons:
          // 1. block-block: the new item is a block and the old item is a block.
          // 2. block-shift: the new item is a block and the old item is a shift.
          // 3. shift-block: the new item is a shift and the old item is a block.
          // 4. shift-shift: the new item is a shift and the old item is a shift.
          // 
          // Case 1:
          // Completely contained prior to first start date/time already scheduled.
          // If (new S/B's end date/time) > (First start date/time)
          // Set no_overlap = false
          // no_overlap will only be set to false if both Case 1 and Case 2's
          // comparisons indicate that no_overlap should be set to false:
          // If (new S/B's end date/time) > (First start date/time)
          // AND If (new S/B's start date/time) < (Last end date/time)
          // Set no_overlap = false
          // new S/B's end date: pInputMsg->ROWCCMN20DI[0].dtDtOnCallEnd
          // new S/B's end time: pInputMsg->ROWCCMN20DI[0].tmOnCallEnd
          // First start date:   pCCMN16DOutputRec->ROWCCMN16DO[0].dtDtOnCallStart
          // First start time:   pCCMN16DOutputRec->ROWCCMN16DO[0].tmOnCallStart
          //
          //-- rc_time1 represents if proposed endDateAndTime is after the firstResult's startDate
          //----> POSITIVE (rc_time1 > 0): firstResult's startDate < proposed endDateAndTime 
          //----> NEGATIVE (rc_time1 < 0): proposed endDateAndTime < firstResult's startDate
          rc_time1 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallEnd(), rowccmn20di.getTmOnCallEnd(),
                                                   (Date) firstResult[3]);
          // Case 2:
          // Completely contained after the last start date/time already scheduled.
          // If (new S/B's start date/time) < (Last end date/time)
          //    Set no_overlap = false

          // no_overlap will only be set to false if both Case 1 and Case 2's
          // comparisons indicate that no_overlap should be set to false:
          // If (new S/B's end date/time) > (First start date/time)
          // AND If (new S/B's start date/time) < (Last end date/time)
          //    Set no_overlap = false

          // new S/B's start date: pInputMsg->ROWCCMN20DI.dtDtOnCallStart
          //  new S/B's start time: pInputMsg->ROWCCMN20DI.tmOnCallStart

          //  Last end date: pCCMN16DOutputRec->ROWCCMN16DO[pCCMN16DOutputRec->
          //                 ArchOutputStruct.ulRowQty - 1].dtDtOnCallEnd

          //   Last end time: pCCMN16DOutputRec->ROWCCMN16DO[pCCMN16DOutputRec->
          //          ArchOutputStruct.ulRowQty - 1].tmOnCallEnd
          //-- rc_time2 represents if proposed startDateAndTime is after the lastResult's endDate
          //----> POSITIVE (rc_time2 > 0): lastResult's endDate < proposed startDateAndTime
          //----> NEGATIVE (rc_time2 < 0): proposed startDateAndTime < lastResult's endDate
          rc_time2 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallStart(), rowccmn20di.getTmOnCallStart(),
                                                   (Date) lastResult[4]);
          if ((rc_time1 > 0) && (rc_time2 < 0)) {
            ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
          }
          // check if no_overlap is FALSE
          // if so, Case 1 and Case 2 conditions indicated an overlap exists.
          // now need to check Case 3 conditions
          // If no_overlap is TRUE, the proposed shift/block may be added,
          // no further processing is necessary in the CallCCMN16D function.
          if (ArchitectureConstants.N.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
            // re-initialize no_overlap (pInputMsg->ArchInputStruct.bDataAcsInd)
            // to TRUE; the moment that it (no_overlap) is found to be FALSE
            // within the Case 3 logic, there is no need to continue the comparisons.
            ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.Y);
            //for (i128 = 0;((i128 < pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty()) && (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true));++i128) {
            for (Iterator<Object[]> it = objList.iterator(); it.hasNext()
                                                             && ArchitectureConstants.Y.equals(
                    ccmn10si.getArchInputStruct()
                            .getBDataAcsInd());) {
              Object[] existingSchedule = it.next();
              //  Case 3:
              //  It's start and/or end date/time overlaps with the existing schedule.
              //  So we need to compare the new S/B with each current shift or block
              //  that is already scheduled.
              //  NOTE: If this is a MODIFY, need to compare ulIdOnCall of the new S/B
              //  with the existing S/B and skip the code for checking for over-lap
              //  between the new S/B and it's old version (because the old version
              //  will be over-written with the new S/B).
              //  old block:      pCCMN16DOutputRec->ROWCCMN16DO[i].szCdOnCallType == BLOCK
              //  old shift:      pCCMN16DOutputRec->ROWCCMN16DO[i].szCdOnCallType == SHIFT
              //  old start date: pCCMN16DOutputRec->ROWCCMN16DO[i].dtDtOnCallStart
              //  old start time: pCCMN16DOutputRec->ROWCCMN16DO[i].tmOnCallStart
              //  old end date:   pCCMN16DOutputRec->ROWCCMN16DO[i].dtDtOnCallEnd
              //  old end time:   pCCMN16DOutputRec->ROWCCMN16DO[i].tmOnCallEnd

              //  new block:      pInputMsg->ROWCCMN20DI.szCdOnCallType == BLOCK
              //  new shift:      pInputMsg->ROWCCMN20DI.szCdOnCallType == SHIFT
              //  new start date: pInputMsg->ROWCCMN20DI.dtDtOnCallStart
              //  new start time: pInputMsg->ROWCCMN20DI.tmOnCallStart
              //  new end date:   pInputMsg->ROWCCMN20DI.dtDtOnCallEnd
              //  new end time:   pInputMsg->ROWCCMN20DI.tmOnCallEnd

              //  Case 3:
              //  First (of four) comparison combinations:
              //  1. block-block: the new item is a block and the old item is a block.

              //  if (new block) and (old block) ]
              //    if [   (old_start date/time <= new_start date/time <  old_end date/time)

              //         or (new_start date/time <= old_start date/time <  new_end date/time)

              //         or (  (new_start date/time >  old_start date/time)
              //          AND    (new_end date/time <= old_end date/time) )

              //        or ( (old_start date/time  >  new_start date/time)
              //         AND    (old_end date/time <= new_end date/time) )  ]

              //        or ( (new_start date/time  <= old_start date/time)
              //         AND    (new_end date/time >= old_end date/time) )  ]

              //        or ( (old_start date/time  <= new_start date/time)
              //         AND    (old_end date/time >= new_end date/time) )  ]

              //    then OVERLAP EXISTS: Set no overlap = false
              
              //-- use today instead of null for comparing time only
              org.exolab.castor.types.Date todayCastorDate = DateHelper.getTodayCastorDate();
              
              //-- use oldStartDate instead of rowccmn16do[3] and oldEndDate instead of rowccmn16do[4]
              Date oldStartDate = (Date) existingSchedule[3];
              String formattedStartDateString = DateHelper.DATE_TIME_FORMAT.format(oldStartDate);
              
              Date oldEndDate = (Date) existingSchedule[4];
              String formattedEndDateString = DateHelper.DATE_TIME_FORMAT.format(oldEndDate);
            
              try{
                oldStartDate = DateHelper.DATE_TIME_FORMAT.parse(formattedStartDateString);
                oldEndDate = DateHelper.DATE_TIME_FORMAT.parse(formattedEndDateString);
                
              } catch(ParseException pe){
                //-- do anything?
              }
              
              if (CodesTables.CONCLTYP_BL.equals(rowccmn20di.getSzCdOnCallType()) && CodesTables.CONCLTYP_BL.equals(
                      existingSchedule[2])) {
                // 1: old start date/time, new start date/time
                rc_time1 = DateHelper.compareDateAndTime(oldStartDate, rowccmn20di.getDtDtOnCallStart(),
                                                         rowccmn20di.getTmOnCallStart());
                // 2: new end date/time, old end date/time
                rc_time2 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallStart(),
                                                         rowccmn20di.getTmOnCallStart(), oldEndDate);
                // check if (old start date/time <= new start date/time) and (new start date/time <  old end date/time)
                if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                  ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                }
                if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  // 3: old start date/time, new start date/time
                  rc_time3 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallStart(),
                                                           rowccmn20di.getTmOnCallStart(), oldStartDate);
                  // 4: old start date/time, new end date/time
                  rc_time4 = DateHelper.compareDateAndTime(oldStartDate, rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd());
                  // check if (new start date/time <= old start date/time) and (old start date/time <  new end date/time)
                  if ((rc_time3 <= 0) && (rc_time4 < 0)) {
                    ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                  }
                }
                if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  // 5: new start date/time, old start date/time
                  rc_time1 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallStart(),
                                                           rowccmn20di.getTmOnCallStart(), oldStartDate);
                  // 6: block start date/time, shift end date/time
                  rc_time2 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd(), oldEndDate);
                  // check if (new start date/time >  old start date/time) and (  new end date/time <= old end date/time)
                  if ((rc_time1 > 0) && (rc_time2 <= 0)) {
                    ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                  }
                }
                if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  // 7: shift start date/time, block end date/time
                  rc_time3 = DateHelper.compareDateAndTime(oldStartDate, rowccmn20di.getDtDtOnCallStart(),
                                                           rowccmn20di.getTmOnCallStart());
                  // 8: old end date/time, new end date/time
                  rc_time4 = DateHelper.compareDateAndTime(oldEndDate, rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd());
                  // check if (old start date/time >  new start date/time) and (  old end date/time <= new end date/time)
                  if ((rc_time3 > 0) && (rc_time4 <= 0)) {
                    ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                  }
                }
                if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  // 9: new start date/time, old start date/time
                  rc_time1 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallStart(),
                                                           rowccmn20di.getTmOnCallStart(), oldStartDate);
                  // 10: block end date/time, shift end date/time
                  rc_time2 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd(), oldEndDate);
                  if ((rc_time1 <= 0) && (rc_time2 >= 0)) {
                    ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                  }
                }
                if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  // 11: shift start date/time, block start date/time
                  rc_time3 = DateHelper.compareDateAndTime(oldStartDate, rowccmn20di.getDtDtOnCallStart(),
                                                           rowccmn20di.getTmOnCallStart());
                  // 12: old end date/time, new end date/time
                  rc_time4 = DateHelper.compareDateAndTime(oldEndDate, rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd());
                  if ((rc_time3 <= 0) && (rc_time4 >= 0)) {

                    ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                  }
                }
              }
              // 
              // Case 3:
              // Second (of four) comparison combinations:
              // 2. block-shift: the new item is a block and the old item is a shift.
              // else if [ (new block) and (old shift) ]
              // if {[shift_start date/time <= block_start date/time <  shift_end date/time]
              // or [shift_start date/time <  block_end date/time   <= shift_end date/time]
              // or [(block_start date/time <= shift_start date/time)
              // AND (block_end date/time  >= shift_end date/time)]        }
              // then OVERLAP EXISTS: Set no overlap = false
              // 
              //else if ((pInputMsg224.getROWCCMN20DI().getSzCdOnCallType().equals(BLOCK)) && (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getSzCdOnCallType().equals(SHIFT))) {
              else if ((CodesTables.CONCLTYP_BL.equals(rowccmn20di.getSzCdOnCallType()) &&
                        (CodesTables.CONCLTYP_SH.equals(existingSchedule[2])))) {
                // 13: shift start date/time, block start date/time
                rc_time1 = DateHelper.compareDateAndTime(oldStartDate, rowccmn20di.getDtDtOnCallStart(),
                                                         rowccmn20di.getTmOnCallStart());
                // 14: block end date/time, shift end date/time
                rc_time2 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallStart(),
                                                         rowccmn20di.getTmOnCallStart(), oldEndDate);
                // check if (shift start date/time <= block start date/time) and (block start date/time <  shift end date/time)
                if ((rc_time1 <= 0) && (rc_time2 < 0)) {

                  ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                }
                if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  // 15: block start date/time, shift start date/time
                  rc_time3 = DateHelper.compareDateAndTime(oldStartDate, rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd());
                  // 16: block end date/time, shift end date/time
                  rc_time4 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd(), oldEndDate);
                  // check if (shift start date/time <  block end date/time) and (block end date/time <= shift end date/time)
                  if ((rc_time3 < 0) && (rc_time4 <= 0)) {
                    ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                  }
                }
                if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  // 17: block start date/time, shift start date/time
                  rc_time1 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallStart(),
                                                           rowccmn20di.getTmOnCallStart(), oldStartDate);
                  // Sir 10902 -replaced the NULL timestamp
                  // 18: new_start_date <= old_end_date
                  rc_time2 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd(), oldEndDate);
                  // check if (block start date/time <= shift start date/time) and (  block end date/time >= shift end date/time)
                  if ((rc_time1 <= 0) && (rc_time2 >= 0)) {
                    ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                  }
                }
              }
              // Case 3:
              // Third (of four) comparison combinations:
              // 3. shift-block: the new item is a shift and the old item is a block.
              // else if [ (new shift) and (old block) ]
              // if {[shift_start date/time <= block_start date/time <  shift_end date/time]
              // or [shift_start date/time <  block_end date/time   <= shift_end date/time]
              // or [(block_start date/time <= shift_start date/time)
              // AND (block_end date/time  >= shift_end date/time)]        }
              // then OVERLAP EXISTS: Set no overlap = false
              //else if ((pInputMsg224.getROWCCMN20DI().getSzCdOnCallType().equals(SHIFT)) && (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getSzCdOnCallType().equals(BLOCK))) {
              else if (CodesTables.CONCLTYP_SH.equals(rowccmn20di.getSzCdOnCallType()) &&
                       CodesTables.CONCLTYP_BL.equals(existingSchedule[2])) {
                // 19: old start date <= new end date
                rc_time3 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallStart(),
                                                         rowccmn20di.getTmOnCallStart(), oldStartDate);
                // 20: block start date/time, shift end date/time
                rc_time4 = DateHelper.compareDateAndTime(oldStartDate, rowccmn20di.getDtDtOnCallEnd(),
                                                         rowccmn20di.getTmOnCallEnd());
                // check if (shift start date/time <= block start date/time) and (block start date/time <  shift end date/time)
                if ((rc_time3 <= 0) && (rc_time4 < 0)) {
                  ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                }
                if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  // 21: shift start date/time, block end date/time
                  rc_time1 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallStart(),
                                                           rowccmn20di.getTmOnCallStart(), oldEndDate);
                  // 22: old start date <= new end date
                  rc_time2 = DateHelper.compareDateAndTime(oldEndDate, rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd());
                  // check if (shift start date/time <  block end date/time) and (block end date/time <= shift end date/time)
                  if ((rc_time1 < 0) && (rc_time2 <= 0)) {
                    ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                  }
                }
                if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  // 23: new start date <= old end date
                  rc_time3 = DateHelper.compareDateAndTime(oldStartDate, rowccmn20di.getDtDtOnCallStart(),
                                                           rowccmn20di.getTmOnCallStart());
                  // 24: block end date/time, shift end date/time
                  rc_time4 = DateHelper.compareDateAndTime(oldEndDate, rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd());
                  // check if (block start date/time <= shift start date/time) and (  block end date/time >= shift end date/time)
                  if ((rc_time3 <= 0) && (rc_time4 >= 0)) {
                    ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                  }
                }
              }
              // Case 3:
              // Fourth (of four) comparison combinations:
              // 4. shift-shift: the new item is a shift and the old item is a shift.
              // else if [ (new shift) and (old shift) ]
              // if { [old_start_date <= new_start_date <= old_end_date]
              // or [old_start_date <= new_end_date <= old_end_date]
              // or [new_start_date <= old_start_date <= new_end_date]
              // or [new_start_date <= old_end_date <= new_end_date] }
              // {  if one of the above comparisons is true,
              // this means that the dates overlap, now check the times 
              // if (old_end_time < old_start_time)
              // {
              // temp1_start_time = 0;        we need 2 blocks 
              // temp1_end_time   = old_end_time;
              // temp2_start_time = old_start_time;
              // temp2_end_time   = 24;
              // if { [temp1_start_time <= new_start_time < temp1_end_time]
              // or [new_start_time  <= temp1_start_time < new_end_time]
              // or [temp2_start_time <= new_start_time < temp2_end_time]
              // or [new_start_time  <= temp2_start_time < new_end_time] }
              // then OVERLAP EXISTS;
              // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
              // }
              // if [new_end_time < new_start_time]
              // {
              // temp1_start_time = 0       we need 2 blocks 
              // temp1_end_time   = old_end_time
              // temp2_start_time = old_start_time
              // temp2_end_time   = 24
              // if { [temp1_start_time <= old_start_time < temp1_end_time]
              // or [old_start_time  <= temp1_start_time < old_end_time]
              // or [temp2_start_time <= old_start_time < temp2_end_time]
              // or [old_start_time  <= temp2_start_time < old_end_time] }
              // then OVERLAP EXISTS;
              // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
              // }
              else if (CodesTables.CONCLTYP_SH.equals(rowccmn20di.getSzCdOnCallType()) &&
                       CodesTables.CONCLTYP_SH.equals(existingSchedule[2])) {
                // 25: old_start_date <= new_start_date
                rc_time1 = DateHelper.compareDateAndTime(oldStartDate, rowccmn20di.getDtDtOnCallStart(),
                                                         rowccmn20di.getTmOnCallStart());
                // 26: new_end_time < new_start_time
                rc_time2 = DateHelper.compareDateAndTime(oldEndDate,  rowccmn20di.getDtDtOnCallEnd(),
                                                         rowccmn20di.getTmOnCallEnd());
                          // check if (old start date <= new start date) and (new start date <= old end date)
                if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                  ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                }
                if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  //   if { [temp1_start_time <= new_start_time < temp1_end_time]
                  // or [temp2_start_time <  new_end_time <= temp2_end_time]
                  // then OVERLAP EXISTS;
                  // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;

                  // if { [temp1_start_time <= new_start_time < temp1_end_time]
                  // 27: temp1_start_time <= new_start_time
                  rc_time3 = DateHelper.compareDateAndTime(oldStartDate, rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd());
                  // Sir 10902 -replaced the NULL timestamp
                  // 28: new end date <= old end date
                  rc_time4 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd(), oldEndDate);
                  // check if (old start date <= new end date) and (new end date <= old end date)
                  if ((rc_time3 <= 0) && (rc_time4 <= 0)) {
                    ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                  }
                }
                if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  // 29: new start date <= old start date
                  rc_time1 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallStart(),
                                                           rowccmn20di.getTmOnCallStart(), oldStartDate);
                  // 30: new_end_time <= temp2_end_time
                  rc_time2 = DateHelper.compareDateAndTime(oldStartDate, rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd());
                  // check if (new start date <= old start date) and (old start date <= new end date)
                  if ((rc_time1 <= 0) && (rc_time2 <= 0)) {
                    ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                  }
                }
                if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  // 31: new_end_time >= new_start_time
                  rc_time3 = DateHelper.compareDateAndTime(rowccmn20di.getDtDtOnCallStart(),
                                                           rowccmn20di.getTmOnCallStart(), oldEndDate);
                  // 32: old end date <= new end date
                  rc_time4 = DateHelper.compareDateAndTime(oldEndDate, rowccmn20di.getDtDtOnCallEnd(),
                                                           rowccmn20di.getTmOnCallEnd());
                  // check if (new start date <= old end date) and (old end date   <= new end date)
                  if ((rc_time3 < 0) && (rc_time4 <= 0)) {
                    ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                  }
                }
                if (ArchitectureConstants.N.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                  // if pInputMsg->ArchInputStruct.bDataAcsInd == FALSE
                  // it means that the dates overlap, now we need to check the times.
                  // First, re-initialize bDataAcsInd back to TRUE 
                  ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.Y);
                  // 33: old_end_time < old_start_time
                  rc_time1 = DateHelper.compareDateAndTime(todayCastorDate, FormattingHelper.formatTime(oldEndDate),
                                                           todayCastorDate, FormattingHelper.formatTime(oldStartDate));
                  if (rc_time1 < 0) {
                    // 34: old start time < new end time
                    rc_time2 = DateHelper.compareDateAndTime(todayCastorDate, rowccmn20di.getTmOnCallEnd(), 
                                                             todayCastorDate, rowccmn20di.getTmOnCallStart());
                    if (rc_time2 < 0) {
                      // If both old end time < old start time and     new end time < new start time
                      // There is an overlap; set DataAcsInd = FALSE.
                      ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                    }
                    if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                      // If we get to this point, it means that old end time <  old start time
                      // and new end time >= new start time Use two temporary times 
                      // (temp1_start_time and temp2_end_time) to make old end time and old start time into
                      // two blocks. Check if new_start_time falls within the first block or if new_end_time 
                      // falls within the second block: if either of those are TRUE, an OVERLAP exists.
                      temp1_start_time = "12:00 AM";
                      temp1_end_time = FormattingHelper.formatTime(oldEndDate);
                      temp2_start_time = FormattingHelper.formatTime(oldStartDate);
                      temp2_end_time = "11:59 PM";
                      //if { [temp1_start_time <= new_start_time < temp1_end_time] or [temp2_start_time 
                      // <  new_end_time <= temp2_end_time]  then OVERLAP EXISTS;  
                      // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
                      // if { [temp1_start_time <= new_start_time < temp1_end_time]
                      // 35: temp1_start_time <= new_start_time 
                      rc_time3 = DateHelper.compareDateAndTime(todayCastorDate, temp1_start_time, todayCastorDate,
                                                               rowccmn20di.getTmOnCallStart());
                      // 36: new_start_time < temp1_end_time
                      rc_time4 = DateHelper.compareDateAndTime(todayCastorDate, rowccmn20di.getTmOnCallStart(), todayCastorDate,
                                                               temp1_end_time);
                      if ((rc_time3 <= 0) && (rc_time4 < 0)) {
                        ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                      }
                    }
                    if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                      // or [temp2_start_time <  new_end_time <= temp2_end_time]
                      // 37: temp2_start_time < new_end_time
                      rc_time1 = DateHelper.compareDateAndTime(todayCastorDate,
                                                               FormattingHelper.formatTime(oldStartDate),
                                                               todayCastorDate, rowccmn20di.getTmOnCallEnd());
                      // 38: old start time <= new end time
                      rc_time2 = DateHelper
                              .compareDateAndTime(todayCastorDate, rowccmn20di.getTmOnCallEnd(), todayCastorDate, temp2_end_time);
                      // check if (temp2_start_time < new_end_time) and (new_end_time <=  temp2_end_time)
                      if ((rc_time1 < 0) && (rc_time2 <= 0)) {
                        ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                      }
                    } /* end if pInputMsg->ArchInputStruct.bDataAcsInd == TRUE */
                  } /* end if (rc_time1 < 0) */ else // old end time >= old start time
                  {

                    // 39: new start time <= old end time
                    rc_time3 = DateHelper.compareDateAndTime(todayCastorDate, rowccmn20di.getTmOnCallEnd(), todayCastorDate,
                                                             rowccmn20di.getTmOnCallStart());
                    if (rc_time3 >= 0) {
                      // If we get to this point, it means that
                      // old end time >=  old start time
                      // and     new end time >= new start time
                      // Need to compare the following:
                      // If (new start time <= old start time <  new end time)
                      // or (new start time <  old end time   <= new end time)
                      // or [ (new start time <= old start time <= new end time)
                      // && (new start time <= old end time   <= new end time) ]
                      // then OVERLAP EXISTS;
                      // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
                      // else
                      // If (old start time <= new start time <  old end time)
                      // or (old start time <  new end time   <= old end time)
                      // or [ (old start time <= new start time <= old end time)
                      // && (old start time <= new end time   <= old end time) ]
                      // then OVERLAP EXISTS;
                      // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
                      // 40: new start time <= old start time
                      rc_time1 = DateHelper.compareDateAndTime(todayCastorDate, rowccmn20di.getTmOnCallStart(), todayCastorDate,
                                                               FormattingHelper.formatTime(oldStartDate));
                      // 41: new start time < old end time
                      rc_time2 = DateHelper.compareDateAndTime(todayCastorDate,
                                                               FormattingHelper.formatTime(oldStartDate),
                                                               todayCastorDate, rowccmn20di.getTmOnCallEnd());
                      // check if (new start time <= old start time) and (old start time <  new end time)
                      if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                        ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                      }
                      if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                        // 42: old start time < new end time
                        rc_time3 = DateHelper.compareDateAndTime(todayCastorDate, rowccmn20di.getTmOnCallStart(), todayCastorDate,
                                                                 FormattingHelper.formatTime(oldEndDate));
                        // 43: old end time <= new end time
                        rc_time4 = DateHelper.compareDateAndTime(todayCastorDate,
                                                                 FormattingHelper.formatTime(oldEndDate),
                                                                 todayCastorDate, rowccmn20di.getTmOnCallEnd());
                        // check if (new start time < old end time) and (old end time <= new end time)
                        if ((rc_time3 < 0) && (rc_time4 <= 0)) {
                          ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                        }
                      }
                      // or [ (new start time <= old start time <= new end time)
                      // && (new start time <= old end time   <= new end time) ]
                      if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                        // 44: new start time <= old start time
                        rc_time1 = DateHelper.compareDateAndTime(todayCastorDate, rowccmn20di.getTmOnCallStart(), todayCastorDate,
                                                                 FormattingHelper.formatTime(oldStartDate));
                        // 45: new start time <= old end time
                        rc_time2 = DateHelper.compareDateAndTime(todayCastorDate,
                                                                 FormattingHelper.formatTime(oldStartDate),
                                                                 todayCastorDate, rowccmn20di.getTmOnCallEnd());
                        // 46: old start time <= new end time
                        rc_time3 = DateHelper.compareDateAndTime(todayCastorDate, rowccmn20di.getTmOnCallStart(), todayCastorDate,
                                                                 FormattingHelper.formatTime(oldEndDate));
                        // 47: old end time <= new end time
                        rc_time4 = DateHelper.compareDateAndTime(todayCastorDate,
                                                                 FormattingHelper.formatTime(oldEndDate),
                                                                 todayCastorDate, rowccmn20di.getTmOnCallEnd());
                        // check if (new start time <= old start time) and (old start time <= new end time)
                        // and (new start time <= old end time) and (old end time <= new end time)
                        if ((rc_time1 <= 0) && (rc_time2 <= 0) && (rc_time3 <= 0) && (rc_time4 <= 0)) {
                          ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                        }
                      } /* end if pInputMsg->ArchInputStruct.bDataAcsInd == TRUE */
                      // If (old start time <= new start time <  old end time)
                      // or (old start time <  new end time   <= old end time)
                      // or [ (old start time <= new start time <= old end time)
                      // && (old start time <= new end time   <= old end time) ]
                      if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                        // 48: old start time <= new start time
                        rc_time1 = DateHelper.compareDateAndTime(todayCastorDate,
                                                                 FormattingHelper.formatTime(oldStartDate),
                                                                 todayCastorDate, rowccmn20di.getTmOnCallStart());
                        // 49: old_start_time < temp1_end_time
                        rc_time2 = DateHelper.compareDateAndTime(todayCastorDate, rowccmn20di.getTmOnCallStart(), todayCastorDate,
                                                                 FormattingHelper.formatTime(oldEndDate));
                        // check if (old start time <= new start time) and (new start time <  old end time)
                        if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                          ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                        }
                      }
                      if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                        // 50: old start time < new end time
                        rc_time3 = DateHelper.compareDateAndTime(todayCastorDate,
                                                                 FormattingHelper.formatTime(oldStartDate),
                                                                 todayCastorDate, rowccmn20di.getTmOnCallEnd());
                        // 51: new end time <= old end time
                        rc_time4 = DateHelper.compareDateAndTime(todayCastorDate, rowccmn20di.getTmOnCallEnd(), todayCastorDate,
                                                                 FormattingHelper.formatTime(oldEndDate));
                        // check if (new start time < old end time) and (old end time <= new end time)
                        if ((rc_time3 < 0) && (rc_time4 <= 0)) {
                          ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                        }
                      }
                      // or [ (old start time <= new start time <= old end time)
                      // && (old start time <= new end time   <= old end time) ]
                      if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                        // 52: old start time <= new start time
                        rc_time1 = DateHelper.compareDateAndTime(todayCastorDate,
                                                                 FormattingHelper.formatTime(oldStartDate),
                                                                 todayCastorDate, rowccmn20di.getTmOnCallStart());
                        // 53: old_end_time <= temp2_end_time
                        rc_time2 = DateHelper.compareDateAndTime(todayCastorDate, rowccmn20di.getTmOnCallStart(), todayCastorDate,
                                                                 FormattingHelper.formatTime(oldEndDate));
                        // 54: old start time <= new end time 
                        rc_time3 = DateHelper.compareDateAndTime(todayCastorDate,
                                                                 FormattingHelper.formatTime(oldStartDate),
                                                                 todayCastorDate, rowccmn20di.getTmOnCallEnd());
                        // 55: new end time <= old end time
                        rc_time4 = DateHelper.compareDateAndTime(todayCastorDate, rowccmn20di.getTmOnCallEnd(), todayCastorDate,
                                                                 FormattingHelper.formatTime(oldEndDate));
                        // check if (old start time <= new start time) and (new start time <= old end time)
                        // and (old start time <= new end time) and (new end time <= old end time)
                        if ((rc_time1 <= 0) && (rc_time2 <= 0) && (rc_time3 <= 0) && (rc_time4 <= 0)) {
                          ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                        }
                      }// end if pInputMsg->ArchInputStruct.bDataAcsInd == TRUE 
                    } // end if (rc_time3 >= 0): new_end_time >= new_start_time
                    else {
                      // If we get to this point, it means that old end time >=  old start time
                      // and  new end time <  new start time Use two temporary times 
                      // (temp1_start_time and temp2_end_time) to make new end time and new start time into 
                      // two blocks. Check if old_start_time falls within the first block or if old_end_time falls 
                      // within the second block: if either of those are TRUE, an OVERLAP exists.
                      temp1_start_time = "12:00 AM";
                      temp1_end_time = rowccmn20di.getTmOnCallEnd();
                      temp2_start_time = rowccmn20di.getTmOnCallStart();
                      temp2_end_time = "11:59 PM";
                      //   if { [temp1_start_time <= old_start_time < temp1_end_time]
                      // or [temp2_start_time <  old_end_time <= temp2_end_time]
                      // then OVERLAP EXISTS;
                      // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
                      // if { [temp1_start_time <= old_start_time < temp1_end_time]
                      // 56: temp1_start_time <= old_start_time
                      rc_time1 = DateHelper.compareDateAndTime(todayCastorDate, temp1_start_time, todayCastorDate,
                                                               FormattingHelper.formatTime(oldStartDate));
                      // 57: old_start_time < temp1_end_time 
                      rc_time2 = DateHelper.compareDateAndTime(todayCastorDate,
                                                               FormattingHelper.formatTime(oldStartDate),
                                                               todayCastorDate, temp1_end_time);
                      // check if (temp1_start_time <=  old_start_time) and (old_start_time < temp1_end_time)
                      if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                        ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                      }
                      //  Check to see if Admin Review exits for
                      // this stage
                      if (ArchitectureConstants.Y.equals(ccmn10si.getArchInputStruct().getBDataAcsInd())) {
                        // or [temp2_start_time < old_end_time <= temp2_end_time]
                        // 58: temp2_start_time < old_end_time
                        rc_time1 = DateHelper.compareDateAndTime(todayCastorDate, temp2_start_time, todayCastorDate,
                                                                 FormattingHelper.formatTime(oldEndDate));
                        // 59: old_end_time <= temp2_end_time 
                        rc_time2 = DateHelper.compareDateAndTime(todayCastorDate,
                                                                 FormattingHelper.formatTime(oldEndDate),
                                                                 todayCastorDate, temp2_end_time);
                        //  check if (temp2_start_time < old_end_time) and (old_end_time <= temp2_end_time) 
                        if ((rc_time1 < 0) && (rc_time2 <= 0)) {
                          ccmn10si.getArchInputStruct().setBDataAcsInd(ArchitectureConstants.N);
                        }
                      } // end if pInputMsg->ArchInputStruct.bDataAcsInd == TRUE
                    } // end else (rc_time3 < 0): new_end_time < new_start_time 
                  } // end else (rc_time1 >= 0): old_end_time >= old_start_time
                } // end if pInputMsg->ArchInputStruct.bDataAcsInd == FALSE 

              } // end if: case four of four
            } // end for loop 
          } // end if bDataAcsInd == FALSE 
        } else // ...ulRowQty == _CCMN16DO__ROWCCMN16DO_SIZE
        {
          // Need to display a message to the user that states that the maximum number of shifts/blocks 
          // for the county/program pair already exist, and that the proposed shift/block was NOT added.
        }
      }
    }
    return ccmn10si;
  }
  
  //STGAP00007499 - created the method compareTo() to compare timestamps of dates
  /*@SuppressWarnings("static-access")
  public Boolean compareTo(Date date, String dateString) {
    Boolean result = false;

    //check to make sure the dateString passed in is not null but if it is, return false
    if (dateString == "" || dateString.length() == 0 || dateString == null) {
      throw new ServiceException(Messages.SSM_COMPLETE_REQUIRED);
    }

    //this section of code extracts the hours and seconds from the dateString and parses them into Integers
    String newStartHours = dateString.substring(0, 2);
    String newStartSeconds = dateString.substring(3, 5);
    String meridean = dateString.substring(6, dateString.length());
    Integer newSHours = 0;
    Integer newSSeconds = 0;
    try {
      newSHours = newSHours.parseInt(newStartHours);
      newSSeconds = newSSeconds.parseInt(newStartSeconds);
    } catch (NumberFormatException nf) {
      // do anything
    }
    //meridean is equal to either PM or AM, and if it is equal to PM then we need to add 12 to the hour so that the times
    //will be compatible when they are compared below
    if (meridean.equals("PM")) {
      newSHours = newSHours + 12;
    }

    //this section of code converts the date passed in into a string and extracts the hours and seconds from that string
    //then parses them into Integers
    String stDate = date.toString();
    String existingStartHours = stDate.substring(11, 13);
    String existingStartSeconds = stDate.substring(14, 16);
    Integer existingSHours = 0;
    Integer existingSSeconds = 0;
    try {
      existingSHours = existingSHours.parseInt(existingStartHours);
      existingSSeconds = existingSSeconds.parseInt(existingStartSeconds);
    } catch (NumberFormatException nf) {
      // do anything
    }
    
    //check to see if the time for the new onCall overlaps the time of the existing onCall
    if (existingSHours < newSHours) {
      result = true;
      return result;
    } else if (newSHours.equals(existingSHours)) {
      if (existingSSeconds < newSSeconds) {
        result = true;
        return result;
      }
    }

    return result;
  }*/
  
  @SuppressWarnings("static-access")
  public Boolean compareTo(Date existingStartDate, String newEndTime, Date existingEndDate, String newStartTime) {
    boolean result = false;
    
  //check to make sure the dateString passed in is not null but if it is, throw service exception
    if (newEndTime == "" || newEndTime.length() == 0 || newEndTime == null || newStartTime == "" || newStartTime.length() == 0 || newStartTime == null) {
      throw new ServiceException(Messages.SSM_COMPLETE_REQUIRED);
    }
    //check to make sure the onCall dates pulled from the database are not null. If they are, return false
    if(existingStartDate == null || existingEndDate == null){
      return result;
    }
    
  //this section of code extracts the hours and seconds from the dateString and parses them into Integers
    String newStartHours = newStartTime.substring(0, 2);
    String newStartMinutes = newStartTime.substring(3, 5);
    String meridean = newStartTime.substring(6, newStartTime.length());
    Integer newSHours = 0;
    Integer newSMinutes = 0;
    
    String newEndHours = newEndTime.substring(0, 2);
    String newEndMinutes = newEndTime.substring(3, 5);
    String merideanEnd = newEndTime.substring(6, newEndTime.length());
    Integer newEHours = 0;
    Integer newEMinutes = 0;
    try {
      newSHours = newSHours.parseInt(newStartHours);
      newSMinutes = newSMinutes.parseInt(newStartMinutes);
      newEHours = newEHours.parseInt(newEndHours);
      newEMinutes = newEMinutes.parseInt(newEndMinutes);
    } catch (NumberFormatException nf) {
      // do anything
    }
    //meridean is equal to either PM or AM, and if it is equal to PM then we need to add 12 to the hour so that the times
    //will be compatible when they are compared below
    if (meridean.equals("PM")) {
      newSHours = newSHours + 12;
    }
    
    if (merideanEnd.equals("PM")) {
      newEHours = newEHours + 12;
    }
    
  //this section of code converts the date passed in into a string and extracts the hours and seconds from that string
    //then parses them into Integers
    String stDate = existingStartDate.toString();
    String existingStartHours = stDate.substring(11, 13);
    String existingStartMinutes = stDate.substring(14, 16);
    Integer existingSHours = 0;
    Integer existingSMinutes = 0;
    
    String endDate = existingEndDate.toString();
    String existingEndHours = endDate.substring(11, 13);
    String existingEndMinutes = endDate.substring(14, 16);
    Integer existingEHours = 0;
    Integer existingEMinutes = 0;
    try {
      existingSHours = existingSHours.parseInt(existingStartHours);
      existingSMinutes = existingSMinutes.parseInt(existingStartMinutes);
      existingEHours = existingEHours.parseInt(existingEndHours);
      existingEMinutes = existingEMinutes.parseInt(existingEndMinutes);
    } catch (NumberFormatException nf) {
      // do anything
    }
    
 /*   if ((existingSHours < newSHours && existingEHours > newSHours)
                    || (existingSHours < newEHours && existingEHours > newEHours)
                    || (existingSHours > newEHours && existingEHours < newEHours && existingEHours > newSHours)
                    || (existingSHours < existingEHours && existingSHours > newSHours && existingEHours < newEHours)
                    || (existingSHours > existingEHours && newSHours < newEHours && existingSHours > newEHours && existingSHours > newSHours
                        && existingEHours > newSHours && (existingEHours > newEHours || existingEHours < newEHours))
                    || (existingSHours > existingEHours && newSHours > newEHours && existingSHours > newSHours 
                        && existingSHours > newEHours && existingEHours < newSHours && (existingEHours < newEHours || existingEHours > newEHours))) {
                  result = true;
                } else if (existingSHours == newSHours && existingSHours == newEHours && existingSHours == existingEHours) {
                  if ((newSMinutes < existingEMinutes && newEMinutes > existingEMinutes)
                      || (newSMinutes < existingSMinutes && newEMinutes > existingSMinutes)
                      || (newSMinutes == existingSMinutes && newEMinutes == existingEMinutes
                      || (existingSMinutes < newSMinutes && existingEMinutes > newEMinutes))) {
                    result = true;
                  }
                } else if ((existingSHours == newSHours && existingSHours == newEHours && newSMinutes >= existingSMinutes)
                           || (existingSHours == newSHours && existingSHours == newEHours && newEMinutes >= existingSMinutes)
                           || (existingEHours == newEHours && existingEHours == newSHours && newSMinutes <= existingEMinutes)
                           || (existingEHours == newEHours && existingEHours == newSHours && newEMinutes <= existingEMinutes)) {
                  result = true;
                } else if ((existingEHours == newSHours && existingSMinutes >= newSMinutes)
                           || (existingSHours == newEHours && existingSMinutes <= newEMinutes)
                           || (existingSHours == newSHours && existingSHours != newEHours)
                           || (existingEHours == newEHours && existingEHours != newSHours)) {
                  result = true;
                }else if(newSHours == newEHours && newSMinutes > newEMinutes && (newSHours != existingSHours || newSHours != existingEHours)){
                  result = true;
                }*/
    
    /*BEGINNING OF CODE TO DETECT OVERLAP IN TIMES*/
    
    //This code fills an integer array, based on the algorithm 60(n) + m where n = hours and m = minutes,
    //with ones according to the existing onCall start and end times pulled from the database where 
    //each array space is equivalent to a minute. Then it takes the new time, in minutes, and searches
    //the array to determine if the object at array[index] is filled (or, that is, if that time slot/minute
    //is already filled).
    
    //The first 60 memory spaces in the integer array go unused since there cannot be a 0th hour
    //This will not affect the code since neither the new time nor the existing time evaluate these spaces
    Integer[] existingTime = new Integer[1499];
    Integer one = 1;
    int z = 0;
    int o = 0;
    Integer existStartTimeInMinutes = 60 * existingSHours + existingSMinutes;
    Integer existEndTimeInMinutes = 60 * existingEHours + existingEMinutes;
    Integer newStartTimeInMinutes = 60 * newSHours + newSMinutes;
    Integer newEndTimeInMinutes = 60 * newEHours + newEMinutes;
    
    //If existing time does not complete a full loop, then the start time and end time converge. So fill the
    //array with the start and end times converging
    if(existingEHours > existingSHours || (existingEHours == existingSHours && existingEMinutes > existingSMinutes)){
      while (existStartTimeInMinutes <= existEndTimeInMinutes) {
        existingTime[existStartTimeInMinutes] = one;
        existStartTimeInMinutes++;
      }
    }
    //If the existing time does complete a full loop, then the start time and end time diverge.  So fill the
    //array with the start and end times diverging to the boundaries of the array.  This will effectively give the 
    //array circular properties
    else{
      while(existStartTimeInMinutes <= existingTime.length - 1){
      existingTime[existStartTimeInMinutes] = one;
      existStartTimeInMinutes++;
     }
      while(z <= existEndTimeInMinutes){
        existingTime[z] = one;
        z++;
      }
    }
    //If the new time does not complete a full loop, check the existingTime[] array at the indexes from the
    //new start time to the new end time.  If any of these spaces points to a value of 1, then there is an
    //overlap and the variable "result" will be set to true.
    if(newSHours < newEHours || (newSHours == newEHours && newEMinutes > newSMinutes)){
      while (newStartTimeInMinutes <= newEndTimeInMinutes) {
        if (one.equals(existingTime[newStartTimeInMinutes])) {
          result = true;
          break;
        }
        newStartTimeInMinutes++;
      }
    }
    //If the new time completes a full loop, check the existingTime[] array at the indexes from the new start time to 
    //the end of the array and from the beginning of the array to the new end time. If any of these spaces points to 
    //a value of 1, then there is an overlap and the variable "result" will be set to true.
    else{
      while(newStartTimeInMinutes <= existingTime.length - 1){
        if(one.equals(existingTime[newStartTimeInMinutes])){
          result = true;
          break;
        }
        newStartTimeInMinutes++;
      }
      while(o <= newEndTimeInMinutes){
        if(one.equals(existingTime[o])){
          result = true;
          break;
        }
        o++;
      }
    }
    return result;
  }
}