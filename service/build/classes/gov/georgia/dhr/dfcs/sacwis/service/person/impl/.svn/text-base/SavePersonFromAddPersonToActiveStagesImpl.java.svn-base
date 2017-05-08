package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SavePersonFromAddPersonToActiveStages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI_ADD_PERSON_TO_STAGES;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI_ADD_PERSON_TO_STAGES_ARRAY;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * @author Seung-eun (Caroline) Choi
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------
 *   09/07/2011   schoi                    Initial Creation
 *   09/13/2011   schoi                    Added condition to check for multiple Primary Caretakers
 *   11/01/2011   schoi                    STGAP00017345: MR-095 Updated code for checking multiple Self and Self/Minor Parent
 *   
 * </pre>
 * 
 */

public class SavePersonFromAddPersonToActiveStagesImpl extends BaseServiceImpl implements
                                                                              SavePersonFromAddPersonToActiveStages {
  private ComplexPersonDAO complexPersonDAO = null;

  private StageDAO stageDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  public void setComplexPersonDAO(ComplexPersonDAO complexPersonDAO) {
    this.complexPersonDAO = complexPersonDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void savePersonFromAddPersonToActiveStages(
                                                    int idPerson,
                                                    int idStage,
                                                    int idCase,
                                                    CINV05SI_ADD_PERSON_TO_STAGES_ARRAY cinv05si_add_person_to_stages_array,
                                                    Date dtAssigned, Date dtUnassigned, String personSearchParameter) {
    List<Map> stagesToAddMap = createMapForStagesAdded(idPerson, idStage, cinv05si_add_person_to_stages_array);

    if (stagesToAddMap != null && !stagesToAddMap.isEmpty()) {
      complexPersonDAO.insertPersonAddedFromAddPersonToActiveStages(idPerson, idStage, idCase, stagesToAddMap,
                                                                    dtAssigned, dtUnassigned, personSearchParameter);
    }
  }

  @SuppressWarnings("unchecked")
  private List<Map> createMapForStagesAdded(int idPerson, int idStage,
                                            CINV05SI_ADD_PERSON_TO_STAGES_ARRAY cinv05si_add_person_to_stages_array)
                                                                                                                    throws ServiceException {

    Enumeration cinv05si_add_person_to_stagesEnumeration = cinv05si_add_person_to_stages_array
                                                                                              .enumerateCINV05SI_ADD_PERSON_TO_STAGES();
    List<Map> stagesToSaveMaps = new ArrayList();
    while (cinv05si_add_person_to_stagesEnumeration.hasMoreElements()) {
      CINV05SI_ADD_PERSON_TO_STAGES cinv05si_add_person_to_stages;
      cinv05si_add_person_to_stages = (CINV05SI_ADD_PERSON_TO_STAGES) cinv05si_add_person_to_stagesEnumeration
                                                                                                              .nextElement();

      int idActiveStageToAdd = cinv05si_add_person_to_stages.getUlIdStage();
      String cdStageActiveStageToAdd = stageDAO.findCdStageByIdStage(idActiveStageToAdd);
      String cdStagePersRelIntToAdd = cinv05si_add_person_to_stages.getSzCdStagePersRelInt();

      if (cdStagePersRelIntToAdd != null) {
        // Check for multiple Primary Caretakers if the stage is INV, ONG or DIV
        if (CodesTables.CSTAGES_INV.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_FPR.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_DIV.equals(cdStageActiveStageToAdd)) {
          if (CodesTables.CRELVICT_PK.equals(cinv05si_add_person_to_stages.getSzCdStagePersRelInt())) {
            Person primaryCaretaker = stagePersonLinkDAO.findStagePersonLinkPrimaryCaretaker(idActiveStageToAdd);
            if ((primaryCaretaker != null) && (primaryCaretaker.getIdPerson().intValue() != idPerson)) {
              throw new ServiceException(Messages.MSG_INT_PK_EXIST);
            }
          }
        }

        // Check for multiple Primary Self if the stage is INV, ONG, PFC, FCC, ADO, FAD, PAD or DIV
        if (CodesTables.CSTAGES_INV.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_FPR.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_PFC.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_SUB.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_ADO.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_FAD.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_PAD.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_DIV.equals(cdStageActiveStageToAdd)) {
          if (CodesTables.CRELVICT_SL.equals(cinv05si_add_person_to_stages.getSzCdStagePersRelInt())) {
            Person self = stagePersonLinkDAO.findPersonByIdStageByCdStagePersRelInt(idActiveStageToAdd, cdStagePersRelIntToAdd);
            if ((self != null) && (self.getIdPerson().intValue() != idPerson)) {
              throw new ServiceException(Messages.MSG_RELATHIONSHIP_SELF_EXIST);
            }
          }
        }

        // Check for multiple Self /Minor Parent if the stage is INV, ONG, PFC, FCC, ADO, FAD, PAD or DIV
        if (CodesTables.CSTAGES_INV.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_FPR.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_PFC.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_SUB.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_ADO.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_FAD.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_PAD.equals(cdStageActiveStageToAdd)
            || CodesTables.CSTAGES_DIV.equals(cdStageActiveStageToAdd)) {
          if (CodesTables.CRELVICT_SM.equals(cinv05si_add_person_to_stages.getSzCdStagePersRelInt())
              || CodesTables.CSRCRPTR_SM.equals(cinv05si_add_person_to_stages.getSzCdStagePersRelInt())) {
            Person selfMinorParent = stagePersonLinkDAO.findPersonByIdStageByCdStagePersRelInt(idActiveStageToAdd,
                                                                                               cdStagePersRelIntToAdd);
            if ((selfMinorParent != null) && (selfMinorParent.getIdPerson().intValue() != idPerson)) {
              throw new ServiceException(Messages.MSG_RELATHIONSHIP_SELF_EXIST);
            }
          }
        }
      }
      
      Map stagesMap = new HashMap();
      stagesMap.put("idStageTo", cinv05si_add_person_to_stages.getUlIdStage());
      stagesMap.put("cdStagePersType", cinv05si_add_person_to_stages.getSzCdStagePersType());
      stagesMap.put("cdStagePersRelInt", cinv05si_add_person_to_stages.getSzCdStagePersRelInt());
      stagesMap.put("dtAdded", DateHelper.toJavaDate(cinv05si_add_person_to_stages.getDtDtAdded()));
      stagesToSaveMaps.add(stagesMap);
    }
    return stagesToSaveMaps;
  }
}