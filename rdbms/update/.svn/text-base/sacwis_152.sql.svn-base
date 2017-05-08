-- change STGAP00001923
INSERT INTO CAPS.TASK(cd_task,cd_task_event_type,cd_task_stage,cd_task_stage_program,txt_task_decode,TXT_1ST_TAB,TXT_2ND_TAB,TXT_3RD_TAB,TXT_EVENT_DETAIL_URL) VALUES('9466','APP','SUB','CPS','Approve Relative Care Assessment','CASE_CASESEARCH','PLACEMENT_EVENTLIST','RELATIVE_CARE_ASSESSMENT','/casemgmt/RelativeCareAssessment/displayRelativeCareAssessment');

-- change STGAP00001925
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60266, 'MSG_FCE_NO_MEDICNUM_INIT_MA', 'Please assign a CRS ID to the child via the Person Detail page.',760,500,'N');

-- change STGAP00001926
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) 
VALUES('CEVNTTYP','IMA','Initial Medicaid Application');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (153, 'SacwisRev2', 'static updates');
commit;
