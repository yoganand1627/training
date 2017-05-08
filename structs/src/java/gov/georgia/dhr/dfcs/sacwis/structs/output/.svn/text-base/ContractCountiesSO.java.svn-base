package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class ContractCountiesSO implements Serializable {
  private Set<String> counties;
  private Set<String> serviceCodes;
  private Map<String, Set<String>> countyToServiceCodes;
  
  public ContractCountiesSO() {
    counties = new TreeSet<String>();
    serviceCodes = new TreeSet<String>();
    countyToServiceCodes = new TreeMap<String, Set<String>>();
  }
  
  //-- counties
  public void addCounty(String county) {
    addToMap(county, null);
    if(county != null && county != "" && !counties.contains(county)) {
      counties.add(county);
    }
  }
  
  public Set<String> getCounties() {
    return counties;
  }
  
  public boolean hasCounties() {
    return !counties.isEmpty();
  }
  
  //-- serviceCodes and countyToServiceCodes
  public void addServiceCode(String county, String serviceCode) {
    addToMap(county, serviceCode);
    if(county != null && county != "" && !counties.contains(county)) {
      counties.add(county);
    }
    if(serviceCode != null && serviceCode != "" && !serviceCodes.contains(serviceCode)) {
      serviceCodes.add(serviceCode);
    }
  }
  
  public void addServiceCodes(String county, Collection<String> serviceCodes) {
    if(serviceCodes != null && !serviceCodes.isEmpty()) {
      for(String serviceCode : serviceCodes) {
        addServiceCode(county, serviceCode);
      }
    } else {
      addCounty(county);
    }
  }
  
  public Map<String, Set<String>> getCountyToServiceCodesMap() {
    return countyToServiceCodes;
  }
  
  public Set<String> getServiceCodes() {
    return serviceCodes;
  }
  
  public boolean hasServiceCodes() {
    return !serviceCodes.isEmpty();
  }
  
  private void addToMap(String county, String serviceCode) {
    if(county != null && county != "") {
      boolean addService = serviceCode != null && serviceCode != "";
      if(countyToServiceCodes.containsKey(county)) {
        if(addService) {
          Set<String> countyServices = countyToServiceCodes.get(county);
          if(!countyServices.contains(serviceCode)) {
            countyServices.add(serviceCode);
            countyToServiceCodes.put(county, countyServices);
          }
        }
      } else {
        Set<String> countyServices = new TreeSet<String>();
        if(addService) {
          countyServices.add(serviceCode);
        }
        countyToServiceCodes.put(county, countyServices);
      }
    }
  }
}
