package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;

public class AdoInfoCbxSentStruct extends AdoInfoCbxStruct implements Serializable {
  int idAdoInfoCbxSent;

  Date dtAdoInfoCbxSent;

  public int getIdAdoInfoCbxSent() {
    return idAdoInfoCbxSent;
  }

  public void setIdAdoInfoCbxSent(int idAdoInfoCbxSent) {
    this.idAdoInfoCbxSent = idAdoInfoCbxSent;
  }

  public Date getDtAdoInfoCbxSent() {
    return dtAdoInfoCbxSent;
  }

  public void setDtAdoInfoCbxSent(Date dtAdoInfoCbxSent) {
    this.dtAdoInfoCbxSent = dtAdoInfoCbxSent;
  }
  
}
