/**
 * Created on Apr 24, 2006 at 11:51:52 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class DynamicEmployeeDAOImpl extends DynamicBaseDAOImpl implements DynamicEmployeeDAO {
  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Employee> findEmployee(String cdUnitProgram, String cdUnitRegion, String cdOfficeCounty,
                                                       String nmNameLast, String nmNameFirst, String nmNameMiddle,
                                                       String nbrPersonIdNumber, int idPerson, String indActive,
                                                       String indJobAssignable,
                                                       String nbrUnit, String addrMailCodeCity,
                                                       String cdUnitSpecialization,
                                                       String cdEmpSkill, String addrMailCode, int pageNbr,
                                                       int pageSize) {
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("e.nmEmployeeLast"));
    projectionList.add(Projections.property("e.nmEmployeeFirst"));
    projectionList.add(Projections.property("e.nmEmployeeMiddle"));
    projectionList.add(Projections.property("e.idPerson"));
    projectionList.add(Projections.property("e.cdEmpBjnEmp"));
    projectionList.add(Projections.property("e.cdEmployeeClass"));
    projectionList.add(Projections.property("e.dtEmpLastAssigned"));
    projectionList.add(Projections.property("e.nbrEmpUnitEmpIn"));
    projectionList.add(Projections.property("e.cdEmpUnitregion"));
    projectionList.add(Projections.property("e.unit.idUnit"));
    projectionList.add(Projections.property("e.nmEmpOfficeName"));
    //projectionList.add(Projections.property("e.office.nmOfficeName"));
    projectionList.add(Projections.property("e.mailCode.cdMailCode"));
    projectionList.add(Projections.property("e.empJobHistory.cdJobTitle"));
    projectionList.add(Projections.property("e.cdEmpProgram"));
    projectionList.add(Projections.property("e.unit.cdCounty"));

    Criteria criteria = getSession().createCriteria(Employee.class, "e");
    // All parameters are optional.
    if (StringHelper.isValid(cdUnitProgram)) {
      // Inactive employees do not have any unit links, so the Program value
      //   that we should search on is the one on the EMPLOYEE table.
      criteria.add(Restrictions.eq("e.cdEmpProgram", cdUnitProgram));
    }
    if (StringHelper.isValid(cdUnitRegion)) {
      criteria.add(Restrictions.eq("e.cdEmpUnitRegion", cdUnitRegion));
    }
    if (StringHelper.isValid(cdOfficeCounty)) {
      // We use a subselect, not a join here, because a join would require a relationship in the HBM files that does
      //   not currently exist.
      //DetachedCriteria oclCriteria = DetachedCriteria.forClass(OfficeCountyLink.class, "ocl");
      //oclCriteria.setProjection(Projections.distinct(Projections.property("ocl.office.idOffice").as("idOffice")));
      //oclCriteria.add(Restrictions.eq("ocl.cdCounty", cdOfficeCounty));
      //criteria.add(Property.forName("e.office.idOffice").in(oclCriteria));
      criteria.add(Restrictions.eq("e.office.idOffice", new Integer(cdOfficeCounty)));
    }
    if (StringHelper.isValid(nmNameLast)) {
      // Search for names starting with the same letters as what was entered.
      //appending % to last name to indicate searching for last names that match the nmNameLast
      criteria.add(Restrictions.ilike("e.nmEmployeeLast", nmNameLast + "%"));
    }
    if (StringHelper.isValid(nmNameFirst)) {
      criteria.add(Restrictions.eq("e.nmEmployeeFirst", nmNameFirst));
    }
    if (StringHelper.isValid(nmNameMiddle)) {
      criteria.add(Restrictions.eq("e.nmEmployeeMiddle", nmNameMiddle));
    }
    // Use this to guarantee that the person table is only joined once.
    boolean personJoined = false;
    if (StringHelper.isValid(nbrPersonIdNumber)) {
      personJoined = true;
      criteria.createAlias("e.person", "p", Criteria.INNER_JOIN);
      // Search on SSN only.
      criteria.createAlias("p.personIds", "pi", Criteria.INNER_JOIN);
      criteria.add(Restrictions.eq("pi.cdPersonIdType", CodesTables.CNUMTYPE_SSN));
      criteria.add(Restrictions.eq("pi.nbrPersonIdNumber", nbrPersonIdNumber));
      criteria.add(Restrictions.isNull("pi.dtPersonIdEnd"));
    }
    if (idPerson != 0) {
      if (!personJoined) {
        criteria.createAlias("e.person", "p", Criteria.INNER_JOIN);
      }
      criteria.add(Restrictions.eq("p.idPerson", idPerson));
    }
    if (ArchitectureConstants.Y.equals(indActive) || ArchitectureConstants.N.equals(indActive)) {
      criteria.add(Restrictions.eq("e.indEmpActiveStatus", indActive));
    }
    if (ArchitectureConstants.Y.equals(indJobAssignable)) {
      criteria.add(Restrictions.eq("e.indEmpJobAssignCurr", ArchitectureConstants.Y));
    }
    if (StringHelper.isValid(nbrUnit)) {
      criteria.add(Restrictions.eq("e.nbrEmpUnitEmpIn", nbrUnit));
    }
    // Use this to guarantee that the mail_code table is joined only once.
    boolean mailCodeJoined = false;
    if (StringHelper.isValid(addrMailCodeCity)) {
      mailCodeJoined = true;
      criteria.createAlias("e.mailCode", "mc", Criteria.LEFT_JOIN);
      criteria.add(Restrictions.eq("mc.addrMailCodeCity", addrMailCodeCity));
      //criteria.add(Restrictions.eq("mc.addrMailCodeCounty", addrMailCodeCity));
    }
    if (StringHelper.isValid(addrMailCode)) {
      if (!mailCodeJoined) {
        // Use an inner join here becuase the mail code must be non-null if we are searching on it.
        criteria.createAlias("e.mailCode", "mc", Criteria.INNER_JOIN);
      }
      //criteria.add(Restrictions.eq("mc.cdMailCode", addrMailCode));
      criteria.add(Restrictions.eq("mc.addrMailCodeCounty", addrMailCode));
    }
    if (StringHelper.isValid(cdUnitSpecialization)) {
      criteria.createAlias("e.unit", "u", Criteria.LEFT_JOIN);
      criteria.add(Restrictions.eq("u.cdUnitSpecialization", cdUnitSpecialization));
    }
    if (StringHelper.isValid(cdEmpSkill)) {
      criteria.createAlias("e.employeeSkills", "es", Criteria.INNER_JOIN);
      criteria.add(Restrictions.eq("es.cdEmpSkill", cdEmpSkill));
    }
    /* if(StringHelper.isValid(cdOfficeLocation)){
        criteria.add(Restrictions.eq("e.office.nmOfficeName", cdOfficeLocation));
 
    }*/
    criteria.addOrder(Order.asc("nmEmployeeLast"));
    criteria.addOrder(Order.asc("nmEmployeeFirst"));
    return (PaginatedHibernateList<Employee>) paginatedList(pageNbr, pageSize, criteria);
  }

}
