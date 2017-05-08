package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceChrctrDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceChrctr;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveResourceCharacteristics;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG_ARRAY;

public class RetrieveResourceCharacteristicsImpl extends BaseServiceImpl implements RetrieveResourceCharacteristics {

  private ResourceChrctrDAO resourceChrctrDAO = null;

  public void setResourceChrctrDAO(ResourceChrctrDAO resourceChrctrDAO) {
    this.resourceChrctrDAO = resourceChrctrDAO;
  }

  public CRES07SO retrieveCharacteristicsData(CRES07SI cres07si) throws ServiceException {
    CRES07SO cres07so = new CRES07SO();

    ArchInputStruct archInputStruct = cres07si.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();

    // Retrievs the population characteristics for a service based on the ID resource service
    ROWCRES07SOG_ARRAY rowcres07sog_array = new ROWCRES07SOG_ARRAY();
    PaginatedHibernateList<ResourceChrctr> resourceChrctrs = resourceChrctrDAO
                                                                              .findResourceChrctrByIdResourceService(
                                                                                                                     cres07si
                                                                                                                             .getUlIdResourceService(),
                                                                                                                     pageNbr,
                                                                                                                     pageSize);
    if (resourceChrctrs == null || resourceChrctrs.size() == 0) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    archOutputStruct.setBMoreDataInd(resourceChrctrs.getBMoreDataInd());
    cres07so.setArchOutputStruct(archOutputStruct);

    for (Iterator<ResourceChrctr> it = resourceChrctrs.iterator(); it.hasNext();) {
      ResourceChrctr resourceChrctr = it.next();
      ROWCRES07SOG rowcres07sog = new ROWCRES07SOG();
      rowcres07sog.setUlIdResourceChrctr(resourceChrctr.getIdRsrcChrctr() != null ? resourceChrctr.getIdRsrcChrctr()
                                                                                 : 0);
      rowcres07sog.setTsLastUpdate(resourceChrctr.getDtLastUpdate());
      rowcres07sog.setSzCdRsrcCharChrctr(resourceChrctr.getCdRsrcCharChrctr());
      rowcres07sog.setCCdRsrcCharSex(resourceChrctr.getCdRsrcCharSex());
      rowcres07sog
                  .setUNbrRsrcCharMinMAge(resourceChrctr.getNbrRsrcCharMinMAge() != null ? resourceChrctr
                                                                                                         .getNbrRsrcCharMinMAge()
                                                                                        : 0);
      rowcres07sog
                  .setUNbrRsrcCharMaxMAge(resourceChrctr.getNbrRsrcCharMaxMAge() != null ? resourceChrctr
                                                                                                         .getNbrRsrcCharMaxMAge()
                                                                                        : 0);
      rowcres07sog
                  .setUNbrRsrcCharMinFAge(resourceChrctr.getNbrRsrcCharMinFAge() != null ? resourceChrctr
                                                                                                         .getNbrRsrcCharMinFAge()
                                                                                        : 0);
      rowcres07sog
                  .setUNbrRsrcCharMaxFAge(resourceChrctr.getNbrRsrcCharMaxFAge() != null ? resourceChrctr
                                                                                                         .getNbrRsrcCharMaxFAge()
                                                                                        : 0);
      rowcres07sog_array.addROWCRES07SOG(rowcres07sog);
    }
    cres07so.setROWCRES07SOG_ARRAY(rowcres07sog_array);
    return cres07so;
  }
}
