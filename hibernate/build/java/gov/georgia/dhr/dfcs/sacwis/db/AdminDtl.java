package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * AdminDtl generated by hbm2java
 */
public class AdminDtl  implements java.io.Serializable {


     private Integer idAdminDtl;
     private Date dtLastUpdate;
     private Invoice invoice;
     private AdminDtl adminDtl;
     private Double amtAdminDtlAdminAlloc;
     private Double amtAdminDtlEquipment;
     private Double amtAdminDtlFrgBenft;
     private Double amtAdminDtlOffsetItem;
     private Double amtAdminDtlOther;
     private Double amtAdminDtlSalaries;
     private Double amtAdminDtlSupplies;
     private Double amtAdminDtlTravel;
     private String cdAdminDtlService;
     private String cdAdminDtlInvoDisptn;
     private String cdAdminDtlLiType;
     private String cdAdminDtlPac;
     private String cdAdminDtlObjCode;
     private String indAdminDtlRejItm;
     private Integer moAdminDtlSvcMonth;
     private Integer nbrAdminDtlCsli;
     private Integer yrAdminDtlSvcYear;
     private Integer nbrCntrctPrd;
     private String cdObjctCertified;
     private String cdObjctPure;
     private Double nbrObjctAllowable;
     private Double nbrObjctCertified;
     private Double nbrObjctPure;
     private String txtComments;
     private Double amtAdminDtlPromotional;
     private String cdCounty;
     private Double amtSmilePaid;
     private Integer nbrCheck;
     private Date dtPaid;
     private Collection<AdminDtl> adminDtls;

    public AdminDtl() {
    }

	
    public AdminDtl(Invoice invoice) {
        this.invoice = invoice;
    }
    public AdminDtl(Invoice invoice, AdminDtl adminDtl, Double amtAdminDtlAdminAlloc, Double amtAdminDtlEquipment, Double amtAdminDtlFrgBenft, Double amtAdminDtlOffsetItem, Double amtAdminDtlOther, Double amtAdminDtlSalaries, Double amtAdminDtlSupplies, Double amtAdminDtlTravel, String cdAdminDtlService, String cdAdminDtlInvoDisptn, String cdAdminDtlLiType, String cdAdminDtlPac, String cdAdminDtlObjCode, String indAdminDtlRejItm, Integer moAdminDtlSvcMonth, Integer nbrAdminDtlCsli, Integer yrAdminDtlSvcYear, Integer nbrCntrctPrd, String cdObjctCertified, String cdObjctPure, Double nbrObjctAllowable, Double nbrObjctCertified, Double nbrObjctPure, String txtComments, Double amtAdminDtlPromotional, String cdCounty, Double amtSmilePaid, Integer nbrCheck, Date dtPaid, Collection<AdminDtl> adminDtls) {
       this.invoice = invoice;
       this.adminDtl = adminDtl;
       this.amtAdminDtlAdminAlloc = amtAdminDtlAdminAlloc;
       this.amtAdminDtlEquipment = amtAdminDtlEquipment;
       this.amtAdminDtlFrgBenft = amtAdminDtlFrgBenft;
       this.amtAdminDtlOffsetItem = amtAdminDtlOffsetItem;
       this.amtAdminDtlOther = amtAdminDtlOther;
       this.amtAdminDtlSalaries = amtAdminDtlSalaries;
       this.amtAdminDtlSupplies = amtAdminDtlSupplies;
       this.amtAdminDtlTravel = amtAdminDtlTravel;
       this.cdAdminDtlService = cdAdminDtlService;
       this.cdAdminDtlInvoDisptn = cdAdminDtlInvoDisptn;
       this.cdAdminDtlLiType = cdAdminDtlLiType;
       this.cdAdminDtlPac = cdAdminDtlPac;
       this.cdAdminDtlObjCode = cdAdminDtlObjCode;
       this.indAdminDtlRejItm = indAdminDtlRejItm;
       this.moAdminDtlSvcMonth = moAdminDtlSvcMonth;
       this.nbrAdminDtlCsli = nbrAdminDtlCsli;
       this.yrAdminDtlSvcYear = yrAdminDtlSvcYear;
       this.nbrCntrctPrd = nbrCntrctPrd;
       this.cdObjctCertified = cdObjctCertified;
       this.cdObjctPure = cdObjctPure;
       this.nbrObjctAllowable = nbrObjctAllowable;
       this.nbrObjctCertified = nbrObjctCertified;
       this.nbrObjctPure = nbrObjctPure;
       this.txtComments = txtComments;
       this.amtAdminDtlPromotional = amtAdminDtlPromotional;
       this.cdCounty = cdCounty;
       this.amtSmilePaid = amtSmilePaid;
       this.nbrCheck = nbrCheck;
       this.dtPaid = dtPaid;
       this.adminDtls = adminDtls;
    }
   
    public Integer getIdAdminDtl() {
        return this.idAdminDtl;
    }
    
    public void setIdAdminDtl(Integer idAdminDtl) {
        this.idAdminDtl = idAdminDtl;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Invoice getInvoice() {
        return this.invoice;
    }
    
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    public AdminDtl getAdminDtl() {
        return this.adminDtl;
    }
    
    public void setAdminDtl(AdminDtl adminDtl) {
        this.adminDtl = adminDtl;
    }
    public Double getAmtAdminDtlAdminAlloc() {
        return this.amtAdminDtlAdminAlloc;
    }
    
    public void setAmtAdminDtlAdminAlloc(Double amtAdminDtlAdminAlloc) {
        this.amtAdminDtlAdminAlloc = amtAdminDtlAdminAlloc;
    }
    public Double getAmtAdminDtlEquipment() {
        return this.amtAdminDtlEquipment;
    }
    
    public void setAmtAdminDtlEquipment(Double amtAdminDtlEquipment) {
        this.amtAdminDtlEquipment = amtAdminDtlEquipment;
    }
    public Double getAmtAdminDtlFrgBenft() {
        return this.amtAdminDtlFrgBenft;
    }
    
    public void setAmtAdminDtlFrgBenft(Double amtAdminDtlFrgBenft) {
        this.amtAdminDtlFrgBenft = amtAdminDtlFrgBenft;
    }
    public Double getAmtAdminDtlOffsetItem() {
        return this.amtAdminDtlOffsetItem;
    }
    
    public void setAmtAdminDtlOffsetItem(Double amtAdminDtlOffsetItem) {
        this.amtAdminDtlOffsetItem = amtAdminDtlOffsetItem;
    }
    public Double getAmtAdminDtlOther() {
        return this.amtAdminDtlOther;
    }
    
    public void setAmtAdminDtlOther(Double amtAdminDtlOther) {
        this.amtAdminDtlOther = amtAdminDtlOther;
    }
    public Double getAmtAdminDtlSalaries() {
        return this.amtAdminDtlSalaries;
    }
    
    public void setAmtAdminDtlSalaries(Double amtAdminDtlSalaries) {
        this.amtAdminDtlSalaries = amtAdminDtlSalaries;
    }
    public Double getAmtAdminDtlSupplies() {
        return this.amtAdminDtlSupplies;
    }
    
    public void setAmtAdminDtlSupplies(Double amtAdminDtlSupplies) {
        this.amtAdminDtlSupplies = amtAdminDtlSupplies;
    }
    public Double getAmtAdminDtlTravel() {
        return this.amtAdminDtlTravel;
    }
    
    public void setAmtAdminDtlTravel(Double amtAdminDtlTravel) {
        this.amtAdminDtlTravel = amtAdminDtlTravel;
    }
    public String getCdAdminDtlService() {
        return this.cdAdminDtlService;
    }
    
    public void setCdAdminDtlService(String cdAdminDtlService) {
        this.cdAdminDtlService = cdAdminDtlService;
    }
    public String getCdAdminDtlInvoDisptn() {
        return this.cdAdminDtlInvoDisptn;
    }
    
    public void setCdAdminDtlInvoDisptn(String cdAdminDtlInvoDisptn) {
        this.cdAdminDtlInvoDisptn = cdAdminDtlInvoDisptn;
    }
    public String getCdAdminDtlLiType() {
        return this.cdAdminDtlLiType;
    }
    
    public void setCdAdminDtlLiType(String cdAdminDtlLiType) {
        this.cdAdminDtlLiType = cdAdminDtlLiType;
    }
    public String getCdAdminDtlPac() {
        return this.cdAdminDtlPac;
    }
    
    public void setCdAdminDtlPac(String cdAdminDtlPac) {
        this.cdAdminDtlPac = cdAdminDtlPac;
    }
    public String getCdAdminDtlObjCode() {
        return this.cdAdminDtlObjCode;
    }
    
    public void setCdAdminDtlObjCode(String cdAdminDtlObjCode) {
        this.cdAdminDtlObjCode = cdAdminDtlObjCode;
    }
    public String getIndAdminDtlRejItm() {
        return this.indAdminDtlRejItm;
    }
    
    public void setIndAdminDtlRejItm(String indAdminDtlRejItm) {
        this.indAdminDtlRejItm = indAdminDtlRejItm;
    }
    public Integer getMoAdminDtlSvcMonth() {
        return this.moAdminDtlSvcMonth;
    }
    
    public void setMoAdminDtlSvcMonth(Integer moAdminDtlSvcMonth) {
        this.moAdminDtlSvcMonth = moAdminDtlSvcMonth;
    }
    public Integer getNbrAdminDtlCsli() {
        return this.nbrAdminDtlCsli;
    }
    
    public void setNbrAdminDtlCsli(Integer nbrAdminDtlCsli) {
        this.nbrAdminDtlCsli = nbrAdminDtlCsli;
    }
    public Integer getYrAdminDtlSvcYear() {
        return this.yrAdminDtlSvcYear;
    }
    
    public void setYrAdminDtlSvcYear(Integer yrAdminDtlSvcYear) {
        this.yrAdminDtlSvcYear = yrAdminDtlSvcYear;
    }
    public Integer getNbrCntrctPrd() {
        return this.nbrCntrctPrd;
    }
    
    public void setNbrCntrctPrd(Integer nbrCntrctPrd) {
        this.nbrCntrctPrd = nbrCntrctPrd;
    }
    public String getCdObjctCertified() {
        return this.cdObjctCertified;
    }
    
    public void setCdObjctCertified(String cdObjctCertified) {
        this.cdObjctCertified = cdObjctCertified;
    }
    public String getCdObjctPure() {
        return this.cdObjctPure;
    }
    
    public void setCdObjctPure(String cdObjctPure) {
        this.cdObjctPure = cdObjctPure;
    }
    public Double getNbrObjctAllowable() {
        return this.nbrObjctAllowable;
    }
    
    public void setNbrObjctAllowable(Double nbrObjctAllowable) {
        this.nbrObjctAllowable = nbrObjctAllowable;
    }
    public Double getNbrObjctCertified() {
        return this.nbrObjctCertified;
    }
    
    public void setNbrObjctCertified(Double nbrObjctCertified) {
        this.nbrObjctCertified = nbrObjctCertified;
    }
    public Double getNbrObjctPure() {
        return this.nbrObjctPure;
    }
    
    public void setNbrObjctPure(Double nbrObjctPure) {
        this.nbrObjctPure = nbrObjctPure;
    }
    public String getTxtComments() {
        return this.txtComments;
    }
    
    public void setTxtComments(String txtComments) {
        this.txtComments = txtComments;
    }
    public Double getAmtAdminDtlPromotional() {
        return this.amtAdminDtlPromotional;
    }
    
    public void setAmtAdminDtlPromotional(Double amtAdminDtlPromotional) {
        this.amtAdminDtlPromotional = amtAdminDtlPromotional;
    }
    public String getCdCounty() {
        return this.cdCounty;
    }
    
    public void setCdCounty(String cdCounty) {
        this.cdCounty = cdCounty;
    }
    public Double getAmtSmilePaid() {
        return this.amtSmilePaid;
    }
    
    public void setAmtSmilePaid(Double amtSmilePaid) {
        this.amtSmilePaid = amtSmilePaid;
    }
    public Integer getNbrCheck() {
        return this.nbrCheck;
    }
    
    public void setNbrCheck(Integer nbrCheck) {
        this.nbrCheck = nbrCheck;
    }
    public Date getDtPaid() {
        return this.dtPaid;
    }
    
    public void setDtPaid(Date dtPaid) {
        this.dtPaid = dtPaid;
    }
    public Collection<AdminDtl> getAdminDtls() {
        return this.adminDtls;
    }
    
    public void setAdminDtls(Collection<AdminDtl> adminDtls) {
        this.adminDtls = adminDtls;
    }




}


