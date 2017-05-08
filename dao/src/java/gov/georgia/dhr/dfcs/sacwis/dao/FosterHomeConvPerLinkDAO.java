package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConvPerLink;

public interface FosterHomeConvPerLinkDAO {

  public int insertFosterHomeConvPerLink(int idFosterHomeConv, int idPerson);
  
  public List<Integer> findPersonsByIdFosterHomeConvEvent(int idEvent);

  public FosterHomeConvPerLink findFosterComeConvPerLinkByIdPersonIdEvent(int idPerson, int idEvent);

  public List<FosterHomeConvPerLink> findFosterHomeConvPerLinksByIdEvent(int idEvent);

  public int deleteFosterHomeConvPerLinkByIdFosterHomeConvPerLink(int idFosterHomeConvPerLink);

  public void saveFosterHomeConvPerLink(FosterHomeConvPerLink fosterHomeConvPerLink);
  
  public int saveFosterHomeConvPerLinkReturnId(FosterHomeConvPerLink fosterHomeConvPerLink);
}
