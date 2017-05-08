package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceService;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveProgramCodeServices;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveProgramCodeServicesSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveProgramCodeServicesSO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RetrieveProgramCodeServicesImpl extends BaseServiceImpl implements RetrieveProgramCodeServices {
  
  private ResourceServiceDAO resourceServiceDAO;

  public void setResourceServiceDAO(ResourceServiceDAO resourceServiceDAO) {
    this.resourceServiceDAO = resourceServiceDAO;
  }


  public RetrieveProgramCodeServicesSO retrieveProgramCodeServices(RetrieveProgramCodeServicesSI retrieveProgramCodeServicesSI){
    RetrieveProgramCodeServicesSO retrieveProgramCodeServicesSO = new RetrieveProgramCodeServicesSO();
    List<ResourceService> resourceServiceList = resourceServiceDAO.findResourceServiceAll(retrieveProgramCodeServicesSI.getIdResource());
    List<Option> programCodesOptions = new ArrayList<Option>();
    Map<String, String> temp = new HashMap<String, String>();
    
    for(ResourceService resourceService : resourceServiceList){
      String cdRsrcSvcCategRsrc = resourceService.getCdRsrcSvcCategRsrc();
      // filter out duplicate codes
      if(cdRsrcSvcCategRsrc != null && !"null".equals(cdRsrcSvcCategRsrc) && !temp.containsKey(cdRsrcSvcCategRsrc)){
        String decode = Lookup.simpleDecodeSafe(CodesTables.CPRGCODE, cdRsrcSvcCategRsrc);
        if(!"".equals(decode)){
          Option option = new Option(cdRsrcSvcCategRsrc, decode);
          programCodesOptions.add(option);
        }
        temp.put(cdRsrcSvcCategRsrc, cdRsrcSvcCategRsrc);
      }    
    }
    
    retrieveProgramCodeServicesSO.setProgramCodesOptions(programCodesOptions);
    
    return retrieveProgramCodeServicesSO;
  }

}
