package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

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
import gov.georgia.dhr.dfcs.sacwis.dao.OnCallCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OnCallDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.OnCall;
import gov.georgia.dhr.dfcs.sacwis.db.OnCallCounty;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveOnCallList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN20DO;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SaveOnCallListImpl extends BaseServiceImpl implements SaveOnCallList {

  private static final int MAX_ON_CALL_INFO_LIST_SIZE = 350;

  private static final String SHIFT = CodesTables.CONCLTYP_SH;
  private static final String BLOCK = CodesTables.CONCLTYP_BL;
  private static final int TO_DO_REQUIRED = 99;

  private static final Date TEMP_1_START_TIME = new GregorianCalendar(2000, 0, 1, 0, 0).getTime();
  private static final Date TEMP_2_END_TIME = new GregorianCalendar(2000, 0, 1, 23, 59).getTime();

  private DynamicOnCallDAO dynamicOnCallDAO = null;
  private ComplexOnCallDAO complexOnCallDAO = null;
  private OnCallCountyDAO onCallCountyDAO = null;
  private EmpOnCallLinkDAO empOnCallLinkDAO = null;
  private OnCallDAO onCallDAO = null;
  private ComplexOnCallCountyDAO complexOnCallCountyDAO = null;
  private TodoDAO todoDAO = null;
  
  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setOnCallDAO(OnCallDAO onCallDAO) {
    this.onCallDAO = onCallDAO;
  }

  public void setDynamicOnCallDAO(DynamicOnCallDAO dynamicOnCallDAO) {
    this.dynamicOnCallDAO = dynamicOnCallDAO;
  }

  public void setComplexOnCallDAO(ComplexOnCallDAO complexOnCallDAO) {
    this.complexOnCallDAO = complexOnCallDAO;
  }

  public void setOnCallCountyDAO(OnCallCountyDAO onCallCountyDAO) {
    this.onCallCountyDAO = onCallCountyDAO;
  }

  public void setEmpOnCallLinkDAO(EmpOnCallLinkDAO empOnCallLinkDAO) {
    this.empOnCallLinkDAO = empOnCallLinkDAO;
  }

  public void setComplexOnCallCountyDAO(ComplexOnCallCountyDAO complexOnCallCountyDAO) {
    this.complexOnCallCountyDAO = complexOnCallCountyDAO;
  }

  public CCMN07SO saveOnCallListInformation(CCMN07SI ccmn07si) throws ServiceException {
    CCMN07SO ccmn07so = new CCMN07SO();
    StringBuffer oldSchedule = new StringBuffer();

    ArchInputStruct archInputStruct = ccmn07si.getArchInputStruct();
    String cReqFuncCd = archInputStruct.getCReqFuncCd();
    ROWCCMN20DI_ARRAY rowccmn20di_array = ccmn07si.getROWCCMN20DI_ARRAY();
    ROWCCMN20DI first_rowccmn20di = rowccmn20di_array.getROWCCMN20DI(0);

    // Initialize ArchInputStruct.bDataAcsInd to TRUE: this flag will be used to determine if an overlap exists.
    //   ArchInputStruct.bDataAcsInd == TRUE means no overlap exists.
    //   ArchInputStruct.bDataAcsInd == FALSE means an overlap exists.
    // If an overlap exists, the proposed shift/block should NOT be added.
    if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // CCMN16D only needs to be called if we are attempting to ADD or MODIFY an On-Call shift/block and the employees
      //   assigned to that block. If we are attempting to DELETE an On-Call shift/block, we do NOT need to call this DAO.
      // Note the oldSchedule is modified with the old scheule description.
      // ccmn16d
      if(proposedScheduleOverlaps(first_rowccmn20di)){
        if(ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)){
          throw new ServiceException(Messages.MSG_CMN_OVERLAP_ADD);
        } else{
          throw new ServiceException(Messages.MSG_CMN_OVERLAP_UPDATE);
        }
      } else{
        archInputStruct.setBDataAcsInd(ArchitectureConstants.Y);
      }
      
      /*
      archInputStruct.setBDataAcsInd(findNoOverlap(oldSchedule, cReqFuncCd, first_rowccmn20di.getUlIdOnCall(),
                                                   first_rowccmn20di.getSzCdOnCallType(),
                                                   first_rowccmn20di.getSzCdOnCallProgram(),
                                                   first_rowccmn20di.getSzCdRegion(),
                                                   first_rowccmn20di.getSzCdOnCallCounty(),
                                                   first_rowccmn20di.getDtDtOnCallStart(),
                                                   first_rowccmn20di.getTmOnCallStart(),
                                                   first_rowccmn20di.getDtDtOnCallEnd(),
                                                   first_rowccmn20di.getTmOnCallEnd(),
                                                   first_rowccmn20di.getSzCdOnCallCounty_ARRAY()));
      */
    } else {
      archInputStruct.setBDataAcsInd(ArchitectureConstants.Y);
    }
    if (ArchitectureConstants.Y.equals(archInputStruct.getBDataAcsInd())) {
      // CCMN20D only needs to be called if no_overlap exists (as determined in the CallCCMN16D function)
      //   OR if the requested action is DELETE.
      // ccmn20d
      ROWCCMN20DO rowccmn20do = audOnCall(cReqFuncCd, first_rowccmn20di.getSzCdOnCallType(),
                                          first_rowccmn20di.getSzCdOnCallProgram(), first_rowccmn20di.getSzCdRegion(),
                                          first_rowccmn20di.getSzCdOnCallCounty(),
                                          first_rowccmn20di.getDtDtOnCallStart(), first_rowccmn20di.getTmOnCallStart(),
                                          first_rowccmn20di.getDtDtOnCallEnd(), first_rowccmn20di.getTmOnCallEnd(),
                                          rowccmn20di_array);
      if (rowccmn20do == null) {
        // This is the SQL_NOT_FOUND case for ccmn20d
        rowccmn20do = new ROWCCMN20DO(); // to prevent NPEs below
      } else {
        SzCdOnCallCounty_ARRAY cdOnCallCounty_ARRAY = first_rowccmn20di.getSzCdOnCallCounty_ARRAY();
        String[] cdOnCallCounty = null;
        if (cdOnCallCounty_ARRAY != null) {
          cdOnCallCounty = cdOnCallCounty_ARRAY.getSzCdOnCallCounty();
        }
        audOnCallCounties(cReqFuncCd, first_rowccmn20di.getUlIdOnCall(),
                          cdOnCallCounty,
                          first_rowccmn20di.getSzCdRegion(), rowccmn20do.getUlIdOnCall(),
                          ccmn07si.getROWCCMN20DI_ARRAY());
      }
      ccmn07so.setROWCCMN20DO(rowccmn20do);
      // ccmnh8d
      if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd) &&
          ArchitectureConstants.Y.equals(first_rowccmn20di.getBIndOnCallFilled())) {
        // If cReqFuncCd is UPDATE or DELETE, and Filled = FILLED ('Y').
        //
        // CCMN21D and CCMN43D only need to be called if we are attempting to UPDATE an On-Call shift/block and there
        //   are employees assigned to that shift/block.
        // CCMN21D and CCMN43D and CCMN22D only need to be called if we are attempting to DELETE an On-Call shift/block
        //   and there are employees assigned to that shift/block.
        // We know if there are employees assigned to the shift/block by the 'Filled' column (bIndOnCallFilled).  For
        //   each employee assigned to that shift/block, a To-do needs to be sent to them alerting them of the
        //   modification/deletion of the on-call shift/block.
        // The CallCCMN21D Function will call both ccmn21d and ccmn43d.
        // If the End Date of the selected shift/block > the Current Date:
        //   That is, if (ArchInputStruct.usPageNbr == TO_DO_REQUIRED) then the CallCCMN21D Function needs to be called
        //   because the employees need to be sent to-do's telling them that the On-Call duty that they were scheduled
        //   for has been modified/deleted.
        // If the cReqFuncCd = DELETE then  Regardless of what the End Date of the selected shift/block, the
        //   CallCCMN22D Function needs to be called.
        if (archInputStruct.getUsPageNbr() == TO_DO_REQUIRED) {
          // Calling EmpOnCallLinkDAO CCMN21D
          List<Map> empOnCallList = empOnCallLinkDAO.findEmployeeOnCallLinkByIdOnCall(first_rowccmn20di.getUlIdOnCall(),
                                                                                      DateHelper.MAX_JAVA_DATE);
          if (empOnCallList != null && !empOnCallList.isEmpty()) {
            // Need to populate a Todo object to be passed into the next DAO
            for (Iterator<Map> it = empOnCallList.iterator(); it.hasNext();) {
              Map empOnCallMap = it.next();
              createTodo(cReqFuncCd, oldSchedule, (Integer) empOnCallMap.get("idPerson"),
                         first_rowccmn20di.getSzCdOnCallType(), first_rowccmn20di.getSzCdRegion(),
                         first_rowccmn20di.getSzCdOnCallMultOrAll(), first_rowccmn20di.getSzCdOnCallProgram(),
                         first_rowccmn20di.getDtDtOnCallStart(), first_rowccmn20di.getTmOnCallStart(),
                         first_rowccmn20di.getDtDtOnCallEnd(), first_rowccmn20di.getTmOnCallEnd());
            }
          }
        }
        if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
          // ccmn22d
          empOnCallLinkDAO.deleteEmpOnCallLinkByIdOnCall(first_rowccmn20di.getUlIdOnCall());
          // if you get 'SQL_NOT_FOUND' (that is, row not found, 1403)when attempting a delete that is
          // okay; it means that there were no employees associated with that ID_ON_CALL, which is okay.
        }
      }
    } else {
      // Need to display a message to the user that states an overlap would be created if the proposed
      // shift/block was added/modified. And that the proposed shift/block was NOT added/modified.
      if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        throw new ServiceException(Messages.MSG_CMN_OVERLAP_UPDATE);
      }
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        throw new ServiceException(Messages.MSG_CMN_OVERLAP_ADD);
      }
    }
    return ccmn07so;
  }

  private void createTodo(String cReqFuncCd, StringBuffer oldSchedule, int idPerson, String cdOnCallType,
                          String cdRegion, String cdOnCallMultOrAll, String cdOnCallProgram,
                          org.exolab.castor.types.Date dtOnCallStart, String tmOnCallStart,
                          org.exolab.castor.types.Date dtOnCallEnd, String tmOnCallEnd) {
    Todo todo = getInitializedTodo(idPerson);
    StringBuffer txtTodoDescSB = new StringBuffer(50);
    StringBuffer txtTodoLongDescSB = new StringBuffer(2 * oldSchedule.length());
    txtTodoLongDescSB.append("The following On-Call");
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      txtTodoDescSB.append("On-Call Deletion.");
      if (BLOCK.equals(cdOnCallType)) {
        txtTodoLongDescSB.append(" Block ");
      } else {
        txtTodoLongDescSB.append(" Shift ");
      }
      txtTodoLongDescSB.append("has been deleted; you are no longer scheduled for this duty.");
    } else {
      txtTodoDescSB.append("On-Call Modification.");
      txtTodoLongDescSB.append(oldSchedule.toString());
      txtTodoLongDescSB.append("  The new schedule is:");
    }
    String dtOnCallStartStr = FormattingHelper.formatDate(dtOnCallStart);
    String dtOnCallEndStr = FormattingHelper.formatDate(dtOnCallEnd);
    txtTodoLongDescSB.append("   Region: ");
    txtTodoLongDescSB.append(cdRegion);
    txtTodoLongDescSB.append("   County: ");
    txtTodoLongDescSB.append(cdOnCallMultOrAll);
    txtTodoLongDescSB.append("   Program: ");
    txtTodoLongDescSB.append(cdOnCallProgram);
    txtTodoLongDescSB.append("   Start Date: ");
    txtTodoLongDescSB.append(dtOnCallStartStr);
    txtTodoLongDescSB.append("   Start Time: ");
    txtTodoLongDescSB.append(tmOnCallStart);
    txtTodoLongDescSB.append("   End Date: ");
    txtTodoLongDescSB.append(dtOnCallEndStr);
    txtTodoLongDescSB.append("   End Time: ");
    txtTodoLongDescSB.append(tmOnCallEnd);
    todo.setTxtTodoLongDesc(txtTodoLongDescSB.toString());

    txtTodoDescSB.append(dtOnCallStartStr);
    txtTodoDescSB.append("  ");
    txtTodoDescSB.append(tmOnCallStart);
    txtTodoDescSB.append(" THRU ");
    txtTodoDescSB.append(
            dtOnCallEndStr);
    txtTodoDescSB.append("  ");
    txtTodoDescSB.append(tmOnCallEnd);
    todo.setTxtTodoDesc(txtTodoDescSB.toString());
    // ccmn43d.
    todoDAO.saveTodo(todo);
  }

  private void audOnCallCounties(String cReqFuncCd, int inputIdOnCall, String[] inputCdOnCallCounties,
                                 String inputCdRegion, int outputIdOnCall, ROWCCMN20DI_ARRAY rowccmn20di_array)
          throws ServiceException {
    // Preparing to Call ComplexOnCallCountyDAO, CCMNH8D
    OnCallCounty onCallCounty = new OnCallCounty();
    OnCall onCall = new OnCall();
    if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // The following are parameters for onCallCountyDAO CCMNH8D
      onCall.setIdOnCall(inputIdOnCall);
      onCallCounty.setCdOnCallRegion(inputCdRegion);
      onCallCounty.setOnCall(onCall);
      String[] cdOnCallCounties;
      cdOnCallCounties = inputCdOnCallCounties;
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        onCall.setIdOnCall(outputIdOnCall);
        onCallCounty.setOnCall(onCall);
        // ccmnh8d
        complexOnCallCountyDAO.saveOnCallCounty(onCallCounty, cdOnCallCounties);
      }
    } else {
      // cReqFuncCd is 'DELETE'
      for (Enumeration rowccmn20diEnum = rowccmn20di_array.enumerateROWCCMN20DI();
           rowccmn20diEnum.hasMoreElements();) {
        ROWCCMN20DI rowccmn20di = (ROWCCMN20DI) rowccmn20diEnum.nextElement();
        // ccmnh8d
        int rowsDeleted = onCallCountyDAO.deleteOnCallCounty(rowccmn20di.getUlIdOnCall());
        if (rowsDeleted < 1) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }
    }
  }

  private ROWCCMN20DO audOnCall(String cReqFuncCd, String cdOnCallType, String cdOnCallProgram, String cdRegion,
                                String cdOnCallCounty,
                                org.exolab.castor.types.Date dtOnCallStart, String startTime,
                                org.exolab.castor.types.Date dtOnCallEnd, String endTime,
                                ROWCCMN20DI_ARRAY rowccmn20di_array) throws ServiceException {
    ROWCCMN20DO rowccmn20do = new ROWCCMN20DO();
    for (Enumeration rowccmn20diEnum = rowccmn20di_array.enumerateROWCCMN20DI(); rowccmn20diEnum.hasMoreElements();) {
      ROWCCMN20DI rowccmn20di = (ROWCCMN20DI) rowccmn20diEnum.nextElement();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        // For 'Add' operation 'indOnCallFilled' field value is passed in as 'N'
        // ccmn20d
        OnCall onCall = onCallDAO.insertOnCall(cdOnCallProgram, cdOnCallType, cdRegion, cdOnCallCounty,
                                               DateHelper.toJavaDate(dtOnCallStart),
                                               DateHelper.toJavaDate(dtOnCallEnd), ArchitectureConstants.N);
        if (onCall == null) {
          return null;
        }
        rowccmn20do.setUlIdOnCall(onCall.getIdOnCall() != null ? onCall.getIdOnCall() : 0);
        rowccmn20do.setTsLastUpdate(onCall.getDtLastUpdate());
      } else {
        int idOnCall = rowccmn20di.getUlIdOnCall();
        Date dtLastUpdate = rowccmn20di.getTsLastUpdate();
        if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
          // ccmn20d
          //-- combine dates and times! ----------------------------------------
          Date jStartDate = DateHelper.toJavaDateSafe(dtOnCallStart, startTime);
          Date jEndDate = DateHelper.toJavaDateSafe(dtOnCallEnd, endTime);
          //--------------------------------------------------------------------
          Date dtLastUpdateReturn =
                  complexOnCallDAO.updateOnCall(cdOnCallProgram, cdOnCallType, jStartDate,
                                                jEndDate, idOnCall, dtLastUpdate);
          if (dtLastUpdateReturn == null) {
            return null;
          }
          rowccmn20do.setTsLastUpdate(dtLastUpdateReturn);
        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
          // ccmn20d
          if (0 == onCallDAO.deleteOnCall(idOnCall, dtLastUpdate)) {
            return null;
          }
        } else if (ServiceConstants.REQ_FUNC_CD_LIST.equals(cReqFuncCd)) {
          // Note that bIndOnCallFilled is never copied into the DAM input structure for LIST, so it is null here.
          // ccmn20d
          onCallDAO.updateOnCallByIdOnCallDtLastUpdate(null, idOnCall, dtLastUpdate);
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      }
    }
    return rowccmn20do;
  }

  /**
   * Note that this method modified the oldSchedule variable in order to pass back the old schedule description.
   *
   * @param oldSchedule              This StringBuffer will be rest and the old schedule descriptive string will be
   *                                 built using it.
   * @param cReqFuncCd
   * @param inputIdOnCall
   * @param inputCdOnCallType
   * @param inputCdOnCallProgram
   * @param inputCdRegion
   * @param inputCdOnCallCounty
   * @param inputCastorDtOnCallStart
   * @param inputTmOnCallStart
   * @param inputCastorDtOnCallEnd
   * @param inputTmOnCallEnd
   * @param szCdOnCallCounty_array
   * @return
   * @throws ServiceException
   */
  private String findNoOverlap(StringBuffer oldSchedule, String cReqFuncCd, int inputIdOnCall, String inputCdOnCallType,
                               String inputCdOnCallProgram, String inputCdRegion, String inputCdOnCallCounty,
                               org.exolab.castor.types.Date inputCastorDtOnCallStart,
                               String inputTmOnCallStart, org.exolab.castor.types.Date inputCastorDtOnCallEnd,
                               String inputTmOnCallEnd, SzCdOnCallCounty_ARRAY szCdOnCallCounty_array)
          throws ServiceException {
    // We default to overlap.
    String bDataAcsInd = ArchitectureConstants.Y;

    // Extract some useful values
    Date inputDtOnCallEnd = DateHelper.toJavaDateSafe(inputCastorDtOnCallEnd, inputTmOnCallEnd);
    Date inputDtOnCallStart = DateHelper.toJavaDateSafe(inputCastorDtOnCallStart, inputTmOnCallStart);

    // Parameters/input:  County and Program. Return/output: full row of the ON CALL table:
    //   every shift and block that exists for the County and Program specified.
    for (Enumeration szCdOnCallCountyEnum = szCdOnCallCounty_array.enumerateSzCdOnCallCounty();
         szCdOnCallCountyEnum.hasMoreElements();) {
      String[] szCdOnCallCounty = {(String) szCdOnCallCountyEnum.nextElement()};
      // ccmn16d
      List<Object[]> onCallInfoList =
              dynamicOnCallDAO.findOnCall(szCdOnCallCounty, inputCdOnCallProgram, null, null, null, 1, 250);
      // If there are no rows found matching the county and program then there is no overlap checking required.
      //   The proposed shift/block is the first entry for the county and program pair: by-pass the over-lap checking
      //   and add the proposed shift/block.
      if (onCallInfoList == null || onCallInfoList.isEmpty()) {
        continue;
      }

      // Pull various values out of the results from findOnCall() that are needed velow.
      int numOnCallRows = onCallInfoList.size();

      // This is guaranteed to exist because we know that we have at least 1 row.
      Object[] firstOnCallRow = onCallInfoList.get(0);
      String firstCdOnCall = (String) firstOnCallRow[2];
      Date firstDtOnCallStart = (Date) firstOnCallRow[3];
      Date firstDtOnCallEnd = (Date) firstOnCallRow[4];
      int firstIdOnCall = (Integer) firstOnCallRow[5];

      // The first will be the same as the last if we only have 1, but this is still valid.
      Object[] lastOnCallRow = onCallInfoList.get(numOnCallRows - 1);
      String lastCdOnCall = (String) lastOnCallRow[2];
      Date lastDtOnCallEnd = (Date) lastOnCallRow[4];
      Date lastDtOnCallStart = (Date) lastOnCallRow[3];
      int lastIdOnCall = (Integer) lastOnCallRow[5];

      // These can only be set if we have at least 2 rows
      Date secondDtOnCallStart = null;
      Date penultimateDtOnCallEnd = null;
      if (numOnCallRows > 1) {
        Object[] secondOnCallRow = onCallInfoList.get(1);
        secondDtOnCallStart = (Date) secondOnCallRow[3];

        Object[] penultimateOnCallRow = onCallInfoList.get(numOnCallRows - 2);
        penultimateDtOnCallEnd = (Date) penultimateOnCallRow[4];
      }

      boolean isUpdate = ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd);
      boolean isAdd = ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd);
      if ((isUpdate || isAdd) && onCallInfoList.size() <= MAX_ON_CALL_INFO_LIST_SIZE) {
        // We now have all of the shifts/blocks for the county/program pair (in the ROWCCMN16DO array) of the proposed
        //   shift/block to be added or modified.
        // First, if the requested function is UPDATE, or if the requested function is ADD and the ulRowQty !=
        //   maxOnCallInfoListSize: we need to check for over-laps. else (that is, if the requested functon is ADD and
        //   the ulRowQty == maxOnCallInfoListSize) the maximum number of shifts/blocks for the county/program pair
        //   already exist; return the MSG_ON_CALL_TOO_MANY message to the user.
        // To check for overlaps: We need to check if there exists an OnCall shift/block which contains any part of the
        //   proposed OnCall shift/block's time; and if so, do NOT add/modify the proposed OnCall shift/block as it
        //   would create an Overlap condition.
        //
        // The new shift/block (S/B) to be added/modified is either/or:
        //
        // Case 1: Completely contained prior to first start date/time already scheduled. If (new S/B's end date/time)
        //   > (First start date/time) Set no_overlap = false
        //
        // Case 2: Completely contained after the last start date/time already scheduled. If (new S/B's start date/time)
        //   < (Last end date/time) Set no_overlap = false
        // no_overlap will only be set to false if both Case 1 and Case 2's comparisons indicate that no_overlap should
        //   be set to false: If (new S/B's end date/time) > (First start date/time) AND If (new S/B's start date/time)
        //   < (Last end date/time) Set no_overlap = false
        //
        // Case 3: It's start and/or end date/time overlaps with the existing schedule. So we need to compare the new
        //   S/B with each current shift or block that is already scheduled. NOTE: If this is a MODIFY, need to compare
        //   ulIdOnCall of the new S/B with the existing S/B and skip the code for checking for over-lap between the
        //   new S/B and it's old version (because the old version will be over-written with the new S/B).
        //
        // There are four combinations of comparisons:
        //   1. block-block: the new item is a block and the old item is a block.
        //   2. block-shift: the new item is a block and the old item is a shift.
        //   3. shift-block: the new item is a shift and the old item is a block.
        //   4. shift-shift: the new item is a shift and the old item is a shift.
        //
        // If this service was called via the MODIFY push button, then we need to check the ID_ON_CALL of the to be
        //   modified shift/block so that we can skip the comparison of the proposed change with the existing
        //   shift/block with the same ID_ON_CALL's start and end dates/times.
        //
        // For Case 1 and Case 2, comparison is made with the first existing shift/block and the last existing
        //   shift/block, respectively. Three variables (skip_first, skip_last, and skip_matching) are initialized to
        //   FALSE. If the ID_ON_CALL of the to be modified shift/block matches the ID_ON_CALL of the first existing
        //   shift/block, then skip_first will be set to TRUE and Case 1 will be done using the second existing
        //   shift/block, rather than the first existing shift/block; If the ID_ON_CALL of the to be modified
        //   shift/block matches the ID_ON_CALL of the last existing shift/block, then skip_last will be set to TRUE
        //   and Case 2 will be done using the second-to-last existing shift/block, rather than the last existing
        //   shift/block. If the ID_ON_CALL of the to be modified shift/block matches the ID_ON_CALL of the i-th
        //   shift/block, then skip_matching will be set to TRUE and Case 3 will be skipped (for the i-th comparison, only).
        //
        // For Case 3, comparison is made with each ID_ON_CALL right before the comparisons are made (and the
        //   comparisons are skipped if the ID_ON_CALL's match).
        if (isUpdate && onCallInfoList.size() == 1 && firstIdOnCall == inputIdOnCall) {
          // If the RowQty == 1, that means there will be no over-lap; the user is requesting to change the only record
          //   that exists for the County/Program pair. Set DataAcsInd = TRUE
          bDataAcsInd = ArchitectureConstants.Y;
          // At this point, copy the 'old' data for the to-be-modified shift/block
          //   (to be put into the 43D ToDo LongDesc Text).
          createOldScheduleDesc(oldSchedule, firstCdOnCall, firstDtOnCallStart, firstDtOnCallEnd);
        } else {
          // if (UPDATE and RowQty > 1) or ADD
          boolean skip_first = false;
          boolean skip_last = false;
          if (isUpdate) {
            if (firstIdOnCall == inputIdOnCall) {
              skip_first = true;
            }
            // Comparing the idOnCall from the last row in the list
            if (lastIdOnCall == inputIdOnCall) {
              skip_last = true;
            }
          }
          // Case 1: Completely contained prior to first start date/time already scheduled.
          //   If (new S/B's end date/time) > (First start date/time) Set no_overlap = false
          //
          // no_overlap will only be set to false if both Case 1 and Case 2's comparisons indicate that no_overlap
          //   should be set to false:
          //   If (new S/B's end date/time) > (First start date/time)
          //   AND If (new S/B's start date/time) < (Last end date/time)
          //   Set no_overlap = false
          int rc_time1 = 0;
          int rc_time2 = 0;
          if (!skip_first) {
            rc_time1 = inputDtOnCallEnd.compareTo(firstDtOnCallStart);
          } else if (numOnCallRows > 1) {
            // skip_first == TRUE
            rc_time1 = inputDtOnCallEnd.compareTo(secondDtOnCallStart);
          }
          // Case 2: Completely contained after the last start date/time already scheduled.
          //   If (new S/B's start date/time) < (Last end date/time)
          //   Set no_overlap = false
          //
          // no_overlap will only be set to false if both Case 1 and Case 2's comparisons indicate that no_overlap
          //   should be set to false:
          //   If (new S/B's end date/time) > (First start date/time)
          //   AND If (new S/B's start date/time) < (Last end date/time)
          //   Set no_overlap = false
          if (!skip_last) {
            rc_time2 = inputDtOnCallStart.compareTo(lastDtOnCallEnd);
          } else if (numOnCallRows > 1) {
            // skip_last == TRUE
            // 2: new start date/time, old end date/time
            rc_time2 = inputDtOnCallStart.compareTo(penultimateDtOnCallEnd);
          }
          if (rc_time1 > 0 && rc_time2 < 0) {
            // set no_overlap to FALSE
            bDataAcsInd = ArchitectureConstants.N;
          } else {
            // no_overlap is TRUE
            if (skip_first) {
              //  at this point, copy the 'old' data for the to-be-modified shift/block
              // (to be put into the 43D ToDo LongDesc Text).
              createOldScheduleDesc(oldSchedule, firstCdOnCall, firstDtOnCallStart, firstDtOnCallEnd);
            }
            if (skip_last) {
              // at this point, copy the 'old' data for the to-be-modified shift/block
              // (to be put into the 43D ToDo LongDesc Text).
              createOldScheduleDesc(oldSchedule, lastCdOnCall, lastDtOnCallStart, lastDtOnCallEnd);
            }
          }
        }
        // Check if no_overlap is FALSE and if so, Case 1 and Case 2 conditions indicated an overlap exists.
        // Need to check Case 3 conditions: If no_overlap is TRUE, the proposed shift/block may be added,
        //   no further processing is necessary in the CallCCMN16D function.
        if (ArchitectureConstants.N.equals(bDataAcsInd)) {
          // Re-initialize no_overlap (ArchInputStruct.bDataAcsInd) to TRUE; the moment that it is found to be FALSE
          //   within the Case 3 logic, there is no need to continue the comparisons.
          bDataAcsInd = ArchitectureConstants.Y;
          boolean skip_matching = false;
          boolean skip_this_one = false;
          for (Iterator<Object[]> it = onCallInfoList.iterator();
               it.hasNext() && ArchitectureConstants.Y.equals(bDataAcsInd);) {
            // Pull values that we need from the current row here.
            Object[] currentRow = it.next();
            String currentCdOnCallType = (String) currentRow[2];
            Date currentDtOnCallStart = (Date) currentRow[3];
            Date currentDtOnCallEnd = (Date) currentRow[4];
            int currentIdOnCall = (Integer) currentRow[5];

            // If in MODIFY, and the current ID_ON_CALL is the same ID_ON_CALL as the shift/block to be modified, then
            //   set skip_this_one to TRUE so that we skip the current comparison. and set skip_matching to TRUE so
            //   that we do not have to continue to compare the ID_ON_CALLs of the proposed shift/block and the
            //   remaining shift/blocks for the county/program pair.
            if (!skip_matching && isUpdate) {
              if (currentIdOnCall == inputIdOnCall) {
                skip_matching = true;
                skip_this_one = true;
              }
            }
            if (!skip_this_one) {
              // Case 3: It's start and/or end date/time overlaps with the existing schedule. So we need to compare the
              //   new S/B with each current shift or block that is already scheduled.
              // NOTE: If this is a MODIFY, need to compare ulIdOnCall of the new S/B with the existing S/B and skip
              //   the code for checking for over-lap between the new S/B and it's old version (because the old version
              //   will be over-written with the new S/B).

              // Case 3: First (of four) comparison combinations:
              // 1. block-block: the new item is a block and the old item is a block.
              // if [ (new block) and (old block) ]
              // if [ (old_start date/time <= new_start date/time < old_end date/time)
              //
              // or (new_start date/time <= old_start date/time < new_end date/time)
              //
              // or ( (new_start date/time > old_start date/time) AND (new_end date/time <= old_end date/time) )
              //
              // or ( (old_start date/time > new_start date/time) AND (old_end date/time <= new_end date/time) ) ]
              //
              // or ( (new_start date/time <= old_start date/time) AND (new_end date/time >= old_end date/time) ) ]
              //
              // or ( (old_start date/time <= new_start date/time) AND (old_end date/time >= new_end date/time) ) ]
              //
              // then OVERLAP EXISTS: Set no overlap = false
              if (BLOCK.equals(inputCdOnCallType) && BLOCK.equals(currentCdOnCallType)) {
                // 1: old start date/time, new start date/time
                int rc_time1 = currentDtOnCallStart.compareTo(inputDtOnCallStart);
                // 2: new end date/time, old end date/time
                int rc_time2 = inputDtOnCallStart.compareTo(currentDtOnCallEnd);
                if (rc_time1 <= 0 && rc_time2 < 0) {
                  bDataAcsInd = ArchitectureConstants.N;
                }
                if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                  // 3: old start date/time, new start date/time
                  int rc_time3 = inputDtOnCallStart.compareTo(currentDtOnCallStart);
                  // 4: old start date/time, new end date/time
                  int rc_time4 = currentDtOnCallStart.compareTo(inputDtOnCallEnd);
                  if (rc_time3 <= 0 && rc_time4 < 0) {
                    bDataAcsInd = ArchitectureConstants.N;
                  }
                }
                if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                  // 5: new start date/time, old start date/time
                  rc_time1 = inputDtOnCallStart.compareTo(currentDtOnCallStart);
                  // 6: new end date/time, old end date/time
                  rc_time2 = inputDtOnCallEnd.compareTo(currentDtOnCallEnd);
                  // check if (new start date/time > old start date/time) and ( new end date/time <= old end date/time)
                  if (rc_time1 > 0 && rc_time2 <= 0) {
                    bDataAcsInd = ArchitectureConstants.N;
                  }
                }
                if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                  // 7: old start date/time, new start date/time
                  int rc_time3 = currentDtOnCallStart.compareTo(inputDtOnCallStart);
                  // 8: old end date/time, new end date/time
                  int rc_time4 = currentDtOnCallEnd.compareTo(inputDtOnCallEnd);
                  if (rc_time3 > 0 && rc_time4 <= 0) {
                    bDataAcsInd = ArchitectureConstants.N;
                  }
                }
                if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                  // 9: new start date/time, old start date/time
                  rc_time1 = inputDtOnCallStart.compareTo(currentDtOnCallStart);
                  // 10: new end date/time, old end date/time
                  rc_time2 = inputDtOnCallEnd.compareTo(currentDtOnCallEnd);
                  if (rc_time1 <= 0 && rc_time2 >= 0) {
                    bDataAcsInd = ArchitectureConstants.N;
                  }
                }
                if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                  // 11: old start date/time, new start date/time
                  int rc_time3 = currentDtOnCallStart.compareTo(inputDtOnCallStart);
                  // 12: old end date/time, new end date/time
                  int rc_time4 = currentDtOnCallEnd.compareTo(inputDtOnCallEnd);
                  if (rc_time3 <= 0 && rc_time4 >= 0) {
                    bDataAcsInd = ArchitectureConstants.N;
                  }
                }
              } else if (BLOCK.equals(inputCdOnCallType) && SHIFT.equals(currentCdOnCallType)) {
                // Case 2:
                // Second (of four) comparison combinations:
                // 2. block-shift: the new item is a block and the old item is a shift.
                //
                // else if [ (new block) and (old shift) ]
                // if {[shift_start date/time <= block_start date/time < shift_end date/time]
                //
                // or [shift_start date/time < block_end date/time <= shift_end date/time]
                //
                // or [(block_start date/time <= shift_start date/time)
                // AND (block_end date/time >= shift_end date/time)] }
                //
                // then OVERLAP EXISTS: Set no overlap = false

                // 13: shift start date/time, block start date/time
                int rc_time1 = currentDtOnCallStart.compareTo(inputDtOnCallStart);
                // 14: block end date/time, shift end date/time
                int rc_time2 = inputDtOnCallStart.compareTo(currentDtOnCallEnd);
                if (rc_time1 <= 0 && rc_time2 < 0) {
                  bDataAcsInd = ArchitectureConstants.N;
                }
                if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                  // 15: shift start date/time, block start date/time
                  int rc_time3 = currentDtOnCallStart.compareTo(inputDtOnCallEnd);
                  // 16: block end date/time, shift end date/time
                  int rc_time4 = inputDtOnCallEnd.compareTo(currentDtOnCallEnd);
                  if (rc_time3 < 0 && rc_time4 <= 0) {
                    bDataAcsInd = ArchitectureConstants.N;
                  }
                }
                if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                  // 17: block start date/time, shift start date/time
                  rc_time1 = inputDtOnCallStart.compareTo(currentDtOnCallStart);
                  // 18: block end date/time, shift end date/time
                  rc_time2 = inputDtOnCallEnd.compareTo(currentDtOnCallEnd);
                  if (rc_time1 <= 0 && rc_time2 >= 0) {
                    bDataAcsInd = ArchitectureConstants.N;
                  }
                }
              } else if (SHIFT.equals(inputCdOnCallType) && BLOCK.equals(currentCdOnCallType)) {
                // Case 3:
                // Third (of four) comparison combinations:
                // 3. shift-block: the new item is a shift and the old item is a block.
                //
                // else if [ (new shift) and (old block) ]
                // if {[shift_start date/time <= block_start date/time < shift_end date/time]
                //
                // or [shift_start date/time < block_end date/time <= shift_end date/time]
                //
                // or [(block_start date/time <= shift_start date/time)
                // AND (block_end date/time >= shift_end date/time)] }
                //
                // then OVERLAP EXISTS: Set no overlap = false

                // Have to check if new end date/time <= old start date/time or
                //   new start date/time >= old end date/time.
                // If either of the above conditions are met, skip the comparison logic that follows.

                // 19: shift start date/time, block start date/time
                int rc_time5 = inputDtOnCallStart.compareTo(currentDtOnCallEnd);
                // 20: block start date/time, shift end date/time
                int rc_time6 = inputDtOnCallEnd.compareTo(currentDtOnCallStart);
                if (rc_time5 >= 0 || rc_time6 <= 0) {
                  // Do not run any further comparisons for this ID ON CALL
                  bDataAcsInd = ArchitectureConstants.Y;
                } else {
                  // 19: block start date/time, shift start date/time
                  int rc_time3 = inputDtOnCallStart.compareTo(currentDtOnCallStart);
                  // 20: block start date/time, shift end date/time
                  int rc_time4 = currentDtOnCallStart.compareTo(inputDtOnCallEnd);
                  // check if (shift start date/time <= block start date/time)
                  //   and (block start date/time < shift end date/time)
                  if (rc_time3 <= 0 && rc_time4 < 0) {
                    bDataAcsInd = ArchitectureConstants.N;
                  }
                  if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                    // 21: shift start date/time, block end date/time
                    int rc_time1 = inputDtOnCallStart.compareTo(currentDtOnCallEnd);
                    // 22: block end date/time, shift end date/time
                    int rc_time2 = currentDtOnCallEnd.compareTo(inputDtOnCallEnd);
                    // check if (shift start date/time < block end date/time)
                    //   and (block end date/time <= shift end date/time)
                    if (rc_time1 < 0 && rc_time2 <= 0) {
                      bDataAcsInd = ArchitectureConstants.N;
                    }
                  }
                  if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                    // 23:  block start date/time, shift start date/time
                    rc_time3 = currentDtOnCallStart.compareTo(inputDtOnCallStart);
                    // 24: block end date/time, shift end date/time
                    rc_time4 = currentDtOnCallEnd.compareTo(inputDtOnCallEnd);
                    if (rc_time3 <= 0 && rc_time4 >= 0) {
                      bDataAcsInd = ArchitectureConstants.N;
                    }
                  }
                }
              } else if (SHIFT.equals(inputCdOnCallType) && SHIFT.equals(currentCdOnCallType)) {
                // Case 4:
                // Fourth (of four) comparison combinations:
                // 4. shift-shift: the new item is a shift and the old item is a shift.
                //
                // else if [ (new shift) and (old shift) ]
                // if { [old_start_date <= new_start_date <= old_end_date]
                // or [old_start_date <= new_end_date <= old_end_date]
                // or [new_start_date <= old_start_date <= new_end_date]
                // or [new_start_date <= old_end_date <= new_end_date] }
                // { if one of the above comparisons is true, this means that the dates overlap, now check the times
                //   if (old_end_time < old_start_time)
                //   {
                //     temp1_start_time = 0; we need 2 blocks
                //     temp1_end_time = old_end_time;
                //     temp2_start_time = old_start_time;
                //     temp2_end_time = 24;
                //     if { [temp1_start_time <= new_start_time < temp1_end_time]
                //       or [new_start_time <= temp1_start_time < new_end_time]
                //       or [temp2_start_time <= new_start_time < temp2_end_time]
                //       or [new_start_time <= temp2_start_time < new_end_time] }
                //         then OVERLAP EXISTS;
                //         set ArchInputStruct.bDataAcsInd = FALSE;
                //   }
                //   if [new_end_time < new_start_time]
                //   {
                //     temp1_start_time = 0 we need 2 blocks
                //     temp1_end_time = old_end_time
                //     temp2_start_time = old_start_time
                //     temp2_end_time = 24
                //     if { [temp1_start_time <= old_start_time < temp1_end_time]
                //       or [old_start_time <= temp1_start_time < old_end_time]
                //       or [temp2_start_time <= old_start_time < temp2_end_time]
                //       or [old_start_time <= temp2_start_time < old_end_time] }
                //       then OVERLAP EXISTS;
                //       set ArchInputStruct.bDataAcsInd = FALSE;
                //   }
                //

                // Have to check if new end date/time <= old start date/time
                //   or new start date/time >= old end date/time.
                // If either of the above conditions are met, skip the comparison logic that follows.
                // 19: shift start date/time, block start date/time
                int rc_time5 = inputDtOnCallStart.compareTo(currentDtOnCallEnd);
                // 20: block start date/time, shift end date/time
                int rc_time6 = inputDtOnCallEnd.compareTo(currentDtOnCallStart);
                if (rc_time5 >= 0 || rc_time6 <= 0) {
                  // Do not run any further comparisons for this ID ON CALL
                  bDataAcsInd = ArchitectureConstants.Y;
                } else {
                  org.exolab.castor.types.Date currentCastorDtOncallStart =
                          DateHelper.toCastorDate(currentDtOnCallStart);
                  org.exolab.castor.types.Date currentCastorDtOnCallEnd = DateHelper.toCastorDate(currentDtOnCallEnd);
                  // 25: old_start_date <= new_start_date
                  // 26: new start date <= old end date
                  if (!DateHelper.isAfter(currentCastorDtOncallStart, inputCastorDtOnCallStart) &&
                      !DateHelper.isAfter(inputCastorDtOnCallStart, currentCastorDtOnCallEnd)) {
                    bDataAcsInd = ArchitectureConstants.N;
                  }
                  if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                    // 27: old start date <= new end date
                    // 28: new end date <= old end date
                    if (!DateHelper.isAfter(currentCastorDtOncallStart, inputCastorDtOnCallEnd) &&
                        !DateHelper.isAfter(inputCastorDtOnCallEnd, currentCastorDtOnCallEnd)) {
                      bDataAcsInd = ArchitectureConstants.N;
                    }
                  }
                  if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                    // 29: new start date <= old start date
                    // 30: old start date <= new end date
                    if (!DateHelper.isAfter(inputCastorDtOnCallStart, currentCastorDtOncallStart) &&
                        !DateHelper.isAfter(currentCastorDtOncallStart, inputCastorDtOnCallEnd)) {
                      bDataAcsInd = ArchitectureConstants.N;
                    }
                  }
                  if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                    // 31: new start date <= old end date
                    // 32: old end date <= new end date
                    if (!DateHelper.isAfter(inputCastorDtOnCallStart, currentCastorDtOnCallEnd) &&
                        !DateHelper.isAfter(currentCastorDtOnCallEnd, inputCastorDtOnCallEnd)) {
                      bDataAcsInd = ArchitectureConstants.N;
                    }
                  }
                  if (ArchitectureConstants.N.equals(bDataAcsInd)) {
                    // Make the date information the same for the following comparisons.
                    Date currentNoDateTmOnCallEnd = normalizeDate(currentDtOnCallEnd);
                    Date currentNoDateTmOnCallStart = normalizeDate(currentDtOnCallStart);
                    Date inputNoDateTmOnCallEnd = normalizeDate(inputDtOnCallEnd);
                    Date inputNoDateTmOnCallStart = normalizeDate(inputDtOnCallStart);

                    //if ArchInputStruct.bDataAcsInd == FALSE it means that the dates overlap,
                    //   Now we need to check the times.
                    // First, re-initialize bDataAcsInd back to TRUE
                    bDataAcsInd = ArchitectureConstants.Y;
                    // 33: old_end_time < old_start_time
                    int rc_time1 = currentNoDateTmOnCallEnd.compareTo(currentNoDateTmOnCallStart);
                    if (rc_time1 < 0) {
                      // 34: new_end_time < new_start_time
                      int rc_time2 = inputNoDateTmOnCallEnd.compareTo(inputNoDateTmOnCallStart);
                      if (rc_time2 < 0) {
                        // If both old end time < old start time and new end time < new start time,
                        //   there is an overlap; set DataAcsInd = FALSE.
                        bDataAcsInd = ArchitectureConstants.N;
                      }
                      if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                        // If we get to this point, it means that:
                        //   old end time < old start time
                        //   new end time >= new start time
                        // Use two temporary times (temp1_start_time and temp2_end_time) to make old end time and old
                        //   start time into two blocks. Check if new_start_time falls within the first block or if
                        //   new_end_time falls within the second block: if either of those are TRUE, an OVERLAP exists.
                        // if { [temp1_start_time <= new_start_time < temp1_end_time]
                        //   or [temp2_start_time < new_end_time <= temp2_end_time]
                        //   then OVERLAP EXISTS; set ArchInputStruct.bDataAcsInd = FALSE;
                        // if { [temp1_start_time <= new_start_time < temp1_end_time]
                        // 35: temp1_start_time <= new_start_time
                        int rc_time3 = TEMP_1_START_TIME.compareTo(inputNoDateTmOnCallStart);
                        // 36: new_start_time < temp1_end_time
                        int rc_time4 = inputNoDateTmOnCallStart.compareTo(currentNoDateTmOnCallEnd);
                        if (rc_time3 <= 0 && rc_time4 < 0) {
                          bDataAcsInd = ArchitectureConstants.N;
                        }
                      }
                      if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                        // or [temp2_start_time < new_end_time <= temp2_end_time]
                        // 37: temp2_start_time < new_end_time
                        rc_time1 = currentNoDateTmOnCallStart.compareTo(inputNoDateTmOnCallEnd);
                        // 38: new_end_time <= temp2_end_time
                        rc_time2 = inputNoDateTmOnCallEnd.compareTo(TEMP_2_END_TIME);
                        //check if (temp2_start_time < new_end_time) and (new_end_time <= temp2_end_time)
                        if (rc_time1 < 0 && rc_time2 <= 0) {
                          bDataAcsInd = ArchitectureConstants.N;
                        }
                      }
                    } else {
                      // old end time >= old start time
                      // 39: new_end_time >= new_start_time
                      int rc_time3 = inputNoDateTmOnCallEnd.compareTo(inputNoDateTmOnCallStart);
                      if (rc_time3 >= 0) {
                        // If we get to this point, it means that
                        //   old end time >= old start time
                        //   new end time >= new start time
                        // Need to compare the following:
                        // If (new start time <= old start time < new end time)
                        // or (new start time < old end time <= new end time)
                        // or [ (new start time <= old start time <= new end time)
                        //   && (new start time <= old end time <= new end time) ]
                        // then OVERLAP EXISTS; set ArchInputStruct.bDataAcsInd = FALSE;
                        // else
                        // If (old start time <= new start time < old end time)
                        // or (old start time < new end time <= old end time)
                        // or [ (old start time <= new start time <= old end time)
                        //   && (old start time <= new end time <= old end time) ]
                        // then OVERLAP EXISTS; set ArchInputStruct.bDataAcsInd = FALSE;

                        // 40: new start time <= old start time
                        rc_time1 = inputNoDateTmOnCallStart.compareTo(currentNoDateTmOnCallStart);
                        // 41: old start time <= new end time
                        int rc_time2 = currentNoDateTmOnCallStart.compareTo(inputNoDateTmOnCallEnd);
                        if (rc_time1 <= 0 && rc_time2 < 0) {
                          bDataAcsInd = ArchitectureConstants.N;
                        }
                        if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                          // 42: new start time <= old end time
                          rc_time3 = inputNoDateTmOnCallStart.compareTo(currentNoDateTmOnCallEnd);
                          // 43: old end time <= new end time
                          int rc_time4 = currentNoDateTmOnCallEnd.compareTo(inputNoDateTmOnCallEnd);
                          if (rc_time3 < 0 && rc_time4 <= 0) {
                            bDataAcsInd = ArchitectureConstants.N;
                          }
                        }
                        // or [ (new start time <= old start time <= new end time) * &&
                        //   (new start time <= old end time <= new end time) ]
                        if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                          // 44: new start time <= old start time
                          rc_time1 = inputNoDateTmOnCallStart.compareTo(currentNoDateTmOnCallStart);
                          // 45: old start time <= new end time
                          rc_time2 = currentNoDateTmOnCallStart.compareTo(inputNoDateTmOnCallEnd);
                          // 46: new start time <= old end time
                          rc_time3 = inputNoDateTmOnCallStart.compareTo(currentNoDateTmOnCallEnd);
                          // 47: old end time <= new end time
                          int rc_time4 = currentNoDateTmOnCallEnd.compareTo(inputNoDateTmOnCallEnd);
                          // check if (new start time <= old start time) * and (old
                          // start time <= new end time) * and (new start time <= old end
                          // time) * and (old end time <= new end time)
                          if (rc_time1 <= 0 && rc_time2 <= 0 && rc_time3 <= 0 && rc_time4 <= 0) {
                            bDataAcsInd = ArchitectureConstants.N;
                          }
                        }
                        // If (old start time <= new start time < old end time)
                        // or (old start time < new end time <= old end time)
                        // or [ (old start time <= new start time <= old end time)
                        // && (old start time <= new end time <= old end time) ]
                        if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                          // 48: old start time <= new start time
                          rc_time1 = currentNoDateTmOnCallStart.compareTo(inputNoDateTmOnCallStart);
                          // 49: new start time <= old end time
                          rc_time2 = inputNoDateTmOnCallStart.compareTo(currentNoDateTmOnCallEnd);
                          //check if (old start time <= new start time) * and (new
                          //start time < old end time)
                          if (rc_time1 <= 0 && rc_time2 < 0) {
                            bDataAcsInd = ArchitectureConstants.N;
                          }
                        }
                        if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                          // 50: old start time <= new end time
                          rc_time3 = currentNoDateTmOnCallStart.compareTo(inputNoDateTmOnCallEnd);
                          // 51: new end time <= old end time
                          int rc_time4 = inputNoDateTmOnCallEnd.compareTo(currentNoDateTmOnCallEnd);
                          // check if (new start time < old end time) * and (old end
                          // time <= new end time)
                          if (rc_time3 < 0 && rc_time4 <= 0) {
                            bDataAcsInd = ArchitectureConstants.N;
                          }
                        }
                        // or [ (old start time <= new start time <= old end time)
                        //   && old start time <= new end time <= old end time) ]
                        if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                          // 52: old start time <= new start time
                          rc_time1 = currentNoDateTmOnCallStart.compareTo(inputNoDateTmOnCallStart);
                          // 53:  new start time <= old end time
                          rc_time2 = inputNoDateTmOnCallStart.compareTo(currentNoDateTmOnCallEnd);
                          // 54: old start time <= new end time
                          rc_time3 = currentNoDateTmOnCallStart.compareTo(inputNoDateTmOnCallEnd);
                          // 55: new end time <= old end time
                          int rc_time4 = inputNoDateTmOnCallEnd.compareTo(currentNoDateTmOnCallEnd);
                          // check if (old start time <= new start time)
                          // and (new start time <= old end time)
                          // and (old start time <= new end time)
                          // and (new end time <= old end time)
                          if (rc_time1 <= 0 && rc_time2 <= 0 && rc_time3 <= 0 && rc_time4 <= 0) {
                            bDataAcsInd = ArchitectureConstants.N;
                          }
                        }
                      } else {
                        // If we get to this point, it means that:
                        //   old end time >= old start time
                        //   new end time < new start time
                        // Use two temporary times (temp1_start_time and temp2_end_time) to make new end time and new
                        //   start time into two blocks. Check if old_start_time falls within the first block or if
                        //   old_end_time falls within the second block: if either of those are TRUE, an OVERLAP exists.
                        // if { [temp1_start_time <= old_start_time < temp1_end_time]
                        //   or [temp2_start_time < old_end_time <= temp2_end_time]
                        // then OVERLAP EXISTS; set ArchInputStruct.bDataAcsInd = FALSE;

                        // if { [temp1_start_time <= old_start_time < temp1_end_time]
                        // 56: temp1_start_time <= old_start_time
                        rc_time1 = TEMP_1_START_TIME.compareTo(currentNoDateTmOnCallStart);
                        // 57: old_end_time <= temp2_end_time
                        int rc_time2 = currentNoDateTmOnCallStart.compareTo(inputNoDateTmOnCallEnd);
                        // check if (temp1_start_time <= old_start_time) * and
                        // (old_start_time < temp1_end_time)
                        if (rc_time1 <= 0 && rc_time2 < 0) {
                          bDataAcsInd = ArchitectureConstants.N;
                        }
                        if (ArchitectureConstants.Y.equals(bDataAcsInd)) {
                          // or [temp2_start_time < old_end_time <= temp2_end_time]
                          // 58: temp2_start_time < old_end_time
                          rc_time1 = inputNoDateTmOnCallStart.compareTo(currentNoDateTmOnCallEnd);
                          /* 59: old_end_time <= temp2_end_time */
                          rc_time2 = currentNoDateTmOnCallEnd.compareTo(TEMP_2_END_TIME);
                          // check if (temp2_start_time < old_end_time)
                          //   and (old_end_time <= temp2_end_time)
                          if (rc_time1 < 0 && rc_time2 <= 0) {
                            bDataAcsInd = ArchitectureConstants.N;
                          }
                        }
                      }
                    }
                  }
                }
              }
            } else {
              // * If we get to this 'else' statement, * it means that skip_this_one was TRUE and we
              // just skipped comparing the proposed shift/block with the current shift/block (and
              // we are in MODIFY mode); need to set skip_this_one back to FALSE so that we compare
              // the proposed shift/block which each of the remaining shifts/blocks for the
              // county/program pair. * * 23Mar95: at this point, copy the 'old' data for the
              // to-be-modified shift/block * (to be put into the 43D ToDo LongDesc Text).
              skip_this_one = false;
              createOldScheduleDesc(oldSchedule, currentCdOnCallType, currentDtOnCallStart, currentDtOnCallEnd);
            }
          }
        }
      } else {
        // Need to display a message to the user that states that the maximum number of shifts/blocks for the
        //   county/program pair already exist, and that the proposed shift/block was NOT added. To do this: set the
        //   explan_code equal to the MSG that should be sent.

        // Note: There is a message here in the C: Messages.MSG_CMN_ON_CALL_TOO_MANY; it is NOT an exception becuase
        //   the return code is overwritten before it can be thrown.
        break;
      }
      if (ArchitectureConstants.N.equals(bDataAcsInd)) {
        break;
      }
    }
    return bDataAcsInd;
  }

  private void createOldScheduleDesc(StringBuffer oldSchedule, String cdOnCall, Date dtOnCallStart, Date dtOnCallEnd) {
    oldSchedule.setLength(0); // clear the string buffer
    if (BLOCK.equals(cdOnCall)) {
      oldSchedule.append(" Block ");
    } else {
      oldSchedule.append(" Shift ");
    }
    oldSchedule.append("has been modified; the old schedule was: ");
    oldSchedule.append("  Start Date: ");
    oldSchedule.append(FormattingHelper.formatDate(dtOnCallStart));
    oldSchedule.append("  Start Time: ");
    oldSchedule.append(FormattingHelper.formatTime(dtOnCallStart));
    oldSchedule.append("  End Date: ");
    oldSchedule.append(FormattingHelper.formatDate(dtOnCallEnd));
    oldSchedule.append("  End Time: ");
    oldSchedule.append(FormattingHelper.formatTime(dtOnCallEnd));
  }

  private Date normalizeDate(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    // Use 1/1/2000 as a generic date to eliminate it as an element in the comparisons.
    cal.set(2000, 0, 1);
    return cal.getTime();
  }

  private Todo getInitializedTodo(Integer idPerson) {
    Todo todo = new Todo();
    Person persCreator = (Person) getPersistentObject(Person.class, idPerson);
    Person persAssigned = (Person) getPersistentObject(Person.class, idPerson);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setPersonByIdTodoPersCreator(persCreator);
    todo.setDtTodoCreated(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoCompleted(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoDue(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoTaskDue(null);
    todo.setPersonByIdTodoPersAssigned(persAssigned);
    todo.setTxtTodoLongDesc("The following On-Call");
    return todo;
  }
  
  private boolean proposedScheduleOverlaps(ROWCCMN20DI rowccmn20di){
    boolean overlap = false;
    
    int newIdOnCall = rowccmn20di.getUlIdOnCall();
    Date newStartDateAndTime = DateHelper.toJavaDateSafe(rowccmn20di.getDtDtOnCallStart().toDate(), rowccmn20di.getTmOnCallStart());
    Date newEndDateAndTime = DateHelper.toJavaDateSafe(rowccmn20di.getDtDtOnCallEnd().toDate(), rowccmn20di.getTmOnCallEnd());
    
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
            Integer id = (Integer) schedule[5];
            
            if(id.intValue() !=  newIdOnCall){
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
              
              //STGAP00007499 - called new compareTo method to accurately compare date and time info
              if (existingStartDate.compareTo(newEndDateAndTime) < 0 && newStartDateAndTime.compareTo(existingEndDate) < 0) {
                if (this.compareTo(existingStartDate, newEndTime, existingEndDate, newStartTime)) {
                  overlap = true;
                  break;
                }
              }
            }
          }
        }
      }
      
      fakePageNbr++;
    } while(schedules.isMoreDataAvailable());
    
    return overlap;
  }
  
 /* @SuppressWarnings("static-access")
  public Boolean compare(Date date, String dateString) {
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
  
  //STGAP00007499 - created new method to accurately compare time info passed in
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
    
   /* if ((existingSHours < newSHours && existingEHours > newSHours)
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