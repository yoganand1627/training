package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.MailCodeDAO;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/**
 * <pre>
 * Change History:
 * Date       User              Description
 * --------   ----------------  --------------------------------------------------
 * 02/09/2012 schoi             STGAP00017831: MR-102 Added new methods findMailCodeByCdCountyForSvcAuthFormPmtCntyField
 *                              and findMailCodeByCdCountyForSvcAuthFormLegalCntyField
 * </pre>
 */

public class MailCodeDAOImpl extends BaseDAOImpl implements MailCodeDAO {

  @SuppressWarnings("unchecked")
  public List<String> findCdCityGACountyFromCityByNmCity(String city ) {
    city = StringHelper.getSafeString(city);
    
    
    city = city.substring(0, 1).toUpperCase() + city.substring(1, city.length()).toLowerCase();
  
  Query query = getSession().createQuery("select distinct m.addrMailCodeCounty" +
                                         "  from MailCode m " +
                                         " where m.addrMailCodeCity = :city");
  query.setString("city", city);
  return (List<String>) query.list();
  }
  
  public Object[] findMailCodeByCdCountyForSSAU(String cdCounty) {
    Query query = getSession().createSQLQuery("select m.cd_mail_code as cdMailCode, " +
    		" m.addr_mail_code_st_ln_1 as addrLine1, " +
    		" m.addr_mail_code_st_ln_2 as addrLine2, " +
    		" m.addr_mail_code_city as city, " +
    		" m.addr_mail_code_zip as zip, " +
    		" m.nbr_mail_code_phone as phone " +
    		" from mail_code m, office o, COFCNM_SSAU_VIEW c " +
    		" where m.cd_mail_code = o.cd_office_mail " +
    		" and o.id_office = c.code " +
    		" and m.addr_mail_code_county = :cdCounty " +
    		" order by m.cd_mail_code asc "); // to exclude State Office code 999; the county that has the State Office would return 2 results for this sql 

    query.setString("cdCounty", cdCounty);
    return (Object[])firstResult(query);
  }

  // STGAP00017831: MR-102
  // Find Mail Code by cdCounty; this query is for Payment County field on the Service Authorization form
  @SuppressWarnings({"unchecked"})
  public Object[] findMailCodeByCdCountyForSvcAuthFormPmtCntyField(String cdCounty) {
    Query query = getSession().createSQLQuery("select m.cd_mail_code as cdMailCode, " +
                " m.addr_mail_code_st_ln_1 as addrLine1, " +
                " m.addr_mail_code_st_ln_2 as addrLine2, " +
                " m.addr_mail_code_city as city, " +
                " m.addr_mail_code_zip as zip, " +
                " m.nbr_mail_code_phone as phone " +
                " from mail_code m, office o, COFCNM_SVC_AUTH_PMT_CNTY_VIEW c " +
                " where m.cd_mail_code = o.cd_office_mail " +
                " and o.id_office = c.code " +
                " and m.addr_mail_code_county = :cdCounty " +
                " order by m.cd_mail_code asc "); // to exclude State Office code 999; the county that has the State Office would return 2 results for this sql 

    query.setString("cdCounty", cdCounty);
    return (Object[])firstResult(query);
  }
  
  // STGAP00017831: MR-102
  // Find Mail Code by cdCounty; this query is for Legal County field on the Service Authorization form
  @SuppressWarnings({"unchecked"})
  public Object[] findMailCodeByCdCountyForSvcAuthFormLegalCntyField(String cdCounty) {
    Query query = getSession().createSQLQuery("select m.cd_mail_code as cdMailCode, " +
                " m.addr_mail_code_st_ln_1 as addrLine1, " +
                " m.addr_mail_code_st_ln_2 as addrLine2, " +
                " m.addr_mail_code_city as city, " +
                " m.addr_mail_code_zip as zip, " +
                " m.nbr_mail_code_phone as phone " +
                " from mail_code m, office o, COFCNM_SVC_AUTH_LEGAL_VIEW c " +
                " where m.cd_mail_code = o.cd_office_mail " +
                " and o.id_office = c.code " +
                " and m.addr_mail_code_county = :cdCounty " +
                " order by m.cd_mail_code asc "); // to exclude State Office code 999; the county that has the State Office would return 2 results for this sql 

    query.setString("cdCounty", cdCounty);
    return (Object[])firstResult(query);
  }
}
