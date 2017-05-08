package gov.georgia.dhr.dfcs.sacwis.web.core.audit;

public class AuditLoginRecord {
  private String txtUserEmail;
  private Integer idUser;
  private String txtIpAddress;
  private String indLoginSuccess;
  private Integer nbrMessage;
  public AuditLoginRecord(String txtUserEmail, 
                          Integer idUser, String txtIpAddress, 
                          String indLoginSuccess, Integer nbrMessage){
    this.txtUserEmail = txtUserEmail;
    this.idUser = idUser;
    this.txtIpAddress = txtIpAddress;
    this.indLoginSuccess = indLoginSuccess;
    this.nbrMessage = nbrMessage;
  }

  public String getTxtUserEmail() {
    return txtUserEmail;
  }
  public void setTxtUserEmail(String txtUserEmail) {
    this.txtUserEmail = txtUserEmail;
  }
  public Integer getIdUser() {
    return idUser;
  }
  public void setIdUser(Integer idUser) {
    this.idUser = idUser;
  }
  public String getTxtIpAddress() {
    return txtIpAddress;
  }
  public void setTxtIpAddress(String txtIpAddress) {
    this.txtIpAddress = txtIpAddress;
  }
  public String getIndLoginSuccess() {
    return indLoginSuccess;
  }
  public void setIndLoginSuccess(String indLoginSuccess) {
    this.indLoginSuccess = indLoginSuccess;
  }

  public Integer getNbrMessage() {
    return nbrMessage;
  }

  public void setNbrMessage(Integer nbrMessage) {
    this.nbrMessage = nbrMessage;
  }
  public String toString(){
    return " txtUserEmail: "+txtUserEmail+
           " idUser: "+ idUser+
           " txtIpAddress: "+txtIpAddress+
           " indLoginSuccess: "+indLoginSuccess+
           " nbrMessage: "+ nbrMessage;
  }
}
