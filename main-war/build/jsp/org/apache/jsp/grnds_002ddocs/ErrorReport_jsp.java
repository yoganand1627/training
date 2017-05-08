package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.zip.InflaterInputStream;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;

public final class ErrorReport_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  //XML error reports weren't parsing correctly so here's a mini parser
  public String getElementData(String xmlString, String elementName) {
    String elementData;
    if (xmlString.indexOf(elementName) > 0) {
      int start = xmlString.indexOf(elementName) + elementName.length() + 1;
      int end = xmlString.indexOf(elementName, start + 1) - 2;
      elementData = xmlString.substring(start, end).trim();
    } else {
      // Guarantees that elementData is never null.
      elementData = "&nbsp;";
    }
    return elementData;
  }


  //Bean class to contain data for each error
  public class ErrorRow implements Comparable<ErrorRow> {

    public String errorId;
    public String personId;
    public String timeStamp;
    public String sourceClassName;
    public String sourceFileName;
    public String sourceLineNumber;
    public String message;
    public int count = 0;

    public ErrorRow(String errorId, String personId, String timeStamp, String sourceClassName, String sourceFileName,
                    String sourceLineNumber, String message) {
      this.errorId = errorId;
      this.personId = personId;
      this.timeStamp = timeStamp;
      this.sourceClassName = sourceClassName;
      this.sourceFileName = sourceFileName;
      this.sourceLineNumber = sourceLineNumber;
      this.message = message;
    }

    public String getErrorId() {
      return errorId;
    }

    public String getPersonId() {
      return personId;
    }

    public String getTimeStamp() {
      return timeStamp;
    }

    public String getSourceClassName() {
      return sourceClassName;
    }

    public String getSourceFileName() {
      return sourceFileName;
    }

    public String getSourceLineNumber() {
      return sourceLineNumber;
    }

    public String getMessage() {
      return message;
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    public int compareTo(ErrorRow errorRow) {
      // Check file, class and line.
      int c;
      if (0 != (c = this.getSourceFileName().compareTo(errorRow.getSourceFileName()))) {
        return c;
      }
      if (0 != (c = this.getSourceClassName().compareTo(errorRow.getSourceClassName()))) {
        return c;
      }
      if (0 != (c = this.getSourceLineNumber().compareTo(errorRow.getSourceLineNumber()))) {
        return c;
      }
      return 0;
    }

    public boolean equals(Object object) {
      if (object instanceof ErrorRow) {
        ErrorRow errorRow = (ErrorRow) object;
        //Compare class, file, line
        if (this.getSourceClassName().equals(errorRow.getSourceClassName()) &&
            this.getSourceFileName().equals(errorRow.getSourceFileName()) &&
            this.getSourceLineNumber().equals(errorRow.getSourceLineNumber())) {
          return true;
        }
      }
      return false;
    }

    public int hashCode() {
      return 17 * getSourceFileName().hashCode() +
             37 * getSourceClassName().hashCode() +
             53 * getSourceLineNumber().hashCode();
    }
  }

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<html>\r\n<head>\r\n  <title>SACWIS Error Management Reporting Tool</title>\r\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=");
      out.print(ArchitectureConstants.CHARACTER_ENCODING);
      out.write("\">\r\n  <link href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\r\n</head>\r\n<body>\r\n<h2>SACWIS Error Report</h2>\r\n\r\n<h3>Report of exceptions logged through the SACWIS error page</h3>\r\n");

  long start = System.currentTimeMillis();
  Connection connection = null;
  PreparedStatement stmt = null;
  ResultSet rs = null;
  List<ErrorRow> errorList = new ArrayList<ErrorRow>();
  int recordCount = 0;
  int rowCount = 0;  //used for unique rows
  try {
    connection = JdbcHelper.getConnection();
    //Retrieve the number of errors currently in the errors table.
    stmt = connection.prepareStatement("SELECT COUNT(*) FROM IMPACT_ERRORS");
    rs = stmt.executeQuery();
    if (rs.next()) {
      recordCount = rs.getInt(1);
    }
  } catch (Exception e) {
    out.print("Failure retreiving record count.");
    //noinspection UnhandledExceptionInJSP
    throw new JspException(e);
  } finally {
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
      }
    }
    if (stmt != null) {
      try {
        stmt.close();
      } catch (SQLException e) {
      }
    }
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (SQLException e) {
    }
  }
  out.println("Total number of error records to parse: " + recordCount + "<br/>");
  out.println("Report will take approximately " + (recordCount * 170 / 1000) + " seconds to generate.<br/>");
  out.flush();
  if (request.getParameter("generateReport") == null) {

      out.write("\r\n<form action=\"ErrorReport.jsp\">\r\n  Only show unique records: <input type=\"checkbox\" name=\"filter\" checked/><br/>\r\n  <input type=\"submit\" name=\"generateReport\" value=\"Generate Report\"/>\r\n</form>\r\n");

} else {
  // Note this page produces html
  response.setContentType("text/html; UTF-8");
  try {
    connection = JdbcHelper.getConnection();
    //Retrieve each of the rows.
    stmt = connection.prepareStatement("SELECT BL_ERROR, ID_ERROR, ID_PERSON FROM IMPACT_ERRORS ORDER BY ID_ERROR");
    rs = stmt.executeQuery();
    //loop through records displaying in table format the relevant information.
    String xmlString;
    String errorId = "";
    String personId = "";
    out.println("Processing error number: ");
    while (rs.next()) {
      try {
        //Retrieve fields from the row
        personId = rs.getString(3);
        errorId = rs.getString(2);
        //Output something every 10 records so we know whats going on.
        if (Integer.parseInt(errorId) % 10 == 0) {
          out.println(errorId + "..");
          out.flush();
        }
        //Get the blob
        java.io.InputStream bs = rs.getBlob(1).getBinaryStream();
        //Uncompress the blob
        ObjectInputStream ois = null;
        try {
          ois = new ObjectInputStream(new InflaterInputStream(bs));
          xmlString = (String) ois.readObject();
        } finally {
          if (ois != null) {
            ois.close();
          }
        }
      } catch (Exception ex) {
        out.print("<p>Failure reading error record.</p>");
        xmlString = "";
      }
      //Create error row object
      ErrorRow errorRow = new ErrorRow(errorId, personId, getElementData(xmlString, "time_stamp"),
                                       getElementData(xmlString, "source_class_name"),
                                       getElementData(xmlString, "source_file_name"),
                                       getElementData(xmlString, "source_line_number"),
                                       getElementData(xmlString, "message"));
      //Sort object
      errorList.add(errorRow);
    }

    //Sort records by natural order
    Collections.sort(errorList);

    //Create unique list of error rows
    Iterator it1 = errorList.iterator();
    List<ErrorRow> uniqueErrorList = new ArrayList<ErrorRow>();
    ErrorRow previousER = null;
    int count = 0;
    //Loop through sorted list removing duplicates
    while (it1.hasNext()) {
      ErrorRow er = (ErrorRow) it1.next();
      //Skip to next record if previous one was null - only happens first time through
      if (previousER != null) {
        //Always increment count
        count++;
        //Compare this error row to the previous one
        if (!er.equals(previousER)) {
          //If not equal, this one is unique
          //System.out.println( "prev:" + previousER.getSourceClassName() + ":" + previousER.getSourceFileName() + ":" + previousER.getSourceLineNumber() );
          //System.out.println( " new:" + er.getSourceClassName() + ":" + er.getSourceFileName() + ":" + er.getSourceLineNumber() + "\n");
          //System.out.println(" count: " + count );
          //Set the count for the previous one and add it into the list
          previousER.setCount(count);
          uniqueErrorList.add(previousER);
          //Reset the previousER to this er, since it is a new one and reset the counter
          previousER = er;
          count = 0;
        }
      } else {
        //If previousER is null, set it.  (Should only happen on first one)
        previousER = er;
      }
    }

    //Comparator to sort by count of each type of error
    Comparator<ErrorRow> countComparator = new Comparator<ErrorRow>() {
      public int compare(ErrorRow er, ErrorRow er1) {
        //Compare count
        if (er.getCount() == er1.getCount()) {
          return 0;
        } else {
          //Make it sort in descending order
          return er1.getCount() - er.getCount();
        }
      }
    };
    //Sort list by count for the type of error
    Collections.sort(uniqueErrorList, countComparator);
    //Create iterator to loop through list of errors
    Iterator it = uniqueErrorList.iterator();
    if (request.getParameter("filter") == null) {
      it = errorList.iterator();
    }

      out.write("\r\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\">\r\n  <tr>\r\n    <th class=\"thList\" style=\"white-space:pre;\">Error ID</th>\r\n    <th class=\"thList\" style=\"white-space:pre;\">Count</th>\r\n    <th class=\"thList\" style=\"white-space:pre;\">Person ID</th>\r\n    <th class=\"thList\" style=\"white-space:pre;\">Time</th>\r\n    <th class=\"thList\" style=\"white-space:pre;\">Source Class</th>\r\n    <th class=\"thList\" style=\"white-space:pre;\">Source File</th>\r\n    <th class=\"thList\" style=\"white-space:pre;\">Line Number</th>\r\n    <th class=\"thList\" style=\"white-space:pre;\">Message</th>\r\n    <th class=\"thList\" style=\"white-space:pre;\">Link</th>\r\n  </tr>\r\n  ");

    while (it.hasNext()) {
      ErrorRow er = (ErrorRow) it.next();
  
      out.write("\r\n  <tr class='");
      out.print(rowCount % 2 == 0 ? "odd" : "even");
      out.write("'>\r\n    <td>");
      out.print( er.errorId);
      out.write("\r\n    </td>\r\n    <td>");
      out.print( er.count);
      out.write("\r\n    </td>\r\n    <td>");
      out.print( er.personId);
      out.write("\r\n    </td>\r\n    <td>");
      out.print( er.timeStamp);
      out.write("\r\n    </td>\r\n    <td>");
      out.print( er.sourceClassName);
      out.write("\r\n    </td>\r\n    <td>");
      out.print( er.sourceFileName);
      out.write("\r\n    </td>\r\n    <td>");
      out.print( er.sourceLineNumber);
      out.write("\r\n    </td>\r\n    <td>");
      out.print( (er.message.length() > 300) ? er.message.substring(0, 300) : er.message.trim());
      out.write("\r\n    </td>\r\n    <td>\r\n      <a href=\"/grnds-docs/ErrorDetails.jsp?ID_ERROR=");
      out.print( er.errorId.trim());
      out.write("\">/grnds-docs/ErrorDetails.jsp?ID_ERROR=");
      out.print(
      er.errorId.trim());
      out.write("\r\n      </a></td>\r\n  </tr>\r\n  ");

      rowCount++;
    } 
      out.write("\r\n</table>\r\n");

    } catch (Exception e) {
      out.print("Failure retreiving records.");
      //noinspection UnhandledExceptionInJSP
      throw new JspException(e);
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (stmt != null) {
          stmt.close();
        }
        if (connection != null) {
          connection.close();
        }
      } catch (Exception e) {
        out.print("<error>Failure closing database connections.</error>");
      }
    }
  }
  long end = System.currentTimeMillis();
  out.println("Total Number of Unique Errors: " + rowCount);
  out.println("<br/>Total Page Load Time: " + (end - start) / 1000 + " seconds");

      out.write("\r\n</body>\r\n</html>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
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
