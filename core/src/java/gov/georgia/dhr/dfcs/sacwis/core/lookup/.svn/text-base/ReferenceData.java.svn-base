package gov.georgia.dhr.dfcs.sacwis.core.lookup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Date;

/**
 * This class encapsulates a HashMap that has data for all reference tables. An object of this class is registered with
 * the JNDI tree.
 *
 * @author Prem Raghupathy, March 1, 2002.
 */
public class ReferenceData implements Serializable {
  public static final String CODE = "code";
  public static final String BEGIN_DATE = "beginDate";
  public static final String END_DATE = "endDate";

  private static final String TRACE_TAG = "ReferenceData";

  private Map<String, Map<String, Map<java.util.Date, Map<String, Object>>>> referenceDataMap;

  /**
   * Package level constructor to deter instantiation
   *
   * @param refDataMap - The HashMap used for caching reference tables data
   */
  public ReferenceData(Map<String, Map<String, Map<java.util.Date, Map<String, Object>>>> refDataMap) {
    this.referenceDataMap = refDataMap;
  }

  /**
   * Returns an Object from the HashMap for the specified reference table, code, table column and date.
   *
   * @param tableName       - The reference table name
   * @param code            - The table key
   * @param tableColumnName - The table column name
   * @param date            - The date for which the reference data is required
   * @return Reference Data Object
   * @throws TableNotFoundException        when the given table is not found in the cache
   * @throws CodeNotFoundException         - if the code is not found in the reference table
   * @throws DataNotFoundException         - if a matching record is not found in the reference table
   * @throws DuplicateRecordFoundException - if more than one records are found
   */
  Object get(String tableName, String code, String tableColumnName, Date date)
          throws CodeNotFoundException, DataNotFoundException, DuplicateRecordFoundException, TableNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".get(1,2,3,4) ");
    GrndsTrace.msg(TRACE_TAG + ".get(1,2,3,4) ", 7,
                   ":: " + "this.referenceDataMap.size()==" + this.referenceDataMap.size());
    GrndsTrace.msg(TRACE_TAG + ".get(1,2,3,4) ", 7, ":: " + "looking for table =" + tableName);
    // Retrieve the Layer2 HashMap
    Map<String, Map<java.util.Date, Map<String, Object>>> layer2Map = getLayer2Map(tableName);
    // Retrieve the Layer3 HashMap
    Map<java.util.Date, Map<String, Object>> layer3Map = getLayer3Map(code, layer2Map);
    // Retrieve the value for the given column
    GrndsTrace.exitScope();
    return getData(tableColumnName, date, layer3Map);
  }

  /**
   * Returns a Collection of all the records for the given reference table and date.
   *
   * @param tableName - The reference table name
   * @param date      - Date
   * @return The list of HashMaps containing the given reference table's data
   * @throws TableNotFoundException - if the table is not found in the Hashmap
   * @throws DataNotFoundException  - if no records are found for the given reference table
   */
  List getList(String tableName, Date date) throws TableNotFoundException, DataNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".getLayerist() ");
    GrndsTrace.msg(TRACE_TAG + ".getLayerist() ", 7,
                   "::this.referenceDataMap." + "size() =" + this.referenceDataMap.size());
    GrndsTrace.msg(TRACE_TAG + ".getLayerist() ", 7, "::looking for table =" + tableName);

    // Retrieve the Layer2 HashMap
    Map<String, Map<java.util.Date, Map<String, Object>>> layer2Map = getLayer2Map(tableName);
    List dataList = getDataList(date, layer2Map);
    if (dataList == null) {
      throw new DataNotFoundException("No data found fot " + tableName + " table", BasePrsException.CRITICAL_PRIORITY);
    }

    GrndsTrace.exitScope();
    return dataList;
  }

  /**
   * Returns a layer 2 HashMap for the given reference table name.
   *
   * @param tableName - The reference table name
   * @return layer 2 Map
   * @throws TableNotFoundException - if the table is not found in the Hashmap
   */
  Map<String, Map<java.util.Date, Map<String, Object>>> getLayer2Map(String tableName) throws TableNotFoundException {
    Map<String, Map<java.util.Date, Map<String, Object>>> layer2Map = this.referenceDataMap.get(tableName);
    if (layer2Map == null) {
      throw new TableNotFoundException(tableName + " table not " + "found in the cache",
                                       BasePrsException.CRITICAL_PRIORITY);
    } else {
      GrndsTrace.msg(TRACE_TAG + ".getLayer2Map() ", 7, ":: " + "layer2Map.size=" + layer2Map.size());
      return layer2Map;
    }
  }

  /**
   * Returns a layer 3 HashMap for the given layer 2 key.
   *
   * @param code      - The layer 2 map's key
   * @param layer2Map - The layer 2 map
   * @return layer 3 Map
   * @throws CodeNotFoundException - if the layer3 map is not found
   */
  Map<java.util.Date, Map<String, Object>> getLayer3Map(String code,
                                                        Map<String, Map<java.util.Date, Map<String, Object>>> layer2Map)
          throws CodeNotFoundException {
    Map<java.util.Date, Map<String, Object>> layer3Map = layer2Map.get(code);
    if (layer3Map == null) {
      throw new CodeNotFoundException("Code " + code + " not " + "found in the table",
                                      BasePrsException.CRITICAL_PRIORITY);
    } else {
      // GrndsTrace.msg( TRACE_TAG + ".getLayer3Map() ",7,":: " + "layer3Map.toString()=" +layer3Map.toString() );
      return layer3Map;
    }
  }

  /**
   * Returns a value for the given reference table column name and date.
   *
   * @param tableColumnName - The reference table column name
   * @param date            - Date
   * @param layer3Map       - layer 3 map
   * @return value object
   * @throws DataNotFoundException         - if no records are found for the given reference table
   * @throws DuplicateRecordFoundException - if more than one value is found the given input parameters.
   */
  Object getData(String tableColumnName, Date date, Map<java.util.Date, Map<String, Object>> layer3Map)
          throws DataNotFoundException, DuplicateRecordFoundException {
    Set<java.util.Date> layer3KeySet = layer3Map.keySet();
    Iterator<java.util.Date> layer3Iterator = layer3KeySet.iterator();
    Object value = null;
    Object prevValue = null;
    while (layer3Iterator.hasNext()) {
      // Retrieve the Layer4 Hashmap
      Map<String, Object> layer4Map = layer3Map.get(layer3Iterator.next());
      if (layer4Map != null) {
        value = getValueFromL4Map(tableColumnName, date, layer4Map);
      }

      if (value != null && prevValue != null) {
        GrndsTrace.msg(TRACE_TAG + ".getData()", 7, " ::Duplicate record for value =" + value);
        throw new DuplicateRecordFoundException("Duplicate record found.", BasePrsException.CRITICAL_PRIORITY);
      }

      if (value != null && prevValue == null) {
        prevValue = value;
      }
      GrndsTrace.msg(TRACE_TAG + ".getData()", 7, " ::prevValue =" + prevValue + " value =" + value);
    }
    GrndsTrace.msg(TRACE_TAG + ".getData()", 7, " ::Final value =" + prevValue);
    return prevValue;
  }

  /**
   * A heloer method that check if the given date is within the begin and end dates in layer 4 map.
   *
   * @param date      - The user input date
   * @param layer4Map - The layer 4 map
   * @return boolean
   */
  boolean checkDate(Date date, Map layer4Map) {
//       GrndsTrace.msg( TRACE_TAG + ".checkDate() ",7, layer4Map.toString());
    Object beginDate = layer4Map.get(ReferenceData.BEGIN_DATE);
    Object endDate = layer4Map.get(ReferenceData.END_DATE);
    GrndsTrace.msg(TRACE_TAG + ".checkDate() ", 7,
                   "::beginDate.toString() =" + beginDate.toString() + " endDate.toString() =" + endDate.toString());
    // Check if the user date falls with the date tange
    GrndsTrace.exitScope();
    return (date.compareTo((Calendar) beginDate) >= 0) && (date.compareTo((Calendar) endDate) <= 0);
  }

  /**
   * Returns a value for the given key in the layer 4 map
   *
   * @param tableColumnName - This is the key in layer 4 map
   * @param date            - The user date
   * @param layer4Map       - The layer 4 map
   * @return value for the given key
   * @throws DataNotFoundException - If the value is null
   */
  Object getValueFromL4Map(String tableColumnName, Date date, Map<String, Object> layer4Map)
          throws DataNotFoundException {
    // Check if the user date falls with the date tange
    //EILERSBE - Remove Date Check for performance reasons
    //boolean validDate = this.checkDate(date, layer4Map);
    //if( validDate )
    //{
    Object value = layer4Map.get(tableColumnName);
    if (value == null) {
      throw new DataNotFoundException(
              "No data found for the " + "column " + tableColumnName + " or incorrect table column name.",
              BasePrsException.CRITICAL_PRIORITY);
    }

    GrndsTrace.msg(TRACE_TAG + ".getValueFromL4Map()", 7, " ::value =" + value.toString());
    //} // end of if( date.equal...
    return value;
  }

  /**
   * Returns a list of all records
   *
   * @param date      - The user date
   * @param layer2Map - The layer 2 map
   * @return list of layer 4 maps
   */
  List<Map<String, Object>> getDataList(Date date, Map<String, Map<java.util.Date, Map<String, Object>>> layer2Map) {
    List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
    Set<String> layer2KeySet = layer2Map.keySet();
    Iterator<String> layer2Iterator = layer2KeySet.iterator();
    while (layer2Iterator.hasNext()) {
      String layer2Key = layer2Iterator.next();
      Map<java.util.Date, Map<String, Object>> layer3Map;
      // Retrieve the Layer3 HashMap
      try {
        layer3Map = getLayer3Map(layer2Key, layer2Map);
      }
      catch (CodeNotFoundException cnfe) {
        GrndsTrace.msg(TRACE_TAG + ".getDataList() ", 7, ":: No data" + " found for the code =" + layer2Key);
        continue;
      }
      Set<java.util.Date> layer3KeySet = layer3Map.keySet();
      Iterator<java.util.Date> layer3Iterator = layer3KeySet.iterator();
      // Retrieve all the Layer4 HashMaps
      while (layer3Iterator.hasNext()) {
        Map<String, Object> layer4Map = layer3Map.get(layer3Iterator.next());
        // check if the user date falls between the begin and end dates
        //EILERSBE - remove Date Check for performance reasons
        //boolean validDate = this.checkDate( date, layer4Map );

        //if( validDate )
        //{
        dataList.add((Map<String, Object>) ((HashMap<String, Object>) layer4Map).clone());
        //}
      } // end of while
    } // end of while( layer2Iterator...
    return dataList;
  }
}







