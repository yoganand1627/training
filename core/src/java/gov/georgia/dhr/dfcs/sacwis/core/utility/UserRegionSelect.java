package gov.georgia.dhr.dfcs.sacwis.core.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;

/**
 * @author piazzaat
 *         <p/>
 *         Tag that generates html SELECT and OPTION tags for regions that the user can choose on MPS.
 *         <p/>
 *         <pre>
 *         <p/>
 *                 Change History:
 *                 Date         User        Description
 *                 -------      ---------   ---------------------------------------------
 *                 7/25/05      ROBERTSW    Moved JdbcHelper.getConnection(); to inside the
 *                                          try.
 *                 8/03/05      cooganpj    SIR - 23845 Added value attribute so that the previously
 *                                          selected region will re-display for refined searches.
 *         <p/>
 *                 </pre>
 */
public class UserRegionSelect implements Tag {
  protected PageContext pageContext;
  private Tag parent;
  private int personId;
  private String value;
  private String tabIndex;
  private String name;
  private String id;
  private String onChange;
  private String style;
  private String title;
  private boolean blankValue;

  public void setPageContext(PageContext value) {
    this.pageContext = value;
  }

  public void setParent(Tag value) {
    this.parent = value;
  }

  public Tag getParent() {
    return this.parent;
  }

  public int doStartTag()
          throws JspException {
    if (personId == 0) {
      throw new JspException("personId attribute has not been initialized");
    }

    JspWriter out = pageContext.getOut();
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      con = JdbcHelper.getConnection();
      preparedStatement = con.prepareStatement(SQL);
      preparedStatement.setInt(1, personId);
      preparedStatement.setInt(2, personId);

      resultSet = preparedStatement.executeQuery();

      out.write(generateSelectTagFromResultSet(resultSet));
    }
    catch (Exception e) {
      throw new JspException(e);
    }
    finally {
      try {
        if (resultSet != null) {
          resultSet.close();
        }
      } catch (SQLException e) {
      }
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } catch (SQLException e) {
      }
      try {
        if (con != null && !con.isClosed()) {
          con.close();
        }
      } catch (SQLException e) {
      }
    }

    return (SKIP_BODY);
  }

  public int doEndTag()
          throws JspException {
    return EVAL_PAGE;
  }

  public void release() {
    parent = null;
    pageContext = null;
    personId = 0;
  }

  public void setPersonId(String value) throws JspException {
    try {
      this.personId = Integer.parseInt(value);
    }
    catch (NumberFormatException e) {
      throw new JspException(e);
    }
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void setBlankValue(String value) {
    this.blankValue = new Boolean(value);
  }

  public void setName(String value) {
    this.name = value;
  }

  public void setId(String value) {
    this.id = value;
  }

  public void setOnChange(String value) {
    this.onChange = value;
  }

  public void setStyle(String value) {
    this.style = value;
  }

  public void setTabIndex(String value) {
    this.tabIndex = value;
  }

  public void setTitle(String value) {
    this.title = value;
  }

  private String generateSelectTagFromResultSet(ResultSet rs) throws JspException {
    StringBuffer result = new StringBuffer();
    String separator = System.getProperty("line.separator");

    result.append("<select");
    if (tabIndex != null) {
      result.append(" tabIndex='").append(tabIndex).append("'");
    }
    if (name != null) {
      result.append(" name='").append(name).append("'");
    }
    if (id != null) {
      result.append(" id='").append(id).append("'");
    }
    if (onChange != null) {
      result.append(" onChange='").append(onChange).append("'");
    }
    if (style != null) {
      result.append(" style='").append(style).append("'");
    }
    if (title != null) {
      result.append(" title='").append(title).append("'");
    }
    result.append(">");
    result.append(separator);

    if (blankValue) {
      result.append("<option value=''>");
      result.append(separator);
    }

    try {
      while (rs.next()) {
        String region = rs.getString(1);
        result.append("<option value='").append(region).append("'");
        if (value.equals(region)) {
          result.append(" selected >");
        } else {
          result.append(">");
        }
        result.append("Region ");
        result.append(region);
        result.append("</option>");
        result.append(separator);
      }
    }
    catch (SQLException e) {
      throw new JspException(e);
    }

    result.append("</select>");

    return result.toString();
  }

  private static final String SQL =
          "(select distinct cd_wkld_stage_region as region from workload where id_wkld_person = ? and cd_wkld_stage_region in ('01','02','03','04','05','06','07','08','09','10','11') union select substr(cd_emp_unit_region,2,2) as region from employee where id_person = ? and substr(cd_emp_unit_region, 1, 1) = '0') order by region asc";
}
