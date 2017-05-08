package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.common.IsUserDeputyPolicyCountyDrt;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 09/12/2011   charden           STGAP00017058 - added hasSecurityClass() method
 *
 */
public class IsUserDeputyPolicyCountyDrtImpl extends BaseServiceImpl implements IsUserDeputyPolicyCountyDrt {
  //security class name for Deputy Director.
  private static final String DEPUTY_DIRECTOR_SEC_CLASS = "DEPUTY_DIRECTOR";
  //security class name for Policy Unit employee
  private static final String POLICY_UNIT_SEC_CLASS = "STATE_CONC";
  //Security Class name for State Office Resource Developer
  private static final String STATE_OFFICE_RESOURCE_DEVELOPER_SEC_CLASS = "ORS_PRU MAINT";
  //Unit number for State County Director.
  private static final String NBR_UNIT_COUNTY_DIRECTOR = "18";
  
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  private EmployeeDAO employeeDAO = null;
  private StageDAO stageDAO = null;
  private UnitDAO unitDAO = null;
  
  private String stageCounty = "";
  private String stageRegion = "";
  
  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }
    
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  public boolean isUserDeputyPolicyCountyDrt(int idPerson, int idStage ){
    boolean isUserDeputyPolicyCountyDrt = false;
    if(isUserDeputyDirector(idPerson) || isUserPolicyUnit(idPerson) || isUserCountyDirector(idPerson, idStage)) {
      isUserDeputyPolicyCountyDrt = true;
    }
    
    return isUserDeputyPolicyCountyDrt;
    
  }
  
  public boolean isUserDeputyDirector(int idPerson){
    return hasSecurityClass(idPerson,DEPUTY_DIRECTOR_SEC_CLASS);
  }
  
  public boolean  isUserPolicyUnit(int idPerson){
    return hasSecurityClass(idPerson,POLICY_UNIT_SEC_CLASS);
    
  }
  
  public boolean  isUserCountyDirector(int idPerson, int idStage){
    boolean isUserCountyDirector = false;
    if (idPerson == getCountyDirector(idStage, NBR_UNIT_COUNTY_DIRECTOR)) {
      isUserCountyDirector = true;
      
    }
    return isUserCountyDirector;
  }
  
  /**
   * This method finds and returns the list of employee ids for State Office Resource Developer.
   */
  public List<Integer> getStateOfficeResourceDeveloperList() {
    List<Integer> empList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(STATE_OFFICE_RESOURCE_DEVELOPER_SEC_CLASS);
    return empList;
    
  }
  /**
   * This method retrieves the County Director's Id for the given county.
   * The unit number for the county director is always 18.
   * There is always only one county director for a county.
   * @param idStage
   * @param unitNumber
   * @return
   */
  public Integer getCountyDirector(int idStage, String unitNumber){
    Integer idCountyDirector = null;
    //get county for this stage.
    this.stageCounty = getCountyForStage(idStage);
    
    //get the county director record for unit # 18 for this county and region.
    Unit unit = unitDAO.findUnitFullRowByCdCountyCdUnitRegionNbrUnit(stageCounty, getRegionForCounty(stageCounty), unitNumber);
    if(unit != null) {
      idCountyDirector = unit.getPerson().getIdPerson();
    }
        return idCountyDirector != null ? idCountyDirector : 0;
  }
  
  //STGAP00017058
  /**
   * This method checks if the logged in person has the assigned Security Class
   * @param idPerson
   * @param securityClassName
   * @return
   */
  public boolean hasSecurityClass(int idPerson, String securityClassName) {
    boolean hasSecClass = false;
    List<Integer> empList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(securityClassName);
    if (empList != null && !empList.isEmpty()) {
      for (Iterator <Integer> it = empList.iterator(); it.hasNext();) {
        if(idPerson == it.next().intValue() ) {
          hasSecClass = true;
          break;
        }
      }
    }
    return hasSecClass;
 }
 // end STGAP00017058
  /**
   * This method gets the list of employee ids for a perticular Security profile.
   * @param securityClassName
   * @return
   */
  private List<Integer> getEmployeeListBySecurityClass(String securityClassName){
    List<Integer> empList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(securityClassName);
    return empList;
  }
  /**
   * This method checks if logged in person has assigned security role
   * @param idPerson
   * @param county
   * @param securityRole
   * @return
   */
  private boolean hasSecurityRole(int idPerson, String county, String securityRole) {
    boolean hasSecRole = false;
    ArrayList<String> jobList = new ArrayList<String>();
    //jobList.add(COUNTY_DIRECTOR_SEC_ROLE);
    jobList.add(securityRole);
    List<Integer> empList = employeeDAO.findIdPersonByJobSecurityRole(county, jobList);
    if (empList != null && !empList.isEmpty()) {
      for (Iterator <Integer> it = empList.iterator(); it.hasNext();) {
        if(idPerson == it.next().intValue() ) {
          hasSecRole = true;
          break;
        }
      }
    }
    return hasSecRole;
 }
  
  /**
   * This method retrieves the stage county for a given stage.
   * @param idStage
   * @return
   */
  private String getCountyForStage(int idStage){
    String stageCounty ="";
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if(stage != null) {
      stageCounty =  stage.getCdStageCnty();
    }
    return stageCounty;
  }
/**
 * This method gets the region for a given county
 * @param county
 * @return
 */
  private String getRegionForCounty(String county){
  //get region for this county.
    return this.stageRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, county);
  }
  
}
