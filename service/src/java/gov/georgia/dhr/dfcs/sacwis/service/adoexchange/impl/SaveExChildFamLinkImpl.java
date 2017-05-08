package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildFamLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeHomeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChildFamLink;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeHome;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.SaveExChildFamLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildLinkStruct;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SaveExChildFamLinkImpl extends BaseServiceImpl implements SaveExChildFamLink {

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
  public void saveExChildFamLink(List<ChildLinkStruct> childLinkStructList) {
    if (childLinkStructList != null && childLinkStructList.size() > 0) {
      Iterator it = childLinkStructList.iterator();
      // Get the Child registration event id, non availability code and date out. These are the same for
      // all the link records.
      int idChildRegEvent = childLinkStructList.get(0).getIdChildEvent();
      Date dtOut = childLinkStructList.get(0).getDtOut();
      String cdNonAvailRsnCode = childLinkStructList.get(0).getNonAvlRsnCode();
      // Checks if there are any existing homes linked to the child
      Long count = exchangeChildFamLinkDAO.countExcChildFamLinksByChildRegEventIdAndCurInd(idChildRegEvent,
                                                                                           ArchitectureConstants.Y);
      // Gets the minimum Date Out value of all the Homes links to the child before inserting the new link
      Date minChildDateOut = exchangeChildFamLinkDAO.findMinDtOutByChildRegEventIdAndCurInd(idChildRegEvent,
                                                                                            ArchitectureConstants.Y);
      while (it.hasNext()) {
        ChildLinkStruct childLinkStruct = (ChildLinkStruct) it.next();
        ExchangeChildFamLink exchangeChildFamLink = new ExchangeChildFamLink();
        int idHomeRegEvent = childLinkStruct.getIdHomeEvent();
        // Checks if the home that is being linked to the current child has any other children linked to it.
        Long count1 = exchangeChildFamLinkDAO.countExcChildFamLinksByHomeRegEventIdAndCurInd(idHomeRegEvent,
                                                                                             ArchitectureConstants.Y);
        // Gets the minimum Date Out value of all the Children linked to the current home before inserting the new link
        Date minFamDateOut = exchangeChildFamLinkDAO.findMinDtOutByHomeRegEventIdAndCurInd(idHomeRegEvent,
                                                                                           ArchitectureConstants.Y);
        ExchangeHome exchangeHome = getPersistentObject(ExchangeHome.class, idHomeRegEvent);
        // If there are no existing links to any children from the current home, set the homes's non availability reason
        // code to the non-availability reason code selected on the page for the current link
        if (count1 == null || count1 <= 0) {
          exchangeHome.setCdNonAvailStatus(cdNonAvailRsnCode);
        }
        // If the date out selected on the page is less than the minimum Date Out of all the existing links to the home
        // then set the home's date out to the selected date out. Else set the home's date out to the minimum date out.
        if (minFamDateOut==null || DateHelper.isBefore(dtOut, minFamDateOut)) {
          exchangeHome.setDtOut(dtOut);
        } else{
          exchangeHome.setDtOut(minFamDateOut);
        }
        // Update the Exchange home registration record for the current home
        exchangeHomeDAO.saveUpdatExchangeHome(exchangeHome);
        exchangeChildFamLink.setCdNonAvailCode(cdNonAvailRsnCode);
        exchangeChildFamLink.setDtOut(dtOut);
        exchangeChildFamLink.setIndLinkCurrent(ArchitectureConstants.Y);
        exchangeChildFamLink.setEventByIdEventChildRegistration(getPersistentObject(Event.class,
                                                                                    childLinkStruct.getIdChildEvent()));
        exchangeChildFamLink.setEventByIdEventHomeRegistration(getPersistentObject(Event.class, idHomeRegEvent));
        // Insert a record in the Exchange Child Fam Link table a record linking the child registration event with the
        // current home registration event
        exchangeChildFamLinkDAO.saveExchangeChildFamLink(exchangeChildFamLink);
      }
      ExchangeChild exchangeChild = getPersistentObject(ExchangeChild.class, idChildRegEvent);
      // If there are no existing links to any Homes from the child, set the child's non availability reason
      // code to the non-availability reason code selected on the page for the current link
      if (count == null || count <= 0) {
        exchangeChild.setCdNonAvailStatus(cdNonAvailRsnCode);
      }
      // If the date out selected on the page is less than the minimum Date Out of all the existing links to the child
      // then set the child's date out to the selected date out. Else set the child's date out to the minimum date out.
      if (minChildDateOut==null || DateHelper.isBefore(dtOut, minChildDateOut)) {
        exchangeChild.setDtOut(dtOut);
      }else{
        exchangeChild.setDtOut(minChildDateOut);
      }
      // Update the Exchange Child Registration record
      exchangeChildDAO.saveExchangeChild(exchangeChild);
    }

  }
}
