package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ApproversRetrieveSO implements Serializable {
  private Approver currentActiveApprover;
  private List<Approver> historicalApprovers;

  public boolean hasCurrentActiveApprover() {
    return (currentActiveApprover != null && currentActiveApprover.hasIdPerson());
  }

  public Approver getCurrentActiveApprover() {
    return currentActiveApprover;
  }

  public void setCurrentActiveApprover(Approver currentActiveApprover) {
    this.currentActiveApprover = currentActiveApprover;
  }

  public boolean hasHistoricalApprovers() {
    return (historicalApprovers != null && !historicalApprovers.isEmpty());
  }

  public List<Approver> getHistoricalApprovers() {
    return historicalApprovers;
  }

  public void setHistoricalApprovers(List<Approver> historicalApprovers) {
    this.historicalApprovers = historicalApprovers;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("========ApproversRetrieveSO_").append(this.hashCode()).append("========\n");
    if (this.hasCurrentActiveApprover()) {
      sb.append("Current Active ").append(this.currentActiveApprover.toString()).append("\n");
    } else {
      sb.append("No current active approver\n");
    }
    if (this.hasHistoricalApprovers()) {
      sb.append("Total historical approvers: ").append(this.historicalApprovers.size()).append("\n");
      int counter = 1;
      for(Approver historical : this.historicalApprovers) {
        sb.append("").append(counter++).append(" Historical ").append(historical.toString()).append("\n");
      }
    } else {
      sb.append("No historical approvers\n");
    }
    sb.append("========ApproversRetrieveSO_").append(this.hashCode()).append("========");
    return sb.toString();
  }
}