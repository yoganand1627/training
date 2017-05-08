package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.NonIncidentAFCARSInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.NonIncidentAfcarsInfo;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.SaveNonIncidentAFCARSInformation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonIncidentAFCARSInformationSI;

/**
 * The SaveNonIncidentAFCARSInformationImpl class is the service for saving the 
 * Non-Incident AFCARS Information page.
 * 
 * @see gov.georgia.dhr.dfcs.sacwis.service.adoexchange.SaveNonIncidentAFCARSInformation
 * 
 * @author Stephen Roberts, October 1, 2008
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * 02/04/09    wjcochran                 STGAP00012148: Added Mother Married at Birth info
 * 02/26/09    wjcochran                 STGAP00012148: Removed Mother Married at Birth info
 *                                       since the information is only saved from the Citizenship
 *                                       and Identity page
 * </PRE>
 */

public class SaveNonIncidentAFCARSInformationImpl extends BaseServiceImpl implements SaveNonIncidentAFCARSInformation {

  private NonIncidentAFCARSInfoDAO nonIncidentAFCARSInfoDAO;
  
  public void setNonIncidentAFCARSInfoDAO(NonIncidentAFCARSInfoDAO nonIncidentAFCARSInfoDAO) {
    this.nonIncidentAFCARSInfoDAO = nonIncidentAFCARSInfoDAO;
  }

  public void saveNonIncidentAFCARSInformation(NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI) {

    NonIncidentAfcarsInfo nonIncidentAfcarsInfo = populateNonIncidentAfcarsInfo(nonIncidentAFCARSInformationSI);
    nonIncidentAFCARSInfoDAO.saveNonIncidentAFCARSInfo(nonIncidentAfcarsInfo);
  }

  /**
   * Populates the service input bean into the hibernate bean for saving.
   * 
   * @param nonIncidentAFCARSInformationSI
   * @param nonIncidentAFCARSInformationSO
   * @param nonIncidentAfcarsInfo
   * @return void
   */  
  private NonIncidentAfcarsInfo populateNonIncidentAfcarsInfo(
                                                              NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI) {

    CapsCase capsCase = getPersistentObject(CapsCase.class, nonIncidentAFCARSInformationSI.getIdCase());
    Person person = getPersistentObject(Person.class, nonIncidentAFCARSInformationSI.getIdPerson());

    // Child Characteristics
    NonIncidentAfcarsInfo nonIncidentAfcarsInfo = new NonIncidentAfcarsInfo();

    nonIncidentAfcarsInfo.setPerson(person);
    nonIncidentAfcarsInfo.setCapsCase(capsCase);
    nonIncidentAfcarsInfo.setIdPerson(nonIncidentAFCARSInformationSI.getIdPerson());
    nonIncidentAfcarsInfo.setDtLastUpdate(nonIncidentAFCARSInformationSI.getDtLastUpdate());
    nonIncidentAfcarsInfo.setDtAppSent(nonIncidentAFCARSInformationSI.getDtApplicationSent());
    nonIncidentAfcarsInfo.setIndMentalRetardation(nonIncidentAFCARSInformationSI.getIndMentRetard());
    nonIncidentAfcarsInfo.setIndVisualHearingImp(nonIncidentAFCARSInformationSI.getIndVisHearImp());
    nonIncidentAfcarsInfo.setIndPhysicallyDisabled(nonIncidentAFCARSInformationSI.getIndPhyDisabled());
    nonIncidentAfcarsInfo.setIndEmotionallyDist(nonIncidentAFCARSInformationSI.getIndEmtDisturbed());
    nonIncidentAfcarsInfo.setIndOtherMed(nonIncidentAFCARSInformationSI.getIndOthMedDiag());

    nonIncidentAfcarsInfo.setCdSevMentalRetardation(nonIncidentAFCARSInformationSI.getCdSevMentRetard());
    nonIncidentAfcarsInfo.setCdSevVisualHearingImp(nonIncidentAFCARSInformationSI.getCdSevVisHearImp());
    nonIncidentAfcarsInfo.setCdSevPhysicallyDisabled(nonIncidentAFCARSInformationSI.getCdSevPhyDisabled());
    nonIncidentAfcarsInfo.setCdSevEmotionallyDist(nonIncidentAFCARSInformationSI.getCdSevEmtDisturbed());
    nonIncidentAfcarsInfo.setCdSevOtherMed(nonIncidentAFCARSInformationSI.getCdSevOthMedDiag());
    
    nonIncidentAfcarsInfo.setCdPrimaryNeed(nonIncidentAFCARSInformationSI.getCdPrimSpecNeed());

    // Child Birth Information
    nonIncidentAfcarsInfo.setNmBnFirst(nonIncidentAFCARSInformationSI.getNmBirthNameFirst());
    nonIncidentAfcarsInfo.setNmBnMiddle(nonIncidentAFCARSInformationSI.getNmBirthNameMiddle());
    nonIncidentAfcarsInfo.setNmBnLast(nonIncidentAFCARSInformationSI.getNmBirthNameLast());

    // Birth Mother Information
    nonIncidentAfcarsInfo.setDtBmDob(nonIncidentAFCARSInformationSI.getDtBirthMotherDOB());
    nonIncidentAfcarsInfo.setCdBmTerminationType(nonIncidentAFCARSInformationSI.getCdBirthMotherTermType());
    nonIncidentAfcarsInfo.setDtBmRightTerminated(nonIncidentAFCARSInformationSI.getDtBirthMotherRightsTerm());

    nonIncidentAfcarsInfo.setIndBmRaceAa(nonIncidentAFCARSInformationSI.getIndBMRaceAA());
    nonIncidentAfcarsInfo.setIndBmRaceAn(nonIncidentAFCARSInformationSI.getIndBMRaceAN());
    nonIncidentAfcarsInfo.setIndBmRaceBk(nonIncidentAFCARSInformationSI.getIndBMRaceBK());
    nonIncidentAfcarsInfo.setIndBmRaceHp(nonIncidentAFCARSInformationSI.getIndBMRaceHP());
    nonIncidentAfcarsInfo.setIndBmRaceUd(nonIncidentAFCARSInformationSI.getIndBMRaceUD());
    nonIncidentAfcarsInfo.setIndBmRaceWt(nonIncidentAFCARSInformationSI.getIndBMRaceWT());
    nonIncidentAfcarsInfo.setCdBmEthnicity(nonIncidentAFCARSInformationSI.getCdBMEthnicity());
    
    // Birth Father Information
    nonIncidentAfcarsInfo.setDtBfDob(nonIncidentAFCARSInformationSI.getDtBirthFatherDOB());
    nonIncidentAfcarsInfo.setCdBfTerminationType(nonIncidentAFCARSInformationSI.getCdBirthFatherTermType());
    nonIncidentAfcarsInfo.setDtBfRightTerminated(nonIncidentAFCARSInformationSI.getDtBirthFatherRightsTerm());

    nonIncidentAfcarsInfo.setIndBfRaceAa(nonIncidentAFCARSInformationSI.getIndBFRaceAA());
    nonIncidentAfcarsInfo.setIndBfRaceAn(nonIncidentAFCARSInformationSI.getIndBFRaceAN());
    nonIncidentAfcarsInfo.setIndBfRaceBk(nonIncidentAFCARSInformationSI.getIndBFRaceBK());
    nonIncidentAfcarsInfo.setIndBfRaceHp(nonIncidentAFCARSInformationSI.getIndBFRaceHP());
    nonIncidentAfcarsInfo.setIndBfRaceUd(nonIncidentAFCARSInformationSI.getIndBFRaceUD());
    nonIncidentAfcarsInfo.setIndBfRaceWt(nonIncidentAFCARSInformationSI.getIndBFRaceWT());
    
    nonIncidentAfcarsInfo.setCdBfEthnicity(nonIncidentAFCARSInformationSI.getCdBFEthnicity());

    return nonIncidentAfcarsInfo;
  }

}
