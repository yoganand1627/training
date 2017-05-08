package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD13SO;

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 02/24/2011   hnguyen           Added Change History.
 * 02/24/2011   hnguyen           SMS#97850: MR-075 Sets new fields for FA Home Reimbursability
 * 03/26/2011   hnguyen           SMS#97850: MR-075 Update for SO element name change.
 * 03/27/2011   hnguyen           SMS#97850: MR-075 Corrected missing data population and incorrect data population.
 * 
 */

public class RetrieveResourceHistoryImpl extends BaseServiceImpl implements RetrieveResourceHistory {

  private ResourceHistoryDAO resourceHistoryDAO = null;

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  public CFAD13SO retrieveResourceHistory(CFAD13SI cfad13si) throws ServiceException {
    CFAD13SO cfad13so = new CFAD13SO();

    // rc = cses55dQUERYdam(sqlca, pCSES55DInputRec, pCSES55DOutputRec)
    ResourceHistory rsrcHist = resourceHistoryDAO.findResourceHistory(cfad13si.getUlIdResourceHistory());
    if (rsrcHist == null) {
      throw new ServiceException(Messages.MSG_DETAIL_DELETED);
    }
    StringBuffer faHomeType = new StringBuffer(7);
    faHomeType.append(rsrcHist.getCdRshsFaHomeType1());
    faHomeType.append(rsrcHist.getCdRshsFaHomeType2());
    faHomeType.append(rsrcHist.getCdRshsFaHomeType3());
    faHomeType.append(rsrcHist.getCdRshsFaHomeType4());
    faHomeType.append(rsrcHist.getCdRshsFaHomeType5());
    faHomeType.append(rsrcHist.getCdRshsFaHomeType6());
    faHomeType.append(rsrcHist.getCdRshsFaHomeType7());
    cfad13so.setCCdRshsFaHomeType1(faHomeType.toString());

    cfad13so.setDtDtRshsEffective(DateHelper.toCastorDate(rsrcHist.getDtRshsEffective()));
    cfad13so.setDtDtRshsEnd(DateHelper.toCastorDate(rsrcHist.getDtRshsEnd()));

    cfad13so.setTmScrTmGeneric1(FormattingHelper.formatTime(rsrcHist.getDtRshsEffective()));
    cfad13so.setTmScrTmGeneric5(FormattingHelper.formatTime(rsrcHist.getDtRshsClose()));

    cfad13so.setSzCdRshsCategory(rsrcHist.getCdRshsCategory());
    cfad13so.setSzCdRshsFaHomeStatus(rsrcHist.getCdRshsFaHomeStatus());
    cfad13so.setUNbrRshsFacilCapacity(
            rsrcHist.getNbrRshsFacilCapacity() != null ? rsrcHist.getNbrRshsFacilCapacity() : 0);
    cfad13so.setUNbrRshsMaAgeMin(rsrcHist.getNbrRshsMaAgeMin() != null ? rsrcHist.getNbrRshsMaAgeMin() : 0);
    cfad13so.setUNbrRshsMaAgeMax(rsrcHist.getNbrRshsMaAgeMax() != null ? rsrcHist.getNbrRshsMaAgeMax() : 0);
    cfad13so.setUNbrRshsFMAgeMin(rsrcHist.getNbrRshsFmAgeMin() != null ? rsrcHist.getNbrRshsFmAgeMin() : 0);
    cfad13so.setUNbrRshsFMAgeMax(rsrcHist.getNbrRshsFmAgeMax() != null ? rsrcHist.getNbrRshsFmAgeMax() : 0);
    cfad13so.setSzCdRshsClosureRsn(rsrcHist.getCdRshsClosureRsn());
    cfad13so.setSzCdRshsRecmndReopen(rsrcHist.getCdRshsRecmndReopen());
    cfad13so.setSzCdRshsInvolClosure(rsrcHist.getCdRshsInvolClosure());

    cfad13so.setSzAddrRshsAttn(rsrcHist.getAddrRshsAttn());
    cfad13so.setSzAddrRshsCity(rsrcHist.getAddrRshsCity());
    cfad13so.setSzAddrRshsStLn1(rsrcHist.getAddrRshsStLn1());
    cfad13so.setSzAddrRshsStLn2(rsrcHist.getAddrRshsStLn2());
    cfad13so.setLAddrRshsZip(rsrcHist.getAddrRshsZip());
    cfad13so.setSzCdRshsCampusType(rsrcHist.getCdRshsCampusType());
    cfad13so.setSzCdRshsCertBy(rsrcHist.getCdRshsCertBy());
    cfad13so.setSzCdRshsCnty(rsrcHist.getCdRshsCnty());
    cfad13so.setSzCdRshsEthnicity(rsrcHist.getCdRshsEthnicity());
    cfad13so.setSzCdRshsFacilType(rsrcHist.getCdRshsFacilType());
    cfad13so.setSzCdRshsHub(rsrcHist.getCdRshsHub());
    cfad13so.setSzCdRshsLanguage(rsrcHist.getCdRshsLanguage());
    cfad13so.setSzCdRshsMaintainer(rsrcHist.getCdRshsMaintainer());
    cfad13so.setSzCdRshsMaritalStatus(rsrcHist.getCdRshsMaritalStatus());
    cfad13so.setSzCdRshsOperBy(rsrcHist.getCdRshsOperBy());
    cfad13so.setSzCdRshsOwnership(rsrcHist.getCdRshsOwnership());
    cfad13so.setSzCdRshsPayment(rsrcHist.getCdRshsPayment());
    cfad13so.setSzCdRshsRegion(rsrcHist.getCdRshsRegion());
    cfad13so.setSzCdRshsReligion(rsrcHist.getCdRshsReligion());
    cfad13so.setSzCdRshsRespite(rsrcHist.getCdRshsRespite());
    cfad13so.setSzCdRshsSchDist(rsrcHist.getCdRshsSchDist());
    cfad13so.setSzCdRshsSetting(rsrcHist.getCdRshsSetting());
    cfad13so.setSzCdRshsSourceInquiry(rsrcHist.getCdRshsSourceInquiry());
    cfad13so.setSzCdRshsState(rsrcHist.getCdRshsState());
    cfad13so.setSzCdRshsStatus(rsrcHist.getCdRshsStatus());
    cfad13so.setSzCdRshsType(rsrcHist.getCdRshsType());

    cfad13so.setDtDtRshsCert(DateHelper.toCastorDate(rsrcHist.getDtRshsCert()));
    cfad13so.setDtDtRshsClose(DateHelper.toCastorDate(rsrcHist.getDtRshsClose()));
    cfad13so.setDtDtRshsMarriage(DateHelper.toCastorDate(rsrcHist.getDtRshsMarriage()));

    cfad13so.setUlIdResource(rsrcHist.getIdResourceHistory() != null ? rsrcHist.getIdResourceHistory() : 0);
    cfad13so.setUlIdEvent(rsrcHist.getEvent().getIdEvent() != null ? rsrcHist.getEvent().getIdEvent() : 0);
    cfad13so.setUlIdStage(rsrcHist.getStage().getIdStage() != null ? rsrcHist.getStage().getIdStage() : 0);

    cfad13so.setCIndRshsCareProv(rsrcHist.getIndRshsCareProv());
    cfad13so.setCIndRshsEmergPlace(rsrcHist.getIndRshsEmergPlace());
    cfad13so.setCIndRshsInactive(rsrcHist.getIndRshsInactive());
    cfad13so.setCIndCurrHomeStudyExists(rsrcHist.getIndCurrHmStdyExsts());
    cfad13so.setCIndRshsNonDFCSHome(rsrcHist.getIndRsrcNondfcs());

    cfad13so.setSzTxtNdfcsCertEntity(rsrcHist.getNdfcsCertEntity());
    cfad13so.setCIndRshsTransport(rsrcHist.getIndRshsTransport());

    cfad13so.setDNbrRshsAnnualIncome(rsrcHist.getNbrRshsAnnualIncome());
    cfad13so.setLNbrRshsCampusNbr(rsrcHist.getNbrRshsCampusNbr() != null ? rsrcHist.getNbrRshsCampusNbr() : 0);
    cfad13so.setLNbrRshsFacilAcclaim(rsrcHist.getNbrRshsFacilAcclaim() != null ? rsrcHist.getNbrRshsFacilAcclaim() : 0);

    cfad13so.setUNbrRshsIntChildren(rsrcHist.getNbrRshsIntChildren() != null ? rsrcHist.getNbrRshsIntChildren() : 0);
    cfad13so.setUNbrRshsIntFeAgeMax(rsrcHist.getNbrRshsIntFeAgeMax() != null ? rsrcHist.getNbrRshsIntFeAgeMax() : 0);
    cfad13so.setUNbrRshsIntFeAgeMin(rsrcHist.getNbrRshsIntFeAgeMin() != null ? rsrcHist.getNbrRshsIntFeAgeMin() : 0);
    cfad13so.setUNbrRshsIntMaAgeMax(rsrcHist.getNbrRshsIntMaAgeMax() != null ? rsrcHist.getNbrRshsIntMaAgeMax() : 0);
    cfad13so.setUNbrRshsIntMaAgeMin(rsrcHist.getNbrRshsIntMaAgeMin() != null ? rsrcHist.getNbrRshsIntMaAgeMin() : 0);
    cfad13so.setSNbrRshsOpenSlots(rsrcHist.getNbrRshsOpenSlots() != null ? rsrcHist.getNbrRshsOpenSlots() : 0);

    cfad13so.setSzNbrRshsPhn(rsrcHist.getNbrRshsPhn());
    cfad13so.setLNbrRshsPhoneExtension(rsrcHist.getNbrRshsPhoneExt());
    cfad13so.setSzNbrRshsVid(rsrcHist.getNbrRshsVid());
    cfad13so.setSzNmRshsContact(rsrcHist.getNmRshsContact());
    cfad13so.setSzNmRshsLastUpdate(rsrcHist.getNmRshsLastUpdate());
    cfad13so.setSzNmRshsResource(rsrcHist.getNmRshsResource());
    cfad13so.setSzTxtRshsAddrCmnts(rsrcHist.getTxtRshsAddrCmnts());
    cfad13so.setSzTxtRshsComments(rsrcHist.getTxtRshsComments());
    // SMS#97850: MR-075 sets new fields for FA Home Reimbursability
    cfad13so.setBIndHomeIveReimbursable(rsrcHist.getIndHomeIveReimbursable());
    cfad13so.setDtDtReimbursableEffective(DateHelper.toCastorDate(rsrcHist.getDtReimbursableEffective()));
    cfad13so.setDtDtReimbursableEnd(DateHelper.toCastorDate(rsrcHist.getDtReimbursableEnd()));

    cfad13so.setTsLastUpdate(rsrcHist.getDtLastUpdate());
    return cfad13so;
  }
}