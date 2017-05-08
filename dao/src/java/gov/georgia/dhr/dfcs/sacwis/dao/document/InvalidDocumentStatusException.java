package gov.georgia.dhr.dfcs.sacwis.dao.document;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class InvalidDocumentStatusException extends BasePrsException {
  public InvalidDocumentStatusException(String msg) {
    super(msg, BasePrsException.INFORMATIONAL_PRIORITY);
  }
}