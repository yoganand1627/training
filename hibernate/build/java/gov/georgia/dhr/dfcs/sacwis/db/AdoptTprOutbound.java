package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * AdoptTprOutbound generated by hbm2java
 */
public class AdoptTprOutbound  implements java.io.Serializable {


     private Integer idAdoptTprOutbound;
     private Date dtLastUpdate;
     private String interfaceStatus;
     private Date dtProcess;
     private String cdError;
     private Integer idInitiator;
     private Date dtAdopttprRequested;
     private int nbrChildCrsId;
     private int nbrNcpCrsId;
     private Date dtTprFinalized;
     private Date dtAdoptFinalized;
     private Integer idCase;

    public AdoptTprOutbound() {
    }

	
    public AdoptTprOutbound(String interfaceStatus, Integer idInitiator, int nbrChildCrsId, int nbrNcpCrsId, Integer idCase) {
        this.interfaceStatus = interfaceStatus;
        this.idInitiator = idInitiator;
        this.nbrChildCrsId = nbrChildCrsId;
        this.nbrNcpCrsId = nbrNcpCrsId;
        this.idCase = idCase;
    }
    public AdoptTprOutbound(String interfaceStatus, Date dtProcess, String cdError, Integer idInitiator, Date dtAdopttprRequested, int nbrChildCrsId, int nbrNcpCrsId, Date dtTprFinalized, Date dtAdoptFinalized, Integer idCase) {
       this.interfaceStatus = interfaceStatus;
       this.dtProcess = dtProcess;
       this.cdError = cdError;
       this.idInitiator = idInitiator;
       this.dtAdopttprRequested = dtAdopttprRequested;
       this.nbrChildCrsId = nbrChildCrsId;
       this.nbrNcpCrsId = nbrNcpCrsId;
       this.dtTprFinalized = dtTprFinalized;
       this.dtAdoptFinalized = dtAdoptFinalized;
       this.idCase = idCase;
    }
   
    public Integer getIdAdoptTprOutbound() {
        return this.idAdoptTprOutbound;
    }
    
    public void setIdAdoptTprOutbound(Integer idAdoptTprOutbound) {
        this.idAdoptTprOutbound = idAdoptTprOutbound;
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
    public Date getDtAdopttprRequested() {
        return this.dtAdopttprRequested;
    }
    
    public void setDtAdopttprRequested(Date dtAdopttprRequested) {
        this.dtAdopttprRequested = dtAdopttprRequested;
    }
    public int getNbrChildCrsId() {
        return this.nbrChildCrsId;
    }
    
    public void setNbrChildCrsId(int nbrChildCrsId) {
        this.nbrChildCrsId = nbrChildCrsId;
    }
    public int getNbrNcpCrsId() {
        return this.nbrNcpCrsId;
    }
    
    public void setNbrNcpCrsId(int nbrNcpCrsId) {
        this.nbrNcpCrsId = nbrNcpCrsId;
    }
    public Date getDtTprFinalized() {
        return this.dtTprFinalized;
    }
    
    public void setDtTprFinalized(Date dtTprFinalized) {
        this.dtTprFinalized = dtTprFinalized;
    }
    public Date getDtAdoptFinalized() {
        return this.dtAdoptFinalized;
    }
    
    public void setDtAdoptFinalized(Date dtAdoptFinalized) {
        this.dtAdoptFinalized = dtAdoptFinalized;
    }
    public Integer getIdCase() {
        return this.idCase;
    }
    
    public void setIdCase(Integer idCase) {
        this.idCase = idCase;
    }




}

