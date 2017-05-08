/**
 * Created on Jun 2, 2006 at 11:24:41 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.impl;

import java.io.Serializable;

import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;

public abstract class BaseServiceImpl {
  protected CommonDAO commonDAO = null;

  public void setCommonDAO(CommonDAO commonDAO) {
    this.commonDAO = commonDAO;
  }

  @SuppressWarnings({"unchecked"})
  protected <T extends Object> T getPersistentObject(Class<T> clazz, Serializable id) {
    return commonDAO.getPersistentObject(clazz, id);
  }
}
