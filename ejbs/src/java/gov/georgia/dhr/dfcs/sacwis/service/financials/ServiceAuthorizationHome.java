package gov.georgia.dhr.dfcs.sacwis.service.financials;

import java.rmi.RemoteException;

import javax.ejb.CreateException;

public interface ServiceAuthorizationHome extends javax.ejb.EJBLocalHome {
  public ServiceAuthorizationLocal create() throws CreateException;
}