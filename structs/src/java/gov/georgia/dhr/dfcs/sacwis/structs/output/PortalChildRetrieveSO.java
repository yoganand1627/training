package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PortalContactBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCharacteristicsBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;

public class PortalChildRetrieveSO implements Serializable {

  //Person Demographics
  private int ulIdPerson;
  private String nmPersonFirst;
  private String nmPersonMiddle;
  private String nmPersonLast;
  private int ulIdCase;
  private String cdGender;
  private Date dtChildBirth;
  private Integer ulChildAge;
  private String cdPersonChar;
  
  //Current Placement
  private String szNmRsrcFacil;
  private int ulIdResource;
  private int ulIdRsrcAgency;
  private Date dtPlcmtStart;
  private Date dtPlcmtEnd;
  private String cdRemovalRsn;
  private String cdPlcmtType;
  private String cdSiblingPlcmt;
  private String cdLegalCnty;
  private String cdRbwoProg;
  private double dPerDiem;
  private double dWaiverRate;
  private String cdIndCci;
  
  //Case Manager/Supervisor Data
  
  private String nmCaseManager;
  private String cdCaseManagerJobTitle;
  private String cdCaseManagerOfficeLoc;
  private String szCaseManagerPhone;
  
  private String nmSupervisor;
  private String cdSupervisorJobTitle;
  private String cdSupervisorOfficeLoc;
  private String szSupervisorPhone;
  
  //Person Characteristics
  private List<PersonCharacteristicsBean> childCharacteristicsList;
  
  //Contacts
  private List<PortalContactBean> contactsList;
  private ArchOutputStruct archOutputStruct;
  
//Person Demographics
  public int getUlIdPerson(){
    return ulIdPerson;
  }
  public String getNmPersonFirst(){
    return nmPersonFirst;
  }
  public String getNmPersonMiddle(){
    return nmPersonMiddle; 
  }
  public String getNmPersonLast(){
    return nmPersonLast;
  }
  public int getUlIdCase(){
    return ulIdCase;
  }
  public String getCdGender(){
    return cdGender;
  }
  public Date getDtChildBirth(){
    return dtChildBirth;
  }
  public Integer getUlChildAge(){
    return ulChildAge;
  }
  public String getCdPersonChar(){
    return cdPersonChar;
  }
  //Current Placement
  public int getUlIdEvent(){
    return ulIdPerson;
  }
  public String getSzNmRsrcFacil(){
    return szNmRsrcFacil;  
  }
  public int getUlIdResource(){
    return ulIdResource; 
  }
  public int getUlIdRsrcAgency(){
    return ulIdRsrcAgency; 
  }
  public Date getDtPlcmtStart(){
    return dtPlcmtStart;
  }
  public Date getDtPlcmtEnd(){
    return dtPlcmtEnd; 
  }
  public String getCdRemovalRsn(){
    return cdRemovalRsn;
  }
  public String getCdPlcmtType(){
    return cdPlcmtType;
  }
  public String getCdSiblingPlcmt(){
    return cdSiblingPlcmt;
  }
  public String getCdLegalCnty(){
    return cdLegalCnty;
  }
  public String getCdRbwoProg(){
    return cdRbwoProg;
  }
  public double getDPerDiem(){
    return dPerDiem; 
  }
  public double getDWaiverRate(){
    return dWaiverRate;
  }
  public String getCdIndCci(){
    return cdIndCci;
  }
  
  //Case Manager/Supervisor Data
  
  public String getNmCaseManager(){
    return nmCaseManager;  
  }
  public String getCdCaseManagerJobTitle(){
    return cdCaseManagerJobTitle;
  }
  public String getCdCaseManagerOfficeLoc(){
    return cdCaseManagerOfficeLoc;
  }
  public String getSzCaseManagerPhone(){
    return szCaseManagerPhone;
  }
  
  public String getNmSupervisor(){
    return nmSupervisor;  
  }
  public String getCdSupervisorJobTitle(){
    return cdSupervisorJobTitle;
  }
  public String getCdSupervisorOfficeLoc(){
    return cdSupervisorOfficeLoc;
  }
  public String getSzSupervisorPhone(){
    return szSupervisorPhone;
  }
  
  //Person Characteristics
  public List<PersonCharacteristicsBean> getChildCharacteristicsList(){
    return childCharacteristicsList; 
  }
  
  //Contacts
  public List<PortalContactBean> getContactsList(){
    return contactsList; 
  }
  
//Person Demographics
  public void setUlIdPerson(int ulIdPerson){
     this.ulIdPerson = ulIdPerson;  
  }
  
  public void setNmPersonFirst(String nmPersonFirst){
     this.nmPersonFirst = nmPersonFirst;  
  }
  
  public void setNmPersonMiddle(String nmPersonMiddle){
     this.nmPersonMiddle = nmPersonMiddle;  
  }
  
  public void setNmPersonLast(String nmPersonLast){
     this.nmPersonLast = nmPersonLast;  
  }
  
  public void setUlIdCase(int ulIdCase){
     this.ulIdCase = ulIdCase;  
  }
  
  public void setCdGender(String cdGender){
     this.cdGender = cdGender;  
  }
  
  public void setDtChildBirth(Date dtChildBirth){
     this.dtChildBirth = dtChildBirth;  
  }
  
  public void setUlChildAge(Integer ulChildAge){
     this.ulChildAge = ulChildAge;  
  }
  
  public void setCdPersonChar(String cdPersonChar){
    this.cdPersonChar = cdPersonChar;  
 }
  
  //Current Placement
    
  public void setSzNmRsrcFacil(String szNmRsrcFacil){
     this.szNmRsrcFacil = szNmRsrcFacil;  
  }
  
  public void setUlIdResource(int ulIdResource){
     this.ulIdResource = ulIdResource;  
  }
  
  public void setUlIdRsrcAgency(int ulIdRsrcAgency){
    this.ulIdRsrcAgency = ulIdRsrcAgency;  
 }
  
  public void setDtPlcmtStart(Date dtPlcmtStart){
     this.dtPlcmtStart = dtPlcmtStart;  
  }
  
  public void setDtPlcmtEnd(Date dtPlcmtEnd){
     this.dtPlcmtEnd = dtPlcmtEnd;  
  }
  
  public void setCdRemovalRsn(String cdRemovalRsn){
     this.cdRemovalRsn = cdRemovalRsn;  
  }
  
  public void setCdPlcmtType(String cdPlcmtType){
     this.cdPlcmtType = cdPlcmtType;  
  }
  
  public void setCdSiblingPlcmt(String cdSiblingPlcmt){
     this.cdSiblingPlcmt = cdSiblingPlcmt;  
  }
  
  public void setCdLegalCnty(String cdLegalCnty){
     this.cdLegalCnty = cdLegalCnty;  
  }
  
  public void setCdRbwoProg(String cdRbwoProg){
     this.cdRbwoProg = cdRbwoProg;  
  }
  
  public void setDPerDiem(double dPerDiem){
     this.dPerDiem = dPerDiem;  
  }
  
  public void setDWaiverRate(double dWaiverRate){
     this.dWaiverRate = dWaiverRate;  
  }
  public void setCdIndCci(String cdIndCci){
    this.cdIndCci = cdIndCci;  
 }
  
  //Case Manager/Supervisor Data
  
  public void setNmCaseManager(String nmCaseManager){
     this.nmCaseManager = nmCaseManager;  
  }
  
  public void setCdCaseManagerJobTitle(String cdCaseManagerJobTitle){
     this.cdCaseManagerJobTitle = cdCaseManagerJobTitle;  
  }
  
  public void setCdCaseManagerOfficeLoc(String cdCaseManagerOfficeLoc){
     this.cdCaseManagerOfficeLoc = cdCaseManagerOfficeLoc;  
  }
  
  public void setSzCaseManagerPhone(String szCaseManagerPhone){
     this.szCaseManagerPhone = szCaseManagerPhone;  
  }
  
  
  public void setNmSupervisor(String nmSupervisor){
     this.nmSupervisor = nmSupervisor;  
  }
  
  public void setCdSupervisorJobTitle(String cdSupervisorJobTitle){
     this.cdSupervisorJobTitle = cdSupervisorJobTitle;  
  }
  
  public void setCdSupervisorOfficeLoc(String cdSupervisorOfficeLoc){
     this.cdSupervisorOfficeLoc = cdSupervisorOfficeLoc;  
  }
  
  public void setSzSupervisorPhone(String szSupervisorPhone){
     this.szSupervisorPhone = szSupervisorPhone;  
  }
  
  
  //Person Characteristics
  public void setChildCharacteristicsList(List<PersonCharacteristicsBean> childCharacteristicsList){
     this.childCharacteristicsList = childCharacteristicsList;  
  }
  
  
  //Contacts
  public void setContactsList(List<PortalContactBean> contactsList){
     this.contactsList = contactsList;  
  }
  
  //Output struct for contact list pagination
  public ArchOutputStruct getArchOutputStruct() {
    return archOutputStruct;
  }

  public void setArchOutputStruct(ArchOutputStruct archOutputStruct) {
    this.archOutputStruct = archOutputStruct;
  }

   
}