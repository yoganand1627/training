package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.util.Date;
import java.util.List;

public class TodoAlertSaveSI {
  /**
   * The input object used for saving alert associated to a todo Detail page, including .
   *
   * @author Joshua Dorsey, 11/16/06
   * <pre>
   * Change History:
   * Date        User         Description
   * ----------  --------     ----------------------------------------------------------------------
   * 03/21/2011  htvo         SMS#97845 MR-074-2 AFCARS: replace idTodoPersAssigned with idTodoPersAssignedList
   *                          to enabled saving alerts as list of todos instead one at a time for reuse purposes.
   * 
   */

  private String txtTodoLongDesc;
  private int idStage;
  private int idPersonCreator;
  private Date dueDate = null;
  private String txtTodoShortDesc;
  private List<Integer> idTodoPersAssignedList = null; // SMS#87845 MR-074-2 AFCARS
  

  public int getIdStage() {
    return idStage;
  }

  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }

  public String getTxtTodoLongDesc() {
    return txtTodoLongDesc;
  }

  public void setTxtTodoLongDesc(String txtTodoLongDesc) {
    this.txtTodoLongDesc = txtTodoLongDesc;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public String getTxtTodoShortDesc() {
    return txtTodoShortDesc;
  }

  public void setTxtTodoShortDesc(String txtTodoShortDesc) {
    this.txtTodoShortDesc = txtTodoShortDesc;
  }

  public int getIdPersonCreator() {
    return idPersonCreator;
  }

  public void setIdPersonCreator(int idPersonCreator) {
    this.idPersonCreator = idPersonCreator;
  }

  public List<Integer> getIdTodoPersAssignedList() {
    return idTodoPersAssignedList;
  }

  public void setIdTodoPersAssignedList(List<Integer> idTodoPersAssignedList) {
    this.idTodoPersAssignedList = idTodoPersAssignedList;
  }

}
