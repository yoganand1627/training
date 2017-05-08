package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.structs.input.DocumentTemplateSI;

public interface RetrieveDocumentTemplate {
  /**
   * This service will retrieve the template id based on doc name, and version
   *
   * @param DocumentTemplateSI
   * @return Integer
   */
  Integer retrieveDocumentTemplate(DocumentTemplateSI documentTemplateSI);
}
