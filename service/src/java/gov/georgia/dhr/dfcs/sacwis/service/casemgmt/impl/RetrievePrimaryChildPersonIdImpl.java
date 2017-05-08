//*  Service Class  Name:     RetrievePrimaryChildPersonIdImpl
//*  Created by:   Jacob Vaidyan
//*  Date Created: 1/8/2007
//*
//*  Description:Service Implementation for retrieving Primary Child person Id.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  

package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FccpChildDAO;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePrimaryChildPersonId;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrievePrimaryChildPersonIdImpl extends BaseServiceImpl implements RetrievePrimaryChildPersonId {

  private FccpChildDAO fccpChildDAO = null;

  public void setFccpChildDAO(FccpChildDAO fccpChildDAO) {
    this.fccpChildDAO = fccpChildDAO;
  }
  @SuppressWarnings("unchecked")

  /**
   * retrievePrimaryChildPersonId is used for retrieving Person Id associated with the Stage Id.
   * 
   * @param context
   *          The Stage ID.
   */
  public int retrievePrimaryChildPersonId(int IdStage) {

    int idPerson = fccpChildDAO.findPrimaryChildForStage(IdStage);
    return idPerson;
  }
}
