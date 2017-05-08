//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  07/18/08  mxpatel           STGAP00007271 Edited the SQL statement in findPersonsByNmLastNmFirst3 method 
//**                              to joining two tables (Name and Person) so that the merged person is no longer
//**                              retrieved by the search.
//**  12/31/08  SSUBRAM           STGAP00011764: Modified the string checking from == to .equals method
          
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ComplexNameDAOImpl extends BaseDAOImpl implements ComplexNameDAO {
  private NameDAO nameDAO = null;

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public List<Integer> findPrimaryIdPersonsByFirstLastMiddle(String first, String last, String middle, String indSealed) {

    if (StringHelper.isValid(middle)) {
      return nameDAO.findPrimaryIdPersonsByFirstLastMiddle(first, last, middle, indSealed);
    } else {
      return nameDAO.findPrimaryIdPersonsByFirstLast(first, last, indSealed);
    }
  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findPersonsByNmLastNmFirst3(String last, String first, String indSealed) {
    Session session = getSession();
    //STGAP00010705: filters out the Adopted Persons if the Sealed Indicator attribute of the user is N
    //STGAP00010967: Added a null check to the cdPersonStatus
    String adoString = (indSealed.equals(ArchitectureConstants.N))?" and (p.indAdopted <> 'Y' or p.indAdopted is null) ":"";
    
    Query query = session.createQuery("select n.person.idPerson "
                                      + "  from Name n, Person p "
                                      + // mxpatel added person p
                                      " where n.person.idPerson = p.idPerson"
                                      + // mxpatel add this code
                                      " and n.nmNameFirst like :first " 
                                      + "   and n.nmNameLast like :last "
                                      + adoString
                                      + "   and n.indNamePrimary = 'Y' " 
                                      + "   and (n.dtNameEndDate is null "
                                      + "        or n.dtNameEndDate = :maxDate) " 
                                      + "   and (p.cdPersonStatus is null "
                                      + "        or p.cdPersonStatus <> 'M')"); // mxpatel
    // added
    // this
    query.setString("first", first + "%");
    query.setString("last", last + "%");
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Integer>) query.list();
  }

  public int insertNameCheckDtNameEndDateForNull(String cdNameSuffix, Date dtNameEndDate, int idName, int idPerson,
                                                 String indNameInvalid, String indNamePrimary, String nmNameFirst,
                                                 String nmNameLast, String nmNameMiddle) {
    // Typically, DT_NAME_END_DATE will be NULL_DATE when
    // passed in. This is fine since a trigger will set it
    // to MAX_DATE for us. However, it is possible for us to have
    // enddated the name at the same time it was created.
    // In this case, we want to set DT_NAME_END_DATE to SYSDATE.
    if (dtNameEndDate == null || DateHelper.MAX_JAVA_DATE.equals(dtNameEndDate)) {
      return nameDAO.insertName(cdNameSuffix, dtNameEndDate, idName, idPerson, indNameInvalid, indNamePrimary,
                                nmNameFirst, nmNameLast, nmNameMiddle);
    } else {
      return nameDAO.insertName(cdNameSuffix, idName, idPerson, indNameInvalid, indNamePrimary, nmNameFirst,
                                nmNameLast, nmNameMiddle);
    }
  }

  public int updateNameCheckDtNameEndDateForNull(String cdNameSuffix, Date dtNameEndDate, int idName, int idPerson,
                                                 String indNameInvalid, String indNamePrimary, String nmNameFirst,
                                                 String nmNameLast, String nmNameMiddle, Date lastUpdate) {
    Date endDate = null;
    if (dtNameEndDate != null) {
      
      //STGAP00006688 When adding a new name then set the old ones primary indicator to N.  There can only be 
      // on primary name per person. 
     if(DateHelper.MAX_JAVA_DATE.equals(dtNameEndDate));{
       indNamePrimary = "N";
     }
 
      endDate = nameDAO.findNameDtNameEndDateByIdName(idName);
    }
    if ((dtNameEndDate != null) && (endDate == null || DateHelper.MAX_JAVA_DATE.equals(endDate))) {
      return nameDAO.updateNameIncludingDtNameEndDate(cdNameSuffix, idPerson, indNameInvalid, indNamePrimary,
                                                      nmNameFirst, nmNameLast, nmNameMiddle, idName,
                                                      DateHelper.MAX_JAVA_DATE);
    } else {
      return nameDAO.updateName(cdNameSuffix, idPerson, indNameInvalid, indNamePrimary, nmNameFirst, nmNameLast,
                                nmNameMiddle, idName, DateHelper.MAX_JAVA_DATE);
    }
  }
}
