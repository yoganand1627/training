package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.spring.SJSASContextSingletonBeanFactoryLocator;
import gov.georgia.dhr.dfcs.sacwis.core.spring.SpringConstants;
import gov.georgia.dhr.dfcs.sacwis.service.external.AddressValidator;
import gov.georgia.dhr.dfcs.sacwis.service.external.PhoneticSearchService;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.AddressValidatorImpl;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchQuery;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchResultSet;
import gov.georgia.dhr.dfcs.sacwis.service.person.impl.NameSearchQuery;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AddressValidatorSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentLookup;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentServicesHandler;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;

public final class testConnections_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<pre>\r\n\r\n");

  /****************************************************
   ** Description: CHECK IF ALL SYSTEMS ARE A GO   *****
   ** Author:  Kapil Aggarwal
   ** Date:    10/24/2006
   **
   ** Updated by swrboerts on 2/18 to clean up architecture tests
   *****************************************************/

  final String MSG_INVALID_LOGIN = "You are not a registered user of SHINES.  Please contact the Help Desk for assistance.";
  out.println("Architecture Test\n\n\n");

  /*****************************************************
   ****** Begin JDBC Connection Pool Test ***************
   *****************************************************/

  out.print("Database Connection:");

  Connection connection = null;
  PreparedStatement statement = null;
  ResultSet results = null;
  try {
    // Using a connection from the system
    connection = JdbcHelper.getConnection();
    String sql = "select sysdate from dual";
    statement = connection.prepareStatement(sql);
    results = statement.executeQuery();
    out.println("SUCCESS");
  } catch (Exception e) {
    out.println("ERROR\n");
    out.println("Exception:" + e.getMessage());
  }
  // Clean up after ourselves
  finally {
    try {
      results.close();
      statement.close();
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (Exception e) {
      out.println("ERROR\n");
      out.println("Exception:" + e.getMessage());
    }
  }
  out.print("\n");

  /*****************************************************
   ****** Address Validator Test          ***************
   *****************************************************/

  out.print("Address Validation:");

  try {
    AddressValidatorSI addressValidatorSI = new AddressValidatorSI();
    addressValidatorSI.setAddress1("623 ROCK SPRINGS CT NE");
    addressValidatorSI.setCity("ATLANTA");
    addressValidatorSI.setState("GA");
    addressValidatorSI.setZipCode("30306-2327");
    AddressValidator val = new AddressValidatorImpl();
    AddressValidatorSO tmp = val.validate(addressValidatorSI);
    out.println(tmp != null ? "SUCCESS" : "ERROR");
  } catch (Exception e) {
    out.println("ERROR\n");
    out.println("Exception:" + e.getMessage());
  }

  out.print("\n");

  /*****************************************************
   ****** LDAP Server Functional Test    ***************
   *****************************************************/

  out.print("Novell LDAP Server:");

  try {
    UserProfileHelper.validateLogin("shinestest", "georgia");
    out.println("SUCCESS");
  } catch (Exception e) {
    // Test to see if we get the expected error message.
    if (MSG_INVALID_LOGIN.equals(e.getMessage())) {
      out.println("SUCCESS");
    } else
    {
      out.println("ERROR");
      out.println("Exception:" + e.getMessage());
    }
  }
  out.print("\n");

  /*****************************************************
   ****** Phonetic Search Test    ***********************
   *****************************************************/

  out.print("Phonetic Search:");

  NameSearchQuery nameSearchQuery = new NameSearchQuery();
  nameSearchQuery.setSearchScope(PhoneticSearchQuery.SEARCH_TYPICAL);
  nameSearchQuery.setMatchTolerance(PhoneticSearchQuery.MATCH_TYPICAL);
  PhoneticSearchResultSet searchResults;
  nameSearchQuery.setLastName("Diag");
  nameSearchQuery.setFirstName("Jacob");
  try {
    BeanFactoryLocator locator =
            SJSASContextSingletonBeanFactoryLocator.getInstance(SpringConstants.SERVICE_CONTEXT_SELECTOR);
    BeanFactory beanFactory = locator.useBeanFactory(SpringConstants.SERVICE_BEAN_FACTORY).getFactory();
    searchResults =
            ((PhoneticSearchService) beanFactory.getBean("phoneticSearchService")).executeSearch(nameSearchQuery);
    out.println("SUCCESS");
  } catch (Exception e) {
    out.println("ERROR");
    out.println("Exception:" + e.getMessage());
  }
  out.print("\n");

  /*****************************************************
   ****** Forms Service Test    ************************
   *****************************************************/

  out.print("Forms Service:");
  try {

    // Lookup metadata for call narrative
    String docMetaDataString = DocumentLookup.lookup("CALLNARR");

    //Marshall string into object
    DocumentMetaData documentMetaData;
    /****************************************************************************
     * Unmarshall the string pulled from the JNDI into the DocumentMetaData object
     ****************************************************************************/
    StringReader stringReader = new StringReader(docMetaDataString);
    // Unmarshall the Xml String into the DocumentMetaData object
    documentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, stringReader);

    // Make sure the doc exists is false so the service
    // gets a new document.
    documentMetaData.setDocumentExists(false);
    documentMetaData.setRenderFormat(RenderType.HTML_WITH_SHELL);

    //Unmarshall back into xmlMetaData
    StringWriter stringWriter = new StringWriter();
    Marshaller.marshal(documentMetaData, stringWriter);

    //Set xmlMetaData to new string
    docMetaDataString = stringWriter.toString();

    //Call webservice to get new document
    DocumentServicesHandler.showDocument(documentMetaData, docMetaDataString, "");

    out.println("SUCCESS");
  } catch (Exception e) {
    out.println("ERROR");
    out.println("Exception:");
    out.println(e.getMessage());
  }
  out.print("\n");

  session.invalidate();


      out.write("\r\n\r\n</pre>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
