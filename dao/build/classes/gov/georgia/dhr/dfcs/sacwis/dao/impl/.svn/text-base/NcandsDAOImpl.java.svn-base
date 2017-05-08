package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import gov.georgia.dhr.dfcs.sacwis.dao.NcandsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.Ncands;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/**
 * @author Patrick Coogan
 *
 */

public class NcandsDAOImpl extends BaseDAOImpl implements NcandsDAO {
  
  @SuppressWarnings( { "unchecked" })
  public Ncands findNcandsByPersonAndStage(int idPerson, int idStage) {
    
    Query query = getSession().createQuery(" from  Ncands n " +
                                           " where n.id.PersonId = :idPerson " +
                                           " and n.id.StageId = :idStage ");
    
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    
    return (Ncands) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public Map findNcandsMapByPersonAndStage(int idPerson, int idStage) {
    
    Query query = getSession()
                              .createQuery(
                                           "select new map ("
                                           + "       n.id.Subyr as SUBYR,"
                                           + "       n.staterr as STATERR,"
                                           + "       str(n.id.StageId) as RPTID,"
                                           + "       str(n.id.PersonId) as CHID,"
                                           + "       n.rptcnty as RPTCNTY,"
                                           + "       n.rptdt as RPTDT,"
                                           + "       n.invstdt as INVSTDT,"
                                           + "       n.rptsrc as RPTSRC,"
                                           + "       n.rptdisp as RPTDISP,"
                                           + "       n.rptdisdt as RPTDISDT,"
                                           + "       n.notifs as NOTIFS,"
                                           + "       n.chage as CHAGE,"
                                           + "       n.childBdate as CHILD_BDATE,"
                                           + "       n.childSex as CHILD_SEX,"
                                           + "       n.childRaceAmerind as CHILD_RACE_AMERIND,"
                                           + "       n.childRaceAsian as CHILD_RACE_ASIAN,"
                                           + "       n.childRaceBlack as CHILD_RACE_BLACK,"
                                           + "       n.childRaceHawaiiPac as CHILD_RACE_HAWAII_PAC,"
                                           + "       n.childRaceWhite as CHILD_RACE_WHITE,"
                                           + "       n.childRaceUnable as CHILD_RACE_UNABLE,"
                                           + "       n.childIsp as CHILD_ISP,"
                                           + "       n.childCnty as CHILD_CNTY,"
                                           + "       n.childLvng as CHILD_LVNG,"
                                           + "       n.childMil as CHILD_MIL,"
                                           + "       n.childPrior as CHILD_PRIOR,"
                                           + "       n.childMal1 as CHILD_MAL_1,"
                                           + "       n.childMaldisp1 as CHILD_MALDISP_1,"
                                           + "       n.childMal2 as CHILD_MAL_2,"
                                           + "       n.childMaldisp2 as CHILD_MALDISP_2,"
                                           + "       n.childMal3 as CHILD_MAL_3,"
                                           + "       n.childMaldisp3 as CHILD_MALDISP_3,"
                                           + "       n.childMal4 as CHILD_MAL_4,"
                                           + "       n.childMaldisp4 as CHILD_MALDISP_4,"
                                           + "       n.childMalDeath as CHILD_MAL_DEATH,"
                                           + "       n.cdalc as CDALC,"
                                           + "       n.cddrug as CDDRUG,"
                                           + "       n.cdrtrd as CDRTRD,"
                                           + "       n.cdemotnl as CDEMOTNL,"
                                           + "       n.cdvisual as CDVISUAL,"
                                           + "       n.cdlearn as CDLEARN,"
                                           + "       n.cdphys as CDPHYS,"
                                           + "       n.cdbehav as CDBEHAV,"
                                           + "       n.cdmedicl as CDMEDICL,"
                                           + "       n.fcalc as FCALC,"
                                           + "       n.fcdrug as FCDRUG,"
                                           + "       n.fcrtrd as FCRTRD,"
                                           + "       n.fcemotnl as FCEMOTNL,"
                                           + "       n.fcvisual as FCVISUAL,"
                                           + "       n.fclearn as FCLEARN,"
                                           + "       n.fcphys as FCPHYS,"
                                           + "       n.fcmedicl as FCMEDICL,"
                                           + "       n.fcviol as FCVIOL,"
                                           + "       n.fchouse as FCHOUSE,"
                                           + "       n.fcmoney as FCMONEY,"
                                           + "       n.fcpublic as FCPUBLIC,"
                                           + "       n.postserv as POSTSERV,"
                                           + "       n.servdate as SERVDATE,"
                                           + "       n.famsup as FAMSUP,"
                                           + "       n.fampres as FAMPRES,"
                                           + "       n.fostercr as FOSTERCR,"
                                           + "       n.rmvdate as RMVDATE,"
                                           + "       n.juvpet as JUVPET,"
                                           + "       n.petdate as PETDATE,"
                                           + "       n.cochrep as COCHREP,"
                                           + "       n.adopt as ADOPT,"
                                           + "       n.casemanag as CASEMANAG,"
                                           + "       n.counsel as COUNSEL,"
                                           + "       n.daycare as DAYCARE,"
                                           + "       n.educatn as EDUCATN,"
                                           + "       n.employ as EMPLOY,"
                                           + "       n.famplan as FAMPLAN,"
                                           + "       n.health as HEALTH,"
                                           + "       n.homebase as HOMEBASE,"
                                           + "       n.housing as HOUSING,"
                                           + "       n.transliv as TRANSLIV,"
                                           + "       n.inforef as INFOREF,"
                                           + "       n.legal as LEGAL,"
                                           + "       n.menthlth as MENTHLTH,"
                                           + "       n.pregpar as PREGPAR,"
                                           + "       n.respite as RESPITE,"
                                           + "       n.ssdisabl as SSDISABL,"
                                           + "       n.ssdelinq as SSDELINQ,"
                                           + "       n.subabuse as SUBABUSE,"
                                           + "       n.transprt as TRANSPRT,"
                                           + "       n.othersv as OTHERSV,"
                                           + "       n.caseManager as WRKRID,"
                                           + "       n.supervisor as SUPRVID,"
                                           + "       n.perId1 as PER_ID_1,"
                                           + "       n.perRel1 as PER_REL_1,"
                                           + "       n.perPrnt1 as PER_PRNT_1,"
                                           + "       n.perCr1 as PER_CR_1,"
                                           + "       n.perAge1 as PER_AGE_1,"
                                           + "       n.perSex1 as PER_SEX_1,"
                                           + "       n.perRaceIndian1 as PER_RACE_INDIAN_1,"
                                           + "       n.perRaceAsian1 as PER_RACE_ASIAN_1,"
                                           + "       n.perRaceBlack1 as PER_RACE_BLACK_1,"
                                           + "       n.perRaceHawaiiPac1 as PER_RACE_HAWAII_PAC_1,"
                                           + "       n.perRaceWhite1 as PER_RACE_WHITE_1,"
                                           + "       n.perRaceUnable1 as PER_RACE_UNABLE_1,"
                                           + "       n.perHisp1 as PER_HISP_1,"
                                           + "       n.perMil1 as PER_MIL_1,"
                                           + "       n.perPrior1 as PER_PRIOR_1,"
                                           + "       n.perMal11 as PER_MAL1_1,"
                                           + "       n.perMal21 as PER_MAL2_1,"
                                           + "       n.perMal31 as PER_MAL3_1,"
                                           + "       n.perMal41 as PER_MAL4_1,"
                                           + "       n.perId2 as PER_ID_2,"
                                           + "       n.perRel2 as PER_REL_2,"
                                           + "       n.perPrnt2 as PER_PRNT_2,"
                                           + "       n.perCr2 as PER_CR_2,"
                                           + "       n.perAge2 as PER_AGE_2,"
                                           + "       n.perSex2 as PER_SEX_2,"
                                           + "       n.perRaceIndian2 as PER_RACE_INDIAN_2,"
                                           + "       n.perRaceAsian2 as PER_RACE_ASIAN_2,"
                                           + "       n.perRaceBlack2 as PER_RACE_BLACK_2,"
                                           + "       n.perRaceHawaiiPac2 as PER_RACE_HAWAII_PAC_2,"
                                           + "       n.perRaceWhite2 as PER_RACE_WHITE_2,"
                                           + "       n.perRaceUnable2 as PER_RACE_UNABLE_2,"
                                           + "       n.perHisp2 as PER_HISP_2,"
                                           + "       n.perMil2 as PER_MIL_2,"
                                           + "       n.perPrior2 as PER_PRIOR_2,"
                                           + "       n.perMal12 as PER_MAL1_2,"
                                           + "       n.perMal22 as PER_MAL2_2,"
                                           + "       n.perMal32 as PER_MAL3_2,"
                                           + "       n.perMal42 as PER_MAL4_2,"
                                           + "       n.perId3 as PER_ID_3,"
                                           + "       n.perRel3 as PER_REL_3,"
                                           + "       n.perPrnt3 as PER_PRNT_3,"
                                           + "       n.perCr3 as PER_CR_3,"
                                           + "       n.perAge3 as PER_AGE_3,"
                                           + "       n.perSex3 as PER_SEX_3,"
                                           + "       n.perRaceIndian3 as PER_RACE_INDIAN_3,"
                                           + "       n.perRaceAsian3 as PER_RACE_ASIAN_3,"
                                           + "       n.perRaceBlack3 as PER_RACE_BLACK_3,"
                                           + "       n.perRaceHawaiiPac3 as PER_RACE_HAWAII_PAC_3,"
                                           + "       n.perRaceWhite3 as PER_RACE_WHITE_3,"
                                           + "       n.perRaceUnable3 as PER_RACE_UNABLE_3,"
                                           + "       n.perHisp3 as PER_HISP_3,"
                                           + "       n.perMil3 as PER_MIL_3,"
                                           + "       n.perPrior3 as PER_PRIOR_3,"
                                           + "       n.perMal13 as PER_MAL1_3,"
                                           + "       n.perMal23 as PER_MAL2_3,"
                                           + "       n.perMal33 as PER_MAL3_3,"
                                           + "       n.perMal43 as PER_MAL4_3,"
                                           + "       n.incidentDate as INCIDENT_DATE) "
                                           + "       from  Ncands n " 
                                           + "       where n.id.PersonId = :idPerson "
                                           + "       and n.id.StageId = :idStage ");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);

    return (Map) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Map> findNcandsChildrenByStage(int idStage) {
    
    Query query = getSession()
                             .createQuery(
                                         "select new map ("
                                 +"       n.id.PersonId as personId," 
                                 +"       p.nmPersonFull as nmPersonFull) "
                                 +"       from  Ncands n, Person p " 
                                 +"       where n.id.StageId = :idStage " 
                                 +"       and n.id.PersonId = p.idPerson"
                                 +"       order by p.nmPersonFull asc");

     
     query.setInteger("idStage", idStage);
    
    return (List<Map>) query.list();
  }

}
