package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveFAHomeHistory;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

/**
 * Retrieve Service for FA Home History page.
 * 
 * @author lata.p.lokhande
 * 
 */
/**
 * 
 * Change History: 
 * Date       User          Description
 * ---------- ------------- -----------------------------------------------
 * 02/23/2011 hanguyen      Added Change History. 
 * 02/23/2011 hanguyen      SMS#97850: MR-075 Added new fields for IV-E Reimbursability.
 * 03/26/2011 hanguyen      SMS#97850: MR-075 Update for SO element name change.
*/

public class RetrieveFAHomeHistoryImpl extends BaseServiceImpl implements RetrieveFAHomeHistory {

  private ResourceHistoryDAO resourceHistoryDAO = null;

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  /**
   * Retrieve method for FA Home History page.
   * 
   * @param cfad12si
   * @return CFAD12SO
   */
  public CFAD12SO retrieveFAHomeHistory(CFAD12SI cfad12si) {

    // get archinputstruct object from retrieveSI object and then
    // get the page number and page size.
    ArchInputStruct input = cfad12si.getArchInputStruct();
    int pageNbr = input.getUsPageNbr();
    int pageSize = input.getUlPageSizeNbr();

    CFAD12SO cfad12so = new CFAD12SO();
    ROWCFAD12SOG00_ARRAY rowcfad12sog00_array = new ROWCFAD12SOG00_ARRAY();
    int idStage = cfad12si.getUlIdStage();

    PaginatedHibernateList<ResourceHistory> resourceHistoryList = resourceHistoryDAO
                                                                                    .findResourceHistoryListByIdStage(
                                                                                                                      idStage,
                                                                                                                      pageNbr,
                                                                                                                      pageSize);

    if (resourceHistoryList != null || resourceHistoryList.size() != 0) {
      cfad12so = populate_CFAD12SO(resourceHistoryList);

    }
    return cfad12so;
  }

  /**
   * Helper method to populate the RetrieveSO object (CFAD12SO) and pass it back to Conversation.
   * 
   * @param resourceHistoryList
   * @return
   */
  private CFAD12SO populate_CFAD12SO(PaginatedHibernateList<ResourceHistory> resourceHistoryList) {

    // create ArchOutputStruct and set the "more data indicator" field from PaginatedHibernateList
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    archOutputStruct.setBMoreDataInd(resourceHistoryList.getBMoreDataInd());

    CFAD12SO cfad12SO = new CFAD12SO();

    ROWCFAD12SOG00_ARRAY rowcfad12sog00_array = new ROWCFAD12SOG00_ARRAY();

    for (Iterator<ResourceHistory> it = resourceHistoryList.iterator(); it.hasNext();) {
      ResourceHistory resourceHisrotyRow = it.next();

      ROWCFAD12SOG00 rowcfad12sog00 = new ROWCFAD12SOG00();

      rowcfad12sog00.setDtDtRshsEffective(DateHelper.toCastorDate(resourceHisrotyRow.getDtRshsEffective()));
      rowcfad12sog00.setDtDtRshsEnd(DateHelper.toCastorDate(resourceHisrotyRow.getDtRshsEnd()));
      rowcfad12sog00.setSzCdRshsCategory(resourceHisrotyRow.getCdRshsCategory());
      rowcfad12sog00.setSzCdRshsFaHomeStatus(resourceHisrotyRow.getCdRshsFaHomeStatus());
      rowcfad12sog00
                    .setUNbrRshsFacilCapacity(resourceHisrotyRow.getNbrRshsFacilCapacity() != null ? resourceHisrotyRow
                                                                                                                       .getNbrRshsFacilCapacity()
                                                                                                  : 0);
      rowcfad12sog00
                    .setUNbrRshsAFeAgeMax(resourceHisrotyRow.getNbrRshsFmAgeMax() != null ? resourceHisrotyRow
                                                                                                              .getNbrRshsFmAgeMax()
                                                                                         : 0);
      rowcfad12sog00
                    .setUNbrRshsAFeAgeMin(resourceHisrotyRow.getNbrRshsFmAgeMin() != null ? resourceHisrotyRow
                                                                                                              .getNbrRshsFmAgeMin()
                                                                                         : 0);
      rowcfad12sog00
                    .setUNbrRshsAMaAgeMax(resourceHisrotyRow.getNbrRshsIntMaAgeMax() != null ? resourceHisrotyRow
                                                                                                                 .getNbrRshsIntMaAgeMax()
                                                                                            : 0);
      rowcfad12sog00
                    .setUNbrRshsAMaAgeMin(resourceHisrotyRow.getNbrRshsIntMaAgeMin() != null ? resourceHisrotyRow
                                                                                                                 .getNbrRshsIntMaAgeMin()
                                                                                            : 0);
      rowcfad12sog00.setSzCdRshsClosureRsn(resourceHisrotyRow.getCdRshsClosureRsn());
      rowcfad12sog00.setSzCdRshsRecmndReopen(resourceHisrotyRow.getCdRshsRecmndReopen());
      rowcfad12sog00.setSzCdRshsInvolClosure(resourceHisrotyRow.getCdRshsInvolClosure());
      rowcfad12sog00.setSzCdRshsEthnicity(resourceHisrotyRow.getCdRshsEthnicity());
      rowcfad12sog00.setSzCdRshsLanguage(resourceHisrotyRow.getCdRshsLanguage());
      rowcfad12sog00.setSzCdRshsReligion(resourceHisrotyRow.getCdRshsReligion());

      rowcfad12sog00
                    .setDNbrRshsAnnualIncome(resourceHisrotyRow.getNbrRshsAnnualIncome() != null ? resourceHisrotyRow
                                                                                                                     .getNbrRshsAnnualIncome()
                                                                                                : 0);

      rowcfad12sog00.setSzCdRshsMaritalStatus(resourceHisrotyRow.getCdRshsMaritalStatus());
      rowcfad12sog00.setDtDtRshsMarriage(DateHelper.toCastorDate(resourceHisrotyRow.getDtRshsMarriage()));

      rowcfad12sog00.setSzCdRshsSourceInquiry(resourceHisrotyRow.getCdRshsSourceInquiry());
      rowcfad12sog00.setSzCdRshsRespite(resourceHisrotyRow.getCdRshsRespite());
      rowcfad12sog00.setCIndRshsNonDFCSHome(resourceHisrotyRow.getIndRsrcNondfcs());
      rowcfad12sog00.setSzTxtNdfcsCertEntity(resourceHisrotyRow.getNdfcsCertEntity());
      rowcfad12sog00.setCIndCurrHomeStudyExists(resourceHisrotyRow.getIndCurrHmStdyExsts());
      rowcfad12sog00.setCIndRshsCareProv(resourceHisrotyRow.getIndRshsCareProv());
      rowcfad12sog00.setUlIdResourceHistory(resourceHisrotyRow.getIdResourceHistory());
      rowcfad12sog00.setCCdRshsFaHomeType1(resourceHisrotyRow.getCdRshsFaHomeType1());
      rowcfad12sog00.setCCdRshsFaHomeType2(resourceHisrotyRow.getCdRshsFaHomeType2());
      rowcfad12sog00.setCCdRshsFaHomeType3(resourceHisrotyRow.getCdRshsFaHomeType3());
      rowcfad12sog00.setCCdRshsFaHomeType4(resourceHisrotyRow.getCdRshsFaHomeType4());
      rowcfad12sog00.setCCdRshsFaHomeType5(resourceHisrotyRow.getCdRshsFaHomeType5());
      rowcfad12sog00.setCCdRshsFaHomeType6(resourceHisrotyRow.getCdRshsFaHomeType6());
      rowcfad12sog00.setCCdRshsFaHomeType7(resourceHisrotyRow.getCdRshsFaHomeType7());

      //added new fields for R2 release.
      rowcfad12sog00.setDtDtRshsLicBegin(DateHelper.toCastorDate(resourceHisrotyRow.getDtLicBegin()));
      rowcfad12sog00.setDtDtRshsLicEnd(DateHelper.toCastorDate(resourceHisrotyRow.getDtLicEnd()));
      rowcfad12sog00.setCCdRshsExchnageStat(resourceHisrotyRow.getCdExchangeStat());
      
      //SMS#97850: MR-075 Added new fields for IV-E Reimbursability for r42 release
      rowcfad12sog00.setBIndHomeIveReimbursable(resourceHisrotyRow.getIndHomeIveReimbursable());
      rowcfad12sog00.setDtDtReimbursableEffective(DateHelper.toCastorDate(resourceHisrotyRow.getDtReimbursableEffective()));
      rowcfad12sog00.setDtDtReimbursableEnd(DateHelper.toCastorDate(resourceHisrotyRow.getDtReimbursableEnd()));

      rowcfad12sog00_array.addROWCFAD12SOG00(rowcfad12sog00);
    }
    cfad12SO.setROWCFAD12SOG00_ARRAY(rowcfad12sog00_array);
    cfad12SO.setArchOutputStruct(archOutputStruct);

    return cfad12SO;
  }
}
