package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchQuery;

public class NameExtSearchQuery extends PhoneticSearchQuery {
  //Constants 
  public final String SEARCH_NAME = "name-search-ext";

  //Instance variables
  private String firstName;
  private String lastName;
  private String middleName;
  private String dob;
  private String gender;

  public NameExtSearchQuery() {
    this.firstName = "";
    this.lastName = "";
    this.middleName = "";
    this.dob = "";
    this.gender = "";
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getSearchName() {
    //Returns the name of the search as specified
    //on the IDS server.
    return this.SEARCH_NAME;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public byte[][] toByteArray() {
    //Define a multidimensional byte array with a length
    //equal to the number of search fields
    byte[][] byteArray = new byte[3][];
    //Combine the firstName and lastName fields
    //to match the search data
    StringBuffer nameBuilder = new StringBuffer();
    nameBuilder.append(this.getFirstName());
    nameBuilder.append(" ");
    nameBuilder.append(this.getMiddleName());
    nameBuilder.append(" ");
    nameBuilder.append(this.getLastName());
    String name = nameBuilder.toString();
    //Add the search criteria to the byte array
    //IN THE ORDER THEY ARE DEFINED IN THE SEARCH
    byteArray[0] = name.getBytes();
    byteArray[1] = dob.getBytes();
    byteArray[2] = gender.getBytes();
    //Return the byte array
    return byteArray;
  }

  public boolean isValid() {
    boolean isValid = true;
    //Only check that required fields are populated
    if (this.lastName.equals("")) {
      isValid = false;
    }
    //Return the validation results
    return isValid;
  }

}


