package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveStaffList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveStaffListImpl extends BaseServiceImpl implements RetrieveStaffList {

  public static final String PERSON_PHONE_PRIMARY_TRUE = ArchitectureConstants.Y;

  private EmployeeDAO employeeDAO = null;
  private DynamicEmployeeDAO dynamicEmployeeDAO = null;
  private PersonPhoneDAO personPhoneDAO = null;

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setDynamicEmployeeDAO(DynamicEmployeeDAO dynamicEmployeeDAO) {
    this.dynamicEmployeeDAO = dynamicEmployeeDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public CCMN03SO retrieveStaffList(CCMN03SI ccmn03si) throws ServiceException {
    CCMN03SO ccmn03so = new CCMN03SO();
    ccmn03so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());
    // If StageID array is passed as InputMsg then call ccmnf9d
    int idStage = ccmn03si.getStageIdInStruct_ARRAY().getStageIdInStruct(0).getUlIdStage();
    if (idStage != 0) {
      // CallCCMNF9D
      ccmn03so = retrieveEmployees(ccmn03si.getStageIdInStruct_ARRAY(), ccmn03so,
                                   ccmn03si.getArchInputStruct().getUsPageNbr(),
                                   ccmn03si.getArchInputStruct().getUlPageSizeNbr());
    } else {
      // InputMsg is other than IdStages, retrieve staff list via ccmn50d

      // CallCCMN50D
      ccmn03so = findEmployee(ccmn03si.getStfSrchCrtInStruct(), ccmn03so, 
                              ccmn03si.getArchInputStruct().getUsPageNbr(), 
                              ccmn03si.getArchInputStruct().getUlPageSizeNbr());
    }
    // CallCCMNC3D - Retrieve Home Phone number
    int idPerson;
    ROWCCMN50DO_ARRAY rowccmn50do_array = ccmn03so.getROWCCMN50DO_ARRAY();
    ROWCCMN50DO rowccmn50do = new ROWCCMN50DO();
    // call the Service for each ID PERSON retrieved for the staff list
    for (Enumeration rowccmn59do_enum = rowccmn50do_array.enumerateROWCCMN50DO(); rowccmn59do_enum.hasMoreElements();) {
      rowccmn50do = (ROWCCMN50DO) rowccmn59do_enum.nextElement();
      idPerson = rowccmn50do.getUlIdPerson();
      // call ccmnc3d
      PersonPhone personPhone = personPhoneDAO.findPersonPhoneByIdPersonCdPersonPhoneTypeDtPersonPhoneEnd(idPerson,
                                                                                                          CodesTables.CPHNTYP_RS,
                                                                                                          DateHelper.MAX_JAVA_DATE);
      if (personPhone != null) {
        rowccmn50do.setLSysNbrPersPhnHome(personPhone.getNbrPersonPhone());
        // If PhoneExtension is null, reset the value to ""
        if ("null".equals(personPhone.getNbrPersonPhoneExtension()) || personPhone.getNbrPersonPhoneExtension() == null) {
          rowccmn50do.setLNbrPhoneExtension("");
        }
      }
      // Retrieve Work Phone number for the given IdPerson
      // ccmnc4d
      PersonPhone personWorkPhone = personPhoneDAO.findPersonPhoneAndOtherInfo(idPerson, CodesTables.CPHNTYP_BS,
                                                                               PERSON_PHONE_PRIMARY_TRUE,
                                                                               DateHelper.MAX_JAVA_DATE);
      if (personWorkPhone != null) {
        rowccmn50do.setLSysNbrPersPhoneWork(personWorkPhone.getNbrPersonPhone());
        if (personWorkPhone.getNbrPersonPhoneExtension() != null) {
          rowccmn50do.setLNbrPhoneExtension(personWorkPhone.getNbrPersonPhoneExtension());
        } else if("null".equals(personWorkPhone.getNbrPersonPhoneExtension()) || personWorkPhone.getNbrPersonPhoneExtension() == null) {
          // If PhoneExtension is null, reset the value to ""
          rowccmn50do.setLNbrPhoneExtension("");
        }
      }
    }
    return ccmn03so;
  }

  private CCMN03SO retrieveEmployees(StageIdInStruct_ARRAY stageIdInStruct, CCMN03SO ccmn03so, int pageNbr, int pageSize)
          throws ServiceException {
    // Retrieve a list of staff using a list of ID STAGES
    List<Integer> idStageList = new ArrayList<Integer>();

    for (int count = 0; count < stageIdInStruct.getStageIdInStructCount(); count++) {
      int idStage = stageIdInStruct.getStageIdInStruct(count).getUlIdStage();
      if (idStage != 0) {
        idStageList.add(idStage);
      }
    }

    // call ccmnf9d
    PaginatedHibernateList<Map> employeeList = employeeDAO.findEmployeeDetailsByStage(pageNbr, pageSize, idStageList);
    if (employeeList == null || employeeList.isEmpty()) {
      throw new ServiceException(Messages.MSG_CMN_SEARCH_NOT_FOUND);
    }
    ROWCCMN50DO_ARRAY rowccmn05do_array = new ROWCCMN50DO_ARRAY();
    for (Iterator<Map> it = employeeList.iterator(); it.hasNext();) {
      Map employeeMap = it.next();
      ROWCCMN50DO row = new ROWCCMN50DO();
      row.setSzNmPersonFull((String) employeeMap.get("nmPersonFull"));
      row.setSzCdUnitRegion((String) employeeMap.get("cdUnitRegion"));
      row.setSzNbrUnit((String) employeeMap.get("nbrUnit"));
      row.setSzCdEmployeeClass((String) employeeMap.get("cdEmployeeClass"));
      row.setSzBjnJob((String) employeeMap.get("cdJobBjn"));
      Integer idOffice = (Integer) employeeMap.get("idOffice");
      String officeId = idOffice.toString();
      if(officeId!=null){
      row.setSzNmOfficeName(Lookup.simpleDecodeSafe("COFCNM", officeId));
      }else{
        row.setSzNmOfficeName("");
      }
      // The following line throws a StackOverFlow error
      //String time = FormattingHelper.formatTime((Date) employeeMap.get("dtEmpLastAssigned"));
      //row.setTmScrTmEmpLastAssigned(time);
      row.setUlIdPerson((Integer) employeeMap.get("idPerson") != null ? (Integer) employeeMap.get("idPerson") : 0);
      row.setUlIdUnit((Integer) employeeMap.get("idUnit") != null ? (Integer) employeeMap.get("idUnit") : 0);
      Date dtEmpLastAssigned = (Date) employeeMap.get("dtEmpLastAssigned");
      row.setDtDtEmpLastAssigned(DateHelper.toCastorDate(dtEmpLastAssigned));
      row.setSzAddrMailCode((String) employeeMap.get("cdMailCode"));
      row.setSzCdEmpProgram((String) employeeMap.get("cdUnitProgram"));
      rowccmn05do_array.addROWCCMN50DO(row);
    }
    
    ArchOutputStruct aos = new ArchOutputStruct();
    aos.setBMoreDataInd(employeeList.getBMoreDataInd());
    
    ccmn03so.setArchOutputStruct(aos);    
    ccmn03so.setROWCCMN50DO_ARRAY(rowccmn05do_array);
    return ccmn03so;
  }

  private CCMN03SO findEmployee(StfSrchCrtInStruct stfSrchCrtInStruct, CCMN03SO ccmn03so, int pageNbr, int pageSize)
          throws ServiceException {
    // Retrieve a list of staff based on the search
    String nmNameLast = stfSrchCrtInStruct.getSzNmNameLast();
    String nmNameFirst = stfSrchCrtInStruct.getSzNmNameFirst();
    String nmNameMiddle = stfSrchCrtInStruct.getSzNmNameMiddle();
    String cdUnitRegion = stfSrchCrtInStruct.getSzCdUnitRegion();
    String nbrUnit = stfSrchCrtInStruct.getSzNbrUnit();
    String addrMailCodeCity = stfSrchCrtInStruct.getSzAddrMailCodeCity();
    String cdEmpSkill = stfSrchCrtInStruct.getSzCdEmpSkill();
    String cdUnitSpecialization = stfSrchCrtInStruct.getSzCdUnitSpecialization();
    String cdUnitProgram = stfSrchCrtInStruct.getSzCdUnitProgram();
    String cdOfficeCounty = stfSrchCrtInStruct.getSzCdOfficeCounty();
    String nbrPersonIdNumber = stfSrchCrtInStruct.getSzNbrPersonIdNumber();
    String indActive = stfSrchCrtInStruct.getCScrIndActive();
    int idPerson = stfSrchCrtInStruct.getUlIdPerson();
    String indJobAssignable = stfSrchCrtInStruct.getBIndJobAssignable();
    String addrMailCode = stfSrchCrtInStruct.getSzAddrMailCode();

    // call ccmn50d
    PaginatedHibernateList<Employee> result = dynamicEmployeeDAO.findEmployee(cdUnitProgram, cdUnitRegion,
                                                                              cdOfficeCounty,
                                                                              nmNameLast, nmNameFirst, nmNameMiddle,
                                                                              nbrPersonIdNumber, idPerson, indActive,
                                                                              indJobAssignable,
                                                                              nbrUnit, addrMailCodeCity,
                                                                              cdUnitSpecialization,
                                                                              cdEmpSkill, addrMailCode, pageNbr,
                                                                              pageSize);

    if (result == null && result.isEmpty()) {
      throw new ServiceException(Messages.MSG_CMN_SEARCH_NOT_FOUND);
    }
    ROWCCMN50DO_ARRAY rowccmn50do_array = new ROWCCMN50DO_ARRAY();
    for (Iterator<Employee> it = result.iterator(); it.hasNext();) {
      ROWCCMN50DO row = new ROWCCMN50DO();
      Employee employee = it.next();
      nmNameLast = employee.getNmEmployeeLast();
      nmNameFirst = employee.getNmEmployeeFirst();
      nmNameMiddle = employee.getNmEmployeeMiddle();
      String nmPersonFull = FormattingHelper.formatFullName(nmNameFirst, nmNameMiddle, nmNameLast);
      row.setSzNmPersonFull(nmPersonFull);
      cdUnitRegion = employee.getCdEmpUnitRegion();
      row.setSzCdUnitRegion(cdUnitRegion);
      nbrUnit = employee.getNbrEmpUnitEmpIn();
      row.setSzNbrUnit(nbrUnit);
      String cdEmployeeClass = employee.getCdEmployeeClass();
      row.setSzCdEmployeeClass(cdEmployeeClass);
      if (employee.getMailCode() != null) {
        addrMailCode = employee.getMailCode().getAddrMailCodeCounty();
        //.getCdMailCode();
      }
      row.setSzAddrMailCode(addrMailCode);
      String bjnJob = employee.getCdEmpBjnEmp();
      row.setSzBjnJob(bjnJob);
      String nmOfficeName = "";
      if (employee.getOffice() != null) {
        //String nmOfficeName = employee.getOffice().getNmOfficeName();
        nmOfficeName = Lookup.simpleDecodeSafe("COFCNM", employee.getOffice().getIdOffice().toString());
      }
      if(employee.getEmpJobHistory()!=null){
        row.setSzCdJobTitle(employee.getEmpJobHistory().getCdJobTitle());
      }
      row.setSzNmOfficeName(nmOfficeName);
      Date dtEmpLastAssigned = employee.getDtEmpLastAssigned();
      row.setTmScrTmEmpLastAssigned(FormattingHelper.formatTime(dtEmpLastAssigned));
      row.setDtDtEmpLastAssigned(DateHelper.toCastorDate(dtEmpLastAssigned));
      idPerson = employee.getIdPerson();
      row.setUlIdPerson(idPerson);
      Integer idUnit = 0;
      if(employee.getUnit()!= null){
      idUnit=employee.getUnit().getIdUnit();
      }
      row.setUlIdUnit(idUnit);
      cdUnitProgram = employee.getCdEmpProgram();
      row.setSzCdEmpProgram(cdUnitProgram);
      row.setSzCdUnitCounty(employee.getUnit().getCdCounty());
      rowccmn50do_array.addROWCCMN50DO(row);
    }
    
    ArchOutputStruct aos = new ArchOutputStruct();
    aos.setBMoreDataInd(result.getBMoreDataInd());
    
    ccmn03so.setArchOutputStruct(aos);
    ccmn03so.setROWCCMN50DO_ARRAY(rowccmn50do_array);
    return ccmn03so;
  }

}
