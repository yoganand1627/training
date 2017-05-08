package gov.georgia.dhr.dfcs.sacwis.service.common;

import java.rmi.RemoteException;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExternalDocumentationSO;

public interface RetrieveExternalDocumentation {

  /**
   * A retrieval service to obtain data from the External Documentation table .
   *
   * @param cinv23si
   * @return
   */

  public CINV23SO retrieveExternalDocumentation(CINV23SI cinv23si);
  /**
   * The displayExtDoc method calls the displayExtDoc method in cinv25dao, which  
   * displays the external Document.
   *
   * @param idExtDoc - id of the external document.
   * @throws RemoteException
   */

   public ExternalDocumentationSO displayExtDoc(int idExtDoc);
}
