package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildFamLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeHomeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChildFamLink;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeHome;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.SaveExChildFamUnlink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildLinkStruct;

import java.util.Iterator;
import java.util.List;

/*Change History:
     Date       User        Description
     --------   --------    --------------------------------------------------
     04/22/09   mxpatel     STGAP00013188: Removed the code that was updating cdNonAvailRsnCode
                            in the exchangeChildFamLink table.
     07/28/09   mxpatel     STGAP00012979: added code to update dtOut when unlinking a home.
*/
public class SaveExChildFamUnlinkImpl extends BaseServiceImpl implements SaveExChildFamUnlink {

  private ExchangeChildFamLinkDAO exchangeChildFamLinkDAO = null;

  private ExchangeChildDAO exchangeChildDAO = null;

  private ExchangeHomeDAO exchangeHomeDAO = null;

  public ExchangeChildFamLinkDAO getExchangeChildFamLinkDAO() {
    return exchangeChildFamLinkDAO;
  }

  public void setExchangeChildFamLinkDAO(ExchangeChildFamLinkDAO exchangeChildFamLinkDAO) {
    this.exchangeChildFamLinkDAO = exchangeChildFamLinkDAO;
  }

  public ExchangeChildDAO getExchangeChildDAO() {
    return exchangeChildDAO;
  }

  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }

  public ExchangeHomeDAO getExchangeHomeDAO() {
    return exchangeHomeDAO;
  }

  public void setExchangeHomeDAO(ExchangeHomeDAO exchangeHomeDAO) {
    this.exchangeHomeDAO = exchangeHomeDAO;
  }

  @SuppressWarnings( { "unchecked" })
  public void saveExChildFamUnlink(List<ChildLinkStruct> childLinkStructList) {

    if (childLinkStructList != null && childLinkStructList.size() > 0) {
      Iterator it = childLinkStructList.iterator();
      int idChildRegEvent = childLinkStructList.get(0).getIdChildEvent();
      String cdNonAvailRsnCode = childLinkStructList.get(0).getNonAvlRsnCode();
      String cdNonSelectionRsn = childLinkStructList.get(0).getNonSelRsn();
      // Checks if there are any existing homes linked to the child
      Long count = exchangeChildFamLinkDAO.countExcChildFamLinksByChildRegEventIdAndCurInd(idChildRegEvent,
                                                                                           ArchitectureConstants.Y);
      while (it.hasNext()) {
        ChildLinkStruct childLinkStruct = (ChildLinkStruct) it.next();
        ExchangeChildFamLink exchangeChildFamLink = new ExchangeChildFamLink();
        int idHomeRegEvent = childLinkStruct.getIdHomeEvent();
        // Checks if the home that is being unlinked to the current child has any other children linked to it.
        Long count1 = exchangeChildFamLinkDAO.countExcChildFamLinksByHomeRegEventIdAndCurInd(idHomeRegEvent,
                                                                                             ArchitectureConstants.Y);
        ExchangeHome exchangeHome = getPersistentObject(ExchangeHome.class, idHomeRegEvent);
        // If this is the only link to any children from the current home, set the homes's non availability reason
        // code to the selected reason code
        if (count1 != null && count1 == 1) {
            exchangeHome.setCdNonAvailStatus(cdNonAvailRsnCode);
        }
        // Update the Exchange home registration record for the current home
        exchangeHomeDAO.saveUpdatExchangeHome(exchangeHome);
        exchangeChildFamLink = exchangeChildFamLinkDAO
                                                      .findExchangeChildFamLinksByChildEventIdByHomeEventIdBYCurrentInd(
                                                                                                                        idChildRegEvent,
                                                                                                                        idHomeRegEvent,
                                                                                                                        ArchitectureConstants.Y);
        exchangeChildFamLink.setIndLinkCurrent(ArchitectureConstants.N);
        exchangeChildFamLink.setCdNonSelectionRsn(cdNonSelectionRsn);
        // Update the Exchange Child Fam Link table record linking the child registration event with the
        // current home registration event with the Unlink information
        exchangeChildFamLinkDAO.saveExchangeChildFamLink(exchangeChildFamLink);
      }
      ExchangeChild exchangeChild = getPersistentObject(ExchangeChild.class, idChildRegEvent);
      // If all the homes that are linked to the child are being unlinked than update the non-availability
      // code for the Exchange Child record
      if (count != null && count == childLinkStructList.size()) {
        exchangeChild.setCdNonAvailStatus(cdNonAvailRsnCode);
        exchangeChild.setDtOut(null);
      } else {
        // STGAP00012979: if the house being unlinked is not the last house linked to the child, update the date out to
        // earliest link date
        exchangeChildDAO.updateExchangeChildDateOut(idChildRegEvent);
      }

      // Update the Exchange Child Registration record
      exchangeChildDAO.saveExchangeChild(exchangeChild);
    }

  }
  
  public void deleteExChildFamUnlink(List<ChildLinkStruct> childLinkStructList) {
    if (childLinkStructList != null && childLinkStructList.size() > 0) {
      Iterator<ChildLinkStruct> it = childLinkStructList.iterator();
      while (it.hasNext()) {
        ChildLinkStruct childLinkStruct = (ChildLinkStruct) it.next();
        exchangeChildFamLinkDAO.deleteExchangeChildFamLink(childLinkStruct.getIdExchangeChildFamLink());
      }
    }
  }
}
