package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * IncomingDetail generated by hbm2java
 */
public class IncomingDetail  implements java.io.Serializable {


     private Integer idStage;
     private Date dtLastUpdate;
     private Stage stage;
     private Event event;
     private CapsResource capsResource;
     private CapsCase capsCase;
     private Employee employee;
     private Employee employeeByIdIncomingSup;
     private CapsResource capsResourceByIdReferredResource;
     private String nbrIncmgUnit;
     private String cdIncmgRegion;
     private String nmIncomingCallerLast;
     private String cdIncmgCallerInt;
     private String addrIncmgWorkerCity;
     private String nbrIncmgWorkerPhone;
     private String nbrIncmgWorkerExt;
     private String nmIncmgWorkerName;
     private String cdIncmgAllegType;
     private String cdIncmgCallerAddrType;
     private String cdIncmgCallerPhonType;
     private String nbrIncmgCallerPhonExt;
     private String cdIncomingCallerSuffix;
     private String cdIncmgSpecHandling;
     private String indIncmgMaltreatInCare;
     private String indPolicyViolation;
     private String indIncmgSensitive;
     private String indIncmgWorkerSafety;
     private String txtIncmgWorkerSafety;
     private String txtIncmgSensitive;
     private String cdIncomingCallType;
     private String cdIncmgSex;
     private String addrIncmgStreetLn1;
     private String addrIncmgStreetLn2;
     private String indIncmgNoFactor;
     private String addrIncmgZip;
     private String nmIncmgRegardingLast;
     private String nmIncmgJurisdiction;
     private String addrIncomingCallerCity;
     private Date dtIncomingCallDisposed;
     private String cdIncomingDisposition;
     private String cdIncmgStatus;
     private String nmIncomingCallerFirst;
     private String cdIncomingCallerState;
     private Date dtIncomingCall;
     private String nmIncmgRegardingFirst;
     private String cdIncomingCallerCounty;
     private String cdIncomingProgramType;
     private String nbrIncomingCallerPhone;
     private String nmIncomingCallerMiddle;
     private String indIncmgIntInvClsReclass;
     private String indIncmgSuspMeth;
     private String txtIncmgSuspMeth;
     private String cdNonRsdntReqType;
     private String cdSpclInvstgtn;
     private String indCnfidntltyExplnd;
     private Date dtCnfidntltyExplntn;
     private String indIncmgLawEnfInvol;
     private String cdIncmgWorkerRegion;
     private String nmIncmgSupName;
     private String nbrIncmgSupPhone;
     private String nbrIncmgSupExt;
     private String cdIncomingWorkerCounty;
     private String cdSpclCircumstances;
     private String indMrLetter;
     private Collection<Event> eventsForIdStage;

    public IncomingDetail() {
    }

	
    public IncomingDetail(Stage stage, Employee employee) {
        this.stage = stage;
        this.employee = employee;
    }
    public IncomingDetail(Stage stage, Event event, CapsResource capsResource, CapsCase capsCase, Employee employee, Employee employeeByIdIncomingSup, CapsResource capsResourceByIdReferredResource, String nbrIncmgUnit, String cdIncmgRegion, String nmIncomingCallerLast, String cdIncmgCallerInt, String addrIncmgWorkerCity, String nbrIncmgWorkerPhone, String nbrIncmgWorkerExt, String nmIncmgWorkerName, String cdIncmgAllegType, String cdIncmgCallerAddrType, String cdIncmgCallerPhonType, String nbrIncmgCallerPhonExt, String cdIncomingCallerSuffix, String cdIncmgSpecHandling, String indIncmgMaltreatInCare, String indPolicyViolation, String indIncmgSensitive, String indIncmgWorkerSafety, String txtIncmgWorkerSafety, String txtIncmgSensitive, String cdIncomingCallType, String cdIncmgSex, String addrIncmgStreetLn1, String addrIncmgStreetLn2, String indIncmgNoFactor, String addrIncmgZip, String nmIncmgRegardingLast, String nmIncmgJurisdiction, String addrIncomingCallerCity, Date dtIncomingCallDisposed, String cdIncomingDisposition, String cdIncmgStatus, String nmIncomingCallerFirst, String cdIncomingCallerState, Date dtIncomingCall, String nmIncmgRegardingFirst, String cdIncomingCallerCounty, String cdIncomingProgramType, String nbrIncomingCallerPhone, String nmIncomingCallerMiddle, String indIncmgIntInvClsReclass, String indIncmgSuspMeth, String txtIncmgSuspMeth, String cdNonRsdntReqType, String cdSpclInvstgtn, String indCnfidntltyExplnd, Date dtCnfidntltyExplntn, String indIncmgLawEnfInvol, String cdIncmgWorkerRegion, String nmIncmgSupName, String nbrIncmgSupPhone, String nbrIncmgSupExt, String cdIncomingWorkerCounty, String cdSpclCircumstances, String indMrLetter, Collection<Event> eventsForIdStage) {
       this.stage = stage;
       this.event = event;
       this.capsResource = capsResource;
       this.capsCase = capsCase;
       this.employee = employee;
       this.employeeByIdIncomingSup = employeeByIdIncomingSup;
       this.capsResourceByIdReferredResource = capsResourceByIdReferredResource;
       this.nbrIncmgUnit = nbrIncmgUnit;
       this.cdIncmgRegion = cdIncmgRegion;
       this.nmIncomingCallerLast = nmIncomingCallerLast;
       this.cdIncmgCallerInt = cdIncmgCallerInt;
       this.addrIncmgWorkerCity = addrIncmgWorkerCity;
       this.nbrIncmgWorkerPhone = nbrIncmgWorkerPhone;
       this.nbrIncmgWorkerExt = nbrIncmgWorkerExt;
       this.nmIncmgWorkerName = nmIncmgWorkerName;
       this.cdIncmgAllegType = cdIncmgAllegType;
       this.cdIncmgCallerAddrType = cdIncmgCallerAddrType;
       this.cdIncmgCallerPhonType = cdIncmgCallerPhonType;
       this.nbrIncmgCallerPhonExt = nbrIncmgCallerPhonExt;
       this.cdIncomingCallerSuffix = cdIncomingCallerSuffix;
       this.cdIncmgSpecHandling = cdIncmgSpecHandling;
       this.indIncmgMaltreatInCare = indIncmgMaltreatInCare;
       this.indPolicyViolation = indPolicyViolation;
       this.indIncmgSensitive = indIncmgSensitive;
       this.indIncmgWorkerSafety = indIncmgWorkerSafety;
       this.txtIncmgWorkerSafety = txtIncmgWorkerSafety;
       this.txtIncmgSensitive = txtIncmgSensitive;
       this.cdIncomingCallType = cdIncomingCallType;
       this.cdIncmgSex = cdIncmgSex;
       this.addrIncmgStreetLn1 = addrIncmgStreetLn1;
       this.addrIncmgStreetLn2 = addrIncmgStreetLn2;
       this.indIncmgNoFactor = indIncmgNoFactor;
       this.addrIncmgZip = addrIncmgZip;
       this.nmIncmgRegardingLast = nmIncmgRegardingLast;
       this.nmIncmgJurisdiction = nmIncmgJurisdiction;
       this.addrIncomingCallerCity = addrIncomingCallerCity;
       this.dtIncomingCallDisposed = dtIncomingCallDisposed;
       this.cdIncomingDisposition = cdIncomingDisposition;
       this.cdIncmgStatus = cdIncmgStatus;
       this.nmIncomingCallerFirst = nmIncomingCallerFirst;
       this.cdIncomingCallerState = cdIncomingCallerState;
       this.dtIncomingCall = dtIncomingCall;
       this.nmIncmgRegardingFirst = nmIncmgRegardingFirst;
       this.cdIncomingCallerCounty = cdIncomingCallerCounty;
       this.cdIncomingProgramType = cdIncomingProgramType;
       this.nbrIncomingCallerPhone = nbrIncomingCallerPhone;
       this.nmIncomingCallerMiddle = nmIncomingCallerMiddle;
       this.indIncmgIntInvClsReclass = indIncmgIntInvClsReclass;
       this.indIncmgSuspMeth = indIncmgSuspMeth;
       this.txtIncmgSuspMeth = txtIncmgSuspMeth;
       this.cdNonRsdntReqType = cdNonRsdntReqType;
       this.cdSpclInvstgtn = cdSpclInvstgtn;
       this.indCnfidntltyExplnd = indCnfidntltyExplnd;
       this.dtCnfidntltyExplntn = dtCnfidntltyExplntn;
       this.indIncmgLawEnfInvol = indIncmgLawEnfInvol;
       this.cdIncmgWorkerRegion = cdIncmgWorkerRegion;
       this.nmIncmgSupName = nmIncmgSupName;
       this.nbrIncmgSupPhone = nbrIncmgSupPhone;
       this.nbrIncmgSupExt = nbrIncmgSupExt;
       this.cdIncomingWorkerCounty = cdIncomingWorkerCounty;
       this.cdSpclCircumstances = cdSpclCircumstances;
       this.indMrLetter = indMrLetter;
       this.eventsForIdStage = eventsForIdStage;
    }
   
    public Integer getIdStage() {
        return this.idStage;
    }
    
    public void setIdStage(Integer idStage) {
        this.idStage = idStage;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Stage getStage() {
        return this.stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public CapsResource getCapsResource() {
        return this.capsResource;
    }
    
    public void setCapsResource(CapsResource capsResource) {
        this.capsResource = capsResource;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Employee getEmployeeByIdIncomingSup() {
        return this.employeeByIdIncomingSup;
    }
    
    public void setEmployeeByIdIncomingSup(Employee employeeByIdIncomingSup) {
        this.employeeByIdIncomingSup = employeeByIdIncomingSup;
    }
    public CapsResource getCapsResourceByIdReferredResource() {
        return this.capsResourceByIdReferredResource;
    }
    
    public void setCapsResourceByIdReferredResource(CapsResource capsResourceByIdReferredResource) {
        this.capsResourceByIdReferredResource = capsResourceByIdReferredResource;
    }
    public String getNbrIncmgUnit() {
        return this.nbrIncmgUnit;
    }
    
    public void setNbrIncmgUnit(String nbrIncmgUnit) {
        this.nbrIncmgUnit = nbrIncmgUnit;
    }
    public String getCdIncmgRegion() {
        return this.cdIncmgRegion;
    }
    
    public void setCdIncmgRegion(String cdIncmgRegion) {
        this.cdIncmgRegion = cdIncmgRegion;
    }
    public String getNmIncomingCallerLast() {
        return this.nmIncomingCallerLast;
    }
    
    public void setNmIncomingCallerLast(String nmIncomingCallerLast) {
        this.nmIncomingCallerLast = nmIncomingCallerLast;
    }
    public String getCdIncmgCallerInt() {
        return this.cdIncmgCallerInt;
    }
    
    public void setCdIncmgCallerInt(String cdIncmgCallerInt) {
        this.cdIncmgCallerInt = cdIncmgCallerInt;
    }
    public String getAddrIncmgWorkerCity() {
        return this.addrIncmgWorkerCity;
    }
    
    public void setAddrIncmgWorkerCity(String addrIncmgWorkerCity) {
        this.addrIncmgWorkerCity = addrIncmgWorkerCity;
    }
    public String getNbrIncmgWorkerPhone() {
        return this.nbrIncmgWorkerPhone;
    }
    
    public void setNbrIncmgWorkerPhone(String nbrIncmgWorkerPhone) {
        this.nbrIncmgWorkerPhone = nbrIncmgWorkerPhone;
    }
    public String getNbrIncmgWorkerExt() {
        return this.nbrIncmgWorkerExt;
    }
    
    public void setNbrIncmgWorkerExt(String nbrIncmgWorkerExt) {
        this.nbrIncmgWorkerExt = nbrIncmgWorkerExt;
    }
    public String getNmIncmgWorkerName() {
        return this.nmIncmgWorkerName;
    }
    
    public void setNmIncmgWorkerName(String nmIncmgWorkerName) {
        this.nmIncmgWorkerName = nmIncmgWorkerName;
    }
    public String getCdIncmgAllegType() {
        return this.cdIncmgAllegType;
    }
    
    public void setCdIncmgAllegType(String cdIncmgAllegType) {
        this.cdIncmgAllegType = cdIncmgAllegType;
    }
    public String getCdIncmgCallerAddrType() {
        return this.cdIncmgCallerAddrType;
    }
    
    public void setCdIncmgCallerAddrType(String cdIncmgCallerAddrType) {
        this.cdIncmgCallerAddrType = cdIncmgCallerAddrType;
    }
    public String getCdIncmgCallerPhonType() {
        return this.cdIncmgCallerPhonType;
    }
    
    public void setCdIncmgCallerPhonType(String cdIncmgCallerPhonType) {
        this.cdIncmgCallerPhonType = cdIncmgCallerPhonType;
    }
    public String getNbrIncmgCallerPhonExt() {
        return this.nbrIncmgCallerPhonExt;
    }
    
    public void setNbrIncmgCallerPhonExt(String nbrIncmgCallerPhonExt) {
        this.nbrIncmgCallerPhonExt = nbrIncmgCallerPhonExt;
    }
    public String getCdIncomingCallerSuffix() {
        return this.cdIncomingCallerSuffix;
    }
    
    public void setCdIncomingCallerSuffix(String cdIncomingCallerSuffix) {
        this.cdIncomingCallerSuffix = cdIncomingCallerSuffix;
    }
    public String getCdIncmgSpecHandling() {
        return this.cdIncmgSpecHandling;
    }
    
    public void setCdIncmgSpecHandling(String cdIncmgSpecHandling) {
        this.cdIncmgSpecHandling = cdIncmgSpecHandling;
    }
    public String getIndIncmgMaltreatInCare() {
        return this.indIncmgMaltreatInCare;
    }
    
    public void setIndIncmgMaltreatInCare(String indIncmgMaltreatInCare) {
        this.indIncmgMaltreatInCare = indIncmgMaltreatInCare;
    }
    public String getIndPolicyViolation() {
        return this.indPolicyViolation;
    }
    
    public void setIndPolicyViolation(String indPolicyViolation) {
        this.indPolicyViolation = indPolicyViolation;
    }
    public String getIndIncmgSensitive() {
        return this.indIncmgSensitive;
    }
    
    public void setIndIncmgSensitive(String indIncmgSensitive) {
        this.indIncmgSensitive = indIncmgSensitive;
    }
    public String getIndIncmgWorkerSafety() {
        return this.indIncmgWorkerSafety;
    }
    
    public void setIndIncmgWorkerSafety(String indIncmgWorkerSafety) {
        this.indIncmgWorkerSafety = indIncmgWorkerSafety;
    }
    public String getTxtIncmgWorkerSafety() {
        return this.txtIncmgWorkerSafety;
    }
    
    public void setTxtIncmgWorkerSafety(String txtIncmgWorkerSafety) {
        this.txtIncmgWorkerSafety = txtIncmgWorkerSafety;
    }
    public String getTxtIncmgSensitive() {
        return this.txtIncmgSensitive;
    }
    
    public void setTxtIncmgSensitive(String txtIncmgSensitive) {
        this.txtIncmgSensitive = txtIncmgSensitive;
    }
    public String getCdIncomingCallType() {
        return this.cdIncomingCallType;
    }
    
    public void setCdIncomingCallType(String cdIncomingCallType) {
        this.cdIncomingCallType = cdIncomingCallType;
    }
    public String getCdIncmgSex() {
        return this.cdIncmgSex;
    }
    
    public void setCdIncmgSex(String cdIncmgSex) {
        this.cdIncmgSex = cdIncmgSex;
    }
    public String getAddrIncmgStreetLn1() {
        return this.addrIncmgStreetLn1;
    }
    
    public void setAddrIncmgStreetLn1(String addrIncmgStreetLn1) {
        this.addrIncmgStreetLn1 = addrIncmgStreetLn1;
    }
    public String getAddrIncmgStreetLn2() {
        return this.addrIncmgStreetLn2;
    }
    
    public void setAddrIncmgStreetLn2(String addrIncmgStreetLn2) {
        this.addrIncmgStreetLn2 = addrIncmgStreetLn2;
    }
    public String getIndIncmgNoFactor() {
        return this.indIncmgNoFactor;
    }
    
    public void setIndIncmgNoFactor(String indIncmgNoFactor) {
        this.indIncmgNoFactor = indIncmgNoFactor;
    }
    public String getAddrIncmgZip() {
        return this.addrIncmgZip;
    }
    
    public void setAddrIncmgZip(String addrIncmgZip) {
        this.addrIncmgZip = addrIncmgZip;
    }
    public String getNmIncmgRegardingLast() {
        return this.nmIncmgRegardingLast;
    }
    
    public void setNmIncmgRegardingLast(String nmIncmgRegardingLast) {
        this.nmIncmgRegardingLast = nmIncmgRegardingLast;
    }
    public String getNmIncmgJurisdiction() {
        return this.nmIncmgJurisdiction;
    }
    
    public void setNmIncmgJurisdiction(String nmIncmgJurisdiction) {
        this.nmIncmgJurisdiction = nmIncmgJurisdiction;
    }
    public String getAddrIncomingCallerCity() {
        return this.addrIncomingCallerCity;
    }
    
    public void setAddrIncomingCallerCity(String addrIncomingCallerCity) {
        this.addrIncomingCallerCity = addrIncomingCallerCity;
    }
    public Date getDtIncomingCallDisposed() {
        return this.dtIncomingCallDisposed;
    }
    
    public void setDtIncomingCallDisposed(Date dtIncomingCallDisposed) {
        this.dtIncomingCallDisposed = dtIncomingCallDisposed;
    }
    public String getCdIncomingDisposition() {
        return this.cdIncomingDisposition;
    }
    
    public void setCdIncomingDisposition(String cdIncomingDisposition) {
        this.cdIncomingDisposition = cdIncomingDisposition;
    }
    public String getCdIncmgStatus() {
        return this.cdIncmgStatus;
    }
    
    public void setCdIncmgStatus(String cdIncmgStatus) {
        this.cdIncmgStatus = cdIncmgStatus;
    }
    public String getNmIncomingCallerFirst() {
        return this.nmIncomingCallerFirst;
    }
    
    public void setNmIncomingCallerFirst(String nmIncomingCallerFirst) {
        this.nmIncomingCallerFirst = nmIncomingCallerFirst;
    }
    public String getCdIncomingCallerState() {
        return this.cdIncomingCallerState;
    }
    
    public void setCdIncomingCallerState(String cdIncomingCallerState) {
        this.cdIncomingCallerState = cdIncomingCallerState;
    }
    public Date getDtIncomingCall() {
        return this.dtIncomingCall;
    }
    
    public void setDtIncomingCall(Date dtIncomingCall) {
        this.dtIncomingCall = dtIncomingCall;
    }
    public String getNmIncmgRegardingFirst() {
        return this.nmIncmgRegardingFirst;
    }
    
    public void setNmIncmgRegardingFirst(String nmIncmgRegardingFirst) {
        this.nmIncmgRegardingFirst = nmIncmgRegardingFirst;
    }
    public String getCdIncomingCallerCounty() {
        return this.cdIncomingCallerCounty;
    }
    
    public void setCdIncomingCallerCounty(String cdIncomingCallerCounty) {
        this.cdIncomingCallerCounty = cdIncomingCallerCounty;
    }
    public String getCdIncomingProgramType() {
        return this.cdIncomingProgramType;
    }
    
    public void setCdIncomingProgramType(String cdIncomingProgramType) {
        this.cdIncomingProgramType = cdIncomingProgramType;
    }
    public String getNbrIncomingCallerPhone() {
        return this.nbrIncomingCallerPhone;
    }
    
    public void setNbrIncomingCallerPhone(String nbrIncomingCallerPhone) {
        this.nbrIncomingCallerPhone = nbrIncomingCallerPhone;
    }
    public String getNmIncomingCallerMiddle() {
        return this.nmIncomingCallerMiddle;
    }
    
    public void setNmIncomingCallerMiddle(String nmIncomingCallerMiddle) {
        this.nmIncomingCallerMiddle = nmIncomingCallerMiddle;
    }
    public String getIndIncmgIntInvClsReclass() {
        return this.indIncmgIntInvClsReclass;
    }
    
    public void setIndIncmgIntInvClsReclass(String indIncmgIntInvClsReclass) {
        this.indIncmgIntInvClsReclass = indIncmgIntInvClsReclass;
    }
    public String getIndIncmgSuspMeth() {
        return this.indIncmgSuspMeth;
    }
    
    public void setIndIncmgSuspMeth(String indIncmgSuspMeth) {
        this.indIncmgSuspMeth = indIncmgSuspMeth;
    }
    public String getTxtIncmgSuspMeth() {
        return this.txtIncmgSuspMeth;
    }
    
    public void setTxtIncmgSuspMeth(String txtIncmgSuspMeth) {
        this.txtIncmgSuspMeth = txtIncmgSuspMeth;
    }
    public String getCdNonRsdntReqType() {
        return this.cdNonRsdntReqType;
    }
    
    public void setCdNonRsdntReqType(String cdNonRsdntReqType) {
        this.cdNonRsdntReqType = cdNonRsdntReqType;
    }
    public String getCdSpclInvstgtn() {
        return this.cdSpclInvstgtn;
    }
    
    public void setCdSpclInvstgtn(String cdSpclInvstgtn) {
        this.cdSpclInvstgtn = cdSpclInvstgtn;
    }
    public String getIndCnfidntltyExplnd() {
        return this.indCnfidntltyExplnd;
    }
    
    public void setIndCnfidntltyExplnd(String indCnfidntltyExplnd) {
        this.indCnfidntltyExplnd = indCnfidntltyExplnd;
    }
    public Date getDtCnfidntltyExplntn() {
        return this.dtCnfidntltyExplntn;
    }
    
    public void setDtCnfidntltyExplntn(Date dtCnfidntltyExplntn) {
        this.dtCnfidntltyExplntn = dtCnfidntltyExplntn;
    }
    public String getIndIncmgLawEnfInvol() {
        return this.indIncmgLawEnfInvol;
    }
    
    public void setIndIncmgLawEnfInvol(String indIncmgLawEnfInvol) {
        this.indIncmgLawEnfInvol = indIncmgLawEnfInvol;
    }
    public String getCdIncmgWorkerRegion() {
        return this.cdIncmgWorkerRegion;
    }
    
    public void setCdIncmgWorkerRegion(String cdIncmgWorkerRegion) {
        this.cdIncmgWorkerRegion = cdIncmgWorkerRegion;
    }
    public String getNmIncmgSupName() {
        return this.nmIncmgSupName;
    }
    
    public void setNmIncmgSupName(String nmIncmgSupName) {
        this.nmIncmgSupName = nmIncmgSupName;
    }
    public String getNbrIncmgSupPhone() {
        return this.nbrIncmgSupPhone;
    }
    
    public void setNbrIncmgSupPhone(String nbrIncmgSupPhone) {
        this.nbrIncmgSupPhone = nbrIncmgSupPhone;
    }
    public String getNbrIncmgSupExt() {
        return this.nbrIncmgSupExt;
    }
    
    public void setNbrIncmgSupExt(String nbrIncmgSupExt) {
        this.nbrIncmgSupExt = nbrIncmgSupExt;
    }
    public String getCdIncomingWorkerCounty() {
        return this.cdIncomingWorkerCounty;
    }
    
    public void setCdIncomingWorkerCounty(String cdIncomingWorkerCounty) {
        this.cdIncomingWorkerCounty = cdIncomingWorkerCounty;
    }
    public String getCdSpclCircumstances() {
        return this.cdSpclCircumstances;
    }
    
    public void setCdSpclCircumstances(String cdSpclCircumstances) {
        this.cdSpclCircumstances = cdSpclCircumstances;
    }
    public String getIndMrLetter() {
        return this.indMrLetter;
    }
    
    public void setIndMrLetter(String indMrLetter) {
        this.indMrLetter = indMrLetter;
    }
    public Collection<Event> getEventsForIdStage() {
        return this.eventsForIdStage;
    }
    
    public void setEventsForIdStage(Collection<Event> eventsForIdStage) {
        this.eventsForIdStage = eventsForIdStage;
    }




}

