package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;

public class RetrieveFacAgencyHomesListSI implements Serializable {

  private List<Integer> rsrcList;
  private int idParentRsrc;
  private String cdSortBy;
  private ArchInputStruct input;

  public List<Integer> getRsrcList() {
    return rsrcList;
  }

  public void setRsrcList(List<Integer> rsrcList) {
    this.rsrcList = rsrcList;
  }
  
  public int getIdParentRsrc(){
    return idParentRsrc;
  }
  
  public void setIdParentRsrc(int idParentRsrc){
    this.idParentRsrc = idParentRsrc;
  }
  
  public ArchInputStruct getArchInputStruct() {
    return input;
  }

  
  public void setArchInputStruct(ArchInputStruct input) {
    this.input = input;
  }
  
  public String getCdSortBy() {
    return cdSortBy;
  }
  
  public void setCdSortBy(String cdSortBy) {
    this.cdSortBy = cdSortBy;
  }

}
