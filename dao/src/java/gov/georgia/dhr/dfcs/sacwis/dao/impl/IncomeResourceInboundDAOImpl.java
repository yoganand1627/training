package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeResourceInboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeResourceInbound;

import java.util.Date;

public class IncomeResourceInboundDAOImpl extends BaseDAOImpl implements IncomeResourceInboundDAO {

  public int saveIncomeResourceInboundInfo(IncomeResourceInbound incomeResourceInbound) {
    getSession().saveOrUpdate(incomeResourceInbound);
    return incomeResourceInbound.getIdIncomeResourceOutbound();
  }

  public long countIncomeAndResourceInbound(int idClient, String clientStatus, int auNumber, String cdProgramType, int bnftMonth,
                                            String cdIncRsrcInd, String cdIncRsrcType, String indEarned, String sdsIncRsrcSource,
                                            double incRsrcAmt, String cdIncRsrcFreqType, String cdIncRsrcVrf, Date dtIncRsrcFrom,
                                            Date dtIncRsrcTo, double unErndIncAmt, String cdUnErndIncFreqType, double rsrcAmt,
                                            String cdUnErndIncVrf, String auStatus, double tanfrfoodBnftAmt, String caseLoadNumber, int idIncomeResourceOutbound) {
    Query query = getSession().createQuery("select count(*) " + "  from IncomeResourceInbound r1 "
                                                           + "  where r1.idClient = :idClient "
                                                           + "  and r1.clientStatus = :clientStatus "
                                                           + "  and r1.auNumber = :auNumber "
                                                           + "  and r1.cdProgramType = :cdProgramType "
                                                           + "  and r1.bnftMonth = :bnftMonth "
                                                           + "  and r1.cdIncRsrcInd = :cdIncRsrcInd "
                                                           + "  and r1.cdIncRsrcType = :cdIncRsrcType "
                                                           + "  and r1.indEarned = :indEarned "
                                                           + "  and r1.sdsIncRsrcSource = :sdsIncRsrcSource "
                                                           + "  and r1.incRsrcAmt = :incRsrcAmt "
                                                           + "  and r1.cdIncRsrcFreqType = :cdIncRsrcFreqType "
                                                           + "  and r1.cdIncRsrcVrf = :cdIncRsrcVrf "
                                                           + "  and r1.dtIncRsrcFrom = :dtIncRsrcFrom "
                                                           + "  and r1.dtIncRsrcTo = :dtIncRsrcTo "
                                                           + "  and r1.unErndIncAmt = :unErndIncAmt "
                                                           + "  and r1.cdUnErndIncFreqType = :cdUnErndIncFreqType "
                                                           + "  and r1.cdUnErndIncVrf = :cdUnErndIncVrf "
                                                           + "  and r1.rsrcAmt = :rsrcAmt "
                                                           + "  and r1.auStatus = :auStatus "
                                                           + "  and r1.tanfrfoodBnftAmt = :tanfrfoodBnftAmt "
                                                           + "  and r1.caseLoadNumber = :caseLoadNumber "
                                                           + "  and r1.idIncomeResourceOutbound != :idIncomeResourceOutbound "
                                                           + "  and r1.returnCode is NULL"
                                                           );

    query.setInteger("idClient", idClient);
    query.setString("clientStatus", clientStatus);
    query.setInteger("auNumber", auNumber);
    query.setString("cdProgramType", cdProgramType);
    query.setInteger("bnftMonth", bnftMonth);
    query.setString("cdIncRsrcInd", cdIncRsrcInd);
    query.setString("cdIncRsrcType", cdIncRsrcType);
    query.setString("indEarned", indEarned);
    query.setString("sdsIncRsrcSource", sdsIncRsrcSource);
    query.setDouble("incRsrcAmt", incRsrcAmt);
    query.setString("cdIncRsrcFreqType", cdIncRsrcFreqType);
    query.setString("cdIncRsrcVrf", cdIncRsrcVrf);
    query.setDate("dtIncRsrcFrom", dtIncRsrcFrom);
    query.setDate("dtIncRsrcTo", dtIncRsrcTo);
    query.setDouble("unErndIncAmt", unErndIncAmt);
    query.setString("cdUnErndIncFreqType", cdUnErndIncFreqType);
    query.setString("cdUnErndIncVrf", cdUnErndIncVrf);
    query.setDouble("rsrcAmt", rsrcAmt);
    query.setString("auStatus", auStatus);
    query.setDouble("tanfrfoodBnftAmt", tanfrfoodBnftAmt);
    query.setString("caseLoadNumber", caseLoadNumber);
    query.setInteger("idIncomeResourceOutbound", idIncomeResourceOutbound);
    return (Long) query.uniqueResult();
  }
}
