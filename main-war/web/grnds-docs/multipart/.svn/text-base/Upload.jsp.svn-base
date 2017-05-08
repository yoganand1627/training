<%--
JSP Name:     Upload.jsp
Created by:   Bhavna Gehlot
Date Created: 11/08/2006

Description:
This JSP displays the upload Window and uploads the document to the SACWIS 
from the External Documentation Detail Page.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>

<%
  //Set the page mode
  String pageMode = PageModeConstants.EDIT;

  // initialize the tabIndex to 0
  int tabIndex = 1;
%>


<impact:validateForm name="frmUpload"
                     method="post"
                     action="/multipart/ExternalDcmnttn/uploadExtDoc"
                     pageMode="<%=pageMode%>"
                     schema="/WEB-INF/Constraints.xsd"
                     encType="multipart/form-data">
  <impact:validateErrors formName="frmUpload"/>

  <!-- Hidden Fields -->
  <impact:validateInput type="hidden" name="hdnPageName" value="Upload"/>

  <Script type="text/javascript" language="JavaScript">
    window.onunload = function ()
    {
      //window.opener.navigate(window.opener.document.location.href);
      //alert("Window closing");
      window.close();

    }

    function testFileExtension() {
      var correctType = false;
      var filename = document.frmUpload.txtSzFileName.value;
      alert(filename);
      if (filename.length > 0) {
        var indexOf = filename.indexOf('.');
        if (indexOf != -1) {
          var start = indexOf + 1;
          var ext = filename.substr(start, filename.length);
          alert(ext);
          if ('jpg' == ext || 'pdf' == ext) {
            correctType = true;
          } else {
            alert("Uploads can only be pictures .jpg or Adobe PDFs .pdf)");
          }
        } else {
          alert("Uploads can only be pictures .jpg or Adobe PDFs .pdf");
        }
      } else {
        alert("Please enter a filename");
      }

      return correctType;
    }

  </script>

  <!--- Begin Table --->
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <impact:validateInput name="txtSzFileName"
                              type="file"
                              size="36"
                              tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
    </tr>
  </table>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr align="center">
      <td>
        <impact:ButtonTag name="btnSubmit"
                          img="btnSubmit"
                          form="frmUpload"
                          action="#"
                          restrictRepost="true"
                          tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <impact:ButtonTag name="btnReset"
                          img="btnReset"
                          form="frmUpload"
                          action="#"
                          function="return reset()"
                          restrictRepost="true"
                          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>

</impact:validateForm>