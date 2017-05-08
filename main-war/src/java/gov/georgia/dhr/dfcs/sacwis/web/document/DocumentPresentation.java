package gov.georgia.dhr.dfcs.sacwis.web.document;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
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

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class DocumentPresentation implements GrndsExchangePresentation {
  public static final String CONTENT_REQUEST_NAME = "document";
  public static final String MIMETYPE_REQUEST_NAME = "mimetype";
  private static final String HTML_MIME_TYPE = "text/html";
  private static final String TRACE_TAG = "DocumentPresentation";

  public void executePresentation(GrndsExchangeContext context) throws ServletException, IOException {
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentPresentation", "executePresentation");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    try {
      //Set the MIME type
      if (request.getAttribute(MIMETYPE_REQUEST_NAME) != null &&
          request.getAttribute(CONTENT_REQUEST_NAME) != null) {
        String mimeType = (String) request.getAttribute(MIMETYPE_REQUEST_NAME);
        response.setContentType(mimeType);

        byte[] document = (byte[]) request.getAttribute(CONTENT_REQUEST_NAME);
        if (mimeType.equals(HTML_MIME_TYPE)) {
          GrndsTrace.msg(TRACE_TAG, 7, "Mime type is html");
          // Set the encoding properly
          response.setContentType("text/html; charset=\"" + ArchitectureConstants.CHARACTER_ENCODING + "\"");
          PrintWriter writer = response.getWriter();
          String htmlOutput = new String(document, ArchitectureConstants.CHARACTER_ENCODING);
          writer.println(htmlOutput);
        } else {
          GrndsTrace.msg(TRACE_TAG, 7, "Mime type is not html");
          //Display the binary data
          ServletOutputStream out = response.getOutputStream();
          ByteArrayInputStream byteInput = new ByteArrayInputStream(document);
          BufferedInputStream buffInput = null;
          try {
            buffInput = new BufferedInputStream(byteInput);
            byte[] b = new byte[2048];
            for (int n = buffInput.read(b); n > 0; n = buffInput.read(b)) {
              out.write(b, 0, n);
            }
          } finally {
            buffInput.close();
          }
          out.close();
        }
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Error:" + e.getMessage());
      response.setContentType("text/html; charset=\"" + ArchitectureConstants.CHARACTER_ENCODING + "\"");
      PrintWriter writer = response.getWriter();
      writer.println("Exception occured rendering the form:<b/>" + e.getMessage());
      writer.println("<pre>");
      e.printStackTrace(writer);
      writer.println("</pre>");
    }
    performanceTrace.exitScope();
  }
}