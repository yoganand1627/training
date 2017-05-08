package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * Ncands generated by hbm2java
 */
public class Ncands  implements java.io.Serializable {


     private NcandsId id;
     private Date dtLastUpdate;
     private String staterr;
     private String rptid;
     private String chid;
     private String rptcnty;
     private String rptdt;
     private String invstdt;
     private String rptsrc;
     private String rptdisp;
     private String rptdisdt;
     private String notifs;
     private String chage;
     private String childBdate;
     private String childSex;
     private String childRaceAmerind;
     private String childRaceAsian;
     private String childRaceBlack;
     private String childRaceHawaiiPac;
     private String childRaceWhite;
     private String childRaceUnable;
     private String childIsp;
     private String childCnty;
     private String childLvng;
     private String childMil;
     private String childPrior;
     private String childMal1;
     private String childMaldisp1;
     private String childMal2;
     private String childMaldisp2;
     private String childMal3;
     private String childMaldisp3;
     private String childMal4;
     private String childMaldisp4;
     private String childMalDeath;
     private String cdalc;
     private String cddrug;
     private String cdrtrd;
     private String cdemotnl;
     private String cdvisual;
     private String cdlearn;
     private String cdphys;
     private String cdbehav;
     private String cdmedicl;
     private String fcalc;
     private String fcdrug;
     private String fcrtrd;
     private String fcemotnl;
     private String fcvisual;
     private String fclearn;
     private String fcphys;
     private String fcmedicl;
     private String fcviol;
     private String fchouse;
     private String fcmoney;
     private String fcpublic;
     private String postserv;
     private String servdate;
     private String famsup;
     private String fampres;
     private String fostercr;
     private String rmvdate;
     private String juvpet;
     private String petdate;
     private String cochrep;
     private String adopt;
     private String casemanag;
     private String counsel;
     private String daycare;
     private String educatn;
     private String employ;
     private String famplan;
     private String health;
     private String homebase;
     private String housing;
     private String transliv;
     private String inforef;
     private String legal;
     private String menthlth;
     private String pregpar;
     private String respite;
     private String ssdisabl;
     private String ssdelinq;
     private String subabuse;
     private String transprt;
     private String othersv;
     private String wrkrid;
     private String suprvid;
     private String perId1;
     private String perRel1;
     private String perPrnt1;
     private String perCr1;
     private String perAge1;
     private String perSex1;
     private String perRaceIndian1;
     private String perRaceAsian1;
     private String perRaceBlack1;
     private String perRaceHawaiiPac1;
     private String perRaceWhite1;
     private String perRaceUnable1;
     private String perHisp1;
     private String perMil1;
     private String perPrior1;
     private String perMal11;
     private String perMal21;
     private String perMal31;
     private String perMal41;
     private String perId2;
     private String perRel2;
     private String perPrnt2;
     private String perCr2;
     private String perAge2;
     private String perSex2;
     private String perRaceIndian2;
     private String perRaceAsian2;
     private String perRaceBlack2;
     private String perRaceHawaiiPac2;
     private String perRaceWhite2;
     private String perRaceUnable2;
     private String perHisp2;
     private String perMil2;
     private String perPrior2;
     private String perMal12;
     private String perMal22;
     private String perMal32;
     private String perMal42;
     private String perId3;
     private String perRel3;
     private String perPrnt3;
     private String perCr3;
     private String perAge3;
     private String perSex3;
     private String perRaceIndian3;
     private String perRaceAsian3;
     private String perRaceBlack3;
     private String perRaceHawaiiPac3;
     private String perRaceWhite3;
     private String perRaceUnable3;
     private String perHisp3;
     private String perMil3;
     private String perPrior3;
     private String perMal13;
     private String perMal23;
     private String perMal33;
     private String perMal43;
     private String afcarsId;
     private String incidentDate;
     private String caseManager;
     private String supervisor;

    public Ncands() {
    }

	
    public Ncands(NcandsId id) {
        this.id = id;
    }
    public Ncands(NcandsId id, String staterr, String rptid, String chid, String rptcnty, String rptdt, String invstdt, String rptsrc, String rptdisp, String rptdisdt, String notifs, String chage, String childBdate, String childSex, String childRaceAmerind, String childRaceAsian, String childRaceBlack, String childRaceHawaiiPac, String childRaceWhite, String childRaceUnable, String childIsp, String childCnty, String childLvng, String childMil, String childPrior, String childMal1, String childMaldisp1, String childMal2, String childMaldisp2, String childMal3, String childMaldisp3, String childMal4, String childMaldisp4, String childMalDeath, String cdalc, String cddrug, String cdrtrd, String cdemotnl, String cdvisual, String cdlearn, String cdphys, String cdbehav, String cdmedicl, String fcalc, String fcdrug, String fcrtrd, String fcemotnl, String fcvisual, String fclearn, String fcphys, String fcmedicl, String fcviol, String fchouse, String fcmoney, String fcpublic, String postserv, String servdate, String famsup, String fampres, String fostercr, String rmvdate, String juvpet, String petdate, String cochrep, String adopt, String casemanag, String counsel, String daycare, String educatn, String employ, String famplan, String health, String homebase, String housing, String transliv, String inforef, String legal, String menthlth, String pregpar, String respite, String ssdisabl, String ssdelinq, String subabuse, String transprt, String othersv, String wrkrid, String suprvid, String perId1, String perRel1, String perPrnt1, String perCr1, String perAge1, String perSex1, String perRaceIndian1, String perRaceAsian1, String perRaceBlack1, String perRaceHawaiiPac1, String perRaceWhite1, String perRaceUnable1, String perHisp1, String perMil1, String perPrior1, String perMal11, String perMal21, String perMal31, String perMal41, String perId2, String perRel2, String perPrnt2, String perCr2, String perAge2, String perSex2, String perRaceIndian2, String perRaceAsian2, String perRaceBlack2, String perRaceHawaiiPac2, String perRaceWhite2, String perRaceUnable2, String perHisp2, String perMil2, String perPrior2, String perMal12, String perMal22, String perMal32, String perMal42, String perId3, String perRel3, String perPrnt3, String perCr3, String perAge3, String perSex3, String perRaceIndian3, String perRaceAsian3, String perRaceBlack3, String perRaceHawaiiPac3, String perRaceWhite3, String perRaceUnable3, String perHisp3, String perMil3, String perPrior3, String perMal13, String perMal23, String perMal33, String perMal43, String afcarsId, String incidentDate, String caseManager, String supervisor) {
       this.id = id;
       this.staterr = staterr;
       this.rptid = rptid;
       this.chid = chid;
       this.rptcnty = rptcnty;
       this.rptdt = rptdt;
       this.invstdt = invstdt;
       this.rptsrc = rptsrc;
       this.rptdisp = rptdisp;
       this.rptdisdt = rptdisdt;
       this.notifs = notifs;
       this.chage = chage;
       this.childBdate = childBdate;
       this.childSex = childSex;
       this.childRaceAmerind = childRaceAmerind;
       this.childRaceAsian = childRaceAsian;
       this.childRaceBlack = childRaceBlack;
       this.childRaceHawaiiPac = childRaceHawaiiPac;
       this.childRaceWhite = childRaceWhite;
       this.childRaceUnable = childRaceUnable;
       this.childIsp = childIsp;
       this.childCnty = childCnty;
       this.childLvng = childLvng;
       this.childMil = childMil;
       this.childPrior = childPrior;
       this.childMal1 = childMal1;
       this.childMaldisp1 = childMaldisp1;
       this.childMal2 = childMal2;
       this.childMaldisp2 = childMaldisp2;
       this.childMal3 = childMal3;
       this.childMaldisp3 = childMaldisp3;
       this.childMal4 = childMal4;
       this.childMaldisp4 = childMaldisp4;
       this.childMalDeath = childMalDeath;
       this.cdalc = cdalc;
       this.cddrug = cddrug;
       this.cdrtrd = cdrtrd;
       this.cdemotnl = cdemotnl;
       this.cdvisual = cdvisual;
       this.cdlearn = cdlearn;
       this.cdphys = cdphys;
       this.cdbehav = cdbehav;
       this.cdmedicl = cdmedicl;
       this.fcalc = fcalc;
       this.fcdrug = fcdrug;
       this.fcrtrd = fcrtrd;
       this.fcemotnl = fcemotnl;
       this.fcvisual = fcvisual;
       this.fclearn = fclearn;
       this.fcphys = fcphys;
       this.fcmedicl = fcmedicl;
       this.fcviol = fcviol;
       this.fchouse = fchouse;
       this.fcmoney = fcmoney;
       this.fcpublic = fcpublic;
       this.postserv = postserv;
       this.servdate = servdate;
       this.famsup = famsup;
       this.fampres = fampres;
       this.fostercr = fostercr;
       this.rmvdate = rmvdate;
       this.juvpet = juvpet;
       this.petdate = petdate;
       this.cochrep = cochrep;
       this.adopt = adopt;
       this.casemanag = casemanag;
       this.counsel = counsel;
       this.daycare = daycare;
       this.educatn = educatn;
       this.employ = employ;
       this.famplan = famplan;
       this.health = health;
       this.homebase = homebase;
       this.housing = housing;
       this.transliv = transliv;
       this.inforef = inforef;
       this.legal = legal;
       this.menthlth = menthlth;
       this.pregpar = pregpar;
       this.respite = respite;
       this.ssdisabl = ssdisabl;
       this.ssdelinq = ssdelinq;
       this.subabuse = subabuse;
       this.transprt = transprt;
       this.othersv = othersv;
       this.wrkrid = wrkrid;
       this.suprvid = suprvid;
       this.perId1 = perId1;
       this.perRel1 = perRel1;
       this.perPrnt1 = perPrnt1;
       this.perCr1 = perCr1;
       this.perAge1 = perAge1;
       this.perSex1 = perSex1;
       this.perRaceIndian1 = perRaceIndian1;
       this.perRaceAsian1 = perRaceAsian1;
       this.perRaceBlack1 = perRaceBlack1;
       this.perRaceHawaiiPac1 = perRaceHawaiiPac1;
       this.perRaceWhite1 = perRaceWhite1;
       this.perRaceUnable1 = perRaceUnable1;
       this.perHisp1 = perHisp1;
       this.perMil1 = perMil1;
       this.perPrior1 = perPrior1;
       this.perMal11 = perMal11;
       this.perMal21 = perMal21;
       this.perMal31 = perMal31;
       this.perMal41 = perMal41;
       this.perId2 = perId2;
       this.perRel2 = perRel2;
       this.perPrnt2 = perPrnt2;
       this.perCr2 = perCr2;
       this.perAge2 = perAge2;
       this.perSex2 = perSex2;
       this.perRaceIndian2 = perRaceIndian2;
       this.perRaceAsian2 = perRaceAsian2;
       this.perRaceBlack2 = perRaceBlack2;
       this.perRaceHawaiiPac2 = perRaceHawaiiPac2;
       this.perRaceWhite2 = perRaceWhite2;
       this.perRaceUnable2 = perRaceUnable2;
       this.perHisp2 = perHisp2;
       this.perMil2 = perMil2;
       this.perPrior2 = perPrior2;
       this.perMal12 = perMal12;
       this.perMal22 = perMal22;
       this.perMal32 = perMal32;
       this.perMal42 = perMal42;
       this.perId3 = perId3;
       this.perRel3 = perRel3;
       this.perPrnt3 = perPrnt3;
       this.perCr3 = perCr3;
       this.perAge3 = perAge3;
       this.perSex3 = perSex3;
       this.perRaceIndian3 = perRaceIndian3;
       this.perRaceAsian3 = perRaceAsian3;
       this.perRaceBlack3 = perRaceBlack3;
       this.perRaceHawaiiPac3 = perRaceHawaiiPac3;
       this.perRaceWhite3 = perRaceWhite3;
       this.perRaceUnable3 = perRaceUnable3;
       this.perHisp3 = perHisp3;
       this.perMil3 = perMil3;
       this.perPrior3 = perPrior3;
       this.perMal13 = perMal13;
       this.perMal23 = perMal23;
       this.perMal33 = perMal33;
       this.perMal43 = perMal43;
       this.afcarsId = afcarsId;
       this.incidentDate = incidentDate;
       this.caseManager = caseManager;
       this.supervisor = supervisor;
    }
   
    public NcandsId getId() {
        return this.id;
    }
    
    public void setId(NcandsId id) {
        this.id = id;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public String getStaterr() {
        return this.staterr;
    }
    
    public void setStaterr(String staterr) {
        this.staterr = staterr;
    }
    public String getRptid() {
        return this.rptid;
    }
    
    public void setRptid(String rptid) {
        this.rptid = rptid;
    }
    public String getChid() {
        return this.chid;
    }
    
    public void setChid(String chid) {
        this.chid = chid;
    }
    public String getRptcnty() {
        return this.rptcnty;
    }
    
    public void setRptcnty(String rptcnty) {
        this.rptcnty = rptcnty;
    }
    public String getRptdt() {
        return this.rptdt;
    }
    
    public void setRptdt(String rptdt) {
        this.rptdt = rptdt;
    }
    public String getInvstdt() {
        return this.invstdt;
    }
    
    public void setInvstdt(String invstdt) {
        this.invstdt = invstdt;
    }
    public String getRptsrc() {
        return this.rptsrc;
    }
    
    public void setRptsrc(String rptsrc) {
        this.rptsrc = rptsrc;
    }
    public String getRptdisp() {
        return this.rptdisp;
    }
    
    public void setRptdisp(String rptdisp) {
        this.rptdisp = rptdisp;
    }
    public String getRptdisdt() {
        return this.rptdisdt;
    }
    
    public void setRptdisdt(String rptdisdt) {
        this.rptdisdt = rptdisdt;
    }
    public String getNotifs() {
        return this.notifs;
    }
    
    public void setNotifs(String notifs) {
        this.notifs = notifs;
    }
    public String getChage() {
        return this.chage;
    }
    
    public void setChage(String chage) {
        this.chage = chage;
    }
    public String getChildBdate() {
        return this.childBdate;
    }
    
    public void setChildBdate(String childBdate) {
        this.childBdate = childBdate;
    }
    public String getChildSex() {
        return this.childSex;
    }
    
    public void setChildSex(String childSex) {
        this.childSex = childSex;
    }
    public String getChildRaceAmerind() {
        return this.childRaceAmerind;
    }
    
    public void setChildRaceAmerind(String childRaceAmerind) {
        this.childRaceAmerind = childRaceAmerind;
    }
    public String getChildRaceAsian() {
        return this.childRaceAsian;
    }
    
    public void setChildRaceAsian(String childRaceAsian) {
        this.childRaceAsian = childRaceAsian;
    }
    public String getChildRaceBlack() {
        return this.childRaceBlack;
    }
    
    public void setChildRaceBlack(String childRaceBlack) {
        this.childRaceBlack = childRaceBlack;
    }
    public String getChildRaceHawaiiPac() {
        return this.childRaceHawaiiPac;
    }
    
    public void setChildRaceHawaiiPac(String childRaceHawaiiPac) {
        this.childRaceHawaiiPac = childRaceHawaiiPac;
    }
    public String getChildRaceWhite() {
        return this.childRaceWhite;
    }
    
    public void setChildRaceWhite(String childRaceWhite) {
        this.childRaceWhite = childRaceWhite;
    }
    public String getChildRaceUnable() {
        return this.childRaceUnable;
    }
    
    public void setChildRaceUnable(String childRaceUnable) {
        this.childRaceUnable = childRaceUnable;
    }
    public String getChildIsp() {
        return this.childIsp;
    }
    
    public void setChildIsp(String childIsp) {
        this.childIsp = childIsp;
    }
    public String getChildCnty() {
        return this.childCnty;
    }
    
    public void setChildCnty(String childCnty) {
        this.childCnty = childCnty;
    }
    public String getChildLvng() {
        return this.childLvng;
    }
    
    public void setChildLvng(String childLvng) {
        this.childLvng = childLvng;
    }
    public String getChildMil() {
        return this.childMil;
    }
    
    public void setChildMil(String childMil) {
        this.childMil = childMil;
    }
    public String getChildPrior() {
        return this.childPrior;
    }
    
    public void setChildPrior(String childPrior) {
        this.childPrior = childPrior;
    }
    public String getChildMal1() {
        return this.childMal1;
    }
    
    public void setChildMal1(String childMal1) {
        this.childMal1 = childMal1;
    }
    public String getChildMaldisp1() {
        return this.childMaldisp1;
    }
    
    public void setChildMaldisp1(String childMaldisp1) {
        this.childMaldisp1 = childMaldisp1;
    }
    public String getChildMal2() {
        return this.childMal2;
    }
    
    public void setChildMal2(String childMal2) {
        this.childMal2 = childMal2;
    }
    public String getChildMaldisp2() {
        return this.childMaldisp2;
    }
    
    public void setChildMaldisp2(String childMaldisp2) {
        this.childMaldisp2 = childMaldisp2;
    }
    public String getChildMal3() {
        return this.childMal3;
    }
    
    public void setChildMal3(String childMal3) {
        this.childMal3 = childMal3;
    }
    public String getChildMaldisp3() {
        return this.childMaldisp3;
    }
    
    public void setChildMaldisp3(String childMaldisp3) {
        this.childMaldisp3 = childMaldisp3;
    }
    public String getChildMal4() {
        return this.childMal4;
    }
    
    public void setChildMal4(String childMal4) {
        this.childMal4 = childMal4;
    }
    public String getChildMaldisp4() {
        return this.childMaldisp4;
    }
    
    public void setChildMaldisp4(String childMaldisp4) {
        this.childMaldisp4 = childMaldisp4;
    }
    public String getChildMalDeath() {
        return this.childMalDeath;
    }
    
    public void setChildMalDeath(String childMalDeath) {
        this.childMalDeath = childMalDeath;
    }
    public String getCdalc() {
        return this.cdalc;
    }
    
    public void setCdalc(String cdalc) {
        this.cdalc = cdalc;
    }
    public String getCddrug() {
        return this.cddrug;
    }
    
    public void setCddrug(String cddrug) {
        this.cddrug = cddrug;
    }
    public String getCdrtrd() {
        return this.cdrtrd;
    }
    
    public void setCdrtrd(String cdrtrd) {
        this.cdrtrd = cdrtrd;
    }
    public String getCdemotnl() {
        return this.cdemotnl;
    }
    
    public void setCdemotnl(String cdemotnl) {
        this.cdemotnl = cdemotnl;
    }
    public String getCdvisual() {
        return this.cdvisual;
    }
    
    public void setCdvisual(String cdvisual) {
        this.cdvisual = cdvisual;
    }
    public String getCdlearn() {
        return this.cdlearn;
    }
    
    public void setCdlearn(String cdlearn) {
        this.cdlearn = cdlearn;
    }
    public String getCdphys() {
        return this.cdphys;
    }
    
    public void setCdphys(String cdphys) {
        this.cdphys = cdphys;
    }
    public String getCdbehav() {
        return this.cdbehav;
    }
    
    public void setCdbehav(String cdbehav) {
        this.cdbehav = cdbehav;
    }
    public String getCdmedicl() {
        return this.cdmedicl;
    }
    
    public void setCdmedicl(String cdmedicl) {
        this.cdmedicl = cdmedicl;
    }
    public String getFcalc() {
        return this.fcalc;
    }
    
    public void setFcalc(String fcalc) {
        this.fcalc = fcalc;
    }
    public String getFcdrug() {
        return this.fcdrug;
    }
    
    public void setFcdrug(String fcdrug) {
        this.fcdrug = fcdrug;
    }
    public String getFcrtrd() {
        return this.fcrtrd;
    }
    
    public void setFcrtrd(String fcrtrd) {
        this.fcrtrd = fcrtrd;
    }
    public String getFcemotnl() {
        return this.fcemotnl;
    }
    
    public void setFcemotnl(String fcemotnl) {
        this.fcemotnl = fcemotnl;
    }
    public String getFcvisual() {
        return this.fcvisual;
    }
    
    public void setFcvisual(String fcvisual) {
        this.fcvisual = fcvisual;
    }
    public String getFclearn() {
        return this.fclearn;
    }
    
    public void setFclearn(String fclearn) {
        this.fclearn = fclearn;
    }
    public String getFcphys() {
        return this.fcphys;
    }
    
    public void setFcphys(String fcphys) {
        this.fcphys = fcphys;
    }
    public String getFcmedicl() {
        return this.fcmedicl;
    }
    
    public void setFcmedicl(String fcmedicl) {
        this.fcmedicl = fcmedicl;
    }
    public String getFcviol() {
        return this.fcviol;
    }
    
    public void setFcviol(String fcviol) {
        this.fcviol = fcviol;
    }
    public String getFchouse() {
        return this.fchouse;
    }
    
    public void setFchouse(String fchouse) {
        this.fchouse = fchouse;
    }
    public String getFcmoney() {
        return this.fcmoney;
    }
    
    public void setFcmoney(String fcmoney) {
        this.fcmoney = fcmoney;
    }
    public String getFcpublic() {
        return this.fcpublic;
    }
    
    public void setFcpublic(String fcpublic) {
        this.fcpublic = fcpublic;
    }
    public String getPostserv() {
        return this.postserv;
    }
    
    public void setPostserv(String postserv) {
        this.postserv = postserv;
    }
    public String getServdate() {
        return this.servdate;
    }
    
    public void setServdate(String servdate) {
        this.servdate = servdate;
    }
    public String getFamsup() {
        return this.famsup;
    }
    
    public void setFamsup(String famsup) {
        this.famsup = famsup;
    }
    public String getFampres() {
        return this.fampres;
    }
    
    public void setFampres(String fampres) {
        this.fampres = fampres;
    }
    public String getFostercr() {
        return this.fostercr;
    }
    
    public void setFostercr(String fostercr) {
        this.fostercr = fostercr;
    }
    public String getRmvdate() {
        return this.rmvdate;
    }
    
    public void setRmvdate(String rmvdate) {
        this.rmvdate = rmvdate;
    }
    public String getJuvpet() {
        return this.juvpet;
    }
    
    public void setJuvpet(String juvpet) {
        this.juvpet = juvpet;
    }
    public String getPetdate() {
        return this.petdate;
    }
    
    public void setPetdate(String petdate) {
        this.petdate = petdate;
    }
    public String getCochrep() {
        return this.cochrep;
    }
    
    public void setCochrep(String cochrep) {
        this.cochrep = cochrep;
    }
    public String getAdopt() {
        return this.adopt;
    }
    
    public void setAdopt(String adopt) {
        this.adopt = adopt;
    }
    public String getCasemanag() {
        return this.casemanag;
    }
    
    public void setCasemanag(String casemanag) {
        this.casemanag = casemanag;
    }
    public String getCounsel() {
        return this.counsel;
    }
    
    public void setCounsel(String counsel) {
        this.counsel = counsel;
    }
    public String getDaycare() {
        return this.daycare;
    }
    
    public void setDaycare(String daycare) {
        this.daycare = daycare;
    }
    public String getEducatn() {
        return this.educatn;
    }
    
    public void setEducatn(String educatn) {
        this.educatn = educatn;
    }
    public String getEmploy() {
        return this.employ;
    }
    
    public void setEmploy(String employ) {
        this.employ = employ;
    }
    public String getFamplan() {
        return this.famplan;
    }
    
    public void setFamplan(String famplan) {
        this.famplan = famplan;
    }
    public String getHealth() {
        return this.health;
    }
    
    public void setHealth(String health) {
        this.health = health;
    }
    public String getHomebase() {
        return this.homebase;
    }
    
    public void setHomebase(String homebase) {
        this.homebase = homebase;
    }
    public String getHousing() {
        return this.housing;
    }
    
    public void setHousing(String housing) {
        this.housing = housing;
    }
    public String getTransliv() {
        return this.transliv;
    }
    
    public void setTransliv(String transliv) {
        this.transliv = transliv;
    }
    public String getInforef() {
        return this.inforef;
    }
    
    public void setInforef(String inforef) {
        this.inforef = inforef;
    }
    public String getLegal() {
        return this.legal;
    }
    
    public void setLegal(String legal) {
        this.legal = legal;
    }
    public String getMenthlth() {
        return this.menthlth;
    }
    
    public void setMenthlth(String menthlth) {
        this.menthlth = menthlth;
    }
    public String getPregpar() {
        return this.pregpar;
    }
    
    public void setPregpar(String pregpar) {
        this.pregpar = pregpar;
    }
    public String getRespite() {
        return this.respite;
    }
    
    public void setRespite(String respite) {
        this.respite = respite;
    }
    public String getSsdisabl() {
        return this.ssdisabl;
    }
    
    public void setSsdisabl(String ssdisabl) {
        this.ssdisabl = ssdisabl;
    }
    public String getSsdelinq() {
        return this.ssdelinq;
    }
    
    public void setSsdelinq(String ssdelinq) {
        this.ssdelinq = ssdelinq;
    }
    public String getSubabuse() {
        return this.subabuse;
    }
    
    public void setSubabuse(String subabuse) {
        this.subabuse = subabuse;
    }
    public String getTransprt() {
        return this.transprt;
    }
    
    public void setTransprt(String transprt) {
        this.transprt = transprt;
    }
    public String getOthersv() {
        return this.othersv;
    }
    
    public void setOthersv(String othersv) {
        this.othersv = othersv;
    }
    public String getWrkrid() {
        return this.wrkrid;
    }
    
    public void setWrkrid(String wrkrid) {
        this.wrkrid = wrkrid;
    }
    public String getSuprvid() {
        return this.suprvid;
    }
    
    public void setSuprvid(String suprvid) {
        this.suprvid = suprvid;
    }
    public String getPerId1() {
        return this.perId1;
    }
    
    public void setPerId1(String perId1) {
        this.perId1 = perId1;
    }
    public String getPerRel1() {
        return this.perRel1;
    }
    
    public void setPerRel1(String perRel1) {
        this.perRel1 = perRel1;
    }
    public String getPerPrnt1() {
        return this.perPrnt1;
    }
    
    public void setPerPrnt1(String perPrnt1) {
        this.perPrnt1 = perPrnt1;
    }
    public String getPerCr1() {
        return this.perCr1;
    }
    
    public void setPerCr1(String perCr1) {
        this.perCr1 = perCr1;
    }
    public String getPerAge1() {
        return this.perAge1;
    }
    
    public void setPerAge1(String perAge1) {
        this.perAge1 = perAge1;
    }
    public String getPerSex1() {
        return this.perSex1;
    }
    
    public void setPerSex1(String perSex1) {
        this.perSex1 = perSex1;
    }
    public String getPerRaceIndian1() {
        return this.perRaceIndian1;
    }
    
    public void setPerRaceIndian1(String perRaceIndian1) {
        this.perRaceIndian1 = perRaceIndian1;
    }
    public String getPerRaceAsian1() {
        return this.perRaceAsian1;
    }
    
    public void setPerRaceAsian1(String perRaceAsian1) {
        this.perRaceAsian1 = perRaceAsian1;
    }
    public String getPerRaceBlack1() {
        return this.perRaceBlack1;
    }
    
    public void setPerRaceBlack1(String perRaceBlack1) {
        this.perRaceBlack1 = perRaceBlack1;
    }
    public String getPerRaceHawaiiPac1() {
        return this.perRaceHawaiiPac1;
    }
    
    public void setPerRaceHawaiiPac1(String perRaceHawaiiPac1) {
        this.perRaceHawaiiPac1 = perRaceHawaiiPac1;
    }
    public String getPerRaceWhite1() {
        return this.perRaceWhite1;
    }
    
    public void setPerRaceWhite1(String perRaceWhite1) {
        this.perRaceWhite1 = perRaceWhite1;
    }
    public String getPerRaceUnable1() {
        return this.perRaceUnable1;
    }
    
    public void setPerRaceUnable1(String perRaceUnable1) {
        this.perRaceUnable1 = perRaceUnable1;
    }
    public String getPerHisp1() {
        return this.perHisp1;
    }
    
    public void setPerHisp1(String perHisp1) {
        this.perHisp1 = perHisp1;
    }
    public String getPerMil1() {
        return this.perMil1;
    }
    
    public void setPerMil1(String perMil1) {
        this.perMil1 = perMil1;
    }
    public String getPerPrior1() {
        return this.perPrior1;
    }
    
    public void setPerPrior1(String perPrior1) {
        this.perPrior1 = perPrior1;
    }
    public String getPerMal11() {
        return this.perMal11;
    }
    
    public void setPerMal11(String perMal11) {
        this.perMal11 = perMal11;
    }
    public String getPerMal21() {
        return this.perMal21;
    }
    
    public void setPerMal21(String perMal21) {
        this.perMal21 = perMal21;
    }
    public String getPerMal31() {
        return this.perMal31;
    }
    
    public void setPerMal31(String perMal31) {
        this.perMal31 = perMal31;
    }
    public String getPerMal41() {
        return this.perMal41;
    }
    
    public void setPerMal41(String perMal41) {
        this.perMal41 = perMal41;
    }
    public String getPerId2() {
        return this.perId2;
    }
    
    public void setPerId2(String perId2) {
        this.perId2 = perId2;
    }
    public String getPerRel2() {
        return this.perRel2;
    }
    
    public void setPerRel2(String perRel2) {
        this.perRel2 = perRel2;
    }
    public String getPerPrnt2() {
        return this.perPrnt2;
    }
    
    public void setPerPrnt2(String perPrnt2) {
        this.perPrnt2 = perPrnt2;
    }
    public String getPerCr2() {
        return this.perCr2;
    }
    
    public void setPerCr2(String perCr2) {
        this.perCr2 = perCr2;
    }
    public String getPerAge2() {
        return this.perAge2;
    }
    
    public void setPerAge2(String perAge2) {
        this.perAge2 = perAge2;
    }
    public String getPerSex2() {
        return this.perSex2;
    }
    
    public void setPerSex2(String perSex2) {
        this.perSex2 = perSex2;
    }
    public String getPerRaceIndian2() {
        return this.perRaceIndian2;
    }
    
    public void setPerRaceIndian2(String perRaceIndian2) {
        this.perRaceIndian2 = perRaceIndian2;
    }
    public String getPerRaceAsian2() {
        return this.perRaceAsian2;
    }
    
    public void setPerRaceAsian2(String perRaceAsian2) {
        this.perRaceAsian2 = perRaceAsian2;
    }
    public String getPerRaceBlack2() {
        return this.perRaceBlack2;
    }
    
    public void setPerRaceBlack2(String perRaceBlack2) {
        this.perRaceBlack2 = perRaceBlack2;
    }
    public String getPerRaceHawaiiPac2() {
        return this.perRaceHawaiiPac2;
    }
    
    public void setPerRaceHawaiiPac2(String perRaceHawaiiPac2) {
        this.perRaceHawaiiPac2 = perRaceHawaiiPac2;
    }
    public String getPerRaceWhite2() {
        return this.perRaceWhite2;
    }
    
    public void setPerRaceWhite2(String perRaceWhite2) {
        this.perRaceWhite2 = perRaceWhite2;
    }
    public String getPerRaceUnable2() {
        return this.perRaceUnable2;
    }
    
    public void setPerRaceUnable2(String perRaceUnable2) {
        this.perRaceUnable2 = perRaceUnable2;
    }
    public String getPerHisp2() {
        return this.perHisp2;
    }
    
    public void setPerHisp2(String perHisp2) {
        this.perHisp2 = perHisp2;
    }
    public String getPerMil2() {
        return this.perMil2;
    }
    
    public void setPerMil2(String perMil2) {
        this.perMil2 = perMil2;
    }
    public String getPerPrior2() {
        return this.perPrior2;
    }
    
    public void setPerPrior2(String perPrior2) {
        this.perPrior2 = perPrior2;
    }
    public String getPerMal12() {
        return this.perMal12;
    }
    
    public void setPerMal12(String perMal12) {
        this.perMal12 = perMal12;
    }
    public String getPerMal22() {
        return this.perMal22;
    }
    
    public void setPerMal22(String perMal22) {
        this.perMal22 = perMal22;
    }
    public String getPerMal32() {
        return this.perMal32;
    }
    
    public void setPerMal32(String perMal32) {
        this.perMal32 = perMal32;
    }
    public String getPerMal42() {
        return this.perMal42;
    }
    
    public void setPerMal42(String perMal42) {
        this.perMal42 = perMal42;
    }
    public String getPerId3() {
        return this.perId3;
    }
    
    public void setPerId3(String perId3) {
        this.perId3 = perId3;
    }
    public String getPerRel3() {
        return this.perRel3;
    }
    
    public void setPerRel3(String perRel3) {
        this.perRel3 = perRel3;
    }
    public String getPerPrnt3() {
        return this.perPrnt3;
    }
    
    public void setPerPrnt3(String perPrnt3) {
        this.perPrnt3 = perPrnt3;
    }
    public String getPerCr3() {
        return this.perCr3;
    }
    
    public void setPerCr3(String perCr3) {
        this.perCr3 = perCr3;
    }
    public String getPerAge3() {
        return this.perAge3;
    }
    
    public void setPerAge3(String perAge3) {
        this.perAge3 = perAge3;
    }
    public String getPerSex3() {
        return this.perSex3;
    }
    
    public void setPerSex3(String perSex3) {
        this.perSex3 = perSex3;
    }
    public String getPerRaceIndian3() {
        return this.perRaceIndian3;
    }
    
    public void setPerRaceIndian3(String perRaceIndian3) {
        this.perRaceIndian3 = perRaceIndian3;
    }
    public String getPerRaceAsian3() {
        return this.perRaceAsian3;
    }
    
    public void setPerRaceAsian3(String perRaceAsian3) {
        this.perRaceAsian3 = perRaceAsian3;
    }
    public String getPerRaceBlack3() {
        return this.perRaceBlack3;
    }
    
    public void setPerRaceBlack3(String perRaceBlack3) {
        this.perRaceBlack3 = perRaceBlack3;
    }
    public String getPerRaceHawaiiPac3() {
        return this.perRaceHawaiiPac3;
    }
    
    public void setPerRaceHawaiiPac3(String perRaceHawaiiPac3) {
        this.perRaceHawaiiPac3 = perRaceHawaiiPac3;
    }
    public String getPerRaceWhite3() {
        return this.perRaceWhite3;
    }
    
    public void setPerRaceWhite3(String perRaceWhite3) {
        this.perRaceWhite3 = perRaceWhite3;
    }
    public String getPerRaceUnable3() {
        return this.perRaceUnable3;
    }
    
    public void setPerRaceUnable3(String perRaceUnable3) {
        this.perRaceUnable3 = perRaceUnable3;
    }
    public String getPerHisp3() {
        return this.perHisp3;
    }
    
    public void setPerHisp3(String perHisp3) {
        this.perHisp3 = perHisp3;
    }
    public String getPerMil3() {
        return this.perMil3;
    }
    
    public void setPerMil3(String perMil3) {
        this.perMil3 = perMil3;
    }
    public String getPerPrior3() {
        return this.perPrior3;
    }
    
    public void setPerPrior3(String perPrior3) {
        this.perPrior3 = perPrior3;
    }
    public String getPerMal13() {
        return this.perMal13;
    }
    
    public void setPerMal13(String perMal13) {
        this.perMal13 = perMal13;
    }
    public String getPerMal23() {
        return this.perMal23;
    }
    
    public void setPerMal23(String perMal23) {
        this.perMal23 = perMal23;
    }
    public String getPerMal33() {
        return this.perMal33;
    }
    
    public void setPerMal33(String perMal33) {
        this.perMal33 = perMal33;
    }
    public String getPerMal43() {
        return this.perMal43;
    }
    
    public void setPerMal43(String perMal43) {
        this.perMal43 = perMal43;
    }
    public String getAfcarsId() {
        return this.afcarsId;
    }
    
    public void setAfcarsId(String afcarsId) {
        this.afcarsId = afcarsId;
    }
    public String getIncidentDate() {
        return this.incidentDate;
    }
    
    public void setIncidentDate(String incidentDate) {
        this.incidentDate = incidentDate;
    }
    public String getCaseManager() {
        return this.caseManager;
    }
    
    public void setCaseManager(String caseManager) {
        this.caseManager = caseManager;
    }
    public String getSupervisor() {
        return this.supervisor;
    }
    
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }




}


