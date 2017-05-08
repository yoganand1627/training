package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.UnitAccess;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveUnitDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG02;

public class RetrieveUnitDetailImpl extends BaseServiceImpl implements RetrieveUnitDetail {

  private UnitAccess unitAccess = null;

  private UnitDAO unitDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  public void setUnitAccess(UnitAccess unitAccess) {
    this.unitAccess = unitAccess;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public CCMN23SO findUnitEmployees(CCMN23SI ccmn23si) throws ServiceException {
    CCMN23SO ccmn23so = new CCMN23SO();

    ROWCCMN23SOG02 rowCcmn23SoGo2 = new ROWCCMN23SOG02();
    rowCcmn23SoGo2 = findCcmnd0d(ccmn23si);
    ccmn23so.setROWCCMN23SOG02(rowCcmn23SoGo2);

    // Check the existance of a unit Approver
    if (rowCcmn23SoGo2.getUlIdPerson() != 0) {

      // Determine whether or not a user has access to a unit in inquiry
      // or modify mode by calling the UnitAccess() common function

      CCMN04UI ccmn04ui = new CCMN04UI();
      CCMN04UO ccmn04uo = new CCMN04UO();
      ccmn04ui.setUlIdUnit(ccmn23so.getROWCCMN23SOG02().getUlIdUnit());

      // Check for unit access
      UlIdPerson_ARRAY_CCMN04UI ulIdPerson_array_ccmn04ui = new UlIdPerson_ARRAY_CCMN04UI();
      ulIdPerson_array_ccmn04ui.setUlIdPerson(ccmn23si.getUlIdPerson_ARRAY_CCMN23SI().getUlIdPerson());
      ccmn04ui.setUlIdPerson_ARRAY_CCMN04UI(ulIdPerson_array_ccmn04ui);

      unitAccess.checkForPersonWithUnitAccess(ccmn04ui);

      if (ArchitectureConstants.Y.equals(ccmn04uo.getBSysIndGeneric())) {
        ccmn23so.getROWCCMN23SOG02().setSzSysCdWinMode(PageModeConstants.MODIFY);
      } else {
        ccmn23so.getROWCCMN23SOG02().setSzSysCdWinMode(PageModeConstants.INQUIRE);
      }

      ROWCCMN23SOG01_ARRAY rowCcmn23SoGo1_Array = new ROWCCMN23SOG01_ARRAY();

      rowCcmn23SoGo1_Array = findCcmn36d(ccmn23si);
      
      ccmn23so.setROWCCMN23SOG01_ARRAY(rowCcmn23SoGo1_Array);
    }

    return ccmn23so;
  }

  private ROWCCMN23SOG02 findCcmnd0d(CCMN23SI ccmn23si) throws ServiceException {

    Unit unit = unitDAO.findUnitFromUnitAndParentUnitByIdUnit(ccmn23si.getUlIdUnit());

    if (unit == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    ROWCCMN23SOG02 rowCcmn23SoGo2 = new ROWCCMN23SOG02();

    rowCcmn23SoGo2.setUlIdUnit(unit.getIdUnit() != null ? unit.getIdUnit() : 0);
    if(unit.getPerson() != null){
      rowCcmn23SoGo2.setUlIdPerson(unit.getPerson().getIdPerson() != null ? unit.getPerson().getIdPerson() : 0);
    }else{
      rowCcmn23SoGo2.setUlIdPerson(0);
    }
    if(unit.getUnit() != null){
      rowCcmn23SoGo2.setUlIdUnitParent(unit.getUnit().getIdUnit() != null ? unit.getUnit().getIdUnit() : 0);
      rowCcmn23SoGo2.setSzCdParentUnitCounty(unit.getUnit().getCdCounty());
      rowCcmn23SoGo2.setSzCdParentUnitRegion(unit.getUnit().getCdUnitRegion());
      rowCcmn23SoGo2.setSzNbrParentUnit(unit.getUnit().getNbrUnit());
    }else{
      rowCcmn23SoGo2.setUlIdUnitParent(0);
      rowCcmn23SoGo2.setSzCdParentUnitCounty("");
      rowCcmn23SoGo2.setSzCdParentUnitRegion("");
      rowCcmn23SoGo2.setSzNbrParentUnit("");
    }
    rowCcmn23SoGo2.setSzCdUnitCounty(unit.getCdCounty());
    rowCcmn23SoGo2.setSzCdUnitRegion(unit.getCdUnitRegion());
    rowCcmn23SoGo2.setSzNbrUnit(unit.getNbrUnit());
    rowCcmn23SoGo2.setSzCdUnitSpecialization(unit.getCdUnitSpecialization());
    rowCcmn23SoGo2.setTsLastUpdate(unit.getDtLastUpdate());

    return rowCcmn23SoGo2;
  }

  private ROWCCMN23SOG01_ARRAY findCcmn36d(CCMN23SI ccmn23si) throws ServiceException {

    ROWCCMN23SOG01_ARRAY rowCcmn23SoGo1_Array = new ROWCCMN23SOG01_ARRAY();

    //List<Map> unitEmployees = unitEmpLinkDAO.findAllEmployeeUnitEmpLinkByIdUnit(ccmn23si.getUlIdUnit());
    List<Map> unitEmployees = unitEmpLinkDAO.findAllEmployeeUnitEmpLinkAndActiveEmployeeByIdUnit(ccmn23si.getUlIdUnit());

    //if (unitEmployees == null || unitEmployees.size() == 0) {
    //  throw new ServiceException(Messages.SQL_NOT_FOUND);
    //}
    
    if(unitEmployees != null && !unitEmployees.isEmpty()) {
      for (Iterator<Map> it = unitEmployees.iterator(); it.hasNext();) {
        Map unitEmployeesMap = it.next();
        ROWCCMN23SOG01 rowCcmn23SoGo1 = new ROWCCMN23SOG01();
  
        rowCcmn23SoGo1.setSzNmPersonFull((String) unitEmployeesMap.get("nmPersonFull"));
        rowCcmn23SoGo1.setSzCdUnitMemberRole((String) unitEmployeesMap.get("cdUnitMemberRole"));
        rowCcmn23SoGo1.setSzCdUnitMemberInOut((String) unitEmployeesMap.get("cdUnitMemberInOut"));
        rowCcmn23SoGo1.setSzBjnJob((String) unitEmployeesMap.get("cdJobBjn"));
        rowCcmn23SoGo1
                      .setUlIdPerson((Integer) unitEmployeesMap.get("idPerson") != null ? (Integer) unitEmployeesMap
                                                                                                                    .get("idPerson")
                                                                                       : 0);
        rowCcmn23SoGo1
                      .setUlIdUnitEmpLink((Integer) unitEmployeesMap.get("idUnitEmpLink") != null ? (Integer) unitEmployeesMap
                                                                                                                              .get("idUnitEmpLink")
                                                                                                 : 0);
        rowCcmn23SoGo1.setTsLastUpdate((Date) unitEmployeesMap.get("dtLastUpdate"));
        rowCcmn23SoGo1_Array.addROWCCMN23SOG01(rowCcmn23SoGo1);
  
      }
    }

    return rowCcmn23SoGo1_Array;
  }

}
