/**
 * Created on Mar 1, 2006 at 8:45:43 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.ant;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateSimpleHQL {
  private static final int INPUT_BUFFER_LENGTH = 8192;

  private final JFrame converterFrame;
  private final JPanel converterPanel;
  private JTextField damPathTextField;
  private JTextArea sqlStatementTextArea;
  private JScrollPane sqlStatementScrollPane;

  /** Used to filter out comments from C code before further processing. */
  private static final Pattern COMMENTS_PATTERN = Pattern.compile("/[*].*?[*]/", Pattern.DOTALL);

  /** Used to extract SQL statements from C code. */
  private static final Pattern SQL_PATTERN = Pattern.compile(
          "EXEC SQL[\\s\\S&&[^;]]*?(\\bSELECT\\b|\\bINSERT\\b|\\bUPDATE\\b|\\bDELETE\\b)[\\s\\S&&[^;]]+?;",
          Pattern.DOTALL);

  /** Used to identify sql variables in the C-style SQL. */
  private static final Pattern VARIABLE_PATTERN =
          Pattern.compile("(:[^_&&[\\w]]*_([^_&&[\\w]]*)(\\w*))(\\W*\\1)?(?:_i)?", Pattern.DOTALL);

  /** Used to find cursors in the C code to pair with select statements. */
  private static final Pattern CURSOR_PATTERN = Pattern.compile("DECLARE\\s+(\\w+)\\s+CURSOR", Pattern.DOTALL);

  /** Used to find C-style selects so they can be replaced with SequenceHelper. */
  private static final Pattern SEQUENCE_PATTERN =
          Pattern.compile("SELECT\\s+(SEQ_\\w++)[.]NEXTVAL\\b.+?\\bFROM\\s+DUAL\\s*", Pattern.DOTALL);

  /** Used to find and remove INTO statements in C-style SQL, which are illegal in Java SQL. */
  private static final Pattern SELECT_INTO_PATTERN = Pattern.compile("INTO\\s++(.+?)\\s++(?=FROM)", Pattern.DOTALL);

  /** Used to find column names in select statements. */
  private static final Pattern COLUMNS_GROUP_PATTERN =
          Pattern.compile("(?<=SELECT).*?(?=\\s*FROM|\\s*INTO)", Pattern.DOTALL);

  private void doConvert() {
    /**
     *   Grab Inpubt struct and output struct info from Dam and use that in DAO.
     *   Determine data type depending on variable name and use appropriate setter method
     *   when capturing results from select statement.
     */
    //If file path and file name were submitted, then proceed
    String damPath = damPathTextField.getText();

    // Initialize variables
    String fileAsString = GenerateSimpleHQL.getFileAsString(damPath).replaceAll("\t", "  ");
    Matcher matcher = GenerateSimpleHQL.COMMENTS_PATTERN.matcher(fileAsString);
    String damInputString = matcher.replaceAll("");
    //Check if the DAM has reference to a row array
    List<String> sqlConstants = new LinkedList<String>();
    Matcher sqlMatcher = GenerateSimpleHQL.SQL_PATTERN.matcher(damInputString);
    Map<String, String> sqlMap = new LinkedHashMap<String, String>();
//    Map<String, String> sqlResultsMap = new LinkedHashMap<String, String>();
    List<String> sequenceList = new LinkedList<String>();
    List<String> unBoundSqlList = new LinkedList<String>();
    boolean isSelect;
    while (sqlMatcher.find()) {
      String rawDamSql = sqlMatcher.group();
      // Trim off everything outside the select and the last character before the semi-colon
      String sqlType = sqlMatcher.group(1);
      isSelect = "SELECT".equals(sqlType);
      String damSql = rawDamSql.substring(rawDamSql.indexOf(sqlType), rawDamSql.length() - 1);
      if (isSelect) {
        Matcher cursorMatcher = GenerateSimpleHQL.CURSOR_PATTERN.matcher(rawDamSql);
        Matcher sequenceMatcher = GenerateSimpleHQL.SEQUENCE_PATTERN.matcher(damSql);
        Matcher selectIntoMatcher = GenerateSimpleHQL.SELECT_INTO_PATTERN.matcher(damSql);
        if (cursorMatcher.find()) {
          String cursorName = cursorMatcher.group(1);
          // Note: This cannot be pre-compiled because it depends on the cursor name.
          Pattern resultsPattern =
                  Pattern.compile("EXEC SQL[\\s\\S&&[^;]]*FETCH\\s+" + cursorName + "\\s+INTO([\\s\\S&&[^;]]+?);");
          Matcher resultsMatcher = resultsPattern.matcher(damInputString);
          // Search for the results AFTER the declaration of the cursor.
          resultsMatcher.find(sqlMatcher.end());
          // We found results; this is normal SQL.
          sqlMap.put(damSql, sqlType);
          // We want the runtime exception if the results are not found
//          sqlResultsMap.put(damSql, resultsMatcher.group(1));
        } else if (sequenceMatcher.find()) {
          // We have a sequence -- use the pattern to guess the sequence name.
          sequenceList.add("Sequence Name: " + sequenceMatcher.group(1));
        } else if (selectIntoMatcher.find()) {
          // We found results; this is normal SQL.
          sqlMap.put(damSql, sqlType);
          // We want the runtime exception if the results are not found
//          sqlResultsMap.put(damSql, selectIntoMatcher.group(1));
        } else {
          unBoundSqlList.add(damSql);
        }
      } else {
        sqlMap.put(damSql, sqlType);
      }
    }
    // Clear the text area first
    sqlStatementTextArea.setText("");
    // We print out all the sequence calls here; this is not perfect, but helps.
    if (sequenceList.size() > 0) {
      for (Iterator<String> it = sequenceList.iterator(); it.hasNext();) {
        sqlStatementTextArea.append(it.next());
        sqlStatementTextArea.append("\n");
      }
    }
    sqlStatementTextArea.append("\n\n");
    StringBuffer outputSB = new StringBuffer(" "); // Start with a space to prevent problems later
    // Print bound SQL
    for (Iterator<String> sqlIt = sqlMap.keySet().iterator(); sqlIt.hasNext();) {
      String damSql = sqlIt.next();
      String sqlType = sqlMap.get(damSql);
      List<String> bindList = new LinkedList<String>();
      StringBuffer javaSqlSB = cToJavaSql(damSql, bindList);
      outputSB.append(javaSqlSB.toString()).append("\n\n\n");
//      String constantName = generateSqlConstant(javaSqlSB.toString(), sqlType, multipleSql, sqlConstants);
    }
    // Print unbound SQL
    for (Iterator<String> it = unBoundSqlList.iterator(); it.hasNext();) {
      String damSql = it.next();
      List<String> noResultsBindings = new LinkedList<String>();
      StringBuffer javaSqlSB = cToJavaSql(damSql, noResultsBindings);
      outputSB.append(javaSqlSB.toString()).append("\n\n\n");
//      generateSqlConstant(javaSqlSB.toString(), "SELECT", true, sqlConstants);
      // Need to pre-pend information on how to bind the variables
      StringBuffer comment = new StringBuffer();
      int lastSqlConstantIndex = sqlConstants.size() - 1;
      String constantString = sqlConstants.get(lastSqlConstantIndex);
      sqlConstants.set(lastSqlConstantIndex, comment.append(constantString).toString());
    }
    Pattern nonVariablesPattern = Pattern.compile("(?<=[^:]?)(\\b\\w*\\b)");
    Matcher nonVariablesMatcher = nonVariablesPattern.matcher(outputSB.toString());
    StringBuffer filteredOutputSB = new StringBuffer();
    while (nonVariablesMatcher.find()) {
      String word = nonVariablesMatcher.group(1);
      String[] wordParts = word.toLowerCase().split("_");
      StringBuffer initCapsWordSB = new StringBuffer(word.length());
      for(String wp : wordParts) {
        if(wp.length() > 1) {
          initCapsWordSB.append(wp.substring(0,1).toUpperCase()).append(wp.substring(1));
        } else {
          initCapsWordSB.append(wp);
        }
      }
      String initCapsWord = initCapsWordSB.toString();
      String camelCaseWord = initCapsWord.length() > 1 ?
              initCapsWord.substring(0,1).toLowerCase() + initCapsWord.substring(1) :
              initCapsWord;
      nonVariablesMatcher.appendReplacement(filteredOutputSB, camelCaseWord);
    }
    nonVariablesMatcher.appendTail(filteredOutputSB);
    sqlStatementTextArea.append(filteredOutputSB.toString().trim().replaceAll("([^\\s\"]) +([^\\s\"])", "$1 $2"));
  }


  private void printSelectExecution(String indent, boolean rowExists, String rowStruct, String rowStructArray,
                                    String damOutputStructLower, boolean multipleSql, String damSql,
                                    Map<String, String> sqlResultsMap, PrintWriter pr) {
    pr.println(indent + "resultSet = preparedStatement.executeQuery();");
    pr.println(indent + "int rowCount = 0;");
    if (rowExists) {
      pr.println(indent + rowStructArray + " array = new " + rowStructArray + "();");
    }
    pr.println(indent + "while( resultSet.next() )");
    pr.println(indent + "{");
    if (rowExists) {
      pr.println(indent + "  " + rowStruct + " row = new " + rowStruct + "();");
    }
    Matcher columnsGroupMatcher = GenerateSimpleHQL.COLUMNS_GROUP_PATTERN.matcher(damSql);
    columnsGroupMatcher.find();
    String columnsGroup = columnsGroupMatcher.group();
    String[] columns = columnsGroup.split(",");
    String resultSql = sqlResultsMap.get(damSql);
    Matcher resultVariableMatcher = GenerateSimpleHQL.VARIABLE_PATTERN.matcher(resultSql);
    for (int j = 0; j < columns.length && resultVariableMatcher.find(); j++) {
      // Remove all whitespace from the column name.
      String columnName = columns[j].replaceAll("\\s", "");
      String bindVariableName = resultVariableMatcher.group(2);
      // Make the first character upper-case.
      bindVariableName = bindVariableName.substring(0, 1).toUpperCase() + bindVariableName.substring(1);
      //Get Column Name
      String type = "DDDD";
      boolean castorDate = false;
      //Check if temp variable is Int
      if (bindVariableName.startsWith("UlId") || bindVariableName.startsWith("L") ||
          bindVariableName.startsWith("SzNbr") ||
          bindVariableName.startsWith("SNbr") || bindVariableName.startsWith("UId")) {
        type = "Int";
      }//Check if temp variable is String
      else if (bindVariableName.startsWith("SzCd") || bindVariableName.startsWith("CCd") ||
               bindVariableName.startsWith("Cd")
               || bindVariableName.startsWith("BCd") || bindVariableName.startsWith("BInd") ||
               bindVariableName.startsWith("SzTxt")
               || bindVariableName.startsWith("SzNm") || bindVariableName.startsWith("SzAddr") ||
               bindVariableName.startsWith("Ind")
               || bindVariableName.startsWith("SzDesc")) {
        type = "String";
      }//Check if temp variable is Date
      else if (bindVariableName.startsWith("DtDt") || bindVariableName.startsWith("Dt")) {
        type = "Date";
        castorDate = true;
      }//Check if temp variable is Castor Date
      else if (bindVariableName.startsWith("SzDt") || bindVariableName.startsWith("Ts")) {
        type = "Timestamp";
        castorDate = false;
      }

      if (rowExists) {
        pr.print(indent + "  row.set" + bindVariableName);
      } else {
        pr.print(indent + "  " + damOutputStructLower + ".set" + bindVariableName);
      }
      if (castorDate) {
        pr.print("( DateHelper.toCastorDate");
      }
      pr.print("( resultSet.get" + type + "( \"" + columnName + "\" ) )");
      if (castorDate) {
        pr.print(")");
      }
      pr.println(";");
    }
    if (rowExists) {
      pr.println(indent + "  array.add" + rowStruct + "( row );");
    }
    pr.println(indent + "  rowCount++;");
    pr.println(indent + "}");
    pr.println(indent + "if( 0 == rowCount )");
    pr.println(indent + "{");
    pr.println(indent + "  throw new ServiceException( Messages.SQL_NOT_FOUND );");
    pr.println(indent + "}");
    if (multipleSql) {
      pr.println("    }");
    }
    if (rowExists) {
      pr.println(indent + damOutputStructLower + ".set" + rowStructArray + "( array );");
    }
  }


  private StringBuffer cToJavaSql(String sqlFromDam, List<String> bindList) {
    // This pattern will work provided that the base of the variable being replaced does not have underscores;
    //   only caud11d, caud18d, caud45d, caud49d, caude9d, ccmn17, and cres58d have such variables.
    Matcher variableMatcher = GenerateSimpleHQL.VARIABLE_PATTERN.matcher(sqlFromDam);
    // The length of the StringBuffer will always be less because variable names are replaced with question marks.
    StringBuffer sqlFromDamSB = new StringBuffer(sqlFromDam.length());
    while (variableMatcher.find()) {
      String bindVariableName = variableMatcher.group(2);
      variableMatcher.appendReplacement(sqlFromDamSB, ":" + bindVariableName);
    }
    variableMatcher.appendTail(sqlFromDamSB);
    return sqlFromDamSB;
  }


  private static String getFileAsString(String filePath) {
    InputStream is = null;
    try {
      is = new FileInputStream(filePath);
      byte[] buf = new byte[GenerateSimpleHQL.INPUT_BUFFER_LENGTH];
      StringBuffer sb = new StringBuffer(GenerateSimpleHQL.INPUT_BUFFER_LENGTH);
      int bytesRead;
      //noinspection NestedAssignment
      while ((bytesRead = is.read(buf, 0, GenerateSimpleHQL.INPUT_BUFFER_LENGTH)) >= 0) {
        sb.append(new String(buf, 0, bytesRead, ArchitectureConstants.CHARACTER_ENCODING));
      }
      return sb.toString();
    }
    catch (IOException e) {
      throw new RuntimeException("Exception while attempting to buffer file: " + filePath, e);
    }
    finally {
      try {
        if (is != null) {
          is.close();
        }
      }
      catch (IOException ioe) {
        // Do nothing.
      }
    }
  }


  /**
   * This function is used to print out calls to select queries, and the subsequent logic to capture results from the
   * querry
   */
/*
  private String generateSqlConstant(String javaSql, String sqlType, boolean multipleSql, List<String> sqlConstants) {
    // Before generating the constant, remove new line characters in constructs line "(?, ?, ?)"
    Matcher groupedValuesMatcher = GenerateSimpleHQL.GROUPED_VALUES_PATTERN.matcher(javaSql);
    StringBuffer javaSqlSB = new StringBuffer(javaSql.length());
    while (groupedValuesMatcher.find()) {
      String[] groupedValuesArray = groupedValuesMatcher.group().split(",");
      StringBuffer replacement = new StringBuffer(groupedValuesArray.length * 3 + 4);
      for (int i = 0; i < groupedValuesArray.length - 1; i++) {
        replacement.append(groupedValuesArray[i].trim()).append(", ");
      }
      // Append the last one w/o a comma
      replacement.append(groupedValuesArray[groupedValuesArray.length - 1].trim());
      groupedValuesMatcher.appendReplacement(javaSqlSB, replacement.toString());
    }
    groupedValuesMatcher.appendTail(javaSqlSB);
    StringWriter sw = new StringWriter();
    PrintWriter pr = null;
    try {
      pr = new PrintWriter(sw);
      String constantName = sqlType.toUpperCase() + "_SQL" + (multipleSql ? "_" + (sqlConstants.size() + 1) : "");
      pr.println("  private static final String " + constantName + " = ");
      BufferedReader br = null;
      try {
        br = new BufferedReader(new StringReader(javaSqlSB.toString()));
        String line;
        //noinspection NestedAssignment
        while ((line = br.readLine()) != null) {
          line = line.trim();
          if (line.length() > 0) {
            pr.print("          \"");
            pr.print(line.trim());
            pr.println(" \\n\" +");
          }
        }
      }
      catch (IOException ioe) {
        throw new RuntimeException(ioe);
      }
      finally {
        if (br != null) {
          try {
            br.close();
          }
          catch (IOException e) {
            // Ignore
          }
        }
      }
      pr.flush();
      String sqlConstant = sw.getBuffer().toString();
      // Replace the last " +" with a semicolon when we add it to the list
      sqlConstants.add(sqlConstant.substring(0, sqlConstant.lastIndexOf("+") - 1) + ";");
      return constantName;
    }
    finally {
      if (pr != null) {
        pr.close();
      }
    }
  }
*/
  private static void printBindVariableBindings(String damInputStructLower, String indent, List<String> bindList,
                                                PrintWriter pr) {
    pr.println(indent + "List bindVariablesList = new ArrayList( " + bindList.size() + " );");
    for (Iterator<String> it = bindList.iterator(); it.hasNext();) {
      String bindVar = it.next();
      String getStatement = damInputStructLower + ".get" + bindVar + "()";
      if (bindVar.indexOf("UlId") >= 0) {
        pr.println(indent + "bindVariablesList.add( new Integer( " + getStatement + " ) );");
      } else {
        pr.println(indent + "bindVariablesList.add( " + getStatement + " );");
      }
    }
  }


  private GenerateSimpleHQL() {
    // Create and set up the window.
    converterFrame = new JFrame("Convert DAM to Dao");
    converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SpringLayout layout = new SpringLayout();
    converterPanel = new JPanel(layout);
    // Lots of widgets; separate method.
    addWidgets();
    GenerateSimpleHQL.makeCompactGrid(converterPanel, 1, 4, 5, 5, 5, 5);
    converterFrame.getContentPane().add(converterPanel, BorderLayout.CENTER);
    sqlStatementTextArea = new JTextArea(30, 100);
    sqlStatementScrollPane = new JScrollPane(sqlStatementTextArea);
    converterFrame.add(sqlStatementScrollPane, BorderLayout.SOUTH);
    converterFrame.pack();
    converterFrame.setLocationRelativeTo(null);
    converterFrame.setVisible(true);
  }


  /** Create and add the widgets. */
  private void addWidgets() {
    // Create DAM chooser row
    JLabel damPathLabel = new JLabel("Dam Input File:", SwingConstants.RIGHT);
    converterPanel.add(damPathLabel);
    damPathTextField = new JTextField(50);
    converterPanel.add(damPathTextField);
    JButton damChooserButton = new JButton("Choose Dam...");
    damChooserButton.setMnemonic(KeyEvent.VK_D);
    damChooserButton.setDisplayedMnemonicIndex(7);
    damChooserButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        JFileChooser jFileChooser = new JFileChooser();
        String damPathText = damPathTextField.getText();
        if(damPathText.length() > 0) {
          File damFile = new File(damPathText);
          if(damFile.isDirectory()) {
            jFileChooser.setCurrentDirectory(damFile);
          } else if (damFile.isFile()) {
            jFileChooser.setCurrentDirectory(damFile.getParentFile());
          }
        }
        jFileChooser.setDialogTitle("DAM to convert");
        jFileChooser.setMultiSelectionEnabled(false);
        jFileChooser.setFileFilter(new FileFilter() {
          public boolean accept(File f) {
            return f != null && (f.isDirectory() || f.getName().endsWith(".pc"));
          }


          public String getDescription() {
            return "DAM source files (*.pc)";
          }
        });
        jFileChooser.showDialog(converterFrame, null);
        File result = jFileChooser.getSelectedFile();
        if (result != null) {
          damPathTextField.setText(result.getAbsolutePath());
        }
      }
    });
    converterPanel.add(damChooserButton);
    JButton convertButton = new JButton("Convert");
    convertButton.setMnemonic(KeyEvent.VK_C);
    convertButton.setDisplayedMnemonicIndex(0);
    convertButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        String damPathText = damPathTextField.getText();
        if (damPathText != null && new File(damPathText).isFile()) {
          try {
            doConvert();
          }
          catch (Exception e) {
            StringBuffer message = new StringBuffer("Failed to convert DAM with exception:\n");
            message.append(e.toString()).append("\n");
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
              StackTraceElement ste = stackTrace[i];
              message.append(ste.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(converterFrame, message, "Exception converting DAM.",
                                          JOptionPane.ERROR_MESSAGE);
          }
        } else {
          JOptionPane.showMessageDialog(converterFrame, "Both the DAM file and output path must be specified.",
                                        "DAM and Dao must be specified.", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    converterPanel.add(convertButton);
  }


  /** Create the GUI and show it.  For thread safety, this method should be invoked from the event-dispatching thread. */
  private static void createAndShowGUI() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e) {
      //  Ignore exceptions from attempting this.
    }
    // Make sure we have nice window decorations.
    JFrame.setDefaultLookAndFeelDecorated(true);
    // noinspection ResultOfObjectAllocationIgnored
    new GenerateSimpleHQL();
  }


  /**
   * Used by makeCompactGrid.
   *
   * @param row
   * @param col
   * @param parent
   * @param cols
   * @return Constrains for a specific cell in a compact Spring Grid
   */
  private static SpringLayout.Constraints getConstraintsForCell(int row, int col, Container parent, int cols) {
    SpringLayout layout = (SpringLayout) parent.getLayout();
    return layout.getConstraints(parent.getComponent(row * cols + col));
  }


  /**
   * Aligns the first <code>rows</code> * <code>cols</code> components of <code>parent</code> in a grid. Each component
   * in a column is as wide as the maximum preferred width of the components in that column; height is similarly
   * determined for each row. The parent is made just big enough to fit them all.
   *
   * @param rows     number of rows
   * @param cols     number of columns
   * @param initialX x location to start the grid at
   * @param initialY y location to start the grid at
   * @param xPad     x padding between cells
   * @param yPad     y padding between cells
   */
  private static void makeCompactGrid(Container parent,
                                      int rows, int cols,
                                      int initialX, int initialY,
                                      int xPad, int yPad) {
    SpringLayout layout = (SpringLayout) parent.getLayout();

    //Align all cells in each column and make them the same width.
    Spring x = Spring.constant(initialX);
    for (int c = 0; c < cols; c++) {
      Spring width = Spring.constant(0);
      for (int r = 0; r < rows; r++) {
        width = Spring.max(width, GenerateSimpleHQL.getConstraintsForCell(r, c, parent, cols). getWidth());
      }
      for (int r = 0; r < rows; r++) {
        SpringLayout.Constraints constraints = GenerateSimpleHQL.getConstraintsForCell(r, c, parent, cols);
        constraints.setX(x);
        constraints.setWidth(width);
      }
      x = Spring.sum(x, Spring.sum(width, Spring.constant(xPad)));
    }

    //Align all cells in each row and make them the same height.
    Spring y = Spring.constant(initialY);
    for (int r = 0; r < rows; r++) {
      Spring height = Spring.constant(0);
      for (int c = 0; c < cols; c++) {
        height = Spring.max(height, GenerateSimpleHQL.getConstraintsForCell(r, c, parent, cols). getHeight());
      }
      for (int c = 0; c < cols; c++) {
        SpringLayout.Constraints constraints = GenerateSimpleHQL.getConstraintsForCell(r, c, parent, cols);
        constraints.setY(y);
        constraints.setHeight(height);
      }
      y = Spring.sum(y, Spring.sum(height, Spring.constant(yPad)));
    }

    //Set the parent's size.
    SpringLayout.Constraints pCons = layout.getConstraints(parent);
    pCons.setConstraint(SpringLayout.SOUTH, y);
    pCons.setConstraint(SpringLayout.EAST, x);
  }


  public static void main(String[] args) {
    // Schedule a job for the event-dispatching thread; creating and showing this application's GUI.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        GenerateSimpleHQL.createAndShowGUI();
      }
    });
  }
}
