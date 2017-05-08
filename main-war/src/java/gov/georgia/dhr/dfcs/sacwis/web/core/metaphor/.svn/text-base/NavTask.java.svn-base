package gov.georgia.dhr.dfcs.sacwis.web.core.metaphor;

import java.io.Serializable;

/**
 * <p>Title: </p> <p>Description: NavTask objects contain the information needed to determine what 2nd and 3rd level
 * tabs to show.
 * <p/>
 * </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class NavTask implements Serializable {

  public NavTask() {
  }

  public void setTaskCode(String taskCD) {
    this.taskCD = taskCD;
  }

  public String getTaskCode() {
    return this.taskCD;
  }

  public void setLevel1Id(int level1Id) {
    this.level1Id = level1Id;
  }

  public int getLevel1Id() {
    return this.level1Id;
  }

  public void setLevel2Id(int level2Id) {
    this.level2Id = level2Id;
  }

  public int getLevel2Id() {
    return this.level2Id;
  }

  public void setLevel3Id(int level3Id) {
    this.level3Id = level3Id;
  }

  public int getLevel3Id() {
    return this.level3Id;
  }

  public void setStageType(String stageType) {
    this.stageType = stageType;
  }

  public String getStageType() {
    return this.stageType;
  }

  public void setProgramCd(String programCd) {
    this.programCd = programCd;
  }

  public String getProgramCd() {
    return this.programCd;
  }

  public String printContents() {
    StringBuffer contents = new StringBuffer();
    contents.append("Level_1_Id == ").append(this.getLevel1Id()).append(", \n");
    contents.append("Level_2_Id == ").append(this.getLevel2Id()).append(", \n");
    contents.append("Level_3_Id == ").append(this.getLevel3Id()).append(", \n");
    contents.append("TaskCode == ").append(this.getTaskCode()).append(", \n");
    contents.append(" \n");
    return contents.toString();
  }

  private String taskCD = "";
  private int level1Id = 0;
  private int level2Id = 0;
  private int level3Id = 0;
  private String stageType = "";
  private String programCd = "";

}