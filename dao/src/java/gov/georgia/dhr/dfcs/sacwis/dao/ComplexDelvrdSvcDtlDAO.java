package gov.georgia.dhr.dfcs.sacwis.dao;


public interface ComplexDelvrdSvcDtlDAO {

  /**
   * Updates a row from the Delvrd Svc Dtl table.
   *
   * @param idSvcDtlRevrsalOrig
   * @return int for the number of rows affected by this update
   */
  public int updateDelvrdSvcDtl(int idSvcDtlRevrsalOrig);
}
