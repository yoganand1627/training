//*  Class  Name:     AdoInfoDAO
//*  Created by:   Jacob Vaidyan
//*  Date Created: 2/18/2007
//*
//*  Description:DAO Interface for Adoption Information Page.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfo;
import gov.georgia.dhr.dfcs.sacwis.db.Event;

/*

Change History:
Date      User           Description
--------  --------       --------------------------------------------------
06/12/09   mxpatel       STGAP00013445: added findLatestAdoInfoByIdChildRegEvent method to retrieve the latest Adoption Information event
10/12/11   hjbaptiste    MR-092: Fostering Connection - Added findLatestCompletedAdoptionInformationByStage to find the most
                         recent completed (COMP) first Best Interest Language legal action
*/


public interface AdoInfoDAO {
 /**
	 * findAdoInfoByIdEvent selects a row from Adoption Information given
	 * idEvent. <p/>
	 * 
	 * @param idAdoEvent
	 * @return rowList.
	 */
	List<AdoInfo> findAdoInfoByIdEvent(int idAdoEvent);
  /**
	 * saveAdoInfoDetail saves or updates the Adoption Information.
	 * 
	 * @param AdoInfo
	 */
  void saveAdoInfoDetail(AdoInfo adoinfo);
  
  /**
   * Gets the latest ADO Info record for the given child registration event
   * @param idChildRegEvent
   * @return
   */
  AdoInfo findAdoInfoByIdChildRegEvent(int idChildRegEvent); 
  
  /**
   * Gets the Adoption Information record given the primary key.
   * @param idEvent
   * @return AdoInfo
   */
  AdoInfo findAdoInformation(int idEvent);
  
  /**
   * Gets the latest ADO info record for the given idStage
   * 
   * @param idEventStage
   * @return
   */
  AdoInfo findLatestAdoptionInformationByStage(int idEventStage);
  
  /**
   * Gets the latest COMP ADO info record for the given idStage
   * 
   * @param idEventStage
   * @return
   */
  AdoInfo findLatestCompletedAdoptionInformationByStage(int idEventStage);

  /**
   * Gets the latest ADO info event for the given person
   * 
   * @param idPerson
   * @return
   */
  AdoInfo findCurrentAdoptionInformationByIdPerson(int idPerson);

  Date findDateDocSentByIdEventChildRegistration(int idEvent);// mxpatel 12533

  Date findDatePermFileByIdEventChildRegistration(int idEvent);// mxpatel 12533
  
  AdoInfo findLatestAdoInfoByIdChildRegEvent(int idChildRegEvent);
  
  Date findDateDecAdoptByIdResource(int idResource);
  
}
