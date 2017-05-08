//*  Bean Class  Name:     AdoptionInformationSaveSO
//*  Created by:   Jacob Vaidyan
//*  Date Created: 2/18/2007
//*
//*  Description:Get / Set for Adoption Information Save SO.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  
package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

public class AdoptionInformationSaveSO implements Serializable {

  private int ulIdEvent;

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

  public int getUlIdEvent() {
    return ulIdEvent;
  }
}