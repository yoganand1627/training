package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildFamLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeHomeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChildFamLink;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.SaveExchangeHomeChildFamLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeHomeChildrenSI;

import java.util.Iterator;
import java.util.List;

/**
 * This is the Service contains the methods to save Exchange Home Child family link records to the Database. <p/> <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  09/09/08   mchillman   STGAP00010004: Initial code                
 *  05/21/09   mchillman   STGAP00012047  deletion of linked records
 * </pre>
 */

public class SaveExchangeHomeChildFamLinkImpl extends BaseServiceImpl implements SaveExchangeHomeChildFamLink {

  private ExchangeChildFamLinkDAO exchangeChildFamLinkDAO = null;

  private ExchangeHomeDAO exchangeHomeDAO = null;

  private ExchangeChildDAO exchangeChildDAO = null;

  private EventDAO eventDAO = null;

  public void saveLinkedExchangeHomeChildFamLink(List<ExchangeHomeChildrenSI> exchangeHomeChildren) {
    if (exchangeHomeChildren != null && exchangeHomeChildren.size() > 0) {
      Iterator<ExchangeHomeChildrenSI> itr = exchangeHomeChildren.iterator();
      while (itr.hasNext()) {
        ExchangeHomeChildrenSI child = itr.next();
        boolean first = true;
        if (first == true) {
          // check if first for the home, if so then set the homes non-ava reason Note: all home event ids are the same
          // for each entry in the list
          List<ExchangeChildFamLink> linkedChildrenDB = exchangeChildFamLinkDAO
                                                                               .findExchangeChildFamLinksByResourceEventIdAndCurrentInd(
                                                                                                                                        child
                                                                                                                                             .getIdExchangeHomeEvent(),
                                                                                                                                        ArchitectureConstants.Y);
          if ((linkedChildrenDB != null && linkedChildrenDB.size() > 0) == false) {
            exchangeHomeDAO.updateExchangeHomeCdNonAvailStatus(child.getIdExchangeHomeEvent(),
                                                               child.getCdNonAviReasonCode());
          }
          first = false;
        }
        // check if first for the child, if so then set the child non-ava reason Note: child event ids are the different
        // for each entry in the list.
        List<ExchangeChildFamLink> linkedChildrenDB = exchangeChildFamLinkDAO
                                                                             .findExchangeChildFamLinksByChildEventIdAndCurrentInd(
                                                                                                                                   child
                                                                                                                                        .getIdExchangeChildEvent(),
                                                                                                                                   ArchitectureConstants.Y);
        if ((linkedChildrenDB != null && linkedChildrenDB.size() > 0) == false) {
          exchangeChildDAO.updateExchangeChildCdNonAvailStatus(child.getIdExchangeChildEvent(),
                                                               child.getCdNonAviReasonCode());
        }

        // create the record
        ExchangeChildFamLink exchangeChildFamLink = new ExchangeChildFamLink();
        exchangeChildFamLink.setCdNonAvailCode(child.getCdNonAviReasonCode());
        exchangeChildFamLink.setDtOut(child.getDtDateOut());
        exchangeChildFamLink
                            .setEventByIdEventChildRegistration(eventDAO
                                                                        .findEventByIdEvent(child
                                                                                                 .getIdExchangeChildEvent()));
        exchangeChildFamLink
                            .setEventByIdEventHomeRegistration(eventDAO
                                                                       .findEventByIdEvent(child
                                                                                                .getIdExchangeHomeEvent()));
        exchangeChildFamLink.setIndLinkCurrent(ArchitectureConstants.Y);
        exchangeChildFamLinkDAO.saveExchangeChildFamLink(exchangeChildFamLink);
      }
    }
  }

  public void saveUnLinkedExchangeHomeChildFamLink(List<ExchangeHomeChildrenSI> exchangeHomeChildren) {
    if (exchangeHomeChildren != null && exchangeHomeChildren.size() > 0) {
      Iterator<ExchangeHomeChildrenSI> itr = exchangeHomeChildren.iterator();
      while (itr.hasNext()) {
        ExchangeHomeChildrenSI child = itr.next();
        boolean first = true;
        if (first == true) {
          // check if first for the home, if so then set the homes non-ava reason Note: all home event ids are the same
          // for each entry in the list
          List<ExchangeChildFamLink> linkedChildrenDB = exchangeChildFamLinkDAO
                                                                               .findExchangeChildFamLinksByResourceEventIdAndCurrentInd(
                                                                                                                                        child
                                                                                                                                             .getIdExchangeHomeEvent(),
                                                                                                                                        ArchitectureConstants.Y);
          if ((linkedChildrenDB != null) && (linkedChildrenDB.size() == exchangeHomeChildren.size())) {
            exchangeHomeDAO.updateExchangeHomeCdNonAvailStatus(child.getIdExchangeHomeEvent(),
                                                               child.getCdNonAviReasonCode());
          }
          first = false;
        }

        // if we are unlinking the only link record for the child set its non-ava reason to Available
        List<ExchangeChildFamLink> linkedChildrenDB = exchangeChildFamLinkDAO
                                                                             .findExchangeChildFamLinksByChildEventIdAndCurrentInd(
                                                                                                                                   child
                                                                                                                                        .getIdExchangeChildEvent(),
                                                                                                                                   ArchitectureConstants.Y);
        if (linkedChildrenDB != null && linkedChildrenDB.size() == 1) {
          if (linkedChildrenDB.get(0).getIdExchangeChildFamLink().intValue() == child.getIdEvent().intValue()) {
            exchangeChildDAO.updateExchangeChildCdNonAvailStatus(child.getIdExchangeChildEvent(),
                                                                 child.getCdNonAviReasonCode());
          }
        }

        exchangeChildFamLinkDAO.updateExchangeHomeCdNonSelectionRsnIdExchangeChildFamLin(child.getIdEvent(),
                                                                                         child.getCdNonSelReasonCode(),
                                                                                         ArchitectureConstants.N);
      }
    }
  }

  public void updateExchangeHomeChildDateOuts(List<ExchangeHomeChildrenSI> exchangeHomeChildren) {

    if (exchangeHomeChildren != null && exchangeHomeChildren.size() > 0) {
      Iterator<ExchangeHomeChildrenSI> itr = exchangeHomeChildren.iterator();
      while (itr.hasNext()) {
        ExchangeHomeChildrenSI child = itr.next();
        boolean first = true;
        // only one home, the home event is the same for all of the entries in the list
        if (first == true) {
          exchangeHomeDAO.updateExchangeHomeDateOut(child.getIdExchangeHomeEvent());
          first = false;
        }
        exchangeChildDAO.updateExchangeChildDateOut(child.getIdExchangeChildEvent());
      }
    }
  }
  
  public void deleteExchangeHomeChildFamLink(List<ExchangeHomeChildrenSI> exchangeHomeChildren) {
    if (exchangeHomeChildren != null && exchangeHomeChildren.size() > 0) {
      Iterator<ExchangeHomeChildrenSI> itr = exchangeHomeChildren.iterator();
      while (itr.hasNext()) {
        ExchangeHomeChildrenSI child = itr.next();
        exchangeChildFamLinkDAO.deleteExchangeChildFamLink(child.getIdEvent());
      }
    }
  }

  public void setExchangeChildFamLinkDAO(ExchangeChildFamLinkDAO exchangeChildFamLinkDAO) {
    this.exchangeChildFamLinkDAO = exchangeChildFamLinkDAO;
  }

  public void setExchangeHomeDAO(ExchangeHomeDAO exchangeHomeDAO) {
    this.exchangeHomeDAO = exchangeHomeDAO;
  }

  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

}
