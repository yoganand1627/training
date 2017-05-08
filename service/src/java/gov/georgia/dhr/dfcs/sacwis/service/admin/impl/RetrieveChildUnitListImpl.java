package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveChildUnitList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01_ARRAY;

/**
 * This service will retrieve a list of child Units 
 * (based on unitProgram,unitRegion and nbrUnit)
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  12/3/2008  wjcochran STGAP00010660: Modified code to read each individual unit's 
 *                       Region which was done by modification to the CCMN24SO object
 * </pre>
 * 
 */
public class RetrieveChildUnitListImpl extends BaseServiceImpl implements RetrieveChildUnitList {

  private UnitDAO unitDAO = null;
  
  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public CCMN24SO retrieveChildUnitList(CCMN24SI ccmn24si) {
    CCMN24SO ccmn24so = new CCMN24SO();
    
    ArchInputStruct archInputStruct = ccmn24si.getArchInputStruct();
    String unitCounty = ccmn24si.getSzCdUnitCounty();
    String unitRegion = ccmn24si.getSzCdUnitRegion();
    String nbrUnit = ccmn24si.getSzNbrUnit();
    String szUserId = archInputStruct.getSzUserId();
    
    Unit parentUnit = null;
    parentUnit = unitDAO.findUnitFromUnitAndPersonByCdCountyCdUnitRegionNbrUnit(unitCounty, unitRegion, nbrUnit);
    List<Unit> childUnitList = null;
    if (parentUnit != null) {
      childUnitList = unitDAO.findChildUnitsByIdUnitParentOrdered(parentUnit.getIdUnit());
    }

    ROWCCMN24SOG01_ARRAY rowccmn24so_array = new ROWCCMN24SOG01_ARRAY();
    if (childUnitList != null && !childUnitList.isEmpty()) {
      for (Unit aUnit : childUnitList){
        Person aPerson = aUnit.getPerson(); // The entire person object is returned in the Unit object

        // if, by chance, a person is not assigned to a unit, set the object
        // to an empty object with empty or 0 values to prevent NullPointerExceptions
        if (aPerson == null) {
          aPerson = new Person();
          aPerson.setIdPerson(new Integer(0));
          aPerson.setNmPersonFull("");
        }
        if (!aUnit.equals(parentUnit)) {
          ROWCCMN24SOG01 rowccmn24sog01 = new ROWCCMN24SOG01();
          rowccmn24sog01.setSzCdUnitSpecialization(aUnit.getCdUnitSpecialization());
          rowccmn24sog01.setSzNbrUnit(aUnit.getNbrUnit());
          rowccmn24sog01.setUlIdUnit(aUnit.getIdUnit());
          rowccmn24sog01.setUlIdPerson(aPerson.getIdPerson());
          rowccmn24sog01.setSzNmPersonFull(aPerson.getNmPersonFull());
          rowccmn24sog01.setSzCdUnitCounty(aUnit.getCdCounty());
          rowccmn24sog01.setSzCdUnitRegion(aUnit.getCdUnitRegion());
          rowccmn24sog01.setSzScrNbrUnitParent(parentUnit.getNbrUnit());  //The unit parent = the original unit
          rowccmn24so_array.addROWCCMN24SOG01(rowccmn24sog01);
        }

      }
    } else {
      return null;

    }
    ccmn24so.setROWCCMN24SOG01_ARRAY(rowccmn24so_array);
    return ccmn24so;
  }

}
