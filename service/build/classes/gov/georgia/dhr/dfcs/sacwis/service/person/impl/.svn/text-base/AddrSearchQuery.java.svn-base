package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchQuery;

public class AddrSearchQuery extends PhoneticSearchQuery {
  //Constants 
  public final String SEARCH_NAME = "addr-search";

  //Instance variables
  private String stAddress;
  private String city;
  private String state;
  private String zip;

  public AddrSearchQuery() {
    this.stAddress = "";
    this.city = "";
    this.state = "";
    this.zip = "";
  }

  public String getSearchName() {
    //Returns the name of the search as specified
    //on the IDS server.
    return this.SEARCH_NAME;
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
    byte[][] byteArray = new byte[3][];
    //Add the search criteria to the byte array
    //IN THE ORDER THEY ARE DEFINED IN THE SEARCH
    byteArray[0] = stAddress.getBytes();
    //Combine the City and State fields to match the search criteia
    StringBuffer cityState = new StringBuffer();
    cityState.append(this.getCity());
    cityState.append(" ");
    cityState.append(this.getState());
    byteArray[1] = cityState.toString().getBytes();
    byteArray[2] = zip.getBytes();
    //Return the byte array
    return byteArray;
  }

  public boolean isValid() {
    boolean isValid = true;
    //Only check that required fields are populated
    if (this.stAddress.equals("")) {
      isValid = false;
    }
    //Return the validation results
    return isValid;
  }

}


