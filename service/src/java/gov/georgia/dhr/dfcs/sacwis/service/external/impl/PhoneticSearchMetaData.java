package gov.georgia.dhr.dfcs.sacwis.service.external.impl;

/**
 * The PhoneticSearchMetaData object describes Identity Tables within the IDS database and is used by the Connection
 * object to perform searches and the PhoneticSearchResultSet object to format search results for display.
 * <p/>
 * An IDS Identity Table (IDT) is an IDS table stored in the user's database containing denormalized and transformed
 * matching and display data extracted by IDS from application tables.  See the IDS documentation for more details.
 *
 * @author Todd G. Tomkinson, February 14, 2002
 */
class PhoneticSearchMetaData {

  /** Attribute representing the IDT associated with this search */
  private String idtName = null;

  /** Attribute representing the name of the search */
  private String searchName = null;

  /** Array containing the column (field) formats as defined in the search's IDT */
  private int[] fieldFormats = null;

  /** Array containing the column (field) lengths as defined in the search's IDT */
  private int[] fieldLengths = null;

  /** Array containing the column (field) names as defined in the search's IDT */
  private String[] fieldNames = null;

  /** Array containing the column (field) offsets as defined in the search's IDT */
  private int[] fieldOffsets = null;

  /** Array containing the column (field) repeats as defined in the search's IDT */
  private int[] fieldRepeats = null;

  /** Attribute representing the number of columns in the result set */
  private int numberOfFields = 0;

  /** Attribute specifying the number of bytes in the record */
  private int recordLength = 0;

  /** Default constructor. */
  PhoneticSearchMetaData() {
  }

  /**
   * Sets the formats of the fields in the IDT record.
   *
   * @param fieldFormats the new fieldFormats
   */
  public void setFieldFormats(int[] fieldFormats) {
    this.fieldFormats = fieldFormats;
  }

  /**
   * Returns the formats of the fields in the IDT record.
   *
   * @return the fieldFormats
   */
  public int[] getFieldFormats() {
    return this.fieldFormats;
  }

  /**
   * Sets the lengths of the fields in the IDT record.
   *
   * @param fieldLengths the new fieldLengths
   */
  public void setFieldLengths(int[] fieldLengths) {
    this.fieldLengths = fieldLengths;
  }

  /**
   * Returns the lengths of the fields in the IDT record.
   *
   * @return the fieldLengths
   */
  public int[] getFieldLengths() {
    return this.fieldLengths;
  }

  /**
   * Sets the names of the fields in the IDT record.
   *
   * @param fieldNames the new fieldNames
   */
  public void setFieldNames(String[] fieldNames) {
    this.fieldNames = fieldNames;
  }

  /**
   * Returns the names of the fields in the IDT record.
   *
   * @return the fieldNames
   */
  public String[] getFieldNames() {
    return this.fieldNames;
  }

  /**
   * Sets the offsets of the fields in the IDT record.
   *
   * @param fieldOffsets the new fieldOffsets
   */
  public void setFieldOffsets(int[] fieldOffsets) {
    this.fieldOffsets = fieldOffsets;
  }

  /**
   * Returns the offsets of the fields in the IDT record.
   *
   * @return the fieldOffsets
   */
  public int[] getFieldOffsets() {
    return this.fieldOffsets;
  }

  /**
   * Sets the repeats of the fields in the IDT record.
   *
   * @param fieldRepeats the new fieldRepeats
   */
  public void setFieldRepeats(int[] fieldRepeats) {
    this.fieldRepeats = fieldRepeats;
  }

  /**
   * Returns the repeats of the fields in the IDT record.
   *
   * @return the fieldRepeats
   */
  public int[] getFieldRepeats() {
    return this.fieldRepeats;
  }

  /**
   * Sets the name of the IDT that the data in this object applies to.
   *
   * @param idtName the new idtName
   */
  public void setIdtName(String idtName) {
    this.idtName = idtName;
  }

  /**
   * Returns the name of the IDT that the data in this object applies to.
   *
   * @return the idtName
   */
  public String getIdtName() {
    return this.idtName;
  }

  /**
   * Sets the number of fields in the IDT record.
   *
   * @param numberOfFields the new numberOfFields
   */
  public void setNumberOfFields(int numberOfFields) {
    this.numberOfFields = numberOfFields;
  }

  /**
   * Returns the number of fields in the IDT record.
   *
   * @return the numberOfFields
   */
  public int getNumberOfFields() {
    return this.numberOfFields;
  }

  /**
   * Sets the length of the IDT record.
   *
   * @param recordLength the new recordLength
   */
  public void setRecordLength(int recordLength) {
    this.recordLength = recordLength;
  }

  /**
   * Returns the length of the IDT record.
   *
   * @return the recordLength
   */
  public int getRecordLength() {
    return this.recordLength;
  }

  /**
   * Sets the name of the predefined IDS search that the data in this object applies to.
   *
   * @param searchName the new searchName
   */
  public void setSearchName(String searchName) {
    this.searchName = searchName;
  }

  /**
   * Returns the name of the predefined IDS search that the data in this object applies to.
   *
   * @return the searchName
   */
  public String getSearchName() {
    return this.searchName;
  }

  /**
   * Overrides the default equals method.
   *
   * @param object the object to compare
   * @return true if the objects are equal; false otherwise
   */
  public boolean equals(Object object) {
    boolean isEqual = false;

    if ((object != null) && object instanceof PhoneticSearchMetaData) {
      isEqual = true;

      PhoneticSearchMetaData testMetaData = (PhoneticSearchMetaData) object;

      //Check that fieldNames values are equal
      isEqual = isEqual && this.compareStringValues(this.searchName, testMetaData.getSearchName());

      //Check that idtName values are equal
      isEqual = isEqual && this.compareStringValues(this.idtName, testMetaData.getIdtName());

      //Check that recordLength values are equal
      isEqual = isEqual && (this.recordLength == testMetaData.getRecordLength());

      //Check that numberOfFields values are equal
      isEqual = isEqual && (this.numberOfFields == testMetaData.getNumberOfFields());

      //Check that fieldNames values are equal
      isEqual = isEqual && this.compareStringArrays(this.fieldNames, testMetaData.getFieldNames());

      //Check that fieldLengths values are equal
      isEqual = isEqual && this.compareIntArrays(this.fieldLengths, testMetaData.getFieldLengths());

      //Check that fieldOffsets values are equal
      isEqual = isEqual && this.compareIntArrays(this.fieldOffsets, testMetaData.getFieldOffsets());

      //Check that fieldRepeats values are equal
      isEqual = isEqual && this.compareIntArrays(this.fieldRepeats, testMetaData.getFieldRepeats());

      //Check that fieldFormats values are equal
      isEqual = isEqual && this.compareIntArrays(this.fieldFormats, testMetaData.getFieldFormats());
    }

    return isEqual;
  }

  //Helper method for equals
  boolean compareIntArrays(int[] intArrayOne, int[] intArrayTwo) {
    boolean isEqual = true;

    if ((intArrayOne != null) && (intArrayTwo != null) && (intArrayOne.length == intArrayTwo.length)) {
      for (int thisField = 0; thisField < this.numberOfFields;
           thisField++) {
        isEqual = (intArrayOne[thisField] == intArrayTwo[thisField]);
      }
    } else {
      isEqual = (intArrayOne == intArrayTwo);
    }

    return isEqual;
  }

  //Helper method for equals
  boolean compareStringArrays(String[] stringArrayOne, String[] stringArrayTwo) {
    boolean isEqual = true;

    if ((stringArrayOne != null) && (stringArrayTwo != null) && (stringArrayOne.length == stringArrayTwo.length)) {
      for (int thisField = 0; thisField < this.numberOfFields;
           thisField++) {
        isEqual = this.compareStringValues(stringArrayOne[thisField], stringArrayTwo[thisField]);
      }
    } else {
      isEqual = (stringArrayOne == stringArrayTwo);
    }

    return isEqual;
  }

  //Helper method for equals
  boolean compareStringValues(String stringOne, String stringTwo) {
    boolean isEqual;
    if (stringOne != null) {
      isEqual = stringOne.equals(stringTwo);
    } else {
      isEqual = (stringTwo == null);
    }
    return isEqual;
  }
}
