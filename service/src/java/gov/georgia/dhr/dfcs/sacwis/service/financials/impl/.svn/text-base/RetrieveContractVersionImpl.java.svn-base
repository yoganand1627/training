package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractVersionDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContractVersion;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveContractVersion;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON07SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON07SOG00_ARRAY;

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 09/12/2011   charden           STGAP00017058 - setting last updated by into transport object to send to page
 *
 */
public class RetrieveContractVersionImpl extends BaseServiceImpl implements RetrieveContractVersion {

  private ContractVersionDAO contractVersionDAO = null;

  public void setContractVersionDAO(ContractVersionDAO contractVersionDAO) {
    this.contractVersionDAO = contractVersionDAO;
  }

  public CCON07SO findContractVersion(CCON07SI ccon07si) throws ServiceException {
    CCON07SO ccon07so = new CCON07SO();

    List<ContractVersion> contractVersionList = contractVersionDAO
                                                                  .findContractVersionByIdContractAndNbrCnperPeriod(
                                                                                                                    ccon07si
                                                                                                                            .getUlIdContract(),
                                                                                                                    ccon07si
                                                                                                                            .getUlNbrCnverPeriod());
    if (contractVersionList == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    ROWCCON07SOG00_ARRAY rowccon07sog00_array = new ROWCCON07SOG00_ARRAY();
    for (Iterator<ContractVersion> it = contractVersionList.iterator(); it.hasNext();) {
      ContractVersion contractVersion = it.next();
      ROWCCON07SOG00 rowccon07sog00 = new ROWCCON07SOG00();
      rowccon07sog00
                    .setUlNbrCnverVersion(contractVersion.getNbrCnverVersion() != null ? contractVersion
                                                                                                        .getNbrCnverVersion()
                                                                                      : 0);
      rowccon07sog00.setUlIdCnver(contractVersion.getIdCnver() != null ? contractVersion.getIdCnver() : 0);
      rowccon07sog00.setDtDtCnverEffective(DateHelper.toCastorDate(contractVersion.getDtCnverEffective()));
      rowccon07sog00.setDtDtCnverEnd(DateHelper.toCastorDate(contractVersion.getDtCnverEnd()));
      rowccon07sog00.setDtDtCnverCreate(DateHelper.toCastorDate(contractVersion.getDtCnverCreate()));
      rowccon07sog00
                    .setUlNbrCnverNoShowPct(contractVersion.getNbrCnverNoShowPct() != null ? contractVersion
                                                                                                            .getNbrCnverNoShowPct()
                                                                                          : 0);
      rowccon07sog00.setCIndCnverVerLock(contractVersion.getIndCnverVerLock());
      rowccon07sog00.setSzTxtCnverComment(contractVersion.getTxtCnverComment());
      rowccon07sog00.setTsLastUpdate(contractVersion.getDtLastUpdate());
      rowccon07sog00.setTxtLastUpdatedBy(contractVersion.getTxtLastUpdatedBy());
      rowccon07sog00_array.addROWCCON07SOG00(rowccon07sog00);
    }
    ccon07so.setROWCCON07SOG00_ARRAY(rowccon07sog00_array);
    return ccon07so;
  }
}
