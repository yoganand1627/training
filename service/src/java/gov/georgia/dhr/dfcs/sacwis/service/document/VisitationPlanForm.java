package gov.georgia.dhr.dfcs.sacwis.service.document;


import gov.georgia.dhr.dfcs.sacwis.structs.input.VISITATIONPLANFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.VISITATIONPLANFORMSO;

public interface VisitationPlanForm extends DocumentService {

  public final String CHILD_NAME = "CHILD_NAME";
  public final String VIS_PARENT= "VIS_PARENT";
  public final String VIS_NONRELATIV = "VIS_NONRELATIV";
  public final String VIS_SIBLING = "VIS_SIBLING";
  public final String VIS_OTHERELATIV = "VIS_OTHERELATIV";
  public static final String CAPX = "(X)";
 
 

  public VISITATIONPLANFORMSO retrieveVisitationPlanForm(VISITATIONPLANFORMSI visitationPlanFormSI);
 
}
