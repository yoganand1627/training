package gov.georgia.dhr.dfcs.sacwis.web.test;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.jndihelper.JndiHelper;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.service.document.Cfp;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

public class PingConversation extends BaseHiddenFieldStateConversation {
  public static final String CONVERSATION_URL = "/test/Ping/";

  Cfp cfp;

  public void setCfp(Cfp cfp) {
    this.cfp = cfp;
  }

  public void blank_xa(GrndsExchangeContext context) {
  }

  public void log_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "log_xa");
    performanceTrace.exitScope();
  }

  public void jdbc_xa(GrndsExchangeContext context) {
    CaseUtility.getEvent(200148);
  }

  public void ejb_xa(GrndsExchangeContext context) {
    try {
      cfp.getStageDB(1000000, 1000001);
    } catch (Exception e) {
      processSevereException(context, e);
    }
  }

  public void wtc_xa(GrndsExchangeContext context) {
    throw new UnsupportedOperationException("No longer supported.");
  }
}

  
