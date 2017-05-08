package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicWorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpOnCallLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OnCallCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveAssign;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO_ARRAY;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveAssignImpl extends BaseServiceImpl implements RetrieveAssign {

  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  private EmpOnCallLinkDAO empOnCallLinkDAO = null;
  private StageDAO stageDAO = null;
  private OnCallCountyDAO onCallCountyDAO = null;
  private WorkloadDAO workloadDAO = null;
  private DynamicWorkloadDAO dynamicWorkloadDAO = null;

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setEmpOnCallLinkDAO(EmpOnCallLinkDAO empOnCallLinkDAO) {
    this.empOnCallLinkDAO = empOnCallLinkDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setOnCallCountyDAO(OnCallCountyDAO onCallCountyDAO) {
    this.onCallCountyDAO = onCallCountyDAO;
  }

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public void setDynamicWorkloadDAO(DynamicWorkloadDAO dynamicWorkloadDAO) {
    this.dynamicWorkloadDAO = dynamicWorkloadDAO;
  }
  
  public CCMN80SO retrieveEmployeeAssignInfo(CCMN80SI ccmn80si) throws ServiceException {
    CCMN80SO ccmn80so = new CCMN80SO();
    if (ccmn80si.getBIndStaffSearch() == false) {
      // This DAM will retrieve a row from the Workload table for each Id_Stage passed in.  If no row is found for
      //   an Id_Stage an empty ccmn80so is returned.
      int[] idStages = ccmn80si.getUlIdStage_ARRAY().getUlIdStage();
      // csec84d
      if (!findStagesOnWorkload(idStages)) {
        // This is explicitly not an error in the service code (rc is deliberately reset to FND_SUCCESS); though,
        //   the explain_code is set to MSG_CMN_NOT_ON_WKLD in this case, which seems odd.
        return ccmn80so;
      }

      String cReqFuncCd = ccmn80si.getArchInputStruct().getCReqFuncCd();
      if (FULL_UNITS_VIEW.equals(cReqFuncCd)) {
        // ccmn27d
        AvailStaffGroup_ARRAY availStaffGroup_Array = findUnitEmpLinkInfo(ccmn80si.getUlIdUnit());
        if(availStaffGroup_Array == null) {
          availStaffGroup_Array = new AvailStaffGroup_ARRAY();
          ccmn80so.setExplan_code(Messages.MSG_CMN_NO_STAFF_IN_UNIT);
        }
        ccmn80so.setAvailStaffGroup_ARRAY(availStaffGroup_Array);
      } else if (ON_CALL_VIEW.equals(cReqFuncCd)) {
        Date now = new Date();
        String cdOnCallProgram = ccmn80si.getSzCdOnCallProgram();
        String szCdOnCallCounty = ccmn80si.getSzCdOnCallCounty();
        // ccmn79d
        ROWCCMN79DO_ARRAY rowccmn79do_array = findOnCallCountyInfo(cdOnCallProgram, szCdOnCallCounty, now);
        if (rowccmn79do_array.getUlRowQty() != 0) {
          ccmn80so.setROWCCMN79DO_ARRAY(rowccmn79do_array);
          ROWCCMN79DO rowccmn79do = rowccmn79do_array.getROWCCMN79DO(0);
          int idOnCall = rowccmn79do.getUlIdOnCall();
          ccmn80so.setAvailStaffGroup_ARRAY(findEmpOnCallLinkInfo(idOnCall));
          Enumeration rowccmn79do_enum = rowccmn79do_array.enumerateROWCCMN79DO();
          rowccmn79do = (ROWCCMN79DO) rowccmn79do_enum.nextElement();
          while (rowccmn79do_enum.hasMoreElements()) {
            rowccmn79do = (ROWCCMN79DO) rowccmn79do_enum.nextElement();
            idOnCall = rowccmn79do.getUlIdOnCall();
            // ccmn28d
            //ccmn80so.setAvailStaffGroup_ARRAY(findEmpOnCallLinkInfo(idOnCall));
            AvailStaffGroup_ARRAY availStaffGroup_array = findEmpOnCallLinkInfo(idOnCall);
            if (availStaffGroup_array != null) {
              Enumeration availStaffGroup_enum = availStaffGroup_array.enumerateAvailStaffGroup();
              while (availStaffGroup_enum.hasMoreElements()) {
                AvailStaffGroup availStaffGroup = (AvailStaffGroup) availStaffGroup_enum.nextElement();
                ccmn80so.getAvailStaffGroup_ARRAY().addAvailStaffGroup(availStaffGroup);
              }
            }
            // Need to find out if the current date/time falls under non-business hours (anytime other than 8am thru 5pm,
            //   Monday thru Friday), and if so, Call 79d and 28d again to get the Next Day's Routing Coordinator.
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(now);
            if (calendar.get(Calendar.HOUR_OF_DAY) < 8 || calendar.get(Calendar.HOUR) >= 17 ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
              // Set the time to 8:00 am on the same day if it was before 8:00 am and at or after midnight.
              if (calendar.get(Calendar.HOUR_OF_DAY) < 8) {
                calendar.set(Calendar.HOUR_OF_DAY, 8);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
              }
              // Set the time to 8:00 am the next day fi it was at or after 5:00 pm.
              if (calendar.get(Calendar.HOUR) >= 17) {
                calendar.add(Calendar.DATE, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 8);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
              }
              // Go to Monday if the adjusted is on the weekend.
              switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SATURDAY:
                  calendar.add(Calendar.DATE, 2);
                  break;
                case Calendar.SUNDAY:
                  calendar.add(Calendar.DATE, 1);
                  break;
              }
            }
            
            // ccmn79d
            ROWCCMN79DO_ARRAY rowccmn79do2_array = findOnCallCountyInfo(cdOnCallProgram, szCdOnCallCounty, calendar.getTime());
            // If the schedule does not exist, it is not an error.
            if (rowccmn79do2_array.getUlRowQty() != 0) {
              Enumeration rowccmn79do2_enum = rowccmn79do2_array.enumerateROWCCMN79DO();
              while (rowccmn79do2_enum.hasMoreElements()) {
                ROWCCMN79DO rowccmn79do2 = (ROWCCMN79DO) rowccmn79do2_enum.nextElement();
                // We just need the idOnCall this time
                idOnCall = rowccmn79do2.getUlIdOnCall();
                // ccmn28d
                AvailStaffGroup_ARRAY availStaffGroup2_array = findEmpOnCallLinkInfo(idOnCall);
                // Do nothing if ccmn28d fails.
                if (availStaffGroup2_array != null) {
                  Enumeration availStaffGroup_enum = availStaffGroup2_array.enumerateAvailStaffGroup();
                  while (availStaffGroup_enum.hasMoreElements()) {
                    AvailStaffGroup availStaffGroup = (AvailStaffGroup) availStaffGroup_enum.nextElement();
                    if (CodesTables.COCDESGN_RC.equals(availStaffGroup.getSzCdEmpOnCallDesig())) {
                      // Add the router
                      ccmn80so.getAvailStaffGroup_ARRAY().addAvailStaffGroup(availStaffGroup);
                      // We only need the first one, so stop the loop.
                      break;
                    }
                  }
                }
             }//While
            }
          } // End While
        
        } else {
          ccmn80so.setExplan_code(Messages.MSG_CMN_ASSIGN_ON_CALL);
          AvailStaffGroup_ARRAY availStaffGroup_array = new AvailStaffGroup_ARRAY();
          ccmn80so.setAvailStaffGroup_ARRAY(availStaffGroup_array);
        }
      }
      if (idStages.length > 0) {
        // ccmn29d
        ccmn80so.setAssignmentGroup_ARRAY(findStageByIdStageAndOrderByCdStagePersRole(idStages));
        // cint40d
        ccmn80so.setUlIdUnit(findStageByIdStage(ccmn80si.getUlIdStage_ARRAY().getUlIdStage(0)));
      }
    } else {
      ccmn80so.setBIndOverPolicyLimit(findOverPolicyIndicatorByIdPerson(ccmn80si.getUlIdPerson()));
    }
    return ccmn80so;
  }

  private boolean findStagesOnWorkload(int[] idStages) {
    boolean foundAllStages = true;
    for (int i = 0; foundAllStages && i < idStages.length; i++) {
      int idStage = idStages[i];
      // csec84d
      foundAllStages = (workloadDAO.findWorkloadByIdStage(idStage) != null);
    }
    return foundAllStages;
  }

  private AvailStaffGroup_ARRAY findUnitEmpLinkInfo(int idUnit) {
    // Using the logged in user's ID-PERSON, this DAM will retrieve information about all staff in the user's
    //   unit for the Available Staff ListBox.
    // ccmn27d
    List<Map> unitEmpLinkInfo = unitEmpLinkDAO.findUnitEmpLinkPrimaryBSPhoneByIdUnit(idUnit);
    if (unitEmpLinkInfo == null || unitEmpLinkInfo.isEmpty()) {
      // In the original service, this is only thrown if pInputMsg->ulIdStage[0] <= 0, and only because that condition
      //   overwrites the return code stored in rc from this call.  Given that the calling conversation explicitly
      //   handles this error, I am adding it.
      
      //-- return null here and add error message to output object in calling code
      return null;
    }
    AvailStaffGroup_ARRAY availStaffGroupArray = new AvailStaffGroup_ARRAY();
    for (Iterator<Map> it = unitEmpLinkInfo.iterator(); it.hasNext();) {
      Map unitEmpLinkMap = it.next();
      AvailStaffGroup row = new AvailStaffGroup();
      String nmPersonFull = FormattingHelper.formatFullName((String) unitEmpLinkMap.get("nmEmployeeFirst"),
                                                            (String) unitEmpLinkMap.get("nmEmployeeMiddle"),
                                                            (String) unitEmpLinkMap.get("nmEmployeeLast"));
      row.setSzNmPersonFull(nmPersonFull);
      row.setSzBjnJob((String) unitEmpLinkMap.get("cdEmpBjnEmp"));
      row.setDtDtEmpLastAssigned((DateHelper.toCastorDate((Date) unitEmpLinkMap.get("dtEmpLastAssigned"))));
      row.setLNbrPhone((String) unitEmpLinkMap.get("nbrPersonPhone"));
      row.setLNbrPhoneExtension((String) unitEmpLinkMap.get("nbrPersonPhoneExtension"));
      row.setSzNmOfficeName(Lookup.simpleDecodeSafe("COFCNM", unitEmpLinkMap.get("idOffice").toString()));
      row.setSzNbrUnit((String) unitEmpLinkMap.get("nbrUnit"));
      row.setTmScrTmEmpLastAssigned(FormattingHelper.formatTime((Date) unitEmpLinkMap.get("dtEmpLastAssigned")));
      row.setUlIdUnit((Integer) unitEmpLinkMap.get("idUnit") != null ? (Integer) unitEmpLinkMap.get("idUnit") : 0);
      row.setUlIdPerson((Integer) unitEmpLinkMap.get("idPerson") != null ? (Integer) unitEmpLinkMap.get("idPerson") :
                        0);
      row.setBIndOverPolicyLimit(findOverPolicyIndicatorByIdPerson((Integer) unitEmpLinkMap.get("idPerson") != null ?
                                                                   (Integer) unitEmpLinkMap.get("idPerson") : 0));
      availStaffGroupArray.addAvailStaffGroup(row);
    }
    return availStaffGroupArray;
  }

  private ROWCCMN79DO_ARRAY findOnCallCountyInfo(String cdOnCallProgram, String cdOnCallCounty, Date dtOnCallStart) {
    // ccmn97d
    List<Map> onCallCountyInfo = onCallCountyDAO.findOnCallCountyByCdOnCallProgramCdOnCallCountyDtOnCallStart(cdOnCallProgram,
                                                                                                        cdOnCallCounty,
                                                                                                        dtOnCallStart);
    ROWCCMN79DO_ARRAY rowccmn79do_array =  new ROWCCMN79DO_ARRAY();
    ROWCCMN79DO rowccmn79do = null;
    if (onCallCountyInfo != null && onCallCountyInfo.size() != 0) {
      int i = 0 ;
      for (Iterator<Map> it = onCallCountyInfo.iterator(); it.hasNext();) {
        Map onCallCountyInfoMap = it.next();
        rowccmn79do = new ROWCCMN79DO();
        rowccmn79do.setUlIdOnCall((Integer) onCallCountyInfoMap.get("idOnCall") != null ? (Integer) onCallCountyInfoMap.get(
                "idOnCall") : 0);
        rowccmn79do.setSzCdRegion((String) onCallCountyInfoMap.get("cdOnCallRegion"));
        rowccmn79do.setSzCdOnCallCounty((String) onCallCountyInfoMap.get("cdOnCallCounty"));
        rowccmn79do.setSzCdOnCallCounty((String) onCallCountyInfoMap.get("cdOnCallProgram"));
        rowccmn79do.setSzCdOnCallProgram((String) onCallCountyInfoMap.get("cdOnCallType"));
        rowccmn79do.setDtDtOnCallStart(DateHelper.toCastorDate((Date) onCallCountyInfoMap.get("dtOnCallStart")));
        rowccmn79do.setDtDtOnCallEnd(DateHelper.toCastorDate((Date) onCallCountyInfoMap.get("dtOnCallEnd")));
        rowccmn79do_array.addROWCCMN79DO(rowccmn79do);
        i++;
      }
      rowccmn79do_array.setUlRowQty(i);
    }
    return rowccmn79do_array;
  }

  private AvailStaffGroup_ARRAY findEmpOnCallLinkInfo(int idOnCall) throws ServiceException {
    // ccmn28d
    List<Map> empOnCallLinkInfo = empOnCallLinkDAO.findEmpOnCallLinkByIdOnCallAndOrderByNbrEmpOnCallCntctOrd(idOnCall);

    if (empOnCallLinkInfo == null || empOnCallLinkInfo.isEmpty()) {
      // In the original service, this is only thrown if pInputMsg->ulIdStage[0] <= 0, and only because that condition
      //   overwrites the return code stored in rc from this call.  The calling conversation does not explitly handle
      //   this exception, but it is hard to see how it could recover from this condition, and it is thrown under the
      //   same circmstances as the others that were added.
      throw new ServiceException(Messages.MSG_CMN_ASSIGN_ON_CALL_EMPTY);
    }

    AvailStaffGroup_ARRAY availStaffGroupArray = new AvailStaffGroup_ARRAY();
    for (Iterator<Map> it = empOnCallLinkInfo.iterator(); it.hasNext();) {
      Map empOnCallLinkMap = it.next();
      AvailStaffGroup row = new AvailStaffGroup();
      row.setUlIdPerson((Integer) empOnCallLinkMap.get("idPerson") != null ? (Integer) empOnCallLinkMap.get(
              "idPerson") : 0);
      row.setUlIdUnit((Integer) empOnCallLinkMap.get("idUnit") != null ? (Integer) empOnCallLinkMap.get("idUnit") : 0);
      row.setSzCdEmpOnCallDesig((String) empOnCallLinkMap.get("cdEmpOnCallDesig"));
      row.setSzNbrEmpOnCallPhone1((String) empOnCallLinkMap.get("nbrEmpOnCallPhone1"));
      row.setLNbrEmpOnCallExt1((String) empOnCallLinkMap.get("nbrEmpOnCallExt1"));
      row.setUsNbrEmpOnCallCntctOrd((Integer) empOnCallLinkMap.get("nbrEmpOnCallCntctOrd") != null ?
                                    (Integer) empOnCallLinkMap.get("nbrEmpOnCallCntctOrd") : 0);
      row.setSzNmPersonFull((String) empOnCallLinkMap.get("nmPersonFull"));
      row.setDtDtEmpLastAssigned((DateHelper.toCastorDate((Date) empOnCallLinkMap.get("dtEmpLastAssigned"))));
      row.setSzNmOfficeName((String) empOnCallLinkMap.get("nmOfficeName"));
      row.setSzBjnJob((String) empOnCallLinkMap.get("cdJobBjn"));
      row.setLNbrPhone((String) empOnCallLinkMap.get("nbrPersonPhone"));
      row.setLNbrPhoneExtension((String) empOnCallLinkMap.get("nbrPersonPhoneExtension"));
      row.setBIndOverPolicyLimit(findOverPolicyIndicatorByIdPerson((Integer) empOnCallLinkMap.get("idPerson") != null ?
                                                                   (Integer) empOnCallLinkMap.get("idPerson") : 0));
      availStaffGroupArray.addAvailStaffGroup(row);
    }
    return availStaffGroupArray;
  }

  private AssignmentGroup_ARRAY findStageByIdStageAndOrderByCdStagePersRole(int[] idStages) throws ServiceException {
    AssignmentGroup_ARRAY assignmentGroupArray = new AssignmentGroup_ARRAY();
    for (int i = 0; i < idStages.length; i++) {
      int idStage = idStages[i];
      // ccmn29d
      List<Map> stageInfo = stageDAO.findStageByIdStageAndOrderByCdStagePersRole(idStage);
      if (stageInfo == null || stageInfo.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      for (Iterator<Map> it = stageInfo.iterator(); it.hasNext();) {
        Map stageMap = it.next();
        AssignmentGroup assignmentGroup = new AssignmentGroup();
        assignmentGroup.setSzNmStage((String) stageMap.get("nmStage"));
        assignmentGroup.setSzNmPersonFull((String) stageMap.get("nmPersonFull"));
        assignmentGroup.setSzCdStagePersRole((String) stageMap.get("cdStagePersRole"));
        assignmentGroup.setUlIdStage((Integer) stageMap.get("idStage") != null ? (Integer) stageMap.get("idStage") : 0);
        assignmentGroup.setUlIdPerson((Integer) stageMap.get("idPerson") != null ?
                                      (Integer) stageMap.get("idPerson") : 0);
        assignmentGroup.setUlIdStagePerson((Integer) stageMap.get("idStagePersonLink") != null ?
                                           (Integer) stageMap.get("idStagePersonLink") : 0);
        assignmentGroup.setUlIdCase((Integer) stageMap.get("idCase") != null ? (Integer) stageMap.get("idCase") : 0);
        assignmentGroup.setSzCdStage((String) stageMap.get("cdStage"));
        assignmentGroup.setSzCdStageProgram((String) stageMap.get("cdStageProgram"));
        assignmentGroup.setSzCdStageType((String) stageMap.get("cdStageType"));
        assignmentGroup.setSzCdStageCnty((String) stageMap.get("cdStageCnty"));
        assignmentGroup.setTsLastUpdate(((Date) stageMap.get("dtLastUpdate")));
        assignmentGroup.setBIndOverPolicyLimit(findOverPolicyIndicatorByIdPerson(assignmentGroup.getUlIdPerson()));
        assignmentGroupArray.addAssignmentGroup(assignmentGroup);
      }
    }
    return assignmentGroupArray;
  }

  private int findStageByIdStage(int idStage) throws ServiceException {
    // cint40d
    Stage stageInfo = stageDAO.findStageByIdStage(idStage);
    if (stageInfo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return stageInfo.getUnit().getIdUnit();
  }

  /* This method returns the overPolicyLimit Indicator as true if ceratin conditions are met*/
  private boolean findOverPolicyIndicatorByIdPerson(int idPerson) {
    int workloadTotalCount = Integer.parseInt(dynamicWorkloadDAO.countWorkload(idPerson));
    //Set the overPolicyLimit Indicator to true if the total stages assigned to a Case Manager is more than 17
    if ((workloadTotalCount) > 17) {
      return true;
    }
    //Set the overPolicyLimit Indicator to true if the total Investigation stages assigned to a Case Manager 
    //is more than 12
    int workloadStageINVCount = Integer.parseInt(dynamicWorkloadDAO.countWorkloadStages(idPerson, "INV"));
    if (workloadStageINVCount > 12) {
      return true;
    }
    //  Set the overPolicyLimit Indicator to true if the total Adoption stages assigned to a Case Manager 
    //is more than 16
    int workloadStageADOCount = Integer.parseInt(dynamicWorkloadDAO.countWorkloadStages(idPerson, "ADO"));
    if (workloadStageADOCount > 16) {
      return true;
    }
    //  Set the overPolicyLimit Indicator to true if the total Ongoing stages assigned to a Case Manager 
    //is more than 17
    int workloadStageONGCount = Integer.parseInt(dynamicWorkloadDAO.countWorkloadStages(idPerson, "ONG"));
    if (workloadStageONGCount > 17) {
      return true;
    }
    //  Set the overPolicyLimit Indicator to true if the total Foster Care stages assigned to a Case Manager 
    //is more than 15
    int workloadStageFCFCount = Integer.parseInt(dynamicWorkloadDAO.countWorkloadStages(idPerson, "FCF"));
    int workloadStageFCCCount = Integer.parseInt(dynamicWorkloadDAO.countWorkloadStages(idPerson, "FCC"));
    if ((workloadStageFCFCount + workloadStageFCCCount) > 15) {
      return true;
    }
    //  Set the overPolicyLimit Indicator to true if the Specialized Social Services Case Manager 
    // is more than 12. Specialized is assigned when a child is in custody 18 months or longer
    workloadStageFCFCount = Integer.parseInt(dynamicWorkloadDAO.countSpecializedWorkerStages(idPerson, "FCF"));
    workloadStageFCCCount = Integer.parseInt(dynamicWorkloadDAO.countSpecializedWorkerStages(idPerson, "FCC"));
    if ((workloadStageFCFCount + workloadStageFCCCount) > 12) {
      return true;
    }
    return false;
  }

}
