package gov.georgia.dhr.dfcs.sacwis.structs.output.ws.cprscaseidlist;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CprsQueryCaseListWO implements Serializable {
  private List<CaseData> cases = null;
  
  private String message = null;
  
  public static class CaseData implements Serializable {
    private String caseId = null;

    private String caseName = null;
    
    private String county = null;
    
    private Date dateLastModified = null;
    
    private List<Name> primaryChildren = null;
    
    private String message = null;
    
    private Date dateGenerated = null;

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public String getCaseId() {
      return caseId;
    }

    public void setCaseId(String caseId) {
      this.caseId = caseId;
    }

    public String getCaseName() {
      return caseName;
    }

    public void setCaseName(String caseName) {
      this.caseName = caseName;
    }

    public String getCounty() {
      return county;
    }

    public void setCounty(String county) {
      this.county = county;
    }

    public Date getDateLastModified() {
      return dateLastModified;
    }

    public void setDateLastModified(Date dateLastModified) {
      this.dateLastModified = dateLastModified;
    }

    public List<Name> getPrimaryChildren() {
      return primaryChildren;
    }

    public void setPrimaryChildren(List<Name> primaryChildren) {
      this.primaryChildren = primaryChildren;
    }

    public Date getDateGenerated() {
      return dateGenerated;
    }

    public void setDateGenerated(Date dateGenerated) {
      this.dateGenerated = dateGenerated;
    }
  }
  
  public static class Name implements Serializable {
    private String lastName = null;

    private String firstName = null;
    
    private String middleName = null;

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public String getMiddleName() {
      return middleName;
    }

    public void setMiddleName(String middleName) {
      this.middleName = middleName;
    }
  }

  public List<CaseData> getCases() {
    return cases;
  }

  public void setCases(List<CaseData> cases) {
    this.cases = cases;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
