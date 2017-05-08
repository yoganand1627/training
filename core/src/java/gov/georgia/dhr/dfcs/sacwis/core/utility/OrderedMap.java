package gov.georgia.dhr.dfcs.sacwis.core.utility;

import org.grnds.facility.log.GrndsTrace;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import gov.georgia.dhr.dfcs.sacwis.core.utility.MapEntry;

/** TODO: add javadocs */
public class OrderedMap extends AbstractMap implements Serializable {
  public OrderedMap() {
    super();
    GrndsTrace.enterScope(TRACE_TAG + ".constructor");
    keyValues = new TreeSet();
    GrndsTrace.exitScope();
  }

  public OrderedMap(Map map) {
    super();
    GrndsTrace.enterScope(TRACE_TAG + ".constructor");
    keyValues = new TreeSet();

    Iterator iterator = map.entrySet().iterator();

    for (int index = 0; iterator.hasNext(); index++) {
      Map.Entry entry = (Map.Entry) iterator.next();
      MapEntry newEntry = new MapEntry(entry, index);
      keyValues.add(newEntry);
    }

    GrndsTrace.exitScope();
  }

  public Object put(Object key, Object value) {
    GrndsTrace.enterScope(TRACE_TAG + ".put");
    GrndsTrace.msg(TRACE_TAG, 7, "key = " + key + "value = " + value);

    MapEntry entry = this.find(key);

    if (entry == null) {
      entry = new MapEntry();
      entry.setKey(key);
      entry.setIndex(this.keyValues.size());
      keyValues.add(entry);
    }

    GrndsTrace.exitScope(value);
    return entry.setValue(value);
  }

  public void putAll(Map map) {
    GrndsTrace.enterScope(TRACE_TAG + ".putAll");
    Iterator iterator = map.entrySet().iterator();

    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      this.put(entry.getKey(), entry.getValue());
    }
    GrndsTrace.exitScope();
  }

  public Object remove(Object key) {
    GrndsTrace.enterScope(TRACE_TAG + ".remove");
    Object result = null;

    MapEntry entry = this.find(key);

    if (entry != null) {
      result = entry.getValue();
      this.keyValues.remove(entry);
      this.removeIndex(entry.getIndex());
    }

    GrndsTrace.exitScope(result);
    return result;
  }

  public void clear() {
    this.keyValues.clear();
  }


  public Set entrySet() {
    return this.keyValues;
  }


  MapEntry find(Object key) {
    GrndsTrace.enterScope(TRACE_TAG + ".find");
    MapEntry result = null;
    Iterator iterator = this.keyValues.iterator();

    while (iterator.hasNext()) {
      MapEntry entry = (MapEntry) iterator.next();
      Object entryKey = entry.getKey();
      if (entryKey == null) {
        if (key == null) {
          result = entry;
        }
      } else {
        if (entryKey.equals(key)) {
          result = entry;
        }
      }
    }
    GrndsTrace.exitScope(result);
    return result;
  }


  void removeIndex(int index) {
    GrndsTrace.enterScope(TRACE_TAG + ".removeIndex");
    Iterator iterator = this.keyValues.iterator();

    while (iterator.hasNext()) {
      MapEntry entry = (MapEntry) iterator.next();

      if (entry.getIndex() > index) {
        entry.setIndex(entry.getIndex() - 1);
      }
    }

    GrndsTrace.exitScope();
  }

  // static constants
  private static final String TRACE_TAG = "OrderedMap"; //for tracing


  //instance variables
  private SortedSet keyValues;
}






