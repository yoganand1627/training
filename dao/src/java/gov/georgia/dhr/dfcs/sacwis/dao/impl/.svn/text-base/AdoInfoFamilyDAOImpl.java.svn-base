//*  Class  Name:     AdoInfoFamilyDAOImpl
//*  Created by:   Jacob Vaidyan
//*  Date Created: 2/18/2007
//*
//*  Description:Provides implementation for Adoption Information DAO Interface .
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoFamily;
import org.hibernate.Query;

public class AdoInfoFamilyDAOImpl extends BaseDAOImpl implements  AdoInfoFamilyDAO {
 
  @SuppressWarnings( { "unchecked" })
  
  public List<AdoInfoFamily> findAdoFamilyInfobyIdEvent(int idEvent) {

            Query query = getSession().createQuery(
                                                   " from  AdoInfoFamily aif " + " where aif.adoInfo.idEvent = :idEvent");
                                                                   

            query.setInteger("idEvent", idEvent);
            
            return (List<AdoInfoFamily>) query.list();

          }


  public void saveAdoFamilyInfo(AdoInfoFamily adofam) {
            getSession().saveOrUpdate(adofam);

          }

  public void deleteAdoResourceListByIdEvent(int idEvent) {
            Query query = getSession().createQuery(
                                                   " delete from AdoInfoFamily fam "
                                                                   + "       where fam.adoInfo.idEvent = :idEvent");
                                                                   
            query.setInteger("idEvent", idEvent);
            query.executeUpdate();
          }
}
