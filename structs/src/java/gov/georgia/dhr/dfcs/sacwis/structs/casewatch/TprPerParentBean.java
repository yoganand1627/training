/**
 * Created on November 23, 2009 by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.structs.casewatch;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class TprPerParentBean implements Serializable {

  private String parent;
  private String nmPersonFull;
  private String cdRel;
  private Date dtTprFiled;
  private Date dtTprGranted;
  private Date dtDod;
  private String indError;
  
  public String getParent(){
    return parent;
  }
  
  public String getNmPersonFull(){
    return nmPersonFull;
  }
  
  public String getCdRel(){
   return cdRel;
  }
  
  public Date getDtTprFiled(){
    return dtTprFiled;
  }
  
  public Date getDtTprGranted(){
    return dtTprGranted;
  }
  
  public Date getDtDod(){
    return dtDod;
  }
  
  public String getIndError(){
    return indError;
  }
  
  public void setParent(String parent){
    this.parent = parent;
  }
  
  public void setNmPersonFull(String nmPersonFull){
    this.nmPersonFull = nmPersonFull;
  }
  
  public void setCdRel (String cdRel){
    this.cdRel = cdRel;
  }
  
  public void setDtTprFiled (Date dtTprFiled){
    this.dtTprFiled = dtTprFiled;
  }
  
  public void setDtTprGranted (Date dtTprGranted){
    this.dtTprGranted = dtTprGranted;
  }
  
  public void setDtDod (Date dtDod){
    this.dtDod = dtDod;
  }
  
  public void setIndError(String indError){
    this.indError = indError;
  }
  
}