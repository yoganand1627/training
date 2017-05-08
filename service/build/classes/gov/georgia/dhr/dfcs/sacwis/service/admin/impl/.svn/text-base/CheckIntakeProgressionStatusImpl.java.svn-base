package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckIntakeProgressionStatus;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IntakeProgressionStatusSI;

import java.util.List;

/**
* <pre>
* Change History:
* Date      User              Description
* --------  ----------------  -------------------------------------------------
* 
* </pre>
*
* @author Herve Jean-Baptiste, April 10, 2008
* 
*/
public class CheckIntakeProgressionStatusImpl extends BaseServiceImpl implements CheckIntakeProgressionStatus {

  public static final String CALL_ENTRY_TASK = "1000";
  public static final String CALL_ENTRY_EVENT_TYPE = CodesTables.CEVNTTYP_CAL;
  public static final String APPROVAL_APPROVED = CodesTables.CAPPDESG_APRV;
    
  private EventDAO eventDAO;
  private ApproversDAO approversDAO;
  
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }


  public boolean checkIntakeProgressionStatus(IntakeProgressionStatusSI intakeProgressionStatusSI) throws ServiceException{
    boolean continueWithStageProgression = false;
    // find the Call Entry event
    Event event = eventDAO.findEventByIdStageAndEventTypeAndTask(intakeProgressionStatusSI.getIdStage(), CALL_ENTRY_EVENT_TYPE, CALL_ENTRY_TASK);
    int idEvent = event == null ? 0 : event.getIdEvent();
    List<Approvers> approversList = approversDAO.findApproversByIdEventReverseChronology(idEvent);
    // if there are no approvers then do not allow Stage Progression. This code should probably never run because
    // if there aren't any approvers than the Intake most likely doesn't have a Case ID [yet]. Thus, it should fail the 
    // case id validation in the CustomValidation. Nevertheless, I'm still leaving it just for some unknown reason 
    // validation makes it this far
    if(approversList == null || approversList.size() == 0) {
      throw new ServiceException(Messages.MSG_NO_STAGE_PROG);
    }
    
    // get the most recent Approvers record and if their determination is not set to Approved(APRV)
    // then do not allow Stage Progression
    Approvers approvers = approversList.get(0);
    if (!APPROVAL_APPROVED.equals(approvers.getCdApproversStatus())){
      throw new ServiceException(Messages.MSG_NO_STAGE_PROG);
    }
    // go ahead and allow Stage Progression
    continueWithStageProgression = true;
    return continueWithStageProgression;

  }

}
