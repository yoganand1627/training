package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * CIntake generated by hbm2java
 */
public class CIntake  implements java.io.Serializable {


     private String intakeid;
     private Date dtLastUpdate;
     private Facility facility;
     private String facid;
     private String facname;
     private String factype;
     private String cmptype;
     private String refnum;
     private String hfdid;
     private String jcaho;
     private Date rophon;
     private String status;
     private String cmplname;
     private String cmplstate;
     private String anonym;
     private String cmpladdr;
     private String cmplexta;
     private String city;
     private String zip;
     private String phoneday;
     private String phoneeve;
     private Date recvdate;
     private String recvtime;
     private String cmpmode;
     private String cmpsrc;
     private String cmpsrc2;
     private String cmpsrc3;
     private String cmpsrc4;
     private Date regOff;
     private Date assndate;
     private Date invtdate;
     private String cmppri;
     private Date reptdt;
     private String overfind;
     private Date ackDate;
     private Date droforwd;
     private Date dtotype;
     private String jcinvest;
     private String relationship;
     private String releasable;
     private String deficiencies;
     private String investid;
     private String origin;
     private Date duedate;
     private String foassign;
     private String stactions;
     private Date closed;
     private String closreason;
     private String increcvtime;
     private Date increcvdate;
     private Date exitDate;
     private Date sortdate;
     private Integer isfollowup;
     private String cmpntid;
     private Date updatedt;
     private String employeeid;
     private String cis;
     private String statecompid;
     private String phoneext;
     private String phoneeveext;
     private String isemtala;
     private Date roappdate;
     private String emergtype1;
     private String emergtype2;
     private String emergtype3;
     private String emergtype4;
     private String emergtype5;
     private String emergtype6;
     private String emergtype7;
     private String resolution;
     private String sanotepad;
     private String notepad;
     private String isResSecl;
     private String staffnm;
     private String rosauser;
     private Date roReceipt;
     private Date finalAction;
     private Integer pastnoncomp;
     private String extCtrlNum;
     private String forwarded;
     private Integer iscmpsent;
     private Integer reqroappr;
     private Date adddate;
     private Integer reqroEmtala;
     private String cmptypeext;
     private Integer numdaystoinv;
     private String emtalaresponse;
     private String priority;
     private Date recvstart;
     private String recvtimestart;
     private Date emtalarespdt;
     private String incshift;
     private String incampm;
     private Integer deemed;
     private Integer recvendopen;
     private String deemresponse;
     private Date deemrespdt;
     private Date deemreqdt;
     private String invnotes;
     private Integer isdelete;
     private Integer issentCsp;
     private Date uploadAddDtCsp;
     private Date uploadUpdtDtCsp;
     private Integer uploadaccepted;
     private Integer reqroStdF;
     private Date stdFReqdt;
     private String stdFResponse;
     private Date stdFRespdt;
     private String l10;
     private String conotepad;
     private String cberId;
     private String isreferao;
     private Date forwardcodt;
     private String forwardco;
     private String labcert;
     private String labclass;
     private String labroapptype;
     private Collection<CompAlg> compAlgs;
     private Collection<CIntakeResp> cIntakeResps;

    public CIntake() {
    }

	
    public CIntake(String intakeid) {
        this.intakeid = intakeid;
    }
    public CIntake(String intakeid, Facility facility, String facid, String facname, String factype, String cmptype, String refnum, String hfdid, String jcaho, Date rophon, String status, String cmplname, String cmplstate, String anonym, String cmpladdr, String cmplexta, String city, String zip, String phoneday, String phoneeve, Date recvdate, String recvtime, String cmpmode, String cmpsrc, String cmpsrc2, String cmpsrc3, String cmpsrc4, Date regOff, Date assndate, Date invtdate, String cmppri, Date reptdt, String overfind, Date ackDate, Date droforwd, Date dtotype, String jcinvest, String relationship, String releasable, String deficiencies, String investid, String origin, Date duedate, String foassign, String stactions, Date closed, String closreason, String increcvtime, Date increcvdate, Date exitDate, Date sortdate, Integer isfollowup, String cmpntid, Date updatedt, String employeeid, String cis, String statecompid, String phoneext, String phoneeveext, String isemtala, Date roappdate, String emergtype1, String emergtype2, String emergtype3, String emergtype4, String emergtype5, String emergtype6, String emergtype7, String resolution, String sanotepad, String notepad, String isResSecl, String staffnm, String rosauser, Date roReceipt, Date finalAction, Integer pastnoncomp, String extCtrlNum, String forwarded, Integer iscmpsent, Integer reqroappr, Date adddate, Integer reqroEmtala, String cmptypeext, Integer numdaystoinv, String emtalaresponse, String priority, Date recvstart, String recvtimestart, Date emtalarespdt, String incshift, String incampm, Integer deemed, Integer recvendopen, String deemresponse, Date deemrespdt, Date deemreqdt, String invnotes, Integer isdelete, Integer issentCsp, Date uploadAddDtCsp, Date uploadUpdtDtCsp, Integer uploadaccepted, Integer reqroStdF, Date stdFReqdt, String stdFResponse, Date stdFRespdt, String l10, String conotepad, String cberId, String isreferao, Date forwardcodt, String forwardco, String labcert, String labclass, String labroapptype, Collection<CompAlg> compAlgs, Collection<CIntakeResp> cIntakeResps) {
       this.intakeid = intakeid;
       this.facility = facility;
       this.facid = facid;
       this.facname = facname;
       this.factype = factype;
       this.cmptype = cmptype;
       this.refnum = refnum;
       this.hfdid = hfdid;
       this.jcaho = jcaho;
       this.rophon = rophon;
       this.status = status;
       this.cmplname = cmplname;
       this.cmplstate = cmplstate;
       this.anonym = anonym;
       this.cmpladdr = cmpladdr;
       this.cmplexta = cmplexta;
       this.city = city;
       this.zip = zip;
       this.phoneday = phoneday;
       this.phoneeve = phoneeve;
       this.recvdate = recvdate;
       this.recvtime = recvtime;
       this.cmpmode = cmpmode;
       this.cmpsrc = cmpsrc;
       this.cmpsrc2 = cmpsrc2;
       this.cmpsrc3 = cmpsrc3;
       this.cmpsrc4 = cmpsrc4;
       this.regOff = regOff;
       this.assndate = assndate;
       this.invtdate = invtdate;
       this.cmppri = cmppri;
       this.reptdt = reptdt;
       this.overfind = overfind;
       this.ackDate = ackDate;
       this.droforwd = droforwd;
       this.dtotype = dtotype;
       this.jcinvest = jcinvest;
       this.relationship = relationship;
       this.releasable = releasable;
       this.deficiencies = deficiencies;
       this.investid = investid;
       this.origin = origin;
       this.duedate = duedate;
       this.foassign = foassign;
       this.stactions = stactions;
       this.closed = closed;
       this.closreason = closreason;
       this.increcvtime = increcvtime;
       this.increcvdate = increcvdate;
       this.exitDate = exitDate;
       this.sortdate = sortdate;
       this.isfollowup = isfollowup;
       this.cmpntid = cmpntid;
       this.updatedt = updatedt;
       this.employeeid = employeeid;
       this.cis = cis;
       this.statecompid = statecompid;
       this.phoneext = phoneext;
       this.phoneeveext = phoneeveext;
       this.isemtala = isemtala;
       this.roappdate = roappdate;
       this.emergtype1 = emergtype1;
       this.emergtype2 = emergtype2;
       this.emergtype3 = emergtype3;
       this.emergtype4 = emergtype4;
       this.emergtype5 = emergtype5;
       this.emergtype6 = emergtype6;
       this.emergtype7 = emergtype7;
       this.resolution = resolution;
       this.sanotepad = sanotepad;
       this.notepad = notepad;
       this.isResSecl = isResSecl;
       this.staffnm = staffnm;
       this.rosauser = rosauser;
       this.roReceipt = roReceipt;
       this.finalAction = finalAction;
       this.pastnoncomp = pastnoncomp;
       this.extCtrlNum = extCtrlNum;
       this.forwarded = forwarded;
       this.iscmpsent = iscmpsent;
       this.reqroappr = reqroappr;
       this.adddate = adddate;
       this.reqroEmtala = reqroEmtala;
       this.cmptypeext = cmptypeext;
       this.numdaystoinv = numdaystoinv;
       this.emtalaresponse = emtalaresponse;
       this.priority = priority;
       this.recvstart = recvstart;
       this.recvtimestart = recvtimestart;
       this.emtalarespdt = emtalarespdt;
       this.incshift = incshift;
       this.incampm = incampm;
       this.deemed = deemed;
       this.recvendopen = recvendopen;
       this.deemresponse = deemresponse;
       this.deemrespdt = deemrespdt;
       this.deemreqdt = deemreqdt;
       this.invnotes = invnotes;
       this.isdelete = isdelete;
       this.issentCsp = issentCsp;
       this.uploadAddDtCsp = uploadAddDtCsp;
       this.uploadUpdtDtCsp = uploadUpdtDtCsp;
       this.uploadaccepted = uploadaccepted;
       this.reqroStdF = reqroStdF;
       this.stdFReqdt = stdFReqdt;
       this.stdFResponse = stdFResponse;
       this.stdFRespdt = stdFRespdt;
       this.l10 = l10;
       this.conotepad = conotepad;
       this.cberId = cberId;
       this.isreferao = isreferao;
       this.forwardcodt = forwardcodt;
       this.forwardco = forwardco;
       this.labcert = labcert;
       this.labclass = labclass;
       this.labroapptype = labroapptype;
       this.compAlgs = compAlgs;
       this.cIntakeResps = cIntakeResps;
    }
   
    public String getIntakeid() {
        return this.intakeid;
    }
    
    public void setIntakeid(String intakeid) {
        this.intakeid = intakeid;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Facility getFacility() {
        return this.facility;
    }
    
    public void setFacility(Facility facility) {
        this.facility = facility;
    }
    public String getFacid() {
        return this.facid;
    }
    
    public void setFacid(String facid) {
        this.facid = facid;
    }
    public String getFacname() {
        return this.facname;
    }
    
    public void setFacname(String facname) {
        this.facname = facname;
    }
    public String getFactype() {
        return this.factype;
    }
    
    public void setFactype(String factype) {
        this.factype = factype;
    }
    public String getCmptype() {
        return this.cmptype;
    }
    
    public void setCmptype(String cmptype) {
        this.cmptype = cmptype;
    }
    public String getRefnum() {
        return this.refnum;
    }
    
    public void setRefnum(String refnum) {
        this.refnum = refnum;
    }
    public String getHfdid() {
        return this.hfdid;
    }
    
    public void setHfdid(String hfdid) {
        this.hfdid = hfdid;
    }
    public String getJcaho() {
        return this.jcaho;
    }
    
    public void setJcaho(String jcaho) {
        this.jcaho = jcaho;
    }
    public Date getRophon() {
        return this.rophon;
    }
    
    public void setRophon(Date rophon) {
        this.rophon = rophon;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCmplname() {
        return this.cmplname;
    }
    
    public void setCmplname(String cmplname) {
        this.cmplname = cmplname;
    }
    public String getCmplstate() {
        return this.cmplstate;
    }
    
    public void setCmplstate(String cmplstate) {
        this.cmplstate = cmplstate;
    }
    public String getAnonym() {
        return this.anonym;
    }
    
    public void setAnonym(String anonym) {
        this.anonym = anonym;
    }
    public String getCmpladdr() {
        return this.cmpladdr;
    }
    
    public void setCmpladdr(String cmpladdr) {
        this.cmpladdr = cmpladdr;
    }
    public String getCmplexta() {
        return this.cmplexta;
    }
    
    public void setCmplexta(String cmplexta) {
        this.cmplexta = cmplexta;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getZip() {
        return this.zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getPhoneday() {
        return this.phoneday;
    }
    
    public void setPhoneday(String phoneday) {
        this.phoneday = phoneday;
    }
    public String getPhoneeve() {
        return this.phoneeve;
    }
    
    public void setPhoneeve(String phoneeve) {
        this.phoneeve = phoneeve;
    }
    public Date getRecvdate() {
        return this.recvdate;
    }
    
    public void setRecvdate(Date recvdate) {
        this.recvdate = recvdate;
    }
    public String getRecvtime() {
        return this.recvtime;
    }
    
    public void setRecvtime(String recvtime) {
        this.recvtime = recvtime;
    }
    public String getCmpmode() {
        return this.cmpmode;
    }
    
    public void setCmpmode(String cmpmode) {
        this.cmpmode = cmpmode;
    }
    public String getCmpsrc() {
        return this.cmpsrc;
    }
    
    public void setCmpsrc(String cmpsrc) {
        this.cmpsrc = cmpsrc;
    }
    public String getCmpsrc2() {
        return this.cmpsrc2;
    }
    
    public void setCmpsrc2(String cmpsrc2) {
        this.cmpsrc2 = cmpsrc2;
    }
    public String getCmpsrc3() {
        return this.cmpsrc3;
    }
    
    public void setCmpsrc3(String cmpsrc3) {
        this.cmpsrc3 = cmpsrc3;
    }
    public String getCmpsrc4() {
        return this.cmpsrc4;
    }
    
    public void setCmpsrc4(String cmpsrc4) {
        this.cmpsrc4 = cmpsrc4;
    }
    public Date getRegOff() {
        return this.regOff;
    }
    
    public void setRegOff(Date regOff) {
        this.regOff = regOff;
    }
    public Date getAssndate() {
        return this.assndate;
    }
    
    public void setAssndate(Date assndate) {
        this.assndate = assndate;
    }
    public Date getInvtdate() {
        return this.invtdate;
    }
    
    public void setInvtdate(Date invtdate) {
        this.invtdate = invtdate;
    }
    public String getCmppri() {
        return this.cmppri;
    }
    
    public void setCmppri(String cmppri) {
        this.cmppri = cmppri;
    }
    public Date getReptdt() {
        return this.reptdt;
    }
    
    public void setReptdt(Date reptdt) {
        this.reptdt = reptdt;
    }
    public String getOverfind() {
        return this.overfind;
    }
    
    public void setOverfind(String overfind) {
        this.overfind = overfind;
    }
    public Date getAckDate() {
        return this.ackDate;
    }
    
    public void setAckDate(Date ackDate) {
        this.ackDate = ackDate;
    }
    public Date getDroforwd() {
        return this.droforwd;
    }
    
    public void setDroforwd(Date droforwd) {
        this.droforwd = droforwd;
    }
    public Date getDtotype() {
        return this.dtotype;
    }
    
    public void setDtotype(Date dtotype) {
        this.dtotype = dtotype;
    }
    public String getJcinvest() {
        return this.jcinvest;
    }
    
    public void setJcinvest(String jcinvest) {
        this.jcinvest = jcinvest;
    }
    public String getRelationship() {
        return this.relationship;
    }
    
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
    public String getReleasable() {
        return this.releasable;
    }
    
    public void setReleasable(String releasable) {
        this.releasable = releasable;
    }
    public String getDeficiencies() {
        return this.deficiencies;
    }
    
    public void setDeficiencies(String deficiencies) {
        this.deficiencies = deficiencies;
    }
    public String getInvestid() {
        return this.investid;
    }
    
    public void setInvestid(String investid) {
        this.investid = investid;
    }
    public String getOrigin() {
        return this.origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public Date getDuedate() {
        return this.duedate;
    }
    
    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }
    public String getFoassign() {
        return this.foassign;
    }
    
    public void setFoassign(String foassign) {
        this.foassign = foassign;
    }
    public String getStactions() {
        return this.stactions;
    }
    
    public void setStactions(String stactions) {
        this.stactions = stactions;
    }
    public Date getClosed() {
        return this.closed;
    }
    
    public void setClosed(Date closed) {
        this.closed = closed;
    }
    public String getClosreason() {
        return this.closreason;
    }
    
    public void setClosreason(String closreason) {
        this.closreason = closreason;
    }
    public String getIncrecvtime() {
        return this.increcvtime;
    }
    
    public void setIncrecvtime(String increcvtime) {
        this.increcvtime = increcvtime;
    }
    public Date getIncrecvdate() {
        return this.increcvdate;
    }
    
    public void setIncrecvdate(Date increcvdate) {
        this.increcvdate = increcvdate;
    }
    public Date getExitDate() {
        return this.exitDate;
    }
    
    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }
    public Date getSortdate() {
        return this.sortdate;
    }
    
    public void setSortdate(Date sortdate) {
        this.sortdate = sortdate;
    }
    public Integer getIsfollowup() {
        return this.isfollowup;
    }
    
    public void setIsfollowup(Integer isfollowup) {
        this.isfollowup = isfollowup;
    }
    public String getCmpntid() {
        return this.cmpntid;
    }
    
    public void setCmpntid(String cmpntid) {
        this.cmpntid = cmpntid;
    }
    public Date getUpdatedt() {
        return this.updatedt;
    }
    
    public void setUpdatedt(Date updatedt) {
        this.updatedt = updatedt;
    }
    public String getEmployeeid() {
        return this.employeeid;
    }
    
    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }
    public String getCis() {
        return this.cis;
    }
    
    public void setCis(String cis) {
        this.cis = cis;
    }
    public String getStatecompid() {
        return this.statecompid;
    }
    
    public void setStatecompid(String statecompid) {
        this.statecompid = statecompid;
    }
    public String getPhoneext() {
        return this.phoneext;
    }
    
    public void setPhoneext(String phoneext) {
        this.phoneext = phoneext;
    }
    public String getPhoneeveext() {
        return this.phoneeveext;
    }
    
    public void setPhoneeveext(String phoneeveext) {
        this.phoneeveext = phoneeveext;
    }
    public String getIsemtala() {
        return this.isemtala;
    }
    
    public void setIsemtala(String isemtala) {
        this.isemtala = isemtala;
    }
    public Date getRoappdate() {
        return this.roappdate;
    }
    
    public void setRoappdate(Date roappdate) {
        this.roappdate = roappdate;
    }
    public String getEmergtype1() {
        return this.emergtype1;
    }
    
    public void setEmergtype1(String emergtype1) {
        this.emergtype1 = emergtype1;
    }
    public String getEmergtype2() {
        return this.emergtype2;
    }
    
    public void setEmergtype2(String emergtype2) {
        this.emergtype2 = emergtype2;
    }
    public String getEmergtype3() {
        return this.emergtype3;
    }
    
    public void setEmergtype3(String emergtype3) {
        this.emergtype3 = emergtype3;
    }
    public String getEmergtype4() {
        return this.emergtype4;
    }
    
    public void setEmergtype4(String emergtype4) {
        this.emergtype4 = emergtype4;
    }
    public String getEmergtype5() {
        return this.emergtype5;
    }
    
    public void setEmergtype5(String emergtype5) {
        this.emergtype5 = emergtype5;
    }
    public String getEmergtype6() {
        return this.emergtype6;
    }
    
    public void setEmergtype6(String emergtype6) {
        this.emergtype6 = emergtype6;
    }
    public String getEmergtype7() {
        return this.emergtype7;
    }
    
    public void setEmergtype7(String emergtype7) {
        this.emergtype7 = emergtype7;
    }
    public String getResolution() {
        return this.resolution;
    }
    
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    public String getSanotepad() {
        return this.sanotepad;
    }
    
    public void setSanotepad(String sanotepad) {
        this.sanotepad = sanotepad;
    }
    public String getNotepad() {
        return this.notepad;
    }
    
    public void setNotepad(String notepad) {
        this.notepad = notepad;
    }
    public String getIsResSecl() {
        return this.isResSecl;
    }
    
    public void setIsResSecl(String isResSecl) {
        this.isResSecl = isResSecl;
    }
    public String getStaffnm() {
        return this.staffnm;
    }
    
    public void setStaffnm(String staffnm) {
        this.staffnm = staffnm;
    }
    public String getRosauser() {
        return this.rosauser;
    }
    
    public void setRosauser(String rosauser) {
        this.rosauser = rosauser;
    }
    public Date getRoReceipt() {
        return this.roReceipt;
    }
    
    public void setRoReceipt(Date roReceipt) {
        this.roReceipt = roReceipt;
    }
    public Date getFinalAction() {
        return this.finalAction;
    }
    
    public void setFinalAction(Date finalAction) {
        this.finalAction = finalAction;
    }
    public Integer getPastnoncomp() {
        return this.pastnoncomp;
    }
    
    public void setPastnoncomp(Integer pastnoncomp) {
        this.pastnoncomp = pastnoncomp;
    }
    public String getExtCtrlNum() {
        return this.extCtrlNum;
    }
    
    public void setExtCtrlNum(String extCtrlNum) {
        this.extCtrlNum = extCtrlNum;
    }
    public String getForwarded() {
        return this.forwarded;
    }
    
    public void setForwarded(String forwarded) {
        this.forwarded = forwarded;
    }
    public Integer getIscmpsent() {
        return this.iscmpsent;
    }
    
    public void setIscmpsent(Integer iscmpsent) {
        this.iscmpsent = iscmpsent;
    }
    public Integer getReqroappr() {
        return this.reqroappr;
    }
    
    public void setReqroappr(Integer reqroappr) {
        this.reqroappr = reqroappr;
    }
    public Date getAdddate() {
        return this.adddate;
    }
    
    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }
    public Integer getReqroEmtala() {
        return this.reqroEmtala;
    }
    
    public void setReqroEmtala(Integer reqroEmtala) {
        this.reqroEmtala = reqroEmtala;
    }
    public String getCmptypeext() {
        return this.cmptypeext;
    }
    
    public void setCmptypeext(String cmptypeext) {
        this.cmptypeext = cmptypeext;
    }
    public Integer getNumdaystoinv() {
        return this.numdaystoinv;
    }
    
    public void setNumdaystoinv(Integer numdaystoinv) {
        this.numdaystoinv = numdaystoinv;
    }
    public String getEmtalaresponse() {
        return this.emtalaresponse;
    }
    
    public void setEmtalaresponse(String emtalaresponse) {
        this.emtalaresponse = emtalaresponse;
    }
    public String getPriority() {
        return this.priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public Date getRecvstart() {
        return this.recvstart;
    }
    
    public void setRecvstart(Date recvstart) {
        this.recvstart = recvstart;
    }
    public String getRecvtimestart() {
        return this.recvtimestart;
    }
    
    public void setRecvtimestart(String recvtimestart) {
        this.recvtimestart = recvtimestart;
    }
    public Date getEmtalarespdt() {
        return this.emtalarespdt;
    }
    
    public void setEmtalarespdt(Date emtalarespdt) {
        this.emtalarespdt = emtalarespdt;
    }
    public String getIncshift() {
        return this.incshift;
    }
    
    public void setIncshift(String incshift) {
        this.incshift = incshift;
    }
    public String getIncampm() {
        return this.incampm;
    }
    
    public void setIncampm(String incampm) {
        this.incampm = incampm;
    }
    public Integer getDeemed() {
        return this.deemed;
    }
    
    public void setDeemed(Integer deemed) {
        this.deemed = deemed;
    }
    public Integer getRecvendopen() {
        return this.recvendopen;
    }
    
    public void setRecvendopen(Integer recvendopen) {
        this.recvendopen = recvendopen;
    }
    public String getDeemresponse() {
        return this.deemresponse;
    }
    
    public void setDeemresponse(String deemresponse) {
        this.deemresponse = deemresponse;
    }
    public Date getDeemrespdt() {
        return this.deemrespdt;
    }
    
    public void setDeemrespdt(Date deemrespdt) {
        this.deemrespdt = deemrespdt;
    }
    public Date getDeemreqdt() {
        return this.deemreqdt;
    }
    
    public void setDeemreqdt(Date deemreqdt) {
        this.deemreqdt = deemreqdt;
    }
    public String getInvnotes() {
        return this.invnotes;
    }
    
    public void setInvnotes(String invnotes) {
        this.invnotes = invnotes;
    }
    public Integer getIsdelete() {
        return this.isdelete;
    }
    
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
    public Integer getIssentCsp() {
        return this.issentCsp;
    }
    
    public void setIssentCsp(Integer issentCsp) {
        this.issentCsp = issentCsp;
    }
    public Date getUploadAddDtCsp() {
        return this.uploadAddDtCsp;
    }
    
    public void setUploadAddDtCsp(Date uploadAddDtCsp) {
        this.uploadAddDtCsp = uploadAddDtCsp;
    }
    public Date getUploadUpdtDtCsp() {
        return this.uploadUpdtDtCsp;
    }
    
    public void setUploadUpdtDtCsp(Date uploadUpdtDtCsp) {
        this.uploadUpdtDtCsp = uploadUpdtDtCsp;
    }
    public Integer getUploadaccepted() {
        return this.uploadaccepted;
    }
    
    public void setUploadaccepted(Integer uploadaccepted) {
        this.uploadaccepted = uploadaccepted;
    }
    public Integer getReqroStdF() {
        return this.reqroStdF;
    }
    
    public void setReqroStdF(Integer reqroStdF) {
        this.reqroStdF = reqroStdF;
    }
    public Date getStdFReqdt() {
        return this.stdFReqdt;
    }
    
    public void setStdFReqdt(Date stdFReqdt) {
        this.stdFReqdt = stdFReqdt;
    }
    public String getStdFResponse() {
        return this.stdFResponse;
    }
    
    public void setStdFResponse(String stdFResponse) {
        this.stdFResponse = stdFResponse;
    }
    public Date getStdFRespdt() {
        return this.stdFRespdt;
    }
    
    public void setStdFRespdt(Date stdFRespdt) {
        this.stdFRespdt = stdFRespdt;
    }
    public String getL10() {
        return this.l10;
    }
    
    public void setL10(String l10) {
        this.l10 = l10;
    }
    public String getConotepad() {
        return this.conotepad;
    }
    
    public void setConotepad(String conotepad) {
        this.conotepad = conotepad;
    }
    public String getCberId() {
        return this.cberId;
    }
    
    public void setCberId(String cberId) {
        this.cberId = cberId;
    }
    public String getIsreferao() {
        return this.isreferao;
    }
    
    public void setIsreferao(String isreferao) {
        this.isreferao = isreferao;
    }
    public Date getForwardcodt() {
        return this.forwardcodt;
    }
    
    public void setForwardcodt(Date forwardcodt) {
        this.forwardcodt = forwardcodt;
    }
    public String getForwardco() {
        return this.forwardco;
    }
    
    public void setForwardco(String forwardco) {
        this.forwardco = forwardco;
    }
    public String getLabcert() {
        return this.labcert;
    }
    
    public void setLabcert(String labcert) {
        this.labcert = labcert;
    }
    public String getLabclass() {
        return this.labclass;
    }
    
    public void setLabclass(String labclass) {
        this.labclass = labclass;
    }
    public String getLabroapptype() {
        return this.labroapptype;
    }
    
    public void setLabroapptype(String labroapptype) {
        this.labroapptype = labroapptype;
    }
    public Collection<CompAlg> getCompAlgs() {
        return this.compAlgs;
    }
    
    public void setCompAlgs(Collection<CompAlg> compAlgs) {
        this.compAlgs = compAlgs;
    }
    public Collection<CIntakeResp> getcIntakeResps() {
        return this.cIntakeResps;
    }
    
    public void setcIntakeResps(Collection<CIntakeResp> cIntakeResps) {
        this.cIntakeResps = cIntakeResps;
    }




}

