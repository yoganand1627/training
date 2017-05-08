package gov.georgia.dhr.dfcs.sacwis.web.document;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.tags.BaseDocTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.tags.DocParameterInterface;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class DocumentTag extends BaseDocTag implements Cloneable {
  private static String TRACE_TAG = "DocumentTag";
  private static String SHOW_DOCUMENT_URL = "/document/DocumentConversation/showDocument";

  private boolean docExists;
  private int checkStage;
  private String displayName = null;
  private String docType = null;
  private String action = null;
  private String validationParameters = null;
  private String savePage;
  private String name;
  private Map<String, String> parameterList;
  private boolean postInSameWindow = false;
  private boolean checkForNewMode = true;
  private boolean protectDocument = false;
  private boolean commentMode = false;
  private boolean hideInWidget = false;
  private boolean deleteDocument = false;
  private boolean preFillAlways = false;
  private String onClick = null;
  private String windowName = null;

  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    this.initDocumentTag();
    GrndsTrace.exitScope();
    return Tag.EVAL_BODY_INCLUDE;
  }

  public int doEndTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    createDoc();
    GrndsTrace.exitScope();
    return Tag.EVAL_BODY_INCLUDE;
  }

  protected void initDocumentTag() {
    this.setParameterMap(null);
  }

  public void setParameterMap(Map<String, String> paramList) {
    if (paramList == null) {
      this.parameterList = new HashMap<String, String>();
    } else {
      this.parameterList = paramList;
    }
  }

  public Map<String, String> getParameterMap() {
    return this.parameterList;
  }

  public void addParameter(DocParameterInterface param) {
    GrndsTrace.enterScope(TRACE_TAG + ".addParameter(" + param + ")");

    DocumentParameterTag docParamTag = (DocumentParameterTag) param;
    GrndsTrace.msg(TRACE_TAG, 7, "parameter name is:" + docParamTag.getName());
    GrndsTrace.msg(TRACE_TAG, 7, "parameter value is:" + docParamTag.getValue());

    this.parameterList.put(docParamTag.getName(), docParamTag.getValue());
    GrndsTrace.exitScope();
  }

  protected void createDoc() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".createDoc");

    if (this.getAction() == null || "".equals(this.getAction())) {
      this.setAction(SHOW_DOCUMENT_URL);
    }

    DocumentContainer parent = (DocumentContainer) findAncestorWithClass(this, DocumentContainer.class);
    DocumentTag dt = (DocumentTag) this.clone();
    parent.addDoc(dt);
    GrndsTrace.exitScope();
  }

  public void setValidationParameters(String validationParams) {
    this.validationParameters = validationParams;
  }

  public String getValidationParameters() {
    return this.validationParameters;
  }

  public void setProtectDocument(boolean protectDocument) {

    // Added support for Brown Out mode
    if (ArchitectureConstants.BROWNOUT_MODE) {
      this.protectDocument = true;
    } else {
      this.protectDocument = protectDocument;
    }
  }

  public boolean getProtectDocument() {
    return this.protectDocument;
  }

  public void setDocExists(boolean docExists) {
    this.docExists = docExists;
  }

  public boolean getDocExists() {
    return this.docExists;
  }

  public void setPromptSavePage(String savePage) {
    this.savePage = savePage;
  }

  public String getPromptSavePage() {
    return this.savePage;
  }

  public void setPostInSameWindow(boolean postInSameWindow) {
    this.postInSameWindow = postInSameWindow;
  }

  public boolean getPostInSameWindow() {
    return this.postInSameWindow;
  }

  public void setCheckForNewMode(boolean checkForNewMode) {
    this.checkForNewMode = checkForNewMode;
  }

  public boolean getCheckForNewMode() {
    return this.checkForNewMode;
  }

  public void setCheckStage(int checkStage) {
    this.checkStage = checkStage;
  }

  public int getCheckStage() {
    return this.checkStage;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return this.displayName;
  }

  public void setDeleteDocument(boolean deleteDocument) {
    this.deleteDocument = deleteDocument;
  }

  public boolean getDeleteDocument() {
    return this.deleteDocument;
  }

  public void setDocType(String docType) {
    this.docType = docType;
  }

  public String getDocType() {
    return this.docType;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getAction() {
    return this.action;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setHideInWidget(boolean hideInWidget) {
    this.hideInWidget = hideInWidget;
  }

  public boolean getHideInWidget() {
    return this.hideInWidget;
  }

  public void setOnClick(String onClick) {
    this.onClick = onClick;
  }

  public String getOnClick() {
    return this.onClick;
  }

  public void setWindowName(String name) {
    this.windowName = name;
  }

  public String getWindowName() {
    return this.windowName;
  }
  
  public boolean getPreFillAlways() {
    return preFillAlways;
  }

  public void setPreFillAlways(boolean preFillAlways) {
    this.preFillAlways = preFillAlways;
  }

  public DocumentTag() {
  }

  private DocumentTag(boolean protectDocument, boolean docExists,
                      int checkStage, String displayName, String docType,
                      String action, Map<String, String> paramList, String validationParams,
                      String savePage, String name, boolean postInSameWindow,
                      boolean checkForNewMode, boolean hideInWidget,
                      String onClick, String windowName, boolean deleteDocument, 
                      boolean preFillAlways, boolean commentMode) {

    this.setProtectDocument(protectDocument);
    this.setDocExists(docExists);
    this.setCheckStage(checkStage);
    this.setDisplayName(displayName);
    this.setDocType(docType);
    this.setAction(action);
    this.setParameterMap(paramList);
    this.setValidationParameters(validationParams);
    this.setPromptSavePage(savePage);
    this.setName(name);
    this.setPostInSameWindow(postInSameWindow);
    this.setCheckForNewMode(checkForNewMode);
    this.setHideInWidget(hideInWidget);
    this.setOnClick(onClick);
    this.setWindowName(windowName);
    this.setDeleteDocument(deleteDocument);
    this.setPreFillAlways(preFillAlways);
    this.setCommentMode(commentMode);

  }

  /**
   * This is not a real clone() method; it just makes a new instance with the same data.
   *
   * @return
   */
  public Object clone() {
    return new DocumentTag(this.getProtectDocument(),
                           this.getDocExists(),
                           this.getCheckStage(),
                           this.getDisplayName(),
                           this.getDocType(),
                           this.getAction(),
                           this.getParameterMap(),
                           this.getValidationParameters(),
                           this.getPromptSavePage(),
                           this.getName(),
                           this.getPostInSameWindow(),
                           this.getCheckForNewMode(),
                           this.getHideInWidget(),
                           this.getOnClick(),
                           this.getWindowName(),
                           this.getDeleteDocument(),
                           this.getPreFillAlways(),
                           this.isCommentMode());
  }

  public boolean isCommentMode() {
    return commentMode;
  }

  public void setCommentMode(boolean commentMode) {
    this.commentMode = commentMode;
  }

}