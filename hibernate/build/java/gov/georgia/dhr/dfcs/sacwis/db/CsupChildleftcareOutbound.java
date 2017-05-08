package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CsupChildleftcareOutbound generated by hbm2java
 */
public class CsupChildleftcareOutbound  implements java.io.Serializable {


     private Integer idCsupChldlftcareOutbound;
     private Date dtLastUpdate;
     private String interfaceStatus;
     private Date dtProcess;
     private String cdError;
     private Integer idInitiator;
     private Date dtChildhomeRequested;
     private int nbrChildCrsId;
     private Date dtLeftCare;
     private String cdReasonCode;
     private Integer idCase;
     private String nmFullName;
     private String addrPlcmtCity;
     private String addrPlcmtLn1;
     private String addrPlcmtLn2;
     private String addrPlcmtSt;
     private String addrPlcmtZip;
     private String nbrPlcmtTelephone;
     private Integer nbrNcpCrsId;

    public CsupChildleftcareOutbound() {
    }

	
    public CsupChildleftcareOutbound(String interfaceStatus, Integer idInitiator, int nbrChildCrsId, Integer idCase) {
        this.interfaceStatus = interfaceStatus;
        this.idInitiator = idInitiator;
        this.nbrChildCrsId = nbrChildCrsId;
        this.idCase = idCase;
    }
    public CsupChildleftcareOutbound(String interfaceStatus, Date dtProcess, String cdError, Integer idInitiator, Date dtChildhomeRequested, int nbrChildCrsId, Date dtLeftCare, String cdReasonCode, Integer idCase, String nmFullName, String addrPlcmtCity, String addrPlcmtLn1, String addrPlcmtLn2, String addrPlcmtSt, String addrPlcmtZip, String nbrPlcmtTelephone, Integer nbrNcpCrsId) {
       this.interfaceStatus = interfaceStatus;
       this.dtProcess = dtProcess;
       this.cdError = cdError;
       this.idInitiator = idInitiator;
       this.dtChildhomeRequested = dtChildhomeRequested;
       this.nbrChildCrsId = nbrChildCrsId;
       this.dtLeftCare = dtLeftCare;
       this.cdReasonCode = cdReasonCode;
       this.idCase = idCase;
       this.nmFullName = nmFullName;
       this.addrPlcmtCity = addrPlcmtCity;
       this.addrPlcmtLn1 = addrPlcmtLn1;
       this.addrPlcmtLn2 = addrPlcmtLn2;
       this.addrPlcmtSt = addrPlcmtSt;
       this.addrPlcmtZip = addrPlcmtZip;
       this.nbrPlcmtTelephone = nbrPlcmtTelephone;
       this.nbrNcpCrsId = nbrNcpCrsId;
    }
   
    public Integer getIdCsupChldlftcareOutbound() {
        return this.idCsupChldlftcareOutbound;
    }
    
    public void setIdCsupChldlftcareOutbound(Integer idCsupChldlftcareOutbound) {
        this.idCsupChldlftcareOutbound = idCsupChldlftcareOutbound;
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
    public Integer getIdInitiator() {
        return this.idInitiator;
    }
    
    public void setIdInitiator(Integer idInitiator) {
        this.idInitiator = idInitiator;
    }
    public Date getDtChildhomeRequested() {
        return this.dtChildhomeRequested;
    }
    
    public void setDtChildhomeRequested(Date dtChildhomeRequested) {
        this.dtChildhomeRequested = dtChildhomeRequested;
    }
    public int getNbrChildCrsId() {
        return this.nbrChildCrsId;
    }
    
    public void setNbrChildCrsId(int nbrChildCrsId) {
        this.nbrChildCrsId = nbrChildCrsId;
    }
    public Date getDtLeftCare() {
        return this.dtLeftCare;
    }
    
    public void setDtLeftCare(Date dtLeftCare) {
        this.dtLeftCare = dtLeftCare;
    }
    public String getCdReasonCode() {
        return this.cdReasonCode;
    }
    
    public void setCdReasonCode(String cdReasonCode) {
        this.cdReasonCode = cdReasonCode;
    }
    public Integer getIdCase() {
        return this.idCase;
    }
    
    public void setIdCase(Integer idCase) {
        this.idCase = idCase;
    }
    public String getNmFullName() {
        return this.nmFullName;
    }
    
    public void setNmFullName(String nmFullName) {
        this.nmFullName = nmFullName;
    }
    public String getAddrPlcmtCity() {
        return this.addrPlcmtCity;
    }
    
    public void setAddrPlcmtCity(String addrPlcmtCity) {
        this.addrPlcmtCity = addrPlcmtCity;
    }
    public String getAddrPlcmtLn1() {
        return this.addrPlcmtLn1;
    }
    
    public void setAddrPlcmtLn1(String addrPlcmtLn1) {
        this.addrPlcmtLn1 = addrPlcmtLn1;
    }
    public String getAddrPlcmtLn2() {
        return this.addrPlcmtLn2;
    }
    
    public void setAddrPlcmtLn2(String addrPlcmtLn2) {
        this.addrPlcmtLn2 = addrPlcmtLn2;
    }
    public String getAddrPlcmtSt() {
        return this.addrPlcmtSt;
    }
    
    public void setAddrPlcmtSt(String addrPlcmtSt) {
        this.addrPlcmtSt = addrPlcmtSt;
    }
    public String getAddrPlcmtZip() {
        return this.addrPlcmtZip;
    }
    
    public void setAddrPlcmtZip(String addrPlcmtZip) {
        this.addrPlcmtZip = addrPlcmtZip;
    }
    public String getNbrPlcmtTelephone() {
        return this.nbrPlcmtTelephone;
    }
    
    public void setNbrPlcmtTelephone(String nbrPlcmtTelephone) {
        this.nbrPlcmtTelephone = nbrPlcmtTelephone;
    }
    public Integer getNbrNcpCrsId() {
        return this.nbrNcpCrsId;
    }
    
    public void setNbrNcpCrsId(Integer nbrNcpCrsId) {
        this.nbrNcpCrsId = nbrNcpCrsId;
    }




}


