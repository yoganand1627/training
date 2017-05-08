package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * TcmClaimOutbound generated by hbm2java
 */
public class TcmClaimOutbound  implements java.io.Serializable {


     private Integer idTcmClaimOutbound;
     private Date dtLastUpdate;
     private String interfaceStatus;
     private Date dtProcess;
     private String cdError;
     private Date dtTcmRequested;
     private Integer idTcmClaim;
     private String nmPersonLast;
     private String nmPersonFirst;
     private String nmPersonMiddle;
     private String cdPersonSuffix;
     private String cdPersonSex;
     private Date dtPersonBirth;
     private String nbrMedicaid;
     private Double amtBillingCharge;
     private String txtProviderId;
     private Integer unitsOfService;
     private String procedureCode;
     private String nbrTcn;

    public TcmClaimOutbound() {
    }

	
    public TcmClaimOutbound(String interfaceStatus, Integer idTcmClaim, String cdPersonSex) {
        this.interfaceStatus = interfaceStatus;
        this.idTcmClaim = idTcmClaim;
        this.cdPersonSex = cdPersonSex;
    }
    public TcmClaimOutbound(String interfaceStatus, Date dtProcess, String cdError, Date dtTcmRequested, Integer idTcmClaim, String nmPersonLast, String nmPersonFirst, String nmPersonMiddle, String cdPersonSuffix, String cdPersonSex, Date dtPersonBirth, String nbrMedicaid, Double amtBillingCharge, String txtProviderId, Integer unitsOfService, String procedureCode, String nbrTcn) {
       this.interfaceStatus = interfaceStatus;
       this.dtProcess = dtProcess;
       this.cdError = cdError;
       this.dtTcmRequested = dtTcmRequested;
       this.idTcmClaim = idTcmClaim;
       this.nmPersonLast = nmPersonLast;
       this.nmPersonFirst = nmPersonFirst;
       this.nmPersonMiddle = nmPersonMiddle;
       this.cdPersonSuffix = cdPersonSuffix;
       this.cdPersonSex = cdPersonSex;
       this.dtPersonBirth = dtPersonBirth;
       this.nbrMedicaid = nbrMedicaid;
       this.amtBillingCharge = amtBillingCharge;
       this.txtProviderId = txtProviderId;
       this.unitsOfService = unitsOfService;
       this.procedureCode = procedureCode;
       this.nbrTcn = nbrTcn;
    }
   
    public Integer getIdTcmClaimOutbound() {
        return this.idTcmClaimOutbound;
    }
    
    public void setIdTcmClaimOutbound(Integer idTcmClaimOutbound) {
        this.idTcmClaimOutbound = idTcmClaimOutbound;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public String getInterfaceStatus() {
        return this.interfaceStatus;
    }
    
    public void setInterfaceStatus(String interfaceStatus) {
        this.interfaceStatus = interfaceStatus;
    }
    public Date getDtProcess() {
        return this.dtProcess;
    }
    
    public void setDtProcess(Date dtProcess) {
        this.dtProcess = dtProcess;
    }
    public String getCdError() {
        return this.cdError;
    }
    
    public void setCdError(String cdError) {
        this.cdError = cdError;
    }
    public Date getDtTcmRequested() {
        return this.dtTcmRequested;
    }
    
    public void setDtTcmRequested(Date dtTcmRequested) {
        this.dtTcmRequested = dtTcmRequested;
    }
    public Integer getIdTcmClaim() {
        return this.idTcmClaim;
    }
    
    public void setIdTcmClaim(Integer idTcmClaim) {
        this.idTcmClaim = idTcmClaim;
    }
    public String getNmPersonLast() {
        return this.nmPersonLast;
    }
    
    public void setNmPersonLast(String nmPersonLast) {
        this.nmPersonLast = nmPersonLast;
    }
    public String getNmPersonFirst() {
        return this.nmPersonFirst;
    }
    
    public void setNmPersonFirst(String nmPersonFirst) {
        this.nmPersonFirst = nmPersonFirst;
    }
    public String getNmPersonMiddle() {
        return this.nmPersonMiddle;
    }
    
    public void setNmPersonMiddle(String nmPersonMiddle) {
        this.nmPersonMiddle = nmPersonMiddle;
    }
    public String getCdPersonSuffix() {
        return this.cdPersonSuffix;
    }
    
    public void setCdPersonSuffix(String cdPersonSuffix) {
        this.cdPersonSuffix = cdPersonSuffix;
    }
    public String getCdPersonSex() {
        return this.cdPersonSex;
    }
    
    public void setCdPersonSex(String cdPersonSex) {
        this.cdPersonSex = cdPersonSex;
    }
    public Date getDtPersonBirth() {
        return this.dtPersonBirth;
    }
    
    public void setDtPersonBirth(Date dtPersonBirth) {
        this.dtPersonBirth = dtPersonBirth;
    }
    public String getNbrMedicaid() {
        return this.nbrMedicaid;
    }
    
    public void setNbrMedicaid(String nbrMedicaid) {
        this.nbrMedicaid = nbrMedicaid;
    }
    public Double getAmtBillingCharge() {
        return this.amtBillingCharge;
    }
    
    public void setAmtBillingCharge(Double amtBillingCharge) {
        this.amtBillingCharge = amtBillingCharge;
    }
    public String getTxtProviderId() {
        return this.txtProviderId;
    }
    
    public void setTxtProviderId(String txtProviderId) {
        this.txtProviderId = txtProviderId;
    }
    public Integer getUnitsOfService() {
        return this.unitsOfService;
    }
    
    public void setUnitsOfService(Integer unitsOfService) {
        this.unitsOfService = unitsOfService;
    }
    public String getProcedureCode() {
        return this.procedureCode;
    }
    
    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }
    public String getNbrTcn() {
        return this.nbrTcn;
    }
    
    public void setNbrTcn(String nbrTcn) {
        this.nbrTcn = nbrTcn;
    }




}


