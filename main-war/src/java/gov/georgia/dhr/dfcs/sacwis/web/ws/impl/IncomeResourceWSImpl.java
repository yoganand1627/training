package gov.georgia.dhr.dfcs.sacwis.web.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.service.ws.WS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IncomeResourceWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IncomeResourceWO;
import gov.georgia.dhr.dfcs.sacwis.web.ws.IncomeResourceWS;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * IncomeResourceWSImpl
 * 
 * @author Srinivasa Rao Dodda
 * @version 1.0
 * 
 * <pre>
 *             Change History:
 *             Date      User              Description
 *             --------  ----------------  --------------------------------------------------
 * </pre>
 */

public class IncomeResourceWSImpl implements IncomeResourceWS{
  
  Log log = LogFactory.getLog(IncomeResourceWS.class);

  private WS ws;

  public void setWS(WS ws) {
    this.ws = ws;
  }


  public IncomeResourceWO saveIncomeResource(IncomeResourceWI incomeResourceWI) {
    log.info(">> Inside IncomeResourceWSImpl-saveIncomeResource()");
    return ws.saveIncomeResource(incomeResourceWI);
      }

  
}

