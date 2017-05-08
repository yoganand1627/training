package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.List;

public class RecruitmentActivitiesSO implements Serializable {
  List<AdoInfoCbxStruct> recruitmentActivityDates;

  public List<AdoInfoCbxStruct> getRecruitmentActivityDates() {
    return recruitmentActivityDates;
  }

  public void setRecruitmentActivityDates(List<AdoInfoCbxStruct> recruitmentActivityDates) {
    this.recruitmentActivityDates = recruitmentActivityDates;
  }

}
