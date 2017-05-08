package gov.georgia.dhr.dfcs.sacwis.web.financials;

import java.io.Serializable;

public class FinancialAccountDB
        implements Serializable {
  protected String accountType = "";
  protected String accountNumber = "";
  protected String personName = "";
  protected int accountId = 0;
  protected int personId = 0;

  protected int searchPersonId = 0;
  protected String searchAccountType = "";
  protected String searchProgram = "";
  protected String searchRegion = "";
  protected String searchCounty = "";

  public void clearNonSearchValues() {
    accountType = "";
    accountNumber = "";
    personName = "";
    accountId = 0;
    personId = 0;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public String getPersonName() {
    return personName;
  }

  public void setPersonName(String personName) {
    this.personName = personName;
  }

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public int getSearchPersonId() {
    return searchPersonId;
  }

  public void setSearchPersonId(int searchPersonId) {
    this.searchPersonId = searchPersonId;
  }

  public String getSearchAccountType() {
    return searchAccountType;
  }

  public void setSearchAccountType(String searchAccountType) {
    this.searchAccountType = searchAccountType;
  }

  public String getSearchProgram() {
    return searchProgram;
  }

  public void setSearchProgram(String searchProgram) {
    this.searchProgram = searchProgram;
  }

  public String getSearchRegion() {
    return searchRegion;
  }

  public void setSearchRegion(String searchRegion) {
    this.searchRegion = searchRegion;
  }

  public String getSearchCounty() {
    return searchCounty;
  }

  public void setSearchCounty(String searchCounty) {
    this.searchCounty = searchCounty;
  }

  public String toString() {
    return
            "FinancialAccountDB: " +
            " accountNumber: " + accountNumber + "\n" +
            " accountType: " + accountType + "\n" +
            " personName: " + personName + "\n" +
            " accountId: " + accountId + "\n" +
            " personId: " + personId + "\n" +
            " searchPersonId: " + searchPersonId + "\n" +
            " searchAccountType: " + searchAccountType + "\n" +
            " searchProgram: " + searchProgram + "\n" +
            " searchRegion: " + searchRegion + "\n" +
            " searchCounty: " + searchCounty + "\n";
  }
}
