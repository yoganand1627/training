package gov.georgia.dhr.dfcs.sacwis.web.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ResourceUpdateResponseWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ResponseWO;
import gov.georgia.dhr.dfcs.sacwis.web.ws.SaveResourceUpdateResponseWS;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SaveResourceUpdateResponseWSImpl implements SaveResourceUpdateResponseWS {

  Log log = LogFactory.getLog(SaveResourceUpdateResponseWSImpl.class);
 
  private Resource rs;

  public void setResource(Resource rs) {
    this.rs = rs;
  }

  public ResponseWO saveResourceUpdateResponse(ResourceUpdateResponseWI resourceUpdateWI) {
    log.info(">> Inside SaveResourceUpdateResponseWSImpl-saveResourceUpdateResponse()");
    return rs.saveResourceUpdateResponse(resourceUpdateWI);
  }
}
