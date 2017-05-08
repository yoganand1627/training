-- Standard Alter Table SQL

ALTER TABLE SACWISIFC.CHILDSUP_REF_OUTBOUND MODIFY(CD_MED_COA  VARCHAR2(3))
;

{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00002714
UPDATE caps.message SET txt_message='Person Characteristics must first be entered'
WHERE txt_message_name='MSG_SUB_PLCMT_CHAR_NEEDED';

-- change STGAP00002715
UPDATE CAPS.METAPHOR SET TXT_TAB = 'Close Foster Care Family Stage'
WHERE ID_TAB = '300';

-- change STGAP00002731
UPDATE CAPS.STAGE_PROG SET cd_stage_prog_Event_type = '' WHERE  cd_stage_prog_Event_type = 'PPT';

-- change STGAP00002738
INSERT INTO CAPS.TASK
   (CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 VALUES
   ('9996',SYSDATE, 'RCA', 'PFC', 'CPS', '1', '1', '1', '0', '0', '0', '1', 'Relative Care Assessment', 'CASE_CASESEARCH', 'PLACEMENT_EVENTLIST', 'RELATIVE_CARE_ASSESSMENT', '/subcare/RelativeCareAssessment/displayRelativeCareAssessment', 3, '1', '0', '0');


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (176, 'SacwisRev2', 'static updates, field expanded in sacwisifc childsup_ref_outbound'); 
commit;
