package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.PersonEligibilityDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEligibilityDetail;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class PersonEligibilityDetailDAOImpl extends BaseDAOImpl implements PersonEligibilityDetailDAO {
  @SuppressWarnings({"unchecked"})
  public List<PersonEligibilityDetail> findPersonEligibilityDtlForPersonClosed(int idPersEligPerson,
                                                                               int idPersEligDtlPerson) {

    Query query = getSession().createQuery(" select " +
                                           " idPersEligDetail,  " +
                                           " moPersEligDtlMonth,  " +
                                           " yrPersEligDtlYear,  " +
                                           " cdPersEligDtlEligCode,  " +
                                           " cdPersEligDtlTypeCase,  " +
                                           " cdPersEligDtlMedCov,  " +
                                           " cdPersEligDtlStatInGrp,  " +
                                           " cdPersEligDtlCaseStatus,  " +
                                           " cdPersEligDtlProgType,  " +
                                           " cdPersEligDtlCaseCateg,  " +
                                           " dtPersEligDtlCaseCert,  " +
                                           " nbrPersEligDtlCaseNbr " +
                                           " from PersonEligibilityDetail " +
                                           " where personEligibility.idPersElig = :idPersEligDtlPerson " +
                                           "   and person.idPerson = :idPersEligPerson");

    query.setInteger("idPersEligPerson", idPersEligPerson);
    query.setInteger("idPersEligDtlPerson", idPersEligDtlPerson);
    return (List<PersonEligibilityDetail>) query.list();
  }

  public int insertPersonEligibilityDetail(int idPerson, int idPersonEligDtl,
                                           int nMoPersEligDtlMonth, int nYrPersEligDtlYear,
                                           String cdPersonEligDtlEligCode, String cdPersonEligDtlTypeCase,
                                           String cdPersonEligDtlMedCov, String cdPersonEligDtlStatInGrp,
                                           String cdPersonEligDtlCaseStatus, String cdPersonEligDtlProgType,
                                           String cdPersonEligDtlCaseCateg, Date dtPersonEligDtlCaseCert,
                                           int nbrPersEligDtlCaseNbr) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO PERSON_ELIGIBILITY_DETAIL " +
                                                 "               (ID_PERS_ELIG_DETAIL, " +
                                                 "                ID_PERS_ELIG, " +
                                                 "                ID_PERS_ELIG_DTL_PERSON, " +
                                                 "                MO_PERS_ELIG_DTL_MONTH, " +
                                                 "                YR_PERS_ELIG_DTL_YEAR, " +
                                                 "                CD_PERS_ELIG_DTL_ELIG_CODE, " +
                                                 "                CD_PERS_ELIG_DTL_TYPE_CASE, " +
                                                 "                CD_PERS_ELIG_DTL_MED_COV, " +
                                                 "                CD_PERS_ELIG_DTL_STAT_IN_GRP, " +
                                                 "                CD_PERS_ELIG_DTL_CASE_STATUS, " +
                                                 "                CD_PERS_ELIG_DTL_PROG_TYPE, " +
                                                 "                CD_PERS_ELIG_DTL_CASE_CATEG, " +
                                                 "                DT_PERS_ELIG_DTL_CASE_CERT, " +
                                                 "                NBR_PERS_ELIG_DTL_CASE_NBR) " +
                                                 "        VALUES " +
                                                 "               (SEQ_PERSON_ELIGIBILITY_DETAIL.NEXTVAL, " +
                                                 "                :idPerson, " +
                                                 "                :idPersonEligDtl, " +
                                                 "                :nMoPersEligDtlMonth, " +
                                                 "                :nYrPersEligDtlYear, " +
                                                 "                :cdPersonEligDtlEligCode, " +
                                                 "                :cdPersonEligDtlTypeCase, " +
                                                 "                :cdPersonEligDtlMedCov, " +
                                                 "                :cdPersonEligDtlStatInGrp, " +
                                                 "                :cdPersonEligDtlCaseStatus, " +
                                                 "                :cdPersonEligDtlProgType, " +
                                                 "                :cdPersonEligDtlCaseCateg, " +
                                                 "                :cdPersonEligDtlCaseCert, " +
                                                 "                :nbrPersEligDtlCaseNbr)");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idPersonEligDtl", idPersonEligDtl);
    query.setInteger("nMoPersEligDtlMonth", nMoPersEligDtlMonth);
    query.setInteger("nYrPersEligDtlYear", nYrPersEligDtlYear);
    query.setString("cdPersonEligDtlEligCode", cdPersonEligDtlEligCode);
    query.setString("cdPersonEligDtlTypeCase", cdPersonEligDtlTypeCase);
    query.setString("cdPersonEligDtlMedCov", cdPersonEligDtlMedCov);
    query.setString("cdPersonEligDtlStatInGrp", cdPersonEligDtlStatInGrp);
    query.setString("cdPersonEligDtlCaseStatus", cdPersonEligDtlCaseStatus);
    query.setString("cdPersonEligDtlProgType", cdPersonEligDtlProgType);
    query.setString("cdPersonEligDtlCaseCateg", cdPersonEligDtlCaseCateg);
    query.setTimestamp("cdPersonEligDtlCaseCert", dtPersonEligDtlCaseCert);
    query.setInteger("nbrPersEligDtlCaseNbr", nbrPersEligDtlCaseNbr);

    return query.executeUpdate();
  }
}