package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.util.List;

public class ProviderAllegationHistorySO {

  @SuppressWarnings("unchecked")
  private List providerAllegList;
  private String nmCase;
  private int idResource;
  private boolean isAllegationAvail;

  @SuppressWarnings("unchecked")
  public List getProviderAllegList() {
    return providerAllegList;
  }

  @SuppressWarnings("unchecked")
  public void setProviderAllegList(List providerAllegList) {
    this.providerAllegList = providerAllegList;
  }

  public String getNmCase() {
    return nmCase;
  }

  public void setNmCase(String nmCase) {
    this.nmCase = nmCase;
  }

  public int getIdResource() {
    return idResource;
  }

  public void setIdResource(int idResource) {
    this.idResource = idResource;
  }

  public boolean isAllegationAvail() {
    return isAllegationAvail;
  }

  public void setAllegationAvail(boolean isAllegationAvail) {
    this.isAllegationAvail = isAllegationAvail;
  }
}
