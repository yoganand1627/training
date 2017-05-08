package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.IncomeResourceInbound;

public interface IncomeResourceInboundDAO {

  public int saveIncomeResourceInboundInfo(IncomeResourceInbound incomeResourceInbound);
  
  public long countIncomeAndResourceInbound(int idClient, String clientStatus, int auNumber, String cdProgramType, int bnftMonth,
                                                        String cdIncRsrcInd, String cdIncRsrcType, String indEarned, String sdsIncRsrcSource,
                                                        double incRsrcAmt, String cdIncRsrcFreqType, String cdIncRsrcVrf, Date dtIncRsrcFrom,
                                                        Date dtIncRsrcTo, double unErndIncAmt, String cdUnErndIncFreqType, double rsrcAmt,
                                                        String cdUnErndIncVrf, String auStatus, double tanfrfoodBnftAmt, String caseLoadNumber,
                                                        int idIncomeResourceOutbound);
}










  
  

