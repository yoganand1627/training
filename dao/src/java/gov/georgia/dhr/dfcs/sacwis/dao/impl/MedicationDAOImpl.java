package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.MedicationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Medication;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

public class MedicationDAOImpl extends BaseDAOImpl implements MedicationDAO {

  @SuppressWarnings({"unchecked"})
  public List<Medication> findMedicationByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
            "     from Medication a" + "    where a.person.idPerson = :idPerson"
            + " order by a.dtMedctnEndDate desc,"
            + "          a.dtMedctnPresc desc");
    query.setInteger("idPerson", idPerson);
    return (List<Medication>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findMedicationCurrentlyOnByIdPerson(int idPerson) {
    Query query = getSession().createQuery( " select new map( a.nmMedctn as nmMedctn, " +
                                            " a.txtMedctnAdminPerson as txtMedctnAdminPerson ) " +
                                            " from Medication a " + 
                                            " where a.person.idPerson = :idPerson " + 
                                            " and a.dtMedctnEndDate is null " +
                                            " order by a.dtMedctnEndDate desc" );
    query.setInteger("idPerson", idPerson);
    return ( List<Map> ) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Medication> findRelationshipByIdPerson(int idPerson, Date dteffdate) {
    Query query = getSession().createQuery(" from Medication " +
                                           "where person.idPerson = :idPerson " +
                                           "  and dtMedctnPresc <= :dteffdate " +
                                           "  and dtMedctnEndDate > :dteffdate");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dteffdate", dteffdate);
    return (List<Medication>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public int updateActiveMedication(String addLine1,String addLine2,String city,String phoneNumber,String state,
                                    String zip,String nmPharmacy,int idMedication, int idPerson, String ldNmMedctn, String ldCdMedctnDose,
                                    String ldTxtMedctnReason, Date ldDtMedctnPresc, Date ldDtMedctnEndDate,
                                    String ldTxtMedctnAdminPerson, String ldIndMedctnAllergies,
                                    String ldTxtMedctnDescrip, String ldTxtMedctnCmnts, Date dtLastUpdate, String szTxtPrescribingPerson) {

    Medication med = new Medication();

    if (idMedication != 0) {
      med = (Medication) getSession().load(Medication.class, idMedication);
    }

    Person person = new Person();
    if (idPerson != 0) {
      person = (Person) getSession().load(Person.class, idPerson);
    }

    med.setPerson(person);
    med.setNmMedctn(ldNmMedctn);
    med.setCdMedctnDose(ldCdMedctnDose);
    med.setTxtMedctnReason(ldTxtMedctnReason);
    med.setTxtMedctnAdminPerson(ldTxtMedctnAdminPerson);
    med.setDtMedctnPresc(ldDtMedctnPresc);
    med.setDtMedctnEndDate(ldDtMedctnEndDate);
    med.setIndMedctnAllergies(ldIndMedctnAllergies);
    med.setTxtMedctnDescrip(ldTxtMedctnDescrip);
    med.setTxtMedctnCmnts(ldTxtMedctnCmnts);
    med.setTxtMedctnPrescPerson(szTxtPrescribingPerson);
    
    med.setAddrPharmCity(city);
    med.setAddrPharmStLn1(addLine1);
    med.setAddrPharmStLn2(addLine2);
    med.setAddrPharmZip(zip);
    med.setCdAddrPharmState(state);
    med.setNbrPharmPhone(phoneNumber);
    med.setNmPharmacy(nmPharmacy);
    
    getSession().saveOrUpdate(med);

    return med.getIdMedication();
  }

  @SuppressWarnings({"unchecked"})
  public int updateInActiveMedication(int idMedication, int idPerson, String ldTxtMedctnDescrip,
                                      String ldTxtMedctnCmnts, Date dtLastUpdate)

  {

    Medication med = new Medication();

    if (idMedication != 0) {
      med = (Medication) getSession().load(Medication.class, idMedication);
    }

    Person person = new Person();
    if (idPerson != 0) {
      person = (Person) getSession().load(Person.class, idPerson);
    }

    med.setPerson(person);
    med.setTxtMedctnDescrip(ldTxtMedctnDescrip);
    med.setTxtMedctnCmnts(ldTxtMedctnCmnts);
    med.setIdMedication(idMedication);
    getSession().saveOrUpdate(med);
    return med.getIdMedication();

  }

  public void saveMedication(Medication medication) {
    getSession().saveOrUpdate(medication);
  }  
  
}