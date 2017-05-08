package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

public class SaveVendorStaffDetailSI implements Serializable {
  private String crudFlag;
  private Integer idUser;
  private String nmUserFirst;
  private String nmUserMiddle;
  private String nmUserLast;
  private String nmUserFull;
  private String txtTitle;
  private String txtUserEmail;
  private String nbrUserPhone;
  private String nbrUserPhoneExtension;
  private String addrUserAddrStLn1;
  private String addrUserAddrStLn2;
  private String addrUserAddrCity;
  private String addrUserAddrZip;
  private String cdUserAddrState;
  private String cdUserAddrCounty;
  private String cdRequestType;
  private String txtOther;
  private String txtPassword;
  private String indUserAgreement;
  private String indAdminAgreement;
  private String userStatus;
  private String cdStatus;
  private String cdQuestion1;
  private String cdQuestion2;
  private String cdQuestion3;
  private String txtAnswer1;
  private String txtAnswer2;
  private String txtAnswer3;
  private Date dtLastPasswdReset;
  private String indPasswdTemp;
  private Integer nbrFailedLoginAttempts;
  private String idResource;
  private String idPuvl;
  private Date dtStart;
  private Date dtEnd;
  private String savePage;
  private String txtRandPassword;
  private Integer loggedInUser;
  private String modifiedSystem;
  private String userAccessType;
  private String cdUserType;
   
  // SMS #66384: MR-067
  private String txtUserFB;  
  private String txtUserMS;
  private String txtUserTW;  
  private String txtUserOthSite;  
  private String txtUserNameOthSite;  
  private String txtUserPhnBest; 
  private String txtUserPhnBestExt;  
  private String txtUserPhnBestType;  
  private String txtUserPhnAlt1;  
  private String txtUserPhnAlt1Ext;  
  private String txtUserPhnAlt1Type;  
  private String txtUserPhnAlt2;  
  private String txtUserPhnAlt2Ext;  
  private String txtUserPhnAlt2Type;  
  private String txtCntctByText;  
  private String txtEmerContact;
  
  public String getCrudFlag() {
    return crudFlag;
  }
  public void setCrudFlag(String crudFlag) {
    this.crudFlag = crudFlag;
  }
  
  public Integer getIdUser() {
    return idUser;
  }
  public void setIdUser(Integer idUser) {
    this.idUser = idUser;
  }
  public String getNmUserFirst() {
    return nmUserFirst;
  }
  public void setNmUserFirst(String nmUserFirst) {
    this.nmUserFirst = nmUserFirst;
  }
  public String getNmUserMiddle() {
    return nmUserMiddle;
  }
  public void setNmUserMiddle(String nmUserMiddle) {
    this.nmUserMiddle = nmUserMiddle;
  }
  public String getNmUserLast() {
    return nmUserLast;
  }
  public void setNmUserLast(String nmUserLast) {
    this.nmUserLast = nmUserLast;
  }
  public String getNmUserFull() {
    return nmUserFull;
  }
  public void setNmUserFull(String nmUserFull) {
    this.nmUserFull = nmUserFull;
  }
  public String getTxtTitle() {
    return txtTitle;
  }
  public void setTxtTitle(String txtTitle) {
    this.txtTitle = txtTitle;
  }
  public String getTxtUserEmail() {
    return txtUserEmail;
  }
  public void setTxtUserEmail(String txtUserEmail) {
    this.txtUserEmail = txtUserEmail;
  }
  public String getNbrUserPhone() {
    return nbrUserPhone;
  }
  public void setNbrUserPhone(String nbrUserPhone) {
    this.nbrUserPhone = nbrUserPhone;
  }
  public String getNbrUserPhoneExtension() {
    return nbrUserPhoneExtension;
  }
  public void setNbrUserPhoneExtension(String nbrUserPhoneExtension) {
    this.nbrUserPhoneExtension = nbrUserPhoneExtension;
  }
  public String getAddrUserAddrStLn1() {
    return addrUserAddrStLn1;
  }
  public void setAddrUserAddrStLn1(String addrUserAddrStLn1) {
    this.addrUserAddrStLn1 = addrUserAddrStLn1;
  }
  public String getAddrUserAddrStLn2() {
    return addrUserAddrStLn2;
  }
  public void setAddrUserAddrStLn2(String addrUserAddrStLn2) {
    this.addrUserAddrStLn2 = addrUserAddrStLn2;
  }
  public String getAddrUserAddrCity() {
    return addrUserAddrCity;
  }
  public void setAddrUserAddrCity(String addrUserAddrCity) {
    this.addrUserAddrCity = addrUserAddrCity;
  }
  public String getAddrUserAddrZip() {
    return addrUserAddrZip;
  }
  public void setAddrUserAddrZip(String addrUserAddrZip) {
    this.addrUserAddrZip = addrUserAddrZip;
  }
  public String getCdUserAddrState() {
    return cdUserAddrState;
  }
  public void setCdUserAddrState(String cdUserAddrState) {
    this.cdUserAddrState = cdUserAddrState;
  }
  public String getCdUserAddrCounty() {
    return cdUserAddrCounty;
  }
  public void setCdUserAddrCounty(String cdUserAddrCounty) {
    this.cdUserAddrCounty = cdUserAddrCounty;
  }
  public String getCdRequestType() {
    return cdRequestType;
  }
  public void setCdRequestType(String cdRequestType) {
    this.cdRequestType = cdRequestType;
  }
  public String getTxtOther() {
    return txtOther;
  }
  public void setTxtOther(String txtOther) {
    this.txtOther = txtOther;
  }
  public String getTxtPassword() {
    return txtPassword;
  }
  public void setTxtPassword(String txtPassword) {
    this.txtPassword = txtPassword;
  }
  public String getIndUserAgreement() {
    return indUserAgreement;
  }
  public void setIndUserAgreement(String indUserAgreement) {
    this.indUserAgreement = indUserAgreement;
  }
  public String getIndAdminAgreement() {
    return indAdminAgreement;
  }
  public void setIndAdminAgreement(String indAdminAgreement) {
    this.indAdminAgreement = indAdminAgreement;
  }
  
  public String getUserStatus() {
    return userStatus;
  }
  public void setUserStatus(String userStatus) {
    this.userStatus = userStatus;
  }
  public String getCdStatus() {
    return cdStatus;
  }
  public void setCdStatus(String cdStatus) {
    this.cdStatus = cdStatus;
  }
  public String getCdQuestion1() {
    return cdQuestion1;
  }
  public void setCdQuestion1(String cdQuestion1) {
    this.cdQuestion1 = cdQuestion1;
  }
  public String getCdQuestion2() {
    return cdQuestion2;
  }
  public void setCdQuestion2(String cdQuestion2) {
    this.cdQuestion2 = cdQuestion2;
  }
  public String getCdQuestion3() {
    return cdQuestion3;
  }
  public void setCdQuestion3(String cdQuestion3) {
    this.cdQuestion3 = cdQuestion3;
  }
  public String getTxtAnswer1() {
    return txtAnswer1;
  }
  public void setTxtAnswer1(String txtAnswer1) {
    this.txtAnswer1 = txtAnswer1;
  }
  public String getTxtAnswer2() {
    return txtAnswer2;
  }
  public void setTxtAnswer2(String txtAnswer2) {
    this.txtAnswer2 = txtAnswer2;
  }
  public String getTxtAnswer3() {
    return txtAnswer3;
  }
  public void setTxtAnswer3(String txtAnswer3) {
    this.txtAnswer3 = txtAnswer3;
  }
  public Date getDtLastPasswdReset() {
    return dtLastPasswdReset;
  }
  public void setDtLastPasswdReset(Date dtLastPasswdReset) {
    this.dtLastPasswdReset = dtLastPasswdReset;
  }
  public String getIndPasswdTemp() {
    return indPasswdTemp;
  }
  public void setIndPasswdTemp(String indPasswdTemp) {
    this.indPasswdTemp = indPasswdTemp;
  }
  public Integer getNbrFailedLoginAttempts() {
    return nbrFailedLoginAttempts;
  }
  public void setNbrFailedLoginAttempts(Integer nbrFailedLoginAttempts) {
    this.nbrFailedLoginAttempts = nbrFailedLoginAttempts;
  }
  public String getIdResource() {
    return idResource;
  }
  public void setIdResource(String idResource) {
    this.idResource = idResource;
  }
  public String getIdPuvl() {
    return idPuvl;
  }
  public void setIdPuvl(String idPuvl) {
    this.idPuvl = idPuvl;
  }
  public Date getDtStart() {
    return dtStart;
  }
  public void setDtStart(Date dtStart) {
    this.dtStart = dtStart;
  }
  public Date getDtEnd() {
    return dtEnd;
  }
  public void setDtEnd(Date dtEnd) {
    this.dtEnd = dtEnd;
  }
  public String getSavePage() {
    return savePage;
  }
  public void setSavePage(String savePage) {
    this.savePage = savePage;
  }
  public String getTxtRandPassword() {
    return txtRandPassword;
  }
  public void setTxtRandPassword(String txtRandPassword) {
    this.txtRandPassword = txtRandPassword;
  }
  public Integer getLoggedInUser() {
    return loggedInUser;
  }
  public void setLoggedInUser(Integer loggedInUser) {
    this.loggedInUser = loggedInUser;
  }
  public String getModifiedSystem() {
    return modifiedSystem;
  }
  public void setModifiedSystem(String modifiedSystem) {
    this.modifiedSystem = modifiedSystem;
  }
  public String getUserAccessType() {
    return userAccessType;
  }
  public void setUserAccessType(String userAccessType) {
    this.userAccessType = userAccessType;
  }
  public String getCdUserType() {
    return cdUserType;
  }
  public void setCdUserType(String cdUserType) {
    this.cdUserType = cdUserType;
  }
  public String getTxtUserFB() {
    return txtUserFB;
  }
  public void setTxtUserFB(String txtUserFB) {
    this.txtUserFB = txtUserFB;
  }
  public String getTxtUserMS() {
    return txtUserMS;
  }
  public void setTxtUserMS(String txtUserMS) {
    this.txtUserMS = txtUserMS;
  }
  public String getTxtUserTW() {
    return txtUserTW;
  }
  public void setTxtUserTW(String txtUserTW) {
    this.txtUserTW = txtUserTW;
  }
  public String getTxtUserOthSite() {
    return txtUserOthSite;
  }
  public void setTxtUserOthSite(String txtUserOthSite) {
    this.txtUserOthSite = txtUserOthSite;
  }
  public String getTxtUserNameOthSite() {
    return txtUserNameOthSite;
  }
  public void setTxtUserNameOthSite(String txtUserNameOthSite) {
    this.txtUserNameOthSite = txtUserNameOthSite;
  }
  public String getTxtUserPhnBest() {
    return txtUserPhnBest;
  }
  public void setTxtUserPhnBest(String txtUserPhnBest) {
    this.txtUserPhnBest = txtUserPhnBest;
  }
  public String getTxtUserPhnBestExt() {
    return txtUserPhnBestExt;
  }
  public void setTxtUserPhnBestExt(String txtUserPhnBestExt) {
    this.txtUserPhnBestExt = txtUserPhnBestExt;
  }
  public String getTxtUserPhnBestType() {
    return txtUserPhnBestType;
  }
  public void setTxtUserPhnBestType(String txtUserPhnBestType) {
    this.txtUserPhnBestType = txtUserPhnBestType;
  }
  public String getTxtUserPhnAlt1() {
    return txtUserPhnAlt1;
  }
  public void setTxtUserPhnAlt1(String txtUserPhnAlt1) {
    this.txtUserPhnAlt1 = txtUserPhnAlt1;
  }
  public String getTxtUserPhnAlt1Ext() {
    return txtUserPhnAlt1Ext;
  }
  public void setTxtUserPhnAlt1Ext(String txtUserPhnAlt1Ext) {
    this.txtUserPhnAlt1Ext = txtUserPhnAlt1Ext;
  }
  public String getTxtUserPhnAlt1Type() {
    return txtUserPhnAlt1Type;
  }
  public void setTxtUserPhnAlt1Type(String txtUserPhnAlt1Type) {
    this.txtUserPhnAlt1Type = txtUserPhnAlt1Type;
  }
  public String getTxtUserPhnAlt2() {
    return txtUserPhnAlt2;
  }
  public void setTxtUserPhnAlt2(String txtUserPhnAlt2) {
    this.txtUserPhnAlt2 = txtUserPhnAlt2;
  }
  public String getTxtUserPhnAlt2Ext() {
    return txtUserPhnAlt2Ext;
  }
  public void setTxtUserPhnAlt2Ext(String txtUserPhnAlt2Ext) {
    this.txtUserPhnAlt2Ext = txtUserPhnAlt2Ext;
  }
  public String getTxtUserPhnAlt2Type() {
    return txtUserPhnAlt2Type;
  }
  public void setTxtUserPhnAlt2Type(String txtUserPhnAlt2Type) {
    this.txtUserPhnAlt2Type = txtUserPhnAlt2Type;
  }
  public String getTxtCntctByText() {
    return txtCntctByText;
  }
  public void setTxtCntctByText(String txtCntctByText) {
    this.txtCntctByText = txtCntctByText;
  }
  public String getTxtEmerContact() {
    return txtEmerContact;
  }
  public void setTxtEmerContact(String txtEmerContact) {
    this.txtEmerContact = txtEmerContact;
  }
  
}
