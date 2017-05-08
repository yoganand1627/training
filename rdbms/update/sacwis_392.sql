--STGAP00010456 - New column for ADOPTION_SUBSIDY

ALTER TABLE CAPS.ADOPTION_SUBSIDY ADD (ID_SPECIAL_NEEDS_DETER decimal(16));


--STGAP00010455 - Various changes to support Adptn Asst Application

ALTER TABLE caps.SPECIAL_NEEDS_DETERMINATION ADD ( IND_DOC_SSI varchar2(1));

update caps.metaphor set txt_tab_constant='ADOPTION_ASSISTANCE_APPLICATION_EVENTLIST'
, txt_tab='Adoption Assistance Application'
where txt_tab_constant='SPECIAL_NEEDS_DETERMINATION_EVENTLIST';

update caps.task set txt_task_decode='Adoption Assistance Application'
where cd_task in (8610, 9100, 8351, 8352);

update CAPS.CODES_TABLES  set decode='Adoption Assistance Application' where code='SND' and code_type='CEVNTTYP' ;

insert into caps.codes_tables  (CODE_TYPE, CODE, DECODE) values ('CSECATTR', 'PI', 'SAU Staff');

insert into caps.ADO_SUBSIDY_RATE (ID_ADO_SUBSIDY_RATE, CD_RATE_TYPE, NUM_MIN_AGE, NUM_MAX_AGE, AMT_ADPT_SUB) VALUES
(1, 'A1', 0, 5, 387.81);

insert into caps.ADO_SUBSIDY_RATE (ID_ADO_SUBSIDY_RATE, CD_RATE_TYPE, NUM_MIN_AGE, NUM_MAX_AGE, AMT_ADPT_SUB) VALUES
(2, 'A2', 6, 12, 410.63);

insert into caps.ADO_SUBSIDY_RATE (ID_ADO_SUBSIDY_RATE, CD_RATE_TYPE, NUM_MIN_AGE, NUM_MAX_AGE, AMT_ADPT_SUB) VALUES
(3, 'A3', 13, 18, 433.43);


--STGAP00010457 - Update for page name changed from Adoption Assista

update CAPS.METAPHOR set TXT_TAB_URL = 'Adoption Assistance Agreement' where ID_TAB = 26;
update CAPS.METAPHOR set TXT_TAB_URL = 'Adoption<br>Assistance Agreement' where ID_TAB = 20;
update CAPS.TASK set TXT_TASK_DECODE = 'Adoption Assistance Agreement' where CD_TASK in ('9105', '9115');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (393, 'SacwisRev3', 'Release 3.0 - DBCRs 10455,10456,10457');

commit;


