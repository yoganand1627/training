package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecialNeedsDeterminationSaveSO;

/** @author vishala devarakonda */
public interface SaveSpecialNeedsDetermination {

  /**
   * This Service calls a DAO to update the Special Needs determination table.
   * 
   * @param SpecialNeedsDeterminationSaveSI
   *          {@link gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationSaveSI} object
   * @return {@link SpecialNeedsDeterminationSaveSO} object
   */
  public SpecialNeedsDeterminationSaveSO saveSpecialNeedsDetermination(SpecialNeedsDeterminationSaveSI spNdsDetermSaveSI);
}
