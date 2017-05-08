//*  Class  Name:     AdoInfoCbxDAOImpl
//*  Created by:   Jacob Vaidyan
//*  Date Created: 2/18/2007
//*
//*  Description:Provides implementation for AdoInfoCbxDAO Interface .
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbx;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbxSent;


import org.hibernate.Query;

public class AdoInfoCbxDAOImpl extends BaseDAOImpl implements  AdoInfoCbxDAO {
 
    @SuppressWarnings( { "unchecked" })
  public List<AdoInfoCbx> findAdoInfoCheckboxbyIdEventandCbxCodeType(int idEvent, String cdCbxType) {

    Query query = getSession().createQuery(
                                           " from  AdoInfoCbx cbx " + " where cbx.adoInfo.idEvent = :idEvent "
                                                           + " and cbx.cdCbxCodeType = :cdCbxType");

    query.setInteger("idEvent", idEvent);
    query.setString("cdCbxType", cdCbxType);
    return (List<AdoInfoCbx>) query.list();

  }
    @SuppressWarnings( { "unchecked" })
	public List<Integer> findIdInfoCharByCbxTypeAndEvent(int idEvent,
			String cdCbxCodeType) {
		Query query = getSession().createQuery(
				" select cbx.idInfoChar from  AdoInfoCbx cbx "
						+ " where cbx.adoInfo.idEvent = :idEvent "
						+ " and cbx.cdCbxCodeType = :cdCbxCodeType");

		query.setInteger("idEvent", idEvent);
		query.setString("cdCbxCodeType", cdCbxCodeType);
		return (List<Integer>) query.list();
	}    
    
  public void saveAdoInfoCheckBox(AdoInfoCbx adoinfocbx) {
    getSession().saveOrUpdate(adoinfocbx);
  }
  

  public void deleteAdoInfoByIdEvent(int idEvent, String cbxtype) {
            Query query = getSession().createQuery(
                                                   " delete from AdoInfoCbx cbx "
                                                                   + "       where cbx.adoInfo.idEvent = :idEvent "
                                                                   + "       and cbx.cdCbxCodeType = :cbxtype");
            query.setInteger("idEvent", idEvent);
            query.setString("cbxtype", cbxtype);
            query.executeUpdate();
  }
  
  //STGAP00010006: Gets the date last update list for the ADO INFO records based on the event Id and cdAdoInfoCbx  
  @SuppressWarnings( { "unchecked" })
  public List<Date> findAdoInfocheckboxbyIdEventandCdInfoCbx(int idEvent, String cdAdoInfoCbx) {

    Query query = getSession().createQuery(
                                           "select cbx.dtLastUpdate from  AdoInfoCbx cbx " 
                                                           + " where cbx.adoInfo.idEvent = :idEvent "
                                                           + " and cbx.cdAdoInfoCbx = :cdAdoInfoCbx " 
                                                           + " order by cbx.dtLastUpdate desc ");

    query.setInteger("idEvent", idEvent);
    query.setString("cdAdoInfoCbx",cdAdoInfoCbx);
    return (List<Date>) query.list();

  }

  /**
   * Selects a row for the given IdEvent, cdCbxCodeType, cdAdoInfoCbx
   * 
   * @param idEvent
   * @param cdCodeType
   * @param cdInfoCbx
   * 
   * return AdoInfoCbx
   */
  @SuppressWarnings( { "unchecked" })
  public AdoInfoCbx findAdoInfoCbxByIdEventCdCodeTypeCdInfoCbx(int idEvent, String cdCbxCodeType, String cdAdoInfoCbx){
    Query query = getSession().createQuery(
                                           " from AdoInfoCbx cbx "
                                                           + " where cbx.adoInfo.idEvent = :idEvent "
                                                           + " and cbx.cdCbxCodeType = :cdCbxCodeType "
                                                           + " and cbx.cdAdoInfoCbx = :cdAdoInfoCbx");

    query.setInteger("idEvent", idEvent);
    query.setString("cdCbxCodeType", cdCbxCodeType);
    query.setString("cdAdoInfoCbx", cdAdoInfoCbx);
    return (AdoInfoCbx) firstResult(query);
  }

}
