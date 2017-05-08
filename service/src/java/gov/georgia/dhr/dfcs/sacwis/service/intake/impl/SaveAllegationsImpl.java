package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexIntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncmgDetermFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SaveAllegations;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegListAudInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegListAUDOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct_ARRAY;

/**
 * <pre>
 *   Change History:
 *   Date      User          Description
 *   --------  --------      --------------------------------------------------
 *  01/05/2009 arege         STGAP00009957: Modified code so that when an existing Allegation type is changed, 
 *                           the corresponding determination factors are deleted.
 *  01/28/2009 arege         STGAP00009957: Made changes as per peer review.
 *  05/26/2010 hjbaptiste    SMS#51977-MR66-Maltreatment In Care: Added the setting of additional field
 *                           to indicate maltreatment in care
 *                       
 * </pre>
 */

public class SaveAllegationsImpl extends BaseServiceImpl implements SaveAllegations {

  private ComplexIntakeAllegationDAO complexIntakeAllegationDAO = null;

  private IntakeAllegationDAO intakeAllegationDAO = null;
  
  private IncmgDetermFactorsDAO incmgDetermFactorsDAO = null;
  

  public void setIncmgDetermFactorsDAO(IncmgDetermFactorsDAO incmgDetermFactorsDAO) {
    this.incmgDetermFactorsDAO = incmgDetermFactorsDAO;
  }
  
  public void setIntakeAllegationDAO(IntakeAllegationDAO intakeAllegationDAO) {
    this.intakeAllegationDAO = intakeAllegationDAO;
  }

  public void setComplexIntakeAllegationDAO(ComplexIntakeAllegationDAO complexIntakeAllegationDAO) {
    this.complexIntakeAllegationDAO = complexIntakeAllegationDAO;
  }

  public AllegListAUDOutRec saveAllegations(AllegListAudInRec allegListAudInRec) throws ServiceException {
    AllegListAUDOutRec allegListAUDOutRec = new AllegListAUDOutRec();
    ROWCINT14DI_ARRAY rowCint14DiArray = allegListAudInRec.getROWCINT14DI_ARRAY();
    Enumeration rowCint14Di_enum = rowCint14DiArray.enumerateROWCINT14DI();

    AllegLstOutStruct_ARRAY allegLstOutStructArray = new AllegLstOutStruct_ARRAY();

    int lSysNbrUniqueLBKey = 0; // An index used to populate lSysNbrUniqueLBKey

    while (rowCint14Di_enum.hasMoreElements()) {
      ROWCINT14DI rowcint14di = (ROWCINT14DI) rowCint14Di_enum.nextElement();
      AllegLstOutStruct allegLstOutStruct = new AllegLstOutStruct();
      String cdScrDataAction = rowcint14di.getSzCdScrDataAction();
      if (cdScrDataAction != null) {
        int idAllegation = rowcint14di.getUlIdAllegation();
        int idStage = rowcint14di.getUlIdStage();
        String cdAllegType = rowcint14di.getSzCdAllegType();
        String txtAllegDuration = rowcint14di.getSzTxtAllegDuration();
        int idVictim = rowcint14di.getUlIdVictim();
        int idAllegedPerpetrator = rowcint14di.getUlIdAllegedPerpetrator();
        String nmVictim = rowcint14di.getSzNmVictim();
        String nmPerpetrator = rowcint14di.getSzNmPerpetrator();
        // Maltreator relationship
        String cdMaltreatorRel = rowcint14di.getSzCdMaltreatorRel();
        //for Location of Maltreatment
        String cdAllegedMalLocation = rowcint14di.getSzCdAllegedMalLocation();
        String cdAllegedMalCode = rowcint14di.getSzCdIntakeAllegMalCode();
        Date dtAllegedIncident = DateHelper.toJavaDate(rowcint14di.getDtDtAllegedIncident());
        String indIncmgMaltreatInCare = rowcint14di.getCIndIncmgMaltreatInCare();

        // cint14d
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)) {
          if (0 == complexIntakeAllegationDAO.addIntakeAllegationWithCheck(cdAllegType, idStage, txtAllegDuration,
                                                                           idVictim, idAllegedPerpetrator, indIncmgMaltreatInCare,
                                                                           nmVictim,nmPerpetrator, cdAllegedMalLocation,
                                                                           cdAllegedMalCode, dtAllegedIncident, cdMaltreatorRel)) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          allegLstOutStruct.setLSysNbrUniqueLBKey(lSysNbrUniqueLBKey);
          allegLstOutStruct.setUlIdAllegation(idAllegation);
        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
          if (0 == complexIntakeAllegationDAO.updateIntakeAllegationDetails(cdAllegType, idStage, txtAllegDuration, idVictim,
                                                                            idAllegedPerpetrator, indIncmgMaltreatInCare, nmVictim, 
                                                                            nmPerpetrator, idAllegation, cdAllegedMalLocation,
                                                                            cdAllegedMalCode, dtAllegedIncident, cdMaltreatorRel)) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          //STGAP00009957: After update of the Maltreatment Type see if there exists any determination factors for the previous allegation type
          // where the allegation i.e Maltreatment Type is changed and there is no more allegation of that type.
          // When an existing Allegation type is changed , this code first finds the determination factors id and then 
          // deletes the determination factors for previous allegation type.
          List <Integer> idDetermFactorsList = incmgDetermFactorsDAO.findExtraIncmgDetermFactorsByIdStage(idStage);
              
          if (!idDetermFactorsList.isEmpty()) {
            int howMany = incmgDetermFactorsDAO.deleteExtraIncmgDetermFactorsByIdDetermFactors(idDetermFactorsList);
            if (howMany != idDetermFactorsList.size()) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }
          }

        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {
          if (0 == intakeAllegationDAO.deleteIntakeAllegation(idAllegation)) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      }
      // A row must be added to each iteration of the loop, even if it was not populated.
      allegLstOutStructArray.addAllegLstOutStruct(allegLstOutStruct);
      // Increment the index used for setting lSysNbrUniqueLBKey
      lSysNbrUniqueLBKey++;
    }
    allegListAUDOutRec.setAllegLstOutStruct_ARRAY(allegLstOutStructArray);
    return allegListAUDOutRec;
  }
}