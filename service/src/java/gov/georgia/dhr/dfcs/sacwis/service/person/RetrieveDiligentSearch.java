package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiligentSearchInfoRetrieveSO;

public interface RetrieveDiligentSearch {
  
  /**
   * This Service calls one DAO to retrieve diligent search information for a person off the    *Diligent Search Table based on ID
   * Case. Makesure to set the page size in the input architecture record group element SYS CARC PAGE SIZE NBR. Also,
   * set the
   *
   * @param DiligentSearchInfoRetrieveSI {@link DiligentSearchInfoRetrieveSI} object
   * @return {@link DiligentSearchInfoRetrieveSO} object
   */
  public DiligentSearchInfoRetrieveSO retrieveDiligentSearchInformation(DiligentSearchInfoRetrieveSI dsiretrievesi);

}
