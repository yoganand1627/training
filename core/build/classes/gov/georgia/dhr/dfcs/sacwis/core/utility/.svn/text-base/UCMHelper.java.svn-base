package gov.georgia.dhr.dfcs.sacwis.core.utility;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;

import oracle.stellent.ridc.IdcClient;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.IdcClientManager;
import oracle.stellent.ridc.IdcContext;
import oracle.stellent.ridc.model.DataBinder;
import oracle.stellent.ridc.model.TransferFile;
import oracle.stellent.ridc.protocol.ServiceResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.filters.StringInputStream;
import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;

/**
 * Helper class used to submit items to UCM.
 * 
 * @author venkat.collooru
 * 
 */
public final class UCMHelper {
  private static final String PARAM_REVISION_SELECTION_METHOD = "RevisionSelectionMethod";

  private static final String PARAM_X_TRANSACTION_ID = "xTransactionID";

  private static final String PARAM_X_DATEOF_ENTRY = "xDateofEntry";

  private static final String PARAM_D_DOC_NAME = "dDocName";

  private static final String PARAM_IDC_SERVICE = "IdcService";

  private static final String PARAM_PRIMARY_FILE = "primaryFile";

  private static final String PARAM_D_DOC_ACCOUNT = "dDocAccount";

  private static final String PARAM_D_SECURITY_GROUP = "dSecurityGroup";

  private static final String PARAM_D_DOC_TYPE = "dDocType";

  private static final String PARAM_D_DOC_TITLE = "dDocTitle";

  public static final String UCM_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";

  public static final SimpleDateFormat UCM_DATE_FORMAT = new SimpleDateFormat(UCM_FORMAT_STRING);

  private static IdcClient client = null;

  private static IdcContext context = null;

  private static final String UCM_URL_PRIMARY = GrndsConfiguration.getInstance()
                                                                  .getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                               "ucm.server.url.primary");

  private static final String UCM_URL_SECONDARY = GrndsConfiguration.getInstance()
                                                                    .getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                                 "ucm.server.url.secondary");

  private static final String UCM_USER = GrndsConfiguration.getInstance()
                                                           .getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                        "ucm.server.user");

  private static final String UCM_PASSWORD = GrndsConfiguration.getInstance()
                                                               .getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                            "ucm.server.password");

  private static final String UCM_SERVER_CONNECTION_TIMEOUT = GrndsConfiguration.getInstance()
                                                                                .getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                                             "ucm.server.connection.timeout");

  private static final GrndsLogger GLOBAL_EXCEPTION_LOGGER = GrndsLogger.getLogger(GrndsConfiguration.getInstance()
                                                                                                     .getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                                                                  "exception.globalLogger"));

  public UCMHelper() {
    IdcClientManager idcManager = new IdcClientManager();
    try {
      String ucmServerUrl = getUCMServerUrl(UCM_URL_PRIMARY, UCM_URL_SECONDARY);
      if (StringUtils.isBlank(ucmServerUrl)) {
        GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.CRITICAL, "Unable to connect to neither primary server:"
                                                         + UCM_URL_PRIMARY + " nor secondary server:"
                                                         + UCM_URL_SECONDARY);
      }
      client = idcManager.createClient(StringUtils.trimToEmpty(ucmServerUrl));
    } catch (IdcClientException e) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.CRITICAL, "Unable to create the IDC client.", e);
    }

    // create an identity with a password
    context = new IdcContext(UCM_USER, UCM_PASSWORD);
  }

  /**
   * populates the UCM binder with the meta data stored in a UCMDataObject.
   * 
   * @param binder
   * @param data
   */
  public void populateBinder(DataBinder binder, UCMDataObject data) {
    // UCM Required fields
    addBinderString(binder, PARAM_D_DOC_TITLE, data.getDocTitle());
    addBinderString(binder, PARAM_D_DOC_TYPE, data.getDocType());
    addBinderString(binder, PARAM_D_SECURITY_GROUP, data.getSecurityGroup());
    addBinderString(binder, PARAM_D_DOC_ACCOUNT, data.getAccount());
    addBinderString(binder, PARAM_X_DATEOF_ENTRY, UCM_DATE_FORMAT.format(new java.util.Date()));
    addBinderString(binder, PARAM_X_TRANSACTION_ID, data.getTransactionID());
    binder.addFile(PARAM_PRIMARY_FILE,
                   new TransferFile(data.getPrimaryFile(), data.getFileName(), data.getContentLength()));
  }

  /**
   * adds a String to the binder
   * 
   * @param binder
   * @param element
   * @param value
   */
  private void addBinderString(DataBinder binder, String element, String value) {
    if (binder != null && StringUtils.isNotBlank(element) && StringUtils.isNotBlank(value)) {
      binder.putLocal(element, value);
    }
  }

  /**
   * Submits a request to UCM
   * 
   * @param binder
   * @return
   */
  public ServiceResponse sendRequest(DataBinder requestBinder) {
    ServiceResponse response = null;
    // execute the request
    try {
      response = client.sendRequest(context, requestBinder);
    } catch (IdcClientException e) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.CRITICAL, "Unable to service the IDC reguest.", e);
    }
    return response;
  }

  /**
   * Populates the binder, and submits it to UCM
   * 
   * @param binder
   * @param data
   * @return int error = -1
   */
  public String upload(DataBinder requestBinder, UCMDataObject data) {
    DataBinder responseBinder = null;
    String contentID = null;
    // populate the binder with the parameters
    requestBinder.putLocal(PARAM_IDC_SERVICE, "CHECKIN_NEW");
    populateBinder(requestBinder, data);
    try {
      ServiceResponse response = sendRequest(requestBinder);
      responseBinder = response.getResponseAsBinder();
      contentID = responseBinder.getLocal(PARAM_D_DOC_NAME);
    } catch (IdcClientException e) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.CRITICAL, "Unable to upload the  file.", e);
    }

    return contentID;
  }

  public DataBinder getBinder() {
    return client.createBinder();
  }

  /**
   * Returns the file associated with the given document ID
   * 
   * @param documentId
   *          - document ID
   * @return
   */
  public InputStream retrieveFile(String documentId) {
    InputStream stream = null;
    DataBinder requestBinder = getBinder();
    requestBinder.putLocal(PARAM_IDC_SERVICE, "GET_FILE");
    requestBinder.putLocal(PARAM_D_DOC_NAME, documentId);
    requestBinder.putLocal(PARAM_REVISION_SELECTION_METHOD, "Latest");
    // execute the request
    ServiceResponse response = null;
    try {
      response = sendRequest(requestBinder);
      stream = response.getResponseStream();
    } catch (Exception e) {
      e.printStackTrace();
      stream = new StringInputStream(e.getMessage());
    }
    return stream;
  }

  /**
   * Returns the primary or the secondary server url based upon the availability The url should be in the format
   * http://[hostname]:[port] or [hostname]:[port]
   * 
   * @param ucmPrimaryServer
   * @param ucmSecondaryServer
   * @return
   */
  private String getUCMServerUrl(String ucmPrimaryServer, String ucmSecondaryServer) {
    int primaryBeginIndex = (StringUtils.isNotBlank(ucmPrimaryServer) && ucmPrimaryServer.indexOf("/") != -1) ? ucmPrimaryServer.lastIndexOf("/") + 1
                                                                                                             : 0;
    int secondaryBeginIndex = (StringUtils.isNotBlank(ucmSecondaryServer) && ucmSecondaryServer.indexOf("/") != -1) ? ucmSecondaryServer.lastIndexOf("/") + 1
                                                                                                                   : 0;
    if (StringUtils.isNotBlank(ucmPrimaryServer)
        && isServerAvailable(ucmPrimaryServer.substring(primaryBeginIndex, ucmPrimaryServer.lastIndexOf(":")),
                             ucmPrimaryServer.substring(ucmPrimaryServer.lastIndexOf(":") + 1))) {
      return ucmPrimaryServer;
    } else if (StringUtils.isNotBlank(ucmSecondaryServer)
               && isServerAvailable(ucmSecondaryServer.substring(secondaryBeginIndex,
                                                                 ucmSecondaryServer.lastIndexOf(":")),
                                    ucmSecondaryServer.substring(ucmSecondaryServer.lastIndexOf(":") + 1))) {
      return ucmSecondaryServer;
    }
    return null;
  }

  /**
   * Test if the connection to the remote server is available.
   * 
   * @param host
   * @param port
   * @return
   */
  private boolean isServerAvailable(String host, String port) {
    int timeout = 2000; // two seconds
    if (StringUtils.isNotBlank(UCM_SERVER_CONNECTION_TIMEOUT) && StringUtils.isNumeric(UCM_SERVER_CONNECTION_TIMEOUT)) {
      timeout = Integer.parseInt(UCM_SERVER_CONNECTION_TIMEOUT);
    }
    Socket socket = new Socket();
    InetSocketAddress endPoint = new InetSocketAddress(host, Integer.parseInt(port));

    if (endPoint.isUnresolved()) { // Checks whether the address has been resolved or not.
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.CRITICAL, "Unable to resolve the address " + host + ":" + port);
      return false;
    } else {
      try {
        socket.connect(endPoint, timeout);
        GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.INFO, "Successfully connected to " + host + ":" + port);
        return true;
      } catch (Exception e) {
        GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.CRITICAL, "Unable to connect to " + host + ":" + port, e);
        return false;
      } finally {
        if (socket != null) {
          try {
            socket.close();
          } catch (IOException ioex) {
            // Ignore the exception
          }
        }
      }
    }
  }
}