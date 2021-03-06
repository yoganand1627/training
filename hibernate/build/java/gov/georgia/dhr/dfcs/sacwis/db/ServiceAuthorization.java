package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * ServiceAuthorization generated by hbm2java
 */
public class ServiceAuthorization  implements java.io.Serializable {


     private Integer idSvcAuth;
     private Date dtLastUpdate;
     private Person personByIdPrimaryClient;
     private Contract contract;
     private Person personByIdPerson;
     private CapsResource capsResource;
     private String cdSvcAuthCounty;
     private String cdSvcAuthAbilToRespond;
     private String cdSvcAuthCategory;
     private String cdSvcAuthRegion;
     private String cdSvcAuthService;
     private Date dtSvcAuthVerbalReferl;
     private Date dtSvcAuthEff;
     private String indSvcAuthComplete;
     private String txtSvcAuthComments;
     private String txtSvcAuthDirToHome;
     private String txtSvcAuthHomeEnviron;
     private String txtSvcAuthMedCond;
     private String txtSvcAuthSecProvdr;
     private String indDontdComntySvc;
     private Double amtEstValue;
     private String cdPayCnty;
     private String indWaiverReqd;
     private Integer idWaiver;
     private Date dtRefSent;
     private String cdErlyCaseTyp;
     private String cdPupTyp;
     private String cdPupOtcme;
     private Collection<SvcAuthEventLink> svcAuthEventLinks;
     private Collection<SvcAuthDetail> svcAuthDetails;

    public ServiceAuthorization() {
    }

	
    public ServiceAuthorization(Person personByIdPrimaryClient, CapsResource capsResource, String cdSvcAuthCounty, String cdPayCnty) {
        this.personByIdPrimaryClient = personByIdPrimaryClient;
        this.capsResource = capsResource;
        this.cdSvcAuthCounty = cdSvcAuthCounty;
        this.cdPayCnty = cdPayCnty;
    }
    public ServiceAuthorization(Person personByIdPrimaryClient, Contract contract, Person personByIdPerson, CapsResource capsResource, String cdSvcAuthCounty, String cdSvcAuthAbilToRespond, String cdSvcAuthCategory, String cdSvcAuthRegion, String cdSvcAuthService, Date dtSvcAuthVerbalReferl, Date dtSvcAuthEff, String indSvcAuthComplete, String txtSvcAuthComments, String txtSvcAuthDirToHome, String txtSvcAuthHomeEnviron, String txtSvcAuthMedCond, String txtSvcAuthSecProvdr, String indDontdComntySvc, Double amtEstValue, String cdPayCnty, String indWaiverReqd, Integer idWaiver, Date dtRefSent, String cdErlyCaseTyp, String cdPupTyp, String cdPupOtcme, Collection<SvcAuthEventLink> svcAuthEventLinks, Collection<SvcAuthDetail> svcAuthDetails) {
       this.personByIdPrimaryClient = personByIdPrimaryClient;
       this.contract = contract;
       this.personByIdPerson = personByIdPerson;
       this.capsResource = capsResource;
       this.cdSvcAuthCounty = cdSvcAuthCounty;
       this.cdSvcAuthAbilToRespond = cdSvcAuthAbilToRespond;
       this.cdSvcAuthCategory = cdSvcAuthCategory;
       this.cdSvcAuthRegion = cdSvcAuthRegion;
       this.cdSvcAuthService = cdSvcAuthService;
       this.dtSvcAuthVerbalReferl = dtSvcAuthVerbalReferl;
       this.dtSvcAuthEff = dtSvcAuthEff;
       this.indSvcAuthComplete = indSvcAuthComplete;
       this.txtSvcAuthComments = txtSvcAuthComments;
       this.txtSvcAuthDirToHome = txtSvcAuthDirToHome;
       this.txtSvcAuthHomeEnviron = txtSvcAuthHomeEnviron;
       this.txtSvcAuthMedCond = txtSvcAuthMedCond;
       this.txtSvcAuthSecProvdr = txtSvcAuthSecProvdr;
       this.indDontdComntySvc = indDontdComntySvc;
       this.amtEstValue = amtEstValue;
       this.cdPayCnty = cdPayCnty;
       this.indWaiverReqd = indWaiverReqd;
       this.idWaiver = idWaiver;
       this.dtRefSent = dtRefSent;
       this.cdErlyCaseTyp = cdErlyCaseTyp;
       this.cdPupTyp = cdPupTyp;
       this.cdPupOtcme = cdPupOtcme;
       this.svcAuthEventLinks = svcAuthEventLinks;
       this.svcAuthDetails = svcAuthDetails;
    }
   
    public Integer getIdSvcAuth() {
        return this.idSvcAuth;
    }
    
    public void setIdSvcAuth(Integer idSvcAuth) {
        this.idSvcAuth = idSvcAuth;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Person getPersonByIdPrimaryClient() {
        return this.personByIdPrimaryClient;
    }
    
    public void setPersonByIdPrimaryClient(Person personByIdPrimaryClient) {
        this.personByIdPrimaryClient = personByIdPrimaryClient;
    }
    public Contract getContract() {
        return this.contract;
    }
    
    public void setContract(Contract contract) {
        this.contract = contract;
    }
    public Person getPersonByIdPerson() {
        return this.personByIdPerson;
    }
    
    public void setPersonByIdPerson(Person personByIdPerson) {
        this.personByIdPerson = personByIdPerson;
    }
    public CapsResource getCapsResource() {
        return this.capsResource;
    }
    
    public void setCapsResource(CapsResource capsResource) {
        this.capsResource = capsResource;
    }
    public String getCdSvcAuthCounty() {
        return this.cdSvcAuthCounty;
    }
    
    public void setCdSvcAuthCounty(String cdSvcAuthCounty) {
        this.cdSvcAuthCounty = cdSvcAuthCounty;
    }
    public String getCdSvcAuthAbilToRespond() {
        return this.cdSvcAuthAbilToRespond;
    }
    
    public void setCdSvcAuthAbilToRespond(String cdSvcAuthAbilToRespond) {
        this.cdSvcAuthAbilToRespond = cdSvcAuthAbilToRespond;
    }
    public String getCdSvcAuthCategory() {
        return this.cdSvcAuthCategory;
    }
    
    public void setCdSvcAuthCategory(String cdSvcAuthCategory) {
        this.cdSvcAuthCategory = cdSvcAuthCategory;
    }
    public String getCdSvcAuthRegion() {
        return this.cdSvcAuthRegion;
    }
    
    public void setCdSvcAuthRegion(String cdSvcAuthRegion) {
        this.cdSvcAuthRegion = cdSvcAuthRegion;
    }
    public String getCdSvcAuthService() {
        return this.cdSvcAuthService;
    }
    
    public void setCdSvcAuthService(String cdSvcAuthService) {
        this.cdSvcAuthService = cdSvcAuthService;
    }
    public Date getDtSvcAuthVerbalReferl() {
        return this.dtSvcAuthVerbalReferl;
    }
    
    public void setDtSvcAuthVerbalReferl(Date dtSvcAuthVerbalReferl) {
        this.dtSvcAuthVerbalReferl = dtSvcAuthVerbalReferl;
    }
    public Date getDtSvcAuthEff() {
        return this.dtSvcAuthEff;
    }
    
    public void setDtSvcAuthEff(Date dtSvcAuthEff) {
        this.dtSvcAuthEff = dtSvcAuthEff;
    }
    public String getIndSvcAuthComplete() {
        return this.indSvcAuthComplete;
    }
    
    public void setIndSvcAuthComplete(String indSvcAuthComplete) {
        this.indSvcAuthComplete = indSvcAuthComplete;
    }
    public String getTxtSvcAuthComments() {
        return this.txtSvcAuthComments;
    }
    
    public void setTxtSvcAuthComments(String txtSvcAuthComments) {
        this.txtSvcAuthComments = txtSvcAuthComments;
    }
    public String getTxtSvcAuthDirToHome() {
        return this.txtSvcAuthDirToHome;
    }
    
    public void setTxtSvcAuthDirToHome(String txtSvcAuthDirToHome) {
        this.txtSvcAuthDirToHome = txtSvcAuthDirToHome;
    }
    public String getTxtSvcAuthHomeEnviron() {
        return this.txtSvcAuthHomeEnviron;
    }
    
    public void setTxtSvcAuthHomeEnviron(String txtSvcAuthHomeEnviron) {
        this.txtSvcAuthHomeEnviron = txtSvcAuthHomeEnviron;
    }
    public String getTxtSvcAuthMedCond() {
        return this.txtSvcAuthMedCond;
    }
    
    public void setTxtSvcAuthMedCond(String txtSvcAuthMedCond) {
        this.txtSvcAuthMedCond = txtSvcAuthMedCond;
    }
    public String getTxtSvcAuthSecProvdr() {
        return this.txtSvcAuthSecProvdr;
    }
    
    public void setTxtSvcAuthSecProvdr(String txtSvcAuthSecProvdr) {
        this.txtSvcAuthSecProvdr = txtSvcAuthSecProvdr;
    }
    public String getIndDontdComntySvc() {
        return this.indDontdComntySvc;
    }
    
    public void setIndDontdComntySvc(String indDontdComntySvc) {
        this.indDontdComntySvc = indDontdComntySvc;
    }
    public Double getAmtEstValue() {
        return this.amtEstValue;
    }
    
    public void setAmtEstValue(Double amtEstValue) {
        this.amtEstValue = amtEstValue;
    }
    public String getCdPayCnty() {
        return this.cdPayCnty;
    }
    
    public void setCdPayCnty(String cdPayCnty) {
        this.cdPayCnty = cdPayCnty;
    }
    public String getIndWaiverReqd() {
        return this.indWaiverReqd;
    }
    
    public void setIndWaiverReqd(String indWaiverReqd) {
        this.indWaiverReqd = indWaiverReqd;
    }
    public Integer getIdWaiver() {
        return this.idWaiver;
    }
    
    public void setIdWaiver(Integer idWaiver) {
        this.idWaiver = idWaiver;
    }
    public Date getDtRefSent() {
        return this.dtRefSent;
    }
    
    public void setDtRefSent(Date dtRefSent) {
        this.dtRefSent = dtRefSent;
    }
    public String getCdErlyCaseTyp() {
        return this.cdErlyCaseTyp;
    }
    
    public void setCdErlyCaseTyp(String cdErlyCaseTyp) {
        this.cdErlyCaseTyp = cdErlyCaseTyp;
    }
    public String getCdPupTyp() {
        return this.cdPupTyp;
    }
    
    public void setCdPupTyp(String cdPupTyp) {
        this.cdPupTyp = cdPupTyp;
    }
    public String getCdPupOtcme() {
        return this.cdPupOtcme;
    }
    
    public void setCdPupOtcme(String cdPupOtcme) {
        this.cdPupOtcme = cdPupOtcme;
    }
    public Collection<SvcAuthEventLink> getSvcAuthEventLinks() {
        return this.svcAuthEventLinks;
    }
    
    public void setSvcAuthEventLinks(Collection<SvcAuthEventLink> svcAuthEventLinks) {
        this.svcAuthEventLinks = svcAuthEventLinks;
    }
    public Collection<SvcAuthDetail> getSvcAuthDetails() {
        return this.svcAuthDetails;
    }
    
    public void setSvcAuthDetails(Collection<SvcAuthDetail> svcAuthDetails) {
        this.svcAuthDetails = svcAuthDetails;
    }




}


