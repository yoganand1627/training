-- Release 2.5 
-- Standard Alter Table SQL

ALTER TABLE CAPS.ADDRESS_PERSON_LINK ADD IND_REMOVAL_HOME VARCHAR2(1)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00008764
update caps.codes_tables
set dt_end = sysdate
where code_type = 'CEVNTTYP'
and code in ('FSR','VRN','FFP','FPL');

-- change STGAP00008779
Insert into caps.MESSAGE (ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) values (0,sysdate,60419,'MSG_SVC_FAMILY_PLAN_ADD_VALID','A Family Plan cannot be added when there is an unfinished existing plan.',760,500,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (326, 'SacwisRev2', 'static table updates');                        
commit;
