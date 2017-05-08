package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexIncomingNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingName;


/* Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------

 09/17/2008   mxpatel          STGAP00008093: changed the field in method 
                                              addIncomingNameToName(int idPerson, int idIncmgPerson 
                                              from incName.getNmIncmgNameLast() to getNmIncmgNameMiddle()
                                              as incName.getNmIncmgNameLast() was written twice and
                                              getNmIncmgNameMiddle() was missing.                          
                               
*/

public class ComplexIncomingNameDAOImpl extends BaseDAOImpl implements ComplexIncomingNameDAO {
  private IncomingNameDAO incomingNameDAO = null;
  private NameDAO nameDAO = null;

  public void setIncomingNameDAO(IncomingNameDAO incomingNameDAO) {
    this.incomingNameDAO = incomingNameDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public int addIncomingNameToName(int idPerson, int idIncmgPerson) {
    int rowsAdded = 0;
    List<IncomingName> list = incomingNameDAO.findIncomingNameByIdIncmgPerson(idIncmgPerson);
    if (list != null && !list.isEmpty()) {
      // The return value is set to the the number of rows in the list. Only if all the insert operations
      // go through successfully, this value will be returned.
      rowsAdded = list.size();
      for (Iterator<IncomingName> it = list.iterator(); it.hasNext();) {
        IncomingName incName = it.next();
        int rowsInserted = nameDAO.insertName(idPerson, incName.getIndIncmgNameInvalid(),
                                              incName.getNmIncmgNameFirst(), incName.getNmIncmgNameMiddle(),//mxpatel changed this from incName.getNmIncmgNameLast() to getNmIncmgNameMiddle() for defect #8093
                                              incName.getNmIncmgNameLast(), incName.getIndIncmgNamePrimary(),
                                              incName.getCdIncmgNameSuffix(), incName.getDtIncmgNameStart());
        if (rowsInserted == 0) {
          // If any of the inserts fails, the return value is reset to 0;
          rowsAdded = 0;
        }
        // TODO: Add a row to the PhoneticName table
      }
    }
    return rowsAdded;
  }
}
