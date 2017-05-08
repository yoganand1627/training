package gov.georgia.dhr.dfcs.sacwis.web.document;

// -- java classes --

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.MetaphorTabs;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;


/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public abstract class DocumentContainer extends TagSupport {

  private static final String TRACE_TAG = "DocumentContainer";
  public static final boolean TRAINING_MODE =
      Boolean.valueOf(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                    "perUserSchemaSupport"));
  
  private String pageMode = null;
  

  public abstract void addDoc(DocumentTag docTag);

  protected String writeDocumentForm(DocumentTag docTag) {
    StringBuffer hiddenHtml = new StringBuffer("");

    hiddenHtml.append("<form action=\"");
    hiddenHtml.append(docTag.getAction());
    hiddenHtml.append("\" method=\"post\" style=\"display:none\" id=\"");
    if (docTag.getName() != null) {
      hiddenHtml.append(docTag.getName());
    } else {
      hiddenHtml.append(docTag.getDocType());
    }
    hiddenHtml.append("\"");
    hiddenHtml.append(" name=\"");
    if (docTag.getName() != null) {
      hiddenHtml.append(docTag.getName());
    } else {
      hiddenHtml.append(docTag.getDocType());
    }
    hiddenHtml.append("\"");
    hiddenHtml.append(">");

    // DocType hidden field
    hiddenHtml.append("<input type=\"hidden\" name=\"docType\" value=\"");
    hiddenHtml.append(docTag.getDocType());
    hiddenHtml.append("\">");

    // DocExists hidden field
    hiddenHtml.append("<input type=\"hidden\" name=\"docExists\" value=\"");
    hiddenHtml.append(docTag.getDocExists());
    hiddenHtml.append("\">");

    // CheckStage Field
    hiddenHtml.append("<input type=\"hidden\" name=\"checkStage\" value=\"");
    hiddenHtml.append(docTag.getCheckStage());
    hiddenHtml.append("\">");

    // PromptSavePage
    hiddenHtml.append("<input type=\"hidden\" name=\"promptSavePage\" value=\"");
    hiddenHtml.append(docTag.getPromptSavePage());
    hiddenHtml.append("\">");

    // PostInSameWindow
    hiddenHtml.append("<input type=\"hidden\" name=\"postInSameWindow\" value=\"");
    hiddenHtml.append(String.valueOf(docTag.getPostInSameWindow()));
    hiddenHtml.append("\">");

    // Delete Document
    hiddenHtml.append("<input type=\"hidden\" name=\"deleteDocument\" value=\"");
    hiddenHtml.append(String.valueOf(docTag.getDeleteDocument()));
    hiddenHtml.append("\">");

    // RenderFormat
    hiddenHtml.append("<input type=\"hidden\" name=\"renderFormat\" value=\"");
    if (docTag.getProtectDocument() && docTag.isCommentMode() == false) {
      hiddenHtml.append(RenderType.HTML_WITHOUT_SHELL.toString());
    } else if (docTag.getProtectDocument() && docTag.isCommentMode()) {
      hiddenHtml.append(RenderType.HTML_COMMENT_SHELL.toString());
    } else {
      hiddenHtml.append(RenderType.HTML_WITH_SHELL.toString());
    }
    
    hiddenHtml.append("\">");

    hiddenHtml.append("<input type=\"hidden\" name=\"");
    hiddenHtml.append("modeOfPage");
    hiddenHtml.append("\" value=\"");
    hiddenHtml.append(this.getPageMode());
    hiddenHtml.append("\">");

    hiddenHtml.append("<input type=\"hidden\" name=\"");
    hiddenHtml.append(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
    hiddenHtml.append("\">");

    HttpServletRequest request = (HttpServletRequest) super.pageContext.getRequest();

    // Grab tab ID's out of attributes, or if not there, out of parameters.
    String level1Tab = (String) request.getAttribute(MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME);
    if (level1Tab == null || "".equals(level1Tab)) {
      level1Tab = request.getParameter(MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME);
    }
    String level2Tab = (String) request.getAttribute(MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME);
    if (level2Tab == null || "".equals(level2Tab)) {
      level2Tab = request.getParameter(MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME);
    }
    String level3Tab = (String) request.getAttribute(MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME);
    if (level3Tab == null || "".equals(level3Tab)) {
      level3Tab = request.getParameter(MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME);
    }

    hiddenHtml.append("<input type=\"hidden\" name=\"");
    hiddenHtml.append(MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME);
    hiddenHtml.append("\" value=\"");
    hiddenHtml.append(level1Tab);
    hiddenHtml.append("\" >");
    hiddenHtml.append("<input type=\"hidden\" name=\"");
    hiddenHtml.append(MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME);
    hiddenHtml.append("\" value=\"");
    hiddenHtml.append(level2Tab);
    hiddenHtml.append("\" >");
    hiddenHtml.append("<input type=\"hidden\" name=\"");
    hiddenHtml.append(MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME);
    hiddenHtml.append("\" value=\"");
    hiddenHtml.append(level3Tab);
    hiddenHtml.append("\" >");

    hiddenHtml.append("<input type=\"hidden\" name=\"");
    hiddenHtml.append("checkForNewMode");
    hiddenHtml.append("\" value=\"");
    hiddenHtml.append(docTag.getCheckForNewMode());
    hiddenHtml.append("\">");
    
    hiddenHtml.append("<input type=\"hidden\" name=\"");
    hiddenHtml.append("preFillAlways");
    hiddenHtml.append("\" value=\"");
    hiddenHtml.append(docTag.getPreFillAlways());
    hiddenHtml.append("\">");

    hiddenHtml.append("<input type=\"hidden\" name=\"");
    hiddenHtml.append("onClick");
    hiddenHtml.append("\" value=\"");
    hiddenHtml.append(docTag.getOnClick());
    hiddenHtml.append("\">");
    
    hiddenHtml.append("<input type=\"hidden\" name=\"");
    hiddenHtml.append("windowName");
    hiddenHtml.append("\" value=\"");
    hiddenHtml.append(docTag.getWindowName());
    hiddenHtml.append("\">");
    
    // If in training mode then write out the username to be passed to the
    // document conversation.  This will be used to set the schema for database access.
    if (TRAINING_MODE)
    {
       //get the username from session
       UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    
       if (userProfile != null) {
           hiddenHtml.append("<input type=\"hidden\" name=\"");
           hiddenHtml.append("userName");
           hiddenHtml.append("\" value=\"");
           hiddenHtml.append(userProfile.getUserLogonID());
           hiddenHtml.append("\">");  	
       }
    }
    boolean hasTableMetaData = false;
    String docMetaDataString = DocumentLookup.lookup(docTag.getDocType().toUpperCase());

    if (docMetaDataString != null) {
      int x = docMetaDataString.indexOf("tableMetaData");
      if (x != -1) {
        hasTableMetaData = true;
      } else {
        hasTableMetaData = false;
      }
    } else {
      hiddenHtml.append("Error finding docType.");
    }

    //if the page is protecting a save docu
    if (docTag.getProtectDocument() && hasTableMetaData && !docTag.getDocExists()) {
      hiddenHtml.append("<input type=\"hidden\" name=\"promptNoDocument\" value=\"true\">");
    } else {
      hiddenHtml.append("<input type=\"hidden\" name=\"promptNoDocument\" value=\"false\">");
    }

    Map paramMap = docTag.getParameterMap();

    Iterator paramIterator = paramMap.keySet().iterator();

    while (paramIterator.hasNext()) {
      String paramName = (String) paramIterator.next();
      String paramValue = (String) paramMap.get(paramName);
      hiddenHtml.append("<input type=\"hidden\" name=\"");
      hiddenHtml.append(paramName);
      hiddenHtml.append("\" value=\"");
      hiddenHtml.append(paramValue);
      hiddenHtml.append("\">");
    }

    hiddenHtml.append("</form>");
    return hiddenHtml.toString();

  }

  public void setPageMode(String mode) {
    GrndsTrace.enterScope(TRACE_TAG + ".setPageMode");

    if (this.pageMode != null) {
      this.pageMode = mode;
    } else {
      this.pageMode = mode;
    }

    GrndsTrace.exitScope();
  }

  public String getPageMode() {
    return this.pageMode;
  }

  public static final boolean PROTECT_AS_PDF = Boolean.valueOf(
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "ProtectAsPDF"));

}