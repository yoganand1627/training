package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ApproversRetrieveSI implements Serializable {
  public static final int SUBMITTED_EVENT = 1;
  public static final int APPROVAL = 2;
  public static final int TODO = 3;

  private int retrievalKey = 0;
  private int idEvent;
  private int idApproval;
  private int idTodo;

  private void retrievalKey(int retrievalKey) {
    switch (retrievalKey) {
      case TODO:
      case APPROVAL:
      case SUBMITTED_EVENT:
        this.retrievalKey = retrievalKey;
        break;
      default:
        this.retrievalKey = SUBMITTED_EVENT;
        break;
    }
  }

  //--------------------------------------------------------
  public ApproversRetrieveSI(int retrievalKey, int key) {
    retrievalKey(retrievalKey);
    switch (this.retrievalKey) {
      case SUBMITTED_EVENT:
        this.idEvent = key;
        this.idApproval = 0;
        this.idTodo = 0;
        break;
      case APPROVAL:
        this.idApproval = key;
        this.idEvent = 0;
        this.idTodo = 0;
        break;
      case TODO:
        this.idTodo = key;
        this.idEvent = 0;
        this.idApproval = 0;
        break;
    }
  }

  //========================================================
  public boolean hasRetrievalKey() {
    return this.retrievalKey > 0;
  }

  public int getRetrievalKey() {
    return retrievalKey;
  }

  public void setRetrievalKey(int retrievalKey) {
    retrievalKey(retrievalKey);
  }

  //========================================================
  public boolean hasIdEvent() {
    return this.idEvent > 0;
  }

  public int getIdEvent() {
    return this.idEvent;
  }

  //public Integer getIdEventWrapped() {
  //  return this.idEvent;
  //}

  public void setIdEvent(int idEvent) {
    this.idEvent = idEvent;
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
}
