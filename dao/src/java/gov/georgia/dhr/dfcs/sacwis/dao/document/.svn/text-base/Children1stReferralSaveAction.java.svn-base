package gov.georgia.dhr.dfcs.sacwis.dao.document;

import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SequenceHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

public class Children1stReferralSaveAction extends BaseSaveAction {

  public Children1stReferralSaveAction(Connection connection) {
    super(connection);
  }

  public void execute(DocumentMetaData documentMetaData) throws SQLException, NoRowsUpdatedException, DuplicateRecordException {
    try {
      
      int idEvent = getEventId(documentMetaData);
     //check to see if the event has already been generated if not create the Children First Referral Generated event and
     //update the page table ID_GENERATION_EVENT
     if (doesExist(idEvent) == false) {
       int idGeneratedEvent = createEvent(documentMetaData);
       
       if(idGeneratedEvent > 0) {
         
         updateChildrenFirstReferral(documentMetaData, idGeneratedEvent, idEvent);
         
         //update event person link
         int idChild = retriveChildId(idEvent);
         if(idChild > 0) {
           createEventPersonLink(documentMetaData, idGeneratedEvent, idChild);
         }
       }
     }
    } catch (SQLException ne) {
      String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_DATA_ACCESSOR_COMMAND_EXEC);
      throw new NoRowsUpdatedException(message, ne);
    } finally {
      GrndsTrace.exitScope();
    }
  }
  
  //create the Children First Referral Generated event
  private int createEvent(DocumentMetaData documentMetaData) throws SQLException, NoRowsUpdatedException, DuplicateRecordException {
    GrndsTrace.enterScope(TRACE_TAG + ".createEvent");
    PreparedStatement statement = null;
    int eventId = 0;
    StringBuffer evntSql = new StringBuffer();
    evntSql.append("INSERT INTO EVENT (ID_EVENT, ID_EVENT_STAGE, CD_EVENT_TYPE, ID_CASE, ID_EVENT_PERSON, TXT_EVENT_DESCR,  DT_EVENT_OCCURRED, CD_EVENT_STATUS) ");
    evntSql.append("VALUES  (?, ?, ?, ?, ?, ?, ?, ?)");
       
    try {
      statement = getConnection().prepareStatement(evntSql.toString());
      
      List<Object> bindVariables = new ArrayList<Object>();
      eventId = SequenceHelper.getSequence("EVENT", getConnection());
      bindVariables.add(eventId);
      bindVariables.add(documentMetaData.getStageId());
      bindVariables.add("CFG");
      bindVariables.add(documentMetaData.getCaseId());
      bindVariables.add(documentMetaData.getUserId());
      bindVariables.add("Children 1st Referral Form generated for " + documentMetaData.getUserName());
      bindVariables.add(new Date());
      bindVariables.add("COMP");
      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);
    } finally {
      cleanup(statement);
      GrndsTrace.exitScope();
    }
    
    return eventId;
  }
  
  //if the ID_GENERATION_EVENT is populated for the page table then we have alreday generated the event 
  private boolean doesExist(int idPageEvent) throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".doesExist");
    boolean exist = false;
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT ID_GENERATION_EVENT FROM CHILDREN_FIRST_REFERRAL WHERE ID_EVENT = ?");
    PreparedStatement selectQuery = getConnection().prepareStatement(sql.toString());
    super.setInt(1, idPageEvent, selectQuery);
    
    try {
      ResultSet resultSet = selectQuery.executeQuery();
      while (resultSet.next()) {
        int idGenEnv = resultSet.getInt("ID_GENERATION_EVENT");
        if (idGenEnv > 0) {
          exist = true;
          break;
        }
      }
    } finally {
      cleanup(selectQuery);
      GrndsTrace.exitScope();
    }
    return exist;
  }
  
  //populate the ID_GENERATION_EVENT with the Children First Referral Generated event id
  private void updateChildrenFirstReferral(DocumentMetaData documentMetaData, int idGenEvent, int idEvent) throws SQLException, NoRowsUpdatedException, DuplicateRecordException {
    GrndsTrace.enterScope(TRACE_TAG + ".updateChildrenFirstReferral");
    PreparedStatement statement = null;
    String sql = "UPDATE CHILDREN_FIRST_REFERRAL SET ID_GENERATION_EVENT = ?, DT_GENERATION = ? WHERE ID_EVENT = ?";    
    
    try {
      statement = getConnection().prepareStatement(sql.toString());
      
      List<Object> bindVariables = new ArrayList<Object>();
      bindVariables.add(idGenEvent);
      bindVariables.add(new Date());
      bindVariables.add(idEvent);
      
      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);
    } finally {
      cleanup(statement);
      GrndsTrace.exitScope();
    }
  }
  
  private int retriveChildId(int idPageEvent) throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".retriveChildId");
    int idChild = 0;
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT ID_CHILD_REFERRED FROM CHILDREN_FIRST_REFERRAL WHERE ID_EVENT = ?");
    PreparedStatement selectQuery = getConnection().prepareStatement(sql.toString());
    super.setInt(1, idPageEvent, selectQuery);
    
    try {
      ResultSet resultSet = selectQuery.executeQuery();
      while (resultSet.next()) {
        idChild = resultSet.getInt("ID_CHILD_REFERRED");
      }
      
    } finally {
      cleanup(selectQuery);
      GrndsTrace.exitScope();
    }
    return idChild;
  }
  
  
//create the Children First Referral Generated event
  private int createEventPersonLink(DocumentMetaData documentMetaData, int idGenEvent, int idChild) throws SQLException, NoRowsUpdatedException, DuplicateRecordException {
    GrndsTrace.enterScope(TRACE_TAG + ".createEventPersonLink");
    PreparedStatement statement = null;
    int eventId = 0;
    StringBuffer evntSql = new StringBuffer();
    evntSql.append("INSERT INTO EVENT_PERSON_LINK (ID_EVENT_PERS_LINK, ID_PERSON, ID_EVENT, ID_CASE) ");
    evntSql.append("VALUES  (?, ?, ?, ?)");
       
    try {
      statement = getConnection().prepareStatement(evntSql.toString());
      
      List<Object> bindVariables = new ArrayList<Object>();
      eventId = SequenceHelper.getSequence("EVENT_PERSON_LINK", getConnection());
      bindVariables.add(eventId);
      bindVariables.add(idChild);
      bindVariables.add(idGenEvent);
      bindVariables.add(documentMetaData.getCaseId());
      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);
    } finally {
      cleanup(statement);
      GrndsTrace.exitScope();
    }
    
    return eventId;
  }
  private int getEventId(DocumentMetaData documentMetaData) {
    int eventId = 0;
    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      String tempName = column.getName().toUpperCase();
      if ("ID_EVENT".equals(tempName)) {
        Integer tempInteger = new Integer(column.getContent());
        eventId = (tempInteger != null) ? tempInteger.intValue() : 0;
        break;
      }
    }
    
    return eventId;
  }
  
  private static final String TRACE_TAG = "Children1stReferralSaveAction";
}
