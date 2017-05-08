/**
 * Created on Apr 25, 2006 at 10:22:40 AM by Michael K. Werle
 * 
 */

package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicContactDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contact;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/*CHANGE HISTORY


 ** Change History:
 **  Date        User              Description
 **  --------    --------------  ----------------------------------------------------------------------------------------
 *   07/04/2009  arege           STGAP00014326 - Modified methods to include parameter cdPurposeList instead of cdPurpose.
 *   07/30/2009  arege           STGAP00014953 - Added code so that Transfer Summary Contacts are displayed on the Search List Page.
 *   11/18/2009  arege           SMS#40650 Changed order from desc to asc on dtContactOccurred and idevent
 *   02/17/2010  swroberts       MR-061 Added conditional sorting
 */                              

public class DynamicContactDAOImpl extends DynamicBaseDAOImpl implements DynamicContactDAO {
  @SuppressWarnings({"unchecked"})
  public List<Object[]> findContacts(int idCase, int idStage, int idEvent, String cdEventStatus, String cdContactType,
                                    List cdPurposeList, String cdContactMethod, String cdContactLocation,
                                     String cdContactOthers, Date dtScrSearchDateFrom, Date dtScrSearchDateTo) {
    if(allNullArgs(idCase, idStage)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    Criteria criteria = buildFindContactsCriteria(idCase, idStage, idEvent, cdEventStatus, cdContactType, cdPurposeList, cdContactMethod,
                                                  cdContactLocation, cdContactOthers, dtScrSearchDateFrom, dtScrSearchDateTo, CONTACT_DATE_SORT, SORT_ASC); 
    
    return (List<Object[]>) criteria.list();
  }
  
  @SuppressWarnings("unchecked")
  public PaginatedHibernateList<Object[]> findContactsPaginated(int idCase, int idStage, int idEvent, String cdEventStatus, String cdContactType,
                                                                List cdPurposeList, String cdContactMethod, String cdContactLocation,
                                                                String cdContactOthers, Date dtScrSearchDateFrom, Date dtScrSearchDateTo,
                                                                int pageNbr, int pageSize, String orderBy, String orderDirection) {
    if(allNullArgs(idCase, idStage)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    Criteria criteria = buildFindContactsCriteria(idCase, idStage, idEvent, cdEventStatus, cdContactType, cdPurposeList, cdContactMethod,
                                                  cdContactLocation, cdContactOthers, dtScrSearchDateFrom, dtScrSearchDateTo, orderBy, orderDirection);
    
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, criteria);
  }
  
    
  private Criteria buildFindContactsCriteria(int idCase, int idStage, int idEvent, String cdEventStatus, String cdContactType,
                                             List<String> cdPurposeList, String cdContactMethod, String cdContactLocation,
                                             String cdContactOthers, Date dtScrSearchDateFrom, Date dtScrSearchDateTo,
                                             String orderBy, String orderDirection) {
    Criteria criteria = getSession().createCriteria(Contact.class, "c");
    criteria.createAlias("c.stage", "st", Criteria.LEFT_JOIN);
    criteria.createAlias("c.contactcbxs", "cx", Criteria.LEFT_JOIN);
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("c.dtContactOccurred"));
    projectionList.add(Projections.property("c.cdContactType"));
    projectionList.add(Projections.property("cx.cdContactCbx"));
    projectionList.add(Projections.property("c.cdContactMethod"));
    projectionList.add(Projections.property("c.indContactAttempted"));
    projectionList.add(Projections.property("st.idStage"));
    projectionList.add(Projections.property("c.event.idEvent"));
    projectionList.add(Projections.property("st.cdStage"));
    projectionList.add(Projections.property("c.cdContactLocation"));
    projectionList.add(Projections.property("c.nmAgencyName"));
    projectionList.add(Projections.property("c.indPermCrossCntyLn"));
    projectionList.add(Projections.property("c.cdContactTcmEligible"));
    projectionList.add(Projections.property("c.cdContactTcmMedSvcs"));
    projectionList.add(Projections.property("c.cdContactedBy"));
    projectionList.add(Projections.property("c.nmContactedBy"));
    projectionList.add(Projections.property("c.cdContactNarrative"));
    projectionList.add(Projections.property("c.personByIdContactTcmClient"));
    projectionList.add(Projections.property("c.person"));
    projectionList.add(Projections.property("c.cdContactOthers"));
    
    criteria.setProjection(projectionList);
    
    boolean noIdCase = idCase <= 0;
    
    Property contactStage = Property.forName("c.stage.idStage");
    if (noIdCase) {
      criteria.add(contactStage.eq(idStage));
    } else {
      //criteria.add(Restrictions.eq("c.capsCase.idCase", idCase));
      
      //-- search by all stages related to case to include INT stage contacts
      DetachedCriteria dc = DetachedCriteria.forClass(Stage.class, "s");
      dc.setProjection(Projections.property("s.idStage"));
      dc.add(Restrictions.eq("s.capsCase.idCase", idCase));
      
      criteria.add(contactStage.in(dc));
    }
    if (dtScrSearchDateFrom != null) {
      criteria.add(Restrictions.ge("c.dtContactOccurred", dtScrSearchDateFrom));
    }
    if (dtScrSearchDateTo!=null && dtScrSearchDateFrom!=null && dtScrSearchDateTo.equals(dtScrSearchDateFrom)) {
      gov.georgia.dhr.dfcs.sacwis.core.utility.Date idate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();
      idate.setTime(dtScrSearchDateFrom);
      idate.addHours(23);
      idate.addMinutes(59);
      idate.addSeconds(59);
      dtScrSearchDateTo = idate.getTime();
    }
    if (dtScrSearchDateTo != null) {
//      criteria.add(Restrictions.le("c.dtContactOccurred", dtScrSearchDateTo));
      
      //R1 defect 952 fix to make the search to include the To date criteria given
      gov.georgia.dhr.dfcs.sacwis.core.utility.Date tdate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();
      tdate.setTime(dtScrSearchDateTo);
      tdate.addHours(23);
      tdate.addMinutes(59);
      tdate.addSeconds(59);
      dtScrSearchDateTo = tdate.getTime();
      criteria.add(Restrictions.le("c.dtContactOccurred", dtScrSearchDateTo));

    }
    if (idEvent != 0) {
      criteria.add(Restrictions.eq("c.event.idEvent", idEvent));
    }
    if (StringHelper.isValid(cdContactType)) {
      // If id_case == 0, search for the exact contact type passed in.  Otherwise, this is a case search and we need to
      //   perform a like search since contact type is a keyed code.  (Ex. contact types of 'REG' actually look like
      //   'AREG', or 'DREG' in the database depending on the key.) We have to do a search without the first character.
      if (noIdCase) {
        criteria.add(Restrictions.eq("c.cdContactType", cdContactType));
      } else {
        // The String manipulation here is unsafe (the string could have length one), but this should not be a problem
        //   because it is a code value, not free text.
        criteria.add(Restrictions.like("c.cdContactType", "%" + cdContactType.substring(1, cdContactType.length())));
      }
    }
    
    Property cdCbxCodeType = Property.forName("cx.cdCbxCodeType");
    criteria.add(Restrictions.or(cdCbxCodeType.eq("CCNTPURP"), cdCbxCodeType.isNull()) );
  

    
    if (cdPurposeList != null && cdPurposeList.size() > 0) {
    //  for (int i = 0; i < cdPurposeList.size(); i++) {
       // if (StringHelper.isValid(cdPurposeList.get(i))) {
          // If id_case == 0, search for the exact contact purpose passed in. Otherwise, this is a case search and we
          // need
          // to perform a like search since contact type is a keyed code. (Ex. contact purpose of 'REG' actually look
          // like 'AREG', or 'DREG' in the database depending on the key.) We have to do a search without the first
          // character.
          if (noIdCase) {
            criteria.add(Restrictions.in("cx.cdContactCbx", cdPurposeList));
          } else {
            // The String manipulation here is unsafe (the string could have length one), but this should not be a
            // problem
            // because it is a code value, not free text.
            /*criteria.add(Restrictions.like("cx.cdContactCbx", "%"
                                                                 + cdPurposeList.get(i)
                                                                                .substring(
                                                                                           1,
                                                                                           cdPurposeList.get(i)
                                                                                                        .length())));*/
            criteria.add(Restrictions.in("cx.cdContactCbx", cdPurposeList));
          }
     //   }
    //  }
    }
    if (StringHelper.isValid(cdContactMethod)) {
      criteria.add(Restrictions.eq("c.cdContactMethod", cdContactMethod));
    }
    if (StringHelper.isValid(cdContactLocation)) {
      criteria.add(Restrictions.eq("c.cdContactLocation", cdContactLocation));
    }
    if (StringHelper.isValid(cdContactOthers)) {
      criteria.add(Restrictions.eq("c.cdContactOthers", cdContactOthers));
    }
    if (StringHelper.isValid(cdEventStatus)) {
      criteria.createAlias("c.event", "e", Criteria.INNER_JOIN);
      criteria.add(Restrictions.eq("e.cdEventStatus", cdEventStatus));
    }
    //SMS#40650 Changed order from desc to asc on dtContactOccurred and idevent
    //MR-061 Added conditional sorting on contact date
    if (CONTACT_DATE_SORT.equals(orderBy) && SORT_DESC.equals(orderDirection) ) {
      criteria.addOrder(Order.desc("c.dtContactOccurred"));
      criteria.addOrder(Order.desc("c.event.idEvent"));
    } else {
      criteria.addOrder(Order.asc("c.dtContactOccurred"));
      criteria.addOrder(Order.asc("c.event.idEvent"));
    }
    return criteria;
  }
}
