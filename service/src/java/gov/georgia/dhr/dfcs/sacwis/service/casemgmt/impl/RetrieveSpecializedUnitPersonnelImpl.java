package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveSpecializedUnitPersonnel;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecializedUnitPersonalBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveSpecializedUnitPersonnelImpl extends BaseServiceImpl implements RetrieveSpecializedUnitPersonnel {
  //SMS #116335: ECEM 5.0 Updated hardcoded 100 to the constant variable
  public static final int MAX_NUM_ATTRIBUTES = ArchitectureConstants.MAX_NUM_ATTRIBUTES;

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

  public List<Integer> retrieveSpecializedUnitPersonnel(SpecializedUnitPersonalBean spUnitPsnlBean) {
    int idStage = spUnitPsnlBean.getIdStage();
    String specialization = spUnitPsnlBean.getSpecialization();
    String securityAttribute = spUnitPsnlBean.getSecurityAttribute();
    String cdCounty = spUnitPsnlBean.getCdCounty();
    boolean isRAC = spUnitPsnlBean.isRAC();
    String cdStageRegion = "";
    if ("ADO".equals(specialization)) {
      return retrieveAdoptionUnitPersonnel(idStage, securityAttribute, isRAC);
    } else if(cdCounty != null && !"".equals(cdCounty)){
      
      if (cdCounty != null && !"".equals(cdCounty)) {
        cdStageRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
        isRAC = true;
      } 
      return retrieveUnitPersonnelByCounty(cdStageRegion, securityAttribute, specialization, isRAC);
    }else{
      cdStageRegion = retrieveStageRegionByStageId(idStage);
      return retrieveUnitPersonnel(idStage, securityAttribute, specialization, isRAC);
    }
  }

  // to be repalced by the more general call below
  @SuppressWarnings( { "unchecked" })
  private List<Integer> retrieveAdoptionUnitPersonnel(int idStage, String securityAttribute, boolean isRAC) {
    List<Integer> adoRegionalPersonnel;
    String cdStageRegion = retrieveStageRegionByStageId(idStage);
    cdStageRegion = "0" + cdStageRegion; // 4/12/07 - there is only 17 regions
    List adoUnitList = retrieveUnits(cdStageRegion, "ADO", isRAC);
    if (adoUnitList != null && adoUnitList.size() != 0) {
      adoRegionalPersonnel = new ArrayList<Integer>();
      for (Iterator<Unit> adoUnitListItr = adoUnitList.iterator(); adoUnitListItr.hasNext();) {
        int idUnit = ((Unit) adoUnitListItr.next()).getIdUnit();
        int idPerson = 0;
        boolean outOfLoop = false;
        String secAsStr = null;
        List<Map> idPersonList = retrieveUnitEmpLinkByIdUnit(idUnit);
        for (Iterator<Map> mapIt = idPersonList.iterator(); mapIt.hasNext();) {
          Map mapCase = mapIt.next();
          idPerson = (Integer) mapCase.get("idPerson") != null ? Integer.parseInt(mapCase.get("idPerson").toString())
                                                              : 0;
          List<Map> securityProfileList = retrieveEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);
          for (Iterator<Map> mapSecIt = securityProfileList.iterator(); mapSecIt.hasNext();) { // iterate through
                                                                                                // attribute string of
                                                                                                // bits
            Map mapSecCase = mapSecIt.next();
            String txtSecurityAttrb = (String) mapSecCase.get("txtSecurityClassProfil") != null ? (String) mapSecCase
                                                                                                                     .get("txtSecurityClassProfil")
                                                                                               : "";
            setRights(txtSecurityAttrb);
            if (hasRight(securityAttribute)) { // needed attribute bit found on attribute string of bits so break out
              outOfLoop = true;
              adoRegionalPersonnel.add(idPerson);
              break;
            }
          }
          if (outOfLoop && isRAC) {
            break; // only one regional role per unit
          }
        }
      }
      return adoRegionalPersonnel;
    } else {
      return null;
    }
  }
  //to be repalced by the more general call. This is defined for the spcific case for Placement where the county is passed 
  @SuppressWarnings( { "unchecked" })
  private List<Integer> retrieveUnitPersonnelByCounty(String cdStageRegion, String securityAttribute, String specialization,
                                              boolean isRegional) {
    // List<Integer> adoRegionalPersonnel;
    List<Integer> unitPersonnel;
    //String cdStageRegion = retrieveStageRegionByStageId(idStage);
    cdStageRegion = "0" + cdStageRegion; // 4/12/07 - there is only 17 regions
    List specUnitList = retrieveUnits(cdStageRegion, specialization, isRegional);
    if (specUnitList != null && specUnitList.size() != 0) {
      unitPersonnel = new ArrayList<Integer>();
      for (Iterator<Unit> specUnitListItr = specUnitList.iterator(); specUnitListItr.hasNext();) {
        int idUnit = ((Unit) specUnitListItr.next()).getIdUnit();
        int idPerson = 0;
        List<Map> idPersonList = retrieveUnitEmpLinkByIdUnit(idUnit);
        for (Iterator<Map> mapIt = idPersonList.iterator(); mapIt.hasNext();) {
          Map mapCase = mapIt.next();
          idPerson = (Integer) mapCase.get("idPerson") != null ? Integer.parseInt(mapCase.get("idPerson").toString())
                                                              : 0;
          List<Map> securityProfileList = retrieveEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);
          for (Iterator<Map> mapSecIt = securityProfileList.iterator(); mapSecIt.hasNext();) { // iterate through
                                                                                                // attribute string of
                                                                                                // bits
            Map mapSecCase = mapSecIt.next();
            String txtSecurityAttrb = (String) mapSecCase.get("txtSecurityClassProfil") != null ? (String) mapSecCase
                                                                                                                     .get("txtSecurityClassProfil")
                                                                                               : "";
            setRights(txtSecurityAttrb);
            if (hasRight(securityAttribute)) { // needed attribute bit found on attribute string of bits so break out
              unitPersonnel.add(idPerson);
              break;
            }
          }
         }
      }
      return unitPersonnel;
    } else {
      return null;
    }
  }

  public boolean hasRightByIdPerson(int idPerson, String securityAttribute) {
    List<Map> securityProfileList = retrieveEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);
    for (Iterator<Map> mapSecIt = securityProfileList.iterator(); mapSecIt.hasNext();) { // iterate through attribute
                                                                                          // string of bits
      Map mapSecCase = mapSecIt.next();
      String txtSecurityAttrb = (String) mapSecCase.get("txtSecurityClassProfil") != null ? (String) mapSecCase
                                                                                                               .get("txtSecurityClassProfil")
                                                                                         : "";
      setRights(txtSecurityAttrb);
      if (hasRight(securityAttribute)) { // needed attribute bit found on attribute string of bits so break out
        return true;
      }
    }
    return false;
  }

  /**
   * To retrieve all ppl in a unit with given specialization and share the same security attribute. However, if that is
   * a regional role then there only one person so stop when find one. This should be the main and only method to
   * retrieve a unit personnel given its specialization and other conditions. Keeping the
   * 'retrieveAdoptionUnitPersonnel' until there is finalization about security attribute for RAC and SAU to see if its
   * code still fits in with the general code or change needs to be made
   * 
   * @param idStage
   * @param securityAttribute
   * @param specialization
   * @param isRAC
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  private List<Integer> retrieveUnitPersonnel(int idStage, String securityAttribute, String specialization,
                                              boolean isRegional) {
    // List<Integer> adoRegionalPersonnel;
    List<Integer> unitPersonnel;
    String cdStageRegion = retrieveStageRegionByStageId(idStage);
    cdStageRegion = "0" + cdStageRegion; // 4/12/07 - there is only 17 regions
    List specUnitList = retrieveUnits(cdStageRegion, specialization, isRegional);
    if (specUnitList != null && specUnitList.size() != 0) {
      unitPersonnel = new ArrayList<Integer>();
      for (Iterator<Unit> specUnitListItr = specUnitList.iterator(); specUnitListItr.hasNext();) {
        int idUnit = ((Unit) specUnitListItr.next()).getIdUnit();
        int idPerson = 0;
        boolean outOfLoop = false;
        List<Map> idPersonList = retrieveUnitEmpLinkByIdUnit(idUnit);
        for (Iterator<Map> mapIt = idPersonList.iterator(); mapIt.hasNext();) {
          Map mapCase = mapIt.next();
          idPerson = (Integer) mapCase.get("idPerson") != null ? Integer.parseInt(mapCase.get("idPerson").toString())
                                                              : 0;
          List<Map> securityProfileList = retrieveEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);
          for (Iterator<Map> mapSecIt = securityProfileList.iterator(); mapSecIt.hasNext();) { // iterate through
                                                                                                // attribute string of
                                                                                                // bits
            Map mapSecCase = mapSecIt.next();
            String txtSecurityAttrb = (String) mapSecCase.get("txtSecurityClassProfil") != null ? (String) mapSecCase
                                                                                                                     .get("txtSecurityClassProfil")
                                                                                               : "";
            setRights(txtSecurityAttrb);
            if (hasRight(securityAttribute)) { // needed attribute bit found on attribute string of bits so break out
              outOfLoop = true;
              unitPersonnel.add(idPerson);
              break;
            }
          }
          if (outOfLoop && isRegional) {
            break; // only one regional role per unit
          }
        }
      }
      return unitPersonnel;
    } else {
      return null;
    }
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> retrieveUnitEmpLinkByIdUnit(int idUnit) {
    List<Map> personMap = unitEmpLinkDAO.findUnitEmpLinkByIdUnit(idUnit);
    return personMap;
  }

  public List<Map> retrieveEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(int idPerson) {
    List<Map> securityMap = empSecClassLinkDAO
                                              .findEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);
    return securityMap;
  }

  public String retrieveStageCountyByStageId(int idStage) {
    Stage stage = stageDAO.findStageByIdStage(idStage);
    return stage.getCdStageCnty();
  }

  public String retrieveStageRegionByStageId(int idStage) {
    Stage stage = stageDAO.findStageByIdStage(idStage);
    return stage.getCdStageRegion();
  }

  public int retrieveIdUnitFromUnitByCdStageCntyAndCdSpecialization(String cdStageCounty) {
    int idUnit = 0;// unitDAO.findIdUnitFromUnitByCdStageCntyAndCdSpecialization(cdStageCounty) != null ?
    // Integer.parseInt(unitDAO.findIdUnitFromUnitByCdStageCntyAndCdSpecialization(cdStageCounty).toString()) : 0;
    return idUnit;
  }

  public List<Unit> retrieveUnits(String cdStageRegion, String spec, boolean isRegional) {
    if (isRegional) {
      return unitDAO.findUnitByCdRegionAndCdUnitSpecialization(cdStageRegion, spec);
    } else {
      return unitDAO.findUnitByCdUnitSpecialization(spec);
    }
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
