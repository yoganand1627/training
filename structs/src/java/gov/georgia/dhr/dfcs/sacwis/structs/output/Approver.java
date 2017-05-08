package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Approver implements Serializable {
  private int idApprovers;
  private Date dtLastUpdate;
  private int idPerson;
  private String nmPersonFull;
  private int idUnit;
  private int idApproval;
  private int idTodo;
  private String cdStatus;
  private Date dtDetermination;
  private Date dtRequested;
  private boolean isHistorical;
  private String indHistorical;
  private String txtComments;

  //--------------------------------------------------------
  public Approver(boolean isHistorical) {
    this.idApprovers = 0;
    this.idPerson = 0;
    this.idUnit = 0;
    this.idApproval = 0;
    this.idTodo = 0;
    this.isHistorical = isHistorical;
  }

  //========================================================
  public boolean hasIdApprovers() {
    return this.idApprovers > 0;
  }

  public int getIdApprovers() {
    return this.idApprovers;
  }

  //public Integer getIdApproversWrapped() {
  //  return this.idApprovers;
  //}

  public void setIdApprovers(int idApprovers) {
    this.idApprovers = idApprovers;
  }

  //========================================================
  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  //========================================================
  public boolean hasIdPerson() {
    return this.idPerson > 0;
  }

  public int getIdPerson() {
    return this.idPerson;
  }

  //public Integer getIdPersonWrapped() {
  //  return this.idPerson;
  //}

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }

  //========================================================
  public String getNmPersonFull() {
    return nmPersonFull;
  }

  public void setNmPersonFull(String nmPersonFull) {
    this.nmPersonFull = nmPersonFull;
  }

  //========================================================
  public boolean hasIdUnit() {
    return this.idUnit > 0;
  }

  public int getIdUnit() {
    return this.idUnit;
  }

  //public Integer getIdUnitWrapped() {
  //  return this.idUnit;
  //}

  public void setIdUnit(int idUnit) {
    this.idUnit = idUnit;
  }

  //========================================================
  public boolean hasIdApproval() {
    return this.idApproval > 0;
  }

  public int getIdApproval() {
    return this.idApproval;
  }

  //public Integer getIdApprovalWrapped() {
  //  return this.idApproval;
  //}

  public void setIdApproval(int idApproval) {
    this.idApproval = idApproval;
  }

  //========================================================
  public boolean hasIdTodo() {
    return this.idTodo > 0;
  }

  public int getIdTodo() {
    return this.idTodo;
  }

  //public Integer getIdTodoWrapped() {
  //  return this.idTodo;
  //}

  public void setIdTodo(int idTodo) {
    this.idTodo = idTodo;
  }

  //========================================================
  public String getCdStatus() {
    return cdStatus;
  }

  public void setCdStatus(String cdStatus) {
    this.cdStatus = cdStatus;
  }

  //========================================================
  public Date getDtDetermination() {
    return dtDetermination;
  }

  public void setDtDetermination(Date dtDetermination) {
    this.dtDetermination = dtDetermination;
  }
  
  /*
  public String getDtDeterminationFormattedString() {
    if (this.dtDetermination != null) {
      return DateHelper.SLASH_FORMAT.format(this.dtDetermination);
    } else {
      return "";
    }
  }
  */
  
  //========================================================
  public Date getDtRequested() {
    return dtRequested;
  }

  public void setDtRequested(Date dtRequested) {
    this.dtRequested = dtRequested;
  }
  
  /*
  public String getDtRequestedFormattedString() {
    if (this.dtRequested != null) {
      return DateHelper.SLASH_FORMAT.format(this.dtRequested);
    } else {
      return "";
    }
  }
  */
  
  //========================================================
  public boolean isHistorical() {
    return isHistorical;
  }

  public void setHistorical(boolean isHistorical) {
    this.isHistorical = isHistorical;
  }

  //========================================================
  public String getTxtComments() {
    return txtComments;
  }

  public void setTxtComments(String txtComments) {
    this.txtComments = txtComments;
  }

  //========================================================
  public String getIndHistorical() {
    return indHistorical;
  }

  public void setIndHistorical(String indHistorical) {
    this.indHistorical = indHistorical;
  }

  //********************************************************
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("Approver: ").append(this.nmPersonFull).append("(").append(this.idPerson).append(")\n");
    if (this.hasIdUnit()) {
      sb.append("\tUnit ID: ").append(this.idUnit).append("\n");
    }
    sb.append("\tHistorical: ").append(this.isHistorical).append("\n");
    sb.append("\tApprovers ID: ").append(this.idApprovers).append("\n");
    sb.append("\tDate Last Updated: ").append(this.dtLastUpdate).append("\n");
    sb.append("\tApproval ID: ").append(this.idApproval).append("\n");
    sb.append("\tTodo ID: ").append(this.idTodo).append("\n");
    sb.append("\tStatus: ").append(this.cdStatus).append("\n");
    sb.append("\tDetermination Date: ").append(this.dtDetermination).append("\n");
    sb.append("\tDate Requested: ").append(this.dtRequested).append("\n");
    sb.append("\tHistorical Indicator: ").append(this.indHistorical).append("\n");
    sb.append("\tComments: ").append(this.txtComments);

    return sb.toString();
  }
}
