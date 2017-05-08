//*  Bean Class  Name: 
//*  Created by: Patrick Coogan
//*  Date Created: 11/17/2009
//*
//*  Description: Input method for service called to verify that contact is not being
//*  added prior to start date of user's relationship with a resource.
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  11/17/09  Patrick Coogan    Created as a part of fix to SMS 39520
//**  
package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

public class ValidateContactDateSI implements Serializable {

  private int ulIdFacilResource;
  
  private int ulIdAgcyResource;

  private int ulIdUser;
  
  private Date dtContactDate;
  
  

  public int getUlIdAgcyResource() {
    return ulIdAgcyResource;
  }

  public void setUlIdAgcyResource(int ulIdAgcyResource) {
    this.ulIdAgcyResource = ulIdAgcyResource;
  }
  
  public int getUlIdFacilResource() {
    return ulIdFacilResource;
  }
  
  public void setUlIdFacilResource(int ulIdFacilResource) {
    this.ulIdFacilResource = ulIdFacilResource;
  }

  public int getUlIdUser() {
	return ulIdUser;
  }

  public void setUlIdUser(int ulIdUser) {
	this.ulIdUser = ulIdUser;
  }


  public Date getDtContactDate() {
    return dtContactDate;
  }

  public void setDtContactDate(Date dtContactDate) {
    this.dtContactDate = dtContactDate;
  }
}
