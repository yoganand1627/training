package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct_ARRAY;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import org.exolab.castor.types.Date;

/**
 * User: mkw Date: Apr 16, 2003 Time: 11:21:28 AM Description: This class is used in two ways: (1) It transports data
 * between the To-Do Conversation class and the To-Do detail page, and (2) it is stored in state so that values can be
 * stored across requests (including during the pull-back call to staff search).
 */
public class ToDoDetailDB implements Serializable {
  // The To-Do mode
  private String toDoMode = null;

  // Return URI
  private String returnURI = null;

  // For optimistic locking, we need the tsLastUpdate
  private java.util.Date tsLastUpdate = null;

  // Store the current userId for use later
  private int userId = 0;

  // For approvals ONLY, this contains information about multiple events that are associated with the To-Do
  private EventIdStruct_ARRAY eventIdStruct_array = null;

  // Information about the To-Do itself
  private Date dtDtTodoCompleted = null;
  private Date dtDtTodoDue = null;
  private String szTxtTodoDesc = null;
  private String txtTodoLongDesc = null;
  private String szCdTodoType = null;
  private int ulIdCase = 0;
  private int ulIdEvent = 0;
  private int ldIdTodo = 0;
  private int ulIdApproval = 0;
  private boolean isAlert = false;

  // Information about the person to whom the To-Do is assigned
  private String szNmPersonFullAssigned = null;
  private int ulIdTodoPersAssigned = 0;

  // Information about the stage that the To-Do is in
  private String szNmStage = null;
  private int ulIdStage = 0;
  private int ulIdTodoPersWorker = 0;
  private String szNmPersonFullWorker = null;
  private String szCdStage = null;
  private String szCdStageProgram = null;

  // Information about the Task related to the To-Do
  private Date dtDtTaskDue = null;
  private String szTxtTaskDecode = null;
  private String szCdTask = null;

  // Information about the creation of the To-Do
  private Date dtDtTodoCreated = null;
  private String tmTmTodoCreated = null;
  private String szNmPersonFullCreator = null;
  private String initialsPersonCreator = null;
  private int ulIdTodoPersCreator = 0;

  // Information used to create new To-Do's
  private Set validSzCdTaskSet = null;
  private Map taskNewIndMap = null;

  /**
   * We need to specify that we want a default constructor, even though it does nothing; This constructor has package
   * visibility to ensure that nothing outside of workload uses it; it should only be used by ApprovalStatusConversation
   * and ToDoConversation.
   */
  ToDoDetailDB() {
    // do nothing
  }

  /**
   * This constructor is used to create the ToDoDetailDB with just ulIdCase, ulIdStage, and szCdTask; it should only be
   * used by ApprovalStatusConversation and ToDoConversation, so it has package visibility.
   *
   * @param ulIdCase
   * @param ulIdStage
   * @param szCdTask
   */
  ToDoDetailDB(int ulIdCase, int ulIdStage, String szCdTask) {
    this.ulIdCase = ulIdCase;
    this.ulIdStage = ulIdStage;
    this.szCdTask = szCdTask;
  }

  /**
   * This constructor is one of several constructors designed to make it easy to create new approval To-Do's with a Save
   * and Submit button.
   *
   * @param eventIdStruct_array
   * @param ulIdCase
   * @param ulIdStage
   * @param szCdTask
   */
  public ToDoDetailDB(EventIdStruct_ARRAY eventIdStruct_array, int ulIdCase, int ulIdStage, String szCdTask) {
    this(ulIdCase, ulIdStage, szCdTask);
    this.eventIdStruct_array = eventIdStruct_array;
  }

  /**
   * This constructor is one of several constructors designed to make it easy to create new approval To-Do's with a Save
   * and Submit button.
   *
   * @param outputEventIdStruct_array
   * @param ulIdCase
   * @param ulIdStage
   * @param szCdTask
   */
  public ToDoDetailDB(gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY outputEventIdStruct_array,
                      int ulIdCase, int ulIdStage, String szCdTask) {
    this(ulIdCase, ulIdStage, szCdTask);
    EventIdStruct_ARRAY eventIdStruct_array = new EventIdStruct_ARRAY();
    Enumeration eventIdStructEnumeration = outputEventIdStruct_array.enumerateEventIdStruct();
    while (eventIdStructEnumeration.hasMoreElements()) {
      gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct outputEventIdStruct
              = (gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct) eventIdStructEnumeration.nextElement();
      EventIdStruct eventIdStruct = new EventIdStruct();
      eventIdStruct.setUlIdEvent(outputEventIdStruct.getUlIdEvent());
      eventIdStruct_array.addEventIdStruct(eventIdStruct);
    }
    this.eventIdStruct_array = eventIdStruct_array;
  }

  /**
   * This constructor is one of several constructors designed to make it easy to create new approval To-Do's with a Save
   * and Submit button.
   *
   * @param shortDescription
   * @param outputEventIdStruct_array
   * @param ulIdCase
   * @param ulIdStage
   * @param szCdTask
   */
  public ToDoDetailDB(String shortDescription,
                      gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY outputEventIdStruct_array,
                      int ulIdCase, int ulIdStage, String szCdTask) {
    this(outputEventIdStruct_array, ulIdCase, ulIdStage, szCdTask);
    this.szTxtTodoDesc = shortDescription;
  }

  /**
   * This constructor is one of several constructors designed to make it easy to create new approval To-Do's with a Save
   * and Submit button.
   *
   * @param ulIdEvent
   * @param ulIdCase
   * @param ulIdStage
   * @param szCdTask
   */
  public ToDoDetailDB(int ulIdEvent, int ulIdCase, int ulIdStage, String szCdTask) {
    this(createEventIdStruct_ARRAY(new int[] {ulIdEvent}), ulIdCase, ulIdStage, szCdTask);
  }

  /**
   * This constructor is one of several constructors designed to make it easy to create new approval To-Do's with a Save
   * and Submit button.
   *
   * @param shortDescription
   * @param ulIdEvent
   * @param ulIdCase
   * @param ulIdStage
   * @param szCdTask
   */
  public ToDoDetailDB(String shortDescription, int ulIdEvent, int ulIdCase, int ulIdStage, String szCdTask) {
    this(createEventIdStruct_ARRAY(new int[] {ulIdEvent}), ulIdCase, ulIdStage, szCdTask);
    this.szTxtTodoDesc = shortDescription;
  }

  /**
   * This constructor is one of several constructors designed to make it easy to create new approval To-Do's with a Save
   * and Submit button.
   *
   * @param ulIdEvent_ARRAY
   * @param ulIdCase
   * @param ulIdStage
   * @param szCdTask
   */
  public ToDoDetailDB(int[] ulIdEvent_ARRAY, int ulIdCase, int ulIdStage, String szCdTask) {
    this(createEventIdStruct_ARRAY(ulIdEvent_ARRAY), ulIdCase, ulIdStage, szCdTask);
  }

  /**
   * This constructor is one of several constructors designed to make it easy to create new approval To-Do's with a Save
   * and Submit button.
   *
   * @param shortDescription
   * @param ulIdEvent_ARRAY
   * @param ulIdCase
   * @param ulIdStage
   * @param szCdTask
   */
  public ToDoDetailDB(String shortDescription, int[] ulIdEvent_ARRAY, int ulIdCase, int ulIdStage, String szCdTask) {
    this(createEventIdStruct_ARRAY(ulIdEvent_ARRAY), ulIdCase, ulIdStage, szCdTask);
    this.szTxtTodoDesc = shortDescription;
  }

  /**
   * This is a helper method that creates an input EventIdStruct_ARRAY for use in the To-Do service.
   *
   * @param events
   * @return
   */
  private static EventIdStruct_ARRAY createEventIdStruct_ARRAY(int[] events) {
    EventIdStruct_ARRAY eventIdStruct_array = new EventIdStruct_ARRAY();
    for (int i = 0; i < events.length; i++) {
      int event = events[i];
      if (event != 0) {
        EventIdStruct eventIdStruct = new EventIdStruct();
        eventIdStruct.setUlIdEvent(event);
        eventIdStruct_array.addEventIdStruct(eventIdStruct);
      }
    }
    return eventIdStruct_array;
  }

  public String getToDoMode() {
    return toDoMode;
  }

  void setToDoMode(String toDoMode) {
    this.toDoMode = toDoMode;
  }

  public String getReturnURI() {
    return returnURI;
  }

  public void setReturnURI(String returnURI) {
    this.returnURI = returnURI;
  }

  public java.util.Date getTsLastUpdate() {
    return tsLastUpdate;
  }

  void setTsLastUpdate(java.util.Date tsLastUpdate) {
    this.tsLastUpdate = tsLastUpdate;
  }

  public int getUserId() {
    return userId;
  }

  void setUserId(int userId) {
    this.userId = userId;
  }

  public EventIdStruct_ARRAY getEventIdStruct_array() {
    return eventIdStruct_array;
  }

  void setEventIdStruct_array(EventIdStruct_ARRAY eventIdStruct_array) {
    this.eventIdStruct_array = eventIdStruct_array;
  }

  public Date getDtDtTodoCompleted() {
    return dtDtTodoCompleted;
  }

  void setDtDtTodoCompleted(Date dtDtTodoCompleted) {
    this.dtDtTodoCompleted = dtDtTodoCompleted;
  }

  public Date getDtDtTodoDue() {
    return dtDtTodoDue;
  }

  void setDtDtTodoDue(Date dtDtTodoDue) {
    this.dtDtTodoDue = dtDtTodoDue;
  }

  public String getSzTxtTodoDesc() {
    return szTxtTodoDesc;
  }

  public void setSzTxtTodoDesc(String szTxtTodoDesc) {
    this.szTxtTodoDesc = szTxtTodoDesc;
  }

  public String getTxtTodoLongDesc() {
    return txtTodoLongDesc;
  }

  void setTxtTodoLongDesc(String txtTodoLongDesc) {
    this.txtTodoLongDesc = txtTodoLongDesc;
  }

  public String getSzCdTodoType() {
    return szCdTodoType;
  }

  void setSzCdTodoType(String szCdTodoType) {
    this.szCdTodoType = szCdTodoType;
  }

  public int getUlIdCase() {
    return ulIdCase;
  }

  public void setUlIdCase(int ulIdCase) {
    this.ulIdCase = ulIdCase;
  }

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

  public int getLdIdTodo() {
    return ldIdTodo;
  }

  public void setLdIdTodo(int ldIdTodo) {
    this.ldIdTodo = ldIdTodo;
  }

  public int getUlIdApproval() {
    return ulIdApproval;
  }

  public void setUlIdApproval(int ulIdApproval) {
    this.ulIdApproval = ulIdApproval;
  }

  public boolean isAlert() {
    return isAlert;
  }

  public void setAlert(boolean isAlert) {
    this.isAlert = isAlert;
  }

  public String getSzNmPersonFullAssigned() {
    return szNmPersonFullAssigned;
  }

  void setSzNmPersonFullAssigned(String szNmPersonFullAssigned) {
    this.szNmPersonFullAssigned = szNmPersonFullAssigned;
  }

  public int getUlIdTodoPersAssigned() {
    return ulIdTodoPersAssigned;
  }

  void setUlIdTodoPersAssigned(int ulIdTodoPersAssigned) {
    this.ulIdTodoPersAssigned = ulIdTodoPersAssigned;
  }

  public String getSzNmStage() {
    return szNmStage;
  }

  public void setSzNmStage(String szNmStage) {
    this.szNmStage = szNmStage;
  }

  public int getUlIdStage() {
    return ulIdStage;
  }

  public void setUlIdStage(int ulIdStage) {
    this.ulIdStage = ulIdStage;
  }

  public int getUlIdTodoPersWorker() {
    return ulIdTodoPersWorker;
  }

  void setUlIdTodoPersWorker(int ulIdTodoPersWorker) {
    this.ulIdTodoPersWorker = ulIdTodoPersWorker;
  }

  public String getSzNmPersonFullWorker() {
    return szNmPersonFullWorker;
  }

  void setSzNmPersonFullWorker(String szNmPersonFullWorker) {
    this.szNmPersonFullWorker = szNmPersonFullWorker;
  }

  public String getSzCdStage() {
    return szCdStage;
  }

  public void setSzCdStage(String szCdStage) {
    this.szCdStage = szCdStage;
  }

  public String getSzCdStageProgram() {
    return szCdStageProgram;
  }

  public void setSzCdStageProgram(String szCdStageProgram) {
    this.szCdStageProgram = szCdStageProgram;
  }

  public Date getDtDtTaskDue() {
    return dtDtTaskDue;
  }

  void setDtDtTaskDue(Date dtDtTaskDue) {
    this.dtDtTaskDue = dtDtTaskDue;
  }

  public String getSzTxtTaskDecode() {
    return szTxtTaskDecode;
  }

  void setSzTxtTaskDecode(String szTxtTaskDecode) {
    this.szTxtTaskDecode = szTxtTaskDecode;
  }

  public String getSzCdTask() {
    return szCdTask;
  }

  public void setSzCdTask(String szCdTask) {
    this.szCdTask = szCdTask;
  }

  public Date getDtDtTodoCreated() {
    return dtDtTodoCreated;
  }

  public String getTmTmTodoCreated() {
    return tmTmTodoCreated;
  }

  void setDtDtTodoCreated(Date dtDtTodoCreated) {
    this.dtDtTodoCreated = dtDtTodoCreated;
  }

  void setTmTmTodoCreated(String tmTmTodoCreated) {
    this.tmTmTodoCreated = tmTmTodoCreated;
  }

  public String getSzNmPersonFullCreator() {
    return szNmPersonFullCreator;
  }

  void setSzNmPersonFullCreator(String szNmPersonFullCreator) {
    this.szNmPersonFullCreator = szNmPersonFullCreator;
  }

  public String getInitialsPersonCreator() {
    return initialsPersonCreator;
  }

  public void setInitialsPersonCreated(String initialsPersonCreator) {
    this.initialsPersonCreator = initialsPersonCreator;
  }

  public int getUlIdTodoPersCreator() {
    return ulIdTodoPersCreator;
  }

  void setUlIdTodoPersCreator(int ulIdTodoPersCreator) {
    this.ulIdTodoPersCreator = ulIdTodoPersCreator;
  }

  public Set getValidSzCdTaskSet() {
    return validSzCdTaskSet;
  }

  void setValidSzCdTaskSet(Set validSzCdTaskSet) {
    this.validSzCdTaskSet = validSzCdTaskSet;
  }

  public Map getTaskNewIndMap() {
    return taskNewIndMap;
  }

  void setTaskNewIndMap(Map taskNewIndMap) {
    this.taskNewIndMap = taskNewIndMap;
  }

  public String toString() {
    StringBuffer buffy = new StringBuffer("gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB {");

    if (toDoMode == null) {
      buffy.append("  toDoMode=null");
    } else {
      buffy.append("  toDoMode='");
      buffy.append(toDoMode);
      buffy.append('\'');
    }
    buffy.append("\n");

    if (returnURI == null) {
      buffy.append("  returnURI=null");
    } else {
      buffy.append("  returnURI='");
      buffy.append(returnURI);
      buffy.append('\'');
    }
    buffy.append("\n");

    buffy.append("  tsLastUpdate=");
    buffy.append(tsLastUpdate);
    buffy.append("\n");

    buffy.append("  userId=");
    buffy.append(userId);
    buffy.append("\n");

    buffy.append("  eventIdStruct_array=");
    buffy.append(eventIdStruct_array);
    buffy.append("\n");

    buffy.append("  dtDtTodoCompleted=");
    buffy.append(dtDtTodoCompleted);
    buffy.append("\n");

    buffy.append("  dtDtTodoDue=");
    buffy.append(dtDtTodoDue);
    buffy.append("\n");

    if (szTxtTodoDesc == null) {
      buffy.append("  szTxtTodoDesc=null");
    } else {
      buffy.append("  szTxtTodoDesc='");
      buffy.append(szTxtTodoDesc);
      buffy.append('\'');
    }
    buffy.append("\n");

    if (txtTodoLongDesc == null) {
      buffy.append("  txtTodoLongDesc=null");
    } else {
      buffy.append("  txtTodoLongDesc='");
      buffy.append(txtTodoLongDesc);
      buffy.append('\'');
    }
    buffy.append("\n");

    if (szCdTodoType == null) {
      buffy.append("  szCdTodoType=null");
    } else {
      buffy.append("  szCdTodoType='");
      buffy.append(szCdTodoType);
      buffy.append('\'');
    }
    buffy.append("\n");

    buffy.append("  ulIdCase=");
    buffy.append(ulIdCase);
    buffy.append("\n");

    buffy.append("  ulIdEvent=");
    buffy.append(ulIdEvent);
    buffy.append("\n");

    buffy.append("  ldIdTodo=");
    buffy.append(ldIdTodo);
    buffy.append("\n");

    buffy.append("  ulIdApproval=");
    buffy.append(ulIdApproval);
    buffy.append("\n");

    if (szNmPersonFullAssigned == null) {
      buffy.append("  szNmPersonFullAssigned=null");
    } else {
      buffy.append("  szNmPersonFullAssigned='");
      buffy.append(szNmPersonFullAssigned);
      buffy.append('\'');
    }
    buffy.append("\n");

    buffy.append("  ulIdTodoPersAssigned=");
    buffy.append(ulIdTodoPersAssigned);
    buffy.append("\n");

    if (szNmStage == null) {
      buffy.append("  szNmStage=null");
    } else {
      buffy.append("  szNmStage='");
      buffy.append(szNmStage);
      buffy.append('\'');
    }
    buffy.append("\n");

    buffy.append("  ulIdStage=");
    buffy.append(ulIdStage);
    buffy.append("\n");

    buffy.append("  ulIdTodoPersWorker=");
    buffy.append(ulIdTodoPersWorker);
    buffy.append("\n");

    if (szNmPersonFullWorker == null) {
      buffy.append("  szNmPersonFullWorker=null");
    } else {
      buffy.append("  szNmPersonFullWorker='");
      buffy.append(szNmPersonFullWorker);
      buffy.append('\'');
    }
    buffy.append("\n");

    if (szCdStage == null) {
      buffy.append("  szCdStage=null");
    } else {
      buffy.append("  szCdStage='");
      buffy.append(szCdStage);
      buffy.append('\'');
    }
    buffy.append("\n");

    if (szCdStageProgram == null) {
      buffy.append("  szCdStageProgram=null");
    } else {
      buffy.append("  szCdStageProgram='");
      buffy.append(szCdStageProgram);
      buffy.append('\'');
    }
    buffy.append("\n");

    buffy.append("  dtDtTaskDue=");
    buffy.append(dtDtTaskDue);
    buffy.append("\n");

    if (szTxtTaskDecode == null) {
      buffy.append("  szTxtTaskDecode=null");
    } else {
      buffy.append("  szTxtTaskDecode='");
      buffy.append(szTxtTaskDecode);
      buffy.append('\'');
    }
    buffy.append("\n");

    if (szCdTask == null) {
      buffy.append("  szCdTask=null");
    } else {
      buffy.append("  szCdTask='");
      buffy.append(szCdTask);
      buffy.append('\'');
    }
    buffy.append("\n");

    buffy.append("  dtDtTodoCreated=");
    buffy.append(dtDtTodoCreated);
    buffy.append("\n");

    buffy.append("  tmTmTodoCreated=");
    buffy.append(tmTmTodoCreated);
    buffy.append("\n");

    if (szNmPersonFullCreator == null) {
      buffy.append("  szNmPersonFullCreator=null");
    } else {
      buffy.append("  szNmPersonFullCreator='");
      buffy.append(szNmPersonFullCreator);
      buffy.append('\'');
    }
    buffy.append("\n");

    if (initialsPersonCreator == null) {
      buffy.append("  initialsPersonCreator=null");
    } else {
      buffy.append("  initialsPersonCreator='");
      buffy.append(initialsPersonCreator);
      buffy.append('\'');
    }
    buffy.append("\n");

    buffy.append("  ulIdTodoPersCreator=");
    buffy.append(ulIdTodoPersCreator);
    buffy.append("\n");

    buffy.append("  validSzCdTaskSet=");
    buffy.append(validSzCdTaskSet);
    buffy.append("\n");

    buffy.append("  taskNewIndMap=");
    buffy.append(taskNewIndMap);
    buffy.append("}");

    return buffy.toString();
  }
}
