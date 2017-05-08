package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexIntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IntakeAllegationDAO;

import java.util.Date;

public class ComplexIntakeAllegationDAOImpl extends BaseDAOImpl implements ComplexIntakeAllegationDAO {
  private IntakeAllegationDAO intakeAllegationDAO = null;
  
  public void setIntakeAllegationDAO(IntakeAllegationDAO intakeAllegationDAO) {
    this.intakeAllegationDAO = intakeAllegationDAO;
  }

  public void updateNameByIdStage(String cdNamePersonFull, int idPerson, int idStage) {
    // note that either of these updates may fail because the person is not a perpetrator or a victim.
    intakeAllegationDAO.updateIntakeAllegationByPersonByIdAllegedPerpetratorIdStage(cdNamePersonFull, idPerson,
                                                                                    idStage);
    intakeAllegationDAO.updateIntakeAllegationByPersonByIdVictimIdStage(cdNamePersonFull, idPerson, idStage);
  }

  public int updateIntakeAllegation(int idRelatedPerson, String nmPersonFull, int idPerson, int idStage) {
    intakeAllegationDAO.updateIntakeAllegationIdAllegedPerpNmPerpetrator(idRelatedPerson, nmPersonFull, idPerson,
                                                                         idStage);
    // The first resutl is ignored by the DAM; only the result of this would cause SQL_NOT_FOUND, so just return this one.
    return intakeAllegationDAO.updateIntakeAllegationIdVictimNmVictim(idRelatedPerson, nmPersonFull, idPerson, idStage);
  }

  public int addIntakeAllegationWithCheck(String cdAllegType, int idStage, String cdTxtAllegDuration, int idVictim,
                                          int idAllegedPerpetrator, String indIncmgMaltreatInCare, String cdNmVictim, 
                                          String cdNmPerpetrator, String cdAllegedMalLocation, String cdAllegedMalCode,
                                          Date dtAllegedIncident, String cdMaltreatorRel) {
    // check that an allegation does not already exist
    long count = intakeAllegationDAO.countIntakeAllegations(idVictim, idAllegedPerpetrator, idStage,
    		                                                cdAllegType, dtAllegedIncident, cdAllegedMalCode,
    		                                                cdAllegedMalLocation, cdMaltreatorRel);
    if (count > 0) {
      // exit if already there; return 1 because this is NOT an error.
      return 1;
    }
    //  not found -- so insert a new IntakeAllegation
    int numOfRecords = 0;
    if (idAllegedPerpetrator != 0) {
      numOfRecords = intakeAllegationDAO.insertIntakeAllegation(cdAllegType, idStage, cdTxtAllegDuration,
                                                        idVictim, idAllegedPerpetrator, indIncmgMaltreatInCare,
                                                        cdNmVictim, cdNmPerpetrator, cdAllegedMalLocation,
                                                        cdAllegedMalCode, dtAllegedIncident, cdMaltreatorRel);
    } else {
      numOfRecords = intakeAllegationDAO.insertIntakeAllegation(cdAllegType, idStage, cdTxtAllegDuration,
                                                        idVictim, indIncmgMaltreatInCare, cdNmVictim, cdAllegedMalLocation,
                                                        cdAllegedMalCode, dtAllegedIncident, cdMaltreatorRel);
    }
    return numOfRecords;
  }
  
  public int updateIntakeAllegationDetails(String cdAllegType, int idStage, String txtAllegDuration,
                                           int idVictim, int idAllegedPerpetrator, String indIncmgMaltreatInCare, 
                                           String cdNmVictim, String cdNmPerpetrator, int idAllegation, 
                                           String cdAllegedMalLocation, String cdAllegedMalCode, 
                                           Date dtAllegedIncident, String cdMaltreatorRel) 
  {
    int numOfRecords = 0;
    if (idAllegedPerpetrator != 0) 
    {
      numOfRecords = intakeAllegationDAO.updateIntakeAllegationDetails(cdAllegType, idStage, txtAllegDuration, idVictim,
                                                               idAllegedPerpetrator, cdNmVictim, cdNmPerpetrator,
                                                               idAllegation, cdAllegedMalLocation, indIncmgMaltreatInCare,
                                                               cdAllegedMalCode, dtAllegedIncident, cdMaltreatorRel);
    } 
    else 
    {
      numOfRecords = intakeAllegationDAO.updateIntakeAllegationDetails(cdAllegType, idStage, txtAllegDuration,
                                                               idVictim, cdNmVictim, idAllegation, cdAllegedMalLocation, 
                                                               indIncmgMaltreatInCare, cdAllegedMalCode, dtAllegedIncident, cdMaltreatorRel);
    }
    return numOfRecords;
  }
}