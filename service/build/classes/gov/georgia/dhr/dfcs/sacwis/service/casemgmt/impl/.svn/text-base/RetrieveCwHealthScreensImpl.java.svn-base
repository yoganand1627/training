//*  Service Class  Name:     RetrieveCwHealthScreensImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 12/06/2009
//*
//*  Description:Service Implementation for retrieving Case Watch health screens info.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/06/09  Patrick Coogan    Created file for ECEM Case Watch page
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ProfessionalAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ProfessionalAssmt;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwHealthScreens;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwHealthScreensSO;

public class RetrieveCwHealthScreensImpl extends BaseServiceImpl implements RetrieveCwHealthScreens {

  private ProfessionalAssmtDAO professionalAssmtDAO = null;
  
  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;
  
  private PersonDAO personDAO = null;
  
  public void setProfessionalAssmtDAO(ProfessionalAssmtDAO professionalAssmtDAO) {
    this.professionalAssmtDAO = professionalAssmtDAO;
  }
  
  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  @SuppressWarnings("unchecked")
  /**
   * retrieveCwHealthScreens retrieves all information necessary for displaying Health Screens data on the Case Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns CwHealthScreensSO object.
   */
  public CwHealthScreensSO retrieveCwHealthScreens(CaseWatchSI caseWatchSI) {

    CwHealthScreensSO cwHealthScreensSO = new CwHealthScreensSO();
    
    Integer idCase = caseWatchSI.getIdCase();
    Integer idPerson = caseWatchSI.getIdPerson();
   
    Integer ageAtRemoval = null;
    Integer currentAge = null;
    
    Date removalDate = cnsrvtrshpRemovalDAO.findLatestCnsrvtrshpRemovalDatetByIdCase(idCase, idPerson);
    Person child = personDAO.findPersonByIdPerson(idPerson);
    
    if ((removalDate!=null)&& ((child!=null ? child.getDtPersonBirth():null)!=null)){
      
      ageAtRemoval = DateHelper.getAge(child.getDtPersonBirth(),removalDate);
      currentAge = DateHelper.getAge(child.getDtPersonBirth());
    }
    
    //Get Date of Most Recent Screen: EPSDT or Medical Screen
    List<String> cdProfAssmtApptRsns = new ArrayList<String>();

    cdProfAssmtApptRsns.add(CodesTables.CARSAPPT_EPS);//EPSDT/GA Health Check
    cdProfAssmtApptRsns.add(CodesTables.CARSAPPT_MSC);//Medical Screen
    
    ProfessionalAssmt medical = professionalAssmtDAO.findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(idCase, idPerson,cdProfAssmtApptRsns);
    if (medical != null){
        cwHealthScreensSO.setDtMedical(medical.getDtProfAssmtAppt());
    } else {
        cwHealthScreensSO.setIndErrorMedical("W");
        cwHealthScreensSO.setIndOverallError("W");
    }

    //Get Date of Most Recent Psychological Screen
    cdProfAssmtApptRsns.clear();
    cdProfAssmtApptRsns.add(CodesTables.CARSAPPT_PHL);//Psychological
    ProfessionalAssmt psychological = professionalAssmtDAO.findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(idCase, idPerson,cdProfAssmtApptRsns);
    if (psychological != null){
        cwHealthScreensSO.setDtPsych(psychological.getDtProfAssmtAppt());
    } else if (currentAge>=4){
      cwHealthScreensSO.setIndErrorPsych("W");
      cwHealthScreensSO.setIndOverallError("W");
    }
    
    
    //Get Date of Most Recent Dental Screen
    cdProfAssmtApptRsns.clear();
    cdProfAssmtApptRsns.add(CodesTables.CARSAPPT_DSC);//Dental Screen
    cdProfAssmtApptRsns.add(CodesTables.CARSAPPT_DAA);//Dental Exam
    ProfessionalAssmt dental = professionalAssmtDAO.findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(idCase,idPerson,cdProfAssmtApptRsns);
    
    if (dental != null){
       cwHealthScreensSO.setDtDental(dental.getDtProfAssmtAppt());
    } else if (currentAge>=3){
      cwHealthScreensSO.setIndErrorDental("W");
      cwHealthScreensSO.setIndOverallError("W");
    }
    
    //Get Date of Most Recent Developmental Assessment
    cdProfAssmtApptRsns.clear();
    cdProfAssmtApptRsns.add(CodesTables.CARSAPPT_DEA);//Developmental Assessment
    ProfessionalAssmt developmental = professionalAssmtDAO.findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(idCase, idPerson,cdProfAssmtApptRsns);
    if (developmental != null){
        cwHealthScreensSO.setDtDevelopmental(developmental.getDtProfAssmtAppt());
    } else if (ageAtRemoval<=3){
      cwHealthScreensSO.setIndErrorDevelopmental("W");
      cwHealthScreensSO.setIndOverallError("W");
    }
    return cwHealthScreensSO;
  }

}
