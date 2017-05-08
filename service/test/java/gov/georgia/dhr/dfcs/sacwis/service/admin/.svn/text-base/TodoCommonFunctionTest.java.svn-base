package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TodoCommonFunctionTest extends BaseServiceTest {
  protected TodoCommonFunction todoCommonFunction = null;

  public TodoCommonFunctionTest(String testName) {
    super(testName);
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new TodoCommonFunctionTest("testCdTodoInfoPersAssigndLead"));
    suite.addTest(new TodoCommonFunctionTest("testCdTodoInfoPersAssigndMember"));
    suite.addTest(new TodoCommonFunctionTest("testIdTodoCfPersAssgnNotZero"));
    suite.addTest(new TodoCommonFunctionTest("testCdTodoInfoPersAssigndNone"));
    suite.addTest(new TodoCommonFunctionTest("testCdTodoInfoPersAssigndLeadAndSysCdTodoCfEqualsSUB015"));
    suite.addTest(new TodoCommonFunctionTest("testTodoInfoNull"));
    suite.addTest(new TodoCommonFunctionTest("testIndTodoInfoEnabledEqualsN"));
    return suite;
  }

  public void testIdTodoCfPersAssgnNotZero() {
    CSUB40UI csub40ui = new CSUB40UI();
    CSUB40UIG00 csub40UIG00 = new CSUB40UIG00();  
    csub40UIG00.setSzSysCdTodoCf("SUB046");
    csub40UIG00.setUlSysIdTodoCfPersAssgn(4466);
    csub40UIG00.setUlSysIdTodoCfPersCrea(5937);
    csub40UIG00.setUlSysIdTodoCfEvent(5603725);
    csub40UIG00.setUlSysIdTodoCfStage(5600566);
    csub40ui.setCSUB40UIG00(csub40UIG00);       
    
    jdbcTemplate.update("UPDATE TODO_INFO SET CD_TODO_INFO_TASK = '2030' WHERE CD_TODO_INFO = 'SUB046' ");                        
 
    todoCommonFunction.audTodo(csub40ui);
  }
  
  public void testCdTodoInfoPersAssigndLeadAndSysCdTodoCfEqualsSUB015() {
    CSUB40UI csub40ui = new CSUB40UI();
    CSUB40UIG00 csub40UIG00 = new CSUB40UIG00();  
    csub40UIG00.setSzSysCdTodoCf("SUB015");
    csub40UIG00.setUlSysIdTodoCfPersCrea(5937);
    csub40UIG00.setUlSysIdTodoCfEvent(5603725);
    csub40UIG00.setUlSysIdTodoCfStage(5600566);
    csub40ui.setCSUB40UIG00(csub40UIG00);       
    
    jdbcTemplate.update("UPDATE TODO_INFO SET CD_TODO_INFO = 'SUB015' WHERE ID_TODO_INFO = '3012931' ");                        
 
    todoCommonFunction.audTodo(csub40ui);
  }
  
  public void testCdTodoInfoPersAssigndLead() {
    CSUB40UI csub40ui = new CSUB40UI();
    CSUB40UIG00 csub40UIG00 = new CSUB40UIG00();  
    csub40UIG00.setSzSysCdTodoCf("SUB046");
    csub40UIG00.setUlSysIdTodoCfPersCrea(5937);
    csub40UIG00.setUlSysIdTodoCfEvent(5603725);
    csub40UIG00.setUlSysIdTodoCfStage(5600566);
    csub40ui.setCSUB40UIG00(csub40UIG00);       
    
    jdbcTemplate.update("UPDATE TODO_INFO SET CD_TODO_INFO_TASK = '2030' WHERE CD_TODO_INFO = 'SUB046' ");                        
 
    todoCommonFunction.audTodo(csub40ui);
  }
  
  public void testCdTodoInfoPersAssigndMember() {
    CSUB40UI csub40ui = new CSUB40UI();
    CSUB40UIG00 csub40UIG00 = new CSUB40UIG00();  
    csub40UIG00.setSzSysCdTodoCf("SUB046");
    csub40UIG00.setUlSysIdTodoCfPersCrea(5937);
    csub40UIG00.setUlSysIdTodoCfEvent(5603725);
    csub40UIG00.setUlSysIdTodoCfStage(5600566);
    csub40ui.setCSUB40UIG00(csub40UIG00);       
    
    jdbcTemplate.update("UPDATE TODO_INFO SET CD_TODO_INFO_PERS_ASSIGND = '60' WHERE CD_TODO_INFO = 'SUB046' ");                        
 
    todoCommonFunction.audTodo(csub40ui);
  }
  
  public void testIndTodoInfoEnabledEqualsN() {
    CSUB40UI csub40ui = new CSUB40UI();
    CSUB40UIG00 csub40UIG00 = new CSUB40UIG00();
    csub40UIG00.setSzSysCdTodoCf("SUB032");
    csub40ui.setCSUB40UIG00(csub40UIG00);
    
    todoCommonFunction.audTodo(csub40ui);
  }
  
  public void testCdTodoInfoPersAssigndNone() {
    CSUB40UI csub40ui = new CSUB40UI();
    CSUB40UIG00 csub40UIG00 = new CSUB40UIG00();
    csub40UIG00.setSzSysCdTodoCf("SUB049");
    csub40UIG00.setUlSysIdTodoCfPersCrea(5937);
    csub40UIG00.setUlSysIdTodoCfEvent(5603725);
    csub40UIG00.setUlSysIdTodoCfStage(5600566);
    csub40UIG00.setUlSysIdTodoCfPersWkr(2699);
    csub40UIG00.setUlSysIdTodoCfStage(5600566);
    csub40ui.setCSUB40UIG00(csub40UIG00);
    
    todoCommonFunction.audTodo(csub40ui);
  }
  
  public void testTodoInfoNull() {
    CSUB40UI csub40ui = new CSUB40UI();
    CSUB40UIG00 csub40UIG00 = new CSUB40UIG00();
    
    //This should throw an exception
    csub40UIG00.setSzSysCdTodoCf("");
    csub40ui.setCSUB40UIG00(csub40UIG00);    
    
    try {
      todoCommonFunction.audTodo(csub40ui);
    } catch (ServiceException e) {
      e.printStackTrace();
    }
  }


}
