/**
 * Created on Jan 8, 2007 at 3:55:27 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.reports;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;
import org.grnds.structural.web.GrndsExchangePresentation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public class ReportPresentation implements GrndsExchangePresentation {

  private static final String TRACE_TAG = ReportPresentation.class.getSimpleName();
  private static final String PDF_MIME_TYPE = "application/pdf";
  private static final String UDR_REPORT = "U";
  private static final String XLS_MIME_TYPE = "application/vnd.ms-excel";

  public static final String REPORT_BYTES_KEY = TRACE_TAG + "_REPORT";
  public static final String REPORT_TYPE_KEY = TRACE_TAG + "_REPORT_TYPE";
  

  public void executePresentation(GrndsExchangeContext context) throws ServletException, IOException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "executePresentation");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    try {
      // Set the MIME type to the correct mime type.
      response.setContentType(isUDRReportType(request) ? XLS_MIME_TYPE : PDF_MIME_TYPE);
      // Retrieve the binary data.
      byte[] reportBytes = getReportBytes(request);
      ServletOutputStream out = response.getOutputStream();
      // Do a flush just before we write the byte array because, if we do not,
      //   IE gets confused and ignores the content type.
      out.flush();
      out.write(reportBytes);
      // The flush does the commit; close is unnecessary (the server does it).
      out.flush();
    } catch (IOException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Error:" + e.getMessage());
      // We really can't display an error if the response has already been committed.
      if (!response.isCommitted()) {
        response.setContentType("text/html; charset=\"" + ArchitectureConstants.CHARACTER_ENCODING + "\"");
        PrintWriter writer = response.getWriter();
        writer.println("Exception occured displaying the report:<b/>" + e.getMessage());
        writer.println("<pre>");
        e.printStackTrace(writer);
        writer.println("</pre>");
      }
    }
    performanceTrace.exitScope();
  }

  private byte[] getReportBytes(HttpServletRequest request) {
    byte[] reportBytes = (byte[]) request.getAttribute(REPORT_BYTES_KEY);
    if (reportBytes == null || reportBytes.length == 0) {
      throw new RuntimeException("Report not found in request.");
    }
    return reportBytes;
  }
  
  boolean isUDRReportType(HttpServletRequest request) {
    String type = (String) ((request.getAttribute(REPORT_TYPE_KEY) != null) ? request.getAttribute(REPORT_TYPE_KEY) : ""); 
    return (UDR_REPORT.equals(type));
  }
}
