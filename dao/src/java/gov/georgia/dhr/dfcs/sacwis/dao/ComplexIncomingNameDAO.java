package gov.georgia.dhr.dfcs.sacwis.dao;

public interface ComplexIncomingNameDAO {
  /**
   * Adds rows to the Name table from IncomingName
   *
   * @param idPerson
   * @param idIncmgPerson
   * @return
   */
  int addIncomingNameToName(int idPerson, int idIncmgPerson);
}