package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**Change History:
*    Date        User              Description
*    --------    ----------------  --------------------------------------------------
*   06/24/2009   bgehlot           STGAP00014329: Added indPKHouseholdMember parameter in method savePersonDtl
 *  09/30/2009   bgehlot           STGAP00015485: Removed cdPKHshdMember form the Person Detail
 *  08/29/2010   htvo			   MR-067: added new field email to savePersonDtl

*/

public class PersonDtlDAOImpl extends BaseDAOImpl implements PersonDtlDAO {

  public PersonDtl findServiceAuthByIdPerson(int idPerson) {
    Query query = getSession().createQuery(" from PersonDtl p " + "where p.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (PersonDtl) firstResult(query);
  }

  public Integer findIdPersonDtlByIdPerson(int idPerson) {
    PersonDtl personDtl = findServiceAuthByIdPerson(idPerson);
    if (personDtl == null) {
      return 0;
    }

    return (Integer) personDtl.getIdPerson();
  }
  //STGAP00005989: Added SQL to give more specific messages on Placement page.
  public String findPersonCtznshipByIdPerson(int idPerson) {
    Session session = getSession();
    Query query = session.createQuery("select p.cdPersonCitizenship from PersonDtl p " 
                                      + "where p.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);
  }
  
  public void savePersonDtl(PersonDtl personDtl) {
    getSession().saveOrUpdate(personDtl);
  }

  public int insertPersonDtl(int idPerson, String cdPersonCitizenship, String indPersonNoUsBrn,
                          String cdPersonBirthCountry) {

    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PERSON_DTL (ID_PERSON, "
                                                                 + "                    CD_PERSON_CITIZENSHIP, "
                                                                 + "                    IND_PERSON_NO_US_BRN, "                                                   
                                                                 + "                    CD_PERSON_BIRTH_COUNTRY) "                                                                 
                                                                 + "     VALUES (:idPerson, "
                                                                 + "             :cdPersonCitizenship, "
                                                                 + "             :indPersonNoUsBrn, "                                                                
                                                                 + "             :cdPersonBirthCountry)");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonCitizenship", cdPersonCitizenship);
    query.setString("indPersonNoUsBrn", indPersonNoUsBrn);
    query.setString("cdPersonBirthCountry", cdPersonBirthCountry);
    return query.executeUpdate();
  }

  public int updatePersonDtl(int idPerson, String cdPersonCitizenship, String indPersonNoUsBrn,
                           String cdPersonBirthCountry) {
    Query query = getSession().createQuery(
                                           "update PersonDtl p "
                                                           + "   set p.cdPersonCitizenship = :cdPersonCitizenship "
                                                           + ", p.indPersonNoUsBrn = :indPersonNoUsBrn "
                                                           + ", p.cdPersonBirthCountry = :cdPersonBirthCountry "
                                                           + " where p.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonCitizenship", cdPersonCitizenship);
    query.setString("indPersonNoUsBrn", indPersonNoUsBrn);
    query.setString("cdPersonBirthCountry", cdPersonBirthCountry);
    return query.executeUpdate();
  }

  public int savePersonDtl(int idPersonDtl, int idPerson, String szTxtMaidenName, int lQtyPersonWeight,
                           int sQtyPersonHeightFeet, int sQtyPersonHeightInches, String szCdPersonEyeColor,
                           String szCdPersonHairColor, String szCdPersonHighestEduc, String indVerified,
                           String indRsrcHouseholdMember, String indPaternityEst, String sideOfFamily,
                           String indLegalCust, String szTxtEmail) {

    PersonDtl personDtl = new PersonDtl();

    if (idPersonDtl != 0) {
      personDtl = (PersonDtl) getSession().load(PersonDtl.class, idPersonDtl);
    }

    Person personByIdPerson = (Person) getSession().load(Person.class, idPerson);
    personDtl.setPerson(personByIdPerson);

    if (!StringHelper.EMPTY_STRING.equals(szTxtMaidenName)) {
      personDtl.setNmPersonMaidenName(szTxtMaidenName);
    }

    if (!StringHelper.EMPTY_STRING.equals(szCdPersonEyeColor)) {
      personDtl.setCdPersonEyeColor(szCdPersonEyeColor);
    }

    if (!StringHelper.EMPTY_STRING.equals(szCdPersonHairColor)) {
      personDtl.setCdPersonHairColor(szCdPersonHairColor);
    }

    if (!StringHelper.EMPTY_STRING.equals(szCdPersonHighestEduc)) {
      personDtl.setCdPersonHighestEduc(szCdPersonHighestEduc);
    }

    if (!StringHelper.EMPTY_STRING.equals(indVerified)) {
      personDtl.setIndPersonVerified(indVerified);
    }

    if (!StringHelper.EMPTY_STRING.equals(indRsrcHouseholdMember)) {
      personDtl.setIndPersonRsrcHshdMember(indRsrcHouseholdMember);
    }

    if (!StringHelper.EMPTY_STRING.equals(indPaternityEst)) {
      personDtl.setIndPersonPaternityEst(indPaternityEst);
    }

    if (!StringHelper.EMPTY_STRING.equals(indLegalCust)) {
      personDtl.setIndLegalCustody(indLegalCust);
    }
    
    if (!StringHelper.EMPTY_STRING.equals(szTxtEmail)) {
        personDtl.setTxtPersonDtlEmail(szTxtEmail);
     }

    if (lQtyPersonWeight != 0) {
      personDtl.setQtyPersonWeight(lQtyPersonWeight);
    }

    if (sQtyPersonHeightFeet != 0) {
      personDtl.setQtyPersonHeightFeet(sQtyPersonHeightFeet);
    }

    if (sQtyPersonHeightInches != 0) {
      personDtl.setQtyPersonHeightInches(sQtyPersonHeightInches);
    }

    personDtl.setCdPersonSideOfFamily(sideOfFamily);

    getSession().saveOrUpdate(personDtl);
    return personDtl.getIdPerson();
  }

  public void deletePersonDtl(PersonDtl personDtl) {
    getSession().delete(personDtl);
  }
}
