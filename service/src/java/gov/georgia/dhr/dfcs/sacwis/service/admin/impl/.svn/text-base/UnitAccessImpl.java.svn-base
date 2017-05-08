package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.UnitAccess;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;

/**
 * Service Name:  CCMN04U - UNIT ACCESS
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 * </pre>
 */
public class UnitAccessImpl extends BaseServiceImpl implements UnitAccess {
  public static final String UNIT_MEMBER_ROLE_CLERK = "70";

  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  private UnitDAO unitDAO = null;

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public CCMN04UO checkForPersonWithUnitAccess(CCMN04UI ccmn04ui) {
    CCMN04UO ccmn04uo = new CCMN04UO();
    Unit unit;
    if (ccmn04ui.getUlIdUnit() != 0) {
      unit = unitDAO.findUnitByIdUnit(ccmn04ui.getUlIdUnit());
    } else {
      unit = unitDAO.findUnitFullRowByCdCountyCdUnitRegionNbrUnit(ccmn04ui.getSzCdUnitCounty(),
                                                                  ccmn04ui.getSzCdUnitRegion(),
                                                                  ccmn04ui.getSzNbrUnit());
    }
    if (unit != null && unit.getPerson() != null) {
      //  Check to see if the user or the user's designees is the approver
      int unitIdPerson = unit.getPerson().getIdPerson();
      int[] ulIdPersons = ccmn04ui.getUlIdPerson_ARRAY_CCMN04UI().getUlIdPerson();
      // Checking to see if someone with a division number is trying to save.
      //   If not then delete the leading zero in the region number.
      boolean isApprover = false;
      for (int i = 0; i < ulIdPersons.length; i++) {
        int ulIdPerson = ulIdPersons[i];
        if (unitIdPerson == ulIdPerson) {
          isApprover = true;
          break;
        }
      }
      // The original service called for 1 for true and 0 for false as strings; we are using "Y" and "N"; if the person
      //   found has access, we are effectively done (the final value will be "Y"); otherwise, we search through the
      //   passed in idPersons to determine if someone in the unit has access.
      ccmn04uo.setBSysIndGeneric(isApprover ? ArchitectureConstants.Y : ArchitectureConstants.N);
      if (!isApprover) {
        UnitEmpLink unitEmpLink = unitEmpLinkDAO.findUnitEmpLinkByIdPersonAndIdUnit(unit.getPerson().getIdPerson(),
                                                                                    unit.getIdUnit());
        if (unitEmpLink != null) {
          ccmn04uo.setBSysIndGeneric(checkForPersonWithAccess(ccmn04ui, unitEmpLink.getUnit().getIdUnit(),
                                                              unitEmpLink.getCdUnitMemberRole()));
        } else {
          ccmn04uo.setBSysIndGeneric(ArchitectureConstants.N);
        }
      }
    } else {
      // Use the string 1 to represent true.
      ccmn04uo.setBSysIndGeneric(ArchitectureConstants.Y);
    }
    return ccmn04uo;
  }

  private String checkForPersonWithAccess(CCMN04UI ccmn04ui, int idUnit,
                                          String cdUnitMemberRole) {
    int[] ulIdPersons = ccmn04ui.getUlIdPerson_ARRAY_CCMN04UI().getUlIdPerson();
    for (int i = 0; i < ulIdPersons.length; i++) {
      Integer idPersonFromUnitEmpLink = unitEmpLinkDAO.findIdPersonFromUnitEmpLink(ulIdPersons[i], idUnit,
                                                                                   cdUnitMemberRole,
                                                                                   UNIT_MEMBER_ROLE_CLERK);
      if (idPersonFromUnitEmpLink != null && idPersonFromUnitEmpLink != 0) {
        // This means that we found someone who has the appropriate access; we are done.
        return ArchitectureConstants.Y;
      }
    }
    // No one had access; return false.
    return ArchitectureConstants.N;
  }
}
