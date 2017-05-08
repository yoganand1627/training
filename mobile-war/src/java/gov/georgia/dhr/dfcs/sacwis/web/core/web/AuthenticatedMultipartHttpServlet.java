package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class AuthenticatedMultipartHttpServlet extends AuthenticatedPrsHttpServlet {

  private static final String TRACE_TAG = AuthenticatedMultipartHttpServlet.class.getSimpleName();

  private static final GrndsConfiguration GRNDS_CONFIGURATION = GrndsConfiguration.getInstance();
  private static final int MAX_UPLOAD_SIZE =
          Integer.valueOf(GRNDS_CONFIGURATION.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "maxUploadSize"));

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    GrndsTrace.enterScope(AuthenticatedMultipartHttpServlet.TRACE_TAG + ".doPost");
    // Only parse a multipart request if the request is actually a multipart request and is hasn't been parsed, already.
    //   If the request has been parsed already, the request object itself will already be wrapped by
    //   DefaultMultipartHttpServletRequest, and reparsing just creates the same thing again.
    if (ServletFileUpload.isMultipartContent(request) && !(request instanceof DefaultMultipartHttpServletRequest)) {
      // Use the spring CommonsFileUploadSupport
      GRNDSCommonsFileUploadSupport uploadSupport = new GRNDSCommonsFileUploadSupport();
      // Always put the request in RAM.
      uploadSupport.setMaxInMemorySize(MAX_UPLOAD_SIZE);
      uploadSupport.setMaxUploadSize(MAX_UPLOAD_SIZE);
      // Replace the request with the parsed value.
      request = uploadSupport.resolveMultipart(request);
    }
    super.doPost(request, response);
    GrndsTrace.exitScope();
  }

  /** Only needed because we don't want to confuse things with the Spring MVC support. */
  private static class GRNDSCommonsFileUploadSupport extends CommonsFileUploadSupport {

    /** Copied from Spring's {@link org.springframework.web.multipart.commons.CommonsMultipartResolver}. */
    public MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) throws MultipartException {
      String encoding = determineEncoding(request);
      FileUpload fileUpload = prepareFileUpload(encoding);
      try {
        List fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
        CommonsFileUploadSupport.MultipartParsingResult parsingResult = parseFileItems(fileItems, encoding);
        return new DefaultMultipartHttpServletRequest(request, parsingResult.getMultipartFiles(),
                                                      parsingResult.getMultipartParameters());
      } catch (FileUploadBase.SizeLimitExceededException ex) {
        // TODO: Replace with ServiceException and proper message.
        throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), ex);
      } catch (FileUploadException ex) {
        // This exception should only happen with network errors; probably doesn't need a message.
        throw new MultipartException("Could not parse multipart servlet request", ex);
      }
    }

    /** Copied from Spring's {@link org.springframework.web.multipart.commons.CommonsMultipartResolver}. */
    protected String determineEncoding(HttpServletRequest request) {
      String encoding = request.getCharacterEncoding();
      if (encoding == null) {
        encoding = getDefaultEncoding();
      }
      return encoding;
    }

    protected FileUpload newFileUpload(FileItemFactory fileItemFactory) {
      return new ServletFileUpload(fileItemFactory);
    }
  }
}
