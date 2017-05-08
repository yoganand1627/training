<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.spring.SJSASContextSingletonBeanFactoryLocator" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.spring.SpringConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.external.AddressValidator" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.external.PhoneticSearchService" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.external.impl.AddressValidatorImpl" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchQuery" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchResultSet" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.person.impl.NameSearchQuery" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.AddressValidatorSI" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.DocumentLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.DocumentServicesHandler" %>
<%@ page import="java.io.StringReader" %>
<%@ page import="java.io.StringWriter" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="org.exolab.castor.xml.Marshaller" %>
<%@ page import="org.exolab.castor.xml.Unmarshaller" %>
<%@ page import="org.springframework.beans.factory.BeanFactory" %>
<%@ page import="org.springframework.beans.factory.access.BeanFactoryLocator" %>

<pre>

<%
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

%>

</pre>
