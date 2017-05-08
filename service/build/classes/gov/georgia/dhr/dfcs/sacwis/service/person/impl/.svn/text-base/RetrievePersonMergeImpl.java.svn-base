package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.UnitAccess;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrievePersonMerge;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00_ARRAY;

public class RetrievePersonMergeImpl extends BaseServiceImpl implements RetrievePersonMerge {

  PersonMergeDAO personMergeDAO = null;

  PersonCategoryDAO personCategoryDAO = null;

  PersonDAO personDAO = null;

  StageDAO stageDAO = null;

  UnitAccess unitAccess = null;

  public void setUnitAccess(UnitAccess unitAccess) {
    this.unitAccess = unitAccess;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonCategoryDAO(PersonCategoryDAO personCategoryDAO) {
    this.personCategoryDAO = personCategoryDAO;
  }

  public void setPersonMergeDAO(PersonMergeDAO personMergeDAO) {
    this.personMergeDAO = personMergeDAO;
  }

  public CCFC13SO retrievePersonMerge(CCFC13SI ccfc13si) throws ServiceException {
    CCFC13SO ccfc13so = new CCFC13SO();
    ArchInputStruct archInputStruct = ccfc13si.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();

//    PaginatedHibernateList<Integer> result = personMergeDAO.findPersonMerge(ccfc13si.getUlIdPerson(), pageNbr, pageSize);
    List<Integer> result = personMergeDAO.findPersonMerge(ccfc13si.getUlIdPerson());

    if (result != null && result.size() != 0) {
      PaginatedHibernateList<Object[]> result2 = personMergeDAO.findPersonMergeByIdPersMergeForward(
              ccfc13si.getUlIdPerson(), pageNbr, pageSize);

      if (result2 != null && result2.size() != 0) {
        ROWCCFC13SOG00_ARRAY rowccfc13sogoo_array = new ROWCCFC13SOG00_ARRAY();
        for (Iterator<Object[]> it = result2.iterator(); it.hasNext();) {
          Object[] personMerge = it.next();
          ROWCCFC13SOG00 rowccfc13sogoo = new ROWCCFC13SOG00();
          /*         String lastName = (String) personMerge[13];
      String firstName = (String) personMerge[14];
      String middle = (String) personMerge[15];*/
          String lastName = (String) personMerge[6];
          String firstName = (String) personMerge[4];
          String middle = (String) personMerge[5];
          String name = FormattingHelper.formatFullName(firstName, middle, lastName);
          rowccfc13sogoo.setSzScrNmPersMergeForward(name);
          String szNmNameFirst = (String) personMerge[4];
          rowccfc13sogoo.setSzNmNameFirst(szNmNameFirst);
          String szNmNameMiddle = (String) personMerge[5];
          rowccfc13sogoo.setSzNmNameMiddle(szNmNameMiddle);
          String SzNmNameLast = (String) personMerge[6];
          rowccfc13sogoo.setSzNmNameLast(SzNmNameLast);
          Integer UlIdPersMergeForward = (Integer) personMerge[2];
          rowccfc13sogoo.setUlIdPersMergeForward(UlIdPersMergeForward != null ? UlIdPersMergeForward : 0);
          String SzScrNmPersMergeClosed = (String) personMerge[8];
          rowccfc13sogoo.setSzScrNmPersMergeClosed(SzScrNmPersMergeClosed);
          String szScrNmNameFirst = (String) personMerge[9];
          rowccfc13sogoo.setSzScrNmNameFirst(szScrNmNameFirst);
          String szScrNmNameMiddle = (String) personMerge[10];
          rowccfc13sogoo.setSzScrNmNameMiddle(szScrNmNameMiddle);
          String szScrNmNameLast = (String) personMerge[11];
          rowccfc13sogoo.setSzScrNmNameLast(szScrNmNameLast);
          Integer ulIdPersMergeClosed = (Integer) personMerge[7];
          rowccfc13sogoo.setUlIdPersMergeClosed(ulIdPersMergeClosed != null ? ulIdPersMergeClosed : 0);
          String name2 = FormattingHelper.formatFullName((String) personMerge[14], (String) personMerge[15],
                                                         (String) personMerge[13]);
          rowccfc13sogoo.setSzScrNmPersMergeWrkr(name2);
          String name3 = FormattingHelper.formatFullName((String) personMerge[18], (String) personMerge[19],
                                                         (String) personMerge[17]);
          rowccfc13sogoo.setSzScrNmPersMrgSpltWrkr(name3);
          Integer ulIdPersMergeWrkr = (Integer) personMerge[12];
          rowccfc13sogoo.setUlIdPersMergeWrkr(ulIdPersMergeWrkr != null ? ulIdPersMergeWrkr : 0);
          Integer ulIdPersMergeSplitWrkr = (Integer) personMerge[16];
          rowccfc13sogoo.setUlIdPersMergeSplitWrkr(ulIdPersMergeSplitWrkr != null ? ulIdPersMergeSplitWrkr : 0);
          Date tsLastUpdate = (Date) personMerge[1];
          rowccfc13sogoo.setTsLastUpdate(tsLastUpdate);
          Integer ulIdPersonMerge = (Integer) personMerge[0];
          rowccfc13sogoo.setUlIdPersonMerge(ulIdPersonMerge != null ? ulIdPersonMerge : 0);
          String indPersMergeInvalid = (String) personMerge[20];
          rowccfc13sogoo.setCIndPersMergeInvalid(indPersMergeInvalid);
          Date dtPersMerge = (Date) personMerge[22];
          rowccfc13sogoo.setDtDtPersMerge(DateHelper.toCastorDate(dtPersMerge));
          Date dtPersMergeSplit = (Date) personMerge[21];
          rowccfc13sogoo.setDtDtPersMergeSplit(DateHelper.toCastorDate(dtPersMergeSplit));

          rowccfc13sogoo_array.addROWCCFC13SOG00(rowccfc13sogoo);
        }
        ccfc13so.setROWCCFC13SOG00_ARRAY(rowccfc13sogoo_array);
      }

      PaginatedHibernateList<PersonCategory> personCategoryList = personCategoryDAO
              .findPersonCategoryByIdPerson(ccfc13si.getUlIdPerson(), pageNbr, pageSize);
      if (personCategoryList != null && personCategoryList.size() != 0) {
        for (Iterator<PersonCategory> it = personCategoryList.iterator(); it.hasNext();) {
          PersonCategory personCategory = it.next();
          if (CodesTables.CPSNDTCT_EMP.equals(personCategory.getCdPersonCategory())
              || CodesTables.CPSNDTCT_FEM.equals(personCategory.getCdPersonCategory())) {
            ccfc13so.setBIndActiveStatus(ArchitectureConstants.TRUE);
          }
        }
      } else {
        ccfc13so.setBIndActiveStatus(ArchitectureConstants.FALSE);
      }
    }

    Map map = personDAO.findNmPersonAndNmStageByIdStage(ccfc13si.getUlIdStage(), CodesTables.CROLEALL_PR);
    if (map != null && (map.size() != 0)) {
      int idPerson = (Integer) map.get("idPerson");
      if (ccfc13si.getUlIdPersonRequestor() == idPerson) {
        ccfc13so.setCSysIndPrimaryWorker("1");
      } else {
        ccfc13so.setCSysIndPrimaryWorker("0");
        Stage stage = stageDAO.findStageAndCapsCase(ccfc13si.getUlIdStage());
        if (stage != null) {
          CCMN04UI pCCMN04UInputRec = new CCMN04UI();
          if (stage.getUnit() == null || stage.getUnit().equals(null)) {
            pCCMN04UInputRec.setUlIdUnit(0);
          } else {
            pCCMN04UInputRec.setUlIdUnit(stage.getUnit().getIdUnit() != null ? stage.getUnit().getIdUnit() : 0);
          }
          //pCCMN04UInputRec.setUlIdUnit(stage.getUnit().getIdUnit() != null ? stage.getUnit().getIdUnit() : 0);
          UlIdPerson_ARRAY_CCMN04UI ulIdPerson_ARRAY_CCMN04UI = new UlIdPerson_ARRAY_CCMN04UI();
          ulIdPerson_ARRAY_CCMN04UI.addUlIdPerson(0, ccfc13si.getUlIdPersonRequestor());
          pCCMN04UInputRec.setUlIdPerson_ARRAY_CCMN04UI(ulIdPerson_ARRAY_CCMN04UI);
          //pCCMN04UInputRec.getUlIdPerson_ARRAY_CCMN04UI().setUlIdPerson(0, ccfc13si.getUlIdPersonRequestor());
          CCMN04UO ccmn04u0 = this.unitAccess.checkForPersonWithUnitAccess(pCCMN04UInputRec);
          if (ccmn04u0 != null) {
            ccfc13so.setCSysIndPrimaryWorker(ccmn04u0.getBSysIndGeneric());
          } else {
            throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
          }
        }

      }
    }

    return ccfc13so;
  }

}
