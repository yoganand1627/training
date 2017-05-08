package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpOnCallLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpOnCallLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveOnCallDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO_ARRAY;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RetrieveOnCallDetailImpl extends BaseServiceImpl implements RetrieveOnCallDetail {

  private EmpOnCallLinkDAO empOnCallLinkDAO = null;
  private PersonPhoneDAO personPhoneDAO = null;

  public void setEmpOnCallLinkDAO(EmpOnCallLinkDAO empOnCallLinkDAO) {
    this.empOnCallLinkDAO = empOnCallLinkDAO;
  }
  
  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public CCMN09SO findEmpOnCallInfo(CCMN09SI ccmn09si) throws ServiceException {
    CCMN09SO ccmn09so = new CCMN09SO();
    ROWCCMN21DO_ARRAY rowccmn21do_array = new ROWCCMN21DO_ARRAY();
    
    List<Integer> employeeIdsFromResults = new ArrayList<Integer>();
    List<EmpOnCallLink> empOnCallLinks = empOnCallLinkDAO.findEmpOnCallLinkListByIdOnCall(ccmn09si.getROWCCMN21DI().getUlIdOnCall());
    for(Iterator<EmpOnCallLink> it = empOnCallLinks.iterator(); it.hasNext();){
      EmpOnCallLink empOnCallLink = it.next();
      Integer idPerson = empOnCallLink.getPerson().getIdPerson();
      if(idPerson != null && !employeeIdsFromResults.contains(idPerson)){
        //-- keep track of who we've added; only add same person once
        employeeIdsFromResults.add(idPerson);
        
        ROWCCMN21DO rowccmn21do = new ROWCCMN21DO();
        rowccmn21do.setUlIdPerson(idPerson);
        rowccmn21do.setSzNmPersonFull(empOnCallLink.getPerson().getNmPersonFull());
        rowccmn21do.setUsNbrEmpOnCallCntctOrd(empOnCallLink.getNbrEmpOnCallCntctOrd());
        rowccmn21do.setSzCdEmpOnCallDesig(empOnCallLink.getCdEmpOnCallDesig());
        rowccmn21do.setSzNbrEmpOnCallPhone1(empOnCallLink.getNbrEmpOnCallPhone1());
        rowccmn21do.setLNbrEmpOnCallExt1(empOnCallLink.getNbrEmpOnCallExt1());
        rowccmn21do.setSzNbrEmpOnCallPhone2(empOnCallLink.getNbrEmpOnCallPhone2());
        rowccmn21do.setLNbrEmpOnCallExt2(empOnCallLink.getNbrEmpOnCallExt2());
        rowccmn21do.setSzCdTitle(empOnCallLink.getCdTitle());
        rowccmn21do.setSzCdOnCallProgram(empOnCallLink.getCdPrgmCvrg());
        rowccmn21do.setUlIdEmpOnCallLink(empOnCallLink.getIdEmpOnCallLink());
        rowccmn21do.setUlIdOnCall(empOnCallLink.getOnCall().getIdOnCall());
        rowccmn21do.setTsLastUpdate(empOnCallLink.getDtLastUpdate());
        
        //-- add call to find PersonPhone entry of type Residence ("RS")
        String nbrPersonPhone = personPhoneDAO.findNbrPersonPhoneByIdPersonAndPhoneType(idPerson, CodesTables.CPHNTYP_RS);
        if(nbrPersonPhone != null && !"".equals(nbrPersonPhone)){
          rowccmn21do.setLNbrPhone(nbrPersonPhone);
        }
        
        rowccmn21do_array.addROWCCMN21DO(rowccmn21do);
      }
    }
    
    rowccmn21do_array.setUlRowQty(rowccmn21do_array.getROWCCMN21DO().length);
    ccmn09so.setROWCCMN21DO_ARRAY(rowccmn21do_array);
    
    /*
    List<Integer> employeeIdsFromResults = new ArrayList<Integer>();
    List<Map> empOnCallLinkInfoList = empOnCallLinkDAO.findEmpOnCallLinkByIdOnCall(ccmn09si.getROWCCMN21DI().getUlIdOnCall(), 
                                                                                   DateHelper.MAX_JAVA_DATE);
    if (empOnCallLinkInfoList == null || empOnCallLinkInfoList.size() <= 0) {
      throw new ServiceException(Messages.MSG_ERR_ON_RETURN);
    }

    ROWCCMN21DO_ARRAY rowccmn21do_array = new ROWCCMN21DO_ARRAY();
    for (Iterator<Map> it = empOnCallLinkInfoList.iterator(); it.hasNext();) {
      Map empOnCallLinkInfo = it.next();
      ROWCCMN21DO rowccmn21do = new ROWCCMN21DO();
      
      Integer idPerson = (Integer) empOnCallLinkInfo.get("idPerson");
      String phoneType = (String) empOnCallLinkInfo.get("cdPersonPhoneType");
      if(idPerson != null && !employeeIdsFromResults.contains(idPerson)) { // &&
         //(CodesTables.CPHNTYP_RS.equals(phoneType) || phoneType == null)){
        
        //-- keep track of who we've added; only add same person once
        employeeIdsFromResults.add(idPerson);
        
        rowccmn21do.setUlIdPerson(idPerson);
        rowccmn21do.setSzNmPersonFull((String) empOnCallLinkInfo.get("nmPersonFull"));
        rowccmn21do.setLNbrPhone((String) empOnCallLinkInfo.get("nbrPersonPhone"));
        rowccmn21do.setUsNbrEmpOnCallCntctOrd((Integer) empOnCallLinkInfo.get("nbrEmpOnCallCntctOrd") != null ? 
          (Integer) empOnCallLinkInfo.get("nbrEmpOnCallCntctOrd") : 0);
        rowccmn21do.setSzCdEmpOnCallDesig((String) empOnCallLinkInfo.get("cdEmpOnCallDesig"));
        rowccmn21do.setSzNbrEmpOnCallPhone1((String) empOnCallLinkInfo.get("nbrEmpOnCallPhone1"));
        rowccmn21do.setLNbrEmpOnCallExt1((String) empOnCallLinkInfo.get("nbrEmpOnCallExt1"));
        rowccmn21do.setSzNbrEmpOnCallPhone2((String) empOnCallLinkInfo.get("nbrEmpOnCallPhone2"));
        rowccmn21do.setLNbrEmpOnCallExt2((String) empOnCallLinkInfo.get("nbrEmpOnCallExt2"));
        rowccmn21do.setSzCdTitle((String) empOnCallLinkInfo.get("SzCdTitle"));
        rowccmn21do.setSzCdOnCallProgram((String) empOnCallLinkInfo.get("SzCdOnCallProgram"));
        rowccmn21do.setUlIdEmpOnCallLink((Integer) empOnCallLinkInfo.get("idEmpOnCallLink") != null ? 
          (Integer) empOnCallLinkInfo.get("idEmpOnCallLink") : 0);
        rowccmn21do.setUlIdOnCall((Integer) empOnCallLinkInfo.get("idOnCall") != null ?
          (Integer) empOnCallLinkInfo.get("idOnCall") : 0);
        rowccmn21do.setTsLastUpdate((Date) empOnCallLinkInfo.get("dtLastUpdate"));
        rowccmn21do_array.addROWCCMN21DO(rowccmn21do);
      }
    }
    rowccmn21do_array.setUlRowQty(rowccmn21do_array.getROWCCMN21DO().length);
    ccmn09so.setROWCCMN21DO_ARRAY(rowccmn21do_array);
    */
    return ccmn09so;
  }
}
