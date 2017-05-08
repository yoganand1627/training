package gov.georgia.dhr.dfcs.sacwis.service.admin;
/**
 * Created on July 21, 2008 by Vishala Devarakonda
 */

import gov.georgia.dhr.dfcs.sacwis.structs.input.CodeDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicationSaveSO;

import java.util.Date;

public interface SaveCodeDetail {

  /**
   * This service will save data to the tables CodesTables and CodesTablesHistory 
   *
   * @param CodeDetailSaveSI 
   * @return 
   */
  public void saveCodeDetail(CodeDetailSaveSI codeDetailSaveSI);
}