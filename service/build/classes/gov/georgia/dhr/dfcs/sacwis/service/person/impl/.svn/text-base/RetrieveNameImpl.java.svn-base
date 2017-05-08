package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveName;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00_ARRAY;

public class RetrieveNameImpl extends BaseServiceImpl implements RetrieveName {

  private NameDAO nameDAO = null;

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public CINV25SO retrievePersonNameInformation(CINV25SI cinv25si) {
    CINV25SO cinv25so = new CINV25SO();
    int idPerson = cinv25si.getUlIdPerson();
    String sysIndIntake = cinv25si.getBSysIndIntake();
    List<Name> names;
    if (StringHelper.isTrue(sysIndIntake)) {
      Date tsSysTsQuery = cinv25si.getTsSysTsQuery();
      // cinv31d
      names = nameDAO.findNameByIdPersonAndDtNameStartDate(idPerson, tsSysTsQuery);
    } else {
      // cinv31d
      names = nameDAO.findNameByIdPerson(idPerson);
    }
    ROWCINV25SOG00_ARRAY rowcinv25sog00_array = new ROWCINV25SOG00_ARRAY();
    //ROWCINV25SOG00_ARRAY rowcinv25sog00_array = cinv25so.getROWCINV25SOG00_ARRAY();
    // It is possible for a person to be entered into the system with no rows on the name table.
    //   Therefore we will not handle SQL_NOT_FOUND.
    if (names != null) {
      for (Iterator it = names.iterator(); it.hasNext();) {
        Name name = (Name) it.next();
        ROWCINV25SOG00 rowcinv25sog00 = new ROWCINV25SOG00();
        rowcinv25sog00.setSzCdNameSuffix(name.getCdNameSuffix());
        rowcinv25sog00.setDtDtNameEndDate(DateHelper.toCastorDate(name.getDtNameEndDate()));
        rowcinv25sog00.setDtDtNameStartDate(DateHelper.toCastorDate(name.getDtNameStartDate()));
        rowcinv25sog00.setUlIdName(name.getIdName() != null ? name.getIdName() : 0);
        rowcinv25sog00.setUlIdPerson(name.getPerson().getIdPerson() != null ? name.getPerson().getIdPerson() : 0);
        rowcinv25sog00.setBIndNameInvalid(name.getIndNameInvalid());
        rowcinv25sog00.setBIndNamePrimary(name.getIndNamePrimary());
        rowcinv25sog00.setSzNmNameFirst(name.getNmNameFirst());
        rowcinv25sog00.setSzNmNameLast(name.getNmNameLast());
        rowcinv25sog00.setSzNmNameMiddle(name.getNmNameMiddle() != null ? name.getNmNameMiddle() : "");
        rowcinv25sog00.setTsLastUpdate(name.getDtLastUpdate());
        rowcinv25sog00_array.addROWCINV25SOG00(rowcinv25sog00);
      }
    }
    cinv25so.setROWCINV25SOG00_ARRAY(rowcinv25sog00_array);
    return cinv25so;
  }
}
