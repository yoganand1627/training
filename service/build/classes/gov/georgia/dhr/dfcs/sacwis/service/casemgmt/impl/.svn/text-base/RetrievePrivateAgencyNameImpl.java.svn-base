//*  Service Class  Name:     RetrievePrivateAgencyNameImpl
//*  Created by:   Jacob Vaidyan
//*  Date Created: 1/8/2007
//*
//*  Description:Service Implementation for retrieving Private Agency Name
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  

package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;


import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RsrcLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePrivateAgencyName;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionInformationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionResourceBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptionInformationRetrieveSO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RetrievePrivateAgencyNameImpl extends BaseServiceImpl implements RetrievePrivateAgencyName {

  private CapsResourceDAO capsResourceDAO = null;

  private RsrcLinkDAO rsrcLinkDAO = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setRsrcLinkDAO(RsrcLinkDAO rsrcLinkDAO) {
    this.rsrcLinkDAO = rsrcLinkDAO;
  }

  @SuppressWarnings("unchecked")
  /**
   * retrievePrivateAgencyName is used for retrieving Agency Name associated with the Resource Id.
   * 
   * @param IdResource
   *          The Resource ID.
   */
  public String retrievePrivateAgencyName(int IdResource) {

    String nmPrivAgency = "";
    int idResParent = 0;
    Integer capsResourceLink = rsrcLinkDAO.findCapsResourceParentIdRsrcLink(IdResource);
    if (capsResourceLink != null) {
      idResParent = capsResourceLink.intValue();
    }
    if (idResParent != 0) {
      nmPrivAgency = capsResourceDAO.findNmByIdResourceOnly(idResParent);
    }

    return nmPrivAgency;
  }
}

