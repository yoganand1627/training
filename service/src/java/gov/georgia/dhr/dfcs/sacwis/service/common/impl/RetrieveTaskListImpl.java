package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveTaskList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50SO;

public class RetrieveTaskListImpl extends BaseServiceImpl implements RetrieveTaskList {

  private static final String IND_YES = "1";
  private static final String IND_NO = "0";
  private static final String NULL_STRING = "";
  private static final String[] STATUS_ARRAY =
          {CodesTables.CEVTSTAT_NEW, CodesTables.CEVTSTAT_PROC, CodesTables.CEVTSTAT_COMP,
           CodesTables.CEVTSTAT_PEND, CodesTables.CEVTSTAT_APRV, NULL_STRING};
  private static final List STATUS_LIST = Arrays.asList(STATUS_ARRAY);
  private StageLinkDAO stageLinkDAO = null;
  private ComplexEventDAO complexEventDAO = null;

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setComplexEventDAO(ComplexEventDAO complexEventDAO) {
    this.complexEventDAO = complexEventDAO;
  }

  public CCMN50SO findTaskListEvents(CCMN50SI ccmn50si) throws ServiceException {
    CCMN50SO ccmn50so = new CCMN50SO();

    // First, check the PriorStage indicator.  If set to YES, then call StageLinkDao method, 
    // CCMNB5D.  In this case,the Prior Stage ID is returned, the DetailList indicator is set to YES, 
    // and the TaskNew indicator is set to NO.  No further processing.
    if (IND_YES.equals(ccmn50si.getCIndTaskRtrvPriorStage())) {
      //  Calling DAO CCMNB5D
      //This function calls DAM CCMNB5D which returns the latest
      //prior stage ID for a particular STAGE ID.
      Integer idStage = stageLinkDAO.findStageLinkMostRecentlyClosedPreviousIdStage(ccmn50si.getUlIdStage());
      if (idStage == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      } else {
        ccmn50so.setUlIdPriorStage(idStage != null ? idStage : 0);
        ccmn50so.setCSysIndTaskDetailList(IND_YES);
        ccmn50so.setCSysIndTaskNew(IND_NO);
      }
    } else {
      // If the PriorStage indicator is NO or NULL, proceed with calling ComplexEventDAO method,CCMNB4D.
      // Check first to see what the MultInst indicator is set to./PB enable logic varies according
      // to whether multiple instancesof a task are allowed.
      if (IND_YES.equals(ccmn50si.getBIndTaskMultInstance())) {
        // Calls ComplexEventDAO method, CCMNB4D to ascertain if there are any rows in the EVENT Table
        // for a given ID STAGE so the enablement of the NEW and DETAIL pushbuttons on the TASK LIST
        // window can be determined. The DAM also returns the ID EVENT. Furthermore, CD EVENT STATUS
        // is returned so the enablement of the NEW pushbutton can be determined.

        // Calling DAO   CCMNB4D
        Map eventMap = complexEventDAO.findIdEventAndCdEventStatus(ccmn50si.getUlIdStage(), ccmn50si.getSzCdTask());
        if (eventMap != null) {
          ccmn50so.setUlIdEvent((Integer) eventMap.get("idEvent") != null ? (Integer) eventMap.get("idEvent") : 0);
          ccmn50so.setSzCdEventStatus((String) eventMap.get("cdEventStatus"));
        }
        if (StringHelper.isValid(ccmn50si.getSzCdEventStatus()) ||
            StringHelper.isValid(ccmn50so.getSzCdEventStatus())) {
          // Since mult instances allowed and Task status is NULL, enable the NEW PB.
          ccmn50so.setCSysIndTaskNew(IND_YES);
          if (eventMap != null) {
            //There are events.  Enable the Detail/List PBs
            ccmn50so.setCSysIndTaskDetailList(IND_YES);
          } else {
            // No Events.  Disable Detail/List.
            ccmn50so.setCSysIndTaskDetailList(IND_NO);
          }
        } else {
          // The task event status is not NULL.  Check task event status against the event table
          // status.  If the Event table status is >= the Task table status, then enable the NEW PB.
          // Otherwise, disable it.
          if (STATUS_LIST.indexOf(ccmn50so.getSzCdEventStatus()) >= STATUS_LIST.indexOf(
                  ccmn50si.getSzCdEventStatus())) {
            ccmn50so.setCSysIndTaskNew(IND_YES);
          } else {
            ccmn50so.setCSysIndTaskNew(IND_NO);
          }
          //Set the Detail/List indicator
          ccmn50so.setCSysIndTaskDetailList(IND_YES);
        }
      } else {
        // Calling DAO    CCMNB4D
        Map eventMap = complexEventDAO.findIdEventAndCdEventStatus(ccmn50si.getUlIdStage(), ccmn50si.getSzCdTask());
        if (eventMap != null) {
          ccmn50so.setUlIdEvent((Integer) eventMap.get("idEvent") != null ? (Integer) eventMap.get("idEvent") : 0);
          ccmn50so.setSzCdEventStatus((String) eventMap.get("cdEventStatus"));
        }
        // Events were found on the Event table.  Therefore, enable List/Detail pushbuttons.
        // New PB must be disabled because only ONE instance is allowed, and it already exists.
        if (eventMap != null) {
          ccmn50so.setCSysIndTaskDetailList(IND_YES);
          ccmn50so.setCSysIndTaskNew(IND_NO);
        } else {
          // Events were not found.  Disable the List/Detail PBs and enable the New PB.
          ccmn50so.setCSysIndTaskDetailList(IND_NO);
          ccmn50so.setCSysIndTaskNew(IND_YES);
        }
      }
    }
    return ccmn50so;
  }
}
