package gov.georgia.dhr.dfcs.sacwis.service.external.impl;

/**
 * An abstract class developers will extend to create custom query objects to be passed to the PhoneticSearchServiceImpl's
 * search method.
 * <p/>
 * The Phonetic Naming Wrapper Framework uses query classes to define searches for the IDS server. A unique query class
 * must be built for each search defined on the server. Follow the steps listed below to create your own class.
 * <p/>
 * <ol> <li>Extend this abstract class. This class already contains attributes and methods that allow you to set the
 * search scope and match tolerance.</li> <li>Add attributes, along with the associated get and set methods, to your
 * class to represent the search specific criteria.</li> <li>Implement the getSearchName() method. This method must
 * return the name of the search as defined on the IDS server.</li> <li>Implement the toByteArray() method. This method
 * must return a multi-dimensional byte array (byte[][]) representing the search criteria. Each criterion will occupy
 * its own byte array (byte[]) in the larger array. The criteria <b>MUST</b> be ordered according to the search
 * definition on the phonetic search tool. Perform any modification to the search criteria, such as the combining of
 * fields, in this method.
 * <pre>
 * public byte[][] toByteArray() {
 *   //Define a multidimensional byte array with a length equal to the number of search fields
 *   byte[][] byteArray = new byte[2][];
 *   // Combine the firstName and lastName fields to match the fields in the search tables
 *   StringBuffer nameBuilder = new StringBuffer();
 *   nameBuilder.append(this.getFirstName());
 *   nameBuilder.append(" ");
 *   nameBuilder.append(this.getLastName());
 *   String name = nameBuilder.toString();
 *   // Add the search criteria to the byte array IN THE ORDER THEY ARE DEFINED IN THE SEARCH
 *   byteArray[0] = name.getBytes();
 *   byteArray[1] = this.getSsn().getBytes();
 *   //Return the byte array
 *   return byteArray;
 * }</pre></li>
 * <li>Implement the isValid() method. This method ensures that all required search criterion are found in the object
 * and that the query is ready to be sent to the IDS server. It returns a boolean value.</li> </ol>
 *
 * @author Sriram S, August 7, 2006
 */
public abstract class PhoneticSearchQuery {
  /** Attribute identifying the query's match tolerence */
  private String matchTolerance;

  /** Attribute identifying the query's search scope */
  private String searchScope;

  //Constants
  public static final String SEARCH_NARROW = "Narrow";
  public static final String SEARCH_TYPICAL = "Typical";
  public static final String SEARCH_EXHAUSTIVE = "Exhaustive";
  public static final String MATCH_CONSERVATIVE = "Conservative";
  public static final String MATCH_TYPICAL = "Typical-7-7";
  public static final String MATCH_LOOSE = "Loose";
  

  /** Default constuctor. */
  public PhoneticSearchQuery() {
    this.setSearchScope(SEARCH_TYPICAL);
    this.setMatchTolerance(MATCH_TYPICAL);
  }

  /**
   * Used to set the query's match tolerance.
   *
   * @param matchTolerance constant representing the new match tolerance
   */
  public final void setMatchTolerance(String matchTolerance) {
    this.matchTolerance = matchTolerance;
  }

  /**
   * Used to get the query's match tolerance.
   *
   * @return constant representing the query's match tolerance
   */
  public final String getMatchTolerance() {
    return this.matchTolerance;
  }

  /**
   * Used to set the query's search scope.
   *
   * @param searchScope constant representing the new search scope
   */
  public final void setSearchScope(String searchScope) {
    this.searchScope = searchScope;
  }

  /**
   * Used to get the query's search scope.
   *
   * @return constant representing the query's search scope
   */
  public final String getSearchScope() {
    return this.searchScope;
  }

  /**
   * This method should be implemented to return the name of the IDS search the query object is associated with.
   *
   * @return the name of the IDS search this query will use
   */
  public abstract String getSearchName();

  /**
   * This method should be implemented to check that all required search criteria are found in the query.
   *
   * @return true if the required criteria are found; false otherwise
   */
  public abstract boolean isValid();

  /**
   * This method should be implemented to convert the search criteria found in the custom query object to the form that
   * IDS expects.  Strings should be converted to byte arrays and ordered in the larger array according to the order of
   * fields in this search's IDT.
   * <pre>
   * public byte[][] toByteArray() {
   *   // Define a multidimensional byte array with a length equal to the number of search fields
   *   byte[][] byteArray = new byte[2][];
   *   // Combine the firstName and lastName fields to match the fields in the search tables
   *   StringBuffer nameBuilder = new StringBuffer();
   *   nameBuilder.append(this.getFirstName());
   *   nameBuilder.append(" ");
   *   nameBuilder.append(this.getLastName());
   *   String name = nameBuilder.toString();
   *   // Add the search criteria to the byte array IN THE ORDER THEY ARE DEFINED IN THE SEARCH
   *   byteArray[0] = name.getBytes();
   *   byteArray[1] = this.getSsn().getBytes();
   *   //Return the byte array
   *   return byteArray;
   * }</pre>
   *
   * @return a multi-dimensional byte array containing ordered search criteria
   */
  public abstract byte[][] toByteArray();
}
