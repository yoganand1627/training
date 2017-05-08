package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConv;

public interface FosterHomeConvDAO {

  public FosterHomeConv findFosterHomeConvDetailsByIdEvent(int idEvent);
  public void saveFosterHomeConvDetails(FosterHomeConv fosterHomeConv);
  
  /** 
   * Retrieves Event Id for a foster home conversion with the given resource id and person id
   * 
   * @param int idResource
   * @param int idPerson
   * 
   * @return Integer
   */
  public Integer findFosterHomeConvByIdPersonIdResource(int idResource, int idPerson);  
  
  /** 
   * Retrieves foster home conversion with the given resource id, person id and inquiry
   * date.
   * 
   * @param int idResource
   * @param int idPerson
   * 
   * @return Integer
   */
  public FosterHomeConv findFosterHomeConvByIdPersonIdResourceAndInquiryDate(int idResource, int idPerson, 
		  Date dtInquiry); 
  
  
  
  /**
   * Gets the most recent approved foster home conversion record for the given resource Id
   * @param idResource
   * @return
   */
  public FosterHomeConv findFosterHomeConvByIdResource(int idResource);
  
  /**
   * Updates Foster Home Conversion Inquiry Date for the given id resource. 
   * @param dtInquiry
   * @param idEvent
   */
  public int updateFosterHomeConvDtInquiry(Date dtInquiry, int idEvent);
  
  /**
   * Update the status of a Foster Home Conversion
   * @param idEvent
   * @param cdConvAppStatus
   * @param dtApproved
   * @return
   */
  public int updateFosterHomeConv(int idEvent, String cdConvAppStatus, Date dtApproved);
  
  FosterHomeConv findActiveFosterHomeConvByIdResource(int idResource);

}
