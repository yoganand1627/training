-- Standard Alter Table SQL

ALTER TABLE CAPS.DELVRD_SVC_DTL MODIFY(NBR_SVC_DTL_CSLI  NUMBER(4))
;
ALTER TABLE CAPS.ADMIN_DTL MODIFY(NBR_ADMIN_DTL_CSLI  NUMBER(4))
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };


-- change STGAP00003913
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60355, 'MSG_FCE_DT_LEGAL_DOC_SENT' 
,'You have indicated legal documents have been provided to the Eligibility Specialist.  Please enter a date.',500,700,'N');

-- change STGAP00003921
UPDATE CAPS.ERROR_LIST SET ID_TAB  = 1570 WHERE NBR_MESSAGE = 25395;
UPDATE CAPS.ERROR_LIST SET ID_TAB  = 1570 WHERE NBR_MESSAGE = 25397;

-- change STGAP00003938
DELETE FROM CAPS.STAGE_PROG WHERE cd_stage_prog_todo_info = 'SUB003';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (207, 'SacwisRev2', 'static updates, field length adjustments');                        
commit;
