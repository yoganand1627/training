package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;

import java.util.List;

public interface FcePersonDAO {
  /**
   * Updates table FcePerson, field idPerson given idPersMergeClosed and idStage
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idStage
   */
  int updateFcePersonIdPerson(int idPersMergeForward, int idPersMergeClosed, int idStage);

  /**
   * Selects all rows given idPerson.
   *
   * @param idPerson
   * @return
   */
  FcePerson findFcePersonByIdPerson(long idPerson);

  public FcePerson findFcePersonByIdFceEPerson(long idFcePerson);

  FcePerson findFcePersonByIdFceEligibilityAndIdPerson(long idFceEligibility, long idPerson);

  int saveFcePersonByIdPersonIdFceEligAndCdRelInt(long IdFcePerson, long idFceEligibility, long idPerson,
                                                  String cdRelInt);

  void saveFcePerson(FcePerson fcePerson);

  public List<String> findcdRelIntbyIdPerson(long idFceEligibility);

  public String ifEventExists(long idStage, long idEvent);

  public void updateByCdRelIntandLegalCustodian(long idFcePerson, String cdRelInt, String indLegalCustodian);

  public void updateFcePersonIndThirdPartyIns(long idPerson, String indThirdPartyIns);
  
  public List<FcePerson> findPrincipals(long idFceEligibility);
  
}