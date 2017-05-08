-- STGAP00009349 - Update Report Tables For Eligibility Monthly Rpt

insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='EligibilityMonthly' and nm_rpt_sqr_ver='00') then
   into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) 
     select 'EligibilityMonthly', '00', 31, 'A', 'Eligibility Monthly Report', 'ondport', 'L', 'W', 'List of approved, active eligibility records for the reporting month. Generated for specific Month and County parameters.', 'Eligibility', 'Y' from dual;
     
insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='EligibilityMonthly' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq=1) then
   into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
     select 'EligibilityMonthly', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year' from dual;
     
insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='EligibilityMonthly' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq=1) then
   into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
     select 'EligibilityMonthly', '00', 2, 3, 'CD_COUNTY', 'CHAR', 'Y', 'County' from dual;     


-- STGAP00009355 - Update Report Tables For Eligibility Monthly Rpt

/
DECLARE 
   var_dtStageClose caps.stage.dt_stage_close%TYPE;
   stageid caps.incoming_detail.ID_STAGE%TYPE;
   
   var_dtLastUpdate caps.stage.dt_last_update%TYPE;
   stageid2 caps.incoming_detail.ID_STAGE%TYPE;
   
   after_change NUMBER(5);
   after_change2 NUMBER(5);
   
   CURSOR cur_idStage IS
   SELECT id.id_stage 
   FROM caps.INCOMING_DETAIL id , caps.STAGE s  WHERE id.id_stage = s.id_stage AND 
   s.cd_stage = 'INT' AND cd_incmg_status = 'CLD' AND dt_stage_close IS NOT NULL 
   AND dt_incoming_call_disposed is NULL;
  
   var_idStage caps.incoming_detail.ID_STAGE%TYPE;
   
      CURSOR cur_idStage2 IS
      SELECT id.id_stage 
      FROM caps.INCOMING_DETAIL id , caps.STAGE s  WHERE  id.id_stage = s.id_stage AND 
      s.cd_stage = 'INT' AND cd_incmg_status = 'CLD' AND dt_stage_close IS  NULL
      AND dt_incoming_call_disposed is NULL;
     
   var_idStage2 caps.incoming_detail.ID_STAGE%TYPE;
   
  
 BEGIN
   
   OPEN cur_idStage;
   LOOP
   FETCH cur_idStage INTO var_idStage;
   EXIT WHEN cur_idStage%NOTFOUND;
   
   stageid := var_idStage;
   
   SELECT dt_stage_close INTO var_dtStageClose 
   FROM caps.stage
   WHERE id_Stage = stageid;
   
   UPDATE caps.incoming_detail
   SET dt_incoming_call_disposed = var_dtStageClose
   WHERE id_Stage = stageid;
   
   END LOOP;
   CLOSE cur_idStage;
   
   
      OPEN cur_idStage2;
      LOOP
      FETCH cur_idStage2 INTO var_idStage2;
      EXIT WHEN cur_idStage2%NOTFOUND;
      
      stageid2 := var_idStage2;
      
      SELECT dt_last_update INTO var_dtLastUpdate
      FROM caps.stage
      WHERE id_Stage = stageid2;
      
      UPDATE caps.incoming_detail
      SET dt_incoming_call_disposed = var_dtLastUpdate
      WHERE id_Stage = stageid2;
      
      END LOOP;
      CLOSE cur_idStage2;
    
 END;   
 /
   
insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (348, 'SacwisRev2', 'DBCRs 9349,9355');
commit;

  



