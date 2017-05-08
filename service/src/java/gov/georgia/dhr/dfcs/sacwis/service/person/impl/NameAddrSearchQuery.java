package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchQuery;

public class NameAddrSearchQuery extends PhoneticSearchQuery {
  //Constants 
  public final String SEARCH_NAME = "name-addr-search";

  //Instance variables
  private String firstName;
  private String lastName;
  private String middleName;
  private String stAddress;
  private String city;
  private String state;
  private String zip;

  public NameAddrSearchQuery() {
    this.firstName = "";
    this.lastName = "";
    this.middleName = "";
    this.stAddress = "";
    this.city = "";
    this.state = "";
    this.zip = "";
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

  public String getStAddress() {
    return stAddress;
  }

  public void setStAddress(String stAddress) {
    this.stAddress = stAddress;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public byte[][] toByteArray() {
    //Define a multidimensional byte array with a length
    //equal to the number of search fields
    byte[][] byteArray = new byte[4][];
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
    byteArray[1] = stAddress.getBytes();
    //Combine the City and State fields to match the search criteia
    StringBuffer cityState = new StringBuffer();
    cityState.append(this.getCity());
    cityState.append(" ");
    cityState.append(this.getState());
    byteArray[2] = cityState.toString().getBytes();
    byteArray[3] = zip.getBytes();
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


