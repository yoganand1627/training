/**
 * Created on Mar 25, 2006 at 1:35:17 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.AdminDtl;

import java.util.Date;

public interface AdminDtlDAO {
  /**
   * Retrieve a
   *
   * @param idInvoResource
   * @return
   */
  PaginatedHibernateList<AdminDtl> findAdminDtlByIdInvoResource(int idInvoResource, int pageNbr, int pageSize);

  /**
   * This does a count by idInvoice all items of a particular CD SVC DTL LI TYPE.
   *
   * @param idInvoice
   * @param cdAdminDtlLiType
   * @return
   */
  long countAdminDtlIdAdminDtl(int idInvoice, String cdAdminDtlLiType);
  
  /**
   * Updates the AdminDtl record's nbrCheck, amtSmilePaid, and dtPaid values.
   * 
   * @param idAdminDtl
   * @param nbrCheck
   * @param amtSmilePaid
   * @param dtPaid
   * @return
   */
  int updateAdminDtlAsPaid(int idAdminDtl, int nbrCheck, double amtSmilePaid, Date dtPaid);

  /**
   * Partial update of AdminDtl table using the supplied parameters(column values).
   *
   * @param idAdminDtl
   * @param idInvoInvoice
   * @param amtAdminDtlAdminAlloc
   * @param amtAdminDtlEquipment
   * @param amtAdminDtlFrgBenft
   * @param amtAdminDtlOffsetItem
   * @param amtAdminDtlOther
   * @param amtAdminDtlSalaries
   * @param amtAdminDtlSupplies
   * @param amtAdminDtlTravel
   * @param cdAdminDtlService
   * @param cdAdminDtlInvoDisptn
   * @param cdAdminDtlLiType
   * @param indAdminDtlRejItm
   * @param moAdminDtlSvcMonth
   * @param nbrAdminDtlCsli
   * @param yrAdminDtlSvcYear
   * @param lastUpdate
   */
  int updateAdminDtl(int idAdminDtl, int idInvoInvoice, double amtAdminDtlAdminAlloc, double amtAdminDtlEquipment,
                     double amtAdminDtlFrgBenft, double amtAdminDtlOffsetItem, double amtAdminDtlOther,
                     double amtAdminDtlSalaries, double amtAdminDtlSupplies, double amtAdminDtlTravel,
                     String cdAdminDtlService, String cdAdminDtlInvoDisptn, String cdAdminDtlLiType,
                     String indAdminDtlRejItm, int moAdminDtlSvcMonth, int nbrAdminDtlCsli, int yrAdminDtlSvcYear,
                     Date lastUpdate,String cdCounty,double amtPromotional,String txtComments);

  /**
   * Partial insert of AdminDtl table using the supplied parameters(column values). (Note that the insert is done using
   * straight SQL)
   *
   * @param idAdminDtl
   * @param lastUpdate
   * @param idInvoInvoice
   * @param amtAdminDtlAdminAlloc
   * @param amtAdminDtlEquipment
   * @param amtAdminDtlFrgBenft
   * @param amtAdminDtlOffsetItem
   * @param amtAdminDtlOther
   * @param amtAdminDtlSalaries
   * @param amtAdminDtlSupplies
   * @param amtAdminDtlTravel
   * @param cdAdminDtlService
   * @param cdAdminDtlInvoDisptn
   * @param cdAdminDtlLiType
   * @param indAdminDtlRejItm
   * @param moAdminDtlSvcMonth
   * @param nbrAdminDtlCsli
   * @param yrAdminDtlSvcYear
   */
  int insertAdminDtl(int idAdminDtl, Date lastUpdate, int idInvoInvoice, double amtAdminDtlAdminAlloc,
                     double amtAdminDtlEquipment, double amtAdminDtlFrgBenft, double amtAdminDtlOffsetItem,
                     double amtAdminDtlOther, double amtAdminDtlSalaries, double amtAdminDtlSupplies,
                     double amtAdminDtlTravel, String cdAdminDtlService, String cdAdminDtlInvoDisptn,
                     String cdAdminDtlLiType, String indAdminDtlRejItm, int moAdminDtlSvcMonth, int nbrAdminDtlCsli,
                     int yrAdminDtlSvcYear,String cdCounty,double amtAdminDtlPromotional,String txtComments);
  
  /**
   * 
   * @param idAdminDtl
   * @param idInvoice
   * @return
   */
  AdminDtl findAdminDtlByInvoiceIdnIdAdminDtl(int idAdminDtl,int idInvoice);
  /**
   * 
   * @param adminDtl
   */
  void saveAdminDtl(AdminDtl adminDtl);
  
  
}
