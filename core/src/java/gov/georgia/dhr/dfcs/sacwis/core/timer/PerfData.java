package gov.georgia.dhr.dfcs.sacwis.core.timer;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * This bean contains performance data for requests in the Impact Application.
 *
 * @author Bradley Eilers
 * @version 1.0
 */
public class PerfData implements Serializable {
  private long totalRequestTime;
  private long totalProcessingTime;
  private long totalPresentationTime;
  private long totalNetworkLatency;
  private java.util.Map<String, Long> totalActivityMethodTimes;
  private java.util.Map<String, Long> totalServiceTimes;
  private java.util.List<String> requestURIs;

  /** default constructor for the bean */
  public PerfData() {
    totalActivityMethodTimes = new HashMap<String, Long>();
    totalServiceTimes = new HashMap<String, Long>();
    requestURIs = new ArrayList<String>();
    clear();
  }

  /** get Total time taken for the request from the user's perspective */
  public long getTotalRequestTime() {
    return totalRequestTime;
  }

  /** set Total time taken for the request from the user's perspective */
  public void setTotalRequestTime(long totalRequestTime) {
    this.totalRequestTime = totalRequestTime;
  }

  /** Total Time for the Request from the server's perspective - total servlet time */
  public long getTotalProcessingTime() {
    return totalProcessingTime;
  }

  /** Total Time for the Request from the server's perspective - total servlet time */
  public void setTotalProcessingTime(long totalProcessingTime) {
    this.totalProcessingTime = totalProcessingTime;
  }

  /**
   * Each entry should be a key-value pair with the key being a string with the name of the Activity Method and the
   * value being a long with the time.
   */
  public java.util.Map<String, Long> getTotalActivityMethodTimes() {
    return totalActivityMethodTimes;
  }

  /**
   * Each entry should be a key-value pair with the key being a string with the name of the Activity Method and the
   * value being a long with the time.
   */
  public void setTotalActivityMethodTimes(java.util.Map<String, Long> totalActivityMethodTimes) {
    this.totalActivityMethodTimes = totalActivityMethodTimes;
  }

  /**
   * Each entry should be a key-value pair with the key being a string with the name of the Service and the value being
   * a long with the time.
   */
  public java.util.Map<String, Long> getTotalServiceTimes() {
    return totalServiceTimes;
  }

  /**
   * Each entry should be a key-value pair with the key being a string with the name of the Service and the value being
   * a long with the time.
   */
  public void setTotalServiceTimes(java.util.Map<String, Long> totalServiceTimes) {
    this.totalServiceTimes = totalServiceTimes;
  }

  /** The total time take for the Presentation */
  public long getTotalPresentationTime() {
    return totalPresentationTime;
  }

  /** The total time take for the Presentation */
  public void setTotalPresentationTime(long totalPresentationTime) {
    this.totalPresentationTime = totalPresentationTime;
  }

  /** The Network Latency for a given Request. Difference between totalRequestTime and totalProcessingTime */
  public long getTotalNetworkLatency() {
    return totalNetworkLatency;
  }

  /** The Network Latency for a given Request. Difference between totalRequestTime and totalProcessingTime */
  public void setTotalNetworkLatency(long totalNetworkLatency) {
    this.totalNetworkLatency = totalNetworkLatency;
  }

  public void clear() {
    totalRequestTime = 0;
    totalProcessingTime = 0;
    totalPresentationTime = 0;
    totalNetworkLatency = 0;
    totalActivityMethodTimes.clear();
    totalServiceTimes.clear();
    requestURIs.clear();
  }

  public String toString() {
    StringBuffer buffer = new StringBuffer();

    //For Loop on Request URIs called
    for (Iterator<String> i = getRequestURIs().iterator(); i.hasNext();) {
      String uri = i.next();
      buffer.append("Request URI:");
      buffer.append(uri);
      buffer.append(ArchitectureConstants.LINE_BREAK);
    }
    buffer.append("Request Time:");
    buffer.append(totalRequestTime);
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("Processing Time:");
    buffer.append(totalProcessingTime);
    buffer.append(ArchitectureConstants.LINE_BREAK);
    //For Loop on Activity Methods called
    for (Iterator<String> i = getTotalActivityMethodTimes().keySet().iterator();
         i.hasNext();) {
      String key = i.next();
      Long time = getTotalActivityMethodTimes().get(key);
      buffer.append("  Activity Method:");
      buffer.append(key);
      buffer.append(" Time:");
      buffer.append(time.longValue());
      buffer.append(ArchitectureConstants.LINE_BREAK);
    }
    //For Loop on Services Called
    for (Iterator<String> i = getTotalServiceTimes().keySet().iterator(); i.hasNext();) {
      String key = i.next();
      Long time = getTotalServiceTimes().get(key);
      buffer.append("  Service:");
      buffer.append(key);
      buffer.append(" Time:");
      buffer.append(time.longValue());
      buffer.append(ArchitectureConstants.LINE_BREAK);
    }

    buffer.append("  Service Time:");
    buffer.append(totalServiceTimes);
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("  Presentation Time:");
    buffer.append(totalPresentationTime);
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("Network Latency:");
    buffer.append(totalNetworkLatency);
    buffer.append(ArchitectureConstants.LINE_BREAK);

    return buffer.toString();
  }

  /** URI for the Request */
  public java.util.List<String> getRequestURIs() {
    return requestURIs;
  }

  /** URI for the Request */
  public void setRequestURIs(java.util.List<String> requestURIs) {
    this.requestURIs = requestURIs;
  }
}
