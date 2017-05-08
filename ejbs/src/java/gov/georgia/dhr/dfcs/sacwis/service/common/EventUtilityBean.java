package gov.georgia.dhr.dfcs.sacwis.service.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.ejb.SessionBean;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.fce.Fce;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;

/**
 * This EventUtilityBean class is used to update the status of events.
 *
 * @author Michael Werle, July 2, 2003
 */
public class EventUtilityBean extends BaseServiceEjb implements SessionBean {
  /**
   * Update the event status for a list of CaseUtility.Event objects.
   *
   * @param events the events to be udpated
   */
  public void updateEventStatus(List<? extends CaseUtility.Event> events) {
    GrndsTrace.enterScope(TRACE_TAG + ".updateEventStatus");

    Connection connection = null;
    PreparedStatement stmt = null;
    try {
      connection = JdbcHelper.getConnection();
      stmt = connection.prepareStatement("UPDATE EVENT SET CD_EVENT_STATUS = ? WHERE ID_EVENT = ?");
      for (Iterator<? extends CaseUtility.Event> eventIterator = events.iterator(); eventIterator.hasNext();) {
        CaseUtility.Event event = eventIterator.next();
        stmt.setString(1, event.getCdEventStatus());
        stmt.setInt(2, event.getIdEvent());
        stmt.addBatch();
      }
      stmt.executeBatch();
    }

    catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure updating event status: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    }
    finally {
      cleanup(stmt, connection);
    }

    GrndsTrace.exitScope();
  }

  /**
   * Update the event status for a list of CaseUtility.Event objects.
   *
   * @param events the events to be udpated
   */
  public void updateEventStatus(List events, String status) {
    GrndsTrace.enterScope(TRACE_TAG + ".updateEventStatus");

    Connection connection = null;
    PreparedStatement stmt = null;
    try {
      connection = JdbcHelper.getConnection();
      stmt = connection.prepareStatement("UPDATE EVENT SET CD_EVENT_STATUS = ? WHERE ID_EVENT = ?");
      for (Iterator eventIterator = events.iterator(); eventIterator.hasNext();) {
        CaseUtility.Event event = (CaseUtility.Event) eventIterator.next();
        stmt.setString(1, status);
        stmt.setInt(2, event.getIdEvent());
        stmt.addBatch();
      }
      stmt.executeBatch();
    }

    catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure updating event status: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    }
    finally {
      cleanup(stmt, connection);
    }

    GrndsTrace.exitScope();
  }

  public void invalidatePendingStageClosure(int stageClosureEventId, Admin admin) {
    GrndsTrace.enterScope(TRACE_TAG + ".invalidatePendingClosure");

    // Set event status to COMP
    updateEventStatus(CaseUtility.getEvents(new int[] {stageClosureEventId}), CodesTables.CEVTSTAT_COMP);

    // Call InvalidateAprvl common service
    ArchInputStruct input = new ArchInputStruct();
    CCMN05UI ccmn05ui = new CCMN05UI();
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    // Add will be disabled in Approver Mode, so if we get here,
    // Approver Mode should be set to N.
    input.setUlSysNbrReserved1(ArchitectureConstants.N);
    ccmn05ui.setUlIdEvent(stageClosureEventId);
    ccmn05ui.setArchInputStruct(input);
    try {
      CCMN05UO ccmn05uo = new CCMN05UO();
      ccmn05uo = admin.invalidateApproval(ccmn05ui);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure invalidating approval: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    }

    GrndsTrace.exitScope();
  }

  // static constants
  public static final String TRACE_TAG = "EventUtilityBean";
}
