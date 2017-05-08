package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.UCMHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicExtDocumentationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExtDocPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExtDocumentationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ExtDocumentation;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveExternalDocumentation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExternalDocumentationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02_ARRAY;

import java.io.InputStream;
import java.rmi.RemoteException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

/**
 * This class is used to perform the Retrieve Service for External Documentation Detail page.
 * 
 * Change History: Date User Description -------- ---------------- ----------------------------------------------
 * 09/10/09 ssubram 	STGAP00015066 - Search operation code has been added
 * 01/30/12 vcollooru 	STGAP00017827 MR-085 Modified to add new parameter to filter for ICPC Documents
 * 03/29/12 cminor		STGAP00018036:Logic was incorrect for displaying personList to attach external documents
 * 
 */
public class RetrieveExternalDocumentationImpl extends BaseServiceImpl implements RetrieveExternalDocumentation {

  private CapsCaseDAO capsCaseDAO = null;

  private DynamicExtDocumentationDAO dynamicExtDocumentationDAO = null;

  private ExtDocPersonLinkDAO extDocPersonLinkDAO = null;

  private ExtDocumentationDAO extDocumentationDAO = null;

  private IncomingDetailDAO incomingDetailDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setDynamicExtDocumentationDAO(DynamicExtDocumentationDAO dynamicExtDocumentationDAO) {
    this.dynamicExtDocumentationDAO = dynamicExtDocumentationDAO;
  }

  public void setExtDocPersonLinkDAO(ExtDocPersonLinkDAO extDocPersonLinkDAO) {
    this.extDocPersonLinkDAO = extDocPersonLinkDAO;
  }

  public void setExtDocumentationDAO(ExtDocumentationDAO extDocumentationDAO) {
    this.extDocumentationDAO = extDocumentationDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CINV23SO retrieveExternalDocumentation(CINV23SI cinv23si) throws ServiceException {
    CINV23SO cinv23so = new CINV23SO();

    int idCase = cinv23si.getUlIdCase();
    String indSealed = cinv23si.getBIndSealed();
    // clsc69dQUERYdam
    cinv23so.setROWCINV23SOG01_ARRAY((callStagePersonLinkDAO(idCase, indSealed)));
    cinv23so = findExtDocumentationInfo(cinv23si, cinv23so);

    Date dtIncomingCall = incomingDetailDAO.findIncomingDetailDtByIdCase(idCase);
    if (dtIncomingCall != null) {
      // Use the dtIncomingCall for the dtCaseOpened
      cinv23so.setDtDtCaseOpened(DateHelper.toCastorDate(dtIncomingCall));
    } else {
      // cinv57dQUERYdam
      Date dtCaseOpenedByIdCase = capsCaseDAO.findCapsCaseDtCaseOpenedByIdCase(idCase);
      cinv23so.setDtDtCaseOpened(DateHelper.toCastorDate(dtCaseOpenedByIdCase));
    }
    cinv23so.setDtWCDDtSystemDate(DateHelper.toCastorDate(new Date()));
    return cinv23so;
  }

  // STG 15065 populates persons names on the case
  private ROWCINV23SOG01_ARRAY callStagePersonLinkDAO(int idCase, String indSealed) {
    ROWCINV23SOG01_ARRAY rowcinv23sogo1_array = new ROWCINV23SOG01_ARRAY();
    // cinv34d
    List<Object[]> stagePersonLinkInfoList = null;
    //STGAP00018036- Swapped calls for sealed cases and unsealed cases
    if (ArchitectureConstants.Y.equalsIgnoreCase(indSealed)) {
      stagePersonLinkInfoList = stagePersonLinkDAO.findStagePersonLinkAndPersonByidCaseForSealedCase(idCase);
    } else {
      stagePersonLinkInfoList = stagePersonLinkDAO.findStagePersonLinkAndPersonByidCase(idCase);
    }
    if (stagePersonLinkInfoList == null || stagePersonLinkInfoList.isEmpty()) {
      return rowcinv23sogo1_array;
    }
    for (Iterator<Object[]> it = stagePersonLinkInfoList.iterator(); it.hasNext();) {
      Object[] map = it.next();
      ROWCINV23SOG01 rowcinv23soso = new ROWCINV23SOG01();
      rowcinv23soso.setUlIdPerson((Integer) map[0] != null ? (Integer) map[0] : 0);
      rowcinv23soso.setSzNmPersonFull((String) map[1]);

      rowcinv23sogo1_array.addROWCINV23SOG01(rowcinv23soso);
    }
    return rowcinv23sogo1_array;
  }

  @SuppressWarnings("unchecked")
  private CINV23SO findExtDocumentationInfo(CINV23SI cinv23si, CINV23SO cinv23so) throws ServiceException {
    final String CHECKED_VAL = "Y";
    int idCase = cinv23si.getUlIdCase();
    // int idExtDoumentation = cinv23si.getUlIdCase();
    ArchInputStruct archInputStruct = cinv23si.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();
    String sortBy = archInputStruct.getCReqFuncCd();
    String cdExtDocSort = cinv23si.getSzCdExtDocSort();
    //STGAP00017827: retrieve the ICPC Document checkbox state.  
    String indICPCDocument = cinv23si.getBIndICPCDoc();
    String txtExtDocLocation = cinv23si.getSzTxtExtDocLocation();
    List<String> docTypeList = new ArrayList<String>();

    ROWCINV23SI01_ARRAY rowCinv23si01Array = cinv23si.getROWCINV23SI01_ARRAY();
    // Parse the array and set the Ext Doc Type and Ext Doc Class
    if (rowCinv23si01Array != null && rowCinv23si01Array.getUlRowQty() > 0) {
      for (int j = 0; j < rowCinv23si01Array.getUlRowQty(); j++) {
        ROWCINV23SI01 rowCinv23si01 = rowCinv23si01Array.getROWCINV23SI01(j);
        String extDocType = rowCinv23si01.getSzCdExtDocType();
        String extDocClass = rowCinv23si01.getSzCdDocClass();
        docTypeList.add(extDocType);
      }
    }
    List<Integer> personIds = new ArrayList<Integer>();
    ROWCINV23SI00_ARRAY rowCinv23si00Array = cinv23si.getROWCINV23SI00_ARRAY();

    ROWCINV23SOG01_ARRAY rowCinv23sogo1Array = cinv23so.getROWCINV23SOG01_ARRAY();

    // Parse the array and set the Person ID
    if (rowCinv23si00Array != null && rowCinv23si00Array.getUlRowQty() > 0) {
      for (int j = 0; j < rowCinv23si00Array.getUlRowQty(); j++) {
        ROWCINV23SI00 rowCinv23si00 = rowCinv23si00Array.getROWCINV23SI00(j);
        Integer idPerson = rowCinv23si00.getUlIdPerson();
        personIds.add(idPerson);
        for (int i = 0; i < rowCinv23sogo1Array.getROWCINV23SOG01Count(); i++) {
          // Use ROWCINV23SOGO1 to redisplay the check boxes with checked after the search is done
          ROWCINV23SOG01 rowCinv23Sog01 = rowCinv23sogo1Array.getROWCINV23SOG01(i);
          if (rowCinv23Sog01 != null && idPerson != null && rowCinv23Sog01.getUlIdPerson() == idPerson) {
            // Set the Person ID
            rowCinv23Sog01.setCSysIndNameChecked(CHECKED_VAL);
          }
        }

      }
    }
    Date beginDate = cinv23si.getDtScrSearchDateFrom() != null ? DateHelper
                                                                           .toJavaDate(cinv23si
                                                                                               .getDtScrSearchDateFrom())
                                                              : DateHelper.MIN_JAVA_DATE;
    Date endDate = cinv23si.getDtScrSearchDateTo() != null ? DateHelper.toJavaDate(cinv23si.getDtScrSearchDateTo())
                                                          : DateHelper.MAX_JAVA_DATE;
    Calendar cal = new GregorianCalendar();
    cal.setTime(endDate);
    cal.add(Calendar.DATE, 0);
    endDate = cal.getTime();
    // get the list of sealed person id if the seal indicator is 'N'
    List<Integer> sealPersonIds = new ArrayList<Integer>();
    if (cinv23si.getBIndSealed().equalsIgnoreCase("N")) {
      sealPersonIds = stagePersonLinkDAO.findSealedIdPersonListByidCase(idCase);
    }
    // cinv26dQUERYdam
    // STGAP00017827: Pass the ICPC Document checkbox status.  
    PaginatedHibernateList<Object[]> extDocObjArrayList = dynamicExtDocumentationDAO
                                                                                    .findExtDocumentationsPaginated(
                                                                                                                    idCase,
                                                                                                                    cdExtDocSort,
                                                                                                                    docTypeList,
                                                                                                                    txtExtDocLocation,
                                                                                                                    beginDate,
                                                                                                                    endDate,
                                                                                                                    personIds,
                                                                                                                    sealPersonIds,
                                                                                                                    sortBy,
                                                                                                                    indICPCDocument,
                                                                                                                    pageNbr,
                                                                                                                    pageSize);
    // STGAP00015065
    ROWCINV23SOG00_ARRAY rowCinv23Sog00Array = new ROWCINV23SOG00_ARRAY();

    for (Iterator<Object[]> it = extDocObjArrayList.iterator(); it.hasNext();) {
      Object[] extDocumentationMap = it.next();
      ROWCINV23SOG00 rowCinv23Sog00 = new ROWCINV23SOG00();

      rowCinv23Sog00.setDtDtExtDocObtained(DateHelper.toCastorDate((Date) extDocumentationMap[3]));
      rowCinv23Sog00.setSzCdExtDocType(String.valueOf(extDocumentationMap[5]));
      rowCinv23Sog00.setSzCdDocClass(extDocumentationMap[12] != null ? extDocumentationMap[12].toString() : null);
      rowCinv23Sog00.setSzTxtExtDocLocation(String.valueOf(extDocumentationMap[6]));
      rowCinv23Sog00.setSzTxtExtDocDetails(StringHelper.getNonNullString((String) extDocumentationMap[4]));
      rowCinv23Sog00.setUlIdExtSitInfo(extDocumentationMap[0] != null ? (Integer) extDocumentationMap[0] : 0);
      rowCinv23Sog00.setTsLastUpdate((Date) extDocumentationMap[1]);
      rowCinv23Sog00.setDtDtExtDocAdded(DateHelper.toCastorDate((Date) extDocumentationMap[13]));
      rowCinv23Sog00.setSzCdExtDocSort(StringHelper.getNonNullString((String) extDocumentationMap[7]));
      rowCinv23Sog00.setDtExtDocUploaded(DateHelper.toCastorDate((Date) extDocumentationMap[9]));
      rowCinv23Sog00.setBIndExtDocSigned(String.valueOf(extDocumentationMap[8]));
      rowCinv23Sog00.setBIndNaChecked(String.valueOf(extDocumentationMap[14]));
      rowCinv23Sog00.setSzTxtFileName(StringHelper.getNonNullString((String) extDocumentationMap[10]));
      rowCinv23Sog00.setSzTxtFormatType(StringHelper.getNonNullString((String) extDocumentationMap[11]));
      // STGAP00017827: set the ICPC Document checkbox status into the object.
      rowCinv23Sog00.setBIndICPCDoc(String.valueOf(extDocumentationMap[15]));
      rowCinv23Sog00.setSzTxtUcmDId(StringHelper.getNonNullString((String) extDocumentationMap[16]));
      int extdoc = rowCinv23Sog00.getUlIdExtSitInfo();
      // Adding persons checked list for each Ext documentation record
      List<Integer> percheckedList = extDocPersonLinkDAO.findPersonCheckedByIdExtDocumentation(extdoc);
      if (percheckedList != null && !percheckedList.isEmpty()) {
        ROWCINV23SOG02_ARRAY perCheckedArray = new ROWCINV23SOG02_ARRAY();
        perCheckedArray.setUlRowQty(percheckedList.size());
        for (int i = 0; i < percheckedList.size(); i++) {
          ROWCINV23SOG02 rowPercheckedSO = new ROWCINV23SOG02();
          Integer ulIdPerson = percheckedList.get(i);
          rowPercheckedSO.setUlIdPerson(ulIdPerson);
          perCheckedArray.addROWCINV23SOG02(rowPercheckedSO);
        }
        rowCinv23Sog00.setROWCINV23SOG02_ARRAY(perCheckedArray);
      }

      rowCinv23Sog00Array.addROWCINV23SOG00(rowCinv23Sog00);

    }

    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    archOutputStruct.setBMoreDataInd(extDocObjArrayList.getBMoreDataInd());
    cinv23so.setArchOutputStruct(archOutputStruct);

    cinv23so.setROWCINV23SOG00_ARRAY(rowCinv23Sog00Array);
    cinv23so.setROWCINV23SOG01_ARRAY(rowCinv23sogo1Array);

    return cinv23so;
  }

  /**
   * The displayExtDoc method calls the displayExtDoc method in cinv25dao, which displays the external Document.
   * 
   * @param idExtDoc
   *          - id of the external document.
   * @throws RemoteException
   */

  public ExternalDocumentationSO displayExtDoc(int idExtDoc) {
    ExternalDocumentationSO extDocSO = new ExternalDocumentationSO();
    try {
      byte[] fileData = null;
      ExtDocumentation extDoc = extDocumentationDAO.findExtDocByIdExtDoc(idExtDoc);
      if (StringUtils.equalsIgnoreCase("Y", StringUtils.trimToEmpty(extDoc.getIsUcmFile()))) {
        if (StringUtils.isNotBlank(extDoc.getUcmDId())) {
          UCMHelper ucmHelper = new UCMHelper();
          InputStream fis = ucmHelper.retrieveFile(extDoc.getUcmDId());
          if (fis != null) {
            fileData = IOUtils.toByteArray(fis);
          }
        }
      } else {
        fileData = (extDoc != null && extDoc.getBlExtDoc() != null && extDoc.getBlExtDoc().length > 0) ? extDoc.getBlExtDoc()
                                                                                                      : null;
      }
      /*
       * Blob blob = extDocumentationDAO.findExtDoc(idExtDoc); if (blob != null && blob.length() > 0) { fileData = new
       * byte[(int) blob.length()]; fileData = blob.getBytes(1, (int) blob.length()); }
       */
      extDocSO.setIsUCMFile(StringUtils.trimToEmpty(extDoc.getIsUcmFile()));
      extDocSO.setFileData(fileData);
      extDocSO.setFileName(StringUtils.trim(extDoc.getTxtFileName()));
      extDocSO.setFileFormat(StringUtils.trim(extDoc.getTxtFormatType()));

    } catch (Exception e) {
      e.getMessage();
    }
    return extDocSO;
  }
}
