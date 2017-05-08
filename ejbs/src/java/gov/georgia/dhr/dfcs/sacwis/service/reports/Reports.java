/**
 * Created on Jun 28, 2006 at 12:54:02 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.reports;

import gov.georgia.dhr.dfcs.sacwis.core.spring.SlsbFacade;

public interface Reports
        extends SlsbFacade, DeleteReportList, LaunchReportAsync, RetrieveOutputLaunch, RetrieveReportList,
                RetrieveReportParmlist, RetrieveReport, SaveOutputLaunch {
}
