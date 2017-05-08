/**
 * Created on Mar 23, 2006 at 12:32:04 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.Unit;

public interface UnitDAO {
  /**
   * Retrieves a row from Unit table for a given IDPerson and CDUnitSpecialization
   *
   * @param idPerson
   * @param cdUnitSpecialization
   * @return Unit
   */
  Unit findUnit(int idPerson, String cdUnitSpecialization);

  /**
   * This dao call will retrieve a unit's supervisor's name and id. Unit number, county and region uniquely identify a
   * unit.
   *
   * @param cdCounty
   * @param cdUnitRegion
   * @param nbrUnit
   * @return A Map with keys nmPersonFull and idPerson
   */
  Map findUnitByCdCountyCdUnitRegionNbrUnit(String cdCounty, String cdUnitRegion, String nbrUnit);

  /**
   * Gets unit fields given idUnit.
   *
   * @param idUnit
   * @return The {@link gov.georgia.dhr.dfcs.sacwis.db.Unit} object for the specified primary key.
   */
  Unit findUnitByIdUnit(int idUnit);

  /**
   * This retrieves a full row from the UNIT table given CD_UNIT_PROGRAM, CD_UNIT_REGION, NBR_UNIT.
   *
   * @param cdUnitProgram
   * @param cdUnitRegion
   * @param cdUnitCounty TODO
   * @param nbrUnit
   * @return
   */
  Unit findUnitFullRowByCdUnitProgramCdUnitRegionNbrUnit(String cdUnitProgram, String cdUnitRegion,
                                                         String cdUnitCounty, String nbrUnit);

  /**
   * This retrieves a full row from the UNIT table given CD_COUNTY, CD_UNIT_REGION, NBR_UNIT.
   *
   * @param cdCounty
   * @param cdUnitRegion
   * @param nbrUnit
   * @return
   */
  Unit findUnitFullRowByCdCountyCdUnitRegionNbrUnit(String cdCounty, String cdUnitRegion,
                                                    String nbrUnit);

  /**
   * This retrieves a full row from the UNIT table given CD_COUNTY, NBR_UNIT.
   *
   * @param cdCounty
   * @param nbrUnit
   * @return
   */
  Unit findUnitFullRowByCdCountyNbrUnit(String cdCounty, String nbrUnit); 
  
  /**
   * This is designed to retrieve an idUnit from the UNIT table given an isPerson.
   *
   * @param idPerson
   * @return
   */
  Unit findUnitByIdPerson(int idPerson);

  /**
   * Retrievs a full row from the Unit table as well as nbrUnit associated with the idUnitParent (if it exists) found
   * using the idUnit of the retrieved row.
   *
   * @param idUnit
   * @return Unit
   */
   
  Unit findUnitFromUnitAndParentUnitByIdUnit(int idUnit);

  
  /**
   * Check to see if the person is a superior 
   *         (above in Unit hierarchy) Unit than that of the Units of the historical case worker <BR> 
   *         assignments of the passed in Stage
   * @param idStage
   * @param idPerson
   * @return Integer[]
   */
  public List<Integer> findSuperiorUnitByIdStageAndIdPerson(int idStage, int idPerson);
  
  /**
   * Retrieve Unit based on county and specialization
   * @param cdCount
   * @param cdSpecialization
   * @return
   */
  Unit findUnitByCdCountyAndCdUnitSpecialization(String cdCounty,String cdSpecialization);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.Unit} object to the database.
   *
   * @param unit A populated {@link gov.georgia.dhr.dfcs.sacwis.db.Unit} object.
   */
  void saveUnit(Unit unit);

  /**
   * Partial update of Unit table using the supplied parameter(column value).
   *
   * @param idUnit
   */
  int updateUnitIDUnitParent(int idUnit);

  /**
   * Partial update of Unit table using the supplied parameters(column values).
   *
   * @param idPerson
   * @param cdUnitMemberInOut
   */
  int updateUnitIdPerson(int idPerson, String cdUnitMemberInOut);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.Unit} object.
   *
   * @param unit
   */
  void deleteUnit(Unit unit);

  /**
   * Retrieves a row comprising of fields from the Unit and Person tables for the given cdCounty, cdUnitRegion and
   * nbrUnit.A full row from the Unit table is retrieved using the given set of unique keys and nmPersonFull is
   * retrieved from the Person table using the idPerson found on the row returned from the Unit table.
   *
   * @param cdCounty
   * @param cdUnitRegion
   * @param nbrUnit
   * @return Unit
   */
  Unit findUnitFromUnitAndPersonByCdCountyCdUnitRegionNbrUnit(String cdCounty,
                                                                   String cdUnitRegion, String nbrUnit);
  
  /**
   * Retrieves unit id for given county and specialization.
   *
   * @param cdCounty
   * @return Integer
   */
  public Integer findIdUnitFromUnitByCdStageCntyAndCdSpecialization(String cdCounty);
  
  /**
   * Retrieves unit id for given county and specialization.
   *
   * @param cdStageRegion
   * @return Integer
   */
  public Integer findIdUnitFromUnitByCdStageRegionAndCdSpecialization(String cdStageRegion);
  /**
   * Find the Parent Id Person by passing the Id Person
   * @param idPerson
   * @return
   */
  public List<Map> findParentUnitByIdPerson(Integer idPerson);
  /**
   * Find all units that share same specialization in a specific region, more likely there is only one such unit
   * @param cdRegion
   * @param cdSpecialization
   * @return
   */
  List<Unit> findUnitByCdRegionAndCdUnitSpecialization(String cdRegion,String cdSpecialization);
  
  /**
   * Find all units that share same specialization state-wide
   * @param cdSpecialization
   * @return
   */
  List<Unit> findUnitByCdUnitSpecialization(String cdSpecialization);
  
  /**
   * Retrieves a list of all {@link gov.georgia.dhr.dfcs.sacwis.db.Unit} objects where the idUnit
   * given is the ID_UNIT_PARENT value of each returned unit.
   * 
   * @param idUnitParent
   * @return
   */
  List<Unit> findChildUnitsByIdUnitParent(int idUnitParent);
  public List<Unit> findChildUnitsByIdUnitParentOrdered(int idUnitParent);

}
