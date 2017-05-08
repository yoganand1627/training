/**
 * Created on November 16, 2009 by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.structs.casewatch;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class CwHealthScreensSO implements Serializable {

  private Date dtMedical;
  private Date dtPsych;
  private Date dtDental;
  private Date dtDevelopmental;
  
  private String indErrorMedical;
  private String indErrorPsych;
  private String indErrorDental;
  private String indErrorDevelopmental;
  
  private String indOverallError;
  
  public Date getDtMedical(){
    return dtMedical; 
  }
  
  public Date getDtPsych(){
    return dtPsych;
  }
  
  public Date getDtDental(){
    return dtDental;
  }
  
  public Date getDtDevelopmental(){
    return dtDevelopmental;
  }
  
  public String getIndErrorMedical(){
    return indErrorMedical;
  }
  
  public String getIndErrorPsych(){
    return indErrorPsych;
  }
  
  public String getIndErrorDental(){
    return indErrorDental;
  }
  
  public String getIndErrorDevelopmental(){
    return indErrorDevelopmental;
  }
  
  public String getIndOverallError(){
    return indOverallError;
  }
  
  public void setDtMedical(Date dtMedical){
    this.dtMedical = dtMedical; 
  }
  
  public void setDtPsych(Date dtPsych){
    this.dtPsych = dtPsych;
  }
  
  public void setDtDental(Date dtDental){
    this.dtDental = dtDental;
  }
  
  public void setDtDevelopmental(Date dtDevelopmental){
    this.dtDevelopmental = dtDevelopmental;
  }
  
  public void setIndErrorMedical(String indErrorMedical){
    this.indErrorMedical = indErrorMedical;
  }
  
  public void setIndErrorPsych(String indErrorPsych){
    this.indErrorPsych = indErrorPsych;
  }
  
  public void setIndErrorDental(String indErrorDental){
    this.indErrorDental = indErrorDental;
  }
  
  public void setIndErrorDevelopmental(String indErrorDevelopmental){
    this.indErrorDevelopmental = indErrorDevelopmental;
  }
  
  public void setIndOverallError(String indOverallError){
    this.indOverallError = indOverallError;
  }
}