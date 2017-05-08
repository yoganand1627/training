package gov.georgia.dhr.dfcs.sacwis.web.ws;

import gov.georgia.dhr.dfcs.sacwis.structs.input.IncomeResourceWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IncomeResourceWO;

/**
 * IncomeResourceWS
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

public interface IncomeResourceWS {

  public IncomeResourceWO saveIncomeResource(IncomeResourceWI incomeResourceWI);
    
}

