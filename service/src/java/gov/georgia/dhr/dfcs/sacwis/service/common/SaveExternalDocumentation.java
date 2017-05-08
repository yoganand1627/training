package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.utility.UCMDataObject;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExternalDocumentationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV22SO;

public interface SaveExternalDocumentation {

  /**
   * An AUD service to add, update, or delete External Documentation records.
   *
   * @param cinv22si, isUploadFile
   * @return
   */

  public CINV22SO saveExternalDocumentation(CINV22SI cinv22si, boolean isUploadFile, ExternalDocumentationSI extDocSI);

  /**
   * Service to upload the document on UCM Server 
   * @param ucmData
   * @return
   */
  public String uploadDocumentToUCM(UCMDataObject ucmData);
}
