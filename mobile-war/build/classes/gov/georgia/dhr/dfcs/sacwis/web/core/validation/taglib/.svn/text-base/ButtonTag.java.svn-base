package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.InputValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.RepostCheckUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.RestrictRepostButtonValidation;

/**
 * The ButtonTag creates the input type image HTML output listed below. It will not output any HTML unless the button
 * editableMode is compatible with the page mode or if the button is disabled.
 *
 * @author Stephan P. Brauchli 2002
 */
public class ButtonTag extends BaseFormElementTag {
  private static final String TRACE_TAG = "InputTag";
  private static final String COPY = "Copy";
  private static final String NEW_USING = "NewUsing";
  private static final String[] VALID_BROWN_OUT_BUTTONS = {"btnLogon", "btnSelectStage", "btnSearch", "btnDetail", "btnView", 
                                                "btnSelectStaff", "btnLaunch", "btnApprovalStatus", "btnSelectPeriod", 
                                                "btnServicesByArea", "btnRefineSearch", "btnServices", "btnSelectPerson"};
  protected String action = null;
  protected String align = null;
  protected String form = null;
  protected String function = null;
  protected String img = null;
  protected String name = null;
  protected String onBlur = null;
  protected String tabindex = null;
  protected boolean backSafe = true;
  protected boolean navAwayCk = false;
  protected boolean restrictRepost = false;
  protected boolean preventDoubleClick = false;

  /** Default Constructor. */
  public ButtonTag() {
    super();
  }

  /** Needed to extend BaseFormElementTag. */
  public void createInput() {
  }

  /** Sets form name */
  public void setForm(String form) {
    this.form = form;
  }

  /** Sets form action */
  public void setAction(String action) {
    this.action = action;
  }

  /** Sets image name */
  public void setName(String name) {
    this.name = name;
  }

  /** Sets custom JavaScript function if supplied */
  public void setOnBlur(String onBlur) {
    this.onBlur = onBlur;
  }

  /** Sets custom JavaScript function if supplied */
  public void setFunction(String function) {
    this.function = function;
  }

  /** Sets tabindex (if supplied as variable) */
  public void setTabIndex(int tabindex) {
    this.tabindex = "" + tabindex;
  }

  /** Sets img source (required) */
  public void setImg(String img) {
    this.img = img;
  }

  /** Sets navAwayCk if boolean */
  public void setNavAwayCk(boolean ckNav) {
    this.navAwayCk = ckNav;
  }

  /** Sets restrictRepost if boolean */
  public void setRestrictRepost(boolean repostRestricted) {
    this.restrictRepost = repostRestricted;
  }

  /** Sets preventDoubleClick if boolean */
  public void setPreventDoubleClick(boolean preventDoubleClick) {
    this.preventDoubleClick = preventDoubleClick;
  }

  /** Sets backSafe */
  public void setBackSafe(String backSafe) {
    if ("true".equalsIgnoreCase(backSafe)) {
      this.backSafe = true;
    }
  }

  /** Sets validate (which determines what form submit function is called) */
  public void setAlign(String align) {
    this.align = align;
  }

  /**
   * Creates an InputValidation object to hold all data for this input and adds it to the parent form.  Also prints an
   * HTML input tag to the output stream.
   *
   * @return TagSupport constant indicating how to process the rest of the JSP page
   * @throws JspException if anything goes wrong
   */
  public int doStartTag()
          throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    JspWriter out = super.pageContext.getOut();

    FormTag parent = getParentFormTag(pageContext.getRequest(),
                                      this);
    try {
      if (super.isEditable() && (getAttribute("disabled") == null)) {
        out.print(createOpeningHtml());

        //If we create the button, add the name.x parameter to the inputs so it
        //  can be referenced in custom validation.
        if (parent != null) {
          if (this.restrictRepost) {
            parent.addInput(new RestrictRepostButtonValidation(name + ".x", null, false));
          } else {
            parent.addInput(new InputValidation(name + ".x", null, false));
          }
        }
      } else {
        out.print(createNoButtonHtml());
      }
    }
    catch (IOException ioe) {
      throw new JspException("Unable to write to JSP output", ioe);
    }

    GrndsTrace.exitScope();

    //This tag should have no body
    return BaseFormElementTag.SKIP_BODY;
  }

  /**
   * Creates the opening HTML tag for this input. when buttons are not displayed
   *
   * @return String containing HTML
   */
  protected String createNoButtonHtml() {
    GrndsTrace.enterScope(TRACE_TAG + ".createNoButtonHtml");

    StringBuffer nbBuffer = new StringBuffer();
    nbBuffer.append("&nbsp;");
    return nbBuffer.toString();
  }

  /**
   * Creates the opening HTML tag for this input.
   *
   * @return String containing HTML
   */
  protected String createOpeningHtml() {
    GrndsTrace.enterScope(TRACE_TAG + ".createOpeningHtml");
    String openingHtml = null;

    if (preventDoubleClick) {
      openingHtml = createOpeningHtml_PreventDoubleClick();
    } else {
      openingHtml = createOpeningHtml_Default();
    }

    GrndsTrace.exitScope();
    return openingHtml;
  }

  /**
   * Creates the opening HTML tag for this input.
   *
   * @return String containing HTML
   */
  private String createOpeningHtml_Default() {
    GrndsTrace.enterScope(TRACE_TAG + ".createOpeningHtml_Default");

    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    StringBuffer buffer = new StringBuffer();
    StringBuffer actionBuffer = new StringBuffer();

    //The following condition determines if we are in brown-out mode to hide all buttons except those on the exception list.
    if (ArchitectureConstants.BROWNOUT_MODE) {
      for (int i=0; i<VALID_BROWN_OUT_BUTTONS.length; i++){
        if (VALID_BROWN_OUT_BUTTONS[i].equals(img)){
          break;
        }
        else {
          if (i == VALID_BROWN_OUT_BUTTONS.length -1) {
            return createNoButtonHtml();
          }
        }
      }
    }
    
    boolean isDefaultButton = this.getParentFormTag(request, this).getDefaultButtonBoolean();

    //cjg - added for SHINES, new using button is now called copy
    String altName = img.substring(3);
    if (NEW_USING.equals(altName)) {
      altName = COPY;
    }

    if (align != null) {
      buffer.append("<div align=\"").append(align).append("\">");
    }
    buffer.append("<input type=\"image\" class=\"md\" border=\"0\" ");

    boolean returnFunctionExists = false;
    String returnFunction = "";

    if (function != null) // if developer supplies JS function
    {
      // Not all function attributes are ending with semi-colon.
      function += ";";

      // Check to see if the developer supplied function has a
      // return statement in it.  If so, use it to determine whether
      // the rest of the button's functions should be called.
      if (function.indexOf("return ") >= 0) {
        returnFunctionExists = true;

        // Get the return function by itself.  Must be the last function
        // in the string.
        returnFunction = function.substring(function.indexOf("return ") + 7);

        // Take the return function off the end.
        function = function.substring(0, function.indexOf("return "));
      }

      // Add the developer-supplied function, minus the return function if
      // there was one.
      actionBuffer.append(function);

      if (returnFunctionExists) {
        // If there was a return function, condition the rest of the processing
        // on the return value of that function.
        actionBuffer.append("var submitButtonClick = ");
        actionBuffer.append(returnFunction);
        actionBuffer.append("; if ( submitButtonClick ) { ");
      }
    }

    if (navAwayCk == false) {
      actionBuffer.append("setIsDirtyCalled(true); ");
    }
    FormTag parent = getParentFormTag(request,
                                      this);
    if (parent != null) {
      actionBuffer.append("setValidationUrl('");
    } else {
      actionBuffer.append("setActionUrl('");
    }
    actionBuffer.append(form);
       
    // Check to see if the developer supplied function for the action 
    boolean returnActionExists = false;
    if (action.indexOf("return ") >= 0) {
      returnActionExists = true;
    }
    
    if(returnActionExists == true) {
      actionBuffer.append("', ");
      actionBuffer.append(action.substring(function.indexOf("return ") + 7));
      actionBuffer.append("); ");
    } else {
      actionBuffer.append("', '");
      actionBuffer.append(action);
      actionBuffer.append("'); ");
    }
    
    if (backSafe == false) // added backSafe logic SPB 12/6/02
    {
      actionBuffer.append("if ( document.hiddenFieldStateForm.bSubmitted.value == 'true' ) ");
      actionBuffer.append("{ return false; } else { document.hiddenFieldStateForm.bSubmitted.value='true' };");
    }
    if (function != null && returnFunctionExists) // if developer supplies JS function
    {
      // If there was a return function, condition the rest of the processing
      // on the return value of that function.  If the function returns false,
      // then the onClick returns false and nothing else happens.
      actionBuffer.append(" } else { return false; } ");
    }
    String accessKey = super.getAttribute("accesskey");
    if (accessKey != null) {
      buffer.append(" accessKey=\"");
      buffer.append(accessKey);
      buffer.append("\" ");
    }
    if (onBlur != null) {
      buffer.append(" onBlur=\"");
      buffer.append(onBlur);
      buffer.append("\" ");
    }
    buffer.append(" tabindex=\"");
    buffer.append(tabindex);
    buffer.append("\" ");
    buffer.append(" id=\"");
    buffer.append(name).append("_Id");
    buffer.append("\"");
    buffer.append(" src=\"/grnds-docs/images/shared/");
    buffer.append(img);
    buffer.append(".gif\" name=\"");
    buffer.append(name);
    //EILERSBE - add alt tag
    buffer.append("\" alt=\"");
    buffer.append(altName);
    buffer.append("\" ");

    // If this ISN'T a default button, put the function in the onClick attribute.
    if (!isDefaultButton) {
      buffer.append("onClick=\"");
      buffer.append(actionBuffer.toString());
      buffer.append("\" ");
    }
    buffer.append("> ");

    //If isAddButton attribute is set to true, include hidden repost check params
    if (restrictRepost) {
      String repostCheckKey = RepostCheckUtility.createCodeKey(request);
      String repostCheckCode = RepostCheckUtility.getCodeForKey(repostCheckKey, request);

      buffer.append("<input type=\"hidden\" class=\"nomargins\" name=\"");
      buffer.append(name).append(RepostCheckUtility.ADD_DEL_SUBMIT_KEY_TAG);
      buffer.append("\" value=\"");
      buffer.append(repostCheckKey);
      buffer.append("\"/>");

      buffer.append("<input type=\"hidden\" class=\"nomargins\" name=\"");
      buffer.append(name).append(RepostCheckUtility.ADD_DEL_SUBMIT_CODE_TAG);
      buffer.append("\" value=\"");
      buffer.append(repostCheckCode);
      buffer.append("\"/>");
    }

    if (align != null) {
      buffer.append("</div>");
    }

    // If this IS a default button, but the function in the form onsubmit
    if (isDefaultButton) {
      buffer.append("\n<script type=\"text/javascript\" language=\"JavaScript1.2\">");
      buffer.append("\n  function defaultButtonOnSubmit()");
      buffer.append("\n  {");
      buffer.append("\n     ");
      buffer.append(actionBuffer.toString());
      buffer.append("\n  }");
      buffer.append("\n  ");
      buffer.append(form);
      buffer.append(".attachEvent(\"onsubmit\", defaultButtonOnSubmit);");
      buffer.append("\n</script>\n");
    }
    GrndsTrace.exitScope();
    return buffer.toString();
  }

  /**
   * Creates the opening HTML tag for this input.
   * <p/>
   * 09/10/03 RIOSJA - Implemented 'prevnentDoubleClick' functionality to prevent user from creating duplicate records
   * if they click Save multiple times.
   *
   * @return String containing HTML
   */
  private String createOpeningHtml_PreventDoubleClick() {
    GrndsTrace.enterScope(TRACE_TAG + ".createOpeningHtml_PreventDoubleClick");

    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    StringBuffer buffer = new StringBuffer();
    StringBuffer actionBuffer = new StringBuffer();

    //The following condition determines if we are in brown-out mode to hide all buttons except those on the exception list.
    if (ArchitectureConstants.BROWNOUT_MODE) {
      for (int i=0; i<VALID_BROWN_OUT_BUTTONS.length; i++){
        if (VALID_BROWN_OUT_BUTTONS[i].equals(img)){
          break;
        }
        else {
          if (i == VALID_BROWN_OUT_BUTTONS.length -1) {
            return createNoButtonHtml();
          }
        }
      }
    } 
    
    boolean isDefaultButton = this.getParentFormTag(request, this).getDefaultButtonBoolean();

    //cjg - added for SHINES, new using button is now called copy
    String altName = img.substring(3);
    if (NEW_USING.equals(altName)) {
      altName = COPY;
    }

    Boolean restrictRepostDisableButtons =
            (Boolean) request.getAttribute(RestrictRepostButtonValidation.restrictRepostDisableButtons);
    String enableClickDivId = name + "_EnableClick_Id";
    String disableClickDivId = name + "_DisableClick_Id";

    buffer.append("<div id=\"").append(enableClickDivId).append("\" style=\"Display: block\";");
    if (align != null) {
      buffer.append(" align=\"").append(align).append("\"");
    }
    buffer.append(">");

    buffer.append("<input type=\"image\" class=\"md\" border=\"0\" ");

    actionBuffer.append("document.").append(form).append(".").append(name).append("IsEnabled.value='false'; ");
    actionBuffer.append("toggleVisibility('").append(enableClickDivId).append("', 'none'); ");
    actionBuffer.append("toggleVisibility('").append(disableClickDivId).append("', 'block'); ");

    boolean returnFunctionExists = false;
    String returnFunction = "";
    if (function != null) // if developer supplies JS function
    {
      // Not all function attributes are ending with semi-colon.
      function += ";";

      // Check to see if the developer supplied function has a
      // return statement in it.  If so, use it to determine whether
      // the rest of the button's functions should be called.
      if (function.indexOf("return ") >= 0) {
        returnFunctionExists = true;

        // Get the return function by itself.  Must be the last function
        // in the string.
        returnFunction = function.substring(function.indexOf("return ") + 7);

        // Take the return function off the end.
        function = function.substring(0, function.indexOf("return "));
      }

      // Add the developer-supplied function, minus the return function if
      // there was one.
      actionBuffer.append(function);

      if (returnFunctionExists) {
        // If there was a return function, condition the rest of the processing
        // on the return value of that function.
        actionBuffer.append("var submitButtonClick = ");
        actionBuffer.append(returnFunction);
        actionBuffer.append("; if ( submitButtonClick ) { ");
      }
    }

    if (navAwayCk == false) {
      actionBuffer.append("setIsDirtyCalled(true); ");
    }
    FormTag parent = getParentFormTag(request,
                                      this);
    if (parent != null) {
      actionBuffer.append("setValidationUrl('");
    } else {
      actionBuffer.append("setActionUrl('");
    }
    actionBuffer.append(form);
    actionBuffer.append("', '");
    actionBuffer.append(action);
    actionBuffer.append("'); ");
    if (backSafe == false) // added backSafe logic SPB 12/6/02
    {
      actionBuffer.append("if ( document.hiddenFieldStateForm.bSubmitted.value == 'true' ) ");
      actionBuffer.append("{ return false; } else { document.hiddenFieldStateForm.bSubmitted.value='true' };");
    }
    if (function != null && returnFunctionExists) // if developer supplies JS function
    {
      // If there was a return function, condition the rest of the processing
      // on the return value of that function.  If the function returns false,
      // then the onClick returns false and nothing else happens.
      actionBuffer.append(" } else { ");
      // Before returning false, re-enable the Save button.
      actionBuffer.append("document.").append(form).append(".").append(name).append("IsEnabled.value='true'; ");
      actionBuffer.append("toggleVisibility('").append(enableClickDivId).append("', 'block'); ");
      actionBuffer.append("toggleVisibility('").append(disableClickDivId).append("', 'none'); ");
      actionBuffer.append("return false; } ");
    }
    String accessKey = super.getAttribute("accesskey");
    if (accessKey != null) {
      buffer.append(" accessKey=\"");
      buffer.append(accessKey);
      buffer.append("\" ");
    }
    if (onBlur != null) {
      buffer.append(" onBlur=\"");
      buffer.append(onBlur);
      buffer.append("\" ");
    }
    buffer.append(" tabindex=\"");
    buffer.append(tabindex);
    buffer.append("\" ");
    buffer.append(" id=\"");
    buffer.append(name).append("_Id");
    buffer.append("\"");
    buffer.append(" src=\"/grnds-docs/images/shared/");
    buffer.append(img);
    buffer.append(".gif\" name=\"");
    buffer.append(name);
    //EILERSBE - add alt tag
    buffer.append("\" alt=\"");
    buffer.append(altName);
    buffer.append("\" ");

    // If this ISN'T a default button, put the function in the onClick attribute.
    if (!isDefaultButton) {
      buffer.append("onClick=\"");
      buffer.append(actionBuffer.toString());
      buffer.append("\" ");
    }
    buffer.append("> ");

    //If isAddButton attribute is set to true, include hidden repost check params
    if (restrictRepost) {
      String repostCheckKey = RepostCheckUtility.createCodeKey(request);
      String repostCheckCode = RepostCheckUtility.getCodeForKey(repostCheckKey, request);

      buffer.append("<input type=\"hidden\" class=\"nomargins\" name=\"");
      buffer.append(name).append(RepostCheckUtility.ADD_DEL_SUBMIT_KEY_TAG);
      buffer.append("\" value=\"");
      buffer.append(repostCheckKey);
      buffer.append("\"/>");

      buffer.append("<input type=\"hidden\" class=\"nomargins\" name=\"");
      buffer.append(name).append(RepostCheckUtility.ADD_DEL_SUBMIT_CODE_TAG);
      buffer.append("\" value=\"");
      buffer.append(repostCheckCode);
      buffer.append("\"/>");
    }

    buffer.append("</div>");
    buffer.append("<div id=\"").append(disableClickDivId).append("\" style=\"Display: none\";");
    if (align != null) {
      buffer.append(" align=\"").append(align).append("\"");
    }
    buffer.append(">");
    buffer.append("<img class=\"md\" border=\"0\" ");
    buffer.append("tabindex=\"").append(tabindex).append("\" ");
    buffer.append("src=\"/grnds-docs/images/shared/").append(img).append("_Off.gif\" ");
    buffer.append("alt=\"").append(altName).append("\">");
    buffer.append("</div>");
    if (restrictRepostDisableButtons != null &&
        restrictRepostDisableButtons == true) {
      buffer.append("<input type=\"hidden\" name=\"").append(name).append("IsEnabled\" value='false'>");
    } else {
      buffer.append("<input type=\"hidden\" name=\"").append(name).append("IsEnabled\" value='true'>");
    }
    String initializeSaveButton =
            "\nif( document." + form + "." + name + "IsEnabled.value == \"true\" )" +
            "\n{" +
            "\n  toggleVisibility( \"" + enableClickDivId + "\", \"block\"); " +
            "\n  toggleVisibility( \"" + disableClickDivId + "\", \"none\"); " +
            "\n}" +
            "\nelse" +
            "\n{" +
            "\n  toggleVisibility( \"" + enableClickDivId + "\", \"none\"); " +
            "\n  toggleVisibility( \"" + disableClickDivId + "\", \"block\"); " +
            "\n}";
    buffer.append("\n<script type=\"text/javascript\" language=\"JavaScript1.2\">");
    buffer.append("\n  function initializeButton_").append(name).append("()");
    buffer.append("\n  {");
    buffer.append("\n     ");
    buffer.append(initializeSaveButton);
    buffer.append("\n  }");
    buffer.append("\n window.attachEvent(\"onload\", initializeButton_").append(name).append(");");
    buffer.append("\n</script>\n");

    // If this IS a default button, but the function in the form onsubmit
    if (isDefaultButton) {
      buffer.append("\n<script type=\"text/javascript\" language=\"JavaScript1.2\">");
      buffer.append("\n  function defaultButtonOnSubmit()");
      buffer.append("\n  {");
      buffer.append("\n     ");
      buffer.append(actionBuffer.toString());
      buffer.append("\n  }");
      buffer.append("\n  ");
      buffer.append(form);
      buffer.append(".attachEvent(\"onsubmit\", defaultButtonOnSubmit);");
      buffer.append("\n</script>\n");
    }
    GrndsTrace.exitScope();
    return buffer.toString();
  }
}