-- Standard Alter Table SQL

ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CHILD_EQUITY VARCHAR2(1)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- All changes for version 2.21 of SHINES
-- change STGAP00007267
insert all
   when not exists(select 'x' from caps.security_class where cd_security_class_name='OFI SCREENER') then
 into caps.security_class
   select 'OFI SCREENER',sysdate,'0000000000000000000100000000000000000000000000000000000100000000000000000000000000000','N',(select nvl((select id_person from caps.employee where id_person=102960),(select id_person from caps.employee where id_person=2071)) from dual) from dual;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'OFI SCREENER'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

-- change STGAP00007269
UPDATE CAPS.MESSAGE
SET txt_message = 'This Invoice is not in your region.Please verify and re-enter.'
WHERE txt_message_name = 'SSM_FIN_INVLD_REGION';

-- change STGAP00007281
-- Stage Progress DIV to INV

UPDATE CAPS.STAGE_PROG SET IND_STAGE_PROG_CLOSE = '1', CD_STAGE_PROG_OPEN = 'INV'
WHERE CD_STAGE_PROG_STAGE = 'DIV' 
AND CD_STAGE_PROG_PROGRAM = 'CPS' 
AND CD_STAGE_PROG_RSN_CLOSE = 'RFI'
AND CD_STAGE_PROG_OPEN IS NULL;

-- Stage Prog Table Change
-- Stage Progress DIV to INV

UPDATE CAPS.STAGE_PROG SET IND_STAGE_PROG_CLOSE = '1', CD_STAGE_PROG_RSN_CLOSE = 'RFI', CD_STAGE_PROG_OPEN = 'INV'
WHERE CD_STAGE_PROG_STAGE = 'INV' 
AND CD_STAGE_PROG_PROGRAM = 'CPS' 
AND CD_STAGE_PROG_RSN_CLOSE = 'DIV'
AND CD_STAGE_PROG_OPEN IS NULL
AND CD_STAGE_PROG_EVENT_TYPE = 'STG';

-- Stage Prog Table Change
-- Stage Progress DIV to INV

UPDATE CAPS.STAGE_PROG SET IND_STAGE_PROG_CLOSE = '1', CD_STAGE_PROG_RSN_CLOSE = 'RFI'
WHERE CD_STAGE_PROG_STAGE = 'INV' 
AND CD_STAGE_PROG_PROGRAM = 'CPS' 
AND CD_STAGE_PROG_RSN_CLOSE = 'DIV'
AND CD_STAGE_PROG_OPEN IS NULL
AND CD_STAGE_PROG_EVENT_TYPE = 'CCL';

-- change STGAP00007282
INSERT INTO CAPS.METAPHOR (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB, TXT_FILTER_PATH) VALUES (1600, '/investigation/DiversionCnclsn/displayDiversionCnclsn', 'DIVERSION_CONCLUSION_INV_DIVERSIONCONCLUSION', 'Review<br>Diversion', 'gov.georgia.dhr.dfcs.sacwis.web.metaphor.DiversionCclShowTab');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (285, 'SacwisRev2', 'static table updates and new column for FCE_ELIGIBILITY');
commit;

