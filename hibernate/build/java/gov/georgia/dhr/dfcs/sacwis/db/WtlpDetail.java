package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * WtlpDetail generated by hbm2java
 */
public class WtlpDetail  implements java.io.Serializable {


     private Integer idPerson;
     private Date dtLastUpdate;
     private Person person;
     private Date dtEmncDisc;
     private String txtDemCmmts;
     private String txtLifeSkills;
     private String txtEmpSvc;
     private String txtHlthSvc;
     private Date dtGrad;
     private String cdAcadTrack;
     private Integer nbrSchCreditReqd;
     private Integer nbrSchCreditEarned;
     private Integer nbrSchCurrGpa;
     private Integer nbrSchCumGpa;
     private String indSchGrad;
     private String txtSchCmmts;
     private Date dtGgtWriteTak;
     private Date dtGgtWritePassed;
     private Date dtGgtMathTak;
     private Date dtGgtMathPassed;
     private Date dtGgtSciTak;
     private Date dtGgtSciPassed;
     private Date dtGgtSocsciTak;
     private Date dtGgtSocsciPassed;
     private Date dtGgtReadTak;
     private Date dtGgtReadPassed;
     private String nmGedProg;
     private String indGedProg;
     private String addrGedAddr1;
     private String addrGedAddr2;
     private String addrGedAddrCity;
     private String addrGedAddrState;
     private String addrGedAddrZip;
     private String nbrGedPhone;
     private String nbrGedFax;
     private Date dtGedExpProgComp;
     private Date dtGedProgComp;
     private Date dtGedComp;
     private Date dtGedWriteTak;
     private Date dtGedWritePassed;
     private Date dtGedSocstuTak;
     private Date dtGedSocstuPassed;
     private Date dtGedSciTak;
     private Date dtGedSciPassed;
     private Date dtGedLaTak;
     private Date dtGedLaPassed;
     private Date dtGedMathTak;
     private Date dtGedMathPassed;
     private String nmInst;
     private String cdEduGoal;
     private String cdClassif;
     private String txtAreaStudy;
     private Integer nbrPostCurrGpa;
     private Integer nbrPostCummGpa;
     private Integer nbrPostReqCred;
     private Integer nbrPostReqEar;
     private Date dtPostExpGrad;
     private Date dtPostGrad;
     private String cdParStat;
     private String indLifeSkills;
     private String indEmpSvc;
     private String indHealthSvc;
     private Collection<CollegeExam> collegeExams;

    public WtlpDetail() {
    }

	
    public WtlpDetail(Person person) {
        this.person = person;
    }
    public WtlpDetail(Person person, Date dtEmncDisc, String txtDemCmmts, String txtLifeSkills, String txtEmpSvc, String txtHlthSvc, Date dtGrad, String cdAcadTrack, Integer nbrSchCreditReqd, Integer nbrSchCreditEarned, Integer nbrSchCurrGpa, Integer nbrSchCumGpa, String indSchGrad, String txtSchCmmts, Date dtGgtWriteTak, Date dtGgtWritePassed, Date dtGgtMathTak, Date dtGgtMathPassed, Date dtGgtSciTak, Date dtGgtSciPassed, Date dtGgtSocsciTak, Date dtGgtSocsciPassed, Date dtGgtReadTak, Date dtGgtReadPassed, String nmGedProg, String indGedProg, String addrGedAddr1, String addrGedAddr2, String addrGedAddrCity, String addrGedAddrState, String addrGedAddrZip, String nbrGedPhone, String nbrGedFax, Date dtGedExpProgComp, Date dtGedProgComp, Date dtGedComp, Date dtGedWriteTak, Date dtGedWritePassed, Date dtGedSocstuTak, Date dtGedSocstuPassed, Date dtGedSciTak, Date dtGedSciPassed, Date dtGedLaTak, Date dtGedLaPassed, Date dtGedMathTak, Date dtGedMathPassed, String nmInst, String cdEduGoal, String cdClassif, String txtAreaStudy, Integer nbrPostCurrGpa, Integer nbrPostCummGpa, Integer nbrPostReqCred, Integer nbrPostReqEar, Date dtPostExpGrad, Date dtPostGrad, String cdParStat, String indLifeSkills, String indEmpSvc, String indHealthSvc, Collection<CollegeExam> collegeExams) {
       this.person = person;
       this.dtEmncDisc = dtEmncDisc;
       this.txtDemCmmts = txtDemCmmts;
       this.txtLifeSkills = txtLifeSkills;
       this.txtEmpSvc = txtEmpSvc;
       this.txtHlthSvc = txtHlthSvc;
       this.dtGrad = dtGrad;
       this.cdAcadTrack = cdAcadTrack;
       this.nbrSchCreditReqd = nbrSchCreditReqd;
       this.nbrSchCreditEarned = nbrSchCreditEarned;
       this.nbrSchCurrGpa = nbrSchCurrGpa;
       this.nbrSchCumGpa = nbrSchCumGpa;
       this.indSchGrad = indSchGrad;
       this.txtSchCmmts = txtSchCmmts;
       this.dtGgtWriteTak = dtGgtWriteTak;
       this.dtGgtWritePassed = dtGgtWritePassed;
       this.dtGgtMathTak = dtGgtMathTak;
       this.dtGgtMathPassed = dtGgtMathPassed;
       this.dtGgtSciTak = dtGgtSciTak;
       this.dtGgtSciPassed = dtGgtSciPassed;
       this.dtGgtSocsciTak = dtGgtSocsciTak;
       this.dtGgtSocsciPassed = dtGgtSocsciPassed;
       this.dtGgtReadTak = dtGgtReadTak;
       this.dtGgtReadPassed = dtGgtReadPassed;
       this.nmGedProg = nmGedProg;
       this.indGedProg = indGedProg;
       this.addrGedAddr1 = addrGedAddr1;
       this.addrGedAddr2 = addrGedAddr2;
       this.addrGedAddrCity = addrGedAddrCity;
       this.addrGedAddrState = addrGedAddrState;
       this.addrGedAddrZip = addrGedAddrZip;
       this.nbrGedPhone = nbrGedPhone;
       this.nbrGedFax = nbrGedFax;
       this.dtGedExpProgComp = dtGedExpProgComp;
       this.dtGedProgComp = dtGedProgComp;
       this.dtGedComp = dtGedComp;
       this.dtGedWriteTak = dtGedWriteTak;
       this.dtGedWritePassed = dtGedWritePassed;
       this.dtGedSocstuTak = dtGedSocstuTak;
       this.dtGedSocstuPassed = dtGedSocstuPassed;
       this.dtGedSciTak = dtGedSciTak;
       this.dtGedSciPassed = dtGedSciPassed;
       this.dtGedLaTak = dtGedLaTak;
       this.dtGedLaPassed = dtGedLaPassed;
       this.dtGedMathTak = dtGedMathTak;
       this.dtGedMathPassed = dtGedMathPassed;
       this.nmInst = nmInst;
       this.cdEduGoal = cdEduGoal;
       this.cdClassif = cdClassif;
       this.txtAreaStudy = txtAreaStudy;
       this.nbrPostCurrGpa = nbrPostCurrGpa;
       this.nbrPostCummGpa = nbrPostCummGpa;
       this.nbrPostReqCred = nbrPostReqCred;
       this.nbrPostReqEar = nbrPostReqEar;
       this.dtPostExpGrad = dtPostExpGrad;
       this.dtPostGrad = dtPostGrad;
       this.cdParStat = cdParStat;
       this.indLifeSkills = indLifeSkills;
       this.indEmpSvc = indEmpSvc;
       this.indHealthSvc = indHealthSvc;
       this.collegeExams = collegeExams;
    }
   
    public Integer getIdPerson() {
        return this.idPerson;
    }
    
    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public Date getDtEmncDisc() {
        return this.dtEmncDisc;
    }
    
    public void setDtEmncDisc(Date dtEmncDisc) {
        this.dtEmncDisc = dtEmncDisc;
    }
    public String getTxtDemCmmts() {
        return this.txtDemCmmts;
    }
    
    public void setTxtDemCmmts(String txtDemCmmts) {
        this.txtDemCmmts = txtDemCmmts;
    }
    public String getTxtLifeSkills() {
        return this.txtLifeSkills;
    }
    
    public void setTxtLifeSkills(String txtLifeSkills) {
        this.txtLifeSkills = txtLifeSkills;
    }
    public String getTxtEmpSvc() {
        return this.txtEmpSvc;
    }
    
    public void setTxtEmpSvc(String txtEmpSvc) {
        this.txtEmpSvc = txtEmpSvc;
    }
    public String getTxtHlthSvc() {
        return this.txtHlthSvc;
    }
    
    public void setTxtHlthSvc(String txtHlthSvc) {
        this.txtHlthSvc = txtHlthSvc;
    }
    public Date getDtGrad() {
        return this.dtGrad;
    }
    
    public void setDtGrad(Date dtGrad) {
        this.dtGrad = dtGrad;
    }
    public String getCdAcadTrack() {
        return this.cdAcadTrack;
    }
    
    public void setCdAcadTrack(String cdAcadTrack) {
        this.cdAcadTrack = cdAcadTrack;
    }
    public Integer getNbrSchCreditReqd() {
        return this.nbrSchCreditReqd;
    }
    
    public void setNbrSchCreditReqd(Integer nbrSchCreditReqd) {
        this.nbrSchCreditReqd = nbrSchCreditReqd;
    }
    public Integer getNbrSchCreditEarned() {
        return this.nbrSchCreditEarned;
    }
    
    public void setNbrSchCreditEarned(Integer nbrSchCreditEarned) {
        this.nbrSchCreditEarned = nbrSchCreditEarned;
    }
    public Integer getNbrSchCurrGpa() {
        return this.nbrSchCurrGpa;
    }
    
    public void setNbrSchCurrGpa(Integer nbrSchCurrGpa) {
        this.nbrSchCurrGpa = nbrSchCurrGpa;
    }
    public Integer getNbrSchCumGpa() {
        return this.nbrSchCumGpa;
    }
    
    public void setNbrSchCumGpa(Integer nbrSchCumGpa) {
        this.nbrSchCumGpa = nbrSchCumGpa;
    }
    public String getIndSchGrad() {
        return this.indSchGrad;
    }
    
    public void setIndSchGrad(String indSchGrad) {
        this.indSchGrad = indSchGrad;
    }
    public String getTxtSchCmmts() {
        return this.txtSchCmmts;
    }
    
    public void setTxtSchCmmts(String txtSchCmmts) {
        this.txtSchCmmts = txtSchCmmts;
    }
    public Date getDtGgtWriteTak() {
        return this.dtGgtWriteTak;
    }
    
    public void setDtGgtWriteTak(Date dtGgtWriteTak) {
        this.dtGgtWriteTak = dtGgtWriteTak;
    }
    public Date getDtGgtWritePassed() {
        return this.dtGgtWritePassed;
    }
    
    public void setDtGgtWritePassed(Date dtGgtWritePassed) {
        this.dtGgtWritePassed = dtGgtWritePassed;
    }
    public Date getDtGgtMathTak() {
        return this.dtGgtMathTak;
    }
    
    public void setDtGgtMathTak(Date dtGgtMathTak) {
        this.dtGgtMathTak = dtGgtMathTak;
    }
    public Date getDtGgtMathPassed() {
        return this.dtGgtMathPassed;
    }
    
    public void setDtGgtMathPassed(Date dtGgtMathPassed) {
        this.dtGgtMathPassed = dtGgtMathPassed;
    }
    public Date getDtGgtSciTak() {
        return this.dtGgtSciTak;
    }
    
    public void setDtGgtSciTak(Date dtGgtSciTak) {
        this.dtGgtSciTak = dtGgtSciTak;
    }
    public Date getDtGgtSciPassed() {
        return this.dtGgtSciPassed;
    }
    
    public void setDtGgtSciPassed(Date dtGgtSciPassed) {
        this.dtGgtSciPassed = dtGgtSciPassed;
    }
    public Date getDtGgtSocsciTak() {
        return this.dtGgtSocsciTak;
    }
    
    public void setDtGgtSocsciTak(Date dtGgtSocsciTak) {
        this.dtGgtSocsciTak = dtGgtSocsciTak;
    }
    public Date getDtGgtSocsciPassed() {
        return this.dtGgtSocsciPassed;
    }
    
    public void setDtGgtSocsciPassed(Date dtGgtSocsciPassed) {
        this.dtGgtSocsciPassed = dtGgtSocsciPassed;
    }
    public Date getDtGgtReadTak() {
        return this.dtGgtReadTak;
    }
    
    public void setDtGgtReadTak(Date dtGgtReadTak) {
        this.dtGgtReadTak = dtGgtReadTak;
    }
    public Date getDtGgtReadPassed() {
        return this.dtGgtReadPassed;
    }
    
    public void setDtGgtReadPassed(Date dtGgtReadPassed) {
        this.dtGgtReadPassed = dtGgtReadPassed;
    }
    public String getNmGedProg() {
        return this.nmGedProg;
    }
    
    public void setNmGedProg(String nmGedProg) {
        this.nmGedProg = nmGedProg;
    }
    public String getIndGedProg() {
        return this.indGedProg;
    }
    
    public void setIndGedProg(String indGedProg) {
        this.indGedProg = indGedProg;
    }
    public String getAddrGedAddr1() {
        return this.addrGedAddr1;
    }
    
    public void setAddrGedAddr1(String addrGedAddr1) {
        this.addrGedAddr1 = addrGedAddr1;
    }
    public String getAddrGedAddr2() {
        return this.addrGedAddr2;
    }
    
    public void setAddrGedAddr2(String addrGedAddr2) {
        this.addrGedAddr2 = addrGedAddr2;
    }
    public String getAddrGedAddrCity() {
        return this.addrGedAddrCity;
    }
    
    public void setAddrGedAddrCity(String addrGedAddrCity) {
        this.addrGedAddrCity = addrGedAddrCity;
    }
    public String getAddrGedAddrState() {
        return this.addrGedAddrState;
    }
    
    public void setAddrGedAddrState(String addrGedAddrState) {
        this.addrGedAddrState = addrGedAddrState;
    }
    public String getAddrGedAddrZip() {
        return this.addrGedAddrZip;
    }
    
    public void setAddrGedAddrZip(String addrGedAddrZip) {
        this.addrGedAddrZip = addrGedAddrZip;
    }
    public String getNbrGedPhone() {
        return this.nbrGedPhone;
    }
    
    public void setNbrGedPhone(String nbrGedPhone) {
        this.nbrGedPhone = nbrGedPhone;
    }
    public String getNbrGedFax() {
        return this.nbrGedFax;
    }
    
    public void setNbrGedFax(String nbrGedFax) {
        this.nbrGedFax = nbrGedFax;
    }
    public Date getDtGedExpProgComp() {
        return this.dtGedExpProgComp;
    }
    
    public void setDtGedExpProgComp(Date dtGedExpProgComp) {
        this.dtGedExpProgComp = dtGedExpProgComp;
    }
    public Date getDtGedProgComp() {
        return this.dtGedProgComp;
    }
    
    public void setDtGedProgComp(Date dtGedProgComp) {
        this.dtGedProgComp = dtGedProgComp;
    }
    public Date getDtGedComp() {
        return this.dtGedComp;
    }
    
    public void setDtGedComp(Date dtGedComp) {
        this.dtGedComp = dtGedComp;
    }
    public Date getDtGedWriteTak() {
        return this.dtGedWriteTak;
    }
    
    public void setDtGedWriteTak(Date dtGedWriteTak) {
        this.dtGedWriteTak = dtGedWriteTak;
    }
    public Date getDtGedWritePassed() {
        return this.dtGedWritePassed;
    }
    
    public void setDtGedWritePassed(Date dtGedWritePassed) {
        this.dtGedWritePassed = dtGedWritePassed;
    }
    public Date getDtGedSocstuTak() {
        return this.dtGedSocstuTak;
    }
    
    public void setDtGedSocstuTak(Date dtGedSocstuTak) {
        this.dtGedSocstuTak = dtGedSocstuTak;
    }
    public Date getDtGedSocstuPassed() {
        return this.dtGedSocstuPassed;
    }
    
    public void setDtGedSocstuPassed(Date dtGedSocstuPassed) {
        this.dtGedSocstuPassed = dtGedSocstuPassed;
    }
    public Date getDtGedSciTak() {
        return this.dtGedSciTak;
    }
    
    public void setDtGedSciTak(Date dtGedSciTak) {
        this.dtGedSciTak = dtGedSciTak;
    }
    public Date getDtGedSciPassed() {
        return this.dtGedSciPassed;
    }
    
    public void setDtGedSciPassed(Date dtGedSciPassed) {
        this.dtGedSciPassed = dtGedSciPassed;
    }
    public Date getDtGedLaTak() {
        return this.dtGedLaTak;
    }
    
    public void setDtGedLaTak(Date dtGedLaTak) {
        this.dtGedLaTak = dtGedLaTak;
    }
    public Date getDtGedLaPassed() {
        return this.dtGedLaPassed;
    }
    
    public void setDtGedLaPassed(Date dtGedLaPassed) {
        this.dtGedLaPassed = dtGedLaPassed;
    }
    public Date getDtGedMathTak() {
        return this.dtGedMathTak;
    }
    
    public void setDtGedMathTak(Date dtGedMathTak) {
        this.dtGedMathTak = dtGedMathTak;
    }
    public Date getDtGedMathPassed() {
        return this.dtGedMathPassed;
    }
    
    public void setDtGedMathPassed(Date dtGedMathPassed) {
        this.dtGedMathPassed = dtGedMathPassed;
    }
    public String getNmInst() {
        return this.nmInst;
    }
    
    public void setNmInst(String nmInst) {
        this.nmInst = nmInst;
    }
    public String getCdEduGoal() {
        return this.cdEduGoal;
    }
    
    public void setCdEduGoal(String cdEduGoal) {
        this.cdEduGoal = cdEduGoal;
    }
    public String getCdClassif() {
        return this.cdClassif;
    }
    
    public void setCdClassif(String cdClassif) {
        this.cdClassif = cdClassif;
    }
    public String getTxtAreaStudy() {
        return this.txtAreaStudy;
    }
    
    public void setTxtAreaStudy(String txtAreaStudy) {
        this.txtAreaStudy = txtAreaStudy;
    }
    public Integer getNbrPostCurrGpa() {
        return this.nbrPostCurrGpa;
    }
    
    public void setNbrPostCurrGpa(Integer nbrPostCurrGpa) {
        this.nbrPostCurrGpa = nbrPostCurrGpa;
    }
    public Integer getNbrPostCummGpa() {
        return this.nbrPostCummGpa;
    }
    
    public void setNbrPostCummGpa(Integer nbrPostCummGpa) {
        this.nbrPostCummGpa = nbrPostCummGpa;
    }
    public Integer getNbrPostReqCred() {
        return this.nbrPostReqCred;
    }
    
    public void setNbrPostReqCred(Integer nbrPostReqCred) {
        this.nbrPostReqCred = nbrPostReqCred;
    }
    public Integer getNbrPostReqEar() {
        return this.nbrPostReqEar;
    }
    
    public void setNbrPostReqEar(Integer nbrPostReqEar) {
        this.nbrPostReqEar = nbrPostReqEar;
    }
    public Date getDtPostExpGrad() {
        return this.dtPostExpGrad;
    }
    
    public void setDtPostExpGrad(Date dtPostExpGrad) {
        this.dtPostExpGrad = dtPostExpGrad;
    }
    public Date getDtPostGrad() {
        return this.dtPostGrad;
    }
    
    public void setDtPostGrad(Date dtPostGrad) {
        this.dtPostGrad = dtPostGrad;
    }
    public String getCdParStat() {
        return this.cdParStat;
    }
    
    public void setCdParStat(String cdParStat) {
        this.cdParStat = cdParStat;
    }
    public String getIndLifeSkills() {
        return this.indLifeSkills;
    }
    
    public void setIndLifeSkills(String indLifeSkills) {
        this.indLifeSkills = indLifeSkills;
    }
    public String getIndEmpSvc() {
        return this.indEmpSvc;
    }
    
    public void setIndEmpSvc(String indEmpSvc) {
        this.indEmpSvc = indEmpSvc;
    }
    public String getIndHealthSvc() {
        return this.indHealthSvc;
    }
    
    public void setIndHealthSvc(String indHealthSvc) {
        this.indHealthSvc = indHealthSvc;
    }
    public Collection<CollegeExam> getCollegeExams() {
        return this.collegeExams;
    }
    
    public void setCollegeExams(Collection<CollegeExam> collegeExams) {
        this.collegeExams = collegeExams;
    }




}


