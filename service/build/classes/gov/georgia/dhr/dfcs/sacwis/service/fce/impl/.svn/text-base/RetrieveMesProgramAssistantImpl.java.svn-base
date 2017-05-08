package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveMesProgramAssistant;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveMesProgramAssistantImpl extends BaseServiceImpl implements RetrieveMesProgramAssistant{
  // SMS #116335: ECEM 5.0 Updated hardcoded 100 to the constant variable  
  public static final int MAX_NUM_ATTRIBUTES = ArchitectureConstants.MAX_NUM_ATTRIBUTES;
  public static final String EFC = "EFC";
  private int[] rights;
  
 private StageDAO stageDAO = null;
  
  private UnitDAO unitDAO = null;
  
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  
  private EmpSecClassLinkDAO empSecClassLinkDAO = null;
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }
  
  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  public void setEmpSecClassLinkDAO(EmpSecClassLinkDAO empSecClassLinkDAO) {
    this.empSecClassLinkDAO = empSecClassLinkDAO;
  }

  public int retrieveMesProgramAssistant(int idStage, String securityAttribute){
    String cdStageRegion = retrieveStageRegionByStageId(idStage);
    if(cdStageRegion != null){
       if(cdStageRegion.length() == 1 ){
         cdStageRegion = "00" + cdStageRegion;
       } else if (cdStageRegion.length() == 2){
         cdStageRegion = "0" + cdStageRegion;
       }
    }
    int idPerson = 0;
    int idUnit = 0;
    boolean outOfLoop = false;
    List<Unit> unitList = retrieveIdUnitFromUnitByCdStageRegionAndCdSpecialization(cdStageRegion, EFC);
    for (Iterator<Unit> listIt = unitList.iterator(); listIt.hasNext();) {
      Unit unit = listIt.next();
      idUnit = unit.getIdUnit();
      List<Map> idPersonList = retrieveUnitEmpLinkByIdUnit(idUnit);
      for (Iterator<Map> mapIt = idPersonList.iterator(); mapIt.hasNext();) {
        Map mapCase = mapIt.next();
        idPerson = (Integer) mapCase.get("idPerson") != null ? Integer.parseInt(mapCase.get("idPerson").toString()) : 0;
        List<Map> securityProfileList = retrieveEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);
        for (Iterator<Map> mapSecIt = securityProfileList.iterator(); mapSecIt.hasNext();) {
          Map mapSecCase = mapSecIt.next();
          String txtSecurityAttrb  = (String) mapSecCase.get("txtSecurityClassProfil") != null ? (String) mapSecCase.get("txtSecurityClassProfil") : "";
          setRights(txtSecurityAttrb);
          if(hasRight(securityAttribute)){
            outOfLoop = true;
            break;
          }
        }
        if(outOfLoop){
          break;
        }
      }
      if(outOfLoop){
        break;
      }
    }
    if(outOfLoop){
      return idPerson;
    }else{
      return 0;
    }
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Map> retrieveUnitEmpLinkByIdUnit(int idUnit){
    List<Map> personMap = unitEmpLinkDAO.findUnitEmpLinkByIdUnit(idUnit);
    return personMap;
  }
  
  public List<Map> retrieveEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(int idPerson){
    List<Map> securityMap = empSecClassLinkDAO.findEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);
    return securityMap;
  }
  
  public String retrieveStageRegionByStageId(int idStage){
    Stage stage = stageDAO.findStageByIdStage(idStage);
    return stage.getCdStageRegion();
  }
  
  public List<Unit> retrieveIdUnitFromUnitByCdStageRegionAndCdSpecialization(String cdStageRegion, String efc){
    List<Unit> unitList = unitDAO.findUnitByCdRegionAndCdUnitSpecialization(cdStageRegion, efc) ;
    return unitList;
  }
  
  /**
   * This method returns a boolean value indicating whether or not the user has the right that was passed in.
   * 
   * @param securityAttribute
   *          The right to check for on the user
   * @return boolean Whether or not the user has the right
   */
  public boolean hasRight(String securityAttribute) {
    try {
      int secAtt = Integer.parseInt(securityAttribute);
      return hasRight(secAtt);
    } catch (NullPointerException npe) {
      return false;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  /**
   * This method returns a boolean value indicating whether or not the user has the right that was passed in.
   * 
   * @param securityAttribute
   *          The right to check for on the user
   * @return boolean Whether or not the user has the right
   */
  public boolean hasRight(int securityAttribute) {
    int[] userRights = this.getRights();
    if (userRights[securityAttribute] == 1) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * This method allows a developer to assign rights to a user. This can only occur once, when the user is first
   * created.
   * 
   * @param rights
   *          A set of rights for the user.
   */
  public void setRights(String rights) {
    // A.Corley - increased hardcoded size to 100 to match the length of the
    // TXT_SECURITY_CLASS_PROFIL column on the SECURITY_CLASS table
    int[] userRights = new int[MAX_NUM_ATTRIBUTES];
    char[] rightsArray = rights.toCharArray();

    for (int x = 0; x < rightsArray.length; x++) {
      // userRights[x]= Integer.parseInt(rightsArray[x]);
      if (rightsArray[x] == '1') {
        userRights[x] = 1;
      } else {
        userRights[x] = 0;
      }
    }

    this.rights = userRights;
  }
  
  /**
   * This method returns the rights
   * 
   * @return The rights for the user
   */
  public int[] getRights() {
    return this.rights;
  }
}
