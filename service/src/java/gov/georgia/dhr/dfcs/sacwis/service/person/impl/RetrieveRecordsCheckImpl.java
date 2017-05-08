package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsCheckDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveRecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY;

/*Change History:
Date             User              Description
--------         ----------------  --------------------------------------------------
04/28/2010       mxpatel           SMS #50253: Update method to set ccfc26so.setMoreDataAvailable
                                   to recordsCheckInfoList.isMoreDataAvailable()for Records Check List 
                                   pagination to work.                       
07/07/2011       hnguyen           SMS#114348: Updated Requested By person name to populate full name without truncation.
*/

public class RetrieveRecordsCheckImpl extends BaseServiceImpl implements RetrieveRecordsCheck {
  private RecordsCheckDAO recordsCheckDAO = null;

  private PersonDAO personDAO = null;

  private NameDAO nameDAO = null;

  public void setRecordsCheckDAO(RecordsCheckDAO recordsCheckDAO) {
    this.recordsCheckDAO = recordsCheckDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public CCFC26SO retrieveRecordsCheck(CCFC26SI ccfc26si) throws ServiceException {
    CCFC26SO ccfc26so = new CCFC26SO();
    ccfc26so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());
    ccfc26so.setCIndRecCheckDpsIncomplete(ArchitectureConstants.N);

    // Retrieve full rows from the Records Check Table. DAO RecordsCheckDAO
    // This DAO will retrieve all rows from the RECORDS CHECK table by ID_REC_CHECK_PERSON.
    int idRecCheckPerson = ccfc26si.getUlIdRecCheckPerson();
    ROWCCFC26SOG00_ARRAY rowccfc26sog00_array = new ROWCCFC26SOG00_ARRAY();

    ArchInputStruct archInputStruct = ccfc26si.getArchInputStruct();
    // ccmn15d

    // clsc53d
    PaginatedHibernateList<Object[]> recordsCheckInfoList = recordsCheckDAO.findRecordsCheck(idRecCheckPerson,
                                                                           archInputStruct.getUsPageNbr(),
                                                                           archInputStruct.getUlPageSizeNbr());
    // If one or more rows was retrieved, Set fields in CCFC26SO
    if (recordsCheckInfoList != null) {
      for (Iterator<Object[]> it = recordsCheckInfoList.iterator(); it.hasNext();) {
        Object[] recordsCheckInfo = it.next();
        RecordsCheck recordsCheck = (RecordsCheck) recordsCheckInfo[0];
        ROWCCFC26SOG00 rowccfc26og00 = new ROWCCFC26SOG00();
        rowccfc26og00.setSzCdRecCheckCheckType(recordsCheck.getCdRecCheckCheckType());
        rowccfc26og00.setSzCdRecCheckEmpType(recordsCheck.getCdRecCheckEmpType());
        rowccfc26og00.setSzCdRecCheckStatus(recordsCheck.getCdRecCheckStatus());
        rowccfc26og00.setSzTxtRecCheckComments(recordsCheck.getTxtRecCheckComments());
        String nmPersonFull = (String) recordsCheckInfo[1];
        rowccfc26og00.setSzScrNmRequestedBy(nmPersonFull);
        rowccfc26og00.setTsLastUpdate(recordsCheck.getDtLastUpdate());
        rowccfc26og00.setDtDtRecCheckRequest(DateHelper.toCastorDate(recordsCheck.getDtRecCheckRequest()));
        rowccfc26og00.setDtDtRecCheckCompleted(DateHelper.toCastorDate(recordsCheck.getDtRecCheckCompleted()));
        rowccfc26og00.setUlIdRecCheck(recordsCheck.getIdRecCheck() != null ? recordsCheck.getIdRecCheck() : 0);
        rowccfc26og00
                .setUlIdRecCheckRequestor(
                        recordsCheck.getPersonByIdRecCheckRequestor().getIdPerson() != null ? recordsCheck
                                .getPersonByIdRecCheckRequestor()
                                .getIdPerson()
                        : 0);

        rowccfc26og00
                .setCIndRecCheckHistory(recordsCheck.getIndReccheckHistory() != null ? recordsCheck
                        .getIndReccheckHistory()
                                        : "N");
        // Fingerprint Check Details.
        rowccfc26og00.setSelDtCriminalReleaseReceived(DateHelper.toCastorDate(recordsCheck.getDtRecCheckCrimRelRec()));
        rowccfc26og00.setCbFingerprintCard(recordsCheck.getIndRecchkFpcard());
        rowccfc26og00.setCbLiveScan(recordsCheck.getIndRecchkLiveScan());
        rowccfc26og00.setSelDtFingerprintCardGiven(DateHelper.toCastorDate(recordsCheck.getDtRecchkFpCardGiven()));
        rowccfc26og00.setSelDtFingerprintCardReturn(DateHelper.toCastorDate(recordsCheck.getDtRecchkFpCardReturn()));
        rowccfc26og00.setSelDtLiveScanPerformed(DateHelper.toCastorDate(recordsCheck.getDtRecchkLsPerformed()));
        rowccfc26og00.setSelDtLiveScanResultReceived(DateHelper.toCastorDate(recordsCheck.getDtRecchkLsresultRec()));
        rowccfc26og00.setRbRefuseSignInvestigationClearance(recordsCheck.getIndRecchkRefuseInvClrnce());
        rowccfc26og00.setRbFingerPrintCkResult(recordsCheck.getIndRecchkFpchkResult());
        rowccfc26og00.setRbRecommendation(recordsCheck.getIndRecchkRecmndatn());
        

        if (recordsCheck.getStage() != null) {

          rowccfc26og00.setUlIdStage(recordsCheck.getStage().getIdStage() != null ? recordsCheck.getStage()
                  .getIdStage() : 0);
        } else {
          rowccfc26og00.setUlIdStage(0);

        }
        // Set DPS Records Check Incomplete flag from the Records Check
        // Table for retrieved records which are CdRecCheckType of "10"
        // (DPS Criminal History) and the DtRecCheckCompleted
        // field is "12/31/4712"(max date).
        if (CodesTables.CCHKTYPE_10.equals(rowccfc26og00.getSzCdRecCheckCheckType())
            && DateHelper.isNull(rowccfc26og00.getDtDtRecCheckCompleted())
            && !CodesTables.CCRIMSTA_O.equals(rowccfc26og00.getSzCdRecCheckStatus())
            && !CodesTables.CCRIMSTA_E.equals(rowccfc26og00.getSzCdRecCheckStatus())
            && !CodesTables.CCRIMSTA_R.equals(rowccfc26og00.getSzCdRecCheckStatus())
            && !ArchitectureConstants.Y.equals(ccfc26so.getCIndRecCheckDpsIncomplete())) {
          rowccfc26og00.setSzCdRecCheckCheckType(ArchitectureConstants.Y);

        }

        rowccfc26sog00_array.addROWCCFC26SOG00(rowccfc26og00);
      }
      ccfc26so.setMoreDataAvailable(recordsCheckInfoList.isMoreDataAvailable());
    }
    ccfc26so.setROWCCFC26SOG00_ARRAY(rowccfc26sog00_array);
    // Retrieve full row from the Person Table DAO PersonDAO
    // This DAO will get the entire row from the PERSON table based on the ID PERSON.
    // ccmn44d
    Person recCheckPerson = personDAO.findPersonByIdPerson(idRecCheckPerson);
    if (recCheckPerson != null) {
      ccfc26so.setSzCdPersonEthnicGroup(recCheckPerson.getCdPersonEthnicGroup());
      ccfc26so.setSzNmPersonFull(recCheckPerson.getNmPersonFull());
      ccfc26so.setDtDtPersonBirth(DateHelper.toCastorDate(recCheckPerson.getDtPersonBirth()));
      ccfc26so.setBIndPersonDobApprox(recCheckPerson.getIndPersonDobApprox());
      ccfc26so.setCCdPersonSex(recCheckPerson.getCdPersonSex());
      // ccmn44d
      Person recCheckRequestor = personDAO.findPersonByIdPerson(ccfc26si.getUlIdRecCheckRequestor());
      if (recCheckRequestor != null) {
        ccfc26so.setSzScrNmRequestedBy(FormattingHelper.formatFullName(recCheckRequestor.getNmPersonFirst(),
                                                                       recCheckRequestor.getNmPersonMiddle(),
                                                                       recCheckRequestor.getNmPersonLast()));
        // Retrieve Name: DAO NameDAO
        // Given ID PERSON this DAO will retrieve NM NAME FIRST, NM NAME LAST, and NM NAME MIDDLE from NAME table.
        // sec35d
        Name name = nameDAO.findNameByPersonPrimary(idRecCheckPerson);
        if (name != null) {
          ccfc26so.setSzNmNameFirst(name.getNmNameFirst());
          ccfc26so.setSzNmNameLast(name.getNmNameLast());
        }
      }
    }
    return ccfc26so;
  }
}
