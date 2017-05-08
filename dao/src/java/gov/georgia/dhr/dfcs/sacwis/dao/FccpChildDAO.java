package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.FccpChild;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChildCbx;

import java.util.List;

 public interface FccpChildDAO {
    
   List<FccpChild> findChildByIdEvent(int idChildPlanEvent);

   /**
    * This selects the checkboxes for ChildPlan given idEvent
    *
    * @param idEvent
    * @return List
    */
   List<FccpChildCbx> findChildCheckBoxByIdEvent(int idEvent);

   /**
    * This selects the checkboxes for ChildPlan given idEvent and the checkbox type. <p/> From: Cses19d.pc
    *
    * @param idEvent
    * @param cdCbxType
    * @return List
    */
   List<FccpChildCbx> findchildcheckboxbyIdEventandCbxCodeType(int idEvent, String cdCbxType);

   /**
    * This Saves or Updates the Child Plan to Fccp_Child
    *
    * @param fccpChild Object.
    */
   void InsertChildPlanDetail(FccpChild fccpChild);

   /**
    * This Saves or Updates the Child Plan Checkboxes to Fccp_Child_Cbx
    *
    * @param fccpchildcbx Object.
    */
   void InsertChildPlanCheckBox(FccpChildCbx fccpchildcbx);

   /**
    * This Deletes the child Plan Check Boxes
    *
    * @param idEvent Object.
    * @param cbxtype type.
    */
   void deleteChildPlanChkBxByIdEvent(int idEvent, String cbxtype);

   /**
    * This queries for Status for the event.
    *
    * @param idEvent
    */
   public String findEventCdEventStatus(int idEvent);

   /**
    * This queries for PersonId for the stage.
    *
    * @param idStage
    */

   public Integer findPrimaryChildForStage(int idStage);

   /**
    * Given a stage id this result returns the latest FCCP child plan detail
    *
    * @param idStage return FccpChildCbx
    */
   public FccpChild findLatestChildPlanByIdStageByCdEventType(int idStage);
   
   /**
    * Given a case and person id this result returns the latest FCCP child plan detail
    * for the child in the case
    * 
    * @param idStage 
    * @param idPerson 
    * return FccpChildCbx
    */
   public FccpChild findLatestChildPlanByIdCaseByIdPersonByCdEventType(int idCase, int idPerson);
}
