package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;

public interface RetrieveResourceDetail {

  static final String TYPE_HOTLINE = CodesTables.CRSCTYPE_03;

  static final String PRIMARY_ADDR_CODE = CodesTables.CRSCADDR_01;

  static final int ZERO = 0;

  /**
   * Retrieval service called within predisplay of Rsrc Dtl window. Tables hit: Caps Resource, Rsrc Categories, Rsrc
   * School District, Rsrc Address, Phone and Rsrc Link. In only one instance is a DAM return code of no rows found
   * acceptable: if the Resource Type is a Hotline and no address records are found. In this case, since the code used
   * to populate the School District DAM input record is stored on the address table, the School District DAM will not
   * be called.
   * 
   * @param cres03si
   *          {@link CRES03SI} object
   * @return {@link CRES03SO} object
   */
  CRES03SO retrieveResourceDetail(CRES03SI cres03si);
}
