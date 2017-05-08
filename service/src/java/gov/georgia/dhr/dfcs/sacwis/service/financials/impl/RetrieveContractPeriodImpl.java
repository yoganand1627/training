package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00_ARRAY;

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 09/12/2011   charden           STGAP00017058 - inserting txtLastUpdatedBy into sctruct to be sent to the page
 *
 */
public class RetrieveContractPeriodImpl extends BaseServiceImpl implements RetrieveContractPeriod {

  private ContractPeriodDAO contractPeriodDAO = null;

  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  public CCON05SO findContractPeriod(CCON05SI ccon05si) throws ServiceException {
    CCON05SO ccon05so = new CCON05SO();
    int idContract = ccon05si.getUlIdContract();
    // clss06d
    List<ContractPeriod> listcp = contractPeriodDAO.findListOfContractPeriodByIdContract(idContract);
    ROWCCON05SOG00_ARRAY rowccon05sog00_array = new ROWCCON05SOG00_ARRAY();
    if (listcp != null) {
      for (Iterator<ContractPeriod> it = listcp.iterator(); it.hasNext();) {
        ContractPeriod cp = it.next();
        ROWCCON05SOG00 rowccon05sog00 = new ROWCCON05SOG00();
        rowccon05sog00.setUlNbrCnperPeriod(cp.getId().getNbrCnperPeriod());
        rowccon05sog00.setDtDtCnperClosure(DateHelper.toCastorDate(cp.getDtCnperClosure()));
        rowccon05sog00.setDtDtCnperStart(DateHelper.toCastorDate(cp.getDtCnperStart()));
        rowccon05sog00.setDtDtCnperTerm((DateHelper.toCastorDate(cp.getDtCnperTerm())));
        rowccon05sog00.setSzCdCnperStatus(cp.getCdCnperStatus());
        rowccon05sog00.setSzTxtCnperClosureCmt(cp.getTxtTermComm());
        rowccon05sog00.setCIndCnperRenewal(cp.getIndCnperRenewal());
        rowccon05sog00.setCIndCnperSigned(cp.getIndCnperSigned());
        rowccon05sog00.setTsLastUpdate(cp.getDtLastUpdate());
        rowccon05sog00.setTxtLastUpdatedBy(cp.getTxtLastUpdatedBy());
        rowccon05sog00_array.addROWCCON05SOG00(rowccon05sog00);
      }
    }
    ccon05so.setROWCCON05SOG00_ARRAY(rowccon05sog00_array);
    return ccon05so;
  }
}
