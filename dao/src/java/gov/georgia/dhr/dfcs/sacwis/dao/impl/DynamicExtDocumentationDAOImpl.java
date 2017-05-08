package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicExtDocumentationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ExtDocumentation;

public class DynamicExtDocumentationDAOImpl extends DynamicBaseDAOImpl implements DynamicExtDocumentationDAO {
  // Sorting constants for External Documentation
  private static final String SORT_BY_DOC_TYPE = "1";
  private static final String SORT_BY_DOC_CLASS = "3";
  private static final String SORT_BY_DATE_OBTAINED = "2";

  //STGAP00017827 MR-085 Modified to add new parameter to filter for ICPC Documents
  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findExtDocumentations(int idCase, String cdExtDocSort, List<String> docTypeList,
                                              String txtExtDocLocation, Date dtScrSearchDateFrom,
                                              Date dtScrSearchDateTo, List<Integer> personIds, List<Integer> sealedPersonIds, String sortBy, String indICPCDocument) {
    if (allNullArgs(idCase)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    Criteria criteria = buildFindExtDocCriteria(idCase, cdExtDocSort, docTypeList, txtExtDocLocation,
                                                dtScrSearchDateFrom, dtScrSearchDateTo, personIds, sealedPersonIds, sortBy, indICPCDocument);

    return (List<Object[]>) criteria.list();

  }

  //STGAP00017827 MR-085 Modified to add new parameter to filter for ICPC Documents
  @SuppressWarnings("unchecked")
  public PaginatedHibernateList<Object[]> findExtDocumentationsPaginated(int idCase, String cdExtDocSort,
                                                                         List<String> docTypeList,
                                                                         String txtExtDocLocation,
                                                                         Date dtScrSearchDateFrom,
                                                                         Date dtScrSearchDateTo,
                                                                         List<Integer> personIds, List<Integer> sealedPersonIds, String sortBy,
                                                                         String indICPCDocument, int pageNbr, int pageSize) {
    if (allNullArgs(idCase)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    Criteria criteria = buildFindExtDocCriteria(idCase, cdExtDocSort, docTypeList, txtExtDocLocation,
                                                dtScrSearchDateFrom, dtScrSearchDateTo, personIds, sealedPersonIds, sortBy, indICPCDocument);
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, criteria);
  }

  //STGAP00017827 MR-085 Modified to add new parameter to filter for ICPC Documents
  private Criteria buildFindExtDocCriteria(int idCase, String cdExtDocSort, List<String> docTypeList,
                                           String txtExtDocLocation, Date dtScrSearchDateFrom, Date dtScrSearchDateTo,
                                           List<Integer> personIds, List<Integer> sealedPersonIds,String sortBy, String indICPCDocument) {
    Criteria criteria = getSession().createCriteria(ExtDocumentation.class, "e");
    // Do a left outer Join only when the Person ID's are passed.
    if (personIds != null && personIds.size() > 0) {
      criteria.createAlias("e.extDocPerLinks", "edpl", Criteria.FULL_JOIN);
      criteria.add(Restrictions.in("edpl.personByIdPerson.idPerson", personIds));
    }
    if (sealedPersonIds != null && sealedPersonIds.size() > 0) {
      if (personIds == null || personIds.size() == 0) {
        criteria.createAlias("e.extDocPerLinks", "edpl", Criteria.FULL_JOIN);
      }
      criteria.add(Restrictions.or(Restrictions.isNull("edpl.personByIdPerson.idPerson"),Restrictions.not(Restrictions.in("edpl.personByIdPerson.idPerson", sealedPersonIds))));
    }

    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("e.idExtDocumentation"));
    projectionList.add(Projections.property("e.dtLastUpdate"));
    projectionList.add(Projections.property("e.capsCase"));
    projectionList.add(Projections.property("e.dtExtDocObtained"));
    projectionList.add(Projections.property("e.txtExtDocDetails"));
    projectionList.add(Projections.property("e.cdExtDocType"));
    projectionList.add(Projections.property("e.txtExtDocLocation"));
    projectionList.add(Projections.property("e.cdExtDocSort"));
    projectionList.add(Projections.property("e.indExtDocSigned"));
    projectionList.add(Projections.property("e.dtExtDocUploaded"));
    projectionList.add(Projections.property("e.txtFileName"));
    projectionList.add(Projections.property("e.txtFormatType"));
    projectionList.add(Projections.property("e.cdDocClass"));
    projectionList.add(Projections.property("e.dtExtDocAdded"));
    projectionList.add(Projections.property("e.indNaChecked"));
    projectionList.add(Projections.property("e.indICPCDoc"));
    projectionList.add(Projections.property("e.ucmDId"));

    criteria.setProjection(Projections.distinct(projectionList));

    criteria.add(Restrictions.eq("e.capsCase.idCase", idCase));

    if (dtScrSearchDateFrom != null) {
      criteria.add(Restrictions.ge("e.dtExtDocObtained", dtScrSearchDateFrom));
    }
    if (dtScrSearchDateTo != null && dtScrSearchDateFrom != null && dtScrSearchDateTo.equals(dtScrSearchDateFrom)) {
      gov.georgia.dhr.dfcs.sacwis.core.utility.Date idate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();
      idate.setTime(dtScrSearchDateFrom);
      idate.addHours(23);
      idate.addMinutes(59);
      idate.addSeconds(59);
      dtScrSearchDateTo = idate.getTime();
      criteria.add(Restrictions.le("e.dtExtDocObtained", dtScrSearchDateTo));
    } else if (dtScrSearchDateTo != null) {
      // R1 defect 952 fix to make the search to include the To date
      // criteria given
      gov.georgia.dhr.dfcs.sacwis.core.utility.Date tdate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();
      tdate.setTime(dtScrSearchDateTo);
      tdate.addHours(23);
      tdate.addMinutes(59);
      tdate.addSeconds(59);
      dtScrSearchDateTo = tdate.getTime();
      criteria.add(Restrictions.le("e.dtExtDocObtained", dtScrSearchDateTo));
    }

    if (docTypeList != null && docTypeList.size() > 0) {
      criteria.add(Restrictions.in("e.cdExtDocType", docTypeList));
    }
    if (StringHelper.isValid(cdExtDocSort)) {
      criteria.add(Restrictions.eq("e.cdExtDocSort", cdExtDocSort));
    }
    if (StringHelper.isValid(txtExtDocLocation)) {
      criteria.add(Restrictions.eq("e.txtExtDocLocation", txtExtDocLocation));
    }
    //STGAP00017827: Filter for ICPC documents if corresponding checkbox is checked.
    if (StringHelper.isValid(indICPCDocument)
    		&& "Y".equalsIgnoreCase(indICPCDocument)) {
      criteria.add(Restrictions.eq("e.indICPCDoc", indICPCDocument));
    }

    if (SORT_BY_DOC_TYPE.equals(sortBy)){
      criteria.addOrder(Order.asc("e.cdExtDocType"));
    }else if (SORT_BY_DATE_OBTAINED.equals(sortBy)){
      criteria.addOrder(Order.desc("e.dtExtDocObtained"));
    } else if (SORT_BY_DOC_CLASS.equals(sortBy)){
      criteria.addOrder(Order.asc("e.cdDocClass"));
    } else {
      criteria.addOrder(Order.asc("e.cdExtDocSort"));
    }
   
    return criteria;
  }
}
