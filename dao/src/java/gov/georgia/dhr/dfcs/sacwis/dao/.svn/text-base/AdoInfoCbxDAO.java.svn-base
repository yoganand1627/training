//*  Class  Name:     AdoInfoCbxDAO
//*  Created by:   Jacob Vaidyan
//*  Date Created: 2/18/2007
//*
//*  Description:DAO Interface for Adoption Information Checkboxes.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbx;

public interface AdoInfoCbxDAO {
          
  /**
   * findAdoInfoCheckboxbyIdEventandCbxCodeType selects a row from Adoption Information Check box table given an
   * idEvent, and Checkbox type
   * 
   * @param idEvent
   * @param cdCbxType
   * @return rowList.
   */
  List<AdoInfoCbx> findAdoInfoCheckboxbyIdEventandCbxCodeType(int idEvent, String cdCbxType);
  /**
   * saveAdoInfoCheckBox saves details into AdoInfoCbx Information Check box table given an idEvent, and Checkbox type
   * 
   * @param adoinfocbx
   */

  void saveAdoInfoCheckBox(AdoInfoCbx adoinfocbx);
  /**
   * deleteAdoInfoByIdEvent deletes Adoption Information CheckBox based on IdEvent and CheckBox Type..
   * 
   * @param idEvent.
   * @param String
   *          CheckBoxType.
   */
  void deleteAdoInfoByIdEvent(int idEvent, String cbxtype);
  
   /**
   * Gets the list of dateLastUpdates based on IdEvent and CheckBox Type.
   * 
   * @param idEvent.
   * @param cdAdoInfoCbx
   *          
   */
  List<Date> findAdoInfocheckboxbyIdEventandCdInfoCbx(int idEvent, String cdAdoInfoCbx);
  
  /**
   * Gets a list of idInfoChars for .
   * 
   * @param idEvent.
   * @param cdCbxCodeType
   *          
   */
  List<Integer> findIdInfoCharByCbxTypeAndEvent(int idEvent,
			String cdCbxCodeType); 

  /**
   * Selects a row for the given IdEvent, cdCodeType, cdInfoCbx
   * 
   * @param idEvent
   * @param cdCodeType
   * @param cdInfoCbx
   * 
   * return AdoInfoCbx
   */
  AdoInfoCbx findAdoInfoCbxByIdEventCdCodeTypeCdInfoCbx(int idEvent, String cdCodeType, String cdInfoCbx);

}
